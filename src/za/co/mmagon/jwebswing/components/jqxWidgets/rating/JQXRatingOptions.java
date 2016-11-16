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
package za.co.mmagon.jwebswing.components.jqxWidgets.rating;

import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * All the options for the tooltip library
 * <p>
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXRatingOptions extends JavaScriptPart
{

    private Integer count;// 	Number 	5
    private Boolean disabled;// 	Boolean 	false
    private Integer height;// 	Number/String 	auto
    private Integer itemHeight;// 	Number 	auto
    private Integer itemWidth;// 	Number 	auto
    private Double precision;// 	Number 	1
    private Boolean singleVote;// 	Boolean 	false
    private Integer value;// 	Number 	0
    private Integer width;// 	Number/String 	auto

    public JQXRatingOptions()
    {

    }

    public Integer getCount()
    {
        return count;
    }

    public void setCount(Integer count)
    {
        this.count = count;
    }

    public Boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    public Integer getHeight()
    {
        return height;
    }

    public void setHeight(Integer height)
    {
        this.height = height;
    }

    public Integer getItemHeight()
    {
        return itemHeight;
    }

    public void setItemHeight(Integer itemHeight)
    {
        this.itemHeight = itemHeight;
    }

    public Integer getItemWidth()
    {
        return itemWidth;
    }

    public void setItemWidth(Integer itemWidth)
    {
        this.itemWidth = itemWidth;
    }

    public Double getPrecision()
    {
        return precision;
    }

    public void setPrecision(Double precision)
    {
        this.precision = precision;
    }

    public Boolean getSingleVote()
    {
        return singleVote;
    }

    public void setSingleVote(Boolean singleVote)
    {
        this.singleVote = singleVote;
    }

    public Integer getValue()
    {
        return value;
    }

    public void setValue(Integer value)
    {
        this.value = value;
    }

    public Integer getWidth()
    {
        return width;
    }

    public void setWidth(Integer width)
    {
        this.width = width;
    }

}
