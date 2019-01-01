package com.jwebmp.core.implementations;

import com.jwebmp.core.Page;
import com.jwebmp.core.annotations.JWebMPSiteBinder;
import com.jwebmp.core.base.html.Script;
import com.jwebmp.core.plugins.jquery.JQueryPageConfigurator;
import com.jwebmp.core.services.IDynamicRenderingServlet;
import com.jwebmp.core.utilities.StaticStrings;

public class JWebMPJavaScriptDynamicScriptRenderer
		implements IDynamicRenderingServlet<JWebMPJavaScriptDynamicScriptRenderer>
{
	@Override
	public String getScriptLocation(Page<?> page)
	{
		return JWebMPSiteBinder.getJavaScriptLocation()
		                       .replaceAll(StaticStrings.STRING_FORWARD_SLASH, StaticStrings.STRING_EMPTY);
	}

	@Override
	public Script renderScript(Page<?> page)
	{
		return getJavascriptScript(page);
	}


	/**
	 * Method getJavascriptScript ...
	 *
	 * @return Script
	 */
	private Script getJavascriptScript(Page<?> page)
	{
		StringBuilder js = page.renderJavascript();
		if (!js.toString()
		       .trim()
		       .isEmpty())
		{
			String[] lines = js.toString()
			                   .split(page.getNewLine());
			StringBuilder output = new StringBuilder();
			for (String line : lines)
			{
				if (line == null || line.isEmpty())
				{
					continue;
				}
				output.append("\t\t\t")
				      .append(line)
				      .append(page.getNewLine());
			}

			return newScript(page.getNewLine() + output);
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
