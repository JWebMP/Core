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

package za.co.mmagon.jwebswing.htmlbuilder.css;

import za.co.mmagon.jwebswing.base.client.CSSVersions;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.CSSAnnotationType;

import java.lang.annotation.*;

/**
 * Defines CSS Details.
 * Marks for copy between objects
 *
 * @author GedMarc
 * @version 1.0
 * @since Nov 18, 2016
 */
@Target(
		{
				ElementType.FIELD, ElementType.TYPE, ElementType.LOCAL_VARIABLE
		})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@CSSAnnotationType
@Documented
public @interface CSSDetail
{
	/**
	 * The CSS Version this field applies to. Default 2.1
	 *
	 * @return
	 */
	CSSVersions cssVersion() default CSSVersions.CSS21;

	/**
	 * The name of this CSS class
	 *
	 * @return
	 */
	String cssName() default "";

	/**
	 * The JSon name
	 *
	 * @return
	 */
	String jsonName() default "";

	/**
	 * The JavaScript name
	 *
	 * @return
	 */
	String jsName() default "";

	/**
	 * Tooltip if any
	 *
	 * @return
	 */
	String tooltip() default "";

	/**
	 * What to do display when falling back
	 *
	 * @return
	 */
	String fallback() default "";

	/**
	 * Referenced Field Name
	 *
	 * @return
	 */
	String field() default "";

	/**
	 * Whether or not this tag is flagged as important
	 *
	 * @return
	 */
	boolean isImportant() default false;
}
