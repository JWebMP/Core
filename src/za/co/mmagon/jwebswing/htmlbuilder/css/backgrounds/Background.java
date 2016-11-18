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

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import za.co.mmagon.jwebswing.htmlbuilder.css.image.ImageCSS;
import za.co.mmagon.jwebswing.htmlbuilder.css.enumarations.Repeats;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.CSSAnnotationType;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourCSS;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourNames;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementCSS;

/**
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
public @interface Background
{

    /**
     * Sets the background color of an element
     */
    public ColourCSS Background_Color() default @ColourCSS;

    /**
     * Sets the background color to a colour name
     *
     * @return
     */
    public ColourNames Background_Color$() default ColourNames.Unset;

    /**
     * Specifies one or more background images for an element
     */
    public ImageCSS Background_Image() default @ImageCSS;

    /**
     * Specifies one or more background images for an element
     */
    public ImageCSS[] Background_Image$() default
    {
    };

    /**
     * Specifies the position of a background image
     */
    public BackgroundPositions Background_Position() default BackgroundPositions.Unset;

    /**
     * The background-size property specifies the size of the background images.
     *
     * @return
     */
    public MeasurementCSS[] Background_Size() default
    {
    };

    /**
     * Sets how a background image will be repeated
     */
    public Repeats Background_Repeat() default Repeats.Unset;

    /**
     * The background-origin property specifies where the background image is positioned.
     *
     * @return
     */
    public BackgroundOrigins Background_Origin() default BackgroundOrigins.Unset;

    /**
     * The background-clip property specifies the painting area of the background.
     *
     * @return
     */
    public BackgroundClip Background_Clip() default BackgroundClip.Unset;

    /**
     * Sets whether a background image is fixed or scrolls with the rest of the page
     */
    public BackgroundAttachments Background_Attachment() default BackgroundAttachments.Unset;

}
