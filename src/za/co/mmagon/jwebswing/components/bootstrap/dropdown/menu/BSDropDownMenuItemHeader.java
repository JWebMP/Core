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
package za.co.mmagon.jwebswing.components.bootstrap.dropdown.menu;

import za.co.mmagon.jwebswing.base.html.attributes.LinkAttributes;
import za.co.mmagon.jwebswing.components.bootstrap.dropdown.BSComponentDropDownOptions;

/**
 * Menu headers
 * <p>
 * Add a header to label sections of actions in any dropdown menu.
 *
 * @author GedMarc
 * @since 14 Jan 2017
 *
 */
public class BSDropDownMenuItemHeader extends BSDropDownMenuItem
{

    private static final long serialVersionUID = 1L;

    /**
     * Menu headers
     * <p>
     * Add a header to label sections of actions in any dropdown menu.
     *
     * @param text
     */
    public BSDropDownMenuItemHeader(String text)
    {
        super(text);
        config();
    }

    /**
     * Menu headers
     * <p>
     * Add a header to label sections of actions in any dropdown menu.
     *
     * @param iconClass
     * @param text
     */
    public BSDropDownMenuItemHeader(String iconClass, String text)
    {
        super(iconClass, text);
        config();
    }

    /**
     * Sets tag to h6 and applies classes
     */
    private void config()
    {
        setTag("h6");
        addClass(BSComponentDropDownOptions.Dropdown_Header);
        removeClass(BSComponentDropDownOptions.Downdown_Item.toString());
        getAttributes().remove(LinkAttributes.HRef);
    }
}
