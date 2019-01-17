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
package com.jwebmp.core.base.html.interfaces;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This interface marks a class or enumeration as a valid attribute value set
 *
 * @author MMagon
 * @version 1.0
 * @since 21 Jul 2013
 */
@FunctionalInterface
public interface AttributeDefinitions
{

	/**
	 * returns the attribute tag name to use
	 *
	 * @return
	 */
	@JsonValue
	@Override
	String toString();

	/**
	 * Returns if this attribute is just a keyword, or a key/value pair
	 *
	 * @return
	 */
	boolean isKeyword();
}
