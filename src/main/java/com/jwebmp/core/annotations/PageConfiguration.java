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
package com.jwebmp.core.annotations;

import com.guicedee.services.jsonrepresentation.json.StaticStrings;

import java.lang.annotation.*;

/**
 * @author GedMarc
 * @since 05 Apr 2017
 */
@Target({ElementType.TYPE, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface PageConfiguration
{
	/**
	 * Specifies the URL that this page serves
	 *
	 * @return
	 */
	String url() default StaticStrings.STRING_FORWARD_SLASH;

	/**
	 * Specifies the type this page serves (best to leave it alone - or only use one page for error types etc)
	 *
	 * @return
	 */
	PageTypes type() default PageTypes.Default;

	/**
	 * If this configuration should be ignored on deployed
	 *
	 * @return
	 */
	boolean ignore() default false;
}
