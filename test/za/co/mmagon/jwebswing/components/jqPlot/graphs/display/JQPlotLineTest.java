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

import za.co.mmagon.jwebswing.components.jqplot.graphs.display.JQPlotLine;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author GedMarc
 */
public class JQPlotLineTest
{

    public JQPlotLineTest()
    {
    }

    @Test
    public void testBasicPlotline()
    {
        JQPlotLine pl = new JQPlotLine(1);
        System.out.println(pl);
        Assert.assertEquals(pl.toString(), "[[0,1.0]]");

        pl.addPoint(2);
        System.out.println(pl);
        Assert.assertEquals(pl.toString(), "[[0,1.0], [1,2.0]]");

        pl.addPoint("X", 1);
        System.out.println(pl);
        Assert.assertEquals(pl.toString(), "[[0,1.0], [1,2.0], ['X',1.0]]");

    }

}
