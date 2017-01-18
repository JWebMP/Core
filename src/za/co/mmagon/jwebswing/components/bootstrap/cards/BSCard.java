/*
 * Copyright (C) 2015 Marc Magon
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

import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.html.*;

/**
 * Cards
 * <p>
 * A card is a flexible and extensible content container. It includes options for headers and footers, a wide variety of content, contextual background colors, and powerful display options.
 * <p>
 * If you’re familiar with Bootstrap 3, cards replace our old panels, wells, and thumbnails. Similar functionality to those components is available as modifier classes for cards.
 * <p>
 * @author Marc Magon
 * @since 29 Aug 2015
 * @version 1.0
 */
public class BSCard extends Div<BSCardChildren, BSCardAttributes, BSCardFeatures, BSCardEvents, BSCard>
{

    private static final long serialVersionUID = 1L;
    private BSCardFeature feature;

    /**
     * Cards
     * <p>
     * A card is a flexible and extensible content container. It includes options for headers and footers, a wide variety of content, contextual background colors, and powerful display options.
     * <p>
     * If you’re familiar with Bootstrap 3, cards replace our old panels, wells, and thumbnails. Similar functionality to those components is available as modifier classes for cards.
     */
    public BSCard()
    {
        addClass(BSComponentCardOptions.Card);
    }

    /**
     * Cards
     * <p>
     * A card is a flexible and extensible content container. It includes options for headers and footers, a wide variety of content, contextual background colors, and powerful display options.
     * <p>
     * If you’re familiar with Bootstrap 3, cards replace our old panels, wells, and thumbnails. Similar functionality to those components is available as modifier classes for cards.
     *
     * @param text
     */
    public BSCard(String text)
    {
        super(text);
        addClass(BSComponentCardOptions.Card);
    }

    /**
     * Returns the blank feature for now
     *
     * @return
     */
    public final BSCardFeature getFeature()
    {
        if (feature == null)
        {
            feature = new BSCardFeature(this);
        }
        return feature;
    }

    /**
     * Returns nothing.. for now
     *
     * @return
     */
    @Override
    public BSCardOptions getOptions()
    {
        return getFeature().getOptions();
    }

    /**
     * Adds the text to the card with the card text
     *
     * @param textToAdd
     *
     * @return
     */
    public BSCardChildren addCardText(String textToAdd)
    {
        Paragraph p = new Paragraph(textToAdd);
        super.add(p);
        p.addClass(BSComponentCardOptions.Card_Text);
        return p;
    }

    /**
     * Adds the child with the given class if necessary
     *
     * @param newChild
     *
     * @return
     */
    public BSCardChildren addCardChildren(BSCardChildren newChild)
    {
        if (Div.class.isAssignableFrom(newChild.getClass()))
        {
            Div.class.cast(newChild).addClass(BSComponentCardOptions.Card_Block);
        }
        else if (HeaderText.class.isAssignableFrom(newChild.getClass()))
        {
            boolean isSubtitle = false;
            for (ComponentHierarchyBase componentHierarchyBase : getChildren())
            {
                if (HeaderText.class.isAssignableFrom(componentHierarchyBase.getClass()))
                {
                    isSubtitle = true;
                }
            }
            if (isSubtitle)
            {
                HeaderText.class.cast(newChild).addClass(BSComponentCardOptions.Card_Subtitle);
                return super.add(1, newChild);
            }
            else
            {
                HeaderText.class.cast(newChild).addClass(BSComponentCardOptions.Card_Title);
                return super.add(0, newChild);
            }
        }
        else if (Image.class.isAssignableFrom(newChild.getClass()))
        {
            Image.class.cast(newChild).addClass(BSComponentCardOptions.Card_Img_Top);
        }
        else if (Link.class.isAssignableFrom(newChild.getClass()))
        {
            Link.class.cast(newChild).addClass(BSComponentCardOptions.Card_Link);
        }
        return super.add(newChild);
    }

}
