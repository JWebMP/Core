package com.jwebmp.core.implementations;

import com.google.common.base.Strings;
import com.google.inject.*;
import com.guicedee.client.*;
import com.jwebmp.core.FileTemplates;
import com.jwebmp.core.Page;
import com.jwebmp.core.SessionHelper;
import com.jwebmp.core.base.html.Script;
import com.jwebmp.core.base.html.attributes.*;
import com.jwebmp.core.base.servlets.JWScriptServlet;
import com.jwebmp.core.services.*;
import com.guicedee.services.jsonrepresentation.json.StaticStrings;
import jakarta.servlet.http.HttpServletRequest;

import static com.guicedee.client.IGuiceContext.*;

public class JWebMPDynamicScriptRenderer implements IDynamicRenderingServlet<JWebMPDynamicScriptRenderer>
{
	@Override
	public String getScriptLocation(IPage<?> page)
	{
		String queryParams = "";
		try
		{
			HttpServletRequest hsr = get(HttpServletRequest.class);
			queryParams = hsr.getQueryString();
		}
		catch (Throwable T)
		{
		
		}
		return JWebMPSiteBinder
				       .getJWScriptLocation()
				       .replaceAll(StaticStrings.STRING_FORWARD_SLASH, StaticStrings.STRING_EMPTY) + "?" + Strings.nullToEmpty(queryParams);
	}
	
	@Override
	public Script<?, ?> renderScript(IPage<?> page)
	{
		return getSiteLoaderScript();
	}
	
	private static final String[] HEADERS_TO_TRY = {"X-Forwarded-For", "Proxy-Client-IP", "WL-Proxy-Client-IP", "HTTP_X_FORWARDED_FOR", "HTTP_X_FORWARDED", "HTTP_X_CLUSTER_CLIENT_IP", "HTTP_CLIENT_IP", "HTTP_FORWARDED_FOR", "HTTP_FORWARDED", "HTTP_VIA", "REMOTE_ADDR"};
	
	private String getClientIpAddress(HttpServletRequest request)
	{
		for (String header : HEADERS_TO_TRY)
		{
			String ip = request.getHeader(header);
			if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip))
			{
				return ip;
			}
		}
		return request.getRemoteAddr();
	}
	
	/**
	 * Method getSiteLoaderScript returns the siteLoaderScript of this ScriptsDynamicPageConfigurator object.
	 *
	 * @return the siteLoaderScript (type Script<?,?>) of this ScriptsDynamicPageConfigurator object.
	 */
	private Script<?, ?> getSiteLoaderScript()
	{
		FileTemplates.getFileTemplate(JWScriptServlet.class, JWScriptServlet.FILE_TEMPLATE_NAME, "siteloader");
		FileTemplates
				.getTemplateVariables()
				.put("SITEADDRESSINSERT", new StringBuilder(SessionHelper.getServerPath()));
		FileTemplates
				.getTemplateVariables()
				.put("ROOTADDRESSINSERT", new StringBuilder(SessionHelper.getServerRootPath()));
		
		try
		{
			FileTemplates
					.getTemplateVariables()
					.put("PAGECLASS",
					     new StringBuilder(IGuiceContext
							                       .get(Page.class)
							                       .getClass()
							                       .getCanonicalName()));
			
		}
		catch (ProvisionException | OutOfScopeException e)
		{
			FileTemplates
					.getTemplateVariables()
					.put("PAGECLASS", new StringBuilder());
		}
		
		try
		{
			HttpServletRequest hsr = get(HttpServletRequest.class);
			FileTemplates
					.getTemplateVariables()
					.put("%USERAGENT%", new StringBuilder(hsr.getHeader("user-agent")));
			
			String ipAddress = getClientIpAddress(hsr);
			if ("[::1]".equals(ipAddress))
			{
				ipAddress = "localhost";
			}
			if ("127.0.0.1".equals(ipAddress))
			{
				ipAddress = "localhost";
			}
			if ("[0:0:0:0:0:0:0:1]".equals(ipAddress))
			{
				ipAddress = "localhost";
			}
			FileTemplates
					.getTemplateVariables()
					.put("%MYIP%", new StringBuilder(ipAddress));
			
			FileTemplates
					.getTemplateVariables()
					.put("%REFERER%", new StringBuilder(hsr.getHeader("referer")));
		}
		catch (Throwable T)
		{
		
		}
		
		StringBuilder jsScript = FileTemplates.renderTemplateScripts(JWScriptServlet.FILE_TEMPLATE_NAME);
		if (!jsScript
				     .toString()
				     .trim()
				     .isEmpty())
		{
			return newScript(jsScript.toString());
		}
		return new Script<>().setText("could not find site loader script");
	}
	
	public Script<?, ?> newScript(String contents)
	{
		Script<?, ?> s = new Script<>();
		s.addAttribute(ScriptAttributes.Type, StaticStrings.HTML_HEADER_JAVASCRIPT);
		s.setText(contents);
		return s;
	}
	
	/**
	 * Default Sort Order INTEGER.MAX - 1000
	 *
	 * @return INTEGER.MAX - 1000
	 */
	@Override
	public Integer sortOrder()
	{
		return Integer.MAX_VALUE - 1000;
	}
	
	@Override
	public boolean enabled()
	{
		return false;
	}
}
