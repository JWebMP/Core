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
import com.jwebmp.core.FileTemplates;
import com.jwebmp.core.utilities.StaticStrings;
import com.jwebmp.guicedinjection.GuiceContext;
import com.jwebmp.logger.LogFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

/**
 * @author GedMarc
 */
@Singleton
public class JWScriptServlet
		extends JWDefaultServlet
{
	public static final String FILE_TEMPLATE_NAME = "jwscript";
	private static final Logger LOG = LogFactory.getInstance()
	                                            .getLogger("JWScriptServlet");
	private static final long serialVersionUID = 1L;

	@Override
	public void perform()
	{
		HttpServletRequest request = GuiceContext.get(HttpServletRequest.class);
		FileTemplates.getFileTemplate(JWScriptServlet.class, FILE_TEMPLATE_NAME, "siteloader");
		FileTemplates.getTemplateVariables()
		             .put("SITEADDRESSINSERT", new StringBuilder(request.getRequestURL()
		                                                                .toString()
		                                                                .replace("jwscr", "")));
		StringBuilder output = FileTemplates.renderTemplateScripts(FILE_TEMPLATE_NAME);
		writeOutput(output, StaticStrings.HTML_HEADER_JAVASCRIPT, StaticStrings.UTF8_CHARSET);
	}

}
