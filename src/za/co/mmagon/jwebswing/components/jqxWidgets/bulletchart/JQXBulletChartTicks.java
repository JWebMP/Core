/*
 * Copyright (C) 2015 MXM3727
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
package za.co.mmagon.jwebswing.components.jqxWidgets.bulletchart;

import za.co.mmagon.jwebswing.components.jqueryUI.position.Position;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 *
 * @author MXM3727
 */
public class JQXBulletChartTicks extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;

    public JQXBulletChartTicks(Position position, Integer interval, Integer size)
    {
        this.position = position;
        this.interval = interval;
        this.size = size;
    }

    public JQXBulletChartTicks()
    {
    }

    private Position position;
    private Integer interval;
    private Integer size;

    public Position getPosition()
    {
        return position;
    }

    public void setPosition(Position position)
    {
        this.position = position;
    }

    public Integer getInterval()
    {
        return interval;
    }

    public void setInterval(Integer interval)
    {
        this.interval = interval;
    }

    public Integer getSize()
    {
        return size;
    }

    public void setSize(Integer size)
    {
        this.size = size;
    }

}
