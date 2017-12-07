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
import za.co.mmagon.FileTemplates;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.exceptions.MissingComponentException;
import za.co.mmagon.jwebswing.utilities.StaticStrings;
import za.co.mmagon.logger.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This Servlet supplies all the JavaScript for a given HTML Page
 *
 * @author GedMarc
 */
@Singleton
public class JavaScriptServlet extends JWDefaultServlet
{

	private static final Logger log = LogFactory.getInstance().getLogger("JavaScriptServlet");
	private static final long serialVersionUID = 1L;

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 *
	 * @param request
	 * 		Servlet request
	 * @param response
	 * 		Servlet response
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws MissingComponentException
	{
		response.setContentType("text/javascript");
		Date startDate = new Date();
		Page page = GuiceContext.inject().getInstance(Page.class);

		if (page == null)
		{
			throw new MissingComponentException("Page has not been bound yet. Please use a binder to map Page to the required page object. Also consider using a @Provides method to apply custom logic. See https://github.com/google/guice/wiki/ProvidesMethods ");
		}
		FileTemplates.getFileTemplate(JavaScriptServlet.class, "JW_JAVASCRIPT", "javascriptScript");
		FileTemplates.getTemplateVariables().put("//%%JW_JAVASCRIPT%%", page.renderJavascript());
		StringBuilder scripts = FileTemplates.renderTemplateScripts("JW_JAVASCRIPT");
		Date endDate = new Date();
		writeOutput(scripts, StaticStrings.HTML_HEADER_JAVASCRIPT, Charset.forName("UTF-8"));
		log.log(Level.FINE, "[SessionID]-[{0}];[Render Time]-[{1}];[Data Size]-[{2}];[Transer Time]=[{3}]", new Object[]
				                                                                                                    {
						                                                                                                    request.getSession().getId(), endDate.getTime() - startDate.getTime(), scripts.length(), new Date().getTime() - startDate.getTime()
				                                                                                                    });
	}

	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request
	 * 		Servlet request
	 * @param response
	 * 		Servlet response
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			super.doGet(request, response);
			processRequest(request, response);
		}
		catch (MissingComponentException ex)
		{
			Logger.getLogger(JavaScriptServlet.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request
	 * 		Servlet request
	 * @param response
	 * 		Servlet response
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			doGet(request, response);
		}
		catch (Exception ex)
		{
			Logger.getLogger(JavaScriptServlet.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
