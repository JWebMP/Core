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

import com.jwebmp.core.Event;
import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.events.BodyEvents;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.html.interfaces.events.ParagraphEvents;
import com.jwebmp.core.htmlbuilder.javascript.events.enumerations.EventTypes;
import com.jwebmp.core.plugins.ComponentInformation;
import com.guicedee.guicedinjection.GuiceContext;
import com.guicedee.logger.LogFactory;

import java.util.ServiceLoader;
import java.util.Set;
import java.util.logging.Level;

/**
 * Handles all click events. Over-ride methods.
 *
 * @author GedMarc
 */
@ComponentInformation(name = "Click Event",
		description = "Server Side Event for Click.")
public abstract class ClickAdapter<J extends ClickAdapter<J>>
		extends Event<GlobalFeatures, J>
		implements ParagraphEvents<GlobalFeatures, J>,
		           BodyEvents<GlobalFeatures, J>,
		           GlobalEvents
{
	/**
	 * Logger for the Component
	 */
	
	private static final java.util.logging.Logger log = LogFactory.getInstance()
	                                                              .getLogger("ClickEvent");
	
	
	protected ClickAdapter()
	{
		super("ClickAdapter", EventTypes.click);
	}
	
	/**
	 * Performs a click
	 *
	 * @param component The component this click is going to be acting on
	 */
	public ClickAdapter(ComponentHierarchyBase<?,?,?,?,?> component)
	{
		super(EventTypes.click, component);
	}
	
	@Override
	public void fireEvent(AjaxCall<?> call, AjaxResponse<?> response)
	{
		try
		{
			onClick(call, response);
			onCall();
		}
		catch (Exception e)
		{
			ClickAdapter.log.log(Level.SEVERE, "Error In Firing Event", e);
		}
	}
	
	/**
	 * Triggers on Click
	 * <p>
	 *
	 * @param call     The physical AJAX call
	 * @param response The physical Ajax Receiver
	 */
	public abstract void onClick(AjaxCall<?> call, AjaxResponse<?> response);
	
	/**
	 * Method onCall ...
	 */
	private void onCall()
	{
		Set<IOnClickService> services = GuiceContext.instance()
		                                            .getLoader(IOnClickService.class, ServiceLoader.load(IOnClickService.class));
		services.forEach(service -> service.onCall(this));
	}
	
	@Override
	public void preConfigure()
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
		Set<IOnClickService> services = GuiceContext.instance()
		                                            .getLoader(IOnClickService.class, ServiceLoader.load(IOnClickService.class));
		services.forEach(service -> service.onCreate(this));
	}
}
