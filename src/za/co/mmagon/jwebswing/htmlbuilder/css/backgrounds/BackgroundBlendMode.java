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

import za.co.mmagon.jwebswing.base.client.CSSVersions;
import za.co.mmagon.jwebswing.htmlbuilder.css.CSSEnumeration;

/**
 * Definition and Usage
 * <p>
 * <p>
 * The background-blend-mode property defines the blending mode of each background layer (color and/or image).
 * <p>
 * Default value: normal
 * <p>
 * Inherited: no
 * <p>
 * Animatable: no. Read about animatable
 * <p>
 * Version: CSS3
 * <p>
 * JavaScript syntax: object.style.backgroundBlendMode="screen"
 *
 * @author GedMarc
 * @since 17 Jan 2016
 */
public enum BackgroundBlendMode implements CSSEnumeration<BackgroundBlendMode>
{
    /**
     * This is default. Sets the blending mode to normal
     */
    normal,
    /**
     * Sets the blending mode to multiply
     */
    multiply,
    /**
     * Sets the blending mode to screen
     */
    screen,
    /**
     * Sets the blending mode to overlay
     */
    overlay,
    /**
     * Sets the blending mode to darken
     */
    darken,
    /**
     * Sets the blending mode to lighten
     */
    lighten,
    /**
     * Sets the blending mode to color-dodge
     */
    color_dodge,
    /**
     * Sets the blending mode to saturation
     */
    saturation,
    /**
     * Sets the blending mode to color
     */
    color,
    /**
     * Sets the blending mode to luminosity
     */
    luminosity,
    /**
     * Sets this field as not set
     */
    Unset;

    @Override
    public String toString()
    {
        return name().toLowerCase().replace('_', '-');
    }

    @Override
    public String getJavascriptSyntax()
    {
        return "style.backgroundBlendMode";
    }

    @Override
    public CSSVersions getCSSVersion()
    {
        return CSSVersions.CSS3;
    }

    @Override
    public String getValue()
    {
        return name();
    }

    @Override
    public BackgroundBlendMode getDefault()
    {
        return Unset;
    }
}
