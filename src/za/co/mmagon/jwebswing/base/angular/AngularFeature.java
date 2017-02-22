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
package za.co.mmagon.jwebswing.base.angular;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import za.co.mmagon.FileTemplates;
import za.co.mmagon.jwebswing.*;
import za.co.mmagon.jwebswing.base.angular.controllers.AngularControllerBase;
import za.co.mmagon.jwebswing.base.angular.controllers.JWAngularController;
import za.co.mmagon.jwebswing.base.angular.directives.AngularDirectiveBase;
import za.co.mmagon.jwebswing.base.angular.modules.AngularModuleBase;
import za.co.mmagon.jwebswing.base.angular.modules.JWAngularModule;
import za.co.mmagon.jwebswing.base.exceptions.NullComponentException;
import za.co.mmagon.jwebswing.base.html.interfaces.HTMLFeatures;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.logger.LogFactory;

/**
 * The Angular 1 Feature Implementation
 *
 * @author GedMarc
 * @since 16 Apr 2016
 */
public class AngularFeature extends Feature<JavaScriptPart, AngularFeature> implements HTMLFeatures
{

    private static final long serialVersionUID = 1L;

    /**
     * The logger for angular
     */
    private static final java.util.logging.Logger LOG = LogFactory.getInstance().getLogger("AngularFeature");

    /**
     * The application module
     */
    @JsonIgnore
    private final JWAngularModule jwAngularApp;
    /**
     * The controller module
     */
    @JsonIgnore
    private final JWAngularController jwAngularController;
    /**
     * The name of this angular application
     */
    private static String appName = "jwApp";
    /**
     * The name of the default controller for this application (rendered last)
     */
    private static String controllerName = "jwController";

    private final Page page;

    /**
     * Adds on the Angular ComponentFeatureBase to the application to allow full data binding
     *
     * @param component
     */
    public AngularFeature(Page component)
    {
        this(component, appName, controllerName);
    }

    /**
     * Adds on the Angular ComponentFeatureBase to the application to allow full data binding
     *
     * @param page            The component to associate with
     * @param applicationName The name of the application
     * @param controllerName  The name of the controller
     */
    public AngularFeature(Page page, String applicationName, String controllerName)
    {
        super("AngularFeature");
        if (page == null)
        {
            throw new NullComponentException("An Angular Application must always be tied with a parent component.");
        }
        this.page = page;
        setJavascriptRenderedElsewhere(true);

        jwAngularApp = new JWAngularModule(page);
        jwAngularController = new JWAngularController();
        if (applicationName != null && !applicationName.isEmpty())
        {
            setAppName(applicationName);
        }
        if (controllerName != null && !controllerName.isEmpty())
        {
            setControllerName(controllerName);
        }
        setRenderAfterLoad(false);
    }

    /**
     * Compile the template
     */
    @Override
    public void preConfigure()
    {
        if (!isConfigured())
        {
            if (getPage().getBody().readChildrenPropertyFirstResult(AngularPageConfigurator.AngularEnabledString, true))
            {
                getPage().getBody().addAttribute(AngularAttributes.ngApp, getAppName() + "");
                getPage().getBody().addAttribute(AngularAttributes.ngController, controllerName);
            }
        }
        super.preConfigure();
    }

    public Page getPage()
    {
        return page;
    }

    /**
     * JW_APP_NAME - the angular module application name JW_DIRECTIVES - the angular directives JW_MODULES the modules generates JW_APP_CONTROLLER the physical controller name JW_CONTROLLERS - the
     * controllers render part
     * <p>
     * Configures the base template variables. Override the method to add your own (keep call to super)
     */
    public void configureTemplateVariables()
    {
        FileTemplates.getTemplateVariables().put("JW_APP_NAME", new StringBuilder(getAppName() + ""));
        FileTemplates.getTemplateVariables().put("JW_MODULES", new StringBuilder(compileModules() + ""));
        FileTemplates.getTemplateVariables().put("JW_DIRECTIVES", new StringBuilder(compileDirectives() + ""));
        FileTemplates.getTemplateVariables().put("JW_APP_CONTROLLER", new StringBuilder(getControllerName() + ""));
        FileTemplates.getTemplateVariables().put("JW_CONTROLLERS", new StringBuilder(compileControllers() + ""));
        FileTemplates.getTemplateVariables().put("jwangular", FileTemplates.compileTemplate(AngularFeature.class, "jwangular"));
    }

    /**
     * Builds up the directives from all the present children
     *
     * @return
     */
    public StringBuilder compileDirectives()
    {
        StringBuilder output = new StringBuilder();
        List<AngularDirectiveBase> angulars = new ArrayList<>();
        angulars.addAll(getPage().getAngular().getAngularDirectives());
        angulars.stream().forEach(directive ->
        {
            output.append(FileTemplates.compileTemplate(directive.getReferenceName(), directive.renderFunction()));
        });
        return output;
    }

    /**
     * Builds up the directives from all the present children
     *
     * @return
     */
    public StringBuilder compileControllers()
    {
        StringBuilder output = new StringBuilder();
        List<AngularControllerBase> angulars = new ArrayList<>();
        angulars.add(jwAngularController);
        angulars.addAll(getPage().getAngular().getAngularControllers());
        angulars.stream().forEach(controller ->
        {
            output.append(FileTemplates.compileTemplate(controller.getReferenceName(), controller.renderFunction()));
        });
        return output;
    }

    /**
     * compiles the global JW Angular Module, where the separate modules get listed inside of JWAngularModule
     *
     * @return
     */
    public StringBuilder compileModules()
    {
        StringBuilder output = new StringBuilder();
        List<AngularModuleBase> angulars = new ArrayList<>();
        angulars.add(jwAngularApp);
        angulars.stream().forEach(module ->
        {
            output.append(FileTemplates.compileTemplate(module.getReferenceName(), module.renderFunction()));
        });
        return output;
    }

    /**
     * Returns the JavaScript for this feature
     */
    @Override
    public void assignFunctionsToComponent()
    {
        //Do Nothing Force Overide
    }

    /**
     * Returns the application name associated
     *
     * @return
     */
    public static String getAppName()
    {
        return appName;
    }

    /**
     * Sets the angular application name associated
     *
     * @param appName
     */
    public static final void setAppName(String appName)
    {
        AngularFeature.appName = appName;

    }

    /**
     * Gets the controller name for this controller
     *
     * @return
     */
    public static String getControllerName()
    {
        return controllerName;
    }

    /**
     * Sets the controller name for this application
     *
     * @param controllerName
     */
    public static final void setControllerName(String controllerName)
    {
        AngularFeature.controllerName = controllerName;
    }

    /**
     * Sets this body
     *
     * @param body
     */
    public final void setComponent(Component body)
    {
        this.component = body;
    }

    /**
     * Returns the physical angular application in use
     *
     * @return
     */
    public final JWAngularModule getJwAngularApp()
    {
        return jwAngularApp;
    }

    /**
     * Get the JW Angular Controller associated for this application
     *
     * @return
     */
    public final JWAngularController getJwAngularController()
    {
        return jwAngularController;
    }

    @Override
    public StringBuilder renderJavascript()
    {
        return new StringBuilder();
        //return renderTemplateScripts("jwangular");
    }

}
