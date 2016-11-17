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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import za.co.mmagon.LoggerFactory;

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
    private static final Logger LOG = LoggerFactory.getInstance().makeNewLoggerInstance("DataServlet");

    public DataServlet()
    {

    }

    public void processRequest(HttpServletRequest req, HttpServletResponse resp)
    {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        try
        {
            super.doGet(req, resp);
        }
        catch (Exception e)
        {
            LOG.fatal("do get error", e);
        }
    }
}
