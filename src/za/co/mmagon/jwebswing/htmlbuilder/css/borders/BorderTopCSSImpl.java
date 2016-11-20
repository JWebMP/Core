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
public class BorderTopCSSImpl extends CSSImplementationAdapter<BorderTopCSS, BorderTopCSSImpl> implements CSSImplementationClass<BorderTopCSS, BorderTopCSSImpl>
{

    private static final long serialVersionUID = 1L;

    @CSSDetail(cssName = "border-top-color", cssVersion = CSSVersions.CSS21)
    private ColourCSSImpl borderTopColor;
    @CSSDetail(cssName = "border-top-color", cssVersion = CSSVersions.CSS21)
    private ColourNames borderTopColor$;
    @CSSDetail(cssName = "border-top-style", cssVersion = CSSVersions.CSS21)
    private BorderStyles borderTopStyle;
    @CSSDetail(cssName = "border-top-width", cssVersion = CSSVersions.CSS21)
    private MeasurementCSSImpl borderTopWidth;

    public BorderTopCSSImpl()
    {
    }

    @Override
    public String toString()
    {
        String out = "";
        out += borderTopWidth + " ";
        out += borderTopStyle + " ";
        out += borderTopColor + " ";
        out += borderTopColor$ + " ";
        out = out.replaceAll("null", "");
        out = out.trim();
        return out;
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
     * Sets the top colour for the border
     *
     * @param borderTopColor
     */
    public void setBorderTopColor(ColourCSSImpl borderTopColor)
    {
        this.borderTopColor = borderTopColor;
    }

    /**
     * Sets the top colour for the border
     *
     * @param borderTopColor$
     */
    public void setBorderTopColor$(ColourNames borderTopColor$)
    {
        this.borderTopColor$ = borderTopColor$;
    }

    /**
     * Sets the top style for the border
     *
     * @param borderTopStyle
     */
    public void setBorderTopStyle(BorderStyles borderTopStyle)
    {
        this.borderTopStyle = borderTopStyle;
    }

    /**
     * Sets the top width for the border
     *
     * @param borderTopWidth
     */
    public void setBorderTopWidth(MeasurementCSSImpl borderTopWidth)
    {
        this.borderTopWidth = borderTopWidth;
    }

}
