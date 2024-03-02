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

import com.jwebmp.core.htmlbuilder.css.enumarations.CSSAnnotationType;
import com.jwebmp.core.htmlbuilder.css.colours.ColourCSS;
import com.jwebmp.core.htmlbuilder.css.colours.ColourNames;
import com.jwebmp.core.htmlbuilder.css.measurement.MeasurementCSS;

import java.lang.annotation.*;

/**
 * Text Formatting
 * <p>
 * see http://www.w3schools.com/css/css_text.asp
 *
 * @author GedMarc
 * @since 18 Jan 2016
 */
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.LOCAL_VARIABLE, ElementType.PACKAGE, ElementType.METHOD, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@CSSAnnotationType
@Documented
public @interface TextCSS
{

	/**
	 * Definition and Usage
	 * <p>
	 * The color property specifies the color of text. Default value: not specified Inherited: yes Version: CSS1 JavaScript syntax: object.style.color=white
	 * <p>
	 *
	 * @return
	 */
	ColourCSS Color() default @ColourCSS;

	/**
	 * Definition and Usage
	 * <p>
	 * The color property specifies the color of text. Default value: not specified Inherited: yes Version: CSS1 JavaScript syntax: object.style.color=white
	 * <p>
	 *
	 * @return
	 */
	ColourNames Color$() default ColourNames.Unset;

	/**
	 * Definition and Usage
	 * <p>
	 * The direction property specifies the text direction/writing direction. Default value: ltr Inherited: yes Version: CSS2 JavaScript syntax: object.style.direction="rtl"
	 * <p>
	 *
	 * @return
	 */
	TextDirections Direction() default TextDirections.Unset;

	/**
	 * Definition and Usage
	 * <p>
	 * The letter-spacing property increases or decreases the space between characters in a text. Default value: normal Inherited: yes Version: CSS1 JavaScript syntax:
	 * object.style.letterSpacing="3px"
	 * <p>
	 *
	 * @return
	 */
	MeasurementCSS LetterSpacing() default @MeasurementCSS;

	/**
	 * Definition and Usage
	 * <p>
	 * The line-height property specifies the line height.
	 * <p>
	 * Note: Negative values are not allowed. Default value: normal Inherited: yes Version: CSS1 JavaScript syntax: object.style.lineHeight="2"
	 * <p>
	 *
	 * @return
	 */
	MeasurementCSS LineHeight() default @MeasurementCSS;

	/**
	 * Definition and Usage
	 * <p>
	 * The text-align property specifies the horizontal alignment of text in an element. Default value: left if direction is ltr, and right if direction is rtl Inherited: yes
	 * Version: CSS1 JavaScript
	 * syntax: object.style.textAlign="right"
	 * <p>
	 *
	 * @return
	 */
	TextAlignments TextAlign() default TextAlignments.Unset;

	/**
	 * Definition and Usage
	 * <p>
	 * The text-decoration property specifies the decoration added to text.
	 * <p>
	 * Note: The color of the decoration should be set by the "color" property. Default value: none Inherited: no Version: CSS1 JavaScript syntax:
	 * object.style.textDecoration="overline"
	 * <p>
	 *
	 * @return
	 */
	TextDecorations TextDecoration() default TextDecorations.Unset;

	/**
	 * Definition and Usage
	 * <p>
	 * The text-indent property specifies the indentation of the first line in a text-block.
	 * <p>
	 * Note: Negative values are allowed. The first line will be indented to the left if the value is negative. Default value: 0 Inherited: yes Version: CSS1 JavaScript syntax:
	 * object.style.textIndent="50px"
	 * <p>
	 *
	 * @return
	 */
	MeasurementCSS TextIndent() default @MeasurementCSS;

	/**
	 * Definition and Usage
	 * <p>
	 * The text-transform property controls the capitalization of text. Default value: none Inherited: yes Version: CSS1 JavaScript syntax: object.style.textTransform="uppercase"
	 * <p>
	 *
	 * @return
	 */
	TextTransforms TextTransform() default TextTransforms.Unset;

	/**
	 * Used together with the direction property to set or return whether the text should be overridden to support multiple languages in the same document
	 *
	 * @return
	 */
	UnicodeBidis UnicodeBidi() default UnicodeBidis.Unset;

	/**
	 * Definition and Usage
	 * <p>
	 * The vertical-align property sets the vertical alignment of an element. Default value: baseline Inherited: no Version: CSS1 JavaScript syntax:
	 * object.style.verticalAlign="bottom"
	 * <p>
	 *
	 * @return
	 */
	VerticalAlignments VerticalAlign() default VerticalAlignments.Unset;

	/**
	 * Definition and Usage
	 * <p>
	 * The white-space property specifies how white-space inside an element is handled. Default value: normal Inherited: yes Version: CSS1 JavaScript syntax:
	 * object.style.whiteSpace="pre"
	 * <p>
	 *
	 * @return
	 */
	WhiteSpacing WhiteSpace() default WhiteSpacing.Unset;

	/**
	 * Definition and Usage
	 * <p>
	 * The word-spacing property increases or decreases the white space between words.
	 * <p>
	 * Note: Negative values are allowed. Default value: normal Inherited: yes Version: CSS1 JavaScript syntax: object.style.wordSpacing="10px"
	 * <p>
	 *
	 * @return
	 */
	MeasurementCSS WordSpacing() default @MeasurementCSS;
}
