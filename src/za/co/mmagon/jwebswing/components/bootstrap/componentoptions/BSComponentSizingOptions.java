/*
 * Copyright (C) 2016 GedMarc
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
package za.co.mmagon.jwebswing.components.bootstrap.componentoptions;

/**
 * Width and height
 * <p>
 * Easily make an element as wide or as tall as its parent using the .w-100 and .h-100 utility classes.
 *
 * @author GedMarc
 * @since 31 Dec 2016
 * @version 1.0
 *
 */
public enum BSComponentSizingOptions implements IBSComponentOptions
{
    /**
     * Sets the width to 100%
     */
    w_100,
    /**
     * Sets the height to 100%
     */
    h_100;

    @Override
    public String toString()
    {
        return name().toLowerCase().replace('_', '-');
    }
}
