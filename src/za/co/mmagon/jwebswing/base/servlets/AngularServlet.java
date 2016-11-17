/*
 * Copyright (C) 2016 GedMarc
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
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import za.co.mmagon.LoggerFactory;
import za.co.mmagon.jwebswing.Page;

/**
 *
 * @author GedMarc
 */
@Singleton
public class AngularServlet extends JWDefaultServlet
{

    private static final Logger LOG = LoggerFactory.getInstance().makeNewLoggerInstance("AngularServlet");
    private static final long serialVersionUID = 1L;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request  Servlet request
     * @param response Servlet response
     * @throws ServletException if a Servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        Page page = (Page) request.getSession().getAttribute("jwpage");
        if (page == null)
        {
            LOG.error("No Page", new ServletException("No Page Currently Loaded"));
            throw new ServletException("No Page Currently Loaded");
        }
        Date startDate = new Date();
        StringBuilder output = page.getAngular().renderTemplateScripts("jwangular");
        Date endDate = new Date();
        try (PrintWriter out = response.getWriter())
        {
            response.setContentType("application/javascript;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(output.toString());
            Date dataTransferDate = new Date();
            LOG.trace("[SessionID]-[" + request.getSession().getId() + "];" + "[Render Time]-[" + (endDate.getTime() - startDate.getTime()) + "];[Data Size]-[" + output.toString().length() + "];[Transer Time]=[" + (dataTransferDate.getTime() - startDate.getTime()) + "]");
        }
    }

    /**
     * Post handler
     *
     * @param request
     * @param response
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
        catch (Exception e)
        {
            LOG.fatal("Do Post Error", e);
        }
    }

    /**
     * Post handler
     *
     * @param request
     * @param response
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
        catch (Exception e)
        {
            LOG.fatal("Angualr Do Get Error", e);
        }
    }
}
