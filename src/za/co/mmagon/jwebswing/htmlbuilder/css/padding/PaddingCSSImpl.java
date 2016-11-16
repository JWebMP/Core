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
 * The CSS margin properties are used to generate space around elements.
 * <p>
 * The margin properties set the size of the white space INSIDE the border.
 * <p>
 *
 * @author GedMarc
 * @since 18 Jan 2016
 */
public class PaddingCSSImpl implements PaddingCSS
{

    public PaddingCSSImpl()
    {
    }

    @Override
    public Class<? extends Annotation> annotationType()
    {
        return PaddingCSS.class;
    }

    private Padding Padding;
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
     * <p>
     */
    public void setPadding_Right(MeasurementCSS Padding_Right)
    {
        this.Padding_Right = Padding_Right;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     * <p>
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

    /**
     * Shorthand for Padding
     *
     * @return
     */
    @Override
    public za.co.mmagon.jwebswing.htmlbuilder.css.padding.Padding Padding()
    {
        return Padding;
    }

    /**
     * Set the shorthand for the margin.
     * <p>
     * If the margin property has four values:
     * <p>
     * <p>
     * margin: 25px 50px 75px 100px;
     * <p>
     * top margin is 25px
     * <p>
     * right margin is 50px
     * <p>
     * bottom margin is 75px
     * <p>
     * left margin is 100px
     * <p>
     * <p>
     * If the margin property has three values:
     * <p>
     * <p>
     * margin: 25px 50px 75px;
     * <p>
     * top margin is 25px
     * <p>
     * right and left margins are 50px
     * <p>
     * bottom margin is 75px
     * <p>
     * <p>
     * If the margin property has two values:
     * <p>
     * <p>
     * margin: 25px 50px;
     * <p>
     * top and bottom margins are 25px
     * <p>
     * right and left margins are 50px
     * <p>
     * <p>
     * If the margin property has one value:
     * <p>
     * <p>
     * margin: 25px;
     * <p>
     * all four margins are 25px
     *
     *
     * @param Padding
     */
    public void setPadding(za.co.mmagon.jwebswing.htmlbuilder.css.padding.Padding Padding)
    {
        this.Padding = Padding;
    }
}
