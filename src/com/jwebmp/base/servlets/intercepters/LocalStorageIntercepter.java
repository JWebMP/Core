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

package com.jwebmp.base.servlets.intercepters;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.servlet.RequestScoped;
import com.jwebmp.base.ajax.AjaxCall;
import com.jwebmp.base.servlets.SessionStorageProperties;
import com.jwebmp.guiceinjection.GuiceContext;
import com.jwebmp.interception.AjaxCallIntercepter;
import com.jwebmp.interception.DataCallIntercepter;
import com.jwebmp.logger.LogFactory;
import com.jwebmp.utilities.StaticStrings;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("unused")
@RequestScoped
public class LocalStorageIntercepter
		implements DataCallIntercepter, AjaxCallIntercepter
{
	private static final Logger log = LogFactory.getLog("LocalStorageIntercepter");

	@Override
	public void intercept()
	{
		try
		{
			AjaxCall<?> call = GuiceContext.getInstance(AjaxCall.class);

			SessionStorageProperties<?> storageProperties = GuiceContext.getInstance(SessionStorageProperties.class);
			Map<String, String> localStorage = storageProperties.getLocalStorage();
			if (call.getVariable(StaticStrings.LOCAL_STORAGE_VARIABLE_KEY) != null && !localStorage.containsKey(StaticStrings.LOCAL_STORAGE_PARAMETER_KEY))
			{
				ObjectMapper mapper = GuiceContext.getInstance(ObjectMapper.class);
				log.finer("Local Storage key found");
				Map<String, String> result = mapper.readValue(call.getVariable(StaticStrings.LOCAL_STORAGE_VARIABLE_KEY)
				                                                  .getVariableText(), new TypeReference<Map<String, String>>() {});
				localStorage.put(StaticStrings.LOCAL_STORAGE_PARAMETER_KEY, result.get(StaticStrings.LOCAL_STORAGE_PARAMETER_KEY));
			}
		}
		catch (Exception e)
		{
			log.log(Level.WARNING, "Unable to check for local storage key", e);
		}
	}

	@Override
	public Integer sortOrder()
	{
		return -50;
	}
}
