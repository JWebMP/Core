package com.jwebmp.base.page;

import com.jwebmp.FileTemplates;
import com.jwebmp.Page;
import com.jwebmp.PageConfigurator;
import com.jwebmp.SessionHelper;
import com.jwebmp.annotations.SiteBinder;
import com.jwebmp.base.ComponentHierarchyBase;
import com.jwebmp.base.angular.AngularPageConfigurator;
import com.jwebmp.base.html.CSSLink;
import com.jwebmp.base.html.Script;
import com.jwebmp.base.html.Style;
import com.jwebmp.base.html.attributes.ScriptAttributes;
import com.jwebmp.base.servlets.JWScriptServlet;
import com.jwebmp.htmlbuilder.css.composer.CSSComposer;
import com.jwebmp.plugins.jquery.JQueryPageConfigurator;

import static com.jwebmp.utilities.StaticStrings.*;

@SuppressWarnings("unused")
class ScriptsDynamicPageConfigurator
		extends PageConfigurator
{
	public ScriptsDynamicPageConfigurator()
	{
		setSortOrder(Integer.MAX_VALUE);
	}

	@Override
	public Page configure(Page<?> page)
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
					    .add(new CSSLink<>(SessionHelper.getServerPath() + SiteBinder.getCSSLocation()
					                                                                 .replaceAll(STRING_FORWARD_SLASH, STRING_EMPTY)));
				}
				if (JQueryPageConfigurator.isRequired())
				{
					page.getBody()
					    .add(getDynamicReference(SiteBinder.getJWScriptLocation()
					                                       .replaceAll(STRING_FORWARD_SLASH, STRING_EMPTY)));
					page.getBody()
					    .add(getDynamicReference(SiteBinder.getJavaScriptLocation()
					                                       .replaceAll(STRING_FORWARD_SLASH, STRING_EMPTY)));
				}
				if (AngularPageConfigurator.isRequired())
				{
					page.getBody()
					    .add(getDynamicReference(SiteBinder.getAngularScriptLocation()
					                                       .replaceAll(STRING_FORWARD_SLASH, STRING_EMPTY)));
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
		jwScript.addAttribute(ScriptAttributes.Type, HTML_HEADER_JAVASCRIPT);
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
		s.addAttribute(ScriptAttributes.Type, HTML_HEADER_JAVASCRIPT);
		s.setText(contents);
		return s;
	}
}
