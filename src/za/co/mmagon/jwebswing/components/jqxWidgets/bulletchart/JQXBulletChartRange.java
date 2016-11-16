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
package za.co.mmagon.jwebswing.components.jqxWidgets.bulletchart;

import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourHex;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 *
 * @author GedMarc
 */
public class JQXBulletChartRange extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;

    private Double startValue;
    private Double endValue;
    private ColourHex color;
    private Double opacity;

    public Double getStartValue()
    {
        return startValue;
    }

    public void setStartValue(Double startValue)
    {
        this.startValue = startValue;
    }

    public Double getEndValue()
    {
        return endValue;
    }

    public void setEndValue(Double endValue)
    {
        this.endValue = endValue;
    }

    public ColourHex getColor()
    {
        return color;
    }

    public void setColor(ColourHex color)
    {
        this.color = color;
    }

    public Double getOpacity()
    {
        return opacity;
    }

    public void setOpacity(Double opacity)
    {
        this.opacity = opacity;
    }

}
