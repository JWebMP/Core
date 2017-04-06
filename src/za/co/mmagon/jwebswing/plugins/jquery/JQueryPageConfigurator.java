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
package za.co.mmagon.jwebswing.plugins.jquery;

import za.co.mmagon.jwebswing.*;
import za.co.mmagon.jwebswing.base.client.BrowserGroups;
import za.co.mmagon.jwebswing.plugins.PluginInformation;

/**
 * This Configurator adds the JQuery portion onto the page rendering
 *
 * @author Marc Magon
 * @since 2017/03/13
 */
@PluginInformation(pluginName = "JQuery",
        pluginUniqueName = "jquery",
        pluginDescription = "jQuery is a fast, small, and feature-rich JavaScript library. It makes things like HTML document traversal and manipulation, event handling, animation, and Ajax much simpler with an easy-to-use API that works across a multitude of browsers. With a combination of versatility and extensibility, jQuery has changed the way that millions of people write JavaScript.",
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
        pluginOriginalHomepage = "http://www.jquery.com"
)
public class JQueryPageConfigurator extends PageConfigurator
{

    private static final long serialVersionUID = 1L;
    /**
     * String property denoting JQuery is enabled on a page
     */
    private static final String JQueryEnabledString = "jquery-enabled";
    /**
     * If the page must render JQuery 3
     */
    private static boolean jquery3 = true;

    public JQueryPageConfigurator()
    {
        setSortOrder(99999998); //Always before angular
    }

    @Override
    public Page configure(Page page)
    {

        if (page != null)
        {
            if (page.getBody().readChildrenPropertyFirstResult(JQueryEnabledString, true))
            {
                if (page.getBrowser() != null)
                {
                    if (page.getBrowser().getBrowserGroup() == BrowserGroups.InternetExplorer)
                    {
                        if (page.getBrowser().getBrowserVersion() < 9)
                        {
                            page.getBody().removeJavaScriptReference(JQueryReferencePool.JQueryV2.getJavaScriptReference());
                            page.getBody().removeJavaScriptReference(JQueryReferencePool.JQueryV3.getJavaScriptReference());
                            page.getBody().removeJavaScriptReference(JQueryReferencePool.JQueryMigrate.getJavaScriptReference());
                            page.getBody().addJavaScriptReference(JQueryReferencePool.JQuery.getJavaScriptReference());
                        }
                    }
                    else
                    {
                        page.getBody().removeJavaScriptReference(JQueryReferencePool.JQuery.getJavaScriptReference());
                        if (isJquery3())
                        {
                            page.getBody().addJavaScriptReference(JQueryReferencePool.JQueryV3.getJavaScriptReference());
                            page.getBody().addJavaScriptReference(JQueryReferencePool.JQueryMigrate.getJavaScriptReference());
                        }
                        else
                        {
                            page.getBody().addJavaScriptReference(JQueryReferencePool.JQueryV2.getJavaScriptReference());
                        }
                    }
                }
                else if (isJquery3())
                {
                    page.getBody().addJavaScriptReference(JQueryReferencePool.JQueryV3.getJavaScriptReference());
                    page.getBody().addJavaScriptReference(JQueryReferencePool.JQueryMigrate.getJavaScriptReference());
                }
                else
                {
                    page.getBody().addJavaScriptReference(JQueryReferencePool.JQueryV2.getJavaScriptReference());
                    //addJavaScriptReference(JQueryReferencePool.JQueryMigrate.getJavaScriptReference());
                }
            }
        }

        return page;
    }

    /**
     * Sets the component/feature/hierarchy as JQuery required
     *
     * @param component
     * @param required
     */
    public static void setRequired(Component component, Boolean required)
    {
        component.getProperties().put(JQueryEnabledString, required.toString());
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
