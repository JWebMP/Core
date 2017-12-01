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
import za.co.mmagon.FileTemplates;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.angular.controllers.AngularControllerBase;
import za.co.mmagon.jwebswing.base.angular.controllers.JWAngularController;
import za.co.mmagon.jwebswing.base.angular.directives.AngularDirectiveBase;
import za.co.mmagon.jwebswing.base.angular.factories.AngularFactoryBase;
import za.co.mmagon.jwebswing.base.angular.modules.AngularModuleBase;
import za.co.mmagon.jwebswing.base.angular.modules.JWAngularModule;
import za.co.mmagon.jwebswing.base.html.interfaces.HTMLFeatures;
import za.co.mmagon.jwebswing.exceptions.NullComponentException;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.utilities.StaticStrings;
import za.co.mmagon.logger.LogFactory;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static za.co.mmagon.jwebswing.utilities.StaticStrings.*;

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
	private static final java.util.logging.Logger log = LogFactory.getInstance().getLogger("AngularFeature");
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
	 * @param page
	 * 		The component to associate with
	 * @param applicationName
	 * 		The name of the application
	 * @param controllerName
	 * 		The name of the controller
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
	 * Compile the template
	 */
	@Override
	public void preConfigure()
	{
		if (!isConfigured() && getPage().getBody().readChildrenPropertyFirstResult(AngularPageConfigurator.AngularEnabledString, true))
		{
			getPage().getBody().addAttribute(AngularAttributes.ngApp, getAppName() + "");
			getPage().getBody().addAttribute(AngularAttributes.ngController, controllerName + " as jwCntrl");
			log.finer("Applied angular configuration to the page");
		}
		super.preConfigure();
	}

	/**
	 * Returns the page associated with this feature
	 *
	 * @return
	 */
	public Page getPage()
	{
		return page;
	}

	/**
	 * Returns an empty stringbuilder to not render any actual javascript
	 *
	 * @return
	 */
	@Override
	public StringBuilder renderJavascript()
	{
		return new StringBuilder();
	}

	/**
	 * JW_APP_NAME - the angular module application name JW_DIRECTIVES - the angular directives JW_MODULES the modules generates JW_APP_CONTROLLER the physical controller name JW_CONTROLLERS - the
	 * controllers render part
	 * <p>
	 * Configures the base template variables. Override the method to add your own (keep call to super)
	 */
	public void configureTemplateVariables()
	{
		FileTemplates.getTemplateVariables().put("JW_APP_NAME", new StringBuilder(getAppName()));
		FileTemplates.getTemplateVariables().put("JW_MODULES", new StringBuilder(compileModules()));
		FileTemplates.getTemplateVariables().put("JW_FACTORIES", new StringBuilder(compileFactories()));
		FileTemplates.getTemplateVariables().put("JW_DIRECTIVES", new StringBuilder(compileDirectives()));
		FileTemplates.getTemplateVariables().put("JW_APP_CONTROLLER", new StringBuilder(getControllerName()));

		FileTemplates.getTemplateVariables().put("//%CONTROLLER_INSERTIONS%", new StringBuilder(compileControllerInsertions()));

		FileTemplates.getTemplateVariables().put("JW_CONTROLLERS", new StringBuilder(compileControllers()));
		FileTemplates.getTemplateVariables().put("jwangular", FileTemplates.compileTemplate(AngularFeature.class, "jwangular"));
	}

	/**
	 * compiles the global JW Angular Module, where the separate modules get listed inside of JWAngularModule
	 *
	 * @return
	 */
	@NotNull
	public StringBuilder compileModules()
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
	 * @return
	 */
	@NotNull
	public StringBuilder compileFactories()
	{
		StringBuilder output = new StringBuilder();
		List<AngularFactoryBase> angulars = new ArrayList<>();
		angulars.addAll(getPage().getAngular().getAngularFactories());
		angulars.forEach(directive ->
		                 {
			                 String function = directive.renderFunction();
			                 StringBuilder outputString = FileTemplates.compileTemplate(directive.getReferenceName(), function);
			                 outputString.append(STRING_NEWLINE_TEXT + STRING_TAB);
			                 output.append(outputString);
		                 });
		return output;
	}

	/**
	 * Builds up the directives from all the present children
	 *
	 * @return
	 */
	@NotNull
	public StringBuilder compileDirectives()
	{
		StringBuilder output = new StringBuilder();
		List<AngularDirectiveBase> angulars = new ArrayList<>();
		angulars.addAll(getPage().getAngular().getAngularDirectives());
		angulars.forEach(directive ->
		                 {
			                 String function = directive.renderFunction();
			                 StringBuilder outputString = FileTemplates.compileTemplate(directive.getReferenceName(), function);
			                 outputString.append(getNewLine() + StaticStrings.STRING_TAB);
			                 output.append(outputString);
		                 });
		return output;
	}

	/**
	 * Creates the controller insertion
	 *
	 * @return
	 */
	@NotNull
	public StringBuilder compileControllerInsertions()
	{
		StringBuilder output = new StringBuilder();
		if (!getPage().getAngular().getControllerInsertions().isEmpty())
		{
			output.append(STRING_COMMNA);
			getPage().getAngular().getControllerInsertions().stream().forEach(a -> output.append(a).append(STRING_COMMNA));
			output.deleteCharAt(output.length() - 1);
		}
		return output;
	}

	/**
	 * Builds up the directives from all the present children
	 *
	 * @return
	 */
	@NotNull
	public StringBuilder compileControllers()
	{
		StringBuilder output = new StringBuilder();
		List<AngularControllerBase> angulars = new ArrayList<>();
		angulars.add(jwAngularController);
		angulars.addAll(getPage().getAngular().getAngularControllers());
		angulars.forEach(controller ->
		                 {
			                 String function = controller.renderFunction();
			                 StringBuilder outputString = FileTemplates.compileTemplate(controller.getReferenceName(), function);
			                 outputString.append(STRING_NEWLINE_TEXT);
			                 output.append(outputString);
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

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof AngularFeature))
		{
			return false;
		}
		if (!super.equals(o))
		{
			return false;
		}
		AngularFeature that = (AngularFeature) o;
		return Objects.equals(getJwAngularApp(), that.getJwAngularApp()) &&
				       Objects.equals(getJwAngularController(), that.getJwAngularController()) &&
				       Objects.equals(getPage(), that.getPage());
	}

	/**
	 * Returns the physical angular application in use
	 *
	 * @return
	 */
	@NotNull
	public final JWAngularModule getJwAngularApp()
	{
		return jwAngularApp;
	}

	/**
	 * Get the JW Angular Controller associated for this application
	 *
	 * @return
	 */
	@NotNull
	public final JWAngularController getJwAngularController()
	{
		return jwAngularController;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(super.hashCode(), getJwAngularApp(), getJwAngularController(), getPage());
	}
}
