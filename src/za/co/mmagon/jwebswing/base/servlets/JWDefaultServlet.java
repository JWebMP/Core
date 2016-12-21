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
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.util.logging.*;
import za.co.mmagon.logger.LogFactory;
import za.co.mmagon.jwebswing.Page;

/**
 * Provides default methods for authentication authorization etc
 *
 * @author GedMarc
 * @since Nov 14, 2016
 * @version 1.0
 *
 */
public class JWDefaultServlet extends HttpServlet
{

    /**
     * The Servlet base logger
     */
    private static final Logger LOG = LogFactory.getInstance().getLogger("ServletBase");
    /**
     * Version 1
     */
    private static final long serialVersionUID = 1L;

    public JWDefaultServlet()
    {

    }

    /**
     * Validates the session
     *
     * @param checkPageExists If the main page has to be hit first
     * @param request         The physical request
     *
     * @throws javax.servlet.ServletException When any security check fails
     */
    public void validate(Boolean checkPageExists, HttpServletRequest request)
            throws ServletException
    {
        boolean checkPage;
        if (checkPageExists == null)
        {
            checkPage = true;
        }
        else
        {
            checkPage = checkPageExists;
        }

        HttpSession session = request.getSession();
        String sessionID = session.getId();

        if (sessionID == null)
        {
            LOG.log(Level.SEVERE,"Session Doesn't Exist", new ServletException("There is no session for a data pull"));
            throw new ServletException("There is no session for a data pull");
        }
        Page servlet = (Page) request.getSession().getAttribute("jwpage");
        if (checkPage)
        {
            if (servlet == null)
            {
                ServletException se = new ServletException("There is no Servlet Loaded for the entry. The web site has not been visited");
                LOG.log(Level.SEVERE,"Main Servlet Doesn't Exist", se);
                throw se;
            }
            Page page = (Page) request.getSession().getAttribute("jwpage");
            if (page == null)
            {
                LOG.log(Level.SEVERE,"No Page", new ServletException("No Page Currently Loaded"));
                throw new ServletException("No Page Currently Loaded");
            }
        }
    }

    /**
     * Does a default security check on the request
     *
     * @param req
     * @param resp
     *
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        try
        {
            validate(false, req);
        }
        catch (ServletException e)
        {
            LOG.log(Level.SEVERE,"Unable to Do Get", e);
        }
    }

    /**
     * Does a default security check on the request
     *
     * @param req
     * @param resp
     *
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        try
        {
            validate(true, req);
        }
        catch (ServletException e)
        {
            LOG.log(Level.SEVERE,"Security Exception in Validation", e);
            throw e;
        }
    }
}
