package za.co.mmagon.jwebswing.base.html;

import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.client.Browsers;
import za.co.mmagon.jwebswing.base.html.attributes.BaseAttributes;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author MMagon
 */
public class BaseTest extends BaseTestClass
{

	public BaseTest()
	{
	}

	@Test
	public void testBaseOutputTiny()
	{
		Page page = getPage();
		Base instance = new Base();
		page.getPageFields().setBase(instance);
		instance.addAttribute(BaseAttributes.Target, "Target Frame");
		instance.addAttribute(BaseAttributes.HRef, "This is a link to something");
		instance.setTiny(true);
		System.out.println(instance.toString(true));
		String expResult = "<base href=\"This is a link to something\" target=\"Target Frame\">";
		String result = instance.toString(true).toString();
		assertEquals(expResult, result);
	}

	@Test
	public void testBaseOutputOldBrowsers()
	{
		Page page = getPage();
		Base instance = new Base();
		page.getPageFields().setBase(instance);
		instance.addAttribute(BaseAttributes.Target, "Target Frame");
		instance.addAttribute(BaseAttributes.HRef, "This is a link to something");
		/**
		 * Test XHTML change to the tag
		 */
		page.setBrowser(Browsers.InternetExplorer6);
		String expResult = "<base href=\"This is a link to something\" target=\"Target Frame\"/>";
		String result = instance.toString(true).toString();
		System.out.println(instance.toString(true));
		assertEquals(expResult, result);
	}

	@Test
	public void testBaseOutputOldBrowsersTiny()
	{
		Page page = getPage();
		Base instance = new Base();
		page.getPageFields().setBase(instance);
		instance.addAttribute(BaseAttributes.Target, "Target Frame");
		instance.addAttribute(BaseAttributes.HRef, "This is a link to something");
		/**
		 * Test XHTML change to the tag
		 */
		page.setBrowser(Browsers.InternetExplorer6);
		String expResult = "<base href=\"This is a link to something\" target=\"Target Frame\"/>";
		String result = instance.toString(true).toString();
		System.out.println(instance.toString(true));
		assertEquals(expResult, result);
	}

	@Test
	public void testBaseOutput()
	{
		Page page = getPage();
		Base instance = new Base();
		page.getPageFields().setBase(instance);
		instance.addAttribute(BaseAttributes.Target, "Target Frame");
		instance.addAttribute(BaseAttributes.HRef, "This is a link to something");
		System.out.println(instance.toString(true));
		String expResult = "<base href=\"This is a link to something\" target=\"Target Frame\">";
		String result = instance.toString(true).toString();
		assertEquals(expResult, result);

		page.setTiny(false);
		System.out.println(page.toString(true));
		expResult = "<!DOCTYPE html>\n" +
				"<html>\n" +
				"\t<head>\n" +
				"\t\t<base href=\"This is a link to something\" target=\"Target Frame\">\n" +
				"\t\t<!-- Priority [Top_Shelf] Values -->\n" +
				"\t\t<script src=\"persist-js/persist-all-min.js\" type=\"text/javascript\"></script>\n" +
				"\t</head>\n" +
				"</html>";
		result = page.toString(true).toString();
		assertEquals(expResult, result);

		page.setTiny(true);
		System.out.println(page.toString(true));
		expResult = "<!DOCTYPE html><html><head><base href=\"This is a link to something\" target=\"Target Frame\"><script src=\"persist-js/persist-all-min.js\" type=\"text/javascript\"></script></head></html>";
		result = page.toString(true).toString();
		assertEquals(expResult, result);
	}
}
