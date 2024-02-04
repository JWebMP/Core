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
import com.jwebmp.core.Page;
import com.guicedee.services.jsonrepresentation.json.StaticStrings;
import com.guicedee.guicedinjection.GuiceContext;
import com.guicedee.guicedservlets.GuicedServletKeys;
import com.jwebmp.core.services.IPage;

/**
 * This Servlet supplies all the JavaScript for a given HTML Page
 *
 * @author GedMarc
 */
@Singleton
public class CSSServlet
		extends JWDefaultServlet
{
	@Override
	public void perform()
	{
		@SuppressWarnings("MismatchedQueryAndUpdateOfStringBuilder")
		StringBuilder scripts = new StringBuilder();
		Page<?> page = (Page<?>) GuiceContext.get(IPage.class);
		StringBuilder css = page.getBody()
		                        .renderCss(0);
		scripts.append(css);
		writeOutput(css, StaticStrings.HTML_HEADER_CSS, StaticStrings.UTF_CHARSET);
	}
}
