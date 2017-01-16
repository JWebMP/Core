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

import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * This Class
 *
 * @author GedMarc
 * @since 25 Dec 2015
 */
class JQXTreeGridExportSettings extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;

    private Boolean columnsHeader;
    private Boolean hiddenColumns;
    private String serverURL;
    private String characterSet;
    private Boolean collapsedRecords;
    private Boolean recordsInView;
    private String fileName;

    public JQXTreeGridExportSettings()
    {
    }

    public Boolean getColumnsHeader()
    {
        return columnsHeader;
    }

    public void setColumnsHeader(Boolean columnsHeader)
    {
        this.columnsHeader = columnsHeader;
    }

    public Boolean getHiddenColumns()
    {
        return hiddenColumns;
    }

    public void setHiddenColumns(Boolean hiddenColumns)
    {
        this.hiddenColumns = hiddenColumns;
    }

    public String getServerURL()
    {
        return serverURL;
    }

    public void setServerURL(String serverURL)
    {
        this.serverURL = serverURL;
    }

    public String getCharacterSet()
    {
        return characterSet;
    }

    public void setCharacterSet(String characterSet)
    {
        this.characterSet = characterSet;
    }

    public Boolean getCollapsedRecords()
    {
        return collapsedRecords;
    }

    public void setCollapsedRecords(Boolean collapsedRecords)
    {
        this.collapsedRecords = collapsedRecords;
    }

    public Boolean getRecordsInView()
    {
        return recordsInView;
    }

    public void setRecordsInView(Boolean recordsInView)
    {
        this.recordsInView = recordsInView;
    }

    public String getFileName()
    {
        return fileName;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    @Override
    public String toString()
    {
        return super.toString();
    }

}
