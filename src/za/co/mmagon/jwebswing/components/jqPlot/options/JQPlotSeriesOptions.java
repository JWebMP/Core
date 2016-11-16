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
package za.co.mmagon.jwebswing.components.jqPlot.options;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import za.co.mmagon.jwebswing.components.jqPlot.JQPlotGraph;
import za.co.mmagon.jwebswing.components.jqPlot.options.series.JQPlotSeriesLineOptions;
import za.co.mmagon.jwebswing.components.jqPlot.parts.XAxisTypes;
import za.co.mmagon.jwebswing.components.jqPlot.parts.YAxisTypes;
import za.co.mmagon.jwebswing.components.jqPlot.parts.interfaces.JQPlotMarkerRenderer;
import za.co.mmagon.jwebswing.components.jqPlot.parts.interfaces.JQPlotSeriesRenderer;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourHex;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 *
 * @param O The Series Renderer
 * @param M The Marker Renderer
 * @author mmagon
 */
public class JQPlotSeriesOptions<O extends JavaScriptPart & JQPlotSeriesRenderer, M extends JavaScriptPart & JQPlotMarkerRenderer>
        extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private JQPlotGraph linkedGraph;

    private Boolean fillToZero;

    private String linePattern;

    /**
     * Construct a new instance of the series defaults with the given renderer
     * <p>
     */
    public JQPlotSeriesOptions(JQPlotGraph linkedGraph)
    {
        this.linkedGraph = linkedGraph;

    }
    /**
     * Whether to show this series or not
     */
    private Boolean show;
    /**
     * either 'xaxis' or 'x2axis'.
     */
    private XAxisTypes xaxis;
    /**
     * either 'yaxis' or 'y2axis'.
     */
    private YAxisTypes yaxis;
    /**
     * label to use in the legend for this line.
     */
    private String label;
    /**
     * CSS color spec to use for the line. Determined automatically.
     */
    private String colors;
    /**
     * Width of the line in pixels.
     */
    private Double lineWidth;
    /**
     * show shadow or not.
     */
    private Boolean shadow;
    /**
     * angle (degrees) of the shadow, clockwise from x axis.
     */
    private Integer shadowAngle;
    /**
     * offset from the line of the shadow.
     */
    private Double shadowOffset;
    /**
     * Number of strokes to make when drawing shadow. Each
     * stroke offset by shadowOffset from the last.
     */
    private Integer shadowDepth;
    /**
     * Opacity of the shadow.
     */
    private Double shadowAlpha;
    /**
     * whether to render the line segments or not.
     */
    private Boolean showLine;
    /**
     * render the data point markers or not.
     */
    private Boolean showMarker;
    /**
     * fill under the line,
     */
    private Boolean fill;
    /**
     * stroke a line at top of fill area.
     */
    private Boolean fillAndStroke;
    /**
     * *custom fill color for filled lines (default is line color).
     */
    private String fillColor;
    /**
     * custom alpha to apply to fillColor
     */
    private String fillAlpha;

    /**
     * renderer: $.jqplot.LineRenderer], // renderer used to draw the series.
     */
    @JsonProperty("renderer")
    @JsonRawValue
    private String seriesRenderer;

    /**
     * The series renderer options
     */
    @JsonProperty("rendererOptions")
    private O rendererOptions;

    /**
     * markerRenderer: $.jqplot.MarkerRenderer, // renderer to use to draw the data
     * // point markers.
     */
    @JsonRawValue
    private String markerRenderer;
    /**
     * The Marker Renderer Options
     */
    @JsonProperty("markerOptions")
    private M markerRendererOptions;
    /**
     * Whether or not to show the labels for a point
     */
    private JQPlotPointLabelsOptions pointLabels;

    /**
     *
     * Whether or not to show a line
     * <p>
     * @return
     */
    public Boolean isShowLine()
    {
        return showLine;
    }

    /**
     *
     * Whether or not to show a line
     * <p>
     * @param showLine Whether to show the line or not
     */
    public void setShowLine(Boolean showLine)
    {
        this.showLine = showLine;
    }

    /**
     * To show or not show the series
     * <p>
     * @return
     */
    public Boolean isShow()
    {
        return show;
    }

    /**
     * To show or not show the series
     */
    public void setShow(Boolean show)
    {
        this.show = show;
    }

    /**
     * render the data point markers or not.
     *
     * @return
     */
    public Boolean isShowMarker()
    {
        return showMarker;
    }

    /**
     * render the data point markers or not.
     *
     * @param showMarker
     */
    public void setShowMarker(Boolean showMarker)
    {
        this.showMarker = showMarker;
    }

    /**
     * show shadow or not.
     *
     * @return
     */
    public Boolean isShadow()
    {
        return shadow;
    }

    /**
     * show shadow or not.
     *
     * @param shadow
     */
    public void setShadow(Boolean shadow)
    {
        this.shadow = shadow;
    }

    /**
     * Gets the X Axis
     *
     * @return
     */
    public XAxisTypes getXaxis()
    {
        return xaxis;
    }

    /**
     * Sets the X Axis
     *
     * @param xaxis
     */
    public void setXaxis(XAxisTypes xaxis)
    {
        this.xaxis = xaxis;
    }

    /**
     * Gets the Y Axis
     *
     * @return
     */
    public YAxisTypes getYaxis()
    {
        return yaxis;
    }

    /**
     * Sets the Y Axis
     *
     * @param yaxis
     */
    public void setYaxis(YAxisTypes yaxis)
    {
        this.yaxis = yaxis;
    }

    /**
     * Gets the label for the series
     *
     * @return
     */
    public String getLabel()
    {
        return label;
    }

    /**
     * Sets the label for the series
     *
     * @param label
     */
    public void setLabel(String label)
    {
        this.label = label;
    }

    /**
     * CSS color spec to use for the line. Determined automatically.
     *
     * @return
     */
    public String getColors()
    {
        return colors;
    }

    /**
     * CSS color spec to use for the line. Determined automatically.
     *
     * @param colors
     */
    public void setColors(ColourHex colors)
    {
        this.colors = colors.getValue();
    }

    /**
     * Width of the line in pixels.
     *
     * @return
     */
    public Double getLineWidth()
    {
        return lineWidth;
    }

    /**
     * Width of the line in pixels.
     *
     * @param lineWidth
     */
    public void setLineWidth(Double lineWidth)
    {
        this.lineWidth = lineWidth;
    }

    /**
     * angle (degrees) of the shadow, clockwise from x axis.
     *
     * @return
     */
    public Integer getShadowAngle()
    {
        return shadowAngle;
    }

    /**
     * angle (degrees) of the shadow, clockwise from x axis.
     *
     * @param shadowAngle
     */
    public void setShadowAngle(Integer shadowAngle)
    {
        this.shadowAngle = shadowAngle;
    }

    /**
     * offset from the line of the shadow.
     *
     * @return
     */
    public Double getShadowOffset()
    {
        return shadowOffset;
    }

    /**
     * offset from the line of the shadow.
     *
     * @param shadowOffset
     */
    public void setShadowOffset(Double shadowOffset)
    {
        this.shadowOffset = shadowOffset;
    }

    /**
     * Number of strokes to make when drawing shadow. Each
     * stroke offset by shadowOffset from the last.
     *
     * @return
     */
    public Integer getShadowDepth()
    {
        return shadowDepth;
    }

    /**
     * Number of strokes to make when drawing shadow. Each
     * stroke offset by shadowOffset from the last.
     *
     * @param shadowDepth
     */
    public void setShadowDepth(Integer shadowDepth)
    {
        this.shadowDepth = shadowDepth;
    }

    /**
     * Opacity of the shadow.
     *
     * @return
     */
    public Double getShadowAlpha()
    {
        return shadowAlpha;
    }

    /**
     * Opacity of the shadow.
     *
     * @param shadowAlpha
     */
    public void setShadowAlpha(Double shadowAlpha)
    {
        this.shadowAlpha = shadowAlpha;
    }

    /**
     * fill under the line,
     *
     * @return
     */
    public Boolean getFill()
    {
        return fill;
    }

    /**
     * fill under the line,
     *
     * @param fill
     */
    public void setFill(Boolean fill)
    {
        this.fill = fill;
    }

    /**
     * stroke a line at top of fill area.
     *
     * @return
     */
    public Boolean getFillAndStroke()
    {
        return fillAndStroke;
    }

    /**
     * stroke a line at top of fill area.
     *
     * @param fillAndStroke
     */
    public void setFillAndStroke(Boolean fillAndStroke)
    {
        this.fillAndStroke = fillAndStroke;
    }

    /**
     * custom fill color for filled lines (default is line color).
     *
     * @return
     */
    public String getFillColor()
    {
        return fillColor;
    }

    /**
     * custom fill color for filled lines (default is line color).
     *
     * @param fillColor
     */
    public void setFillColor(ColourHex fillColor)
    {
        this.fillColor = fillColor.getValue();
    }

    /**
     * custom alpha to apply to fillColor
     *
     * @return
     */
    public String getFillAlpha()
    {
        return fillAlpha;
    }

    /**
     * custom alpha to apply to fillColor
     *
     * @param fillAlpha
     */
    public void setFillAlpha(ColourHex fillAlpha)
    {
        this.fillAlpha = fillAlpha.getValue();
    }

    /**
     * Gets the current series renderer name
     *
     * @return
     */
    public String getSeriesRenderer()
    {
        return seriesRenderer;
    }

    /**
     * Get the Series Renderer Options
     * <p>
     * JQPlotSeriesLineOptions by default
     *
     * @return
     */
    public O getRendererOptions()
    {
        if (rendererOptions == null)
        {
            rendererOptions = (O) new JQPlotSeriesLineOptions(getLinkedGraph());
        }
        return rendererOptions;
    }

    /**
     * CSS color spec to use for the line. Determined automatically.
     *
     * @param colors
     */
    public void setColors(String colors)
    {
        this.colors = colors;
    }

    /**
     * custom fill color for filled lines (default is line color).
     *
     * @param fillColor
     */
    public void setFillColor(String fillColor)
    {
        this.fillColor = fillColor;
    }

    /**
     * custom fill color for filled lines (default is line color).
     *
     * @param fillAlpha
     */
    public void setFillAlpha(String fillAlpha)
    {
        this.fillAlpha = fillAlpha;
    }

    /**
     * Sets the series renderer options
     *
     * @param rendererOptions
     */
    public void setRendererOptions(O rendererOptions)
    {
        this.rendererOptions = rendererOptions;
        this.seriesRenderer = rendererOptions.getRenderer();
    }

    /**
     * Sets the Marker Renderer
     *
     * @return
     */
    public String getMarkerRenderer()
    {
        return markerRenderer;
    }

    /**
     * Set to use point labels or not
     *
     * @return
     */
    public JQPlotPointLabelsOptions getPointLabels()
    {
        if (pointLabels == null)
        {
            pointLabels = new JQPlotPointLabelsOptions(this.linkedGraph);
        }
        return pointLabels;
    }

    /**
     * Set to use point labels
     *
     * @param pointLabels
     */
    public void setPointLabels(JQPlotPointLabelsOptions pointLabels)
    {
        this.pointLabels = pointLabels;
    }

    /**
     * Gets the specified Marker Renderer Options
     * <p>
     * Default to JQPlotMarkerOptions
     *
     * @return
     */
    public M getMarkerRendererOptions()
    {
        if (markerRendererOptions == null)
        {
            setMarkerRendererOptions((M) new JQPlotMarkerOptions(getLinkedGraph()));
        }
        return markerRendererOptions;
    }

    /**
     * Sets the Marker Renderer Options
     *
     * @param markerRendererOptions
     */
    public void setMarkerRendererOptions(M markerRendererOptions)
    {
        this.markerRendererOptions = markerRendererOptions;
        this.markerRenderer = markerRendererOptions.getMarkerRenderer();
    }

    /**
     * Show series
     *
     * @return
     */
    public Boolean getShow()
    {
        return show;
    }

    /**
     * get Shadow
     *
     * @return
     */
    public Boolean getShadow()
    {
        return shadow;
    }

    /**
     * Is Show Line
     *
     * @return
     */
    public Boolean getShowLine()
    {
        return showLine;
    }

    /**
     * Is Show Marker
     *
     * @return
     */
    public Boolean getShowMarker()
    {
        return showMarker;
    }

    /**
     * Set the marker renderer string
     *
     * @param markerRenderer
     */
    public void setMarkerRenderer(String markerRenderer)
    {
        this.markerRenderer = markerRenderer;
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

    /**
     * Gets the fill to zero
     *
     * @return
     */
    public Boolean getFillToZero()
    {
        return fillToZero;
    }

    /**
     * Sets the fill to zero
     *
     * @param fillToZero
     */
    public void setFillToZero(Boolean fillToZero)
    {
        this.fillToZero = fillToZero;
    }

    /**
     * line pattern ‘dashed’, ‘dotted’, ‘solid’, some combination of ‘-’ and ‘.’ characters such as ‘.-.’ or a numerical array like [draw, skip, draw, skip, ...] such as [1, 10] to draw a dotted line,
     * [1, 10, 20, 10] to draw a dot-dash line, and so on.
     *
     * @return
     */
    public String getLinePattern()
    {
        return linePattern;
    }

    /**
     * line pattern ‘dashed’, ‘dotted’, ‘solid’, some combination of ‘-’ and ‘.’ characters such as ‘.-.’ or a numerical array like [draw, skip, draw, skip, ...] such as [1, 10] to draw a dotted line,
     * [1, 10, 20, 10] to draw a dot-dash line, and so on.
     *
     * @param linePattern
     */
    public void setLinePattern(String linePattern)
    {
        this.linePattern = linePattern;
    }

}
