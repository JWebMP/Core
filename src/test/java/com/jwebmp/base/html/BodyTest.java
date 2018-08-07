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
package com.jwebmp.core.base.html;

import com.jwebmp.BaseTestClass;
import com.jwebmp.core.Page;
import com.jwebmp.core.generics.WebReference;
import com.jwebmp.core.plugins.jquery.JQueryPageConfigurator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author MMagon
 */
public class BodyTest
		extends BaseTestClass
{

	private Page p;
	private Body b;

	public BodyTest()
	{
		resetBody();
	}

	private void resetBody()
	{
		p = new Page();
		b = p.getBody();
	}

	@Test
	public void testBody()
	{
		resetBody();
		System.out.println(b.toString(true));
		assertEquals("<body id=\"body\"></body>", b.toString(true));
	}

	@Test
	public void testSetGenerateJQuery()
	{
		p = getInstance();
		resetBody();
		JQueryPageConfigurator.setRequired(true);
		b.add(new Comment("meh"));
		WebReference.setIsLocal(true);
		System.out.println(p.toString(true));
		Assertions.assertEquals(
				"<!DOCTYPE html>\n" +
				"<html>\n" +
				"\t<body id=\"body\">\n" +
				"\t\t<!-- meh -->\n" +
				"\t\t<script src=\"bower_components/jquery/dist/jquery.min.js\" type=\"text/javascript\"></script>\n" +
				"\t\t<script src=\"jwscr\" type=\"application/javascript\"></script>\n" +
				"\t\t<script src=\"jwjs\" type=\"application/javascript\"></script>\n" +
				"\t</body>\n" +
				"</html>",
				p.toString(true));
	}

	@Test
	public void testSetGenerateJQueryRemote()
	{
		resetBody();
		JQueryPageConfigurator.setRequired(true);
		b.add(new Comment("meh"));
		WebReference.setIsLocal(false);
		System.out.println(p.toString(true));
		Assertions.assertEquals(
				"<!DOCTYPE html>\n" +
				"<html>\n" +
				"\t<body id=\"body\">\n" +
				"\t\t<!-- meh -->\n" +
				"\t\t<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\" type=\"text/javascript\"></script>\n" +
				"\t\t<script src=\"jwscr\" type=\"application/javascript\"></script>\n" +
				"\t\t<script src=\"jwjs\" type=\"application/javascript\"></script>\n" +
				"\t</body>\n" +
				"</html>",
				p.toString(true));
	}
}
