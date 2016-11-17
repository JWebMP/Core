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
package za.co.mmagon.jwebswing.components.jqplot.options.grid;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import za.co.mmagon.jwebswing.components.jqplot.JQPlotGraph;
import za.co.mmagon.jwebswing.components.jqplot.parts.interfaces.JQPlotGridRenderer;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourHex;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 *
 * @author Marc Magon
 * @since 07 Aug 2015
 * @version 1.0
 */
public class JQPlotGridOptionsCanvasGrid extends JavaScriptPart implements JQPlotGridRenderer
{

    @JsonIgnore
    private JQPlotGraph linkedGraph;

    /**
     * Construct a new Grid Options with the linked graph
     *
     * @param linkedGraph
     */
    public JQPlotGridOptionsCanvasGrid(JQPlotGraph linkedGraph)
    {
        this.linkedGraph = linkedGraph;
    }

    /**
     * Returns the linked graph with this object
     *
     * @return
     */
    public JQPlotGraph getLinkedGraph()
    {
        return linkedGraph;
    }

    private static final long serialVersionUID = 1L;
    /**
     * whether to draw lines across the grid or not.
     */
    private Boolean drawGridLines;
    /**
     * *Color of the grid lines.
     */
    private String gridLineColor;
    /**
     * CSS color spec for background colour of grid.
     */
    private String background;
    /**
     * CSS color spec for border around grid.
     */
    private String borderColor;
    /**
     * pixel width of border around grid.
     */
    private Double borderWidth;
    /**
     * draw a shadow for grid.
     */
    private Boolean shadow;
    /**
     * angle of the shadow. Clockwise from x axis.
     */
    private Integer shadowAngle;
    /**
     * offset from the line of the shadow.
     */
    private Double shadowOffset;
    /**
     * width of the stroke for the shadow.
     */
    private Integer shadowWidth;
    /**
     * Number of strokes to make when drawing shadow.
     * Each stroke offset by shadowOffset from the last.
     */
    private Integer shadowDepth;
    /**
     * Opacity of the shadow
     */
    private Double shadowAlpha;

    private JavaScriptPart rendererOptions;

    /**
     * Whether or not to draw grid lines
     * <p>
     * @return
     */
    public Boolean getDrawGridLines()
    {
        return drawGridLines;
    }

    /**
     * Whether or not to draw grid lines
     * <p>
     * @param drawGridLines
     */
    public void setDrawGridLines(Boolean drawGridLines)
    {
        this.drawGridLines = drawGridLines;
    }

    /**
     * Color of the grid lines.
     *
     * @return
     */
    public String getGridLineColor()
    {
        return gridLineColor;
    }

    /**
     * Color of the grid lines.
     *
     * @param gridLineColor
     */
    public void setGridLineColor(ColourHex gridLineColor)
    {
        this.gridLineColor = gridLineColor.getValue();
    }

    /**
     * Get background colour
     *
     * @return
     */
    public String getBackground()
    {
        return background;
    }

    /**
     * Set background colour
     *
     * @param background
     */
    public void setBackground(ColourHex background)
    {
        this.background = background.getValue();
    }

    /**
     * Get border colour
     *
     * @return
     */
    public String getBorderColor()
    {
        return borderColor;
    }

    /**
     * Set border colour
     *
     * @param borderColor
     */
    public void setBorderColor(ColourHex borderColor)
    {
        this.borderColor = borderColor.getValue();
    }

    /**
     * Get border width
     *
     * @return
     */
    public Double getBorderWidth()
    {
        return borderWidth;
    }

    /**
     * Set border width
     *
     * @param borderWidth
     */
    public void setBorderWidth(Double borderWidth)
    {
        this.borderWidth = borderWidth;
    }

    /**
     * Get shadow
     *
     * @return
     */
    public Boolean getShadow()
    {
        return shadow;
    }

    /**
     * set shadow
     *
     * @param shadow
     */
    public void setShadow(Boolean shadow)
    {
        this.shadow = shadow;
    }

    /**
     * Get shadow angle
     *
     * @return
     */
    public Integer getShadowAngle()
    {
        return shadowAngle;
    }

    /**
     * Set shadow angle
     *
     * @param shadowAngle
     */
    public void setShadowAngle(Integer shadowAngle)
    {
        this.shadowAngle = shadowAngle;
    }

    /**
     * get shadow offset
     *
     * @return
     */
    public Double getShadowOffset()
    {
        return shadowOffset;
    }

    /**
     * Set the shadow offset
     *
     * @param shadowOffset
     */
    public void setShadowOffset(Double shadowOffset)
    {
        this.shadowOffset = shadowOffset;
    }

    /**
     * Get the shadow width
     *
     * @return
     */
    public Integer getShadowWidth()
    {
        return shadowWidth;
    }

    /**
     * Set the shadow width
     *
     * @param shadowWidth
     */
    public void setShadowWidth(Integer shadowWidth)
    {
        this.shadowWidth = shadowWidth;
    }

    /**
     * Get the shadow depth
     *
     * @return
     */
    public Integer getShadowDepth()
    {
        return shadowDepth;
    }

    /**
     * Set the shadow depth
     *
     * @param shadowDepth
     */
    public void setShadowDepth(Integer shadowDepth)
    {
        this.shadowDepth = shadowDepth;
    }

    /**
     * Get the shadow alpa
     *
     * @return
     */
    public Double getShadowAlpha()
    {
        return shadowAlpha;
    }

    /**
     * Set the shadow alpha
     *
     * @param shadowAlpha
     */
    public void setShadowAlpha(Double shadowAlpha)
    {
        this.shadowAlpha = shadowAlpha;
    }

    /**
     * Get the render options
     *
     * @return
     */
    public JavaScriptPart getRendererOptions()
    {
        return rendererOptions;
    }

    /**
     * Set the renderer options
     *
     * @param rendererOptions
     */
    public void setRendererOptions(JavaScriptPart rendererOptions)
    {
        this.rendererOptions = rendererOptions;
    }

    @JsonProperty("renderer")
    @JsonRawValue
    @Override
    public String getRenderer()
    {
        return "$.jqplot.CanvasGridRenderer";
    }
}
