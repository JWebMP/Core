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
package za.co.mmagon.jwebswing.components.jqxwidgets.dataadapter;

import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * The data type format options available
 *
 * @author GedMarc
 * @since 29 Dec 2015
 */
public class JQXDataTypeFormats extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;
    /**
     * The name of the datatype
     */
    private String name;
    /**
     * The type of the datatype
     */
    private String type;
    /**
     * The format of the data type
     */
    private String format;

    /**
     * The data type format options available
     */
    public JQXDataTypeFormats()
    {
    }

    @Override
    public String toString()
    {
        return super.toString();
    }

    /**
     * The name of the data type
     *
     * @return
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the data type
     *
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the type of the data type
     *
     * @return
     */
    public String getType()
    {
        return type;
    }

    /**
     * Sets the type of the data type
     *
     * @param type
     */
    public void setType(String type)
    {
        this.type = type;
    }

    /**
     * Returns the format for this data type
     *
     * @return
     */
    public String getFormat()
    {
        return format;
    }

    /**
     * Sets the format for this data type
     *
     * @param format
     */
    public void setFormat(String format)
    {
        this.format = format;
    }

}
