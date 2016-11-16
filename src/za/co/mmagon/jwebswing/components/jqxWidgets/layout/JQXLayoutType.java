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
package za.co.mmagon.jwebswing.components.jqxWidgets.layout;

/**
 * This Class
 *
 * @author GedMarc
 * @since 15 Dec 2015
 */
public enum JQXLayoutType
{

    /**
     * - container for other groups. It has no visual features. The root item is always of this type.
     */
    layoutGroup,
    /**
     * a group that contains layoutPanels. It is represented by a jqxWindow-like panel with a bottom-aligned jqxRibbon inside.
     */
    tabbedGroup,
    /**
     * a group that contains documentPanels. It is represented by a top-aligned jqxRibbon.
     */
    documentGroup,
    /**
     * a group that contains layoutPanels. It is represented by a jqxRibbon with mode: popup. Each ribbon item has a jqxWindow-like panel in its content. This group has to be either the first or the
     * last child item of its parent layoutGroup.
     */
    autoHideGroup,
    /**
     * a panel that can be inserted in a tabbedGroup or autoHideGroup. When it is in a tabbedGroup it is represented by a ribbon item and in an autoHideGroup - by a jqxWindow-like panel inside a
     * ribbon item.
     */
    layoutPanel,
    /**
     * a panel that can be inserted in a documentGroup. It is represented by a ribbon item.
     */
    documentPanel,;

    @Override
    public String toString()
    {
        return super.toString();
    }

}
