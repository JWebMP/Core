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
 * Borders
 * <p>
 * Use border utilities to quickly style the border and border-radius of an element. Great for images, buttons, or any other element.
 *
 * @author GedMarc
 * @since 31 Dec 2016
 * @version 1.0
 *
 */
public enum BSComponentBorderOptions implements IBSComponentOptions
{
    /**
     * makes all 4 corners rounded
     */
    Rounded,
    /**
     * Only round the top
     */
    Rounded_Top,
    /**
     * Only rounds the bottom
     */
    Rounded_Bottom,
    /**
     * Rounds the left
     */
    Rounded_Left,
    /**
     * Rounds the right
     */
    Rounded_Right,
    /**
     * Makes the display in circular format
     */
    Rounded_Circle;

    @Override
    public String toString()
    {
        return name().toLowerCase().replace('_', '-');
    }
}
