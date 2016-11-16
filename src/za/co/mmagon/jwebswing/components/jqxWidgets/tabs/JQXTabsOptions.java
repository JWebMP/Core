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
package za.co.mmagon.jwebswing.components.jqxWidgets.tabs;

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
public class JQXTabsOptions extends JQXDefaultJavaScriptPart
{

    private JQXTabsAnimationTypes animationType;// 	String 	none
    private Boolean autoHeight;// 	Boolean 	true
    private Integer closeButtonSize;// 	Number 	16
    private Boolean collapsible;// 	Boolean 	false
    private Integer contentTransitionDuration;// 	Number 	450
    private Boolean disabled;// 	Boolean 	false
    private Boolean enabledHover;// 	Boolean 	true
    private Boolean enableScrollAnimation;// 	Boolean 	true
    private JavascriptFunction initTabContent;//function 	null
    private Boolean keyboardNavigation;// 	Boolean 	true
    private JQXTabPositions position;// 	String 	top
    private Boolean reorder;// 	Boolean 	false
    private Boolean rtl;// 	Boolean 	false
    private Integer scrollAnimationDuration;// 	Number 	250
    private Integer selectedItem;// 	Number 	0
    private Boolean selectionTracker;// 	Boolean 	false
    private Boolean scrollable;// 	Boolean 	true
    private JQXTabsScrollPositions scrollPosition;// 	String 	'right'
    private Integer scrollStep;// 	Number 	70
    private Boolean showCloseButtons;// 	Boolean 	false
    private JQXTabsToggleModes toggleMode;// 	String 	click

    public JQXTabsOptions()
    {

    }

    public JQXTabsAnimationTypes getAnimationType()
    {
        return animationType;
    }

    public void setAnimationType(JQXTabsAnimationTypes animationType)
    {
        this.animationType = animationType;
    }

    public Boolean getAutoHeight()
    {
        return autoHeight;
    }

    public void setAutoHeight(Boolean autoHeight)
    {
        this.autoHeight = autoHeight;
    }

    public Integer getCloseButtonSize()
    {
        return closeButtonSize;
    }

    public void setCloseButtonSize(Integer closeButtonSize)
    {
        this.closeButtonSize = closeButtonSize;
    }

    public Boolean getCollapsible()
    {
        return collapsible;
    }

    public void setCollapsible(Boolean collapsible)
    {
        this.collapsible = collapsible;
    }

    public Integer getContentTransitionDuration()
    {
        return contentTransitionDuration;
    }

    public void setContentTransitionDuration(Integer contentTransitionDuration)
    {
        this.contentTransitionDuration = contentTransitionDuration;
    }

    public Boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    public Boolean getEnabledHover()
    {
        return enabledHover;
    }

    public void setEnabledHover(Boolean enabledHover)
    {
        this.enabledHover = enabledHover;
    }

    public Boolean getEnableScrollAnimation()
    {
        return enableScrollAnimation;
    }

    public void setEnableScrollAnimation(Boolean enableScrollAnimation)
    {
        this.enableScrollAnimation = enableScrollAnimation;
    }

    public JavascriptFunction getInitTabContent()
    {
        return initTabContent;
    }

    public void setInitTabContent(JavascriptFunction initTabContent)
    {
        this.initTabContent = initTabContent;
    }

    public Boolean getKeyboardNavigation()
    {
        return keyboardNavigation;
    }

    public void setKeyboardNavigation(Boolean keyboardNavigation)
    {
        this.keyboardNavigation = keyboardNavigation;
    }

    public JQXTabPositions getPosition()
    {
        return position;
    }

    public void setPosition(JQXTabPositions position)
    {
        this.position = position;
    }

    public Boolean getReorder()
    {
        return reorder;
    }

    public void setReorder(Boolean reorder)
    {
        this.reorder = reorder;
    }

    public Boolean getRtl()
    {
        return rtl;
    }

    public void setRtl(Boolean rtl)
    {
        this.rtl = rtl;
    }

    public Integer getScrollAnimationDuration()
    {
        return scrollAnimationDuration;
    }

    public void setScrollAnimationDuration(Integer scrollAnimationDuration)
    {
        this.scrollAnimationDuration = scrollAnimationDuration;
    }

    public Integer getSelectedItem()
    {
        return selectedItem;
    }

    public void setSelectedItem(Integer selectedItem)
    {
        this.selectedItem = selectedItem;
    }

    public Boolean getSelectionTracker()
    {
        return selectionTracker;
    }

    public void setSelectionTracker(Boolean selectionTracker)
    {
        this.selectionTracker = selectionTracker;
    }

    public Boolean getScrollable()
    {
        return scrollable;
    }

    public void setScrollable(Boolean scrollable)
    {
        this.scrollable = scrollable;
    }

    public JQXTabsScrollPositions getScrollPosition()
    {
        return scrollPosition;
    }

    public void setScrollPosition(JQXTabsScrollPositions scrollPosition)
    {
        this.scrollPosition = scrollPosition;
    }

    public Integer getScrollStep()
    {
        return scrollStep;
    }

    public void setScrollStep(Integer scrollStep)
    {
        this.scrollStep = scrollStep;
    }

    public Boolean getShowCloseButtons()
    {
        return showCloseButtons;
    }

    public void setShowCloseButtons(Boolean showCloseButtons)
    {
        this.showCloseButtons = showCloseButtons;
    }

    public JQXTabsToggleModes getToggleMode()
    {
        return toggleMode;
    }

    public void setToggleMode(JQXTabsToggleModes toggleMode)
    {
        this.toggleMode = toggleMode;
    }

}
