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
package za.co.mmagon.jwebswing.htmlbuilder.css.outline;

import java.lang.annotation.Annotation;
import za.co.mmagon.jwebswing.htmlbuilder.css.BorderStyles;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourCSS;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourNames;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementCSS;

/**
 * An outline is a line drawn around an element - outside the border. This can be use to make an element "stand out".
 * <p>
 * The CSS outline properties specify the style, color, and width of an outline.
 *
 * @author GedMarc
 * @since 18 Jan 2016
 */
public class OutlineCSSImpl implements OutlineCSS
{

    public OutlineCSSImpl()
    {
    }

    private ColourCSS Outline_Color;
    private ColourNames Outline_Color$;
    private BorderStyles Outline_Style;
    private MeasurementCSS Outline_Width;
    private MeasurementCSS Outline_Offset;

    @Override
    public Class<? extends Annotation> annotationType()
    {
        return OutlineCSS.class;
    }

    /**
     * Sets the color of an outline
     *
     * @return
     */
    @Override
    public ColourCSS Outline_Color()
    {
        return Outline_Color;
    }

    /**
     * Sets the color of an outline
     *
     * @return
     */
    @Override
    public ColourNames Outline_Color$()
    {
        return Outline_Color$;
    }

    /**
     * Sets the Outline Style
     *
     * @return
     */
    @Override
    public BorderStyles Outline_Style()
    {
        return Outline_Style;
    }

    /**
     * Sets the outline Width
     *
     * @return
     */
    @Override
    public MeasurementCSS Outline_Width()
    {
        return Outline_Width;
    }

    /**
     * Sets the outline Offset
     *
     * @return
     */
    @Override
    public MeasurementCSS Outline_Offset()
    {
        return Outline_Offset;
    }

    /**
     * Sets the outline Color
     */
    public void setOutline_Color(ColourCSS Outline_Color)
    {
        this.Outline_Color = Outline_Color;
    }

    /**
     * Sets the outline Color
     */
    public void setOutline_Color$(ColourNames Outline_Color$)
    {
        this.Outline_Color$ = Outline_Color$;
    }

    /**
     * Sets the Outline Style
     *
     * @param Outline_Style
     */
    public void setOutline_Style(BorderStyles Outline_Style)
    {
        this.Outline_Style = Outline_Style;
    }

    /**
     * Sets the outline width
     */
    public void setOutline_Width(MeasurementCSS Outline_Width)
    {
        this.Outline_Width = Outline_Width;
    }

    /**
     * Sets the outline offset
     */
    public void setOutline_Offset(MeasurementCSS Outline_Offset)
    {
        this.Outline_Offset = Outline_Offset;
    }

}
