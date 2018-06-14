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
package com.jwebmp.base.servlets;

import com.google.inject.Singleton;
import com.jwebmp.Event;
import com.jwebmp.annotations.AjaxCallInterception;
import com.jwebmp.annotations.SiteInterception;
import com.jwebmp.base.ComponentHierarchyBase;
import com.jwebmp.base.ajax.*;
import com.jwebmp.exceptions.InvalidRequestException;
import com.jwebmp.exceptions.MissingComponentException;
import com.jwebmp.guiceinjection.GuiceContext;
import com.jwebmp.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.logger.LogFactory;
import com.jwebmp.utilities.StaticStrings;
import com.jwebmp.utilities.TextUtilities;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request
	 * 		Servlet request
	 * @param response
	 * 		Servlet response
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		super.doPost(request, response);
		processRequest(request);
	}

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 *
	 * @param request
	 * 		Servlet request
	 */
	protected void processRequest(HttpServletRequest request)
	{
		StringBuilder output = new StringBuilder();
		try
		{
			AjaxCall ajaxCallIncoming = (AjaxCall) new JavaScriptPart().From(request.getInputStream(), AjaxCall.class);
			AjaxCall ajaxCall = GuiceContext.getInstance(AjaxCall.class);
			ajaxCall.fromCall(ajaxCallIncoming);

			AjaxResponse ajaxResponse = GuiceContext.getInstance(AjaxResponse.class);

			validateCall(ajaxCall);
			validatePage();
			validateRequest(ajaxCall);

			Event triggerEvent = processEvent();

			if (!GuiceContext.isBuildingInjector())
			{
				intercept();
			}

			triggerEvent.fireEvent(ajaxCall, ajaxResponse);
			ajaxResponse.getComponents()
			            .forEach(a ->
			                     {
				                     ComponentHierarchyBase c = (ComponentHierarchyBase) a;
				                     c.preConfigure();
			                     });
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

	@SiteInterception
	@AjaxCallInterception
	protected void intercept()
	{
		/**
		 * Intercepted with the annotations
		 */
	}
}