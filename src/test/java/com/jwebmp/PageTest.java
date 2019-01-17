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
package com.jwebmp;

import com.jwebmp.core.Page;
import com.jwebmp.core.base.client.Browsers;
import com.jwebmp.core.base.client.InternetExplorerCompatibilityMode;
import com.jwebmp.core.base.html.Base;
import com.jwebmp.core.base.html.Body;
import com.jwebmp.core.base.html.Comment;
import com.jwebmp.core.base.html.H1;
import com.jwebmp.core.base.html.attributes.BaseAttributes;
import com.jwebmp.core.base.servlets.enumarations.DevelopmentEnvironments;
import com.jwebmp.core.htmlbuilder.css.backgrounds.BackgroundAttachments;
import com.jwebmp.core.htmlbuilder.css.colours.ColourNames;
import com.jwebmp.testing.IBaseTest;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author GedMarc
 */
public class PageTest
		extends BaseTestClass
{
	Page instance;


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
		instance = getInstance();
	}

	public PageTest()
	{
	}

	@Test
	public void testBlankPage()
	{
		Page p = getInstance();
		System.out.println(p);
		System.out.println(p.toString(0));
	}

	@Test
	public void testCSS()
	{
		Page p = getInstance();
		p.getBody()
		 .add(new Comment("Meh"));
		p.getBody()
		 .getCss()
		 .getBackground()
		 .setBackgroundColor$(ColourNames.DarkGoldenRod);
		p.getBody()
		 .getCss()
		 .getBackground()
		 .setBackgroundAttachment(BackgroundAttachments.Fixed);
		System.out.println(p.getBody()
		                    .getCss());
		System.out.println(p.getBody()
		                    .getCss()
		                    .getBackground()
		                    .getMap());
		p.getOptions()
		 .setDynamicRender(false);
		System.out.println(p.toString(true));
	}

	@Test
	public void testCSSWithChildren()
	{
		Page p = getInstance();
		p.getBody()
		 .add(new Comment("Meh"));
		p.getBody()
		 .getCss()
		 .getBackground()
		 .setBackgroundColor$(ColourNames.DarkGoldenRod);
		H1 child = new H1("child");
		child.setID("child");
		child.getCss()
		     .getBackground()
		     .setBackgroundColor$(ColourNames.AntiqueWhite);
		p.getBody()
		 .add(child);
		p.getOptions()
		 .setDynamicRender(false);
		System.out.println(p.toString(true));
		System.out.println(p.getBody()
		                    .renderCss(0));
		System.out.println(child.renderCss(0));
	}

	@Test
	public void testDefaultOutput()
	{
		String result;
		instance = getInstance();
		instance.setTiny(false);
		instance.setRunningEnvironment(DevelopmentEnvironments.Development);
		System.out.println(result = instance.toString(true));
		String expResult = "<!DOCTYPE html>\n" + "<html>\n" + "</html>";
		assertEquals(expResult, result);
	}

	@Test
	public void testDefaultOutputTiny()
	{
		String result;
		instance = getInstance();
		instance.setTiny(true);
		instance.setRunningEnvironment(DevelopmentEnvironments.Production);
		System.out.println(result = instance.toString(true));
		String expResult = "<!DOCTYPE html><html></html>";
		assertEquals(expResult, result);
	}

	/**
	 * mustn't have a tag, header contains nothing
	 */
	@Test
	public void testBlankHeader()
	{
		String result;
		instance = getInstance();
		instance.setRunningEnvironment(DevelopmentEnvironments.Development);
		System.out.println(result = instance.toString(true));
		String expResult = "<!DOCTYPE html>\n" + "<html>\n" + "</html>";
		assertEquals(expResult, result);
	}

	/**
	 * mustn't have a tag, header contains nothing
	 */
	@Test
	public void testBlankHeaderNoComments()
	{
		String result;
		instance = getInstance();
		instance.setRunningEnvironment(DevelopmentEnvironments.Development);
		System.out.println(result = instance.toString(true));
		String expResult = "<!DOCTYPE html>\n" + "<html>\n" + "</html>";
		assertEquals(expResult, result);
	}

	@Test
	public void testBlankHeaderTiny()
	{
		String result;
		instance = getInstance();
		instance.setTiny(true);
		instance.setRunningEnvironment(DevelopmentEnvironments.Production);
		System.out.println(result = instance.toString(true));
		String expResult = "<!DOCTYPE html><html></html>";
		assertEquals(expResult, result);
	}

	@Test
	public void testAuthor()
	{
		String result;
		instance = getInstance();
		instance.setRunningEnvironment(DevelopmentEnvironments.Development);
		instance.getPageFields()
		        .setAuthor("Marc Magon");
		System.out.println(result = instance.toString(true));
		String expResult = "<!DOCTYPE html>\n" + "<html>\n" + "\t<head>\n" + "\t\t<meta content=\"Marc Magon\" name=\"author\">\n" + "\t</head>\n" + "</html>";
		assertEquals(expResult, result);
	}

	@Test
	public void testAuthorTiny()
	{
		String result;
		instance = getInstance();
		instance.setTiny(true);
		instance.setRunningEnvironment(DevelopmentEnvironments.Production);
		instance.getPageFields()
		        .setAuthor("Marc Magon");
		System.out.println(result = instance.toString(true));
		String expResult = "<!DOCTYPE html><html><head><meta content=\"Marc Magon\" name=\"author\"></head></html>";
		assertEquals(expResult, result);
	}

	@Test
	public void testDescription()
	{
		String result;
		instance = getInstance();
		instance.setTiny(false);
		instance.setRunningEnvironment(DevelopmentEnvironments.Development);
		instance.getPageFields()
		        .setDescription("This is my page description... It can be very very long");
		System.out.println(result = instance.toString(true));
		String expResult =
				"<!DOCTYPE html>\n" + "<html>\n" + "\t<head>\n" + "\t\t<meta content=\"This is my page description... It can be very very long\" name=\"description\">\n" +
				"\t</head>\n" + "</html>";
		assertEquals(expResult, result);
	}

	@Test
	public void testDescriptionTiny()
	{
		String result;
		instance = getInstance();
		instance.setTiny(true);
		instance.setRunningEnvironment(DevelopmentEnvironments.Production);
		instance.getPageFields()
		        .setDescription("This is my page description... It can be very very long");
		System.out.println(result = instance.toString(true));
		String expResult = "<!DOCTYPE html><html><head><meta content=\"This is my page description... It can be very very long\" name=\"description\"></head></html>";
		assertEquals(expResult, result);
	}

	@Test
	public void testGenerator()
	{
		String result;
		instance = getInstance();
		instance.setRunningEnvironment(DevelopmentEnvironments.Development);
		instance.getPageFields()
		        .setGenerator("This is my page description... It can be very very long");
		System.out.println(result = instance.toString(true));
		String expResult = "<!DOCTYPE html>\n" + "<html>\n" + "\t<head>\n" + "\t\t<meta content=\"This is my page description... It can be very very long\" name=\"generator\">\n" +
		                   "\t</head>\n" + "</html>";
		assertEquals(expResult, result);
	}

	@Test
	public void testGeneratorTiny()
	{
		String result;
		instance = getInstance();
		instance.setTiny(true);
		instance.setRunningEnvironment(DevelopmentEnvironments.Production);
		instance.getPageFields()
		        .setGenerator("This is my page description... It can be very very long");
		System.out.println(result = instance.toString(true));
		String expResult = "<!DOCTYPE html><html><head><meta content=\"This is my page description... It can be very very long\" name=\"generator\"></head></html>";
		assertEquals(expResult, result);
	}

	@Test
	public void testKeywords()
	{
		String result;
		instance = getInstance();
		instance.setRunningEnvironment(DevelopmentEnvironments.Development);
		instance.getPageFields()
		        .setKeywords("This is my page description... It can be very very long");
		System.out.println(result = instance.toString(true));
		String expResult = "<!DOCTYPE html>\n" + "<html>\n" + "\t<head>\n" + "\t\t<meta content=\"This is my page description... It can be very very long\" name=\"keywords\">\n" +
		                   "\t</head>\n" + "</html>";
		assertEquals(expResult, result);
	}

	@Test
	public void testKeywordsTiny()
	{
		String result;
		instance = getInstance();
		instance.setTiny(true);
		instance.setRunningEnvironment(DevelopmentEnvironments.Production);
		instance.getPageFields()
		        .setKeywords("This is my page description... It can be very very long");
		System.out.println(result = instance.toString(true));
		String expResult = "<!DOCTYPE html><html><head><meta content=\"This is my page description... It can be very very long\" name=\"keywords\"></head></html>";
		assertEquals(expResult, result);
	}

	@Test
	public void testBase()
	{
		String result;
		instance = getInstance();
		instance.setBrowser(Browsers.InternetExplorer10);
		Base b = new Base();
		b.addAttribute(BaseAttributes.Target, "The Base Target");
		instance.getPageFields()
		        .setBase(b);
		instance.setTiny(false);
		instance.setRunningEnvironment(DevelopmentEnvironments.Development);
		System.out.println(result = instance.toString(true));
		String expResult = "<!DOCTYPE html>\n" + "<html>\n" + "\t<head>\n" + "\t\t<base target=\"The Base Target\">\n" + "\t</head>\n" + "</html>";
		assertEquals(expResult, result);
	}

	@Test
	public void testBaseTiny()
	{
		String result;
		instance = getInstance();
		instance.getPageFields()
		        .setBase(new Base());
		instance.setTiny(true);
		instance.setRunningEnvironment(DevelopmentEnvironments.Production);
		System.out.println(result = instance.toString(true));
		String expResult = "<!DOCTYPE html><html><head><base></head></html>";
		assertEquals(expResult, result);
	}

	@Test
	public void testAll()
	{
		instance = getInstance();
		instance.getPageFields()
		        .setTitle("This is my title");
		Body body = instance.getBody();
		Base base = new Base();
		base.addAttribute(BaseAttributes.Target, "Base Target");
		instance.getPageFields()
		        .setBase(base);
		instance.getPageFields()
		        .setAuthor("Author GedMarc");
		instance.getPageFields()
		        .setDescription("Page Description");
		instance.getPageFields()
		        .setApplicationNameMeta("Application Name");
		instance.getPageFields()
		        .setGenerator("Generator");
		instance.getPageFields()
		        .setCompatibilityMode(InternetExplorerCompatibilityMode.IE10);
		instance.setRunningEnvironment(DevelopmentEnvironments.Development);
		String result;
		body.setID(null);
		System.out.println(result = instance.toString(true));
		String expResult = "<!DOCTYPE html>\n" + "<html>\n" + "\t<head>\n" + "\t\t<title>This is my title</title>\n" + "\t\t<base target=\"Base Target\">\n" +
		                   "\t\t<meta content=\"IE=10\" http-equiv=\"X-UA-Compatible\">\n" + "\t\t<meta content=\"Author GedMarc\" name=\"author\">\n" +
		                   "\t\t<meta content=\"Application Name\" name=\"application-name\">\n" + "\t\t<meta content=\"Generator\" name=\"generator\">\n" +
		                   "\t\t<meta content=\"Page Description\" name=\"description\">\n" + "\t</head>\n" + "</html>";
		assertEquals(expResult, result);
	}

	@Test
	public void testAllTiny()
	{
		instance = getInstance();
		instance.getPageFields()
		        .setTitle("This is my title");
		instance.setTiny(true);
		Body body = instance.getBody();
		Base base = new Base();
		base.addAttribute(BaseAttributes.Target, "Base Target");
		instance.getPageFields()
		        .setBase(base);
		instance.getPageFields()
		        .setAuthor("Author GedMarc");
		instance.getPageFields()
		        .setDescription("Page Description");
		instance.getPageFields()
		        .setApplicationNameMeta("Application Name");
		instance.getPageFields()
		        .setGenerator("Generator");
		instance.getPageFields()
		        .setCompatibilityMode(InternetExplorerCompatibilityMode.IE10);
		instance.setRunningEnvironment(DevelopmentEnvironments.Production);
		String result;
		System.out.println(result = instance.toString(true));
		String expResult = "<!DOCTYPE html><html><head><title>This is my title</title><base target=\"Base Target\"><meta content=\"IE=10\" http-equiv=\"X-UA-Compatible\"><meta content=\"Author GedMarc\" name=\"author\"><meta content=\"Application Name\" name=\"application-name\"><meta content=\"Generator\" name=\"generator\"><meta content=\"Page Description\" name=\"description\"></head></html>";
		assertEquals(expResult, result);
	}

	@Test
	public void testDynamicOn()
	{
		instance = getInstance();
		instance.getOptions()
		        .setDynamicRender(true);
		System.out.println(instance.toString(0));
	}

	@Test
	public void testDynamicOff()
	{
		instance = getInstance();
		instance.getOptions()
		        .setDynamicRender(false);
		System.out.println(instance.toString(0));
	}

}
