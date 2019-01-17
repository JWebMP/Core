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

package com.jwebmp.core.base.servlets.intercepters;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.servlet.RequestScoped;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.servlets.SessionStorageProperties;
import com.jwebmp.core.utilities.StaticStrings;
import com.jwebmp.guicedinjection.GuiceContext;
import com.jwebmp.interception.services.AjaxCallIntercepter;
import com.jwebmp.interception.services.DataCallIntercepter;
import com.jwebmp.logger.LogFactory;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("unused")
@RequestScoped
public class LocalStorageIntercepter
		implements DataCallIntercepter<LocalStorageIntercepter>, AjaxCallIntercepter<LocalStorageIntercepter>
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
				LocalStorageIntercepter.log.finer("Local Storage key found");
				Map<String, String> result = mapper.readValue(call.getVariable(StaticStrings.LOCAL_STORAGE_VARIABLE_KEY)
				                                                  .getVariableText(), new TypeReference<Map<String, String>>() {});
				localStorage.put(StaticStrings.LOCAL_STORAGE_PARAMETER_KEY, result.get(StaticStrings.LOCAL_STORAGE_PARAMETER_KEY));
			}
		}
		catch (Exception e)
		{
			LocalStorageIntercepter.log.log(Level.WARNING, "Unable to check for local storage key", e);
		}
	}

	@Override
	public Integer sortOrder()
	{
		return -50;
	}
}
