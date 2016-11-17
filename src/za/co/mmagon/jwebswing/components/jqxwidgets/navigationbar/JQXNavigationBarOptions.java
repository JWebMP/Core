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
package za.co.mmagon.jwebswing.components.jqxwidgets.navigationbar;

import za.co.mmagon.jwebswing.components.jqxwidgets.JQXDefaultJavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.effects.EasingEffects;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptFunction;

/**
 * All the options for the Navigation Bar library
 * <p>
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXNavigationBarOptions extends JQXDefaultJavaScriptPart
{

    private EasingEffects animationType;// 	String 	'slide'
    private JQXNavigationBarArrowPosition arrowPosition;// 	String 	'right'
    private Integer collapseAnimationDuration;// 	Number 	400
    private Boolean disabled;// 	Boolean 	false
    private Integer expandAnimationDuration;// 	Number 	400
    private JQXNavigationBarExpandModes expandMode;// 	String 	'singleFitHeight'
//expandedIndexes 	Array 	[]
    private JavascriptFunction initContent;// 	function 	null
    private Boolean rtl;// 	Boolean 	false
    private Boolean showArrow;// 	Boolean 	true
    private JQXNavigationBarToggleModes toggleMode;// 	String 	click

    public JQXNavigationBarOptions()
    {

    }

    public EasingEffects getAnimationType()
    {
        return animationType;
    }

    public void setAnimationType(EasingEffects animationType)
    {
        this.animationType = animationType;
    }

    public JQXNavigationBarArrowPosition getArrowPosition()
    {
        return arrowPosition;
    }

    public void setArrowPosition(JQXNavigationBarArrowPosition arrowPosition)
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

    public Integer getExpandAnimationDuration()
    {
        return expandAnimationDuration;
    }

    public void setExpandAnimationDuration(Integer expandAnimationDuration)
    {
        this.expandAnimationDuration = expandAnimationDuration;
    }

    public JQXNavigationBarExpandModes getExpandMode()
    {
        return expandMode;
    }

    public void setExpandMode(JQXNavigationBarExpandModes expandMode)
    {
        this.expandMode = expandMode;
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

    public JQXNavigationBarToggleModes getToggleMode()
    {
        return toggleMode;
    }

    public void setToggleMode(JQXNavigationBarToggleModes toggleMode)
    {
        this.toggleMode = toggleMode;
    }

}
