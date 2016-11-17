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
package za.co.mmagon.jwebswing.components.c3.options.data;

import com.fasterxml.jackson.annotation.*;
import java.util.*;
import za.co.mmagon.jwebswing.components.c3.series.*;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.*;

/**
 * An extended ArrayList which will always have the first value as a column header
 *
 * @author GedMarc
 * @param <D> Any JavascriptPart
 * @since 09 Mar 2016
 */
public class C3ColumnData<D extends JavaScriptPart> extends ArrayList<D>
{

    private static final long serialVersionUID = 1L;
    @JsonIgnore
    private C3DataColumnHeader columnHeader;

    /**
     * A Column Based DataSet
     *
     * @param columnHeader
     */
    public C3ColumnData(C3DataColumnHeader columnHeader)
    {
        this.columnHeader = columnHeader;
    }

    /**
     * Returns the JSON
     *
     * @return
     */
    @JsonValue
    public String getJSON()
    {
        remove((D) getColumnHeader());
        add(0, (D) getColumnHeader());
        return JavaScriptPart.objectAsString(this);
    }

    /**
     * Returns this associated Column Header Object/
     *
     * @return
     */
    public C3DataColumnHeader getColumnHeader()
    {
        if (columnHeader == null)
        {
            columnHeader = new C3DataColumnHeader("Column 1");
        }
        return columnHeader;
    }

    /**
     * Sets the column header
     *
     * @param columnHeader
     */
    public void setColumnHeader(C3DataColumnHeader columnHeader)
    {
        this.columnHeader = columnHeader;
    }

}
