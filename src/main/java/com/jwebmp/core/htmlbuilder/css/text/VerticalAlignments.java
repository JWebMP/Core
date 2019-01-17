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
import com.jwebmp.core.utilities.StaticStrings;

/**
 * Definition and Usage
 * <p>
 * The vertical-align property sets the vertical alignment of an element.
 * Default value: baseline
 * Inherited: no
 * Version: CSS1
 * JavaScript syntax: object.style.verticalAlign="bottom"
 *
 * @author GedMarc
 */
public enum VerticalAlignments
		implements CSSEnumeration<VerticalAlignments>
{
	/**
	 * Align the baseline of the element with the baseline of the parent element. This is default
	 */
	Baseline,
	/**
	 * Aligns the element as it was subscript
	 */
	Sub,
	/**
	 * Aligns the element as it was superscript
	 */
	Super,
	/**
	 * The top of the element is aligned with the top of the tallest element on the line
	 */
	Top,
	/**
	 * The top of the element is aligned with the top of the parent element's font
	 */
	Text_Top,
	/**
	 * The element is placed in the middle of the parent element
	 */
	Middle,
	/**
	 * The bottom of the element is aligned with the lowest element on the line
	 */
	Bottom,
	/**
	 * The bottom of the element is aligned with the bottom of the parent element's font
	 */
	Text_Bottom,
	/**
	 * Specifies that the value of the vertical-align property should be inherited from the parent element
	 */
	Inherited,
	/**
	 * Sets this field as not set
	 */
	Unset;

	@Override
	public String toString()
	{
		return super.toString()
		            .toLowerCase()
		            .replace(StaticStrings.CHAR_UNDERSCORE, StaticStrings.CHAR_DASH);
	}

	@Override
	public String getJavascriptSyntax()
	{
		return "style.verticalAlign";
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
	public VerticalAlignments getDefault()
	{
		return Unset;
	}

}
