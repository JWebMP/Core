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
package za.co.mmagon.jwebswing.htmlbuilder.css.tables;

import za.co.mmagon.jwebswing.base.client.CSSVersions;
import za.co.mmagon.jwebswing.htmlbuilder.css.CSSEnumeration;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.CSSAnnotationType;

/**
 * Definition and Usage
 * <p>
 * The border-collapse property sets whether the table borders are collapsed into a single border or detached as in standard HTML.
 * Default value: separate
 * Inherited: yes
 * Animatable: no. Read about animatable
 * Version: CSS2
 * JavaScript syntax: object.style.borderCollapse="collapse"
 *
 * @author GedMarc
 * @since 18 Jan 2016
 */
@CSSAnnotationType
public enum TableBorderCollapse implements CSSEnumeration<TableBorderCollapse>
{
    /**
     * Borders are detached (border-spacing and empty-cells properties will not be ignored). This is default
     */
    Separate,
    /**
     * Borders are collapsed into a single border when possible (border-spacing and empty-cells properties will be ignored)
     */
    Collapse,
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

    @Override
    public String toString()
    {
        return name().toLowerCase();
    }

    private TableBorderCollapse()
    {
    }

    @Override
    public String getJavascriptSyntax()
    {
        return "style.borderCollapse";
    }

    @Override
    public CSSVersions getCSSVersion()
    {
        return CSSVersions.CSS2;
    }

    @Override
    public String getValue()
    {
        return name();
    }

    @Override
    public TableBorderCollapse getDefault()
    {
        return Unset;
    }
}
