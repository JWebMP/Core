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
package za.co.mmagon.jwebswing.components.bootstrap.pagination;

import za.co.mmagon.jwebswing.base.html.ListItem;
import za.co.mmagon.jwebswing.base.html.interfaces.children.ListChildren;
import za.co.mmagon.jwebswing.components.bootstrap.componentoptions.BSComponentDefaultOptions;

/**
 * A pagination list item
 *
 * @author GedMarc
 * @since 21 Jan 2017
 *
 */
public class BSPageinationListItem extends ListItem implements ListChildren
{

    private static final long serialVersionUID = 1L;

    /**
     * A pagination list item
     */
    public BSPageinationListItem()
    {
        addClass(BSComponentPaginationOptions.Page_Item);
    }

    /**
     * Disabled and active states
     * <p>
     * Pagination links are customizable for different circumstances. Use .disabled for links that appear un-clickable and .active to indicate the current page.
     * <p>
     * While the .disabled class uses pointer-events: none to try to disable the link functionality of A's, that CSS property is not yet standardized and doesn’t account for keyboard navigation. As
     * such, you should always add tabindex="-1" on disabled links and use custom JavaScript to fully disable their functionality.
     *
     * @return
     */
    public BSPageinationListItem setDisabled()
    {
        addClass(BSComponentDefaultOptions.Disabled);
        addAttribute("tabindex", "-1");
        return this;
    }

    /**
     * Disabled and active states
     * <p>
     * Pagination links are customizable for different circumstances. Use .disabled for links that appear un-clickable and .active to indicate the current page.
     * <p>
     * While the .disabled class uses pointer-events: none to try to disable the link functionality of as, that CSS property is not yet standardized and doesn’t account for keyboard navigation. As
     * such, you should always add tabindex="-1" on disabled links and use custom JavaScript to fully disable their functionality.
     *
     * @return
     */
    public BSPageinationListItem setActive()
    {
        addClass(BSComponentDefaultOptions.Active);
        return this;
    }
}
