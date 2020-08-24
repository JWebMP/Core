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
import com.guicedee.guicedinjection.json.StaticStrings;

/**
 * Definition and Usage
 * <p>
 * The text-decoration property specifies the decoration added to text.
 * <p>
 * Note: The color of the decoration should be set by the "color" property.
 * Default value: none
 * Inherited: no
 * Version: CSS1
 * JavaScript syntax: object.style.textDecoration="overline"
 *
 * @author GedMarc
 */
public enum TextDecorations
		implements CSSEnumeration<TextDecorations>
{
	/**
	 * Defines a normal text. This is default
	 */
	None,
	/**
	 * Defines underlined text
	 */
	Underline,
	/**
	 * Defines overline text
	 */
	Overline,
	/**
	 * Strike through text
	 */
	Line_Through,
	/**
	 * Blink Text
	 * Note: The "blink" value is not supported in IE, Chrome, or Safari.
	 */
	Blink,
	/**
	 * Specifies that the value of the text-decoration property should be inherited from the parent element
	 * Note: The value "inherit" is not supported in IE7 and earlier. IE8 requires a !DOCTYPE. IE9 supports "inherit".
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
		return "style.textDecoration";
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
	public TextDecorations getDefault()
	{
		return Unset;
	}
}
