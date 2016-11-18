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
public class BorderRightCSSImpl implements BorderRightCSS
{

    public BorderRightCSSImpl()
    {
    }

    @Override
    public String toString()
    {
        String out = "";
        out += Border_Right_Width + " ";
        out += Border_Right_Style + " ";
        out += Border_Right_Color + " ";
        out += Border_Right_Color$ + " ";
        out = out.replaceAll("null", "");
        out = out.trim();
        return out;
    }

    private ColourCSS Border_Right_Color;
    private ColourNames Border_Right_Color$;
    private BorderStyles Border_Right_Style;
    private MeasurementCSS Border_Right_Width;

    @Override
    public Class<? extends Annotation> annotationType()
    {
        return BorderCSS.class;
    }

    /**
     * Gets the colour of the right border
     *
     * @return
     */
    @Override
    public ColourCSS Border_Right_Color()
    {
        return Border_Right_Color;
    }

    /**
     * Sets the colour of the right border
     *
     * @return
     */
    @Override
    public ColourNames Border_Right_Color$()
    {
        return Border_Right_Color$;
    }

    /**
     * Gets the style of the right border
     *
     * @return
     */
    @Override
    public BorderStyles Border_Right_Style()
    {
        return Border_Right_Style;
    }

    /**
     * Gets the width of the right border
     *
     * @return
     */
    @Override
    public MeasurementCSS Border_Right_Width()
    {
        return Border_Right_Width;
    }

    /**
     * Sets the colour of the right border
     *
     * @param Border_Right_Color
     */
    public void setBorder_Right_Color(ColourCSS Border_Right_Color)
    {
        this.Border_Right_Color = Border_Right_Color;
    }

    /**
     * Sets the colour of the right border
     *
     * @param Border_Right_Color$
     */
    public void setBorder_Right_Color$(ColourNames Border_Right_Color$)
    {
        this.Border_Right_Color$ = Border_Right_Color$;
    }

    /**
     * Sets the style of the right border
     *
     * @param Border_Right_Style
     */
    public void setBorder_Right_Style(BorderStyles Border_Right_Style)
    {
        this.Border_Right_Style = Border_Right_Style;
    }

    /**
     * Sets the width of the right border
     *
     * @param Border_Right_Width
     */
    public void setBorder_Right_Width(MeasurementCSS Border_Right_Width)
    {
        this.Border_Right_Width = Border_Right_Width;
    }

}
