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

import com.google.inject.Singleton;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import za.co.mmagon.logger.LogFactory;

/**
 * Provides default methods for authentication authorization etc
 *
 * @author GedMarc
 * @since Nov 14, 2016
 * @version 1.0
 *
 */
@Singleton
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
        HttpSession session = request.getSession();
        String sessionID = session.getId();

        if (sessionID == null)
        {
            LOG.log(Level.SEVERE, "Session Doesn't Exist", new ServletException("There is no session for a data pull"));
            throw new ServletException("There is no session for a data pull");
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
            LOG.log(Level.SEVERE, "Unable to Do Get", e);
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
            LOG.log(Level.SEVERE, "Security Exception in Validation", e);
        }
    }

}
