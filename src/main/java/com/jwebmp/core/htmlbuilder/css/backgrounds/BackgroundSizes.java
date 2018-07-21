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
package com.jwebmp.core.htmlbuilder.css.backgrounds;

import com.jwebmp.core.base.client.CSSVersions;
import com.jwebmp.core.htmlbuilder.css.CSSEnumeration;
import com.jwebmp.core.htmlbuilder.css.animatable.AnimateCSS;

/**
 * Definition and Usage
 * <p>
 * <p>
 * The background-size property specifies the size of the background images.
 * <p>
 * Default value: auto
 * <p>
 * Inherited: no
 * <p>
 * Animatable: yes. Read about animatable
 * <p>
 * Try it
 * <p>
 * Version: CSS3
 * <p>
 * JavaScript syntax: object.style.backgroundSize="60px 120px"
 *
 * @author GedMarc
 * @since 17 Jan 2016
 */
@AnimateCSS
public enum BackgroundSizes
		implements CSSEnumeration<BackgroundSizes>
{
	/**
	 * Default value. The background-image contains its width and height
	 */
	Auto,
	/**
	 * Scale the background image to be as large as possible so that the background area is completely covered by the background image. Some parts of the background image may not
	 * be in view within the
	 * background positioning area
	 */
	Cover,
	/**
	 * Scale the image to the largest size such that both its width and its height can fit inside the content area
	 */
	Contain,
	/**
	 * Sets this property to its default value
	 * <p>
	 * see http://www.w3schools.com/cssref/css_initial.asp
	 */
	Initial,
	/**
	 * Inherits this property from its parent element.
	 * <p>
	 * see http://www.w3schools.com/cssref/css_inherit.asp
	 */
	Inherit,
	/**
	 * Sets this field as not set
	 */
	Unset;

	@Override
	public String toString()
	{
		return name().toLowerCase();
	}

	@Override
	public String getJavascriptSyntax()
	{
		return "style.backgroundSize";
	}

	@Override
	public CSSVersions getCSSVersion()
	{
		return CSSVersions.CSS3;
	}

	@Override
	public String getValue()
	{
		return name();
	}

	@Override
	public BackgroundSizes getDefault()
	{
		return Unset;
	}
}
