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
package com.jwebmp.core.base.servlets;

import com.google.inject.Singleton;
import com.jwebmp.core.utilities.StaticStrings;
import com.jwebmp.guicedinjection.GuiceContext;
import com.jwebmp.interception.SiteInterception;
import com.jwebmp.logger.LogFactory;

import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The base Servlet for the JWebSwing environment. Constructs each page on call
 *
 * @author Marc Magon
 * @version 1.1
 * @since 2012/10/09
 */
@Singleton
public class JWebSwingServlet
		extends JWDefaultServlet
{

	/**
	 * The logger for the swing Servlet
	 */
	private static final Logger log = LogFactory.getInstance()
	                                            .getLogger("JWebSwingServlet");
	/**
	 * Version 1
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new JWebSwing Servlet that is not session aware
	 */
	public JWebSwingServlet()
	{
		//Nothing Needed
	}

	/**
	 * When to perform any commands
	 */
	@Override
	public void perform()
	{
		HttpServletResponse response = GuiceContext.get(HttpServletResponse.class);
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
		writeOutput(getPageHTML(), StaticStrings.HTML_HEADER_DEFAULT_CONTENT_TYPE, StaticStrings.UTF8_CHARSET);
	}

	/**
	 * Method interception holder for Site and Ajax Calls
	 */
	@Override
	@SiteInterception
	protected void intercept()
	{
		//Interception Method
	}

	/**
	 * Destroys this object and all references to it
	 */
	@Override
	public void destroy()
	{
		try
		{
			JWebSwingServlet.log.log(Level.INFO, "Destroying Servlet JWebSwing Servlet and all Static Objects");
			GuiceContext.destroy();
		}
		catch (Exception t)
		{
			JWebSwingServlet.log.log(Level.SEVERE, "Unable to destroy", t);
		}
		super.destroy();
	}
}
