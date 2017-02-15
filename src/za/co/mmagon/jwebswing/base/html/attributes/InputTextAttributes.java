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
 * The attribute enumeration for the input text type
 * <p>
 * @author GedMarc
 */
public enum InputTextAttributes implements AttributeDefinitions
{

    /**
     * Sets or returns the value of the autocomplete attribute of a text field
     */
    AutoComplete,
    /**
     * Sets or returns whether a text field should automatically get focus when the page loads
     */
    AutoFocus,
    /**
     * Sets or returns the default value of a text field
     */
    DefaultValue,
    /**
     * Sets or returns whether the text field is disabled, or not
     */
    Disabled,
    /**
     * Returns a reference to the form that contains the text field
     */
    Form,
    /**
     * Returns a reference to the datalist that contains the text field
     */
    List,
    /**
     * Sets or returns the value of the maxlength attribute of a text field
     */
    MaxLength,
    /**
     * Sets or returns the value of the name attribute of a text field
     */
    Name,
    /**
     * Sets or returns the value of the pattern attribute of a text field
     */
    Pattern,
    /**
     * Sets or returns the value of the placeholder attribute of a text field
     */
    PlaceHolder,
    /**
     * Sets or returns whether a text field is read-only, or not
     */
    ReadOnly,
    /**
     * Sets or returns whether the text field must be filled out before submitting a form
     */
    Required,
    /**
     * Sets or returns the value of the size attribute of a text field
     */
    Size,
    /**
     * Returns which type of form element a text field is
     */
    Type,
    /**
     * Sets or returns the value of the value attribute of the text field
     */
    Value;

    @Override
    public boolean isKeyword()
    {
        return false;
    }

}
