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
package za.co.mmagon.jwebswing.components.jqPlot;

import org.junit.*;
import za.co.mmagon.jwebswing.*;
import za.co.mmagon.jwebswing.base.servlets.enumarations.*;
import za.co.mmagon.jwebswing.components.jqplot.graphs.*;
import za.co.mmagon.jwebswing.components.jqplot.graphs.display.*;

/**
 *
 * @author GedMarc
 */
public class JQPlotGraphTest
{

    public JQPlotGraphTest()
    {
    }

    @Test
    public void testStructure()
    {
        Page p = new Page();

        p.getBody().add(getNewGraph());
        System.out.println(p.toString(true));
    }

    @Test
    public void testDefaultOptions()
    {
        Page p = new Page();
        p.setID("id");
        p.getBody().setID("body");

        JQPlotBarGraph graph = getNewGraph();
        graph.getOptions().getTitle().setText("1D Bar Graph");
        graph.getOptions().getTitle().setShow(true);
        graph.getCss().getDimensions().setWidth(260);

        graph.getOptions().setAnimate(Boolean.TRUE);
        graph.addBar(new JQPlotBar("Cat 1", 12.0));
        graph.addBar(new JQPlotBar("Cat 2", 14.0));
        graph.addBar(new JQPlotBar("Cat 3", 36.0));
        graph.addBar(new JQPlotBar("Cat 4", 94.0));

        graph.getOptions().getSeriesDefaults().getPointLabels().setShow(Boolean.TRUE);
        graph.getOptions().getHighlighter().setShow(true);
        p.getBody().add(graph);

        System.out.println(p.toString(true));
    }

    @Test
    public void getMultipleCategoryBarGraph()
    {
        Page p = new Page();
        p.setID("id");
        p.getBody().setID("body");

        JQPlotBarGraph graph = getNewGraph();
        graph.getOptions().setAnimate(Boolean.TRUE);
        graph.getCss().getDimensions().setWidth(460);

        graph.addBar(new JQPlotBar("Cat 1", 12.0));
        graph.addBar(new JQPlotBar("Cat 1", 94.0));
        graph.addBar(new JQPlotBar("Cat 1", 65.0));
        graph.addBar(new JQPlotBar("Cat 1", 46.0));

        graph.addBar(new JQPlotBar("Cat 2", 14.0));
        graph.addBar(new JQPlotBar("Cat 2", 36.0));
        graph.addBar(new JQPlotBar("Cat 2", 96.0));
        graph.addBar(new JQPlotBar("Cat 2", 107.0));

        graph.addBar(new JQPlotBar("Cat 3", 17.0));
        graph.addBar(new JQPlotBar("Cat 3", 33.0));
        graph.addBar(new JQPlotBar("Cat 3", 8.0));
        graph.addBar(new JQPlotBar("Cat 3", 26.0));

        graph.addBar(new JQPlotBar("Cat 4", 11.0));
        graph.addBar(new JQPlotBar("Cat 4", 52.0));
        graph.addBar(new JQPlotBar("Cat 4", 78.0));
        graph.addBar(new JQPlotBar("Cat 4", 69.0));

        //graph.getOptions().getSeriesDefaults().getPointLabels().setShow(Boolean.TRUE);
        graph.getOptions().getHighlighter().setShow(true);

        p.getBody().add(graph);

        System.out.println(p.toString(true));

    }

    private JQPlotBarGraph getNewGraph()
    {
        JQPlotBarGraph graph = new JQPlotBarGraph(Orientation.VERTICAL);
        graph.setID("id");

        return graph;
    }

}
