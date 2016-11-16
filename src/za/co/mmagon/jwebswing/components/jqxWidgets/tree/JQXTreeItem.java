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
package za.co.mmagon.jwebswing.components.jqxWidgets.tree;

import java.util.ArrayList;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.components.jqxWidgets.dataadapter.options.JQXDataAdapterSourceData;

/**
 *
 * @author GedMarc
 * @since 29 Jan 2016
 */
public class JQXTreeItem extends JQXDataAdapterSourceData
{

    private static final long serialVersionUID = 1L;

    private String label;// - sets the item's label.
    private String value;// - sets the item's value.
    private String html;// - item's html. The html to be displayed in the item.
    private String id;// - sets the item's id.
    private Boolean disabled;// - sets whether the item is enabled/disabled.
    private Boolean checked;// - sets whether the item is checked/unchecked(when checkboxes are enabled).
    private Boolean expanded;// - sets whether the item is expanded or collapsed.
    private Boolean selected;// - sets whether the item is selected.
    private ArrayList<JQXTreeItem> items;// - sets an array of sub items.
    private String icon;// - sets the item's icon(url is expected).
    private Integer iconsize;// - sets the size of the item's icon.

    public JQXTreeItem()
    {
    }

    /**
     * sets the item's label.
     *
     * @return
     */
    public String getLabel()
    {
        return label;
    }

    /**
     * sets the item's label.
     *
     * @param label
     */
    public void setLabel(String label)
    {
        this.label = label;
    }

    /**
     * sets the item's value.
     *
     * @return
     */
    public String getValue()
    {
        return value;
    }

    /**
     * sets the item's value.
     *
     * @param value
     */
    public void setValue(String value)
    {
        this.value = value;
    }

    /**
     * The html to be displayed in the item.
     *
     * @return
     */
    public String getHtml()
    {
        return html;
    }

    /**
     * The html to be displayed in the item.
     * The HTML of the component as at setting point
     *
     * @param html
     */
    public void setHtml(Component html)
    {
        this.html = html.toString().toString();
    }

    /**
     * The ID of the tree item
     *
     * @return
     */
    public String getOwnerId()
    {
        return id;
    }

    /**
     * The ID of the item
     *
     * @param id
     */
    public void setOwnerId(String id)
    {
        this.id = id;
    }

    /**
     * Sets if the item is disabled
     *
     * @return
     */
    public Boolean getDisabled()
    {
        return disabled;
    }

    /**
     * Sets if the item is disabled
     *
     * @param disabled
     */
    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    /**
     * Sets if the item is checked
     *
     * @return
     */
    public Boolean getChecked()
    {
        return checked;
    }

    /**
     * Sets if the item is checked
     *
     * @param checked
     */
    public void setChecked(Boolean checked)
    {
        this.checked = checked;
    }

    /**
     * Sets if the item is expanded
     *
     * @return
     */
    public Boolean getExpanded()
    {
        return expanded;
    }

    /**
     * Sets if the item is expanded
     *
     * @param expanded
     */
    public void setExpanded(Boolean expanded)
    {
        this.expanded = expanded;
    }

    /**
     * Sets if the item is selected
     *
     * @return
     */
    public Boolean getSelected()
    {
        return selected;
    }

    /**
     * Sets if the item is selected
     *
     * @param selected
     */
    public void setSelected(Boolean selected)
    {
        this.selected = selected;
    }

    /**
     * Gets any children items
     *
     * @return
     */
    public ArrayList<JQXTreeItem> getItems()
    {
        if (items == null)
        {
            items = new ArrayList<>();
        }
        return items;
    }

    /**
     * Sets the children items
     *
     * @param items
     */
    public void setItems(ArrayList<JQXTreeItem> items)
    {
        this.items = items;
    }

    /**
     * Sets the icon reference
     *
     * @return
     */
    public String getIcon()
    {
        return icon;
    }

    /**
     * Sets the icon reference
     *
     * @param icon
     */
    public void setIcon(String icon)
    {
        this.icon = icon;
    }

    /**
     * Gets the icon size
     *
     * @return
     */
    public Integer getIconsize()
    {
        return iconsize;
    }

    /**
     * Sets the icon size
     *
     * @param iconsize
     */
    public void setIconsize(Integer iconsize)
    {
        this.iconsize = iconsize;
    }
}
