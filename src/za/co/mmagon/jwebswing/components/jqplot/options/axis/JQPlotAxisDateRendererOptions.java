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
 * along with this program.  If not, see &lt;http://www.gnu.org/licenses/&gt;.
 */
package za.co.mmagon.jwebswing.components.jqplot.options.axis;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import za.co.mmagon.jwebswing.components.jqplot.JQPlotGraph;
import za.co.mmagon.jwebswing.components.jqplot.parts.interfaces.JQPlotAxisRenderer;
import za.co.mmagon.jwebswing.components.jqplot.parts.interfaces.JQPlotTickRenderer;
import za.co.mmagon.jwebswing.components.jqplot.references.JQPlotJavascriptReferencePool;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * A plugin for a jqPlot to render an axis as a series of date values. This renderer has no options beyond those supplied by the Axis class. It supplies its own tick formatter, so the
 * tickOptions.formatter option should not be overridden.
 * <p>
 * Thanks to Ken Synder for his enhanced Date instance methods which are included with this code http://kendsnyder.com/sandbox/date/.
 * <p>
 * To use this renderer, include the plugin in your source
 * <p>
 * &lt;script type="text/javascript" language="javascript" src="plugins/jqplot.dateAxisRenderer.js"&gt;&lt;/script&gt;
 * <p>
 * and supply the appropriate options to your plot
 * <p>
 * {axes:{xaxis:{renderer:$.jqplot.DateAxisRenderer}}}
 * <p>
 * Dates can be passed into the axis in almost any recognizable value and will be parsed. They will be rendered on the axis in the format specified by tickOptions.formatString. e.g.
 * tickOptions.formatString = ‘%Y-%m-%d’.
 * <p>
 * Accecptable format codes are:
 * <p>
 * Code Result Description
 * == Years ==
 * %Y 2008 Four-digit year
 * %y 08 Two-digit year
 * == Months ==
 * %m 09 Two-digit month
 * %#m 9 One or two-digit month
 * %B September Full month name
 * %b Sep Abbreviated month name
 * == Days ==
 * %d 05 Two-digit day of month
 * %#d 5 One or two-digit day of month
 * %e 5 One or two-digit day of month
 * %A Sunday Full name of the day of the week
 * %a Sun Abbreviated name of the day of the week
 * %w 0 Number of the day of the week (0 = Sunday, 6 = Saturday)
 * %o th The ordinal suffix string following the day of the month
 * == Hours ==
 * %H 23 Hours in 24-hour format (two digits)
 * %#H 3 Hours in 24-hour integer format (one or two digits)
 * %I 11 Hours in 12-hour format (two digits)
 * %#I 3 Hours in 12-hour integer format (one or two digits)
 * %p PM AM or PM
 * == Minutes ==
 * %M 09 Minutes (two digits)
 * %#M 9 Minutes (one or two digits)
 * == Seconds ==
 * %S 02 Seconds (two digits)
 * %#S 2 Seconds (one or two digits)
 * %s 1206567625723 Unix timestamp (Seconds past 1970-01-01 00:00:00)
 * == Milliseconds ==
 * %N 008 Milliseconds (three digits)
 * %#N 8 Milliseconds (one to three digits)
 * == Timezone ==
 * %O 360 difference in minutes between local time and GMT
 * %Z Mountain Standard Time Name of timezone as reported by browser
 * %G -06:00 Hours and minutes between GMT
 * == Shortcuts ==
 * %F 2008-03-26 %Y-%m-%d
 * %T 05:06:30 %H:%M:%S
 * %X 05:06:30 %H:%M:%S
 * %x 03/26/08 %m/%d/%y
 * %D 03/26/08 %m/%d/%y
 * %#c Wed Mar 26 15:31:00 2008 %a %b %e %H:%M:%S %Y
 * %v 3-Sep-2008 %e-%b-%Y
 * %R 15:31 %H:%M
 * %r 3:31:00 PM %I:%M:%S %p
 * == Characters ==
 * %n \n Newline
 * %t \t Tab
 * %% % Percent Symbol
 *
 * @author GedMarc
 * @since 29 Feb 2016
 */
public class JQPlotAxisDateRendererOptions extends JavaScriptPart implements JQPlotAxisRenderer
{

    @JsonIgnore
    private JQPlotGraph linkedGraph;

    /**
     * The Default Axis Label Renderer Options
     *
     * @param linkedGraph
     */
    public JQPlotAxisDateRendererOptions(JQPlotGraph linkedGraph)
    {
        this.linkedGraph = linkedGraph;
        linkedGraph.getJavascriptReferences().add(JQPlotJavascriptReferencePool.DateAxisRenderer.getReference());
    }

    @JsonProperty("renderer")
    @JsonRawValue
    @JsonIgnore
    @Override
    public String getRenderer()
    {
        return "$.jqplot.DateAxisRenderer";
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
     * A class of a rendering engine for creating the ticks labels displayed on the plot, See $.jqplot.AxisTickRenderer.
     */
    private JQPlotTickRenderer tickRenderer;
    /**
     * Controls the amount to inset the first and last ticks from the edges of the grid, in multiples of the tick interval.
     */
    private Integer tickInset;
    /**
     * True to draw the axis baseline.
     */
    private Boolean drawBaseline;
    /**
     * width of the baseline in pixels.
     */
    private Integer baselineWidth;
    /**
     * CSS color spec for the baseline.
     */
    private String baselineColor;

    /**
     * A class of a rendering engine for creating the ticks labels displayed on the plot, See $.jqplot.AxisTickRenderer.
     *
     * @return
     */
    public JQPlotTickRenderer getTickRenderer()
    {
        return tickRenderer;
    }

    /**
     * A class of a rendering engine for creating the ticks labels displayed on the plot, See $.jqplot.AxisTickRenderer.
     *
     * @param tickRenderer
     */
    public void setTickRenderer(JQPlotTickRenderer tickRenderer)
    {
        this.tickRenderer = tickRenderer;
    }

    /**
     * Controls the amount to inset the first and last ticks from the edges of the grid, in multiples of the tick interval.
     *
     * @return
     */
    public Integer getTickInset()
    {
        return tickInset;
    }

    /**
     * Controls the amount to inset the first and last ticks from the edges of the grid, in multiples of the tick interval.
     *
     * @param tickInset
     */
    public void setTickInset(Integer tickInset)
    {
        this.tickInset = tickInset;
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
     * CSS color spec for the baseline.
     *
     * @return
     */
    public String getBaselineColor()
    {
        return baselineColor;
    }

    /**
     * CSS color spec for the baseline.
     *
     * @param baselineColor
     */
    public void setBaselineColor(String baselineColor)
    {
        this.baselineColor = baselineColor;
    }

}
