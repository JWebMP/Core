/*
 * Copyright (C) 2014 MMagon
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

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author MMagon
 */
public class BoldTest
{

    public BoldTest()
    {
    }

    @Test
    public void testBoldRender()
    {
        Bold b = new Bold();
        b.setID("ID");
        b.setText("Bold Text");
        System.out.println(b.toString(true));
        assertEquals("<b>Bold Text</b>", b.toString(true));

    }

}
