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
package za.co.mmagon.jwebswing.htmlbuilder.css.margins;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import za.co.mmagon.jwebswing.htmlbuilder.css.MarginSetting;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.CSSAnnotationType;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementCSS;

/**
 * To shorten the code, it is possible to specify all the margin properties in one property.
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
public @interface Margin
{

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public MeasurementCSS Margin_Right() default @MeasurementCSS;

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public MarginSetting Margin_Right$() default MarginSetting.Unset;

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public MeasurementCSS Margin_Left() default @MeasurementCSS;

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public MarginSetting Margin_Left$() default MarginSetting.Unset;

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public MeasurementCSS Margin_Top() default @MeasurementCSS;

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public MarginSetting Margin_Top$() default MarginSetting.Unset;

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public MeasurementCSS Margin_Bottom() default @MeasurementCSS;

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public MarginSetting Margin_Bottom$() default MarginSetting.Unset;
}
