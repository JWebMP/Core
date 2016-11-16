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
package za.co.mmagon.jwebswing.components.jqxWidgets.rangeselector;

import java.text.SimpleDateFormat;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * This Class
 *
 * @author GedMarc
 * @since 24 Dec 2015
 */
public class JQXRanges extends JavaScriptPart
{

    public JQXRanges(String from, String to)
    {
        this.from = from;
        this.to = to;
    }

    private String from;
    private String to;

    @Override
    public String toString()
    {
        return super.toString();
    }

    public String getFrom()
    {
        return from;
    }

    public void setFrom(String from)
    {
        this.from = from;
    }

    public String getTo()
    {
        return to;
    }

    public void setTo(String to)
    {
        this.to = to;
    }

    public void setFrom(Integer from)
    {
        this.from = from.toString();
    }

    public void setTo(Integer to)
    {
        this.to = to.toString();
    }

    public void setFrom(SimpleDateFormat from)
    {
        this.from = from.toPattern();
    }

    public void setTo(SimpleDateFormat to)
    {
        this.to = to.toPattern();
    }

}
