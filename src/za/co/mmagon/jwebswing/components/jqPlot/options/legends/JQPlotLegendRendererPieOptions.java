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
import za.co.mmagon.jwebswing.components.jqPlot.parts.interfaces.JQPlotLegendPieRenderer;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * Default renderer options, nothing really here
 *
 * @author GedMarc
 * @since 1 Mar 2016
 */
public class JQPlotLegendRendererPieOptions extends JavaScriptPart implements JQPlotLegendPieRenderer
{

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private JQPlotGraph linkedGraph;

    /**
     * The Default Axis Label Renderer Options
     *
     * @param linkedGraph
     */
    public JQPlotLegendRendererPieOptions(JQPlotGraph linkedGraph)
    {
        this.linkedGraph = linkedGraph;
    }

    @JsonProperty("renderer")
    @JsonRawValue
    @JsonIgnore
    @Override
    public String getRenderer()
    {
        return "$.jqplot.PieRenderer";
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
     * Fixed with of legend.
     */
    private Integer width;

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
     * Fixed with of legend.
     *
     * @return
     */
    public Integer getWidth()
    {
        return width;
    }

    /**
     * Fixed with of legend.
     *
     * @param width
     */
    public void setWidth(Integer width)
    {
        this.width = width;
    }

}
