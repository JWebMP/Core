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
package com.jwebmp.core.base.interfaces;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jwebmp.core.base.ComponentEventBase;
import com.jwebmp.core.base.html.interfaces.LifeCycle;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.references.CSSReference;
import com.jwebmp.core.base.references.JavascriptReference;
import com.jwebmp.core.htmlbuilder.javascript.events.enumerations.EventTypes;

import java.util.Set;

/**
 * @param <E> This classes capable event type
 * @param <J> This type
 *
 * @author GedMarc
 * @since $(date)
 */
public interface IComponentEventBase<E extends GlobalEvents, J extends IComponentEventBase<E, J>>
		extends GlobalEvents,
		        LifeCycle
{
	/**
	 * Checks if this feature has been configured and rendered with all the features
	 */
	void checkAssignedFunctions();
	
	/**
	 * Adds an event to this object
	 * <p>
	 *
	 * @param event The Event to add
	 * @return
	 */
	J addEvent(E event);
	
	/**
	 * Adds in the JavaScript References for the Features
	 *
	 * @return
	 */
	Set<CSSReference> getCssReferencesAll();
	
	/**
	 * Returns the event type for this event
	 *
	 * @return
	 */
	@JsonProperty(value = "eventType")
	EventTypes getEventTypes();
	
	/**
	 * Gets all registered events
	 * <p>
	 *
	 * @return A Hash Map containing the event type and the events associated with it
	 */
	Set<E> getEvents();
	
	/**
	 * Returns all the events associated with the given type
	 *
	 * @param eventType
	 * @return
	 */
	Set<ComponentEventBase<?, ?, ?>> getEventsFor(EventTypes eventType);
	
	/**
	 * Adds in the JavaScript References for the Features
	 *
	 * @return
	 */
	Set<JavascriptReference> getJavascriptReferencesAll();
	
	/**
	 * In case need to put extra logic here
	 *
	 * @return
	 */
	Set<StringBuilder> getQueriesAll();
	
	/**
	 * Events are types of feature that have server side support. These are referenced using the Ajax Receiver.
	 * <p>
	 *
	 * @param event The event to be removed
	 *              <p>
	 * @return currently false
	 * <p>
	 */
	J removeEvent(E event);
	
	/**
	 * Sets the event type of an event
	 *
	 * @param eventType
	 */
	J setEventType(EventTypes eventType);
	
	/**
	 * Sets all the events to tiny
	 *
	 * @param tiny
	 * @return
	 */
	J setTiny(boolean tiny);
	
	/**
	 * Returns an event with the given Id
	 *
	 * @param eventId
	 * @return
	 */
	IComponentEventBase<?, ?> findEvent(String eventId);
}
