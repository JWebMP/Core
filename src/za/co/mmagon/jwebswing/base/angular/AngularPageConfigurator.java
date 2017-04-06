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
package za.co.mmagon.jwebswing.base.angular;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;
import java.util.List;
import za.co.mmagon.FileTemplates;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.PageConfigurator;
import za.co.mmagon.jwebswing.base.ComponentHTMLAngularBase;
import za.co.mmagon.jwebswing.base.angular.controllers.AngularControllerBase;
import za.co.mmagon.jwebswing.base.angular.directives.AngularDirectiveBase;
import za.co.mmagon.jwebswing.base.angular.modules.AngularModuleBase;
import za.co.mmagon.jwebswing.plugins.PluginInformation;

/**
 *
 * @author GedMarc
 * @since 21 Feb 2017
 *
 */
@PluginInformation(pluginName = "AngularJS",
        pluginUniqueName = "angular",
        pluginDescription = "AngularJS is a toolset for building the framework most suited to your application development. It is fully extensible and works well with other libraries. Every feature can be modified or replaced to suit your unique development workflow and feature needs. Read on to find out how. ",
        pluginVersion = "1.6",
        pluginDependancyUniqueIDs = "jquery",
        pluginCategories = "jquery, angular, data-binding, ng,google",
        pluginSubtitle = "Data-binding is an automatic way of updating the view whenever the model changes, as well as updating the model whenever the view changes. This is awesome because it eliminates DOM manipulation from the list of things you have to worry about. ",
        pluginGitUrl = "https://github.com/GedMarc/JWebSwing",
        pluginSourceUrl = "https://angularjs.org",
        pluginWikiUrl = "https://github.com/GedMarc/JWebSwing/wiki",
        pluginOriginalHomepage = "https://angularjs.org",
        pluginDownloadUrl = "https://angularjs.org/",
        pluginIconUrl = "",
        pluginIconImageUrl = "https://angularjs.org/img/AngularJS-large.png",
        pluginLastUpdatedDate = "2017/03/30"
)
public class AngularPageConfigurator extends PageConfigurator
{

    private static final long serialVersionUID = 1L;
    public static final String AngularEnabledString = "angular-enabled";

    /**
     * All the angular modules for this component
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AngularModuleBase> angularModules;
    /**
     * All of the angular directives for this component
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AngularDirectiveBase> angularDirectives;
    /**
     * All of the angular directives for this component
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AngularControllerBase> angularControllers;
    /**
     * All the angular variables
     */
    private List<String> angularVariables;

    /**
     * Configures the angular page
     */
    public AngularPageConfigurator()
    {
        setSortOrder(99999999); //Always dead last
    }

    @Override
    public Page configure(Page page)
    {
        if (!page.isConfigured())
        {
            if (page.getBody().readChildrenPropertyFirstResult(AngularEnabledString, true))
            {
                page.getBody().getJavascriptReferences().add(AngularReferencePool.Angular1.getJavaScriptReference());
                page.getBody().addAttribute(AngularAttributes.ngApp, AngularFeature.getAppName());
                page.getBody().addAttribute(AngularAttributes.ngController, AngularFeature.getControllerName());
            }
        }
        else
        {
            System.out.println("Page is already configured, not running angualr");
        }
        return page;
    }

    /**
     * Sets angular as a required component
     *
     * @param component
     * @param required
     */
    public static void setRequired(ComponentHTMLAngularBase component, boolean required)
    {
        component.getProperties().put(AngularEnabledString, required);
    }

    /**
     * Gets a list of angular modules
     *
     * @return
     */
    public List<AngularModuleBase> getAngularModules()
    {
        if (angularModules == null)
        {
            setAngularModules(new ArrayList<>());

        }
        return angularModules;
    }

    /**
     * Sets the angular modules
     *
     * @param angularModules
     */
    public void setAngularModules(List<AngularModuleBase> angularModules)
    {
        this.angularModules = angularModules;
    }

    /**
     * Gets the list of angular directives
     *
     * @return
     */
    public List<AngularDirectiveBase> getAngularDirectives()
    {
        if (angularDirectives == null)
        {
            setAngularDirectives(new ArrayList<>());

        }
        return angularDirectives;
    }

    /**
     * Sets the list of angular directives.
     *
     * @param angularDirectives
     */
    public void setAngularDirectives(List<AngularDirectiveBase> angularDirectives)
    {
        this.angularDirectives = angularDirectives;
    }

    /**
     * Returns a list of all the angular controllers for this component
     *
     * @return
     */
    public List<AngularControllerBase> getAngularControllers()
    {
        if (angularControllers == null)
        {
            setAngularControllers(new ArrayList<>());

        }
        return angularControllers;
    }

    /**
     * Sets the list of angular controllers for this component
     *
     * @param angularControllers
     */
    public void setAngularControllers(List<AngularControllerBase> angularControllers)
    {
        this.angularControllers = angularControllers;
    }

    /**
     * Returns the list of angular variables
     *
     * @return
     */
    public List<String> getAngularVariables()
    {
        if (angularVariables == null)
        {
            angularVariables = new ArrayList<>();
        }
        return angularVariables;
    }

    /**
     * Sets the list of angular variables
     *
     * @param angularVariables
     */
    public void setAngularVariables(List<String> angularVariables)
    {
        this.angularVariables = angularVariables;
    }

    public StringBuilder renderAngularJavascript(Page page)
    {
        StringBuilder sb = new StringBuilder();
        AngularFeature af = new AngularFeature(page);
        af.configureTemplateVariables();
        sb.append(FileTemplates.renderTemplateScripts("jwangular"));
        return sb;
    }
}
