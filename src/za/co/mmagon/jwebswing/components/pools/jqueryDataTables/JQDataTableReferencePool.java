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
package za.co.mmagon.jwebswing.components.pools.jqueryDataTables;

import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.base.references.JavascriptReference;
import za.co.mmagon.jwebswing.base.servlets.interfaces.ReferencePool;

/**
 *
 * @author GedMarc
 * @since 09 May 2015
 */
public enum JQDataTableReferencePool implements ReferencePool
{

    JQueryDataTables(new JavascriptReference("JQueryDataTables", 1.1010, "bower_components/datatables/media/js/jquery.dataTables.js", "https://cdn.datatables.net/1.10.10/js/jquery.datatables.js"),
            new CSSReference("JQueryDTCss", 1.1010, "bower_components/datatables/media/css/jquery.dataTables.css", "https://cdn.datatables.net/1.10.10/css/jquery.dataTables.css"), 15),
    JQueryDataTablesUI(new JavascriptReference("JQueryDataTablesUI", 1.1010, "bower_components/datatables/media/js/dataTables.jqueryui.js", "https://cdn.datatables.net/1.10.10/js/dataTables.jqueryui.js"),
            new CSSReference("JQueryDTCss", 1.1010, "bower_components/datatables/media/css/dataTables.jqueryui.css", "https://cdn.datatables.net/1.10.10/css/dataTables.jqueryui.css"), 200000),
    /**
     * AutoFill adds an Excel like option to a table, allowing click and drag over cells, filling in information and incrementing numbers as needed
     */
    JQueryDataTablesAutoFill(null, null, 0),
    /**
     * ColReorder allows the end user to modify the column order of a table through drop-and-drag of column headers
     */
    JQueryDataTablesColumnReorder(null, null, 0),
    /**
     * ColVis presents the end user with a list of columns in the table and options to enable or disable their current visibility
     */
    JQueryDataTablesColumnHiding(null, null, 0),
    /**
     * FixedColumns "freezes" in place the left most columns in a scrolling DataTable, to provide a guide to the end user (for example an index column)
     */
    JQueryDataTablesFixedColumns(null, null, 0),
    /**
     * Overrides the styling with the JQuery UI Integration
     */
    JQueryDataTablesJQueryUIIntegration(null, null, 0),
    /**
     * KeyTable provides Excel like cell navigation on any table. Events (focus, blur, action etc) can be assigned to individual cells, columns, rows or all cells.
     */
    JQueryDataTablesKeyTable(null, null, 0),
    /**
     * In the modern world of responsive web design tables can often cause a particular problem for designers due to their row based layout. Responsive is an extension for DataTables that resolves
     * that problem by optimising the tables layout for different screen sizes through the dynamic insertion and removal of columns from the table.
     */
    JQueryDataTablesResponsive(null, null, 0),
    /**
     * A virtual renderer for DataTables, allowing the table to look like it scrolls for the full data set, but actually only drawing the rows required for the current display, for fast operation.
     */
    JQueryDataTablesScroller(null, null, 0),
    /**
     * TableTools adds a Tool-Bar to a table to provide options for saving files (CSV, XLS, PDF), copying to system Clipboard, or printing the table. Row selection options are also available.
     */
    JQueryDataTablesTableTools(null, null, 0);

    private JavascriptReference javaScriptReference;
    private CSSReference cssReference;

    private JQDataTableReferencePool(JavascriptReference javaScriptReference, CSSReference cssReference, int sortOrder)
    {
        this.javaScriptReference = javaScriptReference;
        this.cssReference = cssReference;

        if (this.javaScriptReference != null)
        {
            this.javaScriptReference.setSortOrder(sortOrder);
        }

        if (this.cssReference != null)
        {
            this.cssReference.setSortOrder(sortOrder);
        }
    }

    @Override
    public JavascriptReference getJavaScriptReference()
    {
        return javaScriptReference;
    }

    @Override
    public void setJavaScriptReference(JavascriptReference javaScriptReference)
    {
        this.javaScriptReference = javaScriptReference;
    }

    @Override
    public CSSReference getCssReference()
    {
        return cssReference;
    }

    @Override
    public void setCssReference(CSSReference cssReference)
    {
        this.cssReference = cssReference;
    }
}
