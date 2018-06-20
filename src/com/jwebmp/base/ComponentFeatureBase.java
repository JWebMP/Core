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
package com.jwebmp.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jwebmp.Feature;
import com.jwebmp.base.html.interfaces.AttributeDefinitions;
import com.jwebmp.base.html.interfaces.GlobalChildren;
import com.jwebmp.base.html.interfaces.GlobalFeatures;
import com.jwebmp.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.base.interfaces.IComponentFeatureBase;
import com.jwebmp.base.references.CSSReference;
import com.jwebmp.base.references.JavascriptReference;
import com.jwebmp.base.servlets.enumarations.ComponentTypes;
import com.jwebmp.base.servlets.enumarations.RequirementsPriority;
import com.jwebmp.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.logger.LogFactory;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;

import static com.jwebmp.utilities.StaticStrings.*;

/**
 * Allows a component to have features and events
 *
 * @param <F>
 * 		The allowed feature JavaScripts
 * @param <J>
 * 		Component output for cloning. Returned on CloneComponent
 *
 * @since 23 Apr 2016
 */
public class ComponentFeatureBase<F extends GlobalFeatures & Serializable, J extends ComponentFeatureBase<F, J>>
		extends ComponentDependancyBase<J>
		implements IComponentFeatureBase<F, J>, Comparator<J>, Comparable<J>
{

	/**
	 * Logger for the Component
	 */
	@JsonIgnore
	private static final java.util.logging.Logger LOG = LogFactory.getInstance()
	                                                              .getLogger("ComponentFeatureBase");
	/**
	 * Serial Version for all Components and their compatibility
	 *
	 * @version 2 Version 2 - Updated CSS Library and References
	 */
	@JsonIgnore
	private static final long serialVersionUID = 2L;
	/**
	 * A linked component if required
	 */
	@JsonIgnore
	private ComponentHierarchyBase component;
	/**
	 * The features of this component
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Set<F> features;
	/**
	 * The list of queries in this feature
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Set<StringBuilder> queries;
	/**
	 * The sort order for this feature
	 */
	private int sortOrder = 1000;
	/**
	 * The variables associated with this feature
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Set<String> variables;
	/**
	 * Name of this feature, not yet used anywhere.. Wondering on it's usefulness
	 */
	private String name;
	/**
	 * Whether this feature is rendered after load
	 */
	private boolean renderAfterLoad;
	/**
	 * The assigned priority for the given application
	 */
	private RequirementsPriority priority;

	/**
	 * Specifies if this components JavaScript is rendered somewhere else
	 */
	private boolean javascriptRenderedElsewhere;

	/**
	 * Constructs a new feature with the given name
	 *
	 * @param name
	 */
	public ComponentFeatureBase(@NotNull String name)
	{
		super(ComponentTypes.Feature);
		this.name = name;
		variables = new LinkedHashSet<>();
	}

	/**
	 * Constructs a new component that can have features
	 *
	 * @param componentType
	 */
	public ComponentFeatureBase(ComponentTypes componentType)
	{
		super(componentType);
	}

	/**
	 * Returns an Attribute Base interface of this component
	 *
	 * @return
	 */
	@SuppressWarnings({"unused"})
	@NotNull
	public IComponentFeatureBase asFeatureBase()
	{
		return this;
	}

	/**
	 * Adds in the JavaScript References for the Features
	 *
	 * @return
	 */
	@Override
	@NotNull
	public Set<CSSReference> getCssReferencesAll()
	{
		Set<CSSReference> allCss = super.getCssReferencesAll();
		getFeatures().forEach(feature ->
		                      {
			                      ComponentFeatureBase cfb = (ComponentFeatureBase) feature;
			                      for (Object css : cfb.getCssReferencesAll())
			                      {
				                      allCss.add(CSSReference.class.cast(css));
			                      }
		                      });
		return allCss;
	}

	/**
	 * Adds in the JavaScript References for the Features
	 *
	 * @return
	 */
	@Override
	@NotNull
	@SuppressWarnings("unchecked")
	public Set<JavascriptReference> getJavascriptReferencesAll()
	{
		Set<JavascriptReference> allJs = super.getJavascriptReferencesAll();
		getFeatures().forEach(feature ->
		                      {
			                      ComponentFeatureBase cfb = (ComponentFeatureBase) feature;
			                      for (Object js : cfb.getJavascriptReferencesAll())
			                      {
				                      allJs.add(JavascriptReference.class.cast(js));
			                      }
		                      });
		return allJs;
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		return super.equals(obj);
	}

	@Override
	public void destroy()
	{
		if (features != null)
		{
			features.clear();
			features = null;
		}
		if (queries != null)
		{
			queries.clear();
			queries = null;
		}
		if (variables != null)
		{
			variables.clear();
			variables = null;
		}
		super.destroy();
	}

	/**
	 * Adds a feature to the collection
	 *
	 * @param feature
	 *
	 * @return
	 */
	@Override
	@NotNull
	@SuppressWarnings("unchecked")
	public J addFeature(@NotNull ComponentFeatureBase feature)
	{
		if (!feature.getComponentType()
		            .equals(ComponentTypes.Feature))
		{
			LOG.log(Level.WARNING, "Tried to add a non-feature to the feature collection");
		}
		else
		{
			if (!getFeatures().contains(feature))
			{
				getFeatures().add((F) feature);
				if (ComponentHierarchyBase.class.isAssignableFrom(getClass()))
				{
					feature.setComponent((ComponentHierarchyBase) this);
				}
			}
		}
		return (J) this;
	}

	/**
	 * Adds a variable to the collection
	 *
	 * @param variable
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J addVariable(@NotNull String variable)
	{
		getVariables().add(variable);
		return (J) this;
	}

	/**
	 * Returns the name of this feature
	 *
	 * @return the name of this feature
	 */
	@Override
	@NotNull
	public String getName()
	{
		return name;
	}

	/**
	 * Sets the name of the feature
	 *
	 * @param name
	 * 		Sets the name of the feature
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J setName(@NotNull String name)
	{
		this.name = name;
		return (J) this;
	}

	/**
	 * Returns any client side options available with this component
	 *
	 * @return
	 */
	@Override
	public JavaScriptPart getOptions()
	{
		return null;
	}

	/**
	 * Gets the render priority of this feature
	 *
	 * @return
	 */
	@Override
	@NotNull
	public RequirementsPriority getPriority()
	{
		return priority;
	}

	/**
	 * Returns all Queries Associated with a component
	 *
	 * @return
	 */
	@Override
	@NotNull
	public Set<StringBuilder> getQueriesAll()
	{
		return getQueries();
	}

	/**
	 * Sets the sort order for this feature. Default 10000
	 *
	 * @return
	 */
	@Override
	@NotNull
	public Integer getSortOrder()
	{
		return sortOrder;
	}

	/**
	 * Gets the sort order for this feature Default 10000
	 *
	 * @param sortOrder
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public final J setSortOrder(int sortOrder)
	{
		this.sortOrder = sortOrder;
		return (J) this;
	}

	/**
	 * Returns the list of variables
	 *
	 * @return
	 */
	@Override
	@NotNull
	public Set<String> getVariables()
	{
		if (variables == null)
		{
			variables = new LinkedHashSet<>();
		}
		return variables;
	}

	/**
	 * Sets if this feature must be rendered in an $(document).ready statement
	 *
	 * @return
	 */
	@Override
	public boolean isRenderAfterLoad()
	{
		return renderAfterLoad;
	}

	/**
	 * Removes a feature from the components collection
	 * <p>
	 *
	 * @param feature
	 * 		The feature to be removed
	 * 		<p>
	 *
	 * @return True or false on whether it could be removed, e.g. if it ever existed.
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J removeFeature(F feature)
	{
		getFeatures().remove(feature);
		return (J) this;
	}

	/**
	 * Removes a variable from the collection
	 *
	 * @param variable
	 */
	@Override
	@SuppressWarnings("unchecked")
	public J removeVariable(@NotNull String variable)
	{
		getVariables().remove(variable);
		return (J) this;
	}

	/**
	 * Renders the JavaScript for this Builder
	 *
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public StringBuilder renderJavascript()
	{
		if (!isConfigured())
		{
			preConfigure();
		}
		StringBuilder sb = new StringBuilder();
		Set<String> allQueries = new LinkedHashSet<>();
		getQueriesAll().forEach(query ->
		                        {
			                        if (query != null)
			                        {
				                        String queryS = query.toString();
				                        if (!queryS.isEmpty())
				                        {
					                        allQueries.add(query.toString());
				                        }
			                        }
		                        });
		allQueries.forEach(query ->
		                   {
			                   if (!query.trim()
			                             .equals(STRING_NEWLINE_TEXT) && !sb.toString()
			                                                                .contains(query))
			                   {
				                   sb.append(query);
			                   }
		                   });
		return sb;
	}

	/**
	 * Specifies whether or not this feature actually contains some JavaScript lines or is just a link
	 *
	 * @return True if a script is located inside the feature
	 */
	@Override
	public boolean scriptAvailable()
	{
		return !getQueries().isEmpty();
	}

	/**
	 * Use Add Query to add a query to the container
	 */
	protected void assignFunctionsToComponent()
	{
		//Nothing needed to be here
	}

	/**
	 * Returns the queries
	 *
	 * @return
	 */
	@JsonProperty("queries")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@NotNull
	public Set<StringBuilder> getQueries()
	{
		if (queries == null)
		{
			queries = new LinkedHashSet<>();
		}
		return queries;
	}

	/**
	 * Sets if this feature must be rendered in an $(document).ready statement
	 *
	 * @param renderAfterLoad
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J setRenderAfterLoad(boolean renderAfterLoad)
	{
		this.renderAfterLoad = renderAfterLoad;
		return (J) this;
	}

	/**
	 * Sets the render priority of this feature
	 *
	 * @param priority
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J setPriority(@NotNull RequirementsPriority priority)
	{
		this.priority = priority;
		return (J) this;
	}

	/**
	 * Returns a list of all the features associated with this component
	 * <p>
	 *
	 * @return An ArrayList of features
	 */
	@NotNull
	public Set<F> getFeatures()
	{
		if (features == null)
		{
			features = new LinkedHashSet<>();
		}
		return features;
	}

	@Override
	public int compare(ComponentFeatureBase o1, ComponentFeatureBase o2)
	{
		if (o2 == null)
		{
			return -1;
		}
		return o1.getSortOrder()
		         .compareTo(o2.getSortOrder());
	}

	/**
	 * Sets all features beneath to tiny
	 *
	 * @param tiny
	 *
	 * @return
	 */
	@Override
	@Null
	@SuppressWarnings("unchecked")
	public J setTiny(boolean tiny)
	{
		for (F f : getFeatures())
		{
			ComponentFeatureBase next = (ComponentFeatureBase) f;
			next.setTiny(tiny);
		}
		return super.setTiny(tiny);
	}

	@Override
	public void preConfigure()
	{
		if (!isConfigured() && Feature.class.isAssignableFrom(getClass()))
		{
			assignFunctionsToComponent();
		}
		super.preConfigure();
	}

	/**
	 * Initialize all the features
	 */
	@Override
	public void init()
	{
		if (!isInitialized())
		{
			getFeatures().forEach(feature ->
			                      {
				                      ComponentFeatureBase cfb = (ComponentFeatureBase) feature;
				                      assignFunctionsToComponent();
				                      if (!cfb.isConfigured())
				                      {
					                      cfb.init();
					                      cfb.preConfigure();
					                      cfb.assignFunctionsToComponent();
				                      }
			                      });
		}
		super.init();
	}

	/**
	 * Adds a query to the object queue
	 *
	 * @param query
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J addQuery(@NotNull StringBuilder query)
	{
		for (StringBuilder existingQuery : getQueriesAll())
		{
			if (existingQuery.toString()
			                 .equalsIgnoreCase(query.toString()))
			{
				return (J) this;
			}
		}
		getQueries().add(query);
		return (J) this;
	}

	/**
	 * Returns if the JavaScript for this component is rendered elsewhere
	 *
	 * @return
	 */
	public boolean isJavascriptRenderedElsewhere()
	{
		return javascriptRenderedElsewhere;
	}

	/**
	 * Returns if the JavaScript for this component is rendered elsewhere
	 *
	 * @param javascriptRenderedElsewhere
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings({"unused", "unchecked"})
	public J setJavascriptRenderedElsewhere(boolean javascriptRenderedElsewhere)
	{
		this.javascriptRenderedElsewhere = javascriptRenderedElsewhere;
		return (J) this;
	}

	/**
	 * Returns any hierarchal assigned component
	 *
	 * @return
	 */
	protected <C extends GlobalChildren, A extends Enum & AttributeDefinitions, E extends GlobalEvents, J extends ComponentHierarchyBase<C, A, F, E, J>> ComponentHierarchyBase<C, A, F, E, J> getComponent()
	{
		return component;
	}

	/**
	 * Returns any hierarchal assigned component
	 *
	 * @param component
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings({"unused", "unchecked"})
	public J setComponent(ComponentHierarchyBase component)
	{
		this.component = component;
		return (J) this;
	}

	@Override
	public int compareTo(J o)
	{
		if (o == null)
		{
			return 1;
		}
		Integer comp = getSortOrder().compareTo(o.getSortOrder());
		if (comp == 0)
		{
			if (getName() != null)
			{
				comp = getName().compareTo(o.getName());
			}
			if (comp == 0)
			{
				return getID().compareTo(o.getID());
			}
			return comp;
		}
		return comp;
	}
}
