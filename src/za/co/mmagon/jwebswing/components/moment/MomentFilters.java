/*
 * Copyright (C) 2016 GedMarc
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

/**
 * All the available filters for a moment display
 *
 * @author GedMarc
 * @since Oct 5, 2016
 *
 */
public enum MomentFilters
{
    /**
     * Parses a custom-formatted date into a moment object that can be used with the am-time-ago directive and the other filters. For example, the following code will accept dates that are formatted
     * like "2015.04.25 22:00:15':
     *//**
     * Parses a custom-formatted date into a moment object that can be used with the am-time-ago directive and the other filters. For example, the following code will accept dates that are formatted
     * like "2015.04.25 22:00:15':
     */
    amParse,
    /**
     * Converts a unix-timestamp (seconds since 1/1/1970) into a moment object. Example:
     */
    amFromUnix,
    /**
     * Create / switch the current moment object into UTC mode. For example, given a date object in message.date, the following code will display the time in UTC instead of the local timezone:
     */
    amUtc,
    /**
     * Uses the given UTC offset when displaying a date. For example, the following code will display the date with a UTC + 3 hours time offset:
     */
    amUtcOffset,
    /**
     * Changes the given moment object to be in the local timezone. Usually used in conjunction with amUtc / amTimezone for timezone conversion. For example, the following will convert the given UTC
     * date to local time:
     */
    amLocal,
    /**
     * Applies a timezone to the given date / moment object. You need to include moment-timezone.js in your project and load timezone data in order to use this filter. The following example displays
     * the time in Israel's timezone:
     */
    amTimezone,
    /**
     * Format dates using moment.js format() method. Example:
     */
    amDateeFormat,
    /**
     * Format dates using moment.js calendar() method. Example:
     *
     * &lt;span&gt;{{message.time | amCalendar:referenceTime:formats}}&lt;/span&gt;
     *
     * This snippet will format the given time as e.g. "Today 2:30 AM" or "Last Monday 2:30 AM" etc..
     */
    amCalendar,
    /**
     * Get the difference between two dates in milliseconds. Parameters are date, units and usePrecision. Date defaults to current date. Example:
     *
     * &lt;span&gt;Scheduled {{message.createdAt | amDifference : null : 'days' }} days from now&lt;/span&gt;
     *
     * This snippet will return the number of days between the current date and the date filtered.
     */
    amDifference,
    /**
     * Formats a duration (such as 5 days) in a human readable format. See Moment.JS documentation for a list of supported duration formats, and humanize() documentation for explanation about the
     * formatting algorithm.
     *
     * Example:
     *
     * &lt;span&gt;Message age: {{message.ageInMinutes | amDurationFormat : 'minute' }}&lt;/span&gt;
     *
     * Will display the age of the message (e.g. 10 minutes, 1 hour, 2 days, etc).
     */
    amDurationFormat,
    /**
     * Subtract values (hours, minutes, seconds ...) from a specified date.
     */
    amSubtract,
    /**
     * Add values (hours, minutes, seconds ...) to a specified date.
     *
     * See Moment.JS documentation for a list of supported duration formats.
     *
     * Example:
     *
     * &lt;span&gt;Start time: {{day.start | amAdd : '1' : 'hours' | amDateFormat : 'hh'}} : {{day.start | amAdd : '30' : 'minutes' | amDateFormat : 'mm'}}&lt;/span&gt;
     *
     */
    amAdd,
    /**
     * Mutates the original moment by setting it to the start of a unit(minute, hour, day..) of time.
     */
    amStartOf,
    /**
     * Mutates the original moment by setting it to the end of a unit(minute, hour, day..) of time.
     */
    amEndOf;

    private MomentFilters()
    {

    }
}
