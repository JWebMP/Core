package com.jwebmp.core.implementations;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.jwebmp.core.htmlbuilder.javascript.events.interfaces.IEvent;
import com.jwebmp.core.services.IEventTypes;

public class JWebMPJacksonModule extends SimpleModule
{
    public JWebMPJacksonModule()
    {
        addDeserializer(IEvent.class, new JacksonEventDeserializer());
        addDeserializer(IEventTypes.class, new JacksonEventTypeDeserializer());
    }
}
