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
package com.jwebmp.core.htmlbuilder.css.text;

import com.jwebmp.core.htmlbuilder.css.annotations.CSSAnnotationType;
import com.jwebmp.core.htmlbuilder.css.colours.ColourCSS;
import com.jwebmp.core.htmlbuilder.css.measurement.MeasurementCSS;

import java.lang.annotation.*;

/**
 * @author GedMarc
 * @since 18 Jan 2016
 */
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.LOCAL_VARIABLE, ElementType.PACKAGE, ElementType.METHOD, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@CSSAnnotationType
@Documented
public @interface TextShadows
{

	/**
	 * Required. The position of the horizontal shadow. Negative values are allowed
	 *
	 * @return
	 */
	MeasurementCSS HShadow();

	/**
	 * Required. The position of the vertical shadow. Negative values are allowed
	 *
	 * @return
	 */
	MeasurementCSS VShadow();

	/**
	 * Optional. The blur radius. Default value is 0
	 *
	 * @return
	 */
	MeasurementCSS BlurRadius() default @MeasurementCSS;

	/**
	 * Optional. The color of the shadow. Look at CSS Color Values for a complete list of possible color values
	 *
	 * @return
	 */
	ColourCSS Color() default @ColourCSS;
}
