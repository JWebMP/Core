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
package za.co.mmagon.jwebswing.components.jqxWidgets.listmenu;

import za.co.mmagon.jwebswing.components.jqxWidgets.JQXDefaultJavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.effects.EasingEffects;

/**
 * All the options for the List Menu
 * jqxListMenu displays a collection of Unordered and Ordered Lists. By nesting child ul or ol inside list items, you can create nested lists.
 * <p>
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXListMenuOptions extends JQXDefaultJavaScriptPart
{

    private Boolean alwaysShowNavigationArrows;// 	Boolean 	false
    private EasingEffects animationType;// 	String 	"slide"
    private Integer animationDuration;// 	Number 	250
    private Boolean autoSeparators;// 	Boolean 	false
    private String backLabel;// 	String 	"Back"
    private Boolean disabled;// 	Boolean 	false
    private Boolean enableScrolling;// 	Boolean 	true
    private Boolean filterCallback;// 	Function 	function (text, searchValue){return text.toString().toLowerCase().indexOf(searchValue.toLowerCase()) >= 0;};
    private Integer headerAnimationDuration;// 	Number 	0
    private String placeHolder;// 	String 	'Filter list items...'
    private Boolean readOnly;// 	Boolean 	false
    private Boolean rtl;// 	Boolean 	false
    private Boolean roundedCorners;// 	Boolean 	true
    private Boolean showNavigationArrows;// 	Boolean 	true
    private Boolean showFilter;// 	Boolean 	false
    private Boolean showHeader;// 	Boolean 	true
    private Boolean showBackButton;// 	Boolean 	true

    public JQXListMenuOptions()
    {

    }

    public Boolean getAlwaysShowNavigationArrows()
    {
        return alwaysShowNavigationArrows;
    }

    public void setAlwaysShowNavigationArrows(Boolean alwaysShowNavigationArrows)
    {
        this.alwaysShowNavigationArrows = alwaysShowNavigationArrows;
    }

    public EasingEffects getAnimationType()
    {
        return animationType;
    }

    public void setAnimationType(EasingEffects animationType)
    {
        this.animationType = animationType;
    }

    public Integer getAnimationDuration()
    {
        return animationDuration;
    }

    public void setAnimationDuration(Integer animationDuration)
    {
        this.animationDuration = animationDuration;
    }

    public Boolean getAutoSeparators()
    {
        return autoSeparators;
    }

    public void setAutoSeparators(Boolean autoSeparators)
    {
        this.autoSeparators = autoSeparators;
    }

    public String getBackLabel()
    {
        return backLabel;
    }

    public void setBackLabel(String backLabel)
    {
        this.backLabel = backLabel;
    }

    public Boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    public Boolean getEnableScrolling()
    {
        return enableScrolling;
    }

    public void setEnableScrolling(Boolean enableScrolling)
    {
        this.enableScrolling = enableScrolling;
    }

    public Boolean getFilterCallback()
    {
        return filterCallback;
    }

    public void setFilterCallback(Boolean filterCallback)
    {
        this.filterCallback = filterCallback;
    }

    public Integer getHeaderAnimationDuration()
    {
        return headerAnimationDuration;
    }

    public void setHeaderAnimationDuration(Integer headerAnimationDuration)
    {
        this.headerAnimationDuration = headerAnimationDuration;
    }

    public String getPlaceHolder()
    {
        return placeHolder;
    }

    public void setPlaceHolder(String placeHolder)
    {
        this.placeHolder = placeHolder;
    }

    public Boolean getReadOnly()
    {
        return readOnly;
    }

    public void setReadOnly(Boolean readOnly)
    {
        this.readOnly = readOnly;
    }

    public Boolean getRtl()
    {
        return rtl;
    }

    public void setRtl(Boolean rtl)
    {
        this.rtl = rtl;
    }

    public Boolean getRoundedCorners()
    {
        return roundedCorners;
    }

    public void setRoundedCorners(Boolean roundedCorners)
    {
        this.roundedCorners = roundedCorners;
    }

    public Boolean getShowNavigationArrows()
    {
        return showNavigationArrows;
    }

    public void setShowNavigationArrows(Boolean showNavigationArrows)
    {
        this.showNavigationArrows = showNavigationArrows;
    }

    public Boolean getShowFilter()
    {
        return showFilter;
    }

    public void setShowFilter(Boolean showFilter)
    {
        this.showFilter = showFilter;
    }

    public Boolean getShowHeader()
    {
        return showHeader;
    }

    public void setShowHeader(Boolean showHeader)
    {
        this.showHeader = showHeader;
    }

    public Boolean getShowBackButton()
    {
        return showBackButton;
    }

    public void setShowBackButton(Boolean showBackButton)
    {
        this.showBackButton = showBackButton;
    }

}
