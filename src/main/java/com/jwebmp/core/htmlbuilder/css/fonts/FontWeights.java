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
 * The font-weight property sets how thick or thin characters in text should be displayed.
 * Default value: normal
 * Inherited: yes
 * Version: CSS1
 * JavaScript syntax: object.style.fontWeight="900"
 *
 * @author GedMarc
 */
public enum FontWeights
		implements CSSEnumeration<FontWeights>
{
	/**
	 * Defines lighter characters
	 */
	Lighter,
	/**
	 * Defines normal characters. This is default
	 */
	Normal,
	/**
	 * Defines thick characters
	 */
	Bold,
	/**
	 * Defines thicker characters
	 */
	Bolder,
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
		return "style.fontWeight";
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
	public FontWeights getDefault()
	{
		return Unset;
	}

}
