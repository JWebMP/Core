/*
 * Copyright (C) 2016 ged_m
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

import java.util.*;
import za.co.mmagon.jwebswing.base.*;
import za.co.mmagon.jwebswing.base.ajax.*;
import za.co.mmagon.jwebswing.base.exceptions.*;
import za.co.mmagon.jwebswing.base.html.interfaces.*;
import za.co.mmagon.jwebswing.base.html.interfaces.events.*;
import za.co.mmagon.jwebswing.base.servlets.enumarations.*;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.*;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.events.enumerations.*;

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
        extends ComponentEventBase<GlobalFeatures, GlobalEvents, Event>
{

    private static final long serialVersionUID = 1L;

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
        component.getPage().getOptions().setAngularEnabled(true);
    }

    /**
     * Adds a variable to return on the call
     *
     * @param returnVariable The name of the variable to return
     */
    public void registerReturnVariableName(String returnVariable)
    {
        getVariables().add(returnVariable);
    }

    /**
     * Adds a variable to return on the call
     *
     * @param returnVariable  The name of the variable to return
     * @param owningComponent The component to assign this variable to
     */
    public void registerReturnVariableName(String returnVariable, String owningComponent)
    {
        getVariables().add(returnVariable);
    }

    /**
     * The variables to return
     */
    private ArrayList<String> variables;

    /**
     * Render the variable return array
     *
     * @return
     */
    public String renderVariables()
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
    public ArrayList<String> getVariables()
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
     */
    public void setVariables(ArrayList<String> variables)
    {
        this.variables = variables;
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
     */
    public void setComponent(ComponentHierarchyBase component)
    {
        if (component == null)
        {
            throw new NullComponentException("Components set for events cannot be null");
        }
        this.component = component;
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
}
