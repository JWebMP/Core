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
import java.util.ArrayList;
import za.co.mmagon.jwebswing.components.jqPlot.JQPlotGraph;
import za.co.mmagon.jwebswing.components.jqPlot.references.JQPlotJavascriptReferencePool;
import za.co.mmagon.jwebswing.generics.CompassPoints;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * The Point Labels
 *
 * @author GedMarc
 * @since 27 Feb 2016
 */
public class JQPlotPointLabelsOptions extends JavaScriptPart
{

    /**
     * show the labels or not.
     */
    private Boolean show;

    /**
     * compass location where to position the label around the point.
     */
    private CompassPoints location;
    /**
     * true to use labels within data point arrays.
     */
    private Boolean labelsFromSeries;
    /**
     * array index for location of labels within data point arrays.
     */
    private ArrayList seriesLabelIndex;//
    /**
     * array of arrays of labels, one array for each series.
     */
    private ArrayList<String> labels;
    /**
     * true to display value as stacked in a stacked plot.
     */
    private Boolean stackedValue;
    /**
     * vertical padding in pixels between point and label
     */
    private Integer ypadding;
    /**
     * horizontal padding in pixels between point and label
     */
    private Integer xpadding;
    /**
     * true to escape html entities in the labels.
     */
    private Boolean escapeHTML;//
    /**
     * Number of pixels that the label must be away from an axis boundary in order to be drawn.
     */
    private Integer edgeTolerance;//
    /**
     * A class of a formatter for the tick text.
     */
    private String formatter;
    /**
     * string passed to the formatter.
     */
    private String formatString;//
    /**
     * true to not show a label for a value which is 0.
     */
    private Boolean hideZeros;

    @JsonIgnore
    private JQPlotGraph linkedGraph;

    /**
     * Constructs a new point labels option
     *
     * @param linkedGraph
     */
    public JQPlotPointLabelsOptions(JQPlotGraph linkedGraph)
    {
        this.linkedGraph = linkedGraph;
    }

    /**
     * Gets whether or not to show the point labels
     *
     * @return
     */
    public Boolean getShow()
    {
        return show;
    }

    /**
     * Sets whether or not to show point labels
     *
     * @param show
     */
    public void setShow(Boolean show)
    {
        if (show)
        {
            if (this.linkedGraph != null)
            {
                this.linkedGraph.getJavascriptReferences().add(JQPlotJavascriptReferencePool.PointLabelsRenderer.getReference());
            }
        }
        this.show = show;
    }

    /**
     * compass location where to position the label around the point.
     *
     * @return
     */
    public CompassPoints getLocation()
    {
        return location;
    }

    /**
     * compass location where to position the label around the point.
     *
     * @param location
     */
    public void setLocation(CompassPoints location)
    {
        this.location = location;
    }

    /**
     * true to use labels within data point arrays.
     *
     * @return
     */
    public Boolean getLabelsFromSeries()
    {
        return labelsFromSeries;
    }

    /**
     * true to use labels within data point arrays.
     *
     * @param labelsFromSeries
     */
    public void setLabelsFromSeries(Boolean labelsFromSeries)
    {
        this.labelsFromSeries = labelsFromSeries;
    }

    /**
     * array index for location of labels within data point arrays.
     *
     * @return
     */
    public ArrayList getSeriesLabelIndex()
    {
        return seriesLabelIndex;
    }

    /**
     * array index for location of labels within data point arrays.
     *
     * @param seriesLabelIndex
     */
    public void setSeriesLabelIndex(ArrayList seriesLabelIndex)
    {
        this.seriesLabelIndex = seriesLabelIndex;
    }

    /**
     * *
     * array of arrays of labels, one array for each series.
     *
     * @return
     */
    public ArrayList<String> getLabels()
    {
        return labels;
    }

    /**
     * array of arrays of labels, one array for each series.
     *
     * @param labels
     */
    public void setLabels(ArrayList<String> labels)
    {
        this.labels = labels;
    }

    /**
     * true to display value as stacked in a stacked plot.
     *
     * @return
     */
    public Boolean getStackedValue()
    {
        return stackedValue;
    }

    /**
     * true to display value as stacked in a stacked plot.
     *
     * @param stackedValue
     */
    public void setStackedValue(Boolean stackedValue)
    {
        this.stackedValue = stackedValue;
    }

    /**
     * vertical padding in pixels between point and label
     *
     * @return
     */
    public Integer getYpadding()
    {
        return ypadding;
    }

    /**
     * vertical padding in pixels between point and label
     *
     * @param ypadding
     */
    public void setYpadding(Integer ypadding)
    {
        this.ypadding = ypadding;
    }

    /**
     * horizontal padding in pixels between point and label
     *
     * @return
     */
    public Integer getXpadding()
    {
        return xpadding;
    }

    /**
     * horizontal padding in pixels between point and label
     *
     * @param xpadding
     */
    public void setXpadding(Integer xpadding)
    {
        this.xpadding = xpadding;
    }

    /**
     * true to escape html entities in the labels.
     *
     * @return
     */
    public Boolean getEscapeHTML()
    {
        return escapeHTML;
    }

    /**
     * true to escape html entities in the labels.
     *
     * @param escapeHTML
     */
    public void setEscapeHTML(Boolean escapeHTML)
    {
        this.escapeHTML = escapeHTML;
    }

    /**
     * Number of pixels that the label must be away from an axis boundary in order to be drawn.
     *
     * @return
     */
    public Integer getEdgeTolerance()
    {
        return edgeTolerance;
    }

    /**
     * Number of pixels that the label must be away from an axis boundary in order to be drawn.
     *
     * @param edgeTolerance
     */
    public void setEdgeTolerance(Integer edgeTolerance)
    {
        this.edgeTolerance = edgeTolerance;
    }

    /**
     * A class of a formatter for the tick text. sprintf by default.
     *
     * @return
     */
    public String getFormatter()
    {
        return formatter;
    }

    /**
     * A class of a formatter for the tick text. sprintf by default.
     *
     * @param formatter
     */
    public void setFormatter(String formatter)
    {
        this.formatter = formatter;
    }

    /**
     * string passed to the formatter.
     *
     * @return
     */
    public String getFormatString()
    {
        return formatString;
    }

    /**
     * string passed to the formatter.
     *
     * @param formatString
     */
    public void setFormatString(String formatString)
    {
        this.formatString = formatString;
    }

    /**
     * Whether or not to hide zeros
     *
     * @return
     */
    public Boolean getHideZeros()
    {
        return hideZeros;
    }

    /**
     * Whether or not to hide zeros
     *
     * @param hideZeros
     */
    public void setHideZeros(Boolean hideZeros)
    {
        this.hideZeros = hideZeros;
    }

    /**
     * gets the linked graph
     *
     * @return
     */
    public JQPlotGraph getLinkedGraph()
    {
        return linkedGraph;
    }

    /*
     * Sets the linked graph
     */
    public void setLinkedGraph(JQPlotGraph linkedGraph)
    {
        this.linkedGraph = linkedGraph;
    }

}
