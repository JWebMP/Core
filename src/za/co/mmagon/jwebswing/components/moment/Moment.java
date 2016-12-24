/*
 * Copyright (C) 2015 Marc Magon
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
package za.co.mmagon.jwebswing.components.moment;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * The Moment.js implementation
 * <p>
 * @author Marc Magon
 * @since 29 Aug 2015
 * @version 1.0
 */
public class Moment extends Div<MomentChildren, MomentAttributes, MomentFeatures, MomentEvents, Moment> implements GlobalChildren
{

    private static final long serialVersionUID = 1L;

    private static MomentAngularModule angularModule;

    private MomentFeature feature;

    private Date assignedDate;
    private String variableName;

    private Map<MomentFilters, String> appliedFilters;

    /**
     * Constructs an empty moment component
     */
    public Moment()
    {

    }

    /**
     * Constructs a new moment with the given date and tag type
     *
     * @param assignedDate The date to use
     * @param myComponent  THe component tag to use
     */
    public Moment(Date assignedDate, ComponentTypes myComponent)
    {
        super(myComponent);
        this.assignedDate = assignedDate;
    }

    /**
     * Constructs a new moment with the given angular variable name
     *
     * @param variableName The angular variable name to use
     * @param myComponent  The component type to use
     */
    public Moment(String variableName, ComponentTypes myComponent)
    {
        super(myComponent);
        this.variableName = variableName;
    }

    /**
     * Constructs a new DIV with the given date
     *
     * @param assignedDate The date to use
     */
    public Moment(Date assignedDate)
    {
        this.assignedDate = assignedDate;
    }

    /**
     * Constructs a new DIV with the given angular variable
     *
     * @param variableName the new angular variable
     */
    public Moment(String variableName)
    {
        this.variableName = variableName;
    }

    /**
     * Returns the given feature
     *
     * @return
     */
    public final MomentFeature getFeature()
    {
        if (feature == null)
        {
            feature = new MomentFeature(this);
        }
        return feature;
    }

    /**
     * Returns no Options
     *
     * @return No options available for a moment
     */
    @Override
    public MomentOptions getOptions()
    {
        return getFeature().getOptions();
    }
    

    /**
     * Returns the assigned date
     *
     * @return
     */
    public Date getAssignedDate()
    {
        return assignedDate;
    }

    /**
     * Returns the assigned date
     *
     * @param assignedDate
     */
    public void setAssignedDate(Date assignedDate)
    {
        this.assignedDate = assignedDate;
    }

    /**
     * Returns the assigned variable name
     *
     * @return
     */
    public String getVariableName()
    {
        return variableName;
    }

    /**
     * Sets the assigned variable name
     *
     * @param variableName
     */
    public void setVariableName(String variableName)
    {
        this.variableName = variableName;
    }

    /**
     * Return the HashMap of filters applied to this moment
     *
     * @return
     */
    public Map<MomentFilters, String> getAppliedFilters()
    {
        if (appliedFilters == null)
        {
            appliedFilters = new HashMap<>();
        }
        return appliedFilters;
    }

    /**
     * Sets this moment list of applied filters
     *
     * @param appliedFilters
     */
    public void setAppliedFilters(HashMap<MomentFilters, String> appliedFilters)
    {
        this.appliedFilters = appliedFilters;
    }

    @Override
    public void preConfigure()
    {
        if (!isConfigured())
        {
            addFeature(getFeature());
            if (angularModule == null)
            {
                angularModule = new MomentAngularModule(getPage());
            }
            getAngularModules().add(angularModule);
            addAttribute(MomentAttributes.am_time_ago, buildAttributeString());
            getPage().getOptions().setAngularEnabled(true);
        }
        super.preConfigure();
    }

    /**
     * Builds the list of given filters
     *
     * @return
     */
    private String buildAttributeString()
    {
        StringBuilder sb = new StringBuilder();
        if (variableName != null)
        {
            sb.append(variableName);
        }
        else if (assignedDate != null)
        {
            sb.append("'").append(DateFormatter.format(assignedDate)).append("'");
            getAppliedFilters().put(MomentFilters.amParse, "YYYY-MM-DD HH:mm:ss");
        }
        if (!getAppliedFilters().isEmpty())
        {
            getAppliedFilters().entrySet().stream().forEach((entry)
                    ->
            {
                MomentFilters key = entry.getKey();
                String value = entry.getValue();
                if (value != null)
                {
                    sb.append(" | ").append(key).append(" : '").append(value).append("'");
                }
                else
                {
                    sb.append(" | ").append(key);
                }
            });
        }
        return sb.toString();
    }

    /**
     * The default date formatter which is parsed
     */
    private static final SimpleDateFormat DateFormatter = (SimpleDateFormat) SimpleDateFormat.getInstance();// new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    static
    {
        DateFormatter.applyPattern("yyyy-MM-dd HH:mm:ss");
    }

    /**
     * Parses a custom-formatted date into a moment object that can be used with the am-time-ago directive and the other filters. For example, the following code will accept dates that are formatted
     * like "2015.04.25 22:00:15':
     * <p>
     * am-time-ago="message.time | amParse:'YYYY.MM.DD HH:mm:ss'"
     * <p>
     * Note: To use amParse, install angular-moment version 1.0.0-beta.3 or newer
     *
     * @param parseSyntax
     */
    public void AddParseFilter(String parseSyntax)
    {
        getAppliedFilters().put(MomentFilters.amParse, parseSyntax);
    }

    /**
     * Converts a unix-timestamp (seconds since 1/1/1970) into a moment object. Example:
     * <p>
     * span am-time-ago="message.unixTime | amFromUnix"
     */
    public void AddFromUnixFilter()
    {
        getAppliedFilters().put(MomentFilters.amFromUnix, null);
    }

    /**
     * Create / switch the current moment object into UTC mode. For example, given a date object in message.date, the following code will display the time in UTC instead of the local timezone:
     * <p>
     * {{message.date | amUtc | amDateFormat:'MM.DD.YYYY HH:mm:ss'}}
     */
    public void AddUtc()
    {
        getAppliedFilters().put(MomentFilters.amUtc, null);
    }

    private static final NumberFormat nf = NumberFormat.getInstance();

    static
    {
        nf.setGroupingUsed(false);
        nf.setMaximumFractionDigits(2);
        nf.setMinimumIntegerDigits(2);
    }

    /**
     * Uses the given U offset when displaying a date. For example, the following code will display the date with a UTC + 3 hours time offset:
     * <p>
     * {{message.date | amUtcOffset:'+0300' | amDateFormat:'MM.DD.YYYY HH:mm:ss'}}/span
     *
     * @param timeToChange the time to change, use like 3.0, or 3.30
     */
    public void AddUtcOffsetFilter(double timeToChange)
    {
        String timeSet = "+" + nf.format(timeToChange).replace(".", "");
        getAppliedFilters().put(MomentFilters.amUtcOffset, timeSet);
    }

    /**
     * Changes the given moment object to be in the local timezone. Usually used in conjunction with amUtc / amTimezone for timezone conversion. For example, the following will convert the given UTC
     * date to local time:
     * <p>
     * {{message.date | amUtc | amLocal | amDateFormat:'MM.DD.YYYY HH:mm:ss'}}
     */
    public void AddLocalFilter()
    {
        getAppliedFilters().put(MomentFilters.amLocal, null);
    }

    /**
     * TODO this guy needs to get done https://github.com/urish/angular-moment
     */
    public void AddTimezoneFilter()
    {

    }

    /**
     * Format dates using moment.js format() method. Example:
     * <p>
     * {{message.time | amDateFormat:'dddd, MMMM Do YYYY, h:mm:ss a'}}
     * <p>
     * This snippet will format the given time as "Monday, October 7th 2013, 12:36:29 am".
     *
     * @param dateformat
     */
    public void AddDateFormatFilter(String dateformat)
    {
        getAppliedFilters().put(MomentFilters.amDateeFormat, dateformat);
    }

    /**
     * Format dates using moment.js calendar() method. Example:
     * <p>
     * span&gt;{{message.time | amCalendar:referenceTime:formats}}/span
     * <p>
     * This snippet will format the given time as e.g. "Today 2:30 AM" or "Last Monday 2:30 AM" etc..
     */
    public void AddCalendarFilter()
    {
        getAppliedFilters().put(MomentFilters.amCalendar, "referenceTime:formats");
    }

    /**
     * TODO this guy... ;/ https://github.com/urish/angular-moment
     */
    public void AddDifferenceFilter()
    {
        getAppliedFilters().put(MomentFilters.amDifference, "referenceTime:formats");
    }

    /**
     * Formats a duration (such as 5 days) in a human readable format. See Moment.JS documentation for a list of supported duration formats, and humanize() documentation for explanation about the
     * formatting algorithm.
     * <p>
     * Example:
     * <p>
     * Message age: {{message.ageInMinutes | amDurationFormat : 'minute' }}
     * <p>
     * Will display the age of the message (e.g. 10 minutes, 1 hour, 2 days, etc).
     *
     * @param duration
     */
    public void AddDurationFilter(DurationFilters duration)
    {
        getAppliedFilters().put(MomentFilters.amDurationFormat, duration.toString());
    }

    /**
     * Subtract values (hours, minutes, seconds ...) from a specified date.
     *
     * @param amount
     * @param part
     */
    public void AddSubtractionFilter(int amount, DurationFilters part)
    {
        getAppliedFilters().put(MomentFilters.amSubtract, "" + amount + "' : '" + part.toString() + "");
    }

    /**
     * Adds values (hours, minutes, seconds ...) from a specified date.
     *
     * @param amount
     * @param part
     */
    public void AddAdditionFilter(int amount, DurationFilters part)
    {
        getAppliedFilters().put(MomentFilters.amAdd, "" + amount + "' : '" + part.toString() + "");
    }

    /**
     * The available descernable parts
     */
    public enum DurationFilters
    {
        Years,
        Hours,
        Minutes,
        Days,
        Months,
        Seconds;

        @Override
        public String toString()
        {
            return name().toLowerCase();
        }
    }
}
