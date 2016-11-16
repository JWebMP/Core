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
package za.co.mmagon.jwebswing.components.jqxWidgets.tooltip;

import za.co.mmagon.jwebswing.components.jqxWidgets.JQXDefaultJavaScriptPart;

/**
 * All the options for the tooltip library
 * <p>
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXToolTipOptions extends JQXDefaultJavaScriptPart
{

    private Integer absolutePositionX;// 	Number/String 	0
    private Integer absolutePositionY;// 	Number/String 	0
    private Boolean autoHide;// 	Boolean 	true
    private Integer autoHideDelay;// 	Number 	3000
    private Integer animationShowDelay;// 	Number/String 	'fast'
    private Integer animationHideDelay;// 	Number/String 	'fast'
    private String content;// 	String 	''
    private Boolean closeOnClick;// 	Boolean 	true
    private Boolean disabled;// 	Boolean 	false
    private Boolean enableBrowserBoundsDetection;// 	Boolean 	true
    private Integer left;// 	Number/String 	0
    private String name;// 	String 	''
    private Double opacity;// 	Number 	0.9
    private JQXTooltipPositions position;// 	String 	'default'
    private Boolean rtl;// 	Boolean 	false
    private Integer showDelay;// 	Number 	100
    private Boolean showArrow;// 	Boolean 	true
    private Integer top;// 	Number/String 	0
    private JQXTooltipTriggers trigger;/// 	String 	'hover'

    public JQXToolTipOptions()
    {

    }

    public Integer getAbsolutePositionX()
    {
        return absolutePositionX;
    }

    public void setAbsolutePositionX(Integer absolutePositionX)
    {
        this.absolutePositionX = absolutePositionX;
    }

    public Integer getAbsolutePositionY()
    {
        return absolutePositionY;
    }

    public void setAbsolutePositionY(Integer absolutePositionY)
    {
        this.absolutePositionY = absolutePositionY;
    }

    public Boolean getAutoHide()
    {
        return autoHide;
    }

    public void setAutoHide(Boolean autoHide)
    {
        this.autoHide = autoHide;
    }

    public Integer getAutoHideDelay()
    {
        return autoHideDelay;
    }

    public void setAutoHideDelay(Integer autoHideDelay)
    {
        this.autoHideDelay = autoHideDelay;
    }

    public Integer getAnimationShowDelay()
    {
        return animationShowDelay;
    }

    public void setAnimationShowDelay(Integer animationShowDelay)
    {
        this.animationShowDelay = animationShowDelay;
    }

    public Integer getAnimationHideDelay()
    {
        return animationHideDelay;
    }

    public void setAnimationHideDelay(Integer animationHideDelay)
    {
        this.animationHideDelay = animationHideDelay;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public Boolean getCloseOnClick()
    {
        return closeOnClick;
    }

    public void setCloseOnClick(Boolean closeOnClick)
    {
        this.closeOnClick = closeOnClick;
    }

    public Boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    public Boolean getEnableBrowserBoundsDetection()
    {
        return enableBrowserBoundsDetection;
    }

    public void setEnableBrowserBoundsDetection(Boolean enableBrowserBoundsDetection)
    {
        this.enableBrowserBoundsDetection = enableBrowserBoundsDetection;
    }

    public Integer getLeft()
    {
        return left;
    }

    public void setLeft(Integer left)
    {
        this.left = left;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Double getOpacity()
    {
        return opacity;
    }

    public void setOpacity(Double opacity)
    {
        this.opacity = opacity;
    }

    public JQXTooltipPositions getPosition()
    {
        return position;
    }

    public void setPosition(JQXTooltipPositions position)
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

    public Integer getShowDelay()
    {
        return showDelay;
    }

    public void setShowDelay(Integer showDelay)
    {
        this.showDelay = showDelay;
    }

    public Boolean getShowArrow()
    {
        return showArrow;
    }

    public void setShowArrow(Boolean showArrow)
    {
        this.showArrow = showArrow;
    }

    public Integer getTop()
    {
        return top;
    }

    public void setTop(Integer top)
    {
        this.top = top;
    }

    public JQXTooltipTriggers getTrigger()
    {
        return trigger;
    }

    public void setTrigger(JQXTooltipTriggers trigger)
    {
        this.trigger = trigger;
    }

}
