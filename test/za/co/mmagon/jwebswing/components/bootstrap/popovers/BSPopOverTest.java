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
package za.co.mmagon.jwebswing.components.bootstrap.popovers;

import org.junit.Test;
import za.co.mmagon.BaseTestClass;
import za.co.mmagon.jwebswing.Page;

/**
 *
 * @author GedMarc
 */
public class BSPopOverTest extends BaseTestClass
{

    public BSPopOverTest()
    {
    }

    @Test
    public void testSomeMethod()
    {
        BSPopOver popOver = new BSPopOver(null);

        System.out.println(popOver.toString(true));
        System.out.println(popOver.renderJavascript());

        Page p = getInstance();
        p.getBody().add(popOver);

        System.out.println(p.toString(true));
    }

}
