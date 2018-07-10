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
package com.jwebmp.events.rightclick;

import com.jwebmp.Component;
import com.jwebmp.Event;
import com.jwebmp.base.ajax.AjaxCall;
import com.jwebmp.base.ajax.AjaxResponse;
import com.jwebmp.base.angular.AngularAttributes;
import com.jwebmp.base.html.interfaces.events.BodyEvents;
import com.jwebmp.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.base.html.interfaces.events.ParagraphEvents;
import com.jwebmp.htmlbuilder.javascript.events.enumerations.EventTypes;
import com.jwebmp.logger.LogFactory;
import com.jwebmp.utilities.StaticStrings;

import javax.validation.constraints.NotNull;
import java.util.logging.Level;

/**
 * Handles all on right click events. Over-ride methods.
 *
 * @author Marc Magon
 */
public abstract class RightClickAdapter
		extends Event
		implements ParagraphEvents, BodyEvents, GlobalEvents
{

	/**
	 * Logger for the Component
	 */
	private static final java.util.logging.Logger log = LogFactory.getInstance()
	                                                              .getLogger("RightClickEvent");
	private static final long serialVersionUID = 1L;
	private RightClickDirective rightClickDirective;

	/**
	 * Performs a click
	 *
	 * @param component
	 * 		The component this click is going to be acting on
	 */
	public RightClickAdapter(Component component)
	{
		super(EventTypes.contextmenu, component);

	}

	@Override
	public void fireEvent(AjaxCall call, AjaxResponse response)
	{
		try
		{
			onRightClick(call, response);
		}
		catch (Exception e)
		{
			log.log(Level.SEVERE, "Error In Firing Event", e);
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
		if (!(o instanceof RightClickAdapter))
		{
			return false;
		}
		if (!super.equals(o))
		{
			return false;
		}

		RightClickAdapter that = (RightClickAdapter) o;

		return rightClickDirective.equals(that.rightClickDirective);
	}

	@Override
	public void preConfigure()
	{
		if (!isConfigured())
		{


			getComponent().addAttribute(AngularAttributes.ngRightClick,
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
	public RightClickDirective getDirective()
	{
		if (rightClickDirective == null)
		{
			rightClickDirective = new RightClickDirective();
		}
		return rightClickDirective;
	}

	/**
	 * Sets the right click angular event
	 *
	 * @param rightClickDirective
	 */
	public void setDirective(RightClickDirective rightClickDirective)
	{
		this.rightClickDirective = rightClickDirective;
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
	public abstract void onRightClick(AjaxCall call, AjaxResponse response);
}
