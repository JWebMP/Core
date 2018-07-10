/*
 * Copyright (C) 2016 GedMarc
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
package com.jwebmp.htmlbuilder.css.borders;

import com.jwebmp.htmlbuilder.css.annotations.CSSAnnotationType;
import com.jwebmp.htmlbuilder.css.colours.ColourCSS;
import com.jwebmp.htmlbuilder.css.colours.ColourNames;
import com.jwebmp.htmlbuilder.css.enumarations.BorderStyles;
import com.jwebmp.htmlbuilder.css.measurement.MeasurementCSS;

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
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.LOCAL_VARIABLE, ElementType.PACKAGE, ElementType.METHOD, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@CSSAnnotationType
@Documented
public @interface BorderTopCSS
{

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
