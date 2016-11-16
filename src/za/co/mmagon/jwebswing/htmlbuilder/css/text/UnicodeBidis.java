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
package za.co.mmagon.jwebswing.htmlbuilder.css.text;

import za.co.mmagon.jwebswing.base.client.CSSVersions;
import za.co.mmagon.jwebswing.htmlbuilder.css.CSSEnumeration;

/**
 * Definition and Usage
 * <p>
 * The unicode-bidi property is used together with the direction property to set or return whether the text should be overridden to support multiple languages in the same document.
 * Default value: Normal
 * Inherited: yes
 * Animatable: no. Read about animatable
 * Version: CSS2
 * JavaScript syntax: object.style.unicodeBidi="bidi-override"
 *
 * @author GedMarc
 * @since 18 Jan 2016
 */
public enum UnicodeBidis implements CSSEnumeration<UnicodeBidis>
{
    /**
     * Does not use an additional level of embedding. This is default
     */
    /**
     * Does not use an additional level of embedding. This is default
     */
    Normal,
    /**
     * Creates an additional level of embedding
     */
    Embed,
    /**
     * Creates an additional level of embedding. Reordering depends on the direction property
     */
    Bidi_Override,
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
    /**
     * Sets this field as not set
     */
    Unset;

    ;
    private UnicodeBidis()
    {
    }

    @Override
    public String getJavascriptSyntax()
    {
        return "style.unicodeBidi";
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
    public UnicodeBidis getDefault()
    {
        return Unset;
    }

    @Override
    public String toString()
    {
        return name().toLowerCase().replace('_', '-');
    }

}
