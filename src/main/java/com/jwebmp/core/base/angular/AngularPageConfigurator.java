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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.inject.Singleton;
import com.jwebmp.core.FileTemplates;
import com.jwebmp.core.Page;
import com.jwebmp.core.plugins.PluginInformation;
import com.jwebmp.core.plugins.jquery.JQueryPageConfigurator;
import com.jwebmp.core.services.IPageConfigurator;
import com.jwebmp.logger.LogFactory;

import javax.validation.constraints.NotNull;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 * @author GedMarc
 * @since 21 Feb 2017
 */
@SuppressWarnings({"WeakerAccess", "UnusedReturnValue", "unused"})
@PluginInformation(pluginName = "AngularJS",
		pluginDescription = "Angular 1x implementation",
		pluginUniqueName = "angular",
		pluginVersion = "1.6",
		pluginDependancyUniqueIDs = "jquery",
		pluginCategories = "jquery, angular, data-binding, ng," + "google",
		pluginGitUrl = "https://github.com/GedMarc/JWebSwing",
		pluginSourceUrl = "https://angularjs.org",
		pluginWikiUrl = "https://github.com/GedMarc/JWebSwing/wiki",
		pluginOriginalHomepage = "https://angularjs.org",
		pluginDownloadUrl = "https://angularjs.org/",
		pluginIconImageUrl = "https://angularjs.org/img/AngularJS-large.png",
		pluginLastUpdatedDate = "2017/03/30")
@Singleton
public class AngularPageConfigurator
		implements IPageConfigurator
{
	private static final Logger log = LogFactory.getLog("Angular Page Configurator");
	/**
	 * If the angular functionality is require or not
	 */
	private static boolean required;
	@SuppressWarnings("unused")
	private static boolean angularMessagesRequired;

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
	 * A set of event data event watchers
	 */
	private Set<AngularVariableWatcher> angularWatchers;

	/**
	 * Configures the angular page
	 */
	public AngularPageConfigurator()
	{
		//No config required
	}

	/**
	 * If the configurator is required
	 *
	 * @return If it is required to render
	 */
	public static boolean isRequired()
	{
		return required;
	}

	/**
	 * Sets angular as a required component
	 *
	 * @param required If it is required to render
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
	public Integer sortOrder()
	{
		return Integer.MAX_VALUE - 100;
	}

	@NotNull
	@Override
	@SuppressWarnings("unchecked")
	public Page configure(Page page)
	{
		if (required)
		{
			page.getBody()
			    .addJavaScriptReference(AngularReferencePool.Angular1.getJavaScriptReference());
			page.getBody()
			    .addJavaScriptReference(AngularReferencePool.Angular1NGMessages.getJavaScriptReference());
			page.getBody()
			    .addAttribute(AngularAttributes.ngApp, AngularFeature.getAppName());
			page.getBody()
			    .addAttribute(AngularAttributes.ngController, AngularFeature.getControllerName() + " as jwCntrl");
		}
		return page;
	}

	/**
	 * Returns the list of angular variables
	 *
	 * @return A list of assigned angular variables
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
	 * @param angularVariables A list of assigned angular variables
	 */
	public AngularPageConfigurator setAngularVariables(@NotNull Set<String> angularVariables)
	{
		this.angularVariables = angularVariables;
		return this;
	}

	/**
	 * Renders the complete angular javascript with the variables configured
	 *
	 * @param page The page to render for
	 *
	 * @return The string builder object
	 */
	@NotNull
	public StringBuilder renderAngularJavascript(Page page)
	{
		StringBuilder sb = new StringBuilder();
		AngularFeature af = new AngularFeature(page);
		af.configureTemplateVariables();
		sb.append(FileTemplates.renderTemplateScripts("jwangular"));
		log.finest("Rendering the angular script");
		return sb;
	}

	/**
	 * Returns the list of controller insertions
	 *
	 * @return A set of controller insertions
	 */
	@NotNull
	public Set<String> getControllerInsertions()
	{
		if (controllerInsertions == null)
		{
			controllerInsertions = new LinkedHashSet<>();
		}
		return controllerInsertions;
	}

	/**
	 * Sets the list of controller insertions
	 *
	 * @param controllerInsertions A set of controller insertions
	 */
	public AngularPageConfigurator setControllerInsertions(@NotNull Set<String> controllerInsertions)
	{
		this.controllerInsertions = controllerInsertions;
		return this;
	}


	/**
	 * Gets the list of angular watchers
	 *
	 * @return A set of variable watchers assigned
	 */
	public Set<AngularVariableWatcher> getAngularWatchers()
	{
		if (angularWatchers == null)
		{
			angularWatchers = new LinkedHashSet<>();
		}
		return angularWatchers;
	}

	/**
	 * Gets the list of angular watchers
	 *
	 * @param angularWatchers A set of variable watchers assigned
	 */
	public AngularPageConfigurator setAngularWatchers(@NotNull Set<AngularVariableWatcher> angularWatchers)
	{
		this.angularWatchers = angularWatchers;
		return this;
	}
}
