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
package za.co.mmagon.jwebswing.components.jqueryUI.combobox;

import org.junit.Assert;
import org.junit.Test;
import za.co.mmagon.jwebswing.base.html.Option;

/**
 *
 * @author GedMarc
 */
public class JQUIComboBoxTest
{

    public JQUIComboBoxTest()
    {
    }

    @Test
    public void testStructure()
    {
        JQUIComboBox combo = new JQUIComboBox();
        combo.setID("combo");
        Option o = new Option("option");
        o.setID("o");
        combo.add(o);
        System.out.println(combo.toString(true));

        String expected = ""
                + "<select id=\"combo\">\n"
                + "	<option id=\"o\" label=\"option\" value=\"option\">option</option>\n"
                + "</select>";
        String result = combo.toString(true).toString();

        Assert.assertEquals(expected, result);
    }

}
