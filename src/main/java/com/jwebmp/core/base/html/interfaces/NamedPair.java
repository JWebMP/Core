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
package com.jwebmp.core.base.html.interfaces;

/**
 * @param <S>
 * 		The Left Field Type
 * @param <T>
 * 		The Right Field Typ
 * 		Denotes a named pair
 *
 * @author MMagon
 * @version 1.0
 * @since 2014/12/09
 */

public interface NamedPair<S, T>
{
	/**
	 * Returns the left value
	 *
	 * @return
	 */
	S getLeft();

	/**
	 * returns the right value
	 *
	 * @return
	 */
	T getRight();
}
