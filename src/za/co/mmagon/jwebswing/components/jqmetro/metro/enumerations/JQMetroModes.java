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
package za.co.mmagon.jwebswing.components.jqmetro.metro.enumerations;

/**
 * This Class
 *
 * @author GedMarc
 * @since 28 Dec 2015
 */
public enum JQMetroModes
{
    /**
     * slide any number of tile faces infinitely or slide to a specific tile face
     */
    carousel,
    /**
     * fade the front face in and out
     */
    fade,
    /**
     * slide two tile faces at an arbitrary number of stopping points
     */
    slide,
    /**
     * flip two tile faces in a vertical or horizontal direction
     */
    flip,
    /**
     * trigger a list of tiles to flip between tile faces with custom delays
     */
    flip_list,
    /**
     * no animations are performed. This is useful if you just want to bind a bounce, click or link to the tile.
     */
    none;

    @Override
    public String toString()
    {
        return super.toString().replace('_', '-');
    }

}
