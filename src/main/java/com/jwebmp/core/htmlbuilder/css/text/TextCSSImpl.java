/*
 * Copyright (C) 2017 GedMarc
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
package com.jwebmp.core.htmlbuilder.css.text;

import com.jwebmp.core.base.client.CSSVersions;
import com.jwebmp.core.htmlbuilder.css.CSSDetail;
import com.jwebmp.core.htmlbuilder.css.annotations.CSSImplementationAdapter;
import com.jwebmp.core.htmlbuilder.css.annotations.CSSImplementationClass;
import com.jwebmp.core.htmlbuilder.css.colours.ColourCSSImpl;
import com.jwebmp.core.htmlbuilder.css.colours.ColourNames;
import com.jwebmp.core.htmlbuilder.css.measurement.MeasurementCSSImpl;

/**
 * All default text properties
 *
 * @author GedMarc
 * @since 18 Jan 2016
 */
public class TextCSSImpl
		extends CSSImplementationAdapter<TextCSS, TextCSSImpl>
		implements CSSImplementationClass<TextCSS, TextCSSImpl>
{


	@CSSDetail(cssName = "color",
			cssVersion = CSSVersions.CSS21)
	private ColourCSSImpl color;
	@CSSDetail(cssName = "color",
			cssVersion = CSSVersions.CSS21)
	private ColourNames color$;
	@CSSDetail(cssName = "direction",
			cssVersion = CSSVersions.CSS21)
	private TextDirections direction;
	@CSSDetail(cssName = "letter-spacing",
			cssVersion = CSSVersions.CSS21)
	private MeasurementCSSImpl letterSpacing;
	@CSSDetail(cssName = "line-height",
			cssVersion = CSSVersions.CSS21)
	private MeasurementCSSImpl lineHeight;
	@CSSDetail(cssName = "text-align",
			cssVersion = CSSVersions.CSS21)
	private TextAlignments textAlign;
	@CSSDetail(cssName = "text-decoration",
			cssVersion = CSSVersions.CSS21)
	private TextDecorations textDecoration;
	@CSSDetail(cssName = "text-indent",
			cssVersion = CSSVersions.CSS21)
	private MeasurementCSSImpl textIndent;
	@CSSDetail(cssName = "text-transform",
			cssVersion = CSSVersions.CSS21)
	private TextTransforms textTransform;
	@CSSDetail(cssName = "unicode-bidi",
			cssVersion = CSSVersions.CSS21)
	private UnicodeBidis unicodeBidi;
	@CSSDetail(cssName = "vertical-align",
			cssVersion = CSSVersions.CSS21)
	private VerticalAlignments verticalAlign;
	@CSSDetail(cssName = "white-space",
			cssVersion = CSSVersions.CSS21)
	private WhiteSpacing whiteSpace;
	@CSSDetail(cssName = "word-spacing",
			cssVersion = CSSVersions.CSS21)
	private MeasurementCSSImpl wordSpacing;

	/**
	 * Constructs a new instance of text css
	 */
	public TextCSSImpl()
	{
		//Nothing needed here
	}

	/**
	 * Sets the colour
	 *
	 * @return
	 */
	public ColourCSSImpl getColour()
	{
		return color;
	}

	/**
	 * Sets the color
	 *
	 * @return
	 */
	public ColourNames getColour$()
	{
		return color$;
	}

	/**
	 * Sets the Text getDirection
	 *
	 * @return
	 */
	public TextDirections getDirection()
	{
		return direction;
	}

	/**
	 * Sets the direction
	 *
	 * @param Direction
	 */
	public void setDirection(TextDirections Direction)
	{
		direction = Direction;
	}

	/**
	 * Sets the letter spacing
	 *
	 * @return
	 */
	public MeasurementCSSImpl getLetterSpacing()
	{
		return letterSpacing;
	}

	/**
	 * Set the letter spacing
	 *
	 * @param letterSpacing
	 */
	public void setLetterSpacing(MeasurementCSSImpl letterSpacing)
	{
		this.letterSpacing = letterSpacing;
	}

	/**
	 * Sets the Line Height
	 *
	 * @return
	 */
	public MeasurementCSSImpl getLineHeight()
	{
		return lineHeight;
	}

	/**
	 * Line Height
	 *
	 * @param lineHeight
	 */
	public void setLineHeight(MeasurementCSSImpl lineHeight)
	{
		this.lineHeight = lineHeight;
	}

	/**
	 * Sets the Text Alignment
	 *
	 * @return
	 */
	public TextAlignments getTextAlign()
	{
		return textAlign;
	}

	/**
	 * Text Alignment
	 *
	 * @param textAlign
	 */
	public void setTextAlign(TextAlignments textAlign)
	{
		this.textAlign = textAlign;
	}

	/**
	 * Sets the Text getDirection
	 *
	 * @return
	 */
	public TextDecorations getTextDecoration()
	{
		return textDecoration;
	}

	/**
	 * Sets the Text Decoration
	 *
	 * @param textDecoration
	 */
	public void setTextDecoration(TextDecorations textDecoration)
	{
		this.textDecoration = textDecoration;
	}

	/**
	 * Sets the Text Indentation
	 *
	 * @return
	 */
	public MeasurementCSSImpl getTextIndent()
	{
		return textIndent;
	}

	/**
	 * Sets the text indentation
	 *
	 * @param textIndent
	 */
	public void setTextIndent(MeasurementCSSImpl textIndent)
	{
		this.textIndent = textIndent;
	}

	/**
	 * Sets any text transformations
	 *
	 * @return
	 */
	public TextTransforms getTextTransform()
	{
		return textTransform;
	}

	/**
	 * Sets the Text Transforms
	 *
	 * @param textTransform
	 */
	public void setTextTransform(TextTransforms textTransform)
	{
		this.textTransform = textTransform;
	}

	/**
	 * Used together with the direction property to set or return whether the text should be overridden to support multiple languages in the same document
	 *
	 * @return
	 */
	public UnicodeBidis getUnicodeBidi()
	{
		return unicodeBidi;
	}

	/**
	 * Used together with the direction property to set or return whether the text should be overridden to support multiple languages in the same document
	 *
	 * @param unicodeBidi
	 */
	public void setUnicodeBidi(UnicodeBidis unicodeBidi)
	{
		this.unicodeBidi = unicodeBidi;
	}

	/**
	 * Sets the Vertical Alignment
	 *
	 * @return
	 */
	public VerticalAlignments getVerticalAlign()
	{
		return verticalAlign;
	}

	/**
	 * Sets the vertical alignment
	 *
	 * @param verticalAlign
	 */
	public void setVerticalAlign(VerticalAlignments verticalAlign)
	{
		this.verticalAlign = verticalAlign;
	}

	/**
	 * Sets the white spacing to be used
	 *
	 * @return
	 */
	public WhiteSpacing getWhiteSpace()
	{
		return whiteSpace;
	}

	/**
	 * Sets the white space
	 *
	 * @param whiteSpace
	 */
	public void setWhiteSpace(WhiteSpacing whiteSpace)
	{
		this.whiteSpace = whiteSpace;
	}

	/**
	 * Sets the word spacing to be used
	 *
	 * @return
	 */
	public MeasurementCSSImpl getWordSpacing()
	{
		return wordSpacing;
	}

	/**
	 * Sets the word spacing
	 *
	 * @param wordSpacing
	 */
	public void setWordSpacing(MeasurementCSSImpl wordSpacing)
	{
		this.wordSpacing = wordSpacing;
	}

	/**
	 * Sets the Colour
	 *
	 * @param Color
	 */
	public void setColor(ColourCSSImpl Color)
	{
		color = Color;
	}

	/**
	 * Sets the colour
	 *
	 * @param Color$
	 */
	public void setColor$(ColourNames Color$)
	{
		color$ = Color$;
	}

}
