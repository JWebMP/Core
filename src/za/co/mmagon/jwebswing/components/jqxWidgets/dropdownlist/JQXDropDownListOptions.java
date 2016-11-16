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
package za.co.mmagon.jwebswing.components.jqxWidgets.dropdownlist;

import com.fasterxml.jackson.annotation.JsonRawValue;
import za.co.mmagon.jwebswing.components.jqxWidgets.JQXDefaultJavaScriptPart;
import za.co.mmagon.jwebswing.components.jqxWidgets.JQXHorizontalAlignments;
import za.co.mmagon.jwebswing.components.jqxWidgets.JQXSearchModes;
import za.co.mmagon.jwebswing.components.jqxWidgets.dataadapter.JQXDataAdapter;
import za.co.mmagon.jwebswing.htmlbuilder.effects.EasingEffects;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptFunction;

/**
 * All the options for the Drop Down List
 * <p>
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXDropDownListOptions extends JQXDefaultJavaScriptPart
{

    private static final long serialVersionUID = 1L;

    private Boolean autoOpen;// Boolean 	false
    private Boolean autoDropDownHeight;//  Boolean 	false
    private EasingEffects animationType;//  String 'slide'
    private Boolean checkboxes;//  Boolean 	false
    private Integer closeDelay;//  Number 	400
    private Boolean disabled;//  Boolean 	false
    private String displayMember;//  String 	""
    private JQXHorizontalAlignments dropDownHorizontalAlignment;//  String 'left'
    private Integer dropDownHeight;//  Number 	200
    private Integer number;//  	200
    private Boolean enableSelection;//  Boolean 	true
    private Boolean enableBrowserBoundsDetection;//  Boolean 	false
    private Boolean enableHover;//  Boolean 	true
    private Boolean filterable;//  Boolean 	false
    private Integer filterHeight;//  Number 	27
    private String filterDelay;//  Number 	100
    private String filterPlaceHolder;//  String 	"Looking for"
    private Boolean incrementalSearch;//  Boolean 	true
    private Integer incrementalSearchDelay;//  Number 	700
    private Integer itemHeight;//  Number 	-1
    private Integer openDelay;//  Number 	350
    private String placeHolder;//  String 	"Please Choose:"
    private Integer popupZIndex;//  Number 	20000
    private Boolean rtl;//  Boolean 	false
    private JavascriptFunction renderer;// Function 	null
    private JavascriptFunction selectionRenderer;// Function 	null
    private JQXSearchModes searchMode;// String 	startswith
    private Integer scrollBarSize;//  	Number 	17
    @JsonRawValue
    private JQXDataAdapter source;// Array 	null
    private Integer selectedIndex;//  Number 	-1
    private String valueMember;//  String

    public JQXDropDownListOptions()
    {

    }

    public Boolean getAutoOpen()
    {
        return autoOpen;
    }

    public void setAutoOpen(Boolean autoOpen)
    {
        this.autoOpen = autoOpen;
    }

    public Boolean getAutoDropDownHeight()
    {
        return autoDropDownHeight;
    }

    public void setAutoDropDownHeight(Boolean autoDropDownHeight)
    {
        this.autoDropDownHeight = autoDropDownHeight;
    }

    public EasingEffects getAnimationType()
    {
        return animationType;
    }

    public void setAnimationType(EasingEffects animationType)
    {
        this.animationType = animationType;
    }

    public Boolean getCheckboxes()
    {
        return checkboxes;
    }

    public void setCheckboxes(Boolean checkboxes)
    {
        this.checkboxes = checkboxes;
    }

    public Integer getCloseDelay()
    {
        return closeDelay;
    }

    public void setCloseDelay(Integer closeDelay)
    {
        this.closeDelay = closeDelay;
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

    public JQXHorizontalAlignments getDropDownHorizontalAlignment()
    {
        return dropDownHorizontalAlignment;
    }

    public void setDropDownHorizontalAlignment(JQXHorizontalAlignments dropDownHorizontalAlignment)
    {
        this.dropDownHorizontalAlignment = dropDownHorizontalAlignment;
    }

    public Integer getDropDownHeight()
    {
        return dropDownHeight;
    }

    public void setDropDownHeight(Integer dropDownHeight)
    {
        this.dropDownHeight = dropDownHeight;
    }

    public Integer getNumber()
    {
        return number;
    }

    public void setNumber(Integer number)
    {
        this.number = number;
    }

    public Boolean getEnableSelection()
    {
        return enableSelection;
    }

    public void setEnableSelection(Boolean enableSelection)
    {
        this.enableSelection = enableSelection;
    }

    public Boolean getEnableBrowserBoundsDetection()
    {
        return enableBrowserBoundsDetection;
    }

    public void setEnableBrowserBoundsDetection(Boolean enableBrowserBoundsDetection)
    {
        this.enableBrowserBoundsDetection = enableBrowserBoundsDetection;
    }

    public Boolean getEnableHover()
    {
        return enableHover;
    }

    public void setEnableHover(Boolean enableHover)
    {
        this.enableHover = enableHover;
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

    public String getFilterDelay()
    {
        return filterDelay;
    }

    public void setFilterDelay(String filterDelay)
    {
        this.filterDelay = filterDelay;
    }

    public String getFilterPlaceHolder()
    {
        return filterPlaceHolder;
    }

    public void setFilterPlaceHolder(String filterPlaceHolder)
    {
        this.filterPlaceHolder = filterPlaceHolder;
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

    public Integer getItemHeight()
    {
        return itemHeight;
    }

    public void setItemHeight(Integer itemHeight)
    {
        this.itemHeight = itemHeight;
    }

    public Integer getOpenDelay()
    {
        return openDelay;
    }

    public void setOpenDelay(Integer openDelay)
    {
        this.openDelay = openDelay;
    }

    public String getPlaceHolder()
    {
        return placeHolder;
    }

    public void setPlaceHolder(String placeHolder)
    {
        this.placeHolder = placeHolder;
    }

    public Integer getPopupZIndex()
    {
        return popupZIndex;
    }

    public void setPopupZIndex(Integer popupZIndex)
    {
        this.popupZIndex = popupZIndex;
    }

    public Boolean getRtl()
    {
        return rtl;
    }

    public void setRtl(Boolean rtl)
    {
        this.rtl = rtl;
    }

    public JavascriptFunction getRenderer()
    {
        return renderer;
    }

    public void setRenderer(JavascriptFunction renderer)
    {
        this.renderer = renderer;
    }

    public JavascriptFunction getSelectionRenderer()
    {
        return selectionRenderer;
    }

    public void setSelectionRenderer(JavascriptFunction selectionRenderer)
    {
        this.selectionRenderer = selectionRenderer;
    }

    public JQXSearchModes getSearchMode()
    {
        return searchMode;
    }

    public void setSearchMode(JQXSearchModes searchMode)
    {
        this.searchMode = searchMode;
    }

    public Integer getScrollBarSize()
    {
        return scrollBarSize;
    }

    public void setScrollBarSize(Integer scrollBarSize)
    {
        this.scrollBarSize = scrollBarSize;
    }

    public JQXDataAdapter getSource()
    {
        return source;
    }

    public void setSource(JQXDataAdapter source)
    {
        this.source = source;
    }

    public Integer getSelectedIndex()
    {
        return selectedIndex;
    }

    public void setSelectedIndex(Integer selectedIndex)
    {
        this.selectedIndex = selectedIndex;
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
