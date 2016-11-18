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
public class BorderTopCSSImpl implements BorderTopCSS
{

    public BorderTopCSSImpl()
    {
    }

    @Override
    public String toString()
    {
        String out = "";
        out += Border_Top_Width + " ";
        out += Border_Top_Style + " ";
        out += Border_Top_Color + " ";
        out += Border_Top_Color$ + " ";
        out = out.replaceAll("null", "");
        out = out.trim();
        return out;
    }

    private ColourCSS Border_Top_Color;
    private ColourNames Border_Top_Color$;
    private BorderStyles Border_Top_Style;
    private MeasurementCSS Border_Top_Width;

    @Override
    public Class<? extends Annotation> annotationType()
    {
        return BorderCSS.class;
    }

    /**
     * Sets the width of the right border
     *
     * @return
     */
    @Override
    public ColourCSS Border_Top_Color()
    {
        return Border_Top_Color;
    }

    /**
     * Sets the width of the top border
     *
     * @return
     */
    @Override
    public ColourNames Border_Top_Color$()
    {
        return Border_Top_Color$;
    }

    /**
     * Gets the style of the top border
     *
     * @return
     */
    @Override
    public BorderStyles Border_Top_Style()
    {
        return Border_Top_Style;
    }

    /**
     * Sets the style of the top border
     *
     * @return
     */
    @Override
    public MeasurementCSS Border_Top_Width()
    {
        return Border_Top_Width;
    }

    /**
     * Sets the top colour for the border
     *
     * @param Border_Top_Color
     */
    public void setBorder_Top_Color(ColourCSS Border_Top_Color)
    {
        this.Border_Top_Color = Border_Top_Color;
    }

    /**
     * Sets the top colour for the border
     *
     * @param Border_Top_Color$
     */
    public void setBorder_Top_Color$(ColourNames Border_Top_Color$)
    {
        this.Border_Top_Color$ = Border_Top_Color$;
    }

    /**
     * Sets the top style for the border
     *
     * @param Border_Top_Style
     */
    public void setBorder_Top_Style(BorderStyles Border_Top_Style)
    {
        this.Border_Top_Style = Border_Top_Style;
    }

    /**
     * Sets the top width for the border
     *
     * @param Border_Top_Width
     */
    public void setBorder_Top_Width(MeasurementCSS Border_Top_Width)
    {
        this.Border_Top_Width = Border_Top_Width;
    }

}
