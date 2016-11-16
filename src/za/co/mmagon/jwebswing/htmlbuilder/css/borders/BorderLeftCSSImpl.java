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
import za.co.mmagon.jwebswing.htmlbuilder.css.BorderStyles;
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
public class BorderLeftCSSImpl implements BorderLeftCSS
{

    public BorderLeftCSSImpl()
    {
    }

    @Override
    public String toString()
    {
        String out = "";
        out += Border_Left_Width + " ";
        out += Border_Left_Style + " ";
        out += Border_Left_Color + " ";
        out += Border_Left_Color$ + " ";
        out = out.replaceAll("null", "");
        out = out.trim();
        return out;
    }

    private ColourCSS Border_Left_Color;
    private ColourNames Border_Left_Color$;
    private BorderStyles Border_Left_Style;
    private MeasurementCSS Border_Left_Width;

    @Override
    public Class<? extends Annotation> annotationType()
    {
        return BorderCSS.class;
    }

    /**
     * Gets the colour of the bottom left border
     *
     * @return
     */
    @Override
    public ColourCSS Border_Left_Color()
    {
        return Border_Left_Color;
    }

    /**
     * Gets the colour of the left border
     *
     * @return
     */
    @Override
    public ColourNames Border_Left_Color$()
    {
        return Border_Left_Color$;
    }

    /**
     * Gets the style of the left border
     *
     * @return
     */
    @Override
    public BorderStyles Border_Left_Style()
    {
        return Border_Left_Style;
    }

    /**
     * Sets the style of the left border
     *
     * @return
     */
    @Override
    public MeasurementCSS Border_Left_Width()
    {
        return Border_Left_Width;
    }

    /**
     * Sets the colour of the left border
     *
     * @param Border_Left_Color
     */
    public void setBorder_Left_Color(ColourCSS Border_Left_Color)
    {
        this.Border_Left_Color = Border_Left_Color;
    }

    /**
     * Sets the colour of the left border
     *
     * @param Border_Left_Color$
     */
    public void setBorder_Left_Color$(ColourNames Border_Left_Color$)
    {
        this.Border_Left_Color$ = Border_Left_Color$;
    }

    /**
     * Sets the style of the left border
     *
     * @param Border_Left_Style
     */
    public void setBorder_Left_Style(BorderStyles Border_Left_Style)
    {
        this.Border_Left_Style = Border_Left_Style;
    }

    /**
     * Sets the width of the left border
     *
     * @param Border_Left_Width
     */
    public void setBorder_Left_Width(MeasurementCSS Border_Left_Width)
    {
        this.Border_Left_Width = Border_Left_Width;
    }

}
