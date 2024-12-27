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

import com.jwebmp.core.base.html.Paragraph;
import com.jwebmp.core.base.html.SampleCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author GedMarc
 */
public class SampleCodeTest
{

    public SampleCodeTest()
    {
    }

    @Test
    public void testSomeMethod()
    {
        Paragraph p = new Paragraph("p");
        SampleCode sc = new SampleCode("sample code");
        p.setID("id");
        sc.setID("sc");
        p.add(sc);
        System.out.println(p.toString(true));
        Assertions.assertEquals("<p id=\"id\">p\n" + "	<samp id=\"sc\"></samp>\n" + "</p>", p.toString(true));
    }

}
