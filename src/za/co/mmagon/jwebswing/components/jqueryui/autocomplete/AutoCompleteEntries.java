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
package za.co.mmagon.jwebswing.components.jqueryui.autocomplete;

import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * Specifies a single entry for a JQUI Auto Complete
 * Moved from inner class to object
 *
 * @author GedMarc
 * @since 22 Feb 2016
 */
public class AutoCompleteEntries extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;

    private String label;
    private String value;
    private String category;

    /**
     * Creates a label only auto complete entry
     *
     * @param label
     */
    public AutoCompleteEntries(String label)
    {
        this.label = label;
    }

    /**
     * Creates a label only with custom value auto complete entry
     *
     * @param label
     */
    public AutoCompleteEntries(String label, String value)
    {
        this.label = label;
        this.value = value;
    }

    /**
     * Creates an auto complete entry that has categories
     *
     * @param label
     * @param category
     */
    public AutoCompleteEntries(String label, String value, String category)
    {
        this.label = label;
        this.value = value;
        this.category = category;
    }

    /**
     * Returns the label
     *
     * @return
     */
    public String getLabel()
    {
        return label;
    }

    /**
     * Sets the label
     *
     * @param label
     */
    public void setLabel(String label)
    {
        this.label = label;
    }

    /**
     * Gets the category
     *
     * @return
     */
    public String getCategory()
    {
        return category;
    }

    /**
     * Sets the category
     *
     * @param category
     */
    public void setCategory(String category)
    {
        this.category = category;
    }

    /**
     * Gets the value for this object
     *
     * @return
     */
    public String getValue()
    {
        return value;
    }

    /**
     * Sets the value for this object
     *
     * @param value
     */
    public void setValue(String value)
    {
        this.value = value;
    }

}
