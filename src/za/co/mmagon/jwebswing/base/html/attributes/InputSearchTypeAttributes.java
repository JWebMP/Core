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
 * The attribute enumeration for the input button type
 * <p>
 * @author GedMarc
 */
public enum InputSearchTypeAttributes implements AttributeDefinitions
{

    AutoComplete, /**
     * Sets or returns the value of the autocomplete attribute of a search field
     */
    AutoCocus, /**
     * Sets or returns whether a search field should automatically get focus when the page loads
     */
    DefaultValue, /**
     * Sets or returns the default value of a search field
     */
    Disabled, /**
     * Sets or returns whether a search field is disabled, or not
     */
    Form, /**
     * Returns a reference to the form that contains the search field
     */
    List, /**
     * Returns a reference to the datalist that contains the search field
     */
    MaxLength, /**
     * Sets or returns the value of the maxlength attribute of a search field
     */
    Name, /**
     * Sets or returns the value of the name attribute of a search field
     */
    Pattern, /**
     * Sets or returns the value of the pattern attribute of a search field
     */
    PlaceHolder, /**
     * Sets or returns the value of the placeholder attribute of a search field
     */
    ReadOnly, /**
     * Sets or returns whether the search field is read-only, or not
     */
    Required, /**
     * Sets or returns whether the search field must be filled out before submitting a form
     */
    Size, /**
     * Sets or returns the value of the size attribute of the search field
     */
    Type, /**
     * Returns which type of form element the search field is
     */
    Value, /**
     * Sets or returns the value of the value attribute of a search field
     */
    ;

    @Override
    public boolean isKeyword()
    {
        return false;
    }

}
