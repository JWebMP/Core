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
package za.co.mmagon.jwebswing.htmlbuilder.css.enumarations;

import za.co.mmagon.jwebswing.base.client.CSSVersions;
import za.co.mmagon.jwebswing.htmlbuilder.css.CSSEnumeration;

/**
 * Definition and Usage
 * <p>
 * The background-repeat property sets if/how a background image will be repeated.
 * <p>
 * By default, a background-image is repeated both vertically and horizontally.<p>
 * Tip: The background image is placed according to the background-position property.
 * <p>
 * If no background-position is specified, the image is always placed at the element's top left corner.
 * <p>
 * Default value: repeat
 * <p>
 * Inherited: no
 * <p>
 * Animatable: no. Read about animatable
 * <p>
 * Version: CSS1
 * <p>
 * JavaScript syntax: object.style.backgroundRepeat="repeat-x"
 * <p>
 * Try it
 * <p>
 * Browser Support
 * <p>
 * <p>
 * The numbers in the table specify the first browser version that fully supports the property.
 * <p>
 * Property
 * <p>
 * background-repeat 1.0 12.0 4.0 1.0 1.0 3.5
 *
 * @author GedMarc
 * @since 17 Jan 2016
 */
public enum Repeats implements CSSEnumeration
{
    /**
     * The background image will be repeated both vertically and horizontally. This is default
     */
    Repeat,
    /**
     * The background image will be repeated only horizontally
     */
    Repeat_x,
    /**
     * The background image will be repeated only vertically
     */
    Repeat_y,
    /**
     * The background-image will not be repeated
     */
    No_Repeat,
    /**
     * Sets this property to its default value
     *
     * see http://www.w3schools.com/cssref/css_initial.asp
     */
    Initial,
    /**
     * Inherits this property from its parent element.
     *
     * see http://www.w3schools.com/cssref/css_inherit.asp
     */
    Inherit,
    Unset;

    @Override
    public String toString()
    {
        return name().toLowerCase().replace('_', '-');
    }

    @Override
    public String getJavascriptSyntax()
    {
        return "style.backgroundRepeat";
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
    public CSSEnumeration getDefault()
    {
        return Unset;
    }
}
