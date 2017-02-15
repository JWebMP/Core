/*
 * Copyright (C) 2015 GedMarc
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
import za.co.mmagon.jwebswing.base.ComponentBase;

/**
 *
 * @author GedMarc
 */
public class TableCellTest
{

    public TableCellTest()
    {
    }

    /**
     * Test of getColumnSpan method, of class TableCell.
     */
    @Test
    public void testGetColumnSpan()
    {
        TableCell tc = new TableCell("blah");
        tc.setID("id");
        ComponentBase.class.cast(tc.getChildren().get(0)).setID("id");
        System.out.println(tc.toString(true));
        assertEquals("<td id=\"id\">\n"
                + "	<p id=\"id\">blah</p>\n"
                + "</td>", tc.toString(true).toString());

        tc.setColumnSpan(0);
        System.out.println(tc.toString(true));
        assertEquals("<td colspan=\"0\" id=\"id\">\n"
                + "	<p id=\"id\">blah</p>\n"
                + "</td>", tc.toString(true).toString());
    }

}
