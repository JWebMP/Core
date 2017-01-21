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

import za.co.mmagon.jwebswing.base.html.Link;
import za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes;
import za.co.mmagon.jwebswing.base.html.attributes.LinkAttributes;

/**
 * A pagination link for an item, usually auto generated from BSPagination
 *
 * @author GedMarc
 * @since 21 Jan 2017
 *
 */
public class BSPaginationLink extends Link
{

    private static final long serialVersionUID = 1L;

    /**
     * A pagination link for an item, usually auto generated from BSPagination
     *
     * @param ariaLabel In addition, as pages likely have more than one such navigation section, it’s advisable to provide a descriptive aria-label for the nav to reflect its purpose. For example, if
     *                  the pagination component is used to navigate between a set of search results, an appropriate label could be aria-label="Search results pages".
     */
    public BSPaginationLink(String ariaLabel)
    {
        addClass(BSComponentPaginationOptions.Page_Link);
        addAttribute(LinkAttributes.HRef, "#");
        addAttribute(GlobalAttributes.Aria_Label, ariaLabel);
    }

    /**
     * Returns this items parent (usually, may throw exceptions if used other than BSPagination.createLink();
     *
     * @return
     */
    public BSPageinationListItem getListItem()
    {
        return (BSPageinationListItem) getParent();
    }
}
