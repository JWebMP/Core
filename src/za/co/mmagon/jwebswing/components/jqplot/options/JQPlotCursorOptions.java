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
package za.co.mmagon.jwebswing.components.jqplot.options;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;
import za.co.mmagon.jwebswing.components.jqplot.JQPlotGraph;
import za.co.mmagon.jwebswing.components.jqplot.parts.interfaces.JQPlotRendererDefault;
import za.co.mmagon.jwebswing.components.jqplot.references.JQPlotJavascriptReferencePool;
import za.co.mmagon.jwebswing.generics.XYObject;
import za.co.mmagon.jwebswing.htmlbuilder.css.displays.Cursors;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * The Cursor Plugin for the JQuery Plot Library
 *
 * @author mmagon
 * @since 2014/07/09
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class JQPlotCursorOptions extends JavaScriptPart implements JQPlotRendererDefault
{

    private static final long serialVersionUID = 1L;

    /**
     * CSS spec for cursor style
     */
    private Cursors style;
    /**
     * Whether to show the cursor or not.
     */
    private Boolean show;
    /**
     * Show tooltip or not
     */
    private Boolean showTooltip;
    /**
     * Tooltip follows the mouse, it is not at a fixed location.
     */
    private Boolean followMouse;
    /**
     * Where to position tooltip.
     */
    private String tooltipLocation;
    /**
     * Pixel offset of tooltip from the grid boudaries or cursor center.
     */
    private Integer tooltipOffset;
    /**
     * show the grid pixel coordinates of the mouse.
     */
    private Boolean showTooltipGridPosition;
    /**
     * show the unit (data) coordinates of the mouse.
     */
    private Boolean showTooltipUnitPosition;
    /**
     * Used with showVerticalLine to show intersecting data points in the tooltip.
     */
    private Boolean showTooltipDataPosition;
    /**
     * sprintf format string for the tooltip.
     */
    private String tooltipFormatString;
    /**
     * Use the x and y axes formatters to format the text in the tooltip.
     */
    private Boolean useAxesFormatters;

    /**
     * Show position for the specified axes<p>
     * This is an array like [[‘xaxis’, ‘yaxis’], [‘xaxis’, ‘y2axis’]] Default is to compute automatically for all visible axes.
     */
    private ArrayList<XYObject> tooltipAxisGroups;
    /**
     * Enable plot zooming.
     */
    private Boolean zoom;
    /**
     * Will expand zoom range to provide more rounded tick values.
     */
    private Boolean looseZoom;
    /**
     * Will reset plot zoom if single click on plot without drag.
     */
    private Boolean clickReset;
    /**
     * Will reset plot zoom if double click on plot without drag.
     */
    private Boolean dblClickReset;
    /**
     * draw a vertical line across the plot which follows the cursor.
     */
    private Boolean showVerticalLine;
    /**
     * draw a horizontal line across the plot which follows the cursor.
     */
    private Boolean showHorizontalLine;
    /**
     * ‘none’, ‘x’ or ‘y’
     */
    private String constrainZoomTo;
    /**
     * pixel distance from data point or marker to consider cursor lines intersecting with point.
     */
    private Integer intersectionThreshold;
    /**
     * Replace the plot legend with an enhanced legend displaying intersection information.
     */
    private Boolean showCursorLegend;
    /**
     * Format string used in the cursor legend.
     */
    private String cursorLegendFormatString;
    /**
     * True to limit actual zoom area to edges of grid, even when zooming outside of plot area.
     */
    private Boolean constrainOutsideZoom;
    /**
     * True will keep updating the tooltip when zooming of the grid.
     */
    private Boolean showTooltipOutsideZoom;

    @JsonIgnore
    private JQPlotGraph linkedGraph;

    /**
     * Constructs a new instance of the cursor object
     *
     * @param linkedGraph
     */
    public JQPlotCursorOptions(JQPlotGraph linkedGraph)
    {
        this.linkedGraph = linkedGraph;
        if (linkedGraph != null)
        {
            this.linkedGraph.getJavascriptReferences().add(JQPlotJavascriptReferencePool.CursorRenderer.getReference());
        }
    }

    /**
     * Gets the linked graph
     *
     * @return
     */
    public JQPlotGraph getLinkedGraph()
    {
        return linkedGraph;
    }

    /**
     * Set the linked graph and adds the reference
     *
     * @param linkedGraph
     */
    public void setLinkedGraph(JQPlotGraph linkedGraph)
    {
        if (this.linkedGraph != null)
        {
            this.linkedGraph.getJavascriptReferences().remove(JQPlotJavascriptReferencePool.CursorRenderer.getReference());
        }
        this.linkedGraph = linkedGraph;
        this.linkedGraph.getJavascriptReferences().add(JQPlotJavascriptReferencePool.CursorRenderer.getReference());
    }

    /**
     * CSS spec for cursor style
     *
     * @return
     */
    public Cursors getStyle()
    {
        return style;
    }

    /**
     * CSS spec for cursor style
     *
     * @param style
     */
    public void setStyle(Cursors style)
    {
        this.style = style;
    }

    /**
     * Whether to show the cursor or not.
     *
     * @return
     */
    public Boolean isShow()
    {
        return show;
    }

    /**
     * Whether to show the cursor or not.
     *
     * @param show
     */
    public void setShow(Boolean show)
    {
        this.show = show;
    }

    /**
     * Show tooltip or not
     *
     * @return
     */
    public Boolean isShowTooltip()
    {
        return showTooltip;
    }

    /**
     * Show tooltip or not
     *
     * @param showTooltip
     */
    public void setShowTooltip(Boolean showTooltip)
    {
        this.showTooltip = showTooltip;
    }

    /**
     * Tooltip follows the mouse, it is not at a fixed location.
     *
     * @return
     */
    public Boolean isFollowMouse()
    {
        return followMouse;
    }

    /**
     * Tooltip follows the mouse, it is not at a fixed location.
     *
     * @param followMouse
     */
    public void setFollowMouse(Boolean followMouse)
    {
        this.followMouse = followMouse;
    }

    /**
     * Where to position tooltip. 'n' etc
     *
     * @return
     */
    public String getTooltipLocation()
    {
        return tooltipLocation;
    }

    /**
     * Where to position tooltip.
     *
     * @param tooltipLocation
     */
    public void setTooltipLocation(String tooltipLocation)
    {
        this.tooltipLocation = tooltipLocation;
    }

    /**
     * Pixel offset of tooltip from the grid boundaries or cursor center.
     * <p>
     * @return
     */
    public Integer getTooltipOffset()
    {
        return tooltipOffset;
    }

    /**
     * Pixel offset of tooltip from the grid boundaries or cursor center.
     * <p>
     * @param tooltipOffset
     */
    public void setTooltipOffset(Integer tooltipOffset)
    {
        this.tooltipOffset = tooltipOffset;
    }

    /**
     * show the grid pixel coordinates of the mouse.
     * <p>
     * @return
     */
    public Boolean isShowTooltipGridPosition()
    {
        return showTooltipGridPosition;
    }

    /**
     * show the grid pixel coordinates of the mouse.
     * <p>
     * @param showTooltipGridPosition
     */
    public void setShowTooltipGridPosition(Boolean showTooltipGridPosition)
    {
        this.showTooltipGridPosition = showTooltipGridPosition;
    }

    /**
     * show the unit (data) coordinates of the mouse.
     * <p>
     * @return
     */
    public Boolean isShowTooltipUnitPosition()
    {
        return showTooltipUnitPosition;
    }

    /**
     * show the unit (data) coordinates of the mouse.
     * <p>
     * @param showTooltipUnitPosition
     */
    public void setShowTooltipUnitPosition(Boolean showTooltipUnitPosition)
    {
        this.showTooltipUnitPosition = showTooltipUnitPosition;
    }

    /**
     * Used with showVerticalLine to show intersecting data points in the tooltip.
     * <p>
     * @return
     */
    public Boolean isShowTooltipDataPosition()
    {
        return showTooltipDataPosition;
    }

    /**
     * Used with showVerticalLine to show intersecting data points in the tooltip.
     * <p>
     * @param showTooltipDataPosition
     */
    public void setShowTooltipDataPosition(Boolean showTooltipDataPosition)
    {
        this.showTooltipDataPosition = showTooltipDataPosition;
    }

    /**
     * sprintf format string for the tooltip.
     * <p>
     * @return
     */
    public String getTooltipFormatString()
    {
        return tooltipFormatString;
    }

    /**
     * sprintf format string for the tooltip.
     * <p>
     * @param tooltipFormatString
     */
    public void setTooltipFormatString(String tooltipFormatString)
    {
        this.tooltipFormatString = tooltipFormatString;
    }

    /**
     * Use the x and y axes formatters to format the text in the tooltip.
     * <p>
     * @return
     */
    public Boolean getUseAxesFormatters()
    {
        return useAxesFormatters;
    }

    /**
     * Use the x and y axes formatters to format the text in the tooltip.
     * <p>
     * @param useAxesFormatters
     */
    public void setUseAxesFormatters(Boolean useAxesFormatters)
    {
        this.useAxesFormatters = useAxesFormatters;
    }

    /**
     * Enable plot zooming.
     * <p>
     * @return
     */
    public Boolean isZoom()
    {
        return zoom;
    }

    /**
     * Enable plot zooming.
     * <p>
     * @param zoom
     */
    public void setZoom(Boolean zoom)
    {
        this.zoom = zoom;
    }

    /**
     * Will expand zoom range to provide more rounded tick values.
     * <p>
     * @return
     */
    public Boolean isLooseZoom()
    {
        return looseZoom;
    }

    /**
     * Will expand zoom range to provide more rounded tick values.
     * <p>
     * @param looseZoom
     */
    public void setLooseZoom(Boolean looseZoom)
    {
        this.looseZoom = looseZoom;
    }

    /**
     * Will reset plot zoom if single click on plot without drag.
     * <p>
     * @return
     */
    public Boolean isClickReset()
    {
        return clickReset;
    }

    /**
     * Will reset plot zoom if single click on plot without drag.
     * <p>
     * @param clickReset
     */
    public void setClickReset(Boolean clickReset)
    {
        this.clickReset = clickReset;
    }

    /**
     * Will reset plot zoom if double click on plot without drag.
     * <p>
     * @return
     */
    public Boolean isDblClickReset()
    {
        return dblClickReset;
    }

    /**
     * Will reset plot zoom if double click on plot without drag.
     * <p>
     * @param dblClickReset
     */
    public void setDblClickReset(Boolean dblClickReset)
    {
        this.dblClickReset = dblClickReset;
    }

    /**
     * draw a vertical line across the plot which follows the cursor.
     * <p>
     * @return
     */
    public Boolean isShowVerticalLine()
    {
        return showVerticalLine;
    }

    /**
     * draw a vertical line across the plot which follows the cursor.
     * <p>
     * @param showVerticalLine
     */
    public void setShowVerticalLine(Boolean showVerticalLine)
    {
        this.showVerticalLine = showVerticalLine;
    }

    /**
     * draw a horizontal line across the plot which follows the cursor.
     * <p>
     * @return
     */
    public Boolean isShowHorizontalLine()
    {
        return showHorizontalLine;
    }

    /**
     * draw a horizontal line across the plot which follows the cursor.
     * <p>
     * @param showHorizontalLine
     */
    public void setShowHorizontalLine(Boolean showHorizontalLine)
    {
        this.showHorizontalLine = showHorizontalLine;
    }

    /**
     * ‘none’, ‘x’ or ‘y’
     * <p>
     * @return
     */
    public String getConstrainZoomTo()
    {
        return constrainZoomTo;
    }

    /**
     * ‘none’, ‘x’ or ‘y’
     * <p>
     * @param constrainZoomTo
     */
    public void setConstrainZoomTo(String constrainZoomTo)
    {
        this.constrainZoomTo = constrainZoomTo;
    }

    /**
     * pixel distance from data point or marker to consider cursor lines intersecting with point.
     * <p>
     * @return
     */
    public Integer getIntersectionThreshold()
    {
        return intersectionThreshold;
    }

    /**
     * pixel distance from data point or marker to consider cursor lines intersecting with point.
     * <p>
     * @param intersectionThreshold
     */
    public void setIntersectionThreshold(Integer intersectionThreshold)
    {
        this.intersectionThreshold = intersectionThreshold;
    }

    /**
     * Replace the plot legend with an enhanced legend displaying intersection information.
     * <p>
     * @return
     */
    public Boolean isShowCursorLegend()
    {
        return showCursorLegend;
    }

    /**
     * Replace the plot legend with an enhanced legend displaying intersection information.
     * <p>
     * @param showCursorLegend
     */
    public void setShowCursorLegend(Boolean showCursorLegend)
    {
        this.showCursorLegend = showCursorLegend;
    }

    /**
     * Format string used in the cursor legend.
     * <p>
     * @return
     */
    public String getCursorLegendFormatString()
    {
        return cursorLegendFormatString;
    }

    /**
     * Format string used in the cursor legend.
     * <p>
     * @param cursorLegendFormatString
     */
    public void setCursorLegendFormatString(String cursorLegendFormatString)
    {
        this.cursorLegendFormatString = cursorLegendFormatString;
    }

    /**
     * True to limit actual zoom area to edges of grid, even when zooming outside of plot area.
     * <p>
     * @return
     */
    public Boolean isConstrainOutsideZoom()
    {
        return constrainOutsideZoom;
    }

    /**
     * True to limit actual zoom area to edges of grid, even when zooming outside of plot area.
     * <p>
     * @param constrainOutsideZoom
     */
    public void setConstrainOutsideZoom(Boolean constrainOutsideZoom)
    {
        this.constrainOutsideZoom = constrainOutsideZoom;
    }

    /**
     * True will keep updating the tooltip when zooming of the grid.
     * <p>
     * @return
     */
    public Boolean isShowTooltipOutsideZoom()
    {
        return showTooltipOutsideZoom;
    }

    /**
     * True will keep updating the tooltip when zooming of the grid.
     * <p>
     * @param showTooltipOutsideZoom
     */
    public void setShowTooltipOutsideZoom(Boolean showTooltipOutsideZoom)
    {
        this.showTooltipOutsideZoom = showTooltipOutsideZoom;
    }

    @Override
    public String getRenderer()
    {
        return "$.jqplot.Cursor";
    }

    /**
     * Show position for the specified axes<p>
     * This is an array like [[‘xaxis’, ‘yaxis’], [‘xaxis’, ‘y2axis’]] Default is to compute automatically for all visible axes.
     *
     * @return
     */
    public ArrayList<XYObject> getTooltipAxisGroups()
    {
        if (tooltipAxisGroups == null)
        {
            tooltipAxisGroups = new ArrayList<>();
        }
        return tooltipAxisGroups;
    }

    /**
     * Show position for the specified axes<p>
     * This is an array like [[‘xaxis’, ‘yaxis’], [‘xaxis’, ‘y2axis’]] Default is to compute automatically for all visible axes.
     *
     * @param tooltipAxisGroups
     */
    public void setTooltipAxisGroups(ArrayList<XYObject> tooltipAxisGroups)
    {
        this.tooltipAxisGroups = tooltipAxisGroups;
    }

}
