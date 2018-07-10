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
import com.jwebmp.FileTemplates;
import com.jwebmp.Page;
import com.jwebmp.exceptions.MissingComponentException;
import com.jwebmp.guicedinjection.GuiceContext;
import com.jwebmp.utilities.StaticStrings;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;

/**
 * This Servlet supplies all the JavaScript for a given HTML Page
 *
 * @author GedMarc
 */
@Singleton
public class JavaScriptServlet
		extends JWDefaultServlet
{
	private static final String scriptReplacement = "JW_JAVASCRIPT";

	private static final long serialVersionUID = 1L;

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 *
	 * @param request
	 * 		Servlet request
	 * @param response
	 * 		Servlet response
	 */
	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	{

	}

	@Override
	public void perform()
	{
		Page page = GuiceContext.inject()
		                        .getInstance(Page.class);
		intercept();
		FileTemplates.removeTemplate(scriptReplacement);
		if (page == null)
		{
			writeOutput(new StringBuilder(getErrorPageHtml(new MissingComponentException(
					"Page has not been bound yet. Please use a binder to map Page to the required page object. Also consider using a @Provides method to apply custom logic. See https://github.com/google/guice/wiki/ProvidesMethods ")).toString(
					0)), StaticStrings.HTML_HEADER_JAVASCRIPT, Charset.forName("UTF-8"));
			return;
		}
		FileTemplates.getFileTemplate(JavaScriptServlet.class, scriptReplacement, "javascriptScript");
		FileTemplates.getTemplateVariables()
		             .put(scriptReplacement, page.renderJavascript());
		StringBuilder scripts = FileTemplates.renderTemplateScripts(scriptReplacement);
		writeOutput(scripts, StaticStrings.HTML_HEADER_JAVASCRIPT, Charset.forName("UTF-8"));
		FileTemplates.getTemplateVariables()
		             .remove(scriptReplacement);
	}
}