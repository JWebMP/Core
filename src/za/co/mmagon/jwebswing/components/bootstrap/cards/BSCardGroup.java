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
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;

/**
 * Groups
 * <p>
 * Use card groups to render cards as a single, attached element with equal width and height columns.
 * <p>
 * By default, card groups use display: table; and table-layout: fixed; to achieve their uniform sizing. However, enabling flexbox mode can switch that to use display: flex; and provide the same
 * effect.
 * <p>
 * Only applies to small devices and above.
 *
 * @author GedMarc
 * @since 01 Jan 2017
 * @version 1.0
 *
 */
public class BSCardGroup extends Div<BSCard, NoAttributes, GlobalFeatures, GlobalEvents, BSCardGroup>
{

    private static final long serialVersionUID = 1L;

    /**
     * Groups
     * <p>
     * Use card groups to render cards as a single, attached element with equal width and height columns.
     * <p>
     * By default, card groups use display: table; and table-layout: fixed; to achieve their uniform sizing. However, enabling flexbox mode can switch that to use display: flex; and provide the same
     * effect.
     * <p>
     * Only applies to small devices and above.
     */
    public BSCardGroup()
    {
        addClass(BSComponentCardOptions.Card_Group);
    }
}
