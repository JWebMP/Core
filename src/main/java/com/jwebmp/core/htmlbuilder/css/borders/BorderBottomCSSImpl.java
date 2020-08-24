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
package com.jwebmp.core.htmlbuilder.css.borders;

import com.jwebmp.core.base.client.CSSVersions;
import com.jwebmp.core.htmlbuilder.css.CSSDetail;
import com.jwebmp.core.htmlbuilder.css.annotations.CSSImplementationAdapter;
import com.jwebmp.core.htmlbuilder.css.annotations.CSSImplementationClass;
import com.jwebmp.core.htmlbuilder.css.colours.ColourCSSImpl;
import com.jwebmp.core.htmlbuilder.css.colours.ColourNames;
import com.jwebmp.core.htmlbuilder.css.enumarations.BorderStyles;
import com.jwebmp.core.htmlbuilder.css.measurement.MeasurementCSSImpl;
import com.guicedee.guicedinjection.json.StaticStrings;

/**
 * CSS Border Properties
 * <p>
 * The CSS border properties allow you to specify the style, width, and color of an element's border.
 * <p>
 *
 * @author GedMarc
 * @since 18 Jan 2016
 */
public class BorderBottomCSSImpl
		extends CSSImplementationAdapter<BorderBottomCSS, BorderBottomCSSImpl>
		implements CSSImplementationClass<BorderBottomCSS, BorderBottomCSSImpl>
{


	@CSSDetail(cssName = "border-bottom-color",
			cssVersion = CSSVersions.CSS21)
	private ColourCSSImpl borderBottomColor;
	@CSSDetail(cssName = "border-bottom-color",
			cssVersion = CSSVersions.CSS21)
	private ColourNames borderBottomColor$;
	@CSSDetail(cssName = "border-bottom-style",
			cssVersion = CSSVersions.CSS21)
	private BorderStyles borderBottomStyle;
	@CSSDetail(cssName = "border-bottom-width",
			cssVersion = CSSVersions.CSS21)
	private MeasurementCSSImpl borderBottomWidth;

	/**
	 * Default Border Bottom
	 */
	public BorderBottomCSSImpl()
	{
		//Nothing Needed
	}

	@Override
	public String toString()
	{
		String out = "";
		out += borderBottomWidth + StaticStrings.STRING_SPACE;
		out += borderBottomStyle + StaticStrings.STRING_SPACE;
		out += borderBottomColor + StaticStrings.STRING_SPACE;
		out += borderBottomColor$ + StaticStrings.STRING_SPACE;
		out = out.replaceAll("null", "");
		out = out.trim();
		return out;
	}

	/**
	 * Sets the color of the bottom border
	 *
	 * @return
	 */
	public ColourCSSImpl getBorderBottomColor()
	{
		return borderBottomColor;
	}

	/**
	 * Sets the border bottom color
	 *
	 * @param borderBottomColor
	 */
	public void setBorderBottomColor(ColourCSSImpl borderBottomColor)
	{
		this.borderBottomColor = borderBottomColor;
	}

	/**
	 * sets the colour of the bottom border
	 *
	 * @return
	 */
	public ColourNames getBorderBottomColor$()
	{
		return borderBottomColor$;
	}

	/**
	 * Sets the border bottom color
	 *
	 * @param borderBottomColor$
	 */
	public void setBorderBottomColor$(ColourNames borderBottomColor$)
	{
		this.borderBottomColor$ = borderBottomColor$;
	}

	/**
	 * Sets the style of the bottom border
	 *
	 * @return
	 */
	public BorderStyles getBorderBottomStyle()
	{
		return borderBottomStyle;
	}

	/**
	 * Sets the style of the bottom border
	 *
	 * @param borderBottomStyle
	 */
	public void setBorderBottomStyle(BorderStyles borderBottomStyle)
	{
		this.borderBottomStyle = borderBottomStyle;
	}

	/**
	 * Sets the width of the bottom border
	 *
	 * @return
	 */
	public MeasurementCSSImpl getBorderBottomWidth()
	{
		return borderBottomWidth;
	}

	/**
	 * Sets the width of the bottom border
	 *
	 * @param borderBottomWidth
	 */
	public void setBorderBottomWidth(MeasurementCSSImpl borderBottomWidth)
	{
		this.borderBottomWidth = borderBottomWidth;
	}

}
