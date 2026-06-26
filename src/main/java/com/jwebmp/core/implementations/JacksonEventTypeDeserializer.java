package com.jwebmp.core.implementations;

import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.ValueDeserializer;
import com.google.common.base.Strings;
import com.jwebmp.core.htmlbuilder.javascript.events.enumerations.EventTypes;
import com.jwebmp.core.services.IEventTypes;


public class JacksonEventTypeDeserializer extends ValueDeserializer<IEventTypes<?>>
{
    @Override
    public IEventTypes<?> deserialize(JsonParser p, DeserializationContext ctxt) throws JacksonException
    {
        String valueAsString = p.getValueAsString();
        if (Strings.isNullOrEmpty(valueAsString))
        {
            return null;
        }
        try
        {
            EventTypes eventTypes = EventTypes.valueOf(valueAsString);
            return eventTypes;
        }
        catch (IllegalArgumentException e)
        {
            return null;
        }
    }
}
