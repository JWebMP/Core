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
 * CSS Border Properties
 * <p>
 * The CSS border properties allow you to specify the style, width, and color of an element's border.
 * <p>
 * @author GedMarc
 * @since 18 Jan 2016
 */
public class BorderRightCSSImpl extends CSSImplementationAdapter<BorderRightCSS, BorderRightCSSImpl> implements CSSImplementationClass<BorderRightCSS, BorderRightCSSImpl>
{

    private static final long serialVersionUID = 1L;

    @CSSDetail(cssName = "border-right-color", cssVersion = CSSVersions.CSS21)
    private ColourCSSImpl borderRightColor;
    @CSSDetail(cssName = "border-right-color", cssVersion = CSSVersions.CSS21)
    private ColourNames borderRightColor$;
    @CSSDetail(cssName = "border-right-style", cssVersion = CSSVersions.CSS21)
    private BorderStyles borderRightStyle;
    @CSSDetail(cssName = "border-right-width", cssVersion = CSSVersions.CSS21)
    private MeasurementCSSImpl borderRightWidth;

    public BorderRightCSSImpl()
    {
    }

    @Override
    public String toString()
    {
        String out = "";
        out += borderRightWidth + " ";
        out += borderRightStyle + " ";
        out += borderRightColor + " ";
        out += borderRightColor$ + " ";
        out = out.replaceAll("null", "");
        out = out.trim();
        return out;
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
     * Sets the border colour
     *
     * @param borderRightColor
     */
    public void setBorderRightColor(ColourCSSImpl borderRightColor)
    {
        this.borderRightColor = borderRightColor;
    }

    /**
     * Sets the border colour
     *
     * @param borderRightColor$
     */
    public void setBorderRightColor$(ColourNames borderRightColor$)
    {
        this.borderRightColor$ = borderRightColor$;
    }

    /**
     * Sets the border style
     *
     * @param borderRightStyle
     */
    public void setBorderRightStyle(BorderStyles borderRightStyle)
    {
        this.borderRightStyle = borderRightStyle;
    }

    /**
     * Sets the border width
     *
     * @param borderRightWidth
     */
    public void setBorderRightWidth(MeasurementCSSImpl borderRightWidth)
    {
        this.borderRightWidth = borderRightWidth;
    }

}
