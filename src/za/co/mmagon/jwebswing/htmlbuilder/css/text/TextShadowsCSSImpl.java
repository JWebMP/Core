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

import java.lang.annotation.Annotation;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourCSS;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementCSS;

/**
 *
 * @author GedMarc
 * @since 18 Jan 2016
 */
public class TextShadowsCSSImpl implements TextShadows
{

    public TextShadowsCSSImpl()
    {
    }

    private MeasurementCSS H_Shadow;
    private MeasurementCSS V_Shadow;
    private MeasurementCSS Blur_Radius;
    private ColourCSS Color;

    @Override
    public Class<? extends Annotation> annotationType()
    {
        return TextShadows.class;
    }

    /**
     * Required. The position of the horizontal shadow. Negative values are allowed
     *
     * @return
     */
    @Override
    public MeasurementCSS H_Shadow()
    {
        return H_Shadow;
    }

    /**
     * Required. The position of the vertical shadow. Negative values are allowed
     *
     * @return
     */
    @Override
    public MeasurementCSS V_Shadow()
    {
        return V_Shadow;
    }

    /**
     * Optional. The blur radius. Default value is 0
     *
     * @return
     */
    @Override
    public MeasurementCSS Blur_Radius()
    {
        return Blur_Radius;
    }

    /**
     * Sets the colour
     *
     * @return
     */
    @Override
    public ColourCSS Color()
    {
        return Color;
    }

    /**
     * Required. The position of the horizontal shadow. Negative values are allowed
     * <p>
     */
    public void setH_Shadow(MeasurementCSS H_Shadow)
    {
        this.H_Shadow = H_Shadow;
    }

    /**
     * Required. The position of the vertical shadow. Negative values are allowed
     * <p>
     */
    public void setV_Shadow(MeasurementCSS V_Shadow)
    {
        this.V_Shadow = V_Shadow;
    }

    /**
     * Sets the blur radius Default is 0
     *
     * @param Blur_Radius
     */
    public void setBlur_Radius(MeasurementCSS Blur_Radius)
    {
        this.Blur_Radius = Blur_Radius;
    }

    /**
     * Set the colour
     *
     * @param Color
     */
    public void setColor(ColourCSS Color)
    {
        this.Color = Color;
    }

}
