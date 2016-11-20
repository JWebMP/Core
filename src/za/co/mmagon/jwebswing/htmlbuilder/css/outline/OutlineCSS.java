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
package za.co.mmagon.jwebswing.htmlbuilder.css.outline;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import za.co.mmagon.jwebswing.htmlbuilder.css.enumarations.BorderStyles;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.CSSAnnotationType;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourCSS;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourNames;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementCSS;

/**
 * An outline is a line drawn around an element - outside the border. This can be use to make an element "stand out".
 * <p>
 * The CSS outline properties specify the style, color, and width of an outline.
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
public @interface OutlineCSS
{

    /**
     * Sets the color of an outline
     *
     * @return
     */
    public ColourCSS OutlineColor() default @ColourCSS;

    /**
     * Sets the color of an outline
     *
     * @return
     */
    public ColourNames OutlineColor$() default ColourNames.Unset;

    /**
     * Sets the style of an outline
     *
     * @return
     */
    public BorderStyles OutlineStyle() default BorderStyles.Unset;

    /**
     * Sets the width of an outline
     *
     * @return
     */
    public MeasurementCSS OutlineWidth() default @MeasurementCSS;

    /**
     * Specifies the space between an outline and the edge or border of an element
     *
     * @return
     */
    public MeasurementCSS OutlineOffset() default @MeasurementCSS;
}
