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
public class SB2DropDownTask extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;
    /**
     * The name in bold
     */
    private String name;
    /**
     * The message to display
     */
    private String message;

    /**
     * The percentage
     */
    private double percentage;
    /**
     * Any particular URL to point to
     */
    private String url;
    /**
     * Any applicable data field
     */
    private String data;

    /**
     * Constructs a new standardized drop down message
     */
    public SB2DropDownTask()
    {

    }

    /**
     * With just a name
     *
     * @param name
     */
    public SB2DropDownTask(String name)
    {
        this.name = name;
    }

    /**
     * A new drop down message item
     *
     * @param name
     * @param message
     * @param dateFormat
     */
    public SB2DropDownTask(String name, String message, Date dateFormat)
    {
        this.name = name;
        this.message = message;
    }

    /**
     * Returns the given percentage for this guy
     *
     * @return
     */
    public double getPercentage()
    {
        return percentage;
    }

    /**
     * Sets a given percentage for this guy
     *
     * @param percentage
     */
    public void setPercentage(double percentage)
    {
        this.percentage = percentage;
    }

    /**
     * The physical Bold component (text is in getText(
     *
     * @return
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name
     *
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
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
}
