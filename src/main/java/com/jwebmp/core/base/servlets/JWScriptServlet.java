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
import com.guicedee.guicedinjection.GuiceContext;
import com.guicedee.guicedinjection.json.StaticStrings;
import com.guicedee.guicedservlets.GuicedServletKeys;
import com.jwebmp.core.FileTemplates;
import com.jwebmp.core.SessionHelper;
import jakarta.servlet.http.HttpServletRequest;

import static com.guicedee.guicedinjection.GuiceContext.get;

/**
 * @author GedMarc
 */
@Singleton
public class JWScriptServlet
		extends JWDefaultServlet
{
	/**
	 * Field FILE_TEMPLATE_NAME
	 */
	public static final String FILE_TEMPLATE_NAME = "jwscript";
	/**
	 * When to perform any commands
	 */
	@Override
	public void perform()
	{
		HttpServletRequest request = GuiceContext.get(GuicedServletKeys.getHttpServletRequestKey());
		FileTemplates.getFileTemplate(JWScriptServlet.class, JWScriptServlet.FILE_TEMPLATE_NAME, "siteloader");
		FileTemplates.getTemplateVariables()
		             .put("SITEADDRESSINSERT", new StringBuilder(SessionHelper.getServerPath()));
		try
		{
			HttpServletRequest hsr = get(HttpServletRequest.class);
			FileTemplates.getTemplateVariables()
					.put("%USERAGENT%", new StringBuilder(hsr.getHeader("user-agent")));
			FileTemplates.getTemplateVariables()
					.put("%MYIP%", new StringBuilder(hsr.getRemoteAddr()));
			FileTemplates.getTemplateVariables()
					.put("%REFERER%", new StringBuilder(hsr.getHeader("referer")));
		}
		catch (Throwable T)
		{

		}
		StringBuilder output = FileTemplates.renderTemplateScripts(JWScriptServlet.FILE_TEMPLATE_NAME);
		writeOutput(output, StaticStrings.HTML_HEADER_JAVASCRIPT, StaticStrings.UTF_CHARSET);
	}

}
