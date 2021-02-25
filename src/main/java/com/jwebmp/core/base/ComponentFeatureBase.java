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
package com.jwebmp.core.base;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.guicedee.guicedinjection.json.StaticStrings;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.interfaces.IComponentFeatureBase;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.references.CSSReference;
import com.jwebmp.core.base.references.JavascriptReference;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;
import com.jwebmp.core.base.servlets.enumarations.RequirementsPriority;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import jakarta.validation.constraints.NotNull;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;

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
public class ComponentFeatureBase<F extends GlobalFeatures, J extends ComponentFeatureBase<F, J>>
		extends ComponentDependencyBase<J>
		implements IComponentFeatureBase<F, J>, Comparator<J>, Comparable<J>
{
	/**
	 * A linked component if required
	 */
	@JsonIgnore
	@JsonIdentityReference(alwaysAsId = true)
	private IComponentHierarchyBase<?,?> component;
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
	 * Whether this feature *WAS* rendered after the load
	 * Preconfigure is called before assignFunctionToComponents must be
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
	 * 		The name of this component/feature
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
	 * 		The given component type of this component
	 */
	public ComponentFeatureBase(ComponentTypes componentType)
	{
		super(componentType);
	}

	/**
	 * Returns an Attribute Base interface of this component
	 *
	 * @return This, but smaller
	 */
	@SuppressWarnings({"unused"})
	@NotNull
	public IComponentFeatureBase<?,?> asFeatureBase()
	{
		return this;
	}

	/**
	 * Adds in the JavaScript References for the Features
	 *
	 * @return All the CSS References
	 *
	 * @see ComponentDependencyBase#getCssReferencesAll()
	 */
	@Override
	@NotNull
	public Set<CSSReference> getCssReferencesAll()
	{
		Set<CSSReference> allCss = super.getCssReferencesAll();
		getFeatures().forEach(feature ->
		                      {
			                      ComponentFeatureBase<?,?> cfb = (ComponentFeatureBase<?,?>) feature;
			                      for (Object css : cfb.getCssReferencesAll())
			                      {
				                      allCss.add((CSSReference) css);
			                      }
		                      });
		return allCss;
	}

	/**
	 * Adds in the JavaScript References for the Features
	 *
	 * @return All the references
	 *
	 * @see ComponentDependencyBase#getJavascriptReferencesAll()
	 */
	@Override
	@NotNull
	public Set<JavascriptReference> getJavascriptReferencesAll()
	{
		Set<JavascriptReference> allJs = super.getJavascriptReferencesAll();
		getFeatures().forEach(feature ->
		                      {
			                      ComponentFeatureBase<?,?> cfb = (ComponentFeatureBase<?,?>) feature;
			                      for (Object js : cfb.getJavascriptReferencesAll())
			                      {
				                      allJs.add((JavascriptReference) js);
			                      }
		                      });
		return allJs;
	}

	/**
	 * @see ComponentDependencyBase#hashCode()
	 */
	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	/**
	 * Method equals ...
	 *
	 * @param obj
	 * 		of type Object
	 *
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj)
	{
		return super.equals(obj);
	}

	/**
	 * Destroys this class cleanly
	 */
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
	 * 		Any given feature
	 *
	 * @return This class
	 *
	 * @see com.jwebmp.core.base.interfaces.IComponentFeatureBase#addFeature(IComponentFeatureBase)
	 */
	@Override
	@NotNull
	@SuppressWarnings("unchecked")
	public J addFeature(@NotNull IComponentFeatureBase<?,?> feature)
	{
		getFeatures().add((F) feature);
		feature.init();
		feature.preConfigure();
		return (J) this;
	}

	/**
	 * Adds a variable to the collection
	 *
	 * @param variable
	 * 		Adds a variable for this feature to assign
	 *
	 * @see com.jwebmp.core.base.interfaces.IComponentFeatureBase#addVariable(String)
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
		return name == null ? getClassCanonicalName() : name;
	}

	/**
	 * Returns any client side options available with this component
	 *
	 * @return Returns null currently
	 *
	 * @see com.jwebmp.core.base.interfaces.IComponentFeatureBase#getOptions()
	 */
	@Override
	public JavaScriptPart<?> getOptions()
	{
		return null;
	}

	/**
	 * Gets the render priority of this feature
	 *
	 * @return The assigned priority of this feature generation
	 *
	 * @see com.jwebmp.core.base.interfaces.IComponentFeatureBase#getPriority()
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
	 * @return A full set of all queries
	 *
	 * @see com.jwebmp.core.base.interfaces.IComponentFeatureBase#getQueriesAll()
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
	 * @return A full set of all queries
	 *
	 * @see com.jwebmp.core.base.interfaces.IComponentFeatureBase#getSortOrder()
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
	 * 		the given sort order
	 *
	 * @return This class
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
	 * @return A unique set of variables
	 *
	 * @see com.jwebmp.core.base.interfaces.IComponentFeatureBase#getVariables()
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
	 * @return If this feature has executed the assignFunctionToComponents method
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
	 * 		the variable to remove
	 *
	 * @return Always this
	 *
	 * @see com.jwebmp.core.base.interfaces.IComponentFeatureBase#removeVariable(String)
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
	 * @return The complete javascript for this object
	 *
	 * @see com.jwebmp.core.base.interfaces.IComponentFeatureBase#renderJavascript()
	 */
	@Override
	@NotNull
	public StringBuilder renderJavascript()
	{
		checkAssignedFunctions();
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
			                             .equals(StaticStrings.STRING_NEWLINE_TEXT) && !sb.toString()
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
	 * Returns a list of all the features associated with this component
	 * <p>
	 *
	 * @return An ArrayList of features
	 */
	@NotNull
	@Override
	public Set<F> getFeatures()
	{
		if (features == null)
		{
			features = new LinkedHashSet<>();
		}
		return features;
	}

	/**
	 * Checks if this feature has been configured and rendered with all the features
	 */
	@Override
	public void checkAssignedFunctions()
	{
		if (!isRenderAfterLoad())
		{
			if (!getFeatures().isEmpty())
			{
				getFeatures().forEach(t -> t.asFeatureBase().checkAssignedFunctions());
			}
			assignFunctionsToComponent();
			setRenderAfterLoad(true);
		}
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
	 * @return A set of queries added to this component/feature
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
	 * 		if this feature has called assignTo...
	 *
	 * @return Always this class
	 */
	@NotNull
	@SuppressWarnings({"unchecked", "UnusedReturnValue"})
	public J setRenderAfterLoad(boolean renderAfterLoad)
	{
		this.renderAfterLoad = renderAfterLoad;
		return (J) this;
	}

	/**
	 * Sets the render priority of this feature
	 *
	 * @param priority
	 * 		The priority to use
	 *
	 * @return J
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J setPriority(@NotNull RequirementsPriority priority)
	{
		this.priority = priority;
		return (J) this;
	}

	/**
	 * Sets the name of the feature
	 *
	 * @param name
	 * 		Sets the name of the feature
	 *
	 * @return Always this
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J setName(@NotNull String name)
	{
		this.name = name;
		return (J) this;
	}

	/**
	 * Method compare ...
	 *
	 * @param o1
	 * 		of type ComponentFeatureBase
	 * @param o2
	 * 		of type ComponentFeatureBase
	 *
	 * @return int
	 */
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
	 * 		if this must render tiny
	 *
	 * @return Always this class
	 *
	 * @see ComponentBase#setTiny(boolean)
	 */
	@NotNull
	@Override
	public J setTiny(boolean tiny)
	{
		for (F f : getFeatures())
		{
			ComponentFeatureBase<?,?> next = (ComponentFeatureBase<?,?>) f;
			next.setTiny(tiny);
		}
		return super.setTiny(tiny);
	}

	/**
	 * Renders the component as a JSON Object
	 *
	 * @return The string as a json object
	 *
	 * @see ComponentBase#toString()
	 */
	@Override
	public String toString()
	{
		checkAssignedFunctions();
		return super.toString();
	}

	/**
	 * Adds a query to the object queue
	 *
	 * @param query
	 * 		The query to add
	 *
	 * @return Always this
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J addQuery(@NotNull StringBuilder query)
	{
		if(!query.toString().endsWith(getNewLine()))
			query.append(getNewLine());
		getQueries().add(query);
		return (J) this;
	}

	/**
	 * Returns if the JavaScript for this component is rendered elsewhere
	 *
	 * @return if the elements must be rendered elsewhere
	 */
	public boolean isJavascriptRenderedElsewhere()
	{
		return javascriptRenderedElsewhere;
	}

	/**
	 * Returns if the JavaScript for this component is rendered elsewhere
	 *
	 * @param javascriptRenderedElsewhere
	 * 		if it must render manually somewhere else
	 *
	 * @return this class
	 */
	@NotNull
	@SuppressWarnings({"unused", "unchecked"})
	public J setJavascriptRenderedElsewhere(boolean javascriptRenderedElsewhere)
	{
		this.javascriptRenderedElsewhere = javascriptRenderedElsewhere;
		return (J) this;
	}

	/**
	 * Method compareTo ...
	 *
	 * @param o
	 * 		of type J
	 *
	 * @return int
	 */
	@Override
	public int compareTo(@NotNull J o)
	{
		int comp = getSortOrder().compareTo(o.getSortOrder());
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

	/**
	 * Returns any hierarchal assigned component
	 *
	 * @return the assigned component
	 */
	@Override
	public IComponentHierarchyBase<?,?>  getComponent()
	{
		return  component;
	}

	/**
	 * Returns any hierarchal assigned component
	 *
	 * @param component
	 * 		the component use
	 *
	 * @return Always this
	 */
	@NotNull
	@SuppressWarnings({"unused", "unchecked"})
	@Override
	public J setComponent(IComponentHierarchyBase<?,?> component)
	{
		this.component = component;
		return (J) this;
	}
}
