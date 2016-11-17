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
package za.co.mmagon.jwebswing.components.jqplot.graphs.display;

import za.co.mmagon.jwebswing.generics.XYObject;

/**
 * A slice of a JQ Plot Pie
 *
 * @author GedMarc
 * @since 01 Mar 2016
 */
public class JQPlotPieSlice extends XYObject<String, Double>
{

    /**
     * A slice of the pie
     *
     * @param name
     * @param value
     */
    public JQPlotPieSlice(String name, double value)
    {
        super(name, value);

    }

    /**
     * Return the name of the slice (or X)
     *
     * @return
     */
    public String getName()
    {
        return getX();
    }

    /**
     * Sets the name of the slice (or X)
     *
     * @param name
     */
    public void setName(String name)
    {
        setX(name);
    }

    /**
     * Gets the value of the slice
     *
     * @return
     */
    public Double getValue()
    {
        return getY();
    }

    /**
     * Sets the value of the slice
     *
     * @param value
     */
    public void setValue(double value)
    {
        setY(value);
    }

}
