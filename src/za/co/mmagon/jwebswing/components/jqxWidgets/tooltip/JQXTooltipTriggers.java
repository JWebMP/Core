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
package za.co.mmagon.jwebswing.components.jqxWidgets.tooltip;

/**
 * This Class
 *
 * @author GedMarc
 * @since 24 Dec 2015
 */
public enum JQXTooltipTriggers
{
    /**
     * - the tooltip shows after a short period of time at the position of the mouse cursor
     */
    Mouse,
    /**
     * - the tooltip shows where the mouse cursor has entered the host element
     */
    MouseEnter,
    /**
     * *
     * the tooltip shows at the bottom-right side of the host element but does not make use of the left and top properties
     */
    Default;

    @Override
    public String toString()
    {
        return super.toString().toLowerCase();
    }

}
