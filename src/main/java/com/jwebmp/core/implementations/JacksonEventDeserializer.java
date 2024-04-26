package com.jwebmp.core.implementations;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.jwebmp.core.Event;
import com.jwebmp.core.htmlbuilder.javascript.events.interfaces.IEvent;

import java.io.IOException;

public class JacksonEventDeserializer extends JsonDeserializer<IEvent<?, ?>>
{
    @Override
    public IEvent<?, ?> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException
    {
        String valueAsString = p.getValueAsString();
        Event o = (Event) new Event("")
        {
        }.fromJson(valueAsString);

        return o;
    }
}
