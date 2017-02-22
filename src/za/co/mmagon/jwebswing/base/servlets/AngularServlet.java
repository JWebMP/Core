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
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.logger.LogFactory;

/**
 *
 * @author GedMarc
 */
@Singleton
public class AngularServlet extends JWDefaultServlet
{

    private static final Logger LOG = LogFactory.getInstance().getLogger("AngularServlet");
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
        Page page = GuiceContext.inject().getInstance(Page.class);
        page.toString(true);
        Date startDate = new Date();
        //page.getAngular().configureTemplateVariables();

        StringBuilder output = page.getAngular().renderAngularJavascript(page);
        Date endDate = new Date();
        try (PrintWriter out = response.getWriter())
        {
            response.setContentType("application/javascript;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");

            response.setHeader("Access-Control-Allow-Origin", CorsAllowedFilter.allowedLocations);
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Methods", "GET");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept");

            response.getWriter().write(output.toString());
            Date dataTransferDate = new Date();
            LOG.log(Level.FINE, "[SessionID]-[{0}];[Render Time]-[{1}];[Data Size]-[{2}];[Transer Time]=[{3}]", new Object[]
            {
                request.getSession().getId(), endDate.getTime() - startDate.getTime(), output.toString().length(), dataTransferDate.getTime() - startDate.getTime()
            });
        }
    }

    /**
     * Post handler
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
            super.doGet(request, response);
            processRequest(request, response);
        }
        catch (IOException | ServletException e)
        {
            LOG.log(Level.SEVERE, "Do Post Error", e);
        }
    }

    /**
     * Post handler
     *
     * @param request
     * @param response
     *
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            super.doGet(request, response);
            processRequest(request, response);
        }
        catch (IOException | ServletException e)
        {
            LOG.log(Level.SEVERE, "Angualr Do Get Error", e);
        }
    }
}
