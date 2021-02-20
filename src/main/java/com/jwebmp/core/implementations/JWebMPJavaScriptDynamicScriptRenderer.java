package com.jwebmp.core.implementations;

import com.google.common.base.Strings;
import com.jwebmp.core.Page;
import com.jwebmp.core.base.html.Script;
import com.jwebmp.core.plugins.jquery.JQueryPageConfigurator;
import com.jwebmp.core.services.IDynamicRenderingServlet;
import com.guicedee.guicedinjection.json.StaticStrings;
import jakarta.servlet.http.HttpServletRequest;

import java.time.LocalDateTime;

import static com.guicedee.guicedinjection.GuiceContext.*;

public class JWebMPJavaScriptDynamicScriptRenderer
		implements IDynamicRenderingServlet<JWebMPJavaScriptDynamicScriptRenderer>
{
	public static boolean renderJavascript = true;

	@Override
	public String getScriptLocation(Page<?> page)
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
		return JWebMPSiteBinder.getJavaScriptLocation()
		                       .replaceAll(StaticStrings.STRING_FORWARD_SLASH, StaticStrings.STRING_EMPTY) +  "?" +  Strings.nullToEmpty(queryParams);
	}
	
	@Override
	public Script<?, ?> renderScript(Page<?> page)
	{
		return getJavascriptScript(page);
	}
	
	
	/**
	 * Method getJavascriptScript ...
	 *
	 * @return Script
	 */
	private Script<?, ?> getJavascriptScript(Page<?> page)
	{
		if(renderJavascript) {
			StringBuilder js = page.renderJavascript();
			return newScript(page.getNewLine() + js);
		}
		return null;
	}
	
	/**
	 * Default Sort Order INTEGER.MAX - 900
	 *
	 * @return Default Sort Order INTEGER.MAX - 900
	 */
	@Override
	public Integer sortOrder()
	{
		return Integer.MAX_VALUE - 900;
	}
	
	@Override
	public boolean enabled()
	{
		return JQueryPageConfigurator.isRequired() && JQueryPageConfigurator.isEnabled();
	}
}
