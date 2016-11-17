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
package za.co.mmagon.jwebswing.components.jqxwidgets.tooltip;

/**
 * This Class
 *
 * @author GedMarc
 * @since 24 Dec 2015
 */
public enum JQXTooltipPositions
{
    /**
     * - the tooltip shows above the host element
     */
    top,
    /**
     * - the tooltip shows below the host element
     */
    bottom,
    /**
     * - the tooltip shows at the left of the host element
     */
    left,
    /**
     * - the tooltip shows at the right of the host element
     */
    right,
    /**
     * - the tooltip shows at the top-left side of the host element
     */
    top_left,
    /**
     * - the tooltip shows at the bottom-left side of the host element
     */
    bottom_left,
    /**
     * - the tooltip shows at the top-right side of the host element
     */
    top_right,
    /**
     * - the tooltip shows at the bottom-right side of the host element
     */
    bottom_right,
    /**
     * the tooltip shows at an absolute position on screen, defined by the coordinate properties absolutePositionX and absolutePositionY
     */
    absolute,;

    @Override
    public String toString()
    {
        return name().replace('_', '-');
    }
}
