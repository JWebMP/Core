/*
 * Copyright (C) 2015 GedMarc
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
package za.co.mmagon.jwebswing.components.bootstrap.cards;

import za.co.mmagon.jwebswing.base.html.interfaces.AttributeDefinitions;

/**
 * Cards
 * <p>
 * A card is a flexible and extensible content container. It includes options for headers and footers, a wide variety of content, contextual background colors, and powerful display options.
 * <p>
 * If you’re familiar with Bootstrap 3, cards replace our old panels, wells, and thumbnails. Similar functionality to those components is available as modifier classes for cards.
 *
 * @author GedMarc
 */
public enum BSCardAttributes implements AttributeDefinitions
{
    Visibility;

    private BSCardAttributes()
    {
    }

    private BSCardAttributes(boolean isKeyword)
    {
        this.isKeyword = isKeyword;
    }

    private boolean isKeyword;

    @Override
    public boolean isKeyword()
    {
        return isKeyword;
    }

    /**
     * Returns the attribute name replacing all underscores with dashes and all dollar signs to empty
     *
     * @return
     */
    @Override
    public String toString()
    {
        return name().toLowerCase().replace('_', '-').replace("$", "");
    }
}
