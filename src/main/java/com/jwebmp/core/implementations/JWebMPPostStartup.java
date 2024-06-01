package com.jwebmp.core.implementations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guicedee.client.IGuiceContext;
import com.guicedee.guicedinjection.interfaces.IGuicePostStartup;
import com.guicedee.guicedinjection.interfaces.ObjectBinderKeys;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class JWebMPPostStartup implements IGuicePostStartup<JWebMPPostStartup>
{
    @Override
    public List<CompletableFuture<Boolean>> postLoad()
    {
        return List.of(CompletableFuture.supplyAsync(()-> {
            IGuiceContext.get(ObjectMapper.class)
                         .registerModule(new JWebMPJacksonModule());
            IGuiceContext.get(ObjectBinderKeys.DefaultObjectMapper)
                         .registerModule(new JWebMPJacksonModule());
            return true;
        }));
    }
}
