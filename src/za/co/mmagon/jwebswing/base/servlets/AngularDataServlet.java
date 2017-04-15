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
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.annotations.DataCallInterception;
import za.co.mmagon.jwebswing.annotations.SiteInterception;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
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

    public static final String LocalStorageSessionKey = "LocalStorage";
    public static final String SessionStorageSessionKey = "SessionStorage";
    public static final String ModernizrSessionKey = "Modernizr";

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
        LOG.log(Level.CONFIG, "[SessionID]-[{0}];[Connection]-[Data Call Connection Established]", request.getSession().getId());
        String componentId = request.getParameter("o");
        StringBuilder jb = new StringBuilder();
        String line;

        try
        {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
            {
                jb.append(line);
            }
        }
        catch (IOException e)
        {
        }

        if (jb.length() > 0)
        {
            AngularDataServletInitData initData = JavaScriptPart.From(jb.toString(), AngularDataServletInitData.class);
            request.getSession().setAttribute(LocalStorageSessionKey, initData.getLocalStorage());
            request.getSession().setAttribute(SessionStorageSessionKey, initData.getSessionStorage());
            request.getSession().setAttribute(ModernizrSessionKey, initData.getModernizr());
        }

        Date startDate = new Date();
        AjaxCall ajaxCall = GuiceContext.inject().getInstance(AjaxCall.class);
        ajaxCall.setComponentId(componentId);
        ajaxCall.setDatetime(new Date());
        ajaxCall.setEventType(EventTypes.data);
        if (componentId == null || componentId.isEmpty())
        {
            LOG.log(Level.FINE, "[SessionID]-[{0}];[Security]-[Component ID Incorrect]", request.getSession().getId());
        }

        Page page = GuiceContext.inject().getInstance(Page.class);
        ComponentHierarchyBase triggerComponent;
        if (ajaxCall.getComponentId().equalsIgnoreCase("body"))
        {
            triggerComponent = page.getBody();
        }
        else
        {
            triggerComponent = page.getComponentCache().get(componentId);
        }
        ajaxCall.setComponent(triggerComponent);
        if (triggerComponent == null)
        {
            LOG.log(Level.SEVERE, "[SessionID]-[{0}];[Security]-[Invalid Component Specified]", request.getSession().getId());
            throw new ServletException("Component could not be found to process any events.");
        }
        AjaxResponse ajaxResponse = GuiceContext.inject().getInstance(AjaxResponse.class);

        if (!GuiceContext.isBuildingInjector())
        {
            intercept();
        }

        GuiceContext.inject().getInstance(Page.class).onConnect(ajaxCall, ajaxResponse);

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

        /*
         * Map<String, JavaScriptPart> angs = ajaxCall.getComponent().getAngularObjectsAll(); ArrayList<AngularJsonVariable> returnables = new ArrayList<>(); angs.entrySet().stream().forEach(entry ->
         * { String key = entry.getKey(); JavaScriptPart value = entry.getValue(); returnables.add(new AngularJsonVariable(key, value)); });
         *
         * JavaScriptPart respJson = new JavaScriptPart() { private static final long serialVersionUID = 1L; ArrayList<AngularJsonVariable> variables;
         *
         * public ArrayList<AngularJsonVariable> getVariables() { if (variables == null) { variables = returnables; } return variables; }
         *
         * public void setVariables(ArrayList<AngularJsonVariable> variables) { this.variables = variables; }
         *
         * @Override public String toString() { getVariables(); return super.toString(); } };
         */
        Date endDate = new Date();
        try (PrintWriter out = response.getWriter())
        {
            response.setContentType("application/json;charset=UTF-8");

            response.setHeader("Access-Control-Allow-Origin", CorsAllowedFilter.allowedLocations);
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Methods", "POST");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept");

            response.getWriter().write(ajaxResponse.toString());
            Date dataTransferDate = new Date();
            LOG.log(Level.FINE, "[SessionID]-[{0}];[Render Time]-[{1}];[Data Size]-[{2}];[Transer Time]=[{3}]", new Object[]
            {
                request.getSession().getId(), endDate.getTime() - startDate.getTime(), ajaxResponse.toString().length(), dataTransferDate.getTime() - startDate.getTime()
            });
        }
    }

    @SiteInterception
    @DataCallInterception
    protected void intercept()
    {

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
            //    super.doPost(request, response);
            processRequest(request, response);
        }
        catch (IOException | ServletException e)
        {
            LOG.log(Level.SEVERE, "Angular Data Servlet Do Post", e);
        }
    }
}
