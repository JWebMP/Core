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
import za.co.mmagon.jwebswing.Page;

/**
 *
 * @author GedMarc
 */
public class BiDirectionalIsolationTest extends BaseTestClass
{

    private BiDirectionalIsolation bdi = new BiDirectionalIsolation();
    private Page p = new Page();
    private Body b = new Body(p);

    public BiDirectionalIsolationTest()
    {
    }

    private void reset()
    {
        bdi = new BiDirectionalIsolation("test");
        p = getPage();
        b.add(bdi);
    }

    /**
     * Test of setText method, of class BiDirectionalIsolation.
     */
    @Test
    public void testSetText()
    {
        reset();
        bdi.setText("set text demo");
        System.out.println(bdi.toString(true));
        Assert.assertEquals("<bdi>set text demo</bdi>", bdi.toString(true).toString());
    }
}
