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
import com.jwebmp.core.FileTemplates;
import com.jwebmp.core.Page;
import com.jwebmp.core.utilities.StaticStrings;
import com.jwebmp.guicedinjection.GuiceContext;
import com.jwebmp.guicedservlets.GuicedServletKeys;
import com.jwebmp.interception.services.AjaxCallIntercepter;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;

import static com.jwebmp.interception.JWebMPInterceptionBinder.*;

/**
 * This Servlet supplies all the JavaScript for a given HTML Page
 *
 * @author GedMarc
 */
@Singleton
public class JavaScriptServlet
		extends JWDefaultServlet
{
	/**
	 * Field scriptReplacement
	 */
	private static final String scriptReplacement = "JW_JAVASCRIPT";

	/**
	 * Field serialVersionUID
	 */


	/**
	 * When to perform any commands
	 */
	@Override
	public void perform()
	{
		Page page = GuiceContext.get(Page.class);
		HttpServletRequest request = GuiceContext.get(GuicedServletKeys.getHttpServletRequestKey());
		readBrowserInformation(request);

		GuiceContext.get(AjaxCallInterceptorKey)
		            .forEach(AjaxCallIntercepter::intercept);
		page.toString(0);
		FileTemplates.removeTemplate(JavaScriptServlet.scriptReplacement);
		FileTemplates.getFileTemplate(JavaScriptServlet.class, JavaScriptServlet.scriptReplacement, "javascriptScript");
		FileTemplates.getTemplateVariables()
		             .put(JavaScriptServlet.scriptReplacement, page.renderJavascript());
		StringBuilder scripts = FileTemplates.renderTemplateScripts(JavaScriptServlet.scriptReplacement);
		writeOutput(scripts, StaticStrings.HTML_HEADER_JAVASCRIPT, Charset.forName("UTF-8"));
		FileTemplates.getTemplateVariables()
		             .remove(JavaScriptServlet.scriptReplacement);
	}
}
