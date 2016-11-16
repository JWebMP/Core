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
 *
 * @author GedMarc
 * @since 18 Jan 2016
 */
@CSSAnnotationType
public enum TableCaptionSides implements CSSEnumeration<TableCaptionSides>
{
    /**
     * Puts the caption above the table. This is default Play it »
     */
    Top,
    /**
     * Puts the caption below the table
     */
    Bottom,
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
    private TableCaptionSides()
    {
    }

    @Override
    public String toString()
    {
        return name().toLowerCase();
    }

    @Override
    public String getJavascriptSyntax()
    {
        return "style.captionSide";
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
    public TableCaptionSides getDefault()
    {
        return Unset;
    }

}
