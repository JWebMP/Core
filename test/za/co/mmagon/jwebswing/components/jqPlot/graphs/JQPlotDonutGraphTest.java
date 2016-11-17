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

import za.co.mmagon.jwebswing.components.jqplot.graphs.JQPlotDonutGraph;
import org.junit.Test;

/**
 *
 * @author GedMarc
 */
public class JQPlotDonutGraphTest
{

    public JQPlotDonutGraphTest()
    {
    }

    @Test
    public void testSomeMethod()
    {
        JQPlotDonutGraph graph = new JQPlotDonutGraph();
        //graph.addSlice(0, "Name 1", 0);

        double line[] = new double[]
        {
            7, 13.3, 14.7, 5.2, 1.2
        };
        double line2[] = new double[]
        {
            7, 13.3, 14.7, 5.2, 1.2
        };

        graph.addSlices(0, line);
        graph.addSlices(1, line2);

        System.out.println(graph.toString(true));

        System.out.println(graph.toString(true));
        System.out.println(graph.renderJavascriptAll());
    }

}
