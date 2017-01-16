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
package za.co.mmagon.jwebswing.components.jqplot.options.axis;

import com.fasterxml.jackson.annotation.*;
import java.util.List;
import za.co.mmagon.jwebswing.components.jqplot.JQPlotGraph;
import za.co.mmagon.jwebswing.components.jqplot.options.ticks.JQPlotTickOptionsAxisTick;
import za.co.mmagon.jwebswing.components.jqplot.parts.interfaces.JQPlotAxisLabelRenderer;
import za.co.mmagon.jwebswing.components.jqplot.parts.interfaces.JQPlotTickRenderer;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourHex;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 *
 * @author Marc Magon
 * @since 07 Aug 2015
 * @version 1.0
 */
public class JQPlotAxisOptions<O extends JavaScriptPart & JQPlotAxisLabelRenderer>
        extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;
    @JsonIgnore
    private JQPlotGraph linkedGraph;
    /**
     * whether or not to renderer the axis. Determined automatically.
     */
    private Boolean show;
    /**
     * Whether or not to show a label
     */
    private Boolean showLabel;
    /**
     * Auto-Scale the axis min and max values to provide sensible tick spacing.
     */
    private Boolean autoscale;
    /**
     * minimum numerical value of the axis. Determined automatically.
     */
    private Integer min;
    /**
     * maximum num vertical value of the axis. Determined automatically.
     */
    private Integer max;
    /**
     * a factor multiplied by the data range on the axis to give the
     */
    private Double pad;
    /**
     * axis range so that data points don't fall on the edges of the axis. a 1D [val1, val2, ...], or 2D [[val, label], [val, label], ...]
     */
    @JsonIgnore
    private List<String> ticks;
    /**
     * array of ticks to use. Computed automatically.
     */
    private Integer numberTicks;
    /**
     * array of ticks to use. Computed automatically.
     */
    private Integer tickInterval;
    /**
     * renderer to use to draw the axis,
     */
    // @JsonRawValue
    //private String renderer;

    //private JavaScriptPart rendererOptions;
    /**
     * whether or not to show the tick labels, Wether to show the ticks (both marks and labels) or not.
     */
    private Boolean showTicks;
    /**
     * Whether or not to show the tick marks Wether to show the tick marks (line crossing grid) or not.
     */
    private Boolean showTickMarks;
    /**
     * A class of a rendering engine for creating the ticks labels displayed on the plot, See $.jqplot.AxisTickRenderer.
     */
    @JsonRawValue
    private String tickRenderer;
    /**
     * The options associated with the tick renderer
     */
    @JsonProperty("tickOptions")
    private JavaScriptPart tickRendererOptions;

    /**
     * The specific renderer options
     */
    @JsonProperty("rendererOptions")
    private O rendererOptions;
    /**
     * Label for the axis
     */
    private String label;

    /**
     * Padding to extend the range above data bounds.
     */
    private Integer padMax;
    /**
     * Padding to extend the range below data bounds.
     */
    private Integer padMin;

    /**
     * Whether or not to show minor ticks.
     */
    private Boolean showMinorTicks;
    /**
     * Use the color of the first series associated with this axis for the tick marks and line bordering this axis.
     */
    private Boolean useSeriesColor;
    /**
     * width of line stroked at the border of the axis.
     */
    private Integer borderWidth;
    /**
     * color of the border adjacent to the axis.
     */
    private String borderColor;
    /**
     * true to try and synchronize tick spacing across multiple axes so that ticks and grid lines line up.
     */
    private Boolean syncTicks;
    /**
     * Approximate pixel spacing between ticks on graph.
     */
    private Integer tickSpacing;

    /**
     * The linked graph
     *
     * @param linkedGraph
     */
    public JQPlotAxisOptions(JQPlotGraph linkedGraph)
    {
        this.linkedGraph = linkedGraph;
    }

    /**
     * Returns the linked graph to this options
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
     * Whether or not to show the axis
     * <p>
     * @return
     */
    public Boolean getShow()
    {
        return show;
    }

    /**
     * Whether or not to show the axis
     * <p>
     * @param show
     */
    public void setShow(Boolean show)
    {
        this.show = show;
    }

    /**
     * Whether or not to show a label
     * <p>
     * @return
     */
    public Boolean getShowLabel()
    {
        return showLabel;
    }

    /**
     * Whether or not to show a label
     * <p>
     * @param showLabel
     */
    public void setShowLabel(Boolean showLabel)
    {
        this.showLabel = showLabel;
    }

    /**
     * Autoscale the axis min and max values to provide sensible tick spacing.
     * <p>
     * @return
     */
    public Boolean getAutoscale()
    {
        return autoscale;
    }

    /**
     * Autoscale the axis min and max values to provide sensible tick spacing.
     * <p>
     * @param autoscale
     */
    public void setAutoscale(Boolean autoscale)
    {
        this.autoscale = autoscale;
    }

    /**
     * minimum numerical value of the axis. Determined automatically.
     * <p>
     * @return
     */
    public Integer getMin()
    {
        return min;
    }

    /**
     * minimum numerical value of the axis. Determined automatically.
     * <p>
     * @param min
     */
    public void setMin(Integer min)
    {
        this.min = min;
    }

    /**
     * maximum num vertical value of the axis. Determined automatically
     * <p>
     * @return
     */
    public Integer getMax()
    {
        return max;
    }

    /**
     * maximum num vertical value of the axis. Determined automatically
     * <p>
     * @param max
     */
    public void setMax(Integer max)
    {
        this.max = max;
    }

    /**
     * a factor multiplied by the data range on the axis to give the
     * <p>
     * @return
     */
    public Double getPad()
    {
        return pad;
    }

    /**
     * a factor multiplied by the data range on the axis to give the
     * <p>
     * @param pad
     */
    public void setPad(Double pad)
    {
        this.pad = pad;
    }

    /**
     * axis range so that data points don't fall on the edges of the axis. a 1D [val1, val2, ...], or 2D [[val, label], [val, label], ...]
     * <p>
     * @return
     */
    @JsonProperty("ticks")
    public List<String> getTicks()
    {
        return ticks;
    }

    /**
     * axis range so that data points don't fall on the edges of the axis. a 1D [val1, val2, ...], or 2D [[val, label], [val, label], ...]
     * <p>
     * @param ticks
     */
    public void setTicks(List<String> ticks)
    {
        this.ticks = ticks;
    }

    /**
     * array of ticks to use. Computed automatically.
     * <p>
     * @return
     */
    public Integer getNumberTicks()
    {
        return numberTicks;
    }

    /**
     * array of ticks to use. Computed automatically.
     * <p>
     * @param numberTicks
     */
    public void setNumberTicks(Integer numberTicks)
    {
        this.numberTicks = numberTicks;
    }

    /**
     * array of ticks to use. Computed automatically.
     * <p>
     * @return
     */
    public Integer getTickInterval()
    {
        return tickInterval;
    }

    /**
     * array of ticks to use. Computed automatically.
     * <p>
     * @param tickInterval
     */
    public void setTickInterval(Integer tickInterval)
    {
        this.tickInterval = tickInterval;
    }

    /**
     * renderer to use to draw the axis,
     * <p>
     * @return
     */
    // public String getRenderer()
    // {
    //    return renderer;
    // }
    /**
     * renderer to use to draw the axis,
     * <p>
     * @param renderer
     */
    //  public void setRenderer(JWGraphAxisRenderers renderer)
    //  {
    //      this.renderer = renderer.getRendererString();
    //      this.rendererOptions = renderer.getOptions();
    //  }
    /**
     * Whether to show the ticks (both marks and labels) or not.
     * <p>
     * @return
     */
    public Boolean getShowTicks()
    {
        return showTicks;
    }

    /**
     * Whether to show the ticks (both marks and labels) or not.
     * <p>
     * @param showTicks
     */
    public void setShowTicks(Boolean showTicks)
    {
        this.showTicks = showTicks;
    }

    /**
     * Whether to show the tick marks (line crossing grid) or not.
     * <p>
     * @return
     */
    public Boolean getShowTickMarks()
    {
        return showTickMarks;
    }

    /**
     * Whether to show the tick marks (line crossing grid) or not.
     * <p>
     * @param showTickMarks
     */
    public void setShowTickMarks(Boolean showTickMarks)
    {
        this.showTickMarks = showTickMarks;
    }

    /**
     * A class of a rendering engine for creating the ticks labels displayed on the plot, See $.jqplot.AxisTickRenderer.
     * <p>
     * @return
     */
    public String getTickRenderer()
    {
        return tickRenderer;
    }

    /**
     * Get Tick Renderer Options Default JQPlotTickOptionsAxisTick
     *
     * @return
     */
    public JavaScriptPart getTickRendererOptions()
    {
        if (tickRendererOptions == null)
        {
            tickRendererOptions = new JQPlotTickOptionsAxisTick();
        }
        return tickRendererOptions;
    }

    /**
     * Set the tick renderer
     *
     * @param <O>                 A Valid Tick Renderer
     * @param tickRendererOptions The Actual Options Class
     */
    public <O extends JavaScriptPart & JQPlotTickRenderer> void setTickRendererOptions(O tickRendererOptions)
    {
        this.tickRenderer = tickRendererOptions.getRenderer();
        this.tickRendererOptions = tickRendererOptions;
    }

    /**
     * Label for the axis
     * <p>
     * @return
     */
    public String getLabel()
    {
        return label;
    }

    /**
     * Label for the axis
     * <p>
     * @param label
     */
    public void setLabel(String label)
    {
        this.label = label;
    }

    /**
     * Padding to extend the range above data bounds.
     * <p>
     * @return
     */
    public Integer getPadMax()
    {
        return padMax;
    }

    /**
     * Padding to extend the range above data bounds.
     * <p>
     * @param padMax
     */
    public void setPadMax(Integer padMax)
    {
        this.padMax = padMax;
    }

    /**
     * Padding to extend the range below data bounds.
     * <p>
     * @return
     */
    public Integer getPadMin()
    {
        return padMin;
    }

    /**
     * Padding to extend the range below data bounds.
     * <p>
     * @param padMin
     */
    public void setPadMin(Integer padMin)
    {
        this.padMin = padMin;
    }

    /**
     * Whether or not to show minor ticks.
     * <p>
     * @return
     */
    public Boolean getShowMinorTicks()
    {
        return showMinorTicks;
    }

    /**
     * Whether or not to show minor ticks.
     * <p>
     * @param showMinorTicks
     */
    public void setShowMinorTicks(Boolean showMinorTicks)
    {
        this.showMinorTicks = showMinorTicks;
    }

    /**
     * Use the color of the first series associated with this axis for the tick marks and line bordering this axis.
     * <p>
     * @return
     */
    public Boolean getUseSeriesColor()
    {
        return useSeriesColor;
    }

    /**
     * Use the color of the first series associated with this axis for the tick marks and line bordering this axis.
     * <p>
     * @param useSeriesColor
     */
    public void setUseSeriesColor(Boolean useSeriesColor)
    {
        this.useSeriesColor = useSeriesColor;
    }

    /**
     * width of line stroked at the border of the axis.
     * <p>
     * @return
     */
    public Integer getBorderWidth()
    {
        return borderWidth;
    }

    /**
     * width of line stroked at the border of the axis.
     * <p>
     * @param borderWidth
     */
    public void setBorderWidth(Integer borderWidth)
    {
        this.borderWidth = borderWidth;
    }

    /**
     * color of the border adjacent to the axis.
     * <p>
     * @return
     */
    public String getBorderColor()
    {
        return borderColor;
    }

    /**
     * color of the border adjacent to the axis.
     * <p>
     * @param borderColor
     */
    public void setBorderColor(ColourHex borderColor)
    {
        this.borderColor = borderColor.getValue();
    }

    /**
     * true to try and synchronize tick spacing across multiple axes so that ticks and grid lines line up.
     * <p>
     * @return
     */
    public Boolean getSyncTicks()
    {
        return syncTicks;
    }

    /**
     * true to try and synchronize tick spacing across multiple axes so that ticks and grid lines line up.
     * <p>
     * @param syncTicks
     */
    public void setSyncTicks(Boolean syncTicks)
    {
        this.syncTicks = syncTicks;
    }

    /**
     * Approximate pixel spacing between ticks on graph.
     * <p>
     * @return
     */
    public Integer getTickSpacing()
    {
        return tickSpacing;
    }

    /**
     * Approximate pixel spacing between ticks on graph.
     * <p>
     * @param tickSpacing
     */
    public void setTickSpacing(Integer tickSpacing)
    {
        this.tickSpacing = tickSpacing;
    }

    /**
     * Returns the assigned axis renderer options
     *
     * @return
     */
    public O getRendererOptions()
    {
        return rendererOptions;
    }

    /**
     * The the options
     * <p>
     * @param rendererOptions
     */
    public void setRendererOptions(O rendererOptions)
    {
        this.rendererOptions = rendererOptions;
        this.renderer = rendererOptions.getRenderer();
    }

    @JsonRawValue
    private String renderer;

    /**
     * Returns the renderer
     *
     * @return
     */
    public String getRenderer()
    {
        return renderer;
    }

    /**
     * The physical label renderer
     */
    @JsonRawValue
    private String labelRenderer;

    /**
     * Returns the label renderer options
     */
    private JQPlotAxisLabelRenderer labelRendererOptions;

    /**
     * Sets the label renderer options
     *
     * @param labelRendererOptions
     */
    public void setLabelRendererOptions(JQPlotAxisLabelRenderer labelRendererOptions)
    {
        this.labelRendererOptions = labelRendererOptions;
        this.labelRenderer = labelRendererOptions.getRenderer();
    }

    /**
     * Gets the label renderer options JQPlotAxisLabelRendererOptionsCanvasLabels by default
     *
     * @return
     */
    public JQPlotAxisLabelRenderer getLabelRendererOptions()
    {
        if (labelRendererOptions == null)
        {
            setLabelRendererOptions(new JQPlotAxisLabelRendererOptionsCanvasLabels(getLinkedGraph()));
        }
        return labelRendererOptions;
    }

    /**
     * Returns the label renderer string assigned with this axis plot
     *
     * @return
     */
    public String getLabelRenderer()
    {
        return labelRenderer;
    }

}
