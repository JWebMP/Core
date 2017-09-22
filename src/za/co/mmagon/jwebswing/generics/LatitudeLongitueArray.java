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
 * A lat long array [lat,long]
 *
 * @author Marc Magon
 * @since 10 Jun 2017
 */
public class LatitudeLongitueArray extends XYObject<Double, Double>
{
	
	private static final long serialVersionUID = 1L;
	
	/*
	 * Constructs a new LatitudeLongitueArray. X is latitude usually
	 */
	public LatitudeLongitueArray()
	{
		//Nothing needed
	}
	
	/**
	 * Sets the parameters
	 *
	 * @param X Latitude
	 * @param Y Longitude
	 */
	public LatitudeLongitueArray(Double X, Double Y)
	{
		super(X, Y);
	}
}
