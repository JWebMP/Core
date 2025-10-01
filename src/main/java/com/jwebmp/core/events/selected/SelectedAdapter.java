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
package com.jwebmp.core.events.selected;


import com.guicedee.client.*;
import com.jwebmp.core.Event;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.html.Option;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.events.services.IOnSelectedService;
import com.jwebmp.core.htmlbuilder.javascript.events.enumerations.EventTypes;
import io.smallrye.mutiny.Uni;
import lombok.extern.java.Log;

import java.util.ServiceLoader;
import java.util.Set;
import java.util.logging.Level;

/**
 * Sets the selected attribute on the element, if the expression inside ngSelected is truthy.
 * <p>
 * A special directive is necessary because we cannot use interpolation inside the selected attribute. See the interpolation guide for more info.
 *
 * @author GedMarc
 */
@Log
public abstract class SelectedAdapter<J extends SelectedAdapter<J>>
        extends Event<GlobalFeatures, J>
        implements GlobalEvents<J>
{
    /**
     * Performs a click
     *
     * @param component The component this click is going to be acting on
     */
    public SelectedAdapter(Option component)
    {
        super(EventTypes.selected, component);
    }

    @Override
    public Uni<Void> fireEvent(AjaxCall<?> call, AjaxResponse<?> response)
    {
        try
        {
            onSelected(call, response);
            onCall();
        }
        catch (Exception e)
        {
            SelectedAdapter.log.log(Level.SEVERE, "Error In Firing Event", e);
        }
        return Uni.createFrom()
                  .voidItem();
    }

    /**
     * Triggers on Click
     * <p>
     *
     * @param call     The physical AJAX call
     * @param response The physical Ajax Receiver
     */
    public abstract void onSelected(AjaxCall<?> call, AjaxResponse<?> response);


    /**
     * Method onCall ...
     */
    private void onCall()
    {
        Set<IOnSelectedService> services = IGuiceContext.instance()
                                                        .getLoader(IOnSelectedService.class, ServiceLoader.load(IOnSelectedService.class));
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
    private void onCreate()
    {
        Set<IOnSelectedService> services = IGuiceContext
                .instance()
                .getLoader(IOnSelectedService.class, ServiceLoader.load(IOnSelectedService.class));
        services.forEach(service -> service.onCreate(this));
    }
}
