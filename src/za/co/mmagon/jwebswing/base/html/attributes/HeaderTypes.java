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

import com.fasterxml.jackson.annotation.JsonValue;
import za.co.mmagon.jwebswing.base.html.interfaces.AttributeDefinitions;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 *
 * An enumeration of the available header types
 * <p>
 * @author GedMarc
 */
public enum HeaderTypes implements AttributeDefinitions
{

    /**
     * The Header 1 Size
     */
    H1(ComponentTypes.Header1),
    /**
     * The HeaderText 2 Size
     */
    H2(ComponentTypes.Header2),
    /**
     * The HeaderText 3 Size
     */
    H3(ComponentTypes.Header3),
    /**
     * The HeaderText 4 Size
     */
    H4(ComponentTypes.Header4),
    /**
     * The HeaderText 5 Size
     */
    H5(ComponentTypes.Header5),
    /**
     * The HeaderText 6 Size
     */
    H6(ComponentTypes.Header6);

    private final ComponentTypes linkedComponent;

    /**
     * Constructs with linked Component
     * <p>
     * @param linkedComponent The linked component
     */
    private HeaderTypes(ComponentTypes linkedComponent)
    {
        this.linkedComponent = linkedComponent;
    }

    /**
     * Get Linked Component
     * <p>
     * @return The linked component
     */
    public ComponentTypes getLinkedComponent()
    {
        return linkedComponent;
    }

    @JsonValue
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
