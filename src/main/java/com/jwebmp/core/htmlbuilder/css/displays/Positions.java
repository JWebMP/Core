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

package com.jwebmp.core.htmlbuilder.css.displays;

import com.jwebmp.core.base.client.CSSVersions;
import com.jwebmp.core.htmlbuilder.css.CSSEnumeration;
import com.jwebmp.core.htmlbuilder.css.annotations.CSSAnnotationType;

/**
 * Definition and Usage
 * <p>
 * The position property specifies the type of positioning method used for an element (static, relative, absolute or fixed).
 * Default value: static
 * Inherited: no
 * Version: CSS2
 * JavaScript syntax: object.style.position="absolute"
 *
 * @author GedMarc
 */
@CSSAnnotationType
public enum Positions
		implements CSSEnumeration<Positions>
{
	/**
	 * The element is positioned relative to its first positioned (not static) ancestor element
	 */
	Absolute,
	/**
	 * The element is positioned relative to the browser window
	 */
	Fixed,
	/**
	 * The element is positioned relative to its normal position, so "left:20" adds 20 pixels to the element's LEFT position
	 */
	Relative,
	/**
	 * The value of the position property is inherited from the parent element
	 */
	Static,
	/**
	 * Sets this property to its default value
	 * <p>
	 * see http://www.w3schools.com/cssref/css_initial.asp
	 */
	Initial,
	/**
	 * Inherits this property from its parent element.
	 * <p>
	 * see http://www.w3schools.com/cssref/css_inherit.asp
	 */
	Inherit,
	/**
	 * Sets this field as not set
	 */
	Unset;

	@Override
	public String getJavascriptSyntax()
	{
		return "style.position";
	}

	@Override
	public CSSVersions getCSSVersion()
	{
		return CSSVersions.CSS1;
	}

	@Override
	public String getValue()
	{
		return name();
	}

	@Override
	public Positions getDefault()
	{
		return Unset;
	}

}
