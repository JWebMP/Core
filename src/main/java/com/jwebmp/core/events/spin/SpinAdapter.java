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
package com.jwebmp.core.events.spin;


import com.guicedee.client.*;
import com.jwebmp.core.Event;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.events.services.IOnSpinService;
import com.jwebmp.core.htmlbuilder.javascript.events.enumerations.EventTypes;
import lombok.extern.java.Log;

import java.util.ServiceLoader;
import java.util.Set;
import java.util.logging.Level;

/**
 * Handles all events. Over-ride methods.
 *
 * @author GedMarc
 */
@Log
public abstract class SpinAdapter<J extends SpinAdapter<J>>
        extends Event<GlobalFeatures, J>
        implements GlobalEvents<J>
{
    /**
     * Performs a click
     *
     * @param component The component this click is going to be acting on
     */
    public SpinAdapter(com.jwebmp.core.base.interfaces.IComponentHierarchyBase<?, ?> component)
    {
        super(EventTypes.spin, component);

    }

    @Override
    public void fireEvent(AjaxCall<?> call, AjaxResponse<?> response)
    {
        try
        {
            onSpin(call, response);
            onCall();
        }
        catch (Exception e)
        {
            SpinAdapter.log.log(Level.SEVERE, "Error In Firing Event", e);
        }
    }

    /**
     * Triggers on Click
     * <p>
     *
     * @param call     The physical AJAX call
     * @param response The physical Ajax Receiver
     */
    public abstract void onSpin(AjaxCall<?> call, AjaxResponse<?> response);

    /**
     * Method onCall ...
     */
    private void onCall()
    {
        Set<IOnSpinService> services = IGuiceContext.instance()
                                                    .getLoader(IOnSpinService.class, ServiceLoader.load(IOnSpinService.class));
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
        Set<IOnSpinService> services = IGuiceContext
                .instance()
                .getLoader(IOnSpinService.class, ServiceLoader.load(IOnSpinService.class));
        services.forEach(service -> service.onCreate(this));
    }
}
