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
package com.jwebmp.core.base.html.attributes;

import com.jwebmp.core.base.html.interfaces.AttributeDefinitions;

/**
 * Valid attributes for images
 *
 * @author MMagon
 * @version 1.0
 * @since 23 Sep 2013
 */
public enum ImageAttributes
		implements AttributeDefinitions
{
	/**
	 * Specifies the URL of an image
	 */
	Src,
	/**
	 * Specifies an alternate text for an image
	 */
	ImageReplacementText,
	/**
	 * Specifies an image as a server-side image-map
	 */
	IsMap,
	/**
	 * Specifies an image as a client-side image-map
	 */
	UseMap,
	/**
	 * Alternative text to display
	 */
	Alt,
	/**
	 * Specifies width as an attribute
	 */
	Width,
	/**
	 * Specifies height as an attribute
	 */
	Height;

	/**
	 * Returns the lowercase variant
	 *
	 * @return
	 */
	@Override
	public String toString()
	{
		return name().toLowerCase();
	}

	@Override
	public boolean isKeyword()
	{
		return false;
	}

}
