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
package za.co.mmagon.jwebswing.components.bootstrap.carousel;

import za.co.mmagon.jwebswing.base.html.ListItem;
import za.co.mmagon.jwebswing.components.bootstrap.componentoptions.BSComponentDefaultOptions;

/**
 * Indicator list items
 *
 * @author GedMarc
 * @since 01 Jan 2017
 * @version 1.0
 *
 */
class BSCarouselIndicatorItem extends ListItem
{

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new carousel indicator that slides to a specific slide, and if it is the current active item or not
     *
     * @param dataTarget
     * @param slideTo
     * @param active
     */
    public BSCarouselIndicatorItem(String dataTarget, int slideTo, boolean active)
    {
        addAttribute("data-target", dataTarget);
        addAttribute("data-slide-to", ((Integer) slideTo).toString());
        if (active)
        {
            addClass(BSComponentDefaultOptions.Active);
        }
    }
}
