package com.jwebmp.core.base.servlets;

import com.google.inject.servlet.SessionScoped;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

import javax.validation.constraints.NotNull;
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

	private static final long serialVersionUID = 1L;
	/**
	 * The client browser local storage
	 */
	private Map<String, String> localStorage;
	/**
	 * The client browser session storage
	 */
	private Map<String, String> sessionStorage;
	/**
	 * Sets a list of files to be uploaded
	 */
	private Map<String, byte[]> uploadedFiles;

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

	/**
	 * Returns a list of files in the last upload
	 *
	 * @return
	 */
	@NotNull
	public Map<String, byte[]> getUploadedFiles()
	{
		if (uploadedFiles == null)
		{
			uploadedFiles = new LinkedHashMap<>();
		}
		return uploadedFiles;
	}

	/**
	 * Sets the list of uploaded files
	 *
	 * @param uploadedFiles
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J setUploadedFiles(@NotNull Map<String, byte[]> uploadedFiles)
	{
		this.uploadedFiles = uploadedFiles;
		return (J) this;
	}

}
