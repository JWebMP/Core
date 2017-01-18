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
package za.co.mmagon.jwebswing;

import org.junit.Assert;
import org.junit.Test;
import za.co.mmagon.BaseTestClass;
import za.co.mmagon.jwebswing.base.html.Body;
import za.co.mmagon.jwebswing.base.html.Paragraph;

/**
 *
 * @author GedMarc
 */
public class ComponentTest extends BaseTestClass
{

    public ComponentTest()
    {
    }

    /**
     * Test of add method, of class Component.
     */
    @Test
    public void testAdd()
    {
        Page p = getPage();
        Body b = p.getBody();
        Paragraph pa = new Paragraph("String adds a paragraph");
        b.add(pa);
        pa.setID("paragraph");
        System.out.println(p.toString(true));
        Assert.assertEquals("<!DOCTYPE html>\n"
                + "<html>\n"
                + "	<body id=\"body\">\n"
                + "		<p id=\"paragraph\">String adds a paragraph</p>\n"
                + "	</body>\n"
                + "</html>", p.toString(true));

    }

}
