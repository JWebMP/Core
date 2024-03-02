package com.jwebmp.core.implementations;

import com.google.common.base.*;
import com.google.inject.*;
import com.guicedee.client.*;
import com.guicedee.guicedservlets.*;
import com.guicedee.services.jsonrepresentation.json.*;
import com.jwebmp.core.*;
import com.jwebmp.core.base.ajax.*;
import com.jwebmp.core.services.*;
import jakarta.servlet.http.*;

import java.util.*;

@SuppressWarnings("rawtypes")
public class PageProvider
		implements Provider<Page>
{
	private static final Map<String, Class<? extends IPage<?>>> urlToClass = new HashMap<>();
	
	@Override
	public Page<?> get()
	{
		try
		{
			AjaxCall<?> call = IGuiceContext.get(AjaxCall.class);
			if (call.getHeaders()
			        .getAppClassName() != null && !Strings.isNullOrEmpty(call.getHeaders()
			                                                                 .getAppClassName()))
			{
				String className = call.getHeaders()
				                       .getAppClassName();
				Class pageClass = IGuiceContext.instance()
				                              .getScanResult()
				                              .loadClass(className, true);
				return (Page<?>) IGuiceContext.get(pageClass);
			}
		}
		catch (ProvisionException | OutOfScopeException e)
		{
		
		}
		
		HttpServletRequest request = IGuiceContext.get(GuicedServletKeys.getHttpServletRequestKey());
		String pathInfo = request.getRequestURI();
		if (pathInfo == null)
		{
			pathInfo = StaticStrings.STRING_FORWARD_SLASH;
		}
		pathInfo = pathInfo.toLowerCase();
		if (urlToClass.containsKey(pathInfo))
		{
			return (Page) IGuiceContext.get(urlToClass.get(pathInfo));
		}
		pathInfo = pathInfo.substring(0, pathInfo.lastIndexOf('/') + 1);
		if (urlToClass.containsKey(pathInfo))
		{
			return (Page) IGuiceContext.get(urlToClass.get(pathInfo));
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
		Set pages = IGuiceContext.instance()
		                        .getLoader(IPage.class, ServiceLoader.load(IPage.class));
		return pages;
	}
	
	public static Map<String, Class<? extends IPage<?>>> getUrlToClass()
	{
		return urlToClass;
	}
}
