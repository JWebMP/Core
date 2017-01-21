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

/**
 * Links and buttons Use &gt;a&lt;s or &gt;button&lt;s to create actionable list group items with hover, disabled, and active states by adding .list-group-item-action. We separate these pseudo-classes
 * to ensure list groups made of non-interactive elements (like &gt;li&lt;s or &gt;div&lt;s) don’t provide a click or tap affordance.
 * <p>
 * Be sure to not use the standard .btn classes here.
 *
 * @author GedMarc
 * @since 19 Jan 2017
 *
 */
public class BSListGroupLinkItem extends BSListGroupListItem
{

    private static final long serialVersionUID = 1L;

    /**
     * Links and buttons Use &gt;a&lt;s or &gt;button&lt;s to create actionable list group items with hover, disabled, and active states by adding .list-group-item-action. We separate these
     * pseudo-classes to ensure list groups made of non-interactive elements (like &gt;li&lt;s or &gt;div&lt;s) don’t provide a click or tap affordance.
     * <p>
     * Be sure to not use the standard .btn classes here.
     *
     * @param url
     * @param text
     */
    public BSListGroupLinkItem(String url, String text)
    {
        super(text);
        setTag("a");
        addAttribute("href", url);
        addClass(BSComponentListGroupOptions.List_Group_Item_Action);
    }
}
