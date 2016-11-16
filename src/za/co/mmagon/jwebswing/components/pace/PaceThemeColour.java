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
package za.co.mmagon.jwebswing.components.pace;

/**
 * All custom colours supported by the CDN
 *
 * @author GedMarc
 * @since 20 Apr 2016
 */
public enum PaceThemeColour
{
    Black,
    Red,
    Blue,
    Green,
    Orange,
    Pink,
    Purple,
    Silver,
    White,
    Yellow;

    @Override
    public String toString()
    {
        return name().toLowerCase();
    }

}
