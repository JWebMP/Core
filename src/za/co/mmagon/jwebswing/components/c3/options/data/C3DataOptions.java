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
import za.co.mmagon.jwebswing.components.c3.options.*;
import za.co.mmagon.jwebswing.components.c3.series.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.*;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.*;

/**
 * Represents a C3 Graphing Data Structure
 *
 * @author GedMarc
 * @since 09 Mar 2016
 */
public class C3DataOptions extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;

    private String url;
    private JavaScriptPart json;
    private C3RowData rows;
    private C3ColumnData columns;
    private String mimeType;
    private ArrayList<String> keys;
    private C3DataColumnHeader x;
    private HashMap<C3DataColumnHeader, C3DataXAxis> xs;
    private String xFormat;
    private String xLocaltime;
    private String xSort;
    private HashMap<C3DataColumnHeader, String> names;
    private HashMap<C3DataColumnHeader, String> classes;
    private ArrayList<ArrayList<C3DataColumnHeader>> groups;
    private HashMap<C3DataColumnHeader, C3DataAxesOptions> axes;
    private C3GraphTypeOptions type;
    private HashMap<C3DataColumnHeader, C3GraphTypeOptions> types;
    private Boolean labels;
    private C3DataOrderOptions order;
    private HashMap<C3DataColumnHeader, C3RegionOptions> regions;
    private JavascriptFunction color;
    private HashMap<C3DataColumnHeader, ColourHex> colors;
    private ArrayList<C3DataColumnHeader> hide;
    private C3DataEmptyOptions empty;
    private C3DataSelectionOptions selection;

    @JsonIgnore
    private ArrayList<C3DataColumnHeader> columnHeaders;
    @JsonIgnore
    private boolean renderByRow;
    @JsonIgnore
    private boolean renderByColumn;

    /**
     * Constructs a new Data Options Object
     */
    public C3DataOptions()
    {
        //No options are required
    }

    /**
     * Constructs a new instance of data options with the column headers set
     *
     * @param columnHeaders
     */
    public C3DataOptions(ArrayList<C3DataColumnHeader> columnHeaders)
    {
        this.columnHeaders = columnHeaders;
    }

    /**
     * Returns the current column headers array
     *
     * @return
     */
    public ArrayList<C3DataColumnHeader> getColumnHeaders()
    {
        if (columnHeaders == null)
        {
            columnHeaders = new ArrayList<>();
        }
        return columnHeaders;
    }

    /**
     * Sets the column headers array
     *
     * @param columnHeaders
     */
    public void setColumnHeaders(ArrayList<C3DataColumnHeader> columnHeaders)
    {
        this.columnHeaders = columnHeaders;
    }

    /**
     * Returns if the data should be delivered by row
     *
     * @return
     */
    public boolean isRenderByRow()
    {
        return renderByRow;
    }

    /**
     * Sets if the data should be delivered by row
     *
     * @param renderByRow
     */
    public void setRenderByRow(boolean renderByRow)
    {
        this.renderByRow = renderByRow;
    }

    /**
     * Gets if the data should be delivered by column
     *
     * @return
     */
    public boolean isRenderByColumn()
    {
        return renderByColumn;
    }

    /**
     * Sets if the data should be rendered by column
     *
     * @param renderByColumn
     */
    public void setRenderByColumn(boolean renderByColumn)
    {
        this.renderByColumn = renderByColumn;
    }

    /**
     * *************************************************************************************************
     * args
     ***************************************************************************************************
     */
    /**
     * Load a CSV or JSON file from a URL. Note that this will not work if loading via the "file://" protocol as most browsers with block XMLHTTPRequests.
     *
     * @return
     */
    public String getUrl()
    {
        return url;
    }

    /**
     * Load a CSV or JSON file from a URL. Note that this will not work if loading via the "file://" protocol as most browsers with block XMLHTTPRequests.
     *
     * @param url
     */
    public void setUrl(String url)
    {
        this.url = url;
    }

    /**
     * Parse a JSON object for data. See also data.keys.
     */
    public JavaScriptPart getJson()
    {
        return json;
    }

    /**
     * Parse a JSON object for data. See also data.keys.
     *
     * @param json
     */
    public void setJson(JavaScriptPart json)
    {
        this.json = json;
    }

    /**
     * Load data from a multidimensional array, with the first element containing the data names, the following containing related data in that order.
     *
     * @return
     */
    public C3RowData getRows()
    {
        if (rows == null)
        {
            rows = new C3RowData();
        }
        return rows;
    }

    /**
     * Load data from a multidimensional array, with the first element containing the data names, the following containing related data in that order.
     *
     * @param rows
     */
    public void setRows(C3RowData rows)
    {
        this.rows = rows;
    }

    /**
     * Load data from a multidimensional array, with each element containing an array consisting of a datum name and associated data values.
     *
     * @return
     */
    public C3ColumnData getColumns()
    {
        if (columns == null)
        {
            columns = new C3ColumnData(new C3DataColumnHeader("Header"));
        }
        return columns;
    }

    /**
     * Load data from a multidimensional array, with each element containing an array consisting of a datum name and associated data values.
     *
     * @param columns
     */
    public void setColumns(C3ColumnData columns)
    {
        this.columns = columns;
    }

    /**
     * Used if loading JSON via data.url:
     *
     * @return
     */
    public String getMimeType()
    {
        return mimeType;
    }

    /**
     * Used if loading JSON via data.url:
     *
     * @param mimeType
     */
    public void setMimeType(String mimeType)
    {
        this.mimeType = mimeType;
    }

    /**
     * Choose which JSON object keys correspond to desired data.
     *
     * @return
     */
    public ArrayList<String> getKeys()
    {
        if (keys == null)
        {
            keys = new ArrayList<>();
        }
        return keys;
    }

    /**
     * Choose which JSON object keys correspond to aggregate data.
     *
     * @param keys
     */
    public void setKeys(ArrayList<String> keys)
    {
        this.keys = keys;
    }

    /**
     * Specify the key of x values in the data.
     * <p>
     * We can show the data with non-index x values by this option. This option is required when the type of x axis is timeseries. If this option is set on category axis, the values of the data on the
     * key will be used for category names
     *
     * @return
     */
    public C3DataColumnHeader getX()
    {
        return x;
    }

    /**
     * Specify the key of x values in the data.
     * <p>
     * We can show the data with non-index x values by this option. This option is required when the type of x axis is timeseries. If this option is set on category axis, the values of the data on the
     * key will be used for category names
     *
     * @param x
     */
    public void setX(C3DataColumnHeader x)
    {
        this.x = x;
    }

    /**
     * Specify the keys of the x values for each data.
     * <p>
     * This option can be used if we want to show the data that has different x values.
     *
     * @return
     */
    public HashMap<C3DataColumnHeader, C3DataXAxis> getXs()
    {
        if (xs == null)
        {
            xs = new HashMap<>();
        }
        return xs;
    }

    /**
     * Specify the keys of the x values for each data.
     * <p>
     * This option can be used if we want to show the data that has different x values.
     *
     * @param xs
     */
    public void setXs(HashMap<C3DataColumnHeader, C3DataXAxis> xs)
    {
        this.xs = xs;
    }

    /**
     * Set a format to parse string specifed as x.
     *
     * @return
     */
    public String getxFormat()
    {
        return xFormat;
    }

    /**
     * Set a format to parse string specifed as x.
     *
     * @param xFormat
     */
    public void setxFormat(String xFormat)
    {
        this.xFormat = xFormat;
    }

    /**
     * not yet
     *
     * @deprecated
     * @return
     */
    public String getxLocaltime()
    {
        return xLocaltime;
    }

    /**
     * not yet
     *
     * @deprecated
     * @param xLocaltime
     */
    public void setxLocaltime(String xLocaltime)
    {
        this.xLocaltime = xLocaltime;
    }

    /**
     * not yet
     *
     * @deprecated
     * @return
     */
    public String getxSort()
    {
        return xSort;
    }

    /**
     * not yet
     *
     * @deprecated
     * @param xSort
     */
    public void setxSort(String xSort)
    {
        this.xSort = xSort;
    }

    /**
     * Set custom data name.
     *
     * @return
     */
    public HashMap<C3DataColumnHeader, String> getNames()
    {
        if (names == null)
        {
            names = new HashMap<>();
        }
        return names;
    }

    /**
     * Set custom data name.
     *
     * @param names
     */
    public void setNames(HashMap<C3DataColumnHeader, String> names)
    {
        this.names = names;
    }

    /**
     * Set custom data class.
     * <p>
     * If this option is specified, the element g for the data has an additional class that has the prefix c3-target- (e.g. c3-target-additional-data1-class).
     *
     * @return
     */
    public HashMap<C3DataColumnHeader, String> getClasses()
    {
        if (classes == null)
        {
            classes = new HashMap<>();
        }
        return classes;
    }

    /**
     * Set custom data class.
     * <p>
     * If this option is specified, the element g for the data has an additional class that has the prefix c3-target- (e.g. c3-target-additional-data1-class).
     *
     * @param classes
     */
    public void setClasses(HashMap<C3DataColumnHeader, String> classes)
    {
        this.classes = classes;
    }

    /**
     * Sets the columns that are grouped together for the stacked effect
     *
     * @return
     */
    public ArrayList<ArrayList<C3DataColumnHeader>> getGroups()
    {
        if (groups == null)
        {
            groups = new ArrayList<>();
        }
        return groups;
    }

    /**
     * Sets the columns that are grouped together for the stacked effect
     *
     * @param groups
     */
    public void setGroups(ArrayList<ArrayList<C3DataColumnHeader>> groups)
    {
        this.groups = groups;
    }

    /**
     * Set y axis the data related to. y and y2 can be used.
     *
     * @return
     */
    public HashMap<C3DataColumnHeader, C3DataAxesOptions> getAxes()
    {
        if (axes == null)
        {
            axes = new HashMap<>();
        }
        return axes;
    }

    /**
     * Set y axis the data related to. y and y2 can be used.
     *
     * @param axes
     */
    public void setAxes(HashMap<C3DataColumnHeader, C3DataAxesOptions> axes)
    {
        this.axes = axes;
    }

    /**
     * Set chart type at once.
     * <p>
     * If this option is specified, the type will be applied to every data. This setting can be overwritten by data.types.
     *
     * @return
     */
    public C3GraphTypeOptions getType()
    {
        return type;
    }

    /**
     * Set chart type at once.
     * <p>
     * If this option is specified, the type will be applied to every data. This setting can be overwritten by data.types.
     *
     * @param type
     */
    public void setType(C3GraphTypeOptions type)
    {
        this.type = type;
    }

    /**
     * Set chart type for each data.
     * <p>
     * This setting overwrites data.type setting.
     *
     * @return
     */
    public HashMap<C3DataColumnHeader, C3GraphTypeOptions> getTypes()
    {
        if (types == null)
        {
            types = new HashMap<>();
        }
        return types;
    }

    /**
     * Set chart type for each data.
     * <p>
     * This setting overwrites data.type setting.
     *
     * @param types
     */
    public void setTypes(HashMap<C3DataColumnHeader, C3GraphTypeOptions> types)
    {
        this.types = types;
    }

    /**
     * Show labels on each data points.
     *
     * @return
     */
    public Boolean getLabels()
    {
        return labels;
    }

    /**
     * Show labels on each data points.
     *
     * @param labels
     */
    public void setLabels(Boolean labels)
    {
        this.labels = labels;
    }

    /**
     * Define the order of the data.
     * <p>
     * This option changes the order of stacking the data and pieces of pie/donut. If null specified, it will be the order the data loaded. If function specified, it will be used to sort the data and
     * it will recieve the data as argument.
     *
     * @return
     */
    public C3DataOrderOptions getOrder()
    {
        return order;
    }

    /**
     * Define the order of the data.
     * <p>
     * This option changes the order of stacking the data and pieces of pie/donut. If null specified, it will be the order the data loaded. If function specified, it will be used to sort the data and
     * it will recieve the data as argument.
     *
     * @param order
     */
    public void setOrder(C3DataOrderOptions order)
    {
        this.order = order;
    }

    /**
     * Define regions for each data.
     * <p>
     * The values must be an array for each data and it should include an object that has start, end, style.
     * If start is not set, the start will be the first data point. If end is not set, the end
     * will be the last data point.
     * <p>
     * Currently this option supports only line chart and dashed style. If this option specified, the line will be dashed only in the regions.
     *
     * @return
     */
    public HashMap<C3DataColumnHeader, C3RegionOptions> getRegions()
    {
        return regions;
    }

    /**
     * Define regions for each data.
     * <p>
     * The values must be an array for each data and it should include an object that has start, end, style.
     * If start is not set, the start will be the first data point. If end is not set, the end
     * will be the last data point.
     * <p>
     * Currently this option supports only line chart and dashed style. If this option specified, the line will be dashed only in the regions.
     *
     * @param regions
     */
    public void setRegions(HashMap<C3DataColumnHeader, C3RegionOptions> regions)
    {
        this.regions = regions;
    }

    /**
     * Set color converter function.
     * <p>
     * This option should a function and the specified function receives color (e.g. '#ff0000') and d that has data parameters like id, value, index, etc. And it must return a string that represents
     * color (e.g. '#00ff00').
     *
     * @return
     */
    public JavascriptFunction getColor()
    {
        return color;
    }

    /**
     * Set color converter function.
     * <p>
     * This option should a function and the specified function receives color (e.g. '#ff0000') and d that has data parameters like id, value, index, etc. And it must return a string that represents
     * color (e.g. '#00ff00').
     *
     * @param color
     */
    public void setColor(JavascriptFunction color)
    {
        this.color = color;
    }

    /**
     * Set color for each data.
     *
     * @return
     */
    public HashMap<C3DataColumnHeader, ColourHex> getColors()
    {
        if (colors == null)
        {
            colors = new HashMap<>();
        }
        return colors;
    }

    /**
     * Set color for each data.
     *
     * @param colors
     */
    public void setColors(HashMap<C3DataColumnHeader, ColourHex> colors)
    {
        this.colors = colors;
    }

    /**
     * Hide each data when the chart appears.
     *
     * @return
     */
    public ArrayList<C3DataColumnHeader> getHide()
    {
        if (hide == null)
        {
            hide = new ArrayList<>();
        }
        return hide;
    }

    /**
     * Hide each data when the chart appears.
     *
     * @param hide
     */
    public void setHide(ArrayList<C3DataColumnHeader> hide)
    {
        this.hide = hide;
    }

    /**
     *
     * @return
     */
    public C3DataEmptyOptions getEmpty()
    {
        return empty;
    }

    public void setEmpty(C3DataEmptyOptions empty)
    {
        this.empty = empty;
    }

    public C3DataSelectionOptions getSelection()
    {
        return selection;
    }

    public void setSelection(C3DataSelectionOptions selection)
    {
        this.selection = selection;
    }

}
