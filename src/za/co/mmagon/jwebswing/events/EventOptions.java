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
package za.co.mmagon.jwebswing.events;

import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptFunction;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.events.enumerations.EventTypes;

/**
 * Basic set of event options
 * @author GedMarc
 * @since 07 Feb 2016
 * @deprecated
 */
public class EventOptions extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;

    private EventTypes eventType;
    private JavascriptFunction valueFunction;

    public EventOptions()
    {
    }

    @Override
    public String toString()
    {
        return "";
    }

    public EventTypes getEventType()
    {
        return eventType;
    }

    public void setEventType(EventTypes eventType)
    {
        this.eventType = eventType;
    }

    public JavascriptFunction getValueFunction()
    {
        return valueFunction;
    }

    public void setValueFunction(JavascriptFunction valueFunction)
    {
        this.valueFunction = valueFunction;
    }

}
