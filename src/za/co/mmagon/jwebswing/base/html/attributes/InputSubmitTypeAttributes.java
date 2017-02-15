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
 * The attribute enumeration for the input submit type
 * <p>
 * @author GedMarc
 */
public enum InputSubmitTypeAttributes implements AttributeDefinitions
{

    /**
     * Sets or returns whether a submit button should automatically get focus when the page loads
     */
    AutoFocus,
    /**
     * Sets or returns the default value of a submit button
     */
    DefaultValue,
    /**
     * Sets or returns whether the submit button is disabled, or not
     */
    Ddisabled,
    /**
     * Returns a reference to the form that contains the submit button
     */
    Form,
    /**
     * Sets or returns the value of the formaction attribute of a submit button
     */
    FormAction,
    /**
     * Sets or returns the value of the formenctype attribute of a submit button
     */
    FormEnctype,
    /**
     * Sets or returns the value of the formmethod attribute of a submit button
     */
    FormMethod,
    /**
     * Sets or returns whether the form-data should be validated or not, on submission
     */
    FormNoValidate,
    /**
     * Sets or returns the value of the formtarget attribute of a submit button
     */
    FormTarget,
    /**
     * Sets or returns the value of the name attribute of a submit button
     */
    Name,
    /**
     * Returns which type of form element the submit button is
     */
    Type,
    /**
     * Sets or returns the value of the value attribute of the submit button
     */
    Value,;

    @Override
    public boolean isKeyword()
    {
        return false;
    }
}
