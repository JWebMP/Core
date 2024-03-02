package com.jwebmp.core.implementations;

import com.google.common.base.Strings;
import com.jwebmp.core.Page;
import com.jwebmp.core.base.html.Script;
import com.jwebmp.core.base.html.attributes.*;
import com.jwebmp.core.services.*;
import com.guicedee.services.jsonrepresentation.json.StaticStrings;
import jakarta.servlet.http.HttpServletRequest;

import static com.guicedee.client.IGuiceContext.*;


public class JWebMPJavaScriptDynamicScriptRenderer implements IDynamicRenderingServlet<JWebMPJavaScriptDynamicScriptRenderer>
{
	public static boolean renderJavascript = true;
	
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
				       .getJavaScriptLocation()
				       .replaceAll(StaticStrings.STRING_FORWARD_SLASH, StaticStrings.STRING_EMPTY) + "?" + Strings.nullToEmpty(queryParams);
	}
	
	@Override
	public Script<?, ?> renderScript(IPage<?> page)
	{
		return getJavascriptScript(page);
	}
	
	public Script<?, ?> newScript(String contents)
	{
		Script<?, ?> s = new Script<>();
		s.addAttribute(ScriptAttributes.Type, StaticStrings.HTML_HEADER_JAVASCRIPT);
		s.setText(contents);
		return s;
	}
	
	/**
	 * Method getJavascriptScript ...
	 *
	 * @return Script
	 */
	private Script<?, ?> getJavascriptScript(IPage<?> pager)
	{
		Page page = (Page)pager;
		if (renderJavascript)
		{
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
		return false;
	}
}
