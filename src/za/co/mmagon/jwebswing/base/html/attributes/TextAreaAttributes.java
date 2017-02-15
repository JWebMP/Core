/* 
 * Copyright (C) 2017 Marc Magon
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
package za.co.mmagon.jwebswing.base.html.attributes;

import za.co.mmagon.jwebswing.base.html.interfaces.AttributeDefinitions;

/**
 *
 * @author GedMarc
 * @since Mar 1, 2015
 * @version 1.0
 */
public enum TextAreaAttributes implements AttributeDefinitions
{

    /**
     * Sets or returns whether a text area should automatically get focus when the page loads
     */
    AutoFocus,
    /**
     * Sets or returns the value of the cols attribute of a text area
     */
    Cols,
    /**
     * Sets or returns the default value of a text area
     */
    DefaultValue,
    /**
     * Sets or returns whether the text area is disabled, or not
     */
    Disabled,
    /**
     * Returns a reference to the form that contains the text area
     */
    Form,
    /**
     * Sets or returns the value of the maxlength attribute of a text area
     */
    MaxLength,
    /**
     * Sets or returns the value of the name attribute of a text area
     */
    Name,
    /**
     * Sets or returns the value of the placeholder attribute of a text area
     */
    PlaceHolder,
    /**
     * Sets or returns whether the contents of a text area is read-only
     */
    ReadOnly,
    /**
     * Sets or returns whether the text area must be filled out before submitting a form
     */
    Required,
    /**
     * Sets or returns the value of the rows attribute of a text area
     */
    Rows,
    /**
     * Returns the type of the form element the text area is
     */
    Type,
    /**
     * Sets or returns the contents of a text area
     */
    Value,
    /**
     * sets or returns the value of the wrap attribute of a text area
     */
    Wrap;

    @Override
    public boolean isKeyword()
    {
        return false;
    }
}
