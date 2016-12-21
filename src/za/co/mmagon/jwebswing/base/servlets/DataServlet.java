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

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.*;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.ajax.exceptions.MissingComponentException;
import za.co.mmagon.jwebswing.base.servlets.interfaces.IDataComponent;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.logger.LogFactory;

/**
 * Provides the data for a specific component
 *
 * @author GedMarc
 * @since Nov 15, 2016
 * @version 1.0
 *
 */
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

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, MissingComponentException
    {
        Date startDate = new Date();
        StringBuilder responseString = new StringBuilder();

        Page page = (Page) request.getSession().getAttribute("jwpage");
        ComponentHierarchyBase hb = page.getComponentCache().get(request.getParameter("component"));
        if (hb == null)
        {
            throw new MissingComponentException("Unable to find the specified component : " + request.getParameter("component"));
        }
        StringBuilder output = new StringBuilder();
        if (IDataComponent.class.isAssignableFrom(hb.getClass()))
        {
            IDataComponent dc = (IDataComponent) hb;
            output.append(JavaScriptPart.objectAsString(dc.getData()));
        }
        responseString.append(output);

        Date endDate = new Date();
        try (PrintWriter out = response.getWriter())
        {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.println(responseString);
            Date dataTransferDate = new Date();
            log.log(Level.FINE,"[SessionID]-[" + request.getSession().getId() + "];" + "[Render Time]-[" + (endDate.getTime() - startDate.getTime()) + "];[Data Size]-[" + responseString.length() + "];[Transer Time]=[" + (dataTransferDate.getTime() - startDate.getTime()) + "]");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        try
        {
            validate(true, req);
            processRequest(req, resp);
        }
        catch (MissingComponentException e)
        {
            log.log(Level.SEVERE, "Unable to find the component", e);
        }
        catch (IOException | ServletException e)
        {
            log.log(Level.SEVERE, "Unable to deliver data", e);
        }
        catch (Exception e)
        {
            log.log(Level.SEVERE, "Unable to deliver data", e);
        }
    }
}
