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
package za.co.mmagon.jwebswing.htmlbuilder.css.backgrounds;

import java.lang.annotation.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.enumarations.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.image.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.*;

/**
 * The CSS background properties are used to define the background effects for elements.
 * <p>
 * see http://www.w3schools.com/css/css_background.asp
 *
 * @author GedMarc
 * @since 17 Jan 2016
 */
@CSSAnnotationType
@Target(
        {
            ElementType.FIELD, ElementType.TYPE, ElementType.LOCAL_VARIABLE, ElementType.PACKAGE, ElementType.METHOD, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE
        })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface BackgroundCSS
{

    public Background Background() default @Background;

    /**
     * Sets whether a background image is fixed or scrolls with the rest of the page
     * @return 
     */
    public BackgroundAttachments Background_Attachment() default BackgroundAttachments.Unset;

    /**
     * Sets the background color of an element
     * @return 
     */
    public ColourCSS BackgroundColor() default @ColourCSS;

    /**
     * Sets the background color to a colour name
     *
     * @return
     */
    public ColourNames Background_Color$() default ColourNames.Unset;

    /**
     * Specifies one or more background images for an element
     * @return 
     */
    public ImageCSS Background_Image() default @ImageCSS;

    /**
     * Specifies one or more background images for an element
     * @return 
     */
    public ImageCSS[] Background_Image$() default
    {
    };

    /**
     * Specifies the position of a background image
     * @return 
     */
    public BackgroundPositions Background_Position() default BackgroundPositions.Unset;

    /**
     * Sets how a background image will be repeated
     * @return 
     */
    public Repeats Background_Repeat() default Repeats.Unset;

    /**
     * Specifies the blending mode of each background layer (color/image)
     *
     * @return
     */
    public BackgroundBlendMode Background_BlendMode() default BackgroundBlendMode.Unset;

    /**
     * The background-clip property specifies the painting area of the background.
     *
     * @return
     */
    public BackgroundClip Background_Clip() default BackgroundClip.Unset;

    /**
     * The background-origin property specifies where the background image is positioned.
     *
     * @return
     */
    public BackgroundOrigins Background_Origin() default BackgroundOrigins.Unset;

    /**
     * The background-size property specifies the size of the background images.
     *
     * @return
     */
    public MeasurementCSS[] Background_Size() default
    {
    };

    /**
     * The background-size property specifies the size of the background images.
     *
     * @return
     */
    public BackgroundSizes Background_Size$() default BackgroundSizes.Unset;

}
