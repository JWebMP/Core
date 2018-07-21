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
package com.jwebmp.core.htmlbuilder.css.annotations;

import com.jwebmp.core.htmlbuilder.css.interfaces.NameValuePairCSS;
import com.jwebmp.core.htmlbuilder.css.interfaces.NameValuePairCSSImpl;

import java.lang.annotation.Annotation;

/**
 * Any custom CSS Implementation
 *
 * @author GedMarc
 * @version 1.0
 * @since Nov 20, 2016
 */
public class CustomCSSImpl
		implements CustomCSS
{

	private NameValuePairCSSImpl[] value;

	/**
	 * Any custom CSS implementation
	 */
	public CustomCSSImpl()
	{
		//No Coniguration Needed
	}

	@Override
	public Class<? extends Annotation> annotationType()
	{
		return CustomCSS.class;
	}

	/**
	 * use getValue
	 *
	 * @return
	 */
	@Override
	public NameValuePairCSS[] value()
	{
		return new NameValuePairCSS[]{};
	}

	/**
	 * Returns the value pairs
	 *
	 * @return
	 */
	public NameValuePairCSSImpl[] getValue()
	{
		return value;
	}

	/**
	 * Returns the value pairs
	 *
	 * @param value
	 */
	public void setValue(NameValuePairCSSImpl[] value)
	{
		this.value = value;
	}

}
