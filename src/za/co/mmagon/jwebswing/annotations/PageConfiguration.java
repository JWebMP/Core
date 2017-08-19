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
package za.co.mmagon.jwebswing.annotations;

import java.lang.annotation.*;

/**
 * @author Marc Magon
 * @since 05 Apr 2017
 */
@Target(
		{
				ElementType.TYPE, ElementType.TYPE_USE
		})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface PageConfiguration
{

	/**
	 * Specifies the URL that this page serves
	 *
	 * @return
	 */
	public String url() default "/";

	/**
	 * Specifies the type this page serves (best to leave it alone - or only use one page for error types etc)
	 *
	 * @return
	 */
	public PageTypes type() default PageTypes.Default;
}
