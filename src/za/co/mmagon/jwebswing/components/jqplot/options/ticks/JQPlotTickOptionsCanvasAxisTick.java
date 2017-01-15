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
package za.co.mmagon.jwebswing.components.jqplot.options.ticks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRawValue;
import za.co.mmagon.jwebswing.components.jqplot.JQPlotGraph;
import za.co.mmagon.jwebswing.components.jqplot.parts.interfaces.JQPlotTickRenderer;
import za.co.mmagon.jwebswing.components.jqplot.references.JQPlotJavascriptReferencePool;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourHex;
import za.co.mmagon.jwebswing.htmlbuilder.css.fonts.FontFamilies;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 *
 * @author Marc Magon
 * @since 07 Aug 2015
 * @version 1.0
 */
public class JQPlotTickOptionsCanvasAxisTick extends JavaScriptPart implements JQPlotTickRenderer
{

    private static final long serialVersionUID = 1L;
    /**
     * tick mark on the axis. One of ‘inside’, ‘outside’, ‘cross’, ‘’ or null.
     */
    private String mark;
    /**
     * Whether or not to show the mark on the axis.
     */
    private Boolean showMark;
    /**
     * Whether or not to draw the gridline on the grid at this tick.
     */
    private Boolean showGridline;
    /**
     * css spec for the font-size css attribute.
     */
    private Integer angle;
    /**
     * if this is a minor tick.
     */
    private Boolean isMinorTick;
    /**
     * Length of the tick marks in pixels.
     */
    private Boolean markSize;
    /**
     * Whether or not to show the tick (mark and label).
     */
    private Boolean show;
    /**
     * wether or not to show the label.
     */
    private Boolean showLabel;
    /**
     * A class of a formatter for the tick text. $.jqplot.DefaultTickFormatter
     * <p>
     * A class of a formatter for the tick text. sprintf by default.
     */
    private String formatter;
    /**
     * String to prepend to the tick label.
     */
    private String prefix;
    /**
     * string passed to the formatter.
     * <p>
     */
    private String formatString;
    /**
     * css spec for the font-family css attribute.
     */
    private FontFamilies fontFamily;
    /**
     * css spec for the font-size css attribute.
     */
    private Integer fontSize;
    /**
     * css spec for the color attribute.
     */
    private ColourHex textColor;
    /**
     * true to escape HTML entities in the label.
     */
    private Boolean escapeHTML;

    /**
     * ‘auto’, ‘start’, ‘middle’ or ‘end’.
     */
    private String labelPosition;

    @JsonIgnore
    private final JQPlotGraph linkedGraph;

    /**
     * Constructs a new tick options canvas
     *
     * @param linkedGraph
     */
    public JQPlotTickOptionsCanvasAxisTick(JQPlotGraph linkedGraph)
    {
        this.linkedGraph = linkedGraph;
        linkedGraph.getJavascriptReferences().add(JQPlotJavascriptReferencePool.CanvasAxisTickRenderer.getReference());
        linkedGraph.getJavascriptReferences().add(JQPlotJavascriptReferencePool.CanvasTextRenderer.getReference());
    }

    /**
     * tick mark on the axis. One of ‘inside’, ‘outside’, ‘cross’, ‘’ or null.
     * <p>
     * @return
     */
    public String getMark()
    {
        return mark;
    }

    /**
     * tick mark on the axis. One of ‘inside’, ‘outside’, ‘cross’, ‘’ or null.
     * <p>
     * @param mark
     */
    public void setMark(String mark)
    {
        this.mark = mark;
    }

    /**
     * Show the mark or not
     * <p>
     * @return
     */
    public Boolean getShowMark()
    {
        return showMark;
    }

    /**
     * Show the mark or not
     * <p>
     * @param showMark
     */
    public void setShowMark(Boolean showMark)
    {
        this.showMark = showMark;
    }

    /**
     * Whether to show the grid line
     * <p>
     * @return
     */
    public Boolean getShowGridline()
    {
        return showGridline;
    }

    /**
     * Whether to show the grid line
     * <p>
     * @param showGridline
     */
    public void setShowGridline(Boolean showGridline)
    {
        this.showGridline = showGridline;
    }

    /**
     * The angle of the text
     * <p>
     * @return
     */
    public Integer getAngle()
    {
        return angle;
    }

    /**
     * The angle of the text
     * <p>
     * @param angle
     */
    public void setAngle(Integer angle)
    {
        this.angle = angle;
    }

    /**
     * Display minor ticks or not
     * <p>
     * @return
     */
    public Boolean getIsMinorTick()
    {
        return isMinorTick;
    }

    /**
     * Display minor ticks or not
     * <p>
     * @param isMinorTick
     */
    public void setIsMinorTick(Boolean isMinorTick)
    {
        this.isMinorTick = isMinorTick;
    }

    /**
     * Gets the mark size
     * <p>
     * @return
     */
    public Boolean getMarkSize()
    {
        return markSize;
    }

    /**
     * Sets the mark size
     * <p>
     * @param markSize
     */
    public void setMarkSize(Boolean markSize)
    {
        this.markSize = markSize;
    }

    /**
     * Whether or not to show the ticks
     * <p>
     * @return
     */
    public Boolean getShow()
    {
        return show;
    }

    /**
     * Whether or not to show the ticks
     * <p>
     * @param show
     */
    public void setShow(Boolean show)
    {
        this.show = show;
    }

    /**
     * Whether or not to show the label
     * <p>
     * @return
     */
    public Boolean getShowLabel()
    {
        return showLabel;
    }

    /**
     * Whether or not to show the label
     * <p>
     * @param showLabel
     */
    public void setShowLabel(Boolean showLabel)
    {
        this.showLabel = showLabel;
    }

    /**
     * Get a sprintf formatter
     * <p>
     * @return
     */
    public String getFormatter()
    {
        return formatter;
    }

    /**
     * Set the sprint f format string
     * <p>
     * @param formatter
     */
    public void setFormatter(String formatter)
    {
        this.formatter = formatter;
    }

    /**
     * Text to display before the value
     * <p>
     * @return
     */
    public String getPrefix()
    {
        return prefix;
    }

    /**
     * Text to display before the prefix
     * <p>
     * @param prefix
     */
    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
    }

    /**
     * The string to pass to the formatter
     * <p>
     * @return
     */
    public String getFormatString()
    {
        return formatString;
    }

    /**
     * The string to pass to the formatter
     * <p>
     * @param formatString
     */
    public void setFormatString(String formatString)
    {
        this.formatString = formatString;
    }

    /**
     * The CSS Font Family
     * <p>
     * @return
     */
    public FontFamilies getFontFamily()
    {
        return fontFamily;
    }

    /**
     * The CSS Font Family
     * <p>
     * @param fontFamily
     */
    public void setFontFamily(FontFamilies fontFamily)
    {
        this.fontFamily = fontFamily;
    }

    /**
     * The font size setting
     * <p>
     * @return
     */
    public Integer getFontSize()
    {
        return fontSize;
    }

    /**
     * The font size setting
     * <p>
     * @param fontSize
     */
    public void setFontSize(Integer fontSize)
    {
        this.fontSize = fontSize;
    }

    /**
     * The text colour
     * <p>
     * @return
     */
    public ColourHex getTextColor()
    {
        return textColor;
    }

    /**
     * The text colour
     * <p>
     * @param textColor
     */
    public void setTextColor(ColourHex textColor)
    {
        this.textColor = textColor;
    }

    /**
     * Escape html characters in the axis label or not
     * <p>
     * @return
     */
    public Boolean getEscapeHTML()
    {
        return escapeHTML;
    }

    /**
     * Escape html characters in the axis label or not
     * <p>
     * @param escapeHTML
     */
    public void setEscapeHTML(Boolean escapeHTML)
    {
        this.escapeHTML = escapeHTML;
    }

    /**
     * ‘auto’, ‘start’, ‘middle’ or ‘end’.
     * <p>
     * @return
     */
    public String getLabelPosition()
    {
        return labelPosition;
    }

    /**
     * ‘auto’, ‘start’, ‘middle’ or ‘end’.
     * <p>
     * @param labelPosition
     */
    public void setLabelPosition(String labelPosition)
    {
        this.labelPosition = labelPosition;
    }

    @Override
    @JsonRawValue
    public String getRenderer()
    {
        return "$.jqplot.CanvasAxisTickRenderer";
    }
}
