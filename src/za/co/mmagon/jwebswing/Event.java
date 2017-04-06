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

import java.util.ArrayList;
import java.util.List;
import za.co.mmagon.jwebswing.base.ComponentEventBase;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.angular.AngularPageConfigurator;
import za.co.mmagon.jwebswing.base.exceptions.NullComponentException;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.events.enumerations.EventTypes;
import za.co.mmagon.jwebswing.plugins.jquery.JQueryPageConfigurator;

/**
 * Container Class for Events. Splits from the component hierarchy
 *
 * @author GedMarc
 * @param <A> Ajax Event type object back
 * @param <J> This class
 *
 * @since 23 Apr 2016
 */
public class Event<A extends JavaScriptPart, J extends Event>
        extends ComponentEventBase<GlobalFeatures, GlobalEvents, Event> implements GlobalEvents
{

    private static final long serialVersionUID = 1L;

    /**
     * The variables to return
     */
    private List<String> variables;

    /**
     * A list of all queries to execute on ajax response
     */
    private List<Event> runEvents;
    /**
     * Any features that must be run
     */
    private List<Feature> runFeatures;

    /**
     * Creates an event with the given component and type
     *
     * @param eventTypes
     * @param component
     */
    public Event(EventTypes eventTypes, ComponentHierarchyBase component)
    {
        this(eventTypes.name(), eventTypes);
        setComponent(component);
        AngularPageConfigurator.setRequired(component, true);
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
     * @param name      The name of this event
     * @param eventType The event type of this event
     * @param component The component type of this event
     */
    public Event(String name, EventTypes eventType, ComponentHierarchyBase component)
    {
        super(ComponentTypes.Event);
        setName(name);
        this.component = component;
        setEventType(eventType);
    }

    /**
     * Constructs an event with the given name
     *
     * @param name      The name of this event
     * @param component The component type of this event
     */
    public Event(String name, ComponentHierarchyBase component)
    {
        this(name, EventTypes.undefined, component);
    }

    /**
     * Adds a variable to return on the call
     *
     * @param returnVariable The name of the variable to return
     *
     * @return
     */
    public J registerReturnVariableName(String returnVariable)
    {
        getVariables().add(returnVariable);
        return (J) this;
    }

    /**
     * Adds a variable to return on the call
     *
     * @param returnVariable  The name of the variable to return
     * @param owningComponent The component to assign this variable to
     *
     * @return
     */
    public J registerReturnVariableName(String returnVariable, String owningComponent)
    {
        getVariables().add(returnVariable);
        return (J) this;
    }

    /**
     * Render the variable return array
     *
     * @return
     */
    protected String renderVariables()
    {
        final StringBuilder s = new StringBuilder("[");
        getVariables().stream().forEach((event) ->
        {
            s.append("'").append(event).append("'").append(",");
        });
        StringBuilder s2;
        if (s.indexOf(",") > 0)
        {
            s2 = s.deleteCharAt(s.lastIndexOf(","));
        }
        else
        {
            s2 = s;
        }
        s2.append("]");

        //append Event ID
        s2.append(",'").append(getID()).append("'");

        return s2.toString();
    }

    /**
     * Returns the list of currently associated variables
     *
     * @return
     */
    @Override
    public List<String> getVariables()
    {
        if (variables == null)
        {
            variables = new ArrayList<>();
        }
        return variables;
    }

    /**
     * Sets the current list of variables to return
     *
     * @param variables
     *
     * @return
     */
    public J setVariables(List<String> variables)
    {
        this.variables = variables;
        return (J) this;
    }

    /**
     * The method that is fired on call
     *
     * @param call     The component that made the call
     * @param response The Response Object Being Returned
     */
    public void fireEvent(AjaxCall call, AjaxResponse response)
    {

    }

    /**
     * Returns the linked component if required
     *
     * @return
     */
    public ComponentHierarchyBase getComponent()
    {
        return component;
    }

    /**
     * Sets the linked component if required
     *
     * @param component
     *
     * @return
     */
    public final J setComponent(ComponentHierarchyBase component)
    {
        if (component == null)
        {
            throw new NullComponentException("Components set for events cannot be null");
        }
        this.component = component;
        return (J) this;
    }

    /**
     * Adds a query to builder
     *
     * @param query
     *
     * @return Adds a query to the window
     */
    public J addQuery(StringBuilder query)
    {
        if (!getQueries().contains(query))
        {
            getQueries().add(query);
        }
        return (J) this;
    }

    /**
     * Adds a query to builder
     *
     * @param query
     *
     * @return
     */
    public J addQuery(String query)
    {
        StringBuilder sb = new StringBuilder(query);
        if (!getQueries().contains(sb))
        {
            getQueries().add(new StringBuilder(query));
        }
        return (J) this;
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

    @Override
    public void preConfigure()
    {
        if (!isConfigured())
        {
            assignFunctionsToComponent();
            JQueryPageConfigurator.setRequired((Component) getComponent(), true);
        }
        super.preConfigure();
    }

}
