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
package za.co.mmagon.jwebswing.components.jqxwidgets.grid;

import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptFunction;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptPartType;

/**
 * All the options for the JQX Grid library
 * <p>
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXGridOptions extends JavaScriptPart
{

    private Boolean altrows;// 	Boolean 	false
    private Integer altstart;// 	Number 	1
    private Integer altstep;// 	Number 	1
    private Boolean autoshowloadelement;// 	Boolean 	true
    private Boolean autoshowfiltericon;// 	Boolean 	true
    private Boolean autoshowcolumnsmenubutton;// 	Boolean 	true
    private Boolean clipboard;// 	Boolean 	true
    private Boolean closeablegroups;// 	Boolean 	true
    private Integer columnsmenuwidth;// 	Number 	15
    private JavascriptFunction columnmenuopening;// 	Function 	null
    private JavascriptFunction columnmenuclosing;// 	Function 	null
    private JavascriptFunction cellhover;// 	Function 	null
    private Boolean enablekeyboarddelete;// 	Boolean 	true
    private Boolean enableellipsis;// 	Boolean 	true
    private Boolean enablemousewheel;// 	Boolean 	true
    private Boolean enableanimations;// 	Boolean 	true
    private Boolean enabletooltips;// 	Boolean 	false
    private Boolean enablehover;//Boolean 	true
    private Boolean enablebrowserselection;// 	Boolean 	false
    private String everpresentrowposition;// 	String 	'top'
    private Integer everpresentrowheight;// 	Number 	30
    private String everpresentrowactions;//String 	"add reset"
    private String everpresentrowactionsmode;// 	String 	"popup"
    private Integer filterrowheight;//Number 	31
    private String filtermode;//String 	"default"
    private JavascriptFunction groupsrenderer;// 	function 	null
    private JavascriptFunction groupcolumnrenderer;// 	function 	null
    private Boolean groupsexpandedbydefault;// 	Boolean 	false
    private JavascriptFunction handlekeyboardnavigation;// 	function 	null
    private JavascriptFunction pagerrenderer;// 	function 	null
    private Boolean rtl;// 	Boolean 	false
    private Boolean showdefaultloadelement;// 	Boolean 	true
    private Boolean showfiltercolumnbackground;// 	Boolean 	true
    private Boolean showfiltermenuitems;// 	Boolean 	true
    private Boolean showpinnedcolumnbackground;// 	Boolean 	true
    private Boolean showsortcolumnbackground;// 	Boolean 	true
    private Boolean showsortmenuitems;// 	Boolean 	true
    private Boolean showgroupmenuitems;// 	Boolean 	true
    private Boolean showrowdetailscolumn;// 	Boolean 	true
    private Boolean showheader;// 	Boolean 	true
    private Boolean showgroupsheader;// 	Boolean 	true
    private Boolean showaggregates;// 	Boolean 	false
    private Boolean showeverpresentrow;// 	Boolean 	false
    private Boolean showfilterrow;// 	Boolean 	false
    private Boolean showemptyrow;// 	Boolean 	true
    private Boolean showstatusbar;// 	Boolean 	false
    private Integer statusbarheight;// 	Number 	34
    private Boolean showtoolbar;// 	Boolean 	false
    private String selectionmode;// 	String 	'singlerow'
    private String theme;// 	String 	''
    private Integer toolbarheight;// 	Number 	34

    private Boolean autoheight;// 	Boolean 	false
    private Boolean autorowheight;// Boolean 	false
    private Integer columnsheight;// Number 	25
    private JWXGridDeferredDataFields deferreddatafields;// 	Array 	[]
    private Integer groupsheaderheight;//  	Number/String 	34
    private Integer groupindentwidth;// 	Number 	20
    private Integer height;//  	Number/String 	400
    private Integer pagerheight;//  	Number/String 	28
    private Integer rowsheight;//  	Number 	25
    private Integer scrollbarsize;//  	Number 	15
    private String scrollmode;//  	String 	"default"
    private JavascriptFunction scrollfeedback;//  	function 	null
    private Integer width;//  	Number/String 	600

    private Boolean autosavestate;//  	Boolean 	false
    private Boolean autoloadstate;//  	Boolean 	false
    private JQXGridColumns columns;// 	Array 	[]
    private JQXGridColumns columngroups;// 	Array 	[]
    private Boolean columnsmenu;//  	Boolean 	true
    private Boolean columnsresize;//  	Boolean 	false
    private Boolean columnsautoresize;//  	Boolean 	true
    private Boolean columnsreorder;//  	Boolean 	false
    private Boolean disabled;//  	Boolean 	false
    private Boolean editable;//  	Boolean 	false
    private String editmode;// 	String 	'selectedcell'
    private Boolean filterable;//  	Boolean 	false
    private Boolean groupable;//  	Boolean 	false
    private JQXGridGroups groups;// 	Array 	[]
    private Integer horizontalscrollbarstep;//  	Number 	5
    private Integer horizontalscrollbarlargestep;//  	Number 	50
    private JavascriptFunction initrowdetails;//  	function 	null
    private Boolean keyboardnavigation;//  	Boolean 	true
    private Integer pagesize;//  	Number 	10
    private Integer[] pagesizeoptions;// 	Array 	['5', '10', '20']
    private String pagermode;// 	String 	"default"
    private Integer pagerbuttonscount;//  	Number 	5
    private Boolean pageable;//  	Boolean 	false
    private Boolean rowdetails;//  	Boolean 	false
    private JQXGridRowDetailsTemplate rowdetailstemplate;// 	Object 	null
    private JavascriptFunction ready;//  	function 	null
    private JavascriptFunction rendered;//  	function 	null
    private JavascriptFunction renderstatusbar;//  	function 	null
    private JavascriptFunction rendertoolbar;//  	function 	null
    private JavascriptFunction rendergridrows;//  	function 	null
    private Boolean sortable;//  	Boolean 	false
    private Integer selectedrowindex;//  	Number 	-1
    private JQXSelectedRowIndexes selectedrowindexes;// 	Array 	[]
    private Object source;// 	Object 	{}
    private String sorttogglestates;//  	String 	2
    private Integer updatedelay;//  	Number 	0
    private Boolean virtualmode;//  	Boolean 	false
    private Integer verticalscrollbarstep;//  	Number 	5
    private Integer verticalscrollbarlargestep;// 	Number 	400

    public JQXGridOptions()
    {

    }

    @Override
    public JavascriptPartType getJavascriptType()
    {
        return JavascriptPartType.Javascript;
    }

    public Boolean getAltrows()
    {
        return altrows;
    }

    public void setAltrows(Boolean altrows)
    {
        this.altrows = altrows;
    }

    public Integer getAltstart()
    {
        return altstart;
    }

    public void setAltstart(Integer altstart)
    {
        this.altstart = altstart;
    }

    public Integer getAltstep()
    {
        return altstep;
    }

    public void setAltstep(Integer altstep)
    {
        this.altstep = altstep;
    }

    public Boolean getAutoshowloadelement()
    {
        return autoshowloadelement;
    }

    public void setAutoshowloadelement(Boolean autoshowloadelement)
    {
        this.autoshowloadelement = autoshowloadelement;
    }

    public Boolean getAutoshowfiltericon()
    {
        return autoshowfiltericon;
    }

    public void setAutoshowfiltericon(Boolean autoshowfiltericon)
    {
        this.autoshowfiltericon = autoshowfiltericon;
    }

    public Boolean getAutoshowcolumnsmenubutton()
    {
        return autoshowcolumnsmenubutton;
    }

    public void setAutoshowcolumnsmenubutton(Boolean autoshowcolumnsmenubutton)
    {
        this.autoshowcolumnsmenubutton = autoshowcolumnsmenubutton;
    }

    public Boolean getClipboard()
    {
        return clipboard;
    }

    public void setClipboard(Boolean clipboard)
    {
        this.clipboard = clipboard;
    }

    public Boolean getCloseablegroups()
    {
        return closeablegroups;
    }

    public void setCloseablegroups(Boolean closeablegroups)
    {
        this.closeablegroups = closeablegroups;
    }

    public Integer getColumnsmenuwidth()
    {
        return columnsmenuwidth;
    }

    public void setColumnsmenuwidth(Integer columnsmenuwidth)
    {
        this.columnsmenuwidth = columnsmenuwidth;
    }

    public JavascriptFunction getColumnmenuopening()
    {
        return columnmenuopening;
    }

    public void setColumnmenuopening(JavascriptFunction columnmenuopening)
    {
        this.columnmenuopening = columnmenuopening;
    }

    public JavascriptFunction getColumnmenuclosing()
    {
        return columnmenuclosing;
    }

    public void setColumnmenuclosing(JavascriptFunction columnmenuclosing)
    {
        this.columnmenuclosing = columnmenuclosing;
    }

    public JavascriptFunction getCellhover()
    {
        return cellhover;
    }

    public void setCellhover(JavascriptFunction cellhover)
    {
        this.cellhover = cellhover;
    }

    public Boolean getEnablekeyboarddelete()
    {
        return enablekeyboarddelete;
    }

    public void setEnablekeyboarddelete(Boolean enablekeyboarddelete)
    {
        this.enablekeyboarddelete = enablekeyboarddelete;
    }

    public Boolean getEnableellipsis()
    {
        return enableellipsis;
    }

    public void setEnableellipsis(Boolean enableellipsis)
    {
        this.enableellipsis = enableellipsis;
    }

    public Boolean getEnablemousewheel()
    {
        return enablemousewheel;
    }

    public void setEnablemousewheel(Boolean enablemousewheel)
    {
        this.enablemousewheel = enablemousewheel;
    }

    public Boolean getEnableanimations()
    {
        return enableanimations;
    }

    public void setEnableanimations(Boolean enableanimations)
    {
        this.enableanimations = enableanimations;
    }

    public Boolean getEnabletooltips()
    {
        return enabletooltips;
    }

    public void setEnabletooltips(Boolean enabletooltips)
    {
        this.enabletooltips = enabletooltips;
    }

    public Boolean getEnablehover()
    {
        return enablehover;
    }

    public void setEnablehover(Boolean enablehover)
    {
        this.enablehover = enablehover;
    }

    public Boolean getEnablebrowserselection()
    {
        return enablebrowserselection;
    }

    public void setEnablebrowserselection(Boolean enablebrowserselection)
    {
        this.enablebrowserselection = enablebrowserselection;
    }

    public String getEverpresentrowposition()
    {
        return everpresentrowposition;
    }

    public void setEverpresentrowposition(String everpresentrowposition)
    {
        this.everpresentrowposition = everpresentrowposition;
    }

    public Integer getEverpresentrowheight()
    {
        return everpresentrowheight;
    }

    public void setEverpresentrowheight(Integer everpresentrowheight)
    {
        this.everpresentrowheight = everpresentrowheight;
    }

    public String getEverpresentrowactions()
    {
        return everpresentrowactions;
    }

    public void setEverpresentrowactions(String everpresentrowactions)
    {
        this.everpresentrowactions = everpresentrowactions;
    }

    public String getEverpresentrowactionsmode()
    {
        return everpresentrowactionsmode;
    }

    public void setEverpresentrowactionsmode(String everpresentrowactionsmode)
    {
        this.everpresentrowactionsmode = everpresentrowactionsmode;
    }

    public Integer getFilterrowheight()
    {
        return filterrowheight;
    }

    public void setFilterrowheight(Integer filterrowheight)
    {
        this.filterrowheight = filterrowheight;
    }

    public String getFiltermode()
    {
        return filtermode;
    }

    public void setFiltermode(String filtermode)
    {
        this.filtermode = filtermode;
    }

    public JavascriptFunction getGroupsrenderer()
    {
        return groupsrenderer;
    }

    public void setGroupsrenderer(JavascriptFunction groupsrenderer)
    {
        this.groupsrenderer = groupsrenderer;
    }

    public JavascriptFunction getGroupcolumnrenderer()
    {
        return groupcolumnrenderer;
    }

    public void setGroupcolumnrenderer(JavascriptFunction groupcolumnrenderer)
    {
        this.groupcolumnrenderer = groupcolumnrenderer;
    }

    public Boolean getGroupsexpandedbydefault()
    {
        return groupsexpandedbydefault;
    }

    public void setGroupsexpandedbydefault(Boolean groupsexpandedbydefault)
    {
        this.groupsexpandedbydefault = groupsexpandedbydefault;
    }

    public JavascriptFunction getHandlekeyboardnavigation()
    {
        return handlekeyboardnavigation;
    }

    public void setHandlekeyboardnavigation(JavascriptFunction handlekeyboardnavigation)
    {
        this.handlekeyboardnavigation = handlekeyboardnavigation;
    }

    public JavascriptFunction getPagerrenderer()
    {
        return pagerrenderer;
    }

    public void setPagerrenderer(JavascriptFunction pagerrenderer)
    {
        this.pagerrenderer = pagerrenderer;
    }

    public Boolean getRtl()
    {
        return rtl;
    }

    public void setRtl(Boolean rtl)
    {
        this.rtl = rtl;
    }

    public Boolean getShowdefaultloadelement()
    {
        return showdefaultloadelement;
    }

    public void setShowdefaultloadelement(Boolean showdefaultloadelement)
    {
        this.showdefaultloadelement = showdefaultloadelement;
    }

    public Boolean getShowfiltercolumnbackground()
    {
        return showfiltercolumnbackground;
    }

    public void setShowfiltercolumnbackground(Boolean showfiltercolumnbackground)
    {
        this.showfiltercolumnbackground = showfiltercolumnbackground;
    }

    public Boolean getShowfiltermenuitems()
    {
        return showfiltermenuitems;
    }

    public void setShowfiltermenuitems(Boolean showfiltermenuitems)
    {
        this.showfiltermenuitems = showfiltermenuitems;
    }

    public Boolean getShowpinnedcolumnbackground()
    {
        return showpinnedcolumnbackground;
    }

    public void setShowpinnedcolumnbackground(Boolean showpinnedcolumnbackground)
    {
        this.showpinnedcolumnbackground = showpinnedcolumnbackground;
    }

    public Boolean getShowsortcolumnbackground()
    {
        return showsortcolumnbackground;
    }

    public void setShowsortcolumnbackground(Boolean showsortcolumnbackground)
    {
        this.showsortcolumnbackground = showsortcolumnbackground;
    }

    public Boolean getShowsortmenuitems()
    {
        return showsortmenuitems;
    }

    public void setShowsortmenuitems(Boolean showsortmenuitems)
    {
        this.showsortmenuitems = showsortmenuitems;
    }

    public Boolean getShowgroupmenuitems()
    {
        return showgroupmenuitems;
    }

    public void setShowgroupmenuitems(Boolean showgroupmenuitems)
    {
        this.showgroupmenuitems = showgroupmenuitems;
    }

    public Boolean getShowrowdetailscolumn()
    {
        return showrowdetailscolumn;
    }

    public void setShowrowdetailscolumn(Boolean showrowdetailscolumn)
    {
        this.showrowdetailscolumn = showrowdetailscolumn;
    }

    public Boolean getShowheader()
    {
        return showheader;
    }

    public void setShowheader(Boolean showheader)
    {
        this.showheader = showheader;
    }

    public Boolean getShowgroupsheader()
    {
        return showgroupsheader;
    }

    public void setShowgroupsheader(Boolean showgroupsheader)
    {
        this.showgroupsheader = showgroupsheader;
    }

    public Boolean getShowaggregates()
    {
        return showaggregates;
    }

    public void setShowaggregates(Boolean showaggregates)
    {
        this.showaggregates = showaggregates;
    }

    public Boolean getShoweverpresentrow()
    {
        return showeverpresentrow;
    }

    public void setShoweverpresentrow(Boolean showeverpresentrow)
    {
        this.showeverpresentrow = showeverpresentrow;
    }

    public Boolean getShowfilterrow()
    {
        return showfilterrow;
    }

    public void setShowfilterrow(Boolean showfilterrow)
    {
        this.showfilterrow = showfilterrow;
    }

    public Boolean getShowemptyrow()
    {
        return showemptyrow;
    }

    public void setShowemptyrow(Boolean showemptyrow)
    {
        this.showemptyrow = showemptyrow;
    }

    public Boolean getShowstatusbar()
    {
        return showstatusbar;
    }

    public void setShowstatusbar(Boolean showstatusbar)
    {
        this.showstatusbar = showstatusbar;
    }

    public Integer getStatusbarheight()
    {
        return statusbarheight;
    }

    public void setStatusbarheight(Integer statusbarheight)
    {
        this.statusbarheight = statusbarheight;
    }

    public Boolean getShowtoolbar()
    {
        return showtoolbar;
    }

    public void setShowtoolbar(Boolean showtoolbar)
    {
        this.showtoolbar = showtoolbar;
    }

    public String getSelectionmode()
    {
        return selectionmode;
    }

    public void setSelectionmode(String selectionmode)
    {
        this.selectionmode = selectionmode;
    }

    public String getTheme()
    {
        return theme;
    }

    public void setTheme(String theme)
    {
        this.theme = theme;
    }

    public Integer getToolbarheight()
    {
        return toolbarheight;
    }

    public void setToolbarheight(Integer toolbarheight)
    {
        this.toolbarheight = toolbarheight;
    }

    public Boolean getAutoheight()
    {
        return autoheight;
    }

    public void setAutoheight(Boolean autoheight)
    {
        this.autoheight = autoheight;
    }

    public Boolean getAutorowheight()
    {
        return autorowheight;
    }

    public void setAutorowheight(Boolean autorowheight)
    {
        this.autorowheight = autorowheight;
    }

    public Integer getColumnsheight()
    {
        return columnsheight;
    }

    public void setColumnsheight(Integer columnsheight)
    {
        this.columnsheight = columnsheight;
    }

    public JWXGridDeferredDataFields getDeferreddatafields()
    {
        return deferreddatafields;
    }

    public void setDeferreddatafields(JWXGridDeferredDataFields deferreddatafields)
    {
        this.deferreddatafields = deferreddatafields;
    }

    public Integer getGroupsheaderheight()
    {
        return groupsheaderheight;
    }

    public void setGroupsheaderheight(Integer groupsheaderheight)
    {
        this.groupsheaderheight = groupsheaderheight;
    }

    public Integer getGroupindentwidth()
    {
        return groupindentwidth;
    }

    public void setGroupindentwidth(Integer groupindentwidth)
    {
        this.groupindentwidth = groupindentwidth;
    }

    public Integer getHeight()
    {
        return height;
    }

    public void setHeight(Integer height)
    {
        this.height = height;
    }

    public Integer getPagerheight()
    {
        return pagerheight;
    }

    public void setPagerheight(Integer pagerheight)
    {
        this.pagerheight = pagerheight;
    }

    public Integer getRowsheight()
    {
        return rowsheight;
    }

    public void setRowsheight(Integer rowsheight)
    {
        this.rowsheight = rowsheight;
    }

    public Integer getScrollbarsize()
    {
        return scrollbarsize;
    }

    public void setScrollbarsize(Integer scrollbarsize)
    {
        this.scrollbarsize = scrollbarsize;
    }

    public String getScrollmode()
    {
        return scrollmode;
    }

    public void setScrollmode(String scrollmode)
    {
        this.scrollmode = scrollmode;
    }

    public JavascriptFunction getScrollfeedback()
    {
        return scrollfeedback;
    }

    public void setScrollfeedback(JavascriptFunction scrollfeedback)
    {
        this.scrollfeedback = scrollfeedback;
    }

    public Integer getWidth()
    {
        return width;
    }

    public void setWidth(Integer width)
    {
        this.width = width;
    }

    public Boolean getAutosavestate()
    {
        return autosavestate;
    }

    public void setAutosavestate(Boolean autosavestate)
    {
        this.autosavestate = autosavestate;
    }

    public Boolean getAutoloadstate()
    {
        return autoloadstate;
    }

    public void setAutoloadstate(Boolean autoloadstate)
    {
        this.autoloadstate = autoloadstate;
    }

    public JQXGridColumns getColumns()
    {
        return columns;
    }

    public void setColumns(JQXGridColumns columns)
    {
        this.columns = columns;
    }

    public JQXGridColumns getColumngroups()
    {
        return columngroups;
    }

    public void setColumngroups(JQXGridColumns columngroups)
    {
        this.columngroups = columngroups;
    }

    public Boolean getColumnsmenu()
    {
        return columnsmenu;
    }

    public void setColumnsmenu(Boolean columnsmenu)
    {
        this.columnsmenu = columnsmenu;
    }

    public Boolean getColumnsresize()
    {
        return columnsresize;
    }

    public void setColumnsresize(Boolean columnsresize)
    {
        this.columnsresize = columnsresize;
    }

    public Boolean getColumnsautoresize()
    {
        return columnsautoresize;
    }

    public void setColumnsautoresize(Boolean columnsautoresize)
    {
        this.columnsautoresize = columnsautoresize;
    }

    public Boolean getColumnsreorder()
    {
        return columnsreorder;
    }

    public void setColumnsreorder(Boolean columnsreorder)
    {
        this.columnsreorder = columnsreorder;
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

    public String getEditmode()
    {
        return editmode;
    }

    public void setEditmode(String editmode)
    {
        this.editmode = editmode;
    }

    public Boolean getFilterable()
    {
        return filterable;
    }

    public void setFilterable(Boolean filterable)
    {
        this.filterable = filterable;
    }

    public Boolean getGroupable()
    {
        return groupable;
    }

    public void setGroupable(Boolean groupable)
    {
        this.groupable = groupable;
    }

    public JQXGridGroups getGroups()
    {
        return groups;
    }

    public void setGroups(JQXGridGroups groups)
    {
        this.groups = groups;
    }

    public Integer getHorizontalscrollbarstep()
    {
        return horizontalscrollbarstep;
    }

    public void setHorizontalscrollbarstep(Integer horizontalscrollbarstep)
    {
        this.horizontalscrollbarstep = horizontalscrollbarstep;
    }

    public Integer getHorizontalscrollbarlargestep()
    {
        return horizontalscrollbarlargestep;
    }

    public void setHorizontalscrollbarlargestep(Integer horizontalscrollbarlargestep)
    {
        this.horizontalscrollbarlargestep = horizontalscrollbarlargestep;
    }

    public JavascriptFunction getInitrowdetails()
    {
        return initrowdetails;
    }

    public void setInitrowdetails(JavascriptFunction initrowdetails)
    {
        this.initrowdetails = initrowdetails;
    }

    public Boolean getKeyboardnavigation()
    {
        return keyboardnavigation;
    }

    public void setKeyboardnavigation(Boolean keyboardnavigation)
    {
        this.keyboardnavigation = keyboardnavigation;
    }

    public Integer getPagesize()
    {
        return pagesize;
    }

    public void setPagesize(Integer pagesize)
    {
        this.pagesize = pagesize;
    }

    public Integer[] getPagesizeoptions()
    {
        return pagesizeoptions;
    }

    public void setPagesizeoptions(Integer[] pagesizeoptions)
    {
        this.pagesizeoptions = pagesizeoptions;
    }

    public String getPagermode()
    {
        return pagermode;
    }

    public void setPagermode(String pagermode)
    {
        this.pagermode = pagermode;
    }

    public Integer getPagerbuttonscount()
    {
        return pagerbuttonscount;
    }

    public void setPagerbuttonscount(Integer pagerbuttonscount)
    {
        this.pagerbuttonscount = pagerbuttonscount;
    }

    public Boolean getPageable()
    {
        return pageable;
    }

    public void setPageable(Boolean pageable)
    {
        this.pageable = pageable;
    }

    public Boolean getRowdetails()
    {
        return rowdetails;
    }

    public void setRowdetails(Boolean rowdetails)
    {
        this.rowdetails = rowdetails;
    }

    public JQXGridRowDetailsTemplate getRowdetailstemplate()
    {
        return rowdetailstemplate;
    }

    public void setRowdetailstemplate(JQXGridRowDetailsTemplate rowdetailstemplate)
    {
        this.rowdetailstemplate = rowdetailstemplate;
    }

    public JavascriptFunction getReady()
    {
        return ready;
    }

    public void setReady(JavascriptFunction ready)
    {
        this.ready = ready;
    }

    public JavascriptFunction getRendered()
    {
        return rendered;
    }

    public void setRendered(JavascriptFunction rendered)
    {
        this.rendered = rendered;
    }

    public JavascriptFunction getRenderstatusbar()
    {
        return renderstatusbar;
    }

    public void setRenderstatusbar(JavascriptFunction renderstatusbar)
    {
        this.renderstatusbar = renderstatusbar;
    }

    public JavascriptFunction getRendertoolbar()
    {
        return rendertoolbar;
    }

    public void setRendertoolbar(JavascriptFunction rendertoolbar)
    {
        this.rendertoolbar = rendertoolbar;
    }

    public JavascriptFunction getRendergridrows()
    {
        return rendergridrows;
    }

    public void setRendergridrows(JavascriptFunction rendergridrows)
    {
        this.rendergridrows = rendergridrows;
    }

    public Boolean getSortable()
    {
        return sortable;
    }

    public void setSortable(Boolean sortable)
    {
        this.sortable = sortable;
    }

    public Integer getSelectedrowindex()
    {
        return selectedrowindex;
    }

    public void setSelectedrowindex(Integer selectedrowindex)
    {
        this.selectedrowindex = selectedrowindex;
    }

    public JQXSelectedRowIndexes getSelectedrowindexes()
    {
        return selectedrowindexes;
    }

    public void setSelectedrowindexes(JQXSelectedRowIndexes selectedrowindexes)
    {
        this.selectedrowindexes = selectedrowindexes;
    }

    public Object getSource()
    {
        return source;
    }

    public void setSource(Object source)
    {
        this.source = source;
    }

    public String getSorttogglestates()
    {
        return sorttogglestates;
    }

    public void setSorttogglestates(String sorttogglestates)
    {
        this.sorttogglestates = sorttogglestates;
    }

    public Integer getUpdatedelay()
    {
        return updatedelay;
    }

    public void setUpdatedelay(Integer updatedelay)
    {
        this.updatedelay = updatedelay;
    }

    public Boolean getVirtualmode()
    {
        return virtualmode;
    }

    public void setVirtualmode(Boolean virtualmode)
    {
        this.virtualmode = virtualmode;
    }

    public Integer getVerticalscrollbarstep()
    {
        return verticalscrollbarstep;
    }

    public void setVerticalscrollbarstep(Integer verticalscrollbarstep)
    {
        this.verticalscrollbarstep = verticalscrollbarstep;
    }

    public Integer getVerticalscrollbarlargestep()
    {
        return verticalscrollbarlargestep;
    }

    public void setVerticalscrollbarlargestep(Integer verticalscrollbarlargestep)
    {
        this.verticalscrollbarlargestep = verticalscrollbarlargestep;
    }

}
