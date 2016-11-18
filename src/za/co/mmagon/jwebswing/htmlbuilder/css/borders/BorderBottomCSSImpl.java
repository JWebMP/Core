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

import java.lang.annotation.Annotation;
import za.co.mmagon.jwebswing.htmlbuilder.css.enumarations.BorderStyles;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourCSS;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourNames;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementCSS;

/**
 * CSS Border Properties
 * <p>
 * The CSS border properties allow you to specify the style, width, and color of an element's border.
 * <p>
 * @author GedMarc
 * @since 18 Jan 2016
 */
public class BorderBottomCSSImpl implements BorderBottomCSS
{

    public BorderBottomCSSImpl()
    {
    }

    @Override
    public String toString()
    {
        String out = "";
        out += Border_Bottom_Width + " ";
        out += Border_Bottom_Style + " ";
        out += Border_Bottom_Color + " ";
        out += Border_Bottom_Color$ + " ";
        out = out.replaceAll("null", "");
        out = out.trim();
        return out;
    }

    private ColourCSS Border_Bottom_Color;
    private ColourNames Border_Bottom_Color$;
    private BorderStyles Border_Bottom_Style;
    private MeasurementCSS Border_Bottom_Width;

    @Override
    public Class<? extends Annotation> annotationType()
    {
        return BorderCSS.class;
    }

    /**
     * Sets the color of the bottom border
     *
     * @return
     */
    @Override
    public ColourCSS Border_Bottom_Color()
    {
        return Border_Bottom_Color;
    }

    /**
     * sets the colour of the bottom border
     *
     * @return
     */
    @Override
    public ColourNames Border_Bottom_Color$()
    {
        return Border_Bottom_Color$;
    }

    /**
     * Sets the style of the bottom border
     *
     * @return
     */
    @Override
    public BorderStyles Border_Bottom_Style()
    {
        return Border_Bottom_Style;
    }

    /**
     * Sets the width of the bottom border
     *
     * @return
     */
    @Override
    public MeasurementCSS Border_Bottom_Width()
    {
        return Border_Bottom_Width;
    }

    /**
     * Sets the border bottom color
     *
     * @param Border_Bottom_Color
     */
    public void setBorder_Bottom_Color(ColourCSS Border_Bottom_Color)
    {
        this.Border_Bottom_Color = Border_Bottom_Color;
    }

    /**
     * Sets the border bottom color
     *
     * @param Border_Bottom_Color$
     */
    public void setBorder_Bottom_Color$(ColourNames Border_Bottom_Color$)
    {
        this.Border_Bottom_Color$ = Border_Bottom_Color$;
    }

    /**
     * Sets the style of the bottom border
     *
     * @param Border_Bottom_Style
     */
    public void setBorder_Bottom_Style(BorderStyles Border_Bottom_Style)
    {
        this.Border_Bottom_Style = Border_Bottom_Style;
    }

    /**
     * Sets the width of the bottom border
     *
     * @param Border_Bottom_Width
     */
    public void setBorder_Bottom_Width(MeasurementCSS Border_Bottom_Width)
    {
        this.Border_Bottom_Width = Border_Bottom_Width;
    }

}
