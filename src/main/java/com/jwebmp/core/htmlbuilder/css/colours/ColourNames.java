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

package com.jwebmp.core.htmlbuilder.css.colours;

import com.jwebmp.core.base.client.CSSVersions;
import com.jwebmp.core.htmlbuilder.css.CSSEnumeration;

/**
 * Standard HTML Colours Based on the list referenced at http://www.w3schools.com/HTML/html_colornames.asp
 * <p>
 * Definition and Usage The color property specifies the color of text. Default value: not specified Inherited: yes Version: CSS1 JavaScript syntax: object.style.color="#FF0000"
 *
 * @author GedMarc
 */
public enum ColourNames
		implements CSSEnumeration<ColourNames>
{

	AliceBlue,
	AntiqueWhite,
	Aqua,
	Aquamarine,
	Azure,
	Beige,
	Bisque,
	Black,
	BlanchedAlmond,
	Blue,
	BlueViolet,
	Brown,
	BurlyWood,
	CadetBlue,
	Chartreuse,
	Chocolate,
	Coral,
	CornflowerBlue,
	Cornsilk,
	Crimson,
	Cyan,
	DarkBlue,
	DarkCyan,
	DarkGoldenRod,
	DarkGray,
	DarkGreen,
	DarkKhaki,
	DarkMagenta,
	DarkOliveGreen,
	DarkOrange,
	DarkOrchid,
	DarkRed,
	DarkSalmon,
	DarkSeaGreen,
	DarkSlateBlue,
	DarkSlateGray,
	DarkSlateGrey,
	DarkTurquoise,
	DarkViolet,
	DeepPink,
	DeepSkyBlue,
	DimGray,
	DimGrey,
	DodgerBlue,
	FireBrick,
	FloralWhite,
	ForestGreen,
	Fuchsia,
	Gainsboro,
	GhostWhite,
	Gold,
	GoldenRod,
	Gray,
	Grey,
	Green,
	GreenYellow,
	HoneyDew,
	HotPink,
	IndianRed,
	Indigo,
	Ivory,
	Khaki,
	Lavender,
	LavenderBlush,
	LawnGreen,
	LemonChiffon,
	LightBlue,
	LightCoral,
	LightCyan,
	LightGoldenRodYellow,
	LightGray,
	LightGrey,
	LightGreen,
	LightPink,
	LightSalmon,
	LightSeaGreen,
	LightSkyBlue,
	LightSlateGray,
	LightSlateGrey,
	LightSteelBlue,
	LightYellow,
	Lime,
	LimeGreen,
	Linen,
	Magenta,
	Maroon,
	MediumAquaMarine,
	MediumBlue,
	MediumOrchid,
	MediumPurple,
	MediumSeaGreen,
	MediumSlateBlue,
	MediumSpringGreen,
	MediumTurquoise,
	MediumVioletRed,
	MidnightBlue,
	MintCream,
	MistyRose,
	Moccasin,
	NavajoWhite,
	Navy,
	OldLace,
	Olive,
	OliveDrab,
	Orange,
	OrangeRed,
	Orchid,
	PaleGoldenRod,
	PaleGreen,
	PaleTurquoise,
	PaleVioletRed,
	PapayaWhip,
	PeachPuff,
	Peru,
	Pink,
	Plum,
	PowderBlue,
	Purple,
	Red,
	RosyBrown,
	RoyalBlue,
	SaddleBrown,
	Salmon,
	SandyBrown,
	SeaGreen,
	SeaShell,
	Sienna,
	Silver,
	SkyBlue,
	SlateBlue,
	SlateGray,
	SlateGrey,
	Snow,
	SpringGreen,
	SteelBlue,
	Tan,
	Teal,
	Thistle,
	Tomato,
	Turquoise,
	Violet,
	Wheat,
	White,
	WhiteSmoke,
	Yellow,
	YellowGreen,
	None,
	Transparent,
	/**
	 * Sets this field as not set
	 */
	Unset;

	@Override
	public String toString()
	{
		return super.toString()
		            .toLowerCase();
	}

	@Override
	public String getJavascriptSyntax()
	{
		return null;
	}

	@Override
	public CSSVersions getCSSVersion()
	{
		return null;
	}

	@Override
	public String getValue()
	{
		return name();
	}

	@Override
	public ColourNames getDefault()
	{
		return Unset;
	}
}
