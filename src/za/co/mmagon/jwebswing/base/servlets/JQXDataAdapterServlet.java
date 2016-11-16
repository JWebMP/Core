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

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
 * This Servlet supplies all the JSON data for JQX Data Adapters via AJAX
 *
 * @author GedMarc
 */
public class JQXDataAdapterServlet extends HttpServlet
{

    private static final Logger LOG = LoggerFactory.getInstance().makeNewLoggerInstance("Data Adapter");
    private static final long serialVersionUID = 1L;
    private HttpSession session;
    private String sessionID;
    private JWebSwingServlet servlet;
    private Page page;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        String componentId = request.getParameter("do");
        session = request.getSession();
        sessionID = session.getId();

        if (sessionID == null)
        {
            LOG.error("Session Doesn't Exist", new ServletException("There is no session for a data pull"));
            throw new ServletException("There is no session for a data pull");
        }
        servlet = JWebSwingServlet.getSessionServlet(sessionID);
        if (servlet == null)
        {
            LOG.error("Servlet Doesn't Exist", new ServletException("There is no Servlet Loaded for the entry."));
            throw new ServletException("There is no Servlet Loaded for the entry.");
        }
        if (!servlet.isUserLoggedIn())
        {
            LOG.error("Not Logged In", new ServletException("User Has Not Logged Into The System"));
            throw new ServletException("User Has Not Logged Into The System");
        }
        this.page = servlet.getCurrentPage(request.getSession());
        if (page == null)
        {
            LOG.error("No Page", new ServletException("No Page Currently Loaded"));
            throw new ServletException("No Page Currently Loaded");
        }

        if (componentId == null || componentId.isEmpty())
        {
            LOG.error("Invalid DA ID", new ServletException("The Referenced DA ID is invalid"));
            throw new ServletException("The Referenced DA ID is invalid (" + componentId + ")");
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<JQXDataAdapter> da = getAllAdapters(componentId);
        da.stream().forEach((comp)->{
            sb.append(comp.renderJavascriptAll() + comp.getNewLine());
            
        });
        
        if (da == null)
        {
            LOG.error("DA Not Found", new ServletException("The Referenced DA is not found"));
            throw new ServletException("The Referenced DA is not found");
        }

        response.setContentType("application/javascript");
        try (PrintWriter out = response.getWriter())
        {
            Date startDate = new Date();
            //String sb = jsonObjectMapper.writeValueAsString(dataPacket);
            Date endDate = new Date();
            //out.println(sb);
            out.println(sb);
            //out.flush();
            Date dataTransferDate = new Date();
            LOG.trace("[SessionID]-[" + request.getSession().getId() + "];" + "[Render Time]-[" + (endDate.getTime() - startDate.getTime()) + "];[Data Size]-[" + sb.length() + "];[Transer Time]=[" + (dataTransferDate.getTime() - startDate.getTime()) + "]");
        }
    }

    private ArrayList<JQXDataAdapter> getAllAdapters(String id)
    {
        ArrayList<JQXDataAdapter> returnable = new ArrayList<>();
        ComponentHierarchyBase comp1 = page.getComponentCache().get(id);
        List<ComponentHierarchyBase> childrenHierarchy = comp1.getChildrenHierarchy(true);
        childrenHierarchy.stream().forEach((comp) -> 
                {
                    if (comp instanceof JQXDataAdapter)
                    {
                        returnable.add((JQXDataAdapter) comp);
                    }
        });

        return returnable;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
