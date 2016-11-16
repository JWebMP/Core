/*
 * Copyright (C) 2015 GedMarc
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
package za.co.mmagon.jwebswing.components.c3;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.components.c3.options.C3AxisOptions;
import za.co.mmagon.jwebswing.components.c3.options.C3ColourOptions;
import za.co.mmagon.jwebswing.components.c3.options.C3GridOptions;
import za.co.mmagon.jwebswing.components.c3.options.C3InteractionsOptions;
import za.co.mmagon.jwebswing.components.c3.options.C3LegendOptions;
import za.co.mmagon.jwebswing.components.c3.options.C3PaddingOptions;
import za.co.mmagon.jwebswing.components.c3.options.C3PointOptions;
import za.co.mmagon.jwebswing.components.c3.options.C3RegionOptions;
import za.co.mmagon.jwebswing.components.c3.options.C3SizeOptions;
import za.co.mmagon.jwebswing.components.c3.options.C3SubchartOptions;
import za.co.mmagon.jwebswing.components.c3.options.C3TooltipOptions;
import za.co.mmagon.jwebswing.components.c3.options.C3TransitionOptions;
import za.co.mmagon.jwebswing.components.c3.options.C3ZoomOptions;
import za.co.mmagon.jwebswing.components.c3.options.data.C3DataOptions;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * All the options for the C3 Library
 * <p>
 * @author GedMarc
 * @since Mar 9, 2016
 * @version 1.0
 * <p>
 * <p>
 */
public class C3Options extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;

    private String bindto;
    private C3SizeOptions size;
    private C3PaddingOptions padding;
    private C3ColourOptions color;
    private C3InteractionsOptions interaction;
    private C3TransitionOptions transition;

    private C3DataOptions data;
    private C3AxisOptions axis;
    private C3GridOptions grid;
    private C3RegionOptions region;
    private C3LegendOptions legend;
    private C3TooltipOptions tooltip;
    private C3SubchartOptions subchart;
    private C3ZoomOptions zoom;
    private C3PointOptions point;

    //oninit onrendered
    //onmouseover onmouseout
    //onresize onresized
    /**
     * Construct a new C3 Options Object with the component to specify as the bind
     *
     * @param bindTo
     */
    public C3Options(Component bindTo)
    {

    }

    /**
     * The CSS selector or the element which the chart will be set to. D3 selection object can be specified. If other chart is set already, it will be replaced with the new one (only one chart can be
     * set in one element).
     * <p>
     * If this option is not specified, the chart will be generated but not be set. Instead, we can access the element by chart.element and set it by ourselves.
     * Note:
     * <p>
     * When chart is not binded, c3 starts observing if chart.element is binded by MutationObserver. In this case, polyfill is required in IE9 and IE10 becuase they do not support MutationObserver. On
     * the other hand, if chart always will be binded, polyfill will not be required because MutationObserver will never be called.
     * Default:
     * #chart
     *
     * @return
     */
    public String getBindto()
    {
        return bindto;
    }

    /**
     * The CSS selector or the element which the chart will be set to. D3 selection object can be specified. If other chart is set already, it will be replaced with the new one (only one chart can be
     * set in one element).
     * <p>
     * If this option is not specified, the chart will be generated but not be set. Instead, we can access the element by chart.element and set it by ourselves.
     * Note:
     * <p>
     * When chart is not binded, c3 starts observing if chart.element is binded by MutationObserver. In this case, polyfill is required in IE9 and IE10 becuase they do not support MutationObserver. On
     * the other hand, if chart always will be binded, polyfill will not be required because MutationObserver will never be called.
     * Default:
     * #chart
     *
     * @param bindto
     */
    public void setBindto(String bindto)
    {
        this.bindto = bindto;
    }

    /**
     * The CSS selector or the element which the chart will be set to. D3 selection object can be specified. If other chart is set already, it will be replaced with the new one (only one chart can
     * be set in one element)
     * <p>
     * If this option is not specified, the chart will be generated but not be set. Instead, we can access the element by chart.element and set it by ourselves.<p>
     * Note:
     * <p>
     * <p>
     * When chart is not binded, c3 starts observing if chart.element is binded by MutationObserver. In this case, polyfill is required in IE9 and IE10 becuase they do not support MutationObserver.
     * On<p>
     * the other hand, if chart always will be binded, polyfill will not be required because MutationObserver will never be called.<p>
     * Default:
     * <p>
     * #chart<p>
     *
     * @param bindto
     */
    public void setBindto(Component bindto)
    {
        this.bindto = bindto.getID(true);
    }

    /**
     * Gets the size object for the chart, never null
     *
     * @return
     */
    public C3SizeOptions getSize()
    {
        if (size == null)
        {
            size = new C3SizeOptions();
        }
        return size;
    }

    /**
     * Sets the size object for the chart
     *
     * @param size
     */
    public void setSize(C3SizeOptions size)
    {
        this.size = size;
    }

    /**
     * Gets the padding object for the chart
     *
     * @return
     */
    public C3PaddingOptions getPadding()
    {
        if (padding == null)
        {
            padding = new C3PaddingOptions();
        }
        return padding;
    }

    public void setPadding(C3PaddingOptions padding)
    {
        this.padding = padding;
    }

    /**
     * Gets the colour options
     *
     * @return
     */
    public C3ColourOptions getColor()
    {
        if (color == null)
        {
            color = new C3ColourOptions();
        }
        return color;
    }

    /**
     * Sets the colour options
     *
     * @param color
     */
    public void setColor(C3ColourOptions color)
    {
        this.color = color;
    }

    /**
     * Gets the interaction options
     *
     * @return
     */
    public C3InteractionsOptions getInteraction()
    {
        if (interaction == null)
        {
            interaction = new C3InteractionsOptions();
        }
        return interaction;
    }

    /**
     * Sets the interaction object
     *
     * @param interaction
     */
    public void setInteraction(C3InteractionsOptions interaction)
    {
        this.interaction = interaction;
    }

    /**
     * Gets the transition object
     *
     * @return
     */
    public C3TransitionOptions getTransition()
    {
        if (transition == null)
        {
            transition = new C3TransitionOptions();
        }
        return transition;
    }

    /**
     * Sets the current transition
     *
     * @param transition
     */
    public void setTransition(C3TransitionOptions transition)
    {
        this.transition = transition;
    }

    /**
     * Gets the data object
     *
     * @return
     */
    public C3DataOptions getData()
    {
        if (data == null)
        {
            data = new C3DataOptions();
        }
        return data;
    }

    /*
     *
     * Sets the data object
     */
    public void setData(C3DataOptions data)
    {
        this.data = data;
    }

    /**
     * Gets the axis options
     *
     * @return
     */
    public C3AxisOptions getAxis()
    {
        if (axis == null)
        {
            axis = new C3AxisOptions();
        }
        return axis;
    }

    /**
     * Sets the axis options
     *
     * @param axis
     */
    public void setAxis(C3AxisOptions axis)
    {
        this.axis = axis;
    }

    /**
     * Gets the grid options
     *
     * @return
     */
    public C3GridOptions getGrid()
    {
        if (grid == null)
        {
            grid = new C3GridOptions();
        }
        return grid;
    }

    /**
     * Sets the grid options
     *
     * @param grid
     */
    public void setGrid(C3GridOptions grid)
    {
        this.grid = grid;
    }

    /**
     * Gets the region object
     *
     * @return
     */
    public C3RegionOptions getRegion()
    {
        if (region == null)
        {
            region = new C3RegionOptions();
        }
        return region;
    }

    /**
     * Sets the region object
     *
     * @param region
     */
    public void setRegion(C3RegionOptions region)
    {
        this.region = region;
    }

    /**
     * Gets the legend object
     *
     * @return
     */
    public C3LegendOptions getLegend()
    {
        if (legend == null)
        {
            legend = new C3LegendOptions();
        }
        return legend;
    }

    /**
     * Sets the legend object
     *
     * @param legend
     */
    public void setLegend(C3LegendOptions legend)
    {
        this.legend = legend;
    }

    /**
     * Gets the tooltip options
     *
     * @return
     */
    public C3TooltipOptions getTooltip()
    {
        if (tooltip == null)
        {
            tooltip = new C3TooltipOptions();
        }
        return tooltip;
    }

    /**
     * Sets the tooltip options
     *
     * @param tooltip
     */
    public void setTooltip(C3TooltipOptions tooltip)
    {
        this.tooltip = tooltip;
    }

    /**
     * Gets the subchart object.
     * Creates a new one if one is not found, and adds the required js file to the build
     *
     * @return
     */
    public C3SubchartOptions getSubchart()
    {
        if (subchart == null)
        {
            subchart = new C3SubchartOptions();
        }
        return subchart;
    }

    /**
     * Gets the subchart object.
     * Creates a new one if one is not found, and adds the required js file to the build
     *
     * @param subchart
     */
    public void setSubchart(C3SubchartOptions subchart)
    {
        this.subchart = subchart;
    }

    /**
     * Gets the zoom object. Adds the required js file
     *
     * @return
     */
    public C3ZoomOptions getZoom()
    {
        if (zoom == null)
        {
            zoom = new C3ZoomOptions();
        }
        return zoom;
    }

    /**
     * Sets the zoom object, adds the required js file
     *
     * @param zoom
     */
    public void setZoom(C3ZoomOptions zoom)
    {
        this.zoom = zoom;
    }

    /**
     * Whether to show each point in line
     *
     * @return
     */
    public C3PointOptions getPoint()
    {
        if (this.point == null)
        {
            this.point = new C3PointOptions();
        }
        return point;
    }

    /**
     * Whether to show each point in line
     *
     * @param point
     */
    public void setPoint(C3PointOptions point)
    {
        this.point = point;
    }

}
