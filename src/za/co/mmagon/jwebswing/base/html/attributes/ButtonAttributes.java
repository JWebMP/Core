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
 * Defines The Attributes that are valid for Buttons
 * <p>
 * @author GedMarc
 * @since 2014/12/20
 */
public enum ButtonAttributes implements AttributeDefinitions
{

    /**
     * Specifies that a button should automatically get focus when the page loads
     */
    AutoFocus,
    /**
     * Specifies one or more forms the button belongs to
     */
    Form,
    /**
     * Specifies where to send the form-data when a form is submitted. Only for type="submit"
     */
    FormAction,
    /**
     * Specifies how form-data should be encoded before sending it to a server. Only for type="submit".
     * <p>
     * application/ x-www-form-urlencoded multipart/ form-data text/ plain
     */
    FormEncType,
    /**
     * Specifies how to send the form-data (which HTTP method to use). Only for type="submit". Get or Post
     */
    FormMethod,
    /**
     * Specifies that the form-data should not be validated on submission. Only for type="submit"
     */
    FormNoValidate,
    /**
     * Specifies where to display the response after submitting the form. Only for type="submit"
     */
    FormTarget,
    /**
     * Specifies a name for the button
     */
    Name,
    /**
     * Specifies the type of button
     * <p>
     * button reset submit
     */
    Type,
    /**
     * Specifies an initial value for the button
     */
    Value,
    /**
     * Sets the toggle
     */
    Data_Toggle,
    /**
     * Sets the target
     */
    Data_Target,
    /**
     * What to dismiss
     */
    Data_Dismiss;

    @Override
    public boolean isKeyword()
    {
        return false;
    }

    @Override
    public String toString()
    {
        return name().toLowerCase().replace('_', '-');
    }
    
    

}
