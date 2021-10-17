package com.jwebmp.core.implementations;

import com.google.common.base.*;
import com.google.inject.*;
import com.guicedee.guicedinjection.*;
import com.guicedee.guicedinjection.json.*;
import com.guicedee.guicedservlets.*;
import com.guicedee.logger.*;
import com.jwebmp.core.*;
import com.jwebmp.core.base.ajax.*;
import com.jwebmp.core.services.*;
import jakarta.servlet.http.*;

import java.util.*;

@SuppressWarnings("rawtypes")
public class PageProvider
		implements Provider<Page>
{
	private static final java.util.logging.Logger log = LogFactory.getLog("PageProvider");
	
	private static final Map<String, Class<? extends IPage<?>>> urlToClass = new HashMap<>();
	
	@Override
	public Page<?> get()
	{
		try
		{
			AjaxCall<?> call = GuiceContext.get(AjaxCall.class);
			if (call.getVariable("jw.pageClass") != null && !Strings.isNullOrEmpty(call.getVariable("jw.pageClass")
			                                                                           .getVariableText()))
			{
				String className = call.getVariable("jw.pageClass")
				                       .getVariableText()
				                       .replaceAll("\"", "");
				Class pageClass = GuiceContext.instance()
				                              .getScanResult()
				                              .loadClass(className, true);
				return (Page<?>) GuiceContext.get(pageClass);
			}
		}
		catch (ProvisionException | OutOfScopeException e)
		{
		
		}
		
		HttpServletRequest request = GuiceContext.get(GuicedServletKeys.getHttpServletRequestKey());
		String pathInfo = request.getRequestURI();
		if (pathInfo == null)
		{
			pathInfo = StaticStrings.STRING_FORWARD_SLASH;
		}
		pathInfo = pathInfo.toLowerCase();
		if (urlToClass.containsKey(pathInfo))
		{
			return (Page) GuiceContext.get(urlToClass.get(pathInfo));
		}
		pathInfo = pathInfo.substring(0, pathInfo.lastIndexOf('/') + 1);
		if (urlToClass.containsKey(pathInfo))
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
