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
 The background-blend-mode property defines the blending mode of each background layer (Color and/or image).
 <p>
 Default value: Normal
 <p>
 * Inherited: no
 * <p>
 * Animatable: no. Read about animatable
 * <p>
 * Version: CSS3
 * <p>
 JavaScript syntax: object.style.backgroundBlendMode="Screen"
 *
 * @author GedMarc
 * @since 17 Jan 2016
 */
public enum BackgroundBlendMode implements CSSEnumeration<BackgroundBlendMode>
{
    /**
     * This is default. Sets the blending mode to Normal
     */
    Normal,
    /**
     * Sets the blending mode to Multiply
     */
    Multiply,
    /**
     * Sets the blending mode to Screen
     */
    Screen,
    /**
     * Sets the blending mode to Overlay
     */
    Overlay,
    /**
     * Sets the blending mode to Darken
     */
    Darken,
    /**
     * Sets the blending mode to Lighten
     */
    Lighten,
    /**
     * Sets the blending mode to Color-dodge
     */
    Color_Dodge,
    /**
     * Sets the blending mode to Saturation
     */
    Saturation,
    /**
     * Sets the blending mode to Color
     */
    Color,
    /**
     * Sets the blending mode to Luminosity
     */
    Luminosity,
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
