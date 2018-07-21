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
package com.jwebmp.core.htmlbuilder.css.borders;

import com.jwebmp.core.base.client.CSSVersions;
import com.jwebmp.core.htmlbuilder.css.CSSDetail;
import com.jwebmp.core.htmlbuilder.css.annotations.CSSImplementationAdapter;
import com.jwebmp.core.htmlbuilder.css.annotations.CSSImplementationClass;
import com.jwebmp.core.htmlbuilder.css.colours.ColourCSSImpl;
import com.jwebmp.core.htmlbuilder.css.colours.ColourNames;
import com.jwebmp.core.htmlbuilder.css.enumarations.BorderStyles;
import com.jwebmp.core.htmlbuilder.css.measurement.MeasurementCSSImpl;
import com.jwebmp.core.utilities.StaticStrings;

/**
 * CSS Border Properties
 * <p>
 * The CSS border properties allow you to specify the style, width, and color of an element's border.
 * <p>
 *
 * @author GedMarc
 * @since 18 Jan 2016
 */
public class BorderLeftCSSImpl
		extends CSSImplementationAdapter<BorderLeftCSS, BorderLeftCSSImpl>
		implements CSSImplementationClass<BorderLeftCSS, BorderLeftCSSImpl>
{

	private static final long serialVersionUID = 1L;

	@CSSDetail(cssName = "border-left-color",
			cssVersion = CSSVersions.CSS21)
	private ColourCSSImpl borderLeftColor;
	@CSSDetail(cssName = "border-left-color",
			cssVersion = CSSVersions.CSS21)
	private ColourNames borderLeftColor$;
	@CSSDetail(cssName = "border-left-style",
			cssVersion = CSSVersions.CSS21)
	private BorderStyles borderLeftStyle;
	@CSSDetail(cssName = "border-left-width",
			cssVersion = CSSVersions.CSS21)
	private MeasurementCSSImpl borderLeftWidth;

	public BorderLeftCSSImpl()
	{
		//Nothing needed
	}

	@Override
	public String toString()
	{
		String out = "";
		out += borderLeftWidth + StaticStrings.STRING_SPACE;
		out += borderLeftStyle + StaticStrings.STRING_SPACE;
		out += borderLeftColor + StaticStrings.STRING_SPACE;
		out += borderLeftColor$ + StaticStrings.STRING_SPACE;
		out = out.replaceAll("null", "");
		out = out.trim();
		return out;
	}

	/**
	 * Gets the colour of the bottom left border
	 *
	 * @return
	 */
	public ColourCSSImpl getBorderLeftColor()
	{
		return borderLeftColor;
	}

	/**
	 * Sets the border width
	 *
	 * @param borderLeftColor
	 */
	public void setBorderLeftColor(ColourCSSImpl borderLeftColor)
	{
		this.borderLeftColor = borderLeftColor;
	}

	/**
	 * Gets the colour of the left border
	 *
	 * @return
	 */
	public ColourNames getBorderLeftColor$()
	{
		return borderLeftColor$;
	}

	/**
	 * Sets the border colour
	 *
	 * @param borderLeftColor$
	 */
	public void setBorderLeftColor$(ColourNames borderLeftColor$)
	{
		this.borderLeftColor$ = borderLeftColor$;
	}

	/**
	 * Gets the style of the left border
	 *
	 * @return
	 */
	public BorderStyles getBorderLeftStyle()
	{
		return borderLeftStyle;
	}

	/**
	 * Sets the border style
	 *
	 * @param borderLeftStyle
	 */
	public void setBorderLeftStyle(BorderStyles borderLeftStyle)
	{
		this.borderLeftStyle = borderLeftStyle;
	}

	/**
	 * Sets the style of the left border
	 *
	 * @return
	 */
	public MeasurementCSSImpl getBorderLeftWidth()
	{
		return borderLeftWidth;
	}

	/**
	 * Sets the border width
	 *
	 * @param borderLeftWidth
	 */
	public void setBorderLeftWidth(MeasurementCSSImpl borderLeftWidth)
	{
		this.borderLeftWidth = borderLeftWidth;
	}

}
