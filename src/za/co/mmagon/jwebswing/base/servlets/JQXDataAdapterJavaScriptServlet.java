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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import za.co.mmagon.LoggerFactory;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.components.jqxWidgets.dataadapter.JQXDataAdapter;

/**
 * This Servlet supplies all the JavaScript for a given HTML Page
 *
 * @author GedMarc
 */
public class JQXDataAdapterJavaScriptServlet extends HttpServlet
{

    private static final Logger log = LoggerFactory.getInstance().makeNewLoggerInstance("JavaScriptServlet");
    private static final long serialVersionUID = 1L;
    private HttpSession session;
    private String sessionID;
    private JWebSwingServlet servlet;
    private Page page;

    /**
     * The Object Mapper for rendering the JSON with Jackson
     */
    private static final ObjectMapper jsonObjectMapper = new ObjectMapper();

    static
    {
        jsonObjectMapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
        log.trace("JavaScript Servlet Instantiated");
    }

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
        response.setContentType("text/html");
        String componentId = request.getParameter("do");
        session = request.getSession();
        sessionID = session.getId();

        if (sessionID == null)
        {
            log.error("Session Doesn't Exist", new ServletException("There is no session for a data pull"));
            throw new ServletException("There is no session for a data pull");
        }
        servlet = JWebSwingServlet.getSessionServlet(sessionID);
        if (servlet == null)
        {
            log.error("Servlet Doesn't Exist", new ServletException("There is no Servlet Loaded for the entry."));
            throw new ServletException("There is no Servlet Loaded for the entry.");
        }
        if (!servlet.isUserLoggedIn())
        {
            log.error("Not Logged In", new ServletException("User Has Not Logged Into The System"));
            throw new ServletException("User Has Not Logged Into The System");
        }
        this.page = servlet.getCurrentPage(request.getSession());
        if (page == null)
        {
            log.error("No Page", new ServletException("No Page Currently Loaded"));
            throw new ServletException("No Page Currently Loaded");
        }

        StringBuilder dataAdaptersValues = new StringBuilder();
        dataAdaptersValues.append(getAllDataAdapters());

        Date startDate = new Date();
        //StringBuilder scripts = this.page.renderJavascripts(0, true);
        StringBuilder scripts = dataAdaptersValues;
        //scripts.insert(0, "$(document).ready(function(){\n").
        //scripts.append(page.getNewLine());
        //scripts.append("$(window).resize();").append(page.getNewLine());
        //scripts.append("});").append(page.getNewLine());
        Date endDate = new Date();
        //Render the Pages JavaScript
        try (PrintWriter out = response.getWriter())
        {
            response.setContentType("application/javascript");
            out.println(scripts);
            //out.flush();
            Date dataTransferDate = new Date();
            log.trace("[SessionID]-[" + request.getSession().getId() + "];" + "[Render Time]-[" + (endDate.getTime() - startDate.getTime()) + "];[Data Size]-[" + scripts.length() + "];[Transer Time]=[" + (dataTransferDate.getTime() - startDate.getTime()) + "]");
        }
    }

    public StringBuilder getAllDataAdapters()
    {
        StringBuilder sb = new StringBuilder();
        /*
         * page.getBody().getChildrenHierarchy().stream().filter((comp) -> (comp.getDataAdapter() != null)).forEach((comp)
         * ->
         * {
         * for (Iterator iterator = comp.getDataAdapter().iterator(); iterator.hasNext();)
         * {
         * JQXDataAdapter next = (JQXDataAdapter) iterator.next();
         * //next.setTiny(page.isTiny());
         * next.setTiny(true);
         * sb.append(next.renderJavascripts(0));
         * }
         * });
         */
        return sb;
    }

    private JQXDataAdapter getAllAdapters(String id)
    {
        for (Iterator<ComponentHierarchyBase> it = page.getBody().getChildrenHierarchy().iterator(); it.hasNext();)
        {
            ComponentHierarchyBase comp = it.next();
            /*
             * for (Iterator it = comp.getDataAdapter().iterator(); it.hasNext();)
             * {
             * JQXDataAdapter dataAdapter = (JQXDataAdapter) it.next();
             * if (dataAdapter.getDAID().equals(id))
             * {
             * return dataAdapter;
             * }
             * }
             */
        }
        return null;
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  Servlet request
     * @param response Servlet response
     * @throws ServletException if a Servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        //Standard Web Build Call
        if (request.getHeader("Content-Type") == null || request.getHeader("Content-Type").isEmpty())
        {
            processRequest(request, response);
        }
    }
}
