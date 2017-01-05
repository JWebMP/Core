/*
 * Copyright (C) 2014 GedMarc
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
package za.co.mmagon.jwebswing.base.html;

import org.junit.Assert;
import org.junit.Test;
import za.co.mmagon.BaseTestClass;
import za.co.mmagon.jwebswing.base.html.attributes.CanvasAttributes;

/**
 *
 * @author GedMarc
 */
public class CanvasTest extends BaseTestClass
{

    public CanvasTest()
    {
    }

    @Test
    public void testSomeMethod()
    {
        System.out.println("neg");
        Canvas c21 = new Canvas();
        System.out.println("asdfg");
        c21.addAttribute(CanvasAttributes.Height, "asdf");
        System.out.println(c21.toString(true));
        Canvas c = new Canvas();
        c.setID("Canvas");
        c.addAttribute(CanvasAttributes.Height, "200px");
        c.addAttribute(CanvasAttributes.Width, "200px");
        System.out.println(c.toString(true));
        Assert.assertEquals("<canvas height=\"200px\" width=\"200px\" id=\"Canvas\"></canvas>", c.toString(true).toString());
    }

}
