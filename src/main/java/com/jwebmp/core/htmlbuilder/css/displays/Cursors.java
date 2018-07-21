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

package com.jwebmp.core.htmlbuilder.css.displays;

import com.jwebmp.core.base.client.CSSVersions;
import com.jwebmp.core.htmlbuilder.css.CSSEnumeration;
import com.jwebmp.core.htmlbuilder.css.annotations.CSSAnnotationType;

/**
 * Specifies the type of cursor to be displayed
 * <p>
 * Browser Support
 * <p>
 * Internet Explorer Firefox Opera Google Chrome Safari
 * <p>
 * The cursor property is supported in all major browsers. Definition and Usage
 * <p>
 * The cursor property specifies the type of cursor to be displayed when pointing on an element. Default value: auto Inherited: yes Animatable: no. Read about animatable Version:
 * CSS2 JavaScript
 * syntax: object.style.cursor="crosshair" Try it
 *
 * @author Marc Magon
 * @version 2.0
 * 		<p>
 * 		2.0 Added all the new stuff, and added the javadoc things
 * @since 2011/03/18
 */
@CSSAnnotationType
public enum Cursors
		implements CSSEnumeration<Cursors>
{

	/**
	 * The cursor indicates an alias of something is to be created
	 */
	Alias,
	/**
	 * The cursor indicates that something can be scrolled in any direction
	 */
	All_Scroll,
	/**
	 * Default. The browser sets a cursor
	 */
	Auto,
	/**
	 * The cursor indicates that a cell (or set of cells) may be selected
	 */
	Cell,
	/**
	 * The cursor indicates that a context_menu is available
	 */
	Context_Menu,
	/**
	 * The cursor indicates that the column can be resized horizontally
	 */
	Col_Resize,
	/**
	 * The cursor indicates something is to be copied
	 */
	Copy,
	/**
	 * The cursor render as a crosshair
	 */
	Crosshair,
	/**
	 * The default cursor
	 */
	Default,
	/**
	 * The cursor indicates that an edge of a box is to be moved right (east)
	 */
	E_Resize,
	/**
	 * Indicates a bidirectional resize cursor
	 */
	EW_Resize,
	/**
	 * The cursor indicates that help is available
	 */
	Help,
	/**
	 * The cursor indicates something is to be moved
	 */
	Move,
	/**
	 * The cursor indicates that an edge of a box is to be moved up (north)
	 */
	N_Resize,
	/**
	 * The cursor indicates that an edge of a box is to be moved up and right (north/east)
	 */
	NE_Resize,
	/**
	 * Indicates a bidirectional resize cursor
	 */
	NESW_Resize,
	/**
	 * Indicates a bidirectional resize cursor
	 */
	NS_Resize,
	/**
	 * The cursor indicates that an edge of a box is to be moved up and left (north/west)
	 */
	NW_Resize,
	/**
	 * Indicates a bidirectional resize cursor
	 */
	NWSE_Resize,
	/**
	 * The cursor indicates that the dragged item cannot be dropped here
	 */
	No_Drop,
	/**
	 * No cursor is rendered for the element
	 */
	None,
	/**
	 * The cursor indicates that the requested action will not be executed
	 */
	Not_Allowed,
	/**
	 * The cursor is a pointer and indicates a link
	 */
	Pointer,
	/**
	 * The cursor indicates that the program is busy (in progress)
	 */
	Progress,
	/**
	 * The cursor indicates that the row can be resized vertically
	 */
	Row_Resize,
	/**
	 * The cursor indicates that an edge of a box is to be moved down (south)
	 */
	S_Resize,
	/**
	 * The cursor indicates that an edge of a box is to be moved down and right (south/east)
	 */
	SE_Resize,
	/**
	 * The cursor indicates that an edge of a box is to be moved down and left (south/west)
	 */
	SW_Resize,
	/**
	 * The cursor indicates text that may be selected
	 */
	Text,
	/**
	 * A comma separated list of URLs to custom cursors. Note: Always specify a generic cursor at the end of the list, in case none of the URL_defined cursors can be used
	 */
	URL,
	/**
	 * The cursor indicates vertical_text that may be selected
	 */
	Vertical_Text,
	/**
	 * The cursor indicates that an edge of a box is to be moved left (west)
	 */
	W_Resize,
	/**
	 * The cursor indicates that the program is busy
	 */
	Wait,
	/**
	 * The cursor indicates that something can be zoomed in
	 */
	Zoom_In,
	/**
	 * The cursor indicates that something can be zoomed out
	 */
	Zoom_Out,
	/**
	 * Sets this property to its default value. Read about initial
	 */
	Initial,
	/**
	 * Inherits this property from its parent element. Read about inherit
	 */
	Inherit,
	/**
	 * Sets this field as not set
	 */
	Unset;

	@Override
	public String toString()
	{
		return name().replaceAll("_", "-");
	}

	@Override
	public String getJavascriptSyntax()
	{
		return "style.cursors";
	}

	@Override
	public CSSVersions getCSSVersion()
	{
		return CSSVersions.CSS1;
	}

	@Override
	public String getValue()
	{
		return name().replaceAll("_", "-");
	}

	@Override
	public Cursors getDefault()
	{
		return Unset;
	}

}
