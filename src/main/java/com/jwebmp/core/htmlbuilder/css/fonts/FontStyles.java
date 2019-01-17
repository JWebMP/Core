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

package com.jwebmp.core.htmlbuilder.css.fonts;

import com.jwebmp.core.base.client.CSSVersions;
import com.jwebmp.core.htmlbuilder.css.CSSEnumeration;

/**
 * Definition and Usage
 * <p>
 * The font-style property specifies the font style for a text.
 * Default value: normal
 * Inherited: yes
 * Version: CSS1
 * JavaScript syntax: object.style.fontStyle="italic"
 *
 * @author GedMarc
 */
public enum FontStyles
		implements CSSEnumeration<FontStyles>
{
	/**
	 * The browser displays a normal font style. This is default
	 */
	Normal,
	/**
	 * The browser displays an italic font style
	 */
	Italic,
	/**
	 * The browser displays an oblique font style
	 */
	Oblique,
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
		return "style.fontStyle";
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
	public FontStyles getDefault()
	{
		return Unset;
	}

}
