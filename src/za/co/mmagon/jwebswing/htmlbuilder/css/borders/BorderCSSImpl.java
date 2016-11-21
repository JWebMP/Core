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
package za.co.mmagon.jwebswing.htmlbuilder.css.borders;

import za.co.mmagon.jwebswing.base.client.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.enumarations.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.*;

/**
 * CSS getBorder Properties
 * <p>
 * The CSS border properties allow you to specify the style, width, and color of an element's border.
 * <p>
 * @author GedMarc
 * @since 18 Jan 2016
 */
public class BorderCSSImpl extends CSSImplementationAdapter<BorderCSS, BorderCSSImpl> implements CSSImplementationClass<BorderCSS, BorderCSSImpl>
{

    @CSSDetail(cssName = "border-bottom-color", cssVersion = CSSVersions.CSS21)
    private ColourCSSImpl borderBottomColor;
    @CSSDetail(cssName = "border-bottom-color", cssVersion = CSSVersions.CSS21)
    private ColourNames borderBottomColor$;
    @CSSDetail(cssName = "border-bottom-style", cssVersion = CSSVersions.CSS21)
    private BorderStyles borderBottomStyle;
    @CSSDetail(cssName = "border-bottom-width", cssVersion = CSSVersions.CSS21)
    private MeasurementCSSImpl borderBottomWidth;
    @CSSDetail(cssName = "border-left-color", cssVersion = CSSVersions.CSS21)
    private ColourCSSImpl borderLeftColor;
    @CSSDetail(cssName = "border-left-color", cssVersion = CSSVersions.CSS21)
    private ColourNames borderLeftColor$;
    @CSSDetail(cssName = "border-left-Style", cssVersion = CSSVersions.CSS21)
    private BorderStyles borderLeftStyle;
    @CSSDetail(cssName = "border-left-width", cssVersion = CSSVersions.CSS21)
    private MeasurementCSSImpl borderLeftWidth;
    @CSSDetail(cssName = "border-right-color", cssVersion = CSSVersions.CSS21)
    private ColourCSSImpl borderRightColor;
    @CSSDetail(cssName = "border-right-color", cssVersion = CSSVersions.CSS21)
    private ColourNames borderRightColor$;
    @CSSDetail(cssName = "border-right-style", cssVersion = CSSVersions.CSS21)
    private BorderStyles borderRightStyle;
    @CSSDetail(cssName = "border-right-width", cssVersion = CSSVersions.CSS21)
    private MeasurementCSSImpl borderRightWidth;
    @CSSDetail(cssName = "border-top-color", cssVersion = CSSVersions.CSS21)
    private ColourCSSImpl borderTopColor;
    @CSSDetail(cssName = "border-top-color", cssVersion = CSSVersions.CSS21)
    private ColourNames borderTopColor$;
    @CSSDetail(cssName = "border-top-style", cssVersion = CSSVersions.CSS21)
    private BorderStyles borderTopStyle;
    @CSSDetail(cssName = "border-top-width", cssVersion = CSSVersions.CSS21)
    private MeasurementCSSImpl borderTopWidth;

    @CSSDetail(cssName = "border", cssVersion = CSSVersions.CSS21)
    private BorderImpl border;
    private BorderBottomCSSImpl borderBottom;
    @CSSDetail(cssName = "border-left", cssVersion = CSSVersions.CSS21)
    private BorderBottomCSSImpl borderLeft;
    @CSSDetail(cssName = "border-right", cssVersion = CSSVersions.CSS21)
    private BorderBottomCSSImpl borderRight;
    @CSSDetail(cssName = "border-top", cssVersion = CSSVersions.CSS21)
    private BorderBottomCSSImpl borderTop;

    private static final long serialVersionUID = 1L;

    /**
     * A default border
     */
    public BorderCSSImpl()
    {
        //Nothing needed to be done
    }

    /**
     * Sets the color of the bottom border
     *
     * @return
     */
    public ColourCSSImpl getBorderBottomColor()
    {
        return borderBottomColor;
    }

    /**
     * sets the colour of the bottom border
     *
     * @return
     */
    public ColourNames getBorderBottomColor$()
    {
        return borderBottomColor$;
    }

    /**
     * Sets the style of the bottom border
     *
     * @return
     */
    public BorderStyles getBorderBottomStyle()
    {
        return borderBottomStyle;
    }

    /**
     * Sets the width of the bottom border
     *
     * @return
     */
    public MeasurementCSSImpl getBorderBottomWidth()
    {
        return borderBottomWidth;
    }

    /**
     * Gets the colour of the bottom left border
     *
     * @return
     */
    public ColourCSSImpl getBorderLeftColor()
    {
        return borderLeftColor;
    }

    /**
     * Gets the colour of the left border
     *
     * @return
     */
    public ColourNames getBorderLeftColor$()
    {
        return borderLeftColor$;
    }

    /**
     * Gets the style of the left border
     *
     * @return
     */
    public BorderStyles getBorderLeftStyle()
    {
        return borderLeftStyle;
    }

    /**
     * Sets the style of the left border
     *
     * @return
     */
    public MeasurementCSSImpl getBorderLeftWidth()
    {
        return borderLeftWidth;
    }

    /**
     * Gets the colour of the right border
     *
     * @return
     */
    public ColourCSSImpl getBorderRightColor()
    {
        return borderRightColor;
    }

    /**
     * Sets the colour of the right border
     *
     * @return
     */
    public ColourNames getBorderRightColor$()
    {
        return borderRightColor$;
    }

    /**
     * Gets the style of the right border
     *
     * @return
     */
    public BorderStyles getBorderRightStyle()
    {
        return borderRightStyle;
    }

    /**
     * Gets the width of the right border
     *
     * @return
     */
    public MeasurementCSSImpl getBorderRightWidth()
    {
        return borderRightWidth;
    }

    /**
     * Sets the width of the right border
     *
     * @return
     */
    public ColourCSSImpl getBorderTopColor()
    {
        return borderTopColor;
    }

    /**
     * Sets the width of the top border
     *
     * @return
     */
    public ColourNames getBorderTopColor$()
    {
        return borderTopColor$;
    }

    /**
     * Gets the style of the top border
     *
     * @return
     */
    public BorderStyles getBorderTopStyle()
    {
        return borderTopStyle;
    }

    /**
     * Sets the style of the top border
     *
     * @return
     */
    public MeasurementCSSImpl getBorderTopWidth()
    {
        return borderTopWidth;
    }

    /**
     * Provides a short hand for setting all border at once
     *
     * @return
     */
    public BorderImpl getBorder()
    {
        return border;
    }

    /**
     * Provides a short hand for setting bottom border
     *
     * @return
     */
    public BorderBottomCSSImpl getBorderBottom()
    {
        return borderBottom;
    }

    /**
     * Provides a short hand for setting bottom border
     *
     * @return
     */
    public BorderBottomCSSImpl getBorderLeft()
    {
        return borderLeft;
    }

    /**
     * Provides a short hand for setting bottom border
     *
     * @return
     */
    public BorderBottomCSSImpl getBorderRight()
    {
        return borderRight;
    }

    /**
     * Provides a short hand for setting bottom border
     *
     * @return
     */
    public BorderBottomCSSImpl getBorderTop()
    {
        return borderTop;
    }

    /**
     * Sets the border bottom colour
     *
     * @param borderBottomColor
     */
    public void setBorderBottomColor(ColourCSSImpl borderBottomColor)
    {
        this.borderBottomColor = borderBottomColor;
    }

    /**
     * Sets the border bottom colour
     *
     * @param borderBottomColor$
     */
    public void setBorderBottomColor$(ColourNames borderBottomColor$)
    {
        this.borderBottomColor$ = borderBottomColor$;
    }

    /**
     * Sets the border bottom style
     *
     * @param borderBottomStyle
     */
    public void setBorderBottomStyle(BorderStyles borderBottomStyle)
    {
        this.borderBottomStyle = borderBottomStyle;
    }

    /**
     * Sets the border bottom style
     *
     * @param borderBottomWidth
     */
    public void setBorderBottomWidth(MeasurementCSSImpl borderBottomWidth)
    {
        this.borderBottomWidth = borderBottomWidth;
    }

    /**
     * Sets the border left colour
     *
     * @param borderLeftColor
     */
    public void setBorderLeftColor(ColourCSSImpl borderLeftColor)
    {
        this.borderLeftColor = borderLeftColor;
    }

    /**
     * Sets the border left colour
     *
     * @param borderLeftColor$
     */
    public void setBorderLeftColor$(ColourNames borderLeftColor$)
    {
        this.borderLeftColor$ = borderLeftColor$;
    }

    /**
     * Sets the border left colour
     *
     * @param borderLeftStyle
     */
    public void setBorderLeftStyle(BorderStyles borderLeftStyle)
    {
        this.borderLeftStyle = borderLeftStyle;
    }

    /**
     * Sets the border left width
     *
     * @param borderLeftWidth
     */
    public void setBorderLeftWidth(MeasurementCSSImpl borderLeftWidth)
    {
        this.borderLeftWidth = borderLeftWidth;
    }

    /**
     * Sets the border right colour
     *
     * @param borderRightColor
     */
    public void setBorderRightColor(ColourCSSImpl borderRightColor)
    {
        this.borderRightColor = borderRightColor;
    }

    /**
     * Sets the border right colour
     *
     * @param borderRightColor$
     */
    public void setBorderRightColor$(ColourNames borderRightColor$)
    {
        this.borderRightColor$ = borderRightColor$;
    }

    /**
     * Sets the border right style
     *
     * @param borderRightStyle
     */
    public void setBorderRightStyle(BorderStyles borderRightStyle)
    {
        this.borderRightStyle = borderRightStyle;
    }

    /**
     * Sets the border right width
     *
     * @param borderRightWidth
     */
    public void setBorderRightWidth(MeasurementCSSImpl borderRightWidth)
    {
        this.borderRightWidth = borderRightWidth;
    }

    /**
     * Sets the border top colour
     *
     * @param borderTopColor
     */
    public void setBorderTopColor(ColourCSSImpl borderTopColor)
    {
        this.borderTopColor = borderTopColor;
    }

    /**
     * Sets the border top colour
     *
     * @param borderTopColor$
     */
    public void setBorderTopColor$(ColourNames borderTopColor$)
    {
        this.borderTopColor$ = borderTopColor$;
    }

    /**
     * Sets the border top style
     *
     * @param borderTopStyle
     */
    public void setBorderTopStyle(BorderStyles borderTopStyle)
    {
        this.borderTopStyle = borderTopStyle;
    }

    /**
     * Sets the border width
     *
     * @param borderTopWidth
     */
    public void setBorderTopWidth(MeasurementCSSImpl borderTopWidth)
    {
        this.borderTopWidth = borderTopWidth;
    }

    /**
     * Sets the border
     *
     * @param border
     */
    public void setBorder(BorderImpl border)
    {
        this.border = border;
    }

    /**
     * Sets the border bottom
     *
     * @param borderBottom
     */
    public void setBorderBottom(BorderBottomCSSImpl borderBottom)
    {
        this.borderBottom = borderBottom;
    }

    /**
     * Sets the border left
     *
     * @param borderLeft
     */
    public void setBorderLeft(BorderBottomCSSImpl borderLeft)
    {
        this.borderLeft = borderLeft;
    }

    /**
     * Sets the border right
     *
     * @param borderRight
     */
    public void setBorderRight(BorderBottomCSSImpl borderRight)
    {
        this.borderRight = borderRight;
    }

    /**
     * Sets the border top
     *
     * @param borderTop
     */
    public void setBorderTop(BorderBottomCSSImpl borderTop)
    {
        this.borderTop = borderTop;
    }

}
