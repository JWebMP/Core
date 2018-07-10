/*
 * Copyright (C) 2017 Marc Magon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.jwebmp.plugins.jquery;

import com.jwebmp.Page;
import com.jwebmp.PageConfigurator;
import com.jwebmp.base.client.BrowserGroups;
import com.jwebmp.plugins.PluginInformation;

/**
 * This Configurator adds the JQuery portion onto the page rendering
 *
 * @author Marc Magon
 * @since 2017/03/13
 */
@PluginInformation(pluginName = "JQuery",
		pluginUniqueName = "jquery",
		pluginDescription = "jQuery is a fast, small, and feature-rich JavaScript library. It makes things like HTML document traversal " + "and manipulation, event handling, animation, and Ajax much simpler with an easy-to-use API that " + "works" + " across a multitude of browsers. With a combination of versatility and extensibility, " + "jQuery has " + "changed the way that millions of people write JavaScript.",
		pluginVersion = "3.1.1",
		pluginDependancyUniqueIDs = "",
		pluginCategories = "javascript,jquery, framework, jwebswing",
		pluginSubtitle = " jQuery has changed the way that millions of people write JavaScript",
		pluginGitUrl = "https://github.com/GedMarc/JWebSwing",
		pluginSourceUrl = "https://github.com/jquery/jquery",
		pluginWikiUrl = "https://github.com/GedMarc/JWebSwing/wiki",
		pluginDownloadUrl = "",
		pluginIconUrl = "jquery_icon.png",
		pluginIconImageUrl = "jquery_logo.png",
		pluginLastUpdatedDate = "2017/03/13",
		pluginOriginalHomepage = "http://www.jquery.com")
public class JQueryPageConfigurator
		extends PageConfigurator
{

	private static final long serialVersionUID = 1L;
	private static boolean required;
	/**
	 * If the page must render JQuery 3
	 */
	private static boolean jquery3 = true;
	private static boolean renderMigrate = false;

	public JQueryPageConfigurator()
	{
		setSortOrder(99999998); //Always before angular
	}

	/**
	 * If the migrate plugin must be rendered. Default false
	 *
	 * @return
	 */
	public static boolean isRenderMigrate()
	{
		return renderMigrate;
	}

	/**
	 * If the migrate plugin must be rendered. Default false
	 *
	 * @param renderMigrate
	 */
	public static void setRenderMigrate(boolean renderMigrate)
	{
		JQueryPageConfigurator.renderMigrate = renderMigrate;
	}

	/**
	 * Returns if JQuery is configured as required for the page
	 *
	 * @return
	 */
	public static boolean isRequired()
	{
		return required;
	}

	/**
	 * Sets the component/feature/hierarchy as JQuery required
	 *
	 * @param required
	 */
	@SuppressWarnings("unchecked")
	public static void setRequired(boolean required)
	{
		JQueryPageConfigurator.required = required;
	}

	@Override
	public Page configure(Page page)
	{
		if (page.getOptions()
		        .isLocalStorage())
		{
			page.getBody()
			    .addJavaScriptReference(JQueryReferencePool.PersistJS.getJavaScriptReference());
		}
		if (required)
		{
			if (page.getBrowser() != null)
			{
				page = configureForInternetExplorer(page);
			}
			else if (isJquery3())
			{
				page.getBody()
				    .addJavaScriptReference(JQueryReferencePool.JQueryV3.getJavaScriptReference());
				if (renderMigrate)
				{
					page.getBody()
					    .addJavaScriptReference(JQueryReferencePool.JQueryMigrate.getJavaScriptReference());
				}
			}
			else
			{
				if (renderMigrate)
				{
					page.getBody()
					    .addJavaScriptReference(JQueryReferencePool.JQueryV2.getJavaScriptReference());
				}
			}
		}


		return page;
	}

	private Page configureForInternetExplorer(Page page)
	{
		if (page.getBrowser()
		        .getBrowserGroup() == BrowserGroups.InternetExplorer)
		{
			if (page.getBrowser()
			        .getBrowserVersion() < 9)
			{
				page.getBody()
				    .removeJavaScriptReference(JQueryReferencePool.JQueryV2.getJavaScriptReference());
				page.getBody()
				    .removeJavaScriptReference(JQueryReferencePool.JQueryV3.getJavaScriptReference());
				page.getBody()
				    .removeJavaScriptReference(JQueryReferencePool.JQueryMigrate.getJavaScriptReference());
				page.getBody()
				    .addJavaScriptReference(JQueryReferencePool.JQuery.getJavaScriptReference());
			}
		}
		else
		{
			page.getBody()
			    .removeJavaScriptReference(JQueryReferencePool.JQuery.getJavaScriptReference());
			if (isJquery3())
			{
				page.getBody()
				    .addJavaScriptReference(JQueryReferencePool.JQueryV3.getJavaScriptReference());
				if (renderMigrate)
				{
					page.getBody()
					    .addJavaScriptReference(JQueryReferencePool.JQueryMigrate.getJavaScriptReference());
				}
			}
			else
			{
				page.getBody()
				    .addJavaScriptReference(JQueryReferencePool.JQueryV2.getJavaScriptReference());
			}
		}

		return page;
	}

	/**
	 * Whether or not this page must render JQuery 3
	 *
	 * @return
	 */
	public static boolean isJquery3()
	{
		return jquery3;
	}

	/**
	 * Whether or not this page must render JQuery 3
	 *
	 * @param jquery3
	 */
	public static void setJquery3(boolean jquery3)
	{
		JQueryPageConfigurator.jquery3 = jquery3;
	}
}
