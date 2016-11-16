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
package za.co.mmagon.jwebswing.components.jqxWidgets.chart;

import za.co.mmagon.jwebswing.base.html.Div;

/**
 *
 * jqxChart is a lightweight and powerful chart widget written 100% in javascript.
 * It offers many advanced features and supports three different rendering technologies - SVG, HTML5 Canvas and VML.
 * <p>
 * You can use jqxChart to add interactive charts to your website, build custom dashboards, or use it in your mobile applications.
 * <p>
 * jqxChart offers excellent cross-browser compatibility and works well with both desktop and mobile browsers.
 * jqxChart is being used by thousands of individual developers, small companies as well as a significant percentage of the Furtune 100 companies.
 * <p>
 * Basic concepts
 * Before you start using jqxChart you need to learn how it works and some basic concepts. Depending on which features you use, your chart may contain the following elements:
 * <p>
 * horizontal axis (xAxis)
 * vertical axis (valueAxis)
 * title and description
 * one or more series groups and series
 * grid lines and tick marks
 * legend
 * border line
 * background
 * tooltips
 * annotations
 * range selector
 * <p>
 * <p>
 * Some simple charts may not have all of these elements, while complicated charts could be highly customized and even include additional elements added through custom drawing.
 * <p>
 * @author Marc Magon
 * @since 29 Aug 2015
 * @version 1.0
 */
public class JQXChart extends Div<JQXChartChildren, JQXChartAttributes, JQXChartFeature, JQXChartEvents, JQXChart>
{

    private static final long serialVersionUID = 1L;
    private JQXChartFeature feature;

    public JQXChart()
    {
        addFeature(getFeature());
    }

    public JQXChartFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQXChartFeature(this);
        }
        return feature;
    }

    @Override
    public JQXChartOptions getOptions()
    {
        return getFeature().getOptions();
    }

}
