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
package za.co.mmagon.jwebswing.components.jqPlot.options.legends;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import za.co.mmagon.jwebswing.components.jqPlot.JQPlotGraph;
import za.co.mmagon.jwebswing.components.jqPlot.parts.interfaces.JQPlotLegendRenderer;
import za.co.mmagon.jwebswing.components.jqPlot.references.JQPlotJavascriptReferencePool;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * @author GedMarc
 * @since 1 Mar 2016
 */
public class JQPlotLegendRendererEnhancedOptions extends JavaScriptPart implements JQPlotLegendRenderer
{

    @JsonIgnore
    private JQPlotGraph linkedGraph;

    /**
     * The Default Axis Label Renderer Options
     *
     * @param linkedGraph
     */
    public JQPlotLegendRendererEnhancedOptions(JQPlotGraph linkedGraph)
    {
        this.linkedGraph = linkedGraph;
        linkedGraph.getJavascriptReferences().add(JQPlotJavascriptReferencePool.EnhancedLegenedRenderer.getReference());
    }

    @JsonProperty("renderer")
    @JsonRawValue
    @JsonIgnore
    @Override
    public String getRenderer()
    {
        return "$.jqplot.EnhancedLegendRenderer";
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
     * Maximum number of rows in the legend.
     */
    private Integer numberRows;
    /**
     * Maximum number of columns in the legend.
     */
    private Integer numberColumns;
    /**
     * false to not enable series on/off toggling on the legend.
     */
    private Boolean seriesToggle;
    /**
     * True to replot the chart after toggling series on/off.
     */
    private Boolean seriesToggleReplot;
    /**
     * true to toggle series with a show/hide method only and not allow fading in/out.
     */
    private Boolean disableIEFading;

    /**
     * Maximum number of rows in the legend.
     *
     * @return
     */
    public Integer getNumberRows()
    {
        return numberRows;
    }

    /**
     * Maximum number of rows in the legend.
     *
     * @param numberRows
     */
    public void setNumberRows(Integer numberRows)
    {
        this.numberRows = numberRows;
    }

    /**
     * Maximum number of columns in the legend.
     *
     * @return
     */
    public Integer getNumberColumns()
    {
        return numberColumns;
    }

    /**
     * Maximum number of columns in the legend.
     *
     * @param numberColumns
     */
    public void setNumberColumns(Integer numberColumns)
    {
        this.numberColumns = numberColumns;
    }

    /**
     * false to not enable series on/off toggling on the legend.
     *
     * @return
     */
    public Boolean getSeriesToggle()
    {
        return seriesToggle;
    }

    /**
     * false to not enable series on/off toggling on the legend.
     *
     * @param seriesToggle
     */
    public void setSeriesToggle(Boolean seriesToggle)
    {
        this.seriesToggle = seriesToggle;
    }

    /**
     * True to replot the chart after toggling series on/off.
     *
     * @return
     */
    public Boolean getSeriesToggleReplot()
    {
        return seriesToggleReplot;
    }

    /**
     * True to replot the chart after toggling series on/off.
     *
     * @param seriesToggleReplot
     */
    public void setSeriesToggleReplot(Boolean seriesToggleReplot)
    {
        this.seriesToggleReplot = seriesToggleReplot;
    }

    /**
     * true to toggle series with a show/hide method only and not allow fading in/out.
     *
     * @return
     */
    public Boolean getDisableIEFading()
    {
        return disableIEFading;
    }

    /**
     * true to toggle series with a show/hide method only and not allow fading in/out.
     *
     * @param disableIEFading
     */
    public void setDisableIEFading(Boolean disableIEFading)
    {
        this.disableIEFading = disableIEFading;
    }

}
