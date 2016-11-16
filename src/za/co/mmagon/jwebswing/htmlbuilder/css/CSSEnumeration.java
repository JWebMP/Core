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
package za.co.mmagon.jwebswing.htmlbuilder.css;

import za.co.mmagon.jwebswing.base.client.CSSVersions;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.CSSAnnotationType;

/**
 * Defines an enumeration as CSS
 * Fills all the information required for a CSS Field
 *
 * @author GedMarc
 * @since 17 Jan 2016
 */
@CSSAnnotationType
public interface CSSEnumeration<T extends CSSEnumeration>
{

    /**
     * Returns the Enumeration Name in its clean form
     *
     * @return The Formatted Output for the enumeration
     */
    @Override
    public String toString();

    /**
     * Returns the JavaScript CSS Property form
     *
     * @return
     */
    public String getJavascriptSyntax();

    /**
     * Returns the CSS Version this enumeration is compatible with
     *
     * @return
     */
    public CSSVersions getCSSVersion();

    /**
     * Returns the value of this CSS Option.
     * Usually the name of the Enumeration
     *
     * @return
     */
    public String getValue();

    /**
     * Returns the default, AKA exclude render
     *
     * @return The member to never render, as it is the default
     */
    public T getDefault();

}
