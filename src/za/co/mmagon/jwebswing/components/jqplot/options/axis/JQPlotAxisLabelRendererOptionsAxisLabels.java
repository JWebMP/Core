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
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.components.jqplot.JQPlotGraph;
import za.co.mmagon.jwebswing.components.jqplot.references.JQPlotJavascriptReferencePool;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.components.jqplot.parts.interfaces.JQPlotAxisLabelRenderer;

/**
 *
 * @author GedMarc
 * @since 29 Feb 2016
 */
public class JQPlotAxisLabelRendererOptionsAxisLabels extends JavaScriptPart implements JQPlotAxisLabelRenderer
{

    @JsonIgnore
    private JQPlotGraph linkedGraph;

    /**
     * whether or not to show the tick (mark and label).
     */
    private Boolean show;
    /**
     * The text or html for the label.
     */
    private String label;
    /**
     * true to escape HTML entities in the label.
     */
    private Boolean escapeHTML;

    /**
     * The Default Axis Label Renderer Options
     *
     * @param linkedGraph
     */
    public JQPlotAxisLabelRendererOptionsAxisLabels(JQPlotGraph linkedGraph)
    {
        this.linkedGraph = linkedGraph;
        linkedGraph.getJavascriptReferences().add(JQPlotJavascriptReferencePool.AxisLabelRenderer.getReference());
    }

    @JsonProperty("renderer")
    @JsonRawValue
    @Override
    public String getRenderer()
    {
        return "$.jqplot.AxisLabelRenderer";
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
     * Whether or not to show the axis
     *
     * @return
     */
    public Boolean getShow()
    {
        return show;
    }

    /**
     * Wheter or not to show the axis label
     *
     * @param show
     */
    public void setShow(Boolean show)
    {
        this.show = show;
    }

    /**
     * Gets the label
     *
     * @return
     */
    public String getLabel()
    {
        return label;
    }

    /**
     * Sets the label
     *
     * @param label
     */
    public void setLabel(String label)
    {
        this.label = label;
    }

    /**
     * Sets the label to a component
     *
     * @param label
     */
    public void setLabel(Component label)
    {
        label.setTiny(true);
        this.label = label.toString(true).toString();
        setEscapeHTML(true);
    }

    /**
     * Whether or not to escape the html
     *
     * @return
     */
    public Boolean getEscapeHTML()
    {
        return escapeHTML;
    }

    /**
     * Whether or not to escape html in the label field
     *
     * @param escapeHTML
     */
    public void setEscapeHTML(Boolean escapeHTML)
    {
        this.escapeHTML = escapeHTML;
    }

}
