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
package za.co.mmagon.jwebswing.components.jqxwidgets.menu;

import za.co.mmagon.jwebswing.base.servlets.enumarations.Orientation;
import za.co.mmagon.jwebswing.components.jqxwidgets.JQXDefaultJavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.effects.EasingEffects;

/**
 * All the options for the tooltip library
 * <p>
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXMenuOptions extends JQXDefaultJavaScriptPart
{

    private Integer animationShowDuration;// 	Number 	350
    private Integer animationHideDuration;// 	Number 	250
    private Integer animationHideDelay;// 	Number 	500
    private Integer animationShowDelay;// 	Number 	200
    private Integer autoCloseInterval;// 	Number 	10000
    private Boolean autoSizeMainItems;// 	Boolean 	true
    private Boolean autoCloseOnClick;// 	Boolean 	true
    private Boolean autoOpenPopup;// 	Boolean 	true
    private Boolean autoOpen;// 	Boolean 	true
    private Boolean clickToOpen;// 	Boolean 	false
    private Boolean disabled;// 	Boolean 	false
    private Boolean enableHover;// 	Boolean 	true
    private EasingEffects easing;// 	String 	easeInOutSine
    private Boolean keyboardNavigation;// 	Boolean 	false
    private String minimizeWidth;// 	String 	'auto'
    private Orientation mode;// 	String 	horizontal
    private Integer popupZIndex;// 	Number 	20000
    private Boolean rtl;// 	Boolean 	false

    public JQXMenuOptions()
    {

    }

    public Integer getAnimationShowDuration()
    {
        return animationShowDuration;
    }

    public void setAnimationShowDuration(Integer animationShowDuration)
    {
        this.animationShowDuration = animationShowDuration;
    }

    public Integer getAnimationHideDuration()
    {
        return animationHideDuration;
    }

    public void setAnimationHideDuration(Integer animationHideDuration)
    {
        this.animationHideDuration = animationHideDuration;
    }

    public Integer getAnimationHideDelay()
    {
        return animationHideDelay;
    }

    public void setAnimationHideDelay(Integer animationHideDelay)
    {
        this.animationHideDelay = animationHideDelay;
    }

    public Integer getAnimationShowDelay()
    {
        return animationShowDelay;
    }

    public void setAnimationShowDelay(Integer animationShowDelay)
    {
        this.animationShowDelay = animationShowDelay;
    }

    public Integer getAutoCloseInterval()
    {
        return autoCloseInterval;
    }

    public void setAutoCloseInterval(Integer autoCloseInterval)
    {
        this.autoCloseInterval = autoCloseInterval;
    }

    public Boolean getAutoSizeMainItems()
    {
        return autoSizeMainItems;
    }

    public void setAutoSizeMainItems(Boolean autoSizeMainItems)
    {
        this.autoSizeMainItems = autoSizeMainItems;
    }

    public Boolean getAutoCloseOnClick()
    {
        return autoCloseOnClick;
    }

    public void setAutoCloseOnClick(Boolean autoCloseOnClick)
    {
        this.autoCloseOnClick = autoCloseOnClick;
    }

    public Boolean getAutoOpenPopup()
    {
        return autoOpenPopup;
    }

    public void setAutoOpenPopup(Boolean autoOpenPopup)
    {
        this.autoOpenPopup = autoOpenPopup;
    }

    public Boolean getAutoOpen()
    {
        return autoOpen;
    }

    public void setAutoOpen(Boolean autoOpen)
    {
        this.autoOpen = autoOpen;
    }

    public Boolean getClickToOpen()
    {
        return clickToOpen;
    }

    public void setClickToOpen(Boolean clickToOpen)
    {
        this.clickToOpen = clickToOpen;
    }

    public Boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    public Boolean getEnableHover()
    {
        return enableHover;
    }

    public void setEnableHover(Boolean enableHover)
    {
        this.enableHover = enableHover;
    }

    public EasingEffects getEasing()
    {
        return easing;
    }

    public void setEasing(EasingEffects easing)
    {
        this.easing = easing;
    }

    public Boolean getKeyboardNavigation()
    {
        return keyboardNavigation;
    }

    public void setKeyboardNavigation(Boolean keyboardNavigation)
    {
        this.keyboardNavigation = keyboardNavigation;
    }

    public String getMinimizeWidth()
    {
        return minimizeWidth;
    }

    public void setMinimizeWidth(String minimizeWidth)
    {
        this.minimizeWidth = minimizeWidth;
    }

    public Orientation getMode()
    {
        return mode;
    }

    public void setMode(Orientation mode)
    {
        this.mode = mode;
    }

    public Integer getPopupZIndex()
    {
        return popupZIndex;
    }

    public void setPopupZIndex(Integer popupZIndex)
    {
        this.popupZIndex = popupZIndex;
    }

    public Boolean getRtl()
    {
        return rtl;
    }

    public void setRtl(Boolean rtl)
    {
        this.rtl = rtl;
    }

}
