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

import java.lang.annotation.Annotation;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourCSS;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourNames;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementCSS;

/**
 *
 * @author GedMarc
 * @since 18 Jan 2016
 */
public class TextCSSImpl implements TextCSS
{

    public TextCSSImpl()
    {
    }

    @Override
    public String toString()
    {
        return "";
    }

    private ColourCSS Color;
    private ColourNames Color$;
    private TextDirections Direction;
    private MeasurementCSS Letter_Spacing;
    private MeasurementCSS Line_Height;
    private TextAlignments Text_Align;
    private TextDecorations Text_Decoration;
    private MeasurementCSS Text_Indent;
    private TextTransforms Text_Transform;
    private UnicodeBidis Unicode_Bidi;
    private VerticalAlignments Vertical_Align;
    private WhiteSpacing White_Space;
    private MeasurementCSS Word_Spacing;

    @Override
    public Class<? extends Annotation> annotationType()
    {
        return TextCSS.class;
    }

    /**
     * Sets the colour
     *
     * @return
     */
    @Override
    public ColourCSS Color()
    {
        return Color;
    }

    /**
     * Sets the color
     *
     * @return
     */
    @Override
    public ColourNames Color$()
    {
        return Color$;
    }

    /**
     * Sets the Text Direction
     *
     * @return
     */
    @Override
    public TextDirections Direction()
    {
        return Direction;
    }

    /**
     * Sets the letter spacing
     *
     * @return
     */
    @Override
    public MeasurementCSS Letter_Spacing()
    {
        return Letter_Spacing;
    }

    /**
     * Sets the Line Height
     *
     * @return
     */
    @Override
    public MeasurementCSS Line_Height()
    {
        return Line_Height;
    }

    /**
     * Sets the Text Alignment
     *
     * @return
     */
    @Override
    public TextAlignments Text_Align()
    {
        return Text_Align;
    }

    /**
     * Sets the Text Direction
     *
     * @return
     */
    @Override
    public TextDecorations Text_Decoration()
    {
        return Text_Decoration;
    }

    /**
     * Sets the Text Indentation
     *
     * @return
     */
    @Override
    public MeasurementCSS Text_Indent()
    {
        return Text_Indent;
    }

    /**
     * Sets any text transformations
     *
     * @return
     */
    @Override
    public TextTransforms Text_Transform()
    {
        return Text_Transform;
    }

    /**
     * Used together with the direction property to set or return whether the text should be overridden to support multiple languages in the same document
     *
     * @return
     */
    @Override
    public UnicodeBidis Unicode_Bidi()
    {
        return Unicode_Bidi;
    }

    /**
     * Sets the Vertical Alignment
     *
     * @return
     */
    @Override
    public VerticalAlignments Vertical_Align()
    {
        return Vertical_Align;
    }

    /**
     * Sets the white spacing to be used
     *
     * @return
     */
    @Override
    public WhiteSpacing White_Space()
    {
        return White_Space;
    }

    /**
     * Sets the word spacing to be used
     *
     * @return
     */
    @Override
    public MeasurementCSS Word_Spacing()
    {
        return Word_Spacing;
    }

    /**
     * Sets the Colour
     *
     * @param Color
     */
    public void setColor(ColourCSS Color)
    {
        this.Color = Color;
    }

    /**
     * Sets the colour
     *
     * @param Color$
     */
    public void setColor$(ColourNames Color$)
    {
        this.Color$ = Color$;
    }

    /**
     * Sets the direction
     *
     * @param Direction
     */
    public void setDirection(TextDirections Direction)
    {
        this.Direction = Direction;
    }

    /**
     * Set the letter spacing
     *
     * @param Letter_Spacing
     */
    public void setLetter_Spacing(MeasurementCSS Letter_Spacing)
    {
        this.Letter_Spacing = Letter_Spacing;
    }

    /**
     * Line Height
     *
     * @param Line_Height
     */
    public void setLine_Height(MeasurementCSS Line_Height)
    {
        this.Line_Height = Line_Height;
    }

    /**
     * Text Alignment
     *
     * @param Text_Align
     */
    public void setText_Align(TextAlignments Text_Align)
    {
        this.Text_Align = Text_Align;
    }

    /**
     * Sets the Text Decoration
     *
     * @param Text_Decoration
     */
    public void setText_Decoration(TextDecorations Text_Decoration)
    {
        this.Text_Decoration = Text_Decoration;
    }

    /**
     * Sets the text indentation
     *
     * @param Text_Indent
     */
    public void setText_Indent(MeasurementCSS Text_Indent)
    {
        this.Text_Indent = Text_Indent;
    }

    /**
     * Sets the Text Transforms
     *
     * @param Text_Transform
     */
    public void setText_Transform(TextTransforms Text_Transform)
    {
        this.Text_Transform = Text_Transform;
    }

    /**
     * Used together with the direction property to set or return whether the text should be overridden to support multiple languages in the same document
     *
     * @param Unicode_Bidi
     */
    public void setUnicode_Bidi(UnicodeBidis Unicode_Bidi)
    {
        this.Unicode_Bidi = Unicode_Bidi;
    }

    /**
     * Sets the vertical alignment
     *
     * @param Vertical_Align
     */
    public void setVertical_Align(VerticalAlignments Vertical_Align)
    {
        this.Vertical_Align = Vertical_Align;
    }

    /**
     * Sets the white space
     *
     * @param White_Space
     */
    public void setWhite_Space(WhiteSpacing White_Space)
    {
        this.White_Space = White_Space;
    }

    /**
     * Sets the word spacing
     *
     * @param Word_Spacing
     */
    public void setWord_Spacing(MeasurementCSS Word_Spacing)
    {
        this.Word_Spacing = Word_Spacing;
    }

}
