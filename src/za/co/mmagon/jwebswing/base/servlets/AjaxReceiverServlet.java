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
import com.armineasy.injection.filters.CorsAllowedFilter;
import com.google.inject.Singleton;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.mmagon.jwebswing.*;
import za.co.mmagon.jwebswing.annotations.AjaxCallInterception;
import za.co.mmagon.jwebswing.annotations.SiteInterception;
import za.co.mmagon.jwebswing.base.ComponentEventBase;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.ajax.*;
import za.co.mmagon.jwebswing.base.ajax.exceptions.InvalidRequestException;
import za.co.mmagon.jwebswing.base.ajax.exceptions.MissingComponentException;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.events.enumerations.EventTypes;
import za.co.mmagon.jwebswing.utilities.TextUtilities;
import za.co.mmagon.logger.LogFactory;

/**
 * Handles all AJAX Requests performed by a client connection. Session codes are used in order to identify
 * <p>
 * @author Marc Magon
 */
@Singleton
public class AjaxReceiverServlet extends JWDefaultServlet
{

    private static final Logger LOG = LogFactory.getInstance().getLogger("AJAXServlet");
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
            AjaxCall ajaxCall = JavaScriptPart.From(request.getInputStream(), AjaxCall.class);
            GuiceContext.inject().getInstance(JWebSwingSiteBinder.class).setAjaxCall(ajaxCall);
            if (ajaxCall.getComponentId() == null)
            {
                LOG.log(Level.SEVERE, "[SessionID]-[{0}];[Security]-[Component ID Not Found]", request.getSession().getId());
                throw new InvalidRequestException("There is no Component ID in this call.");
            }

            String componentId = ajaxCall.getComponentId();
            if (componentId == null || componentId.isEmpty())
            {
                LOG.log(Level.FINE, "[SessionID]-[{0}];[Security]-[Component ID Incorrect]", request.getSession().getId());
                throw new InvalidRequestException("Component ID Was Incorrect.");
            }

            Page page = GuiceContext.inject().getInstance(Page.class);
            if (page == null)
            {
                throw new MissingComponentException("Page has not been bound yet. Please use a binder to map Page to the required page object. Also consider using a @Provides method to apply custom logic. See https://github.com/google/guice/wiki/ProvidesMethods ");
            }
            page.preConfigure();

            ComponentHierarchyBase triggerComponent;
            page.buildComponentHierarchy();
            Map<String, ComponentHierarchyBase> comps = page.getComponentCache();
            triggerComponent = comps.get(componentId);
            ajaxCall.setComponent(triggerComponent);

            if (triggerComponent == null)
            {
                LOG.log(Level.SEVERE, "[SessionID]-[{0}];[Security]-[Invalid Component Specified];[Component]-[" + componentId + "]", request.getSession().getId());
                throw new MissingComponentException("Component could not be found to process any events.");
            }

            Date datetime = ajaxCall.getDatetime();
            if (datetime == null)
            {
                LOG.log(Level.FINE, "[SessionID]-[{0}];[Security]-[Date Time Incorrect]", request.getSession().getId());
                throw new InvalidRequestException("Invalid Date Time Value");
            }
            EventTypes eventType = ajaxCall.getEventType();
            if (eventType == null)
            {
                LOG.log(Level.FINE, "[SessionID]-[{0}];[Security]-[Event Type Incorrect]", request.getSession().getId());
                throw new InvalidRequestException("Invalid Event Type");
            }
            _eventType = eventType.toString();

            EventTypes eventTypeFrom = ajaxCall.getEventTypeFrom();
            if (eventTypeFrom == null)
            {
                LOG.log(Level.FINE, "[SessionID]-[{0}];[Security]-[Event From Incorrect]", request.getSession().getId());
                throw new InvalidRequestException("Invalid Event Type From");
            }

            AjaxEventValue value = ajaxCall.getValue();

            if (value == null)
            {
                LOG.log(Level.FINE, "[SessionID]-[{0}];[Security]-[Value Is Missing]", request.getSession().getId());
                throw new InvalidRequestException("Invalid Event Value");
            }

            Date ajaxCallObjectCreated = new Date();
            ArrayList<ComponentEventBase> events = getEvents(ajaxCall, ajaxCall.getEventTypeFrom());

            AjaxResponse ajaxResponse = GuiceContext.inject().getInstance(AjaxResponse.class);

            if (!GuiceContext.isBuildingInjector())
            {
                intercept();
            }

            for (Iterator<ComponentEventBase> iterator = events.iterator(); iterator.hasNext();)
            {
                Event event = (Event) iterator.next();
                event.fireEvent(ajaxCall, ajaxResponse);
            }

            fireTime = new Date().getTime() - ajaxCallObjectCreated.getTime();
            startDate = new Date();
            output = ajaxResponse.toString();
            page.buildComponentHierarchy();
            ajaxResponse.getComponents().forEach(component ->
            {
                component.preConfigure();
                for (Iterator it = component.getChildren().iterator(); it.hasNext();)
                {
                    ComponentHierarchyBase object = (ComponentHierarchyBase) it.next();
                    page.buildComponentHierarchy(object, page.getComponentCache());
                }
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
            LOG.log(Level.SEVERE, "[SessionID]-[" + request.getSession().getId() + "];" + "[Exception]-[Invalid Request]", ie);
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
            LOG.log(Level.SEVERE, "[SessionID]-[" + request.getSession().getId() + "];" + "[Exception]-[Missing Component]", mce);
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
            LOG.log(Level.SEVERE, "Unknown in ajax reply\n", T);
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
            LOG.log(Level.SEVERE, "Unknown in ajax reply\n", T);
        }
        finally
        {
            try
            {
                Date dataTransferDate = new Date();
                response.setContentType("application/json;charset=UTF-8");
                response.setCharacterEncoding("UTF-8");

                response.setHeader("Access-Control-Allow-Origin", CorsAllowedFilter.allowedLocations);
                response.setHeader("Access-Control-Allow-Credentials", "true");
                response.setHeader("Access-Control-Allow-Methods", "GET, POST");
                response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept");

                response.getWriter().write(output);
                //LOG.log(Level.FINE,"[Ajax Reply]-[" + output + "]");
                long transferTime = new Date().getTime() - dataTransferDate.getTime();
                LOG.log(Level.CONFIG, "[SessionID]-[{0}];[EventType]-[{1}];[Render Time]-[{2}];[Data Size]-[{3}];[Transer Time]-[{4}];[Fire Time]-[{5}]", new Object[]
                {
                    request.getSession().getId(), _eventType, renderTime, output.length(), transferTime, fireTime
                });
            }
            catch (IOException io)
            {
                LOG.log(Level.SEVERE, "Unable to send response to client", io);
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
            LOG.log(Level.SEVERE, "Error in post", e);
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
