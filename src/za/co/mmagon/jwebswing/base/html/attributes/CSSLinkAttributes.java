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
 * Attributes valid for the header link tag
 *
 * @since 2013/11/13
 * @version 1.0
 * @author MMagon
 *
 *
 */
public enum CSSLinkAttributes implements AttributeDefinitions
{
    /**
     * THe charset for the link
     */
    Charset,
    /**
     * The link
     */
    HRef,
    /**
     * The language of the link
     */
    HRefLang,
    /**
     * The relationship to the document
     */
    Rel,
    /**
     * The media type
     */
    Media,
    /**
     * The link is reversed
     */
    Rev,
    /**
     * Specifies that the target resource should be cached
     */
    PreFetch,
    /**
     * The target frame
     */
    Target,
    /**
     * The type
     */
    Type;

    /**
     * Returns the lower case variant of the name;
     *
     * @return
     */
    @Override
    public String toString()
    {
        return name().toLowerCase();
    }

    @Override
    public boolean isKeyword()
    {
        return false;
    }
}
