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
 * Attributes valid for the Input Tag
 *
 * @since 2014/05/18
 * @version 1.0
 * @author MMagon
 *
 *
 */
public enum InputAttributes implements AttributeDefinitions
{
    /**
     * Specifies the types of files that the server accepts (only for type="file")
     */
    Accept,
    /**
     * Specifies an alternate text for images (only for type="image")
     */
    Alt,
    /**
     * Specifies that an input element should be pre-selected when the page loads (for type="checkbox" or type="radio")
     */
    Checked,
    /**
     * Specifies that an &gt;input&lt; element should be disabled
     */
    Disabled,
    /**
     * Specifies the maximum number of characters allowed in an &gt;input&lt; element
     */
    MaxLength,
    /**
     * Specifies the width, in characters, of an input element
     */
    Size,
    /**
     * Specifies the URL of the image to use as a submit button (only for type="image")
     */
    Src,
    /**
     * Specifies the type input element to display
     */
    Type,
    /**
     * Specifies the value of an input element
     */
    Value;

    @Override
    public boolean isKeyword()
    {
        return false;
    }

}
