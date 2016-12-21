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
package za.co.mmagon.jwebswing.components.jqplot.graphs;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRawValue;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;
import za.co.mmagon.logger.LogFactory;
import za.co.mmagon.jwebswing.components.jqplot.JQPlotGraph;
import za.co.mmagon.jwebswing.components.jqplot.graphs.display.JQPlotDonutGroup;
import za.co.mmagon.jwebswing.components.jqplot.graphs.display.JQPlotPieSlice;
import za.co.mmagon.jwebswing.components.jqplot.options.JQPlotOptions;
import za.co.mmagon.jwebswing.components.jqplot.options.series.JQPlotSeriesDonutOptions;

/**
 * The line graph implementation
 *
 * @author mmagon
 * @since 2014/07/08
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class JQPlotDonutGraph extends JQPlotGraph<JQPlotOptions>
{

    /**
     * The logger for the swing Servlet
     */
    private static final Logger LOG = LogFactory.getInstance().getLogger("JQPlotDonutGraph");

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private JQPlotSeriesDonutOptions donutOptions;

    @JsonIgnore
    private JQPlotDonutGroup donutGroup;

    public JQPlotDonutGraph()
    {
        getOptions().getSeriesDefaults().setRendererOptions(donutOptions = new JQPlotSeriesDonutOptions(this));
        donutGroup = new JQPlotDonutGroup();
    }

    /**
     * Returns the plot lines on this graph
     *
     * @param donutGroup
     * @return
     */
    public List<JQPlotPieSlice> getPlotSlices(int donutGroup)
    {
        List<JQPlotPieSlice> arr = getDonutGroup().get(donutGroup);
        if (arr == null)
        {
            getDonutGroup().add(donutGroup, arr);
        }

        return getDonutGroup().get(donutGroup);
    }

    /**
     * Each line should consist of data-points in the form of x,y,x,y,x,y,x,y
     *
     * @param doubleGroup the donut group number to assign towards
     * @param name
     * @param values
     * @return
     */
    public JQPlotPieSlice addSlice(int doubleGroup, String name, double values)
    {
        JQPlotPieSlice slice = new JQPlotPieSlice(name, values);
        getDonutGroupSlices(doubleGroup).add(slice);
        return slice;
    }

    /**
     * Each line should consist of data-points in the form of x,y,x,y,x,y,x,y
     *
     * @param doubleGroup The group to add the pie values to
     * @param values An array of x,y values continual
     * @return
     */
    public List<JQPlotPieSlice> addSlices(int doubleGroup, double[] values)
    {
        List<JQPlotPieSlice> newSlices = getDonutGroupSlices(doubleGroup);
        for (int i = 0; i < values.length; i++)
        {
            double value = values[i];
            JQPlotPieSlice slice = new JQPlotPieSlice("Slice " + i, value);
            newSlices.add(slice);
        }

        return newSlices;
    }

    /**
     * 3 Bracket start
     *
     * @return
     */
    @Override
    protected StringBuilder getDataPointRender()
    {
        StringBuilder sb = new StringBuilder();
        String jsonInString;
        jsonInString = getDonutGroupJSON().toString();
        sb.append(jsonInString);

        return sb;
    }

    /**
     * The donut options
     *
     * @return
     */
    public JQPlotSeriesDonutOptions getDonutOptions()
    {
        return donutOptions;
    }

    /**
     * The donut options
     *
     * @param donutOptions
     */
    public void setDonutOptions(JQPlotSeriesDonutOptions donutOptions)
    {
        this.donutOptions = donutOptions;
    }

    /**
     * Returns a specific donut group. Rendered as [] in
     *
     * @return
     */
    @JsonRawValue
    @JsonFormat(shape = JsonFormat.Shape.ARRAY)
    public List<List<JQPlotPieSlice>> getDonutGroupJSON()
    {
        return getDonutGroup();
    }

    /**
     * Keep Group Number In oRder. if number is not in the size list, array list index out of bounds or
     *
     * @param groupNumber
     * @return
     */
    public List<JQPlotPieSlice> getDonutGroupSlices(int groupNumber) throws ArrayIndexOutOfBoundsException
    {
        if (getDonutGroup().size() >= groupNumber)
        {
            List<JQPlotPieSlice> newList = new ArrayList<>();
            getDonutGroup().add(newList);
        }
        return getDonutGroup().get(groupNumber);
    }

    public List<List<JQPlotPieSlice>> getDonutGroup()
    {
        if (this.donutGroup == null)
        {
            donutGroup = new JQPlotDonutGroup();
        }
        return this.donutGroup.getDonutGroup();
    }
}
