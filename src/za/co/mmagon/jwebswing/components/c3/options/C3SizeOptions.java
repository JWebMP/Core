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
package za.co.mmagon.jwebswing.components.c3.options;

import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * All the options for the tooltip library
 * <p>
 * @author GedMarc
 * @since Mar 9, 2016
 * @version 1.0
 * <p>
 * <p>
 */
public class C3SizeOptions extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;

    private Integer width;
    private Integer height;

    public C3SizeOptions()
    {
    }

    /**
     * The desired width of the chart element.
     * <p>
     * If this option is not specified, the width of the chart will be calculated by the size of the parent element it's appended to.
     *
     * @return
     */
    public Integer getWidth()
    {
        return width;
    }

    /**
     * The desired width of the chart element.
     * <p>
     * If this option is not specified, the width of the chart will be calculated by the size of the parent element it's appended to.
     *
     * @param width
     */
    public void setWidth(Integer width)
    {
        this.width = width;
    }

    /**
     * The desired height of the chart element.
     * <p>
     * If this option is not specified, the height of the chart will be calculated by the size of the parent element it's appended to.
     *
     * @return
     */
    public Integer getHeight()
    {
        return height;
    }

    /**
     * The desired height of the chart element.
     * <p>
     * If this option is not specified, the height of the chart will be calculated by the size of the parent element it's appended to.
     *
     * @param height
     */
    public void setHeight(Integer height)
    {
        this.height = height;
    }

}
