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

import com.jwebmp.core.base.html.Body;
import com.jwebmp.core.base.html.Comment;
import com.jwebmp.test.BaseTestClass;
import com.jwebmp.core.Page;
import com.jwebmp.core.generics.WebReference;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author MMagon
 */
public class BodyTest
        extends BaseTestClass
{

    private Page<?> p;
    private Body b;

    public BodyTest()
    {
        resetBody();
    }

    private void resetBody()
    {
        p = new Page();
        b = p.getBody();
    }

    @Test
    public void testBody()
    {
        resetBody();
        System.out.println(b.toString(true));
        assertEquals("<body id=\"body\"></body>", b.toString(true));
    }

}
