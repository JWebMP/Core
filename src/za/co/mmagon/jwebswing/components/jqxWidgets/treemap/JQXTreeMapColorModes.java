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
package za.co.mmagon.jwebswing.components.jqxWidgets.treemap;

/**
 * This Class
 *
 * @author GedMarc
 * @since 25 Dec 2015
 */
public enum JQXTreeMapColorModes
{
    /**
     * - a child sector inherits the color from its parent sector. Depending on the child value and the colorRange property the color varies.
     */
    parent,
    /**
     * - automatic color generation based on the baseColor/colorRange and the value.
     */
    autoColors,
    /**
     * - the user can sets array of color ranges. Each color range has the properties min, max and color.
     */
    rangeColors,;

    @Override
    public String toString()
    {
        return super.toString();
    }

}
