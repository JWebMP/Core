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
package za.co.mmagon.jwebswing.components.jqxWidgets.dataadapter;

import za.co.mmagon.jwebswing.components.jqxwidgets.dataadapter.JQXDataAdapter;
import org.junit.Before;
import org.junit.Test;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.components.jqxwidgets.dropdownlist.JQXDropDownListNameValuePair;
import za.co.mmagon.jwebswing.components.jqxwidgets.tree.JQXTreeItem;

/**
 *
 * @author GedMarc
 */
public class JQXDataAdapterTest
{
    
    public JQXDataAdapterTest()
    {
    }
    
    @Before
    public void setUp()
    {
    }

    @Test
    public void testSomeMethod()
    {
        Div d= new Div();
        JQXDataAdapter dataAdapter = new JQXDataAdapter<>(d);
        d.add(dataAdapter);
        dataAdapter.asMe().getOptions().setData(new JQXTreeItem());
        System.out.println(d.toString(true));
        System.out.println(d.renderJavascriptAll());
        
        dataAdapter.getOptions().setLocaldata(new JQXDropDownListNameValuePair(), dataAdapter);
    }
    
}
