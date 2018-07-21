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
import com.jwebmp.core.base.servlets.enumarations.DevelopmentEnvironments;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author MMagon
 */
public class HeadTest
		extends BaseTestClass
{

	Head instance = new Head();

	public HeadTest()
	{
		//System.out.println("Testing <HEAD> Tag");
	}

	/**
	 * I expect the head tag to show, to see that it's being added The page object manages the presentation of it
	 */
	@Test
	public void testOutput()
	{
		System.out.println("testOutput");

		System.out.println(instance.toString(true));
		String expResult = "<head></head>";
		String result = instance.toString(true);
		assertEquals(expResult, result);
	}

	@Test
	public void testTiny()
	{
		String expResult;
		String result;
		instance.setTiny(true);
		expResult = "<head></head>";
		result = instance.toString(true);
		System.out.println(instance.toString(true));
		assertEquals(expResult, result);
	}

	@Test
	public void testHtml()
	{
		String result;
		String expResult;
		Html html = getPage();
		html.setTiny(false);
		expResult = "<!DOCTYPE html>\n" + "<html>\n" + "</html>";
		result = html.toString(true);
		System.out.println(html.toString(true));
		assertEquals(expResult, result);
	}

	@Test
	public void testHtmlTiny()
	{
		String result;
		String expResult;
		Page html = getPage();
		html.setTiny(true);
		html.setRunningEnvironment(DevelopmentEnvironments.Production);
		expResult = "<!DOCTYPE html><html></html>";
		result = html.toString(true);
		System.out.println(html.toString(true));
		assertEquals(expResult, result);
	}
}
