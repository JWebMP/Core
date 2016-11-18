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
    public BorderBottomCSS Border_Bottom() default @BorderBottomCSS;

    /**
     * The border-top shorthand property sets all the top border properties in one declaration.
     *
     * @return
     */
    public BorderBottomCSS Border_Left() default @BorderBottomCSS;

    /**
     * The border-top shorthand property sets all the top border properties in one declaration.
     *
     * @return
     */
    public BorderBottomCSS Border_Right() default @BorderBottomCSS;

    /**
     * The border-top shorthand property sets all the top border properties in one declaration.
     *
     * @return
     */
    public BorderBottomCSS Border_Top() default @BorderBottomCSS;

    /**
     * Sets the color of the bottom border
     *
     * @return
     */
    public ColourCSS Border_Bottom_Color() default @ColourCSS;

    /**
     * Sets the color of the bottom border
     *
     * @return
     */
    public ColourNames Border_Bottom_Color$() default ColourNames.Unset;

    /**
     * Sets the Style of the bottom border
     *
     * @return
     */
    public BorderStyles Border_Bottom_Style() default BorderStyles.Unset;

    /**
     * Sets the width of the bottom border
     *
     * @return
     */
    public MeasurementCSS Border_Bottom_Width() default @MeasurementCSS;

    /**
     * Sets the colour of the left border
     *
     * @return
     */
    public ColourCSS Border_Left_Color() default @ColourCSS;

    /**
     * Sets the colour of the left border
     *
     * @return
     */
    public ColourNames Border_Left_Color$() default ColourNames.Unset;

    /**
     * Sets the style of the left border
     *
     * @return
     */
    public BorderStyles Border_Left_Style() default BorderStyles.Unset;

    /**
     * Sets the width of the left border
     *
     * @return
     */
    public MeasurementCSS Border_Left_Width() default @MeasurementCSS;

    /**
     * Sets the color of the right border
     *
     * @return
     */
    public ColourCSS Border_Right_Color() default @ColourCSS;

    /**
     * Sets the color of the right border
     *
     * @return
     */
    public ColourNames Border_Right_Color$() default ColourNames.Unset;

    /**
     * Sets the style of the right border
     *
     * @return
     */
    public BorderStyles Border_Right_Style() default BorderStyles.Unset;

    /**
     * Sets the style of the right border
     *
     * @return
     */
    public MeasurementCSS Border_Right_Width() default @MeasurementCSS;

    /**
     * Sets the color of the top border
     *
     * @return
     */
    public ColourCSS Border_Top_Color() default @ColourCSS;

    /**
     * Sets the color of the top border
     *
     * @return
     */
    public ColourNames Border_Top_Color$() default ColourNames.Unset;

    /**
     * Sets the style of the top border
     *
     * @return
     */
    public BorderStyles Border_Top_Style() default BorderStyles.Unset;

    /**
     * Sets the width of the top border
     *
     * @return
     */
    public MeasurementCSS Border_Top_Width() default @MeasurementCSS;
}
