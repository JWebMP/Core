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
package com.jwebmp.core.utilities;

/**
 * Provides basics for Colours
 *
 * @author MMagon
 * @version 1.0
 * @since 22 Jun 2013
 */
public class ColourUtils
{
	/**
	 * Converts a colour to hex i suppose
	 */
	private static final String chars = "0123456789ABCDEF";

	/**
	 * No construct
	 */
	private ColourUtils()
	{
		//Nothing NEeded
	}

	/**
	 * Returns a colour found between two colours from two numbers
	 *
	 * @param minNumber
	 * 		The minimum number range
	 * @param maxNumber
	 * 		The maximum number range
	 * @param value
	 * 		The actual value
	 * @param colourMin
	 * 		The colour assigned to the minimum range
	 * @param colourMax
	 * 		The colour assigned to the maximum range
	 *
	 * @return Colour Hex for the colour
	 */
	public static String getColourBetweenColours(double minNumber, double maxNumber, double value, String colourMin, String colourMax)
	{
		Integer[] colMax = new Integer[3];
		Integer[] colMin = new Integer[3];

		String maxRGB = hexToRGB(colourMax);
		String minRGB = hexToRGB(colourMin);

		colMax[0] = Integer.parseInt(maxRGB.split(StaticStrings.STRING_COMMNA)[0]);
		colMax[1] = Integer.parseInt(maxRGB.split(StaticStrings.STRING_COMMNA)[1]);
		colMax[2] = Integer.parseInt(maxRGB.split(StaticStrings.STRING_COMMNA)[2]);

		colMin[0] = Integer.parseInt(minRGB.split(StaticStrings.STRING_COMMNA)[0]);
		colMin[1] = Integer.parseInt(minRGB.split(StaticStrings.STRING_COMMNA)[1]);
		colMin[2] = Integer.parseInt(minRGB.split(StaticStrings.STRING_COMMNA)[2]);

		int[] diff = new int[3];
		diff[0] = colMin[0] - colMax[0];
		diff[1] = colMin[1] - colMax[1];
		diff[2] = colMin[2] - colMax[2];

		double dividend = value - minNumber;
		double divisor = maxNumber - minNumber;

		double perc = dividend / divisor;
		Integer[] c = new Integer[3];

		c[0] = colMin[0] - (int) (perc * diff[0]);
		c[1] = colMin[1] - (int) (perc * diff[1]);
		c[2] = colMin[2] - (int) (perc * diff[2]);

		String co = c[0] + StaticStrings.STRING_COMMNA + c[1] + StaticStrings.STRING_COMMNA + c[2];
		return rgbToHex(co);
	}

	private static String hexToRGB(String color)
	{
		String val1 = color.substring(0, 2);
		String val2 = color.substring(2, 4);
		String val3 = color.substring(4, 6);
		return hexToDecimal(val1) + StaticStrings.STRING_COMMNA + hexToDecimal(val2) + StaticStrings.STRING_COMMNA + hexToDecimal(val3);
	}

	private static String rgbToHex(String color)
	{
		String[] RGB = color.split(StaticStrings.STRING_COMMNA);
		return toHex(RGB[0]) + toHex(RGB[1]) + toHex(RGB[2]);
	}

	/**
	 * Returns a heat map colour between the min and maximum set
	 *
	 * @return
	 */
	private static int hexToDecimal(String hex)
	{
		return Math.max(0, Math.min(Integer.parseInt(hex, 16), 255));
	}

	/**
	 * Sends a colour to a hex
	 *
	 * @param color
	 *
	 * @return
	 */
	private static String toHex(String color)
	{
		if (color == null)
		{
			return "00";
		}
		Integer N;
		N = Integer.parseInt(color);
		if (N == 0)
		{
			return "00";
		}
		N = Math.max(0, N);
		N = Math.min(N, 255);
		N = Math.round(N);
		char s = chars.charAt((N - N % 16) / 16);
		char s1 = chars.charAt(N % 16);
		return "" + Character.toString(s) + Character.toString(s1);
	}

}
