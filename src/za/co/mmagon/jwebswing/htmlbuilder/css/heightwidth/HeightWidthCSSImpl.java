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
package za.co.mmagon.jwebswing.htmlbuilder.css.heightwidth;

import java.lang.annotation.Annotation;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementCSS;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementCSSImpl;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementTypes;

/**
 *
 * @author GedMarc
 * @since 18 Jan 2016
 */
public class HeightWidthCSSImpl implements HeightWidthCSS
{

    public HeightWidthCSSImpl()
    {
    }

    private MeasurementCSS Height;
    private HeightSetting Height$;
    private MeasurementCSS Width;
    private WidthSetting Width$;
    private MeasurementCSS Min_Height;
    private MeasurementCSS Max_Height;
    private MeasurementCSS Min_Width;
    private MeasurementCSS Max_Width;

    @Override
    public Class<? extends Annotation> annotationType()
    {
        return HeightWidthCSS.class;
    }

    /**
     * Sets the height of an element
     *
     * @return
     */
    @Override
    public MeasurementCSS Height()
    {
        return Height;
    }

    /**
     * Sets the height of an element
     *
     * @return
     */
    @Override
    public HeightSetting Height$()
    {
        return Height$;
    }

    /**
     * Sets the width of an element
     *
     * @return
     */
    @Override
    public MeasurementCSS Width()
    {
        return Width;
    }

    /**
     * Sets the width of an element
     *
     * @return
     */
    @Override
    public WidthSetting Width$()
    {
        return Width$;
    }

    /**
     * Sets the min height of an element
     *
     * @return
     */
    @Override
    public MeasurementCSS Min_Height()
    {
        return Min_Height;
    }

    /**
     * Sets the max height of an element
     *
     * @return
     */
    @Override
    public MeasurementCSS Max_Height()
    {
        return Max_Height;
    }

    /**
     * Sets the min width of an element
     *
     * @return
     */
    @Override
    public MeasurementCSS Min_Width()
    {
        return Min_Width;
    }

    /**
     * Sets the max height of an element
     *
     * @return
     */
    @Override
    public MeasurementCSS Max_Width()
    {
        return Max_Width;
    }

    /**
     * Sets the height of an element
     *
     * @param Height
     */
    public void setHeight(MeasurementCSS Height)
    {
        this.Height = Height;
    }

    /**
     * Sets the height of an element
     *
     * @param Height$
     */
    public void setHeight$(HeightSetting Height$)
    {
        this.Height$ = Height$;
    }

    /**
     * Sets the width of an element
     *
     * @param Width
     */
    public void setWidth(MeasurementCSS Width)
    {
        this.Width = Width;
    }

    /**
     * Sets the width of an element
     *
     * @param Width$
     */
    public void setWidth$(WidthSetting Width$)
    {
        this.Width$ = Width$;
    }

    /**
     * Sets the width of an element
     *
     * @param Min_Height
     */
    public void setMin_Height(MeasurementCSS Min_Height)
    {
        this.Min_Height = Min_Height;
    }

    /**
     * Sets the width of an element
     *
     * @param Max_Height
     */
    public void setMax_Height(MeasurementCSS Max_Height)
    {
        this.Max_Height = Max_Height;
    }

    /**
     * Sets the width of an element
     *
     * @param Min_Width
     */
    public void setMin_Width(MeasurementCSS Min_Width)
    {
        this.Min_Width = Min_Width;
    }

    /**
     * Sets the width of an element
     *
     * @param Max_Width
     */
    public void setMax_Width(MeasurementCSS Max_Width)
    {
        this.Max_Width = Max_Width;
    }

    /**
     * Convenience method setting the Width
     * <p>
     * @param Width           The width to set
     * @param measurementType The measurement type
     */
    public void setWidth(int Width, MeasurementTypes measurementType)
    {
        setWidth(new MeasurementCSSImpl(Width, measurementType));
    }

    /**
     * Convenience method setting the inner HTML value - Default of Pixels
     * <p>
     * @param Width Width
     */
    public void setWidth(int Width)
    {
        setWidth(Width, MeasurementTypes.Pixels);
    }

    /**
     * Convenience method setting the Width
     * <p>
     * @param Width           The width to set
     * @param measurementType The measurement type
     */
    public void setHeight(int Width, MeasurementTypes measurementType)
    {
        setHeight(new MeasurementCSSImpl(Width, measurementType));
    }

    /**
     * Convenience method setting the inner HTML value - Default of Pixels
     * <p>
     * @param Width Width
     */
    public void setHeight(int Width)
    {
        setHeight(Width, MeasurementTypes.Pixels);
    }

    /**
     * Convenience method setting the Width
     * <p>
     * @param Width           The width to set
     * @param measurementType The measurement type
     */
    public void setMin_Width(int Width, MeasurementTypes measurementType)
    {
        setMin_Width(new MeasurementCSSImpl(Width, measurementType));
    }

    /**
     * Convenience method setting the inner HTML value - Default of Pixels
     * <p>
     * @param Width Width
     */
    public void setMin_Width(int Width)
    {
        setMin_Width(Width, MeasurementTypes.Pixels);
    }

    /**
     * Convenience method setting the Width
     * <p>
     * @param Width           The width to set
     * @param measurementType The measurement type
     */
    public void setMax_Width(int Width, MeasurementTypes measurementType)
    {
        setMax_Width(new MeasurementCSSImpl(Width, measurementType));
    }

    /**
     * Convenience method setting the inner HTML value - Default of Pixels
     * <p>
     * @param Width Width
     */
    public void setMax_Width(int Width)
    {
        setMax_Width(Width, MeasurementTypes.Pixels);
    }

    /**
     * Convenience method setting the Width
     * <p>
     * @param Width           The width to set
     * @param measurementType The measurement type
     */
    public void setMin_Height(int Width, MeasurementTypes measurementType)
    {
        setMin_Height(new MeasurementCSSImpl(Width, measurementType));
    }

    /**
     * Convenience method setting the inner HTML value - Default of Pixels
     * <p>
     * @param Width Width
     */
    public void setMin_Height(int Width)
    {
        setMin_Height(Width, MeasurementTypes.Pixels);
    }

    /**
     * Convenience method setting the Width
     * <p>
     * @param Width           The width to set
     * @param measurementType The measurement type
     */
    public void setMax_Height(int Width, MeasurementTypes measurementType)
    {
        setMax_Height(new MeasurementCSSImpl(Width, measurementType));
    }

    /**
     * Convenience method setting the inner HTML value - Default of Pixels
     * <p>
     * @param Width Width
     */
    public void setMax_Height(int Width)
    {
        setMax_Height(Width, MeasurementTypes.Pixels);
    }

}
