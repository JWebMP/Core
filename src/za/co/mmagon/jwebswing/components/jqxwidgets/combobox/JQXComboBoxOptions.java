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
package za.co.mmagon.jwebswing.components.jqxwidgets.combobox;

import java.util.ArrayList;
import za.co.mmagon.jwebswing.components.jqxwidgets.JQXDefaultJavaScriptPart;

/**
 * All the options for the tooltip library
 * <p>
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXComboBoxOptions extends JQXDefaultJavaScriptPart
{

    private JQXComboBoxAnimationTypes animationType;// 	String 'slide'
    private Boolean autoComplete;// Boolean 	false
    private Boolean autoOpen;// Boolean 	false
    private Boolean autoDropDownHeight;// Boolean 	false
    private Integer closeDelay;// Number 	400
    private Boolean checkboxes;// Boolean 	false
    private Boolean disabled;// Boolean 	false
    private String displayMember;// String 	""
    private JXComboBoxHorizontalAlignment dropDownHorizontalAlignment;// String    'left'
    private Integer dropDownHeight;// Number 	200
    private Integer dropDownWidth;// Number 	200
    private Boolean enableHover;// Boolean 	true
    private Boolean enableSelection;// Boolean 	true
    private Boolean enableBrowserBoundsDetection;// Boolean 	false
    private Integer itemHeight;// Number 	-1
    private Boolean multiSelect;// Boolean 	false
    private Integer minLength;// Number 	2
    private Integer openDelay;// Number 	350
    private Integer popupZIndex;// Number 	20000
    private String placeHolder;// String 	""
    private Boolean remoteAutoComplete;// Boolean 	false
    private Integer remoteAutoCompleteDelay;// Number 	300
    private String renderer;// function; 	null
    private String renderSelectedItem;// function 	null
    private Boolean rtl;// Boolean 	false
    private Integer selectedIndex;// Number 	-1
    private Boolean showArrow;// Boolean 	true
    private Boolean showCloseButtons;// Boolean 	true
    private String searchMode;// String;// 	startswith
    private String search;// 	function 	null
    private ArrayList<String> source;// Array 	null
    private Integer scrollBarSize;// Number 	17
    private String validateSelection;// Function 	null
    private String valueMember;// String 	""

    public JQXComboBoxOptions()
    {

    }

    public JQXComboBoxAnimationTypes getAnimationType()
    {
        return animationType;
    }

    public void setAnimationType(JQXComboBoxAnimationTypes animationType)
    {
        this.animationType = animationType;
    }

    public Boolean getAutoComplete()
    {
        return autoComplete;
    }

    public void setAutoComplete(Boolean autoComplete)
    {
        this.autoComplete = autoComplete;
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

    public Integer getCloseDelay()
    {
        return closeDelay;
    }

    public void setCloseDelay(Integer closeDelay)
    {
        this.closeDelay = closeDelay;
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

    public JXComboBoxHorizontalAlignment getDropDownHorizontalAlignment()
    {
        return dropDownHorizontalAlignment;
    }

    public void setDropDownHorizontalAlignment(JXComboBoxHorizontalAlignment dropDownHorizontalAlignment)
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

    public Integer getDropDownWidth()
    {
        return dropDownWidth;
    }

    public void setDropDownWidth(Integer dropDownWidth)
    {
        this.dropDownWidth = dropDownWidth;
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

    public Boolean getEnableBrowserBoundsDetection()
    {
        return enableBrowserBoundsDetection;
    }

    public void setEnableBrowserBoundsDetection(Boolean enableBrowserBoundsDetection)
    {
        this.enableBrowserBoundsDetection = enableBrowserBoundsDetection;
    }

    public Integer getItemHeight()
    {
        return itemHeight;
    }

    public void setItemHeight(Integer itemHeight)
    {
        this.itemHeight = itemHeight;
    }

    public Boolean getMultiSelect()
    {
        return multiSelect;
    }

    public void setMultiSelect(Boolean multiSelect)
    {
        this.multiSelect = multiSelect;
    }

    public Integer getMinLength()
    {
        return minLength;
    }

    public void setMinLength(Integer minLength)
    {
        this.minLength = minLength;
    }

    public Integer getOpenDelay()
    {
        return openDelay;
    }

    public void setOpenDelay(Integer openDelay)
    {
        this.openDelay = openDelay;
    }

    public Integer getPopupZIndex()
    {
        return popupZIndex;
    }

    public void setPopupZIndex(Integer popupZIndex)
    {
        this.popupZIndex = popupZIndex;
    }

    public String getPlaceHolder()
    {
        return placeHolder;
    }

    public void setPlaceHolder(String placeHolder)
    {
        this.placeHolder = placeHolder;
    }

    public Boolean getRemoteAutoComplete()
    {
        return remoteAutoComplete;
    }

    public void setRemoteAutoComplete(Boolean remoteAutoComplete)
    {
        this.remoteAutoComplete = remoteAutoComplete;
    }

    public Integer getRemoteAutoCompleteDelay()
    {
        return remoteAutoCompleteDelay;
    }

    public void setRemoteAutoCompleteDelay(Integer remoteAutoCompleteDelay)
    {
        this.remoteAutoCompleteDelay = remoteAutoCompleteDelay;
    }

    public String getRenderer()
    {
        return renderer;
    }

    public void setRenderer(String renderer)
    {
        this.renderer = renderer;
    }

    public String getRenderSelectedItem()
    {
        return renderSelectedItem;
    }

    public void setRenderSelectedItem(String renderSelectedItem)
    {
        this.renderSelectedItem = renderSelectedItem;
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

    public Boolean getShowArrow()
    {
        return showArrow;
    }

    public void setShowArrow(Boolean showArrow)
    {
        this.showArrow = showArrow;
    }

    public Boolean getShowCloseButtons()
    {
        return showCloseButtons;
    }

    public void setShowCloseButtons(Boolean showCloseButtons)
    {
        this.showCloseButtons = showCloseButtons;
    }

    public String getSearchMode()
    {
        return searchMode;
    }

    public void setSearchMode(String searchMode)
    {
        this.searchMode = searchMode;
    }

    public String getSearch()
    {
        return search;
    }

    public void setSearch(String search)
    {
        this.search = search;
    }

    public ArrayList<String> getSource()
    {
        return source;
    }

    public void setSource(ArrayList<String> source)
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

    public String getValidateSelection()
    {
        return validateSelection;
    }

    public void setValidateSelection(String validateSelection)
    {
        this.validateSelection = validateSelection;
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
