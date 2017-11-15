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

import za.co.mmagon.jwebswing.base.ComponentBase;
import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.base.references.JavascriptReference;
import za.co.mmagon.jwebswing.base.servlets.enumarations.RequirementsPriority;

import java.util.Set;

/**
 * @param <J> Always this object
 *
 * @author GedMarc
 */
public interface IComponentDependancyBase<J extends ComponentBase>
{
	
	/**
	 * Adds a CSS Reference to the collection
	 *
	 * @param cssReference
	 *
	 * @return
	 */
	J addCssReference(CSSReference cssReference);
	
	/**
	 * Adds a JavaScript Reference to the collection
	 *
	 * @param jsReference
	 *
	 * @return
	 */
	J addJavaScriptReference(JavascriptReference jsReference);
	
	
	/**
	 * Returns a clone of the given component type
	 *
	 * @return
	 */
	J cloneComponent();
	
	/**
	 * Returns the strings of the CSS Links this will use
	 * <p>
	 *
	 * @return ArrayList of all CSS File Links in String format
	 */
	Set<CSSReference> getCssReferences();
	
	/**
	 * Return all the CSS References associated with this component
	 *
	 * @return
	 */
	Set<CSSReference> getCssReferencesAll();
	
	/**
	 * Returns all the CSS references with the given priority
	 *
	 * @param priority The priority of the references to retrieve
	 *
	 * @return A new array list of all the requested for references
	 */
	Set<CSSReference> getCssReferencesAll(RequirementsPriority priority);
	
	/**
	 * Returns the JavaScript links attached to this component
	 * <p>
	 *
	 * @return
	 */
	Set<JavascriptReference> getJavascriptReferences();
	
	/**
	 * Return all the CSS References associated with this component.
	 * Override and add the references required for the functionality
	 *
	 * @return
	 */
	Set<JavascriptReference> getJavascriptReferencesAll();
	
	/**
	 * Returns all the CSS references with the given priority
	 * Override and add the references required for the functionality
	 *
	 * @param priority The priority of the references to retrieve
	 *
	 * @return A new array list of all the requested for references
	 */
	Set<JavascriptReference> getJavascriptReferencesAll(RequirementsPriority priority);
	
	
	/**
	 * Removes the CSS Reference from the Component
	 *
	 * @param cssReference
	 *
	 * @return
	 */
	J removeCssReference(CSSReference cssReference);
	
	/**
	 * Removes the CSS Reference from the Component
	 *
	 * @param jsReference
	 *
	 * @return
	 */
	J removeJavaScriptReference(JavascriptReference jsReference);
	
}
