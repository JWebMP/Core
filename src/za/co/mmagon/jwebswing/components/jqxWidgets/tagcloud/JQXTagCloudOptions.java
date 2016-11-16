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
package za.co.mmagon.jwebswing.components.jqxWidgets.tagcloud;

import za.co.mmagon.jwebswing.components.jqxWidgets.JQXDefaultJavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourHex;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementTypes;
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
public class JQXTagCloudOptions extends JQXDefaultJavaScriptPart
{

    private String alterTextCase;// 	String 	'none'
    private Boolean autoBind;// 	Boolean 	true
    private Boolean disabled;// 	Boolean 	false
    private Boolean displayLimit;// 	Integer 	null
    private String displayMember;// 	String 	'label'
    private Boolean displayValue;// 	Boolean 	false
    private MeasurementTypes fontSizeUnit;// 	String 	'px'

    private ColourHex maxColor;// 	Color String 	null
    private Integer maxFontSize;// 	Integer 	24
    private Integer maxValueToDisplay;// 	Integer 	0
    private ColourHex minColor;// 	Color String 	null
    private Integer minFontSize;// 	Integer 	10
    private Integer minValueToDisplay;// 	Integer 	0
    private Boolean rtl;// 	Boolean 	false
    private String sortBy;// 	String 	'none'
    private JQXSortOrders sortOrder;// 	String 	'ascending'
//source 	Object 	{}
    private JavascriptFunction tagRenderer;// 	function 	null
    private Boolean takeTopWeightedItems;// 	Boolean 	false
    private ColourHex textColor;// 	Color String 	null
    private String urlBase;// 	String 	''
    private String urlMember;// 	String 	'url'
    private String valueMember;// 	String 	'value'

    public JQXTagCloudOptions()
    {

    }

    public String getAlterTextCase()
    {
        return alterTextCase;
    }

    public void setAlterTextCase(String alterTextCase)
    {
        this.alterTextCase = alterTextCase;
    }

    public Boolean getAutoBind()
    {
        return autoBind;
    }

    public void setAutoBind(Boolean autoBind)
    {
        this.autoBind = autoBind;
    }

    public Boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    public Boolean getDisplayLimit()
    {
        return displayLimit;
    }

    public void setDisplayLimit(Boolean displayLimit)
    {
        this.displayLimit = displayLimit;
    }

    public String getDisplayMember()
    {
        return displayMember;
    }

    public void setDisplayMember(String displayMember)
    {
        this.displayMember = displayMember;
    }

    public Boolean getDisplayValue()
    {
        return displayValue;
    }

    public void setDisplayValue(Boolean displayValue)
    {
        this.displayValue = displayValue;
    }

    public MeasurementTypes getFontSizeUnit()
    {
        return fontSizeUnit;
    }

    public void setFontSizeUnit(MeasurementTypes fontSizeUnit)
    {
        this.fontSizeUnit = fontSizeUnit;
    }

    public ColourHex getMaxColor()
    {
        return maxColor;
    }

    public void setMaxColor(ColourHex maxColor)
    {
        this.maxColor = maxColor;
    }

    public Integer getMaxFontSize()
    {
        return maxFontSize;
    }

    public void setMaxFontSize(Integer maxFontSize)
    {
        this.maxFontSize = maxFontSize;
    }

    public Integer getMaxValueToDisplay()
    {
        return maxValueToDisplay;
    }

    public void setMaxValueToDisplay(Integer maxValueToDisplay)
    {
        this.maxValueToDisplay = maxValueToDisplay;
    }

    public ColourHex getMinColor()
    {
        return minColor;
    }

    public void setMinColor(ColourHex minColor)
    {
        this.minColor = minColor;
    }

    public Integer getMinFontSize()
    {
        return minFontSize;
    }

    public void setMinFontSize(Integer minFontSize)
    {
        this.minFontSize = minFontSize;
    }

    public Integer getMinValueToDisplay()
    {
        return minValueToDisplay;
    }

    public void setMinValueToDisplay(Integer minValueToDisplay)
    {
        this.minValueToDisplay = minValueToDisplay;
    }

    public Boolean getRtl()
    {
        return rtl;
    }

    public void setRtl(Boolean rtl)
    {
        this.rtl = rtl;
    }

    public String getSortBy()
    {
        return sortBy;
    }

    public void setSortBy(String sortBy)
    {
        this.sortBy = sortBy;
    }

    public JQXSortOrders getSortOrder()
    {
        return sortOrder;
    }

    public void setSortOrder(JQXSortOrders sortOrder)
    {
        this.sortOrder = sortOrder;
    }

    public JavascriptFunction getTagRenderer()
    {
        return tagRenderer;
    }

    public void setTagRenderer(JavascriptFunction tagRenderer)
    {
        this.tagRenderer = tagRenderer;
    }

    public Boolean getTakeTopWeightedItems()
    {
        return takeTopWeightedItems;
    }

    public void setTakeTopWeightedItems(Boolean takeTopWeightedItems)
    {
        this.takeTopWeightedItems = takeTopWeightedItems;
    }

    public ColourHex getTextColor()
    {
        return textColor;
    }

    public void setTextColor(ColourHex textColor)
    {
        this.textColor = textColor;
    }

    public String getUrlBase()
    {
        return urlBase;
    }

    public void setUrlBase(String urlBase)
    {
        this.urlBase = urlBase;
    }

    public String getUrlMember()
    {
        return urlMember;
    }

    public void setUrlMember(String urlMember)
    {
        this.urlMember = urlMember;
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
