package com.jwebmp.core.implementations;

import com.google.common.base.Strings;
import com.google.inject.OutOfScopeException;
import com.google.inject.Provider;
import com.google.inject.ProvisionException;
import com.guicedee.guicedinjection.GuiceContext;
import com.guicedee.guicedservlets.GuicedServletKeys;
import com.guicedee.services.jsonrepresentation.json.StaticStrings;
import com.jwebmp.core.Page;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.services.IPage;
import jakarta.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;

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
			AjaxCall<?> call = GuiceContext.get(AjaxCall.class);
			if (call.getHeaders()
			        .getAppClassName() != null && !Strings.isNullOrEmpty(call.getHeaders()
			                                                                 .getAppClassName()))
			{
				String className = call.getHeaders()
				                       .getAppClassName();
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
