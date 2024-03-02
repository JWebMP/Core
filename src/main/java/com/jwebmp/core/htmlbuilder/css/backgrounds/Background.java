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
package com.jwebmp.core.htmlbuilder.css.backgrounds;

import com.jwebmp.core.htmlbuilder.css.enumarations.CSSAnnotationType;
import com.jwebmp.core.htmlbuilder.css.colours.ColourCSS;
import com.jwebmp.core.htmlbuilder.css.colours.ColourNames;
import com.jwebmp.core.htmlbuilder.css.enumarations.Repeats;
import com.jwebmp.core.htmlbuilder.css.image.ImageCSS;
import com.jwebmp.core.htmlbuilder.css.measurement.MeasurementCSS;

import java.lang.annotation.*;

/**
 * @author GedMarc
 * @since 17 Jan 2016
 */
@CSSAnnotationType
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.LOCAL_VARIABLE, ElementType.PACKAGE, ElementType.METHOD, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Background
{

	/**
	 * Sets the background color of an element
	 *
	 * @return
	 */
	ColourCSS BackgroundColor() default @ColourCSS;

	/**
	 * Sets the background color to a colour name
	 *
	 * @return
	 */
	ColourNames BackgroundColor$() default ColourNames.Unset;

	/**
	 * Specifies one or more background images for an element
	 *
	 * @return
	 */
	ImageCSS BackgroundImage() default @ImageCSS;

	/**
	 * Specifies one or more background images for an element
	 *
	 * @return
	 */
	ImageCSS[] BackgroundImage$() default {};

	/**
	 * Specifies the position of a background image
	 *
	 * @return
	 */
	BackgroundPositions BackgroundPosition() default BackgroundPositions.Unset;

	/**
	 * The background-size property specifies the size of the background images.
	 *
	 * @return
	 */
	MeasurementCSS[] BackgroundSize() default {};

	/**
	 * Sets how a background image will be repeated
	 *
	 * @return
	 */
	Repeats BackgroundRepeat() default Repeats.Unset;

	/**
	 * The background-origin property specifies where the background image is positioned.
	 *
	 * @return
	 */
	BackgroundOrigins BackgroundOrigin() default BackgroundOrigins.Unset;

	/**
	 * The background-clip property specifies the painting area of the background.
	 *
	 * @return
	 */
	BackgroundClip BackgroundClip() default BackgroundClip.Unset;

	/**
	 * Sets whether a background image is fixed or scrolls with the rest of the page
	 *
	 * @return
	 */
	BackgroundAttachments BackgroundAttachment() default BackgroundAttachments.Unset;

}
