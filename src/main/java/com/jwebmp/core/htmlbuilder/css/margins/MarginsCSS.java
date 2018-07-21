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
package com.jwebmp.core.htmlbuilder.css.margins;

import com.jwebmp.core.htmlbuilder.css.annotations.CSSAnnotationType;
import com.jwebmp.core.htmlbuilder.css.enumarations.MarginSetting;
import com.jwebmp.core.htmlbuilder.css.measurement.MeasurementCSS;

import java.lang.annotation.*;

/**
 * The CSS margin properties are used to generate space around elements.
 * <p>
 * The margin properties set the size of the white space OUTSIDE the border.
 * <p>
 *
 * @author GedMarc
 * @since 18 Jan 2016
 */
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.LOCAL_VARIABLE, ElementType.PACKAGE, ElementType.METHOD, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@CSSAnnotationType
@Documented
public @interface MarginsCSS
{

	/**
	 * The shorthand for margin
	 *
	 * @return
	 */
	Margin Margin() default @Margin;

	/**
	 * The CSS margin properties set the size of the white space OUTSIDE the border.
	 *
	 * @return
	 */
	MeasurementCSS MarginRight() default @MeasurementCSS;

	/**
	 * The CSS margin properties set the size of the white space OUTSIDE the border.
	 *
	 * @return
	 */
	MarginSetting MarginRight$() default MarginSetting.Unset;

	/**
	 * The CSS margin properties set the size of the white space OUTSIDE the border.
	 *
	 * @return
	 */
	MeasurementCSS MarginLeft() default @MeasurementCSS;

	/**
	 * The CSS margin properties set the size of the white space OUTSIDE the border.
	 *
	 * @return
	 */
	MarginSetting MarginLeft$() default MarginSetting.Unset;

	/**
	 * The CSS margin properties set the size of the white space OUTSIDE the border.
	 *
	 * @return
	 */
	MeasurementCSS MarginTop() default @MeasurementCSS;

	/**
	 * The CSS margin properties set the size of the white space OUTSIDE the border.
	 *
	 * @return
	 */
	MarginSetting MarginTop$() default MarginSetting.Unset;

	/**
	 * The CSS margin properties set the size of the white space OUTSIDE the border.
	 *
	 * @return
	 */
	MeasurementCSS MarginBottom() default @MeasurementCSS;

	/**
	 * The CSS margin properties set the size of the white space OUTSIDE the border.
	 *
	 * @return
	 */
	MarginSetting MarginBottom$() default MarginSetting.Unset;

}
