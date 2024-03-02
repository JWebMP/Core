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
package com.jwebmp.core.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jwebmp.core.Event;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.interfaces.IComponentEventBase;
import com.jwebmp.core.base.interfaces.IComponentFeatureBase;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.references.CSSReference;
import com.jwebmp.core.base.references.JavascriptReference;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;
import com.jwebmp.core.htmlbuilder.javascript.events.enumerations.EventTypes;
import com.jwebmp.core.services.*;
import jakarta.validation.constraints.NotNull;
import lombok.extern.java.Log;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;

/**
 * Enables Events in the Component Tree Hierarchy
 *
 * @param <F> The Features TYpe
 * @param <E> The Events Type
 * @param <J> This Type
 * @author GedMarc
 * @version 2.0
 * @since 23 Apr 2013
 */
@Log
public class ComponentEventBase<F extends GlobalFeatures, E extends GlobalEvents,
		J extends ComponentEventBase<F, E, J>>
		extends ComponentFeatureBase<F, J>
		implements IComponentEventBase<E, J>,GlobalEvents<J>
{
	/**
	 * The event of this component
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Set<E> events;
	
	/**
	 * The actual event type
	 */
	@JsonIgnore
	private IEventTypes<?> eventType;
	
	/**
	 * Constructs a new event for the given component type
	 *
	 * @param componentType The type for the event
	 */
	public ComponentEventBase(ComponentTypes componentType)
	{
		this(EventTypes.undefined, componentType);
	}
	
	/**
	 * Constructs a new event type for component type
	 *
	 * @param eventType     The Event Type being applied
	 * @param componentType The component type of this component
	 */
	public ComponentEventBase(EventTypes eventType, ComponentTypes componentType)
	{
		super(componentType);
		this.eventType = eventType;
	}
	
	/**
	 * Returns an Attribute Base interface of this component
	 *
	 * @return This object with only the events based methods
	 */
	@NotNull
	@SuppressWarnings("unused")
	public IComponentEventBase<?, ?> asEventBase()
	{
		return this;
	}
	
	/**
	 * Adds an event to this object
	 * <p>
	 *
	 * @param event The Event to add
	 */
	@Override
	@NotNull
	@SuppressWarnings("unchecked")
	public J addEvent(@NotNull E event)
	{
		if (event != null)
		{
			if (event instanceof Event)
			{
				Event chb = (Event) event;
				if (chb.getComponent() == null)
				{
					chb.setComponent((IComponentHierarchyBase<?, ?>) this);
				}
			}
			//noinspection RedundantClassCall
			if (!IComponentFeatureBase.class.cast(event)
			                                .asBase()
			                                .getComponentType()
			                                .equals(ComponentTypes.Event))
			{
				ComponentEventBase.log.log(Level.WARNING, "Tried to add a non event to the event collection");
			}
			else
			{
				getEvents().add(event);
			}
			if (IComponentFeatureBase.class.isAssignableFrom(getClass()))
			{
				((IComponentFeatureBase<?, ?>) event).asFeatureBase()
				                                     .setComponent((IComponentHierarchyBase<?, ?>) this);
			}
			event.init();
			event.preConfigure();
		}
		return (J) this;
	}
	
	/**
	 * Returns the event type for this event
	 *
	 * @return The associated Event Type
	 */
	@Override
	@NotNull
	@JsonIgnore
	public IEventTypes<?> getEventTypes()
	{
		if (eventType == EventTypes.undefined)
		{
			return EventTypes.undefined;
		}
		else
		{
			return eventType;
		}
	}
	
	/**
	 * Gets all registered events
	 * <p>
	 *
	 * @return A Hash Map containing the event type and the events associated with it
	 */
	@Override
	@NotNull
	public Set<E> getEvents()
	{
		if (events == null)
		{
			events = new LinkedHashSet<>();
		}
		return events;
	}
	
	/**
	 * Returns all the events associated with the given type
	 *
	 * @param eventType All child events on this component with the given event type
	 *
	 * @return An in order list of all the events of the given type for this component
	 */
	@Override
	public Set<IComponentEventBase<?, ?>> getEventsFor(@NotNull IEventTypes<?> eventType)
	{
		Set<IComponentEventBase<?, ?>> output = new LinkedHashSet<>();
		for (E e : getEvents())
		{
			ComponentEventBase<?, ?, ?> next = (ComponentEventBase<?, ?, ?>) e;
			if (next.getEventTypes()
			        .equals(eventType))
			{
				output.add(next);
			}
		}
		return output;
	}
	
	/**
	 * Events are types of feature that have server side support. These are referenced using the Ajax Receiver.
	 * <p>
	 *
	 * @param event The event to be removed
	 *              <p>
	 * @return currently false
	 * <p>
	 */
	@Override
	@NotNull
	@SuppressWarnings("unchecked")
	public J removeEvent(E event)
	{
		getEvents().remove(event);
		return (J) this;
	}
	
	/**
	 * Sets the event type of an event
	 *
	 * @param eventType The given event type
	 * @return This object
	 */
	@Override
	@NotNull
	@SuppressWarnings("unchecked")
	public J setEventType(@NotNull IEventTypes<?> eventType)
	{
		this.eventType = eventType;
		return (J) this;
	}
	
	/**
	 * Returns an event with the given Id
	 *
	 * @param eventId A given id
	 * @return The event or null
	 */
	@Override
	public ComponentEventBase<?, ?, ?> findEvent(@NotNull String eventId)
	{
		for (E e : getEvents())
		{
			ComponentEventBase<?, ?, ?> next = (ComponentEventBase<?, ?, ?>) e;
			if (next.getID()
			        .equals(eventId))
			{
				return next;
			}
		}
		return null;
	}
	
	/**
	 * Returns the event type for this event
	 *
	 * @return the type to be used for event types
	 */
	@JsonProperty("eventType")
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	@SuppressWarnings("unused")
	private IEventTypes<?> getEventTypesJSON()
	{
		if (eventType == EventTypes.undefined)
		{
			return null;
		}
		else
		{
			return eventType;
		}
	}
	
	/**
	 * Adds in the JavaScript References for the Features
	 *
	 * @return The set of all references
	 */
	@SuppressWarnings("RedundantClassCall")
	@Override
	@NotNull
	public Set<CSSReference> getCssReferencesAll()
	{
		Set<CSSReference> allCss = super.getCssReferencesAll();
		getEvents().forEach((E feature) ->
		{
			for (Object css : ComponentEventBase.class.cast(feature)
			                                          .getCssReferencesAll())
			{
				allCss.add(CSSReference.class.cast(css));
			}
		});
		return allCss;
	}
	
	/**
	 * Adds in the JavaScript References for the Features
	 *
	 * @return The set of all javascript references
	 */
	@Override
	@NotNull
	@SuppressWarnings("RedundantClassCall")
	public Set<JavascriptReference> getJavascriptReferencesAll()
	{
		Set<JavascriptReference> allJs = super.getJavascriptReferencesAll();
		getEvents().forEach(feature ->
		{
			for (Object js : ComponentEventBase.class.cast(feature)
			                                         .getJavascriptReferencesAll())
			{
				allJs.add(JavascriptReference.class.cast(js));
			}
		});
		return allJs;
	}
	
	/**
	 * Method hashCode ...
	 *
	 * @return int
	 */
	@Override
	public int hashCode()
	{
		return super.hashCode();
	}
	
	/**
	 * Method equals ...
	 *
	 * @param obj of type Object
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj)
	{
		return super.equals(obj);
	}
	
	@Override
	public void destroy()
	{
		if (events != null)
		{
			events.clear();
			events = null;
		}
		super.destroy();
	}
	
	/**
	 * Checks if this feature has been configured and rendered with all the features
	 */
	@Override
	public void checkAssignedFunctions()
	{
		if (!getEvents().isEmpty())
		{
			getEvents().forEach(GlobalEvents::checkAssignedFunctions);
		}
		super.checkAssignedFunctions();
	}
	
	/**
	 * Sets all features beneath to tiny
	 *
	 * @param tiny if this must render tiny
	 * @return Always this class
	 * @see com.jwebmp.core.base.ComponentBase#setTiny(boolean)
	 */
	@Override
	@NotNull
	public J setTiny(boolean tiny)
	{
		for (E e : getEvents())
		{
			ComponentEventBase<?, ?, ?> next = (ComponentEventBase<?, ?, ?>) e;
			next.setTiny(tiny);
		}
		return super.setTiny(tiny);
	}
	
	/**
	 * Clones the component and all its events
	 *
	 * @return The new cloned object
	 * @see ComponentDependencyBase#cloneComponent()
	 */
	@Override
	@NotNull
	@SuppressWarnings("unchecked")
	public J cloneComponent()
	{
		ComponentEventBase<?, GlobalEvents, ?> cloned = (ComponentEventBase<?, GlobalEvents, ?>) super.cloneComponent();
		cloned.events = new LinkedHashSet<>();
		cloned.events.addAll(getEvents());
		return (J) cloned;
	}
	
}
