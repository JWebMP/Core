package com.jwebmp.core.implementations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guicedee.client.IGuiceContext;
import com.guicedee.guicedinjection.interfaces.IGuicePostStartup;
import com.guicedee.guicedinjection.interfaces.ObjectBinderKeys;

public class JWebMPPostStartup implements IGuicePostStartup<JWebMPPostStartup>
{
    @Override
    public void postLoad()
    {
        IGuiceContext.get(ObjectMapper.class)
                     .registerModule(new JWebMPJacksonModule());
        IGuiceContext.get(ObjectBinderKeys.DefaultObjectMapper)
                     .registerModule(new JWebMPJacksonModule());
        ;
    }
}
