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
package za.co.mmagon.jwebswing.components.jqPlot;

import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.components.jqPlot.references.JQPlotCSSReferencePool;
import za.co.mmagon.jwebswing.components.jqPlot.references.JQPlotJavascriptReferencePool;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * This is the default implementation of the JQPlot Graph Library
 *
 * @author mmagon
 * @since 2014/07/08
 * @version 2.0
 *
 * 2016/02/26 Update to the feature for 1.0.9 and updates to the JavaScript Engine
 */
public class JQPlotGraphFeature extends Feature<JavaScriptPart, Feature> implements JQPlotGraphFeatures, GlobalFeatures
{

    /**
     * The graph this feature is linked to
     */
    private JQPlotGraph graph;

    public JQPlotGraphFeature(JQPlotGraph forGraph)
    {
        super("JWGraphFeature");
        setComponent(forGraph);
        this.graph = forGraph;
        getJavascriptReferences().add(JQPlotJavascriptReferencePool.GraphCore.getReference());
        getCssReferences().add(JQPlotCSSReferencePool.GraphCore.getReference());
        forGraph.addVariable(getVariableName());
    }

    public String getVariableName()
    {
        return graph.getID().replaceAll("-", "_") + "_plot";
    }

    @Override
    public void assignFunctionsToComponent()
    {
        getGraph().addVariable(getVariableName());
        StringBuilder sb = new StringBuilder();

        addQuery("$.jqplot.config.enablePlugins = true;" + getNewLine());

        sb.append("var ").append(getVariableName()).append(" = ");
        sb.append(getComponent().getJQueryID()).append("jqplot(");
        sb.append(graph.getDataPointRender()).append(",").append(getNewLine());
        JavaScriptPart options = getOptions();
        sb.append(getOptions());
        sb.append(");").append(getNewLine());
        addQuery(sb.toString());
    }

    /**
     * Sets the graph for this feature
     *
     * @param graph
     */
    public void setGraph(JQPlotGraph graph)
    {
        this.graph = graph;
    }

    /**
     * Gets the graph with this feature
     *
     * @return
     */
    public JQPlotGraph getGraph()
    {
        return graph;
    }

}
