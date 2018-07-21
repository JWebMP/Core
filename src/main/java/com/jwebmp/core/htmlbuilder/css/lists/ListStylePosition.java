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
package com.jwebmp.core.htmlbuilder.css.lists;

import com.jwebmp.core.base.client.CSSVersions;
import com.jwebmp.core.htmlbuilder.css.CSSEnumeration;

/**
 * @author GedMarc
 * @since 18 Jan 2016
 */
public enum ListStylePosition
		implements CSSEnumeration<ListStylePosition>
{
	/**
	 * Indents the marker and the text. The bullets appear inside the content flow
	 */
	Inside,
	/**
	 * Keeps the marker to the left of the text. The bullets appears outside the content flow. This is default
	 */
	Outside,
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

	ListStylePosition()
	{
	}

	@Override
	public String toString()
	{
		return name().toLowerCase();
	}

	@Override
	public String getJavascriptSyntax()
	{
		return "style.listStylePosition";
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
	public ListStylePosition getDefault()
	{
		return Unset;
	}
}
