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

import com.jwebmp.BaseTestClass;
import com.jwebmp.core.base.html.Body;
import com.jwebmp.core.base.html.Meta;
import com.jwebmp.core.base.html.Paragraph;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author ged_m
 */
public class ComponentHierarchyBaseTest
		extends BaseTestClass
{

	public ComponentHierarchyBaseTest()
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
	public void testChildrenPreConfigure()
	{
		Body b = getInstance().getBody();
		Paragraph p = new Paragraph("Text");
		b.add(p);
		b.preConfigure();
		System.out.println(p);
		//System.out.println(b.getPage().toString(true));
	}

	@Test
	public void testClasses()
	{
		ComponentHierarchyBase tag = new ComponentHierarchyBase(ComponentTypes.Area);
		tag.setID("testTag");
		tag.addClass("This is a class");
		tag.addClass("KKKKKKK");
		System.out.println(tag);
		System.out.println(tag.toString(true));
		Assertions.assertEquals("<area class=\"This is a class KKKKKKK\" id=\"testTag\">" + "</area>", tag.toString(true));
	}

	@Test
	public void testClassesTiny()
	{
		ComponentHierarchyBase tag = new ComponentHierarchyBase(ComponentTypes.Area);
		tag.setID("testTag");
		tag.setTiny(true);
		tag.addClass("Class1");
		tag.addClass("Class2");
		System.out.println(tag);
		System.out.println(tag.toString(true));
		Assertions.assertEquals("<area class=\"Class1 Class2\" id=\"testTag\"></area>", tag.toString(true));
	}

}
