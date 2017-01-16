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
package za.co.mmagon.jwebswing.components.bootstrap.themes.sbadmin2;

import java.util.Date;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * A standard message display format from SB2 Admin Theme
 *
 * @author GedMarc
 * @since Oct 4, 2016
 * @version 1.0
 *
 */
public class SB2DropDownAlert extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;
    /**
     * The icon in bold
     */
    private String icon;
    /**
     * The message to display
     */
    private String message;

    /**
     * Any particular URL to point to
     */
    private String url;
    /**
     * Any applicable data field
     */
    private String data;
    /**
     * The moment date to use
     */
    private Date date;

    /**
     * Constructs a new standardized drop down message
     */
    public SB2DropDownAlert()
    {

    }

    /**
     * With just a icon
     *
     * @param icon
     */
    public SB2DropDownAlert(String icon)
    {
        this.icon = icon;
    }

    /**
     * A new drop down message item
     *
     * @param icon
     * @param message
     * @param dateFormat
     */
    public SB2DropDownAlert(String icon, String message, Date dateFormat)
    {
        this.icon = icon;
        this.message = message;
    }

    /**
     * The physical Bold component (text is in getText(
     *
     * @return
     */
    public String getIcon()
    {
        return icon;
    }

    /**
     * Sets the icon
     *
     * @param icon
     */
    public void setIcon(String icon)
    {
        this.icon = icon;
    }

    /**
     * Gets the current message
     *
     * @return
     */
    public String getMessage()
    {
        return message;
    }

    /**
     * Sets the current message
     *
     * @param message
     */
    public void setMessage(String message)
    {
        this.message = message;
    }

    /**
     * Any linking URL
     *
     * @return
     */
    public String getUrl()
    {
        return url;
    }

    /**
     * Sets the URL to go to
     *
     * @param url
     */
    public void setUrl(String url)
    {
        this.url = url;
    }

    /**
     * Any data that needs to be stored
     *
     * @return
     */
    public String getData()
    {
        return data;
    }

    /**
     * Any data that needs to be stored
     *
     * @param data
     */
    public void setData(String data)
    {
        this.data = data;
    }

    /**
     * Gets the date
     *
     * @return
     */
    public Date getDate()
    {
        return date;
    }

    /**
     * Sets the date
     *
     * @param date
     */
    public void setDate(Date date)
    {
        this.date = date;
    }

}
