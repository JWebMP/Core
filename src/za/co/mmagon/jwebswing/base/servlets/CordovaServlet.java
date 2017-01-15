/*
 * Copyright (C) 2017 GedMarc
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
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.ajax.exceptions.MissingComponentException;
import za.co.mmagon.jwebswing.base.html.Base;
import za.co.mmagon.jwebswing.base.html.attributes.BaseAttributes;
import za.co.mmagon.jwebswing.base.references.JavascriptReference;
import za.co.mmagon.logger.LogFactory;

/**
 *
 * @author GedMarc
 */
@Singleton
public class CordovaServlet extends JWDefaultServlet
{

    private static final Logger LOG = LogFactory.getInstance().getLogger("CordovaServlet");
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
        try
        {
            Page p = GuiceContext.Injector().getInstance(Page.class);
            if (p == null)
            {
                throw new MissingComponentException("Page has not been bound yet. Please use a binder to map Page to the required page object. Also consider using a @Provides method to apply custom logic. See https://github.com/google/guice/wiki/ProvidesMethods ");
            }

            JavascriptReference cordovaReference = new JavascriptReference("CordovaDefaultJavascript", 1.0, "cordova.js");

            p.getPageFields().setBase((Base) new Base().addAttribute(BaseAttributes.HRef, request.getRequestURL().toString().replaceAll("jwcordova", "")));
            p.getBody().getJavascriptReferences().add(cordovaReference);
            p.getOptions().setScriptsInHead(true);

            p.toString(true);//render

            AjaxResponse ajaxResponse = new AjaxResponse();
            ajaxResponse.addComponent(p.getHead());
            ajaxResponse.addComponent(p.getBody());

            String output = ajaxResponse.toString();

            Date dataTransferDate = new Date();
            response.setContentType("application/json;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Access-Control-Allow-Origin", CorsAllowedFilter.allowedLocations);
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Methods", "GET, POST");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept");
            response.getWriter().write(output);
        }
        catch (MissingComponentException e)
        {
            LOG.log(Level.SEVERE, "Page must exist", e);
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
            super.doGet(request, response); //Checks for the page existance
            processRequest(request, response);
        }
        catch (IOException | ServletException e)
        {
            LOG.log(Level.SEVERE, "Do Get in CSS Servlet", e);
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
            LOG.log(Level.SEVERE, "Do Post in CSS Servlet", e);
        }
    }
}
