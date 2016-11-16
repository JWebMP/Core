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
package za.co.mmagon.jwebswing.htmlbuilder.css.heightwidth;

import za.co.mmagon.jwebswing.base.client.CSSVersions;
import za.co.mmagon.jwebswing.htmlbuilder.css.CSSEnumeration;

/**
 * Available Width Settings
 *
 * @author GedMarc
 * @since 18 Jan 2016
 */
public enum WidthSetting implements CSSEnumeration<WidthSetting>
{
    /**
     * Sets the type to auto
     */
    Auto,
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

    ;

    @Override
    public String toString()
    {
        return super.name().toLowerCase();
    }

    private WidthSetting()
    {
    }

    @Override
    public String getJavascriptSyntax()
    {
        return "style.width";
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
    public WidthSetting getDefault()
    {
        return Unset;
    }
}
