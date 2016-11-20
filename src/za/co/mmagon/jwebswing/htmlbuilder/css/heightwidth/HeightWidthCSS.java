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

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.CSSAnnotationType;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementCSS;

/**
 * CSS Dimension Properties
 * <p>
 * The CSS dimension properties allow you to control the height and width of an element.
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
public @interface HeightWidthCSS
{

    /**
     * The height property sets the height of an element.
     * <p>
     * Note: The height property does not include padding, borders, or margins; it sets the height of the area inside the padding, border, and margin of the element!
     * <p>
     * Note: The min-height and max-height properties override height.
     * Default value: auto
     * Inherited: no
     * Animatable: yes. Read about animatable
     * Try it
     * Version: CSS1
     * JavaScript syntax: object.style.height="500px"
     *
     * @return
     */
    public MeasurementCSS Height() default @MeasurementCSS;

    /**
     * The height property sets the height of an element.
     * <p>
     * Note: The height property does not include padding, borders, or margins; it sets the height of the area inside the padding, border, and margin of the element!
     * <p>
     * Note: The min-height and max-height properties override height.
     * Default value: auto
     * Inherited: no
     * Animatable: yes. Read about animatable
     * Try it
     * Version: CSS1
     * JavaScript syntax: object.style.height="500px"
     *
     * @return
     */
    public HeightSetting Height$() default HeightSetting.Unset;

    /**
     * Definition and Usage
     * <p>
     * The width property sets the width of an element.
     * <p>
     * Note: The width property does not include padding, borders, or margins; it sets the width of the area inside the padding, border, and margin of the element!
     * <p>
     * Note: The min-width and max-width properties override width.
     * Default value: auto
     * Inherited: no
     * Animatable: yes. Read about animatable
     * Try it
     * Version: CSS1
     * JavaScript syntax: object.style.width="500px"
     *
     * @return
     */
    public MeasurementCSS Width() default @MeasurementCSS;

    /**
     * Definition and Usage
     * <p>
     * The width property sets the width of an element.
     * <p>
     * Note: The width property does not include padding, borders, or margins; it sets the width of the area inside the padding, border, and margin of the element!
     * <p>
     * Note: The min-width and max-width properties override width.
     * Default value: auto
     * Inherited: no
     * Animatable: yes. Read about animatable
     * Try it
     * Version: CSS1
     * JavaScript syntax: object.style.width="500px"
     *
     * @return
     */
    public WidthSetting Width$() default WidthSetting.Unset;

    /**
     * Definition and Usage
     * <p>
     * The min-height property is used to set the minimum height of an element.
     * <p>
     * This prevents the value of the height property from becoming smaller than min-height.
     * <p>
     * Note: The value of the min-height property overrides both max-height and height.
     * Default value: 0
     * Inherited: no
     * Animatable: yes, see individual properties. Read about animatable
     * Try it
     * Version: CSS2
     * JavaScript syntax: object.style.minHeight="400px"
     *
     * @return
     */
    public MeasurementCSS MinHeight() default @MeasurementCSS;

    /**
     * Definition and Usage
     * <p>
     * The max-height property is used to set the maximum height of an element.
     * <p>
     * This prevents the value of the height property from becoming larger than max-height.
     * <p>
     * Note: The value of the max-height property overrides height.
     * Default value: none
     * Inherited: no
     * Animatable: yes, see individual properties. Read about animatable
     * Try it
     * Version: CSS2
     * JavaScript syntax: object.style.maxHeight="100px"
     *
     * @return
     */
    public MeasurementCSS MaxHeight() default @MeasurementCSS;

    /**
     * Definition and Usage
     * <p>
     * The min-width property is used to set the minimum width of an element.
     * <p>
     * This prevents the value of the width property from becoming smaller than min-width.
     * <p>
     * Note: The value of the min-width property overrides both max-width and width.
     * Default value: 0
     * Inherited: no
     * Animatable: yes, see individual properties. Read about animatable
     * Try it
     * Version: CSS2
     * JavaScript syntax: object.style.minWidth="400px"
     *
     * @return
     */
    public MeasurementCSS MinWidth() default @MeasurementCSS;

    /**
     * Definition and Usage
     * <p>
     * The max-width property is used to set the maximum width of an element.
     * <p>
     * This prevents the value of the width property from becoming larger than max-width.
     * <p>
     * Note: The value of the max-width property overrides width.
     * Default value: none
     * Inherited: no
     * Animatable: yes, see individual properties. Read about animatable
     * Try it
     * Version: CSS2
     * JavaScript syntax: object.style.maxWidth="600px"
     *
     * @return
     */
    public MeasurementCSS MaxWidth() default @MeasurementCSS;
}
