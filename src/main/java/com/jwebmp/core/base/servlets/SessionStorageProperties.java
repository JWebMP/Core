package com.jwebmp.core.base.servlets;

import com.google.inject.servlet.SessionScoped;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

import jakarta.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A global qualified session properties map
 *
 * @param <J>
 * 		any extension
 */
@SessionScoped
public class SessionStorageProperties<J extends SessionStorageProperties<J>>
		extends JavaScriptPart<J>
{
	/**
	 * The client browser local storage
	 */
	private Map<String, String> localStorage;
	/**
	 * The client browser session storage
	 */
	private Map<String, String> sessionStorage;

	/**
	 * Constructs the session properties
	 */
	public SessionStorageProperties()
	{
		//Not needed
	}

	/**
	 * The client browser local storage
	 *
	 * @return
	 */
	@NotNull
	public Map<String, String> getLocalStorage()
	{
		if (localStorage == null)
		{
			localStorage = new HashMap<>();
		}
		return localStorage;
	}

	/**
	 * The client browser local storage
	 *
	 * @param localStorage
	 */
	@SuppressWarnings("unchecked")
	public J setLocalStorage(Map<String, String> localStorage)
	{
		this.localStorage = localStorage;
		return (J) this;
	}

	/**
	 * The client browser session storage
	 *
	 * @return
	 */
	@NotNull
	public Map<String, String> getSessionStorage()
	{
		if (sessionStorage == null)
		{
			sessionStorage = new HashMap<>();
		}
		return sessionStorage;
	}

	/**
	 * The client browser session storage
	 *
	 * @param sessionStorage
	 */
	@SuppressWarnings("unchecked")
	public J setSessionStorage(Map<String, String> sessionStorage)
	{
		this.sessionStorage = sessionStorage;
		return (J) this;
	}

}
