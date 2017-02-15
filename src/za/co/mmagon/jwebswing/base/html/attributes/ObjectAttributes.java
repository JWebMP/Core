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
 * @since Feb 9, 2015
 * @version 1.0
 */
public enum ObjectAttributes implements AttributeDefinitions
{

    /**
     * Specifies the URL of the resource to be used by the object
     */
    Data,
    /**
     * Specifies one or more forms the object belongs to
     */
    Form,
    /**
     * Specifies the height of the object
     */
    Height,
    /**
     * Specifies a name for the object
     */
    Name,
    /**
     * Specifies the media type of data specified in the data attribute
     */
    Type,
    /**
     * Specifies the name of a client-side image map to be used with the object
     */
    UseMap,
    /**
     * Specifies the width in pixels
     */
    Width;

    @Override
    public boolean isKeyword()
    {
        return false;
    }
}
