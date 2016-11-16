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
 * The empty-cells property sets whether or not to display borders and background on empty cells in a table (only for the "separated borders" model).
 * Default value: show
 * Inherited: yes
 * Animatable: no. Read about animatable
 * Version: CSS2
 * JavaScript syntax: object.style.emptyCells="hide"
 *
 * @author GedMarc
 * @since 18 Jan 2016
 */
@CSSAnnotationType
public enum TableEmptyCells implements CSSEnumeration<TableEmptyCells>
{
    /**
     * Background and borders are shown on empty cells. This is default
     */
    Show,
    /**
     * No background or borders are shown on empty cells
     */
    Hide,
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

    private TableEmptyCells()
    {
    }

    @Override
    public String getJavascriptSyntax()
    {
        return "style.emptyCells";
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
    public TableEmptyCells getDefault()
    {
        return Unset;
    }
}
