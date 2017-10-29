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

import java.util.*;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	private List<ComponentHierarchyBase> children;

	/**
	 * My Parent
	 */
	@JsonIgnore
	private ComponentHierarchyBase parent;

	/**
	 * The list of class names for this object
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<String> classes;

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
	public ComponentHierarchyBase(ComponentTypes componentType)
	{
		super(componentType);
	}

	/**
	 * Returns a Hierarchy Base interface of this component
	 *
	 * @return
	 */
	public IComponentHierarchyBase asHierarchyBase()
	{
		return this;
	}

	/**
	 * Add a new child to this component
	 * <p>
	 *
	 * @param position
	 * 		The position to add the child to
	 * @param newChild
	 * 		The child to be added
	 * 		<p>
	 *
	 * @return The new child added
	 */
	@Override
	public J add(int position, C newChild)
	{
		if (newChild == null)
		{
			return (J) this;
		}
		ComponentHierarchyBase comp = ComponentHierarchyBase.class.cast(newChild);
		if (comp != null)
		{
			comp.setParent(this);
			comp.setTiny(isTiny());
			comp.setPage(getPage());
			getChildren().add(position, comp);
		}
		return (J) this;
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
	public J add(C newChild)
	{
		if (newChild == null)
		{
			return (J) this;
		}
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
	public J add(String text)
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

		for (Iterator<ComponentHierarchyBase> iterator = getChildrenHierarchy(true).iterator(); iterator.hasNext(); )
		{
			ComponentHierarchyBase next = iterator.next();
			for (Iterator iterator1 = next.getAngularObjects().entrySet().iterator(); iterator1.hasNext(); )
			{
				try
				{
					Object ne = iterator1.next();
					if (ne instanceof String)
					{
						String next1 = (String) iterator1.next();
						JavaScriptPart part = (JavaScriptPart) next.getAngularObjects().get(next1);
						map.put(next1, part);
					}
					else if (ne instanceof Map)
					{

					}
				}
				catch (ClassCastException cce)
				{
					log.log(Level.WARNING, "Incorrect Object Type, Perhaps JavaScriptPart?", cce);
				}
				catch (Exception e)
				{
					log.log(Level.WARNING, "Unable to render angular object", e);
				}
			}

		}
		return map;
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
	public List<ComponentHierarchyBase> getChildrenHierarchy(boolean trues)
	{
		List<ComponentHierarchyBase> components = new ArrayList<>();
		if (trues)
		{
			components.add(this);
		}
		getChildrenHierarchy(components);

		return components;
	}

	/**
	 * Returns the children ArrayList of type Component
	 * <p>
	 *
	 * @return An array list of components
	 */
	@Override
	public final List<ComponentHierarchyBase> getChildren()
	{
		if (children == null)
		{
			children = new ArrayList<>();
		}
		return children;
	}

	/**
	 * Get an array list of all children and their children recursively Includes this object
	 * <p>
	 *
	 * @return A complete array list of all children at time of call
	 */
	@Override
	public List<ComponentHierarchyBase> getChildrenHierarchy()
	{
		return getChildrenHierarchy(true);
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
	public List<ComponentHierarchyBase> getChildrenHierarchy(List<ComponentHierarchyBase> componentsToAddTo)
	{
		getChildren().forEach(child
				                      ->
		                      {
			                      if (child != null)
			                      {
				                      if (!componentsToAddTo.contains(child))
				                      {
					                      componentsToAddTo.add(child);
				                      }
				                      child.getChildrenHierarchy(componentsToAddTo);
			                      }
		                      });
		return componentsToAddTo;
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
	public boolean remove(C childToRemove)
	{
		ComponentHierarchyBase comp = (ComponentHierarchyBase) childToRemove;
		getChildren().remove(comp);
		return true;
	}

	/**
	 * Renders each child
	 *
	 * @return
	 */
	@Override
	protected StringBuilder renderChildren()
	{
		StringBuilder sb = new StringBuilder();
		if (renderBeforeChildren() != null)
		{
			sb.append(renderBeforeChildren());
		}
		getChildren().forEach(child
				                      ->
		                      {
			                      sb.append(getNewLine()).append(child.toString(isTiny() ? 0 : getCurrentTabIndents() + 1));
		                      });
		if (renderAfterChildren() != null)
		{
			sb.append(renderAfterChildren());
		}
		return sb;
	}

	/**
	 * Get the page this component exists on
	 * <p>
	 *
	 * @return A Page
	 */
	@Override
	public Page getPage()
	{
		if (page == null)
		{
			setPage(new Page());
		}
		return page;
	}

	/**
	 * Sets the page this component belongs on.
	 * <p>
	 *
	 * @param page
	 * 		A Page
	 */
	@Override
	public J setPage(Page page)
	{
		this.page = page;
		getChildren().forEach(child
				                      ->
		                      {
			                      child.setPage(page);
		                      });
		return (J) this;
	}

	/**
	 * Gets the parent of this hierarchy item
	 *
	 * @return
	 */
	@Override
	public ComponentHierarchyBase getParent()
	{
		return parent;
	}

	/**
	 * Sets the parent of this item
	 *
	 * @param parent
	 */
	@Override
	public J setParent(ComponentHierarchyBase parent)
	{
		this.parent = parent;
		return (J) this;
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
			return getParent().getID();
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
	 * Adds in the JavaScript References for all the children
	 *
	 * @return
	 */
	@Override
	public List<JavascriptReference> getJavascriptReferencesAll()
	{
		List<JavascriptReference> allJs = super.getJavascriptReferencesAll();
		getChildren().forEach(child
				                      ->
		                      {
			                      for (Iterator<JavascriptReference> iterator1 = child.getJavascriptReferencesAll().iterator(); iterator1.hasNext(); )
			                      {
				                      JavascriptReference jScript = iterator1.next();
				                      if (!allJs.contains(jScript))
				                      {
					                      allJs.add(jScript);
				                      }
			                      }
		                      });
		return allJs;
	}

	/**
	 * Returns a complete list of events
	 *
	 * @return
	 */
	@Override
	public List<Event> getEventsAll()
	{
		ArrayList<Event> allEvents = new ArrayList<>();
		getChildrenHierarchy(true).forEach(child
				                                   ->
		                                   {
			                                   for (Iterator<Event> iterator1 = child.getEvents().iterator(); iterator1.hasNext(); )
			                                   {
				                                   Event event = iterator1.next();
				                                   if (event != null)
				                                   {
					                                   allEvents.add(event);
				                                   }
			                                   }
		                                   });
		return allEvents;
	}

	/**
	 * Returns a complete list of events
	 *
	 * @return
	 */
	public List<Feature> getFeaturesAll()
	{
		ArrayList<Feature> allFeatures = new ArrayList<>();
		getChildrenHierarchy().forEach(child
				                               ->
		                               {
			                               for (Iterator<Feature> iterator1 = child.getFeatures().iterator(); iterator1.hasNext(); )
			                               {
				                               Feature event = iterator1.next();
				                               if (event != null)
				                               {
					                               allFeatures.add(event);
				                               }
			                               }
		                               });
		return allFeatures;
	}

	/**
	 * Adds in the JavaScript References for all the children
	 *
	 * @return
	 */
	@Override
	public List<CSSReference> getCssReferencesAll()
	{
		List<CSSReference> allCss = super.getCssReferencesAll();
		getChildren().forEach(child
				                      ->
		                      {
			                      for (Iterator<CSSReference> iterator1 = child.getCssReferencesAll().iterator(); iterator1.hasNext(); )
			                      {
				                      CSSReference jScript = iterator1.next();
				                      if (!allCss.contains(jScript))
				                      {
					                      allCss.add(jScript);
				                      }
			                      }
		                      });
		return allCss;
	}

	/**
	 * Finds the event in all this components and child components
	 *
	 * @param eventId
	 *
	 * @return
	 */
	@Override
	public ComponentEventBase getEvent(String eventId)
	{
		for (ComponentHierarchyBase child : getChildren())
		{
			for (Iterator<ComponentEventBase> iterator1 = child.getEventsAll().iterator(); iterator1.hasNext(); )
			{
				ComponentEventBase jScript = iterator1.next();
				if (jScript.getID().equals(eventId))
				{
					return jScript;
				}
			}
		}
		return null;
	}

	/**
	 * *
	 * Returns all the variables for all the components
	 *
	 * @return
	 */
	@Override
	public List<String> getVariablesAll()
	{
		ArrayList<String> allVariables = new ArrayList<>();
		getChildrenHierarchy().forEach(child
				                               ->
		                               {
			                               for (Iterator it = child.getVariables().iterator(); it.hasNext(); )
			                               {
				                               String variable = (String) it.next();
				                               if (!allVariables.contains(variable))
				                               {
					                               allVariables.add(variable);
				                               }
			                               }
		                               });
		return allVariables;
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
	public J addClass(String className)
	{
		if (!getClasses().contains(className))
		{
			getClasses().add(className);
			return (J) this;
		}
		else
		{
			return (J) this;
		}
	}

	/**
	 * *
	 * Returns all the JavaScript for all the components
	 *
	 * @return
	 */
	@Override
	public StringBuilder renderJavascriptAll()
	{
		preConfigure();
		StringBuilder sb = new StringBuilder();
		ArrayList<String> allScripts = new ArrayList<>();
		ArrayList<StringBuilder> queries = (ArrayList<StringBuilder>) getQueriesAll();
		queries.forEach(a ->
		                {
			                if (!a.toString().isEmpty() && !allScripts.contains(a.toString()))
			                {
				                allScripts.add(a.toString());
			                }
		                });
		allScripts.forEach(sb.append(getNewLine())::append);
		return sb;
	}

	/**
	 * Overrides this and all below components to set tiny false
	 *
	 * @param tiny
	 *
	 * @return super.tiny
	 */
	@Override
	public J setTiny(boolean tiny)
	{
		getChildren().forEach(child
				                      ->
		                      {
			                      child.setTiny(tiny);
		                      });
		return super.setTiny(tiny);
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
	public boolean addClass(CSSComponent classComponent)
	{
		String className = classComponent.getID();
		getPage().getBody().add(classComponent);
		if (!getClasses().contains(className))
		{
			getClasses().add(className);
			return true;
		}
		else
		{
			return false;
		}
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
	public boolean removeClass(String className)
	{
		if (getClasses().contains(className))
		{
			getClasses().remove(className);
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Renders String content before the children tags are rendered
	 * <p>
	 *
	 * @return Custom HTML String to be inserted before Children tags
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
	 */
	@Override
	protected StringBuilder renderAfterChildren()
	{
		return null;
	}

	/**
	 * Set the theme applied to this component
	 * <p>
	 *
	 * @param theme
	 * 		The JQuery UI theme to apply to the component
	 */
	@Override
	public J addTheme(Theme theme)
	{
		if (theme != null)
		{
			if (!getThemes().contains(theme))
			{
				getThemes().add(theme);
				addClass(theme.getClassName());
			}
		}
		return (J) this;
	}

	/**
	 * Initialize all children
	 */
	@Override
	public void init()
	{
		if (!isInitialized())
		{

			List<ComponentHierarchyBase> clonedBase = getChildren();
			clonedBase.stream().filter(a -> a != null).forEach(comp
					                                                   ->
			                                                   {
				                                                   ComponentHierarchyBase cfb = comp;
				                                                   cfb.init();
			                                                   });
		}
		super.init();
	}

	/**
	 * Pre-Configure the children tree
	 *
	 * @return
	 */
	@Override
	public String toString()
	{
		getChildren().forEach(next
				                      ->
		                      {
			                      if (!next.isConfigured())
			                      {
				                      next.preConfigure();
			                      }
		                      });
		return super.toString();
	}

	/**
	 * Returns the HTML with the specified tab count
	 *
	 * @param tabCount
	 *
	 * @return Indented HTML
	 */
	@Override
	public String toString(Integer tabCount)
	{
//        preConfigure();
		return super.toString(tabCount);
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
	public J wrap(ComponentHierarchyBase component)
	{
		ComponentHierarchyBase existingParent = component.getParent();
		if (component.getParent() != null)
		{
			existingParent.remove(component);
			existingParent.add(this);
		}
		getChildren().add(component);
		return (J) this;
	}

	/**
	 * Returns all the feature queries associated to this component and all its children
	 *
	 * @return
	 */
	@Override
	public List<StringBuilder> getQueriesAll()
	{
		ArrayList<StringBuilder> reallyAllQueries = new ArrayList<>();
		List<ComponentHierarchyBase> allComponents = getChildrenHierarchy(true);
		allComponents.forEach((Consumer<? super ComponentHierarchyBase>) componentQuery ->
		{
			List<ComponentFeatureBase> features = componentQuery.getFeatures();
			features.remove(null);
			features.forEach(feature ->
			                 {
				                 if (feature != null)
				                 {
					                 feature.preConfigure();
					                 reallyAllQueries.add(feature.renderJavascript());
				                 }
			                 });
			Collections.sort(features, Comparator.comparing(ComponentFeatureBase::getSortOrder));
			List<ComponentEventBase> events = componentQuery.getEvents();
			events.remove(null);
			events.forEach(event ->
			               {
				               if (event != null)
				               {
					               event.preConfigure();
					               reallyAllQueries.add(event.renderJavascript());
				               }
			               });
			Collections.sort(events, Comparator.comparing(ComponentFeatureBase::getSortOrder));
			List<ComponentHierarchyBase> myQueries = new ArrayList<>();// componentQuery.getQueriesAll();
			myQueries.remove(null);
			myQueries.forEach(query ->
			                  {
				                  if (query != null)
				                  {
					                  query.preConfigure();
					                  reallyAllQueries.add(query.renderJavascript());
				                  }
			                  });
		});

		return reallyAllQueries;
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
			List<ComponentHierarchyBase> clonedBase = getChildren();
			clonedBase.stream().filter(a -> a != null).forEach(feature
					                                                   ->
			                                                   {
				                                                   ComponentHierarchyBase cfb = feature;
				                                                   if (cfb != null && !cfb.isConfigured())
				                                                   {
					                                                   cfb.preConfigure();
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
	protected StringBuilder renderClasses()
	{
		StringBuilder sb = new StringBuilder();
		getClasses().forEach(clazz -> sb.append(clazz).append(STRING_SPACE));
		if (sb.length() > 0)
		{
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb;
	}

	public <T extends ComponentHierarchyBase> T findChild(Class<T> childType)
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
	 * Iterates through all the children checking if a boolean property has been placed, Returns the first instance of true or always false
	 *
	 * @param propertyName
	 * @param returnBool
	 *
	 * @return
	 */
	public boolean readChildrenPropertyFirstResult(String propertyName, boolean returnBool)
	{
		for (ComponentHierarchyBase next : getChildrenHierarchy(true))
		{
			if (next.hasProperty(propertyName))
			{
				String propertyValue = next.getProperties().get(propertyName).toString();
				if (propertyValue != null && !propertyValue.isEmpty())
				{
					try
					{
						Boolean bool = Boolean.parseBoolean(propertyValue);
						if (bool)
						{
							return bool;
						}
					}
					catch (Exception e)
					{
						log.log(Level.WARNING, "Property value was not a boolean.", e);
					}
				}
			}
		}
		return false;
	}

	/**
	 * Returns a complete list of all class names associated with this component
	 * <p>
	 *
	 * @return
	 */
	@Override
	public List<String> getClasses()
	{
		if (classes == null)
		{
			classes = new ArrayList<>();
		}
		return classes;
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
	protected boolean containsClass(Class classType)
	{
		for (Iterator<ComponentHierarchyBase> iterator = getChildren().iterator(); iterator.hasNext(); )
		{
			ComponentHierarchyBase next = iterator.next();
			if (next.getClass().equals(classType))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public J addClass(ICSSClassName className)
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
	 * Adds the class at the given position
	 *
	 * @param position
	 * @param className
	 *
	 * @return
	 */
	@Override
	public J addClass(int position, ICSSClassName className)
	{
		if (!getClasses().contains(className.toString()))
		{
			getClasses().add(position, className.toString());
			return (J) this;
		}
		else
		{
			return (J) this;
		}
	}

	/**
	 * Ensure if there are children that new lines must be rendered
	 *
	 * @return
	 */
	@Override
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
	 * Enumeration to remove
	 *
	 * @param className
	 *
	 * @return
	 */
	public boolean removeClass(Enum className)
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
	public <T extends ComponentHierarchyBase> T findParent(Class<T> parentType)
	{
		return findParent(this, parentType);
	}

	@Override
	public J cloneComponent()
	{
		ComponentHierarchyBase cloned = super.cloneComponent();
		return (J) cloned;
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
	private <T extends ComponentHierarchyBase> T findParent(ComponentHierarchyBase root, Class<T> parentType)
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
				if (next != null)
				{
					try
					{
						next.destroy();
						next = null;
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
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

}
