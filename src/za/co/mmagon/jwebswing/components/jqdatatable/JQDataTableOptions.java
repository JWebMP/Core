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
package za.co.mmagon.jwebswing.components.jqdatatable;

import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptPartType;

/**
 * The Options for the Data Table
 * <p>
 * @author GedMarc
 * @since 09 May 2015
 */
public class JQDataTableOptions extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;

    public JQDataTableOptions()
    {

    }

    /**
     * the document object model layout
     */
    private String dom;

    /**
     * Add or modify data submitted to the server upon an Ajax request
     */
    private String ajax_data;

    /**
     * Data property or manipulation method for table data
     */
    private String ajax_dataSrc;

    /**
     * Load data for the table's content from an Ajax source
     */
    private String ajax;

    /**
     * Data to use as the display data for the table.
     */
    private String data;

    /**
     * Feature control DataTables' smart column width handling
     */
    private Boolean autoWidth;

    /**
     * Feature control deferred rendering for additional speed of initialization.
     */
    private Boolean deferRender;

    /**
     * Feature control table information display field
     */
    private Boolean info;

    /**
     * Use markup and classes for the table to be themed by jQuery UI ThemeRoller.
     *
     * @deprecated
     */
    private Boolean jQueryUI;

    /**
     * Feature control the end user's ability to change the paging display length of the table.
     */
    private Boolean lengthChange;

    /**
     * Feature control ordering (sorting) abilities in DataTables.
     */
    private Boolean ordering;

    /**
     * Enable or disable table pagination.
     */
    private Boolean paging;

    /**
     * Feature control the processing indicator.
     */
    private Boolean processing;

    /**
     * Horizontal scrolling
     */
    private Boolean scrollX;
    /**
     * Horizontal scrolling
     */
    private Integer scrollXNum;

    /**
     * Vertical scrolling
     */
    private Boolean scrollY;
    /**
     * Vertical scrolling
     */
    private Integer scrollYNum;

    /**
     * Feature control search (filtering) abilities
     */
    private Boolean searching;

    /**
     * Feature control DataTables' server-side processing mode.
     */
    private Boolean serverSide;

    /**
     * State saving - restore table state on page reload
     */
    private Boolean stateSave;

    /**
     * State saving - restore table state on page reload
     */
    private Boolean retrieve = true;
    private Boolean destroy;

    public Boolean getAutoWidth()
    {
        return autoWidth;
    }

    public void setAutoWidth(Boolean autoWidth)
    {
        this.autoWidth = autoWidth;
    }

    public Boolean getDeferRender()
    {
        return deferRender;
    }

    public void setDeferRender(Boolean deferRender)
    {
        this.deferRender = deferRender;
    }

    public Boolean getInfo()
    {
        return info;
    }

    public void setInfo(Boolean info)
    {
        this.info = info;
    }

    /**
     * @deprecated
     * @return
     */
    public Boolean getjQueryUI()
    {
        return jQueryUI;
    }

    /**
     * @deprecated
     * @param jQueryUI
     */
    public void setjQueryUI(Boolean jQueryUI)
    {
        this.jQueryUI = jQueryUI;
    }

    public Boolean getLengthChange()
    {
        return lengthChange;
    }

    public void setLengthChange(Boolean lengthChange)
    {
        this.lengthChange = lengthChange;
    }

    public Boolean getOrdering()
    {
        return ordering;
    }

    public void setOrdering(Boolean ordering)
    {
        this.ordering = ordering;
    }

    public Boolean getPaging()
    {
        return paging;
    }

    public void setPaging(Boolean paging)
    {
        this.paging = paging;
    }

    public Boolean getProcessing()
    {
        return processing;
    }

    public void setProcessing(Boolean processing)
    {
        this.processing = processing;
    }

    public Boolean getScrollX()
    {
        return scrollX;
    }

    public void setScrollX(Boolean scrollX)
    {
        this.scrollX = scrollX;
    }

    public Integer getScrollXNum()
    {
        return scrollXNum;
    }

    public void setScrollXNum(Integer scrollXNum)
    {
        this.scrollXNum = scrollXNum;
    }

    public Boolean getScrollY()
    {
        return scrollY;
    }

    public void setScrollY(Boolean scrollY)
    {
        this.scrollY = scrollY;
    }

    public Integer getScrollYNum()
    {
        return scrollYNum;
    }

    public void setScrollYNum(Integer scrollYNum)
    {
        this.scrollYNum = scrollYNum;
    }

    public Boolean getSearching()
    {
        return searching;
    }

    public void setSearching(Boolean searching)
    {
        this.searching = searching;
    }

    public Boolean getServerSide()
    {
        return serverSide;
    }

    public void setServerSide(Boolean serverSide)
    {
        this.serverSide = serverSide;
    }

    public Boolean getStateSave()
    {
        return stateSave;
    }

    public void setStateSave(Boolean stateSave)
    {
        this.stateSave = stateSave;
    }

    public String getAjax_data()
    {
        return ajax_data;
    }

    public void setAjax_data(String ajax_data)
    {
        this.ajax_data = ajax_data;
    }

    public String getAjax_dataSrc()
    {
        return ajax_dataSrc;
    }

    public void setAjax_dataSrc(String ajax_dataSrc)
    {
        this.ajax_dataSrc = ajax_dataSrc;
    }

    public String getAjax()
    {
        return ajax;
    }

    public void setAjax(String ajax)
    {
        this.ajax = ajax;
    }

    public String getData()
    {
        return data;
    }

    public void setData(String data)
    {
        this.data = data;
    }

    @Override
    public JavascriptPartType getJavascriptType()
    {
        return JavascriptPartType.Javascript;
    }

    public Boolean getRetrieve()
    {
        return retrieve;
    }

    public void setRetrieve(Boolean retrieve)
    {
        this.retrieve = retrieve;
    }

    public Boolean getDestroy()
    {
        return destroy;
    }

    public void setDestroy(Boolean destroy)
    {
        this.destroy = destroy;
    }

    /**
     *
     * <p>
     * As is described by the basic DOM positioning example you can use the dom initialisation parameter to move DataTables features around the table to where you want them.
     * <p>
     * In addition to this, you can also use dom to create multiple instances of these table controls. Simply include the feature's identification letter where you want it to appear, as many times as
     * you wish, and the controls will all sync up (note that obviously the table (t) should be included only once).
     * <p>
     * This is shown in the demo below where for four key build-in features are duplicated above and below the table.
     *
     * @return
     */
    public String getDom()
    {
        return dom;
    }

    /**
     *
     * <p>
     * As is described by the basic DOM positioning example you can use the dom initialisation parameter to move DataTables features around the table to where you want them.
     * <p>
     * In addition to this, you can also use dom to create multiple instances of these table controls. Simply include the feature's identification letter where you want it to appear, as many times as
     * you wish, and the controls will all sync up (note that obviously the table (t) should be included only once).
     * <p>
     * This is shown in the demo below where for four key build-in features are duplicated above and below the table.
     *
     * @param dom
     */
    public void setDom(String dom)
    {
        this.dom = dom;
    }

}
