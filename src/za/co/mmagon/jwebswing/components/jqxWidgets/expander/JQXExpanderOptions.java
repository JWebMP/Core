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
package za.co.mmagon.jwebswing.components.jqxWidgets.expander;

import za.co.mmagon.jwebswing.components.jqxWidgets.JQXDefaultJavaScriptPart;
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
public class JQXExpanderOptions extends JQXDefaultJavaScriptPart
{

    private String animationType;// 	String 	'slide'
    private String arrowPosition;// 	String 	'left'
    private Integer collapseAnimationDuration;// 	Number 	400
    private Boolean disabled;// 	Boolean 	false
    private Boolean expanded;// 	Boolean 	true
    private Integer expandAnimationDuration;// 	Number 	400
    private String HeaderPosition;// 	String 	'top'
    private JavascriptFunction initContent;// 	function 	null
    private Boolean rtl;// 	Boolean 	false
    private Boolean showArrow;// 	Boolean 	true
    private String toggleMode;// 	String 	'click'

    public JQXExpanderOptions()
    {

    }

    public String getAnimationType()
    {
        return animationType;
    }

    public void setAnimationType(String animationType)
    {
        this.animationType = animationType;
    }

    public String getArrowPosition()
    {
        return arrowPosition;
    }

    public void setArrowPosition(String arrowPosition)
    {
        this.arrowPosition = arrowPosition;
    }

    public Integer getCollapseAnimationDuration()
    {
        return collapseAnimationDuration;
    }

    public void setCollapseAnimationDuration(Integer collapseAnimationDuration)
    {
        this.collapseAnimationDuration = collapseAnimationDuration;
    }

    public Boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    public Boolean getExpanded()
    {
        return expanded;
    }

    public void setExpanded(Boolean expanded)
    {
        this.expanded = expanded;
    }

    public Integer getExpandAnimationDuration()
    {
        return expandAnimationDuration;
    }

    public void setExpandAnimationDuration(Integer expandAnimationDuration)
    {
        this.expandAnimationDuration = expandAnimationDuration;
    }

    public String getHeaderPosition()
    {
        return HeaderPosition;
    }

    public void setHeaderPosition(String HeaderPosition)
    {
        this.HeaderPosition = HeaderPosition;
    }

    public JavascriptFunction getInitContent()
    {
        return initContent;
    }

    public void setInitContent(JavascriptFunction initContent)
    {
        this.initContent = initContent;
    }

    public Boolean getRtl()
    {
        return rtl;
    }

    public void setRtl(Boolean rtl)
    {
        this.rtl = rtl;
    }

    public Boolean getShowArrow()
    {
        return showArrow;
    }

    public void setShowArrow(Boolean showArrow)
    {
        this.showArrow = showArrow;
    }

    public String getToggleMode()
    {
        return toggleMode;
    }

    public void setToggleMode(String toggleMode)
    {
        this.toggleMode = toggleMode;
    }

}
