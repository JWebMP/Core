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
package com.jwebmp.core.base.servlets.options;

import com.google.inject.servlet.RequestScoped;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

import java.util.HashMap;
import java.util.Map;

/**
 * @author GedMarc
 * @since 05 Apr 2017
 */
@RequestScoped
public class AngularDataServletInitData<J extends AngularDataServletInitData<J>>
		extends JavaScriptPart<J>
{
	/**
	 * The local storage map to be set for the provider
	 */
	private Map<String, String> localStorage;
	/**
	 * The session storage map
	 */
	private Map<String, String> sessionStorage;
	/**
	 * The parameters for the initialized data
	 */
	private Map<String, String> parameters;

	/*
	 * Constructs a new AngularDataServletInitData
	 */
	public AngularDataServletInitData()
	{
		//Nothing needed
	}

	public Map<String, String> getLocalStorage()
	{
		return localStorage;
	}

	public void setLocalStorage(Map<String, String> localStorage)
	{
		this.localStorage = localStorage;
	}

	public Map<String, String> getSessionStorage()
	{
		return sessionStorage;
	}

	public void setSessionStorage(Map<String, String> sessionStorage)
	{
		this.sessionStorage = sessionStorage;
	}

	public Map<String, String> getParameters()
	{
		if (parameters == null)
		{
			parameters = new HashMap<>();
		}
		return parameters;
	}

	public void setParameters(Map<String, String> parameters)
	{
		this.parameters = parameters;
	}
}
