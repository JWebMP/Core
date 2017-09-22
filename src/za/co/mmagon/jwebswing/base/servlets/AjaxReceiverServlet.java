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
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.annotations.AjaxCallInterception;
import za.co.mmagon.jwebswing.annotations.SiteInterception;
import za.co.mmagon.jwebswing.base.ComponentEventBase;
import za.co.mmagon.jwebswing.base.ajax.*;
import za.co.mmagon.jwebswing.base.ajax.exceptions.InvalidRequestException;
import za.co.mmagon.jwebswing.base.ajax.exceptions.MissingComponentException;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.events.enumerations.EventTypes;
import za.co.mmagon.jwebswing.utilities.TextUtilities;
import za.co.mmagon.logger.LogFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Date;
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
	}
	
	@SiteInterception
	@AjaxCallInterception
	protected void intercept()
	{
	
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
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		Date startDate;
		String output = new String();
		String _eventType = "Servlet Accessed";
		long renderTime = 1L;
		long fireTime = 1L;
		
		try
		{
			AjaxCall ajaxCallIncoming = (AjaxCall) new JavaScriptPart().From(request.getInputStream(), AjaxCall.class);
			AjaxCall ajaxCall = GuiceContext.getInstance(AjaxCall.class);
			ajaxCall.from(ajaxCallIncoming);
			if (ajaxCall.getComponentId() == null)
			{
				log.log(Level.SEVERE, "[SessionID]-[{0}];[Security]-[Component ID Not Found]", request.getSession().getId());
				throw new InvalidRequestException("There is no Component ID in this call.");
			}
			
			String componentId = ajaxCall.getComponentId();
			if (componentId == null || componentId.isEmpty())
			{
				log.log(Level.FINER, "[SessionID]-[{0}];[Security]-[Component ID Incorrect]", request.getSession().getId());
				throw new InvalidRequestException("Component ID Was Incorrect.");
			}
			
			Page page = GuiceContext.inject().getInstance(Page.class);
			
			if (page == null)
			{
				throw new MissingComponentException("Page has not been bound yet. Please use a binder to map Page to the required page object. Also consider using a @Provides method to apply custom logic. See https://github.com/google/guice/wiki/ProvidesMethods ");
			}
			
			Event triggerEvent = null;
			
			try
			{
				Class eventClass = Class.forName(ajaxCallIncoming.getClassName().replace('_', '.'));
				triggerEvent = (Event) GuiceContext.getInstance(eventClass);
			}
			catch (ClassNotFoundException cnfe)
			{
				Set<Class<? extends Event>> events = GuiceContext.reflect().getSubTypesOf(Event.class);
				for (Class<? extends Event> event : events)
				{
					if (Modifier.isAbstract(event.getModifiers()))
					{
						continue;
					}
					Event instance = GuiceContext.getInstance(event);
					if (instance.getID().equals(ajaxCall.getEventId()))
					{
						triggerEvent = instance;
						break;
					}
				}
			}
			
			
			Date datetime = ajaxCall.getDatetime();
			if (datetime == null)
			{
				log.log(Level.SEVERE, "[SessionID]-[{0}];[Security]-[Date Time Incorrect]", request.getSession().getId());
				throw new InvalidRequestException("Invalid Date Time Value");
			}
			EventTypes eventType = ajaxCall.getEventType();
			if (eventType == null)
			{
				log.log(Level.SEVERE, "[SessionID]-[{0}];[Security]-[Event Type Incorrect]", request.getSession().getId());
				throw new InvalidRequestException("Invalid Event Type");
			}
			_eventType = eventType.toString();
			
			EventTypes eventTypeFrom = ajaxCall.getEventTypeFrom();
			if (eventTypeFrom == null)
			{
				log.log(Level.SEVERE, "[SessionID]-[{0}];[Security]-[Event From Incorrect]", request.getSession().getId());
				throw new InvalidRequestException("Invalid Event Type From");
			}
			
			AjaxEventValue value = ajaxCall.getValue();
			
			if (value == null)
			{
				log.log(Level.SEVERE, "[SessionID]-[{0}];[Security]-[Value Is Missing]", request.getSession().getId());
				throw new InvalidRequestException("Invalid Event Value");
			}
			
			Date ajaxCallObjectCreated = new Date();
			
			AjaxResponse ajaxResponse = GuiceContext.inject().getInstance(AjaxResponse.class);
			
			if (!GuiceContext.isBuildingInjector())
			{
				intercept();
			}
			
			triggerEvent.fireEvent(ajaxCall, ajaxResponse);
			
			fireTime = new Date().getTime() - ajaxCallObjectCreated.getTime();
			startDate = new Date();
			output = ajaxResponse.toString();
			ajaxResponse.getComponents().forEach(component ->
			                                     {
				                                     component.preConfigure();
			                                     });
			renderTime = new Date().getTime() - startDate.getTime();
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
			startDate = new Date();
			output = ajaxResponse.toString();
			renderTime = new Date().getTime() - startDate.getTime();
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
			startDate = new Date();
			output = ajaxResponse.toString();
			renderTime = new Date().getTime() - startDate.getTime();
			log.log(Level.SEVERE, "[SessionID]-[" + request.getSession().getId() + "];" + "[Exception]-[Missing Component]", mce);
		}
		catch (IOException T)
		{
			AjaxResponse ajaxResponse = new AjaxResponse();
			ajaxResponse.setSuccess(false);
			AjaxResponseReaction arr = new AjaxResponseReaction("Unknown Error",
			                                                    "An AJAX call resulted in an unknown server error<br>"
					                                                    + T.getMessage() + "<br>" + TextUtilities.stackTraceToString(T), ReactionType.DialogDisplay);
			arr.setResponseType(AjaxResponseType.Danger);
			ajaxResponse.addReaction(arr);
			startDate = new Date();
			output = ajaxResponse.toString();
			renderTime = new Date().getTime() - startDate.getTime();
			log.log(Level.SEVERE, "Unknown in ajax reply\n", T);
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
			startDate = new Date();
			output = ajaxResponse.toString();
			renderTime = new Date().getTime() - startDate.getTime();
			log.log(Level.SEVERE, "Unknown in ajax reply\n", T);
		}
		finally
		{
			try (PrintWriter out = response.getWriter())
			{
				Date dataTransferDate = new Date();
				response.setContentType("application/json;charset=UTF-8");
				response.setCharacterEncoding("UTF-8");
				
				response.setHeader("Access-Control-Allow-Origin", "*");
				response.setHeader("Access-Control-Allow-Credentials", "true");
				response.setHeader("Access-Control-Allow-Methods", "GET, POST");
				response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept");
				
				out.write(output);
				//LOG.log(Level.FINE,"[Ajax Reply]-[" + output + "]");
				long transferTime = new Date().getTime() - dataTransferDate.getTime();
				log.log(Level.FINER, "[SessionID]-[{0}];[EventType]-[{1}];[Render Time]-[{2}];[Data Size]-[{3}];[Transer Time]-[{4}];[Fire Time]-[{5}]", new Object[]
						{
								request.getSession().getId(), _eventType, renderTime, output.length(), transferTime, fireTime
						});
			}
			catch (IOException io)
			{
				log.log(Level.SEVERE, "Unable to send response to client", io);
			}
		}
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
			processRequest(request, response);
		}
		catch (IOException | ServletException e)
		{
			log.log(Level.SEVERE, "Error in post", e);
		}
		
	}
	
	/**
	 * This returns all the event associated with a call
	 *
	 * @param callObject The call object to process
	 * @param eventType  The ComponentEventBase Type to get events for
	 *
	 * @return
	 */
	private ArrayList<ComponentEventBase> getEvents(AjaxCall callObject, EventTypes eventType)
	{
		return callObject.getComponent().getEventsFor(eventType);
	}
}
