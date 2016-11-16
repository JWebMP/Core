/*
 * Copyright (C) 2016 ged_m
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
package za.co.mmagon.jwebswing.components.fontawesome;

/**
 *
 * @author ged_m
 * @since 21 May 2016
 */
public enum FontAwesomeProperties implements IFontAwesomeProperty
{
    /**
     * 1em
     */
    $1x,
    /**
     * 2em
     */
    $2x,
    /** 
     * 3em
     */
    $3x,
    /**
     * 4em
     */
    $4x,
    /**
     * 5em
     */
    $5x, 
    /**
     * center
     */
    fw;

    private FontAwesomeProperties()
    {
    }

    /**
     * Returns the font awesome class string
     *
     * @return
     */
    @Override
    public String toString()
    {
        return "fa-" + name().replaceAll("\\$", "").replaceAll("_", "-");
    }
}
