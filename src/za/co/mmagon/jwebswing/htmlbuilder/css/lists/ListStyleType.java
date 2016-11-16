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
package za.co.mmagon.jwebswing.htmlbuilder.css.lists;

import za.co.mmagon.jwebswing.base.client.CSSVersions;
import za.co.mmagon.jwebswing.htmlbuilder.css.CSSEnumeration;

/**
 *
 * @author GedMarc
 * @since 18 Jan 2016
 */
public enum ListStyleType implements CSSEnumeration<ListStyleType>
{
    /**
     * Default value. The marker is a filled circle
     */
    disc,
    /**
     * The marker is traditional Armenian numbering
     */
    armenian,
    /**
     * The marker is a circle
     */
    circle,
    /**
     * The marker is plain ideographic numbers
     */
    cjk_ideographic,
    /**
     * The marker is a number
     */
    decimal,
    /**
     * The marker is a number with leading zeros (01, 02, 03, etc.)
     */
    decimal_leading_zero,
    /**
     * The marker is traditional Georgian numbering
     */
    georgian,
    /**
     * The marker is traditional Hebrew numbering
     */
    hebrew,
    /**
     * The marker is traditional Hiragana numbering
     */
    hiragana,
    /**
     * The marker is traditional Hiragana iroha numbering
     */
    hiragana_iroha,
    /**
     * The marker is traditional Katakana numbering
     */
    katakana,
    /**
     * The marker is traditional Katakana iroha numbering
     */
    katakana_iroha,
    /**
     * The marker is lower_alpha (a, b, c, d, e, etc.)
     */
    lower_alpha,
    /**
     * The marker is lower_greek
     */
    lower_greek,
    /**
     * The marker is lower_latin (a, b, c, d, e, etc.)
     */
    lower_latin,
    /**
     * The marker is lower_roman (i, ii, iii, iv, v, etc.)
     */
    lower_roman,
    /**
     * No marker is shown
     */
    none,
    /**
     * The marker is a square
     */
    square,
    /**
     * The marker is upper_alpha (A, B, C, D, E, etc.)
     */
    upper_alpha,
    /**
     * The marker is upper_latin (A, B, C, D, E, etc.)
     */
    upper_latin,
    /**
     * The marker is upper_roman (I, II, III, IV, V, etc.)
     */
    upper_roman,
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
        return "style.listStyleType";
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
    public ListStyleType getDefault()
    {
        return Unset;
    }
}
