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
 * @author GedMarc
 */
public enum TableColumnAttributes
		implements AttributeDefinitions
{

	/**
	 * Specifies the alignment of the content related to a col element.
	 * <p>
	 * left right center justify char Not supported in HTML5.
	 * <p>
	 *
	 * @deprecated
	 */@Deprecated
	Align,
	/**
	 * Not supported in HTML5.
	 * <p>
	 * Specifies the alignment of the content related to a col element to a character
	 * <p>
	 *
	 * @deprecated
	 */@Deprecated
	Char,
	/**
	 * Not supported in HTML5. Specifies the number of characters the content will be aligned from the character specified by the char attribute
	 * <p>
	 *
	 * @deprecated
	 */@Deprecated
	CharOff,
	/**
	 * Specifies the number of columns a col element should span
	 */
	Span,
	/**
	 * Not supported in HTML5.
	 * <p>
	 * Specifies the vertical alignment of the content related to a col element
	 * <p>
	 *
	 * @deprecated
	 */@Deprecated
	VAlign,
	/**
	 * Not supported in HTML5.
	 * <p>
	 * Specifies the width of a col element
	 *
	 * @deprecated
	 */@Deprecated
	Width;

	@Override
	public boolean isKeyword()
	{
		return false;
	}

}
