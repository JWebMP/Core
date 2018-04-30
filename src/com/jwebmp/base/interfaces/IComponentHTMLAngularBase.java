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
package com.jwebmp.base.interfaces;

import com.jwebmp.base.ComponentBase;
import com.jwebmp.base.angular.AngularAttributes;

import java.util.Map;

/**
 * @param <J>
 * 		This Type (Always this class)
 *
 * @author GedMarc
 * @since Sep 26, 2016
 */
public interface IComponentHTMLAngularBase<J extends ComponentBase>
{

	/**
	 * Sets an Angular Attribute
	 *
	 * @param attribute
	 * @param value
	 *
	 * @return
	 */
	J addAttribute(AngularAttributes attribute, String value);

	/**
	 * Adds an object for watching across an application
	 *
	 * @param name
	 * 		The variable name to use
	 * @param dataObject
	 * 		The data object to map
	 *
	 * @return This for chain setting
	 */
	J addDto(String name, Object dataObject);

	/**
	 * Returns the angular objects mapped to this component
	 *
	 * @return
	 */
	Map<String, Object> getAngularObjects();

	/**
	 * Gets an angular attribute
	 *
	 * @param attribute
	 *
	 * @return
	 */
	String getAttribute(AngularAttributes attribute);

	/**
	 * Returns the DTO currently mapped
	 *
	 * @param <T>
	 * 		JavascriptPart
	 * @param name
	 * 		The name of the DTO to map
	 * @param classType
	 * 		The class type
	 *
	 * @return Null if not available
	 */
	<T> T getDto(String name, Class<T> classType);

}
