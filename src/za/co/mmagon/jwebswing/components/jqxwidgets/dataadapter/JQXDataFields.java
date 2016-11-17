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
 * This Class has all the necessary items for a JQX column
 *
 * @author GedMarc
 * @since 29 Dec 2015
 */
public class JQXDataFields extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;

    /**
     * A string containing the data fields name.
     */
    private String name;
    /*
     * - A string containing the data fields type. Possible values: string, date, number, int, float, bool.
     */
    private JQXDataFieldTypes type;
    /**
     * (optional) - A mapping to the data field.
     */
    private String map;
    /**
     * (optional) - Sets the data formatting. By setting the format, the jqxDataAdapter plug-in will try to format the data before loading it.
     * Example: { name: SubmitDate, type: date, format: "yyyy-MM-ddTHH:mm:ss-HH:mm" }
     */
    private JQXDataTypeFormats format;//
    /**
     * (optional) - determines a foreign collection of values for a datafield.
     */
    private String values;

    /**
     * Constructs a new JQX Data Field
     */
    public JQXDataFields()
    {
    }

    /**
     * Constructs a new field with the given name
     * @param name 
     */
    public JQXDataFields(String name)
    {
        this.name = name;
    }

    /**
     * Constructs a new field with the given name and type
     * @param name The name of the field
     * @param type The type of the field
     */
    public JQXDataFields(String name, JQXDataFieldTypes type)
    {
        this.name = name;
        this.type = type;
    }

    /**
     * Constructs a new field with the given name type and format
     * @param name
     * @param type
     * @param format 
     */
    public JQXDataFields(String name, JQXDataFieldTypes type, JQXDataTypeFormats format)
    {
        this.name = name;
        this.type = type;
        this.format = format;
    }

    /**
     * Constructs a new field with the given name type and format for the value
     * @param name
     * @param type
     * @param format
     * @param values 
     */
    public JQXDataFields(String name, JQXDataFieldTypes type, JQXDataTypeFormats format, String values)
    {
        this.name = name;
        this.type = type;
        this.format = format;
        this.values = values;
    }

    /**
     * Returns the name of the field
     * @return 
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the field
     * @param name 
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Returns the specified type
     * @return 
     */
    public JQXDataFieldTypes getType()
    {
        return type;
    }

    /**
     * Sets the specified type
     * @param type 
     */
    public void setType(JQXDataFieldTypes type)
    {
        this.type = type;
    }

    /**
     * Returns the map
     * @return 
     */
    public String getMap()
    {
        return map;
    }

    /**
     * Sets the map
     * @param map 
     */
    public void setMap(String map)
    {
        this.map = map;
    }

    /**
     * Returns the data type message formats
     * @return 
     */
    public JQXDataTypeFormats getFormat()
    {
        return format;
    }

    /**
     * Sets the data type message format
     * @param format 
     */
    public void setFormat(JQXDataTypeFormats format)
    {
        this.format = format;
    }

    /**
     * Returns the given format
     * @return 
     */
    public String getValues()
    {
        return values;
    }

    /**
     * Sets the given value
     * @param values 
     */
    public void setValues(String values)
    {
        this.values = values;
    }

    /**
     * The specified data field type
     */
    public static enum JQXDataFieldTypes
    {
        /**
         * A string field
         */
        String,
        /**
         * A date field
         */
        Date,
        /**
         * A number field
         */
        Number,
        /**
         * An integer field
         */
        Int,
        /**
         * A long field
         */
        Float,
        /**
         * A boolean
         */
        Bool;

        @Override
        public String toString()
        {
            return super.toString().toLowerCase();
        }

    }
}
