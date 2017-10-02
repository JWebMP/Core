package za.co.mmagon.jwebswing.base.html;

import org.junit.jupiter.api.Test;
import za.co.mmagon.BaseTestClass;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.servlets.enumarations.DevelopmentEnvironments;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author MMagon
 */
public class HeadTest extends BaseTestClass
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
		expResult = "<!DOCTYPE html>\n" +
				"<html>\n" +
				"\t<head>\n" +
				"\t\t<!-- Priority [Top_Shelf] Values -->\n" +
				"\t\t<script src=\"persist-js/persist-all-min.js\" type=\"text/javascript\"></script>\n" +
				"\t</head>\n" +
				"</html>";
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
		expResult = "<!DOCTYPE html><html><head><script src=\"persist-js/persist-all-min.js\" type=\"text/javascript\"></script></head></html>";
		result = html.toString(true);
		System.out.println(html.toString(true));
		assertEquals(expResult, result);
	}
}
