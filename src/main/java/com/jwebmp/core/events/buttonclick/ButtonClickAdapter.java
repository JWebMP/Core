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
package com.jwebmp.core.events.buttonclick;

import com.guicedee.guicedinjection.GuiceContext;
import com.jwebmp.core.Event;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.htmlbuilder.javascript.events.enumerations.EventTypes;
import com.jwebmp.core.plugins.ComponentInformation;
import lombok.extern.java.Log;

import java.util.ServiceLoader;
import java.util.Set;

/**
 * This event is triggered when a button is clicked.
 *
 * @author GedMarc
 */
@ComponentInformation(name = "Button Event",
		description = "Server Side Event for Button Click Event.")
@Log
public abstract class ButtonClickAdapter<J extends ButtonClickAdapter<J>>
		extends Event<GlobalFeatures, J>

{
	/**
	 * This event is triggered when a button is clicked.
	 *
	 * @param component
	 * 		The component this click is going to be acting on
	 */
	public ButtonClickAdapter(com.jwebmp.core.base.interfaces.IComponentHierarchyBase<?,?> component)
	{
		super(EventTypes.buttonClickEvent, component);
	}

	/**
	 * The method that is fired on call
	 *
	 * @param ajaxObject
	 * 		The component that made the call
	 * @param ajaxReceiver
	 * 		The Response Object Being Returned
	 */
	@Override
	public void fireEvent(AjaxCall<?> ajaxObject, AjaxResponse<?> ajaxReceiver)
	{
		onButtonClick(ajaxObject, ajaxReceiver);
		onCall();
	}


	/**
	 * Triggers on Activation
	 * <p>
	 *
	 * @param ajaxObject
	 * 		The physical AJAX call
	 * @param ajaxReceiver
	 * 		The physical Ajax Receiver
	 */
	public abstract void onButtonClick(AjaxCall<?> ajaxObject, AjaxResponse<?> ajaxReceiver);

	/**
	 * Method onCall ...
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	private void onCall()
	{
		Set<IOnButtonClickService> services = GuiceContext.instance()
		                                                  .getLoader(IOnButtonClickService.class, ServiceLoader.load(IOnButtonClickService.class));
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
		@SuppressWarnings("rawtypes")
		Set<IOnButtonClickService> services = GuiceContext.instance()
		                                                  .getLoader(IOnButtonClickService.class, ServiceLoader.load(IOnButtonClickService.class));
		services.forEach(service -> service.onCreate(this));
	}
}
