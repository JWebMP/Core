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
package za.co.mmagon.jwebswing.components.jqxwidgets.bulletchart;

import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourHex;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 *
 * @author mmagon
 */
public class JQXBulletChartPointer extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;

    public JQXBulletChartPointer(Double value, String label, Integer thickness)
    {
        this.value = value;
        this.label = label;
        this.thickness = thickness;
    }

    public JQXBulletChartPointer(Double value, ColourHex color)
    {
        this.value = value;
        this.color = color;
    }

    public JQXBulletChartPointer(Double value, String label, ColourHex color)
    {
        this.value = value;
        this.label = label;
        this.color = color;
    }

    private Double value;
    private String label;
    private Integer thickness;
    private ColourHex color;

    public JQXBulletChartPointer()
    {
    }

    public Double getValue()
    {
        return value;
    }

    public void setValue(Double value)
    {
        this.value = value;
    }

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    public Integer getThickness()
    {
        return thickness;
    }

    public void setThickness(Integer thickness)
    {
        this.thickness = thickness;
    }

    public ColourHex getColor()
    {
        return color;
    }

    public void setColor(ColourHex color)
    {
        this.color = color;
    }

}
