package za.co.mmagon.jwebswing.base.servlets;

import com.google.inject.Singleton;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import za.co.mmagon.LoggerFactory;
import za.co.mmagon.jwebswing.Event;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.ComponentEventBase;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxEventValue;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponseReaction;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponseType;
import za.co.mmagon.jwebswing.base.ajax.ReactionType;
import za.co.mmagon.jwebswing.base.ajax.exceptions.InvalidRequestException;
import za.co.mmagon.jwebswing.base.ajax.exceptions.MissingComponentException;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.events.enumerations.EventTypes;
import za.co.mmagon.jwebswing.utilities.TextUtilities;

/**
 * Handles all AJAX Requests performed by a client connection. Session codes are used in order to identify
 * <p>
 * @author Marc Magon
 */
@Singleton
public class AjaxReceiverServlet extends JWDefaultServlet
{

    private static final Logger LOG = LoggerFactory.getInstance().makeNewLoggerInstance("AJAXServlet");
    private static final long serialVersionUID = 1L;

    public AjaxReceiverServlet()
    {
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request  Servlet request
     * @param response Servlet response
     * @throws ServletException if a Servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected synchronized void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        Date startDate;
        String output = new String();
        String _eventType = "Servlet Accessed";
        long renderTime = 1L;
        long fireTime = 1L;

        try
        {
            String json;
            try ( 
                    BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream())))
            {
                json = "";
                json += br.readLine();
            }

            AjaxCall ajaxCall = JavaScriptPart.getJsonObjectMapper().readValue(json, AjaxCall.class);
            if (ajaxCall.getComponentId() == null)
            {
                LOG.error("[SessionID]-[" + request.getSession().getId() + "];" + "[Security]-[Component ID Not Found]");
                throw new InvalidRequestException("There is no Component ID in this call.");
            }

            String componentId = ajaxCall.getComponentId();
            if (componentId == null || componentId.isEmpty())
            {
                LOG.trace("[SessionID]-[" + request.getSession().getId() + "];" + "[Security]-[Component ID Incorrect]");
                throw new InvalidRequestException("Component ID Was Incorrect.");
            }

            Page page = (Page) request.getSession().getAttribute("jwpage");

            ComponentHierarchyBase triggerComponent;
            page.buildComponentHierarchy();
            HashMap<String, ComponentHierarchyBase> comps = page.getComponentCache();
            triggerComponent = comps.get(componentId);
            ajaxCall.setComponent(triggerComponent);

            if (triggerComponent == null)
            {
                LOG.error("[SessionID]-[" + request.getSession().getId() + "];" + "[Security]-[Invalid Component Specified]");
                throw new MissingComponentException("Component could not be found to process any events.");
            }

            Date datetime = ajaxCall.getDatetime();
            if (datetime == null)
            {
                LOG.trace("[SessionID]-[" + request.getSession().getId() + "];" + "[Security]-[Date Time Incorrect]");
                throw new InvalidRequestException("Invalid Date Time Value");
            }
            EventTypes eventType = ajaxCall.getEventType();
            if (eventType == null)
            {
                LOG.trace("[SessionID]-[" + request.getSession().getId() + "];" + "[Security]-[Event Type Incorrect]");
                throw new InvalidRequestException("Invalid Event Type");
            }
            _eventType = eventType.toString();

            EventTypes eventTypeFrom = ajaxCall.getEventTypeFrom();
            if (eventTypeFrom == null)
            {
                LOG.trace("[SessionID]-[" + request.getSession().getId() + "];" + "[Security]-[Event From Incorrect]");
                throw new InvalidRequestException("Invalid Event Type From");
            }

            AjaxEventValue value = ajaxCall.getValue();

            if (value == null)
            {
                LOG.trace("[SessionID]-[" + request.getSession().getId() + "];" + "[Security]-[Value Is Missing]");
                throw new InvalidRequestException("Invalid Event Value");
            }

            Date ajaxCallObjectCreated = new Date();
            ArrayList<ComponentEventBase> events = getEvents(ajaxCall, ajaxCall.getEventTypeFrom());

            AjaxResponse ajaxResponse = new AjaxResponse();

            for (Iterator<ComponentEventBase> iterator = events.iterator(); iterator.hasNext();)
            {
                Event next = (Event) iterator.next();
                next.fireEvent(ajaxCall, ajaxResponse);
            }

            fireTime = ajaxCallObjectCreated.getTime() - new Date().getTime();
            startDate = new Date();
            output = ajaxResponse.toString();
            page.buildComponentHierarchy();
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
            LOG.error("[SessionID]-[" + request.getSession().getId() + "];" + "[Exception]-[Invalid Request]",ie);
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
            LOG.error("[SessionID]-[" + request.getSession().getId() + "];" + "[Exception]-[Missing Component]",mce);
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
            LOG.error("Unknown in ajax reply\n", T);
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
            LOG.error("Unknown in ajax reply\n", T);
        }
        finally
        {
            try
            {
                Date dataTransferDate = new Date();
                response.setContentType("application/json;charset=UTF-8");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(output);
                //LOG.trace("[Ajax Reply]-[" + output + "]");
                long transferTime = new Date().getTime() - dataTransferDate.getTime();
                LOG.debug("[SessionID]-[" + request.getSession().getId() + "];[EventType]-[" + _eventType + "];[Render Time]-[" + renderTime + "];"
                        + "[Data Size]-[" + output.length() + "];[Transer Time]-[" + (transferTime) + "];"
                        + "[Fire Time]-[" + fireTime + "]");
            }
            catch (IOException io)
            {
                LOG.fatal("Unable to send response to client", io);
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
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
        }catch(Exception e)
        {
            LOG.fatal("Error in post",e);
        }
        
    }

    /**
     * This returns all the event associated with a call
     *
     * @param callObject The call object to process
     * @param eventType  The ComponentEventBase Type to get events for
     * @return
     */
    private ArrayList<ComponentEventBase> getEvents(AjaxCall callObject, EventTypes eventType)
    {
        return callObject.getComponent().getEventsFor(eventType);
    }
}
