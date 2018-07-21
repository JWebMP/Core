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
package com.jwebmp.core.base.servlets;

import com.google.inject.Singleton;
import com.jwebmp.core.Event;
import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.ajax.*;
import com.jwebmp.core.exceptions.InvalidRequestException;
import com.jwebmp.core.exceptions.MissingComponentException;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.core.utilities.StaticStrings;
import com.jwebmp.core.utilities.TextUtilities;
import com.jwebmp.guicedinjection.GuiceContext;
import com.jwebmp.logger.LogFactory;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Modifier;
import java.nio.charset.Charset;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Handles all AJAX Requests performed by a client connection. Session codes are used in order to identify
 * <p>
 *
 * @author Marc Magon
 */
@Singleton
public class AjaxReceiverServlet
		extends JWDefaultServlet
{

	private static final Logger log = LogFactory.getInstance()
	                                            .getLogger("AJAXServlet");
	private static final long serialVersionUID = 1L;

	public AjaxReceiverServlet()
	{
		//Quick construction
	}

	@Override
	public void perform()
	{
		StringBuilder output = new StringBuilder();
		HttpServletRequest request = GuiceContext.get(HttpServletRequest.class);
		try
		{
			AjaxCall ajaxCallIncoming = (AjaxCall) new JavaScriptPart().From(request.getInputStream(), AjaxCall.class);
			AjaxCall ajaxCall = GuiceContext.getInstance(AjaxCall.class);
			ajaxCall.fromCall(ajaxCallIncoming);

			AjaxResponse<?> ajaxResponse = GuiceContext.getInstance(AjaxResponse.class);

			validateCall(ajaxCall);
			validatePage();
			validateRequest(ajaxCall);

			Event triggerEvent = processEvent();

			intercept();
			triggerEvent.fireEvent(ajaxCall, ajaxResponse);
			ajaxResponse.getComponents()
			            .forEach(ComponentHierarchyBase::preConfigure);
			output = new StringBuilder(ajaxResponse.toString());
		}
		catch (InvalidRequestException ie)
		{
			AjaxResponse ajaxResponse = new AjaxResponse();
			ajaxResponse.setSuccess(false);
			AjaxResponseReaction arr = new AjaxResponseReaction("Invalid Request Value", "A value in the request was found to be incorrect.<br>" + ie.getMessage(),
			                                                    ReactionType.DialogDisplay);
			arr.setResponseType(AjaxResponseType.Danger);
			ajaxResponse.addReaction(arr);
			output = new StringBuilder(ajaxResponse.toString());
			log.log(Level.SEVERE, "[SessionID]-[" + request.getSession()
			                                               .getId() + "];" + "[Exception]-[Invalid Request]", ie);
		}
		catch (MissingComponentException mce)
		{
			AjaxResponse ajaxResponse = new AjaxResponse();
			ajaxResponse.setSuccess(false);
			AjaxResponseReaction arr = new AjaxResponseReaction("Invalid Request Value", "The specified Component ID does not seem linked to the page.<br>" + mce.getMessage(),
			                                                    ReactionType.DialogDisplay);
			arr.setResponseType(AjaxResponseType.Danger);
			ajaxResponse.addReaction(arr);
			output = new StringBuilder(ajaxResponse.toString());
			log.log(Level.SEVERE, "[SessionID]-[" + request.getSession()
			                                               .getId() + "];" + "[Exception]-[Missing Component]", mce);
		}
		catch (Exception T)
		{
			AjaxResponse ajaxResponse = new AjaxResponse();
			ajaxResponse.setSuccess(false);
			AjaxResponseReaction arr = new AjaxResponseReaction("Unknown Error",
			                                                    "An AJAX call resulted in an unknown server error<br>" + T.getMessage() + "<br>" + TextUtilities.stackTraceToString(
					                                                    T), ReactionType.DialogDisplay);
			arr.setResponseType(AjaxResponseType.Danger);
			ajaxResponse.addReaction(arr);
			output = new StringBuilder(ajaxResponse.toString());
			log.log(Level.SEVERE, "Unknown in ajax reply\n", T);
		}
		finally
		{
			writeOutput(output, "application/json;charset=UTF-8", Charset.forName("UTF-8"));
		}
	}

	protected Event processEvent() throws InvalidRequestException
	{
		Event triggerEvent = null;
		try
		{
			AjaxCall call = GuiceContext.getInstance(AjaxCall.class);
			Class eventClass = Class.forName(call.getClassName()
			                                     .replace(StaticStrings.CHAR_UNDERSCORE, StaticStrings.CHAR_DOT));
			triggerEvent = (Event) GuiceContext.getInstance(eventClass);
			triggerEvent.setID(call.getEventId());
		}
		catch (ClassNotFoundException cnfe)
		{
			Set<Class<? extends Event>> events = GuiceContext.reflect()
			                                                 .getSubTypesOf(Event.class);
			events.removeIf(event -> Modifier.isAbstract(event.getModifiers()));
			for (Class<? extends Event> event : events)
			{
				Event instance = GuiceContext.getInstance(event);
				if (instance.getID()
				            .equals(GuiceContext.getInstance(AjaxCall.class)
				                                .getEventId()))
				{
					triggerEvent = instance;
					break;
				}
			}
			if (triggerEvent == null)
			{
				log.log(Level.FINEST, "Unable to find the event class specified", cnfe);
				throw new InvalidRequestException("The Event To Be Triggered Could Not Be Found");
			}
		}
		return triggerEvent;
	}
}
