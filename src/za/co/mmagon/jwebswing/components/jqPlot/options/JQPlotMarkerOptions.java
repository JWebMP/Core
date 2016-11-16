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
package za.co.mmagon.jwebswing.components.jqPlot.options;

import com.fasterxml.jackson.annotation.JsonIgnore;
import za.co.mmagon.jwebswing.components.jqPlot.JQPlotGraph;
import za.co.mmagon.jwebswing.components.jqPlot.parts.MarkerStyles;
import za.co.mmagon.jwebswing.components.jqPlot.parts.interfaces.JQPlotMarkerRenderer;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourHex;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * The specific marker options available
 *
 * @author mmagon
 */
public class JQPlotMarkerOptions extends JavaScriptPart implements JQPlotMarkerRenderer
{

    private static final long serialVersionUID = 1L;

    /**
     * whether to show data point markers.
     */
    private Boolean show;
    /**
     * The default style of the marker
     */
    private MarkerStyles style;
    /**
     * width of the stroke drawing the marker.
     */
    private Integer lineWidth;
    /**
     * size (diameter, edge length, etc.) of the marker.
     */
    private Integer size;
    /**
     * color of marker, set to color of line by default.
     */
    private String color;
    /**
     * whether to draw shadow on marker or not.
     */
    private Boolean shadow;
    /**
     * angle of the shadow. Clockwise from x axis.
     */
    private Integer shadowAngle;
    /**
     * The offset of the shadow from the marker
     */
    private Integer shadowOffset;
    /**
     * Number of strokes to make when drawing shadow.
     * Each stroke offset by shadowOffset from the last.
     */
    private Integer shadowDepth;
    /**
     * Opacity of the shadow
     */
    private Double shadowAlpha;

    /**
     * Renderer that will draws the shadows on the marker.
     */
    private JavaScriptPart shadowRenderer;
    /**
     * Renderer that will draw the marker.
     */
    private JavaScriptPart shapeRenderer;

    @JsonIgnore
    private JQPlotGraph linkedGraph;

    /**
     * Constructs a new instance of the Marker Options
     *
     * @param linkedGraph
     */
    public JQPlotMarkerOptions(JQPlotGraph linkedGraph)
    {
        this.linkedGraph = linkedGraph;
    }

    /**
     * whether or not to show the marker.
     *
     * @return
     */
    public Boolean getShow()
    {
        return show;
    }

    /**
     * whether or not to show the marker.
     *
     * @param show
     */
    public void setShow(Boolean show)
    {
        this.show = show;
    }

    /**
     * One of diamond, circle, square, x, plus, dash, filledDiamond, filledCircle, filledSquare
     *
     * @return
     */
    public MarkerStyles getStyle()
    {
        return style;
    }

    /**
     * One of diamond, circle, square, x, plus, dash, filledDiamond, filledCircle, filledSquare
     *
     * @param style
     */
    public void setStyle(MarkerStyles style)
    {
        this.style = style;
    }

    /**
     * size of the line for non-filled markers.
     *
     * @return
     */
    public Integer getLineWidth()
    {
        return lineWidth;
    }

    /**
     * size of the line for non-filled markers.
     *
     * @param lineWidth
     */
    public void setLineWidth(Integer lineWidth)
    {
        this.lineWidth = lineWidth;
    }

    /**
     * Size of the marker (diameter or circle, length of edge of square, etc.)
     *
     * @return
     */
    public Integer getSize()
    {
        return size;
    }

    /**
     * Size of the marker (diameter or circle, length of edge of square, etc.)
     *
     * @param size
     */
    public void setSize(Integer size)
    {
        this.size = size;
    }

    /**
     * color of marker.
     *
     * @return
     */
    public String getColor()
    {
        return color;
    }

    /**
     * color of marker.
     *
     * @param color
     */
    public void setColor(ColourHex color)
    {
        this.color = color.getValue();
    }

    /**
     * *
     * whether or not to draw a shadow on the line
     *
     * @return
     */
    public Boolean getShadow()
    {
        return shadow;
    }

    /**
     * whether or not to draw a shadow on the line
     *
     * @param shadow
     */
    public void setShadow(Boolean shadow)
    {
        this.shadow = shadow;
    }

    /**
     * Shadow angle in degrees
     *
     * @return
     */
    public Integer getShadowAngle()
    {
        return shadowAngle;
    }

    /**
     * Shadow angle in degrees
     *
     * @param shadowAngle
     */
    public void setShadowAngle(Integer shadowAngle)
    {
        this.shadowAngle = shadowAngle;
    }

    /**
     * Shadow offset from line in pixels
     *
     * @return
     */
    public Integer getShadowOffset()
    {
        return shadowOffset;
    }

    /**
     * Shadow offset from line in pixels
     *
     * @param shadowOffset
     */
    public void setShadowOffset(Integer shadowOffset)
    {
        this.shadowOffset = shadowOffset;
    }

    /**
     * Number of times shadow is stroked, each stroke offset shadowOffset from the last.
     *
     * @return
     */
    public Integer getShadowDepth()
    {
        return shadowDepth;
    }

    /**
     * Number of times shadow is stroked, each stroke offset shadowOffset from the last.
     *
     * @param shadowDepth
     */
    public void setShadowDepth(Integer shadowDepth)
    {
        this.shadowDepth = shadowDepth;
    }

    /**
     * Alpha channel transparency of shadow.
     *
     * @return
     */
    public Double getShadowAlpha()
    {
        return shadowAlpha;
    }

    /**
     * Alpha channel transparency of shadow.
     *
     * @param shadowAlpha
     */
    public void setShadowAlpha(Double shadowAlpha)
    {
        this.shadowAlpha = shadowAlpha;
    }

    @Override
    @JsonIgnore
    public String getMarkerRenderer()
    {
        return "$.jqplot.MarkerRenderer";
    }

    /**
     * Returns the shadow renderer
     *
     * @return
     */
    public JavaScriptPart getShadowRenderer()
    {
        return shadowRenderer;
    }

    /**
     * sets the shadow renderer
     *
     * @param shadowRenderer
     */
    public void setShadowRenderer(JavaScriptPart shadowRenderer)
    {
        this.shadowRenderer = shadowRenderer;
    }

    /**
     * gets the shape renderer
     *
     * @return
     */
    public JavaScriptPart getShapeRenderer()
    {
        return shapeRenderer;
    }

    /**
     * sets the shape renderer
     *
     * @param shapeRenderer
     */
    public void setShapeRenderer(JavaScriptPart shapeRenderer)
    {
        this.shapeRenderer = shapeRenderer;
    }

    /**
     * return the graph that is linked to this marker
     *
     * @return
     */
    public JQPlotGraph getLinkedGraph()
    {
        return linkedGraph;
    }

    /**
     * sets the graph that is linked to this marker
     *
     * @param linkedGraph
     */
    public void setLinkedGraph(JQPlotGraph linkedGraph)
    {
        this.linkedGraph = linkedGraph;
    }

}
