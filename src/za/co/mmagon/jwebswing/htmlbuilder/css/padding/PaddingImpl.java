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
package za.co.mmagon.jwebswing.htmlbuilder.css.padding;

import java.lang.annotation.Annotation;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementCSS;

/**
 * To shorten the code, it is possible to specify all the margin properties in one property.
 *
 * @author GedMarc
 * @since 18 Jan 2016
 */
public class PaddingImpl implements Padding
{

    public PaddingImpl()
    {
    }

    @Override
    public String toString()
    {
        String out = "";
        out += Padding_Top + " ";
        out += Padding_Top$ + " ";
        out += Padding_Right + " ";
        out += Padding_Right$ + " ";
        out += Padding_Bottom + " ";
        out += Padding_Bottom$ + " ";
        out += Padding_Left + " ";
        out += Padding_Left$ + " ";
        out = out.replaceAll("null", "");
        out = out.trim();
        return out;
    }

    private MeasurementCSS Padding_Right;
    private PaddingSetting Padding_Right$;
    private MeasurementCSS Padding_Left;
    private PaddingSetting Padding_Left$;
    private MeasurementCSS Padding_Top;
    private PaddingSetting Padding_Top$;
    private MeasurementCSS Padding_Bottom;
    private PaddingSetting Padding_Bottom$;

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    @Override
    public MeasurementCSS Padding_Right()
    {
        return Padding_Right;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    @Override
    public PaddingSetting Padding_Right$()
    {
        return Padding_Right$;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    @Override
    public MeasurementCSS Padding_Left()
    {
        return Padding_Left;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    @Override
    public PaddingSetting Padding_Left$()
    {
        return Padding_Left$;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    @Override
    public MeasurementCSS Padding_Top()
    {
        return Padding_Top;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     * <p>
     */
    public void setPadding_Right(MeasurementCSS Padding_Right)
    {
        this.Padding_Right = Padding_Right;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     * <p>
     */
    public void setPadding_Right$(PaddingSetting Padding_Right$)
    {
        this.Padding_Right$ = Padding_Right$;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     * <p>
     * <p>
     */
    public void setPadding_Left(MeasurementCSS Padding_Left)
    {
        this.Padding_Left = Padding_Left;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     * <p>
     * <p>
     */
    public void setPadding_Left$(PaddingSetting Padding_Left$)
    {
        this.Padding_Left$ = Padding_Left$;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     * <p>
     */
    public void setPadding_Top(MeasurementCSS Padding_Top)
    {
        this.Padding_Top = Padding_Top;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    @Override
    public PaddingSetting Padding_Top$()
    {
        return Padding_Top$;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    @Override
    public MeasurementCSS Padding_Bottom()
    {
        return Padding_Bottom;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    @Override
    public PaddingSetting Padding_Bottom$()
    {
        return Padding_Bottom$;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @param Padding_Top$
     */
    public void setPadding_Top$(PaddingSetting Padding_Top$)
    {
        this.Padding_Top$ = Padding_Top$;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @param Padding_Bottom
     */
    public void setPadding_Bottom(MeasurementCSS Padding_Bottom)
    {
        this.Padding_Bottom = Padding_Bottom;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @param Padding_Bottom$
     */
    public void setPadding_Bottom$(PaddingSetting Padding_Bottom$)
    {
        this.Padding_Bottom$ = Padding_Bottom$;
    }

    @Override
    public Class<? extends Annotation> annotationType()
    {
        return Padding.class;
    }
}
