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
package za.co.mmagon.jwebswing.components.jqxWidgets.textarea;

import java.util.ArrayList;
import za.co.mmagon.jwebswing.components.jqxWidgets.JQXDefaultJavaScriptPart;
import za.co.mmagon.jwebswing.components.jqxWidgets.JQXSearchModes;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptFunction;

/**
 * All the options for the tooltip library
 * <p>
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXTextAreaOptions extends JQXDefaultJavaScriptPart
{

    private Boolean disabled;// 	Boolean 	false
    private String displayMember;// 	String 	''
    private Integer dropDownWidth;// 	Number/String 	null
    private Integer items;// 	Number 	8
    private Integer maxLength;// 	Number 	null
    private Integer minLength;// 	Number 	1
    private Integer opened;// 	Boolean 	false
    private String placeHolder;// 	String 	''
    private Integer popupZIndex;// 	Number 	20000
    private String query;// 	String 	''
    private JavascriptFunction renderer;// 	function 	null
    private Boolean roundedCorners;// 	Boolean 	true
    private Boolean rtl;// 	Boolean 	false
    private Integer scrollBarSize;// 	Number 	15
    private JQXSearchModes searchMode;// 	String 	'default'
    private ArrayList<String> source;// 	Array, function 	[]
    private String valueMember;// 	String 	''

    public JQXTextAreaOptions()
    {

    }

    public Boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    public String getDisplayMember()
    {
        return displayMember;
    }

    public void setDisplayMember(String displayMember)
    {
        this.displayMember = displayMember;
    }

    public Integer getDropDownWidth()
    {
        return dropDownWidth;
    }

    public void setDropDownWidth(Integer dropDownWidth)
    {
        this.dropDownWidth = dropDownWidth;
    }

    public Integer getItems()
    {
        return items;
    }

    public void setItems(Integer items)
    {
        this.items = items;
    }

    public Integer getMaxLength()
    {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength)
    {
        this.maxLength = maxLength;
    }

    public Integer getMinLength()
    {
        return minLength;
    }

    public void setMinLength(Integer minLength)
    {
        this.minLength = minLength;
    }

    public Integer getOpened()
    {
        return opened;
    }

    public void setOpened(Integer opened)
    {
        this.opened = opened;
    }

    public String getPlaceHolder()
    {
        return placeHolder;
    }

    public void setPlaceHolder(String placeHolder)
    {
        this.placeHolder = placeHolder;
    }

    public Integer getPopupZIndex()
    {
        return popupZIndex;
    }

    public void setPopupZIndex(Integer popupZIndex)
    {
        this.popupZIndex = popupZIndex;
    }

    public String getQuery()
    {
        return query;
    }

    public void setQuery(String query)
    {
        this.query = query;
    }

    public JavascriptFunction getRenderer()
    {
        return renderer;
    }

    public void setRenderer(JavascriptFunction renderer)
    {
        this.renderer = renderer;
    }

    public Boolean getRoundedCorners()
    {
        return roundedCorners;
    }

    public void setRoundedCorners(Boolean roundedCorners)
    {
        this.roundedCorners = roundedCorners;
    }

    public Boolean getRtl()
    {
        return rtl;
    }

    public void setRtl(Boolean rtl)
    {
        this.rtl = rtl;
    }

    public Integer getScrollBarSize()
    {
        return scrollBarSize;
    }

    public void setScrollBarSize(Integer scrollBarSize)
    {
        this.scrollBarSize = scrollBarSize;
    }

    public JQXSearchModes getSearchMode()
    {
        return searchMode;
    }

    public void setSearchMode(JQXSearchModes searchMode)
    {
        this.searchMode = searchMode;
    }

    public ArrayList<String> getSource()
    {
        return source;
    }

    public void setSource(ArrayList<String> source)
    {
        this.source = source;
    }

    public String getValueMember()
    {
        return valueMember;
    }

    public void setValueMember(String valueMember)
    {
        this.valueMember = valueMember;
    }

}
