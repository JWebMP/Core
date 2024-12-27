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

import com.jwebmp.core.base.html.SmallText;
import org.junit.jupiter.api.Test;

/**
 * @author GedMarc
 */
public class SmallTextTest
{

    public SmallTextTest()
    {
    }

    @Test
    public void testSomeMethod()
    {
        SmallText st = new SmallText("Small Text");
        System.out.println(st.toString(true));
    }

}
