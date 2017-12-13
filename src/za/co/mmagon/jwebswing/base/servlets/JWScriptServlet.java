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
import za.co.mmagon.FileTemplates;
import za.co.mmagon.guiceinjection.GuiceContext;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.utilities.StaticStrings;
import za.co.mmagon.logger.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author GedMarc
 */
@Singleton
public class JWScriptServlet extends JWDefaultServlet
{

	public static final String FILE_TEMPLATE_NAME = "jwscript";
	private static final Logger LOG = LogFactory.getInstance().getLogger("JWScriptServlet");
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
		processRequest(request);
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
		processRequest(request);
	}

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 *
	 * @param request
	 * 		Servlet request
	 */
	protected void processRequest(HttpServletRequest request)
	{
		Page page = GuiceContext.inject().getInstance(Page.class);
		page.toString(true);
		Date startDate = new Date();
		FileTemplates.getFileTemplate(JWScriptServlet.class, FILE_TEMPLATE_NAME, "siteloader");
		FileTemplates.getTemplateVariables().put("SITEADDRESSINSERT", new StringBuilder(request.getRequestURL().toString().replace("jwscr", "")));

		StringBuilder output = FileTemplates.renderTemplateScripts(FILE_TEMPLATE_NAME);

		Date endDate = new Date();
		writeOutput(output, StaticStrings.HTML_HEADER_JAVASCRIPT, Charset.forName("UTF-8"));
		Date dataTransferDate = new Date();
		LOG.log(Level.FINER, "[SessionID]-[{0}];[Render Time]-[{1}];[Data Size]-[{2}];[Transer Time]=[{3}]", new Object[]
				                                                                                                     {
						                                                                                                     request.getSession().getId(), endDate.getTime() - startDate.getTime(), output.toString().length(), dataTransferDate.getTime() - startDate.getTime()
				                                                                                                     });
	}
}
