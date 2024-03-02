package com.jwebmp.core.base.page;

import com.guicedee.client.*;
import com.jwebmp.core.Page;
import com.jwebmp.core.SessionHelper;
import com.jwebmp.core.base.interfaces.*;
import com.jwebmp.core.implementations.JWebMPSiteBinder;
import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.html.CSSLink;
import com.jwebmp.core.base.html.Paragraph;
import com.jwebmp.core.base.html.Script;
import com.jwebmp.core.base.html.Style;
import com.jwebmp.core.base.html.attributes.ScriptAttributes;
import com.jwebmp.core.htmlbuilder.css.composer.CSSComposer;
import com.jwebmp.core.services.*;
import com.guicedee.services.jsonrepresentation.json.StaticStrings;


import jakarta.validation.constraints.NotNull;
import java.util.ServiceLoader;
import java.util.Set;

import static com.jwebmp.core.implementations.JWebMPServicesBindings.*;

/**
 * Configures the dynamic script insertions that run last into the page
 *
 * @author GedMarc
 * @since 2018/08/10
 */
@SuppressWarnings("unused")
public class ScriptsDynamicPageConfigurator
		implements IPageConfigurator<ScriptsDynamicPageConfigurator>
{
	/**
	 * If this configurator is enabled
	 */
	private static boolean enabled = true;

	/**
	 * Constructor ScriptsDynamicPageConfigurator creates a new ScriptsDynamicPageConfigurator instance.
	 */
	public ScriptsDynamicPageConfigurator()
	{
		//No config required
	}

	/**
	 * Method isEnabled returns the enabled of this AngularAnimatedChangePageConfigurator object.
	 * <p>
	 * If this configurator is enabled
	 *
	 * @return the enabled (type boolean) of this AngularAnimatedChangePageConfigurator object.
	 */
	public static boolean isEnabled()
	{
		return ScriptsDynamicPageConfigurator.enabled;
	}

	/**
	 * Method setEnabled sets the enabled of this AngularAnimatedChangePageConfigurator object.
	 * <p>
	 * If this configurator is enabled
	 *
	 * @param mustEnable
	 * 		the enabled of this AngularAnimatedChangePageConfigurator object.
	 */
	public static void setEnabled(boolean mustEnable)
	{
		ScriptsDynamicPageConfigurator.enabled = mustEnable;
	}

	/**
	 * Configures the given page for the parameters
	 *
	 * @param pager
	 * 		The page incoming
	 *
	 * @return The original page incoming or a new page, never null
	 */
	@NotNull
	@Override
	@SuppressWarnings("unchecked")
	public Page<?> configure(IPage<?> pager)
	{
		Page page = (Page)pager;
		if (!page.isConfigured() && enabled())
		{
			//Render Before Dynamic Scripts
			Paragraph beforeText = new Paragraph().setTextOnly(true);
			StringBuilder sbBeforeText = new StringBuilder();
			Set<RenderBeforeDynamicScripts> beforeLoader = IGuiceContext.get(RenderBeforeDynamicScriptsKey);
			for (RenderBeforeDynamicScripts renderAfterDynamicScripts : beforeLoader)
			{
				sbBeforeText.append(IGuiceContext.get(renderAfterDynamicScripts.getClass())
				                                .render(page)
				                                .append(page.getNewLine()));
			}
			if (!sbBeforeText.toString()
			                 .isEmpty())
			{
				beforeText.setText(sbBeforeText.toString());
				page.getBody()
				    .add(beforeText);
			}

			Style s = getCss(page);
			if (page.getOptions()
			        .isDynamicRender())
			{
				if (s != null)
				{
					page.getHead()
					    .add(new CSSLink<>(SessionHelper.getServerPath() + JWebMPSiteBinder.getCSSLocation()
					                                                                       .replaceAll(StaticStrings.STRING_FORWARD_SLASH, StaticStrings.STRING_EMPTY)));
				}

				Set<IDynamicRenderingServlet> dynamicRenderingServlets = IGuiceContext.instance()
				                                                                     .getLoader(IDynamicRenderingServlet.class, ServiceLoader.load(IDynamicRenderingServlet.class));
				for (IDynamicRenderingServlet dynamicRenderingServlet : dynamicRenderingServlets)
				{
					if (dynamicRenderingServlet.enabled())
					{
						page.getBody()
						    .add(getDynamicReference(dynamicRenderingServlet.getScriptLocation(page)));
					}
				}
			}
			else
			{
				if (s != null)
				{
					page.getHead()
					    .add(s);
				}
				ComponentHierarchyBase addable;
				if (page.getOptions()
				        .isScriptsInHead())
				{
					addable = page.getHead();
				}
				else
				{
					addable = page.getBody();
				}

				Set<IDynamicRenderingServlet> dynamicRenderingServlets = IGuiceContext.instance()
				                                                                     .getLoader(IDynamicRenderingServlet.class, ServiceLoader.load(IDynamicRenderingServlet.class));
				for (IDynamicRenderingServlet dynamicRenderingServlet : dynamicRenderingServlets)
				{
					if (dynamicRenderingServlet.enabled())
					{
						IComponentHierarchyBase script = dynamicRenderingServlet.renderScript(page);
						if (script != null)
						{
							addable.add(script);
						}
					}
				}
			}
			//Render After Dynamic Scripts
			Paragraph afterText = new Paragraph().setTextOnly(true);
			StringBuilder sbAfterText = new StringBuilder();
			Set<RenderAfterDynamicScripts> afterLoader = IGuiceContext.get(RenderAfterDynamicScriptsKey);
			for (RenderAfterDynamicScripts renderAfterDynamicScripts : afterLoader)
			{
				sbAfterText.append(IGuiceContext
						                   .get(renderAfterDynamicScripts.getClass())
						                   .render(page)
						                   .append(page.getNewLine()));
			}
			if (!sbAfterText.toString()
			                .isEmpty())
			{
				afterText.setText(sbAfterText.toString());
				page.getBody()
				    .add(afterText);
			}
		}
		return page;
	}

	@Override
	public boolean enabled()
	{
		return ScriptsDynamicPageConfigurator.enabled;
	}

	/**
	 * Method getCss returns the CSS for the page
	 *
	 * @param page
	 * 		of type Page
	 *
	 * @return Style<?
                       *       	   	   ,
                       *       	   	   ?>
	 */
	private Style<?, ?> getCss(Page<?> page)
	{
		CSSComposer comp = new CSSComposer();
		comp.addComponent(page, true);
		String generated = comp.toString();

		StringBuilder css = page.getBody()
		                        .renderCss(0)
		                        .append(generated);
		if (css.toString()
		       .isEmpty())
		{
			return null;
		}
		Style<?, ?> style = new Style();
		style.setText(css);
		return style;
	}

	/**
	 * Method getDynamicReference ...
	 *
	 * @param urlLocation
	 * 		of type String
	 *
	 * @return Script<?
                       *       	   	   ,
                       *       	   	   ?>
	 */
	@NotNull
	private Script<?, ?> getDynamicReference(String urlLocation)
	{
		Script<?, ?> jwScript = new Script();
		jwScript.addAttribute(ScriptAttributes.Type, StaticStrings.HTML_HEADER_JAVASCRIPT);
		jwScript.addAttribute(ScriptAttributes.Src, SessionHelper.getServerPath() + urlLocation);
		return jwScript;
	}

	/**
	 * Method newScript ...
	 *
	 * @param contents
	 * 		of type String
	 *
	 * @return Script
	 */
	private Script<?, ?> newScript(String contents)
	{
		Script<?, ?> s = new Script();
		s.addAttribute(ScriptAttributes.Type, StaticStrings.HTML_HEADER_JAVASCRIPT);
		s.setText(contents);
		return s;
	}

	/**
	 * Sort order for startup, Default 100.
	 *
	 * @return the sort order never null. Integer. MAX
	 *
	 * @see com.jwebmp.core.services.IPageConfigurator#sortOrder()
	 */
	@Override
	public Integer sortOrder()
	{
		return Integer.MAX_VALUE;
	}
}
