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

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.*;
import com.google.common.base.*;
import com.google.inject.*;
import com.guicedee.guicedinjection.*;
import com.guicedee.guicedinjection.interfaces.*;
import com.guicedee.guicedservlets.*;
import com.guicedee.guicedservlets.services.scopes.*;
import com.jwebmp.core.base.interfaces.*;
import com.jwebmp.core.databind.*;
import com.jwebmp.core.htmlbuilder.javascript.*;
import com.jwebmp.core.htmlbuilder.javascript.events.enumerations.*;
import jakarta.servlet.http.*;
import jakarta.validation.constraints.*;
import jakarta.websocket.*;

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
	
	private HeadersDTO headers;
	
	private Map<String, Object> attributes;
	/**
	 * The component object that this call is linked to
	 */
	@JsonIgnore
	private IComponentHierarchyBase<?, ?> component;
	/**
	 * The parameters associated with the call
	 */
	private Map<String, String> parameters;
	
	/**
	 * The parameters associated with the call
	 */
	private Map<String, String> sessionStorage;
	/**
	 * The parameters associated with the call
	 */
	private Map<String, String> localStorage;
	
	/**
	 * The class to create
	 */
	@JsonAlias({"classname","eventClass"})
	private String className;
	/**
	 * The given hash bang
	 */
	@JsonAlias("hashbang")
	private String hashBang;
	/**
	 * The given path route for the application
	 */
	private String route;
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
	 * If this is a page or a supporting servlet call
	 */
	private boolean pageCall;
	
	private Map<String, Object> unknownFields = new HashMap<>();
	
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
	 */
	public AjaxCall(String componentId, Date datetime, String eventType, String eventTypeFrom)
	{
		this.componentId = componentId;
		this.datetime = datetime;
		this.eventType = EventTypes.valueOf(eventType);
	}
	
	@Inject
	void configure()
	{
		try
		{
			HttpServletRequest request = GuiceContext.get(GuicedServletKeys.getHttpServletRequestKey());
			for (Map.Entry<String, String[]> entry : request.getParameterMap()
			                                                .entrySet())
			{
				String key = entry.getKey();
				String[] value = entry.getValue();
				getParameters()
						.put(key, value[0]);
			}
		}
		catch (OutOfScopeException | ProvisionException e)
		{
			//ignore
		}
	}
	
	public String getAttribute(String attribute)
	{
		if (getAttributes() != null && getAttributes()
				                                                     .get(attribute) != null)
		{
			return getAttributes()
					.get(attribute)
					.toString();
		}
		return null;
	}
	
	/**
	 * @return
	 */
	@SuppressWarnings("Convert2Diamond")
	public Map<String, Object> getAttributeAsMap(String attributeName)
	{
		String variableText = getAttribute(attributeName);
		if (Strings.isNullOrEmpty(variableText))
		{
			return new HashMap<>();
		}
		TypeReference<HashMap<String, Object>> typeRef
				= new TypeReference<HashMap<String, Object>>()
		{
		};
		try
		{
			return GuiceContext.get(ObjectBinderKeys.DefaultObjectMapper)
			                   .readValue(variableText, typeRef);
		}
		catch (JsonProcessingException e)
		{
			return new HashMap<>();
		}
		
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
		setEventType(incoming.getEventType());
		setReferenceId(incoming.getReferenceId());
		setClassName(incoming.getClassName());
		setParameters(incoming.getParameters());
		setLocalStorage(incoming.getLocalStorage());
		setSessionStorage(incoming.getSessionStorage());
		setHashBang(incoming.getHashBang());
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
	public J setComponent(IComponentHierarchyBase<?, ?> component)
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
	@SuppressWarnings("unchecked")
	public J setDatetime(Date datetime)
	{
		this.datetime = datetime;
		return (J) this;
	}

	@Override
	public IComponentHierarchyBase<?, ?> getComponent()
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
	
	/**
	 * If this call originates through a web socket (so there is no request or session scope),
	 * * or if it is a direct page call
	 *
	 * @return
	 */
	public boolean isWebSocketCall()
	{
		return isWebSocketCall;
	}
	
	/**
	 * If this call originates through a web socket (so there is no request or session scope),
	 * * or if it is a direct page call
	 *
	 * @param webSocketCall
	 */
	@SuppressWarnings("unchecked")
	public J setWebSocketCall(boolean webSocketCall)
	{
		isWebSocketCall = webSocketCall;
		return (J) this;
	}
	
	/**
	 * The web socket session for this call
	 *
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
		return (J) this;
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
	
	/**
	 * If the call originates as a live page call, or a supporting servlet call
	 *
	 * @return
	 */
	public boolean isPageCall()
	{
		return pageCall;
	}
	
	/**
	 * If the call originates as a live page call, or a supporting servlet call
	 *
	 * @param pageCall
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public J setPageCall(boolean pageCall)
	{
		this.pageCall = pageCall;
		return (J) this;
	}

	/**
	 * Returns the sent through state of the session storage
	 *
	 * @return
	 */
	public Map<String, String> getSessionStorage()
	{
		if (sessionStorage == null)
		{
			sessionStorage = new HashMap<>();
		}
		return sessionStorage;
	}
	
	/**
	 * Sets the call list for session storage
	 *
	 * @param sessionStorage
	 * @return
	 */
	public J setSessionStorage(Map<String, String> sessionStorage)
	{
		this.sessionStorage = sessionStorage;
		return (J) this;
	}
	
	/**
	 * Gets the local storage
	 *
	 * @return
	 */
	public Map<String, String> getLocalStorage()
	{
		if (localStorage == null)
		{
			localStorage = new HashMap<>();
		}
		return localStorage;
	}
	
	/**
	 * Sets local storage
	 *
	 * @param localStorage
	 * @return
	 */
	public J setLocalStorage(Map<String, String> localStorage)
	{
		this.localStorage = localStorage;
		return (J) this;
	}
	
	
	@JsonAnyGetter
	public Map<String, Object> getUnknownFields()
	{
		return unknownFields;
	}
	
	@JsonAnySetter
	public void setOtherField(String name, Object value)
	{
		unknownFields.put(name, value);
	}
	
	
	public Map<String, Object> getAttributes()
	{
		if (attributes == null)
		{
			attributes = new HashMap<>();
		}
		return attributes;
	}
	
	@SuppressWarnings("unchecked")
	public J setAttributes(Map<String, Object> attributes)
	{
		this.attributes = attributes;
		return (J) this;
	}
	
	public HeadersDTO getHeaders()
	{
		return headers;
	}
	
	public AjaxCall<J> setHeaders(HeadersDTO headers)
	{
		this.headers = headers;
		return this;
	}
	
	public String getRoute()
	{
		return route;
	}
	
	public AjaxCall<J> setRoute(String route)
	{
		this.route = route;
		return this;
	}
}
