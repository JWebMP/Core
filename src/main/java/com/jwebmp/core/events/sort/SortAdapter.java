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
package com.jwebmp.core.events.sort;

import com.guicedee.guicedinjection.GuiceContext;
import com.jwebmp.core.Event;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
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
public abstract class SortAdapter<J extends SortAdapter<J>>
		extends Event<GlobalFeatures, J>
		implements GlobalEvents<J>
{
	/**
	 * Performs a click
	 *
	 * @param component
	 * 		The component this click is going to be acting on
	 */
	@SuppressWarnings("WeakerAccess")
	public SortAdapter(com.jwebmp.core.base.interfaces.IComponentHierarchyBase<?,?> component)
	{
		super(EventTypes.sort, component);
	}

	/**
	 * The method that is fired on call
	 *
	 * @param call
	 * 		The component that made the call
	 * @param response
	 * 		The Response Object Being Returned
	 */
	@Override
	public void fireEvent(AjaxCall<?> call, AjaxResponse<?> response)
	{
		try
		{
			onCall();
			onSort(call, response);
		}
		catch (Exception e)
		{
			SortAdapter.log.log(Level.SEVERE, "Error In Firing Event", e);
		}
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
		Set<IOnSortService> services = GuiceContext.instance()
		                                           .getLoader(IOnSortService.class, ServiceLoader.load(IOnSortService.class));
		services.forEach(service -> service.onCreate(this));
	}

	/**
	 * Method onCall ...
	 */
	private void onCall()
	{
		Set<IOnSortService> services = GuiceContext.instance()
		                                           .getLoader(IOnSortService.class, ServiceLoader.load(IOnSortService.class));
		services.forEach(service -> service.onCall(this));
	}

	/**
	 * Triggers on Click
	 * <p>
	 *
	 * @param call
	 * 		The physical AJAX call
	 * @param response
	 * 		The physical Ajax Receiver
	 */
	public abstract void onSort(AjaxCall<?> call, AjaxResponse<?> response);
}
