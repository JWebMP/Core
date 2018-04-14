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
import com.jwebmp.utilities.StaticStrings;
import za.co.mmagon.guiceinjection.GuiceContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;

/**
 * @author GedMarc
 */
@Singleton
public class AngularDataVariables
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		super.doGet(request, response);
		processRequest();

	}

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 */
	protected void processRequest()
	{
		Page page = GuiceContext.inject()
		                        .getInstance(Page.class);
		StringBuilder output = page.getAngular()
		                           .renderAngularJavascript(page);
		writeOutput(output, StaticStrings.HTML_HEADER_JAVASCRIPT, Charset.forName("UTF-8"));
	}
}
