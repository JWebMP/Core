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
package za.co.mmagon.jwebswing.base.interfaces;

import java.util.List;
import java.util.Map;
import za.co.mmagon.jwebswing.*;
import za.co.mmagon.jwebswing.base.ComponentBase;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.base.references.JavascriptReference;
import za.co.mmagon.jwebswing.htmlbuilder.css.themes.Theme;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 *
 * @author GedMarc
 * @param <C> All allowed children
 * @param <J> This Class
 *
 * @since Sep 26, 2016
 *
 */
public interface IComponentHierarchyBase<C, J extends ComponentBase>
{

    /**
     * Add a new child to this component
     * <p>
     * @param position Position in the hierarchy to add the component
     * @param newChild The child to be added
     * <p>
     * @return The new child added
     */
    J add(int position, C newChild);

    /**
     * Add a new child to this component
     * <p>
     * @param newChild The child to be added
     * <p>
     * @return The new child added
     */
    J add(C newChild);

    /**
     * Returns null sets the text
     *
     * @param text
     *
     * @return
     */
    J add(String text);

    /**
     * Adds the given CSS Class Name with the given references
     * <p>
     * @param classComponent
     *
     * @return
     */
    boolean addClass(CSSComponent classComponent);

    /**
     * Returns All the angular objects mapped to this component and its children
     *
     * @return
     */
    Map<String, JavaScriptPart> getAngularObjectsAll();

    /**
     * Returns the children ArrayList of type Component
     * <p>
     * @return An array list of components
     */
    List<ComponentHierarchyBase> getChildren();

    /**
     * Get an array list of all children and their children recursively Includes this object
     * <p>
     * @return A complete array list of all children at time of call
     */
    List<ComponentHierarchyBase> getChildrenHierarchy();

    /**
     * Get an array list of all children and their children recursively Excludes this object
     * <p>
     * @param trues Whether or not to include this component
     * <p>
     * @return A complete array list of all children at time of call
     */
    List<ComponentHierarchyBase> getChildrenHierarchy(boolean trues);

    /**
     * Adds the children of this component onto the array list coming in
     * <p>
     * @param componentsToAddTo The component Array List to add to
     * <p>
     * @return original components added with
     */
    List<ComponentHierarchyBase> getChildrenHierarchy(List<ComponentHierarchyBase> componentsToAddTo);

    /**
     * Adds in the JavaScript References for all the children
     *
     * @return
     */
    List<CSSReference> getCssReferencesAll();

    /**
     * Returns a complete list of events
     *
     * @return
     */
    List<Event> getEventsAll();

    /**
     * Adds in the JavaScript References for all the children
     *
     * @return
     */
    List<JavascriptReference> getJavascriptReferencesAll();

    /**
     * Get the page this component exists on
     * <p>
     * @return A Page
     */
    Page getPage();

    /**
     * Gets the parent of this hierarchy item
     *
     * @return
     */
    ComponentHierarchyBase getParent();

    /**
     * Returns all the feature queries associated to this component and all its children
     *
     * @return
     */
    List<StringBuilder> getQueriesAll();

    /**
     * *
     * Returns all the variables for all the components
     *
     * @return
     */
    List<String> getVariablesAll();

    /**
     * Returns if this object has children or not
     * <p>
     * @return true if there are children attached
     */
    boolean hasChildren();

    /**
     * Takes a component off this components child list
     * <p>
     * @param childToRemove The child object to remove from this list
     * <p>
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
     * @param page A Page
     *
     * @return This Class
     */
    J setPage(Page page);

    /**
     * Sets the parent of this item
     *
     * @param parent
     *
     * @return This Class
     */
    J setParent(ComponentHierarchyBase parent);

    /**
     * Overrides this and all below components to set tiny false
     *
     * @param tiny
     *
     * @return
     */
    J setTiny(boolean tiny);

    /**
     * Pre-Configure the children tree and extracts the JSON
     *
     * @return
     */
    @Override
    String toString();

    /**
     * Returns the HTML with the specified tab count
     *
     * @param tabCount
     *
     * @return Indented HTML
     */
    String toString(Integer tabCount);

    /**
     * Adds a class name to the class list
     * <p>
     * @param className The class name to add
     * <p>
     * @return True if it was added, false if it already existed
     */
    J addClass(String className);

    /**
     * Removes a class name from this component
     * <p>
     * @param className Class Name to Remove
     * <p>
     * @return True if the class was removed, False if the class was not part of the collection
     */
    boolean removeClass(String className);

    /**
     * Sets the ID and adds the attribute to the global set
     *
     * @param id
     *
     * @return
     */
    J setID(String id);

    /**
     * Adds a class name with the given css class name compatible
     *
     * @param className
     *
     * @return
     */
    J addClass(ICSSClassName className);

    /**
     * Adds the class at the given position
     *
     * @param position
     * @param className
     *
     * @return
     */
    public J addClass(int position, ICSSClassName className);

    /**
     * Returns a complete list of all class names associated with this component
     * <p>
     * @return
     */
    List<String> getClasses();

    /**
     * Set the theme applied to this component
     * <p>
     * @param theme The JQuery UI theme to apply to the component
     *
     * @return This Class
     */
    J addTheme(Theme theme);
}
