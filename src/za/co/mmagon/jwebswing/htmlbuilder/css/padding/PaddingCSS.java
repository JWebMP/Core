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

import java.lang.annotation.*;
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
@Target(
        {
            ElementType.FIELD, ElementType.TYPE, ElementType.LOCAL_VARIABLE, ElementType.PACKAGE, ElementType.METHOD, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE
        })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@CSSAnnotationType
public @interface PaddingCSS
{

    /**
     * Shorthand format for padding
     *
     * @return
     */
    public Padding Padding() default @Padding;

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public MeasurementCSS PaddingRight() default @MeasurementCSS;

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public PaddingSetting PaddingRight$ () default PaddingSetting.Unset;

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public MeasurementCSS PaddingLeft() default @MeasurementCSS;

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public PaddingSetting PaddingLeft$() default PaddingSetting.Unset;

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public MeasurementCSS PaddingTop() default @MeasurementCSS;

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public PaddingSetting PaddingTop$() default PaddingSetting.Unset;

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public MeasurementCSS PaddingBottom() default @MeasurementCSS;

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public PaddingSetting PaddingBottom$() default PaddingSetting.Unset;

}
