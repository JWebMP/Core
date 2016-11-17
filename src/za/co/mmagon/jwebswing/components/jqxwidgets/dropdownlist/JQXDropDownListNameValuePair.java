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
package za.co.mmagon.jwebswing.components.jqxwidgets.dropdownlist;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import za.co.mmagon.jwebswing.components.jqxwidgets.dataadapter.options.JQXDataAdapterSourceData;

/**
 * This Class
 *
 * @author GedMarc
 * @since 31 Dec 2015
 */
public class JQXDropDownListNameValuePair extends JQXDataAdapterSourceData
{

    private ArrayList<JQXDropDownListData> values;

    public JQXDropDownListNameValuePair()
    {
    }

    @Override
    public String toString()
    {
        return super.toString();
    }

    @JsonValue
    public ArrayList<JQXDropDownListData> getValues()
    {
        if (values == null)
        {
            values = new ArrayList<>();
        }
        return values;
    }

    public void setValues(ArrayList<JQXDropDownListData> values)
    {
        this.values = values;
    }

    public static class JQXDropDownListData
    {

        private String name;
        private String value;

        public JQXDropDownListData()
        {
        }

        public JQXDropDownListData(String name, String value)
        {
            this.name = name;
            this.value = value;
        }

        public JQXDropDownListData(String name)
        {
            this.name = name;
        }

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        public String getValue()
        {
            return value;
        }

        public void setValue(String value)
        {
            this.value = value;
        }

    }
}
