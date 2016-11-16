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
package za.co.mmagon.jwebswing.components.jqxWidgets.input;

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
public class JQXInputOptions extends JQXDefaultJavaScriptPart
{

    private static final long serialVersionUID = 1L;

    private Boolean disabled;// 	Boolean 	false
    private Integer dropDownWidth;// 	Number/String 	null
    private String displayMember;// 	String 	""
    private Integer items;// 	Number 	8
    private Integer minLength;// 	Number 	1
    private Integer maxLength;// 	Number 	null
    private Boolean opened;// 	Boolean 	false
    private String placeHolder;// 	String 	""
    private Integer popupZIndex;// 	Number 	20000
    private String query;// 	String 	""
    private JavascriptFunction renderer;// 	function 	null
    private Boolean rtl;// 	Boolean 	false
    private JQXSearchModes searchMode;// 	String 	'default'
    private ArrayList<String> source;// 	Array, function 	[]
    private String valueMember;// 	String 	""

    public JQXInputOptions()
    {

    }

    /**
     * Set the disabled property.
     *
     * @return
     */
    public Boolean getDisabled()
    {
        return disabled;
    }

    /**
     * Set the disabled property.
     *
     * @param disabled
     */
    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    /**
     * Sets or gets the jqxInput's dropDown width
     *
     * @return
     */
    public Integer getDropDownWidth()
    {
        return dropDownWidth;
    }

    /**
     * Sets or gets the jqxInput's dropDown width
     *
     * @param dropDownWidth
     */
    public void setDropDownWidth(Integer dropDownWidth)
    {
        this.dropDownWidth = dropDownWidth;
    }

    /**
     * Sets or gets the displayMember of the Items. The displayMember specifies the name of an object property to display. The name is contained in the collection specified by the 'source' property.
     *
     * @return
     */
    public String getDisplayMember()
    {
        return displayMember;
    }

    /**
     * Sets or gets the displayMember of the Items. The displayMember specifies the name of an object property to display. The name is contained in the collection specified by the 'source' property.
     *
     * @param displayMember
     */
    public void setDisplayMember(String displayMember)
    {
        this.displayMember = displayMember;
    }

    /**
     * Sets or gets the maximum number of items to display in the popup menu.
     *
     * @return
     */
    public Integer getItems()
    {
        return items;
    }

    /**
     * Sets or gets the maximum number of items to display in the popup menu.
     *
     * @param items
     */
    public void setItems(Integer items)
    {
        this.items = items;
    }

    /**
     * Sets or gets the minimum character length needed before triggering auto-complete suggestions.
     *
     * @return
     */
    public Integer getMinLength()
    {
        return minLength;
    }

    /**
     * Sets or gets the minimum character length needed before triggering auto-complete suggestions.
     *
     * @param minLength
     */
    public void setMinLength(Integer minLength)
    {
        this.minLength = minLength;
    }

    /**
     * Sets or gets the maximum character length needed before triggering auto-complete suggestions.
     *
     * @return
     */
    public Integer getMaxLength()
    {
        return maxLength;
    }

    /**
     * Sets or gets the maximum character length needed before triggering auto-complete suggestions.
     *
     * @param maxLength
     */
    public void setMaxLength(Integer maxLength)
    {
        this.maxLength = maxLength;
    }

    /**
     * Sets or gets a value indicating whether the auto-suggest popup is opened.
     *
     * @return
     */
    public Boolean getOpened()
    {
        return opened;
    }

    /**
     * Sets or gets a value indicating whether the auto-suggest popup is opened.
     *
     * @param opened
     */
    public void setOpened(Boolean opened)
    {
        this.opened = opened;
    }

    /**
     * Sets or gets the input's place holder.
     *
     * @return
     */
    public String getPlaceHolder()
    {
        return placeHolder;
    }

    /**
     * Sets or gets the input's place holder.
     *
     * @param placeHolder
     */
    public void setPlaceHolder(String placeHolder)
    {
        this.placeHolder = placeHolder;
    }

    /**
     * Sets or gets the auto-suggest popup's z-index.
     *
     * @return
     */
    public Integer getPopupZIndex()
    {
        return popupZIndex;
    }

    /**
     * Sets or gets the auto-suggest popup's z-index.
     *
     * @param popupZIndex
     */
    public void setPopupZIndex(Integer popupZIndex)
    {
        this.popupZIndex = popupZIndex;
    }

    /**
     * Determines the input's query.
     *
     * @return
     */
    public String getQuery()
    {
        return query;
    }

    /**
     * Determines the input's query.
     *
     * @param query
     */
    public void setQuery(String query)
    {
        this.query = query;
    }

    /**
     * Enables you to update the input's value, after a selection from the auto-complete popup.
     *
     * @return
     */
    public JavascriptFunction getRenderer()
    {
        return renderer;
    }

    /**
     * Enables you to update the input's value, after a selection from the auto-complete popup.
     *
     * @param renderer
     */
    public void setRenderer(JavascriptFunction renderer)
    {
        this.renderer = renderer;
    }

    /**
     * Sets or gets a value indicating whether widget's elements are aligned to support locales using right-to-left fonts.
     *
     * @return
     */
    public Boolean getRtl()
    {
        return rtl;
    }

    /**
     * Sets or gets a value indicating whether widget's elements are aligned to support locales using right-to-left fonts.
     *
     * @param rtl
     */
    public void setRtl(Boolean rtl)
    {
        this.rtl = rtl;
    }

    /**
     * Sets or gets the search mode. When the user types into the edit field, the jqxInput widget tries to find the searched item using the entered text and the selected search mode.
     * Possible Values:
     * <p>
     * 'none'
     * <p>
     * 'contains'
     * <p>
     * 'containsignorecase'
     * <p>
     * 'equals'
     * <p>
     * 'equalsignorecase'
     * <p>
     * 'startswithignorecase'
     * <p>
     * 'startswith'
     * <p>
     * 'endswithignorecase'
     * <p>
     * 'endswith'
     *
     * @return
     */
    public JQXSearchModes getSearchMode()
    {
        return searchMode;
    }

    /**
     * Sets or gets the search mode. When the user types into the edit field, the jqxInput widget tries to find the searched item using the entered text and the selected search mode.
     * Possible Values:
     * <p>
     * 'none'
     * <p>
     * 'contains'
     * <p>
     * 'containsignorecase'
     * <p>
     * 'equals'
     * <p>
     * 'equalsignorecase'
     * <p>
     * 'startswithignorecase'
     * <p>
     * 'startswith'
     * <p>
     * 'endswithignorecase'
     * <p>
     * 'endswith'
     *
     * @param searchMode
     */
    public void setSearchMode(JQXSearchModes searchMode)
    {
        this.searchMode = searchMode;
    }

    /**
     * Sets the widget's data source. The 'source' function is passed two arguments, the input field's value and a callback function.
     * <p>
     * The 'source' function may be used synchronously by returning an
     * array of items or asynchronously via the callback.
     *
     * @return
     */
    public ArrayList<String> getSource()
    {
        if (source == null)
        {
            source = new ArrayList<>();
        }
        return source;
    }

    /**
     * Sets the widget's data source. The 'source' function is passed two arguments, the input field's value and a callback function. The 'source' function may be used synchronously by returning an
     * array of items or asynchronously via the callback.
     *
     * @param source
     */
    public void setSource(ArrayList<String> source)
    {
        this.source = source;
    }

    /**
     * Sets or gets the valueMember of the Items. The valueMember specifies the name of an object property to set as a 'value' of the list items. The name is contained in the collection specified by
     * the 'source' property.
     *
     * @return
     */
    public String getValueMember()
    {
        return valueMember;
    }

    /**
     * Sets or gets the valueMember of the Items. The valueMember specifies the name of an object property to set as a 'value' of the list items. The name is contained in the collection specified by
     * the 'source' property.
     *
     * @param valueMember
     */
    public void setValueMember(String valueMember)
    {
        this.valueMember = valueMember;
    }

}
