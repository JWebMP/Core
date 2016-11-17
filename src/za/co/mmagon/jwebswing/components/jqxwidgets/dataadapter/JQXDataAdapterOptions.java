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
package za.co.mmagon.jwebswing.components.jqxwidgets.dataadapter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * All the options for the Data Adapter library
 * <p>
 * @author GedMarc
 * @param <A>
 * @since Dec 39, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXDataAdapterOptions<A extends JQXDataAdapterSourceData> extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;

    /**
     * String "\t" when datatype is "tab" and "," when datatype is "CSV"
     */
    private String columnDelimiter;//
    /**
     * Array []
     */
    private ArrayList<JQXDataFields> datafields;//
    private A data;// Object
    @JsonIgnore
    private A localdata;// Object
    private JQXDataAdapterSourceType datatype;// String
    private String type;
    private String id;// String 	""
//localdata Array or String[]
    private String mapChar;// String 	">"
    private String rowDelimiter;// String 	"\n"
    private String root;// String 	""
    private String record;// String 	""
    private String url;// String
    private Boolean async;// 	Boolean 	true
    private Boolean autoBind;// 	Boolean 	false
    private String contentType;// 	String 	"application/x-www-form-urlencoded"

    public JQXDataAdapterOptions()
    {

    }

    public String getColumnDelimiter()
    {
        return columnDelimiter;
    }

    public void setColumnDelimiter(String columnDelimiter)
    {
        this.columnDelimiter = columnDelimiter;
    }

    public ArrayList<JQXDataFields> getDatafields()
    {
        if (datafields == null)
        {
            datafields = new ArrayList<>();
        }
        return datafields;
    }

    public void setDatafields(ArrayList<JQXDataFields> datafields)
    {
        this.datafields = datafields;
    }

    public A getData()
    {
        return data;
    }

    public void setData(A data)
    {
        this.data = data;
    }

    public A getLocaldata()
    {
        return localdata;
    }

    public void setLocaldata(A localdata, JQXDataAdapter adapter)
    {
        this.localdata = localdata;
        if (localdata != null)
        {
            setUrl("da?do=" + adapter.getDAID());
            setAsync(true);
            setAutoBind(true);
            setDatatype(JQXDataAdapterSourceType.JSON);
        }
    }

    public JQXDataAdapterSourceType getDatatype()
    {
        return datatype;
    }

    public void setDatatype(JQXDataAdapterSourceType datatype)
    {
        this.datatype = datatype;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getOwnerId()
    {
        return id;
    }

    public void setOwnerId(String id)
    {
        this.id = id;
    }

    public String getMapChar()
    {
        return mapChar;
    }

    public void setMapChar(String mapChar)
    {
        this.mapChar = mapChar;
    }

    public String getRowDelimiter()
    {
        return rowDelimiter;
    }

    public void setRowDelimiter(String rowDelimiter)
    {
        this.rowDelimiter = rowDelimiter;
    }

    public String getRoot()
    {
        return root;
    }

    public void setRoot(String root)
    {
        this.root = root;
    }

    public String getRecord()
    {
        return record;
    }

    public void setRecord(String record)
    {
        this.record = record;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public Boolean getAsync()
    {
        return async;
    }

    public void setAsync(Boolean async)
    {
        this.async = async;
    }

    public Boolean getAutoBind()
    {
        return autoBind;
    }

    public void setAutoBind(Boolean autoBind)
    {
        this.autoBind = autoBind;
    }

    public String getContentType()
    {
        return contentType;
    }

    public void setContentType(String contentType)
    {
        this.contentType = contentType;
    }

}
