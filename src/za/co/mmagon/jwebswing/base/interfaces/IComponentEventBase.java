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
package za.co.mmagon.jwebswing.base.interfaces;

/**
 *
 * @author GedMarc
 * @since $(date)
 *
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import za.co.mmagon.jwebswing.base.ComponentBase;
import za.co.mmagon.jwebswing.base.ComponentEventBase;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.base.references.JavascriptReference;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.events.enumerations.EventTypes;

/**
 *
 * @author GedMarc
 * @param <E> This event type
 * @param <J> Clone type
 *
 * @since $(date)
 *
 */
public interface IComponentEventBase<E extends GlobalEvents, J extends ComponentBase>
{

    /**
     * Adds an event to this object
     * <p>
     * @param event The Event to add
     *
     * @return
     */
    J addEvent(E event);

    /**
     * Adds in the JavaScript References for the Features
     *
     * @return
     */
    List<CSSReference> getCssReferencesAll();

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
     * @return A Hash Map containing the event type and the events associated with it
     */
    List<E> getEvents();

    /**
     * Returns all the events associated with the given type
     *
     * @param eventType
     *
     * @return
     */
    List<ComponentEventBase> getEventsFor(EventTypes eventType);

    /**
     * Adds in the JavaScript References for the Features
     *
     * @return
     */
    List<JavascriptReference> getJavascriptReferencesAll();

    /**
     * In case need to put extra logic here
     *
     * @return
     */
    List<StringBuilder> getQueriesAll();

    /**
     * Events are types of feature that have server side support. These are referenced using the Ajax Receiver.
     * <p>
     * @param event The event to be removed
     * <p>
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
     *
     * @return
     */
    J setTiny(boolean tiny);

    /**
     * Returns an event with the given Id
     *
     * @param eventId
     *
     * @return
     */
    ComponentEventBase getEvent(String eventId);
}
