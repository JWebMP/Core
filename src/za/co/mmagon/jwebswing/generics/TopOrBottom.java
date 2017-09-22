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
package za.co.mmagon.jwebswing.generics;

/**
 * Top or Bottom
 *
 * @author Marc Magon
 * @since 09 Jun 2017
 */
public enum TopOrBottom
{
	Top,
	Bottom;
	/**
	 * Any sub data
	 */
	private String data;
	
	/**
	 * A new LeftOrRight
	 */
	TopOrBottom()
	{

	}
	
	/**
	 * A new LeftOrRight with data
	 */
	TopOrBottom(String data)
	{

	}
	
	/**
	 * Returns the name or the data contained within
	 *
	 * @return
	 */
	@Override
	public String toString()
	{
		if (data != null && !data.isEmpty())
		{
			return data;
		}
		else
		{
			return name().toLowerCase();
		}
	}
}
