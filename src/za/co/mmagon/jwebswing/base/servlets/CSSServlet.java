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
import za.co.mmagon.jwebswing.base.ajax.exceptions.MissingComponentException;
import za.co.mmagon.logger.LogFactory;

/**
 * This Servlet supplies all the JavaScript for a given HTML Page
 *
 * @author GedMarc
 */
@Singleton
public class CSSServlet extends JWDefaultServlet
{

    private static final Logger LOG = LogFactory.getInstance().getLogger("CSSServlet");
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
            throws ServletException, IOException, MissingComponentException
    {
        Date startDate = new Date();
        StringBuilder scripts = new StringBuilder();

        Page page = GuiceContext.inject().getInstance(Page.class);

        if (page == null)
        {
            throw new MissingComponentException("Page has not been bound yet. Please use a binder to map Page to the required page object. Also consider using a @Provides method to apply custom logic. See https://github.com/google/guice/wiki/ProvidesMethods ");
        }

        StringBuilder css = page.getBody().renderCss(0);
        scripts.append(css);

        Date endDate = new Date();
        try (PrintWriter out = response.getWriter())
        {
            response.setContentType("text/css");
            response.setHeader("Access-Control-Allow-Origin", CorsAllowedFilter.allowedLocations);
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept");

            out.println(scripts);
            Date dataTransferDate = new Date();
            LOG.log(Level.FINE, "[SessionID]-[{0}];[Render Time]-[{1}];[Data Size]-[{2}];[Transer Time]=[{3}]",
                    new Object[]
                    {
                        request.getSession().getId(), endDate.getTime() - startDate.getTime(), scripts.length(), dataTransferDate.getTime() - startDate.getTime()
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
            LOG.log(Level.SEVERE, "Do Get in CSS Servlet", e);
        }
        catch (MissingComponentException ex)
        {
            Logger.getLogger(CSSServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
