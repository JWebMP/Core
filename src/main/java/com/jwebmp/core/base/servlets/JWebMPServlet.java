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
package com.jwebmp.core.base.servlets;

import com.google.inject.Singleton;

import com.guicedee.client.*;
import com.guicedee.guicedservlets.GuicedServletKeys;
import com.guicedee.services.jsonrepresentation.json.StaticStrings;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.java.Log;

import java.util.logging.Level;

/**
 * The base Servlet for the JWebSwing environment. Constructs each page on call
 *
 * @author GedMarc
 * @version 1.1
 * @since 2012/10/09
 */
@Singleton
@Log
public class JWebMPServlet
		extends JWDefaultServlet
{

	/**
	 * Constructs a new JWebSwing Servlet that is not session aware
	 */
	public JWebMPServlet()
	{
		//Nothing Needed
	}

	/**
	 * When to perform any commands
	 */
	@Override
	public void perform()
	{
		
		HttpServletResponse response = IGuiceContext.get(GuicedServletKeys.getHttpServletResponseKey());
		sendPage(response);
	}

	/**
	 * Sends the page out
	 *
	 * @param response
	 * 		The response object
	 */
	private void sendPage(HttpServletResponse response)
	{
		response.setContentType(StaticStrings.HTML_HEADER_DEFAULT_CONTENT_TYPE);
		writeOutput(getPageHTML(), StaticStrings.HTML_HEADER_DEFAULT_CONTENT_TYPE, StaticStrings.UTF_CHARSET);
	}

	/**
	 * Destroys this object and all references to it
	 */
	@Override
	public void destroy()
	{
		try
		{
			JWebMPServlet.log.log(Level.INFO, "Destroying Servlet JWebMP Servlet and all Static Objects");
			IGuiceContext.getContext().destroy();
		}
		catch (Exception t)
		{
			JWebMPServlet.log.log(Level.SEVERE, "Unable to destroy", t);
		}
		super.destroy();
	}
}
