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

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.guicedee.guicedservlets.services.scopes.CallScope;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.databind.ClientVariableWatcher;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.core.htmlbuilder.javascript.events.enumerations.EventTypes;
import jakarta.validation.constraints.NotNull;
import jakarta.websocket.Session;

import java.util.*;

/**
 * This class handles the decoding of an AJAX call being received
 * <p>
 *
 * @author GedMarc
 * @since 04 May 2015
 */
@SuppressWarnings({"JavaDoc", "unused"})
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY,
		getterVisibility = JsonAutoDetect.Visibility.NONE,
		setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@CallScope
public class AjaxCall<J extends AjaxCall<J>>
		extends JavaScriptPart<J>
		implements IAjaxCall<J>
{
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
	private AjaxEventValue<?> value;
	/**
	 * The component object that this call is linked to
	 */
	@JsonIgnore
	private IComponentHierarchyBase<?,?> component;
	/**
	 * Is an incoming string of angular data
	 */
	private Set<JsonVariable> variableData;
	/**
	 * Is an incoming string of angular data
	 */
	private Set<ClientVariableWatcher> variableWatchers;
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
	 * The given hash bang
	 */
	private String hashBang;
	/**
	 * If this call originates through a web socket (so there is no request or session scope),
	 * or if it is a direct page call
	 */
	private boolean isWebSocketCall;
	/**
	 * The web socket session for this call
	 */
	@JsonIgnore
	private Session websocketSession;
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
	 * @param componentId
	 * 		The component ID
	 * @param datetime
	 * 		The Date Time
	 * @param eventType
	 * 		The ComponentEventBase Type
	 * @param eventTypeFrom
	 * 		The ComponentEventBase Type From
	 * @param value
	 * 		The Value
	 */
	public AjaxCall(String componentId, Date datetime, String eventType, String eventTypeFrom, AjaxEventValue<?> value)
	{
		this.componentId = componentId;
		this.datetime = datetime;
		this.value = value;
		this.eventType = EventTypes.valueOf(eventType);
		this.eventTypeFrom = EventTypes.valueOf(eventTypeFrom);
	}
	
	public String getAttribute(String attribute)
	{
		return getValue().getAttributes()
		                 .get(attribute)
		                 .toString();
	}

	/**
	 * Returns a list of variable angular watchers to apply on the ajax call.
	 * Good for on binding changes
	 *
	 * @return
	 */
	public Set<ClientVariableWatcher> getVariableWatchers()
	{
		if (variableWatchers == null)
		{
			variableWatchers = new LinkedHashSet<>();
		}
		return variableWatchers;
	}

	/**
	 * Sets the variable watchers list to a new list
	 *
	 * @param variableWatchers
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J setVariableWatchers(Set<ClientVariableWatcher> variableWatchers)
	{
		this.variableWatchers = variableWatchers;
		return (J) this;
	}

	/**
	 * The given hash bang
	 *
	 * @return
	 */
	public String getHashBang()
	{
		return hashBang;
	}

	/**
	 * The given hash bang
	 *
	 * @param hashBang
	 */
	public void setHashBang(String hashBang)
	{
		this.hashBang = hashBang;
	}

	@Override
	public final String getComponentId()
	{
		return componentId;
	}

	@Override
	@SuppressWarnings("unchecked")
	public J fromCall(AjaxCall<?> incoming)
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
		setParameters(incoming.getParameters());
		setHashBang(incoming.getHashBang());
		setValue(incoming.getValue());
		setVariableData(incoming.getVariableData());
		setVariableWatchers(incoming.getVariableWatchers());
		setWebsocketSession(incoming.getWebsocketSession());
		setWebSocketCall(incoming.isWebSocketCall());
		return (J) this;
	}

	@Override
	public Date getDatetime()
	{
		return datetime;
	}

	@Override
	@SuppressWarnings("unchecked")
	public J setComponent(IComponentHierarchyBase<?,?> component)
	{
		this.component = component;
		return (J) this;
	}

	@Override
	public EventTypes getEventType()
	{
		return eventType;
	}

	@Override
	@SuppressWarnings("unchecked")
	public J setComponentId(String componentId)
	{
		this.componentId = componentId;
		return (J) this;
	}

	@Override
	public EventTypes getEventTypeFrom()
	{
		return eventTypeFrom;
	}

	@Override
	@SuppressWarnings("unchecked")
	public J setDatetime(Date datetime)
	{
		this.datetime = datetime;
		return (J) this;
	}

	@Override
	public AjaxEventValue<?> getValue()
	{
		return value;
	}

	@Override
	@SuppressWarnings("unchecked")
	public J setEventId(String eventId)
	{
		this.eventId = eventId;
		return (J) this;
	}

	@Override
	public IComponentHierarchyBase<?,?> getComponent()
	{
		return component;
	}

	@Override
	@SuppressWarnings("unchecked")
	public J setEventType(EventTypes eventType)
	{
		this.eventType = eventType;
		return (J) this;
	}

	@Override
	@NotNull
	public Set<JsonVariable> getVariableData()
	{
		if (variableData == null)
		{
			variableData = new HashSet<>();
		}
		return variableData;
	}

	@Override
	@SuppressWarnings("unchecked")
	public J setEventTypeFrom(EventTypes eventTypeFrom)
	{
		this.eventTypeFrom = eventTypeFrom;
		return (J) this;
	}

	@Override
	public JsonVariable getVariable(String name)
	{
		for (JsonVariable next : getVariableData())
		{
			if (next.getVariableName()
			        .equals(name))
			{
				return next;
			}
		}
		return null;
	}

	@Override
	public String getEventId()
	{
		return eventId;
	}

	@Override
	@SuppressWarnings("unchecked")
	public J setValue(AjaxEventValue<?> value)
	{
		this.value = value;
		return (J) this;
	}

	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J setVariableData(Set<JsonVariable> variableData)
	{
		this.variableData = variableData;
		return (J) this;
	}
	
	/**
	 * If this call originates through a web socket (so there is no request or session scope),
	 * 	 * or if it is a direct page call
	 * @return
	 */
	public boolean isWebSocketCall()
	{
		return isWebSocketCall;
	}
	
	/**
	 * If this call originates through a web socket (so there is no request or session scope),
	 * 	 * or if it is a direct page call
	 * @param webSocketCall
	 */
	@SuppressWarnings("unchecked")
	public J setWebSocketCall(boolean webSocketCall)
	{
		isWebSocketCall = webSocketCall;
		return (J)this;
	}
	
	/**
	 * The web socket session for this call
	 * @return
	 */
	public Session getWebsocketSession()
	{
		return websocketSession;
	}
	
	/**
	 * The web socket session for this call
	 *
	 * @param websocketSession
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public J setWebsocketSession(Session websocketSession)
	{
		this.websocketSession = websocketSession;
		return (J)this;
	}
	
	@Override
	@NotNull
	public Map<String, String> getParameters()
	{
		if (parameters == null)
		{
			parameters = new HashMap<>();
		}
		return parameters;
	}

	@Override
	@SuppressWarnings("unchecked")
	public J setParameters(Map<String, String> parameters)
	{
		this.parameters = parameters;
		return (J) this;
	}

	@Override
	@NotNull
	public String getClassName()
	{
		return className;
	}

	@Override
	@NotNull
	@SuppressWarnings("unchecked")
	public J setClassName(String className)
	{
		this.className = className;
		return (J) this;
	}

	protected void updateVariable(AjaxCall<?> call, String dtoName, Object newDto)
	{
		call.getVariableData()
		    .removeIf(variableDatum -> (variableDatum).getVariableName()
		                                              .equals(dtoName));
		call.getVariableData()
		    .add(new JsonVariable(dtoName, newDto));
	}
}
