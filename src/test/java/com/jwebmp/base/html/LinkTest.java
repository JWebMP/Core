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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jwebmp.core.base.html;

import com.jwebmp.core.base.html.attributes.GlobalAttributes;
import com.jwebmp.core.utilities.StaticStrings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author MMagon
 */
public class LinkTest
{

	public LinkTest()
	{
	}

	/**
	 * Test of getCSSClassName method, of class Link.
	 */
	@Test
	public void testALink()
	{
		Link instance = getInstance();
		instance.setID("id");
		System.out.println(instance.toString(true));
		String expResult = "<a href=\"tt\" id=\"id\"></a>";
		String result = instance.toString(true);
		assertEquals(expResult, result);
	}

	private Link getInstance()
	{
		Link instance = new Link("tt");
		instance.setID("id");
		return instance;
	}

	/**
	 * Test of getCSSClassName method, of class Link.
	 */
	@Test
	public void testALinkWithAddress()
	{
		Link instance = new Link("Address");
		instance.setID("instance");
		instance.addAttribute(GlobalAttributes.ID, "instance");
		System.out.println(instance.toString(true));
		String expResult = "<a href=\"Address\" id=\"instance\"></a>";
		String result = instance.toString(true);
		assertEquals(expResult, result);
	}

	@Test
	public void testALinkWithAddressAndTarget()
	{
		Link instance = new Link("Address", "Target");
		instance.setID("instance");
		instance.addAttribute(GlobalAttributes.ID, "instance");
		System.out.println(instance.toString(true));
		String expResult = "<a href=\"Address\" id=\"instance\" target=\"Target\"></a>";
		String result = instance.toString(true);
		assertEquals(expResult, result);
	}

	@Test
	public void testALinkWithAddressAndTargetAndChildren()
	{
		Link instance = new Link("Address", "Target");
		instance.setID("id");
		Paragraph p = new Paragraph("Child");
		p.addAttribute(GlobalAttributes.ID, "instance");
		p.setID("od");
		instance.add(p);
		instance.addAttribute(GlobalAttributes.ID, "instance");
		System.out.println(instance.toString(true));
		String expResult = "" + "<a href=\"Address\" id=\"id\" target=\"Target\">\n" + "	<p id=\"od\">Child</p>\n" + "</a>";
		String result = instance.toString(true);
		assertEquals(expResult, result);
	}

	/**
	 * Test of getCSSClassName method, of class Link.
	 */
	@Test
	public void testALinkTiny()
	{
		Link instance = new Link("");
		instance.setID("instance");
		instance.setTiny(true);
		instance.setDirectToAddress(StaticStrings.STRING_HASH);
		instance.addAttribute(GlobalAttributes.ID, "instance");
		System.out.println(instance.toString(true));
		String expResult = "<a href=\"#\" id=\"instance\"></a>";
		String result = instance.toString(true);
		assertEquals(expResult, result);
	}

	/**
	 * Test of getCSSClassName method, of class Link.
	 */
	@Test
	public void testALinkWithAddressTiny()
	{
		Link instance = new Link("Address");
		instance.setID("instance");
		instance.setTiny(true);
		instance.addAttribute(GlobalAttributes.ID, "instance");
		System.out.println(instance.toString(true));
		String expResult = "<a href=\"Address\" id=\"instance\"></a>";
		String result = instance.toString(true);
		assertEquals(expResult, result);
	}

	@Test
	public void testALinkWithAddressAndTargetTiny()
	{
		Link instance = new Link("Address", "Target");
		instance.setTiny(true);
		instance.setID("instance");
		System.out.println(instance.toString(true));
		String expResult = "<a href=\"Address\" id=\"instance\" target=\"Target\"></a>";
		String result = instance.toString(true);
		assertEquals(expResult, result);
	}

	@Test
	public void testALinkWithAddressAndTargetAndChildrenTiny()
	{
		Link instance = new Link("Address", "Target");
		instance.setID("id");
		Paragraph p = new Paragraph("Child");
		p.setID("instance");
		instance.add(p);
		instance.setTiny(true);
		instance.addAttribute(GlobalAttributes.ID, "instance");
		System.out.println(instance.toString(true));
		String expResult = "<a href=\"Address\" id=\"id\" target=\"Target\"><p id=\"instance\">Child</p></a>";
		String result = instance.toString(true);
		assertEquals(expResult, result);
	}
}
