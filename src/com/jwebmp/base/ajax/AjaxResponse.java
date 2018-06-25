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
package com.jwebmp.base.ajax;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.inject.servlet.RequestScoped;
import com.jwebmp.Event;
import com.jwebmp.Feature;
import com.jwebmp.base.ComponentDependancyBase;
import com.jwebmp.base.ComponentHierarchyBase;
import com.jwebmp.base.ComponentStyleBase;
import com.jwebmp.base.references.CSSReference;
import com.jwebmp.base.references.JavascriptReference;
import com.jwebmp.htmlbuilder.javascript.JavaScriptPart;
import org.aspectj.lang.annotation.SuppressAjWarnings;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;
import java.util.Map.Entry;

/**
 * A response sent back to the client
 *
 * @author GedMarc
 * @since 27 Apr 2016
 */
@RequestScoped
public class AjaxResponse<J extends AjaxResponse<J>>
		extends JavaScriptPart<J>
{

	private static final long serialVersionUID = 1L;

	/**
	 * Whether or not the response is a success or not
	 */
	@JsonProperty("success")
	private boolean success = true;

	/**
	 * All angular variable updates to be performed
	 */
	@JsonProperty("variables")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Set<AngularJsonVariable> angularVariables;

	/**
	 * All relevant client reactions to perform
	 */
	@JsonProperty("reactions")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Set<AjaxResponseReaction> reactions;

	/**
	 * All components that must be updated
	 */
	@JsonIgnore
	private Set<ComponentHierarchyBase> components;

	/**
	 * A complete list of the component update objects
	 */
	@JsonIgnore
	private Set<AjaxComponentUpdates> componentUpdates;

	/**
	 * An additional list of events that can fire, not stored in memory
	 */
	@JsonIgnore
	private Set<Event> events;

	/**
	 * An additional list of features that can fire
	 */
	@JsonIgnore
	private Set<Feature<?, ?>> features;

	/**
	 * A list of local storage items and their keys
	 */
	private Map<String, String> localStorage;

	/**
	 * A list of local storage items and their keys
	 */
	private Map<String, String> sessionStorage;

	/**
	 * Returns all the feature queries for the given response
	 *
	 * @return
	 */
	@JsonProperty("features")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@SuppressWarnings("unused")
	protected Set<String> getFeatureQueries()
	{
		Set<String> list = new LinkedHashSet<>();
		getFeatures().forEach(feature ->
		                      {
			                      feature.preConfigure();
			                      list.add(feature.renderJavascript()
			                                      .toString());
		                      });
		return list;
	}

	/**
	 * Gets features assigned to the response
	 *
	 * @return
	 */
	public Set<Feature<?, ?>> getFeatures()
	{
		if (features == null)
		{
			features = new TreeSet<>();
		}
		return features;
	}

	/**
	 * Sets features assigned to the response
	 *
	 * @param features
	 */
	public void setFeatures(Set<Feature<?, ?>> features)
	{
		this.features = features;
	}

	/**
	 * Adds a DTO to the response call
	 *
	 * @param name
	 * 		The name of the variable
	 * @param object
	 * 		The DTO to pass through
	 */
	public void addDto(String name, String object)
	{
		AngularJsonVariable variable = new AngularJsonVariable(name, object);
		getAngularVariables().add(variable);
	}

	/**
	 * Returns the list of angular variables from the server
	 *
	 * @return
	 */
	public Set<AngularJsonVariable> getAngularVariables()
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
	public void setAngularVariables(Set<AngularJsonVariable> angularVariables)
	{
		this.angularVariables = angularVariables;
	}

	/**
	 * If the server action was a success
	 *
	 * @return
	 */
	public boolean isSuccess()
	{
		return success;
	}

	/**
	 * If the server action was a success, default is no
	 *
	 * @param success
	 */
	public void setSuccess(boolean success)
	{
		this.success = success;
	}

	/**
	 * Adds a component to be returned to the client
	 *
	 * @param component
	 *
	 * @return
	 */
	public AjaxComponentUpdates addComponent(ComponentHierarchyBase component)
	{
		getComponents().add(component);
		AjaxComponentUpdates newComponent = new AjaxComponentUpdates(component);
		getComponentUpdates().add(newComponent);
		return newComponent;
	}

	/**
	 * Returns the list of components sending back
	 *
	 * @return
	 */
	public Set<ComponentHierarchyBase> getComponents()
	{
		if (components == null)
		{
			components = new TreeSet<>();
		}
		return components;
	}

	/**
	 * Returns a list of the needed component updates
	 *
	 * @return
	 */
	public Set<AjaxComponentUpdates> getComponentUpdates()
	{
		if (componentUpdates == null)
		{
			componentUpdates = new LinkedHashSet<>();
		}
		return componentUpdates;
	}

	/**
	 * Adds a client reaction to be performed
	 *
	 * @param reaction
	 */
	@SuppressAjWarnings("unchecked")
	@NotNull
	public J addReaction(AjaxResponseReaction reaction)
	{
		getReactions().add(reaction);
		return (J) this;
	}

	/**
	 * Returns the list of client reactions available
	 *
	 * @return
	 */
	public Set<AjaxResponseReaction> getReactions()
	{
		if (reactions == null)
		{
			reactions = new LinkedHashSet<>();
		}
		return reactions;
	}

	/**
	 * Returns all the event queries from the components
	 *
	 * @return
	 */
	@JsonProperty("events")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected Set<String> getEventQueries()
	{
		Set<String> list = new LinkedHashSet<>();
		getEvents().forEach(event -> list.add(event.renderJavascript()
		                                           .toString()));
		return list;
	}

	/**
	 * Gets events assigned to the response
	 *
	 * @return
	 */
	public Set<Event> getEvents()
	{
		if (events == null)
		{
			events = new TreeSet<>();
		}
		return events;
	}

	/**
	 * Sets events assigned to the response
	 *
	 * @param events
	 */
	public void setEvents(Set<Event> events)
	{
		this.events = events;
	}

	/**
	 * Gets all the CSS References
	 *
	 * @return
	 */
	@JsonProperty("cssLinks")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected Set<String> getAllCssReferences()
	{
		Set<String> output = new LinkedHashSet<>();
		getComponents().forEach(next ->
		                        {
			                        if (ComponentDependancyBase.class.isAssignableFrom(next.getClass()))
			                        {
				                        output.addAll(getCssReferences(next));
			                        }
		                        });
		return output;
	}

	/**
	 * Returns all the CSS references for all the components
	 *
	 * @param component
	 *
	 * @return
	 */
	public Set<String> getCssReferences(ComponentDependancyBase component)
	{
		Set<String> cssRender = new TreeSet<>();
		for (Object o : component.getCssReferencesAll())
		{
			CSSReference next = (CSSReference) o;
			cssRender.add(next.toString());
		}
		return cssRender;
	}

	/**
	 * Gets all the CSS Renders
	 *
	 * @return
	 */
	@JsonProperty("css")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected String getAllCss()
	{
		StringBuilder sb = new StringBuilder();
		getComponents().forEach(next -> sb.append(getCssRenders(ComponentStyleBase.class.cast(next))));
		return sb.toString();
	}

	/**
	 * Gets all the CSS renders for a component and its children
	 *
	 * @param component
	 *
	 * @return
	 */
	public StringBuilder getCssRenders(ComponentStyleBase component)
	{
		StringBuilder cssRender = new StringBuilder();
		cssRender.append(component.renderCss(0)
		                          .toString());
		return cssRender;
	}

	/**
	 * Gets all the JavaScript References
	 *
	 * @return
	 */
	@JsonProperty("jsReferences")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected Set<String> getAllJsReferences()
	{
		Set<String> output = new LinkedHashSet<>();
		getComponents().forEach(next ->
		                        {
			                        for (String a : getJsReferences(next))
			                        {
				                        output.add(a);
			                        }
		                        });
		return output;
	}

	/**
	 * Gets all JavaScript references for a component and it's children
	 *
	 * @param component
	 *
	 * @return
	 */
	public Set<String> getJsReferences(ComponentDependancyBase component)
	{
		Set<String> cssRender = new LinkedHashSet<>();
		for (Object o : component.getJavascriptReferencesAll())
		{
			JavascriptReference next = (JavascriptReference) o;
			cssRender.add(next.toString());
		}
		return cssRender;
	}

	/**
	 * Gets all the JavaScript and inserts it into the JSON response
	 *
	 * @return
	 */
	@JsonProperty("jsScripts")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected Set<String> getAllJsScripts()
	{
		Set<String> output = new LinkedHashSet<>();
		getComponents().forEach(next ->
		                        {
			                        getJsRenders(next).forEach(rendered ->
			                                                   {
				                                                   if (!rendered.isEmpty())
				                                                   {
					                                                   if (!rendered.endsWith(next.getNewLine()))
					                                                   {
						                                                   rendered = rendered + next.getNewLine();
					                                                   }
					                                                   output.add(rendered);
				                                                   }
			                                                   });
			                        //Load on demand scripts
			                        buildEventQueries(next, output);
		                        });
		return output;
	}

	/**
	 * Gets all the JavaScript to render for a component and its children
	 *
	 * @param component
	 *
	 * @return
	 */
	public Set<String> getJsRenders(ComponentHierarchyBase component)
	{
		Set<String> jsRenders = new LinkedHashSet<>();
		jsRenders.add(component.renderJavascriptAll()
		                       .toString());
		return jsRenders;
	}

	private Set<String> buildEventQueries(ComponentHierarchyBase next, Set<String> output)
	{
		if (Event.class.isAssignableFrom(next.getClass()))
		{
			for (Object o : Event.class.cast(next)
			                           .getRunEvents())
			{
				Event next1 = (Event) o;
				next1.preConfigure();
				addEventQuery(next1, output);
			}
		}
		return output;
	}

	private void addEventQuery(Event next1, Set<String> output)
	{
		next1.preConfigure();
		for (Object o : next1.getQueriesAll())
		{
			StringBuilder query = (StringBuilder) o;
			output.add(query.toString());
		}
	}

	/**
	 * Removes the registered variable from the client. Use to clean up memory or assigned variables on the client
	 *
	 * @param variable
	 */
	public void clearVariable(AngularJsonVariable variable)
	{
		if (variable != null)
		{
			variable.setVariableText(null);
			variable.setVariable(null);
			getAngularVariables().add(variable);
		}
	}

	/**
	 * Removes the registered variable from the client. Use to clean up memory or assigned variables on the client
	 *
	 * @param variableName
	 */
	public void clearVariable(String variableName)
	{
		AngularJsonVariable var = new AngularJsonVariable(variableName, (JavaScriptPart) null);
		getAngularVariables().add(var);
	}

	/**
	 * Returns the updates
	 *
	 * @return
	 */
	@JsonProperty("components")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected Set<AjaxComponentUpdates> getUpdates()
	{
		return getComponentUpdates();
	}

	@Override
	@SuppressWarnings("unchecked")
	public String toString()
	{
		for (ComponentHierarchyBase component : getComponents())
		{
			for (Object o : component.getAngularObjectsAll()
			                         .entrySet())
			{
				Entry<String, Serializable> object = (Entry<String, Serializable>) o;
				String key = object.getKey();
				Serializable value = object.getValue();
				addDto(key, value);
			}
		}
		return super.toString();
	}

	/**
	 * Adds a DTO to the response call
	 *
	 * @param name
	 * 		The name of the variable
	 * @param object
	 * 		The DTO to pass through
	 */
	public void addDto(String name, Serializable object)
	{
		AngularJsonVariable variable = new AngularJsonVariable(name, object);
		getAngularVariables().add(variable);
	}

	/**
	 * Returns the map going back for the local storage
	 *
	 * @return
	 */
	public Map<String, String> getLocalStorage()
	{
		if (localStorage == null)
		{
			localStorage = new HashMap<>();
		}
		return localStorage;
	}

	/**
	 * Sets the map for the local storage going back
	 *
	 * @param localStorage
	 */
	public void setLocalStorage(Map<String, String> localStorage)
	{
		this.localStorage = localStorage;
	}

	/**
	 * Gets the local session going back
	 *
	 * @return
	 */
	public Map<String, String> getSessionStorage()
	{
		if (sessionStorage == null)
		{
			sessionStorage = new HashMap<>();
		}
		return sessionStorage;
	}

	/**
	 * The session storage going back
	 *
	 * @param sessionStorage
	 */
	public void setSessionStorage(Map<String, String> sessionStorage)
	{
		this.sessionStorage = sessionStorage;
	}

}
