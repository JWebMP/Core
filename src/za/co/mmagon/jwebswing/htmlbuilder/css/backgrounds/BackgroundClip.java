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
 * The background-clip property specifies the painting area of the background.
 * <p>
 * Default value: border-box
 * <p>
 * Inherited: no
 * <p>
 * Animatable: no. Read about animatable
 * <p>
 * Version: CSS3
 * <p>
 * JavaScript syntax: object.style.backgroundClip="content-box"
 *
 * @author GedMarc
 * @since 17 Jan 2016
 */
public enum BackgroundClip implements CSSEnumeration<BackgroundClip>
{
    /**
     * Default value. The background is clipped/starts to the border box
     */
    border_box,
    /**
     * The background is clipped/starts to the padding box
     */
    padding_box,
    /**
     * The background is clipped/starts to the content box
     */
    content_box,
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

    @Override
    public String toString()
    {
        return name().toLowerCase().replace('_', '-');
    }

    @Override
    public String getJavascriptSyntax()
    {
        return "style.backgroundClip";
    }

    @Override
    public CSSVersions getCSSVersion()
    {
        return CSSVersions.CSS3;
    }

    @Override
    public String getValue()
    {
        return toString();
    }

    @Override
    public BackgroundClip getDefault()
    {
        return Unset;
    }
}
