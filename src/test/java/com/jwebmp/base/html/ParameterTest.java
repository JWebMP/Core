/*
 * Copyright (C) 2015 GedMarc
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
package com.jwebmp.core.base.html;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author GedMarc
 */
public class ParameterTest
{

	public ParameterTest()
	{
	}

	@Test
	public void testSomeMethod()
	{
		Parameter p1 = new Parameter();
		p1.setID("id");
		ObjectTag ot = new ObjectTag();
		ot.setID("ot");
		ot.add(p1);

		System.out.println(ot.toString(true));
		Assertions.assertEquals("<object id=\"ot\">\n" + "	<param id=\"id\"></param>\n" + "</object>", ot.toString(true));
	}

}
