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
import com.google.inject.Singleton;
import za.co.mmagon.FileTemplates;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.PageConfigurator;
import za.co.mmagon.jwebswing.base.angular.configurations.AngularConfigurationBase;
import za.co.mmagon.jwebswing.base.angular.controllers.AngularControllerBase;
import za.co.mmagon.jwebswing.base.angular.directives.AngularDirectiveBase;
import za.co.mmagon.jwebswing.base.angular.factories.AngularFactoryBase;
import za.co.mmagon.jwebswing.base.angular.modules.AngularMessagesModule;
import za.co.mmagon.jwebswing.base.angular.modules.AngularModuleBase;
import za.co.mmagon.jwebswing.plugins.PluginInformation;
import za.co.mmagon.jwebswing.plugins.jquery.JQueryPageConfigurator;
import za.co.mmagon.logger.LogFactory;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 * @author GedMarc
 * @since 21 Feb 2017
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
@Singleton
public class AngularPageConfigurator extends PageConfigurator
{

	public static final String AngularEnabledString = "angular-enabled";
	private static final Logger log = LogFactory.getLog("Angular Page Configurator");
	/**
	 * If the angular functionality is require or not
	 */
	private static boolean required;

	private static boolean angularMessagesRequired;

	private static final long serialVersionUID = 1L;
	/**
	 * All the angular modules for this component
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Set<AngularModuleBase> angularModules;
	/**
	 * All of the angular directives for this component
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Set<AngularDirectiveBase> angularDirectives;
	/**
	 * All of the angular directives for this component
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Set<AngularControllerBase> angularControllers;
	/**
	 * All of the angular directives for this component
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Set<AngularFactoryBase> angularFactories;

	/**
	 * All of the angular directives for this component
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Set<AngularConfigurationBase> angularConfigurations;

	/**
	 * All of the angular controller insertions for this component
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Set<String> controllerInsertions;

	/**
	 * All the angular variables
	 */
	private Set<String> angularVariables;

	/**
	 * Configures the angular page
	 */
	@SuppressWarnings("")
	public AngularPageConfigurator()
	{
		setSortOrder(99999999); //Always dead last
	}

	/**
	 * Sets angular as a required component
	 *
	 * @param required
	 */
	@SuppressWarnings("unchecked")
	public static void setRequired(boolean required)
	{
		AngularPageConfigurator.required = required;
		if (required)
		{
			JQueryPageConfigurator.setRequired(true);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public Page configure(Page page)
	{
		if (!page.isConfigured())
		{
			if (required)
			{
				page.getBody().getJavascriptReferences().add(AngularReferencePool.Angular1.getJavaScriptReference());
				if (angularMessagesRequired)
				{
					page.getBody().getJavascriptReferences().add(AngularReferencePool.Angular1NGMessages.getJavaScriptReference());
				}
				page.getBody().addAttribute(AngularAttributes.ngApp, AngularFeature.getAppName());
				page.getBody().addAttribute(AngularAttributes.ngController, AngularFeature.getControllerName() + " as jwCntrl");
			}
		}
		else
		{
			log.finer("Page is already configured, angular not added this time round");
		}
		return page;
	}

	/**
	 * Gets a list of angular modules
	 *
	 * @return
	 */
	@NotNull
	public Set<AngularModuleBase> getAngularModules()
	{
		if (angularModules == null)
		{
			setAngularModules(new LinkedHashSet<>());
			if (angularMessagesRequired)
			{
				angularModules.add(new AngularMessagesModule());
			}
		}
		return angularModules;
	}

	/**
	 * Sets the angular modules
	 *
	 * @param angularModules
	 */
	public void setAngularModules(@NotNull Set<AngularModuleBase> angularModules)
	{
		this.angularModules = angularModules;
	}

	/**
	 * Gets the list of angular directives
	 *
	 * @return
	 */
	@NotNull
	public Set<AngularDirectiveBase> getAngularDirectives()
	{
		if (angularDirectives == null)
		{
			setAngularDirectives(new LinkedHashSet<>());

		}
		return angularDirectives;
	}

	/**
	 * Sets the list of angular directives.
	 *
	 * @param angularDirectives
	 */
	public void setAngularDirectives(@NotNull Set<AngularDirectiveBase> angularDirectives)
	{
		this.angularDirectives = angularDirectives;
	}

	/**
	 * Returns a list of all the angular controllers for this component
	 *
	 * @return
	 */
	@NotNull
	public Set<AngularControllerBase> getAngularControllers()
	{
		if (angularControllers == null)
		{
			setAngularControllers(new LinkedHashSet<>());

		}
		return angularControllers;
	}

	/**
	 * Sets the list of angular controllers for this component
	 *
	 * @param angularControllers
	 */
	public void setAngularControllers(@NotNull Set<AngularControllerBase> angularControllers)
	{
		this.angularControllers = angularControllers;
	}

	/**
	 * Returns the list of angular variables
	 *
	 * @return
	 */
	@NotNull
	public Set<String> getAngularVariables()
	{
		if (angularVariables == null)
		{
			angularVariables = new LinkedHashSet<>();
		}
		return angularVariables;
	}

	/**
	 * Sets the list of angular variables
	 *
	 * @param angularVariables
	 */
	public void setAngularVariables(@NotNull Set<String> angularVariables)
	{
		this.angularVariables = angularVariables;
	}

	/**
	 * Renders the complete angular javascript with the variables configured
	 *
	 * @param page
	 *
	 * @return
	 */
	@NotNull
	public StringBuilder renderAngularJavascript(Page page)
	{
		StringBuilder sb = new StringBuilder();
		AngularFeature af = new AngularFeature(page);
		af.configureTemplateVariables();
		sb.append(FileTemplates.renderTemplateScripts("jwangular"));
		return sb;
	}

	/**
	 * Returns a list of factories
	 *
	 * @return
	 */
	@NotNull
	public Set<AngularFactoryBase> getAngularFactories()
	{
		if (angularFactories == null)
		{
			angularFactories = new LinkedHashSet<>();
		}
		return angularFactories;
	}

	/**
	 * Sets the list of angular factories
	 *
	 * @param angularFactories
	 */
	public void setAngularFactories(@NotNull Set<AngularFactoryBase> angularFactories)
	{
		this.angularFactories = angularFactories;
	}

	/**
	 * Returns the list of controller insertions
	 *
	 * @return
	 */
	@NotNull
	public Set<String> getControllerInsertions()
	{
		if (controllerInsertions == null)
		{
			this.controllerInsertions = new LinkedHashSet<>();
		}
		return controllerInsertions;
	}

	/**
	 * Sets the list of controller insertions
	 *
	 * @param controllerInsertions
	 */
	public void setControllerInsertions(@NotNull Set<String> controllerInsertions)
	{
		this.controllerInsertions = controllerInsertions;
	}

	/**
	 * Gets the Angular Configurations
	 *
	 * @return
	 */
	public Set<AngularConfigurationBase> getAngularConfigurations()
	{
		if (angularConfigurations == null)
		{
			angularConfigurations = new HashSet<>();
		}
		return angularConfigurations;
	}

	/**
	 * Sets the current angular configuration base
	 *
	 * @param angularConfigurations
	 */
	public void setAngularConfigurations(@NotNull Set<AngularConfigurationBase> angularConfigurations)
	{
		this.angularConfigurations = angularConfigurations;
	}

	/**
	 * If angular messages must be included
	 *
	 * @return
	 */
	public static boolean isAngularMessagesRequired()
	{
		return angularMessagesRequired;
	}

	/**
	 * If anuglar messages are required
	 *
	 * @param angularMessagesRequired
	 */
	public static void setAngularMessagesRequired(boolean angularMessagesRequired)
	{
		AngularPageConfigurator.angularMessagesRequired = angularMessagesRequired;
	}

	/**
	 * If the configurator is required
	 *
	 * @return
	 */
	public static boolean isRequired()
	{
		return required;
	}
}
