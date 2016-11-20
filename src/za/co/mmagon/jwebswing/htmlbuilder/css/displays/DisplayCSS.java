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
package za.co.mmagon.jwebswing.htmlbuilder.css.displays;

import java.lang.annotation.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.*;

/**
 * The display property is the most important CSS property for controlling layout.
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
public @interface DisplayCSS
{

    /**
     * Sets the Display Format
     * The display Property
     * <p>
     * The display property specifies if/how an element is displayed.
     * <p>
     * Every HTML element has a default display value depending on what type of element it is. The default display value for most elements is block or inline.
     * Block-level Elements
     * <p>
     * A block-level element always starts on a new line and takes up the full width available (stretches out to the left and right as far as it can).
     * The &lt;div&gt; element is a block-level element.
     * <p>
     * Examples of block-level elements:
     * <p>
     * &lt;div&gt;
     * &lt;h1&gt; - &lt;h6&gt;
     * <p>
     * &lt;form&gt;
     * &lt;header&gt;
     * &lt;footer&gt;
     * &lt;section&gt;
     * <p>
     * Inline Elements
     * <p>
     * An inline element does not start on a new line and only takes up as much width as necessary.
     * <p>
     * This is an inline &lt;span&gt; element inside a paragraph.
     * <p>
     * Examples of inline elements:
     * <p>
     * &lt;span&gt;
     * &lt;a&gt;
     * &lt;img&gt;
     *
     * @return
     */
    public Displays Display() default Displays.Unset;

    /**
     * The mouse cursor
     *
     * @return
     */
    public Cursors Cursor() default Cursors.Unset;

    /**
     * Sets the overflow
     *
     * @return
     */
    public Overflows Overflow() default Overflows.Unset;

    /**
     * Sets the Overflow for Horizontal
     *
     * @return
     */
    public Overflows OverflowX() default Overflows.Unset;

    /**
     * Sets the Overflow for Vertical
     *
     * @return
     */
    public Overflows OverflowY() default Overflows.Unset;

    /**
     * Sets the Position to apply
     *
     * @return
     */
    public Positions Position() default Positions.Unset;

    /**
     * Sets how an object must float
     *
     * @return
     */
    public za.co.mmagon.jwebswing.htmlbuilder.css.displays.Floats FloatProperty() default za.co.mmagon.jwebswing.htmlbuilder.css.displays.Floats.Unset;

    /**
     * Sets the Z-Index of the component
     *
     * @return
     */
    public MeasurementCSS ZIndex() default @MeasurementCSS;

    /**
     * Sets the bottom margin edge for a positioned box
     *
     * @return
     */
    public MeasurementCSS Bottom() default @MeasurementCSS;

    /**
     * Sets the bottom margin edge for a positioned box
     *
     * @return
     */
    public MeasurementCSS Left() default @MeasurementCSS;

    /**
     * Sets the bottom margin edge for a positioned box
     *
     * @return
     */
    public MeasurementCSS Right() default @MeasurementCSS;

    /**
     * Sets the bottom margin edge for a positioned box
     *
     * @return
     */
    public MeasurementCSS Top() default @MeasurementCSS;

}
