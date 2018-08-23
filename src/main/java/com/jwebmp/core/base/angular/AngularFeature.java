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
package com.jwebmp.core.base.angular;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jwebmp.core.Feature;
import com.jwebmp.core.FileTemplates;
import com.jwebmp.core.Page;
import com.jwebmp.core.base.angular.controllers.JWAngularController;
import com.jwebmp.core.base.angular.modules.AngularModuleBase;
import com.jwebmp.core.base.angular.modules.JWAngularModule;
import com.jwebmp.core.base.angular.services.IAngularController;
import com.jwebmp.core.base.angular.services.IAngularDefaultService;
import com.jwebmp.core.base.html.interfaces.HTMLFeatures;
import com.jwebmp.core.exceptions.NullComponentException;
import com.jwebmp.core.utilities.StaticStrings;
import com.jwebmp.guicedinjection.GuiceContext;
import com.jwebmp.logger.LogFactory;

import javax.validation.constraints.NotNull;
import java.util.*;

import static com.jwebmp.core.services.JWebMPServicesBindings.*;

/**
 * The Angular 1 Feature Implementation
 *
 * @author GedMarc
 * @since 16 Apr 2016
 */
public class AngularFeature
		extends Feature
		implements HTMLFeatures
{

	/**
	 * Field serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The logger for angular
	 */
	@SuppressWarnings("unused")
	private static final java.util.logging.Logger log = LogFactory.getInstance()
	                                                              .getLogger("AngularFeature");
	/**
	 * The name of this angular application
	 */
	private static String appName = "jwApp";
	/**
	 * The name of the default controller for this application (rendered last)
	 */
	private static String controllerName = "jwController";
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
	 * The linked page for this feature
	 */
	private final Page<?> page;

	/**
	 * Adds on the Angular ComponentFeatureBase to the application to allow full data binding
	 *
	 * @param component
	 * 		The page to be used
	 */
	public AngularFeature(Page<?> component)
	{
		this(component, AngularFeature.appName, AngularFeature.controllerName);
	}

	/**
	 * Adds on the Angular ComponentFeatureBase to the application to allow full data binding
	 *
	 * @param page
	 * 		The component to associate with
	 * @param applicationName
	 * 		The name of the application
	 * @param controllerName
	 * 		The name of the controller
	 */
	@SuppressWarnings("WeakerAccess")
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
			AngularFeature.setAppName(applicationName);
		}
		if (controllerName != null && !controllerName.isEmpty())
		{
			AngularFeature.setControllerName(controllerName);
		}
		setRenderAfterLoad(false);
	}

	/**
	 * Renders the JavaScript for this Builder
	 *
	 * @return An empty string builder
	 *
	 * @see com.jwebmp.core.base.ComponentFeatureBase#renderJavascript()
	 */
	@NotNull
	@Override
	public StringBuilder renderJavascript()
	{
		return new StringBuilder();
	}

	/**
	 * @see com.jwebmp.core.base.ComponentFeatureBase#preConfigure()
	 */
	@Override
	public void preConfigure()
	{
		if (!isConfigured())
		{
			getPage().getBody()
			         .addAttribute(AngularAttributes.ngApp, AngularFeature.getAppName());
			getPage().getBody()
			         .addAttribute(AngularAttributes.ngController, AngularFeature.controllerName + " as jwCntrl");
		}
		super.preConfigure();
	}

	/**
	 * Returns the page associated with this feature
	 *
	 * @return The associated page
	 */
	public Page<?> getPage()
	{
		return page;
	}

	/**
	 * Returns the application name associated
	 *
	 * @return The angular application name
	 */
	public static String getAppName()
	{
		return AngularFeature.appName;
	}

	/**
	 * Sets the angular application name associated
	 *
	 * @param appName
	 * 		Sets the app name
	 */
	public static void setAppName(String appName)
	{
		AngularFeature.appName = appName;
	}

	/**
	 * JW_APP_NAME - the angular module application name JW_DIRECTIVES - the angular directives JW_MODULES the modules generates
	 * JW_APP_CONTROLLER the physical controller name JW_CONTROLLERS - the
	 * controllers render part
	 * <p>
	 * Configures the base template variables. Override the method to add your own (keep call to super)
	 */
	public void configureTemplateVariables()
	{
		if (FileTemplates.getTemplateVariables()
		                 .get("PACE_TRACK_START") == null)
		{
			FileTemplates.getTemplateVariables()
			             .put("PACE_TRACK_START;", new StringBuilder(StaticStrings.STRING_EMPTY));
		}
		if (FileTemplates.getTemplateVariables()
		                 .get("PACE_TRACK_END") == null)
		{
			FileTemplates.getTemplateVariables()
			             .put("PACE_TRACK_END;", new StringBuilder(StaticStrings.STRING_EMPTY));
		}
		FileTemplates.getTemplateVariables()
		             .put("JW_APP_NAME", new StringBuilder(AngularFeature.getAppName()));
		FileTemplates.getTemplateVariables()
		             .put("JW_MODULES", new StringBuilder(compileModules()));
		FileTemplates.getTemplateVariables()
		             .put("JW_FACTORIES", new StringBuilder(compileFactories()));
		FileTemplates.getTemplateVariables()
		             .put("JW_CONFIGURATIONS", new StringBuilder(compileConfigurations()));
		FileTemplates.getTemplateVariables()
		             .put("JW_DIRECTIVES", new StringBuilder(compileDirectives()));
		FileTemplates.getTemplateVariables()
		             .put("JW_APP_CONTROLLER", new StringBuilder(AngularFeature.getControllerName()));
		FileTemplates.getTemplateVariables()
		             .put("JW_WATCHERS;", compileWatchers());

		FileTemplates.getTemplateVariables()
		             .put("CONTROLLER_INSERTIONS", new StringBuilder(compileControllerInsertions()));

		FileTemplates.getTemplateVariables()
		             .put("ANGULAR_CONFIG_FUNCTION ", new StringBuilder(compileControllerInsertions()));

		FileTemplates.getTemplateVariables()
		             .put("JW_CONTROLLERS", new StringBuilder(compileControllers()));
		FileTemplates.getTemplateVariables()
		             .put("jwangular", FileTemplates.compileTemplate(AngularFeature.class, "jwangular"));
	}

	/**
	 * compiles the global JW Angular Module, where the separate modules get listed inside of JWAngularModule
	 *
	 * @return The rendered modules
	 */
	@NotNull
	private StringBuilder compileModules()
	{
		StringBuilder output = new StringBuilder();
		List<AngularModuleBase> angulars = new ArrayList<>();
		angulars.add(jwAngularApp);
		angulars.forEach(module -> output.append(FileTemplates.compileTemplate(module.getReferenceName(), module.renderFunction())));
		return output;
	}

	/**
	 * Builds up the directives from all the present children
	 *
	 * @return The rendered factories
	 */
	@NotNull
	private StringBuilder compileFactories()
	{
		StringBuilder output = new StringBuilder();
		buildString(output, GuiceContext.get(AngularFactoryKey));
		return output;
	}

	/**
	 * Builds up the directives from all the present children
	 *
	 * @return The rendered configurations
	 */
	@NotNull
	private StringBuilder compileConfigurations()
	{
		StringBuilder output = new StringBuilder();
		buildString(output, GuiceContext.get(AngularConfigurationKey));
		return output;
	}

	/**
	 * Builds up the directives from all the present children
	 *
	 * @return The returned directives
	 */
	@NotNull
	private StringBuilder compileDirectives()
	{
		StringBuilder output = new StringBuilder();
		buildString(output, GuiceContext.get(AngularDirectivesKey));
		return output;
	}

	/**
	 * Gets the controller name for this controller
	 *
	 * @return The angular controller name
	 */
	public static String getControllerName()
	{
		return AngularFeature.controllerName;
	}

	/**
	 * Sets the controller name for this application
	 *
	 * @param controllerName
	 * 		Sets the controller name
	 */
	public static void setControllerName(String controllerName)
	{
		AngularFeature.controllerName = controllerName;
	}

	/**
	 * Adds variable watchers
	 *
	 * @return StringBuilder
	 */
	private StringBuilder compileWatchers()
	{
		StringBuilder output = new StringBuilder();
		getPage().getAngular()
		         .getAngularWatchers()
		         .forEach(module -> output.append(FileTemplates.compileTemplate("AngularWatchVariable" + module.getWatchName(), module.toString())));
		return output;
	}

	/**
	 * Creates the controller insertion
	 *
	 * @return The insertions under the global app controller
	 */
	@NotNull
	private StringBuilder compileControllerInsertions()
	{
		StringBuilder output = new StringBuilder();
		if (!getPage().getAngular()
		              .getControllerInsertions()
		              .isEmpty())
		{
			output.append(StaticStrings.STRING_COMMNA);
			getPage().getAngular()
			         .getControllerInsertions()
			         .forEach(a -> output.append(a)
			                             .append(StaticStrings.STRING_COMMNA));
			output.deleteCharAt(output.length() - 1);
		}
		return output;
	}

	/**
	 * Builds up the directives from all the present children
	 *
	 * @return The rendered controllers
	 */
	@NotNull
	private StringBuilder compileControllers()
	{
		StringBuilder output = new StringBuilder();
		Set<IAngularController> angulars = new TreeSet<>();
		ServiceLoader<IAngularController> loader = ServiceLoader.load(IAngularController.class);
		for (IAngularController item : loader)
		{
			angulars.add(item);
		}
		angulars.forEach(controller ->
		                 {
			                 String function = controller.renderFunction();
			                 StringBuilder outputString = FileTemplates.compileTemplate(controller.getReferenceName(), function);
			                 outputString.append(StaticStrings.STRING_NEWLINE_TEXT);
			                 output.append(outputString);
		                 });
		return output;
	}

	/**
	 * Method buildString loads the string builder for the given loader
	 *
	 * @param output
	 * 		of type StringBuilderW
	 */
	private void buildString(StringBuilder output, Set<? extends IAngularDefaultService> sortedList)
	{
		sortedList.forEach(item ->
		                   {
			                   String function = item.renderFunction();
			                   StringBuilder configurations = FileTemplates.compileTemplate(item.getReferenceName(), function);
			                   configurations.append(StaticStrings.STRING_NEWLINE_TEXT + StaticStrings.STRING_TAB);
			                   output.append(configurations);
		                   });
	}

	/**
	 * @see com.jwebmp.core.Feature#hashCode()
	 */
	@Override
	public int hashCode()
	{
		return Objects.hash(super.hashCode(), getJwAngularApp(), getJwAngularController(), getPage());
	}

	/**
	 * @see com.jwebmp.core.Feature#equals(Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		return super.equals(obj);
	}

	/**
	 * Any work that needs to get done pre render
	 */
	@Override
	public void assignFunctionsToComponent()
	{
		//Do Nothing Force Overide
	}

	/**
	 * Returns the physical angular application in use
	 *
	 * @return The assigned angular module
	 */
	@SuppressWarnings("WeakerAccess")
	@NotNull
	public final JWAngularModule getJwAngularApp()
	{
		return jwAngularApp;
	}

	/**
	 * Get the JW Angular Controller associated for this application
	 *
	 * @return The global controller
	 */
	@SuppressWarnings("WeakerAccess")
	@NotNull
	public final JWAngularController getJwAngularController()
	{
		return jwAngularController;
	}
}
