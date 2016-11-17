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
package za.co.mmagon.jwebswing.components.jqxwidgets.treegrid;

import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptFunction;

/**
 * This Class
 *
 * @author GedMarc
 * @since 25 Dec 2015
 */
public class JQXTreeGridColumns
{

    /**
     * string property which sets the column headers text.
     */
    private String text;
    /**
     * string property which sets the columns bound field. It should be unique and should point to a data field defined in the jqxDataAdapters dataFields array.
     */
    private String dataField;
    /**
     * string property which sets the columns display field. It should be unique and should point to a data field defined in the jqxDataAdapters dataFields array.
     */
    private String displayField;
    /**
     * boolean property which determines whether the column is sortable.
     */
    private Boolean sortable;
    /**
     * boolean property which determines whether the column is filterable.
     */
    private Boolean filterable;
    /**
     * boolean property which determines whether the column is visible or hidden.
     */
    private Boolean hidden;
    /**
     * string property which determines the name of the columns parent group. It should point to a valid name defined in the columnGroups.
     */
    private String columnGroup;
    /**
     * boolean property which determines whether the cells data wrapping is enabled. This property is set to true by default. When autoRowHeight is enabled and autoCellHeight is set to false, the
     * cells data will not be wrapped.
     */
    private Boolean autoCellHeight;
    /**
     * callback function for custom rendering of the columns header.
     */
    private JavascriptFunction renderer;

    public JQXTreeGridColumns()
    {
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public String getDataField()
    {
        return dataField;
    }

    public void setDataField(String dataField)
    {
        this.dataField = dataField;
    }

    public String getDisplayField()
    {
        return displayField;
    }

    public void setDisplayField(String displayField)
    {
        this.displayField = displayField;
    }

    public Boolean getSortable()
    {
        return sortable;
    }

    public void setSortable(Boolean sortable)
    {
        this.sortable = sortable;
    }

    public Boolean getFilterable()
    {
        return filterable;
    }

    public void setFilterable(Boolean filterable)
    {
        this.filterable = filterable;
    }

    public Boolean getHidden()
    {
        return hidden;
    }

    public void setHidden(Boolean hidden)
    {
        this.hidden = hidden;
    }

    public String getColumnGroup()
    {
        return columnGroup;
    }

    public void setColumnGroup(String columnGroup)
    {
        this.columnGroup = columnGroup;
    }

    public Boolean getAutoCellHeight()
    {
        return autoCellHeight;
    }

    public void setAutoCellHeight(Boolean autoCellHeight)
    {
        this.autoCellHeight = autoCellHeight;
    }

    public JavascriptFunction getRenderer()
    {
        return renderer;
    }

    public void setRenderer(JavascriptFunction renderer)
    {
        this.renderer = renderer;
    }

    @Override
    public String toString()
    {
        return super.toString();
    }

}
