package com.jwebmp.core.services;

import com.jwebmp.core.Page;
import com.jwebmp.core.base.html.Script;
import com.jwebmp.core.base.html.attributes.ScriptAttributes;
import com.guicedee.guicedinjection.json.StaticStrings;
import com.guicedee.guicedinjection.interfaces.IDefaultService;
import com.guicedee.guicedinjection.interfaces.IServiceEnablement;

/**
 * Renders a script that can be done dynamically through a servlet or placed directly into the page at a location (sort order)
 */
public interface IDynamicRenderingServlet<J extends IDynamicRenderingServlet<J>>
		extends IDefaultService<J>, IServiceEnablement<J>
{
	/**
	 * Returns the script location
	 *
	 * @return The script
	 */
	String getScriptLocation(Page<?> page);

	/**
	 * Render the script that can be dynamically built
	 *
	 * @return The string builder for the script
	 */
	Script<?,?> renderScript(Page<?> page);

	/**
	 * Method newScript ...
	 *
	 * @param contents
	 * 		of type String
	 *
	 * @return Script
	 */
	default Script<?, ?> newScript(String contents)
	{
		Script<?, ?> s = new Script<>();
		s.addAttribute(ScriptAttributes.Type, StaticStrings.HTML_HEADER_JAVASCRIPT);
		s.setText(contents);
		return s;
	}
}
