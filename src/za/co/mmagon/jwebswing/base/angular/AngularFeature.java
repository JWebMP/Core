/*
 * Copyright (C) 2016 GedMarc
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

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.regex.Matcher;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.angular.controllers.AngularControllerBase;
import za.co.mmagon.jwebswing.base.angular.controllers.JWAngularController;
import za.co.mmagon.jwebswing.base.angular.directives.AngularDirectiveBase;
import za.co.mmagon.jwebswing.base.angular.modules.AngularModuleBase;
import za.co.mmagon.jwebswing.base.angular.modules.JWAngularModule;
import za.co.mmagon.jwebswing.base.exceptions.NullComponentException;
import za.co.mmagon.jwebswing.base.html.Comment;
import za.co.mmagon.jwebswing.base.html.interfaces.HTMLFeatures;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.utilities.TextUtilities;
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
     * All registered templates
     */
    private final Map<String, StringBuilder> TemplateScripts = new HashMap<>();
    /**
     * All registered variables
     */
    private final Map<String, StringBuilder> TemplateVariables = new HashMap<>();

    /**
     * Final collection of all the modules
     */
    private final List<AngularModuleBase> modules;
    /**
     * Final collection of all the directives
     */
    private final List<AngularDirectiveBase> directives;
    /**
     * Final collection of all the controllers
     */
    private final List<AngularControllerBase> controllers;

    /**
     * The application module
     */
    private final JWAngularModule jwAngularApp;
    /**
     * The controller module
     */
    private final JWAngularController jwAngularController;
    /**
     * The name of this angular application
     */
    private String appName = "jwApp";
    /**
     * The name of the default controller for this application (rendered last)
     */
    private String controllerName = "jwController";

    /**
     * All the angular variables
     */
    private List<String> angularVariables;

    /**
     * Adds on the Angular ComponentFeatureBase to the application to allow full data binding
     *
     * @param component
     */
    public AngularFeature(Component component)
    {
        this(component, "jwApp", "jwController");
    }

    /**
     * Adds on the Angular ComponentFeatureBase to the application to allow full data binding
     *
     * @param component       The component to associate with
     * @param applicationName The name of the application
     * @param controllerName  The name of the controller
     */
    public AngularFeature(Component component, String applicationName, String controllerName)
    {
        super("AngularFeature");
        if (component == null)
        {
            throw new NullComponentException("An Angular Application must always be tied with a parent component.");
        }
        setComponent(component);
        setJavascriptRenderedElsewhere(true);

        modules = new ArrayList<>();
        directives = new ArrayList<>();
        controllers = new ArrayList<>();

        jwAngularApp = new JWAngularModule(this);
        jwAngularController = new JWAngularController(this);

        controllers.add(getJwAngularController());

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
            if (getComponent().getPage().getOptions().isAngularEnabled())
            {
                getComponent().addAttribute(AngularAttributes.ngApp, getAppName() + "");
                getComponent().addAttribute(AngularAttributes.ngController, controllerName);
                getComponent().add(new Comment("Angular Application"));
                compileTemplate(AngularFeature.class, "jwangular");
            }
            setConfigured(true);
        }
    }

    /**
     * Convenience method for adding a directive
     *
     * @param directive
     *
     * @return This
     */
    public AngularFeature addDirective(AngularDirectiveBase directive)
    {
        if (!getDirectives().contains(directive))
        {
            getDirectives().add(directive);
        }
        return this;
    }

    /**
     * Convenience method for adding a directive
     *
     * @param directive
     *
     * @return This
     */
    public AngularFeature removeDirective(AngularDirectiveBase directive)
    {
        getDirectives().remove(directive);
        return this;
    }

    /**
     * Convenience method for adding a module
     *
     * @param module
     *
     * @return This
     */
    public AngularFeature addModule(AngularModuleBase module)
    {
        if (!getModules().contains(module))
        {
            getModules().add(module);
        }
        return this;
    }

    /**
     * Convenience method for adding a module
     *
     * @param module
     *
     * @return This
     */
    public AngularFeature removeModule(AngularModuleBase module)
    {
        getModules().remove(module);
        return this;
    }

    /**
     * Convenience method for adding a directive
     *
     * @param controllers
     *
     * @return This
     */
    public AngularFeature addDirective(AngularControllerBase controllers)
    {
        if (!getControllers().contains(controllers))
        {
            getControllers().add(controllers);
        }

        return this;
    }

    /**
     * Convenience method for adding a directive
     *
     * @param controller
     *
     * @return This
     */
    public AngularFeature removeDirective(AngularControllerBase controller)
    {
        getControllers().remove(controller);
        return this;
    }

    /**
     * JW_APP_NAME - the angular module application name JW_DIRECTIVES - the angular directives JW_MODULES the modules generates JW_APP_CONTROLLER the physical controller name JW_CONTROLLERS - the
     * controllers render part
     * <p>
     * Configures the base template variables. Override the method to add your own (keep call to super)
     */
    public void configureTemplateVariables()
    {
        TemplateVariables.put("JW_APP_NAME", new StringBuilder(getAppName() + ""));
        TemplateVariables.put("JW_MODULES", new StringBuilder(compileModules() + ""));
        TemplateVariables.put("JW_DIRECTIVES", new StringBuilder(compileDirectives() + ""));

        TemplateVariables.put("JW_APP_CONTROLLER", new StringBuilder(getControllerName() + ""));
        TemplateVariables.put("JW_CONTROLLERS", new StringBuilder(compileControllers() + ""));
    }

    /**
     * Replaces all instances of the following
     *
     * @param templateName The name of the template being processed
     * @param template     The physical string to process
     *
     * @return
     */
    public StringBuilder processTemplate(String templateName, String template)
    {
        String templateOutput = template;
        for (String templateVariable : getTemplateVariables().keySet())
        {
            String templateScript = Matcher.quoteReplacement(getTemplateVariables().get(templateVariable).toString());
            String templateNameClean = templateVariable;
            try
            {
                templateOutput = templateOutput.replaceAll("" + templateNameClean + "", templateScript);
            }
            catch (IllegalArgumentException iae)
            {
                LOG.config("[Error]-[Invalid Variable Name for Regular Expression Search];[Variable]-[" + templateVariable + "];[Script]-[" + templateScript + "]");
                LOG.severe(TextUtilities.stackTraceToString(iae));
            }
        }
        TemplateScripts.put(templateName, new StringBuilder(templateOutput));
        return TemplateScripts.get(templateName);
    }

    /**
     * Replaces all instances of the following
     * <p>
     * %%APP%% - the angular module application name %%DIRECTIVES%% - the angular directives %%MODULES%% the modules generates %%CONTROLLER%% the modules generates
     *
     * @param referenceClass The class to find where the file is at
     * @param templateName   the template to use
     *
     * @return the name
     */
    public StringBuilder compileTemplate(Class referenceClass, String templateName)
    {
        String template = getFileTemplate(referenceClass, templateName).toString();
        return processTemplate(templateName, template);
    }

    /**
     * Replaces all instances of the following
     * <p>
     * %%APP%% - the angular module application name %%DIRECTIVES%% - the angular directives %%MODULES%% the modules generates %%CONTROLLER%% the modules generates
     *
     * @param templateName The template name
     * @param template     the template to build
     *
     * @return the name
     */
    public StringBuilder compileTemplate(String templateName, String template)
    {
        return processTemplate(templateName, template);
    }

    /**
     * Builds up the directives from all the present children
     *
     * @return
     */
    public StringBuilder compileDirectives()
    {
        StringBuilder output = new StringBuilder();
        getDirectives().stream().forEach(directive ->
        {
            output.append(compileTemplate(directive.getReferenceName(), directive.renderFunction()));
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
        getControllers().stream().forEach(controller ->
        {
            output.append(compileTemplate(controller.getReferenceName(), controller.renderFunction()));
        });
        return output;
    }

    /**
     * compiles modules for all the present children
     *
     * @return
     */
    public StringBuilder compileModules()
    {
        StringBuilder output = new StringBuilder();
        output.append(compileTemplate(getJwAngularApp().getReferenceName(), getJwAngularApp().renderFunction()));
        return output;
    }

    /**
     * Returns the template as a string
     *
     * @param referenceClass The class to reference to locate the file
     * @param templateName   The file without .min.js or .js attached to it
     *
     * @return The string for the file
     */
    public StringBuilder getFileTemplate(Class referenceClass, String templateName)
    {
        StringBuilder template = TemplateScripts.get(templateName);
        if (template == null)
        {
            try
            {
                String templateFileName = templateName;

                if (this.component.isTiny())
                {
                    templateFileName += ".min.js";
                }
                else
                {
                    templateFileName += ".js";
                }
                byte[] fileContents;
                try (InputStream is = referenceClass.getResourceAsStream(templateFileName);
                        BufferedInputStream bis = new BufferedInputStream(is))
                {
                    fileContents = new byte[bis.available()];
                    bis.read(fileContents, 0, bis.available());
                }
                String contents = new String(fileContents);
                setTemplateScript(templateName, new StringBuilder(contents));
            }
            catch (FileNotFoundException ex)
            {
                LOG.log(Level.SEVERE, "[Error]-[unable to find template file];[TemplateFile]-[" + templateName + "];[TemplatePath]-[" + referenceClass.getResource(templateName).getPath() + "]", ex);
            }
            catch (IOException ex)
            {
                LOG.log(Level.SEVERE, "Unable to read file contents jwangular template File", ex);
            }
        }
        return TemplateScripts.get(templateName);
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
    public String getAppName()
    {
        return appName;
    }

    /**
     * Sets the angular application name associated
     *
     * @param appName
     */
    public final void setAppName(String appName)
    {
        this.appName = appName;

    }

    /**
     * Gets the controller name for this controller
     *
     * @return
     */
    public String getControllerName()
    {
        return controllerName;
    }

    /**
     * Sets the controller name for this application
     *
     * @param controllerName
     */
    public final void setControllerName(String controllerName)
    {
        this.controllerName = controllerName;
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
     * Gets the text string for the template script
     *
     * @param templateName
     *
     * @return
     */
    public StringBuilder getTemplateScript(String templateName)
    {
        return TemplateScripts.get(templateName);
    }

    /**
     * Sets the template script
     *
     * @param templateName
     * @param templateScript
     */
    public void setTemplateScript(String templateName, StringBuilder templateScript)
    {
        TemplateScripts.put(templateName, templateScript);
    }

    /**
     * Get the map of all the template scripts
     *
     * @param template
     *
     * @return A final HashMap
     */
    public StringBuilder renderTemplateScripts(String template)
    {
        configureTemplateVariables();
        if (TemplateScripts.containsKey(template) && TemplateScripts.get(template) != null)
        {
            StringBuilder output = processTemplate(template, getTemplateScripts().get(template).toString());
            return output;
        }

        return new StringBuilder();
    }

    /**
     * Get the map of all the template scripts
     *
     * @return A final HashMap
     */
    public Map<String, StringBuilder> getTemplateScripts()
    {
        return TemplateScripts;
    }

    /**
     * Returns all the compiles replacement template strings with their values to be replaced
     *
     * @return
     */
    public Map<String, StringBuilder> getTemplateVariables()
    {
        return TemplateVariables;
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
     * Returns a final ArrayList of directives for this angular application
     *
     * @return
     */
    public List<AngularDirectiveBase> getDirectives()
    {
        return directives;
    }

    /**
     * Returns a final ArrayList of directives for the angular application
     *
     * @return
     */
    public List<AngularModuleBase> getModules()
    {
        return modules;
    }

    /**
     * Returns the final controllers list for the angular application
     *
     * @return
     */
    public List<AngularControllerBase> getControllers()
    {
        return controllers;
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
