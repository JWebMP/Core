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
package com.jwebmp.core.htmlbuilder.css.tables;

import com.jwebmp.core.htmlbuilder.css.enumarations.CSSAnnotationType;
import com.jwebmp.core.htmlbuilder.css.measurement.MeasurementCSS;

import java.lang.annotation.*;

/**
 * The look of an HTML table can be greatly improved with CSS:
 *
 * @author GedMarc
 * @since 18 Jan 2016
 */
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.LOCAL_VARIABLE, ElementType.PACKAGE, ElementType.METHOD, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@CSSAnnotationType
@Documented
public @interface TableCSS
{

	/**
	 * Specifies whether or not table borders should be collapsed
	 *
	 * @return
	 */
	TableBorderCollapse BorderCollapse() default TableBorderCollapse.Unset;

	/**
	 * Sets where the caption will appear
	 *
	 * @return
	 */
	TableCaptionSides TableCaptionSide() default TableCaptionSides.Unset;

	/**
	 * Sets the border spacing for the table
	 *
	 * @return
	 */
	MeasurementCSS BorderSpacing() default @MeasurementCSS;

}
