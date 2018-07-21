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

package com.jwebmp.core.base.ajax;

import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.htmlbuilder.javascript.events.enumerations.EventTypes;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public interface IAjaxCall<J extends AjaxCall<J>>
		extends Serializable
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
	@SuppressWarnings("unchecked")
	J fromCall(AjaxCall incoming);

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
	@SuppressWarnings("unchecked")
	J setComponent(ComponentHierarchyBase component);

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
	@SuppressWarnings("unchecked")
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
	@SuppressWarnings("unchecked")
	J setDatetime(Date datetime);

	/**
	 * Returns this calls value
	 *
	 * @return
	 */
	AjaxEventValue getValue();

	/**
	 * The Event ID
	 *
	 * @param eventId
	 */
	@SuppressWarnings("unchecked")
	J setEventId(String eventId);

	/**
	 * Returns this calls component
	 *
	 * @return
	 */
	ComponentHierarchyBase getComponent();

	/**
	 * Sets the event type
	 *
	 * @param eventType
	 */
	@SuppressWarnings("unchecked")
	J setEventType(EventTypes eventType);

	/**
	 * Returns JSON strings of inbound variables
	 *
	 * @return
	 */
	@NotNull
	Set<AngularJsonVariable> getVariableData();

	/**
	 * Sets this calls event type from
	 *
	 * @param eventTypeFrom
	 */
	@SuppressWarnings("unchecked")
	J setEventTypeFrom(EventTypes eventTypeFrom);

	/**
	 * Returns the variable with the given name in the array or null
	 *
	 * @param name
	 * 		The name of the variable as designated
	 *
	 * @return
	 */
	AngularJsonVariable getVariable(String name);

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
	@SuppressWarnings("unchecked")
	J setValue(AjaxEventValue value);

	/**
	 * Sets the array list of bound objects?
	 *
	 * @param variableData
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	J setVariableData(Set<AngularJsonVariable> variableData);

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
	@SuppressWarnings("unchecked")
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
	@SuppressWarnings("unchecked")
	J setClassName(String className);
}
