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
package com.jwebmp.base;

import com.jwebmp.BaseTestClass;
import com.jwebmp.Page;
import com.jwebmp.base.angular.AngularPageConfigurator;
import com.jwebmp.base.html.Body;
import com.jwebmp.base.html.Comment;
import com.jwebmp.base.html.Meta;
import com.jwebmp.base.servlets.enumarations.ComponentTypes;
import com.jwebmp.htmlbuilder.css.colours.ColourNames;
import com.jwebmp.plugins.jquery.JQueryPageConfigurator;
import org.junit.jupiter.api.Test;

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
		ComponentStyleBase head = new ComponentStyleBase(ComponentTypes.Head)
		{};
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
		Page p = new Page();
		Body b = p.getBody();

		b.getCss()
		 .getBackground()
		 .setBackgroundColor$(ColourNames.DarkGoldenRod);
		b.add(new Comment("asdf"));
		//System.out.println(p.toString(true));
		p.getOptions()
		 .setDynamicRender(true);
		JQueryPageConfigurator.setRequired(false);
		AngularPageConfigurator.setRequired(false);

		if (p.toString(true)
		     .startsWith(
				     "<!DOCTYPE html>\n" + "<html>\n" + "\t<head>\n" + "\t\t<style type=\"text/css\">#body {background-color:darkgoldenrod;}</style>\n" + "\t</head>\n" + "\t<body id=\"body\" ng-app=\"jwApp\" ng-controller=\"jwController as jwCntrl\">"))
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
}
