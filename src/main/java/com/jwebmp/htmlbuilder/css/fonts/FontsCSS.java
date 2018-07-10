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

import com.jwebmp.htmlbuilder.css.CSSPropertiesFactory;
import com.jwebmp.htmlbuilder.css.annotations.CSSAnnotationType;
import com.jwebmp.htmlbuilder.css.measurement.MeasurementCSS;

import java.lang.annotation.*;

/**
 * The CSS font properties define the font family, boldness, size, and the style of a text.
 * <p>
 * see http://www.w3schools.com/css/css_font.asp
 *
 * @author Marc Magon
 */
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.LOCAL_VARIABLE, ElementType.PACKAGE, ElementType.METHOD, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@CSSAnnotationType
@Documented
public @interface FontsCSS
{

	/**
	 * The font-family property specifies the font for an element.
	 *
	 * @return
	 */
	FontFamilies FontFamily() default FontFamilies.Unset;

	/**
	 * Specifies the font size of text
	 *
	 * @return
	 */
	MeasurementCSS FontSize() default @MeasurementCSS;

	/**
	 * The font-style property specifies the font style for a text.
	 *
	 * @return
	 */
	FontStyles FontStyle() default FontStyles.Unset;

	/**
	 * The font-variant property specifies whether or not a text should be displayed in a small-caps font.
	 *
	 * @return
	 */
	FontVariants FontVariant() default FontVariants.Unset;

	/**
	 * Specifies the weight of a font
	 *
	 * @return
	 */
	FontWeights FontWeight() default FontWeights.Unset;

	/**
	 * Specifies the weight of a font
	 *
	 * @return
	 */
	int FontWeight$() default CSSPropertiesFactory.DefaultIntValue;
}
