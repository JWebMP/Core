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
package com.jwebmp.test.core.base.html;

import com.jwebmp.core.Page;
import com.jwebmp.core.base.html.Body;
import com.jwebmp.core.base.html.HeaderText;
import com.jwebmp.core.base.html.attributes.HeaderTypes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author MMagon
 */
public class HeaderTest
{

    public HeaderTest()
    {
    }

    /**
     * Test of equals method, of class HeaderText.
     */
    @Test
    public void testEquals()
    {
        Body b = new Body(new Page());
        b.add(new HeaderText(HeaderTypes.H3, "Text goes here"));
        b.add(new HeaderText(HeaderTypes.H6, "456"));

        System.out.println(b.toString(true));

        System.out.println("equals");
        Object obj = null;
        HeaderText instance = new HeaderText();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

}
