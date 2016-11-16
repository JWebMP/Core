package za.co.mmagon.jwebswing.htmlbuilder.css.composer;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author MMagon
 */
public class CSSLineTest
{

    public CSSLineTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {
    }

    @AfterClass
    public static void tearDownClass()
    {
    }

    @Before
    public void setUp()
    {
    }

    @After
    public void tearDown()
    {
    }

    @Test
    public void testToString()
    {
        System.out.println("Testing CSS Line");
        CSSLine line1 = new CSSLine("Propert1", "Value1");
        assertEquals("propert1:Value1", line1.toString());
        CSSLine line2 = new CSSLine("text-decoration", "textDecoration");
        assertEquals("text-decoration:textDecoration", line2.toString());
        System.out.println("Passed CSS Line");
    }
}
