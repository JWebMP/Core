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
package za.co.mmagon.jwebswing.components.jqPlot.options;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import java.util.ArrayList;
import za.co.mmagon.jwebswing.base.references.JavascriptReference;
import za.co.mmagon.jwebswing.components.jqPlot.JQPlotGraph;
import za.co.mmagon.jwebswing.components.jqPlot.options.axis.JQPlotAxisOptions;
import za.co.mmagon.jwebswing.components.jqPlot.options.grid.JQPlotGridOptionsCanvasGrid;
import za.co.mmagon.jwebswing.components.jqPlot.options.title.JQPlotTitleOptions;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * The Global options allowed for a JQPlotGraph
 *
 * @author GedMarc
 * @since 26 Feb 2016
 */
public class JQPlotOptions<O extends JavaScriptPart> extends JavaScriptPart
{

    @JsonIgnore
    private JQPlotGraph linkedGraph;

    /**
     * The graph options available. This is the complete set
     * <p>
     */
    public JQPlotOptions(JQPlotGraph linkedGraph)
    {
        this.linkedGraph = linkedGraph;
    }

    /**
     * Version 1
     */
    private static final long serialVersionUID = 1L;

    /**
     * True to animate the series on initial plot draw (renderer dependent).
     */
    @JsonIgnore
    private Boolean animate;
    /**
     * True to animate series after a call to the replot() method.
     * Replots can happen very frequently under certain circumstances (e.g. resizing, dragging points) and animation in these situations can cause problems.
     */
    private Boolean animateReplot;
    /**
     * false to not sort the data passed in by the user.
     */
    private Boolean sortData;
    /**
     * true or false, creates a stack or “mountain” plot.
     */
    private Boolean stackSeries;
    /**
     * if true, right-click events are intercepted and a jqplotRightClick
     * event will be fired. This will also block the context menu.
     */
    private Boolean captureRightClick;

    /**
     * The Highlighter Plugin Options
     */
    private JQPlotHighlightOptions highlighter;
    /**
     * The title options available
     */
    private JQPlotTitleOptions title;
    /**
     * The cursor options available
     */
    private JQPlotCursorOptions cursor;
    /**
     * A grouping of colours
     */
    private ArrayList<String> seriesColours;
    /**
     * A grouping of colours
     */
    private ArrayList<String> negativeSeriesColours;
    /**
     * The default options for all series
     */
    private JQPlotSeriesOptions seriesDefaults;
    /**
     * Each series configuration in order of display
     */
    private ArrayList<JQPlotSeriesOptions> series;
    /**
     * An array of all the axis available.
     * Can be up to 9. Example [x,y,z] or [x,y1,x2,y2,y3,y4,y5,y6]
     */
    private JQPlotAxes axes;

    /**
     * The default legendOptions
     */
    @JsonProperty("legend")
    private JQPlotLegendOptions legendOptions;
    /**
     * The grid canvas options
     */
    private JQPlotGridOptionsCanvasGrid gridOptions;

    /**
     * The default axis configuration
     */
    private JQPlotAxisOptions axesDefaults;

    /**
     * Gets the Title Part for this Graph
     * <p>
     * @return The Graph Title Part
     */
    public JQPlotTitleOptions getTitle()
    {
        if (title == null)
        {
            title = new JQPlotTitleOptions("", this.linkedGraph);
        }
        return title;
    }

    /**
     * Sets the Graph Title Part for this Graph
     * <p>
     * @param title The title object to set
     */
    public void setTitle(JQPlotTitleOptions title)
    {
        this.title = title;

    }

    /**
     * Gets the Highlighter associated with this graph
     * <p>
     * @return
     */
    public JQPlotHighlightOptions getHighlighter()
    {
        if (highlighter == null)
        {
            highlighter = new JQPlotHighlightOptions(this.linkedGraph);
        }
        return highlighter;
    }

    /**
     * Sets the Highlighter for this graph
     * <p>
     * @param highlighter The highlighting to use
     */
    public void setHighlighter(JQPlotHighlightOptions highlighter)
    {
        this.highlighter = highlighter;
    }

    /**
     * Get the cursor option associated with this graph
     * <p>
     * @return
     */
    public JQPlotCursorOptions getCursor()
    {
        if (cursor == null)
        {
            cursor = new JQPlotCursorOptions(this.linkedGraph);
        }
        return cursor;
    }

    /**
     * Sets the Cursor options associated with this graph
     * <p>
     * @param cursor
     */
    public void setCursor(JQPlotCursorOptions cursor)
    {
        this.cursor = cursor;
    }

    /**
     * Returns the series Colours that are associated with this Graph
     * <p>
     * @return
     */
    public ArrayList<String> getSeriesColours()
    {
        if (seriesColours == null)
        {
            seriesColours = new ArrayList<>();
        }
        return seriesColours;
    }

    /**
     * Set the series Colours to be used for this graph
     * <p>
     * @param seriesColours
     */
    public void setSeriesColours(ArrayList<String> seriesColours)
    {
        this.seriesColours = seriesColours;
    }

    /**
     * Returns the series Colours that are associated with this Graph when negative
     * <p>
     * @return
     */
    public ArrayList<String> getNegativeSeriesColours()
    {
        if (negativeSeriesColours == null)
        {
            negativeSeriesColours = new ArrayList<>();
        }
        return negativeSeriesColours;
    }

    /**
     * Set the series Colours to be used for this graph when negative
     * <p>
     * @param negativeSeriesColours
     */
    public void setNegativeSeriesColours(ArrayList<String> negativeSeriesColours)
    {
        this.negativeSeriesColours = negativeSeriesColours;
    }

    /**
     * Returns the current allocated series defaults
     * <p>
     * @return Null if not applied or is Line Graph
     */
    public JQPlotSeriesOptions getSeriesDefaults()
    {
        if (seriesDefaults == null)
        {
            seriesDefaults = new JQPlotSeriesOptions(this.linkedGraph);
        }
        return seriesDefaults;
    }

    /**
     * Sets the current allocated Series Defaults.
     * <p>
     * @param seriesDefaults
     */
    public void setSeriesDefaults(JQPlotSeriesOptions seriesDefaults)
    {
        this.seriesDefaults = seriesDefaults;
    }

    /**
     * Gets the array list of each series different options in order of addition
     * <p>
     * @return
     */
    public ArrayList<JQPlotSeriesOptions> getSeries()
    {
        if (series == null)
        {
            series = new ArrayList<>();
        }
        return series;
    }

    /**
     * Sets the series configuration
     * <p>
     * @param series
     */
    public void setSeries(ArrayList<JQPlotSeriesOptions> series)
    {
        this.series = series;
    }

    /**
     * Gets the Axes Defaults
     * <p>
     * @return
     */
    public JQPlotAxisOptions getAxesDefaults()
    {
        if (axesDefaults == null)
        {
            axesDefaults = new JQPlotAxisOptions(this.getLinkedGraph());
        }
        return axesDefaults;
    }

    /**
     * Sets the Axes Defaults
     * <p>
     * @param axesDefaults
     */
    public void setAxesDefaults(JQPlotAxisOptions axesDefaults)
    {
        this.axesDefaults = axesDefaults;
    }

    /**
     * Returns the legendOptions options
     * <p>
     * @return
     */
    public JQPlotLegendOptions getLegendOptions()
    {
        if (legendOptions == null)
        {
            legendOptions = new JQPlotLegendOptions(getLinkedGraph());
        }
        return legendOptions;
    }

    /**
     * Sets the legendOptions options
     * <p>
     * @param legendOptions
     */
    public void setLegendOptions(JQPlotLegendOptions legendOptions)
    {
        this.legendOptions = legendOptions;
    }

    /**
     * Gets the grid options
     * <p>
     * @return
     */
    public JQPlotGridOptionsCanvasGrid getGridOptions()
    {
        if (gridOptions == null)
        {
            gridOptions = new JQPlotGridOptionsCanvasGrid(getLinkedGraph());
        }
        return gridOptions;
    }

    /**
     * Sets the grid options
     * <p>
     * @param gridOptions
     */
    public void setGridOptions(JQPlotGridOptionsCanvasGrid gridOptions)
    {
        this.gridOptions = gridOptions;
    }

    @JsonProperty(value = "animate")
    @JsonRawValue
    /**
     * True to animate the series on initial plot draw (renderer dependent).
     * <p>
     * @return
     */
    public String getAnimate()
    {
        if (animate == null)
        {
            return null;
        }
        if (animate)
        {
            return "!$.jqplot.use_excanvas";
        }
        else
        {
            return "false";
        }
    }

    /**
     * True to animate the series on initial plot draw (renderer dependent).
     * <p>
     * @param animate
     */
    public void setAnimate(Boolean animate)
    {
        this.animate = animate;
    }

    /**
     * True to animate series after a call to the replot() method.
     * Replots can happen very frequently under certain circumstances (e.g. resizing, dragging points) and animation in these situations can cause problems.
     * <p>
     * @return
     */
    public Boolean getAnimateReplot()
    {
        return animateReplot;
    }

    /**
     * True to animate series after a call to the replot() method.
     * Replots can happen very frequently under certain circumstances (e.g. resizing, dragging points) and animation in these situations can cause problems.
     * <p>
     * @param animateReplot
     */
    public void setAnimateReplot(Boolean animateReplot)
    {
        this.animateReplot = animateReplot;
    }

    /**
     * false to not sort the data passed in by the user.
     * <p>
     * @return
     */
    public Boolean getSortData()
    {
        return sortData;
    }

    /**
     * false to not sort the data passed in by the user.
     * <p>
     * @param sortData
     */
    public void setSortData(Boolean sortData)
    {
        this.sortData = sortData;
    }

    /**
     * true or false, creates a stack or “mountain” plot.
     * <p>
     * @return
     */
    public Boolean getStackSeries()
    {
        return stackSeries;
    }

    /**
     * true or false, creates a stack or “mountain” plot.
     * <p>
     * @param stackSeries
     */
    public void setStackSeries(Boolean stackSeries)
    {
        this.stackSeries = stackSeries;
    }

    /**
     * if true, right-click events are intercepted and a jqplotRightClick
     * event will be fired. This will also block the context menu.
     * <p>
     * @return
     */
    public Boolean getCaptureRightClick()
    {
        return captureRightClick;
    }

    /**
     * if true, right-click events are intercepted and a jqplotRightClick
     * event will be fired. This will also block the context menu.
     * <p>
     * @param captureRightClick
     */
    public void setCaptureRightClick(Boolean captureRightClick)
    {
        this.captureRightClick = captureRightClick;
    }

    /**
     * An array of all the axis available.
     * Can be up to 9. Example [x,y,z] or [x,y1,x2,y2,y3,y4,y5,y6]
     * <p>
     * @return A map in order for the options render
     */
    public JQPlotAxes getAxes()
    {
        if (axes == null)
        {
            axes = new JQPlotAxes(linkedGraph);
        }
        return axes;
    }

    /**
     * Sets the map in order
     * <p>
     * @param axes
     */
    public void setAxes(JQPlotAxes axes)
    {
        this.axes = axes;
    }

    ;

    @JsonIgnore
    /**
     * Returns the linked JavaScript References
     *
     * @return
     */
    public ArrayList<JavascriptReference> getJavascriptReferences()
    {
        ArrayList<JavascriptReference> arrs = new ArrayList<>();
        return arrs;
    }

    /**
     * Gets the linked graph
     *
     * @return
     */
    public JQPlotGraph getLinkedGraph()
    {
        return linkedGraph;
    }

    /**
     * Sets the linked graph
     *
     * @param linkedGraph
     */
    public void setLinkedGraph(JQPlotGraph linkedGraph)
    {
        this.linkedGraph = linkedGraph;
    }

}
