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
package za.co.mmagon.jwebswing.components.jqPlot.options;

import za.co.mmagon.jwebswing.components.jqplot.options.JQPlotOptions;
import org.junit.Test;
import za.co.mmagon.jwebswing.base.servlets.enumarations.Orientation;
import za.co.mmagon.jwebswing.components.jqplot.graphs.JQPlotBarGraph;
import za.co.mmagon.jwebswing.components.jqplot.graphs.display.JQPlotBar;
import za.co.mmagon.jwebswing.components.jqplot.options.series.JQPlotSeriesBarOptions;

/**
 *
 * @author GedMarc
 */
public class JQPlotOptionsTest
{

    public JQPlotOptionsTest()
    {
    }

    @Test
    public void testSomeMethod()
    {
        JQPlotBarGraph graph = new JQPlotBarGraph(Orientation.VERTICAL);

        graph.addBar("meh", 1.0);
        graph.addBar(new JQPlotBar("Cat 2", 14.0));
        graph.addBar(new JQPlotBar("Cat 3", 36.0));
        graph.addBar(new JQPlotBar("Cat 4", 94.0));

        //graph.preRenderTest();
        //JQPlotOptions o = new JQPlotOptions(new JQPlotBarGraph(Orientation.HORIZONTAL));
        JQPlotOptions o = graph.getOptions();
        o.getSeriesDefaults().setColors("123");
        o.setAnimate(true);
        o.getSeriesDefaults().setRendererOptions(new JQPlotSeriesBarOptions(graph));
        o.getSeriesDefaults().getPointLabels().setShow(true);

        //  System.out.println(o);
        System.out.println(graph.renderJavascriptAll());
    }

}
