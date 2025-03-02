package com.jwebmp.core.implementations;

import com.guicedee.guicedinjection.interfaces.IGuicePreStartup;
import com.guicedee.services.jsonrepresentation.IJsonRepresentation;
import com.guicedee.vertx.spi.VertXPreStartup;
import io.vertx.core.Future;

import java.util.List;

public class JWebMPPreStartup implements IGuicePreStartup<JWebMPPreStartup>
{
    @Override
    public List<Future<Boolean>> onStartup()
    {

        return List.of(VertXPreStartup.getVertx().executeBlocking(() -> {
            JWebMPJacksonModule jWebMPJacksonModule = new JWebMPJacksonModule();
            IJsonRepresentation.getObjectMapper().registerModule(jWebMPJacksonModule);
            return true;
        }));
    }

    @Override
    public Integer sortOrder()
    {
        return 15;
    }
}
