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

package com.jwebmp.core.htmlbuilder.css.text;

import com.jwebmp.core.base.client.CSSVersions;
import com.jwebmp.core.htmlbuilder.css.CSSEnumeration;

/**
 * Definition and Usage
 * <p>
 * The direction property specifies the text direction/writing direction.
 * Default value: ltr
 * Inherited: yes
 * Version: CSS2
 * JavaScript syntax: object.style.direction="rtl"
 *
 * @author GedMarc
 */
public enum TextDirections
		implements CSSEnumeration<TextDirections>
{
	/**
	 * The writing direction is right-to-left
	 */
	Rtl,
	/**
	 * The writing direction is left-to-right. This is default
	 */
	Ltr,
	/**
	 * Specifies that the value of the direction property should be inherited from the parent element
	 */
	Inherited,
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
		return "style.textDecoration";
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
	public TextDirections getDefault()
	{
		return Unset;
	}
}
