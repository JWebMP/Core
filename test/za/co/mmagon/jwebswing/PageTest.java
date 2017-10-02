/*
 * Copyright (C) 2015 GedMarc
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
package za.co.mmagon.jwebswing;

import org.junit.jupiter.api.Test;
import za.co.mmagon.BaseTestClass;
import za.co.mmagon.jwebswing.base.client.Browsers;
import za.co.mmagon.jwebswing.base.client.InternetExplorerCompatibilityMode;
import za.co.mmagon.jwebswing.base.html.Base;
import za.co.mmagon.jwebswing.base.html.Body;
import za.co.mmagon.jwebswing.base.html.Comment;
import za.co.mmagon.jwebswing.base.html.H1;
import za.co.mmagon.jwebswing.base.html.attributes.BaseAttributes;
import za.co.mmagon.jwebswing.base.servlets.enumarations.DevelopmentEnvironments;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourNames;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author GedMarc
 */
public class PageTest extends BaseTestClass
{

	Page instance;

	public PageTest()
	{
		instance = new Page();
	}

	@Test
	public void testBlankPage()
	{
		Page p = getPage();
		System.out.println(p);
		System.out.println(p.toString(0));
	}

	@Test
	public void testCSS()
	{
		Page p = getPage();
		p.getBody().add(new Comment("Meh"));
		p.getBody().getCss().getBackground().setBackgroundColor$(ColourNames.DarkGoldenRod);
		System.out.println(p.toString(true));

		assertEquals("<!DOCTYPE html>\n" +
				             "<html>\n" +
				             "\t<head>\n" +
				             "\t\t<!-- Priority [Top_Shelf] Values -->\n" +
				             "\t\t<script src=\"persist-js/persist-all-min.js\" type=\"text/javascript\"></script>\n" +
				             "\t\t<style type=\"text/css\">#body {background-color:darkgoldenrod;}</style>\n" +
				             "\t</head>\n" +
				             "\t<body id=\"body\">\n" +
				             "\t\t<!-- Meh -->\n" +
				             "\t</body>\n" +
				             "</html>", p.toString(true));
	}

	@Test
	public void testCSSWithChildren()
	{
		Page p = getPage();
		p.getBody().add(new Comment("Meh"));
		p.getBody().getCss().getBackground().setBackgroundColor$(ColourNames.DarkGoldenRod);
		H1 child = new H1("child");
		child.setID("child");
		child.getCss().getBackground().setBackgroundColor$(ColourNames.AntiqueWhite);
		p.getBody().add(child);
		System.out.println(p.toString(true));

		// System.out.println(p.getBody().renderCss(0));
		// System.out.println(child.renderCss(0));
		assertEquals("<!DOCTYPE html>\n" +
				             "<html>\n" +
				             "\t<head>\n" +
				             "\t\t<!-- Priority [Top_Shelf] Values -->\n" +
				             "\t\t<script src=\"persist-js/persist-all-min.js\" type=\"text/javascript\"></script>\n" +
				             "\t\t<style type=\"text/css\">#body {background-color:darkgoldenrod;}#child {background-color:antiquewhite;}</style>\n" +
				             "\t</head>\n" +
				             "\t<body id=\"body\">\n" +
				             "\t\t<!-- Meh -->\n" +
				             "\t\t<h1 id=\"child\">child</h1>\n" +
				             "\t</body>\n" +
				             "</html>", p.toString(true));

	}

	@Test
	public void testDefaultOutput()
	{
		String result;
		instance = getPage();
		instance.setTiny(false);
		instance.setRunningEnvironment(DevelopmentEnvironments.Development);
		System.out.println(result = instance.toString(true));
		String expResult = "<!DOCTYPE html>\n" +
				"<html>\n" +
				"\t<head>\n" +
				"\t\t<!-- Priority [Top_Shelf] Values -->\n" +
				"\t\t<script src=\"persist-js/persist-all-min.js\" type=\"text/javascript\"></script>\n" +
				"\t</head>\n" +
				"</html>";
		assertEquals(expResult, result);
	}

	@Test
	public void testDefaultOutputTiny()
	{
		String result;
		instance = getPage();
		instance.setTiny(true);
		instance.setRunningEnvironment(DevelopmentEnvironments.Production);
		System.out.println(result = instance.toString(true));
		String expResult = "<!DOCTYPE html><html><head><script src=\"persist-js/persist-all-min.js\" type=\"text/javascript\"></script></head></html>";
		assertEquals(expResult, result);
	}

	/**
	 * mustn't have a tag, header contains nothing
	 */
	@Test
	public void testBlankHeader()
	{
		String result;
		instance = getPage();
		instance.setRunningEnvironment(DevelopmentEnvironments.Development);
		System.out.println(result = instance.toString(true));
		String expResult = "<!DOCTYPE html>\n" +
				"<html>\n" +
				"\t<head>\n" +
				"\t\t<!-- Priority [Top_Shelf] Values -->\n" +
				"\t\t<script src=\"persist-js/persist-all-min.js\" type=\"text/javascript\"></script>\n" +
				"\t</head>\n" +
				"</html>";
		assertEquals(expResult, result);
	}

	/**
	 * mustn't have a tag, header contains nothing
	 */
	@Test
	public void testBlankHeaderNoComments()
	{
		String result;
		instance = getPage();
		//instance.setRenderComments(false);
		instance.setRunningEnvironment(DevelopmentEnvironments.Development);
		System.out.println(result = instance.toString(true));
		String expResult = "<!DOCTYPE html>\n" +
				"<html>\n" +
				"\t<head>\n" +
				"\t\t<!-- Priority [Top_Shelf] Values -->\n" +
				"\t\t<script src=\"persist-js/persist-all-min.js\" type=\"text/javascript\"></script>\n" +
				"\t</head>\n" +
				"</html>";
		assertEquals(expResult, result);
	}

	@Test
	public void testBlankHeaderTiny()
	{
		String result;
		instance = getPage();
		instance.setTiny(true);
		instance.setRunningEnvironment(DevelopmentEnvironments.Production);
		System.out.println(result = instance.toString(true));
		String expResult = "<!DOCTYPE html><html><head><script src=\"persist-js/persist-all-min.js\" type=\"text/javascript\"></script></head></html>";
		assertEquals(expResult, result);
	}

	@Test
	public void testAuthor()
	{
		String result;
		instance = getPage();
		instance.setRunningEnvironment(DevelopmentEnvironments.Development);
		instance.getPageFields().setAuthor("Marc Magon");
		System.out.println(result = instance.toString(true));
		String expResult = "<!DOCTYPE html>\n" +
				"<html>\n" +
				"\t<head>\n" +
				"\t\t<meta content=\"Marc Magon\" name=\"author\">\n" +
				"\t\t<!-- Priority [Top_Shelf] Values -->\n" +
				"\t\t<script src=\"persist-js/persist-all-min.js\" type=\"text/javascript\"></script>\n" +
				"\t</head>\n" +
				"</html>";
		assertEquals(expResult, result);
	}

	@Test
	public void testAuthorTiny()
	{
		String result;
		instance = getPage();
		instance.setTiny(true);
		instance.setRunningEnvironment(DevelopmentEnvironments.Production);
		instance.getPageFields().setAuthor("Marc Magon");
		System.out.println(result = instance.toString(true));
		String expResult = "<!DOCTYPE html><html><head><meta content=\"Marc Magon\" name=\"author\"><script src=\"persist-js/persist-all-min.js\" type=\"text/javascript\"></script></head></html>";
		assertEquals(expResult, result);
	}

	@Test
	public void testDescription()
	{
		String result;
		instance = getPage();
		instance.setTiny(false);
		instance.setRunningEnvironment(DevelopmentEnvironments.Development);
		instance.getPageFields().setDescription("This is my page description... It can be very very long");
		System.out.println(result = instance.toString(true));
		String expResult = "<!DOCTYPE html>\n" +
				"<html>\n" +
				"\t<head>\n" +
				"\t\t<meta content=\"This is my page description... It can be very very long\" name=\"description\">\n" +
				"\t\t<!-- Priority [Top_Shelf] Values -->\n" +
				"\t\t<script src=\"persist-js/persist-all-min.js\" type=\"text/javascript\"></script>\n" +
				"\t</head>\n" +
				"</html>";
		assertEquals(expResult, result);
	}

	@Test
	public void testDescriptionTiny()
	{
		String result;
		instance = getPage();
		instance.setTiny(true);
		instance.setRunningEnvironment(DevelopmentEnvironments.Production);
		instance.getPageFields().setDescription("This is my page description... It can be very very long");
		System.out.println(result = instance.toString(true));
		String expResult = "<!DOCTYPE html><html><head><meta content=\"This is my page description... It can be very very long\" name=\"description\"><script src=\"persist-js/persist-all-min.js\" type=\"text/javascript\"></script></head></html>";
		assertEquals(expResult, result);
	}

	@Test
	public void testGenerator()
	{
		String result;
		instance = getPage();
		instance.setRunningEnvironment(DevelopmentEnvironments.Development);
		instance.getPageFields().setGenerator("This is my page description... It can be very very long");
		System.out.println(result = instance.toString(true));
		String expResult = "<!DOCTYPE html>\n" +
				"<html>\n" +
				"\t<head>\n" +
				"\t\t<meta content=\"This is my page description... It can be very very long\" name=\"generator\">\n" +
				"\t\t<!-- Priority [Top_Shelf] Values -->\n" +
				"\t\t<script src=\"persist-js/persist-all-min.js\" type=\"text/javascript\"></script>\n" +
				"\t</head>\n" +
				"</html>";
		assertEquals(expResult, result);
	}

	@Test
	public void testGeneratorTiny()
	{
		String result;
		instance = getPage();
		instance.setTiny(true);
		instance.setRunningEnvironment(DevelopmentEnvironments.Production);
		instance.getPageFields().setGenerator("This is my page description... It can be very very long");
		System.out.println(result = instance.toString(true));
		String expResult = "<!DOCTYPE html><html><head><meta content=\"This is my page description... It can be very very long\" name=\"generator\"><script src=\"persist-js/persist-all-min.js\" type=\"text/javascript\"></script></head></html>";
		assertEquals(expResult, result);
	}

	@Test
	public void testKeywords()
	{
		String result;
		instance = getPage();
		instance.setRunningEnvironment(DevelopmentEnvironments.Development);
		instance.getPageFields().setKeywords("This is my page description... It can be very very long");
		System.out.println(result = instance.toString(true));
		String expResult = "<!DOCTYPE html>\n" +
				"<html>\n" +
				"\t<head>\n" +
				"\t\t<meta content=\"This is my page description... It can be very very long\" name=\"keywords\">\n" +
				"\t\t<!-- Priority [Top_Shelf] Values -->\n" +
				"\t\t<script src=\"persist-js/persist-all-min.js\" type=\"text/javascript\"></script>\n" +
				"\t</head>\n" +
				"</html>";
		assertEquals(expResult, result);
	}

	@Test
	public void testKeywordsTiny()
	{
		String result;
		instance = getPage();
		instance.setTiny(true);
		instance.setRunningEnvironment(DevelopmentEnvironments.Production);
		instance.getPageFields().setKeywords("This is my page description... It can be very very long");
		System.out.println(result = instance.toString(true));
		String expResult = "<!DOCTYPE html><html><head><meta content=\"This is my page description... It can be very very long\" name=\"keywords\"><script src=\"persist-js/persist-all-min.js\" type=\"text/javascript\"></script></head></html>";
		assertEquals(expResult, result);
	}

	@Test
	public void testBase()
	{
		String result;
		instance = getPage();
		instance.setBrowser(Browsers.InternetExplorer10);
		Base b = new Base();
		b.addAttribute(BaseAttributes.Target, "The Base Target");
		instance.getPageFields().setBase(b);
		instance.setTiny(false);
		instance.setRunningEnvironment(DevelopmentEnvironments.Development);
		System.out.println(result = instance.toString(true));
		String expResult = "<!DOCTYPE html>\n" +
				"<html>\n" +
				"\t<head>\n" +
				"\t\t<base target=\"The Base Target\">\n" +
				"\t\t<!-- Priority [Top_Shelf] Values -->\n" +
				"\t\t<script src=\"persist-js/persist-all-min.js\" type=\"text/javascript\"></script>\n" +
				"\t</head>\n" +
				"</html>";
		assertEquals(expResult, result);
	}

	@Test
	public void testBaseTiny()
	{
		String result;
		instance = getPage();
		instance.getPageFields().setBase(new Base());
		instance.setTiny(true);
		instance.setRunningEnvironment(DevelopmentEnvironments.Production);
		System.out.println(result = instance.toString(true));
		String expResult = "<!DOCTYPE html><html><head><base><script src=\"persist-js/persist-all-min.js\" type=\"text/javascript\"></script></head></html>";
		assertEquals(expResult, result);
	}

	@Test
	public void testAll()
	{
		instance = getPage();
		instance.getPageFields().setTitle("This is my title");
		final Body body = instance.getBody();
		final Base base = new Base();
		base.addAttribute(BaseAttributes.Target, "Base Target");
		instance.getPageFields().setBase(base);
		instance.getPageFields().setAuthor("Author Marc Magon");
		instance.getPageFields().setDescription("Page Description");
		instance.getPageFields().setApplicationNameMeta("Application Name");
		instance.getPageFields().setGenerator("Generator");
		instance.getPageFields().setCompatibilityMode(InternetExplorerCompatibilityMode.IE10);
		instance.setRunningEnvironment(DevelopmentEnvironments.Development);
		String result;
		body.setID(null);
		System.out.println(result = instance.toString(true));
		String expResult = "<!DOCTYPE html>\n" +
				"<html>\n" +
				"\t<head>\n" +
				"\t\t<title>This is my title</title>\n" +
				"\t\t<base target=\"Base Target\">\n" +
				"\t\t<meta content=\"IE=10\" http-equiv=\"X-UA-Compatible\">\n" +
				"\t\t<meta content=\"Author Marc Magon\" name=\"author\">\n" +
				"\t\t<meta content=\"Application Name\" name=\"application-name\">\n" +
				"\t\t<meta content=\"Generator\" name=\"generator\">\n" +
				"\t\t<meta content=\"Page Description\" name=\"description\">\n" +
				"\t\t<!-- Priority [Top_Shelf] Values -->\n" +
				"\t\t<script src=\"persist-js/persist-all-min.js\" type=\"text/javascript\"></script>\n" +
				"\t</head>\n" +
				"</html>";
		assertEquals(expResult, result);
	}

	@Test
	public void testAllTiny()
	{
		instance = getPage();
		instance.getPageFields().setTitle("This is my title");
		instance.setTiny(true);
		final Body body = instance.getBody();
		final Base base = new Base();
		base.addAttribute(BaseAttributes.Target, "Base Target");
		instance.getPageFields().setBase(base);
		instance.getPageFields().setAuthor("Author Marc Magon");
		instance.getPageFields().setDescription("Page Description");
		instance.getPageFields().setApplicationNameMeta("Application Name");
		instance.getPageFields().setGenerator("Generator");
		instance.getPageFields().setCompatibilityMode(InternetExplorerCompatibilityMode.IE10);
		instance.setRunningEnvironment(DevelopmentEnvironments.Production);
		String result;
		System.out.println(result = instance.toString(true));
		String expResult = "<!DOCTYPE html><html><head><title>This is my title</title><base target=\"Base Target\"><meta content=\"IE=10\" http-equiv=\"X-UA-Compatible\"><meta content=\"Author Marc Magon\" name=\"author\"><meta content=\"Application Name\" name=\"application-name\"><meta content=\"Generator\" name=\"generator\"><meta content=\"Page Description\" name=\"description\"><script src=\"persist-js/persist-all-min.js\" type=\"text/javascript\"></script></head></html>";
		assertEquals(expResult, result);
	}
}
