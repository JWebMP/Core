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
import za.co.mmagon.jwebswing.base.html.attributes.HeaderTypes;

/**
 *
 * @author GedMarc
 */
public class HeaderTextTest
{
    public HeaderTextTest()
    {
    }

    @Test
    public void reset()
    {
        HeaderText h1 = new HeaderText(HeaderTypes.H1, "bla");
        HeaderText h2 = new HeaderText(HeaderTypes.H2, "bla");
        h1.setID("id");
        h2.setID("id");
        System.out.println(h1.toString(true));
        System.out.println(h2.toString(true));
        Assert.assertNotSame(h1,h2);
        h2.setHeaderType(HeaderTypes.H1);
        Assert.assertEquals(h1,h2);
        h2.setHeaderText("new text");
        Assert.assertNotSame(h1,h2);
    }
}
