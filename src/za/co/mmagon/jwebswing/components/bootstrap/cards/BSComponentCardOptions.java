/*
 * Copyright (C) 2017 GedMarc
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

import za.co.mmagon.jwebswing.components.bootstrap.componentoptions.IBSComponentOptions;

/**
 * Cards
 * <p>
 * A card is a flexible and extensible content container. It includes options for headers and footers, a wide variety of content, contextual background colors, and powerful display options.
 * <p>
 * If you’re familiar with Bootstrap 3, cards replace our old panels, wells, and thumbnails. Similar functionality to those components is available as modifier classes for cards.
 *
 * @author GedMarc
 * @since 01 Jan 2017
 * @version 1.0
 *
 */
public enum BSComponentCardOptions implements IBSComponentOptions
{
    /**
     * Cards
     * <p>
     * A card is a flexible and extensible content container. It includes options for headers and footers, a wide variety of content, contextual background colors, and powerful display options.
     * <p>
     * If you’re familiar with Bootstrap 3, cards replace our old panels, wells, and thumbnails. Similar functionality to those components is available as modifier classes for cards.
     */
    Card,
    /**
     * Formats as a card header object
     */
    Card_Header,
    /**
     * Formats as a card footer object
     */
    Card_Footer,
    /**
     * Displays text as default to white. Use with darker themes
     */
    Card_Inverse,
    /**
     * Displays and pads an item for card blocks
     */
    Card_Block,
    /**
     * Card titles are used by adding .card-title to a h* tag. In the same way, links are added and placed next to each other by adding .card-link to a a tag.
     */
    Card_Title,
    /**
     * Subtitles are used by adding a .card-subtitle to an h* tag.
     * <p>
     * If the .card-title and the .card-subtitle items are placed in a .card-block item, the card title and subtitle are aligned nicely.
     * <p>
     * The multiple content types can be easily combined to create the card you need. See below for an example.
     */
    Card_Subtitle,
    /**
     * With .card-text, text can be added to the card. Text within .card-text can also be styled with the standard HTML tags
     */
    Card_Text,
    /**
     * Card titles are used by adding .card-title to a h* tag. In the same way, links are added and placed next to each other by adding .card-link to a a tag.
     */
    Card_Link,
    /**
     * .card-img-top places an image to the top of the card.
     */
    Card_Img_Top,
    /**
     * Formats the image for the bottom
     */
    Card_Img_Bottom,
    /**
     * Places the contents on top of the image
     */
    Card_Img_Overlay,
    /**
     * Formats a card in the primary fashion
     */
    Card_Primary,
    /**
     * Formats a card in the success fashion
     */
    Card_Success,
    /**
     * Formats a card in the info fashion
     */
    Card_Info,
    /**
     * Formats a card in the warning fashion
     */
    Card_Warning,
    /**
     * Formats a card in the danger fashion
     */
    Card_Danger,
    /**
     * Formats a card in the primary fashion outlined
     */
    Card_Outline_Primary,
    /**
     * Formats a card in the success fashion outlined
     */
    Card_Outline_Success,
    /**
     * Formats a card in the info fashion outlined
     */
    Card_Outline_Info,
    /**
     * Formats a card in the warning fashion outlined
     */
    Card_Outline_Warning,
    /**
     * Formats a card in the danger fashion outlined
     */
    Card_Outline_Danger,
    /**
     * Use card groups to render cards as a single, attached element with equal width and height columns. By default, card groups use display: table; and table-layout: fixed; to achieve their uniform
     * sizing. However, enabling flexbox mode can switch that to use display: flex; and provide the same effect.
     */
    Card_Group,
    /**
     * Need a set of equal width and height cards that aren’t attached to one another? Use card decks. By default, card decks require two wrapping elements: .card-deck-wrapper and a .card-deck. We use
     * table styles for the sizing and the gutters on .card-deck. The .card-deck-wrapper is used to negative margin out the border-spacing on the .card-deck.
     */
    Card_Deck,
    /**
     * Need a set of equal width and height cards that aren’t attached to one another? Use card decks. By default, card decks require two wrapping elements: .card-deck-wrapper and a .card-deck. We use
     * table styles for the sizing and the gutters on .card-deck. The .card-deck-wrapper is used to negative margin out the border-spacing on the .card-deck.
     */
    Card_Deck_Wrpper,
    /**
     * Columns
     * <p>
     * Cards can be organized into Masonry-like columns with just CSS by wrapping them in .card-columns. Cards are ordered from top to bottom and left to right when wrapped in .card-columns.
     * <p>
     * Only applies to small devices and above.
     * <p>
     * Heads up! This is not available in IE9 and below as they have no support for the column-* CSS properties.
     */
    Card_Columns;

    @Override
    public String toString()
    {
        return name().toLowerCase().replace('_', '-');
    }
}
