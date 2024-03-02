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

package com.jwebmp.core.htmlbuilder.css.measurement;

import com.jwebmp.core.base.client.CSSVersions;
import com.jwebmp.core.htmlbuilder.css.enumarations.CSSEnumeration;

/**
 * @author GedMarc
 */
public enum MeasurementTypes
		implements CSSEnumeration<MeasurementTypes>
{
	/**
	 * Any basic percentage
	 */
	Percent(true, "%"),
	/**
	 * Inches
	 */
	Inch(true, "in"),
	/**
	 * Centimeter
	 */
	Centimeter(true, "cm"),
	/**
	 * Millimeter
	 */
	Millimeter(true, "mm"),
	/**
	 * Points
	 */
	Points(true, "pt"),
	/**
	 * 1em is equal to the current font size. 2em means 2 times the size of the current font. E.g., if an element is displayed with a font of 12 pt, then '2em' is 24 pt. The 'em'
	 * is a very useful unit
	 * in CSS, since it can adapt automatically to the font that the reader uses
	 */
	EM(true, "em"),
	/**
	 * one ex is the x-height of a font (x-height is usually about half the font-size)
	 */
	EX(true, "ex"),
	/**
	 * Pica's
	 */
	Pica(true, "pi"),
	/**
	 * Pixels the default
	 */
	Pixels(true, "px"),
	/**
	 * If the value requires quotes
	 */
	None(false, "");
	private final boolean requiresQuotes;
	/**
	 * Any annotations
	 */
	private final String htmlAnnotation;

	/**
	 * Any basic measurement type
	 *
	 * @param requiresQuotes
	 * @param htmlAnnotation
	 */
	MeasurementTypes(boolean requiresQuotes, String htmlAnnotation)
	{
		this.requiresQuotes = requiresQuotes;
		this.htmlAnnotation = htmlAnnotation;
	}

	/**
	 * Returns a measurement type from the annotation
	 *
	 * @param annotation
	 *
	 * @return
	 */
	public static MeasurementTypes getFromAnnotation(String annotation)
	{
		for (MeasurementTypes measurementTypes : values())
		{
			if (measurementTypes.getHtmlAnnotation()
			                    .equalsIgnoreCase(annotation))
			{
				return measurementTypes;
			}
		}
		return null;
	}

	public String getHtmlAnnotation()
	{
		return htmlAnnotation;
	}

	public boolean isRequiresQuotes()
	{
		return requiresQuotes;
	}

	@Override
	public String getJavascriptSyntax()
	{
		return "";
	}

	@Override
	public CSSVersions getCSSVersion()
	{
		return null;
	}

	/**
	 * Returns the formatted value
	 *
	 * @return
	 */
	@Override
	public String getValue()
	{
		return getHtmlAnnotation();
	}

	/**
	 * Returns the default annotation of None
	 *
	 * @return
	 */
	@Override
	public MeasurementTypes getDefault()
	{
		return None;
	}

	/**
	 * Returns the final HTML annotation
	 *
	 * @return
	 */
	@Override
	public String toString()
	{
		return getHtmlAnnotation();
	}
}
