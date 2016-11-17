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
package za.co.mmagon.jwebswing.components.jqPlot.graphs.display;

import za.co.mmagon.jwebswing.components.jqplot.graphs.display.JQPlotBar;
import org.junit.Test;

/**
 *
 * @author GedMarc
 */
public class JQPlotBarTest
{

    public JQPlotBarTest()
    {
    }

    @Test
    public void testSomeMethod()
    {
        System.out.println("1D Bar");
        JQPlotBar bar = new JQPlotBar("Cat 1", 14.0);
        System.out.println(bar);

        System.out.println("2D Bar");
        bar = new JQPlotBar("Cat 1", "Cluster Bar 1", 1.0);
        JQPlotBar bar2 = new JQPlotBar("Cat 1", "Cluster Bar 2", 1.0);
        System.out.println(bar);
        System.out.println(bar2);

        System.out.println("Waterfall");
        bar = new JQPlotBar("Cat 1", 14.0, 19.0);
        System.out.println(bar);

        System.out.println("Waterfall clustered");
        bar = new JQPlotBar("XAxis", "Cluster Waterfall 1", 15.0, 28.0);
        bar2 = new JQPlotBar("XAxis", "Cluster Waterfall 2", 2.0, 13.0);

        System.out.println(bar);
        System.out.println(bar2);
    }

}
