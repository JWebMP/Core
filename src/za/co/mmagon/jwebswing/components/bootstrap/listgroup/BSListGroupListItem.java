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
package za.co.mmagon.jwebswing.components.bootstrap.listgroup;

import za.co.mmagon.jwebswing.base.html.ListItem;

/**
 * Basic example The most basic list group is an unordered list with list items and the proper classes. Build upon it with the options that follow, or with your own CSS as needed.
 *
 * @author GedMarc
 * @since 19 Jan 2017
 *
 */
public class BSListGroupListItem extends ListItem implements BSListGroupChildren
{

    private static final long serialVersionUID = 1L;

    /**
     * Basic example The most basic list group is an unordered list with list items and the proper classes. Build upon it with the options that follow, or with your own CSS as needed.
     */
    public BSListGroupListItem()
    {
        addClass(BSComponentListGroupOptions.List_Group_Item);
    }

    /**
     * Basic example The most basic list group is an unordered list with list items and the proper classes. Build upon it with the options that follow, or with your own CSS as needed.
     *
     * @param text
     */
    public BSListGroupListItem(String text)
    {
        super(text);
        addClass(BSComponentListGroupOptions.List_Group_Item);
    }

    /**
     * Active items Add .active to a .list-group-item to indicate the current active selection.
     *
     * @return
     */
    public BSListGroupListItem setActive()
    {
        addClass(BSComponentListGroupOptions.Active);
        return this;
    }

    /**
     * Disabled items Add .disabled to a .list-group-item to make it appear disabled. Note that some elements with .disabled will also require custom JavaScript to fully disable their click events
     * (e.g., links).
     *
     * @return
     */
    public BSListGroupListItem setDisabled()
    {
        addClass(BSComponentListGroupOptions.Disabled);
        return this;
    }

    /**
     * Contextual classes Use contextual classes to style list items with a stateful background and color.
     *
     * @return
     */
    public BSListGroupListItem setSuccess()
    {
        addClass(BSComponentListGroupOptions.List_Group_Item_Success);
        return this;
    }

    /**
     * Contextual classes Use contextual classes to style list items with a stateful background and color.
     *
     * @return
     */
    public BSListGroupListItem setWarning()
    {
        addClass(BSComponentListGroupOptions.List_Group_Item_Warning);
        return this;
    }

    /**
     * Contextual classes Use contextual classes to style list items with a stateful background and color.
     *
     * @return
     */
    public BSListGroupListItem setInfo()
    {
        addClass(BSComponentListGroupOptions.List_Group_Item_Info);
        return this;
    }

    /**
     * Contextual classes Use contextual classes to style list items with a stateful background and color.
     *
     * @return
     */
    public BSListGroupListItem setDanger()
    {
        addClass(BSComponentListGroupOptions.List_Group_Item_Danger);
        return this;
    }

}
