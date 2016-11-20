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

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.CSSAnnotationType;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourCSS;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementCSS;

/**
 *
 * @author GedMarc
 * @since 18 Jan 2016
 */
@Target(
        {
            ElementType.FIELD, ElementType.TYPE, ElementType.LOCAL_VARIABLE, ElementType.PACKAGE, ElementType.METHOD, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE
        })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@CSSAnnotationType
public @interface TextShadows
{

    /**
     * Required. The position of the horizontal shadow. Negative values are allowed
     *
     * @return
     */
    public MeasurementCSS HShadow();

    /**
     * Required. The position of the vertical shadow. Negative values are allowed
     *
     * @return
     */
    public MeasurementCSS VShadow();

    /**
     * Optional. The blur radius. Default value is 0
     *
     * @return
     */
    public MeasurementCSS BlurRadius() default @MeasurementCSS;

    /**
     * Optional. The color of the shadow. Look at CSS Color Values for a complete list of possible color values
     *
     * @return
     */
    public ColourCSS Color() default @ColourCSS;
}
