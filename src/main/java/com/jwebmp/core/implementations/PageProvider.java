package com.jwebmp.core.implementations;

import com.google.inject.Provider;
import com.jwebmp.core.Page;
import com.jwebmp.core.SessionHelper;
import com.jwebmp.core.annotations.PageConfiguration;
import com.jwebmp.core.services.IPage;
import com.guicedee.guicedinjection.json.StaticStrings;
import com.guicedee.guicedinjection.GuiceContext;
import com.guicedee.logger.LogFactory;
import net.sf.uadetector.ReadableUserAgent;
import net.sf.uadetector.UserAgentStringParser;

import jakarta.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.logging.Level;

@SuppressWarnings("rawtypes")
public class PageProvider
		implements Provider<Page>
{
	private static final java.util.logging.Logger log = LogFactory.getLog("PageProvider");
	
	private static final Map<String, Class<? extends IPage<?>>> urlToClass = new HashMap<>();
	
	@Override
	public Page get()
	{
		HttpServletRequest request = GuiceContext.get(HttpServletRequest.class);
		String pathInfo = request.getRequestURI();
		if (pathInfo == null)
		{
			pathInfo = StaticStrings.STRING_FORWARD_SLASH;
		}
		pathInfo = pathInfo.toLowerCase();
		if(urlToClass.containsKey(pathInfo))
		{
			return (Page) GuiceContext.get(urlToClass.get(pathInfo));
		}
		pathInfo = pathInfo.substring(0, pathInfo.lastIndexOf('/') + 1);
		if(urlToClass.containsKey(pathInfo))
		{
			return (Page) GuiceContext.get(urlToClass.get(pathInfo));
		}
		return new Page<>();
	}

	/**
	 * Method getPages returns the pages of this PageProvider object.
	 *
	 * @return the pages (type ServiceLoader IPage ) of this PageProvider object.
	 */
	@SuppressWarnings({"unchecked"})
	public static Set<IPage<?>> getPages()
	{
		@SuppressWarnings("UnnecessaryLocalVariable")
		Set pages = GuiceContext.instance()
		                        .getLoader(IPage.class, ServiceLoader.load(IPage.class));
		return pages;
	}

	public static Map<String, Class<? extends IPage<?>>> getUrlToClass()
	{
		return urlToClass;
	}
}
