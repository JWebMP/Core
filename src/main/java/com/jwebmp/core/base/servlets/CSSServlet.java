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
import com.jwebmp.core.Page;
import com.jwebmp.core.utilities.StaticStrings;
import com.jwebmp.guicedinjection.GuiceContext;

/**
 * This Servlet supplies all the JavaScript for a given HTML Page
 *
 * @author GedMarc
 */
@Singleton
public class CSSServlet
		extends JWDefaultServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	public void perform()
	{
		StringBuilder scripts = new StringBuilder();

		Page page = GuiceContext.inject()
		                        .getInstance(Page.class);
		StringBuilder css = page.getBody()
		                        .renderCss(0);
		scripts.append(css);
		writeOutput(css, StaticStrings.HTML_HEADER_CSS, StaticStrings.UTF8_CHARSET);
	}
}
