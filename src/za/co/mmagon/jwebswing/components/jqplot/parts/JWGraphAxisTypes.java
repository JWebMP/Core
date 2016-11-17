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
 * A set of all the graph axis types supported by the jqPlot plugin.
 * Some graphs are obviously retricted to a few
 * <p>
 * @author Marc Magon
 * @since 08 Aug 2015
 * @version 1.0
 * @version 1.1 Update to include all 9 axis types with the change to the graph options rendering
 */
public enum JWGraphAxisTypes
{

    /**
     * The X Axis
     */
    xAxis,
    /**
     * The xAxis-2 Axis for Dual Graph Support
     */
    x2Axis,
    /**
     * The yAxis axis for a graph
     */
    yAxis,
    /**
     * The y2Axis axis for a dual graph
     */
    y2Axis,
    /**
     * The zAxis Axis for a 3 dimensional graph
     */
    zAxis,
    /**
     * The y2Axis axis for a dual graph
     */
    y3Axis,
    /**
     * The y2Axis axis for a dual graph
     */
    y4Axis,
    /**
     * The y2Axis axis for a dual graph
     */
    y5Axis,
    /**
     * The y2Axis axis for a dual graph
     */
    y6Axis,
    /**
     * The y2Axis axis for a dual graph
     */
    y7Axis,
    /**
     * The y2Axis axis for a dual graph
     */
    y8Axis,
    /**
     * The y2Axis axis for a dual graph
     */
    y9Axis;

    ;
    private JWGraphAxisTypes()
    {

    }

    /**
     * Returns the name of the enumeration in lower case
     * <p>
     * @return
     */
    @JsonValue
    @Override
    public String toString()
    {
        return name().toLowerCase();
    }
}
