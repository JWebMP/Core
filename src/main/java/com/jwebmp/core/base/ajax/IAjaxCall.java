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

import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.htmlbuilder.javascript.events.enumerations.EventTypes;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.Map;
import java.util.Set;

public interface IAjaxCall<J extends AjaxCall<J>>
{
	/**
	 * Returns this component ID
	 *
	 * @return
	 */
	String getComponentId();

	/**
	 * Creates this as a copy from the incoming call
	 *
	 * @param incoming
	 */
	
	J fromCall(AjaxCall<?> incoming);

	/**
	 * Returns this date time of this call
	 *
	 * @return
	 */
	Date getDatetime();

	/**
	 * Sets this calls component
	 *
	 * @param component
	 */
	
	J setComponent(IComponentHierarchyBase<?,?> component);

	/**
	 * Gets event type
	 *
	 * @return
	 */
	EventTypes getEventType();

	/**
	 * Sets this component ID
	 *
	 * @param componentId
	 */
	
	J setComponentId(String componentId);

	/**
	 * Returns this calls event type from
	 *
	 * @return
	 */
	EventTypes getEventTypeFrom();

	/**
	 * Sets the date time of this call
	 *
	 * @param datetime
	 */
	
	J setDatetime(Date datetime);

	/**
	 * Returns this calls value
	 *
	 * @return
	 */
	AjaxEventValue<?> getValue();

	/**
	 * The Event ID
	 *
	 * @param eventId
	 */
	
	J setEventId(String eventId);

	/**
	 * Returns this calls component
	 *
	 * @return
	 */
	IComponentHierarchyBase<?,?> getComponent();

	/**
	 * Sets the event type
	 *
	 * @param eventType
	 */
	
	J setEventType(EventTypes eventType);

	/**
	 * Returns JSON strings of inbound variables
	 *
	 * @return
	 */
	@NotNull
	Set<JsonVariable> getVariableData();

	/**
	 * Sets this calls event type from
	 *
	 * @param eventTypeFrom
	 */
	
	J setEventTypeFrom(EventTypes eventTypeFrom);

	/**
	 * Returns the variable with the given name in the array or null
	 *
	 * @param name
	 * 		The name of the variable as designated
	 *
	 * @return
	 */
	JsonVariable getVariable(String name);

	/**
	 * The event ID
	 *
	 * @return
	 */
	String getEventId();

	/**
	 * Sets this calls value
	 *
	 * @param value
	 */
	
	J setValue(AjaxEventValue<?> value);

	/**
	 * Sets the array list of bound objects?
	 *
	 * @param variableData
	 */
	
	@NotNull
	J setVariableData(Set<JsonVariable> variableData);

	/**
	 * Returns a list of parameters
	 *
	 * @return
	 */
	@NotNull
	Map<String, String> getParameters();

	/**
	 * Sets the list of parameters
	 *
	 * @param parameters
	 */
	
	J setParameters(Map<String, String> parameters);

	/**
	 * Returns the event class this event is associated with
	 *
	 * @return
	 */
	@NotNull
	String getClassName();

	/**
	 * Sets the class name this event is associated with
	 *
	 * @param className
	 */
	@NotNull
	
	J setClassName(String className);
}
