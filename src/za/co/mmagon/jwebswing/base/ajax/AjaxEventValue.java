/* 
 * Copyright (C) 2017 Marc Magon
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
package za.co.mmagon.jwebswing.base.ajax;

import za.co.mmagon.jwebswing.htmlbuilder.javascript.*;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.events.enumerations.*;

/**
 * An angular event that is returned
 *
 * @author GedMarc
 * @since 27 Apr 2016
 */
public class AjaxEventValue extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;
    /**
     * If the alt key was pressed
     */
    private Boolean altKey;
    /**
     * If the ctrl key was pressed
     */
    private Boolean ctrlKey;
    /**
     * If the event bubbles down
     */
    private Boolean bubbles;
    /**
     * If the event is cancelable
     */
    private Boolean cancelable;
    /**
     * Mouse X
     */
    private Integer clientX;
    /**
     * Mouse Y
     */
    private Integer clientY;
    /**
     * Component ID
     */
    private String componentID;
    /**
     * detail
     */
    private Integer detail;
    /**
     * Event Phase
     */
    private Integer eventPhase;
    /**
     * Meta Key
     */
    private Boolean metaKey;
    /**
     * Offset X
     */
    private Integer offsetX;
    /**
     * Offset Y
     */
    private Integer offsetY;
    /**
     * Page X
     */
    private Integer pageX;
    /**
     * Page Y
     */
    private Integer pageY;
    /**
     * Screen X
     */
    private Integer screenX;
    /**
     * Screen Y
     */
    private Integer screenY;
    /**
     * Shift key
     */
    private Boolean shiftKey;
    /**
     * The event type
     */
    private EventTypes type;

    /**
     * The JSON data
     */
    private String data;
    /**
     * The JSON Target
     */
    private String target;
    /**
     * Which and Where to put it
     */
    private String which;

    /**
     * Blank Constructor
     */
    public AjaxEventValue()
    {
        //Just a dto
    }

    /**
     * If the alt key was pressed
     *
     * @return
     */
    public Boolean getAltKey()
    {
        return altKey;
    }

    /**
     * If the alt key was pressed
     *
     * @param altKey
     */
    public void setAltKey(Boolean altKey)
    {
        this.altKey = altKey;
    }

    /**
     * If the cntrl key was pressed
     *
     * @return
     */
    public Boolean getCtrlKey()
    {
        return ctrlKey;
    }

    /**
     * If the cntrl key was pressed
     *
     * @param ctrlKey
     */
    public void setCtrlKey(Boolean ctrlKey)
    {
        this.ctrlKey = ctrlKey;
    }

    /**
     * If the event bubbles down
     *
     * @return
     */
    public Boolean getBubbles()
    {
        return bubbles;
    }

    /**
     * If the event bubbles down
     *
     * @param bubbles
     */
    public void setBubbles(Boolean bubbles)
    {
        this.bubbles = bubbles;
    }

    /**
     * If the event is cancellable
     *
     * @return
     */
    public Boolean getCancelable()
    {
        return cancelable;
    }

    /**
     * If the event is cancellable
     *
     * @param cancelable
     */
    public void setCancelable(Boolean cancelable)
    {
        this.cancelable = cancelable;
    }

    /**
     * The mouse position for the client
     *
     * @return
     */
    public Integer getClientX()
    {
        return clientX;
    }

    /**
     * The mouse position for the client
     *
     * @param clientX
     */
    public void setClientX(Integer clientX)
    {
        this.clientX = clientX;
    }

    /**
     * The mouse position for the client
     *
     * @return
     */
    public Integer getClientY()
    {
        return clientY;
    }

    /**
     * The mouse position for the client
     *
     * @param clientY
     */
    public void setClientY(Integer clientY)
    {
        this.clientY = clientY;
    }

    /**
     * *
     * The component ID of the event cause
     *
     * @return
     */
    public String getComponentID()
    {
        return componentID;
    }

    /**
     * The component ID of the event cause
     *
     * @param componentID
     */
    public void setComponentID(String componentID)
    {
        this.componentID = componentID;
    }

    /**
     * Returns a detail number
     *
     * @return
     */
    public Integer getDetail()
    {
        return detail;
    }

    /**
     * Sets a detail number
     *
     * @param detail
     */
    public void setDetail(Integer detail)
    {
        this.detail = detail;
    }

    /**
     * The event phase
     *
     * @return
     */
    public Integer getEventPhase()
    {
        return eventPhase;
    }

    /**
     * Sets the event phase
     *
     * @param eventPhase
     */
    public void setEventPhase(Integer eventPhase)
    {
        this.eventPhase = eventPhase;
    }

    /**
     * Indicates if the meta key was pressed
     *
     * @return
     */
    public Boolean getMetaKey()
    {
        return metaKey;
    }

    /**
     * Sets if the meta key was pressed
     *
     * @param metaKey
     */
    public void setMetaKey(Boolean metaKey)
    {
        this.metaKey = metaKey;
    }

    /**
     * Returns the offset x from the parent
     *
     * @return
     */
    public Integer getOffsetX()
    {
        return offsetX;
    }

    /**
     * *
     * The offset position for the client
     *
     * @param offsetX
     */
    public void setOffsetX(Integer offsetX)
    {
        this.offsetX = offsetX;
    }

    /**
     * The offset position for Y
     *
     * @return
     */
    public Integer getOffsetY()
    {
        return offsetY;
    }

    /**
     * The offset position for Y
     *
     * @param offsetY
     */
    public void setOffsetY(Integer offsetY)
    {
        this.offsetY = offsetY;
    }

    /**
     * *
     * The page location X
     *
     * @return
     */
    public Integer getPageX()
    {
        return pageX;
    }

    /**
     * The page location X
     *
     * @param pageX
     */
    public void setPageX(Integer pageX)
    {
        this.pageX = pageX;
    }

    /*
     * The page location Y
     */
    public Integer getPageY()
    {
        return pageY;
    }

    /**
     * The page location Y
     *
     * @param pageY
     */
    public void setPageY(Integer pageY)
    {
        this.pageY = pageY;
    }

    /**
     * The Screen position X
     *
     * @return
     */
    public Integer getScreenX()
    {
        return screenX;
    }

    /**
     * The screen position X
     *
     * @param screenX
     */
    public void setScreenX(Integer screenX)
    {
        this.screenX = screenX;
    }

    /**
     * The screen position Y
     *
     * @return
     */
    public Integer getScreenY()
    {
        return screenY;
    }

    /**
     * The screen position Y
     *
     * @param screenY
     */
    public void setScreenY(Integer screenY)
    {
        this.screenY = screenY;
    }

    /**
     * If the shift key was pressed
     *
     * @return
     */
    public Boolean getShiftKey()
    {
        return shiftKey;
    }

    /**
     * If the shift key was pressed
     *
     * @param shiftKey
     */
    public void setShiftKey(Boolean shiftKey)
    {
        this.shiftKey = shiftKey;
    }

    /**
     * The type of event
     *
     * @return
     */
    public EventTypes getType()
    {
        return type;
    }

    /**
     * The type of event
     *
     * @param type
     */
    public void setType(EventTypes type)
    {
        this.type = type;
    }

    /**
     * Any data attached to the object
     *
     * @return
     */
    public String getData()
    {
        return data;
    }

    /**
     * Any data attached to the object
     *
     * @param data
     */
    public void setData(String data)
    {
        this.data = data;
    }

    /**
     * Gets the target component ID
     *
     * @return
     */
    public String getTarget()
    {
        return target;
    }

    /**
     * Sets the target component ID
     *
     * @param target
     */
    public void setTarget(String target)
    {
        this.target = target;
    }

    /**
     * Which button was pushed
     *
     * @return
     */
    public String getWhich()
    {
        return which;
    }

    /**
     * Which button was pushed
     *
     * @param which
     */
    public void setWhich(String which)
    {
        this.which = which;
    }

}
