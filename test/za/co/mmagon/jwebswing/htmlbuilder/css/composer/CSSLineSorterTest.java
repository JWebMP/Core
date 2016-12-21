package za.co.mmagon.jwebswing.htmlbuilder.css.composer;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MMagon
 */
public class CSSLineSorterTest
{

    public CSSLineSorterTest()
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
    /**
     * Test of compare method, of class CSSLineSorter.
     */
    @Test
    public void testCompare()
    {
        System.out.println("Testing Line Sorter Compare");
        CSSLine line1 = new CSSLine("Propert1", "Value1");
        CSSLine line2 = new CSSLine("text-decoration", "textDecoration");
        CSSLine line3 = new CSSLine("property2:value2");
        CSSLine line4 = new CSSLine("property2:value2");
        CSSLine line5 = new CSSLine("property2:value1");
        CSSLine line6 = new CSSLine("property1:value1");
        CSSLine line7 = new CSSLine("property1:value2");
        ArrayList<CSSLine> line = new ArrayList();
        line.add(line1);
        line.add(line2);
        line.add(line3);
        line.add(line4);
        line.add(line5);
        line.add(line6);
        line.add(line7);
        CSSLineSorter instance = new CSSLineSorter();
        Collections.sort(line, instance);
        
        if(line.indexOf(line1) != 0)
            fail("Didn't sort correctly");
        else if(line.indexOf(line2) != 6)
            fail("Didn't sort correctly");
        else if(line.indexOf(line5) != 3)
            fail("didn't sort correctly");
        else if(line.indexOf(line6) != 1)
            fail("didn't sort correctly");
        
        System.out.println("Line Sorting Compare Complete");
    }
}