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
package com.jwebmp.core.events.submit;


import com.jwebmp.core.Event;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.html.Form;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.events.BodyEvents;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.html.interfaces.events.ParagraphEvents;
import com.jwebmp.core.events.services.IOnSubmitService;
import com.jwebmp.core.htmlbuilder.javascript.events.enumerations.EventTypes;
import lombok.extern.java.Log;

import java.util.ServiceLoader;
import java.util.Set;
import java.util.logging.Level;

/**
 * Handles all click events. Over-ride methods.
 *
 * @author GedMarc
 */
@SuppressWarnings("unused")
@Log
public abstract class SubmitAdapter<J extends SubmitAdapter<J>>
        extends Event<GlobalFeatures, J>
        implements ParagraphEvents<GlobalFeatures, J>,
                   BodyEvents<GlobalFeatures, J>, GlobalEvents<J>
{
    protected SubmitAdapter()
    {
        super("Submit", EventTypes.submit);
    }

    /**
     * Performs a click
     *
     * @param component The component this click is going to be acting on
     */
    public SubmitAdapter(Form component)
    {
        super(EventTypes.submit, component);
    }

    @Override
    public void fireEvent(AjaxCall<?> call, AjaxResponse<?> response)
    {
        try
        {
            onSubmit(call, response);
            onCall();
        }
        catch (Exception e)
        {
            SubmitAdapter.log.log(Level.SEVERE, "Error In Firing Event", e);
        }
    }

    /**
     * Triggers on Click
     * <p>
     *
     * @param call     The physical AJAX call
     * @param response The physical Ajax Receiver
     */
    public abstract void onSubmit(AjaxCall<?> call, AjaxResponse<?> response);

    /**
     * Method onCall ...
     */
    @SuppressWarnings({"rawtypes",
            "unchecked"})
    private void onCall()
    {
        Set<IOnSubmitService> services = com.guicedee.client.IGuiceContext.instance()
                                                                          .getLoader(IOnSubmitService.class, ServiceLoader.load(IOnSubmitService.class));
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
        @SuppressWarnings({"rawtypes",
                "unchecked"})
        Set<IOnSubmitService> services = com.guicedee.client.IGuiceContext.instance()
                                                                          .getLoader(IOnSubmitService.class, ServiceLoader.load(IOnSubmitService.class));
        services.forEach(service -> service.onCreate(this));
    }
}
