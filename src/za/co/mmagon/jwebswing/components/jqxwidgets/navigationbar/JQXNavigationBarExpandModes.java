/*
 * Copyright (C) 2015 GedMarc
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
package za.co.mmagon.jwebswing.components.jqxwidgets.navigationbar;

/**
 * This Class
 *
 * @author GedMarc
 * @since 20 Dec 2015
 */
public enum JQXNavigationBarExpandModes
{
    /**
     * only one item can be expanded. If the expanded item's height is greater than the value of the height property, a vertical scrollbar is shown.
     */
    single,
    /**
     * only one item can be expanded. If the expanded item's height is greater than the value of the height property, a vertical scrollbar is shown inside the content of the expanded item
     */
    singleFitHeight,
    /**
     * multiple items can be expanded. If the expanded items' height is greater than the value of the height property, a vertical scrollbar is shown.
     */
    multiple,
    /**
     * only one item can be expanded. The expanded item can also be collapsed.If the expanded item's height is greater than the value of the height property, a vertical scrollbar is shown
     */
    toggle,
    /**
     * no items can be expanded/collapsed
     */
    none;

    @Override
    public String toString()
    {
        return super.toString();
    }

}
