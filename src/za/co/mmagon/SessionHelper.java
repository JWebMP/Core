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
package za.co.mmagon;

import za.co.mmagon.guiceinjection.GuiceContext;
import za.co.mmagon.logger.LogFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Level;
import java.util.logging.Logger;

import static za.co.mmagon.jwebswing.utilities.StaticStrings.*;

/**
 * @author Marc Magon
 * @since 05 Apr 2017
 */
public class SessionHelper
{
	private static final Logger log = LogFactory.getLog("SessionHelper");
	/**
	 * The given address
	 */
	private static String address = null;

	/*
	 * Constructs a new SessionHelper
	 */
	private SessionHelper()
	{
		//Nothing needed
	}

	/**
	 * Returns the full server address, without the final section
	 *
	 * @return
	 */
	public static String getServerPath()
	{
		if (address == null && !GuiceContext.isBuildingInjector())
		{
			try
			{
				HttpServletRequest request = GuiceContext.inject().getInstance(HttpServletRequest.class);
				StringBuffer buff = request.getRequestURL();
				if (request.getHeader(REQUEST_SITE_HEADER_NAME) != null && !request.getHeader(REQUEST_SITE_HEADER_NAME).isEmpty())
				{
					buff = new StringBuffer(request.getHeader(REQUEST_SITE_HEADER_NAME));
				}
				String address = buff.substring(0, buff.lastIndexOf(STRING_FORWARD_SLASH) + 1);
				SessionHelper.address = address;
				return address;
			}
			catch (Exception e)
			{
				log.log(Level.SEVERE, "Unable to get server path", e);
				return STRING_EMPTY;
			}
		}
		return address;
	}

	/**
	 * Returns the last section of the url, to be matched with page configurator url
	 *
	 * @return
	 */
	public static String getServletUrl()
	{
		if (!GuiceContext.isBuildingInjector())
		{
			HttpServletRequest request = GuiceContext.inject().getInstance(HttpServletRequest.class);
			String buff = request.getServletPath();
			return buff.isEmpty() ? STRING_FORWARD_SLASH : buff;
		}
		return STRING_FORWARD_SLASH;
	}
}
