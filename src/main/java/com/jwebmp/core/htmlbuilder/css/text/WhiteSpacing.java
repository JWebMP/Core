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
import com.guicedee.services.jsonrepresentation.json.StaticStrings;

/**
 * Definition and Usage
 * <p>
 * The white-space property specifies how white-space inside an element is handled.
 * Default value: normal
 * Inherited: yes
 * Version: CSS1
 * JavaScript syntax: object.style.whiteSpace="pre"
 *
 * @author GedMarc
 */
public enum WhiteSpacing
		implements CSSEnumeration<WhiteSpacing>
{
	/**
	 * Sequences of whitespace will collapse into a single whitespace. Text will wrap when necessary. This is default
	 */
	Normal,
	/**
	 * Sequences of whitespace will collapse into a single whitespace.
	 * Text will never wrap to the next line. The text continues on the same line until a br/ tag is encountered
	 */
	NoWrap,
	/**
	 * Whitespace is preserved by the browser. Text will only wrap on line breaks Acts like the pre tag in HTML
	 */
	Pre,
	/**
	 * Sequences of whitespace will collapse into a single whitespace. Text will wrap when necessary, and on line breaks
	 */
	Pre_Line,
	/**
	 * Whitespace is preserved by the browser. Text will wrap when necessary, and on line breaks
	 */
	Pre_Wrap,
	/**
	 * Specifies that the value of the white-space property should be inherited from the parent element
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
		return "style.whiteSpace";
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
	public WhiteSpacing getDefault()
	{
		return Unset;
	}
}
