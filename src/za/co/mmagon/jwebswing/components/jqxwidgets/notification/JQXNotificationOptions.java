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
package za.co.mmagon.jwebswing.components.jqxwidgets.notification;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.components.jqxwidgets.JQXDefaultJavaScriptPart;

/**
 * All the options for the tooltip library
 * <p>
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXNotificationOptions extends JQXDefaultJavaScriptPart
{

    private String appendContainer;// 	String 	null
    private Boolean autoOpen;// 	Boolean 	false
    private Integer animationOpenDelay;// 	Number/String 	400
    private Integer animationCloseDelay;// 	Number/String 	800
    private Boolean autoClose;// 	Boolean 	true
    private Integer autoCloseDelay;// 	Number/String 	3000
    private Boolean blink;// 	Boolean 	false
    private Integer browserBoundsOffset;// 	Number/String 	5
    private Boolean closeOnClick;// 	Boolean 	true
    private Boolean disabled;// 	Boolean 	false
    private Double hoverOpacity;// 	Number 	1
    private JQXNotificationIcon icon;// 	Object 	null
    private Integer notificationOffset;// 	Number/String 	5
    private Double opacity;// 	Number 	0.9
    private JQXNotificationPositions position;// 	String 	'top-right'
    private Boolean rtl;// 	Boolean 	false
    private Boolean showCloseButton;// 	Boolean 	true
    private JQXNotificationTemplates template;// 	String 	'info'

    public JQXNotificationOptions()
    {

    }

    public String getAppendContainer()
    {
        return appendContainer;
    }

    public void setAppendContainer(Component appendContainer)
    {
        this.appendContainer = appendContainer.getID(true);
    }

    public Boolean getAutoOpen()
    {
        return autoOpen;
    }

    public void setAutoOpen(Boolean autoOpen)
    {
        this.autoOpen = autoOpen;
    }

    public Integer getAnimationOpenDelay()
    {
        return animationOpenDelay;
    }

    public void setAnimationOpenDelay(Integer animationOpenDelay)
    {
        this.animationOpenDelay = animationOpenDelay;
    }

    public Integer getAnimationCloseDelay()
    {
        return animationCloseDelay;
    }

    public void setAnimationCloseDelay(Integer animationCloseDelay)
    {
        this.animationCloseDelay = animationCloseDelay;
    }

    public Boolean getAutoClose()
    {
        return autoClose;
    }

    public void setAutoClose(Boolean autoClose)
    {
        this.autoClose = autoClose;
    }

    public Integer getAutoCloseDelay()
    {
        return autoCloseDelay;
    }

    public void setAutoCloseDelay(Integer autoCloseDelay)
    {
        this.autoCloseDelay = autoCloseDelay;
    }

    public Boolean getBlink()
    {
        return blink;
    }

    public void setBlink(Boolean blink)
    {
        this.blink = blink;
    }

    public Integer getBrowserBoundsOffset()
    {
        return browserBoundsOffset;
    }

    public void setBrowserBoundsOffset(Integer browserBoundsOffset)
    {
        this.browserBoundsOffset = browserBoundsOffset;
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

    public Double getHoverOpacity()
    {
        return hoverOpacity;
    }

    public void setHoverOpacity(Double hoverOpacity)
    {
        this.hoverOpacity = hoverOpacity;
    }

    public JQXNotificationIcon getIcon()
    {
        return icon;
    }

    public void setIcon(JQXNotificationIcon icon)
    {
        this.icon = icon;
    }

    public Integer getNotificationOffset()
    {
        return notificationOffset;
    }

    public void setNotificationOffset(Integer notificationOffset)
    {
        this.notificationOffset = notificationOffset;
    }

    public Double getOpacity()
    {
        return opacity;
    }

    public void setOpacity(Double opacity)
    {
        this.opacity = opacity;
    }

    public JQXNotificationPositions getPosition()
    {
        return position;
    }

    public void setPosition(JQXNotificationPositions position)
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

    public Boolean getShowCloseButton()
    {
        return showCloseButton;
    }

    public void setShowCloseButton(Boolean showCloseButton)
    {
        this.showCloseButton = showCloseButton;
    }

    public JQXNotificationTemplates getTemplate()
    {
        return template;
    }

    public void setTemplate(JQXNotificationTemplates template)
    {
        this.template = template;
    }

}
