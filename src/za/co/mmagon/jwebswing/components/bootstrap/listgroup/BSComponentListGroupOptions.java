/*
 * Copyright (C) 2016 GedMarc
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

import za.co.mmagon.jwebswing.components.bootstrap.componentoptions.IBSComponentOptions;

/**
 * List group
 * <p>
 * List groups are a flexible and powerful component for displaying a series of content. List group items can be modified and extended to support just about any content within. They can also be used
 * as navigation with the right modifier class.
 *
 * @author GedMarc
 */
public enum BSComponentListGroupOptions implements IBSComponentOptions
{
    /**
     * List group
     * <p>
     * List groups are a flexible and powerful component for displaying a series of content. List group items can be modified and extended to support just about any content within. They can also be
     * used as navigation with the right modifier class.
     */
    List_Group,
    /**
     * Basic example
     * <p>
     * The most basic list group is an unordered list with list items and the proper classes. Build upon it with the options that follow, or with your own CSS as needed.
     */
    List_Group_Item,
    /**
     * Links and buttons
     * <p>
     * Use &lt;a&gt;s or &lt;button&gt;s to create actionable list group items with hover, disabled, and active states by adding .list-group-item-action. We separate these pseudo-classes to ensure
     * list groups made of non-interactive elements (like &lt;li&gt;s or &lt;div&gt;s) don’t provide a click or tap affordance.
     * <p>
     * Be sure to not use the standard .btn classes here.
     */
    List_Group_Item_Action,
    /**
     * Contextual classes
     * <p>
     * Use contextual classes to style list items with a stateful background and color.
     */
    List_Group_Item_Success,
    /**
     * Contextual classes
     * <p>
     * Use contextual classes to style list items with a stateful background and color.
     */
    List_Group_Item_Info,
    /**
     * Contextual classes
     * <p>
     * Use contextual classes to style list items with a stateful background and color.
     */
    List_Group_Item_Warning,
    /**
     * Contextual classes
     * <p>
     * Use contextual classes to style list items with a stateful background and color.
     */
    List_Group_Item_Danger,
    /**
     * Active items
     * <p>
     * Add .active to a .list-group-item to indicate the current active selection.
     */
    Active,
    /**
     * Disabled items
     * <p>
     * Add .disabled to a .list-group-item to make it appear disabled. Note that some elements with .disabled will also require custom JavaScript to fully disable their click events (e.g., links).
     */
    Disabled,;

    private BSComponentListGroupOptions()
    {

    }

    @Override
    public String toString()
    {
        return name().toLowerCase().replace('_', '-');
    }

}
