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
package za.co.mmagon.jwebswing.components.jqxWidgets.popover;

import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * This Class
 *
 * @author GedMarc
 * @since 24 Dec 2015
 */
public class JQXPopOverOffset extends JavaScriptPart
{

    private Integer left;
    private Integer right;
    private Integer bottom;
    private Integer top;

    public JQXPopOverOffset()
    {
    }

    public Integer getLeft()
    {
        return left;
    }

    public void setLeft(Integer left)
    {
        this.left = left;
    }

    public Integer getRight()
    {
        return right;
    }

    public void setRight(Integer right)
    {
        this.right = right;
    }

    public Integer getBottom()
    {
        return bottom;
    }

    public void setBottom(Integer bottom)
    {
        this.bottom = bottom;
    }

    public Integer getTop()
    {
        return top;
    }

    public void setTop(Integer top)
    {
        this.top = top;
    }

}
