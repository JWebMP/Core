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
package za.co.mmagon.jwebswing.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import za.co.mmagon.jwebswing.CSSComponent;
import za.co.mmagon.jwebswing.Event;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.html.interfaces.AttributeDefinitions;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.interfaces.ICSSClassName;
import za.co.mmagon.jwebswing.base.interfaces.IComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.base.references.JavascriptReference;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.htmlbuilder.css.themes.Theme;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.logger.LogFactory;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.Comparator.comparing;
import static za.co.mmagon.jwebswing.utilities.StaticStrings.STRING_SPACE;

/**
 * Provides the Hierarchy for any component. Manages children and parent relationships
 *
 * @param <C>
 * 		All allowed children
 * @param <A>
 * 		All attributes for this component
 * @param <F>
 * 		All features allowed for this component
 * @param <E>
 * 		All events allowed for this component
 * @param <J>
 * 		Always this class
 *
 * @author GedMarc
 * @since 24 Apr 2016
 */
public class ComponentHierarchyBase<C extends GlobalChildren, A extends Enum & AttributeDefinitions, F extends GlobalFeatures, E extends GlobalEvents, J extends ComponentHierarchyBase<C, A, F, E, J>>
		extends ComponentThemeBase<A, F, E, J>
		implements IComponentHierarchyBase<C, J>, GlobalChildren
{

	private static final long serialVersionUID = 1L;
	private static final Logger log = LogFactory.getInstance().getLogger("ComponentHierarchyBase");

	/**
	 * The list of children of this component
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Set<ComponentHierarchyBase> children;

	/**
	 * My Parent
	 */
	@JsonIgnore
	private ComponentHierarchyBase parent;

	/**
	 * The list of class names for this object
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Set<String> classes;

	/**
	 * My Page
	 */
	@JsonIgnore
	private Page page;

	/**
	 * Constructs a new component that can be part of a tree
	 *
	 * @param componentType
	 */
	public ComponentHierarchyBase(@NotNull ComponentTypes componentType)
	{
		super(componentType);
	}

	/**
	 * Returns a Hierarchy Base interface of this component
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unused")
	public IComponentHierarchyBase asHierarchyBase()
	{
		return this;
	}

	/**
	 * Add a new child to this component
	 * <p>
	 *
	 * @param newChild
	 * 		The child to be added
	 * 		<p>
	 *
	 * @return The new child added
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J add(@NotNull C newChild)
	{
		ComponentHierarchyBase comp = ComponentHierarchyBase.class.cast(newChild);
		if (comp != null)
		{
			comp.setParent(this);
			comp.setTiny(isTiny());
			comp.setPage(getPage());
			getChildren().add(comp);
		}
		return (J) this;
	}

	/**
	 * Returns null sets the text
	 *
	 * @param text
	 *
	 * @return
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
	 * Returns All the angular objects mapped to this component and its children
	 *
	 * @return
	 */
	@Override
	public Map<String, JavaScriptPart> getAngularObjectsAll()
	{
		Map<String, JavaScriptPart> map = getAngularObjects();
		for (ComponentHierarchyBase next : getChildrenHierarchy(true))
		{
			processAngularObjects(next, map);
		}
		return map;
	}

	/**
	 * Adds the given CSS Class Name with the given references
	 * <p>
	 *
	 * @param classComponent
	 *
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public J addClass(@NotNull CSSComponent classComponent)
	{
		String className = classComponent.getID();
		getPage().getBody().add(classComponent);
		if (!getClasses().contains(className))
		{
			addClass(className);
			return (J) this;
		}
		else
		{
			return (J) this;
		}
	}

	/**
	 * Returns the children ArrayList of type Component
	 * <p>
	 *
	 * @return An array list of components
	 */
	@Override
	@NotNull
	public final Set<ComponentHierarchyBase> getChildren()
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
	 * @param children
	 * 		The children set to apply
	 */
	public void setChildren(Set<ComponentHierarchyBase> children)
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
	public Set<ComponentHierarchyBase> getChildrenHierarchy()
	{
		return getChildrenHierarchy(true);
	}

	/**
	 * Get an array list of all children and their children recursively Excludes this object
	 * <p>
	 *
	 * @param trues
	 * 		Whether or not to include this component
	 * 		<p>
	 *
	 * @return A complete array list of all children at time of call
	 */
	@Override
	@NotNull
	public Set<ComponentHierarchyBase> getChildrenHierarchy(boolean trues)
	{
		Set<ComponentHierarchyBase> components = new LinkedHashSet<>();
		if (trues)
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
	 * @param componentsToAddTo
	 * 		The component Array List to add to
	 * 		<p>
	 *
	 * @return original components added with
	 */
	@Override
	@NotNull
	public Set<ComponentHierarchyBase> getChildrenHierarchy(@NotNull Set<ComponentHierarchyBase> componentsToAddTo)
	{
		getChildren().forEach(child ->
		                      {
			                      componentsToAddTo.add(child);
			                      child.getChildrenHierarchy(componentsToAddTo);
		                      });
		return componentsToAddTo;
	}

	/**
	 * Returns a complete list of events
	 *
	 * @return
	 */
	@Override
	@NotNull
	public Set<Event> getEventsAll()
	{
		Set<Event> allEvents = new LinkedHashSet<>();
		getChildrenHierarchy(true).forEach(child
				                                   ->
		                                   {
			                                   for (Object event : child.getEvents())
			                                   {
				                                   allEvents.add(Event.class.cast(event));
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
	public Page getPage()
	{
		if (page == null)
		{
			setPage(new Page());
		}
		return page;
	}

	/**
	 * *
	 * Returns all the JavaScript for all the components
	 *
	 * @return
	 */
	@Override
	@NotNull
	@SuppressWarnings("unchecked")
	public StringBuilder renderJavascriptAll()
	{
		preConfigure();
		StringBuilder sb = new StringBuilder();
		Set<String> allScripts = new TreeSet<>();
		Set<StringBuilder> queries = getQueriesAll();
		queries.forEach(a ->
		                {
			                if (!a.toString().isEmpty())
			                {
				                allScripts.add(a.toString());
			                }
		                });
		allScripts.forEach(sb.append(getNewLine())::append);
		return sb;
	}

	/**
	 * Gets the parent of this hierarchy item
	 *
	 * @return
	 */
	@Override
	@Nullable
	public ComponentHierarchyBase getParent()
	{
		return parent;
	}

	/**
	 * Sets the page this component belongs on.
	 * Null to reset the page hierarchy for all children
	 * <p>
	 *
	 * @param page
	 * 		A Page
	 */
	@Override
	@SuppressWarnings("unchecked")
	public J setPage(@Nullable Page page)
	{
		this.page = page;
		getChildren().forEach(child -> child.setPage(page));
		return (J) this;
	}

	/**
	 * Sets the parent of this item
	 *
	 * @param parent
	 */
	@Override
	@NotNull
	@SuppressWarnings("unchecked")
	public J setParent(@Nullable ComponentHierarchyBase parent)
	{
		this.parent = parent;
		return (J) this;
	}

	/**
	 * Adds a class name to the class list
	 * <p>
	 *
	 * @param className
	 * 		The class name to add
	 * 		<p>
	 *
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

	@Override
	@NotNull
	@SuppressWarnings("unchecked")
	public J addClass(@NotNull ICSSClassName className)
	{
		if (!getClasses().contains(className.toString()))
		{
			getClasses().add(className.toString());
			return (J) this;
		}
		else
		{
			return (J) this;
		}
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
		getChildrenHierarchy().forEach(child
				                               ->
		                               {
			                               for (Object o : child.getVariables())
			                               {
				                               allVariables.add(o.toString());
			                               }
		                               });
		return allVariables;
	}

	/**
	 * Set the theme applied to this component
	 * <p>
	 *
	 * @param theme
	 * 		The JQuery UI theme to apply to the component
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
	 * Takes a component off this components child list
	 * <p>
	 *
	 * @param childToRemove
	 * 		The child object to remove from this list
	 * 		<p>
	 *
	 * @return True if the child was part of this components children's list
	 */
	@Override
	public boolean remove(@Nullable C childToRemove)
	{
		ComponentHierarchyBase comp = (ComponentHierarchyBase) childToRemove;
		getChildren().remove(comp);
		return true;
	}

	/**
	 * Removes a class name from this component
	 * <p>
	 *
	 * @param className
	 * 		Class Name to Remove
	 * 		<p>
	 *
	 * @return True if the class was removed, False if the class was not part of the collection
	 */
	@Override
	@SuppressWarnings("unchecked")
	public J removeClass(@Nullable String className)
	{
		getClasses().remove(className);
		return (J) this;
	}

	/**
	 * Processes the angular objects into a map
	 *
	 * @param next
	 * @param map
	 */
	@SuppressWarnings("unchecked")
	private void processAngularObjects(@NotNull ComponentHierarchyBase next, @NotNull Map<String, JavaScriptPart> map)
	{
		next.getAngularObjects().forEach((key, value) ->
		                                 {
			                                 try
			                                 {
				                                 JavaScriptPart part = JavaScriptPart.class.cast(next.getAngularObjects().get(key));
				                                 map.put((String) key, part);
			                                 }
			                                 catch (ClassCastException cce)
			                                 {
				                                 log.log(Level.WARNING, "Incorrect Object Type, Perhaps JavaScriptPart?", cce);
			                                 }
			                                 catch (Exception e)
			                                 {
				                                 log.log(Level.WARNING, "Unable to render angular object", e);
			                                 }
		                                 });
	}

	/**
	 * Renders each child
	 *
	 * @return
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
		getChildren().forEach(child -> sb.append(getNewLine()).append(child.toString(isTiny() ? 0 : getCurrentTabIndents() + 1)));
		if (renderAfterChildren() != null)
		{
			sb.append(renderAfterChildren());
		}
		return sb;
	}

	/**
	 * Renders String content before the children tags are rendered
	 * <p>
	 *
	 * @return Custom HTML String to be inserted before Children tags
	 */
	@Override
	@Nullable
	protected StringBuilder renderBeforeChildren()
	{
		return null;
	}

	/**
	 * Renders String content after the children tags are rendered
	 * <p>
	 *
	 * @return Custom HTML String to be inserted after Children tags
	 */
	@Override
	@Nullable
	protected StringBuilder renderAfterChildren()
	{
		return null;
	}

	/**
	 * Ensure if there are children that new lines must be rendered
	 * <p>
	 * Boxed for operating purposes
	 *
	 * @return
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
	 * Returns the parent id for the parent property so JSON doesn't go circular
	 *
	 * @return
	 */
	@JsonProperty("parent")
	@Nullable
	private String getParentJSON()
	{
		if (getParent() != null)
		{
			return getParent().getID();
		}
		return null;
	}

	/**
	 * Adds in the JavaScript References for all the children
	 *
	 * @return
	 */
	@Override
	@NotNull
	public Set<CSSReference> getCssReferencesAll()
	{
		Set<CSSReference> allCss = super.getCssReferencesAll();
		getChildren().forEach(child ->
		                      {
			                      for (Object jScript : child.getCssReferencesAll())
			                      {
				                      allCss.add(CSSReference.class.cast(jScript));
			                      }
		                      });
		return allCss;
	}

	/**
	 * Adds in the JavaScript References for all the children
	 *
	 * @return
	 */
	@Override
	@NotNull
	@SuppressWarnings("unchecked")
	public Set<JavascriptReference> getJavascriptReferencesAll()
	{
		Set<JavascriptReference> allJs = super.getJavascriptReferencesAll();
		getChildren().forEach(child ->
		                      {
			                      for (Object jScript : child.getJavascriptReferencesAll())
			                      {
				                      allJs.add(JavascriptReference.class.cast(jScript));
			                      }
		                      });
		return allJs;
	}

	/**
	 * Returns a complete list of events
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unused")
	public Set<Feature> getFeaturesAll()
	{
		Set<Feature> allFeatures = new LinkedHashSet<>();
		getChildrenHierarchy().forEach(child ->
		                               {
			                               for (Object event : child.getFeatures())
			                               {
				                               allFeatures.add(Feature.class.cast(event));
			                               }
		                               });
		return allFeatures;
	}

	/**
	 * Finds the event in all this components and child components
	 *
	 * @param eventId
	 *
	 * @return
	 */
	@Override
	@Nullable
	public ComponentEventBase findEvent(String eventId)
	{
		for (ComponentHierarchyBase child : getChildren())
		{
			for (Object jScript : child.getEventsAll())
			{
				if (Event.class.cast(jScript).getID().equals(eventId))
				{
					return (ComponentEventBase) jScript;
				}
			}
		}
		return null;
	}

	/**
	 * Overrides this and all below components to set tiny false
	 *
	 * @param tiny
	 *
	 * @return super.tiny
	 */
	@Override
	@NotNull
	public J setTiny(boolean tiny)
	{
		getChildren().forEach(child -> child.setTiny(tiny));
		return super.setTiny(tiny);
	}

	/**
	 * Initialize all children
	 */
	@Override
	public void init()
	{
		if (!isInitialized())
		{
			getChildren().forEach(ComponentHierarchyBase::init);
		}
		super.init();
	}

	@Override
	public boolean equals(Object o)
	{
		return this == o || o instanceof ComponentHierarchyBase && (super.equals(o));
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	/**
	 * Pre-Configure the children tree
	 *
	 * @return
	 */
	@Override
	@NotNull
	public String toString()
	{
		getChildren().forEach(next ->
		                      {
			                      if (!next.isConfigured())
			                      {
				                      next.preConfigure();
			                      }
		                      });
		return super.toString();
	}

	/**
	 * Iterates through all the children checking if a boolean property has been placed, Returns the first instance of true or always false
	 *
	 * @param propertyName
	 * @param returnBool
	 *
	 * @return
	 */
	@SuppressWarnings("unused")
	public boolean readChildrenPropertyFirstResult(String propertyName, boolean returnBool)
	{
		for (ComponentHierarchyBase next : getChildrenHierarchy(true))
		{
			if (next.hasProperty(propertyName))
			{
				String propertyValue = next.getProperties().get(propertyName).toString();
				try
				{
					return Boolean.parseBoolean(propertyValue);
				}
				catch (Exception e)
				{
					log.log(Level.WARNING, "Property value was not a boolean.", e);
				}
			}
		}
		return false;
	}

	/**
	 * Takes an instance and wraps around the component
	 * <p>
	 * e.g. BSRow.wrap(div) = iv class="row"myComponent//div
	 *
	 * @param component
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J wrap(@NotNull ComponentHierarchyBase component)
	{
		ComponentHierarchyBase existingParent = component.getParent();
		if (existingParent != null)
		{
			existingParent.remove(component);
			existingParent.add(this);
			getChildren().add(component);
		}
		return (J) this;
	}

	@Override
	public void preConfigure()
	{
		if (!isInitialized())
		{
			init();
		}

		if (!isConfigured())
		{
			Set<ComponentHierarchyBase> clonedBase = getChildren();
			clonedBase.forEach(feature ->
			                   {
				                   if (!feature.isConfigured())
				                   {
					                   feature.preConfigure();
				                   }
			                   });
			if (hasChildren())
			{
				setNewLineForClosingTag(true);
			}
			else
			{
				setNewLineForClosingTag(false);
			}
		}
		super.preConfigure();
	}

	/**
	 * Renders the classes array as an in-line class string
	 *
	 * @return
	 */
	@Override
	@NotNull
	protected StringBuilder renderClasses()
	{
		StringBuilder sb = new StringBuilder();
		Set eachClass = getClasses();
		eachClass.forEach(a ->
		                  {
			                  if (a instanceof String)
			                  {
				                  sb.append(a).append(STRING_SPACE);
			                  }
		                  });
		if (sb.length() > 0)
		{
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb;
	}

	@Override
	@NotNull
	@SuppressWarnings("unchecked")
	public J cloneComponent()
	{
		ComponentHierarchyBase cloned = super.cloneComponent();
		return (J) cloned;
	}

	@Nullable
	@SuppressWarnings({"unchecked", "unused"})
	public <T extends ComponentHierarchyBase> T findChild(@NotNull Class<T> childType)
	{
		for (ComponentHierarchyBase componentHierarchyBase : getChildren())
		{
			if (componentHierarchyBase.getClass().equals(childType))
			{
				return (T) componentHierarchyBase;
			}
		}
		return null;
	}

	/**
	 * Convenience method for checking if a tag has already been added as a child
	 * <p>
	 *
	 * @param classType
	 * 		The Tag type to check for
	 * 		<p>
	 *
	 * @return The Obvious
	 */
	@SuppressWarnings("unused")
	protected boolean containsClass(@NotNull Class classType)
	{
		for (ComponentHierarchyBase next : getChildren())
		{
			if (next.getClass().equals(classType))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Enumeration to remove
	 *
	 * @param className
	 *
	 * @return
	 */
	public boolean removeClass(@NotNull Enum className)
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
	 * Returns the first parent in the chain of the class type
	 *
	 * @param <T>
	 * 		The class type
	 * @param parentType
	 * 		The type to look for
	 *
	 * @return
	 */
	@Nullable
	public <T extends ComponentHierarchyBase> T findParent(Class<T> parentType)
	{
		return findParent(this, parentType);
	}

	/**
	 * Recursive method for going through the parent base
	 *
	 * @param root
	 * 		The root
	 * @param parentType
	 * 		The parent type
	 *
	 * @return
	 */
	@Nullable
	@SuppressWarnings("unchecked")
	private <T extends ComponentHierarchyBase> T findParent(@NotNull ComponentHierarchyBase root, @NotNull Class<T> parentType)
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

	@Override
	public void destroy()
	{
		if (children != null)
		{
			for (ComponentHierarchyBase next : children)
			{
				try
				{
					next.destroy();
				}
				catch (Exception e)
				{
					log.log(Level.SEVERE, "UUnable to destroy", e);
				}
			}
		}
		if (this.children != null)
		{
			this.children.clear();
			this.children = null;
		}
		if (this.classes != null)
		{
			this.classes.clear();
			this.classes = null;
		}
		super.destroy();
	}

	/**
	 * Returns all the feature queries associated to this component and all its children
	 *
	 * @return
	 */
	@Override
	@NotNull
	public Set<StringBuilder> getQueriesAll()
	{
		Set<StringBuilder> reallyAllQueries = new LinkedHashSet<>();
		Set<ComponentHierarchyBase> allComponents = getChildrenHierarchy(true);
		allComponents.forEach((Consumer<? super ComponentHierarchyBase>) componentQuery -> processComponentQueries(componentQuery, reallyAllQueries));
		return reallyAllQueries;
	}

	/**
	 * Processes the queries
	 *
	 * @param componentQuery
	 * @param reallyAllQueries
	 */
	@SuppressWarnings("unchecked")
	private void processComponentQueries(@NotNull ComponentHierarchyBase componentQuery, @NotNull Set<StringBuilder> reallyAllQueries)
	{
		List<ComponentFeatureBase> features = new ArrayList<>(componentQuery.getFeatures());
		features.remove(null);
		features.forEach(feature ->
		                 {
			                 if (feature != null)
			                 {
				                 feature.preConfigure();
				                 reallyAllQueries.add(feature.renderJavascript());
			                 }
		                 });

		features.sort(comparing(ComponentFeatureBase::getSortOrder));
		Set<ComponentEventBase> events = componentQuery.getEvents();
		events.remove(null);
		events.forEach(event ->
		               {
			               if (event != null)
			               {
				               event.preConfigure();
				               reallyAllQueries.add(event.renderJavascript());
			               }
		               });

		features.sort(comparing(ComponentFeatureBase::getSortOrder));
		List<ComponentHierarchyBase> myQueries = new ArrayList<>();
		myQueries.removeIf(Objects::isNull);
		myQueries.forEach(query ->
		                  {
			                  query.preConfigure();
			                  reallyAllQueries.add(query.renderJavascript());
		                  });
	}
}
