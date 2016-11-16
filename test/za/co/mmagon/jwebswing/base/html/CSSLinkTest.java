package za.co.mmagon.jwebswing.base.html;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import za.co.mmagon.BaseTestClass;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.client.Browsers;
import za.co.mmagon.jwebswing.base.html.attributes.CSSLinkAttributes;

/**
 *
 * @author MMagon
 */
public class CSSLinkTest extends BaseTestClass
{

    CSSLink instance;

    public CSSLinkTest()
    {
        instance = new CSSLink("");
    }

    @Test
    public void testOutput()
    {
        Page page = getPage();
        page.getBody().add(new Comment("meh"));
        page.getHead().add(instance);
        instance.addAttribute(CSSLinkAttributes.Target, "Target Frame");
        instance.addAttribute(CSSLinkAttributes.HRef, "This is a link to something");
        System.out.println(instance.toString(true));
        String expResult = "<link href=\"This is a link to something\" rel=\"stylesheet\" target=\"Target Frame\" type=\"text/css\">";
        String result = instance.toString(true).toString();
        assertEquals(expResult, result);

        instance.setTiny(true);
        System.out.println(instance.toString(true));
        assertEquals(expResult, result);
        instance.setPage(page);
        /**
         * Test XHTML change to the tag
         */
        instance.getPage().setBrowser(Browsers.InternetExplorer6);
        expResult = "<link href=\"This is a link to something\" rel=\"stylesheet\" target=\"Target Frame\" type=\"text/css\">";
        instance.setTiny(false);
        result = instance.toString(true).toString();
        System.out.println(instance.toString(true));
        System.out.println(expResult);
        assertEquals(expResult, result);

        instance.setTiny(true);
        System.out.println(instance.toString(true));
        assertEquals(expResult, result);
    }

}
