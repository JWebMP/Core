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
package com.jwebmp.events.submit;

import com.jwebmp.Event;
import com.jwebmp.base.ajax.AjaxCall;
import com.jwebmp.base.ajax.AjaxResponse;
import com.jwebmp.base.angular.AngularAttributes;
import com.jwebmp.base.angular.forms.AngularForm;
import com.jwebmp.base.html.interfaces.events.BodyEvents;
import com.jwebmp.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.base.html.interfaces.events.ParagraphEvents;
import com.jwebmp.htmlbuilder.javascript.events.enumerations.EventTypes;
import com.jwebmp.logger.LogFactory;
import com.jwebmp.plugins.ComponentInformation;
import com.jwebmp.utilities.StaticStrings;

import java.util.logging.Level;

/**
 * Handles all click events. Over-ride methods.
 *
 * @author Marc Magon
 */
public abstract class SubmitAdapter
		extends Event<SubmitAdapter>
		implements ParagraphEvents, BodyEvents, GlobalEvents
{

	/**
	 * Logger for the Component
	 */
	@ComponentInformation(name = "Click Event",
			description = "Server Side Event for Click.",
			url = "https://www.armineasy.com/JWebSwing",
			wikiUrl = "https://github.com/GedMarc/JWebSwing/wiki")
	private static final java.util.logging.Logger log = LogFactory.getInstance()
	                                                              .getLogger("ClickEvent");
	private static final long serialVersionUID = 1L;

	protected SubmitAdapter()
	{
		super("Submit", EventTypes.click);
	}

	/**
	 * Performs a click
	 *
	 * @param component
	 * 		The component this click is going to be acting on
	 */
	public SubmitAdapter(AngularForm component)
	{
		super(EventTypes.click, component);
	}

	@Override
	public void fireEvent(AjaxCall call, AjaxResponse response)
	{
		try
		{
			onClick(call, response);
		}
		catch (Exception e)
		{
			log.log(Level.SEVERE, "Error In Firing Event", e);
		}
	}

	@Override
	public void preConfigure()
	{
		if (!isConfigured() && getComponent() != null)
		{
			getComponent().addAttribute(AngularAttributes.ngSubmit,
			                            "jwCntrl.jw.isLoading || " + StaticStrings.STRING_ANGULAR_EVENT_START + renderVariables() + StaticStrings.STRING_CLOSING_BRACKET_SEMICOLON);
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
	public abstract void onClick(AjaxCall call, AjaxResponse response);

}
