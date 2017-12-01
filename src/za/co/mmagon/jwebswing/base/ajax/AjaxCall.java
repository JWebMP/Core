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

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.inject.servlet.RequestScoped;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.events.enumerations.EventTypes;

import javax.validation.constraints.NotNull;
import java.util.*;

/**
 * This class handles the decoding of an AJAX call being received
 * <p>
 *
 * @author GedMarc
 * @since 04 May 2015
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@RequestScoped
public class AjaxCall<J extends AjaxCall<J>> extends JavaScriptPart<J>
{

	private static final long serialVersionUID = 1L;
	/**
	 * The component ID that was sent back
	 */
	private String componentId;
	/**
	 * The date of the client event - used to measure network congestion.
	 */
	private Date datetime;
	/**
	 * The event type
	 */
	private EventTypes eventType;
	/**
	 * A secondary event type from option
	 */
	private EventTypes eventTypeFrom;
	/**
	 * The angular event variable
	 */
	private AjaxEventValue value;
	/**
	 * The component object that this call is linked to
	 */
	@JsonIgnore
	private ComponentHierarchyBase component;
	/**
	 * Is an incoming string of angular data
	 */
	private Set<AngularJsonVariable> variableData;
	/**
	 * The event ID
	 */
	private String eventId;
	/**
	 * The parameters associated with the call
	 */
	private Map<String, String> parameters;
	/**
	 * The class to create
	 */
	private String className;

	/**
	 * JSon Jackson Constructor
	 */
	public AjaxCall()
	{
		//set nothing
	}

	/**
	 * Creates a valid AJAX call object that can be processed
	 *
	 * @param componentId   The component ID
	 * @param datetime      The Date Time
	 * @param eventType     The ComponentEventBase Type
	 * @param eventTypeFrom The ComponentEventBase Type From
	 * @param value         The Value
	 *
	 */
	public AjaxCall(String componentId, Date datetime, String eventType, String eventTypeFrom, AjaxEventValue value)
	{
		this.componentId = componentId;
		this.datetime = datetime;
		this.value = value;
		this.eventType = EventTypes.valueOf(eventType);
		this.eventTypeFrom = EventTypes.valueOf(eventTypeFrom);
	}

	/**
	 * Returns this component ID
	 *
	 * @return
	 */
	public final String getComponentId()
	{
		return componentId;
	}

	/**
	 * Creates this as a copy from the incoming call
	 * @param incoming
	 */
	@SuppressWarnings("unchecked")
	public J fromCall(AjaxCall incoming)
	{
		setComponent(incoming.getComponent());
		setComponentId(incoming.getComponentId());
		setDatetime(incoming.getDatetime());
		setEventId(incoming.getEventId());
		setEventType(incoming.getEventType());
		setEventTypeFrom(incoming.getEventTypeFrom());
		setReferenceId(incoming.getReferenceId());
		setValue(incoming.getValue());
		setVariableData(incoming.getVariableData());
		setClassName(incoming.getClassName());
		return (J)this;
	}

	/**
	 * Returns this date time of this call
	 *
	 * @return
	 */
	public Date getDatetime()
	{
		return datetime;
	}

	/**
	 * Sets this calls component
	 *
	 * @param component
	 */
	@SuppressWarnings("unchecked")
	public J setComponent(ComponentHierarchyBase component)
	{
		this.component = component;
		return (J)this;
	}

	/**
	 * Gets event type
	 *
	 * @return
	 */
	public EventTypes getEventType()
	{
		return eventType;
	}

	/**
	 * Sets this component ID
	 *
	 * @param componentId
	 */
	@SuppressWarnings("unchecked")
	public J setComponentId(String componentId)
	{
		this.componentId = componentId;
		return (J)this;
	}

	/**
	 * Returns this calls event type from
	 *
	 * @return
	 */
	public EventTypes getEventTypeFrom()
	{
		return eventTypeFrom;
	}

	/**
	 * Sets the date time of this call
	 *
	 * @param datetime
	 */
	@SuppressWarnings("unchecked")
	public J setDatetime(Date datetime)
	{
		this.datetime = datetime;
		return (J)this;
	}

	/**
	 * Returns this calls value
	 *
	 * @return
	 */
	public AjaxEventValue getValue()
	{
		return value;
	}

	/**
	 * The Event ID
	 *
	 * @param eventId
	 */
	@SuppressWarnings("unchecked")
	public J setEventId(String eventId)
	{
		this.eventId = eventId;
		return (J)this;
	}

	/**
	 * Returns this calls component
	 *
	 * @return
	 */
	public ComponentHierarchyBase getComponent()
	{
		return component;
	}

	/**
	 * Sets the event type
	 *
	 * @param eventType
	 */
	@SuppressWarnings("unchecked")
	public J setEventType(EventTypes eventType)
	{
		this.eventType = eventType;
		return (J)this;
	}

	/**
	 * Returns JSON strings of inbound variables
	 *
	 * @return
	 */
	@NotNull
	public Set<AngularJsonVariable> getVariableData()
	{
		if (variableData == null)
		{
			variableData = new HashSet<>();
		}
		return variableData;
	}

	/**
	 * Sets this calls event type from
	 *
	 * @param eventTypeFrom
	 */
	@SuppressWarnings("unchecked")
	public J setEventTypeFrom(EventTypes eventTypeFrom)
	{
		this.eventTypeFrom = eventTypeFrom;
		return (J)this;
	}

	/**
	 * Returns the variable with the given name in the array or null
	 *
	 * @param name The name of the variable as designated
	 *
	 * @return
	 */
	public AngularJsonVariable getVariable(String name)
	{
		for (AngularJsonVariable next : getVariableData())
		{
			if (next.getVariableName().equals(name))
			{
				return next;
			}
		}
		return null;
	}

	/**
	 * The event ID
	 *
	 * @return
	 */
	public String getEventId()
	{
		return eventId;
	}

	/**
	 * Sets this calls value
	 *
	 * @param value
	 */
	@SuppressWarnings("unchecked")
	public J setValue(AjaxEventValue value)
	{
		this.value = value;
		return (J)this;
	}

	/**
	 * Sets the array list of bound objects?
	 *
	 * @param variableData
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setVariableData(Set<AngularJsonVariable> variableData)
	{
		this.variableData = variableData;
		return (J)this;
	}

	/**
	 * Returns a list of parameters
	 * @return
	 */
	@NotNull
	public Map<String, String> getParameters()
	{
		if (parameters == null)
		{
			parameters = new HashMap<>();
		}
		return parameters;
	}

	/**
	 * Sets the list of parameters
	 * @param parameters
	 */
	@SuppressWarnings("unchecked")
	public J setParameters(Map<String, String> parameters)
	{
		this.parameters = parameters;
		return (J)this;
	}

	/**
	 * Returns the event class this event is associated with
	 *
	 * @return
	 */
	@NotNull
	public String getClassName()
	{
		return className;
	}

	/**
	 * Sets the class name this event is associated with
	 *
	 * @param className
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J setClassName(String className)
	{
		this.className = className;
		return (J)this;
	}
}
