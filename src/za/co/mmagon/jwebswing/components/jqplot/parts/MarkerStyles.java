/*
 * Copyright (C) 2015 Marc Magon
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
package za.co.mmagon.jwebswing.components.jqplot.parts;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The available default marker styles in jqPlot
 * <p>
 * @author Marc Magon
 * @since 07 Aug 2015
 * @version 1.0
 */
public enum MarkerStyles
{

    /**
     * An Empty Circle
     */
    Circle,
    /**
     * An Empty Diamond
     */
    Diamond,
    /**
     * An Empty Square
     */
    Square,
    /**
     * A Filled Circle
     */
    FilledCircle,
    /**
     * A Filled Diamond
     */
    FilledDiamond,
    /**
     * A Filled Square
     */
    FilledSquare,
    /**
     * Draw an X
     */
    X,
    /**
     * Draw a Plus Sign
     */
    Plus,
    /**
     * Draw a Dash
     */
    Dash;

    /**
     * Returns the name in lower case
     * <p>
     * @return
     */
    @Override
    @JsonValue
    public String toString()
    {
        return name().toLowerCase();
    }

}
