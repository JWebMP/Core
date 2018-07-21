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
package com.jwebmp.core.base;

import com.jwebmp.core.base.html.CSSLink;
import com.jwebmp.core.base.html.Div;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Marc Magon
 */
public class ComponentHTMLAttributeBaseTest
{

	public ComponentHTMLAttributeBaseTest()
	{
	}

	@Test
	public void testCustomAttributesKeywords()
	{
		Div d = new Div();
		d.addAttribute("thisIsKeyword", null);
		d.addAttribute("uib-dropdown", null);
		System.out.println(d.toString(true));
	}

	@Test
	public void testNullAttribute()
	{
		CSSLink link = (CSSLink) new CSSLink(null, "rel", "href").setID("id");
		System.out.println(link.toString(true));
		if (link.toString(true)
		        .contains("type=\"null\""))
		{
			fail("Inserting null as attribute values");
		}
	}

	@Test
	public void testAddStyle()
	{
		Div d = new Div();
		d.addStyle("background-black");
		System.out.println(d.toString(true));

	}
}
