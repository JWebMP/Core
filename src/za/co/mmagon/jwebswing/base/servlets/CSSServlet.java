/*
 * Copyright (C) 2015 GedMarc
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

import com.google.inject.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.log4j.*;
import za.co.mmagon.*;
import za.co.mmagon.jwebswing.*;

/**
 * This Servlet supplies all the JavaScript for a given HTML Page
 *
 * @author GedMarc
 */
@Singleton
public class CSSServlet extends JWDefaultServlet
{

    private static final Logger LOG = LoggerFactory.getInstance().makeNewLoggerInstance("CSSServlet");
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
        Date startDate = new Date();
        StringBuilder scripts = new StringBuilder();

        Page page = (Page) request.getSession().getAttribute("jwpage");
        StringBuilder css = page.getBody().renderCss(0);
        scripts.append(css);

        Date endDate = new Date();
        try (PrintWriter out = response.getWriter())
        {
            response.setContentType("text/css");
            out.println(scripts);
            Date dataTransferDate = new Date();
            LOG.trace("[SessionID]-[" + request.getSession().getId() + "];" + "[Render Time]-[" + (endDate.getTime() - startDate.getTime()) + "];[Data Size]-[" + scripts.length() + "];[Transer Time]=[" + (dataTransferDate.getTime() - startDate.getTime()) + "]");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try
        {
            super.doPost(request, response); //Checks for the page existance
            processRequest(request, response);
        }
        catch (IOException | ServletException e)
        {
            LOG.fatal("Do Post in CSS Servlet", e);
        }
    }
}
