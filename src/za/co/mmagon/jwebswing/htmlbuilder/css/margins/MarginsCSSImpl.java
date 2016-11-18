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
 * The CSS margin properties are used to generate space around elements.
 * <p>
 * The margin properties set the size of the white space OUTSIDE the border.
 * <p>
 *
 * @author GedMarc
 * @since 18 Jan 2016
 */
public class MarginsCSSImpl implements MarginsCSS
{

    public MarginsCSSImpl()
    {
    }

    @Override
    public Class<? extends Annotation> annotationType()
    {
        return MarginsCSS.class;
    }

    private Margin Margin;
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

    /**
     * Shorthand for Margin
     *
     * @return
     */
    @Override
    public za.co.mmagon.jwebswing.htmlbuilder.css.margins.Margin Margin()
    {
        return Margin;
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
     * @param Margin
     */
    public void setMargin(za.co.mmagon.jwebswing.htmlbuilder.css.margins.Margin Margin)
    {
        this.Margin = Margin;
    }
}
