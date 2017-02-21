/*
 * Copyright (C) 2017 Marc Magon
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
package za.co.mmagon.jwebswing.base.html.attributes;

import za.co.mmagon.jwebswing.base.html.interfaces.AttributeDefinitions;

/**
 * This class holds CSS Enumerations that are global across all HTML elements
 * <p>
 * @author Marc Magon
 */
public enum GlobalAttributes implements AttributeDefinitions
{

    /**
     * Specifies a unique id for an element
     */
    ID(),
    /**
     * Specifies an in-line CSS style for an element
     */
    Style(),
    /**
     * Specifies extra information about an element
     */
    Title(),
    /**
     * Specifies the name of an anchor Not Supported in HTML5 use global attribute ID instead, but it is used everywhere by everything else. Just not by the HTML engine. and forms have to have them
     */
    Name(),
    /**
     * Specifies one or more class-names for an element (refers to a class in a style sheet)
     */
    Class(),
    /**
     * Specifies a JWType handler for an element
     */
    JWType(),
    /**
     * Specifies a type
     */
    Type(),
    /**
     * The JW Event Mappings
     */
    Events(),
    /**
     * Generic Value Mapping
     */
    Value,
    /**
     * Screen Reader Labels
     */
    Aria_Label,
    /**
     * Screen Reader Invisible
     */
    Aria_Hidden,
    /**
     * Screen Reader to show pressed or not
     */
    Aria_Pressed,
    /**
     * Screen Reader to show disabled
     */
    Aria_Disabled,
    /**
     * Screen Reader described by
     */
    Aria_Describedby,
    /**
     * Expanded on screen reader mode
     */
    Aria_Expanded,
    /**
     * Screen reader has popup
     */
    Aria_HasPopup,
    /**
     * Screen Reader labelled by
     */
    Aria_LabelledBy,
    Aria_Controls,;

    private GlobalAttributes()
    {
    }

    /**
     * Returns the lowercase
     * <p>
     * @return
     */
    @Override
    public String toString()
    {
        return name().toLowerCase();
    }

    @Override
    public boolean isKeyword()
    {
        return false;
    }
}
