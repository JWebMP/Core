package za.co.mmagon.jwebswing.base.page;

import za.co.mmagon.FileTemplates;
import za.co.mmagon.SessionHelper;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.PageConfigurator;
import za.co.mmagon.jwebswing.annotations.SiteBinder;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.angular.AngularPageConfigurator;
import za.co.mmagon.jwebswing.base.html.CSSLink;
import za.co.mmagon.jwebswing.base.html.Script;
import za.co.mmagon.jwebswing.base.html.Style;
import za.co.mmagon.jwebswing.base.html.attributes.ScriptAttributes;
import za.co.mmagon.jwebswing.base.servlets.JWScriptServlet;
import za.co.mmagon.jwebswing.plugins.jquery.JQueryPageConfigurator;

import static za.co.mmagon.jwebswing.utilities.StaticStrings.*;

class ScriptsDynamicPageConfigurator extends PageConfigurator
{
	public ScriptsDynamicPageConfigurator()
	{
		setSortOrder(Integer.MAX_VALUE);
	}

	@Override
	public Page configure(Page page)
	{
		if (!page.isConfigured())
		{
			Style s = getCss(page);
			if (page.getOptions().isDynamicRender())
			{
				if (s != null)
				{
					page.getHead().add(new CSSLink(SessionHelper.getServerPath() + SiteBinder.getCSSLocation().replaceAll(STRING_FORWARD_SLASH, STRING_EMPTY)));
				}
				if (JQueryPageConfigurator.isRequired())
				{
					page.getBody().add(getDynamicReference(SiteBinder.getJWScriptLocation().replaceAll(STRING_FORWARD_SLASH, STRING_EMPTY)));
					page.getBody().add(getDynamicReference(SiteBinder.getJavaScriptLocation().replaceAll(STRING_FORWARD_SLASH, STRING_EMPTY)));
				}
				if (AngularPageConfigurator.isRequired())
				{
					page.getBody().add(getDynamicReference(SiteBinder.getAngularScriptLocation().replaceAll(STRING_FORWARD_SLASH, STRING_EMPTY)));
				}

			}
			else
			{
				page.getHead().add(s);
				ComponentHierarchyBase addable;
				if (page.getOptions().isScriptsInHead())
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
				if (AngularPageConfigurator.isRequired())
				{
					addable.add(getAngularScript(page));
				}
			}
		}
		return page;
	}

	private Style getCss(Page page)
	{
		StringBuilder css = page.getBody().renderCss(0);
		if (css.toString().isEmpty())
		{
			return null;
		}
		Style style = new Style();
		style.setText(css);
		return style;
	}

	private Script getDynamicReference(String urlLocation)
	{
		Script jwScript = new Script();
		jwScript.addAttribute(ScriptAttributes.Type, HTML_HEADER_JAVASCRIPT);
		jwScript.addAttribute(ScriptAttributes.Src, SessionHelper.getServerPath() + urlLocation);
		return jwScript;
	}

	private Script getSiteLoaderScript()
	{
		FileTemplates.getFileTemplate(JWScriptServlet.class, JWScriptServlet.FILE_TEMPLATE_NAME, "siteloader");
		StringBuilder jsScript = FileTemplates.renderTemplateScripts(JWScriptServlet.FILE_TEMPLATE_NAME);
		if (!jsScript.toString().trim().isEmpty())
		{
			return newScript(jsScript.toString());
		}
		return new Script();
	}

	private Script getJavascriptScript(Page page)
	{
		StringBuilder js = page.renderJavascript();
		if (!js.toString().trim().isEmpty())
		{
			return newScript(page.getNewLine() + js);
		}
		return new Script();
	}

	private Script getAngularScript(Page page)
	{
		StringBuilder jsAngular = page.getAngular().renderAngularJavascript(page);
		if (!jsAngular.toString().trim().isEmpty())
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
