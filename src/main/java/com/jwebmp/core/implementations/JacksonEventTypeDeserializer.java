package com.jwebmp.core.implementations;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.google.common.base.Strings;
import com.jwebmp.core.htmlbuilder.javascript.events.enumerations.EventTypes;
import com.jwebmp.core.services.IEventTypes;

import java.io.IOException;

public class JacksonEventTypeDeserializer extends JsonDeserializer<IEventTypes<?>>
{
    @Override
    public IEventTypes<?> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException
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
