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
package za.co.mmagon.jwebswing.components.jqxwidgets.datatable;

import java.util.ArrayList;
import za.co.mmagon.jwebswing.components.jqxwidgets.*;

/**
 * All the options for the JQX Data Library library
 * <p>
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXDataTableOptions extends JQXDefaultJavaScriptPart
{

    private static final long serialVersionUID = 1L;

    private Boolean altRows;// 	Boolean 	false
    private Boolean autoRowHeight;// 	Boolean 	true
    private Integer aggregatesHeight;// 	Number 	34
    private Boolean autoShowLoadElement;// 	Boolean 	true
    private Integer columnsHeight;// 	Number 	30
    private ArrayList<JQXDataTableColumns> columns;// 	Array 	[]
    private JQXDataTableColumnGroups columnGroups;// 	Array 	[]
    private Boolean columnsResize;// 	Boolean 	false
    private Boolean columnsReorder;// 	Boolean 	false
    private Boolean disabled;// 	Boolean 	false
    private Boolean editable;// 	Boolean 	false
    private JQXDataTableEditSettings editSettings;// 	Object 	{ saveOnPageChange: true, saveOnBlur: true, saveOnSelectionChange: true, cancelOnEsc: true, saveOnEnter: true, editSingleCell: false, editOnDoubleClick: true, editOnF2: true }
    private JQXDataTableExportSettings exportSettings;// 	Object 	{ columnsHeader: true, hiddenColumns: false, serverURL: null, characterSet: null, recordsInView: true, fileName: "jqxDataTable"}
    private Boolean enableHover;// 	Boolean 	true
    private Boolean enableBrowserSelection;// 	Boolean 	false
    private Boolean filterable;// 	Boolean 	false
    private Integer filterHeight;// 	Number 	30
    private JQXDataTableFilterModes filterMode;// 	String 	"default"
    private ArrayList<String> groups;// 	Array 	[]
    private String groupsRenderer;// 	Function 	null
    private String initRowDetails;// 	Function 	null
    private Boolean incrementalSearch;// 	Boolean 	trued
    private JQXLocalization localization;// 	Object 	default localization strings.
    private Integer pagerHeight;// 	Number 	28
    private Integer pageSize;// 	Number 	10
    private Integer[] pageSizeOptions;// 	Array 	['5', '10', '20']
    private Boolean pageable;// 	Boolean 	false
    private JQXPagerPositions pagerPosition;// 	String 	"bottom"
    private JQXPagerModes pagerMode;// 	String 	"default"
    private Integer pagerButtonsCount;// 	Number 	5
    private String pagerRenderer;// 	Function 	nullddd
    private String ready;// 	Function 	null
    private Boolean rowDetails;// 	Boolean 	false
    private String renderToolbar;// 	Function 	null
    private String renderStatusbar;// 	Function 	null
    private String rendering;// 	Function 	null
    private String rendered;// 	Function 	null
    private Boolean rtl;// 	Boolean 	false
    private JQXDataTableData source;// 	Object 	null
    private Boolean sortable;// 	Boolean 	false
    private Boolean showAggregates;// 	Boolean 	false
    private Boolean showToolbar;// 	Boolean 	false
    private Boolean showStatusbar;// 	Boolean 	false
    private Integer statusBarHeight;// 	Number 	34
    private Integer scrollBarSize;// 	Number 	17
    private JQXDataTableSelectionModes selectionMode;// 	String 	"multipleRows"
    private Boolean serverProcessing;// 	Boolean 	false
    private Boolean showHeader;// 	Boolean 	true
    private Integer toolbarHeight;// 	Number 	34

    public JQXDataTableOptions()
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

    public Integer getColumnsHeight()
    {
        return columnsHeight;
    }

    public void setColumnsHeight(Integer columnsHeight)
    {
        this.columnsHeight = columnsHeight;
    }

    public ArrayList<JQXDataTableColumns> getColumns()
    {
        return columns;
    }

    public void setColumns(ArrayList<JQXDataTableColumns> columns)
    {
        this.columns = columns;
    }

    public JQXDataTableColumnGroups getColumnGroups()
    {
        return columnGroups;
    }

    public void setColumnGroups(JQXDataTableColumnGroups columnGroups)
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

    public JQXDataTableEditSettings getEditSettings()
    {
        return editSettings;
    }

    public void setEditSettings(JQXDataTableEditSettings editSettings)
    {
        this.editSettings = editSettings;
    }

    public JQXDataTableExportSettings getExportSettings()
    {
        return exportSettings;
    }

    public void setExportSettings(JQXDataTableExportSettings exportSettings)
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

    public JQXDataTableFilterModes getFilterMode()
    {
        return filterMode;
    }

    public void setFilterMode(JQXDataTableFilterModes filterMode)
    {
        this.filterMode = filterMode;
    }

    public ArrayList<String> getGroups()
    {
        return groups;
    }

    public void setGroups(ArrayList<String> groups)
    {
        this.groups = groups;
    }

    public String getGroupsRenderer()
    {
        return groupsRenderer;
    }

    public void setGroupsRenderer(String groupsRenderer)
    {
        this.groupsRenderer = groupsRenderer;
    }

    public String getInitRowDetails()
    {
        return initRowDetails;
    }

    public void setInitRowDetails(String initRowDetails)
    {
        this.initRowDetails = initRowDetails;
    }

    public Boolean getIncrementalSearch()
    {
        return incrementalSearch;
    }

    public void setIncrementalSearch(Boolean incrementalSearch)
    {
        this.incrementalSearch = incrementalSearch;
    }

    public JQXLocalization getLocalization()
    {
        return localization;
    }

    public void setLocalization(JQXLocalization localization)
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

    public Integer[] getPageSizeOptions()
    {
        return pageSizeOptions;
    }

    public void setPageSizeOptions(Integer[] pageSizeOptions)
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

    public JQXPagerPositions getPagerPosition()
    {
        return pagerPosition;
    }

    public void setPagerPosition(JQXPagerPositions pagerPosition)
    {
        this.pagerPosition = pagerPosition;
    }

    public JQXPagerModes getPagerMode()
    {
        return pagerMode;
    }

    public void setPagerMode(JQXPagerModes pagerMode)
    {
        this.pagerMode = pagerMode;
    }

    public Integer getPagerButtonsCount()
    {
        return pagerButtonsCount;
    }

    public void setPagerButtonsCount(Integer pagerButtonsCount)
    {
        this.pagerButtonsCount = pagerButtonsCount;
    }

    public String getPagerRenderer()
    {
        return pagerRenderer;
    }

    public void setPagerRenderer(String pagerRenderer)
    {
        this.pagerRenderer = pagerRenderer;
    }

    public String getReady()
    {
        return ready;
    }

    public void setReady(String ready)
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

    public String getRenderToolbar()
    {
        return renderToolbar;
    }

    public void setRenderToolbar(String renderToolbar)
    {
        this.renderToolbar = renderToolbar;
    }

    public String getRenderStatusbar()
    {
        return renderStatusbar;
    }

    public void setRenderStatusbar(String renderStatusbar)
    {
        this.renderStatusbar = renderStatusbar;
    }

    public String getRendering()
    {
        return rendering;
    }

    public void setRendering(String rendering)
    {
        this.rendering = rendering;
    }

    public String getRendered()
    {
        return rendered;
    }

    public void setRendered(String rendered)
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

    public JQXDataTableData getSource()
    {
        return source;
    }

    public void setSource(JQXDataTableData source)
    {
        this.source = source;
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

    public JQXDataTableSelectionModes getSelectionMode()
    {
        return selectionMode;
    }

    public void setSelectionMode(JQXDataTableSelectionModes selectionMode)
    {
        this.selectionMode = selectionMode;
    }

    public Boolean getServerProcessing()
    {
        return serverProcessing;
    }

    public void setServerProcessing(Boolean serverProcessing)
    {
        this.serverProcessing = serverProcessing;
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

}
