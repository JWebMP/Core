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
public class TextAreaTest
{

    public TextAreaTest()
    {
    }

    @Test
    public void testSomeMethod()
    {
        TextArea ta = new TextArea("default text");
        ta.setID("id");
        System.out.println(ta.toString(true));
        assertEquals(""
                + "<textarea id=\"id\">default text</textarea>", ta.toString(true).toString());
    }

}
