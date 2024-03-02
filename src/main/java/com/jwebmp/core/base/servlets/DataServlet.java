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
import com.guicedee.guicedservlets.GuicedServletKeys;
import com.guicedee.services.jsonrepresentation.json.StaticStrings;
import com.jwebmp.core.Page;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.servlets.interfaces.IDataComponent;
import com.jwebmp.interception.services.DataCallIntercepter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.java.Log;

import static com.guicedee.client.IGuiceContext.get;
import static com.jwebmp.interception.JWebMPInterceptionBinder.DataCallInterceptorKey;

/**
 * Provides the data for a specific component
 *
 * @author GedMarc
 * @version 1.0
 * @since Nov 15, 2016
 */
@Singleton
@Log
public class DataServlet
		extends JWDefaultServlet
{
	
	/**
	 * A data server
	 */
	public DataServlet()
	{
		//Nothing Needed
	}

	/**
	 * When to perform any commands
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void perform()
	{
		HttpServletRequest request = get(GuicedServletKeys.getHttpServletRequestKey());
		String componentID = request.getParameter("component");
		StringBuilder responseString = new StringBuilder();
		try
		{
			Class<? extends IDataComponent> clazz = (Class<? extends IDataComponent>) Class.forName(
					componentID.replace(StaticStrings.CHAR_UNDERSCORE, StaticStrings.CHAR_DOT));
			IDataComponent component = get(clazz);
			StringBuilder renderData = component.renderData();
			responseString.append(renderData);
		}
		catch (Exception e)
		{
			Page<?> p = getErrorPageHtml(e);
			writeOutput(new StringBuilder(p.toString(0)), StaticStrings.HTML_HEADER_DEFAULT_CONTENT_TYPE, StaticStrings.UTF_CHARSET);
			return;
		}
		for (DataCallIntercepter<?> dataCallIntercepter : get(DataCallInterceptorKey))
		{
			dataCallIntercepter.intercept(get(AjaxCall.class),get(AjaxResponse.class));
		}
		writeOutput(responseString, StaticStrings.HTML_HEADER_JSON, StaticStrings.UTF_CHARSET);
	}

}
