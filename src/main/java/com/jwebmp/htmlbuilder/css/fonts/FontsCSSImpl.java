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

package com.jwebmp.htmlbuilder.css.fonts;

import com.jwebmp.base.client.CSSVersions;
import com.jwebmp.htmlbuilder.css.CSSDetail;
import com.jwebmp.htmlbuilder.css.annotations.CSSImplementationAdapter;
import com.jwebmp.htmlbuilder.css.annotations.CSSImplementationClass;
import com.jwebmp.htmlbuilder.css.measurement.MeasurementCSSImpl;

/**
 * The CSS font properties define the font family, boldness, size, and the style of a text.
 * <p>
 * see http://www.w3schools.com/css/css_font.asp
 *
 * @author Marc Magon
 */
public class FontsCSSImpl
		extends CSSImplementationAdapter<FontsCSS, FontsCSSImpl>
		implements CSSImplementationClass<FontsCSS, FontsCSSImpl>
{

	private static final long serialVersionUID = 1L;

	@CSSDetail(cssName = "font-family",
			cssVersion = CSSVersions.CSS21)
	private FontFamilies fontFamily;
	@CSSDetail(cssName = "font-size",
			cssVersion = CSSVersions.CSS21)
	private MeasurementCSSImpl fontSize;
	@CSSDetail(cssName = "font-style",
			cssVersion = CSSVersions.CSS21)
	private FontStyles fontStyle;
	@CSSDetail(cssName = "font-variant",
			cssVersion = CSSVersions.CSS21)
	private FontVariants fontVariant;
	@CSSDetail(cssName = "font-weight",
			cssVersion = CSSVersions.CSS21)
	private FontWeights fontWeight;
	@CSSDetail(cssName = "font-weight",
			cssVersion = CSSVersions.CSS21)
	private Integer fontWeight$;

	/**
	 * Returns the font family assigned
	 *
	 * @return
	 */
	public FontFamilies getFontFamily()
	{
		return fontFamily;
	}

	/**
	 * Sets the font family
	 *
	 * @param fontFamily
	 */
	public void setFontFamily(FontFamilies fontFamily)
	{
		this.fontFamily = fontFamily;
	}

	/**
	 * Sets the font size
	 *
	 * @return
	 */
	public MeasurementCSSImpl getFontSize()
	{
		return fontSize;
	}

	/**
	 * Sets the font size
	 *
	 * @param fontSize
	 */
	public void setFontSize(MeasurementCSSImpl fontSize)
	{
		this.fontSize = fontSize;
	}

	/**
	 * Set the font style
	 *
	 * @return
	 */
	public FontStyles getFontStyle()
	{
		return fontStyle;
	}

	/**
	 * Sets the font style
	 *
	 * @param fontStyle
	 */
	public void setFontStyle(FontStyles fontStyle)
	{
		this.fontStyle = fontStyle;
	}

	/**
	 * Sets the applicable font variant
	 *
	 * @return
	 */
	public FontVariants getFontVariant()
	{
		return fontVariant;
	}

	/**
	 * Sets the font variant
	 *
	 * @param fontVariant
	 */
	public void setFontVariant(FontVariants fontVariant)
	{
		this.fontVariant = fontVariant;
	}

	/**
	 * Sets the font weight
	 *
	 * @return
	 */
	public FontWeights getFontWeight()
	{
		return fontWeight;
	}

	/**
	 * Sets the font weight
	 *
	 * @param fontWeight
	 */
	public void setFontWeight(FontWeights fontWeight)
	{
		this.fontWeight = fontWeight;
	}

	/**
	 * Sets the font weight
	 *
	 * @return
	 */
	public int getFontWeight$()
	{
		return fontWeight$;
	}

	/**
	 * Sets the font weight
	 *
	 * @param fontWeight$
	 */
	public void setFontWeight$(Integer fontWeight$)
	{
		this.fontWeight$ = fontWeight$;
	}

}
