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
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Singleton;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.annotations.DataCallInterception;
import za.co.mmagon.jwebswing.annotations.SiteInterception;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.ajax.exceptions.MissingComponentException;
import za.co.mmagon.jwebswing.base.servlets.interfaces.IDataComponent;
import za.co.mmagon.logger.LogFactory;

/**
 * Provides the data for a specific component
 *
 * @author GedMarc
 * @since Nov 15, 2016
 * @version 1.0
 *
 */
@Singleton
public class DataServlet extends JWDefaultServlet
{

    /**
     * The Servlet base logger
     */
    private static final Logger log = LogFactory.getInstance().getLogger("DataServlet");
    private static final long serialVersionUID = 1L;

    public DataServlet()
    {

    }

    /**
     * The Object Mapper for rendering the JSON with Jackson
     */
    private static final ObjectMapper jsonObjectMapper = new ObjectMapper();

    static
    {
        jsonObjectMapper.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, true);
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, MissingComponentException
    {
        Date startDate = new Date();
        StringBuilder responseString = new StringBuilder();
        HttpSession session = GuiceContext.inject().getInstance(HttpSession.class);
        Page page = GuiceContext.inject().getInstance(Page.class);
        if (page == null)
        {
            throw new MissingComponentException("Page has not been bound yet. Please use a binder to map Page to the required page object. Also consider using a @Provides method to apply custom logic. See https://github.com/google/guice/wiki/ProvidesMethods ");
        }

        String componentID = request.getParameter("component");
        log.log(Level.CONFIG, "[SessionID]-[{0}];[DataFetch];[ComponentID]-[{1}]", new Object[]
        {
            session.getId(), componentID
        });
        ComponentHierarchyBase hb = page.getComponentCache().get(componentID);
        if (hb == null)
        {
            throw new MissingComponentException("Unable to find the specified component : " + request.getParameter("component"));
        }
        StringBuilder output = new StringBuilder();

        String searchString = (String) request.getSession().getAttribute("search");
        Integer totalCount = (Integer) request.getSession().getAttribute("count");
        String lastItemID = (String) request.getSession().getAttribute("lastID");

        if (!GuiceContext.isBuildingInjector())
        {
            intercept();
        }

        if (IDataComponent.class.isAssignableFrom(hb.getClass()))
        {
            IDataComponent dc = (IDataComponent) hb;
            String outputJson = jsonObjectMapper
                    .configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, true)
                    .writeValueAsString(
                            dc.getData(request.getParameterMap())
                    );
            output.append(outputJson).toString();
        }

        responseString.append(output);

        Date endDate = new Date();
        try (PrintWriter out = response.getWriter())
        {
            response.setContentType("application/json;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");

            response.setHeader("Access-Control-Allow-Origin", CorsAllowedFilter.allowedLocations);
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Methods", "GET, POST");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept");

            out.println(responseString);
            Date dataTransferDate = new Date();
            log.log(Level.CONFIG, "[SessionID]-[{0}];[Render Time]-[{1}];[Data Size]-[{2}];[Transer Time]=[{3}]", new Object[]
            {
                request.getSession().getId(), endDate.getTime() - startDate.getTime(), responseString.length(), dataTransferDate.getTime() - startDate.getTime()
            });
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
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
            super.doGet(request, response); //Checks for the page existance
            processRequest(request, response);
        }
        catch (IOException | ServletException e)
        {
            log.log(Level.SEVERE, "Do Post in Data Servlet", e);
        }
        catch (MissingComponentException ex)
        {
            Logger.getLogger(DataServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SiteInterception
    @DataCallInterception
    protected void intercept()
    {

    }
}
