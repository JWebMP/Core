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

import java.util.ArrayList;
import java.util.StringTokenizer;
import za.co.mmagon.jwebswing.generics.XYObject;

/**
 * Defines a JQPlot Line Series
 *
 * @author GedMarc
 * @since 29 Feb 2016
 */
public class JQPlotLine implements JQPlotSeriesItem
{

    private String name;
    private ArrayList<XYObject> values;

    /**
     * Constructs a new line
     * <p>
     */
    public JQPlotLine()
    {
    }

    /**
     * Constructs a new plot line from an ArrayList of Co-ordinates
     *
     * @param values
     */
    public JQPlotLine(ArrayList<XYObject> values)
    {
        this.values = values;
    }

    /**
     * *
     * Constructs a
     *
     * @param name
     */
    private JQPlotLine(String name)
    {
        this.name = name;
    }

    /**
     * Constructs a new plot line object with the given name and Y value
     *
     * @param x
     * @param y
     */
    public JQPlotLine(String x, double y)
    {
        getValues().add(new XYObject(x, y));
    }

    /**
     * Constructs a new line plot using the given value y value with an incremental x value
     *
     * @param y
     */
    public JQPlotLine(double y)
    {
        getValues().add(new XYObject(getValues().size(), y));
    }

    /**
     * Adds a point to this line
     *
     * @param x The X Position
     * @param y The Y Position
     * @return
     */
    public boolean addPoint(String x, double y)
    {
        getValues().add(new XYObject(x, y));
        return true;
    }

    /**
     * Adds an incremental Y point to the list
     *
     * @param y
     * @return
     */
    public boolean addPoint(double y)
    {
        getValues().add(new XYObject(getValues().size(), y));
        return true;
    }

    /**
     * Gets the name of this line
     *
     * @return
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of this line
     *
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets all the values for this line
     *
     * @return
     */
    public final ArrayList<XYObject> getValues()
    {
        if (values == null)
        {
            values = new ArrayList<>();
        }
        return values;
    }

    /**
     * Sets all the values for this line
     *
     * @param values
     */
    public void setValues(ArrayList<XYObject> values)
    {
        this.values = values;
    }

    /**
     * Returns the string representation of this line
     *
     * @return
     */
    @Override
    public String toString()
    {
        StringBuilder lineStringBuilder = new StringBuilder("[");
        ArrayList<XYObject> vals = getValues();

        for (XYObject value : vals)
        {
            String lineString = value.toString();
            lineStringBuilder.append(lineString);
        }
        lineStringBuilder.append("]");

        return getValues().toString();
    }

    /**
     * Builds an array list from an object array
     *
     * @param array
     * @return
     */
    public static ArrayList<XYObject> buildFromArray(Object... array)
    {
        ArrayList<XYObject> output = new ArrayList<>();
        for (int i = 0; i < array.length; i = i + 2)
        {
            Object object = array[i];
            Object object2 = array[i + 1];
            XYObject xy = new XYObject(object, object2);
            output.add(xy);
        }
        return output;
    }

    /**
     * Builds an array list from an object array
     *
     * @param array
     * @return
     */
    public static JQPlotLine buildLineFromArray(Object[] array)
    {

        ArrayList<XYObject> output = new ArrayList<>();
        for (int i = 0; i < array.length; i = i + 2)
        {
            Object object = array[i];
            Object object2 = array[i + 1];
            XYObject xy = new XYObject(object, object2);
            output.add(xy);
        }

        return new JQPlotLine(output);
    }

    /**
     * Builds an array list from an object array
     *
     * @param array
     * @param delimeter
     * @return
     */
    public static ArrayList<XYObject> buildFromDelimiteredSrting(String array, String delimeter)
    {
        ArrayList<XYObject> output = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(array, delimeter);
        while (st.hasMoreElements())
        {
            XYObject xy = new XYObject();
            xy.setX(st.nextToken());
            xy.setY(st.nextToken());
            output.add(xy);
        }
        return output;
    }

}
