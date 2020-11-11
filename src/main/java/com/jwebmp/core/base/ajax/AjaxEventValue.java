/*
 * Copyright (C) 2017 GedMarc
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
package com.jwebmp.core.base.ajax;

import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.core.htmlbuilder.javascript.events.enumerations.EventTypes;

import jakarta.validation.constraints.NotNull;

/**
 * An angular event that is returned
 *
 * @author GedMarc
 * @since 27 Apr 2016
 */
public class AjaxEventValue<J extends AjaxEventValue<J>>
		extends JavaScriptPart<J>
{
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
	@NotNull
	@SuppressWarnings("unchecked")
	public J setAltKey(Boolean altKey)
	{
		this.altKey = altKey;
		return (J) this;
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
	@NotNull
	@SuppressWarnings("unchecked")
	public J setCtrlKey(Boolean ctrlKey)
	{
		this.ctrlKey = ctrlKey;
		return (J) this;
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
	@NotNull
	@SuppressWarnings("unchecked")
	public J setBubbles(Boolean bubbles)
	{
		this.bubbles = bubbles;
		return (J) this;
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
	@NotNull
	@SuppressWarnings("unchecked")
	public J setCancelable(Boolean cancelable)
	{
		this.cancelable = cancelable;
		return (J) this;
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
	@NotNull
	@SuppressWarnings("unchecked")
	public J setClientX(Integer clientX)
	{
		this.clientX = clientX;
		return (J) this;
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
	@NotNull
	@SuppressWarnings("unchecked")
	public J setClientY(Integer clientY)
	{
		this.clientY = clientY;
		return (J) this;
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
	@NotNull
	@SuppressWarnings("unchecked")
	public J setComponentID(String componentID)
	{
		this.componentID = componentID;
		return (J) this;
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
	@NotNull
	@SuppressWarnings("unchecked")
	public J setDetail(Integer detail)
	{
		this.detail = detail;
		return (J) this;
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
	@NotNull
	@SuppressWarnings("unchecked")
	public J setEventPhase(Integer eventPhase)
	{
		this.eventPhase = eventPhase;
		return (J) this;
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
	@NotNull
	@SuppressWarnings("unchecked")
	public J setMetaKey(Boolean metaKey)
	{
		this.metaKey = metaKey;
		return (J) this;
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
	@NotNull
	@SuppressWarnings("unchecked")
	public J setOffsetX(Integer offsetX)
	{
		this.offsetX = offsetX;
		return (J) this;
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
	@NotNull
	@SuppressWarnings("unchecked")
	public J setOffsetY(Integer offsetY)
	{
		this.offsetY = offsetY;
		return (J) this;
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
	@NotNull
	@SuppressWarnings("unchecked")
	public J setPageX(Integer pageX)
	{
		this.pageX = pageX;
		return (J) this;
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
	@NotNull
	@SuppressWarnings("unchecked")
	public J setPageY(Integer pageY)
	{
		this.pageY = pageY;
		return (J) this;
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
	@NotNull
	@SuppressWarnings("unchecked")
	public J setScreenX(Integer screenX)
	{
		this.screenX = screenX;
		return (J) this;
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
	@NotNull
	@SuppressWarnings("unchecked")
	public J setScreenY(Integer screenY)
	{
		this.screenY = screenY;
		return (J) this;
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
	@NotNull
	@SuppressWarnings("unchecked")
	public J setShiftKey(Boolean shiftKey)
	{
		this.shiftKey = shiftKey;
		return (J) this;
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
	@NotNull
	@SuppressWarnings("unchecked")
	public J setType(EventTypes type)
	{
		this.type = type;
		return (J) this;
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
	@NotNull
	@SuppressWarnings("unchecked")
	public J setData(String data)
	{
		this.data = data;
		return (J) this;
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
	@NotNull
	@SuppressWarnings("unchecked")
	public J setTarget(String target)
	{
		this.target = target;
		return (J) this;
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
	@NotNull
	@SuppressWarnings("unchecked")
	public J setWhich(String which)
	{
		this.which = which;
		return (J) this;
	}

}
