/*
 * Copyright (C) 2016 GedMarc
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
package za.co.mmagon.jwebswing.components.jqueryUI.button;

import org.junit.Test;
import za.co.mmagon.BaseTestClass;

/**
 *
 * @author GedMarc
 */
public class JQUIButtonTest extends BaseTestClass
{

    public JQUIButtonTest()
    {
    }

    @Test
    public void testHtml()
    {
        JQUIButton button = new JQUIButton("test");
        button.setID("test");
        System.out.println(button.toString(true));
    }

    @Test
    public void testJS()
    {
        JQUIButton button = new JQUIButton("test");
        button.setID("test");
        //button.toString(true);
        //System.out.println(button.renderJavascript());
        System.out.println(button.renderJavascriptAll());

    }

    /**
     * Test of getOptions method, of class JQUIButton.
     */
    @Test
    public void testGetOptions()
    {
    }

    /**
     * Test of getFeature method, of class JQUIButton.
     */
    @Test
    public void testGetFeature()
    {
    }

}
