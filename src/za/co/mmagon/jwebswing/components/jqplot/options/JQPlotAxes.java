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
package za.co.mmagon.jwebswing.components.jqplot.options;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import za.co.mmagon.jwebswing.components.jqplot.JQPlotGraph;
import za.co.mmagon.jwebswing.components.jqplot.options.axis.JQPlotAxisOptions;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * The settings for the axes available
 *
 * @author GedMarc
 * @since 28 Feb 2016
 */
public class JQPlotAxes extends JavaScriptPart
{

    @JsonIgnore
    private JQPlotGraph linkedGraph;

    @JsonProperty("xaxis")
    private JQPlotAxisOptions xAxis;
    @JsonProperty("x2axis")
    private JQPlotAxisOptions x2Axis;
    @JsonProperty("yaxis")
    private JQPlotAxisOptions yAxis;
    @JsonProperty("y2axis")
    private JQPlotAxisOptions y2Axis;
    @JsonProperty("y3axis")
    private JQPlotAxisOptions y3Axis;
    @JsonProperty("y4axis")
    private JQPlotAxisOptions y4Axis;
    @JsonProperty("y5axis")
    private JQPlotAxisOptions y5Axis;
    @JsonProperty("y6axis")
    private JQPlotAxisOptions y6Axis;
    @JsonProperty("y7axis")
    private JQPlotAxisOptions y7Axis;
    @JsonProperty("y8axis")
    private JQPlotAxisOptions y8Axis;
    @JsonProperty("y9axis")
    private JQPlotAxisOptions y9Axis;
    @JsonProperty("zaxis")
    private JQPlotAxisOptions zAxis;

    public JQPlotAxes(JQPlotGraph linkedGraph)
    {
        this.linkedGraph = linkedGraph;
    }

    /**
     * Gets the X Axis Options
     *
     * @return
     */
    public JQPlotAxisOptions getxAxis()
    {
        if (xAxis == null)
        {
            xAxis = new JQPlotAxisOptions(getLinkedGraph());
        }
        return xAxis;
    }

    /**
     * Sets the X Axis
     *
     * @param xAxis
     */
    public void setxAxis(JQPlotAxisOptions xAxis)
    {
        this.xAxis = xAxis;
    }

    /**
     * Gets the X 2 Axis
     *
     * @return
     */
    public JQPlotAxisOptions getX2Axis()
    {
        if (x2Axis == null)
        {
            x2Axis = new JQPlotAxisOptions(getLinkedGraph());
        }
        return x2Axis;
    }

    /**
     * Sets the X 2 Axis
     *
     * @param x2Axis
     */
    public void setX2Axis(JQPlotAxisOptions x2Axis)
    {
        this.x2Axis = x2Axis;
    }

    /**
     * Gets the Y Axis
     *
     * @return
     */
    public JQPlotAxisOptions getyAxis()
    {
        if (yAxis == null)
        {
            yAxis = new JQPlotAxisOptions(getLinkedGraph());
        }
        return yAxis;
    }

    /**
     * Sets the Y Axis
     *
     * @param yAxis
     */
    public void setyAxis(JQPlotAxisOptions yAxis)
    {
        this.yAxis = yAxis;
    }

    /**
     * Gets the Y 2 Axis
     *
     * @return
     */
    public JQPlotAxisOptions getY2Axis()
    {
        if (y2Axis == null)
        {
            y2Axis = new JQPlotAxisOptions(getLinkedGraph());
        }
        return y2Axis;
    }

    /**
     * Sets the Y 2Axis
     *
     * @param y2Axis
     */
    public void setY2Axis(JQPlotAxisOptions y2Axis)
    {
        this.y2Axis = y2Axis;
    }

    /**
     * Gets the Y 2 Axis
     *
     * @return
     */
    public JQPlotAxisOptions getY3Axis()
    {
        if (y3Axis == null)
        {
            y3Axis = new JQPlotAxisOptions(getLinkedGraph());
        }
        return y3Axis;
    }

    /**
     * Sets the Y 3 Axis
     *
     * @param y3Axis
     */
    public void setY3Axis(JQPlotAxisOptions y3Axis)
    {
        this.y3Axis = y3Axis;
    }

    /**
     * Gets the Y 2 Axis
     *
     * @return
     */
    public JQPlotAxisOptions getY4Axis()
    {
        if (y4Axis == null)
        {
            y4Axis = new JQPlotAxisOptions(getLinkedGraph());
        }
        return y4Axis;
    }

    /**
     * Sets the Y 3 Axis
     *
     * @param y4Axis
     */
    public void setY4Axis(JQPlotAxisOptions y4Axis)
    {
        this.y4Axis = y4Axis;
    }

    /**
     * Gets the Y 2 Axis
     *
     * @return
     */
    public JQPlotAxisOptions getY5Axis()
    {
        if (y5Axis == null)
        {
            y5Axis = new JQPlotAxisOptions(getLinkedGraph());
        }
        return y5Axis;
    }

    /**
     * Sets the Y 3 Axis
     *
     * @param y5Axis
     */
    public void setY5Axis(JQPlotAxisOptions y5Axis)
    {
        this.y5Axis = y5Axis;
    }

    /**
     * Gets the Y 2 Axis
     *
     * @return
     */
    public JQPlotAxisOptions getY6Axis()
    {
        if (y6Axis == null)
        {
            y6Axis = new JQPlotAxisOptions(getLinkedGraph());
        }
        return y6Axis;
    }

    /**
     * Sets the Y 3 Axis
     *
     * @param y6Axis
     */
    public void setY6Axis(JQPlotAxisOptions y6Axis)
    {
        this.y6Axis = y6Axis;
    }

    /**
     * Gets the Y 2 Axis
     *
     * @return
     */
    public JQPlotAxisOptions getY7Axis()
    {
        if (y7Axis == null)
        {
            y7Axis = new JQPlotAxisOptions(getLinkedGraph());
        }
        return y7Axis;
    }

    /**
     * Sets the Y 3 Axis
     *
     * @param y7Axis
     */
    public void setY7Axis(JQPlotAxisOptions y7Axis)
    {
        this.y7Axis = y7Axis;
    }

    /**
     * Gets the Y 2 Axis
     *
     * @return
     */
    public JQPlotAxisOptions getY8Axis()
    {
        if (y8Axis == null)
        {
            y8Axis = new JQPlotAxisOptions(getLinkedGraph());
        }
        return y8Axis;
    }

    /**
     * Sets the Y 3 Axis
     *
     * @param y8Axis
     */
    public void setY8Axis(JQPlotAxisOptions y8Axis)
    {
        this.y8Axis = y8Axis;
    }

    /**
     * Gets the Y 2 Axis
     *
     * @return
     */
    public JQPlotAxisOptions getY9Axis()
    {
        if (y9Axis == null)
        {
            y9Axis = new JQPlotAxisOptions(getLinkedGraph());
        }
        return y9Axis;
    }

    /**
     * Sets the Y 3 Axis
     *
     * @param y9Axis
     */
    public void setY9Axis(JQPlotAxisOptions y9Axis)
    {
        this.y9Axis = y9Axis;
    }

    /**
     * Returns the linked graph with this options
     *
     * @return
     */
    public JQPlotGraph getLinkedGraph()
    {
        return linkedGraph;
    }

    /**
     * Sets the linked graph with this object
     *
     * @param linkedGraph
     */
    public void setLinkedGraph(JQPlotGraph linkedGraph)
    {
        this.linkedGraph = linkedGraph;
    }

    /**
     * Gets the Z Axis Options
     *
     * @return
     */
    public JQPlotAxisOptions getzAxis()
    {
        if (zAxis == null)
        {
            zAxis = new JQPlotAxisOptions(getLinkedGraph());
        }
        return zAxis;
    }

    /**
     * Sets the zAxis Options
     *
     * @param zAxis
     */
    public void setzAxis(JQPlotAxisOptions zAxis)
    {
        this.zAxis = zAxis;
    }

}
