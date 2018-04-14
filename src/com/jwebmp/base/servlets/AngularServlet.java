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
package com.jwebmp.base.servlets;

import com.google.inject.Singleton;
import com.jwebmp.Page;
import za.co.mmagon.guiceinjection.GuiceContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;

/**
 * @author GedMarc
 */
@Singleton
public class AngularServlet
		extends JWDefaultServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * Post handler
	 *
	 * @param request
	 * @param response
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		super.doGet(request, response);
		processRequest(request, response);
	}

	/**
	 * Post handler
	 *
	 * @param request
	 * @param response
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		super.doGet(request, response);
		processRequest(request, response);
	}

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 *
	 * @param request
	 * 		Servlet request
	 * @param response
	 * 		Servlet response
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	{
		Page page = GuiceContext.inject()
		                        .getInstance(Page.class);
		page.toString(true);
		StringBuilder output = page.getAngular()
		                           .renderAngularJavascript(page);
		request.getHeaderNames();
		response.getHeaderNames();
		writeOutput(output, "application/javascript;charset=UTF-8", Charset.forName("UTF-8"));
	}
}
