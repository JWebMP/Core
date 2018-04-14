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

package com.jwebmp.htmlbuilder.css.displays;

import com.jwebmp.base.client.CSSVersions;
import com.jwebmp.htmlbuilder.css.CSSEnumeration;
import com.jwebmp.htmlbuilder.css.annotations.CSSAnnotationType;

/**
 * Definition and Usage
 * <p>
 * The overflow property specifies what happens if content overflows an element's box.
 * Default value: visible
 * Inherited: no
 * Animatable: no. Read about animatable
 * Version: CSS2
 * JavaScript syntax: object.style.overflow="scroll"
 *
 * @author Marc Magon
 */
@CSSAnnotationType
public enum Overflows
		implements CSSEnumeration<Overflows>
{
	/**
	 * If overflow is clipped, a scroll-bar should be added to see the rest of the content
	 */
	Auto,
	/**
	 * The overflow is clipped, and the rest of the content will be invisible
	 */
	Hidden,
	/**
	 * The overflow is clipped, but a scroll-bar is added to see the rest of the content
	 */
	Scroll,
	/**
	 * The overflow is not clipped. It renders outside the element's box. This is default
	 */
	Visible,
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
	public String toString()
	{
		return name().toLowerCase();
	}

	@Override
	public String getJavascriptSyntax()
	{
		return "style.overflow";
	}

	@Override
	public CSSVersions getCSSVersion()
	{
		return CSSVersions.CSS2;
	}

	@Override
	public String getValue()
	{
		return name();
	}

	@Override
	public Overflows getDefault()
	{
		return Unset;
	}
}
