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
import com.jwebmp.htmlbuilder.css.annotations.CustomCSS;

/**
 * Any custom css record you want
 *
 * @author ANGELFIRE
 */
public class CustomCSSImpl
		extends CSSImplementationAdapter<CustomCSS, CustomCSSImpl>
		implements CSSImplementationClass<CustomCSS, CustomCSSImpl>
{

	private static final long serialVersionUID = 1L;

	private NameValuePairCSSImpl[] valuePair;

	/**
	 * A Name Value Pair for CSS Properties
	 *
	 * @return
	 */
	public NameValuePairCSSImpl[] value()
	{
		return valuePair;
	}

	/**
	 * Sets the name value pair
	 *
	 * @param valuePair
	 */
	public void setvalue(NameValuePairCSS[] valuePair)
	{
		this.valuePair = (NameValuePairCSSImpl[]) valuePair;
	}
}
