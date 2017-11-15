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
package za.co.mmagon.jwebswing;

import com.armineasy.injection.GuiceContext;
import com.fasterxml.jackson.annotation.JsonInclude;
import za.co.mmagon.jwebswing.base.ComponentEventBase;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.angular.AngularPageConfigurator;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.events.enumerations.EventTypes;
import za.co.mmagon.jwebswing.plugins.jquery.JQueryPageConfigurator;
import za.co.mmagon.jwebswing.utilities.StaticStrings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static za.co.mmagon.jwebswing.utilities.StaticStrings.STRING_COMMNA;
import static za.co.mmagon.jwebswing.utilities.StaticStrings.STRING_SINGLE_QUOTES;

/**
 * Container Class for Events. Splits from the component hierarchy
 *
 * @param <A>
 * 		Ajax Event type object back
 * @param <J>
 * 		This class
 *
 * @author GedMarc
 * @since 23 Apr 2016
 */
public abstract class Event<A extends JavaScriptPart, J extends Event>
		extends ComponentEventBase<GlobalFeatures, GlobalEvents, Event<A, J>> implements GlobalEvents
{

	private static final long serialVersionUID = 1L;

	/**
	 * A list of all queries to execute on ajax response
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<Event> runEvents;
	/**
	 * Any features that must be run
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<Feature> runFeatures;
	/**
	 * A set of components that this event can construct
	 */
	private Set<Class<? extends ComponentHierarchyBase>> registeredComponents;

	/**
	 * Creates an event with the given component and type
	 *
	 * @param eventTypes
	 * @param component
	 */
	public Event(EventTypes eventTypes, ComponentHierarchyBase component)
	{
		this(eventTypes.name(), eventTypes, component);
	}

	/**
	 * Creates an event with the given component and type
	 *
	 * @param component
	 */
	public Event(ComponentHierarchyBase component)
	{
		this(EventTypes.undefined, component);
	}

	/**
	 * Constructs an event with the given name
	 *
	 * @param name
	 * @param eventType
	 */
	public Event(String name, EventTypes eventType)
	{
		this(name, eventType, null);
	}

	/**
	 * Constructs an event with the given name
	 *
	 * @param name
	 */
	public Event(String name)
	{
		this(name, EventTypes.undefined);
	}

	/**
	 * Constructs an event with the given name
	 *
	 * @param name
	 * 		The name of this event
	 * @param component
	 * 		The component type of this event
	 */
	public Event(String name, ComponentHierarchyBase component)
	{
		this(name, EventTypes.undefined, component);
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
	public Event(String name, EventTypes eventType, ComponentHierarchyBase component)
	{
		super(ComponentTypes.Event);
		setID(getClassCanonicalName());
		setName(name);
		setComponent(component);
		setEventType(eventType);
	}

	/**
	 * Sets the ID as whatever with dots as underscores
	 *
	 * @param id
	 * 		The ID
	 *
	 * @return
	 */
	@Override
	public Event<A, J> setID(String id)
	{
		return super.setID(id.replace(StaticStrings.CHAR_DOT, StaticStrings.CHAR_UNDERSCORE));
	}

	/**
	 * Adds a variable to return on the call
	 *
	 * @param returnVariable
	 * 		The name of the variable to return
	 *
	 * @return
	 */
	public J returnVariable(String returnVariable)
	{
		getVariables().add(returnVariable);
		return (J) this;
	}

	/**
	 * Render the variable return array
	 *
	 * @return
	 */
	public StringBuilder renderVariables()
	{
		final StringBuilder s = new StringBuilder("[");
		getVariables().forEach(event -> s.append(STRING_SINGLE_QUOTES).append(event).append(STRING_SINGLE_QUOTES).append(STRING_COMMNA));
		StringBuilder s2;
		if (s.indexOf(STRING_COMMNA) > 0)
		{
			s2 = s.deleteCharAt(s.lastIndexOf(STRING_COMMNA));
		}
		else
		{
			s2 = s;
		}
		s2.append("]");
		s2.append(",'").append(getID()).append(STRING_SINGLE_QUOTES);
		s2.append(",'").append(getClassCanonicalName()).append(STRING_SINGLE_QUOTES);

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
	public void fireEvent(AjaxCall call, AjaxResponse response)
	{

	}

	/**
	 * Adds an on demand event to be performed after ajax response
	 *
	 * @param event
	 *
	 * @return
	 */
	public J addOnDemandEvent(Event event)
	{
		getRunEvents().add(event);
		return (J) this;
	}

	/**
	 * Return all the queries to execute on ajax response
	 *
	 * @return
	 */
	public List<Event> getRunEvents()
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
	 * @param onDemandQueries
	 *
	 * @return
	 */
	public J setOnDemandQueries(List<Event> onDemandQueries)
	{
		this.runEvents = onDemandQueries;
		return (J) this;
	}

	/**
	 * Returns a list of runnable features that occur from an event
	 *
	 * @return
	 */
	public List<Feature> getRunFeatures()
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
	 * @param runFeatures
	 */
	public void setRunFeatures(List<Feature> runFeatures)
	{
		this.runFeatures = runFeatures;
	}


	/**
	 * A set of components that this event can construct/be called from (same thing)
	 *
	 * @return
	 */
	public Set<Class<? extends ComponentHierarchyBase>> getRegisteredComponents()
	{
		if (registeredComponents == null)
		{
			setRegisteredComponents(new HashSet<>());
		}
		return registeredComponents;
	}

	/**
	 * A set of components that this event can construct/be called from (same thing)
	 *
	 * @param registeredComponents
	 *
	 * @return
	 */
	public J setRegisteredComponents(Set<Class<? extends ComponentHierarchyBase>> registeredComponents)
	{
		this.registeredComponents = registeredComponents;
		return (J) this;
	}


	/**
	 * Sets the given component and class for this events. Component instance is destroyed on delivery
	 *
	 * @param component
	 *
	 * @return
	 */
	@Override
	public Event<A, J> setComponent(ComponentHierarchyBase component)
	{
		if (component != null)
		{
			getRegisteredComponents().add(component.getClass());
		}
		return super.setComponent(component);
	}

	/**
	 * Runs the assign function to components then executes the parents configuration
	 */
	@Override
	public void preConfigure()
	{
		if (!isConfigured() && !GuiceContext.isBuildingInjector())
		{
			assignFunctionsToComponent();
			if (getComponent() != null)
			{
				Page p = getComponent().getPage();
				JQueryPageConfigurator.setRequired(p.getBody(), true);
				AngularPageConfigurator.setRequired(p.getBody(), true);
			}
		}

		super.preConfigure();
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof Event))
		{
			return false;
		}
		if (!super.equals(o))
		{
			return false;
		}

		Event<?, ?> event = (Event<?, ?>) o;

		if (!getVariables().equals(event.getVariables()))
		{
			return false;
		}
		if (!getRunEvents().equals(event.getRunEvents()))
		{
			return false;
		}
		if (!getRunFeatures().equals(event.getRunFeatures()))
		{
			return false;
		}
		return getRegisteredComponents().equals(event.getRegisteredComponents());
	}

	@Override
	public int hashCode()
	{
		int result = super.hashCode();
		result = 31 * result + getVariables().hashCode();
		result = 31 * result + getRunEvents().hashCode();
		result = 31 * result + getRunFeatures().hashCode();
		result = 31 * result + getRegisteredComponents().hashCode();
		return result;
	}
}
