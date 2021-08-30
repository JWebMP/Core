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
package com.jwebmp.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.guicedee.guicedinjection.GuiceContext;
import com.guicedee.guicedinjection.json.StaticStrings;
import com.jwebmp.core.base.ComponentEventBase;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;
import com.jwebmp.core.events.IEventConfigurator;
import com.jwebmp.core.htmlbuilder.javascript.events.enumerations.EventTypes;
import com.jwebmp.core.plugins.jquery.JQueryPageConfigurator;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;

import static com.guicedee.guicedinjection.json.StaticStrings.*;

/**
 * Container Class for Events. Splits from the component hierarchy
 *
 * @param <J>
 * 		This class
 *
 * @author GedMarc
 * @since 23 Apr 2016
 */
@SuppressWarnings("unused")
public abstract class Event<F extends GlobalFeatures, J extends Event<F, J>>
		extends ComponentEventBase<F, GlobalEvents, J>
		implements GlobalEvents<J>
{
	/**
	 * A list of all queries to execute on ajax response
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<Event<?,?>> runEvents;
	/**
	 * Any features that must be run
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<Feature<?,?,?>> runFeatures;

	/**
	 * Constructs an event with the given name
	 *
	 * @param name
	 * 		The name of the event
	 */
	public Event(String name)
	{
		this(name, EventTypes.undefined);
	}

	/**
	 * Constructs an event with the given name
	 *
	 * @param name
	 * 		The name of the event
	 * @param eventType
	 * 		The event type of this event
	 */
	public Event(String name, EventTypes eventType)
	{
		this(name, eventType, null);
	}

	/**
	 * Constructs an event with the given name
	 *
	 * @param name
	 * 		The name of this event
	 * @param eventType
	 * 		The event type of this event
	 * @param component
	 * 		The component type of this event
	 */
	@SuppressWarnings("unchecked")
	public Event(String name, EventTypes eventType, IComponentHierarchyBase<?,?> component)
	{
		super(ComponentTypes.Event);
		setID(getClassCanonicalName());
		setName(name);
		setComponent(component);
		setEventType(eventType);

		@SuppressWarnings("rawtypes")
		Set<IEventConfigurator> eventConfiguratorSet = GuiceContext.instance()
		                                                           .getLoader(IEventConfigurator.class, ServiceLoader.load(IEventConfigurator.class));
		
		for (IEventConfigurator<?> iEventConfigurator : eventConfiguratorSet)
		{
			iEventConfigurator.configureEvent(this);
		}
	}
	
	/**
	 * Adds a variable to return on the call
	 *
	 * @param returnVariable
	 * 		The name of the variable to return
	 *
	 * @return This object
	 */
	@SuppressWarnings("unchecked")
	public J returnVariable(String returnVariable)
	{
		getVariables().add(returnVariable);
		return (J) this;
	}

	/**
	 * Constructs an event with the given name
	 *
	 * @param name
	 * 		The name of this event
	 * @param component
	 * 		The component type of this event
	 */
	public Event(String name, IComponentHierarchyBase<?,?> component)
	{
		this(name, EventTypes.undefined, component);
	}

	/**
	 * Creates an event with the given component and type
	 *
	 * @param component The component to use bind to
	 */
	public Event(IComponentHierarchyBase<?,?> component)
	{
		this(EventTypes.undefined, component);
	}

	/**
	 * Creates an event with the given component and type
	 *
	 * @param eventTypes This event type
	 * @param component The component to bind to
	 */
	public Event(EventTypes eventTypes, IComponentHierarchyBase<?,?> component)
	{
		this(eventTypes.name(), eventTypes, component);
	}

	/**
	 * Render the variable return array
	 *
	 * @return The variables rendered string
	 */
	public StringBuilder renderVariables()
	{
		StringBuilder s = new StringBuilder(StaticStrings.STRING_SQUARE_BRACE_OPEN);
		getVariables().forEach(event -> s.append(STRING_SINGLE_QUOTES)
		                                 .append(event)
		                                 .append(STRING_SINGLE_QUOTES)
		                                 .append(StaticStrings.STRING_COMMNA));
		StringBuilder s2;
		if (s.indexOf(StaticStrings.STRING_COMMNA) > 0)
		{
			s2 = s.deleteCharAt(s.lastIndexOf(StaticStrings.STRING_COMMNA));
		}
		else
		{
			s2 = s;
		}
		s2.append(STRING_SQUARE_BRACE_CLOSED);
		s2.append(STRING_COMMNA_SEMICOLON)
		  .append(getID())
		  .append(STRING_SINGLE_QUOTES);
		s2.append(STRING_COMMNA_SEMICOLON)
		  .append(getClassCanonicalName())
		  .append(STRING_SINGLE_QUOTES);

		return s2;
	}

	/**
	 * The method that is fired on call
	 *
	 * @param call
	 * 		The component that made the call
	 * @param response
	 * 		The Response Object Being Returned
	 */
	public void fireEvent(AjaxCall<?> call, AjaxResponse<?> response)
	{

	}

	/**
	 * Adds an on demand event to be performed after ajax response
	 *
	 * @param event An on demand event (client side only)
	 *
	 * @return  This object
	 */
	@SuppressWarnings("unchecked")
	public J addOnDemandEvent(Event<?,?> event)
	{
		getRunEvents().add(event);
		return (J) this;
	}

	/**
	 * Return all the queries to execute on ajax response
	 *
	 * @return The list of events to run
	 */
	public List<Event<?,?>> getRunEvents()
	{
		if (runEvents == null)
		{
			runEvents = new ArrayList<>();
		}
		return runEvents;
	}

	/**
	 * Returns all queries that are executed on ajax response
	 *
	 * @param onDemandQueries The list of on demand queries to execute
	 *
	 * @return  This object
	 */
	@SuppressWarnings("unchecked")
	public J setOnDemandQueries(List<Event<?,?>> onDemandQueries)
	{
		runEvents = onDemandQueries;
		return (J) this;
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
	 * @param obj
	 * 		of type Object
	 *
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj)
	{
		return super.equals(obj);
	}

	/**
	 * Runs the assign function to components then executes the parents configuration
	 */
	@Override
	public void preConfigure()
	{
		JQueryPageConfigurator.setRequired(true);
		super.preConfigure();
	}

	/**
	 * Sets the ID as whatever with dots as underscores
	 *
	 * @param id
	 * 		The ID
	 *
	 * @return  This object
	 */
	@NotNull
	@Override
	public J setID(String id)
	{
		return super.setID(id.replace(StaticStrings.CHAR_DOT, StaticStrings.CHAR_UNDERSCORE));
	}

	/**
	 * Returns a list of runnable features that occur from an event
	 *
	 * @return The list of features to run that is associated with this event
	 */
	public List<Feature<?,?,?>> getRunFeatures()
	{
		if (runFeatures == null)
		{
			setRunFeatures(new ArrayList<>());
		}
		return runFeatures;
	}

	/**
	 * Sets the running feature base
	 *
	 * @param runFeatures The list of features to run that is associated with this event
	 */
	public void setRunFeatures(List<Feature<?,?,?>> runFeatures)
	{
		this.runFeatures = runFeatures;
	}
}
