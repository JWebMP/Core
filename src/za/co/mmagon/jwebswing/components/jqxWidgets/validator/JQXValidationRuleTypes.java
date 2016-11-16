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
package za.co.mmagon.jwebswing.components.jqxWidgets.validator;

/**
 * This Class
 *
 * @author GedMarc
 * @since 25 Dec 2015
 */
public enum JQXValidationRuleTypes
{
    /**
     * - Social Security Number Requires input like: ___-__-____
     */
    ssn,
    /**
     * requires valid e-mail address.
     */
    email,
    /**
     * requires a CheckBox or Radio Button to be checked or any value to be entered in an Input.
     */
    required,
    /**
     * requires input like: (___)___-____
     */
    phone,
    /**
     * - requires a valid zip code like: ___-__-____
     */
    zipCode,
    /**
     * - restricts the maximum input characters to len.
     */
    maxLength,
    /**
     * restricts the minimum input characters to len
     */
    minLength,
    /**
     * - restricts the input length to a specific range.
     */
    length;

    @Override
    public String toString()
    {
        return super.toString();
    }

}
