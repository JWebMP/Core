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
package za.co.mmagon.jwebswing.components.jqplot;

import java.util.ArrayList;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.client.BrowserGroups;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.DisplayObjectType;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineBeforeClosingTag;
import za.co.mmagon.jwebswing.base.html.interfaces.children.NoChildren;
import za.co.mmagon.jwebswing.base.references.JavascriptReference;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.components.jqplot.options.JQPlotOptions;
import za.co.mmagon.jwebswing.components.jqplot.references.JQPlotJavascriptReferencePool;
import za.co.mmagon.jwebswing.components.jqueryui.tabs.JQUITabsChildren;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * This class incorporates the JQPlot library from http://www.jqplot.com
 *
 * @author mmagon
 * @since 2014/07/08
 * @version 3.0
 * <p>
 * Changes to how the Renderering and options work together
 *
 * 3.0 2016/02/28 Implementation into Options interface with JavaScriptFunctions as the base
 *
 *
 */
public abstract class JQPlotGraph<O extends JavaScriptPart> 
        extends Component<NoChildren, NoAttributes, JQPlotGraphFeatures, JQPlotGraphEvents, JQPlotGraph>
        implements GlobalChildren, DisplayObjectType, NoNewLineBeforeClosingTag, JQUITabsChildren
{

    /**
     * If version of ie before 9 add the ex canvas script
     */
    @Override
    public void preConfigure()
    {
        super.preConfigure();
        if (getPage() != null && getPage().getBrowser() != null)
        {
            if (getPage().getBrowser().getBrowserGroup() == BrowserGroups.InternetExplorer && getPage().getBrowser().getBrowserVersion() < 9)
            {
                if (!getFeature().getJavascriptReferences().contains(JQPlotJavascriptReferencePool.ExCanvas.getReference()))
                {
                    getFeature().getJavascriptReferences().add(0, JQPlotJavascriptReferencePool.ExCanvas.getReference());
                }
            }
        }
    }

    /**
     * Version 2
     */
    private static final long serialVersionUID = 2L;

    /**
     * All the data points
     */
    protected final ArrayList<Object> dataObjects = new ArrayList<>();

    protected JQPlotGraph()
    {
        super(ComponentTypes.Div);
        addFeature(getFeature());
    }

    /**
     * Renders the data point section on the graph
     * <p>
     * @return The Data Points String
     */
    protected abstract StringBuilder getDataPointRender();

    /**
     * Gets the feature for the graph.
     * Please don't ever return a null. JQPlotGraphFeature is also fine
     * <p>
     * @return
     */
    public JQPlotGraphFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQPlotGraphFeature(this);
        }
        return feature;
    }

    private JQPlotGraphFeature feature;
    private JQPlotOptions<O> options;

    /**
     * Returns the graph options
     * <p>
     * @return
     */
    public JQPlotOptions<O> getOptions()
    {
        if (options == null)
        {
            options = new JQPlotOptions<>(this);
        }
        return options;
    }

    /**
     * Sets the feature for this graph
     *
     * @param feature
     */
    public void setFeature(JQPlotGraphFeature feature)
    {
        this.feature = feature;
    }

    /**
     * Sets the options for this graph
     *
     * @param options
     */
    public void setOptions(JQPlotOptions<O> options)
    {
        this.options = options;
    }

    /**
     * Returns the JavaScriptReferences
     *
     * @return
     */
    public ArrayList<JavascriptReference> getJavascriptReference()
    {
        ArrayList<JavascriptReference> arrs = new ArrayList<>();
        return arrs;
    }

}
