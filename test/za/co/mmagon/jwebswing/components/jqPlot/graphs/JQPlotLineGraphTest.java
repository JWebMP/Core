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
package za.co.mmagon.jwebswing.components.jqPlot.graphs;

import za.co.mmagon.jwebswing.components.jqplot.graphs.JQPlotLineGraph;
import org.junit.Test;

/**
 *
 * @author GedMarc
 */
public class JQPlotLineGraphTest
{

    public JQPlotLineGraphTest()
    {
    }

    @Test
    public void testVeryBasic()
    {

        JQPlotLineGraph graph = new JQPlotLineGraph();
        graph.getOptions().getTitle().setText("Line Graph");
        graph.addLine("0,1,1,2,3,4,5,6,7,8,9,10");
        graph.addLine("0,1,1,2,3,4,5,6,7,8,9,10");

        System.out.println(graph.renderJavascriptAll());

    }

}
