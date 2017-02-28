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
package za.co.mmagon.jwebswing.plugins;

import java.lang.annotation.*;

/**
 * Defines a plugin, attach to a Page Configurator
 *
 * @author GedMarc
 * @since 19 Feb 2017
 *
 */
@Target(
        {
            ElementType.FIELD, ElementType.TYPE, ElementType.LOCAL_VARIABLE, ElementType.PACKAGE, ElementType.METHOD, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE
        })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface PluginInformation
{

    /**
     * Lower case unique id name
     *
     * @return
     */
    public String pluginUniqueName();

    /**
     * The actual name of the plugin
     *
     * @return
     */
    public String pluginName();

    /**
     * The version identifier for the plugin
     *
     * @return
     */
    public String pluginVersion();

    /**
     * The subtitle of the plugin
     *
     * @return
     */
    public String pluginSubtitle() default "";

    /**
     * The description of the plugin
     *
     * @return
     */
    public String pluginDescription();

    /**
     * The categories of the plugin
     *
     * @return
     */
    public String pluginCategories() default "";

    /**
     * The actual Wiki url for this plugin
     *
     * @return
     */
    public String pluginWikiUrl() default "";

    /**
     * The image for the icon of this plugin (192x192)
     *
     * @return
     */
    public String pluginIconImageUrl() default "";

    /**
     * The source url for this plugin
     *
     * @return
     */
    public String pluginIconUrl() default "";

    /**
     * The source url for this plugin (usually git)
     *
     * @return
     */
    public String pluginSourceUrl() default "";

    /**
     * The Git url for the java portion of this plugin
     *
     * @return
     */
    public String pluginGitUrl() default "";

    /**
     * The donate button for the source url of this plugin
     *
     * @return
     */
    public String pluginSourceDonateUrl() default "https://paypal.me/MarcMagon/15";

    /**
     * The default download URL for plugins
     *
     * @return
     */
    public String pluginDownloadUrl() default "https://sourceforge.net/projects/jwebswing/files/";

    /**
     * The author of this plugin
     *
     * @return
     */
    public String pluginAuthor() default "Marc Magon";

    /**
     * The date (pls yyyy/MM/dd format) for this plugin
     *
     * @return
     */
    public String pluginLastUpdatedDate() default "2017/02/19";

    /**
     * Comma separated list of unique id name for plugins
     *
     * @return
     */
    public String pluginDependancyUniqueIDs() default "";

    /**
     * The price of this plugin
     *
     * @return
     */
    public double pluginPrice() default 0.0;

    /**
     *
     * @return
     */
    public String pluginPayUrl() default "https://paypal.me/MarcMagon/15";

    /**
     * The default homepage of the plugin
     *
     * @return
     */
    public String pluginOriginalHomepage() default "";

    /**
     * If the plugin requires commercial for public sites
     *
     * @return
     */
    public boolean pluginCommercial() default false;
}
