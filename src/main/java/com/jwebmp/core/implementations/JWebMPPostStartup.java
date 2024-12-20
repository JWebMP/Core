package com.jwebmp.core.implementations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guicedee.client.IGuiceContext;
import com.guicedee.guicedinjection.interfaces.IGuicePostStartup;
import com.guicedee.guicedinjection.interfaces.ObjectBinderKeys;
import com.guicedee.services.jsonrepresentation.IJsonRepresentation;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class JWebMPPostStartup implements IGuicePostStartup<JWebMPPostStartup>
{
    @Override
    public List<CompletableFuture<Boolean>> postLoad()
    {
        return List.of(CompletableFuture.supplyAsync(() -> {
            JWebMPJacksonModule jWebMPJacksonModule = new JWebMPJacksonModule();
            IJsonRepresentation.getObjectMapper().registerModule(jWebMPJacksonModule);
            IGuiceContext.get(ObjectMapper.class)
                    .registerModule(jWebMPJacksonModule);
            IGuiceContext.get(ObjectBinderKeys.DefaultObjectMapper)
                    .registerModule(jWebMPJacksonModule);
            return true;
        }));
    }

    @Override
    public Integer sortOrder()
    {
        return 15;
    }
}
