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
package za.co.mmagon.jwebswing.base.servlets;

import com.armineasy.injection.GuiceContext;
import com.google.inject.Singleton;
import za.co.mmagon.jwebswing.Event;
import za.co.mmagon.jwebswing.annotations.AjaxCallInterception;
import za.co.mmagon.jwebswing.annotations.SiteInterception;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.ajax.*;
import za.co.mmagon.jwebswing.base.ajax.exceptions.InvalidRequestException;
import za.co.mmagon.jwebswing.base.ajax.exceptions.MissingComponentException;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.utilities.TextUtilities;
import za.co.mmagon.logger.LogFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.nio.charset.Charset;
import java.util.Iterator;
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
public class AjaxReceiverServlet extends JWDefaultServlet
{
	
	private static final Logger log = LogFactory.getInstance().getLogger("AJAXServlet");
	private static final long serialVersionUID = 1L;
	
	public AjaxReceiverServlet()
	{
		//Quick construction
	}
	
	@SiteInterception
	@AjaxCallInterception
	protected void intercept()
	{
		/**
		 * Intercepted with the annotations
		 */
	}
	
	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 *
	 * @param request  Servlet request
	 * @param response Servlet response
	 *
	 * @throws ServletException if a Servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request)
	{
		StringBuilder output = new StringBuilder();
		try
		{
			AjaxCall ajaxCallIncoming = (AjaxCall) new JavaScriptPart().From(request.getInputStream(), AjaxCall.class);
			AjaxCall ajaxCall = GuiceContext.getInstance(AjaxCall.class);
			ajaxCall.fromCall(ajaxCallIncoming);
			
			AjaxResponse ajaxResponse = GuiceContext.inject().getInstance(AjaxResponse.class);

			validateCall(ajaxCall);
			validatePage();
			validateRequest(ajaxCall);
			
			Event triggerEvent = processEvent();

			if (!GuiceContext.isBuildingInjector())
			{
				intercept();
			}
			
			triggerEvent.fireEvent(ajaxCall, ajaxResponse);
			output = new StringBuilder(ajaxResponse.toString());
			ajaxResponse.getComponents().forEach(ComponentHierarchyBase::preConfigure);
		}
		catch (InvalidRequestException ie)
		{
			AjaxResponse ajaxResponse = new AjaxResponse();
			ajaxResponse.setSuccess(false);
			AjaxResponseReaction arr = new AjaxResponseReaction("Invalid Request Value",
			                                                    "A value in the request was found to be incorrect.<br>"
					                                                    + ie.getMessage(), ReactionType.DialogDisplay);
			arr.setResponseType(AjaxResponseType.Danger);
			ajaxResponse.addReaction(arr);
			output = new StringBuilder(ajaxResponse.toString());
			log.log(Level.SEVERE, "[SessionID]-[" + request.getSession().getId() + "];" + "[Exception]-[Invalid Request]", ie);
		}
		catch (MissingComponentException mce)
		{
			AjaxResponse ajaxResponse = new AjaxResponse();
			ajaxResponse.setSuccess(false);
			AjaxResponseReaction arr = new AjaxResponseReaction("Invalid Request Value",
			                                                    "The specified Component ID does not seem linked to the page.<br>"
					                                                    + mce.getMessage(), ReactionType.DialogDisplay);
			arr.setResponseType(AjaxResponseType.Danger);
			ajaxResponse.addReaction(arr);
			output = new StringBuilder(ajaxResponse.toString());
			log.log(Level.SEVERE, "[SessionID]-[" + request.getSession().getId() + "];" + "[Exception]-[Missing Component]", mce);
		}
		catch (Exception T)
		{
			AjaxResponse ajaxResponse = new AjaxResponse();
			ajaxResponse.setSuccess(false);
			AjaxResponseReaction arr = new AjaxResponseReaction("Unknown Error",
			                                                    "An AJAX call resulted in an unknown server error<br>"
					                                                    + T.getMessage() + "<br>" + TextUtilities.stackTraceToString(T), ReactionType.DialogDisplay);
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
			Class eventClass = Class.forName(GuiceContext.getInstance(AjaxCall.class).getClassName().replace('_', '.'));
			triggerEvent = (Event) GuiceContext.getInstance(eventClass);
		}
		catch (ClassNotFoundException cnfe)
		{
			Set<Class<? extends Event>> events = GuiceContext.reflect().getSubTypesOf(Event.class);
			for (Iterator<Class<? extends Event>> iterator = events.iterator(); iterator.hasNext(); )
			{
				Class<? extends Event> event = iterator.next();
				if (Modifier.isAbstract(event.getModifiers()))
				{
					iterator.remove();
				}
			}
			for (Class<? extends Event> event : events)
			{
				Event instance = GuiceContext.getInstance(event);
				if (instance.getID().equals(GuiceContext.getInstance(AjaxCall.class).getEventId()))
				{
					triggerEvent = instance;
					break;
				}
			}
			if(triggerEvent == null)
			{
				log.log(Level.FINEST,"Unable to find the event class specified",cnfe);
				throw new InvalidRequestException("The Event To Be Triggered Could Not Be Found");
			}
		}
		return triggerEvent;
	}
	
	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request  Servlet request
	 * @param response Servlet response
	 *
	 * @throws ServletException if a Servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		try
		{
			super.doPost(request, response);
			processRequest(request);
		}
		catch (IOException | ServletException e)
		{
			log.log(Level.SEVERE, "Error in post", e);
		}
		
	}
}
