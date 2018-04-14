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

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author MMagon
 */
public class CSSLineTest
{

	public CSSLineTest()
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

	@Test
	public void testToString()
	{
		System.out.println("Testing CSS Line");
		CSSLine line1 = new CSSLine("Propert1", "Value1");
		assertEquals("propert1:Value1", line1.toString());
		CSSLine line2 = new CSSLine("text-decoration", "textDecoration");
		assertEquals("text-decoration:textDecoration", line2.toString());
		System.out.println("Passed CSS Line");
	}
}
