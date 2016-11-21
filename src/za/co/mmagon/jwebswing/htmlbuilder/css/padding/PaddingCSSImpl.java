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

import za.co.mmagon.jwebswing.base.client.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.*;

/**
 * The CSS margin properties are used to generate space around elements.
 * <p>
 * The margin properties set the size of the white space INSIDE the border.
 * <p>
 *
 * @author GedMarc
 * @since 18 Jan 2016
 */
public class PaddingCSSImpl extends CSSImplementationAdapter<PaddingCSS, PaddingCSSImpl> implements CSSImplementationClass<PaddingCSS, PaddingCSSImpl>
{

    private static final long serialVersionUID = 1L;

    @CSSDetail(cssName = "padding", cssVersion = CSSVersions.CSS21)
    private PaddingImpl padding;
    @CSSDetail(cssName = "padding-right", cssVersion = CSSVersions.CSS21)
    private MeasurementCSSImpl paddingRight;
    @CSSDetail(cssName = "padding-right", cssVersion = CSSVersions.CSS21)
    private PaddingSetting paddingRight$;
    @CSSDetail(cssName = "padding-left", cssVersion = CSSVersions.CSS21)
    private MeasurementCSSImpl paddingLeft;
    @CSSDetail(cssName = "padding-left", cssVersion = CSSVersions.CSS21)
    private PaddingSetting paddingLeft$;
    @CSSDetail(cssName = "padding-top", cssVersion = CSSVersions.CSS21)
    private MeasurementCSSImpl paddingTop;
    @CSSDetail(cssName = "padding-top", cssVersion = CSSVersions.CSS21)
    private PaddingSetting paddingTop$;
    @CSSDetail(cssName = "padding-bottom", cssVersion = CSSVersions.CSS21)
    private MeasurementCSSImpl paddingBottom;
    @CSSDetail(cssName = "padding-bottom", cssVersion = CSSVersions.CSS21)
    private PaddingSetting paddingBottom$;

    /**
     * Constructs a new getPadding implementation
     */
    public PaddingCSSImpl()
    {
        //Nothing needed
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public MeasurementCSSImpl getPaddingRight()
    {
        return paddingRight;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public PaddingSetting getPaddingRight$()
    {
        return paddingRight$;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public MeasurementCSSImpl getPaddingLeft()
    {
        return paddingLeft;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public PaddingSetting getPaddingLeft$()
    {
        return paddingLeft$;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public MeasurementCSSImpl getPaddingTop()
    {
        return paddingTop;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     * <p>
     * <p>
     * @param paddingRight
     */
    public void setPaddingRight(MeasurementCSSImpl paddingRight)
    {
        this.paddingRight = paddingRight;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     * <p>
     * <p>
     * @param paddingRight$
     */
    public void setPaddingRight$(PaddingSetting paddingRight$)
    {
        this.paddingRight$ = paddingRight$;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     * <p>
     * <p>
     * @param paddingLeft
     */
    public void setPaddingLeft(MeasurementCSSImpl paddingLeft)
    {
        this.paddingLeft = paddingLeft;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     * <p>
     * <p>
     * @param paddingLeft$
     */
    public void setPaddingLeft$(PaddingSetting paddingLeft$)
    {
        this.paddingLeft$ = paddingLeft$;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     * <p>
     * <p>
     * @param paddingTop
     */
    public void setPaddingTop(MeasurementCSSImpl paddingTop)
    {
        this.paddingTop = paddingTop;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public PaddingSetting getPaddingTop$()
    {
        return paddingTop$;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public MeasurementCSSImpl getPaddingBottom()
    {
        return paddingBottom;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public PaddingSetting getPaddingBottom$()
    {
        return paddingBottom$;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @param paddingTop$
     */
    public void setPaddingTop$(PaddingSetting paddingTop$)
    {
        this.paddingTop$ = paddingTop$;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @param paddingBottom
     */
    public void setPaddingBottom(MeasurementCSSImpl paddingBottom)
    {
        this.paddingBottom = paddingBottom;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @param paddingBottom$
     */
    public void setPaddingBottom$(PaddingSetting paddingBottom$)
    {
        this.paddingBottom$ = paddingBottom$;
    }

    /**
     * Shorthand for getPadding
     *
     * @return
     */
    public PaddingImpl getPadding()
    {
        return padding;
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
    public void setPadding(PaddingImpl Padding)
    {
        this.padding = Padding;
    }
}
