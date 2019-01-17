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
package com.jwebmp.generics;

import com.jwebmp.core.generics.LatitudeLongitueArray;
import org.junit.jupiter.api.Test;

/**
 * @author GedMarc
 */
public class LatitudeLongitueArrayTest
{

	public LatitudeLongitueArrayTest()
	{
	}

	@Test
	public void testEmpty()
	{
		LatitudeLongitueArray lat = new LatitudeLongitueArray();

		System.out.println(lat);
	}

	@Test
	public void testCoords()
	{
		LatitudeLongitueArray lat = new LatitudeLongitueArray();
		lat.setX(5.0);
		lat.setY(6.0);
		System.out.println(lat);
	}
}
