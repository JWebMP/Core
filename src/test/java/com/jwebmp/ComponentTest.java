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
package com.jwebmp;

import com.jwebmp.base.ComponentHierarchyBase;
import com.jwebmp.base.html.Body;
import com.jwebmp.base.html.Meta;
import com.jwebmp.base.html.Paragraph;
import com.jwebmp.base.servlets.enumarations.ComponentTypes;
import org.junit.jupiter.api.Test;

/**
 * @author GedMarc
 */
public class ComponentTest
		extends BaseTestClass
{

	public ComponentTest()
	{
	}

	@Test
	public void test()
	{
		Component head = new Component(ComponentTypes.Head)
		{};
		head.add(new Meta("name"));
		head.add(new Meta(Meta.MetadataFields.Author, "Author Me"));
		ComponentHierarchyBase body = new ComponentHierarchyBase(ComponentTypes.Body);
		System.out.println(head.toString());
		System.out.println(head.toString(true));
		System.out.println(body.toString(true));
	}

	/**
	 * Test of add method, of class Component.
	 */
	@Test
	public void testAdd()
	{
		Page p = new Page();
		Body b = p.getBody();
		Paragraph pa = new Paragraph("String adds a paragraph");
		b.add(pa);
		pa.setID("paragraph");
		System.out.println(p.toString(true));

	}

}
