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

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author GedMarc
 */
public class SelectTest
{

    public SelectTest()
    {
    }

    @Test
    public void testOptionGroups()
    {
        Select s = new Select();
        Option o = new Option("Option");
        OptionGroup op = new OptionGroup("Option Group");
        s.setID("id");
        o.setID("id");
        op.setID("id");
        s.add(op);
        op.add(o);

        System.out.println(s.toString(true));

        assertEquals("<select id=\"id\">\n"
                + "	<optgroup label=\"Option Group\">\n"
                + "		<option label=\"Option\" value=\"Option\" id=\"id\">Option</option>\n"
                + "	</optgroup>\n"
                + "</select>", s.toString(true).toString());
    }
}
