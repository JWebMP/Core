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
package com.jwebmp.core.plugins;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Any specific component
 *
 * @author GedMarc
 * @since 19 Feb 2017
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ComponentInformation
{

	/**
	 * The name of the component
	 *
	 * @return
	 */
	String name();

	/**
	 * The description of the component
	 *
	 * @return
	 */
	String description();

	/**
	 * The URL of the component
	 *
	 * @return
	 */
	String url() default "https://github.com/GedMarc/JWebMP";

	/**
	 * The wiki url of the component
	 *
	 * @return
	 */
	String wikiUrl() default "https://github.com/GedMarc/JWebMP/wiki";

	/**
	 * The icon of the component
	 *
	 * @return
	 */
	String icon() default "";

}
