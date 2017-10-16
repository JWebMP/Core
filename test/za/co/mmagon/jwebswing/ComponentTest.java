/*
 * Copyright (C) 2016 GedMarc
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
package za.co.mmagon.jwebswing;

import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.base.html.Body;
import za.co.mmagon.jwebswing.base.html.Paragraph;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * @author GedMarc
 */
public class ComponentTest extends BaseTestClass
{
	
	public ComponentTest()
	{
	}
	
	/**
	 * Test of add method, of class Component.
	 */
	@Test
	public void testAdd()
	{
		Page p = getPage();
		Body b = p.getBody();
		Paragraph pa = new Paragraph("String adds a paragraph");
		b.add(pa);
		pa.setID("paragraph");
		System.out.println(p.toString(true));
		if (!p.toString(true).startsWith("<!DOCTYPE html>\n" +
				                                 "<html>\n" +
				                                 "\t<head>\n" +
				                                 "\t\t<!-- Priority [Top_Shelf] Values -->\n" +
				                                 "\t\t<script src=\"persist-js/persist-all-min.js\" type=\"text/javascript\"></script>\n" +
				                                 "\t</head>\n" +
				                                 "\t<body id=\"body\">\n" +
				                                 "\t\t<p id=\"paragraph\">String adds a paragraph</p>\n" +
				                                 "\t</body>\n" +
				                                 "</html>"))
		{
			fail("didn't add paragraph");
		}
		
	}
	
}
