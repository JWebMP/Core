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
package za.co.mmagon.jwebswing.components.jqxWidgets.docking;

/**
 * This Class lists all the available docking modes
 *
 * @author GedMarc
 * @since 14 Dec 2015
 */
public enum JQXDockingModes
{
    /**
     * -the user can drop every window inside any docking panel or outside the docking panels
     */
    Default,
    /**
     * -the user can drop every window just into the docking panels
     */
    Docked,
    /**
     * -the user can drop any window just outside of the docking panels.
     */
    Floating;

    @Override
    public String toString()
    {
        return name().toLowerCase();
    }

}
