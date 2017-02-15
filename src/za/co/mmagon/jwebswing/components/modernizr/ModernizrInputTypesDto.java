/* 
 * Copyright (C) 2017 Marc Magon
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
package za.co.mmagon.jwebswing.components.modernizr;

/**
 * The input type DTO
 *
 * @author GedMarc
 * @since Nov 21, 2016
 * @version 1.0
 *
 */
public class ModernizrInputTypesDto
{

    private Boolean search;
    private Boolean tel;
    private Boolean url;
    private Boolean email;
    private Boolean dateTime;
    private Boolean date;
    private Boolean month;
    private Boolean week;
    private Boolean time;
    private Boolean datetime_local;
    private Boolean number;
    private Boolean range;
    private Boolean collr;

    /**
     * Constructor for the input types
     */
    public ModernizrInputTypesDto()
    {
        //Nothing needed
    }

    /**
     * Returns the search
     *
     * @return
     */
    public Boolean getSearch()
    {
        return search;
    }

    /**
     * Sets the search field
     *
     * @param search
     */
    public void setSearch(Boolean search)
    {
        this.search = search;
    }

    /**
     * Returns the tel number
     *
     * @return
     */
    public Boolean getTel()
    {
        return tel;
    }

    /**
     * Sets the tel number
     *
     * @param tel
     */
    public void setTel(Boolean tel)
    {
        this.tel = tel;
    }

    /**
     * Gets the URL
     *
     * @return
     */
    public Boolean getUrl()
    {
        return url;
    }

    /**
     * Sets the URL
     *
     * @param url
     */
    public void setUrl(Boolean url)
    {
        this.url = url;
    }

    /**
     * Gets the email portion
     *
     * @return
     */
    public Boolean getEmail()
    {
        return email;
    }

    /**
     * Sets the email portion
     *
     * @param email
     */
    public void setEmail(Boolean email)
    {
        this.email = email;
    }

    /**
     * Gets the date time availability
     *
     * @return
     */
    public Boolean getDateTime()
    {
        return dateTime;
    }

    /**
     * Sets the date time field
     *
     * @param dateTime
     */
    public void setDateTime(Boolean dateTime)
    {
        this.dateTime = dateTime;
    }

    /**
     * Gets the date
     *
     * @return
     */
    public Boolean getDate()
    {
        return date;
    }

    /**
     * Sets the date
     *
     * @param date
     */
    public void setDate(Boolean date)
    {
        this.date = date;
    }

    /**
     * Gets the month property
     *
     * @return
     */
    public Boolean getMonth()
    {
        return month;
    }

    /**
     * Sets the month property
     *
     * @param month
     */
    public void setMonth(Boolean month)
    {
        this.month = month;
    }

    /**
     * Gets the week property
     *
     * @return
     */
    public Boolean getWeek()
    {
        return week;
    }

    /**
     * Sets the week property
     *
     * @param week
     */
    public void setWeek(Boolean week)
    {
        this.week = week;
    }

    /**
     * Gets if the time property is supported
     *
     * @return
     */
    public Boolean getTime()
    {
        return time;
    }

    /**
     * Sets if the time property is supported
     *
     * @param time
     */
    public void setTime(Boolean time)
    {
        this.time = time;
    }

    /**
     * Gets if the date time local property is supported
     *
     * @return
     */
    public Boolean getDatetime_local()
    {
        return datetime_local;
    }

    /**
     * Sets if the date time local property is supported
     *
     * @param datetime_local
     */
    public void setDatetime_local(Boolean datetime_local)
    {
        this.datetime_local = datetime_local;
    }

    /**
     * Gets if numbers are supported
     *
     * @return
     */
    public Boolean getNumber()
    {
        return number;
    }

    /**
     * Sets if numbers are supported
     *
     * @param number
     */
    public void setNumber(Boolean number)
    {
        this.number = number;
    }

    /**
     * Gets if the range is available
     *
     * @return
     */
    public Boolean getRange()
    {
        return range;
    }

    /**
     * Sets the range availabity property
     *
     * @param range
     */
    public void setRange(Boolean range)
    {
        this.range = range;
    }

    /**
     * If collr is supported
     *
     * @return
     */
    public Boolean getCollr()
    {
        return collr;
    }

    /**
     * If collr is supported
     *
     * @param collr
     */
    public void setCollr(Boolean collr)
    {
        this.collr = collr;
    }

}
