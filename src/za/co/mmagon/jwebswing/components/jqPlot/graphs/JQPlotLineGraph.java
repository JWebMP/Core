/*
 * Copyright (C) 2014 mmagon
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
package za.co.mmagon.jwebswing.components.jqPlot.graphs;

import java.util.ArrayList;
import za.co.mmagon.jwebswing.components.jqPlot.JQPlotGraph;
import za.co.mmagon.jwebswing.components.jqPlot.graphs.display.JQPlotLine;
import za.co.mmagon.jwebswing.components.jqPlot.options.JQPlotOptions;

/**
 * The line graph implementation
 *
 * @author mmagon
 * @since 2014/07/08
 */
public class JQPlotLineGraph extends JQPlotGraph<JQPlotOptions>
{

    private static final long serialVersionUID = 1L;

    private ArrayList<JQPlotLine> plotLines;

    public JQPlotLineGraph()
    {
    }

    /**
     * Returns the plot lines on this graph
     *
     * @return
     */
    public ArrayList<JQPlotLine> getPlotLines()
    {
        if (plotLines == null)
        {
            plotLines = new ArrayList<>();
        }
        return plotLines;
    }

    /**
     * Each line should consist of data-points in the form of x,y,x,y,x,y,x,y
     *
     * @param xyValues An array of x,y values continual
     */
    public void addLine(double... xyValues)
    {
        JQPlotLine newLine = new JQPlotLine(JQPlotLine.buildFromArray(xyValues));
        getPlotLines().add(newLine);
    }

    /**
     * Each line should consist of data-points in the form of x,y,x,y,x,y,x,y
     *
     * @param xyValues An array of x,y values continual
     */
    public void addLine(Object[] xyValues)
    {
        JQPlotLine newLine = new JQPlotLine(JQPlotLine.buildFromArray(xyValues));
        getPlotLines().add(newLine);
    }

    /**
     * Each line should consist of data-points in the form of x,y,x,y,x,y,x,y
     *
     * @param xyValues An array of x,y values continual
     */
    public void addLine(boolean yOnly, double... xyValues)
    {
        JQPlotLine newLine = new JQPlotLine();
        for (double xyValue : xyValues)
        {
            newLine.addPoint(xyValue);
        }
        getPlotLines().add(newLine);
    }

    /**
     * Each line should consist of data-points in the form of x,y,x,y,x,y,x,y
     *
     * @param xyValues A string of x,y coordinates
     */
    public void addLine(String xyValues)
    {
        JQPlotLine newLine = new JQPlotLine(JQPlotLine.buildFromDelimiteredSrting(xyValues, ","));
        getPlotLines().add(newLine);
    }

    /**
     * Each line should consist of data-points in the form of x,y,x,y,x,y,x,y
     *
     * @param newLine A new line to add
     */
    public void addLine(JQPlotLine newLine)
    {

        getPlotLines().add(newLine);
    }

    @Override
    protected StringBuilder getDataPointRender()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (JQPlotLine plotLine : getPlotLines())
        {
            sb.append(plotLine).append(",");
            sb.append("");
        }
        sb = sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append("]");
        return sb;
    }
}
