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

package com.jwebmp.htmlbuilder.css.interfaces;

import com.jwebmp.htmlbuilder.css.annotations.CSSImplementationAdapter;
import com.jwebmp.htmlbuilder.css.annotations.CSSImplementationClass;

/**
 * A default name value pair
 *
 * @author ANGELFIRE
 */
public class NameValuePairCSSImpl
		extends CSSImplementationAdapter<NameValuePairCSS, NameValuePairCSSImpl>
		implements CSSImplementationClass<NameValuePairCSS, NameValuePairCSSImpl>
{

	private static final long serialVersionUID = 1L;

	private String name;
	private String value;

	/**
	 * The name of this pair
	 *
	 * @return
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Sets the name of the name value pair
	 *
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Gets the name of this value pair
	 *
	 * @return
	 */
	public String getValue()
	{
		return value;
	}

	/**
	 * Sets the value of this value pair
	 *
	 * @param value
	 */
	public void setValue(String value)
	{
		this.value = value;
	}
}
