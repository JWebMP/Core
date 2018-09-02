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
package com.jwebmp.core;

import com.jwebmp.core.utilities.StaticStrings;
import com.jwebmp.guicedinjection.GuiceContext;
import com.jwebmp.logger.LogFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Level;
import java.util.logging.Logger;

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

	private static boolean cacheAddress = false;

	private static String addressToBeUsedWhenNull = "";

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
		if (SessionHelper.isCacheAddress() && SessionHelper.getAddress() != null)
		{
			return SessionHelper.getAddress();
		}
		try
		{
			HttpServletRequest request = GuiceContext.getInstance(HttpServletRequest.class);
			StringBuffer buff = request.getRequestURL();
			if (request.getHeader(StaticStrings.REQUEST_SITE_HEADER_NAME) != null && !request.getHeader(StaticStrings.REQUEST_SITE_HEADER_NAME)
			                                                                                 .isEmpty())
			{
				buff = new StringBuffer(request.getHeader(StaticStrings.REQUEST_SITE_HEADER_NAME));
			}
			String address = buff.substring(0, buff.lastIndexOf(StaticStrings.STRING_FORWARD_SLASH) + 1);
			SessionHelper.address = address;
			return address;
		}
		catch (Exception e)
		{
			SessionHelper.log.log(Level.FINER, "Unable to get server path", e);
			return SessionHelper.addressToBeUsedWhenNull;
		}
	}

	/**
	 * If the helper is using the cached address
	 *
	 * @return
	 */
	public static boolean isCacheAddress()
	{
		return SessionHelper.cacheAddress;
	}

	/**
	 * Returns the current addross for the session helper
	 *
	 * @return
	 */
	public static String getAddress()
	{
		return SessionHelper.address;
	}

	/**
	 * Sets the current address for the session helper. Use with cacheAddress to use fully customized address paths
	 *
	 * @param address
	 */
	public static void setAddress(String address)
	{
		SessionHelper.address = address;
	}

	/**
	 * If the address must be cached on first reponse, and used for future calls
	 *
	 * @param cacheAddress
	 */
	public static void setCacheAddress(boolean cacheAddress)
	{
		SessionHelper.cacheAddress = cacheAddress;
	}

	/**
	 * Returns the last section of the url, to be matched with page configurator url
	 *
	 * @return
	 */
	public static String getServletUrl()
	{
		HttpServletRequest request = GuiceContext.inject()
		                                         .getInstance(HttpServletRequest.class);
		String buff = request.getServletPath();
		return buff.isEmpty() ? StaticStrings.STRING_FORWARD_SLASH : buff;
	}

	/**
	 * Returns the client IP Address
	 *
	 * @return String of the client ip
	 */
	public static String getClientIPAddress()
	{
		HttpServletRequest request = GuiceContext.inject()
		                                         .getInstance(HttpServletRequest.class);
		return request.getRemoteAddr();
	}

	public static String getAddressToBeUsedWhenNull()
	{
		return SessionHelper.addressToBeUsedWhenNull;
	}

	public static void setAddressToBeUsedWhenNull(String addressToBeUsedWhenNull)
	{
		SessionHelper.addressToBeUsedWhenNull = addressToBeUsedWhenNull;
	}
}
