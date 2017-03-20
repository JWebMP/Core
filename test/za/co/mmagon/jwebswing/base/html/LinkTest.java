/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.mmagon.jwebswing.base.html;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes;

/**
 *
 * @author MMagon
 */
public class LinkTest
{

    public LinkTest()
    {
    }

    private Link getInstance()
    {
        Link instance = new Link("tt");
        instance.setID("id");
        return instance;
    }

    /**
     * Test of getCSSClassName method, of class Link.
     */
    @Test
    public void testALink()
    {
        Link instance = getInstance();
        instance.setID("id");
        System.out.println(instance.toString(true));
        String expResult = "<a href=\"tt\" id=\"id\"></a>";
        String result = instance.toString(true).toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCSSClassName method, of class Link.
     */
    @Test
    public void testALinkWithAddress()
    {
        Link instance = new Link("Address");
        instance.setID("instance");
        instance.addAttribute(GlobalAttributes.ID, "instance");
        System.out.println(instance.toString(true));
        String expResult = "<a href=\"Address\" id=\"instance\"></a>";
        String result = instance.toString(true).toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testALinkWithAddressAndTarget()
    {
        Link instance = new Link("Address", "Target");
        instance.setID("instance");
        instance.addAttribute(GlobalAttributes.ID, "instance");
        System.out.println(instance.toString(true));
        String expResult = "<a href=\"Address\" id=\"instance\" target=\"Target\"></a>";
        String result = instance.toString(true).toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testALinkWithAddressAndTargetAndChildren()
    {
        Link instance = new Link("Address", "Target");
        instance.setID("id");
        Paragraph p = new Paragraph("Child");
        p.addAttribute(GlobalAttributes.ID, "instance");
        p.setID("od");
        instance.add(p);
        instance.addAttribute(GlobalAttributes.ID, "instance");
        System.out.println(instance.toString(true));
        String expResult = ""
                + "<a href=\"Address\" id=\"id\" target=\"Target\">\n"
                + "	<p id=\"od\">Child</p>\n"
                + "</a>";
        String result = instance.toString(true).toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCSSClassName method, of class Link.
     */
    @Test
    public void testALinkTiny()
    {
        Link instance = new Link("");
        instance.setID("instance");
        instance.setTiny(true);
        instance.addAttribute(GlobalAttributes.ID, "instance");
        System.out.println(instance.toString(true));
        String expResult = "<a href=\"\" id=\"instance\"></a>";
        String result = instance.toString(true).toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCSSClassName method, of class Link.
     */
    @Test
    public void testALinkWithAddressTiny()
    {
        Link instance = new Link("Address");
        instance.setID("instance");
        instance.setTiny(true);
        instance.addAttribute(GlobalAttributes.ID, "instance");
        System.out.println(instance.toString(true));
        String expResult = "<a href=\"Address\" id=\"instance\"></a>";
        String result = instance.toString(true).toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testALinkWithAddressAndTargetTiny()
    {
        Link instance = new Link("Address", "Target");
        instance.setTiny(true);
        instance.setID("instance");
        System.out.println(instance.toString(true));
        String expResult = "<a href=\"Address\" id=\"instance\" target=\"Target\"></a>";
        String result = instance.toString(true).toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testALinkWithAddressAndTargetAndChildrenTiny()
    {
        Link instance = new Link("Address", "Target");
        instance.setID("id");
        Paragraph p = new Paragraph("Child");
        p.setID("instance");
        instance.add(p);
        instance.setTiny(true);
        instance.addAttribute(GlobalAttributes.ID, "instance");
        System.out.println(instance.toString(true));
        String expResult = "<a href=\"Address\" id=\"id\" target=\"Target\"><p id=\"instance\">Child</p></a>";
        String result = instance.toString(true).toString();
        assertEquals(expResult, result);
    }
}
