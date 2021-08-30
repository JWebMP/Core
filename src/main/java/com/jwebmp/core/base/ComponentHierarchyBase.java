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

import com.fasterxml.jackson.annotation.*;
import com.google.common.base.Strings;
import com.guicedee.guicedinjection.GuiceContext;
import com.guicedee.guicedinjection.json.StaticStrings;
import com.guicedee.logger.LogFactory;
import com.jwebmp.core.*;
import com.jwebmp.core.base.html.interfaces.*;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.interfaces.*;
import com.jwebmp.core.base.references.CSSReference;
import com.jwebmp.core.base.references.JavascriptReference;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;
import com.jwebmp.core.htmlbuilder.css.themes.Theme;
import com.jwebmp.core.htmlbuilder.javascript.events.interfaces.IEvent;
import com.jwebmp.core.implementations.JWebMPSiteBinder;
import jakarta.validation.constraints.NotNull;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.Comparator.*;

/**
 * Provides the Hierarchy for any component. Manages children and parent relationships
 *
 * @param <C> All allowed children
 * @param <A> All attributes for this component
 * @param <F> All features allowed for this component
 * @param <E> All events allowed for this component
 * @param <J> Always this class
 * @author GedMarc
 * @since 24 Apr 2016
 */
@SuppressWarnings({"unchecked", "MissingClassJavaDoc"})
public class ComponentHierarchyBase<C extends GlobalChildren,
		A extends Enum<?> & AttributeDefinitions,
		F extends GlobalFeatures,
		E extends GlobalEvents,
		J extends ComponentHierarchyBase<C, A, F, E, J>>
		extends ComponentThemeBase<A, F, E, J>
		implements IComponentHierarchyBase<C, J>,
		           GlobalChildren
{
	/**
	 * Field log
	 */
	private static final Logger log = LogFactory.getInstance()
	                                            .getLogger("ComponentHierarchyBase");
	
	/**
	 * The list of children of this component
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Set<C> children;
	
	/**
	 * My Parent
	 */
	@JsonIgnore
	private IComponentHierarchyBase<?, ?> parent;
	
	/**
	 * The list of class names for this object
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Set<String> classes;
	
	/**
	 * My Page
	 */
	@JsonIgnore
	private Page<?> page;
	
	/**
	 * Constructs a new component that can be part of a tree
	 *
	 * @param componentType The component type of the class
	 */
	public ComponentHierarchyBase(@NotNull ComponentTypes componentType)
	{
		super(componentType);
	}
	
	/**
	 * Returns a Hierarchy Base interface of this component
	 *
	 * @return The smaller neater version as a child hierarchy
	 */
	@NotNull
	@SuppressWarnings("unused")
	public IComponentHierarchyBase<C, J> asHierarchyBase()
	{
		return this;
	}
	
	/**
	 * Finds the event in all this components and child components
	 *
	 * @param eventId
	 * @return
	 * @see ComponentEventBase#findEvent(String)
	 */
	@Override
	public ComponentEventBase<?, ?, ?> findEvent(@NotNull String eventId)
	{
		for (C child : getChildren())
		{
			for (Object jScript : child.asHierarchyBase()
			                           .getEventsAll())
			{
				if (jScript == null)
				{
					continue;
				}
				if (((Event<?, ?>) jScript)
						.getID()
						.equals(eventId))
				{
					return (ComponentEventBase<?, ?, ?>) jScript;
				}
			}
		}
		return null;
	}
	
	/**
	 * Overrides this and all below components to set tiny false
	 *
	 * @param tiny
	 * @return super.tiny
	 * @see ComponentEventBase#setTiny(boolean)
	 */
	@Override
	@NotNull
	public J setTiny(boolean tiny)
	{
		getChildren().stream()
		             .filter(a -> a != null)
		             .forEach(child -> child.asBase()
		                                    .setTiny(tiny));
		return super.setTiny(tiny);
	}
	
	/**
	 * Returns the parent id for the parent property so JSON doesn't go circular
	 *
	 * @return
	 */
	@JsonProperty("parent")
	private String getParentJSON()
	{
		if (getParent() != null)
		{
			return getParent().asBase()
			                  .getID();
		}
		return null;
	}
	
	/**
	 * Adds in the JavaScript References for all the children
	 *
	 * @return
	 * @see ComponentThemeBase#getCssReferencesAll()
	 */
	@Override
	@NotNull
	public Set<CSSReference> getCssReferencesAll()
	{
		Set<CSSReference> allCss = super.getCssReferencesAll();
		getChildren().forEach(child ->
		{
			if (child != null)
			{
				for (Object jScript : child.asDependencyBase()
				                           .getCssReferencesAll())
				{
					allCss.add((CSSReference) jScript);
				}
			}
		});
		return allCss;
	}
	
	/**
	 * Adds in the JavaScript References for all the children
	 *
	 * @return
	 * @see ComponentThemeBase#getJavascriptReferencesAll()
	 */
	@Override
	@NotNull
	public Set<JavascriptReference> getJavascriptReferencesAll()
	{
		Set<JavascriptReference> allJs = super.getJavascriptReferencesAll();
		getChildren().forEach(child ->
		{
			if (child != null)
			{
				for (Object jScript : child.asDependencyBase()
				                           .getJavascriptReferencesAll())
				{
					if (jScript != null)
					{
						allJs.add((JavascriptReference) jScript);
					}
				}
			}
		});
		return allJs;
	}
	
	/**
	 * Method hashCode ...
	 *
	 * @return int
	 */
	@Override
	public int hashCode()
	{
		return super.hashCode();
	}
	
	/**
	 * Method equals ...
	 *
	 * @param o of type Object
	 * @return boolean
	 */
	@Override
	public boolean equals(Object o)
	{
		return super.equals(o);
	}
	
	/**
	 * Method destroy ...
	 */
	@Override
	public void destroy()
	{
		if (children != null)
		{
			for (C next : children)
			{
				try
				{
					next.destroy();
				}
				catch (Exception e)
				{
					ComponentHierarchyBase.log.log(Level.SEVERE, "UUnable to destroy", e);
				}
			}
		}
		if (children != null)
		{
			children.clear();
			children = null;
		}
		if (classes != null)
		{
			classes.clear();
			classes = null;
		}
		super.destroy();
	}
	
	/**
	 * Returns a complete list of events
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unused")
	public Set<Feature<?, ?, ?>> getFeaturesAll()
	{
		Set<Feature<?, ?, ?>> allFeatures = new LinkedHashSet<>();
		getChildrenHierarchy().forEach(child -> {
			if (child != null)
			{
				for (Object event : child.asFeatureBase()
				                         .getFeatures())
				{
					if (event != null)
					{
						allFeatures.add((Feature<?, ?, ?>) event);
					}
				}
			}
		});
		return allFeatures;
	}
	
	/**
	 * Takes an instance and wraps around the component
	 * <p>
	 * e.g. BSRow.wrap(div) = iv class="row"myComponent//div
	 *
	 * @param component
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	@Override
	public <T extends IComponentHierarchyBase<?, ?>> T wrap(@NotNull T component)
	{
		IComponentHierarchyBase<T, ?> existingParent = (IComponentHierarchyBase<T, ?>) component.getParent();
		if (existingParent != null)
		{
			existingParent.remove(component);
			existingParent.add((T) this);
		}
		getChildren().add((C) component);
		return component;
	}
	
	/**
	 * Takes all children and embeds them into the current children hierarchy
	 * None of the details for the transient container is kept
	 * <p>
	 * e.g. myComponent.embed(div)
	 *
	 * @param component
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	@Override
	public <T extends IComponentHierarchyBase<?, ?>> T embed(@NotNull T component)
	{
		component.getChildren()
		         .stream()
		         .filter(Objects::nonNull)
		         .forEach(a -> add((C) a));
		return component;
	}
	
	/**
	 * Add a new child to this component
	 * <p>
	 *
	 * @param newChild The child to be added
	 *                 <p>
	 * @return The new child added
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J add(@NotNull C newChild)
	{
		if (newChild == null)
		{
			return (J) this;
		}
		newChild.asHierarchyBase()
		        .setParent(this);
		newChild.asHierarchyBase()
		        .setTiny(isTiny());
		newChild.asHierarchyBase()
		        .setPage(getPage());
		getChildren().add(newChild);
		return (J) this;
	}
	
	/**
	 * Add a new child to this component
	 * <p>
	 *
	 * @param newChild The child to be added
	 *                 <p>
	 * @return The new child added
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J add(@NotNull Integer position, @NotNull C newChild)
	{
		if (newChild == null)
		{
			return (J) this;
		}
		newChild.asHierarchyBase()
		        .setParent(this);
		newChild.asHierarchyBase()
		        .setTiny(isTiny());
		newChild.asHierarchyBase()
		        .setPage(getPage());
		ArrayList<C> componentHierarchyBases = new ArrayList<>(getChildren());
		componentHierarchyBases.add(position, newChild);
		setChildren(new LinkedHashSet<>(componentHierarchyBases));
		return (J) this;
	}
	
	/**
	 * Returns null sets the text
	 *
	 * @param text Sets this tags raw text, does not add a component
	 * @return J Always this class
	 * @see com.jwebmp.core.base.interfaces.IComponentHierarchyBase#add(String)
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J add(@NotNull String text)
	{
		setText(text);
		return (J) this;
	}
	
	/**
	 * Adds the given CSS Class Name with the given references
	 * <p>
	 *
	 * @param classComponent Adds a class as a component to this object
	 * @return This class
	 * @see com.jwebmp.core.base.interfaces.IComponentHierarchyBase#addClass(CSSComponent)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public J addClass(@NotNull CSSComponent<?> classComponent)
	{
		String className = classComponent.getID();
		add((C) classComponent);
		if (!getClasses().contains(className))
		{
			addClass(className);
			
		}
		return (J) this;
	}
	
	/**
	 * Adds the given CSS Class Name with the given references
	 * <p>
	 *
	 * @param className Adds a class as a component to this object
	 * @return This class
	 * @see com.jwebmp.core.base.interfaces.IComponentHierarchyBase#addClass(CSSComponent)
	 */
	@Override
	public J addClass(ICssClassName className, ICssClassName... classNames)
	{
		addClass(className);
		for (ICssClassName name : classNames)
		{
			addClass(name);
		}
		return (J) this;
	}
	
	/**
	 * Returns All the angular objects mapped to this component and its children
	 *
	 * @return A map of String,Object
	 * @see com.jwebmp.core.base.interfaces.IComponentHierarchyBase#getAngularObjectsAll()
	 */
	@Override
	public Map<String, Object> getAngularObjectsAll()
	{
		Map<String, Object> map = getJsonObjects();
		for (IComponentHierarchyBase<?, ?> next : getChildrenHierarchy(true))
		{
			processAngularObjects(next, map);
		}
		return map;
	}
	
	/**
	 * Returns the children ArrayList of type Component
	 * <p>
	 *
	 * @return An array list of components
	 */
	@Override
	@NotNull
	public final Set<C> getChildren()
	{
		if (children == null)
		{
			children = new LinkedHashSet<>();
		}
		return children;
	}
	
	/**
	 * Sets the children of this object
	 *
	 * @param children The children set to apply
	 */
	public void setChildren(Set<C> children)
	{
		this.children = children;
	}
	
	/**
	 * Get an array list of all children and their children recursively Includes this object
	 * <p>
	 *
	 * @return A complete array list of all children at time of call
	 */
	@Override
	@NotNull
	public Set<IComponentHierarchyBase<?, ?>> getChildrenHierarchy()
	{
		return getChildrenHierarchy(true);
	}
	
	/**
	 * Get an array list of all children and their children recursively Excludes this object
	 * <p>
	 *
	 * @param includeSelf Whether or not to include this component
	 *                    <p>
	 * @return A complete array list of all children at time of call
	 */
	@Override
	@NotNull
	public Set<IComponentHierarchyBase<?, ?>> getChildrenHierarchy(boolean includeSelf)
	{
		Set<IComponentHierarchyBase<?, ?>> components = new LinkedHashSet<>();
		if (includeSelf)
		{
			components.add(this);
		}
		getChildrenHierarchy(components);
		
		return components;
	}
	
	/**
	 * Adds the children of this component onto the array list coming in
	 * <p>
	 * <p>
	 * <p>
	 *
	 * @param componentsToAddTo The component Array List to add to
	 *                          <p>
	 * @return original components added with
	 * <p>
	 * see com.jwebmp.core.base.interfaces.IComponentHierarchyBase#getChildrenHierarchy(Set ComponentHierarchyBase ?, ?, ?, ?, ? )
	 */
	@Override
	@NotNull
	public Set<IComponentHierarchyBase<?, ?>> getChildrenHierarchy(
			@NotNull Set<IComponentHierarchyBase<?, ?>> componentsToAddTo)
	{
		getChildren().forEach(child ->
		{
			if (child != null)
			{
				componentsToAddTo.add((IComponentHierarchyBase<?, ?>) child);
				child.asHierarchyBase()
				     .getChildrenHierarchy(componentsToAddTo);
			}
		});
		return componentsToAddTo;
	}
	
	/**
	 * Returns a complete list of events
	 *
	 * @return A unique set of all events
	 */
	@Override
	@NotNull
	public Set<Event<?, ?>> getEventsAll()
	{
		Set<Event<?, ?>> allEvents = new LinkedHashSet<>();
		getChildrenHierarchy(true).stream()
		                          .filter(Objects::nonNull)
		                          .forEach(child -> {
			                          for (Object event : child.asEventBase()
			                                                   .getEvents())
			                          {
				                          if (event != null)
				                          {
					                          allEvents.add((Event<?, ?>) event);
				                          }
			                          }
		                          });
		return allEvents;
	}
	
	/**
	 * Get the page this component exists on
	 * <p>
	 *
	 * @return A Page
	 */
	@Override
	@NotNull
	public Page<?> getPage()
	{
		if (page == null)
		{
			setPage(new Page<>());
		}
		return page;
	}
	
	/**
	 * Gets the parent of this hierarchy item
	 *
	 * @return The parent object
	 */
	@Override
	public IComponentHierarchyBase<?, ?> getParent()
	{
		return parent;
	}
	
	/**
	 * Sets the parent of this item
	 *
	 * @param parent Sets the parent object
	 */
	@Override
	@NotNull
	@SuppressWarnings("unchecked")
	public J setParent(IComponentHierarchyBase<?, ?> parent)
	{
		this.parent = parent;
		return (J) this;
	}
	
	/**
	 * Adds a class name to the class list
	 * <p>
	 *
	 * @param className The class name to add
	 *                  <p>
	 * @return True if it was added, false if it already existed
	 */
	@Override
	@NotNull
	@SuppressWarnings("unchecked")
	public J addClass(@NotNull String className)
	{
		getClasses().add(className);
		return (J) this;
	}
	
	/**
	 * Removes a class name from this component
	 * <p>
	 *
	 * @param className Class Name to Remove
	 *                  <p>
	 * @return True if the class was removed, False if the class was not part of the collection
	 */
	@Override
	@SuppressWarnings("unchecked")
	public J removeClass(String className)
	{
		getClasses().remove(className);
		return (J) this;
	}
	
	/**
	 * Removes a class name from this component
	 * <p>
	 *
	 * @param className Class Name to Remove
	 *                  <p>
	 * @return True if the class was removed, False if the class was not part of the collection
	 */
	@Override
	@SuppressWarnings("unchecked")
	public J removeClass(String className, String... classNames)
	{
		this.removeClass(className);
		for (String name : classNames)
		{
			this.removeClass(name);
		}
		return (J) this;
	}
	
	/**
	 * Enumeration to remove
	 *
	 * @param className
	 * @return
	 */
	@Override
	public J removeClass(@NotNull Enum<?> className, Enum<?>... classNames)
	{
		this.removeClass(className);
		for (Enum<?> name : classNames)
		{
			this.removeClass(name);
		}
		return (J) this;
	}
	
	/**
	 * Enumeration to remove
	 *
	 * @param className
	 * @return
	 */
	@Override
	public boolean removeClass(@NotNull Enum<?> className)
	{
		if (getClasses().contains(className.toString()))
		{
			getClasses().remove(className.toString());
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Method addClass ...
	 *
	 * @param className of type ICssClassName
	 * @return J
	 * @see com.jwebmp.core.base.interfaces.IComponentHierarchyBase#addClass(ICssClassName)
	 */
	@Override
	@NotNull
	@SuppressWarnings("unchecked")
	public J addClass(@NotNull ICssClassName className)
	{
		getClasses().add(className.toString());
		return (J) this;
	}
	
	/**
	 * Returns a complete list of all class names associated with this component
	 * <p>
	 *
	 * @return
	 */
	@Override
	@NotNull
	public Set<String> getClasses()
	{
		if (classes == null)
		{
			classes = new LinkedHashSet<>();
		}
		return classes;
	}
	
	/**
	 * Sets the classes set
	 *
	 * @param classes a new set of classes
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	@Override
	public J setClasses(Set<String> classes)
	{
		this.classes = classes;
		return (J) this;
	}
	
	/**
	 * Set the theme applied to this component
	 * <p>
	 *
	 * @param theme The JQuery UI theme to apply to the component
	 * @see com.jwebmp.core.base.interfaces.IComponentHierarchyBase#addTheme(Theme)
	 */
	@Override
	@NotNull
	@SuppressWarnings("unchecked")
	public J addTheme(@NotNull Theme theme)
	{
		if (!getThemes().contains(theme))
		{
			getThemes().add(theme);
			addClass(theme.getClassName());
		}
		
		return (J) this;
	}
	
	/**
	 * *
	 * Returns all the variables for all the components
	 *
	 * @return
	 */
	@Override
	@NotNull
	public Set<String> getVariablesAll()
	{
		Set<String> allVariables = new TreeSet<>();
		getChildrenHierarchy().forEach(child -> {
			if (child != null)
			{
				for (Object o : child.asFeatureBase()
				                     .getVariables())
				{
					if (o != null)
					{
						allVariables.add(o.toString());
					}
				}
			}
		});
		return allVariables;
	}
	
	/**
	 * Creates loading part objects that return an injected instance of the class associated to that part
	 *
	 * @return
	 */
	@Override
	public ComponentHierarchyBase<GlobalChildren, ?, ?, GlobalEvents, ?> getLoadingPart(IEvent... events)
	{
		if (JWebMPSiteBinder.loadingPartClass != null)
		{
			ComponentHierarchyBase<GlobalChildren, ?, ?, GlobalEvents, ?> loadingPart = (ComponentHierarchyBase<GlobalChildren, ?, ?, GlobalEvents, ?>) GuiceContext.get(JWebMPSiteBinder.loadingPartClass);
			loadingPart.setID(getID());
			for (IEvent<GlobalFeatures, ?> event : events)
			{
				loadingPart.addEvent(event);
			}
			return loadingPart;
		}
		return null;
	}
	
	/**
	 * Returns if this object has children or not
	 * <p>
	 *
	 * @return true if there are children attached
	 */
	@Override
	public boolean hasChildren()
	{
		return !getChildren().isEmpty();
	}
	
	/**
	 * Takes a component off this components child list
	 * <p>
	 *
	 * @param childToRemove The child object to remove from this list
	 *                      <p>
	 * @return True if the child was part of this components children's list
	 */
	@Override
	public boolean remove(C childToRemove)
	{
		getChildren().remove(childToRemove);
		return true;
	}
	
	/**
	 * *
	 * Returns all the JavaScript for all the components
	 *
	 * @return
	 */
	@Override
	@NotNull
	public StringBuilder renderJavascriptAll()
	{
		preConfigure();
		StringBuilder sb = new StringBuilder();
		Set<String> allScripts = new LinkedHashSet<>();
		Set<StringBuilder> queries = getQueriesAll();
		queries.forEach(a ->
		{
			if (!Strings.isNullOrEmpty(a.toString()))
			{
				allScripts.add(a.toString());
			}
		});
		allScripts.forEach(sb.append(getNewLine())::append);
		return sb;
	}
	
	/**
	 * Configures the page and all its components
	 *
	 * @see ComponentHTMLAttributeBase#preConfigure()
	 */
	@Override
	public void preConfigure()
	{
		if (!isConfigured())
		{
			setNewLineForClosingTag(hasChildren());
		}
		super.preConfigure();
	}
	
	/**
	 * Renders the classes array as an in-line class string
	 *
	 * @return
	 * @see ComponentHTMLAttributeBase#renderClasses()
	 */
	@Override
	@NotNull
	protected StringBuilder renderClasses()
	{
		StringBuilder sb = new StringBuilder();
		Set<String> eachClass = getClasses();
		eachClass.forEach(a -> sb.append(a)
		                         .append(StaticStrings.STRING_SPACE));
		if (sb.length() > 0)
		{
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb;
	}
	
	/**
	 * @see ComponentHTMLAttributeBase#cloneComponent()
	 */
	@Override
	@NotNull
	@SuppressWarnings("unchecked")
	public J cloneComponent()
	{
		ComponentHierarchyBase<?, ?, ?, ?, ?> cloned = super.cloneComponent();
		//noinspection CastCanBeRemovedNarrowingVariableType
		return (J) cloned;
	}
	
	/**
	 * Returns all the feature queries associated to this component and all its children
	 *
	 * @return
	 * @see ComponentFeatureBase#getQueriesAll()
	 */
	@Override
	@NotNull
	public Set<StringBuilder> getQueriesAll()
	{
		Set<StringBuilder> reallyAllQueries = new LinkedHashSet<>();
		Set<IComponentHierarchyBase<?, ?>> allComponents = getChildrenHierarchy(true);
		Consumer<? super IComponentHierarchyBase<?, ?>> action = componentQuery -> processComponentQueries(componentQuery, reallyAllQueries);
		for (IComponentHierarchyBase<?, ?> allComponent : allComponents)
		{
			if (allComponent != null)
			{
				action.accept(allComponent);
			}
		}
		return reallyAllQueries;
	}
	
	/**
	 * Pre-Configure the children tree
	 *
	 * @return
	 * @see ComponentBase#toString()
	 */
	@Override
	@NotNull
	public String toString()
	{
		getChildren().forEach(next ->
		{
			if (next != null)
			{
				if (!next.isConfigured())
				{
					next.preConfigure();
				}
			}
		});
		return super.toString();
	}
	
	/**
	 * Processes the queries
	 *
	 * @param componentQuery
	 * @param reallyAllQueries
	 */
	@SuppressWarnings("unchecked")
	private void processComponentQueries(@NotNull IComponentHierarchyBase<?, ?> componentQuery, @NotNull Set<StringBuilder> reallyAllQueries)
	{
		reallyAllQueries.addAll(getQueries());
		@SuppressWarnings("rawtypes")
		List<ComponentFeatureBase<?, ?>> features = new ArrayList(componentQuery.asFeatureBase()
		                                                                        .getFeatures());
		features.forEach(feature -> reallyAllQueries.add(feature.renderJavascript()));
		features.sort(comparing(ComponentFeatureBase::getSortOrder));
		Set<GlobalEvents> events = (Set<GlobalEvents>) componentQuery.asEventBase()
		                                                             .getEvents();
		
		events.forEach(event -> reallyAllQueries.add(((IComponentFeatureBase<?, ?>) event).asFeatureBase()
		                                                                                  .renderJavascript()));
		
		features.sort(comparing(ComponentFeatureBase::getSortOrder));
	}
	
	/**
	 * Sets the page this component belongs on.
	 * Null to reset the page hierarchy for all children
	 * <p>
	 *
	 * @param page A Page
	 * @see com.jwebmp.core.base.interfaces.IComponentHierarchyBase#setPage(Page)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public J setPage(Page<?> page)
	{
		this.page = page;
		getChildren().stream()
		             .filter(a -> a != null)
		             .forEach(child -> child.asHierarchyBase()
		                                    .setPage(page));
		return (J) this;
	}
	
	/**
	 * Processes the angular objects into a map
	 *
	 * @param next
	 * @param map
	 */
	private void processAngularObjects(@NotNull IComponentHierarchyBase<?, ?> next, @NotNull Map<String, Object> map)
	{
		for (Map.Entry<String, Object> entry : next.asAngularBase()
		                                           .getJsonObjects()
		                                           .entrySet())
		{
			String key = entry.getKey();
			Object value = entry.getValue();
			if (key != null)
			{
				try
				{
					map.put(key, value);
				}
				catch (ClassCastException cce)
				{
					ComponentHierarchyBase.log.log(Level.WARNING, "Incorrect Object Type, Perhaps JavaScriptPart?", cce);
				}
				catch (Exception e)
				{
					ComponentHierarchyBase.log.log(Level.WARNING, "Unable to render angular object", e);
				}
			}
		}
	}
	
	/**
	 * Iterates through all the children checking if a boolean property has been placed, Returns the first instance of true or always false
	 *
	 * @param propertyName
	 * @param returnBool
	 * @return
	 */
	@SuppressWarnings("unused")
	public boolean readChildrenPropertyFirstResult(String propertyName, boolean returnBool)
	{
		for (IComponentHierarchyBase<?, ?> next : getChildrenHierarchy(true))
		{
			if (next != null)
			{
				if (next.asBase()
				        .getProperties()
				        .containsKey(propertyName))
				{
					String propertyValue = next.asBase()
					                           .getProperties()
					                           .get(propertyName)
					                           .toString();
					try
					{
						return Boolean.parseBoolean(propertyValue);
					}
					catch (Exception e)
					{
						ComponentHierarchyBase.log.log(Level.WARNING, "Property value was not a boolean.", e);
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Returns the first parent in the chain of the class type
	 *
	 * @param <T>        The class type
	 * @param parentType The type to look for
	 * @return
	 */
	@Override
	public <T extends IComponentHierarchyBase<?, ?>> T findParent(Class<T> parentType)
	{
		return findParent(this, parentType);
	}
	
	/**
	 * Recursive method for going through the parent base
	 *
	 * @param root       The root
	 * @param parentType The parent type
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private <T extends IComponentHierarchyBase<?, ?>> T findParent(@NotNull IComponentHierarchyBase<?, ?> root, @NotNull Class<T> parentType)
	{
		if (root.getParent() != null)
		{
			T found;
			found = (T) root.getParent();
			while (found != null && !parentType.isAssignableFrom(found.getClass()))
			{
				found = (T) found.getParent();
			}
			return found;
		}
		return null;
	}
	
	/**
	 * Method findChild ...
	 *
	 * @param childType of type Class T
	 * @return T
	 */
	@SuppressWarnings({"unchecked", "unused"})
	@Override
	public <T extends IComponentHierarchyBase<?, ?>> T findChild(@NotNull Class<T> childType)
	{
		return (T) getChildren().stream()
		                        .filter(componentHierarchyBase -> componentHierarchyBase.getClass()
		                                                                                .equals(childType))
		                        .findFirst()
		                        .orElse(null);
	}
	
	/**
	 * Convenience method for checking if a tag has already been added as a child
	 * <p>
	 *
	 * @param classType The Tag type to check for
	 *                  <p>
	 * @return The Obvious
	 */
	@SuppressWarnings("unused")
	protected boolean containsClass(@NotNull Class<?> classType)
	{
		for (C next : getChildren())
		{
			if (next.getClass()
			        .equals(classType))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Renders each child
	 *
	 * @return
	 * @see ComponentHTMLBase#renderChildren()
	 */
	@Override
	@NotNull
	protected StringBuilder renderChildren()
	{
		StringBuilder sb = new StringBuilder();
		if (renderBeforeChildren() != null)
		{
			sb.append(renderBeforeChildren());
		}
		CopyOnWriteArraySet<C> objects = new CopyOnWriteArraySet<>();
		objects.addAll(getChildren());
		objects.stream()
		       .filter(Objects::nonNull)
		       .forEach(child -> {
					       try
					       {
						       sb.append(getNewLine())
						         .append(child.toString(child.asBase()
						                                     .isTiny() ? 0 : getCurrentTabIndents() + 1));
					       }
					       catch (Exception e)
					       {
						       log.log(Level.SEVERE, "Cannot work on child object - " + child.getClass()
						                                                                     .getCanonicalName() + "\n, adding to the tree\n", e);
					       }
				       }
		       );
		if (renderAfterChildren() != null)
		{
			sb.append(renderAfterChildren());
		}
		return sb;
	}
	
	/**
	 * Ensure if there are children that new lines must be rendered
	 * <p>
	 * Boxed for operating purposes
	 *
	 * @return
	 * @see ComponentHTMLBase#isNewLineForClosingTag()
	 */
	@Override
	@NotNull
	public Boolean isNewLineForClosingTag()
	{
		if (hasChildren() && !isTiny())
		{
			return true;
		}
		else
		{
			return super.isNewLineForClosingTag();
		}
	}
	
	/**
	 * Renders String content before the children tags are rendered
	 * <p>
	 *
	 * @return Custom HTML String to be inserted before Children tags
	 * @see ComponentHTMLBase#renderBeforeChildren()
	 */
	@Override
	
	protected StringBuilder renderBeforeChildren()
	{
		return null;
	}
	
	/**
	 * Renders String content after the children tags are rendered
	 * <p>
	 *
	 * @return Custom HTML String to be inserted after Children tags
	 * @see ComponentHTMLBase#renderAfterChildren()
	 */
	@Override
	
	protected StringBuilder renderAfterChildren()
	{
		return null;
	}
	
}
