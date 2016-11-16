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
package za.co.mmagon.jwebswing.components.jqxWidgets.calendar;

import java.util.ArrayList;
import java.util.Date;
import za.co.mmagon.jwebswing.components.globalize.cultures.GlobalizeCultures;
import za.co.mmagon.jwebswing.components.jqxWidgets.JQXDayNameFormats;
import za.co.mmagon.jwebswing.components.jqxWidgets.JQXDefaultJavaScriptPart;
import za.co.mmagon.jwebswing.components.jqxWidgets.JQXSelectionModes;

/**
 * All the options for the JQX Calendar library
 * <p>
 * @author GedMarc
 * @since Dec 10, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXCalendarOptions extends JQXDefaultJavaScriptPart
{

    private static final long serialVersionUID = 1L;

    private String backText;// 	String 	Back
    private Integer columnHeaderHeight;// 	Number 	20
    private String clearString;// 	String 	'Clear'
    private GlobalizeCultures culture;// 	String 	default
    private JQXDayNameFormats dayNameFormat;// 	String 	'firstTwoLetters'
    private Boolean disabled;// Boolean 	false
    private Boolean enableWeekend;// Boolean 	false
    private Boolean enableViews;// Boolean 	true
    private Boolean enableOtherMonthDays;// Boolean 	true
    private Boolean enableFastNavigation;// Boolean 	true
    private Boolean enableHover;// Boolean 	true
    private Boolean enableAutoNavigation;// Boolean 	true
    private Boolean enableTooltips;// Boolean 	false
    private String forwardText;// String 	Forward
    private Integer firstDayOfWeek;// 	Number 	0

    private Date min;// 	1900, 1, 1
    private Date max;// Date 	2100, 1, 1
    private Integer navigationDelay;// Number 	400
    private Integer rowHeaderWidth;// Number 	25
    private Boolean readOnly;// Boolean 	false
    private ArrayList<Date> restrictedDates;// Array[]
    private Boolean rtl;// Boolean 	false
    private Integer stepMonths;// Number 	1
    private Boolean showWeekNumbers;// Boolean 	true
    private Boolean showDayNames;/// Boolean 	true
    private Boolean showOtherMonthDays;// Boolean 	true
    private Boolean showFooter;// Boolean 	false
    private JQXSelectionModes selectionMode;// String    'default'
    private ArrayList<Date> specialDates;// Array    new Array()
    private Integer titleHeight;// 	Number 	25
    private ArrayList<String> titleFormat;// 	Array 	["MMMM yyyy", "yyyy", "yyyy"]
    private String todayString;// 	String 	'Today'
    private Date value;// 	Date 	Today

    public JQXCalendarOptions()
    {

    }

    /**
     * Sets or gets the tooltip text displayed when the mouse cursor is over the back navigation button.
     *
     * @return
     */
    public String getBackText()
    {
        return backText;
    }

    /**
     * Sets or gets the tooltip text displayed when the mouse cursor is over the back navigation button.
     *
     * @param backText
     */
    public void setBackText(String backText)
    {
        this.backText = backText;
    }

    /**
     * Sets or gets the Calendar colomn header's height. In the column header are displayed the calendar day names.
     *
     * @return
     */
    public Integer getColumnHeaderHeight()
    {
        return columnHeaderHeight;
    }

    /**
     * Sets or gets the Calendar colomn header's height. In the column header are displayed the calendar day names.
     *
     * @param columnHeaderHeight
     */
    public void setColumnHeaderHeight(Integer columnHeaderHeight)
    {
        this.columnHeaderHeight = columnHeaderHeight;
    }

    /**
     * Sets or gets the 'Clear' string displayed when the 'showFooter' property is true.
     *
     * @return
     */
    public String getClearString()
    {
        return clearString;
    }

    /**
     * Sets or gets the 'Clear' string displayed when the 'showFooter' property is true.
     *
     * @param clearString
     */
    public void setClearString(String clearString)
    {
        this.clearString = clearString;
    }

    /**
     * Sets or gets the jqxCalendar's culture. The culture settings are contained within a file with the language code appended to the name, e.g. jquery.glob.de-DE.js for German. To set the culture,
     * you need to include the jquery.glob.de-DE.js and set the culture property to the culture's name, e.g. 'de-DE'.
     *
     * @return
     */
    public GlobalizeCultures getCulture()
    {
        return culture;
    }

    /**
     * Sets or gets the jqxCalendar's culture. The culture settings are contained within a file with the language code appended to the name, e.g. jquery.glob.de-DE.js for German. To set the culture,
     * you need to include the jquery.glob.de-DE.js and set the culture property to the culture's name, e.g. 'de-DE'.
     *
     * @param culture
     */
    public void setCulture(GlobalizeCultures culture)
    {
        this.culture = culture;
    }

    /**
     * Sets or gets the name format of days of the week.
     * Possible Values:
     * <p>
     * 'default'
     * <p>
     * 'shortest'
     * <p>
     * 'firstTwoLetters'
     * <p>
     * 'firstLetter'
     * <p>
     * 'full'
     *
     * @return
     */
    public JQXDayNameFormats getDayNameFormat()
    {
        return dayNameFormat;
    }

    /**
     * Sets or gets the name format of days of the week.
     * Possible Values:
     * <p>
     * 'default'
     * <p>
     * 'shortest'
     * <p>
     * 'firstTwoLetters'
     * <p>
     * 'firstLetter'
     * <p>
     * 'full'
     *
     * @param dayNameFormat
     */
    public void setDayNameFormat(JQXDayNameFormats dayNameFormat)
    {
        this.dayNameFormat = dayNameFormat;
    }

    /**
     * Disables (true) or enables (false) the calendar. Can be set when initialising (first creating) the calendar.
     *
     * @return
     */
    public Boolean getDisabled()
    {
        return disabled;
    }

    /**
     * Disables (true) or enables (false) the calendar. Can be set when initialising (first creating) the calendar.
     *
     * @param disabled
     */
    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    /**
     * Sets or gets a value indicating whether weekend persists its view state.
     *
     * @return
     */
    public Boolean getEnableWeekend()
    {
        return enableWeekend;
    }

    /**
     * Sets or gets a value indicating whether weekend persists its view state.
     *
     * @param enableWeekend
     */
    public void setEnableWeekend(Boolean enableWeekend)
    {
        this.enableWeekend = enableWeekend;
    }

    /**
     * Determines whether switching between month, year and decade views is enabled.
     *
     * @return
     */
    public Boolean getEnableViews()
    {
        return enableViews;
    }

    /**
     * Determines whether switching between month, year and decade views is enabled.
     *
     * @param enableViews
     */
    public void setEnableViews(Boolean enableViews)
    {
        this.enableViews = enableViews;
    }

    /**
     * Sets or gets a value indicating whether the other month days are enabled.
     *
     * @return
     */
    public Boolean getEnableOtherMonthDays()
    {
        return enableOtherMonthDays;
    }

    /**
     * Sets or gets a value indicating whether the other month days are enabled.
     *
     * @param enableOtherMonthDays
     */
    public void setEnableOtherMonthDays(Boolean enableOtherMonthDays)
    {
        this.enableOtherMonthDays = enableOtherMonthDays;
    }

    /**
     * Sets or gets a value indicating whether the fast navigation is enabled.
     *
     * @return
     */
    public Boolean getEnableFastNavigation()
    {
        return enableFastNavigation;
    }

    /*
     * Sets or gets a value indicating whether the fast navigation is enabled.
     */
    public void setEnableFastNavigation(Boolean enableFastNavigation)
    {
        this.enableFastNavigation = enableFastNavigation;
    }

    /**
     * Sets or gets a value indicating whether the hover state is enabled. The hover state is activated when the mouse cursor is over a calendar cell. The hover state is automatically disabled when
     * the calendar is displayed in touch devices.
     *
     * @return
     */
    public Boolean getEnableHover()
    {
        return enableHover;
    }

    /**
     * Sets or gets a value indicating whether the hover state is enabled. The hover state is activated when the mouse cursor is over a calendar cell. The hover state is automatically disabled when
     * the calendar is displayed in touch devices.
     *
     * @param enableHover
     */
    public void setEnableHover(Boolean enableHover)
    {
        this.enableHover = enableHover;
    }

    /**
     * Sets or gets a value indicating whether the auto navigation is enabled. When this property is true, click on other month date will automatically navigate to the previous or next month.
     *
     * @return
     */
    public Boolean getEnableAutoNavigation()
    {
        return enableAutoNavigation;
    }

    /**
     * Sets or gets a value indicating whether the auto navigation is enabled. When this property is true, click on other month date will automatically navigate to the previous or next month.
     *
     * @param enableAutoNavigation
     */
    public void setEnableAutoNavigation(Boolean enableAutoNavigation)
    {
        this.enableAutoNavigation = enableAutoNavigation;
    }

    /**
     * Sets or gets a value indicating whether the tool tips are enabled.
     *
     * @return
     */
    public Boolean getEnableTooltips()
    {
        return enableTooltips;
    }

    /**
     * Sets or gets a value indicating whether the tool tips are enabled.
     *
     * @param enableTooltips
     */
    public void setEnableTooltips(Boolean enableTooltips)
    {
        this.enableTooltips = enableTooltips;
    }

    /**
     * Sets or gets the tooltip text displayed when the mouse cursor is over the forward navigation button.EnableTooltips property should be set to true.
     *
     * @return
     */
    public String getForwardText()
    {
        return forwardText;
    }

    /**
     * Sets or gets the tooltip text displayed when the mouse cursor is over the forward navigation button.EnableTooltips property should be set to true.
     *
     * @param forwardText
     */
    public void setForwardText(String forwardText)
    {
        this.forwardText = forwardText;
    }

    /**
     * Sets or gets which day to display in the first day column. By default the calendar displays 'Sunday' as first day.
     *
     * @return
     */
    public Integer getFirstDayOfWeek()
    {
        return firstDayOfWeek;
    }

    /**
     * Sets or gets which day to display in the first day column. By default the calendar displays 'Sunday' as first day.
     *
     * @param firstDayOfWeek
     */
    public void setFirstDayOfWeek(Integer firstDayOfWeek)
    {
        this.firstDayOfWeek = firstDayOfWeek;
    }

    /**
     * Represents the minimum navigation date.
     *
     * @return
     */
    public Date getMin()
    {
        return min;
    }

    /**
     * Represents the minimum navigation date.
     *
     * @param min
     */
    public void setMin(Date min)
    {
        this.min = min;
    }

    /**
     * Represents the maximum navigation date.
     *
     * @return
     */
    public Date getMax()
    {
        return max;
    }

    /**
     * maximum
     *
     * @param max
     */
    public void setMax(Date max)
    {
        this.max = max;
    }

    /**
     * Determines the animation delay between switching views.
     *
     * @return
     */
    public Integer getNavigationDelay()
    {
        return navigationDelay;
    }

    /**
     * Determines the animation delay between switching views.
     *
     * @param navigationDelay
     */
    public void setNavigationDelay(Integer navigationDelay)
    {
        this.navigationDelay = navigationDelay;
    }

    /**
     * Sets or gets the row header width.
     *
     * @return
     */
    public Integer getRowHeaderWidth()
    {
        return rowHeaderWidth;
    }

    /**
     * Sets or gets the row header width.
     *
     * @param rowHeaderWidth
     */
    public void setRowHeaderWidth(Integer rowHeaderWidth)
    {
        this.rowHeaderWidth = rowHeaderWidth;
    }

    /**
     * Sets or gets the calendar in read only state.
     *
     * @return
     */
    public Boolean getReadOnly()
    {
        return readOnly;
    }

    /**
     * Sets or gets the calendar in read only state.
     *
     * @param readOnly
     */
    public void setReadOnly(Boolean readOnly)
    {
        this.readOnly = readOnly;
    }

    /**
     * Sets or gets the calendar's restricted dates. These are dates which cannot be clicked.
     *
     * @return
     */
    public ArrayList<Date> getRestrictedDates()
    {
        if (restrictedDates == null)
        {
            restrictedDates = new ArrayList<>();
        }
        return restrictedDates;
    }

    /**
     * Sets or gets the calendar's restricted dates. These are dates which cannot be clicked.
     *
     * @param restrictedDates
     */
    public void setRestrictedDates(ArrayList<Date> restrictedDates)
    {
        this.restrictedDates = restrictedDates;
    }

    /**
     * Sets or gets a value indicating whether widget's elements are aligned to support locales using right-to-left fonts.
     *
     * @return
     */
    public Boolean getRtl()
    {
        return rtl;
    }

    /**
     * Sets or gets a value indicating whether widget's elements are aligned to support locales using right-to-left fonts.
     *
     * @param rtl
     */
    public void setRtl(Boolean rtl)
    {
        this.rtl = rtl;
    }

    /**
     * Represents the calendar`s navigation step when the left or right navigation button is clicked.
     *
     * @return
     */
    public Integer getStepMonths()
    {
        return stepMonths;
    }

    /**
     * Represents the calendar`s navigation step when the left or right navigation button is clicked.
     *
     * @param stepMonths
     */
    public void setStepMonths(Integer stepMonths)
    {
        this.stepMonths = stepMonths;
    }

    /**
     * Sets or gets a value whether the week`s numbers are displayed.
     *
     * @return
     */
    public Boolean getShowWeekNumbers()
    {
        return showWeekNumbers;
    }

    /**
     * Sets or gets a value whether the week`s numbers are displayed.
     *
     * @param showWeekNumbers
     */
    public void setShowWeekNumbers(Boolean showWeekNumbers)
    {
        this.showWeekNumbers = showWeekNumbers;
    }

    /**
     * Sets or gets a value whether the day names are displayed. By default, the day names are displayed.
     *
     * @return
     */
    public Boolean getShowDayNames()
    {
        return showDayNames;
    }

    /**
     * Sets or gets a value whether the day names are displayed. By default, the day names are displayed.
     *
     * @param showDayNames
     */
    public void setShowDayNames(Boolean showDayNames)
    {
        this.showDayNames = showDayNames;
    }

    /**
     * Sets or gets a value whether the other month days are displayed.
     *
     * @return
     */
    public Boolean getShowOtherMonthDays()
    {
        return showOtherMonthDays;
    }

    /**
     * Sets or gets a value whether the other month days are displayed.
     *
     * @param showOtherMonthDays
     */
    public void setShowOtherMonthDays(Boolean showOtherMonthDays)
    {
        this.showOtherMonthDays = showOtherMonthDays;
    }

    /**
     * Sets or gets a value indicating whether the calendar's footer is displayed.
     *
     * @return
     */
    public Boolean getShowFooter()
    {
        return showFooter;
    }

    /**
     * Sets or gets a value indicating whether the calendar's footer is displayed.
     *
     * @param showFooter
     */
    public void setShowFooter(Boolean showFooter)
    {
        this.showFooter = showFooter;
    }

    /**
     * Sets or gets the selection mode.
     * Possible Values:
     * <p>
     * 'none'
     * <p>
     * 'default'
     * <p>
     * 'range'
     *
     * @return
     */
    public JQXSelectionModes getSelectionMode()
    {
        return selectionMode;
    }

    /**
     * Sets or gets the selection mode.
     * Possible Values:
     * <p>
     * 'none'
     * <p>
     * 'default'
     * <p>
     * 'range'
     *
     * @param selectionMode
     */
    public void setSelectionMode(JQXSelectionModes selectionMode)
    {
        this.selectionMode = selectionMode;
    }

    /**
     * Sets or gets a special date to the Calendar.
     *
     * @return
     */
    public ArrayList<Date> getSpecialDates()
    {
        if (specialDates == null)
        {
            specialDates = new ArrayList<>();
        }
        return specialDates;
    }

    /**
     * Sets or gets a special date to the Calendar.
     *
     * @param specialDates
     */
    public void setSpecialDates(ArrayList<Date> specialDates)
    {
        this.specialDates = specialDates;
    }

    /**
     * Sets or gets the title height where the navigation arrows are displayed.
     *
     * @return
     */
    public Integer getTitleHeight()
    {
        return titleHeight;
    }

    /**
     * Sets or gets the title height where the navigation arrows are displayed.
     *
     * @param titleHeight
     */
    public void setTitleHeight(Integer titleHeight)
    {
        this.titleHeight = titleHeight;
    }

    /**
     * Sets or gets the title format for the title section.
     * Possible Values:
     * <p>
     * 'd'-the day of the month
     * <p>
     * 'dd'-the day of the month
     * <p>
     * 'ddd'-the abbreviated name of the day of the week
     * <p>
     * 'dddd'-the full name of the day of the week
     * <p>
     * 'h'-the hour, using a 12-hour clock from 1 to 12
     * <p>
     * 'hh'-the hour, using a 12-hour clock from 01 to 12
     * <p>
     * 'H'-the hour, using a 24-hour clock from 0 to 23
     * <p>
     * 'HH'-the hour, using a 24-hour clock from 00 to 23
     * <p>
     * 'm'-the minute, from 0 through 59
     * <p>
     * 'mm'-the minutes,from 00 though59
     * <p>
     * 'M'-the month, from 1 through 12;
     * <p>
     * 'MM'-the month, from 01 through 12
     * <p>
     * 'MMM'-the abbreviated name of the month
     * <p>
     * 'MMMM'-the full name of the month
     * <p>
     * 's'-the second, from 0 through 59
     * <p>
     * 'ss'-the second, from 00 through 59
     * <p>
     * 't'-the first character of the AM/PM designator
     * <p>
     * 'tt'-the AM/PM designator
     * <p>
     * 'y'-the year, from 0 to 99
     * <p>
     * 'yy'-the year, from 00 to 99
     * <p>
     * 'yyy'-the year, with a minimum of three digits
     * <p>
     * 'yyyy'-the year as a four-digit number
     *
     * @return
     */
    public ArrayList<String> getTitleFormat()
    {
        if (titleFormat == null)
        {
            titleFormat = new ArrayList<>();
        }
        return titleFormat;
    }

    /**
     * Sets or gets the title format for the title section.
     * Possible Values:
     * <p>
     * 'd'-the day of the month
     * <p>
     * 'dd'-the day of the month
     * <p>
     * 'ddd'-the abbreviated name of the day of the week
     * <p>
     * 'dddd'-the full name of the day of the week
     * <p>
     * 'h'-the hour, using a 12-hour clock from 1 to 12
     * <p>
     * 'hh'-the hour, using a 12-hour clock from 01 to 12
     * <p>
     * 'H'-the hour, using a 24-hour clock from 0 to 23
     * <p>
     * 'HH'-the hour, using a 24-hour clock from 00 to 23
     * <p>
     * 'm'-the minute, from 0 through 59
     * <p>
     * 'mm'-the minutes,from 00 though59
     * <p>
     * 'M'-the month, from 1 through 12;
     * <p>
     * 'MM'-the month, from 01 through 12
     * <p>
     * 'MMM'-the abbreviated name of the month
     * <p>
     * 'MMMM'-the full name of the month
     * <p>
     * 's'-the second, from 0 through 59
     * <p>
     * 'ss'-the second, from 00 through 59
     * <p>
     * 't'-the first character of the AM/PM designator
     * <p>
     * 'tt'-the AM/PM designator
     * <p>
     * 'y'-the year, from 0 to 99
     * <p>
     * 'yy'-the year, from 00 to 99
     * <p>
     * 'yyy'-the year, with a minimum of three digits
     * <p>
     * 'yyyy'-the year as a four-digit number
     *
     * @param titleFormat
     */
    public void setTitleFormat(ArrayList<String> titleFormat)
    {
        this.titleFormat = titleFormat;
    }

    /**
     * Sets or gets the 'Today' string displayed when the 'showFooter' property is true.
     *
     * @return
     */
    public String getTodayString()
    {
        return todayString;
    }

    /**
     * Sets or gets the 'Today' string displayed when the 'showFooter' property is true.
     *
     * @param todayString
     */
    public void setTodayString(String todayString)
    {
        this.todayString = todayString;
    }

    /**
     * Sets or gets the Calendar's value.
     *
     * @return
     */
    public Date getValue()
    {
        return value;
    }

    /**
     * *
     * Sets or gets the Calendar's value.
     *
     * @param value
     */
    public void setValue(Date value)
    {
        this.value = value;
    }

}
