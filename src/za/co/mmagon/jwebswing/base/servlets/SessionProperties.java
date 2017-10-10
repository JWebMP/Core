package za.co.mmagon.jwebswing.base.servlets;

import com.google.inject.servlet.SessionScoped;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

/**
 * A global qualified session properties map
 * @param <J> any extension
 */
@SessionScoped
public class SessionProperties<J extends SessionProperties<J>> extends JavaScriptPart<J>
{
	
	private static final long serialVersionUID = 1L;
	/**
	 * The client browser local storage
	 */
	private Map<String,String> localStorage;
	/**
	 * The client browser session storage
	 */
	private Map<String,String> sessionStorage;
	
	/**
	 * Constructs the session properties
	 */
	public SessionProperties()
	{
		//Not needed
	}
	
	/**
	 * The client browser local storage
	 * @return
	 */
	@NotNull
	public Map<String, String> getLocalStorage()
	{
		if(localStorage == null)
			localStorage = new HashMap<>();
		return localStorage;
	}
	
	/**
	 * The client browser local storage
	 * @param localStorage
	 */
	public void setLocalStorage(Map<String, String> localStorage)
	{
		this.localStorage = localStorage;
	}
	
	/**
	 * The client browser session storage
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
	 * @param sessionStorage
	 */
	public void setSessionStorage(Map<String, String> sessionStorage)
	{
		this.sessionStorage = sessionStorage;
	}
}
