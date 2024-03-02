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

import com.jwebmp.core.htmlbuilder.css.enumarations.CSSAnnotationType;
import com.jwebmp.core.htmlbuilder.css.colours.ColourCSS;
import com.jwebmp.core.htmlbuilder.css.colours.ColourNames;
import com.jwebmp.core.htmlbuilder.css.enumarations.BorderStyles;
import com.jwebmp.core.htmlbuilder.css.measurement.MeasurementCSS;

import java.lang.annotation.*;

/**
 * CSS Border Properties
 * <p>
 * The CSS border properties allow you to specify the style, width, and color of an element's border.
 * <p>
 *
 * @author GedMarc
 * @since 18 Jan 2016
 * 		see http://www.w3schools.com/css/css_border.asp
 */
@CSSAnnotationType
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.LOCAL_VARIABLE, ElementType.PACKAGE, ElementType.METHOD, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface BorderCSS
{

	/**
	 * The border shorthand property sets all the border properties in one declaration.
	 *
	 * @return
	 */
	Border Border() default @Border;

	/**
	 * The border-top shorthand property sets all the top border properties in one declaration.
	 *
	 * @return
	 */
	BorderBottomCSS BorderBottom() default @BorderBottomCSS;

	/**
	 * The border-top shorthand property sets all the top border properties in one declaration.
	 *
	 * @return
	 */
	BorderBottomCSS BorderLeft() default @BorderBottomCSS;

	/**
	 * The border-top shorthand property sets all the top border properties in one declaration.
	 *
	 * @return
	 */
	BorderBottomCSS BorderRight() default @BorderBottomCSS;

	/**
	 * The border-top shorthand property sets all the top border properties in one declaration.
	 *
	 * @return
	 */
	BorderBottomCSS BorderTop() default @BorderBottomCSS;

	/**
	 * Sets the color of the bottom border
	 *
	 * @return
	 */
	ColourCSS BorderBottomColor() default @ColourCSS;

	/**
	 * Sets the color of the bottom border
	 *
	 * @return
	 */
	ColourNames BorderBottomColor$() default ColourNames.Unset;

	/**
	 * Sets the Style of the bottom border
	 *
	 * @return
	 */
	BorderStyles BorderBottomStyle() default BorderStyles.Unset;

	/**
	 * Sets the width of the bottom border
	 *
	 * @return
	 */
	MeasurementCSS BorderBottomWidth() default @MeasurementCSS;

	/**
	 * Sets the colour of the left border
	 *
	 * @return
	 */
	ColourCSS BorderLeftColor() default @ColourCSS;

	/**
	 * Sets the colour of the left border
	 *
	 * @return
	 */
	ColourNames BorderLeftColor$() default ColourNames.Unset;

	/**
	 * Sets the style of the left border
	 *
	 * @return
	 */
	BorderStyles BorderLeftStyle() default BorderStyles.Unset;

	/**
	 * Sets the width of the left border
	 *
	 * @return
	 */
	MeasurementCSS BorderLeftWidth() default @MeasurementCSS;

	/**
	 * Sets the color of the right border
	 *
	 * @return
	 */
	ColourCSS BorderRightColor() default @ColourCSS;

	/**
	 * Sets the color of the right border
	 *
	 * @return
	 */
	ColourNames BorderRightColor$() default ColourNames.Unset;

	/**
	 * Sets the style of the right border
	 *
	 * @return
	 */
	BorderStyles BorderRightStyle() default BorderStyles.Unset;

	/**
	 * Sets the style of the right border
	 *
	 * @return
	 */
	MeasurementCSS BorderRightWidth() default @MeasurementCSS;

	/**
	 * Sets the color of the top border
	 *
	 * @return
	 */
	ColourCSS BorderTopColor() default @ColourCSS;

	/**
	 * Sets the color of the top border
	 *
	 * @return
	 */
	ColourNames BorderTopColor$() default ColourNames.Unset;

	/**
	 * Sets the style of the top border
	 *
	 * @return
	 */
	BorderStyles BorderTopStyle() default BorderStyles.Unset;

	/**
	 * Sets the width of the top border
	 *
	 * @return
	 */
	MeasurementCSS BorderTopWidth() default @MeasurementCSS;
}
