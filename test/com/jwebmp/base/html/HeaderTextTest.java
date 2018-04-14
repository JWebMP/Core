/*
 * Copyright (C) 2014 GedMarc
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
package com.jwebmp.base.html;

import com.jwebmp.base.html.attributes.HeaderTypes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author GedMarc
 */
public class HeaderTextTest
{
	public HeaderTextTest()
	{
	}

	@Test
	public void reset()
	{
		HeaderText h1 = new HeaderText(HeaderTypes.H1, "bla");
		HeaderText h2 = new HeaderText(HeaderTypes.H2, "bla");
		h1.setID("id");
		h2.setID("id2");
		System.out.println(h1.toString(true));
		System.out.println(h2.toString(true));
		Assertions.assertNotSame(h1, h2);
		h2.setHeaderType(HeaderTypes.H1);
		Assertions.assertFalse(h1.equals(h2));
		h2.setHeaderText("new text");
		Assertions.assertFalse(h1.equals(h2));
	}

	@Test
	public void allHeaders()
	{
		H1 h1 = new H1<>("bla").setID("id");
		H2 h2 = new H2<>("bla").setID("id");
		H3 h3 = new H3<>("bla").setID("id");
		H4 h4 = new H4<>("bla").setID("id");
		H5 h5 = new H5<>("bla").setID("id");
		H6 h6 = new H6<>("bla").setID("id");

		h1.setID("id");
		System.out.println(h1.toString(true));
		System.out.println(h2.toString(true));
		System.out.println(h3.toString(true));
		System.out.println(h4.toString(true));
		System.out.println(h5.toString(true));
		System.out.println(h6.toString(true));
	}
}
