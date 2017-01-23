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
import java.util.List;
import za.co.mmagon.jwebswing.htmlbuilder.effects.JWAnimationEffectsPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * THE Date picker options for JQUI
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
    private String altField;
    /**
     * The dateFormat to be used for the altField option. This allows one date format to be shown to the user for selection purposes, while a different format is actually sent behind the scenes. For a
     * full list of the possible formats see the formatDate function
     */
    private String altFormat;
    /**
     * The text to display after each date field, e.g., to show the required format.
     */
    private String appendText;
    /**
     * Set to true to automatically resize the input field to accommodate dates in the current dateFormat.
     */
    private Boolean autoSize;
    /**
     * A URL of an image to use to display the datepicker when the showOn option is set to "button" or "both". If set, the buttonText option becomes the alt value and is not directly displayed
     */
    private String buttonImage;
    /**
     * Whether the button image should be rendered by itself instead of inside a button element. This option is only relevant if the buttonImage option has also been set.
     */
    private Boolean buttonImageOnly;
    /**
     * The text to display on the trigger button. Use in conjunction with the showOn option set to "button" or "both".
     */
    private String buttonText;
    /**
     * Whether the month should be rendered as a dropdown instead of text.
     */
    private Boolean changeMonth;
    /**
     * Whether the year should be rendered as a dropdown instead of text. Use the yearRange option to control which years are made available for selection.
     */
    private Boolean changeYear;
    /**
     * The text to display for the close link. Use the showButtonPanel option to display this button.
     */
    private String closeText;
    /**
     * When true, entry in the input field is constrained to those characters allowed by the current dateFormat option.
     */
    private Boolean constrainInput;
    /**
     * The text to display for the current day link. Use the showButtonPanel option to display this button.
     */
    private String currentText;
    /**
     * The format for parsed and displayed dates. For a full list of the possible formats see the formatDate function.
     */
    private String dateFormat;
    /**
     * Default: [ "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" ]
     * <p>
     * The list of long day names, starting from Sunday, for use as requested via the dateFormat option.
     */
    private List<String> dayNames;
    /**
     * Default: [ "Su", "Mo", "Tu", "We", "Th", "Fr", "Sa" ]
     * <p>
     * The list of minimised day names, starting from Sunday, for use as column headers within the datepicker.<p>
     */
    private List<String> dayNamesMin;
    /**
     * dayNamesShortType: Array<p>
     * Default: [ "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" ]
     * <p>
     * The list of abbreviated day names, starting from Sunday, for use as requested via the dateFormat option.<p>
     */
    private List<String> dayNamesShort;
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
    private String defaultDate;
    /**
     * Control the speed at which the datepicker appears, it may be a time in milliseconds or a string representing one of the three predefined speeds ("slow", "normal", "fast").
     */
    private Integer duration;
    /**
     * Set the first day of the week: Sunday is 0, Monday is 1, etc.
     */
    private Integer firstDay;
    /**
     * When true, the current day link moves to the currently selected date instead of today.
     */
    private Boolean gotoCurrent;
    /**
     * Default: false<p>
     * Normally the previous and next links are disabled when not applicable (see the minDate and maxDate options).
     * <p>
     * You can hide them altogether by setting this attribute to true.<p>
     */
    private Boolean hideIfNoPrevNext;
    /**
     * Whether the current language is drawn from right to left.
     */
    private Boolean isRTL;
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
     * <p>
     */
    private String maxDate;
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
     * <p>
     */
    private String minDate;
    /**
     * Default: [ "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" ]
     * <p>
     * The list of full month names, for use as requested via the dateFormat option.<p>
     */
    private List<String> monthNames;
    /**
     * Default: [ "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" ]
     * <p>
     * The list of abbreviated month names, as used in the month header on each datepicker and as requested via the dateFormat option.<p>
     */
    private List<String> monthNamesShort;
    /**
     * Default: false Whether the prevText and nextText options should be parsed as dates by the formatDate function, allowing them to display the target month names for example.
     */
    private Boolean navigationAsDateFormat;
    /**
     * The text to display for the next month link. With the standard ThemeRoller styling, this value is replaced by an icon.
     */
    private String nextText;
    /**
     * The number of months to show at once.
     */
    private Integer numberOfMonths;
    /**
     * The text to display for the previous month link. With the standard ThemeRoller styling, this value is replaced by an icon.
     */
    private String prevText;

    /**
     * Whether days in other months shown before or after the current month are selectable. This only applies if the showOtherMonths option is set to true.
     */
    private Boolean selectOtherMonths;
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
     * <p>
     */
    private Integer shortYearCutoff;
    /**
     * The name of the animation used to show and hide the datepicker.
     * <p>
     * Use "show" (the default), "slideDown", "fadeIn", any of the jQuery UI effects. Set to an empty string to disable animation.<p>
     */
    private JWAnimationEffectsPart showAnim;
    /**
     * Whether to display a button pane underneath the calendar.<p>
     * The button pane contains two buttons, a Today button that links to the current day, and a Done button that closes the datepicker.<p>
     * The buttons' text can be customized using the currentText and closeText options respectively.
     */
    private Boolean showButtonPanel;
    /**
     * When displaying multiple months via the numberOfMonths option, the showCurrentAtPos option defines which position to display the current month in.
     */
    private Integer showCurrentAtPos;
    /**
     * Whether to show the month after the year in the header
     */
    private Boolean showMonthAfterYear;
    /**
     * When the datepicker should appear.
     * <p>
     * The datepicker can appear when the field receives focus ("focus"), when a button is clicked ("button"), or when either event occurs ("both").
     */
    private String showOn;
    /**
     * If using one of the jQuery UI effects for the showAnim option, you can provide additional properties for that animation using this option.
     *
     * @deprecated
     */
    private Boolean showOptions;
    /**
     * Whether to display dates in other months (non-selectable) at the start or end of the current month.
     * <p>
     * To make these days selectable use the selectOtherMonths option.
     */
    private Boolean showOtherMonths;
    /**
     * When true, a column is added to show the week of the year.<p>
     * The calculateWeek option determines how the week of the year is calculated.
     * <p>
     * You may also want to change the firstDay option.
     */
    private Boolean showWeek;
    /**
     * Set how many months to move when clicking the previous/next links.
     */
    private Integer stepMonths;
    /**
     * The text to display for the week of the year column heading. Default: "Wk" Use the showWeek option to display this column.
     */
    private String weekHeader;
    /**
     * The range of years displayed in the year drop-down: either relative to today's year ("-nn:+nn"),
     * <p>
     * relative to the currently selected year ("c-nn:c+nn"), absolute ("nnnn:nnnn"), or combinations of these formats ("nnnn:-nn").
     * <p>
     * Note that this option only affects what appears in the drop-down, to restrict which dates may be selected use the minDate and/or maxDate options.<p>
     * yearRange: "2002:2012"
     * <p>
     * <p>
     */
    private String yearRange;
    /**
     * Additional text to display after the year in the month headers.
     */
    private String yearSuffix;

    /**
     * Default creating constructor
     */
    public JQUIDatePickerOptions()
    {
        //Nothing needed here
    }

    /**
     * An input element that is to be updated with the selected date from the datepicker. Use the altFormat option to change the format of the date within this field. Leave as blank for no alternate
     * field.
     *
     * @return
     */
    public String getAltField()
    {
        return altField;
    }

    /**
     * An input element that is to be updated with the selected date from the datepicker. Use the altFormat option to change the format of the date within this field. Leave as blank for no alternate
     * field.
     *
     * @param altField
     */
    public void setAltField(String altField)
    {
        this.altField = altField;
    }

    /**
     * The dateFormat to be used for the altField option. This allows one date format to be shown to the user for selection purposes, while a different format is actually sent behind the scenes. For a
     * full list of the possible formats see the formatDate function
     *
     * @return
     */
    public String getAltFormat()
    {
        return altFormat;
    }

    /**
     * The dateFormat to be used for the altField option. This allows one date format to be shown to the user for selection purposes, while a different format is actually sent behind the scenes. For a
     * full list of the possible formats see the formatDate function
     *
     * @param altFormat
     */
    public void setAltFormat(String altFormat)
    {
        this.altFormat = altFormat;
    }

    /**
     * The text to display after each date field, e.g., to show the required format.
     *
     * @return
     */
    public String getAppendText()
    {
        return appendText;
    }

    /**
     * The text to display after each date field, e.g., to show the required format.
     *
     * @param appendText
     */
    public void setAppendText(String appendText)
    {
        this.appendText = appendText;
    }

    /**
     * Set to true to automatically resize the input field to accommodate dates in the current dateFormat.
     *
     * @return
     */
    public Boolean getAutoSize()
    {
        return autoSize;
    }

    /**
     * Set to true to automatically resize the input field to accommodate dates in the current dateFormat.
     *
     * @param autoSize
     */
    public void setAutoSize(Boolean autoSize)
    {
        this.autoSize = autoSize;
    }

    /**
     * A URL of an image to use to display the datepicker when the showOn option is set to "button" or "both". If set, the buttonText option becomes the alt value and is not directly displayed
     *
     * @return
     */
    public String getButtonImage()
    {
        return buttonImage;
    }

    /**
     * A URL of an image to use to display the datepicker when the showOn option is set to "button" or "both". If set, the buttonText option becomes the alt value and is not directly displayed
     *
     * @param buttonImage
     */
    public void setButtonImage(String buttonImage)
    {
        this.buttonImage = buttonImage;
    }

    /**
     * Whether the button image should be rendered by itself instead of inside a button element. This option is only relevant if the buttonImage option has also been set.
     *
     * @return
     */
    public Boolean getButtonImageOnly()
    {
        return buttonImageOnly;
    }

    /**
     * Whether the button image should be rendered by itself instead of inside a button element. This option is only relevant if the buttonImage option has also been set.
     *
     * @param buttonImageOnly
     */
    public void setButtonImageOnly(Boolean buttonImageOnly)
    {
        this.buttonImageOnly = buttonImageOnly;
    }

    /**
     * The text to display on the trigger button. Use in conjunction with the showOn option set to "button" or "both".
     *
     * @return
     */
    public String getButtonText()
    {
        return buttonText;
    }

    /**
     * The text to display on the trigger button. Use in conjunction with the showOn option set to "button" or "both".
     *
     * @param buttonText
     */
    public void setButtonText(String buttonText)
    {
        this.buttonText = buttonText;
    }

    /**
     * Whether the month should be rendered as a dropdown instead of text.
     *
     * @return
     */
    public Boolean getChangeMonth()
    {
        return changeMonth;
    }

    /**
     * Whether the month should be rendered as a dropdown instead of text.
     *
     * @param changeMonth
     */
    public void setChangeMonth(Boolean changeMonth)
    {
        this.changeMonth = changeMonth;
    }

    /**
     * Whether the year should be rendered as a dropdown instead of text. Use the yearRange option to control which years are made available for selection.
     *
     * @return
     */
    public Boolean getChangeYear()
    {
        return changeYear;
    }

    /**
     * Whether the year should be rendered as a dropdown instead of text. Use the yearRange option to control which years are made available for selection.
     *
     * @param changeYear
     */
    public void setChangeYear(Boolean changeYear)
    {
        this.changeYear = changeYear;
    }

    /**
     * The text to display for the close link. Use the showButtonPanel option to display this button.
     *
     * @return
     */
    public String getCloseText()
    {
        return closeText;
    }

    /**
     * The text to display for the close link. Use the showButtonPanel option to display this button.
     *
     * @param closeText
     */
    public void setCloseText(String closeText)
    {
        this.closeText = closeText;
    }

    /**
     * When true, entry in the input field is constrained to those characters allowed by the current dateFormat option.
     *
     * @return
     */
    public Boolean getConstrainInput()
    {
        return constrainInput;
    }

    /**
     * When true, entry in the input field is constrained to those characters allowed by the current dateFormat option.
     *
     * @param constrainInput
     */
    public void setConstrainInput(Boolean constrainInput)
    {
        this.constrainInput = constrainInput;
    }

    /**
     * The text to display for the current day link. Use the showButtonPanel option to display this button.
     *
     * @return
     */
    public String getCurrentText()
    {
        return currentText;
    }

    /**
     * The text to display for the current day link. Use the showButtonPanel option to display this button.
     *
     * @param currentText
     */
    public void setCurrentText(String currentText)
    {
        this.currentText = currentText;
    }

    /**
     * The format for parsed and displayed dates. For a full list of the possible formats see the formatDate function.
     *
     * @return
     */
    public String getDateFormat()
    {
        return dateFormat;
    }

    /**
     * The format for parsed and displayed dates. For a full list of the possible formats see the formatDate function.
     *
     * @param dateFormat
     */
    public void setDateFormat(String dateFormat)
    {
        this.dateFormat = dateFormat;
    }

    /**
     * Default: [ "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" ]
     * <p>
     * The list of long day names, starting from Sunday, for use as requested via the dateFormat option.
     *
     * @return
     */
    public List<String> getDayNames()
    {
        return dayNames;
    }

    /**
     * Default: [ "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" ]
     * <p>
     * The list of long day names, starting from Sunday, for use as requested via the dateFormat option.
     *
     * @param dayNames
     */
    public void setDayNames(List<String> dayNames)
    {
        this.dayNames = dayNames;
    }

    /**
     * Default: [ "Su", "Mo", "Tu", "We", "Th", "Fr", "Sa" ]
     * <p>
     * The list of minimised day names, starting from Sunday, for use as column headers within the datepicker.<p>
     * @return
     */
    public List<String> getDayNamesMin()
    {
        return dayNamesMin;
    }

    /**
     * Default: [ "Su", "Mo", "Tu", "We", "Th", "Fr", "Sa" ]
     * <p>
     * The list of minimised day names, starting from Sunday, for use as column headers within the datepicker.<p>
     * @param dayNamesMin
     */
    public void setDayNamesMin(List<String> dayNamesMin)
    {
        if (dayNamesMin == null)
        {
            setDayNamesMin(new ArrayList<>());
        }
        this.dayNamesMin = dayNamesMin;
    }

    /**
     * Default: [ "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" ]
     * <p>
     * The list of abbreviated month names, as used in the month header on each datepicker and as requested via the dateFormat option.<p>
     * @return
     */
    public List<String> getDayNamesShort()
    {
        return dayNamesShort;
    }

    /**
     * Default: [ "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" ]
     * <p>
     * The list of abbreviated month names, as used in the month header on each datepicker and as requested via the dateFormat option.<p>
     * @param dayNamesShort
     */
    public void setDayNamesShort(List<String> dayNamesShort)
    {
        this.dayNamesShort = dayNamesShort;
    }

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
     *
     * @return
     */
    public String getDefaultDate()
    {
        return defaultDate;
    }

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
     *
     * @param defaultDate
     */
    public void setDefaultDate(String defaultDate)
    {
        this.defaultDate = defaultDate;
    }

    /**
     * Control the speed at which the datepicker appears, it may be a time in milliseconds or a string representing one of the three predefined speeds ("slow", "normal", "fast").
     *
     * @return
     */
    public Integer getDuration()
    {
        return duration;
    }

    /**
     * Control the speed at which the datepicker appears, it may be a time in milliseconds or a string representing one of the three predefined speeds ("slow", "normal", "fast").
     *
     * @param duration
     */
    public void setDuration(Integer duration)
    {
        this.duration = duration;
    }

    /**
     * Set the first day of the week: Sunday is 0, Monday is 1, etc.
     *
     * @return
     */
    public Integer getFirstDay()
    {
        return firstDay;
    }

    /**
     * Set the first day of the week: Sunday is 0, Monday is 1, etc.
     *
     * @param firstDay
     */
    public void setFirstDay(Integer firstDay)
    {
        this.firstDay = firstDay;
    }

    /**
     * When true, the current day link moves to the currently selected date instead of today.
     *
     * @return
     */
    public Boolean getGotoCurrent()
    {
        return gotoCurrent;
    }

    /**
     * When true, the current day link moves to the currently selected date instead of today.
     *
     * @param gotoCurrent
     */
    public void setGotoCurrent(Boolean gotoCurrent)
    {
        this.gotoCurrent = gotoCurrent;
    }

    /**
     * Default: false<p>
     * Normally the previous and next links are disabled when not applicable (see the minDate and maxDate options).
     * <p>
     * You can hide them altogether by setting this attribute to true.<p>
     * @return
     */
    public Boolean getHideIfNoPrevNext()
    {
        return hideIfNoPrevNext;
    }

    /**
     * Default: false<p>
     * Normally the previous and next links are disabled when not applicable (see the minDate and maxDate options).
     * <p>
     * You can hide them altogether by setting this attribute to true.<p>
     * @param hideIfNoPrevNext
     */
    public void setHideIfNoPrevNext(Boolean hideIfNoPrevNext)
    {
        this.hideIfNoPrevNext = hideIfNoPrevNext;
    }

    /**
     * Whether the current language is drawn from right to left.
     *
     * @return
     */
    public Boolean getIsRTL()
    {
        return isRTL;
    }

    /**
     * Whether the current language is drawn from right to left.
     *
     * @param isRTL
     */
    public void setIsRTL(Boolean isRTL)
    {
        this.isRTL = isRTL;
    }

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
     * <p>
     * @return
     */
    public String getMaxDate()
    {
        return maxDate;
    }

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
     * <p>
     * @param maxDate
     */
    public void setMaxDate(String maxDate)
    {
        this.maxDate = maxDate;
    }

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
     * <p>
     * @return
     */
    public String getMinDate()
    {
        return minDate;
    }

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
     * <p>
     * @param minDate
     */
    public void setMinDate(String minDate)
    {
        this.minDate = minDate;
    }

    /**
     * Default: [ "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" ]
     * <p>
     * The list of full month names, for use as requested via the dateFormat option.<p>
     * @return
     */
    public List<String> getMonthNames()
    {
        if (this.monthNames == null)
        {
            monthNames = new ArrayList<>();
        }
        return monthNames;
    }

    /**
     * Default: [ "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" ]
     * <p>
     * The list of full month names, for use as requested via the dateFormat option.<p>
     * @param monthNames
     */
    public void setMonthNames(List<String> monthNames)
    {
        this.monthNames = monthNames;
    }

    /**
     * Default: [ "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" ]
     * <p>
     * The list of abbreviated month names, as used in the month header on each datepicker and as requested via the dateFormat option.<p>
     * @return
     */
    public List<String> getMonthNamesShort()
    {
        if (monthNamesShort == null)
        {
            monthNamesShort = new ArrayList<>();
        }
        return monthNamesShort;
    }

    /**
     * Default: [ "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" ]
     * <p>
     * The list of abbreviated month names, as used in the month header on each datepicker and as requested via the dateFormat option.<p>
     * @param monthNamesShort
     */
    public void setMonthNamesShort(List<String> monthNamesShort)
    {
        this.monthNamesShort = monthNamesShort;
    }

    /**
     * Default: false Whether the prevText and nextText options should be parsed as dates by the formatDate function, allowing them to display the target month names for example.
     *
     * @return
     */
    public Boolean getNavigationAsDateFormat()
    {
        return navigationAsDateFormat;
    }

    /**
     * Default: false Whether the prevText and nextText options should be parsed as dates by the formatDate function, allowing them to display the target month names for example.
     *
     * @param navigationAsDateFormat
     */
    public void setNavigationAsDateFormat(Boolean navigationAsDateFormat)
    {
        this.navigationAsDateFormat = navigationAsDateFormat;
    }

    /**
     * The text to display for the next month link. With the standard ThemeRoller styling, this value is replaced by an icon.
     *
     * @return
     */
    public String getNextText()
    {
        return nextText;
    }

    /**
     * The text to display for the next month link. With the standard ThemeRoller styling, this value is replaced by an icon.
     *
     * @param nextText
     */
    public void setNextText(String nextText)
    {
        this.nextText = nextText;
    }

    /**
     * The number of months to show at once.
     *
     * @return
     */
    public Integer getNumberOfMonths()
    {
        return numberOfMonths;
    }

    /**
     * The number of months to show at once.
     *
     * @param numberOfMonths
     */
    public void setNumberOfMonths(Integer numberOfMonths)
    {
        this.numberOfMonths = numberOfMonths;
    }

    /**
     * The text to display for the previous month link. With the standard ThemeRoller styling, this value is replaced by an icon.
     *
     * @return
     */
    public String getPrevText()
    {
        return prevText;
    }

    /**
     * The text to display for the previous month link. With the standard ThemeRoller styling, this value is replaced by an icon.
     *
     * @param prevText
     */
    public void setPrevText(String prevText)
    {
        this.prevText = prevText;
    }

    /**
     * Whether days in other months shown before or after the current month are selectable. This only applies if the showOtherMonths option is set to true.
     *
     * @return
     */
    public Boolean getSelectOtherMonths()
    {
        return selectOtherMonths;
    }

    /**
     * Whether days in other months shown before or after the current month are selectable. This only applies if the showOtherMonths option is set to true.
     *
     * @param selectOtherMonths
     */
    public void setSelectOtherMonths(Boolean selectOtherMonths)
    {
        this.selectOtherMonths = selectOtherMonths;
    }

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
     * <p>
     * @return
     */
    public Integer getShortYearCutoff()
    {
        return shortYearCutoff;
    }

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
     * <p>
     * @param shortYearCutoff
     */
    public void setShortYearCutoff(Integer shortYearCutoff)
    {
        this.shortYearCutoff = shortYearCutoff;
    }

    /**
     * The name of the animation used to show and hide the datepicker.
     * <p>
     * Use "show" (the default), "slideDown", "fadeIn", any of the jQuery UI effects. Set to an empty string to disable animation.<p>
     * @return
     */
    public JWAnimationEffectsPart getShowAnim()
    {
        return showAnim;
    }

    /**
     * The name of the animation used to show and hide the datepicker.
     * <p>
     * Use "show" (the default), "slideDown", "fadeIn", any of the jQuery UI effects. Set to an empty string to disable animation.<p>
     * @param showAnim
     */
    public void setShowAnim(JWAnimationEffectsPart showAnim)
    {
        this.showAnim = showAnim;
    }

    /**
     * Whether to display a button pane underneath the calendar.<p>
     * The button pane contains two buttons, a Today button that links to the current day, and a Done button that closes the datepicker.<p>
     * The buttons' text can be customized using the currentText and closeText options respectively.
     *
     * @return
     */
    public Boolean getShowButtonPanel()
    {
        return showButtonPanel;
    }

    /**
     * Whether to display a button pane underneath the calendar.<p>
     * The button pane contains two buttons, a Today button that links to the current day, and a Done button that closes the datepicker.<p>
     * The buttons' text can be customized using the currentText and closeText options respectively.
     *
     * @param showButtonPanel
     */
    public void setShowButtonPanel(Boolean showButtonPanel)
    {
        this.showButtonPanel = showButtonPanel;
    }

    /**
     * When displaying multiple months via the numberOfMonths option, the showCurrentAtPos option defines which position to display the current month in.
     *
     * @return
     */
    public Integer getShowCurrentAtPos()
    {
        return showCurrentAtPos;
    }

    /**
     * When displaying multiple months via the numberOfMonths option, the showCurrentAtPos option defines which position to display the current month in.
     *
     * @param showCurrentAtPos
     */
    public void setShowCurrentAtPos(Integer showCurrentAtPos)
    {
        this.showCurrentAtPos = showCurrentAtPos;
    }

    /**
     * Whether to show the month after the year in the header
     *
     * @return
     */
    public Boolean getShowMonthAfterYear()
    {
        return showMonthAfterYear;
    }

    /**
     * Whether to show the month after the year in the header
     *
     * @param showMonthAfterYear
     */
    public void setShowMonthAfterYear(Boolean showMonthAfterYear)
    {
        this.showMonthAfterYear = showMonthAfterYear;
    }

    /**
     * When the datepicker should appear.
     * <p>
     * The datepicker can appear when the field receives focus ("focus"), when a button is clicked ("button"), or when either event occurs ("both").
     *
     * @return
     */
    public String getShowOn()
    {
        return showOn;
    }

    /**
     * When the datepicker should appear.
     * <p>
     * The datepicker can appear when the field receives focus ("focus"), when a button is clicked ("button"), or when either event occurs ("both").
     *
     * @param showOn
     */
    public void setShowOn(String showOn)
    {
        this.showOn = showOn;
    }

    /**
     * If using one of the jQuery UI effects for the showAnim option, you can provide additional properties for that animation using this option.
     *
     * @return
     *
     * @deprecated
     */
    public Boolean getShowOptions()
    {
        return showOptions;
    }

    /**
     * If using one of the jQuery UI effects for the showAnim option, you can provide additional properties for that animation using this option.
     *
     * @param showOptions
     *
     * @deprecated
     */
    public void setShowOptions(Boolean showOptions)
    {
        this.showOptions = showOptions;
    }

    /**
     * Whether to display dates in other months (non-selectable) at the start or end of the current month.
     * <p>
     * To make these days selectable use the selectOtherMonths option.
     *
     * @return
     */
    public Boolean getShowOtherMonths()
    {
        return showOtherMonths;
    }

    /**
     * Whether to display dates in other months (non-selectable) at the start or end of the current month.
     * <p>
     * To make these days selectable use the selectOtherMonths option.
     *
     * @param showOtherMonths
     */
    public void setShowOtherMonths(Boolean showOtherMonths)
    {
        this.showOtherMonths = showOtherMonths;
    }

    /**
     * When true, a column is added to show the week of the year.<p>
     * The calculateWeek option determines how the week of the year is calculated.
     * <p>
     * You may also want to change the firstDay option.
     *
     * @return
     */
    public Boolean getShowWeek()
    {
        return showWeek;
    }

    /**
     * When true, a column is added to show the week of the year.<p>
     * The calculateWeek option determines how the week of the year is calculated.
     * <p>
     * You may also want to change the firstDay option.
     *
     * @param showWeek
     */
    public void setShowWeek(Boolean showWeek)
    {
        this.showWeek = showWeek;
    }

    /**
     * Set how many months to move when clicking the previous/next links.
     *
     * @return
     */
    public Integer getStepMonths()
    {
        return stepMonths;
    }

    /**
     * Set how many months to move when clicking the previous/next links.
     *
     * @param stepMonths
     */
    public void setStepMonths(Integer stepMonths)
    {
        this.stepMonths = stepMonths;
    }

    /**
     * The text to display for the week of the year column heading. Default: "Wk" Use the showWeek option to display this column.
     *
     * @return
     */
    public String getWeekHeader()
    {
        return weekHeader;
    }

    /**
     * The text to display for the week of the year column heading. Default: "Wk" Use the showWeek option to display this column.
     *
     * @param weekHeader
     */
    public void setWeekHeader(String weekHeader)
    {
        this.weekHeader = weekHeader;
    }

    /**
     * The range of years displayed in the year drop-down: either relative to today's year ("-nn:+nn"),
     * <p>
     * relative to the currently selected year ("c-nn:c+nn"), absolute ("nnnn:nnnn"), or combinations of these formats ("nnnn:-nn").
     * <p>
     * Note that this option only affects what appears in the drop-down, to restrict which dates may be selected use the minDate and/or maxDate options.<p>
     * yearRange: "2002:2012"
     * <p>
     * <p>
     * @return
     */
    public String getYearRange()
    {
        return yearRange;
    }

    /**
     * The range of years displayed in the year drop-down: either relative to today's year ("-nn:+nn"),
     * <p>
     * relative to the currently selected year ("c-nn:c+nn"), absolute ("nnnn:nnnn"), or combinations of these formats ("nnnn:-nn").
     * <p>
     * Note that this option only affects what appears in the drop-down, to restrict which dates may be selected use the minDate and/or maxDate options.<p>
     * yearRange: "2002:2012"
     * <p>
     * <p>
     * @param yearRange
     */
    public void setYearRange(String yearRange)
    {
        this.yearRange = yearRange;
    }

    /**
     * Additional text to display after the year in the month headers.
     *
     * @return
     */
    public String getYearSuffix()
    {
        return yearSuffix;
    }

    /**
     * Additional text to display after the year in the month headers.
     *
     * @param yearSuffix
     */
    public void setYearSuffix(String yearSuffix)
    {
        this.yearSuffix = yearSuffix;
    }

}
