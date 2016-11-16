package za.co.mmagon.jwebswing.base.html;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.client.Browsers;

/**
 * Tests all aspects of the HTML Raw Component
 *
 * @author MMagon
 */
public class HtmlTest
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
        //System.out.println("testOutput");
        Html instance = new HtmlImpl();
        instance.setBrowser(Browsers.Firefox19);
        System.out.println(instance.toString(true));
        String expResult = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "</html>";
        String result = instance.toString(true).toString();
        assertEquals(expResult, result);

        instance.setTiny(true);
        expResult = "<!DOCTYPE html><html></html>";
        result = instance.toString(true).toString();
        System.out.println(instance.toString(true));
        assertEquals(expResult, result);
    }

    public class HtmlImpl extends Page
    {

        public HtmlImpl()
        {
            super();
            setBrowser(Browsers.Chrome);
        }
    }
}
