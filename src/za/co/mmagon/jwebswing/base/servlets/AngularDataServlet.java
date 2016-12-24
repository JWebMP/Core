/*
 * Copyright (C) 2016 ged_m
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

import com.google.inject.Singleton;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AngularJsonVariable;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptPartType;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.events.enumerations.EventTypes;
import za.co.mmagon.logger.LogFactory;

/**
 * Handles angular data binding calls, registers variables for access. Can handle population, use event binding for call back.
 *
 * @author GedMarc
 * @since 20160607
 */
@Singleton
public class AngularDataServlet extends JWDefaultServlet
{

    private static final Logger LOG = LogFactory.getInstance().getLogger("AngularDataServlet");
    private static final long serialVersionUID = 1L;

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
        String componentId = request.getParameter("o");
        Date startDate = new Date();

        AjaxCall ajaxCall = new AjaxCall();
        ajaxCall.setComponentId(componentId);
        ajaxCall.setDatetime(new Date());
        ajaxCall.setEventType(EventTypes.data);
        if (componentId == null || componentId.isEmpty())
        {
            LOG.log(Level.FINE, "[SessionID]-[" + request.getSession().getId() + "];" + "[Security]-[Component ID Incorrect]");
        }

        Page page = (Page) request.getAttribute("jwpage");
        ComponentHierarchyBase triggerComponent = page.getComponentCache().get(componentId);
        ajaxCall.setComponent(triggerComponent);
        if (triggerComponent == null)
        {
            LOG.log(Level.SEVERE, "[SessionID]-[" + request.getSession().getId() + "];" + "[Security]-[Invalid Component Specified]");
            throw new ServletException("Component could not be found to process any events.");
        }
        Map<String, JavaScriptPart> angs = ajaxCall.getComponent().getAngularObjectsAll();
        ArrayList<AngularJsonVariable> returnables = new ArrayList<>();
        angs.entrySet().stream().forEach((entry)
                ->
        {
            String key = entry.getKey();
            JavaScriptPart value = entry.getValue();
            returnables.add(new AngularJsonVariable(key, value));
        });

        JavaScriptPart respJson = new JavaScriptPart()
        {
            ArrayList<AngularJsonVariable> variables;

            public ArrayList<AngularJsonVariable> getVariables()
            {
                if (variables == null)
                {
                    variables = returnables;
                }
                return variables;
            }

            public void setVariables(ArrayList<AngularJsonVariable> variables)
            {
                this.variables = variables;
            }

            @Override
            public JavascriptPartType getJavascriptType()
            {
                return JavascriptPartType.JSON;
            }

            @Override
            public String toString()
            {
                getVariables();
                return super.toString();
            }
        };
        Date endDate = new Date();
        try (PrintWriter out = response.getWriter())
        {
            response.setContentType("application/json;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(respJson.toString());
            Date dataTransferDate = new Date();
            LOG.log(Level.FINE, "[SessionID]-[" + request.getSession().getId() + "];" + "[Render Time]-[" + (endDate.getTime() - startDate.getTime()) + "];[Data Size]-[" + respJson.toString().length() + "];[Transer Time]=[" + (dataTransferDate.getTime() - startDate.getTime()) + "]");
        }
    }

    /**
     * Validates and sends the post
     *
     * @param request
     * @param response
     *
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            super.doPost(request, response);
            processRequest(request, response);
        }
        catch (Exception e)
        {
            LOG.log(Level.SEVERE, "Angular Data Servlet Do Post", e);
        }
    }

}
