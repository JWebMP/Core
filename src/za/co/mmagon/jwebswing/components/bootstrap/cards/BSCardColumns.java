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
 * Columns
 * <p>
 * Cards can be organized into Masonry-like columns with just CSS by wrapping them in .card-columns. Cards are ordered from top to bottom and left to right when wrapped in .card-columns.
 * <p>
 * Only applies to small devices and above.
 * <p>
 * Heads up! This is not available in IE9 and below as they have no support for the column-* CSS properties.
 *
 * @author GedMarc
 * @since 01 Jan 2017
 * @version 1.0
 *
 */
public class BSCardColumns extends Div<BSCard, NoAttributes, GlobalFeatures, GlobalEvents, BSCardColumns> implements GlobalChildren
{

    private static final long serialVersionUID = 1L;

    /**
     * Columns
     * <p>
     * Cards can be organized into Masonry-like columns with just CSS by wrapping them in .card-columns. Cards are ordered from top to bottom and left to right when wrapped in .card-columns.
     * <p>
     * Only applies to small devices and above.
     * <p>
     * Heads up! This is not available in IE9 and below as they have no support for the column-* CSS properties.
     */
    public BSCardColumns()
    {
        addClass(BSComponentCardOptions.Card_Columns);
    }

    @Override
    public StringBuilder renderCss(int tabCount, boolean renderOpening, boolean renderInQuotations, boolean isAjaxCall)
    {
        return super.renderCss(tabCount, renderOpening, renderInQuotations, isAjaxCall).append(".card-columns {")
                .append(getNewLine())
                .append("  @include media-breakpoint-only(lg) {").append(getNewLine())
                .append("    column-count: 4;").append(getNewLine()).append("  }")
                .append(getNewLine()).append("  @include media-breakpoint-only(xl) {")
                .append(getNewLine()).append("    column-count: 5;")
                .append(getNewLine()).append("  }")
                .append(getNewLine()).append("}");
    }

}
