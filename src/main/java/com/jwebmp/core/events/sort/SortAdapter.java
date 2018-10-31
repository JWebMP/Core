/*
 * Copyright (C) 2017 Marc Magon
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

import com.jwebmp.core.Component;
import com.jwebmp.core.Event;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.angular.AngularAttributes;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.htmlbuilder.javascript.events.enumerations.EventTypes;
import com.jwebmp.core.utilities.StaticStrings;
import com.jwebmp.logger.LogFactory;

import javax.validation.constraints.NotNull;
import java.util.logging.Level;

/**
 * Handles all events. Over-ride methods.
 *
 * @author Marc Magon
 */
public abstract class SortAdapter
		extends Event
		implements GlobalEvents
{

	/**
	 * Logger for the Component
	 */
	private static final java.util.logging.Logger log = LogFactory.getInstance()
	                                                              .getLogger("SortEvent");
	/**
	 * Field serialVersionUID
	 */

	/**
	 * Field directive
	 */
	private SortDirective directive;

	/**
	 * Performs a click
	 *
	 * @param component
	 * 		The component this click is going to be acting on
	 */
	@SuppressWarnings("WeakerAccess")
	public SortAdapter(Component component)
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
	public void fireEvent(AjaxCall call, AjaxResponse response)
	{
		try
		{
			onSort(call, response);
		}
		catch (Exception e)
		{
			SortAdapter.log.log(Level.SEVERE, "Error In Firing Event", e);
		}
	}

	/**
	 * @see com.jwebmp.core.Event#hashCode()
	 */
	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	/**
	 * @see com.jwebmp.core.Event#equals(Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		return super.equals(obj);
	}

	/**
	 * Sets JQuery and Angular enabled, adds the directive to angular, and the attribute to the component
	 *
	 * @see com.jwebmp.core.Event#preConfigure()
	 */
	@Override
	public void preConfigure()
	{
		if (getComponent() != null)
		{

			getComponent().addAttribute(AngularAttributes.ngSort, StaticStrings.STRING_ANGULAR_EVENT_START + renderVariables() + StaticStrings.STRING_CLOSING_BRACKET_SEMICOLON);
		}
		super.preConfigure();
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
	public abstract void onSort(AjaxCall call, AjaxResponse response);

	/**
	 * Returns the angular directive associated with the right click event
	 *
	 * @return The applied directive
	 */
	@NotNull
	public SortDirective getDirective()
	{
		if (directive == null)
		{
			directive = new SortDirective();
		}
		return directive;
	}

	/**
	 * Sets the right click angular event
	 *
	 * @param directive
	 * 		The directive to use
	 */
	public void setDirective(SortDirective directive)
	{
		this.directive = directive;
	}
}
