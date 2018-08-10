package com.jwebmp.core.base.page;

import com.jwebmp.core.FileTemplates;
import com.jwebmp.core.Page;
import com.jwebmp.core.SessionHelper;
import com.jwebmp.core.annotations.JWebMPSiteBinder;
import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.angular.AngularPageConfigurator;
import com.jwebmp.core.base.html.CSSLink;
import com.jwebmp.core.base.html.Script;
import com.jwebmp.core.base.html.Style;
import com.jwebmp.core.base.html.attributes.ScriptAttributes;
import com.jwebmp.core.base.servlets.JWScriptServlet;
import com.jwebmp.core.htmlbuilder.css.composer.CSSComposer;
import com.jwebmp.core.plugins.jquery.JQueryPageConfigurator;
import com.jwebmp.core.services.IPageConfigurator;
import com.jwebmp.core.utilities.StaticStrings;

import javax.validation.constraints.NotNull;

@SuppressWarnings("unused")
public
class ScriptsDynamicPageConfigurator
		implements IPageConfigurator
{
	public ScriptsDynamicPageConfigurator()
	{
		//No config required
	}

	@NotNull
	@Override
	@SuppressWarnings("unchecked")
	public Page<?> configure(Page<?> page)
	{
		if (!page.isConfigured())
		{
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
				if (JQueryPageConfigurator.isRequired())
				{
					page.getBody()
					    .add(getDynamicReference(JWebMPSiteBinder.getJWScriptLocation()
					                                             .replaceAll(StaticStrings.STRING_FORWARD_SLASH, StaticStrings.STRING_EMPTY)));
					page.getBody()
					    .add(getDynamicReference(JWebMPSiteBinder.getJavaScriptLocation()
					                                             .replaceAll(StaticStrings.STRING_FORWARD_SLASH, StaticStrings.STRING_EMPTY)));
				}
				if (AngularPageConfigurator.isRequired())
				{
					page.getBody()
					    .add(getDynamicReference(JWebMPSiteBinder.getAngularScriptLocation()
					                                             .replaceAll(StaticStrings.STRING_FORWARD_SLASH, StaticStrings.STRING_EMPTY)));
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

				if (JQueryPageConfigurator.isRequired())
				{
					addable.add(getSiteLoaderScript());
					addable.add(getJavascriptScript(page));
				}
				Script javaScript = getJavascriptScript(page);
				if (javaScript != null)
				{
					addable.add(javaScript);
				}
				if (AngularPageConfigurator.isRequired())
				{
					addable.add(getAngularScript(page));
				}
			}
		}
		return page;
	}

	@Override
	public Integer sortOrder()
	{
		return Integer.MAX_VALUE;
	}

	private Style<?> getCss(Page page)
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
		Style<?> style = new Style();
		style.setText(css);
		return style;
	}

	private Script<?> getDynamicReference(String urlLocation)
	{
		Script<?> jwScript = new Script();
		jwScript.addAttribute(ScriptAttributes.Type, StaticStrings.HTML_HEADER_JAVASCRIPT);
		jwScript.addAttribute(ScriptAttributes.Src, SessionHelper.getServerPath() + urlLocation);
		return jwScript;
	}

	private Script<?> getSiteLoaderScript()
	{
		FileTemplates.getFileTemplate(JWScriptServlet.class, JWScriptServlet.FILE_TEMPLATE_NAME, "siteloader");
		StringBuilder jsScript = FileTemplates.renderTemplateScripts(JWScriptServlet.FILE_TEMPLATE_NAME);
		if (!jsScript.toString()
		             .trim()
		             .isEmpty())
		{
			return newScript(jsScript.toString());
		}
		return new Script();
	}

	private Script getJavascriptScript(Page page)
	{
		StringBuilder js = page.renderJavascript();
		if (!js.toString()
		       .trim()
		       .isEmpty())
		{
			String[] lines = js.toString()
			                   .split(page.getNewLine());
			StringBuilder output = new StringBuilder();
			for (String line : lines)
			{
				if (line == null || line.isEmpty())
				{
					continue;
				}
				output.append("\t\t\t" + line)
				      .append(page.getNewLine());
			}

			return newScript(page.getNewLine() + output);
		}
		return null;
	}

	private Script getAngularScript(Page page)
	{
		StringBuilder jsAngular = page.getAngular()
		                              .renderAngularJavascript(page);
		if (!jsAngular.toString()
		              .trim()
		              .isEmpty())
		{
			return newScript(jsAngular.toString());
		}
		return new Script();
	}

	private Script newScript(String contents)
	{
		Script s = new Script();
		s.addAttribute(ScriptAttributes.Type, StaticStrings.HTML_HEADER_JAVASCRIPT);
		s.setText(contents);
		return s;
	}
}
