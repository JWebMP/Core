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
package za.co.mmagon.jwebswing.htmlbuilder.css.margins;

import java.lang.annotation.Annotation;
import za.co.mmagon.jwebswing.htmlbuilder.css.enumarations.MarginSetting;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementCSS;

/**
 * To shorten the code, it is possible to specify all the margin properties in one property.
 *
 * @author GedMarc
 * @since 18 Jan 2016
 */
public class MarginImpl implements Margin
{

    public MarginImpl()
    {
    }

    @Override
    public String toString()
    {
        String out = "";
        out += Margin_Top + " ";
        out += Margin_Top$ + " ";
        out += Margin_Right + " ";
        out += Margin_Right$ + " ";
        out += Margin_Bottom + " ";
        out += Margin_Bottom$ + " ";
        out += Margin_Left + " ";
        out += Margin_Left$ + " ";
        out = out.replaceAll("null", "");
        out = out.trim();
        return out;
    }

    private MeasurementCSS Margin_Right;
    private MarginSetting Margin_Right$;
    private MeasurementCSS Margin_Left;
    private MarginSetting Margin_Left$;
    private MeasurementCSS Margin_Top;
    private MarginSetting Margin_Top$;
    private MeasurementCSS Margin_Bottom;
    private MarginSetting Margin_Bottom$;

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    @Override
    public MeasurementCSS Margin_Right()
    {
        return Margin_Right;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    @Override
    public MarginSetting Margin_Right$()
    {
        return Margin_Right$;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    @Override
    public MeasurementCSS Margin_Left()
    {
        return Margin_Left;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    @Override
    public MarginSetting Margin_Left$()
    {
        return Margin_Left$;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    @Override
    public MeasurementCSS Margin_Top()
    {
        return Margin_Top;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     * <p>
     */
    public void setMargin_Right(MeasurementCSS Margin_Right)
    {
        this.Margin_Right = Margin_Right;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     * <p>
     */
    public void setMargin_Right$(MarginSetting Margin_Right$)
    {
        this.Margin_Right$ = Margin_Right$;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     * <p>
     */
    public void setMargin_Left(MeasurementCSS Margin_Left)
    {
        this.Margin_Left = Margin_Left;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     * <p>
     */
    public void setMargin_Left$(MarginSetting Margin_Left$)
    {
        this.Margin_Left$ = Margin_Left$;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     * <p>
     */
    public void setMargin_Top(MeasurementCSS Margin_Top)
    {
        this.Margin_Top = Margin_Top;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    @Override
    public MarginSetting Margin_Top$()
    {
        return Margin_Top$;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    @Override
    public MeasurementCSS Margin_Bottom()
    {
        return Margin_Bottom;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    @Override
    public MarginSetting Margin_Bottom$()
    {
        return Margin_Bottom$;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @param Margin_Top$
     */
    public void setMargin_Top$(MarginSetting Margin_Top$)
    {
        this.Margin_Top$ = Margin_Top$;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @param Margin_Bottom
     */
    public void setMargin_Bottom(MeasurementCSS Margin_Bottom)
    {
        this.Margin_Bottom = Margin_Bottom;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @param Margin_Bottom$
     */
    public void setMargin_Bottom$(MarginSetting Margin_Bottom$)
    {
        this.Margin_Bottom$ = Margin_Bottom$;
    }

    @Override
    public Class<? extends Annotation> annotationType()
    {
        return Margin.class;
    }
}
