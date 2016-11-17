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
package za.co.mmagon.jwebswing.components.jqplot.options.axis;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import za.co.mmagon.jwebswing.components.jqplot.JQPlotGraph;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.components.jqplot.parts.interfaces.JQPlotAxisLabelRenderer;

/**
 * The default jqPlot axis renderer, creating a numeric axis.
 *
 * @author GedMarc
 * @since 29 Feb 2016
 */
public class JQPlotAxisLabelRendererOptionsLinearLabels extends JavaScriptPart implements JQPlotAxisLabelRenderer
{

    @JsonIgnore
    private JQPlotGraph linkedGraph;

    /**
     * EXPERIMENTAL!!
     */
    private String breakPoints;
    private String breakTickLabel;//	Label to use at the axis break if breakPoints are specified.
    private Boolean drawBaseline;//	True to draw the axis baseline.
    private Integer baselineWidth;//	width of the baseline in pixels.
    private String baselineColor;//	CSS color spec for the baseline.
    private Boolean forceTickAt0;//	This will ensure that there is always a tick mark at 0.
    private Boolean forceTickAt100;//	This will ensure that there is always a tick mark at 100.
    private Integer tickInset;//	Controls the amount to inset the first and last ticks from the edges of the grid, in multiples of the tick interval.
    private Integer minorTicks;//	Number of ticks to add between “major” ticks.
    private Boolean alignTicks;//	true to align tick marks across opposed axes such as from the y2axis to yaxis.

    /**
     * EXPERIMENTAL!! Use at your own risk! Works only with linear axes and the default tick renderer. Array of [start, stop] points to create a broken axis. Broken axes have a “jump” in them, which
     * is an immediate transition from a smaller value to a larger value. Currently, axis ticks MUST be manually assigned if using breakPoints by using the axis ticks array option.
     *
     * @return
     */
    public String getBreakPoints()
    {
        return breakPoints;
    }

    /**
     * EXPERIMENTAL!! Use at your own risk! Works only with linear axes and the default tick renderer. Array of [start, stop] points to create a broken axis. Broken axes have a “jump” in them, which
     * is an immediate transition from a smaller value to a larger value. Currently, axis ticks MUST be manually assigned if using breakPoints by using the axis ticks array option.
     *
     * @param breakPoints
     */
    public void setBreakPoints(String breakPoints)
    {
        this.breakPoints = breakPoints;
    }

    /**
     * Label to use at the axis break if breakPoints are specified.
     *
     * @return
     */
    public String getBreakTickLabel()
    {
        return breakTickLabel;
    }

    /**
     * Label to use at the axis break if breakPoints are specified.
     *
     * @param breakTickLabel
     */
    public void setBreakTickLabel(String breakTickLabel)
    {
        this.breakTickLabel = breakTickLabel;
    }

    /**
     * True to draw the axis baseline.
     *
     * @return
     */
    public Boolean getDrawBaseline()
    {
        return drawBaseline;
    }

    /**
     * True to draw the axis baseline.
     *
     * @param drawBaseline
     */
    public void setDrawBaseline(Boolean drawBaseline)
    {
        this.drawBaseline = drawBaseline;
    }

    /**
     * width of the baseline in pixels.
     *
     * @return
     */
    public Integer getBaselineWidth()
    {
        return baselineWidth;
    }

    /**
     * width of the baseline in pixels.
     *
     * @param baselineWidth
     */
    public void setBaselineWidth(Integer baselineWidth)
    {
        this.baselineWidth = baselineWidth;
    }

    /**
     * colour of the baseline
     *
     * @return
     */
    public String getBaselineColor()
    {
        return baselineColor;
    }

    /**
     * colour of the baseline
     *
     * @param baselineColor
     */
    public void setBaselineColor(String baselineColor)
    {
        this.baselineColor = baselineColor;
    }

    /**
     * true to always force a tick at 0
     *
     * @return
     */
    public Boolean getForceTickAt0()
    {
        return forceTickAt0;
    }

    /**
     * true to always force a tick at 0
     *
     * @param forceTickAt0
     */
    public void setForceTickAt0(Boolean forceTickAt0)
    {
        this.forceTickAt0 = forceTickAt0;
    }

    /**
     * true to force a tick at 100
     *
     * @return
     */
    public Boolean getForceTickAt100()
    {
        return forceTickAt100;
    }

    /**
     * true to force a tick at 100
     *
     * @param forceTickAt100
     */
    public void setForceTickAt100(Boolean forceTickAt100)
    {
        this.forceTickAt100 = forceTickAt100;
    }

    /**
     * Controls the amount to inset the first and last ticks from the edges of the grid, in multiples of the tick interval. 0 is no inset, 0.5 is one half a tick interval, 1 is a full tick interval,
     * etc.
     *
     * @return
     */
    public Integer getTickInset()
    {
        return tickInset;
    }

    /**
     * Controls the amount to inset the first and last ticks from the edges of the grid, in multiples of the tick interval. 0 is no inset, 0.5 is one half a tick interval, 1 is a full tick interval,
     * etc.
     *
     * @param tickInset
     */
    public void setTickInset(Integer tickInset)
    {
        this.tickInset = tickInset;
    }

    /**
     * Number of ticks to add between “major” ticks. Major ticks are ticks supplied by user or auto computed. Minor ticks cannot be created by user.
     *
     * @return
     */
    public Integer getMinorTicks()
    {
        return minorTicks;
    }

    /**
     * Number of ticks to add between “major” ticks. Major ticks are ticks supplied by user or auto computed. Minor ticks cannot be created by user.
     *
     * @param minorTicks
     */
    public void setMinorTicks(Integer minorTicks)
    {
        this.minorTicks = minorTicks;
    }

    /**
     * true to align tick marks across opposed axes such as from the y2axis to yaxis.
     *
     * @return
     */
    public Boolean getAlignTicks()
    {
        return alignTicks;
    }

    /**
     * true to align tick marks across opposed axes such as from the y2axis to yaxis.
     *
     * @param alignTicks
     */
    public void setAlignTicks(Boolean alignTicks)
    {
        this.alignTicks = alignTicks;
    }

    /**
     * The Default Axis Label Renderer Options
     *
     * @param linkedGraph
     */
    public JQPlotAxisLabelRendererOptionsLinearLabels(JQPlotGraph linkedGraph)
    {
        this.linkedGraph = linkedGraph;
    }

    @JsonProperty("renderer")
    @JsonRawValue
    @Override
    public String getRenderer()
    {
        return "$.jqplot.LinearAxisRenderer";
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
