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
package com.jwebmp.core.base.ajax;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.inject.servlet.RequestScoped;
import com.guicedee.guicedservlets.services.scopes.CallScope;
import com.jwebmp.core.Event;
import com.jwebmp.core.Feature;
import com.jwebmp.core.base.interfaces.IComponentDependencyBase;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.interfaces.IComponentStyleBase;
import com.jwebmp.core.base.references.CSSReference;
import com.jwebmp.core.base.references.JavascriptReference;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import jakarta.validation.constraints.NotNull;

import java.util.*;
import java.util.Map.Entry;

/**
 * A response sent back to the client
 *
 * @author GedMarc
 * @since 27 Apr 2016
 */
@SuppressWarnings("MissingClassJavaDoc")
@CallScope
public class AjaxResponse<J extends AjaxResponse<J>>
		extends JavaScriptPart<J>
{
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
	private Set<JsonVariable> jsonVariables;
	
	/**
	 * All relevant client reactions to perform
	 */
	@JsonProperty("reactions")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Set<AjaxResponseReaction<?>> reactions;
	
	/**
	 * All components that must be updated
	 */
	@JsonIgnore
	private Set<IComponentHierarchyBase<?, ?>> components;
	
	/**
	 * A complete list of the component update objects
	 */
	@JsonIgnore
	private Set<AjaxComponentUpdates<?>> componentUpdates;
	
	/**
	 * An additional list of events that can fire, not stored in memory
	 */
	@JsonIgnore
	private Set<Event<?, ?>> events;
	
	/**
	 * An additional list of features that can fire
	 */
	@JsonIgnore
	private Set<Feature<?, ?, ?>> features;
	
	/**
	 * A list of local storage items and their keys
	 */
	private Map<String, String> localStorage;
	
	/**
	 * A list of local storage items and their keys
	 */
	private Map<String, String> sessionStorage;
	
	private Map<String, String> properties = new HashMap<>();
	
	
	public Map<String, String> getProperties()
	{
		return properties;
	}
	
	/**
	 * Sets the properties for this response
	 * @param properties
	 * @return
	 */
	public AjaxResponse<J> setProperties(Map<String, String> properties)
	{
		this.properties = properties;
		return this;
	}
	
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
	public Set<Feature<?, ?, ?>> getFeatures()
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
	public void setFeatures(Set<Feature<?, ?, ?>> features)
	{
		this.features = features;
	}
	
	/**
	 * Adds a DTO to the response call
	 *
	 * @param name   The name of the variable
	 * @param object The DTO to pass through
	 */
	public void addDto(String name, String object)
	{
		JsonVariable variable = new JsonVariable(name, object);
		getJsonVariables().add(variable);
	}
	
	/**
	 * Returns the list of angular variables from the server
	 *
	 * @return
	 */
	public Set<JsonVariable> getJsonVariables()
	{
		if (jsonVariables == null)
		{
			jsonVariables = new LinkedHashSet<>();
		}
		return jsonVariables;
	}
	
	/**
	 * Sets the list of angular variables
	 *
	 * @param jsonVariables
	 */
	public void setJsonVariables(Set<JsonVariable> jsonVariables)
	{
		this.jsonVariables = jsonVariables;
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
	 * Convenience method to add a feature to the feature group
	 *
	 * @param feature The feature to add
	 * @return J Always this
	 */
	@SuppressWarnings("unchecked")
	public J addFeature(Feature<?, ?, ?> feature)
	{
		getFeatures().add(feature);
		return (J) this;
	}
	
	/**
	 * Adds a component to be returned to the client
	 *
	 * @param component
	 * @return
	 */
	public AjaxComponentUpdates<?> addComponent(IComponentHierarchyBase<?, ?> component)
	{
		for (Iterator<IComponentHierarchyBase<?, ?>> iterator = getComponents().iterator(); iterator.hasNext(); )
		{
			IComponentHierarchyBase<?, ?> iComponentHierarchyBase = iterator.next();
			if (iComponentHierarchyBase.getID()
			                           .equals(component.getID()))
			{
				iterator.remove();
				break;
			}
		}
		getComponents().add(component);
		AjaxComponentUpdates<?> newComponent = new AjaxComponentUpdates<>(component);
		getComponentUpdates().add(newComponent);
		return newComponent;
	}
	
	/**
	 * Returns the list of components sending back
	 *
	 * @return
	 */
	protected Set<IComponentHierarchyBase<?, ?>> getComponents()
	{
		if (components == null)
		{
			components = new LinkedHashSet<>();
		}
		return components;
	}
	
	protected void setComponents(Set<IComponentHierarchyBase<?, ?>> components)
	{
		this.components = components;
	}
	
	/**
	 * Returns a list of the needed component updates
	 *
	 * @return
	 */
	public Set<AjaxComponentUpdates<?>> getComponentUpdates()
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
	@SuppressWarnings("unchecked")
	@NotNull
	public J addReaction(AjaxResponseReaction<?> reaction)
	{
		getReactions().add(reaction);
		return (J) this;
	}
	
	/**
	 * Returns the list of client reactions available
	 *
	 * @return
	 */
	public Set<AjaxResponseReaction<?>> getReactions()
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
	public Set<Event<?, ?>> getEvents()
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
	public void setEvents(Set<Event<?, ?>> events)
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
		getComponents().forEach(next -> output.addAll(getCssReferences((IComponentDependencyBase<?>) next)));
		return output;
	}
	
	/**
	 * Returns all the CSS references for all the components
	 *
	 * @param component
	 * @return
	 */
	public Set<String> getCssReferences(IComponentDependencyBase<?> component)
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
		List<IComponentHierarchyBase<?, ?>> workable = new ArrayList<>(getComponents());
		workable.forEach(next -> sb.append(getCssRenders((IComponentStyleBase<?>) next)));
		
		return sb.toString();
	}
	
	/**
	 * Gets all the CSS renders for a component and its children
	 *
	 * @param component
	 * @return
	 */
	public StringBuilder getCssRenders(IComponentStyleBase<?> component)
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
		getComponents().forEach(next -> output.addAll(getJsReferences((IComponentDependencyBase<?>) next)));
		return output;
	}
	
	/**
	 * Gets all JavaScript references for a component and it's children
	 *
	 * @param component
	 * @return
	 */
	public Set<String> getJsReferences(IComponentDependencyBase<?> component)
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
					                                                   if (!rendered.endsWith(next.asBase()
					                                                                              .getNewLine()))
					                                                   {
						                                                   rendered = rendered + next.asBase()
						                                                                             .getNewLine();
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
	 * @return
	 */
	@SuppressWarnings("WeakerAccess")
	public Set<String> getJsRenders(IComponentHierarchyBase<?, ?> component)
	{
		Set<String> jsRenders = new LinkedHashSet<>();
		for (IComponentHierarchyBase<?, ?> componentHierarchyBase : component.getChildrenHierarchy())
		{
			for (StringBuilder stringBuilder : componentHierarchyBase.getQueriesAll())
			{
				if (!stringBuilder.toString()
				                  .isEmpty())
				{
					String string = stringBuilder.toString();
					string = string.replace("\n", "");
					string = string.replace("\t", "");
					string = string.replace("  ", "");
					jsRenders.add(string);
				}
			}
		}
		return jsRenders;
	}
	
	private Set<String> buildEventQueries(IComponentHierarchyBase<?, ?> next, Set<String> output)
	{
		if (Event.class.isAssignableFrom(next.getClass()))
		{
			//noinspection RedundantClassCall
			for (Object o : Event.class.cast(next)
			                           .getRunEvents())
			{
				Event<?, ?> next1 = (Event<?, ?>) o;
				next1.preConfigure();
				addEventQuery(next1, output);
			}
		}
		return output;
	}
	
	private void addEventQuery(Event<?, ?> next1, Set<String> output)
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
	public void clearVariable(JsonVariable variable)
	{
		if (variable != null)
		{
			variable.setVariableText(null);
			variable.setVariable(null);
			getJsonVariables().add(variable);
		}
	}
	
	/**
	 * Removes the registered variable from the client. Use to clean up memory or assigned variables on the client
	 *
	 * @param variableName
	 */
	public void clearVariable(String variableName)
	{
		JsonVariable var = new JsonVariable(variableName, (JavaScriptPart<?>) null);
		getJsonVariables().add(var);
	}
	
	/**
	 * Returns the updates
	 *
	 * @return
	 */
	@JsonProperty("components")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected Set<AjaxComponentUpdates<?>> getUpdates()
	{
		return getComponentUpdates();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public String toString()
	{
		for (IComponentHierarchyBase<?, ?> component : getComponents())
		{
			for (Object o : component.getAngularObjectsAll()
			                         .entrySet())
			{
				Entry<String, Object> object = (Entry<String, Object>) o;
				String key = object.getKey();
				Object value = object.getValue();
				addDto(key, value);
			}
		}
		return super.toString();
	}
	
	/**
	 * Adds a DTO to the response call
	 *
	 * @param name   The name of the variable
	 * @param object The DTO to pass through
	 */
	public void addDto(String name, Object object)
	{
		JsonVariable variable = new JsonVariable(name, object);
		getJsonVariables().add(variable);
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
