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

package com.jwebmp.core.base.html;

import com.jwebmp.BaseTestClass;
import com.jwebmp.core.Page;
import com.jwebmp.core.base.client.Browsers;
import com.jwebmp.core.base.html.attributes.BaseAttributes;
import com.jwebmp.core.plugins.jquery.JQueryPageConfigurator;
import com.jwebmp.testing.IBaseTest;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author MMagon
 */
public class BaseTest
		extends BaseTestClass
{

	@AfterAll
	public static void tearDownAll()
	{
		IBaseTest.tearDownAll();
	}

	@BeforeAll
	public static void initAll()
	{
		IBaseTest.initAll();
	}


	@Override
	@AfterEach
	public void tearDown()
	{
		super.tearDown();
	}

	@Override
	@BeforeEach
	public void init()
	{
		super.init();
	}


	public BaseTest()
	{
	}

	@Test
	public void testBaseOutputTiny()
	{
		JQueryPageConfigurator.setRequired(false);
		Page page = getInstance();
		Base instance = new Base();
		page.getOptions()
		    .setBase(instance);
		instance.addAttribute(BaseAttributes.Target, "Target Frame");
		instance.addAttribute(BaseAttributes.HRef, "This is a link to something");
		instance.setTiny(true);
		System.out.println(instance.toString(true));
		String expResult = "<base href=\"This is a link to something\" target=\"Target Frame\">";
		String result = instance.toString(true);
		assertEquals(expResult, result);
	}

	@Test
	public void testBaseOutputOldBrowsers()
	{
		JQueryPageConfigurator.setRequired(false);
		Page page = getInstance();
		Base instance = new Base();
		page.getOptions()
		    .setBase(instance);
		instance.addAttribute(BaseAttributes.Target, "Target Frame");
		instance.addAttribute(BaseAttributes.HRef, "This is a link to something");
		/**
		 * Test XHTML change to the tag
		 */
		page.setBrowser(Browsers.InternetExplorer6);
		String expResult = "<base href=\"This is a link to something\" target=\"Target Frame\"/>";
		String result = instance.toString(true);
		System.out.println(instance.toString(true));
		assertEquals(expResult, result);
	}

	@Test
	public void testBaseOutputOldBrowsersTiny()
	{
		JQueryPageConfigurator.setRequired(false);
		Page page = getInstance();
		Base instance = new Base();
		page.getOptions()
		    .setBase(instance);
		instance.addAttribute(BaseAttributes.Target, "Target Frame");
		instance.addAttribute(BaseAttributes.HRef, "This is a link to something");
		/**
		 * Test XHTML change to the tag
		 */
		page.setBrowser(Browsers.InternetExplorer6);
		String expResult = "<base href=\"This is a link to something\" target=\"Target Frame\"/>";
		String result = instance.toString(true);
		System.out.println(instance.toString(true));
		assertEquals(expResult, result);
	}

	@Test
	public void testBaseOutput()
	{
		JQueryPageConfigurator.setRequired(false);
		Page page = getInstance();
		Base instance = new Base();
		page.getOptions()
		    .setBase(instance);
		instance.addAttribute(BaseAttributes.Target, "Target Frame");
		instance.addAttribute(BaseAttributes.HRef, "This is a link to something");
		System.out.println(instance.toString(true));
		String expResult = "<base href=\"This is a link to something\" target=\"Target Frame\">";
		String result = instance.toString(true);
		assertEquals(expResult, result);
	}

	@Test
	public void testBaseTiny()
	{
		JQueryPageConfigurator.setRequired(false);
		Page page = getInstance();
		Base instance = new Base();
		page.getOptions()
		    .setBase(instance);
		instance.addAttribute(BaseAttributes.Target, "Target Frame");
		instance.addAttribute(BaseAttributes.HRef, "This is a link to something");
		System.out.println(instance.toString(true));
		String expResult;
		String result;
		page.setTiny(false);
		System.out.println(page.toString(true));
		expResult = "<!DOCTYPE html>\n" + "<html>\n" + "\t<head>\n" + "\t\t<base href=\"This is a link to something\" target=\"Target Frame\">\n" + "\t</head>\n" + "</html>";
		result = page.toString(true);
		assertEquals(expResult, result);
	}

	@Test
	public void testBaseTinyPage()
	{
		JQueryPageConfigurator.setRequired(false);
		Page page = getInstance();
		Base instance = new Base();
		page.getOptions()
		    .setBase(instance);
		instance.addAttribute(BaseAttributes.Target, "Target Frame");
		instance.addAttribute(BaseAttributes.HRef, "This is a link to something");
		System.out.println(instance.toString(true));
		String expResult;
		String result;

		page.setTiny(true);
		System.out.println(page.toString(true));
		expResult = "<!DOCTYPE html><html><head><base href=\"This is a link to something\" target=\"Target Frame\"></head></html>";
		result = page.toString(true);
		assertEquals(expResult, result);
	}
}
