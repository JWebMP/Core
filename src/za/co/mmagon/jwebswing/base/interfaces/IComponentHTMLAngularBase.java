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

import java.util.Map;
import za.co.mmagon.jwebswing.base.ComponentBase;
import za.co.mmagon.jwebswing.base.angular.AngularAttributes;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 *
 * @author GedMarc
 * @param <J> This Type (Always this class)
 * @since Sep 26, 2016
 * 
 */
public interface IComponentHTMLAngularBase<J extends ComponentBase> 
{

    /**
     * Sets an Angular Attribute
     *
     * @param attribute
     * @param value
     * @return
     */
    J addAttribute(AngularAttributes attribute, String value);

    /**
     * Adds an object for watching across an application
     *
     * @param name       The variable name to use
     * @param dataObject The data object to map
     * @return This for chain setting
     */
    J addDto(String name, JavaScriptPart dataObject);

    /**
     * Returns the angular objects mapped to this component
     *
     * @return
     */
    Map<String, JavaScriptPart> getAngularObjects();

    /**
     * Gets an angular attribute
     *
     * @param attribute
     * @return
     */
    String getAttribute(AngularAttributes attribute);

    /**
     * Adds all the attributes associated with angular
     *
     * @return
     */
    Map<Enum, String> getAttributesAll();

    /**
     * Returns the DTO currently mapped
     *
     * @param <T> JavascriptPart
     * @param name The name of the DTO to map
     * @param classType The class type
     * @return Null if not available
     */
     <T extends JavaScriptPart> T getDto(String name, Class<T> classType);

}
