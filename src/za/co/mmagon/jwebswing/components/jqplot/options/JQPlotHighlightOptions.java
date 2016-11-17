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
package za.co.mmagon.jwebswing.components.jqplot.options;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.components.jqplot.JQPlotGraph;
import za.co.mmagon.jwebswing.components.jqplot.parts.interfaces.JQPlotMarkerRenderer;
import za.co.mmagon.jwebswing.components.jqplot.parts.interfaces.JQPlotRendererDefault;
import za.co.mmagon.jwebswing.components.jqplot.references.JQPlotJavascriptReferencePool;
import za.co.mmagon.jwebswing.generics.CompassPoints;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * Plugin which will highlight data points when they are moused over.
 * <p>
 * To use this plugin, include the js file in your source:
 * <p>
 * <p>
 * A tooltip providing information about the data point is enabled by default. To disable the tooltip, set “showTooltip” to false.
 * <p>
 * You can control what data is displayed in the tooltip with various options. The “tooltipAxes” option controls whether the x, y or both data values are displayed.
 * <p>
 * Some chart types (e.g. hi-low-close) have more than one y value per data point. To display the additional values in the tooltip, set the “yvalues” option to the desired number of y values present
 * (3 for a hlc chart).
 * <p>
 * By default, data values will be formatted with the same formatting specifiers as used to format the axis ticks. A custom format code can be supplied with the tooltipFormatString option. This will
 * apply to all values in the tooltip.
 * <p>
 * For more complete control, the “formatString” option can be set. This Allows conplete control over tooltip formatting. Values are passed to the format string in an order determined by the
 * “tooltipAxes” and “yvalues” options. So, if you have a hi-low-close chart and you just want to display the hi-low-close values in the tooltip, you could set a formatString like:
 *
 * @author mmagon
 */
public class JQPlotHighlightOptions<O extends JavaScriptPart & JQPlotMarkerRenderer> extends JavaScriptPart implements JQPlotRendererDefault
{

    private static final long serialVersionUID = 1L;

    /**
     * true to show the highlight.
     */
    private Boolean show;
    /**
     * Renderer used to draw the marker of the highlighted point.
     */
    private String markerRenderer;
    @JsonProperty("markerRenderer")
    private O markerRendererOptions;

    /**
     * true to show the marker
     */
    private Boolean showMarker = false;
    /**
     * Pixels to add to the lineWidth of the highlight.
     */
    private Integer lineWidthAdjust;
    /**
     * Pixels to add to the overall size of the highlight.
     */
    private Integer sizeAdjust;
    /**
     * Show a ToolTip with data point values.
     */
    private Boolean showTooltip = false;
    /**
     * Where to position tooltip, ‘n’, ‘ne’, ‘e’, ‘se’, ‘s’, ‘sw’, ‘w’, ‘nw’
     */
    private CompassPoints tooltipLocation;
    /**
     * true = fade in/out tooltip, false = show/hide tooltip
     */
    private Boolean fadeTooltip;
    /**
     * number of milliseconds.
     */
    private Integer tooltipFadeSpeed;
    /**
     * Pixel offset of tooltip from the highlight.
     */
    private Integer tooltipOffset;
    /**
     * Which axes to display in tooltip, ‘x’, ‘y’ or ‘both’, ‘xy’ or ‘yx’ ‘both’
     * and ‘xy’ are equivalent, ‘yx’ reverses order of labels.
     */
    private String tooltipAxes;
    /**
     * Use the x and y axes formatters to format the text in the tooltip.
     */
    private Boolean useAxesFormatters;
    /**
     * sprintf format string for the tooltip.
     */
    private String tooltipFormatString;
    /**
     * alternative to tooltipFormatString will format the whole tooltip text,
     * populating with x, y values as indicated by tooltipAxes option.
     */
    private String formatString;
    /**
     * Number of y values to expect in the data point array.
     */
    private Integer yvalues;
    /**
     * This option requires jQuery 1.4+ True to bring the series of the
     * highlighted point to the front of other series.
     */
    private Boolean bringSeriesToFront;

    @JsonIgnore
    private JQPlotGraph linkedGraph;

    /**
     * Constructs a new highlight options class with the given graph
     *
     * @param linkedGraph
     */
    public JQPlotHighlightOptions(JQPlotGraph linkedGraph)
    {
        this.linkedGraph = linkedGraph;
        linkedGraph.getJavascriptReferences().add(JQPlotJavascriptReferencePool.HighlightRenderer.getReference());
    }

    /**
     * true to show the highlight.
     * <p>
     * @return Current value
     */
    public Boolean isShow()
    {
        return show;
    }

    /**
     * True to show the highlight
     * <p>
     * @param show
     */
    public void setShow(Boolean show)
    {
        this.show = show;
    }

    /**
     * Renderer used to draw the marker of the highlighted point.
     * <p>
     * @return The renderer used
     */
    public String getMarkerRenderer()
    {
        return markerRenderer;
    }

    /**
     * true to show the marker
     * <p>
     * @return Current Value
     */
    public Boolean isShowMarker()
    {
        return showMarker;
    }

    /**
     * true to show the marker
     * <p>
     * @param showMarker Show Marker Boolean
     */
    public void setShowMarker(Boolean showMarker)
    {
        this.showMarker = showMarker;
    }

    /**
     * Pixels to add to the lineWidth of the highlight.
     * <p>
     * @return The pixels adjustment
     */
    public Integer getLineWidthAdjust()
    {
        return lineWidthAdjust;
    }

    /**
     * Pixels to add to the lineWidth of the highlight.
     * <p>
     * @param lineWidthAdjust The line adjustment width
     */
    public void setLineWidthAdjust(Integer lineWidthAdjust)
    {
        this.lineWidthAdjust = lineWidthAdjust;
    }

    /**
     * Pixels to add to the overall size of the highlight.
     * <p>
     * @return The Size Adjustment
     */
    public Integer getSizeAdjust()
    {
        return sizeAdjust;
    }

    /**
     * Pixels to add to the overall size of the highlight.
     * <p>
     * @param sizeAdjust The size to adjust by
     */
    public void setSizeAdjust(Integer sizeAdjust)
    {
        this.sizeAdjust = sizeAdjust;
    }

    /**
     * Show a tooltip with data point values
     * <p>
     * @return
     */
    public Boolean isShowTooltip()
    {
        return showTooltip;
    }

    /**
     * Show a tooltip with data point values.
     * <p>
     * @param showTooltip To show the tooltip
     */
    public void setShowTooltip(Boolean showTooltip)
    {
        this.showTooltip = showTooltip;
    }

    /**
     * Where to position tooltip, ‘n’, ‘ne’, ‘e’, ‘se’, ‘s’, ‘sw’, ‘w’, ‘nw’
     * <p>
     * @return Position
     */
    public CompassPoints getTooltipLocation()
    {
        return tooltipLocation;
    }

    /**
     * Where to position tooltip, ‘n’, ‘ne’, ‘e’, ‘se’, ‘s’, ‘sw’, ‘w’, ‘nw’
     * <p>
     * @param tooltipLocation The location
     */
    public void setTooltipLocation(CompassPoints tooltipLocation)
    {
        this.tooltipLocation = tooltipLocation;
    }

    /**
     * true = fade in/out tooltip, false = show/hide tooltip
     * <p>
     * @return Fading
     */
    public Boolean isFadeTooltip()
    {
        return fadeTooltip;
    }

    /**
     * true = fade in/out tooltip, false = show/hide tooltip
     * <p>
     * @param fadeTooltip True or False
     */
    public void setFadeTooltip(Boolean fadeTooltip)
    {
        this.fadeTooltip = fadeTooltip;
    }

    /**
     * number of milliseconds
     * <p>
     * @return Number of milliseconds
     */
    public Integer getTooltipFadeSpeed()
    {
        return tooltipFadeSpeed;
    }

    /**
     * number of milliseconds
     * <p>
     * @param tooltipFadeSpeed The fading speed in milliseconds
     */
    public void setTooltipFadeSpeed(Integer tooltipFadeSpeed)
    {
        this.tooltipFadeSpeed = tooltipFadeSpeed;
    }

    /**
     * Pixel offset of tooltip from the highlight.
     * <p>
     * @return The offset from the highlight
     */
    public Integer getTooltipOffset()
    {
        return tooltipOffset;
    }

    /**
     * Pixel offset of tooltip from the highlight.
     * <p>
     * @param tooltipOffset The offest
     */
    public void setTooltipOffset(Integer tooltipOffset)
    {
        this.tooltipOffset = tooltipOffset;
    }

    /**
     * Which axes to display in tooltip, ‘x’, ‘y’ or ‘both’, ‘xy’ or ‘yx’ ‘both’
     * and ‘xy’ are equivalent, ‘yx’ reverses order of labels.
     * <p>
     * @return The Axes to use
     */
    public String getTooltipAxes()
    {
        return tooltipAxes;
    }

    /**
     * Which axes to display in tooltip, ‘x’, ‘y’ or ‘both’, ‘xy’ or ‘yx’ ‘both’
     * and ‘xy’ are equivalent, ‘yx’ reverses order of labels.
     * <p>
     * @param tooltipAxes
     */
    public void setTooltipAxes(String tooltipAxes)
    {
        this.tooltipAxes = tooltipAxes;
    }

    /**
     * Use the x and y axes formatters to format the text in the tooltip
     * <p>
     * @return The text in the formatters
     */
    public Boolean isUseAxesFormatters()
    {
        return useAxesFormatters;
    }

    /**
     * Use the x and y axes formatters to format the text in the tooltip
     * <p>
     * @param useAxesFormatters True or False
     */
    public void setUseAxesFormatters(Boolean useAxesFormatters)
    {
        this.useAxesFormatters = useAxesFormatters;
    }

    /**
     * sprintf format string for the tooltip.
     * <p>
     * @return The tooltip format string
     */
    public String getTooltipFormatString()
    {
        return tooltipFormatString;
    }

    /**
     * sprintf format string for the tooltip.
     * <p>
     * @param tooltipFormatString The sprintf format for the tooltip
     */
    public void setTooltipFormatString(String tooltipFormatString)
    {
        this.tooltipFormatString = tooltipFormatString;
    }

    /**
     * Alternative to tooltipFormatString will format the whole tooltip text,
     * populating with x, y values as indicated by tooltipAxes option.
     * <p>
     * @return
     */
    public String getFormatString()
    {
        return formatString;
    }

    /**
     * Alternative to tooltipFormatString will format the whole tooltip text,
     * populating with x, y values as indicated by tooltipAxes option.
     * <p>
     * @param formatString The HTML to use as a tooltip
     */
    public void setFormatString(String formatString)
    {
        this.formatString = formatString;
    }

    /**
     * Alternative to tooltipFormatString will format the whole tooltip text,
     * populating with x, y values as indicated by tooltipAxes option.
     * <p>
     * @param formatString The HTML to use as a tooltip
     */
    public void setFormatString(Div formatString)
    {
        this.formatString = formatString.toString(true).toString();
    }

    /**
     * Number of y values to expect in the data point array.
     * <p>
     * @return
     */
    public Integer getYvalues()
    {
        return yvalues;
    }

    /**
     * Number of y values to expect in the data point array.
     * <p>
     * @param yvalues
     */
    public void setYvalues(Integer yvalues)
    {
        this.yvalues = yvalues;
    }

    /**
     * True to bring the series of the highlighted point to the front of other
     * series.
     * <p>
     * @return
     */
    public Boolean isBringSeriesToFront()
    {
        return bringSeriesToFront;
    }

    /**
     * True to bring the series of the highlighted point to the front of other
     * series.
     * <p>
     * @param bringSeriesToFront
     */
    public void setBringSeriesToFront(Boolean bringSeriesToFront)
    {
        this.bringSeriesToFront = bringSeriesToFront;
    }

    /**
     * Sets the marker renderer accordingly
     * <p>
     */
    public void setMarkerRendererOptions(O markerRendererOptions)
    {
        this.markerRenderer = markerRendererOptions.getMarkerRenderer();
        this.markerRendererOptions = markerRendererOptions;
    }

    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }

    /**
     * true to show the highlight.
     *
     * @return
     */
    public Boolean getShow()
    {
        return show;
    }

    /**
     * Return the marker rendering options with the highlighter
     *
     * @return
     */
    public O getMarkerRendererOptions()
    {
        if (markerRendererOptions == null)
        {
            markerRendererOptions = (O) new JQPlotMarkerOptions(getLinkedGraph());
            this.markerRenderer = markerRendererOptions.getMarkerRenderer();
        }
        return markerRendererOptions;
    }

    /**
     * Whether or not to show the marker
     *
     * @return
     */
    public Boolean getShowMarker()
    {
        return showMarker;
    }

    /**
     * Whether or not to show the tooltip
     *
     * @return
     */
    public Boolean getShowTooltip()
    {
        return showTooltip;
    }

    /**
     * whether or not to fade the tooltip
     *
     * @return
     */
    public Boolean getFadeTooltip()
    {
        return fadeTooltip;
    }

    /**
     * Use axes formatters for display or not
     *
     * @return
     */
    public Boolean getUseAxesFormatters()
    {
        return useAxesFormatters;
    }

    /**
     * Always have the series in front
     *
     * @return
     */
    public Boolean getBringSeriesToFront()
    {
        return bringSeriesToFront;
    }

    /**
     * Returns the linked graph with this object
     *
     * @return
     */
    public JQPlotGraph getLinkedGraph()
    {
        return linkedGraph;
    }

    @Override
    public String getRenderer()
    {
        return "$.jqplot.Highlighter";
    }

}
