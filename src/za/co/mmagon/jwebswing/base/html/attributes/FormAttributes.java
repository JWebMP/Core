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
 * A list of attributes valid for the form tag
 * <p>
 * @author GedMarc
 */
public enum FormAttributes implements AttributeDefinitions
{

    /**
     * Not supported in HTML5. Specifies a comma-separated list of file types that the server accepts (that can be submitted through the file upload)
     * <p>
     * @deprecated
     */
    Accept,
    /**
     * Specifies the character encodings that are to be used for the form submission
     */
    Accept_CharSet,
    /**
     * Specifies where to send the form-data when a form is submitted. URL
     */
    Action,
    /**
     * Specifies whether a form should have autocomplete on or off. Used with Data List
     */
    AutoComplete,
    /**
     * Specifies how the form-data should be encoded when submitting it to the server (only for method="post") application/x-www-form-url
     * <p>
     * encoded
     * <p>
     * multipart/form-data
     * <p>
     * text/plain
     */
    EncType,
    /**
     * Get/Post
     */
    Method,
    /**
     * In XHTML, the name attribute is deprecated. Use the global id attribute instead.
     * Specifies the name of a form
     *
     * @deprecated
     */
    Name,
    /**
     * Specifies that the form should not be validated when submitted
     */
    NoValidate,
    /**
     * Specifies where to display the response that is received after submitting the form
     */
    Target;

    @Override
    public boolean isKeyword()
    {
        return false;
    }
}
