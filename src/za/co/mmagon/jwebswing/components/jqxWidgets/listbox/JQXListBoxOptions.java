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
package za.co.mmagon.jwebswing.components.jqxWidgets.listbox;

import za.co.mmagon.jwebswing.components.jqxWidgets.JQXDefaultJavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptFunction;

/**
 * All the options for the JQX List Box
 * <p>
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXListBoxOptions extends JQXDefaultJavaScriptPart
{

    private Boolean autoHeight;// 	Boolean 	false
    private Boolean allowDrag;// 	Boolean 	false
    private Boolean allowDrop;// 	Boolean 	false
    private Boolean checkboxes;// 	Boolean 	false
    private Boolean disabled;// 	Boolean 	false
    private String displayMember;// 	String 	""
    private String dropAction;//(requires jqxdragdrop.js) 	String 	'default'.
    private JavascriptFunction dragStart;// 	Function 	null
    private JavascriptFunction dragEnd;// 	Function 	null
    private Boolean enableHover;// 	Boolean 	true
    private Boolean enableSelection;// 	Boolean 	true
    private Boolean equalItemsWidth;// 	Boolean 	true
    private Boolean filterable;// 	Boolean 	false
    private Integer filterHeight;// 	Number 	27
    private Integer filterDelay;// 	Number 	100
    private Boolean filterPlaceHolder;// 	String 	"Looking for"
    private Boolean hasThreeStates;// 	Boolean 	false
    private Integer itemHeight;// 	Number 	-1
    private Boolean incrementalSearch;// 	Boolean 	true
    private Integer incrementalSearchDelay;// 	Number 	700
    private Boolean multiple;// 	Boolean 	false
    private Boolean multipleextended;// 	Boolean 	false
    private Boolean renderer;// 	Function 	null
    private Boolean rtl;// 	Boolean 	false
    private Integer selectedIndex;// 	Number 	-1
    private Boolean source;// 	Array 	null
    private Integer scrollBarSize;// 	Number 	17
    private String searchMode;// 	String 	startswith
    private String valueMember;// 	String 	""

    public JQXListBoxOptions()
    {

    }

    public Boolean getAutoHeight()
    {
        return autoHeight;
    }

    public void setAutoHeight(Boolean autoHeight)
    {
        this.autoHeight = autoHeight;
    }

    public Boolean getAllowDrag()
    {
        return allowDrag;
    }

    public void setAllowDrag(Boolean allowDrag)
    {
        this.allowDrag = allowDrag;
    }

    public Boolean getAllowDrop()
    {
        return allowDrop;
    }

    public void setAllowDrop(Boolean allowDrop)
    {
        this.allowDrop = allowDrop;
    }

    public Boolean getCheckboxes()
    {
        return checkboxes;
    }

    public void setCheckboxes(Boolean checkboxes)
    {
        this.checkboxes = checkboxes;
    }

    public Boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    public String getDisplayMember()
    {
        return displayMember;
    }

    public void setDisplayMember(String displayMember)
    {
        this.displayMember = displayMember;
    }

    public String getDropAction()
    {
        return dropAction;
    }

    public void setDropAction(String dropAction)
    {
        this.dropAction = dropAction;
    }

    public JavascriptFunction getDragStart()
    {
        return dragStart;
    }

    public void setDragStart(JavascriptFunction dragStart)
    {
        this.dragStart = dragStart;
    }

    public JavascriptFunction getDragEnd()
    {
        return dragEnd;
    }

    public void setDragEnd(JavascriptFunction dragEnd)
    {
        this.dragEnd = dragEnd;
    }

    public Boolean getEnableHover()
    {
        return enableHover;
    }

    public void setEnableHover(Boolean enableHover)
    {
        this.enableHover = enableHover;
    }

    public Boolean getEnableSelection()
    {
        return enableSelection;
    }

    public void setEnableSelection(Boolean enableSelection)
    {
        this.enableSelection = enableSelection;
    }

    public Boolean getEqualItemsWidth()
    {
        return equalItemsWidth;
    }

    public void setEqualItemsWidth(Boolean equalItemsWidth)
    {
        this.equalItemsWidth = equalItemsWidth;
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

    public Integer getFilterDelay()
    {
        return filterDelay;
    }

    public void setFilterDelay(Integer filterDelay)
    {
        this.filterDelay = filterDelay;
    }

    public Boolean getFilterPlaceHolder()
    {
        return filterPlaceHolder;
    }

    public void setFilterPlaceHolder(Boolean filterPlaceHolder)
    {
        this.filterPlaceHolder = filterPlaceHolder;
    }

    public Boolean getHasThreeStates()
    {
        return hasThreeStates;
    }

    public void setHasThreeStates(Boolean hasThreeStates)
    {
        this.hasThreeStates = hasThreeStates;
    }

    public Integer getItemHeight()
    {
        return itemHeight;
    }

    public void setItemHeight(Integer itemHeight)
    {
        this.itemHeight = itemHeight;
    }

    public Boolean getIncrementalSearch()
    {
        return incrementalSearch;
    }

    public void setIncrementalSearch(Boolean incrementalSearch)
    {
        this.incrementalSearch = incrementalSearch;
    }

    public Integer getIncrementalSearchDelay()
    {
        return incrementalSearchDelay;
    }

    public void setIncrementalSearchDelay(Integer incrementalSearchDelay)
    {
        this.incrementalSearchDelay = incrementalSearchDelay;
    }

    public Boolean getMultiple()
    {
        return multiple;
    }

    public void setMultiple(Boolean multiple)
    {
        this.multiple = multiple;
    }

    public Boolean getMultipleextended()
    {
        return multipleextended;
    }

    public void setMultipleextended(Boolean multipleextended)
    {
        this.multipleextended = multipleextended;
    }

    public Boolean getRenderer()
    {
        return renderer;
    }

    public void setRenderer(Boolean renderer)
    {
        this.renderer = renderer;
    }

    public Boolean getRtl()
    {
        return rtl;
    }

    public void setRtl(Boolean rtl)
    {
        this.rtl = rtl;
    }

    public Integer getSelectedIndex()
    {
        return selectedIndex;
    }

    public void setSelectedIndex(Integer selectedIndex)
    {
        this.selectedIndex = selectedIndex;
    }

    public Boolean getSource()
    {
        return source;
    }

    public void setSource(Boolean source)
    {
        this.source = source;
    }

    public Integer getScrollBarSize()
    {
        return scrollBarSize;
    }

    public void setScrollBarSize(Integer scrollBarSize)
    {
        this.scrollBarSize = scrollBarSize;
    }

    public String getSearchMode()
    {
        return searchMode;
    }

    public void setSearchMode(String searchMode)
    {
        this.searchMode = searchMode;
    }

    public String getValueMember()
    {
        return valueMember;
    }

    public void setValueMember(String valueMember)
    {
        this.valueMember = valueMember;
    }

}
