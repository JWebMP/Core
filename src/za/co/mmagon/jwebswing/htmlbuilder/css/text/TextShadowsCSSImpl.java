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
package za.co.mmagon.jwebswing.htmlbuilder.css.text;

import za.co.mmagon.jwebswing.base.client.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.*;

/**
 * Defines text shadows
 *
 * @author GedMarc
 * @since 18 Jan 2016
 */
public class TextShadowsCSSImpl extends CSSImplementationAdapter<TextShadows, TextShadowsCSSImpl> implements CSSImplementationClass<TextShadows, TextShadowsCSSImpl>
{

    private static final long serialVersionUID = 1L;

    @CSSDetail(cssName = "h-shadow", cssVersion = CSSVersions.CSS21)
    private MeasurementCSSImpl hShadow;
    @CSSDetail(cssName = "v-shadow", cssVersion = CSSVersions.CSS21)
    private MeasurementCSSImpl vShadow;
    @CSSDetail(cssName = "blur-radius", cssVersion = CSSVersions.CSS21)
    private MeasurementCSSImpl blurRadius;
    @CSSDetail(cssName = "color", cssVersion = CSSVersions.CSS21)
    private ColourCSSImpl color;

    /**
     * Constructs a new text shadow instance
     */
    public TextShadowsCSSImpl()
    {
    }

    /**
     * Required. The position of the horizontal shadow. Negative values are allowed
     *
     * @return
     */
    public MeasurementCSSImpl getHShadow()
    {
        return hShadow;
    }

    /**
     * Required. The position of the vertical shadow. Negative values are allowed
     *
     * @return
     */
    public MeasurementCSSImpl getVShadow()
    {
        return vShadow;
    }

    /**
     * Optional. The blur radius. Default value is 0
     *
     * @return
     */
    public MeasurementCSSImpl getBlurRadius()
    {
        return blurRadius;
    }

    /**
     * Sets the colour
     *
     * @return
     */
    public ColourCSSImpl getColour()
    {
        return color;
    }

    /**
     * Required. The position of the horizontal shadow. Negative values are allowed
     * <p>
     * @param hShadow
     */
    public void sethShadow(MeasurementCSSImpl hShadow)
    {
        this.hShadow = hShadow;
    }

    /**
     * Required. The position of the vertical shadow. Negative values are allowed
     * <p>
     * @param vShadow
     */
    public void setvShadow(MeasurementCSSImpl vShadow)
    {
        this.vShadow = vShadow;
    }

    /**
     * Sets the blur radius Default is 0
     *
     * @param blurRadius
     */
    public void setBlurRadius(MeasurementCSSImpl blurRadius)
    {
        this.blurRadius = blurRadius;
    }

    /**
     * Set the colour
     *
     * @param Color
     */
    public void setColour(ColourCSSImpl Color)
    {
        this.color = Color;
    }

}
