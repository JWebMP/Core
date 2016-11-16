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
public class BorderCSSImpl implements BorderCSS
{

    public BorderCSSImpl()
    {
    }

    private ColourCSS Border_Bottom_Color;
    private ColourNames Border_Bottom_Color$;
    private BorderStyles Border_Bottom_Style;
    private MeasurementCSS Border_Bottom_Width;
    private ColourCSS Border_Left_Color;
    private ColourNames Border_Left_Color$;
    private BorderStyles Border_Left_Style;
    private MeasurementCSS Border_Left_Width;
    private ColourCSS Border_Right_Color;
    private ColourNames Border_Right_Color$;
    private BorderStyles Border_Right_Style;
    private MeasurementCSS Border_Right_Width;
    private ColourCSS Border_Top_Color;
    private ColourNames Border_Top_Color$;
    private BorderStyles Border_Top_Style;
    private MeasurementCSS Border_Top_Width;

    private za.co.mmagon.jwebswing.htmlbuilder.css.borders.Border Border;

    private BorderBottomCSS Border_Bottom;

    private BorderBottomCSS Border_Left;

    private BorderBottomCSS Border_Right;

    private BorderBottomCSS Border_Top;

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

    /**
     * Provides a short hand for setting all border at once
     *
     * @return
     */
    @Override
    public za.co.mmagon.jwebswing.htmlbuilder.css.borders.Border Border()
    {
        return Border;
    }

    /**
     * Provides a short hand for setting bottom border
     *
     * @return
     */
    @Override
    public BorderBottomCSS Border_Bottom()
    {
        return Border_Bottom;
    }

    /**
     * Provides a short hand for setting bottom border
     *
     * @return
     */
    @Override
    public BorderBottomCSS Border_Left()
    {
        return Border_Left;
    }

    /**
     * Provides a short hand for setting bottom border
     *
     * @return
     */
    @Override
    public BorderBottomCSS Border_Right()
    {
        return Border_Right;
    }

    /**
     * Provides a short hand for setting bottom border
     *
     * @return
     */
    @Override
    public BorderBottomCSS Border_Top()
    {
        return Border_Top;
    }

}
