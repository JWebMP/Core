package za.co.mmagon.jwebswing.base.html;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import za.co.mmagon.BaseTestClass;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.client.Browsers;
import za.co.mmagon.jwebswing.base.html.attributes.BaseAttributes;

/**
 *
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
        expResult = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "	<head>\n"
                + "		<base href=\"This is a link to something\" target=\"Target Frame\">\n"
                + "	</head>\n"
                + "</html>";
        result = page.toString(true).toString();
        assertEquals(expResult, result);

        page.setTiny(true);
        System.out.println(page.toString(true));
        expResult = "<!DOCTYPE html><html><head><base href=\"This is a link to something\" target=\"Target Frame\"></head></html>";
        result = page.toString(true).toString();
        assertEquals(expResult, result);
    }
}
