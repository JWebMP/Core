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
package za.co.mmagon.jwebswing.components.jqueryui.datepicker;

import java.util.ArrayList;
import za.co.mmagon.jwebswing.htmlbuilder.effects.JWAnimationEffectsPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptPartType;

/**
 *
 * @author GedMarc
 * @since Mar 8, 2015
 * @version 1.0
 * <p>
 *
 */
public class JQUIDatePickerOptions extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;

    /**
     * An input element that is to be updated with the selected date from the datepicker. Use the altFormat option to change the format of the date within this field. Leave as blank for no alternate
     * field.
     */
    public String altField;
    /**
     * The dateFormat to be used for the altField option. This allows one date format to be shown to the user for selection purposes, while a different format is actually sent behind the scenes. For a
     * full list of the possible formats see the formatDate function
     */
    public String altFormat;
    /**
     * The text to display after each date field, e.g., to show the required format.
     */
    public String appendText;
    /**
     * Set to true to automatically resize the input field to accommodate dates in the current dateFormat.
     */
    public Boolean autoSize;
    /**
     * A URL of an image to use to display the datepicker when the showOn option is set to "button" or "both". If set, the buttonText option becomes the alt value and is not directly displayed
     */
    public String buttonImage;
    /**
     * Whether the button image should be rendered by itself instead of inside a button element. This option is only relevant if the buttonImage option has also been set.
     */
    public Boolean buttonImageOnly;
    /**
     * The text to display on the trigger button. Use in conjunction with the showOn option set to "button" or "both".
     */
    public String buttonText;
    /**
     * Whether the month should be rendered as a dropdown instead of text.
     */
    public Boolean changeMonth;
    /**
     * Whether the year should be rendered as a dropdown instead of text. Use the yearRange option to control which years are made available for selection.
     */
    public Boolean changeYear;
    /**
     * The text to display for the close link. Use the showButtonPanel option to display this button.
     */
    public String closeText;
    /**
     * When true, entry in the input field is constrained to those characters allowed by the current dateFormat option.
     */
    public Boolean constrainInput;
    /**
     * The text to display for the current day link. Use the showButtonPanel option to display this button.
     */
    public String currentText;
    /**
     * The format for parsed and displayed dates. For a full list of the possible formats see the formatDate function.
     */
    public String dateFormat;
    /**
     * Default: [ "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" ]
     * <p>
     * The list of long day names, starting from Sunday, for use as requested via the dateFormat option.
     */
    public ArrayList<String> dayNames;
    /**
     * Default: [ "Su", "Mo", "Tu", "We", "Th", "Fr", "Sa" ]
     * <p>
     * The list of minimised day names, starting from Sunday, for use as column headers within the datepicker.<p>
     */
    public ArrayList<String> dayNamesMin;
    /**
     * dayNamesShortType: Array<p>
     * Default: [ "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" ]
     * <p>
     * The list of abbreviated day names, starting from Sunday, for use as requested via the dateFormat option.<p>
     */
    public ArrayList<String> dayNamesShort;
    /**
     * Set the date to highlight on first opening if the field is blank.<p>
     * Specify either an actual date via a Date object or as a string in the current dateFormat, or a number of days from today (e.g. +7)
     * <p>
     * or a string of values and periods ('y' for years, 'm' for months, 'w' for weeks, 'd' for days, e.g. '+1m +7d'), or null for today.<p>
     * Multiple types supported:
     * <p>
     * <p>
     * Date: A date object containing the default date.<p>
     * Number: A number of days from today. For example 2 represents two days from today and -1 represents yesterday.<p>
     * String: A string in the format defined by the dateFormat option, or a relative date.
     * <p>
     * Relative dates must contain value and period pairs; valid periods are "y" for years, "m" for months, "w" for weeks, and "d" for days.
     * <p>
     * For example, "+1m +7d" represents one month and seven days from today
     */
    public String defaultDate;
    /**
     * Control the speed at which the datepicker appears, it may be a time in milliseconds or a string representing one of the three predefined speeds ("slow", "normal", "fast").
     */
    public Integer duration;
    /**
     * Set the first day of the week: Sunday is 0, Monday is 1, etc.
     */
    public Integer firstDay;
    /**
     * When true, the current day link moves to the currently selected date instead of today.
     */
    public Boolean gotoCurrent;
    /**
     * Default: false<p>
     * Normally the previous and next links are disabled when not applicable (see the minDate and maxDate options).
     * <p>
     * You can hide them altogether by setting this attribute to true.<p>
     */
    public Boolean hideIfNoPrevNext;
    /**
     * Whether the current language is drawn from right to left.
     */
    public Boolean isRTL;
    /**
     * The maximum selectable date. When set to null, there is no maximum.<p>
     * Multiple types supported:
     * <p>
     * <p>
     * Date: A date object containing the maximum date.<p>
     * Number: A number of days from today. For example 2 represents two days from today and -1 represents yesterday.<p>
     * String: A string in the format defined by the dateFormat option, or a relative date.<p>
     * Relative dates must contain value and period pairs; valid periods are "y" for years, "m" for months, "w" for weeks, and "d" for days.<p>
     * For example, "+1m +7d" represents one month and seven days from today.<p>
     *
     */
    public String maxDate;
    /**
     * he minimum selectable date. When set to null, there is no minimum.<p>
     * Multiple types supported:
     * <p>
     * <p>
     * Date: A date object containing the minimum date.
     * <p>
     * Number: A number of days from today. For example 2 represents two days from today and -1 represents yesterday.
     * <p>
     * String: A string in the format defined by the dateFormat option, or a relative date.
     * <p>
     * Relative dates must contain value and period pairs; valid periods are "y" for years, "m" for months, "w" for weeks, and "d" for days.<p>
     * For example, "+1m +7d" represents one month and seven days from today.
     *
     */
    public String minDate;
    /**
     * Default: [ "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" ]
     * <p>
     * The list of full month names, for use as requested via the dateFormat option.<p>
     */
    public ArrayList<String> monthNames;
    /**
     * Default: [ "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" ]
     * <p>
     * The list of abbreviated month names, as used in the month header on each datepicker and as requested via the dateFormat option.<p>
     */
    public ArrayList<String> monthNamesShort;
    /**
     * Default: false Whether the prevText and nextText options should be parsed as dates by the formatDate function, allowing them to display the target month names for example.
     */
    public Boolean navigationAsDateFormat;
    /**
     * The text to display for the next month link. With the standard ThemeRoller styling, this value is replaced by an icon.
     */
    public String nextText;
    /**
     * The number of months to show at once.
     */
    public Integer numberOfMonths;
    /**
     * The text to display for the previous month link. With the standard ThemeRoller styling, this value is replaced by an icon.
     */
    public String prevText;

    /**
     * Whether days in other months shown before or after the current month are selectable. This only applies if the showOtherMonths option is set to true.
     */
    public Boolean selectOtherMonths;
    /**
     * The cutoff year for determining the century for a date (used in conjunction with dateFormat 'y')
     * .<p>
     * Any dates entered with a year value less than or equal to the cutoff year are considered to be<p>
     * in the current century,
     * <p>
     * while those greater than it are deemed to be in the previous century. Multiple types supported:
     * <p>
     * <p>
     * Number: A value between 0 and 99 indicating the cutoff year.
     * <p>
     * String: A relative number of years from the current year, e.g., "+3" or "-5"
     * .<p>
     *
     */
    public Integer shortYearCutoff;
    /**
     * The name of the animation used to show and hide the datepicker.
     * <p>
     * Use "show" (the default), "slideDown", "fadeIn", any of the jQuery UI effects. Set to an empty string to disable animation.<p>
     */
    public JWAnimationEffectsPart showAnim;
    /**
     * Whether to display a button pane underneath the calendar.<p>
     * The button pane contains two buttons, a Today button that links to the current day, and a Done button that closes the datepicker.<p>
     * The buttons' text can be customized using the currentText and closeText options respectively.
     */
    public Boolean showButtonPanel;
    /**
     * When displaying multiple months via the numberOfMonths option, the showCurrentAtPos option defines which position to display the current month in.
     */
    public Integer showCurrentAtPos;
    /**
     * Whether to show the month after the year in the header
     */
    public Boolean showMonthAfterYear;
    /**
     * When the datepicker should appear.
     * <p>
     * The datepicker can appear when the field receives focus ("focus"), when a button is clicked ("button"), or when either event occurs ("both").
     */
    public String showOn;
    /**
     * If using one of the jQuery UI effects for the showAnim option, you can provide additional properties for that animation using this option.
     *
     * @deprecated
     */
    public Boolean showOptions;
    /**
     * Whether to display dates in other months (non-selectable) at the start or end of the current month.
     * <p>
     * To make these days selectable use the selectOtherMonths option.
     */
    public Boolean showOtherMonths;
    /**
     * When true, a column is added to show the week of the year.<p>
     * The calculateWeek option determines how the week of the year is calculated.
     * <p>
     * You may also want to change the firstDay option.
     */
    public Boolean showWeek;
    /**
     * Set how many months to move when clicking the previous/next links.
     */
    public Integer stepMonths;
    /**
     * The text to display for the week of the year column heading. Default: "Wk" Use the showWeek option to display this column.
     */
    public String weekHeader;
    /**
     * The range of years displayed in the year drop-down: either relative to today's year ("-nn:+nn"),
     * <p>
     * relative to the currently selected year ("c-nn:c+nn"), absolute ("nnnn:nnnn"), or combinations of these formats ("nnnn:-nn").
     * <p>
     * Note that this option only affects what appears in the drop-down, to restrict which dates may be selected use the minDate and/or maxDate options.<p>
     * yearRange: "2002:2012"
     * <p>
     *
     */
    public String yearRange;
    /**
     * Additional text to display after the year in the month headers.
     */
    public String yearSuffix;

    public String getAltField()
    {
        return altField;
    }

    public void setAltField(String altField)
    {
        this.altField = altField;
    }

    public String getAltFormat()
    {
        return altFormat;
    }

    public void setAltFormat(String altFormat)
    {
        this.altFormat = altFormat;
    }

    public String getAppendText()
    {
        return appendText;
    }

    public void setAppendText(String appendText)
    {
        this.appendText = appendText;
    }

    public Boolean getAutoSize()
    {
        return autoSize;
    }

    public void setAutoSize(Boolean autoSize)
    {
        this.autoSize = autoSize;
    }

    public String getButtonImage()
    {
        return buttonImage;
    }

    public void setButtonImage(String buttonImage)
    {
        this.buttonImage = buttonImage;
    }

    public Boolean getButtonImageOnly()
    {
        return buttonImageOnly;
    }

    public void setButtonImageOnly(Boolean buttonImageOnly)
    {
        this.buttonImageOnly = buttonImageOnly;
    }

    public String getButtonText()
    {
        return buttonText;
    }

    public void setButtonText(String buttonText)
    {
        this.buttonText = buttonText;
    }

    public Boolean getChangeMonth()
    {
        return changeMonth;
    }

    public void setChangeMonth(Boolean changeMonth)
    {
        this.changeMonth = changeMonth;
    }

    public Boolean getChangeYear()
    {
        return changeYear;
    }

    public void setChangeYear(Boolean changeYear)
    {
        this.changeYear = changeYear;
    }

    public String getCloseText()
    {
        return closeText;
    }

    public void setCloseText(String closeText)
    {
        this.closeText = closeText;
    }

    public Boolean getConstrainInput()
    {
        return constrainInput;
    }

    public void setConstrainInput(Boolean constrainInput)
    {
        this.constrainInput = constrainInput;
    }

    public String getCurrentText()
    {
        return currentText;
    }

    public void setCurrentText(String currentText)
    {
        this.currentText = currentText;
    }

    public String getDateFormat()
    {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat)
    {
        this.dateFormat = dateFormat;
    }

    public ArrayList<String> getDayNames()
    {
        return dayNames;
    }

    public void setDayNames(ArrayList<String> dayNames)
    {
        this.dayNames = dayNames;
    }

    public ArrayList<String> getDayNamesMin()
    {
        return dayNamesMin;
    }

    public void setDayNamesMin(ArrayList<String> dayNamesMin)
    {
        this.dayNamesMin = dayNamesMin;
    }

    public ArrayList<String> getDayNamesShort()
    {
        return dayNamesShort;
    }

    public void setDayNamesShort(ArrayList<String> dayNamesShort)
    {
        this.dayNamesShort = dayNamesShort;
    }

    public String getDefaultDate()
    {
        return defaultDate;
    }

    public void setDefaultDate(String defaultDate)
    {
        this.defaultDate = defaultDate;
    }

    public Integer getDuration()
    {
        return duration;
    }

    public void setDuration(Integer duration)
    {
        this.duration = duration;
    }

    public Integer getFirstDay()
    {
        return firstDay;
    }

    public void setFirstDay(Integer firstDay)
    {
        this.firstDay = firstDay;
    }

    public Boolean getGotoCurrent()
    {
        return gotoCurrent;
    }

    public void setGotoCurrent(Boolean gotoCurrent)
    {
        this.gotoCurrent = gotoCurrent;
    }

    public Boolean getHideIfNoPrevNext()
    {
        return hideIfNoPrevNext;
    }

    public void setHideIfNoPrevNext(Boolean hideIfNoPrevNext)
    {
        this.hideIfNoPrevNext = hideIfNoPrevNext;
    }

    public Boolean getIsRTL()
    {
        return isRTL;
    }

    public void setIsRTL(Boolean isRTL)
    {
        this.isRTL = isRTL;
    }

    public String getMaxDate()
    {
        return maxDate;
    }

    public void setMaxDate(String maxDate)
    {
        this.maxDate = maxDate;
    }

    public String getMinDate()
    {
        return minDate;
    }

    public void setMinDate(String minDate)
    {
        this.minDate = minDate;
    }

    public ArrayList<String> getMonthNames()
    {
        return monthNames;
    }

    public void setMonthNames(ArrayList<String> monthNames)
    {
        this.monthNames = monthNames;
    }

    public ArrayList<String> getMonthNamesShort()
    {
        return monthNamesShort;
    }

    public void setMonthNamesShort(ArrayList<String> monthNamesShort)
    {
        this.monthNamesShort = monthNamesShort;
    }

    public Boolean getNavigationAsDateFormat()
    {
        return navigationAsDateFormat;
    }

    public void setNavigationAsDateFormat(Boolean navigationAsDateFormat)
    {
        this.navigationAsDateFormat = navigationAsDateFormat;
    }

    public String getNextText()
    {
        return nextText;
    }

    public void setNextText(String nextText)
    {
        this.nextText = nextText;
    }

    public Integer getNumberOfMonths()
    {
        return numberOfMonths;
    }

    public void setNumberOfMonths(Integer numberOfMonths)
    {
        this.numberOfMonths = numberOfMonths;
    }

    public String getPrevText()
    {
        return prevText;
    }

    public void setPrevText(String prevText)
    {
        this.prevText = prevText;
    }

    public Boolean getSelectOtherMonths()
    {
        return selectOtherMonths;
    }

    public void setSelectOtherMonths(Boolean selectOtherMonths)
    {
        this.selectOtherMonths = selectOtherMonths;
    }

    public Integer getShortYearCutoff()
    {
        return shortYearCutoff;
    }

    public void setShortYearCutoff(Integer shortYearCutoff)
    {
        this.shortYearCutoff = shortYearCutoff;
    }

    public JWAnimationEffectsPart getShowAnim()
    {
        return showAnim;
    }

    public void setShowAnim(JWAnimationEffectsPart showAnim)
    {
        this.showAnim = showAnim;
    }

    public Boolean getShowButtonPanel()
    {
        return showButtonPanel;
    }

    public void setShowButtonPanel(Boolean showButtonPanel)
    {
        this.showButtonPanel = showButtonPanel;
    }

    public Integer getShowCurrentAtPos()
    {
        return showCurrentAtPos;
    }

    public void setShowCurrentAtPos(Integer showCurrentAtPos)
    {
        this.showCurrentAtPos = showCurrentAtPos;
    }

    public Boolean getShowMonthAfterYear()
    {
        return showMonthAfterYear;
    }

    public void setShowMonthAfterYear(Boolean showMonthAfterYear)
    {
        this.showMonthAfterYear = showMonthAfterYear;
    }

    public String getShowOn()
    {
        return showOn;
    }

    public void setShowOn(String showOn)
    {
        this.showOn = showOn;
    }

    public Boolean getShowOptions()
    {
        return showOptions;
    }

    public void setShowOptions(Boolean showOptions)
    {
        this.showOptions = showOptions;
    }

    public Boolean getShowOtherMonths()
    {
        return showOtherMonths;
    }

    public void setShowOtherMonths(Boolean showOtherMonths)
    {
        this.showOtherMonths = showOtherMonths;
    }

    public Boolean getShowWeek()
    {
        return showWeek;
    }

    public void setShowWeek(Boolean showWeek)
    {
        this.showWeek = showWeek;
    }

    public Integer getStepMonths()
    {
        return stepMonths;
    }

    public void setStepMonths(Integer stepMonths)
    {
        this.stepMonths = stepMonths;
    }

    public String getWeekHeader()
    {
        return weekHeader;
    }

    public void setWeekHeader(String weekHeader)
    {
        this.weekHeader = weekHeader;
    }

    public String getYearRange()
    {
        return yearRange;
    }

    public void setYearRange(String yearRange)
    {
        this.yearRange = yearRange;
    }

    public String getYearSuffix()
    {
        return yearSuffix;
    }

    public void setYearSuffix(String yearSuffix)
    {
        this.yearSuffix = yearSuffix;
    }

    @Override
    public JavascriptPartType getJavascriptType()
    {
        return JavascriptPartType.Javascript;
    }
}
