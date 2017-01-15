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

import com.fasterxml.jackson.annotation.*;
import za.co.mmagon.jwebswing.components.jqplot.JQPlotGraph;
import za.co.mmagon.jwebswing.components.jqplot.parts.interfaces.JQPlotAxisLabelRenderer;
import za.co.mmagon.jwebswing.components.jqplot.parts.interfaces.JQPlotTickRenderer;
import za.co.mmagon.jwebswing.components.jqplot.references.JQPlotJavascriptReferencePool;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 *
 * @author GedMarc
 * @since 29 Feb 2016
 */
public class JQPlotAxisLabelRendererOptionsCategoryLabels<O extends JavaScriptPart & JQPlotTickRenderer> extends JavaScriptPart
        implements JQPlotAxisLabelRenderer
{

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private JQPlotGraph linkedGraph;

    /**
     * The Default Axis Label Renderer Options
     *
     * @param linkedGraph
     */
    public JQPlotAxisLabelRendererOptionsCategoryLabels(JQPlotGraph linkedGraph)
    {
        this.linkedGraph = linkedGraph;
        linkedGraph.getJavascriptReferences().add(JQPlotJavascriptReferencePool.CategoryAxisRenderer.getReference());
    }

    @JsonProperty("renderer")
    @JsonRawValue
    @Override
    public String getRenderer()
    {
        return "$.jqplot.CategoryAxisRenderer";
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
     * True to sort tick labels when labels are created by merging x axis values from multiple series.
     */
    private Boolean sortMergedLabels;
    /**
     * A class of a rendering engine for creating the ticks labels displayed on the plot, See $.jqplot.AxisTickRenderer.
     */
    private O tickRenderer;

    /**
     * True to sort tick labels when labels are created by merging x axis values from multiple series.
     *
     * @return
     */
    public Boolean getSortMergedLabels()
    {
        return sortMergedLabels;
    }

    /**
     * True to sort tick labels when labels are created by merging x axis values from multiple series.
     *
     * @param sortMergedLabels
     */
    public void setSortMergedLabels(Boolean sortMergedLabels)
    {
        this.sortMergedLabels = sortMergedLabels;
    }

    /**
     * A class of a rendering engine for creating the ticks labels displayed on the plot, See $.jqplot.AxisTickRenderer.
     *
     * @return
     */
    public O getTickRenderer()
    {
        return tickRenderer;
    }

    /**
     * A class of a rendering engine for creating the ticks labels displayed on the plot, See $.jqplot.AxisTickRenderer.
     *
     * @param tickRenderer
     */
    public void setTickRenderer(O tickRenderer)
    {
        this.tickRenderer = tickRenderer;
    }

}
