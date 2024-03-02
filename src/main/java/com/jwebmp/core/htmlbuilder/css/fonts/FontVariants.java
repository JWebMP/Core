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
import com.jwebmp.core.htmlbuilder.css.enumarations.CSSEnumeration;
import com.guicedee.services.jsonrepresentation.json.StaticStrings;

/**
 * Definition and Usage
 * <p>
 * In a small-caps font, all lowercase letters are converted to uppercase letters. However, the converted uppercase letters appears in a smaller font size than the original
 * uppercase letters in the
 * text.
 * <p>
 * The font-variant property specifies whether or not a text should be displayed in a small-caps font.
 * Default value: normal
 * Inherited: yes
 * Version: CSS1
 * JavaScript syntax: object.style.fontVariant="small-caps"
 *
 * @author GedMarc
 */
public enum FontVariants
		implements CSSEnumeration<FontVariants>
{
	/**
	 * The browser displays a normal font. This is default
	 */
	Normal,
	/**
	 * The browser displays a small-caps font
	 */
	Small_Caps,
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
		return name().toLowerCase()
		             .replace(StaticStrings.CHAR_UNDERSCORE, StaticStrings.CHAR_DASH);
	}

	@Override
	public String getJavascriptSyntax()
	{
		return "style.fontVariant";
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
	public FontVariants getDefault()
	{
		return Unset;
	}

}
