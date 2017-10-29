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
import com.google.inject.Singleton;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.utilities.StaticStrings;
import za.co.mmagon.logger.LogFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author GedMarc
 */
@Singleton
public class AngularDataVariables extends JWDefaultServlet
{
	private static final Logger LOG = LogFactory.getInstance().getLogger("AngularServlet");
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
	protected void processRequest()
	{
		Page page = GuiceContext.inject().getInstance(Page.class);
		StringBuilder output = page.getAngular().renderAngularJavascript(page);
		writeOutput(output, StaticStrings.HTML_HEADER_JAVASCRIPT, Charset.forName("UTF-8"));
	}
	
	/**
	 * Post handler
	 *
	 * @param request
	 * @param response
	 *
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			super.doGet(request, response);
			processRequest();
		}
		catch (ServletException | IOException e)
		{
			LOG.log(Level.SEVERE, "Do Post Error", e);
		}
	}
}
