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
package za.co.mmagon.jwebswing.components.jqxWidgets.dockinglayout;

import java.util.ArrayList;
import za.co.mmagon.jwebswing.base.servlets.enumarations.Orientation;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * This Class
 *
 * @author GedMarc
 * @since 14 Dec 2015
 */
public class JQXDockingLayoutArray extends JavaScriptPart
{

    /**
     * Possible values:
     * 'layoutGroup' - container for other groups. It has no visual features. The root item is always of this type.
     * 'tabbedGroup' - a group that contains layoutPanels. It is represented by a jqxWindow-like panel with a bottom-aligned jqxRibbon inside.
     * 'documentGroup' - a group that contains documentPanels. It is represented by a top-aligned jqxRibbon.
     * 'autoHideGroup' - a group that contains layoutPanels. It is represented by a jqxRibbon with mode: 'popup'. Each ribbon item has a jqxWindow-like panel in its content. This group has to be
     * either the first or the last child item of its parent layoutGroup.
     * 'layoutPanel' - a panel that can be inserted in a tabbedGroup or autoHideGroup. When it is in a tabbedGroup it is represented by a ribbon item and in an autoHideGroup - by a jqxWindow-like
     * panel inside a ribbon item.
     * 'documentPanel' - a panel that can be inserted in a documentGroup. It is represented by a ribbon item.
     * 'floatGroup' - a floating group that can contain a tabbedGroup or a layoutPanel. It is represented by a jqxWindow. Initial floatGroups have to be defined after the root layoutGroup in the
     * layout array.
     */
    private JQXDockingLayoutType type;
    /**
     * sets the alignment of an autoHideGroup. Possible values:
     * 'left'
     * 'right'
     * 'top'
     * 'bottom'
     */
    private JQXDockingLayoutAlignment alignment;
    /**
     * applicable to tabbedGroups, floatGroups, layoutPanels and documentPanels. If set to false, the group/panel cannot be closed.
     */
    private Boolean allowClose;
    /**
     * applicable only to tabbedGroups. If set to false, the group cannot be pinned.
     */
    private Boolean allowPin;
    /**
     * applicable only to autoHideGroups. If set to false, the group cannot be unpinned.
     */
    private Boolean allowUnpin;
    /**
     * indicates which HTML element has the content of the panel. The required value is the value of an existing HTML element's data-container attribute. N/A to groups.
     */
    private Div contentContainer;
    /**
     * sets the height of a group (N/A to panels). Used only if the parent group's orientation is 'vertical' or for floatGroups. The heights of all such groups have to be set either in pixels or
     * percents (not a mix of both).
     */
    private Integer height;
    /**
     * a callback function to be called when a panel is opened for the first time. Useful for initializing widgets in panels. N/A to groups.
     */
    private String initContent;
    /**
     * sets the minimumn height (in pixels) of a group which is vertically aligned within its parent group. Disregards the value of the minGroupHeight property.
     */
    private Integer minHeight;
    /**
     * sets the minimumn width (in pixels) of a group which is horizontally aligned within its parent group. Disregards the value of the minGroupWidth property.
     */
    private Integer minWidth;
    /**
     * orients child items either horizontally or vertically. Applicable only to layoutGroups. Possible values:
     * 'horizontal'
     * 'vertical'
     */
    private Orientation orientation;
    /**
     * sets what the height of a tabbedGroup will be after it is pinned.
     */
    private Integer pinnedHeight;
    /**
     * - sets what the width of a tabbedGroup will be after it is pinned
     */
    private Integer pinnedWidth;
    /**
     * sets the initial position of a floatGroup.The position property is an object with the following properties
     * x y
     */
    private Integer[] position;
    /**
     * Sets whether a panel is initially selected
     * .N/A to groups
     */
    private Boolean selected;
    /**
     * sets the title of a panel
     */
    private String title;
    /**
     * sets what the width of an autoHideGroup will be after it is unpinned.
     */
    private Integer unpinnedWidth;
    /**
     * sets the width of a group (N/A to panels). Used only if the parent group's orientation is 'horizontal' or for floatGroups. The widths of all such groups have to be set either in pixels or
     * percents (not a mix of both).
     */
    private Integer width;
    /**
     * an array of item objects with the fields described above. N/A to panels.
     */
    private ArrayList<JQXDockingLayoutArray> items;

    public JQXDockingLayoutArray()
    {
    }

    @Override
    public String toString()
    {
        return super.toString();
    }

    public JQXDockingLayoutType getType()
    {
        return type;
    }

    public void setType(JQXDockingLayoutType type)
    {
        this.type = type;
    }

    public JQXDockingLayoutAlignment getAlignment()
    {
        return alignment;
    }

    public void setAlignment(JQXDockingLayoutAlignment alignment)
    {
        this.alignment = alignment;
    }

    public Boolean getAllowClose()
    {
        return allowClose;
    }

    public void setAllowClose(Boolean allowClose)
    {
        this.allowClose = allowClose;
    }

    public Boolean getAllowPin()
    {
        return allowPin;
    }

    public void setAllowPin(Boolean allowPin)
    {
        this.allowPin = allowPin;
    }

    public Boolean getAllowUnpin()
    {
        return allowUnpin;
    }

    public void setAllowUnpin(Boolean allowUnpin)
    {
        this.allowUnpin = allowUnpin;
    }

    public Div getContentContainer()
    {
        return contentContainer;
    }

    public void setContentContainer(Div contentContainer)
    {
        this.contentContainer = contentContainer;
    }

    public Integer getHeight()
    {
        return height;
    }

    public void setHeight(Integer height)
    {
        this.height = height;
    }

    public String getInitContent()
    {
        return initContent;
    }

    public void setInitContent(String initContent)
    {
        this.initContent = initContent;
    }

    public Integer getMinHeight()
    {
        return minHeight;
    }

    public void setMinHeight(Integer minHeight)
    {
        this.minHeight = minHeight;
    }

    public Integer getMinWidth()
    {
        return minWidth;
    }

    public void setMinWidth(Integer minWidth)
    {
        this.minWidth = minWidth;
    }

    public Orientation getOrientation()
    {
        return orientation;
    }

    public void setOrientation(Orientation orientation)
    {
        this.orientation = orientation;
    }

    public Integer getPinnedHeight()
    {
        return pinnedHeight;
    }

    public void setPinnedHeight(Integer pinnedHeight)
    {
        this.pinnedHeight = pinnedHeight;
    }

    public Integer getPinnedWidth()
    {
        return pinnedWidth;
    }

    public void setPinnedWidth(Integer pinnedWidth)
    {
        this.pinnedWidth = pinnedWidth;
    }

    public Integer[] getPosition()
    {
        return position;
    }

    public void setPosition(Integer[] position)
    {
        this.position = position;
    }

    public Boolean getSelected()
    {
        return selected;
    }

    public void setSelected(Boolean selected)
    {
        this.selected = selected;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Integer getUnpinnedWidth()
    {
        return unpinnedWidth;
    }

    public void setUnpinnedWidth(Integer unpinnedWidth)
    {
        this.unpinnedWidth = unpinnedWidth;
    }

    public Integer getWidth()
    {
        return width;
    }

    public void setWidth(Integer width)
    {
        this.width = width;
    }

    public ArrayList<JQXDockingLayoutArray> getItems()
    {
        return items;
    }

    public void setItems(ArrayList<JQXDockingLayoutArray> items)
    {
        this.items = items;
    }

}
