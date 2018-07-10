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

package com.jwebmp.base.html;

import com.jwebmp.BaseTestClass;
import com.jwebmp.Page;
import com.jwebmp.base.angular.AngularPageConfigurator;
import com.jwebmp.base.client.Browsers;
import com.jwebmp.plugins.jquery.JQueryPageConfigurator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests all aspects of the HTML Raw Component
 *
 * @author MMagon
 */
public class HtmlTest
		extends BaseTestClass
{

	public HtmlTest()
	{
		System.out.println("Testing <HTML> Tag");
	}

	/**
	 * Test of getMinimumBrowserSupport method, of class HTML.
	 */
	@Test
	public void testGetMinimumBrowserSupport()
	{
		//System.out.println("getMinimumBrowserSupport");
		Html instance = new HtmlImpl();
		instance.setBrowser(Browsers.Firefox19);
		Browsers expResult = Browsers.Firefox19;
		Browsers result = instance.getBrowser();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setMinimumBrowserSupport method, of class HTML.
	 */
	@Test
	public void testSetMinimumBrowserSupport()
	{
		//System.out.println("setMinimumBrowserSupport");
		Browsers minimumBrowserSupport = null;
		Html instance = new HtmlImpl();
		instance.setBrowser(Browsers.Firefox19);
		Browsers expResult = Browsers.Firefox19;
		Browsers result = instance.getBrowser();
		assertEquals(expResult, result);
	}

	@Test
	public void testOutput()
	{
		JQueryPageConfigurator.setRequired(false);
		AngularPageConfigurator.setRequired(false);
		//System.out.println("testOutput");
		Html instance = new HtmlImpl();
		instance.setBrowser(Browsers.Firefox19);
		System.out.println(instance.toString(true));
		String expResult = "<!DOCTYPE html>\n" + "<html>\n" + "</html>";
		String result = instance.toString(true);
		assertEquals(expResult, result);

		instance.setTiny(true);
		expResult = "<!DOCTYPE html><html></html>";
		result = instance.toString(true);
		System.out.println(instance.toString(true));
		assertEquals(expResult, result);
	}

	public class HtmlImpl
			extends Page
	{

		public HtmlImpl()
		{
			super();
			setBrowser(Browsers.Chrome);
		}
	}
}
