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
package za.co.mmagon.jwebswing.components.jqxWidgets.dropdownlist;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.components.jqxWidgets.dataadapter.JQXDataAdapter;
import za.co.mmagon.jwebswing.components.jqxWidgets.dataadapter.JQXDataFields;

/**
 * This Class
 *
 * @author GedMarc
 * @since 31 Dec 2015
 */
public class DataAdapterNameValuePair extends JQXDataAdapter<JQXDropDownListNameValuePair>
{

    private JQXDropDownList list;

    public DataAdapterNameValuePair(Component component)
    {
        super(component);
        getOptions().getDatafields().add(new JQXDataFields("name", JQXDataFields.JQXDataFieldTypes.String));
        getOptions().getDatafields().add(new JQXDataFields("value", JQXDataFields.JQXDataFieldTypes.String));
    }

    public void updateDropDownList(JQXDropDownList list)
    {
        list.getOptions().setSource(this);
        list.getOptions().setDisplayMember("name");
        list.getOptions().setValueMember("value");
    }

    public void updateDropDownListSelectMenu(JQXDropDownListSelectMenu list)
    {
        list.getOptions().setSource(this);
        list.getOptions().setDisplayMember("name");
        list.getOptions().setValueMember("value");
    }

    /**
     * Assigns the name and value pair to the list for display
     *
     * @param list
     */
    public DataAdapterNameValuePair(JQXDropDownList list)
    {
        super(list);
        this.list = list;
    }

    public static void main(String[] args)
    {
        // DataAdapterNameValuePair j = new DataAdapterNameValuePair();
        // System.out.println(j.renderJavascripts(0));
    }

}
