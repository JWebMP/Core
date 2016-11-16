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
package za.co.mmagon.jwebswing.components.jqxWidgets.layout;

import org.junit.Test;

/**
 *
 * @author GedMarc
 */
public class JQXLayoutTest
{

    public JQXLayoutTest()
    {
    }

    /**
     * Test of getFeature method, of class JQXLayout.
     */
    @Test
    public void testOptions()
    {

        JQXLayout layout = new JQXLayout();
        layout.getOptions().setContextMenu(true);

        JQXLayoutArray arr = new JQXLayoutArray();
        arr.setAllowPin(true);

        layout.getOptions().getLayout().add(arr);

        JQXLayoutArray arr2 = new JQXLayoutArray();
        arr2.setTitle("title");
        arr2.setInitContent("init content");
        layout.getOptions().getLayout().add(arr2);

        System.out.println(layout.renderJavascript());
    }

}
