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
public class BorderLeftCSSImpl extends CSSImplementationAdapter<BorderLeftCSS, BorderLeftCSSImpl> implements CSSImplementationClass<BorderLeftCSS, BorderLeftCSSImpl>
{

    private static final long serialVersionUID = 1L;

    @CSSDetail(cssName = "border-left-color", cssVersion = CSSVersions.CSS21)
    private ColourCSSImpl borderLeftColor;
    @CSSDetail(cssName = "border-left-color", cssVersion = CSSVersions.CSS21)
    private ColourNames borderLeftColor$;
    @CSSDetail(cssName = "border-left-style", cssVersion = CSSVersions.CSS21)
    private BorderStyles borderLeftStyle;
    @CSSDetail(cssName = "border-left-width", cssVersion = CSSVersions.CSS21)
    private MeasurementCSSImpl borderLeftWidth;

    public BorderLeftCSSImpl()
    {
    }

    @Override
    public String toString()
    {
        String out = "";
        out += borderLeftWidth + " ";
        out += borderLeftStyle + " ";
        out += borderLeftColor + " ";
        out += borderLeftColor$ + " ";
        out = out.replaceAll("null", "");
        out = out.trim();
        return out;
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
     * Sets the border width
     *
     * @param borderLeftColor
     */
    public void setBorderLeftColor(ColourCSSImpl borderLeftColor)
    {
        this.borderLeftColor = borderLeftColor;
    }

    /**
     * Sets the border colour
     *
     * @param borderLeftColor$
     */
    public void setBorderLeftColor$(ColourNames borderLeftColor$)
    {
        this.borderLeftColor$ = borderLeftColor$;
    }

    /**
     * Sets the border style
     *
     * @param borderLeftStyle
     */
    public void setBorderLeftStyle(BorderStyles borderLeftStyle)
    {
        this.borderLeftStyle = borderLeftStyle;
    }

    /**
     * Sets the border width
     *
     * @param borderLeftWidth
     */
    public void setBorderLeftWidth(MeasurementCSSImpl borderLeftWidth)
    {
        this.borderLeftWidth = borderLeftWidth;
    }

}
