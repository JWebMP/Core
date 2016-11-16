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
package za.co.mmagon.jwebswing.components.c3.options;

import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 *
 * @author GedMarc
 * @since 09 Mar 2016
 */
public class C3PaddingOptions extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;

    private Integer top;
    private Integer left;
    private Integer right;
    private Integer bottom;

    public C3PaddingOptions()
    {
    }

    /**
     * Returns the padding value
     *
     * @return
     */
    public Integer getTop()
    {
        return top;
    }

    /**
     * Sets the padding value
     *
     * @param top
     */
    public void setTop(Integer top)
    {
        this.top = top;
    }

    /**
     * Returns the padding value
     *
     * @return
     */
    public Integer getLeft()
    {
        return left;
    }

    /**
     * Sets the padding value
     *
     * @param left
     */
    public void setLeft(Integer left)
    {
        this.left = left;
    }

    /**
     * Returns the padding value
     *
     * @return
     */
    public Integer getRight()
    {
        return right;
    }

    /**
     * Sets the padding value
     *
     * @param right
     */
    public void setRight(Integer right)
    {
        this.right = right;
    }

    /**
     * Returns the padding value
     *
     * @return
     */
    public Integer getBottom()
    {
        return bottom;
    }

    /**
     * Sets the padding value
     *
     * @param bottom
     */
    public void setBottom(Integer bottom)
    {
        this.bottom = bottom;
    }

}
