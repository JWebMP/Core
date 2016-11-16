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
package za.co.mmagon.jwebswing.components.jqxWidgets.treegrid;

import java.util.ArrayList;
import za.co.mmagon.jwebswing.components.jqxWidgets.JQXDefaultJavaScriptPart;
import za.co.mmagon.jwebswing.components.jqxWidgets.JQXSelectionModes;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptFunction;

/**
 * All the options for the tooltip library
 * <p>
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXTreeGridOptions extends JQXDefaultJavaScriptPart
{

    private Boolean altRows;// Boolean 	false
    private Boolean autoRowHeight;// Boolean 	true
    private Integer aggregatesHeight;// Number 34
    private Boolean autoShowLoadElement;// Boolean 	true
    private Boolean checkboxes;// Boolean 	false
    private Integer columnsHeight;// Number 	30
    private ArrayList<JQXTreeGridColumns> columns;// Array[]
    private ArrayList<JQXTreeGridColumnGroups> columnGroups;// Array[]
    private Boolean columnsResize;// Boolean 	false
    private Boolean columnsReorder;// Boolean 	false
    private Boolean disabled;// Boolean 	false
    private Boolean editable;// Boolean 	false
    private JQXTreeGridEditSettings editSettings;// Object
    private JQXTreeGridExportSettings exportSettings;

    private Boolean enableHover;// Boolean 	true
    private Boolean enableBrowserSelection;// Boolean 	false
    private Boolean filterable;// Boolean 	false
    private Integer filterHeight;// Number 	30
    private String filterMode;// String 	"default"

    private Boolean hierarchicalCheckboxes;// Boolean 	false
    private Boolean icons;// Boolean 	false
    private Boolean incrementalSearch;// Boolean 	true
    private String localization;// Object 	default localization strings
    private Integer pagerHeight;// Number 	28
    private Integer pageSize;// Number 	10
    private ArrayList<Integer> pageSizeOptions;// Array['5', '10', '20']
    private Boolean pageable;// Boolean 	false
    private String pagerPosition;// String 	"bottom"
    private String pagerMode;// String 	"default"
    private String pageSizeMode;// String 	"default"
    private Integer pagerButtonsCount;// Number 	5
    private Integer pagerRenderer;// Function 	null
    private JavascriptFunction ready;// Function 	null
    private Boolean rowDetails;//Boolean 	false
    private JavascriptFunction rowDetailsRenderer;// Function 	null
    private JavascriptFunction renderToolbar;//Function 	null
    private JavascriptFunction renderStatusbar;//Function 	null
    private JavascriptFunction rendering;// Function 	null
    private JavascriptFunction rendered;// Function 	null
    private Boolean rtl;//Boolean 	false
//private source Object 	null
    private Boolean sortable;//Boolean 	false
    private Boolean showAggregates;//Boolean 	false
    private Boolean showSubAggregates;//Boolean 	false
    private Boolean showToolbar;//Boolean 	false
    private Boolean showStatusbar;//Boolean 	false
    private Integer statusBarHeight;//Number 	34
    private Integer scrollBarSize;//Number 	17
    private JQXSelectionModes selectionMode;// String 	"multipleRows"
    private Boolean showHeader;//Boolean 	true
    private Integer toolbarHeight;// Number 	34
    private JavascriptFunction virtualModeCreateRecords;// Function 	null
    private JavascriptFunction virtualModeRecordCreating;// Function null

    public JQXTreeGridOptions()
    {

    }

    public Boolean getAltRows()
    {
        return altRows;
    }

    public void setAltRows(Boolean altRows)
    {
        this.altRows = altRows;
    }

    public Boolean getAutoRowHeight()
    {
        return autoRowHeight;
    }

    public void setAutoRowHeight(Boolean autoRowHeight)
    {
        this.autoRowHeight = autoRowHeight;
    }

    public Integer getAggregatesHeight()
    {
        return aggregatesHeight;
    }

    public void setAggregatesHeight(Integer aggregatesHeight)
    {
        this.aggregatesHeight = aggregatesHeight;
    }

    public Boolean getAutoShowLoadElement()
    {
        return autoShowLoadElement;
    }

    public void setAutoShowLoadElement(Boolean autoShowLoadElement)
    {
        this.autoShowLoadElement = autoShowLoadElement;
    }

    public Boolean getCheckboxes()
    {
        return checkboxes;
    }

    public void setCheckboxes(Boolean checkboxes)
    {
        this.checkboxes = checkboxes;
    }

    public Integer getColumnsHeight()
    {
        return columnsHeight;
    }

    public void setColumnsHeight(Integer columnsHeight)
    {
        this.columnsHeight = columnsHeight;
    }

    public ArrayList<JQXTreeGridColumns> getColumns()
    {
        return columns;
    }

    public void setColumns(ArrayList<JQXTreeGridColumns> columns)
    {
        this.columns = columns;
    }

    public ArrayList<JQXTreeGridColumnGroups> getColumnGroups()
    {
        return columnGroups;
    }

    public void setColumnGroups(ArrayList<JQXTreeGridColumnGroups> columnGroups)
    {
        this.columnGroups = columnGroups;
    }

    public Boolean getColumnsResize()
    {
        return columnsResize;
    }

    public void setColumnsResize(Boolean columnsResize)
    {
        this.columnsResize = columnsResize;
    }

    public Boolean getColumnsReorder()
    {
        return columnsReorder;
    }

    public void setColumnsReorder(Boolean columnsReorder)
    {
        this.columnsReorder = columnsReorder;
    }

    public Boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    public Boolean getEditable()
    {
        return editable;
    }

    public void setEditable(Boolean editable)
    {
        this.editable = editable;
    }

    public JQXTreeGridEditSettings getEditSettings()
    {
        return editSettings;
    }

    public void setEditSettings(JQXTreeGridEditSettings editSettings)
    {
        this.editSettings = editSettings;
    }

    public JQXTreeGridExportSettings getExportSettings()
    {
        return exportSettings;
    }

    public void setExportSettings(JQXTreeGridExportSettings exportSettings)
    {
        this.exportSettings = exportSettings;
    }

    public Boolean getEnableHover()
    {
        return enableHover;
    }

    public void setEnableHover(Boolean enableHover)
    {
        this.enableHover = enableHover;
    }

    public Boolean getEnableBrowserSelection()
    {
        return enableBrowserSelection;
    }

    public void setEnableBrowserSelection(Boolean enableBrowserSelection)
    {
        this.enableBrowserSelection = enableBrowserSelection;
    }

    public Boolean getFilterable()
    {
        return filterable;
    }

    public void setFilterable(Boolean filterable)
    {
        this.filterable = filterable;
    }

    public Integer getFilterHeight()
    {
        return filterHeight;
    }

    public void setFilterHeight(Integer filterHeight)
    {
        this.filterHeight = filterHeight;
    }

    public String getFilterMode()
    {
        return filterMode;
    }

    public void setFilterMode(String filterMode)
    {
        this.filterMode = filterMode;
    }

    public Boolean getHierarchicalCheckboxes()
    {
        return hierarchicalCheckboxes;
    }

    public void setHierarchicalCheckboxes(Boolean hierarchicalCheckboxes)
    {
        this.hierarchicalCheckboxes = hierarchicalCheckboxes;
    }

    public Boolean getIcons()
    {
        return icons;
    }

    public void setIcons(Boolean icons)
    {
        this.icons = icons;
    }

    public Boolean getIncrementalSearch()
    {
        return incrementalSearch;
    }

    public void setIncrementalSearch(Boolean incrementalSearch)
    {
        this.incrementalSearch = incrementalSearch;
    }

    public String getLocalization()
    {
        return localization;
    }

    public void setLocalization(String localization)
    {
        this.localization = localization;
    }

    public Integer getPagerHeight()
    {
        return pagerHeight;
    }

    public void setPagerHeight(Integer pagerHeight)
    {
        this.pagerHeight = pagerHeight;
    }

    public Integer getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(Integer pageSize)
    {
        this.pageSize = pageSize;
    }

    public ArrayList<Integer> getPageSizeOptions()
    {
        return pageSizeOptions;
    }

    public void setPageSizeOptions(ArrayList<Integer> pageSizeOptions)
    {
        this.pageSizeOptions = pageSizeOptions;
    }

    public Boolean getPageable()
    {
        return pageable;
    }

    public void setPageable(Boolean pageable)
    {
        this.pageable = pageable;
    }

    public String getPagerPosition()
    {
        return pagerPosition;
    }

    public void setPagerPosition(String pagerPosition)
    {
        this.pagerPosition = pagerPosition;
    }

    public String getPagerMode()
    {
        return pagerMode;
    }

    public void setPagerMode(String pagerMode)
    {
        this.pagerMode = pagerMode;
    }

    public String getPageSizeMode()
    {
        return pageSizeMode;
    }

    public void setPageSizeMode(String pageSizeMode)
    {
        this.pageSizeMode = pageSizeMode;
    }

    public Integer getPagerButtonsCount()
    {
        return pagerButtonsCount;
    }

    public void setPagerButtonsCount(Integer pagerButtonsCount)
    {
        this.pagerButtonsCount = pagerButtonsCount;
    }

    public Integer getPagerRenderer()
    {
        return pagerRenderer;
    }

    public void setPagerRenderer(Integer pagerRenderer)
    {
        this.pagerRenderer = pagerRenderer;
    }

    public JavascriptFunction getReady()
    {
        return ready;
    }

    public void setReady(JavascriptFunction ready)
    {
        this.ready = ready;
    }

    public Boolean getRowDetails()
    {
        return rowDetails;
    }

    public void setRowDetails(Boolean rowDetails)
    {
        this.rowDetails = rowDetails;
    }

    public JavascriptFunction getRowDetailsRenderer()
    {
        return rowDetailsRenderer;
    }

    public void setRowDetailsRenderer(JavascriptFunction rowDetailsRenderer)
    {
        this.rowDetailsRenderer = rowDetailsRenderer;
    }

    public JavascriptFunction getRenderToolbar()
    {
        return renderToolbar;
    }

    public void setRenderToolbar(JavascriptFunction renderToolbar)
    {
        this.renderToolbar = renderToolbar;
    }

    public JavascriptFunction getRenderStatusbar()
    {
        return renderStatusbar;
    }

    public void setRenderStatusbar(JavascriptFunction renderStatusbar)
    {
        this.renderStatusbar = renderStatusbar;
    }

    public JavascriptFunction getRendering()
    {
        return rendering;
    }

    public void setRendering(JavascriptFunction rendering)
    {
        this.rendering = rendering;
    }

    public JavascriptFunction getRendered()
    {
        return rendered;
    }

    public void setRendered(JavascriptFunction rendered)
    {
        this.rendered = rendered;
    }

    public Boolean getRtl()
    {
        return rtl;
    }

    public void setRtl(Boolean rtl)
    {
        this.rtl = rtl;
    }

    public Boolean getSortable()
    {
        return sortable;
    }

    public void setSortable(Boolean sortable)
    {
        this.sortable = sortable;
    }

    public Boolean getShowAggregates()
    {
        return showAggregates;
    }

    public void setShowAggregates(Boolean showAggregates)
    {
        this.showAggregates = showAggregates;
    }

    public Boolean getShowSubAggregates()
    {
        return showSubAggregates;
    }

    public void setShowSubAggregates(Boolean showSubAggregates)
    {
        this.showSubAggregates = showSubAggregates;
    }

    public Boolean getShowToolbar()
    {
        return showToolbar;
    }

    public void setShowToolbar(Boolean showToolbar)
    {
        this.showToolbar = showToolbar;
    }

    public Boolean getShowStatusbar()
    {
        return showStatusbar;
    }

    public void setShowStatusbar(Boolean showStatusbar)
    {
        this.showStatusbar = showStatusbar;
    }

    public Integer getStatusBarHeight()
    {
        return statusBarHeight;
    }

    public void setStatusBarHeight(Integer statusBarHeight)
    {
        this.statusBarHeight = statusBarHeight;
    }

    public Integer getScrollBarSize()
    {
        return scrollBarSize;
    }

    public void setScrollBarSize(Integer scrollBarSize)
    {
        this.scrollBarSize = scrollBarSize;
    }

    public JQXSelectionModes getSelectionMode()
    {
        return selectionMode;
    }

    public void setSelectionMode(JQXSelectionModes selectionMode)
    {
        this.selectionMode = selectionMode;
    }

    public Boolean getShowHeader()
    {
        return showHeader;
    }

    public void setShowHeader(Boolean showHeader)
    {
        this.showHeader = showHeader;
    }

    public Integer getToolbarHeight()
    {
        return toolbarHeight;
    }

    public void setToolbarHeight(Integer toolbarHeight)
    {
        this.toolbarHeight = toolbarHeight;
    }

    public JavascriptFunction getVirtualModeCreateRecords()
    {
        return virtualModeCreateRecords;
    }

    public void setVirtualModeCreateRecords(JavascriptFunction virtualModeCreateRecords)
    {
        this.virtualModeCreateRecords = virtualModeCreateRecords;
    }

    public JavascriptFunction getVirtualModeRecordCreating()
    {
        return virtualModeRecordCreating;
    }

    public void setVirtualModeRecordCreating(JavascriptFunction virtualModeRecordCreating)
    {
        this.virtualModeRecordCreating = virtualModeRecordCreating;
    }

}
