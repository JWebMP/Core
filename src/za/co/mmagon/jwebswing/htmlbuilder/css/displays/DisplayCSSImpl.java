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

import java.lang.annotation.Annotation;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementCSS;

/**
 * The display property is the most important CSS property for controlling layout.
 *
 * @author GedMarc
 * @since 18 Jan 2016
 */
public class DisplayCSSImpl implements DisplayCSS
{

    public DisplayCSSImpl()
    {
    }

    public Displays Display;
    public Cursors Cursor;
    public Overflows Overflow;
    public Overflows Overflow_X;
    public Overflows Overflow_Y;
    public Positions Position;
    public za.co.mmagon.jwebswing.htmlbuilder.css.displays.Float Float;
    public MeasurementCSS Z_Index;
    public MeasurementCSS Bottom;
    public MeasurementCSS Left;
    public MeasurementCSS Right;
    public MeasurementCSS Top;

    @Override
    public Class<? extends Annotation> annotationType()
    {
        return DisplayCSS.class;
    }

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
    @Override
    public Displays Display()
    {
        return Display;
    }

    /**
     * Sets the mouse cursor
     *
     * @return
     */
    @Override
    public Cursors Cursor()
    {
        return Cursor;
    }

    /**
     * Sets the overflow
     *
     * @return
     */
    @Override
    public Overflows Overflow()
    {
        return Overflow;
    }

    /**
     * Sets the Horizontal Overflow
     *
     * @return
     */
    @Override
    public Overflows Overflow_X()
    {
        return Overflow_X;
    }

    /**
     * Sets the vertical overflow
     *
     * @return
     */
    @Override
    public Overflows Overflow_Y()
    {
        return Overflow_Y;
    }

    /**
     * Sets the display position
     *
     * @return
     */
    @Override
    public Positions Position()
    {
        return Position;
    }

    /**
     * Sets the component floating
     *
     * @return
     */
    @Override
    public za.co.mmagon.jwebswing.htmlbuilder.css.displays.Float Float()
    {
        return Float;
    }

    /**
     * Sets the Z-Index
     *
     * @return
     */
    @Override
    public MeasurementCSS Z_Index()
    {
        return Z_Index;
    }

    /**
     * Sets the bottom margin edge for a positioned box
     *
     * @return
     */
    @Override
    public MeasurementCSS Bottom()
    {
        return Bottom;
    }

    /**
     * Sets the bottom margin edge for a positioned box
     *
     * @return
     */
    @Override
    public MeasurementCSS Left()
    {
        return Left;
    }

    /**
     * Sets the bottom margin edge for a positioned box
     *
     * @return
     */
    @Override
    public MeasurementCSS Right()
    {
        return Right;
    }

    /**
     * Sets the bottom margin edge for a positioned box
     *
     * @return
     */
    @Override
    public MeasurementCSS Top()
    {
        return Top;
    }

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
     * @param Display
     */
    public void setDisplay(Displays Display)
    {
        this.Display = Display;
    }

    /**
     * Sets the mouse cursor
     *
     * @param Cursor
     */
    public void setCursor(Cursors Cursor)
    {
        this.Cursor = Cursor;
    }

    /**
     * Sets the overflow
     *
     * @param Overflow
     */
    public void setOverflow(Overflows Overflow)
    {
        this.Overflow = Overflow;
    }

    /**
     * Sets the horizontal overflow
     *
     * @param Overflow_X
     */
    public void setOverflow_X(Overflows Overflow_X)
    {
        this.Overflow_X = Overflow_X;
    }

    /**
     * Sets the vertical overflow
     *
     * @param Overflow_Y
     */
    public void setOverflow_Y(Overflows Overflow_Y)
    {
        this.Overflow_Y = Overflow_Y;
    }

    /**
     * Sets the display position
     *
     * @param Position
     */
    public void setPosition(Positions Position)
    {
        this.Position = Position;
    }

    /**
     * Sets the flow to be applied
     *
     * @param Float
     */
    public void setFloat(za.co.mmagon.jwebswing.htmlbuilder.css.displays.Float Float)
    {
        this.Float = Float;
    }

    /**
     * Sets the Z-Index
     *
     * @param Z_Index
     */
    public void setZ_Index(MeasurementCSS Z_Index)
    {
        this.Z_Index = Z_Index;
    }

    /**
     * Sets the bottom margin edge for a positioned box
     *
     * @param Bottom
     */
    public void setBottom(MeasurementCSS Bottom)
    {
        this.Bottom = Bottom;
    }

    /**
     * Sets the bottom margin edge for a positioned box
     *
     * @param Left
     */
    public void setLeft(MeasurementCSS Left)
    {
        this.Left = Left;
    }

    /**
     * Sets the bottom margin edge for a positioned box
     *
     * @param Right
     */
    public void setRight(MeasurementCSS Right)
    {
        this.Right = Right;
    }

    /**
     * Sets the bottom margin edge for a positioned box
     *
     * @param Top
     */
    public void setTop(MeasurementCSS Top)
    {
        this.Top = Top;
    }

}
