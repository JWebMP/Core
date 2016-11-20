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
 * To shorten the code, it is possible to specify all the margin properties in one property.
 *
 * @author GedMarc
 * @since 18 Jan 2016
 */
public class PaddingImpl extends CSSImplementationAdapter<Padding, PaddingImpl> implements CSSImplementationClass<Padding, PaddingImpl>
{

    private static final long serialVersionUID = 1L;

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
     * Constructs a new padding object
     */
    public PaddingImpl()
    {
        //nothing needed
    }

    @Override
    public String toString()
    {
        String out = "";
        out += paddingTop + " ";
        out += paddingTop$ + " ";
        out += paddingRight + " ";
        out += paddingRight$ + " ";
        out += paddingBottom + " ";
        out += paddingBottom$ + " ";
        out += paddingLeft + " ";
        out += paddingLeft$ + " ";
        out = out.replaceAll("null", "");
        out = out.trim();
        return out;
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
     * @param paddingRight
     */
    public void setPaddingRight(MeasurementCSSImpl paddingRight)
    {
        this.paddingRight = paddingRight;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
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
}
