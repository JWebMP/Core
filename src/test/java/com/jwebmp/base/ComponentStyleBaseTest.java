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
package com.jwebmp.core.base;

import com.jwebmp.BaseTestClass;
import com.jwebmp.core.Page;
import com.jwebmp.core.base.html.Body;
import com.jwebmp.core.base.html.Comment;
import com.jwebmp.core.base.html.Meta;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;
import com.jwebmp.core.htmlbuilder.css.colours.ColourNames;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * @author ged_m
 */
public class ComponentStyleBaseTest
		extends BaseTestClass
{

	public ComponentStyleBaseTest()
	{
	}

	@Test
	public void test()
	{
		ComponentHierarchyBase head = new ComponentHierarchyBase(ComponentTypes.Head);
		head.add(new Meta("name"));
		head.add(new Meta(Meta.MetadataFields.Author, "Author Me"));
		ComponentHierarchyBase body = new ComponentHierarchyBase(ComponentTypes.Body);
		System.out.println(head.toString());
		System.out.println(head.toString(true));
		System.out.println(body.toString(true));
	}

	@Test
	public void testCSS()
	{
		Page<?> p = getInstance();
		Body b = p.getBody();

		b.getCss()
		 .getBackground()
		 .setBackgroundColor$(ColourNames.DarkGoldenRod);
		b.add(new Comment("asdf"));
		//System.out.println(p.toString(true));
		p.getOptions()
		 .setDynamicRender(true);


		if (p.toString(true)
		     .startsWith(
				     "<!DOCTYPE html>\n" + "<html>\n" + "\t<head>\n" + "\t\t<style type=\"text/css\">#body {background-color:darkgoldenrod;}</style>\n" + "\t</head>\n" +
				     "\t<body id=\"body\" ng-app=\"jwApp\" ng-controller=\"jwController as jwCntrl\">"))
		{
		}
		/*Assertions.assertEquals("<!DOCTYPE html>\n"
				                    + "<html>\n"
				                    + "	<head>\n"
				                    + "		<style type=\"text/css\">#body {background-color:darkgoldenrod;}</style>\n"
				                    + "	</head>\n"
				                    + "	<body id=\"body\">\n"
				                    + "		<!-- asdf -->\n"
				                    + "	</body>\n"
				                    + "</html>", p.toString(true));*/
	}
	
	@Test
	public void testAddStyle()
	{
		Page<?> p = new Page();
		p.addStyle("height","100%");
		String output = p.toString(0);
		if(output.contains("nullheight"))
		{
			fail("Null rendered in style addition");
		}
		p.addStyle("height","100%");
		output = p.toString(0);
		System.out.println(p.toString(0));
	}
}
