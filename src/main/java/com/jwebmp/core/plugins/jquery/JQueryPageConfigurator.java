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
package com.jwebmp.core.plugins.jquery;

import com.jwebmp.core.Page;
import com.jwebmp.core.base.client.BrowserGroups;
import com.jwebmp.core.plugins.PluginInformation;
import com.jwebmp.core.services.IPageConfigurator;

import javax.validation.constraints.NotNull;

/**
 * This Configurator adds the JQuery portion onto the page rendering
 *
 * @author Marc Magon
 * @since 2017/03/13
 */
@SuppressWarnings({"WeakerAccess", "unused"})
@PluginInformation(pluginName = "JQuery",
		pluginUniqueName = "jquery",
		pluginDescription = "jQuery is a fast, small, and feature-rich JavaScript library. It makes things like HTML document traversal " +
		                    "and manipulation, event handling, animation, and Ajax much simpler with an easy-to-use API that " +
		                    "works" +
		                    " across a multitude of browsers. With a combination of versatility and extensibility, " +
		                    "jQuery has " +
		                    "changed the way that millions of people write JavaScript.",
		pluginVersion = "3.1.1",
		pluginCategories = "javascript,jquery, framework, jwebswing",
		pluginSubtitle = " jQuery has changed the way that millions of people write JavaScript",
		pluginGitUrl = "https://github.com/GedMarc/JWebMP",
		pluginSourceUrl = "https://github.com/jquery/jquery",
		pluginWikiUrl = "https://github.com/GedMarc/JWebMP/wiki",
		pluginDownloadUrl = "",
		pluginIconUrl = "jquery_icon.png",
		pluginIconImageUrl = "jquery_logo.png",
		pluginLastUpdatedDate = "2017/03/13",
		pluginOriginalHomepage = "http://www.jquery.com")
public class JQueryPageConfigurator
		implements IPageConfigurator<JQueryPageConfigurator>
{
	/**
	 * If this configurator is enabled
	 */
	private static boolean enabled = true;
	/**
	 * Field required
	 */
	private static boolean required;
	/**
	 * If the page must render JQuery 3
	 */
	private static boolean jquery3 = true;
	/**
	 * Field renderMigrate
	 */
	private static boolean renderMigrate = false;

	/**
	 * Constructor JQueryPageConfigurator creates a new JQueryPageConfigurator instance.
	 */
	public JQueryPageConfigurator()
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
		return JQueryPageConfigurator.enabled;
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
		JQueryPageConfigurator.enabled = mustEnable;
	}

	/**
	 * If the migrate plugin must be rendered. Default false
	 *
	 * @return if migrate reference should be used
	 */
	public static boolean isRenderMigrate()
	{
		return JQueryPageConfigurator.renderMigrate;
	}

	/**
	 * If the migrate plugin must be rendered. Default false
	 *
	 * @param renderMigrate
	 * 		If migrate should be used
	 */
	public static void setRenderMigrate(boolean renderMigrate)
	{
		JQueryPageConfigurator.renderMigrate = renderMigrate;
	}

	/**
	 * Returns if JQuery is configured as required for the page
	 *
	 * @return If the reference is required
	 */
	public static boolean isRequired()
	{
		return JQueryPageConfigurator.required;
	}

	/**
	 * Sets the component/feature/hierarchy as JQuery required
	 *
	 * @param required
	 * 		If is required
	 */
	@SuppressWarnings("unchecked")
	public static void setRequired(boolean required)
	{
		JQueryPageConfigurator.required = required;
	}

	/**
	 * Method configure ...
	 *
	 * @param page
	 * 		of type Page
	 *
	 * @return Page
	 */
	@NotNull
	@Override
	public Page configure(Page page)
	{
		if (page.getOptions()
		        .isLocalStorage())
		{
			page.getBody()
			    .addJavaScriptReference(JQueryReferencePool.PersistJS.getJavaScriptReference());
		}
		if (JQueryPageConfigurator.required)
		{
			if (page.getBrowser() != null)
			{
				configureForInternetExplorer(page);
			}
			else if (JQueryPageConfigurator.isJquery3())
			{
				page.getBody()
				    .addJavaScriptReference(JQueryReferencePool.JQueryV3.getJavaScriptReference());
				if (JQueryPageConfigurator.renderMigrate)
				{
					page.getBody()
					    .addJavaScriptReference(JQueryReferencePool.JQueryMigrate.getJavaScriptReference());
				}
			}
			else
			{
				if (JQueryPageConfigurator.renderMigrate)
				{
					page.getBody()
					    .addJavaScriptReference(JQueryReferencePool.JQueryV2.getJavaScriptReference());
				}
			}
		}

		return page;
	}

	/**
	 * Method configureForInternetExplorer ...
	 *
	 * @param page
	 * 		of type Page
	 *
	 * @return Page
	 */
	@SuppressWarnings("UnusedReturnValue")
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
			if (JQueryPageConfigurator.isJquery3())
			{
				page.getBody()
				    .addJavaScriptReference(JQueryReferencePool.JQueryV3.getJavaScriptReference());
				if (JQueryPageConfigurator.renderMigrate)
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
	 * @return If jquery 3 must be rendered - always rendered now
	 */
	public static boolean isJquery3()
	{
		return JQueryPageConfigurator.jquery3;
	}

	/**
	 * Whether or not this page must render JQuery 3
	 *
	 * @param jquery3
	 * 		if jquery 3 must be rendered
	 */
	public static void setJquery3(boolean jquery3)
	{
		JQueryPageConfigurator.jquery3 = jquery3;
	}

	@Override
	public boolean enabled()
	{
		return JQueryPageConfigurator.enabled;
	}

	/**
	 * Sort order for startup, Default 100.
	 *
	 * @return the sort order never null
	 */
	@Override
	public Integer sortOrder()
	{
		//Always before angular
		return Integer.MAX_VALUE - 100;
	}

	/**
	 * Method hashCode ...
	 *
	 * @return int
	 */
	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	/**
	 * Method equals ...
	 *
	 * @param obj
	 * 		of type Object
	 *
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null)
		{
			return false;
		}
		return getClass().equals(obj.getClass());
	}
}
