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

package com.jwebmp.htmlbuilder.css.composer;

import java.util.Comparator;

/**
 * Compares CSS Lines as a comparator
 *
 * @author MMagon
 * @version 1.0
 * @since 07 Apr 2013
 */
public class CSSLineSorter implements Comparator<CSSLine>
{

	/**
	 * Orders the CSS Lines by property then Value
	 *
	 * @param o1 Line 1
	 * @param o2 Line 2
	 *
	 * @return -1 to 1
	 */
	@Override
	public int compare(CSSLine o1, CSSLine o2)
	{
		if (o1.getProperty().compareTo(o2.getProperty()) == 0)
		{
			return o1.getValue().compareTo(o2.getValue());
		}
		return o1.getProperty().compareTo(o2.getProperty());
	}
}
