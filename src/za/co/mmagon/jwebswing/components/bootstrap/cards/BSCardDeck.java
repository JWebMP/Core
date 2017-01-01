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

import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;

/**
 * Need a set of equal width and height cards that aren’t attached to one another? Use card decks. By default, card decks require two wrapping elements: .card-deck-wrapper and a .card-deck. We use
 * table styles for the sizing and the gutters on .card-deck. The .card-deck-wrapper is used to negative margin out the border-spacing on the .card-deck.
 *
 * @author GedMarc
 * @since 01 Jan 2017
 * @version 1.0
 *
 */
public class BSCardDeck extends Div<BSCard, NoAttributes, GlobalFeatures, GlobalEvents, BSCardDeck> implements GlobalChildren
{

    private static final long serialVersionUID = 1L;

    /**
     * Need a set of equal width and height cards that aren’t attached to one another? Use card decks. By default, card decks require two wrapping elements: .card-deck-wrapper and a .card-deck. We use
     * table styles for the sizing and the gutters on .card-deck. The .card-deck-wrapper is used to negative margin out the border-spacing on the .card-deck.
     */
    public BSCardDeck()
    {
        addClass(BSComponentCardOptions.Card_Deck);
    }
}
