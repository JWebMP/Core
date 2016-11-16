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
package za.co.mmagon.jwebswing.components.jqPlot.options.series;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import za.co.mmagon.jwebswing.components.jqPlot.JQPlotGraph;
import za.co.mmagon.jwebswing.components.jqPlot.parts.interfaces.JQPlotSeriesRenderer;
import za.co.mmagon.jwebswing.components.jqPlot.references.JQPlotJavascriptReferencePool;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * The properties for a line graph
 *
 * @author Marc Magon
 * @since 09 Aug 2015
 * @version 1.0
 */
public class JQPlotSeriesDonutOptions extends JavaScriptPart implements JQPlotSeriesRenderer
{

    /**
     * The graph that this is linked to
     */
    @JsonIgnore
    private JQPlotGraph linkedGraph;
    
    /**
     * Outer diameter of the pie, auto computed by default
     */
    private Integer diameter;//
    /**
     * padding between the pie and plot edges, legend, etc.
     */
    private Double padding;
    /**
     * angular spacing between pie slices in degrees.
     */
    private Integer sliceMargin;
    /**
     * true or false, whether to fil the slices.
     */
    private Boolean fill;
    /**
     * offset of the shadow from the slice and offset of each succesive stroke of the shadow from the last.
     */
    private Integer shadowOffset;
    /**
     * transparency of the shadow (0 = transparent, 1 = opaque)
     */
    private Double shadowAlpha;
    /**
     * number of strokes to apply to the shadow, each stroke offset shadowOffset from the last.
     */
    private Integer shadowDepth;
    /**
     * True to highlight slice when moused over.
     */
    private Boolean highlightMouseOver;
    /**
     * True to highlight when a mouse button is pressed over a slice.
     */
    private Boolean highlightMouseDown;
    /**
     * an array of colors to use when highlighting a slice.
     */
    private List<String> highlightColors;
    /**
     * Either ‘label’, ‘value’, ‘percent’ or an array of labels to place on the pie slices.
     */
    private String dataLabels;
    /**
     * true to show data labels on slices.
     */
    private Boolean showDataLabels;
    /**
     * Format string for data labels.
     */
    private String dataLabelFormatString;
    /**
     * Threshold in percentage (0-100) of pie area, below which no label will be displayed.
     */
    private Integer dataLabelThreshold;
    /**
     * A Multiplier (0-1) of the pie radius which controls position of label on slice.
     */
    private Double dataLabelPositionFactor;
    /**
     * Number of pixels to slide the label away from (+) or toward (-) the center of the pie.
     */
    private Integer dataLabelNudge;
    /**
     * True to center the data label at its position.
     */
    private Boolean dataLabelCenterOn;
    /**
     * Angle to start drawing pie in degrees.
     */
    private Integer startAngle;
    /**
     * Array for whether the pie chart slice for a data element should be displayed.
     */
    private List<Boolean> showSlice;
    
    

    /**
     * Constructs a new Line Options for the given graph
     *
     * @param linkedGraph
     */
    public JQPlotSeriesDonutOptions(JQPlotGraph linkedGraph)
    {
        this.linkedGraph = linkedGraph;
        linkedGraph.getJavascriptReferences().add(JQPlotJavascriptReferencePool.DoughnutRenderer.getReference());
    }

    private static final long serialVersionUID = 1L;

    /**
     * Gets the graph associated with this options
     *
     * @return
     */
    public JQPlotGraph getLinkedGraph()
    {
        return linkedGraph;
    }

    /**
     * Sets the graph that is linked to this options
     *
     * @param linkedGraph
     */
    public void setLinkedGraph(JQPlotGraph linkedGraph)
    {
        this.linkedGraph = linkedGraph;
    }

    /**
     * Sets the series render to bubble
     *
     * @return
     */
    @Override
    public String getRenderer()
    {
        return "$.jqplot.DonutRenderer";
    }

    

    /**
     * Outer diameter of the pie, auto computed by default
     *
     * @return
     */
    public Integer getDiameter()
    {
        return diameter;
    }

    /**
     * Outer diameter of the pie, auto computed by default
     * <p>
     * <p>
     * @param diameter
     */
    public void setDiameter(Integer diameter)
    {
        this.diameter = diameter;
    }

    /**
     * padding between the pie and plot edges, legend, etc.
     *
     * @return
     */
    public Double getPadding()
    {
        return padding;
    }

    /**
     * padding between the pie and plot edges, legend, etc.
     * <p>
     * @param padding
     */
    public void setPadding(Double padding)
    {
        this.padding = padding;
    }

    /**
     * angular spacing between pie slices in degrees.
     *
     * @return
     */
    public Integer getSliceMargin()
    {
        return sliceMargin;
    }

    /**
     * angular spacing between pie slices in degrees.
     * <p>
     * @param sliceMargin
     */
    public void setSliceMargin(Integer sliceMargin)
    {
        this.sliceMargin = sliceMargin;
    }

    /**
     * true or false, whether to fil the slices.
     *
     * @return
     */
    public Boolean getFill()
    {
        return fill;
    }

    /**
     * true or false, whether to fill the slices.
     * <p>
     * @param fill
     */
    public void setFill(Boolean fill)
    {
        this.fill = fill;
    }

    /**
     * offset of the shadow from the slice and offset of each succesive stroke of the shadow from the last.
     *
     * @return
     */
    public Integer getShadowOffset()
    {
        return shadowOffset;
    }

    /**
     * offset of the shadow from the slice and offset of each succesive stroke of the shadow from the last.
     * <p>
     * @param shadowOffset
     */
    public void setShadowOffset(Integer shadowOffset)
    {
        this.shadowOffset = shadowOffset;
    }

    /**
     * transparency of the shadow (0 = transparent, 1 = opaque)
     *
     * @return
     */
    public Double getShadowAlpha()
    {
        return shadowAlpha;
    }

    /**
     * transparency of the shadow (0 = transparent, 1 = opaque)
     * <p>
     * <p>
     * @param shadowAlpha
     */
    public void setShadowAlpha(Double shadowAlpha)
    {
        this.shadowAlpha = shadowAlpha;
    }

    /**
     * number of strokes to apply to the shadow, each stroke offset shadowOffset from the last.
     *
     * @return
     */
    public Integer getShadowDepth()
    {
        return shadowDepth;
    }

    /**
     * number of strokes to apply to the shadow, each stroke offset shadowOffset from the last.
     * <p>
     * @param shadowDepth
     */
    public void setShadowDepth(Integer shadowDepth)
    {
        this.shadowDepth = shadowDepth;
    }

    /**
     * True to highlight slice when moused over.
     *
     * @return
     */
    public Boolean getHighlightMouseOver()
    {
        return highlightMouseOver;
    }

    /**
     * True to highlight slice when moused over.
     * <p>
     * @param highlightMouseOver
     */
    public void setHighlightMouseOver(Boolean highlightMouseOver)
    {
        this.highlightMouseOver = highlightMouseOver;
    }

    /**
     * True to highlight when a mouse button is pressed over a slice.
     *
     * @return
     */
    public Boolean getHighlightMouseDown()
    {
        return highlightMouseDown;
    }

    /**
     * True to highlight when a mouse button is pressed over a slice.
     * <p>
     * @param highlightMouseDown
     */
    public void setHighlightMouseDown(Boolean highlightMouseDown)
    {
        this.highlightMouseDown = highlightMouseDown;
    }

    /**
     * an array of colors to use when highlighting a slice.
     *
     * @return
     */
    public List<String> getHighlightColors()
    {
        return highlightColors;
    }

    /**
     * an array of colors to use when highlighting a slice.
     * <p>
     * @param highlightColors
     */
    public void setHighlightColors(ArrayList<String> highlightColors)
    {
        this.highlightColors = highlightColors;
    }

    /**
     * Either ‘label’, ‘value’, ‘percent’ or an array of labels to place on the pie slices.
     *
     * @return
     */
    public String getDataLabels()
    {
        return dataLabels;
    }

    /**
     * Either ‘label’, ‘value’, ‘percent’ or an array of labels to place on the pie slices.
     * <p>
     * @param dataLabels
     */
    public void setDataLabels(String dataLabels)
    {
        this.dataLabels = dataLabels;
    }

    /**
     * true to show data labels on slices
     *
     * @return
     */
    public Boolean getShowDataLabels()
    {
        return showDataLabels;
    }

    /**
     * true to show data labels on slices
     * <p>
     * @param showDataLabels
     */
    public void setShowDataLabels(Boolean showDataLabels)
    {
        this.showDataLabels = showDataLabels;
    }

    /**
     * Format string for data labels. If none, ‘%s’ is used for “label” and for arrays, ‘%d’ for value and ‘%d%%’ for percentage.
     *
     * @return
     */
    public String getDataLabelFormatString()
    {
        return dataLabelFormatString;
    }

    /**
     * Format string for data labels. If none, ‘%s’ is used for “label” and for arrays, ‘%d’ for value and ‘%d%%’ for percentage.
     * <p>
     * @param dataLabelFormatString
     */
    public void setDataLabelFormatString(String dataLabelFormatString)
    {
        this.dataLabelFormatString = dataLabelFormatString;
    }

    /**
     * Threshhold in percentage (0-100) of pie area, below which no label will be displayed.
     *
     * @return
     */
    public Integer getDataLabelThreshold()
    {
        return dataLabelThreshold;
    }

    /**
     * Threshhold in percentage (0-100) of pie area, below which no label will be displayed.
     * <p>
     * @param dataLabelThreshold
     */
    public void setDataLabelThreshold(Integer dataLabelThreshold)
    {
        this.dataLabelThreshold = dataLabelThreshold;
    }

    /**
     * A Multiplier (0-1) of the pie radius which controls position of label on slice.
     *
     * @return
     */
    public Double getDataLabelPositionFactor()
    {
        return dataLabelPositionFactor;
    }

    /**
     * A Multiplier (0-1) of the pie radius which controls position of label on slice.
     * <p>
     * @param dataLabelPositionFactor
     */
    public void setDataLabelPositionFactor(Double dataLabelPositionFactor)
    {
        this.dataLabelPositionFactor = dataLabelPositionFactor;
    }

    /**
     * Number of pixels to slide the label away from (+) or toward (-) the center of the pie.
     *
     * @return
     */
    public Integer getDataLabelNudge()
    {
        return dataLabelNudge;
    }

    /**
     * Number of pixels to slide the label away from (+) or toward (-) the center of the pie.
     * <p>
     * @param dataLabelNudge
     */
    public void setDataLabelNudge(Integer dataLabelNudge)
    {
        this.dataLabelNudge = dataLabelNudge;
    }

    /**
     * True to center the data label at its position.
     *
     * @return
     */
    public Boolean getDataLabelCenterOn()
    {
        return dataLabelCenterOn;
    }

    /**
     * True to center the data label at its position.
     * <p>
     * @param dataLabelCenterOn
     */
    public void setDataLabelCenterOn(Boolean dataLabelCenterOn)
    {
        this.dataLabelCenterOn = dataLabelCenterOn;
    }

    /**
     * Angle to start drawing pie in degrees.
     *
     * @return
     */
    public Integer getStartAngle()
    {
        return startAngle;
    }

    /**
     * Angle to start drawing pie in degrees.
     * <p>
     * @param startAngle
     */
    public void setStartAngle(Integer startAngle)
    {
        this.startAngle = startAngle;
    }

    /**
     * Array for whether the pie chart slice for a data element should be displayed.
     *
     * @return
     */
    public List<Boolean> getShowSlice()
    {
        return showSlice;
    }

    /**
     * Array for whether the pie chart slice for a data element should be displayed.
     * <p>
     * @param showSlice
     */
    public void setShowSlice(List<Boolean> showSlice)
    {
        this.showSlice = showSlice;
    }

}
