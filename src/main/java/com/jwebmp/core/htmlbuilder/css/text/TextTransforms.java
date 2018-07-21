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

package com.jwebmp.core.htmlbuilder.css.text;

import com.jwebmp.core.base.client.CSSVersions;
import com.jwebmp.core.htmlbuilder.css.CSSEnumeration;

/**
 * @author Marc Magon
 */
public enum TextTransforms
		implements CSSEnumeration<TextTransforms>
{
	/**
	 * No capitalization. The text renders as it is. This is default
	 */
	None,
	/**
	 * Transforms the first character of each word to uppercase
	 */
	Capitalize,
	/**
	 * Transforms the text to uppercase
	 */
	Uppercase,
	/**
	 * Transforms the text to lowercase
	 */
	Lowercase,
	/**
	 * Inherits the value
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
		return name().toLowerCase();
	}

	@Override
	public String getJavascriptSyntax()
	{
		return "style.textTransform";
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
	public TextTransforms getDefault()
	{
		return Unset;
	}
}
