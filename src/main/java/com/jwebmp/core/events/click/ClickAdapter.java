/*
 * Copyright (C) 2017 GedMarc
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.jwebmp.core.events.click;


import com.guicedee.client.IGuiceContext;
import com.jwebmp.core.Event;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.events.BodyEvents;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.html.interfaces.events.ParagraphEvents;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.events.services.IOnClickService;
import com.jwebmp.core.htmlbuilder.javascript.events.enumerations.EventTypes;
import io.smallrye.mutiny.Uni;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;

import java.util.ServiceLoader;
import java.util.Set;
import java.util.logging.Level;

/**
 * Handles all click events. Over-ride methods.
 *
 * @author GedMarc
 */
@Log4j2
public abstract class ClickAdapter<J extends ClickAdapter<J>>
        extends Event<GlobalFeatures, J>
        implements ParagraphEvents<GlobalFeatures, J>,
        BodyEvents<GlobalFeatures, J>,
        GlobalEvents<J>
{
    protected ClickAdapter()
    {
        super("ClickAdapter", EventTypes.click);
    }

    /**
     * Performs a click
     *
     * @param component The component this click is going to be acting on
     */
    public ClickAdapter(IComponentHierarchyBase<?, ?> component)
    {
        super(EventTypes.click, component);
    }

    @Override
    public Uni<Void> fireEvent(AjaxCall<?> call, AjaxResponse<?> response)
    {
        return onClick(call, response)
                .onFailure()
                .invoke(t -> log.error("fireEvent: onClick Uni failed for {}", getClass().getName(), t))
                // Use call(...) to make onCall() an ordered side-effect without changing the item
                .call(() -> {
                    try
                    {
                        onCall();
                    }
                    catch (Throwable t)
                    {
                        log.error("fireEvent: onCall() threw", t);
                        // Don’t fail the chain because a legacy onCall() may throw unexpectedly
                    }
                    return io.smallrye.mutiny.Uni.createFrom()
                                                 .voidItem();
                })
                ;
        //.onTermination()
        //.invoke(() -> log.info("fireEvent: terminated for {}", getClass().getName()));
    }

    /**
     * Triggers on Click
     * <p>
     *
     * @param call     The physical AJAX call
     * @param response The physical Ajax Receiver
     * @return
     */
    public abstract Uni<Void> onClick(AjaxCall<?> call, AjaxResponse<?> response);

    /**
     * Method onCall ...
     */
    private void onCall()
    {
        Set<IOnClickService> services = IGuiceContext.instance()
                                                     .getLoader(IOnClickService.class, ServiceLoader.load(IOnClickService.class));
        services.forEach(service -> service.onCall(this));
    }

    @Override
    protected void preConfigure()
    {
        if (!isConfigured())
        {
            onCreate();
        }
        super.preConfigure();
    }

    /**
     * Occurs when the event is called
     */
    @SuppressWarnings("unchecked")
    protected void onCreate()
    {
        Set<IOnClickService> services = IGuiceContext
                .instance()
                .getLoader(IOnClickService.class, ServiceLoader.load(IOnClickService.class));
        services.forEach(service -> service.onCreate(this));
    }
}
