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
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.CSSAnnotationType;

/**
 * Definition and Usage
 * <p>
 * The background-position property sets the starting position of a background image.
 * <p>
 * Tip: By default, a background-image is placed at the top-left corner of an element, and repeated both vertically and horizontally.
 * <p>
 * Default value: 0% 0%
 * <p>
 * Inherited: no
 * <p>
 * Animatable: yes. Read about animatable
 * <p>
 * Version: CSS1
 * <p>
 * JavaScript syntax: object.style.backgroundPosition="center"
 *
 * @author GedMarc
 * @since 17 Jan 2016
 */
@CSSAnnotationType
public enum BackgroundPositions implements CSSEnumeration<BackgroundPositions>
{
    /**
     * If you only specify one keyword, the other value will be "center"
     */
    Left,
    /**
     * If you only specify one keyword, the other value will be "center"
     */
    Center,
    /**
     * If you only specify one keyword, the other value will be "center"
     */
    Right,
    /**
     * Place at Left Top
     */
    Left_Top,
    /**
     * Place at Left Center
     */
    Left_Center,
    /**
     * Place at Left Bottom
     */
    Left_Bottom,
    /**
     * Place at Right Top
     */
    Right_Top,
    /**
     * Place at Right Center
     */
    Right_Center,
    /**
     * Place at Right Bottom
     */
    Right_Bottom,
    /**
     * Place at Center Top
     */
    Center_Top,
    /**
     * Place at Center Center
     */
    Center_Center,
    /**
     * Place at Center Bottom
     */
    Center_Bottom,
    /**
     * Sets this property to its default value
     * <p>
     * see http://www.w3schools.com/cssref/css_initial.asp
     */
    Initial,
    /**
     * Inherits this property from its parent element.
     * <p>
     * see http://www.w3schools.com/cssref/css_inherit.asp
     */
    Inherit,
    /**
     * Sets this field as not set
     */
    Unset;

    /**
     * Returns the name in lowercase with underscores replaced as spaces
     *
     * @return
     */
    @Override
    public String toString()
    {
        return name().toLowerCase().replace('_', ' ');
    }

    public String getJavascriptSyntax()
    {
        return "style.backgroundPosition";
    }

    @Override
    public CSSVersions getCSSVersion()
    {
        return CSSVersions.CSS1;
    }

    @Override
    public String getValue()
    {
        return name();
    }

    @Override
    public BackgroundPositions getDefault()
    {
        return Unset;
    }
}
