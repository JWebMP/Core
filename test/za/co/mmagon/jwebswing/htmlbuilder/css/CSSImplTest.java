/*
 * Copyright (C) 2016 ged_m
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
package za.co.mmagon.jwebswing.htmlbuilder.css;

import org.junit.*;
import za.co.mmagon.*;
import za.co.mmagon.jwebswing.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.*;

/**
 *
 * @author ged_m
 */
public class CSSImplTest extends BaseTestClass
{

    public CSSImplTest()
    {
    }

    @Test
    public void testToJSON()
    {
        Page p = getInstance();
        CSSImpl imp = new CSSImpl();
        imp.getBackground().setBackgroundColor$(ColourNames.DarkGoldenRod);
        System.out.println(imp.toString());

        Assert.assertEquals("{\n" + "\t\"background\" : {\n" + "\t\t\"backgroundColor$\" : \"darkgoldenrod\"\n" + "\t}\n" + "}", imp.toString());

    }

    /**
     * Test of getAnimatable method, of class CSSImpl.
     */
    @Test
    public void testGetAnimatable()
    {
    }

    /**
     * Test of getCustom method, of class CSSImpl.
     */
    @Test
    public void testGetCustom()
    {
    }

    /**
     * Test of getBackground method, of class CSSImpl.
     */
    @Test
    public void testGetBackground()
    {
    }

    /**
     * Test of getBorder method, of class CSSImpl.
     */
    @Test
    public void testGetBorder()
    {
    }

    /**
     * Test of getColour method, of class CSSImpl.
     */
    @Test
    public void testGetColour()
    {
    }

    /**
     * Test of getDisplay method, of class CSSImpl.
     */
    @Test
    public void testGetDisplay()
    {
    }

    /**
     * Test of getFont method, of class CSSImpl.
     */
    @Test
    public void testGetFont()
    {
    }

    /**
     * Test of getDimensions method, of class CSSImpl.
     */
    @Test
    public void testGetDimensions()
    {
    }

    /**
     * Test of getList method, of class CSSImpl.
     */
    @Test
    public void testGetList()
    {
    }

    /**
     * Test of getMargins method, of class CSSImpl.
     */
    @Test
    public void testGetMargins()
    {
    }

    /**
     * Test of getOutline method, of class CSSImpl.
     */
    @Test
    public void testGetOutline()
    {
    }

    /**
     * Test of getPadding method, of class CSSImpl.
     */
    @Test
    public void testGetPadding()
    {
    }

    /**
     * Test of getTable method, of class CSSImpl.
     */
    @Test
    public void testGetTable()
    {
    }

    /**
     * Test of getText method, of class CSSImpl.
     */
    @Test
    public void testGetText()
    {
    }

    /**
     * Test of setAnimatable method, of class CSSImpl.
     */
    @Test
    public void testSetAnimatable()
    {
    }

    /**
     * Test of setBackground method, of class CSSImpl.
     */
    @Test
    public void testSetBackground()
    {
    }

    /**
     * Test of setBorder method, of class CSSImpl.
     */
    @Test
    public void testSetBorder()
    {
    }

    /**
     * Test of setCustom method, of class CSSImpl.
     */
    @Test
    public void testSetCustom()
    {
    }

    /**
     * Test of setColour method, of class CSSImpl.
     */
    @Test
    public void testSetColour()
    {
    }

    /**
     * Test of setDisplay method, of class CSSImpl.
     */
    @Test
    public void testSetDisplay()
    {
    }

    /**
     * Test of setFonts method, of class CSSImpl.
     */
    @Test
    public void testSetFonts()
    {
    }

    /**
     * Test of setDimensions method, of class CSSImpl.
     */
    @Test
    public void testSetDimensions()
    {
    }

    /**
     * Test of setList method, of class CSSImpl.
     */
    @Test
    public void testSetList()
    {
    }

    /**
     * Test of setMargins method, of class CSSImpl.
     */
    @Test
    public void testSetMargins()
    {
    }

    /**
     * Test of setOutline method, of class CSSImpl.
     */
    @Test
    public void testSetOutline()
    {
    }

    /**
     * Test of setPadding method, of class CSSImpl.
     */
    @Test
    public void testSetPadding()
    {
    }

    /**
     * Test of setTables method, of class CSSImpl.
     */
    @Test
    public void testSetTables()
    {
    }

    /**
     * Test of setText method, of class CSSImpl.
     */
    @Test
    public void testSetText()
    {
    }

}
