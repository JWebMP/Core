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
package za.co.mmagon.jwebswing.htmlbuilder.css.borders;

import java.lang.annotation.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.enumarations.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.*;

/**
 *
 * CSS Border Properties
 * <p>
 * The CSS border properties allow you to specify the style, width, and color of an element's border.
 * <p>
 *
 * @author GedMarc
 * @since 18 Jan 2016
 * see http://www.w3schools.com/css/css_border.asp
 */
@CSSAnnotationType
@Target(
        {
            ElementType.FIELD, ElementType.TYPE, ElementType.LOCAL_VARIABLE, ElementType.PACKAGE, ElementType.METHOD, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE
        })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface BorderCSS
{

    /**
     * The border shorthand property sets all the border properties in one declaration.
     *
     * @return
     */
    public Border Border() default @Border;

    /**
     * The border-top shorthand property sets all the top border properties in one declaration.
     *
     * @return
     */
    public BorderBottomCSS BorderBottom() default @BorderBottomCSS;

    /**
     * The border-top shorthand property sets all the top border properties in one declaration.
     *
     * @return
     */
    public BorderBottomCSS BorderLeft() default @BorderBottomCSS;

    /**
     * The border-top shorthand property sets all the top border properties in one declaration.
     *
     * @return
     */
    public BorderBottomCSS BorderRight() default @BorderBottomCSS;

    /**
     * The border-top shorthand property sets all the top border properties in one declaration.
     *
     * @return
     */
    public BorderBottomCSS BorderTop() default @BorderBottomCSS;

    /**
     * Sets the color of the bottom border
     *
     * @return
     */
    public ColourCSS BorderBottomColor() default @ColourCSS;

    /**
     * Sets the color of the bottom border
     *
     * @return
     */
    public ColourNames BorderBottomColor$() default ColourNames.Unset;

    /**
     * Sets the Style of the bottom border
     *
     * @return
     */
    public BorderStyles BorderBottomStyle() default BorderStyles.Unset;

    /**
     * Sets the width of the bottom border
     *
     * @return
     */
    public MeasurementCSS BorderBottomWidth() default @MeasurementCSS;

    /**
     * Sets the colour of the left border
     *
     * @return
     */
    public ColourCSS BorderLeftColor() default @ColourCSS;

    /**
     * Sets the colour of the left border
     *
     * @return
     */
    public ColourNames BorderLeftColor$() default ColourNames.Unset;

    /**
     * Sets the style of the left border
     *
     * @return
     */
    public BorderStyles BorderLeftStyle() default BorderStyles.Unset;

    /**
     * Sets the width of the left border
     *
     * @return
     */
    public MeasurementCSS BorderLeftWidth() default @MeasurementCSS;

    /**
     * Sets the color of the right border
     *
     * @return
     */
    public ColourCSS BorderRightColor() default @ColourCSS;

    /**
     * Sets the color of the right border
     *
     * @return
     */
    public ColourNames BorderRightColor$() default ColourNames.Unset;

    /**
     * Sets the style of the right border
     *
     * @return
     */
    public BorderStyles BorderRightStyle() default BorderStyles.Unset;

    /**
     * Sets the style of the right border
     *
     * @return
     */
    public MeasurementCSS BorderRightWidth() default @MeasurementCSS;

    /**
     * Sets the color of the top border
     *
     * @return
     */
    public ColourCSS BorderTopColor() default @ColourCSS;

    /**
     * Sets the color of the top border
     *
     * @return
     */
    public ColourNames BorderTopColor$() default ColourNames.Unset;

    /**
     * Sets the style of the top border
     *
     * @return
     */
    public BorderStyles BorderTopStyle() default BorderStyles.Unset;

    /**
     * Sets the width of the top border
     *
     * @return
     */
    public MeasurementCSS BorderTopWidth() default @MeasurementCSS;
}
