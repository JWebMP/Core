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
package za.co.mmagon.jwebswing.components.jqxWidgets.buttons;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author GedMarc
 */
public class JQXButtonTest
{
    
    public JQXButtonTest()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @Test 
    public void testHtml()
    {
        JQXButton button = new JQXButton();
        button.setID("id");
        button.getOptions().setDisabled(true);
        System.out.println(button.toString(true));
    }

    @Test
    public void testSomeMethod()
    {
        JQXButton button = new JQXButton();
        button.setID("id");
        button.getOptions().setDisabled(true);
        System.out.println(button.renderJavascript());
    }
    
}
