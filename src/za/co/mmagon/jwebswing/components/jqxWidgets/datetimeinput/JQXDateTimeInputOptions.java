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
package za.co.mmagon.jwebswing.components.jqxWidgets.datetimeinput;

import java.util.Date;
import za.co.mmagon.jwebswing.components.jqxWidgets.JQXDefaultJavaScriptPart;
import za.co.mmagon.jwebswing.components.jqxWidgets.JQXHorizontalAlignments;
import za.co.mmagon.jwebswing.components.jqxWidgets.JQXSelectionModes;
import za.co.mmagon.jwebswing.components.jqxWidgets.JQXTextAlignments;

/**
 * All the options for the tooltip library
 * <p>
 * @author GedMarc
 * @since Dec 12, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXDateTimeInputOptions extends JQXDefaultJavaScriptPart
{

    private String animationType;// 	String 	'slide'
    private Boolean allowNullDate;// 	Boolean 	true
    private Boolean allowKeyboardDelete;// 	Boolean 	true
    private String clearString;// 	String 	'Clear'
    private String culture;// 	String 	default
    private Integer closeDelay;// 	Number 	400
    private Boolean closeCalendarAfterSelection;// 	Boolean 	true
    private JQXHorizontalAlignments dropDownHorizontalAlignment;// 	String 	'left'
    private Boolean disabled;// 	Boolean 	false
    private Boolean enableBrowserBoundsDetection;// 	Boolean 	false
    private Boolean enableAbsoluteSelection;// 	Boolean 	false
    private Integer firstDayOfWeek;// 	Number 	0
    private String formatString;// 	String 	dd/MM/yyyy
    private Date min;// 	Date 	Date(1900, 1, 1)
    private Date max;// 	Date 	Date(2100, 1, 1)
    private Integer openDelay;// 	Number 	350
    private Integer popupZIndex;// 	Number 	20000
    private Boolean rtl;// 	Boolean 	false
    private Boolean readonly;// 	Boolean 	false
    private Boolean showFooter;// 	Boolean 	false
    private JQXSelectionModes selectionMode;// 	String 	'default'
    private Boolean showWeekNumbers;// 	Boolean 	true
    private Boolean showTimeButton;// 	Boolean 	false
    private Boolean showCalendarButton;// 	Boolean 	true
    private JQXTextAlignments textAlign;// 	String 	left
    private String todayString;// 	String 	'Today'
    private String value;// 	Date 	Today's Date

    public JQXDateTimeInputOptions()
    {

    }

    public String getAnimationType()
    {
        return animationType;
    }

    public void setAnimationType(String animationType)
    {
        this.animationType = animationType;
    }

    public Boolean getAllowNullDate()
    {
        return allowNullDate;
    }

    public void setAllowNullDate(Boolean allowNullDate)
    {
        this.allowNullDate = allowNullDate;
    }

    public Boolean getAllowKeyboardDelete()
    {
        return allowKeyboardDelete;
    }

    public void setAllowKeyboardDelete(Boolean allowKeyboardDelete)
    {
        this.allowKeyboardDelete = allowKeyboardDelete;
    }

    public String getClearString()
    {
        return clearString;
    }

    public void setClearString(String clearString)
    {
        this.clearString = clearString;
    }

    public String getCulture()
    {
        return culture;
    }

    public void setCulture(String culture)
    {
        this.culture = culture;
    }

    public Integer getCloseDelay()
    {
        return closeDelay;
    }

    public void setCloseDelay(Integer closeDelay)
    {
        this.closeDelay = closeDelay;
    }

    public Boolean getCloseCalendarAfterSelection()
    {
        return closeCalendarAfterSelection;
    }

    public void setCloseCalendarAfterSelection(Boolean closeCalendarAfterSelection)
    {
        this.closeCalendarAfterSelection = closeCalendarAfterSelection;
    }

    public JQXHorizontalAlignments getDropDownHorizontalAlignment()
    {
        return dropDownHorizontalAlignment;
    }

    public void setDropDownHorizontalAlignment(JQXHorizontalAlignments dropDownHorizontalAlignment)
    {
        this.dropDownHorizontalAlignment = dropDownHorizontalAlignment;
    }

    public Boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    public Boolean getEnableBrowserBoundsDetection()
    {
        return enableBrowserBoundsDetection;
    }

    public void setEnableBrowserBoundsDetection(Boolean enableBrowserBoundsDetection)
    {
        this.enableBrowserBoundsDetection = enableBrowserBoundsDetection;
    }

    public Boolean getEnableAbsoluteSelection()
    {
        return enableAbsoluteSelection;
    }

    public void setEnableAbsoluteSelection(Boolean enableAbsoluteSelection)
    {
        this.enableAbsoluteSelection = enableAbsoluteSelection;
    }

    public Integer getFirstDayOfWeek()
    {
        return firstDayOfWeek;
    }

    public void setFirstDayOfWeek(Integer firstDayOfWeek)
    {
        this.firstDayOfWeek = firstDayOfWeek;
    }

    public String getFormatString()
    {
        return formatString;
    }

    public void setFormatString(String formatString)
    {
        this.formatString = formatString;
    }

    public Date getMin()
    {
        return min;
    }

    public void setMin(Date min)
    {
        this.min = min;
    }

    public Date getMax()
    {
        return max;
    }

    public void setMax(Date max)
    {
        this.max = max;
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

    public Boolean getRtl()
    {
        return rtl;
    }

    public void setRtl(Boolean rtl)
    {
        this.rtl = rtl;
    }

    public Boolean getReadonly()
    {
        return readonly;
    }

    public void setReadonly(Boolean readonly)
    {
        this.readonly = readonly;
    }

    public Boolean getShowFooter()
    {
        return showFooter;
    }

    public void setShowFooter(Boolean showFooter)
    {
        this.showFooter = showFooter;
    }

    public JQXSelectionModes getSelectionMode()
    {
        return selectionMode;
    }

    public void setSelectionMode(JQXSelectionModes selectionMode)
    {
        this.selectionMode = selectionMode;
    }

    public Boolean getShowWeekNumbers()
    {
        return showWeekNumbers;
    }

    public void setShowWeekNumbers(Boolean showWeekNumbers)
    {
        this.showWeekNumbers = showWeekNumbers;
    }

    public Boolean getShowTimeButton()
    {
        return showTimeButton;
    }

    public void setShowTimeButton(Boolean showTimeButton)
    {
        this.showTimeButton = showTimeButton;
    }

    public Boolean getShowCalendarButton()
    {
        return showCalendarButton;
    }

    public void setShowCalendarButton(Boolean showCalendarButton)
    {
        this.showCalendarButton = showCalendarButton;
    }

    public JQXTextAlignments getTextAlign()
    {
        return textAlign;
    }

    public void setTextAlign(JQXTextAlignments textAlign)
    {
        this.textAlign = textAlign;
    }

    public String getTodayString()
    {
        return todayString;
    }

    public void setTodayString(String todayString)
    {
        this.todayString = todayString;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

}
