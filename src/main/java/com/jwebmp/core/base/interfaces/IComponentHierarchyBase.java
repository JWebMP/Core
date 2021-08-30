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
package com.jwebmp.core.base.interfaces;

import com.jwebmp.core.*;
import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.html.interfaces.GlobalChildren;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.references.CSSReference;
import com.jwebmp.core.base.references.JavascriptReference;
import com.jwebmp.core.htmlbuilder.css.themes.Theme;
import com.jwebmp.core.htmlbuilder.javascript.events.interfaces.IEvent;
import jakarta.validation.constraints.NotNull;

import java.util.Map;
import java.util.Set;

/**
 * @param <C> All allowed children
 * @param <J> This Class
 * @author GedMarc
 * @since Sep 26, 2016
 */
@SuppressWarnings("MissingClassJavaDoc")
public interface IComponentHierarchyBase<C extends GlobalChildren, J extends IComponentHierarchyBase<C, J>>
		extends GlobalChildren
{
	/**
	 * Takes an instance and wraps around the component
	 * <p>
	 * e.g. BSRow.wrap(div) = iv class="row"myComponent//div
	 *
	 * @param component
	 * @return
	 */
	@NotNull <T extends IComponentHierarchyBase<?, ?>> T wrap(@NotNull T component);
	
	/**
	 * Takes all children and embeds them into the current children hierarchy
	 * None of the details for the transient container is kept
	 * <p>
	 * e.g. myComponent.embed(div)
	 *
	 * @param component
	 * @return
	 */
	@NotNull <T extends IComponentHierarchyBase<?, ?>> T embed(@NotNull T component);
	
	/**
	 * Add a new child to this component
	 * <p>
	 *
	 * @param newChild The child to be added
	 *                 <p>
	 * @return The new child added
	 */
	J add(C newChild);
	
	/**
	 * Adds into a specific pesition
	 *
	 * @param position
	 * @param newChild
	 * @return Always this
	 */
	J add(@NotNull Integer position, C newChild);
	
	/**
	 * Returns null sets the text
	 *
	 * @param text
	 * @return
	 */
	J add(String text);
	
	/**
	 * Adds the given CSS Class Name with the given references
	 * <p>
	 *
	 * @param classComponent
	 * @return
	 */
	J addClass(CSSComponent<?> classComponent);
	
	/**
	 * Returns All the angular objects mapped to this component and its children
	 *
	 * @return
	 */
	Map<String, Object> getAngularObjectsAll();
	
	/**
	 * Returns the children ArrayList of type Component
	 * <p>
	 *
	 * @return An array list of components
	 */
	Set<C> getChildren();
	
	/**
	 * Get an array list of all children and their children recursively Includes this object
	 * <p>
	 *
	 * @return A complete array list of all children at time of call
	 */
	Set<IComponentHierarchyBase<?, ?>> getChildrenHierarchy();
	
	/**
	 * Get an array list of all children and their children recursively Excludes this object
	 * <p>
	 *
	 * @param includeSelf Whether or not to include this component
	 *                    <p>
	 * @return A complete array list of all children at time of call
	 */
	Set<IComponentHierarchyBase<?, ?>> getChildrenHierarchy(boolean includeSelf);
	
	/**
	 * Adds the children of this component onto the array list coming in
	 * <p>
	 *
	 * @param componentsToAddTo The component Array List to add to
	 *                          <p>
	 * @return original components added with
	 */
	Set<IComponentHierarchyBase<?, ?>> getChildrenHierarchy(Set<IComponentHierarchyBase<?, ?>> componentsToAddTo);
	
	/**
	 * Adds in the JavaScript References for all the children
	 *
	 * @return
	 */
	Set<CSSReference> getCssReferencesAll();
	
	/**
	 * Returns a complete list of events
	 *
	 * @return
	 */
	Set<Event<?, ?>> getEventsAll();
	
	/**
	 * Adds in the JavaScript References for all the children
	 *
	 * @return
	 */
	Set<JavascriptReference> getJavascriptReferencesAll();
	
	/**
	 * Get the page this component exists on
	 * <p>
	 *
	 * @return A Page
	 */
	Page<?> getPage();
	
	/**
	 * Gets the parent of this hierarchy item
	 *
	 * @return
	 */
	IComponentHierarchyBase<?, ?> getParent();
	
	/**
	 * Returns all the feature queries associated to this component and all its children
	 *
	 * @return
	 */
	Set<StringBuilder> getQueriesAll();
	
	/**
	 * *
	 * Returns all the variables for all the components
	 *
	 * @return
	 */
	Set<String> getVariablesAll();
	
	/**
	 * Creates loading part objects that return an injected instance of the class associated to that part
	 *
	 * @return
	 */
	ComponentHierarchyBase<GlobalChildren, ?, ?, GlobalEvents, ?> getLoadingPart(IEvent... events);
	
	/**
	 * Returns if this object has children or not
	 * <p>
	 *
	 * @return true if there are children attached
	 */
	boolean hasChildren();
	
	/**
	 * Takes a component off this components child list
	 * <p>
	 *
	 * @param childToRemove The child object to remove from this list
	 *                      <p>
	 * @return True if the child was part of this components children's list
	 */
	boolean remove(C childToRemove);
	
	/**
	 * *
	 * Returns all the JavaScript for all the components
	 *
	 * @return
	 */
	StringBuilder renderJavascriptAll();
	
	/**
	 * Sets the page this component belongs on.
	 * <p>
	 *
	 * @param page A Page
	 * @return This Class
	 */
	J setPage(Page<?> page);
	
	/**
	 * Sets the parent of this item
	 *
	 * @param parent
	 * @return This Class
	 */
	J setParent(IComponentHierarchyBase<?, ?> parent);
	
	/**
	 * Overrides this and all below components to set tiny false
	 *
	 * @param tiny
	 * @return
	 */
	J setTiny(boolean tiny);
	
	/**
	 * Adds a class name to the class list
	 * <p>
	 *
	 * @param className The class name to add
	 *                  <p>
	 * @return True if it was added, false if it already existed
	 */
	J addClass(String className);
	
	/**
	 * Removes a class name from this component
	 * <p>
	 *
	 * @param className Class Name to Remove
	 *                  <p>
	 * @return True if the class was removed, False if the class was not part of the collection
	 */
	J removeClass(String className);
	
	/**
	 * Removes the classes from the component
	 *
	 * @param className  class name
	 * @param classNames more class names
	 * @return This object
	 */
	J removeClass(String className, String... classNames);
	
	/**
	 * Removes the classes from the component
	 *
	 * @param className  class name
	 * @param classNames more class names
	 * @return This object
	 */
	J removeClass(@NotNull Enum<?> className, Enum<?>... classNames);
	
	/**
	 * Enumeration to remove
	 *
	 * @param className
	 * @return
	 */
	boolean removeClass(@NotNull Enum<?> className);
	
	/**
	 * Sets the ID and adds the attribute to the global set
	 *
	 * @param id
	 * @return
	 */
	J setID(String id);
	
	/**
	 * Adds a class name with the given css class name compatible
	 *
	 * @param className
	 * @return
	 */
	J addClass(ICssClassName className);
	
	/**
	 * Adds a class name with the given css class name compatible
	 *
	 * @param className
	 * @return
	 */
	J addClass(ICssClassName className, ICssClassName... classNames);
	
	/**
	 * Returns a complete list of all class names associated with this component
	 * <p>
	 *
	 * @return
	 */
	Set<String> getClasses();
	
	/**
	 * Sets the classes set
	 *
	 * @param classes a new set of classes
	 */
	J setClasses(Set<String> classes);
	
	/**
	 * Set the theme applied to this component
	 * <p>
	 *
	 * @param theme The JQuery UI theme to apply to the component
	 * @return This Class
	 */
	J addTheme(Theme theme);
	
	/**
	 * Returns the first parent in the chain of the class type
	 *
	 * @param <T>        The class type
	 * @param parentType The type to look for
	 * @return
	 */
	<T extends IComponentHierarchyBase<?, ?>> T findParent(Class<T> parentType);
	
	/**
	 * Method findChild ...
	 *
	 * @param childType of type Class T
	 * @return T
	 */
	<T extends IComponentHierarchyBase<?, ?>> T findChild(@NotNull Class<T> childType);
}
