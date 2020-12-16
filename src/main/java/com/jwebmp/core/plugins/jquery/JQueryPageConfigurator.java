/*
 * Copyright (C) 2017 GedMarc
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
import com.jwebmp.core.plugins.PluginInformation;
import com.jwebmp.core.plugins.PluginStatus;
import com.jwebmp.core.services.IPageConfigurator;

import jakarta.validation.constraints.NotNull;

/**
 * This Configurator adds the JQuery portion onto the page rendering
 *
 * @author GedMarc
 * @since 2017/03/13
 */
@SuppressWarnings({"WeakerAccess", "unused"})
@PluginInformation(pluginName = "JQuery",
		pluginUniqueName = "jquery",
		pluginDescription = "jQuery is a fast, small, and feature-rich JavaScript library. It makes things like HTML document traversal " +
		                    "and manipulation, event handling, animation, and Ajax much simpler with an easy-to-use API that " +
		                    "works across a multitude of browsers. With a combination of versatility and extensibility, " +
		                    "jQuery has changed the way that millions of people write JavaScript.",
		pluginVersion = "3.5.1",
		pluginCategories = "javascript,jquery, framework, core",
		pluginSubtitle = " jQuery has changed the way that millions of people write JavaScript",
		pluginGitUrl = "https://github.com/GedMarc/JWebMP",
		pluginSourceUrl = "https://github.com/jquery/jquery",
		pluginWikiUrl = "https://github.com/GedMarc/JWebMP/wiki",
		pluginDownloadUrl = "https://mvnrepository.com/artifact/com.jwebmp.core/jwebmp-core",
		pluginIconUrl = "jquery_icon.png",
		pluginIconImageUrl = "jquery_logo.png",
		pluginLastUpdatedDate = "2020/04/14",
		pluginOriginalHomepage = "http://www.jquery.com",
		pluginModuleName = "com.jwebmp.core",
		pluginGroupId = "com.jwebmp.core",
		pluginArtifactId = "jwebmp-core",
		pluginStatus = PluginStatus.Released,
		pluginSourceDonateUrl = "https://js.foundation/about/donate"
)
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
	public Page<?> configure(Page<?> page)
	{
		if (JQueryPageConfigurator.required)
		{
			configureJQuery(page);
		}
		return page;
	}

	/**
	 * Method configureJQuery ...
	 *
	 * @param page
	 * 		of type Page
	 *
	 * @return Page
	 */
	@SuppressWarnings("UnusedReturnValue")
	private Page<?> configureJQuery(Page<?> page)
	{
		page.getBody()
		    .addJavaScriptReference(JQueryReferencePool.JQueryV3.getJavaScriptReference());
		if (JQueryPageConfigurator.renderMigrate)
		{
			page.getBody()
			    .addJavaScriptReference(JQueryReferencePool.JQueryMigrate.getJavaScriptReference());
		}
		return page;
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
