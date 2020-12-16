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
package com.jwebmp.core.plugins;

import java.lang.annotation.*;

/**
 * Defines a plugin, attach to a Page Configurator
 *
 * @author GedMarc
 * @since 19 Feb 2017
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface PluginInformation
{

	/**
	 * Lower case unique id name
	 *
	 * @return
	 */
	String pluginUniqueName();

	/**
	 * The actual name of the plugin
	 *
	 * @return
	 */
	String pluginName();

	/**
	 * The version identifier for the plugin
	 *
	 * @return
	 */
	String pluginVersion();

	/**
	 * The subtitle of the plugin
	 *
	 * @return
	 */
	String pluginSubtitle() default "";

	/**
	 * The description of the plugin
	 *
	 * @return
	 */
	String pluginDescription();

	/**
	 * The categories of the plugin
	 *
	 * @return
	 */
	String pluginCategories() default "";

	/**
	 * The actual Wiki url for this plugin
	 *
	 * @return
	 */
	String pluginWikiUrl() default "";

	/**
	 * The image for the icon of this plugin (192x192)
	 *
	 * @return
	 */
	String pluginIconImageUrl() default "";

	/**
	 * The source url for this plugin
	 *
	 * @return
	 */
	String pluginIconUrl() default "";

	/**
	 * The source url for this plugin (usually git)
	 *
	 * @return
	 */
	String pluginSourceUrl() default "";

	/**
	 * The Git url for the java portion of this plugin
	 *
	 * @return
	 */
	String pluginGitUrl() default "";

	/**
	 * The donate button for the source url of this plugin
	 *
	 * @return
	 */
	String pluginSourceDonateUrl() default "https://paypal.me/MarcMagon/15";

	/**
	 * The default download URL for plugins
	 *
	 * @return
	 */
	String pluginDownloadUrl() default "https://sourceforge.net/projects/jwebswing/files/";

	/**
	 * The author of this plugin
	 *
	 * @return
	 */
	String pluginAuthor() default "Marc Magon";

	/**
	 * The date (pls yyyy/MM/dd format) for this plugin
	 *
	 * @return
	 */
	String pluginLastUpdatedDate() default "2017/02/19";

	/**
	 * Comma separated list of unique id name for plugins
	 *
	 * @return
	 */
	String pluginDependancyUniqueIDs() default "";

	/**
	 * The price of this plugin
	 *
	 * @return
	 */
	double pluginPrice() default 0.0;

	/**
	 * @return
	 */
	String pluginPayUrl() default "https://paypal.me/MarcMagon/15";

	/**
	 * The default homepage of the plugin
	 *
	 * @return
	 */
	String pluginOriginalHomepage() default "";

	/**
	 * If the plugin requires commercial for public sites
	 *
	 * @return
	 */
	boolean pluginCommercial() default false;
	
	/**
	 * The name of the hosting module
	 * @return
	 */
	String pluginModuleName() default "NotEntered";
	
	/**
	 * The pom plugin group id
	 * @return
	 */
	String pluginGroupId() default "NotEntered";
	
	/**
	 * The pom artifact id
	 * @return
	 */
	String pluginArtifactId() default "NotEntered";
	
	/**
	 * The current status
	 * @return
	 */
	PluginStatus pluginStatus() default PluginStatus.Planned;
}
