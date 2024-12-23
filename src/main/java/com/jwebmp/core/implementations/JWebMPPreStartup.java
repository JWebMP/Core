package com.jwebmp.core.implementations;

import com.guicedee.guicedinjection.interfaces.IGuicePreStartup;
import com.guicedee.services.jsonrepresentation.IJsonRepresentation;

public class JWebMPPreStartup implements IGuicePreStartup<JWebMPPreStartup>
{
    @Override
    public void onStartup()
    {
        JWebMPJacksonModule jWebMPJacksonModule = new JWebMPJacksonModule();
        IJsonRepresentation.getObjectMapper().registerModule(jWebMPJacksonModule);
    }

    @Override
    public Integer sortOrder()
    {
        return 15;
    }
}
