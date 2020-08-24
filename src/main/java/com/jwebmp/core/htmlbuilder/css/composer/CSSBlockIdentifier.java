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

package com.jwebmp.core.htmlbuilder.css.composer;

import com.jwebmp.core.htmlbuilder.css.enumarations.CSSTypePosition;
import com.guicedee.guicedinjection.json.StaticStrings;

/**
 * Type of CSS Block Identifier, e.g. class, ID, In-Line, or inherited
 *
 * @author MMagon
 * @version 1.0
 * @since 07 Apr 2013
 */
public enum CSSBlockIdentifier
{
	/**
	 * #id #firstname Selects the element with id="firstname"
	 */
	Id(1.0, StaticStrings.STRING_HASH, CSSTypePosition.Before),
	/**
	 * .class .intro Selects all elements with class="intro"
	 */
	Class(1.0, StaticStrings.STRING_DOT, CSSTypePosition.Before),
	/**
	 * element p Selects all p elements
	 */
	Element(1.0, "", CSSTypePosition.Before),
	/**
	 * Render the CSS as a style attribute
	 */
	Inline(1.0, "", CSSTypePosition.After),
	/**
	 * Puts the CSS inside the header. Referenced by tagname.themename
	 */
	Theme(1.0, StaticStrings.STRING_DOT, CSSTypePosition.Before),;
	/**
	 * Where to place the position
	 */
	private final CSSTypePosition cssPosition;
	/**
	 * The physical version of this CSS
	 */
	private double cssVersion;
	/**
	 * The name to represent
	 */
	private String cssName;

	/**
	 * Constructs a new CSS Render Type
	 *
	 * @param cssVersion
	 * 		The version the CSS Render type works on
	 * @param cssName
	 * 		The physical display name of the selector
	 * @param cssPosition
	 * 		Where to place the type
	 */
	CSSBlockIdentifier(double cssVersion, String cssName, CSSTypePosition cssPosition)
	{
		this.cssVersion = cssVersion;
		this.cssName = cssName;
		this.cssPosition = cssPosition;
	}

	/**
	 * Returns the capable CSS Version
	 *
	 * @return
	 */
	public double getCssVersion()
	{
		return cssVersion;
	}

	/**
	 * Sets the capable CSS Version
	 *
	 * @param cssVersion
	 */
	public void setCssVersion(double cssVersion)
	{
		this.cssVersion = cssVersion;
	}

	/**
	 * Returns the CSS Name of this type
	 *
	 * @return
	 */
	public String getCssName()
	{
		return cssName;
	}

	/**
	 * Returns the CSS Name of this type
	 *
	 * @param cssName
	 */
	public void setCssName(String cssName)
	{
		this.cssName = cssName;
	}

	/**
	 * Returns where this CSS name type is placed
	 *
	 * @return
	 */
	public CSSTypePosition getCssPosition()
	{
		return cssPosition;
	}
}
