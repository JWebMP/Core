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
package za.co.mmagon.jwebswing.components.jqplot.graphs;

import java.util.List;
import za.co.mmagon.jwebswing.base.servlets.enumarations.Orientation;
import za.co.mmagon.jwebswing.components.jqplot.graphs.display.JQPlotBar;
import za.co.mmagon.jwebswing.components.jqplot.options.axis.JQPlotAxisLabelRendererOptionsCategoryLabels;
import za.co.mmagon.jwebswing.components.jqplot.parts.YAxisTypes;
import za.co.mmagon.jwebswing.components.jqplot.references.JQPlotJavascriptReferencePool;

/**
 * Constructs a new JQPlotBar Graph default series display
 * <p>
 * @author Marc Magon
 * @since 09 Aug 2015
 * @version 1.0
 */
public class JQPlotBarWaterFallGraph extends JQPlotBarGraph
{

    /**
     * Version 1
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new JQPlotBar Graph default waterfall graph
     * <p>
     * @param orientation Vertical or Horizontal. Configures where to apply the Tick Renderer. Don't ever make this null
     */
    public JQPlotBarWaterFallGraph(Orientation orientation)
    {
        super(orientation);
        setOrientation(orientation);
        setWaterfall(true);
        getJavascriptReferences().add(JQPlotJavascriptReferencePool.BarRenderer.getReference());
        getOptions().getSeriesDefaults().setRendererOptions(barGraphOptions);

        getBarGraphOptions().setWaterfall(true);
        getBarGraphOptions().setVaryBarColor(true);

        getOptions().getSeriesDefaults().getPointLabels().setHideZeros(true);

        getOptions().getSeriesDefaults().setYaxis(YAxisTypes.Y2Axis);

        getOptions().getAxes().getxAxis().setRendererOptions(new JQPlotAxisLabelRendererOptionsCategoryLabels(this));

    }

    @Override
    public void preConfigure()
    {
        super.preConfigure();
        getBarGraphOptions().setFillToZero(null);
    }

    /**
     * Adds a new bar for cluster graphs for each bar value to have a series name
     *
     * @deprecated Not For Waterfalls
     * <p>
     * @param xAxisName The tick or category value
     * @param BarName   The yAxis Value
     * @param barValue  The actual bar value
     *
     */
    @Override
    public void addBar(String xAxisName, String BarName, Double barValue)
    {
        JQPlotBar bar = new JQPlotBar(xAxisName, BarName, barValue);
        setClustered(true);
        bar.setClustered(true);
        addBar(bar);
    }

    /**
     * Adds a new bar and category to the 0 bar group number for waterfall standard graphs
     * <p>
     * @param xAxisName     The tick or category value
     * @param startingPoint The starting point for a bar
     * @param barValue      The actual bar value
     *
     */
    @Override
    public void addBar(String xAxisName, Double startingPoint, Double barValue)
    {
        JQPlotBar bar = new JQPlotBar(xAxisName, startingPoint, barValue);
        barGraphOptions.setWaterfall(true);
        setWaterfall(true);
        addBar(bar);
    }

    /**
     * Adds a new bar and category to the 0 bar group number for waterfall clustered graphs
     * <p>
     * @param xAxisName     The tick or category value
     * @param BarName       The yAxis Value
     * @param startingPoint The starting point for a bar
     * @param barValue      The actual bar value
     *
     */
    @Override
    public void addBar(String xAxisName, String BarName, Double startingPoint, Double barValue)
    {
        JQPlotBar bar = new JQPlotBar(xAxisName, BarName, startingPoint, barValue);
        barGraphOptions.setWaterfall(true);
        setWaterfall(true);
        addBar(bar);
    }

    /**
     * Adds a new bar and category to the 0 bar group number
     *
     * @deprecated Not For Waterfalls
     * <p>
     * @param XAxisValue The tick or category value
     * @param dataValue  The yAxis Value
     */
    public void addBar(String XAxisValue, Double dataValue)
    {
        JQPlotBar bar = new JQPlotBar(XAxisValue, dataValue);
        bar.setWaterfall(true);
        addBar(bar);
    }

    /**
     * Adds a new bar and x Axis to the 0 bar group
     * <p>
     * @param bar The bar to add to the bar group 0
     */
    @Override
    public void addBar(JQPlotBar bar)
    {
        List<JQPlotBar> bars = getBarGroup(bar.getxAxisValue());
        bars.add(bar);
        bar.setWaterfall(true);
        if (!getCategoryTickValues().contains(bar.getxAxisValue()))
        {
            getCategoryTickValues().add(bar.getxAxisValue());
        }
    }

}
