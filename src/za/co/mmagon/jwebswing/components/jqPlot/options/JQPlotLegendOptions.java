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
package za.co.mmagon.jwebswing.components.jqPlot.options;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRawValue;
import java.util.ArrayList;
import za.co.mmagon.jwebswing.components.jqPlot.JQPlotGraph;
import za.co.mmagon.jwebswing.components.jqPlot.options.legends.JQPlotLegendRendererEnhancedOptions;
import za.co.mmagon.jwebswing.components.jqPlot.parts.interfaces.JQPlotLegendRenderer;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourHex;
import za.co.mmagon.jwebswing.htmlbuilder.css.fonts.FontFamilies;
import za.co.mmagon.jwebswing.generics.CompassPoints;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * The Legend options
 *
 * @author Marc Magon
 * @since 07 Aug 2015
 * @version 1.0
 */
public class JQPlotLegendOptions<O extends JavaScriptPart & JQPlotLegendRenderer> extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;

    /**
     * The legend renderer string
     */
    @JsonRawValue
    private String renderer;

    /**
     * The legend renderer options
     */
    private O rendererOptions;

    /**
     * Whether to display the legend on the graph.
     */
    private Boolean show;
    /**
     * Placement of the legend.
     * compass direction, nw, n, ne, e, se, s, sw, w.
     */
    private CompassPoints location;
    /**
     * pixel offset of the legend box from the x (or x2) axis.
     * <p>
     * @deprecated
     */
    private Integer xoffset;
    /**
     * pixel offset of the legend box from the y (or y2) axis.
     * <p>
     * @deprecated
     */
    private Integer yoffset;

    /**
     * Array of labels to use.
     */
    private ArrayList<String> labels;
    /**
     * true to show the label text on the legend.
     */
    private Boolean showLabels;
    /**
     * true to show the color swatches on the legend.
     */
    private Boolean showSwatch;
    /**
     * “insideGrid” places legend inside the grid area of the plot.
     */
    private String placement;
    /**
     * CSS spec for the border around the legend box.
     */
    private String border;
    /**
     * CSS spec for the background of the legend box.
     */
    private String background;
    /**
     * CSS color spec for the legend text.
     */
    private String textColor;
    /**
     * CSS font-family spec for the legend text.
     */
    private FontFamilies fontFamily;
    /**
     * CSS font-size spec for the legend text.
     */
    private Integer fontSize;
    /**
     * CSS padding-top spec for the rows in the legend.
     */
    private Integer rowSpacing;

    /**
     * Whether to draw the legend before the series or not.
     */
    private Boolean predraw;
    /**
     * CSS margin for the legend DOM element.
     */
    private Integer marginTop;
    /**
     * CSS margin for the legend DOM element.
     */
    private Integer marginRight;
    /**
     * CSS margin for the legend DOM element.
     */
    private Integer marginBottom;
    /**
     * CSS margin for the legend DOM element.
     */
    private Integer marginLeft;

    @JsonIgnore
    private JQPlotGraph linkedGraph;

    /**
     * Sets the linked graph for this options
     *
     * @param linkedGraph
     */
    public JQPlotLegendOptions(JQPlotGraph linkedGraph)
    {
        this.linkedGraph = linkedGraph;
    }

    /**
     * Whether to display the legend on the graph.
     */
    public Boolean getShow()
    {
        return show;
    }

    /**
     * Whether to display the legend on the graph.
     * <p>
     * @param show
     */
    public void setShow(Boolean show)
    {
        this.show = show;
    }

    /**
     * Placement of the legend.
     * compass direction, nw, n, ne, e, se, s, sw, w.
     * <p>
     * @return
     */
    public CompassPoints getLocation()
    {
        return location;
    }

    /**
     * Placement of the legend.
     * compass direction, nw, n, ne, e, se, s, sw, w.
     * <p>
     * @param location
     */
    public void setLocation(CompassPoints location)
    {
        this.location = location;
    }

    /**
     * pixel offset of the legend box from the x (or x2) axis.
     * <p>
     * @deprecated
     *
     */
    public Integer getXoffset()
    {
        return xoffset;
    }

    /**
     * pixel offset of the legend box from the x (or x2) axis.
     * <p>
     * @deprecated
     * @param xoffset
     */
    public void setXoffset(Integer xoffset)
    {
        this.xoffset = xoffset;
    }

    /**
     * pixel offset of the legend box from the x (or x2) axis.
     * <p>
     * @deprecated
     * @return
     */
    public Integer getYoffset()
    {
        return yoffset;
    }

    /**
     * pixel offset of the legend box from the x (or x2) axis.
     * <p>
     * @deprecated
     * @param yoffset
     */
    public void setYoffset(Integer yoffset)
    {
        this.yoffset = yoffset;
    }

    /**
     * Custom list of labels
     * <p>
     * @return
     */
    public ArrayList<String> getLabels()
    {
        if (labels == null)
        {
            labels = new ArrayList<>();
        }
        return labels;
    }

    /**
     * Sets a custom display list for labels
     * <p>
     * @param labels
     */
    public void setLabels(ArrayList<String> labels)
    {
        this.labels = labels;
    }

    /**
     * Sets to show the labels or not
     * <p>
     * @return
     */
    public Boolean getShowLabels()
    {
        return showLabels;
    }

    /**
     * Sets to show the labels
     * <p>
     * @param showLabels
     */
    public void setShowLabels(Boolean showLabels)
    {
        this.showLabels = showLabels;
    }

    /**
     * Whether to show the swatch or not
     * <p>
     * @return
     */
    public Boolean getShowSwatch()
    {
        return showSwatch;
    }

    /**
     * Whether to show the swatch or not
     * <p>
     * @param showSwatch
     */
    public void setShowSwatch(Boolean showSwatch)
    {
        this.showSwatch = showSwatch;
    }

    /**
     * ”insideGrid” places legend inside the grid area of the plot
     * “outsideGrid” places the legend outside the grid but inside the plot container, shrinking the grid to accomodate the legend
     * “inside” synonym for “insideGrid”,
     * <p>
     * “outside” places the legend ouside the grid area, but does not shrink the grid which can cause the legend to overflow the plot container.
     * <p>
     * @return
     */
    public String getPlacement()
    {
        return placement;
    }

    /**
     * ”insideGrid” places legend inside the grid area of the plot<p>
     * “outsideGrid” places the legend outside the grid but inside the plot container, shrinking the grid to accomodate the legend<p>
     * “inside” synonym for “insideGrid”,
     * <p>
     * “outside” places the legend ouside the grid area, but does not shrink the grid which can cause the legend to overflow the plot container.<p>
     * <p>
     * @param placement
     */
    public void setPlacement(String placement)
    {
        this.placement = placement;
    }

    /**
     * CSS Border Configuration line
     * <p>
     * @return
     */
    public String getBorder()
    {
        return border;
    }

    /**
     * Sets the css border configuration
     * <p>
     * @param border
     */
    public void setBorder(String border)
    {
        this.border = border;
    }

    /**
     * Sets the CSS Background
     * <p>
     * @return
     */
    public String getBackground()
    {
        return background;
    }

    /**
     * Sets the CSS Background
     * <p>
     * @param background
     */
    public void setBackground(String background)
    {
        this.background = background;
    }

    /**
     * Gets the text colour
     * <p>
     * @return
     */
    public String getTextColor()
    {
        return textColor;
    }

    /**
     * Sets the text colour
     * <p>
     * @param textColor
     */
    public void setTextColor(ColourHex textColor)
    {
        this.textColor = textColor.getValue();
    }

    /**
     * Gets the font family used
     * <p>
     * @return
     */
    public FontFamilies getFontFamily()
    {
        return fontFamily;
    }

    /**
     * Sets the font family used
     * <p>
     * @param fontFamily
     */
    public void setFontFamily(FontFamilies fontFamily)
    {
        this.fontFamily = fontFamily;
    }

    /**
     * Gets the font size
     * <p>
     * @return
     */
    public Integer getFontSize()
    {
        return fontSize;
    }

    /**
     * Sets the font size
     * <p>
     * @param fontSize
     */
    public void setFontSize(Integer fontSize)
    {
        this.fontSize = fontSize;
    }

    /**
     * Gets the row spacing
     * <p>
     * @return
     */
    public Integer getRowSpacing()
    {
        return rowSpacing;
    }

    /**
     * Sets the row spacing
     * <p>
     * @param rowSpacing
     */
    public void setRowSpacing(Integer rowSpacing)
    {
        this.rowSpacing = rowSpacing;
    }

    /**
     * Whether to draw the legend before the series or not.
     * <p>
     * @return
     */
    public Boolean getPredraw()
    {
        return predraw;
    }

    /**
     * Whether to draw the legend before the series or not.
     * <p>
     * @param predraw
     */
    public void setPredraw(Boolean predraw)
    {
        this.predraw = predraw;
    }

    /**
     * Sets the margin top
     * <p>
     * @return
     */
    public Integer getMarginTop()
    {
        return marginTop;
    }

    /**
     * Sets the margin top
     * <p>
     * @param marginTop
     */
    public void setMarginTop(Integer marginTop)
    {
        this.marginTop = marginTop;
    }

    /**
     * Sets the margin right
     * <p>
     * @return
     */
    public Integer getMarginRight()
    {
        return marginRight;
    }

    /**
     * Sets the margin right
     * <p>
     * @param marginRight
     */
    public void setMarginRight(Integer marginRight)
    {
        this.marginRight = marginRight;
    }

    /**
     * Gets the margin bottom
     * <p>
     * @return
     */
    public Integer getMarginBottom()
    {
        return marginBottom;
    }

    /**
     * Sets the margin bottom
     * <p>
     * @param marginBottom
     */
    public void setMarginBottom(Integer marginBottom)
    {
        this.marginBottom = marginBottom;
    }

    /**
     * Sets the margin left
     * <p>
     * @return
     */
    public Integer getMarginLeft()
    {
        return marginLeft;
    }

    /**
     * Sets the margin left
     * <p>
     * @param marginLeft
     */
    public void setMarginLeft(Integer marginLeft)
    {
        this.marginLeft = marginLeft;
    }

    /**
     * Gets the linked graph for this legends box
     *
     * @return
     */
    public JQPlotGraph getLinkedGraph()
    {
        return linkedGraph;
    }

    /**
     * Sets the linked graph for this box
     *
     * @param linkedGraph
     */
    public void setLinkedGraph(JQPlotGraph linkedGraph)
    {
        this.linkedGraph = linkedGraph;
    }

    /**
     * Legend Renderer Options
     * <p>
     * Defaults to JQPlotLegendRendererEnhancedOptions
     *
     * @return
     */
    public O getRendererOptions()
    {
        if (rendererOptions == null)
        {
            setRendererOptions((O) new JQPlotLegendRendererEnhancedOptions(getLinkedGraph()));
        }
        return rendererOptions;
    }

    /**
     * Sets legend renderer options
     *
     * @param rendererOptions
     */
    public void setRendererOptions(O rendererOptions)
    {
        this.renderer = rendererOptions.getRenderer();
        this.rendererOptions = rendererOptions;
    }

    /**
     * Returns the renderer string for the options
     *
     * @return
     */
    public String getRenderer()
    {
        return renderer;
    }

}
