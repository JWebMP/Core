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
 * Supplies the available attributes for the style tag
 *
 * @author mmagon
 */
public enum StyleAttributes implements AttributeDefinitions
{
    /**
     * Specifies what media/device the media resource is optimized for
     */
    Media,
    /**
     * Specifies that the style only applies to this elements parent element and the
     * elements child elements
     */
    Scoped,
    /**
     * Specifies the MIME Type of the style sheet
     */
    Type;

    @Override
    public boolean isKeyword()
    {
        return false;
    }
}
