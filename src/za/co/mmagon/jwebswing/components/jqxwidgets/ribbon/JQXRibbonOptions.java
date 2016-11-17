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
package za.co.mmagon.jwebswing.components.jqxwidgets.ribbon;

import za.co.mmagon.jwebswing.components.jqxwidgets.JQXDefaultJavaScriptPart;
import za.co.mmagon.jwebswing.components.jqxwidgets.JQXInitContent;
import za.co.mmagon.jwebswing.components.jqxwidgets.JQXSelectionModes;
import za.co.mmagon.jwebswing.components.jqxwidgets.popover.JQXPopupCloseModes;
import za.co.mmagon.jwebswing.htmlbuilder.effects.EasingEffects;

/**
 * All the options for the JQX Ribbon
 * <p>
 * @author GedMarc
 * @since Dec 13, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXRibbonOptions extends JQXDefaultJavaScriptPart
{

    /**
     * Version 1.0
     */
    private static final long serialVersionUID = 1L;

    private EasingEffects animationType;// 	String 	'fade'
    private Integer animationDelay;// 	Number/String 	400
    private Boolean disabled;// 	Boolean 	false
    private JQXInitContent initContent;// 	Function 	null
    private JQXRibbonModes mode;// 	String 	'default'
    private JQXPopupCloseModes popupCloseMode;// 	String 	'click'
    private JQXRibbonPositions position;// 	String 	'top'
    private Boolean rtl;// 	Boolean 	false
    private Integer selectedIndex;// 	Number 	0
    private JQXSelectionModes selectionMode;// 	String 	'click'
    private JQXScrollPositions scrollPosition;// 	String 	'both'
    private Integer scrollStep;// 	Number 	10
    private Integer scrollDelay;// 	Number 	50

    public JQXRibbonOptions()
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

    public Integer getAnimationDelay()
    {
        return animationDelay;
    }

    public void setAnimationDelay(Integer animationDelay)
    {
        this.animationDelay = animationDelay;
    }

    public Boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    /**
     * *
     * Can return null!
     *
     * @return
     */
    public JQXInitContent getInitContent()
    {
        return initContent;
    }

    public void setInitContent(JQXInitContent initContent)
    {
        this.initContent = initContent;
    }

    public JQXRibbonModes getMode()
    {
        return mode;
    }

    public void setMode(JQXRibbonModes mode)
    {
        this.mode = mode;
    }

    public JQXPopupCloseModes getPopupCloseMode()
    {
        return popupCloseMode;
    }

    public void setPopupCloseMode(JQXPopupCloseModes popupCloseMode)
    {
        this.popupCloseMode = popupCloseMode;
    }

    public JQXRibbonPositions getPosition()
    {
        return position;
    }

    public void setPosition(JQXRibbonPositions position)
    {
        this.position = position;
    }

    public Boolean getRtl()
    {
        return rtl;
    }

    public void setRtl(Boolean rtl)
    {
        this.rtl = rtl;
    }

    public Integer getSelectedIndex()
    {
        return selectedIndex;
    }

    public void setSelectedIndex(Integer selectedIndex)
    {
        this.selectedIndex = selectedIndex;
    }

    public JQXSelectionModes getSelectionMode()
    {
        return selectionMode;
    }

    public void setSelectionMode(JQXSelectionModes selectionMode)
    {
        this.selectionMode = selectionMode;
    }

    public JQXScrollPositions getScrollPosition()
    {
        return scrollPosition;
    }

    public void setScrollPosition(JQXScrollPositions scrollPosition)
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

    public Integer getScrollDelay()
    {
        return scrollDelay;
    }

    public void setScrollDelay(Integer scrollDelay)
    {
        this.scrollDelay = scrollDelay;
    }
}
