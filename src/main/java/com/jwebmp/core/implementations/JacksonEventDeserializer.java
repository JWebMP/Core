package com.jwebmp.core.implementations;

import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.ValueDeserializer;
import com.jwebmp.core.Event;
import com.jwebmp.core.htmlbuilder.javascript.events.interfaces.IEvent;


public class JacksonEventDeserializer extends ValueDeserializer<IEvent<?, ?>>
{
    @Override
    public IEvent<?, ?> deserialize(JsonParser p, DeserializationContext ctxt) throws JacksonException
    {
        String valueAsString = p.getValueAsString();
        Event o = (Event) new Event("")
        {
        }.fromJson(valueAsString);

        return o;
    }
}
