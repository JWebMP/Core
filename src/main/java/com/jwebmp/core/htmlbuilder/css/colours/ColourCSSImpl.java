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

package com.jwebmp.core.htmlbuilder.css.colours;

import com.fasterxml.jackson.annotation.JsonValue;
import com.jwebmp.core.htmlbuilder.css.annotations.CSSImplementationAdapter;
import com.jwebmp.core.htmlbuilder.css.annotations.CSSImplementationClass;
import com.jwebmp.core.htmlbuilder.css.annotations.CSSImplementationValue;

/**
 * Defines a Colour by anything
 *
 * @author GedMarc
 */
public class ColourCSSImpl
		extends CSSImplementationAdapter<ColourCSS, ColourCSSImpl>
		implements CSSImplementationValue, CSSImplementationClass<ColourCSS, ColourCSSImpl>
{

	/**
	 * Version 1
	 */

	/**
	 * The actual value
	 */
	private String value;

	/**
	 * Constructs a new Colour CSS
	 */
	public ColourCSSImpl()
	{
		//No need for anything here
	}

	/**
	 * Constructs a new colour with a value
	 *
	 * @param value
	 */
	public ColourCSSImpl(String value)
	{
		this.value = value;
	}

	/**
	 * Sets the actual value
	 *
	 * @param value
	 */
	public void setValue(String value)
	{
		this.value = value;
	}

	public ColourCSSImpl setValue(ColourRGBAImpl value)
	{
		this.value = new ColourRGBAImpl().setBlue(value.Blue())
		                                 .setGreen(value.Green())
		                                 .setRed(value.Red())
		                                 .setAlpha(value.Alpha())
		                                 .toString();
		return this;
	}

	/**
	 * Sets the colour value associated
	 *
	 * @param value
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ColourCSSImpl setValue(ColourCSSImpl value)
	{
		this.value = value.value();
		return this;
	}

	@JsonValue
	/**
	 * Returns the actual value
	 *
	 * @return
	 */ public String value()
	{
		return value;
	}

	/**
	 * Sets the colour
	 *
	 * @param value
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ColourCSSImpl setValue(ColourNames value)
	{
		this.value = value.toString();
		return this;
	}

	/**
	 * Sets the colour
	 *
	 * @param value
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ColourCSSImpl setValue(ColourHexImpl value)
	{
		this.value = value.toString();
		return this;
	}

	/**
	 * Sets the colour
	 *
	 * @param value
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ColourCSSImpl setValue(ColourRGBImpl value)
	{
		this.value = new ColourRGBImpl().setBlue(value.Blue())
		                                .setGreen(value.Green())
		                                .setRed(value.Red())
		                                .toString();
		return this;
	}

	/**
	 * Returns the value of this colour
	 *
	 * @return
	 */
	@Override
	public String toString()
	{
		return value == null ? "" : value;
	}

}
