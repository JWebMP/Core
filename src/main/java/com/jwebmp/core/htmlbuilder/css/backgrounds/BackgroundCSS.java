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
package com.jwebmp.core.htmlbuilder.css.backgrounds;

import com.jwebmp.core.htmlbuilder.css.enumarations.CSSAnnotationType;
import com.jwebmp.core.htmlbuilder.css.colours.ColourCSS;
import com.jwebmp.core.htmlbuilder.css.colours.ColourNames;
import com.jwebmp.core.htmlbuilder.css.enumarations.Repeats;
import com.jwebmp.core.htmlbuilder.css.image.ImageCSS;
import com.jwebmp.core.htmlbuilder.css.measurement.MeasurementCSS;

import java.lang.annotation.*;

/**
 * The CSS background properties are used to define the background effects for elements.
 * <p>
 * see http://www.w3schools.com/css/css_background.asp
 *
 * @author GedMarc
 * @since 17 Jan 2016
 */
@CSSAnnotationType
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.LOCAL_VARIABLE, ElementType.PACKAGE, ElementType.METHOD, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface BackgroundCSS
{
	/**
	 * The shortcut for Background CSS Files
	 *
	 * @return
	 */
	Background Background() default @Background;

	/**
	 * Sets whether a background image is fixed or scrolls with the rest of the page
	 *
	 * @return
	 */
	BackgroundAttachments BackgroundAttachment() default BackgroundAttachments.Unset;

	/**
	 * Sets the background Color of an element
	 *
	 * @return
	 */
	ColourCSS BackgroundColor() default @ColourCSS;

	/**
	 * Sets the background Color to a colour name
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
	 * Sets how a background image will be repeated
	 *
	 * @return
	 */
	Repeats BackgroundRepeat() default Repeats.Unset;

	/**
	 * Specifies the blending mode of each background layer (Color/image)
	 *
	 * @return
	 */
	BackgroundBlendMode BackgroundBlendMode() default BackgroundBlendMode.Unset;

	/**
	 * The background-clip property specifies the painting area of the background.
	 *
	 * @return
	 */
	BackgroundClip BackgroundClip() default BackgroundClip.Unset;

	/**
	 * The background-origin property specifies where the background image is positioned.
	 *
	 * @return
	 */
	BackgroundOrigins BackgroundOrigin() default BackgroundOrigins.Unset;

	/**
	 * The background-size property specifies the size of the background images.
	 *
	 * @return
	 */
	MeasurementCSS[] BackgroundSize() default {};

	/**
	 * The background-size property specifies the size of the background images.
	 *
	 * @return
	 */
	BackgroundSizes BackgroundSize$() default BackgroundSizes.Unset;

}
