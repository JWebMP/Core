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
import com.guicedee.guicedinjection.json.StaticStrings;
import com.guicedee.guicedinjection.GuiceContext;
import com.guicedee.guicedservlets.GuicedServletKeys;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.services.IPage;
import com.jwebmp.interception.services.AjaxCallIntercepter;

import jakarta.servlet.http.HttpServletRequest;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static com.guicedee.guicedinjection.GuiceContext.get;
import static com.jwebmp.interception.JWebMPInterceptionBinder.*;
import static java.nio.charset.StandardCharsets.UTF_8;

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
	 * When to perform any commands
	 */
	@Override
	public void perform()
	{
		Page<?> page = (Page<?>) get(IPage.class);
		HttpServletRequest request = get(GuicedServletKeys.getHttpServletRequestKey());
		for (AjaxCallIntercepter<?> ajaxCallIntercepter : get(AjaxCallInterceptorKey))
		{
			
			ajaxCallIntercepter.intercept(GuiceContext.get(AjaxCall.class), GuiceContext.get(AjaxResponse.class));
		}
		page.toString(0);
		FileTemplates.removeTemplate(JavaScriptServlet.scriptReplacement);
		FileTemplates.getFileTemplate(JavaScriptServlet.class, JavaScriptServlet.scriptReplacement, "javascriptScript");
		FileTemplates.getTemplateVariables()
		             .put(JavaScriptServlet.scriptReplacement, page.renderJavascript());
		StringBuilder scripts = FileTemplates.renderTemplateScripts(JavaScriptServlet.scriptReplacement);
		writeOutput(scripts, StaticStrings.HTML_HEADER_JAVASCRIPT, UTF_8);
		FileTemplates.getTemplateVariables()
		             .remove(JavaScriptServlet.scriptReplacement);
	}
}
