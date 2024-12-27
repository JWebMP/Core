/*
 * Copyright (C) 2017 GedMarc
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
package com.jwebmp.test.core.base.html;

import com.jwebmp.core.base.html.DataList;
import com.jwebmp.core.base.html.Option;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author GedMarc
 */
public class DataListTest
{

    public DataListTest()
    {
    }

    @Test
    public void testdatalist()
    {
        DataList dl = new DataList("browsers");
        Option o = new Option("option 1");
        dl.add(o);
        o.setID("id");
        System.out.println(dl.toString(true));
        Assertions.assertEquals("<datalist id=\"browsers\">\n" + "	<option label=\"option 1\" value=\"option 1\" id=\"id\">option 1</option>\n" + "</datalist>",
                dl.toString(true));
    }

}
