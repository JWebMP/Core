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
package com.jwebmp.core.base.servlets;

import com.google.inject.*;
import com.guicedee.guicedinjection.representations.*;
import com.guicedee.guicedservlets.*;
import com.guicedee.logger.*;
import com.jwebmp.core.*;
import com.jwebmp.core.base.ajax.*;
import com.jwebmp.core.exceptions.*;
import com.jwebmp.core.utilities.*;
import com.jwebmp.interception.services.*;
import jakarta.servlet.http.*;

import java.util.logging.*;

import static com.guicedee.guicedinjection.GuiceContext.*;
import static com.guicedee.guicedinjection.json.StaticStrings.*;
import static com.jwebmp.interception.JWebMPInterceptionBinder.*;
import static java.nio.charset.StandardCharsets.*;

/**
 * Handles all AJAX Requests performed by a client connection. Session codes are used in order to identify
 * <p>
 *
 * @author GedMarc
 */
@Singleton
public class AjaxReceiverServlet
		extends JWDefaultServlet
{
	private static final Logger log = LogFactory.getInstance()
	                                            .getLogger("AJAXServlet");
	
	public AjaxReceiverServlet()
	{
		//Quick construction
	}
	
	@Override
	public void perform()
	{
		StringBuilder output = new StringBuilder();
		HttpServletRequest request = get(GuicedServletKeys.getHttpServletRequestKey());
		try
		{
			AjaxCall<?> ajaxCallIncoming = IJsonRepresentation.From(request.getInputStream(), AjaxCall.class);
			AjaxCall<?> ajaxCall = get(AjaxCall.class);
			ajaxCall.fromCall(ajaxCallIncoming);
			ajaxCall.setPageCall(true);
			AjaxResponse<?> ajaxResponse = get(AjaxResponse.class);
			
			validateCall(ajaxCall);
			validatePage();
			validateRequest(ajaxCall);
			Event<?, ?> triggerEvent = processEvent();
			
			for (AjaxCallIntercepter<?> ajaxCallIntercepter : get(AjaxCallInterceptorKey))
			{
				ajaxCallIntercepter.intercept(ajaxCall, ajaxResponse);
			}
			
			triggerEvent.fireEvent(ajaxCall, ajaxResponse);
			
			output = new StringBuilder(ajaxResponse.toString());
		}
		catch (InvalidRequestException ie)
		{
			AjaxResponse<?> ajaxResponse = new AjaxResponse<>();
			ajaxResponse.setSuccess(false);
			AjaxResponseReaction<?> arr = new AjaxResponseReaction<>("Invalid Request Value", "A value in the request was found to be incorrect.<br>" + ie.getMessage(),
					ReactionType.DialogDisplay);
			arr.setResponseType(AjaxResponseType.Danger);
			ajaxResponse.addReaction(arr);
			output = new StringBuilder(ajaxResponse.toString());
			AjaxReceiverServlet.log.log(Level.SEVERE, "[SessionID]-[" + request.getSession()
			                                                                   .getId() + "];" + "[Exception]-[Invalid Request]", ie);
		}
		catch (MissingComponentException mce)
		{
			AjaxResponse<?> ajaxResponse = new AjaxResponse<>();
			ajaxResponse.setSuccess(false);
			AjaxResponseReaction<?> arr = new AjaxResponseReaction<>("Invalid Request Value", "The specified Component ID does not seem linked to the page.<br>" + mce.getMessage(),
					ReactionType.DialogDisplay);
			arr.setResponseType(AjaxResponseType.Danger);
			ajaxResponse.addReaction(arr);
			output = new StringBuilder(ajaxResponse.toString());
			AjaxReceiverServlet.log.log(Level.SEVERE, "[SessionID]-[" + request.getSession()
			                                                                   .getId() + "];" + "[Exception]-[Missing Component]", mce);
		}
		catch (Exception T)
		{
			AjaxResponse<?> ajaxResponse = new AjaxResponse<>();
			ajaxResponse.setSuccess(false);
			AjaxResponseReaction<?> arr = new AjaxResponseReaction<>("Unknown Error",
					"An AJAX call resulted in an unknown server error<br>" + T.getMessage() + "<br>" + TextUtilities.stackTraceToString(
							T), ReactionType.DialogDisplay);
			arr.setResponseType(AjaxResponseType.Danger);
			ajaxResponse.addReaction(arr);
			output = new StringBuilder(ajaxResponse.toString());
			AjaxReceiverServlet.log.log(Level.SEVERE, "Unknown in ajax reply\n", T);
		}
		finally
		{
			writeOutput(output, "application/json;charset=UTF-8", UTF_8);
		}
	}
	
	protected Event<?, ?> processEvent() throws InvalidRequestException
	{
		Event<?, ?> triggerEvent = null;
		try
		{
			AjaxCall<?> call = get(AjaxCall.class);
			Class<?> eventClass = Class.forName(call.getClassName()
			                                        .replace(CHAR_UNDERSCORE, CHAR_DOT));
			triggerEvent = (Event<?, ?>) get(eventClass);
		}
		catch (ClassNotFoundException cnfe)
		{
			AjaxReceiverServlet.log.log(Level.FINEST, "Unable to find the event class specified", cnfe);
			throw new InvalidRequestException("The Event To Be Triggered Could Not Be Found");
		}
		return triggerEvent;
	}
}
