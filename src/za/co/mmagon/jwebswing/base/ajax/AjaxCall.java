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

import com.fasterxml.jackson.annotation.*;
import com.google.inject.servlet.RequestScoped;
import java.util.*;
import javax.servlet.ServletException;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.events.enumerations.EventTypes;

/**
 *
 * This class handles the decoding of an AJAX call being received
 * <p>
 * @author GedMarc
 * @since 04 May 2015
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@RequestScoped
public class AjaxCall extends JavaScriptPart
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
     * @deprecated
     *
     */
    @Deprecated
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
    private List<AngularJsonVariable> variableData;
    /**
     * The event ID
     */
    private String eventId;

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
     * @param page          The Page
     *
     * @throws ServletException In Case anything is funky
     */
    public AjaxCall(String componentId, Date datetime, String eventType, String eventTypeFrom, AjaxEventValue value, Page page) throws ServletException
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
     * Sets this component ID
     *
     * @param componentId
     */
    public void setComponentId(String componentId)
    {
        this.componentId = componentId;
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
     * Sets the date time of this call
     *
     * @param datetime
     */
    public void setDatetime(Date datetime)
    {
        this.datetime = datetime;
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
     * Sets the event type
     *
     * @param eventType
     */
    public void setEventType(EventTypes eventType)
    {
        this.eventType = eventType;
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
     * Sets this calls event type from
     *
     * @param eventTypeFrom
     */
    public void setEventTypeFrom(EventTypes eventTypeFrom)
    {
        this.eventTypeFrom = eventTypeFrom;
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
     * Sets this calls value
     *
     * @param value
     */
    public void setValue(AjaxEventValue value)
    {
        this.value = value;
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
     * Sets this calls component
     *
     * @param component
     */
    public void setComponent(ComponentHierarchyBase component)
    {
        this.component = component;
    }

    /**
     * Returns JSON strings of inbound variables
     *
     * @return
     */
    public List<AngularJsonVariable> getVariableData()
    {
        if (variableData == null)
        {
            variableData = new ArrayList<>();
        }
        return variableData;
    }

    /**
     * Sets the array list of bound objects?
     *
     * @param variableData
     */
    public void setVariableData(List<AngularJsonVariable> variableData)
    {
        this.variableData = variableData;
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
     * The Event ID
     *
     * @param eventId
     */
    public void setEventId(String eventId)
    {
        this.eventId = eventId;
    }

}
