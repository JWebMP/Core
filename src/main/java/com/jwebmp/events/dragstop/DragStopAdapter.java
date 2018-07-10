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
package com.jwebmp.events.dragstop;

import com.jwebmp.Component;
import com.jwebmp.Event;
import com.jwebmp.base.ajax.AjaxCall;
import com.jwebmp.base.ajax.AjaxResponse;
import com.jwebmp.base.angular.AngularAttributes;
import com.jwebmp.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.htmlbuilder.javascript.events.enumerations.EventTypes;
import com.jwebmp.logger.LogFactory;
import com.jwebmp.plugins.ComponentInformation;
import com.jwebmp.utilities.StaticStrings;

import javax.validation.constraints.NotNull;
import java.util.logging.Level;

/**
 * Handles all events. Over-ride methods.
 *
 * @author Marc Magon
 */
@ComponentInformation(name = "Drag Stop Event",
		description = "Server Side Event for Drag Stop.",
		url = "https://www.armineasy.com/JWebSwing",
		wikiUrl = "https://github.com/GedMarc/JWebSwing/wiki")
public abstract class DragStopAdapter
		extends Event
		implements GlobalEvents
{

	/**
	 * Logger for the Component
	 */
	private static final java.util.logging.Logger LOG = LogFactory.getInstance()
	                                                              .getLogger("DragStopEvent");
	private static final long serialVersionUID = 1L;
	private DragStopDirective directive;

	/**
	 * Performs a click
	 *
	 * @param component
	 * 		The component this click is going to be acting on
	 */
	public DragStopAdapter(Component component)
	{
		super(EventTypes.dragStop, component);

	}

	@Override
	public void fireEvent(AjaxCall call, AjaxResponse response)
	{
		try
		{
			onDragStop(call, response);
		}
		catch (Exception e)
		{
			LOG.log(Level.SEVERE, "Error In Firing Event", e);
		}
	}

	@Override
	public int hashCode()
	{
		int result = super.hashCode();
		result = 31 * result + getDirective().hashCode();
		return result;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof DragStopAdapter))
		{
			return false;
		}
		if (!super.equals(o))
		{
			return false;
		}

		DragStopAdapter that = (DragStopAdapter) o;

		return getDirective().equals(that.getDirective());
	}

	/**
	 * Sets JQuery and Angular enabled, adds the directive to angular, and the attribute to the component
	 */
	@Override
	public void preConfigure()
	{
		if (!isConfigured())
		{


			getComponent().addAttribute(AngularAttributes.ngDragStop,
			                            StaticStrings.STRING_ANGULAR_EVENT_START + renderVariables() + StaticStrings.STRING_CLOSING_BRACKET_SEMICOLON);
		}
		super.preConfigure();
	}

	/**
	 * Returns the angular directive associated with the right click event
	 *
	 * @return
	 */
	@NotNull
	public DragStopDirective getDirective()
	{
		if (directive == null)
		{
			directive = new DragStopDirective();
		}
		return directive;
	}

	/**
	 * Sets the right click angular event
	 *
	 * @param directive
	 */
	public void setDirective(DragStopDirective directive)
	{
		this.directive = directive;
	}

	/**
	 * Triggers on Drag Stop
	 * <p>
	 *
	 * @param call
	 * 		The physical AJAX call
	 * @param response
	 * 		The physical Ajax Receiver
	 */
	public abstract void onDragStop(AjaxCall call, AjaxResponse response);
}
