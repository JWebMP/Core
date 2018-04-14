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

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * @author MMagon
 */
public class CSSLineSorterTest
{

	public CSSLineSorterTest()
	{
	}

	@BeforeAll
	public static void setUpClass()
	{
	}

	@AfterAll
	public static void tearDownClass()
	{
	}

	@BeforeEach
	public void setUp()
	{
	}

	@AfterEach
	public void tearDown()
	{
	}

	/**
	 * Test of compare method, of class CSSLineSorter.
	 */
	@Test
	public void testCompare()
	{
		System.out.println("Testing Line Sorter Compare");
		CSSLine line1 = new CSSLine("Propert1", "Value1");
		CSSLine line2 = new CSSLine("text-decoration", "textDecoration");
		CSSLine line3 = new CSSLine("property2:value2");
		CSSLine line4 = new CSSLine("property2:value2");
		CSSLine line5 = new CSSLine("property2:value1");
		CSSLine line6 = new CSSLine("property1:value1");
		CSSLine line7 = new CSSLine("property1:value2");
		ArrayList<CSSLine> line = new ArrayList();
		line.add(line1);
		line.add(line2);
		line.add(line3);
		line.add(line4);
		line.add(line5);
		line.add(line6);
		line.add(line7);
		CSSLineSorter instance = new CSSLineSorter();
		Collections.sort(line, instance);

		if (line.indexOf(line1) != 0)
		{
			fail("Didn't sort correctly");
		}
		else if (line.indexOf(line2) != 6)
		{
			fail("Didn't sort correctly");
		}
		else if (line.indexOf(line5) != 3)
		{
			fail("didn't sort correctly");
		}
		else if (line.indexOf(line6) != 1)
		{
			fail("didn't sort correctly");
		}

		System.out.println("Line Sorting Compare Complete");
	}
}
