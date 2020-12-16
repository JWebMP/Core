/*
 * Copyright (C) 2017 GedMarc
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.jwebmp.core.base.html;

import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.html.attributes.ScriptAttributes;
import com.jwebmp.core.base.html.interfaces.NoClassAttribute;
import com.jwebmp.core.base.html.interfaces.NoFeatures;
import com.jwebmp.core.base.html.interfaces.NoIDTag;
import com.jwebmp.core.base.html.interfaces.children.BodyChildren;
import com.jwebmp.core.base.html.interfaces.children.FormChildren;
import com.jwebmp.core.base.html.interfaces.children.HeadChildren;
import com.jwebmp.core.base.html.interfaces.events.NoEvents;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.references.JavascriptReference;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;
import com.guicedee.logger.LogFactory;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Base Component<p>
 * <p>
 * Browser Support<p>
 * <p>
 * Internet Explorer Firefox Opera Google Chrome Safari<p>
 * <p>
 * The script tag is supported in all major browsers. Definition and Usage<p>
 * <p>
 * The script tag is used to define a client-side script, such as a JavaScript.<p>
 * <p>
 * The script element either contains scripting statements, or it points to an external script file through the src attribute.<p>
 * <p>
 * Common uses for JavaScript are image manipulation, form validation, and dynamic changes of content.<p>
 * <p>
 * Tips and Notes<p>
 * <p>
 * Note: If the "src" attribute is present, the script element must be empty.<p>
 * <p>
 * Tip: Also look at the noscript element for users that have disabled scripts in their browser, or have a browser that doesn’t support client-side scripting.<p>
 * <p>
 * Note: There are several ways an external script can be executed:
 * <p>
 * <p>
 * If async="async": The script is executed asynchronously with the rest of the page (the script will be executed while the page continues the parsing) If async is not present and
 * defer="defer":
 * The<p>
 * script is executed when the page has finished parsing If neither async or defer is present: The script is fetched and executed immediately, before the browser continues parsing
 * the page<p>
 * <p>
 * <p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * <p>
 * The "type" attribute is required in HTML 4, but optional in HTML5.<p>
 * <p>
 * The "async" attribute is new in HTML5.<p>
 * <p>
 * The HTML 4.01 attribute: "xml:space", is not supported in HTML5.<p>
 * <p>
 * </p>
 *
 * @author MMagon
 * @version 1.0
 * @since 2013/11/12
 */
public class Script<C extends IComponentHierarchyBase<?,?>, J extends Script<C, J>>
		extends ComponentHierarchyBase<C, ScriptAttributes, NoFeatures, NoEvents, J>
		implements NoIDTag, HeadChildren, NoClassAttribute, BodyChildren, FormChildren
{

	private static final Logger logger = LogFactory.getInstance()
	                                               .getLogger("<SCRIPT>");

	private JavascriptReference reference;

	/**
	 * Constructs a script with the given reference
	 *
	 * @param reference
	 */
	public Script(JavascriptReference reference)
	{
		this(reference.toString());
		this.reference = reference;
	}

	/**
	 * Constructs a new script with a specified source and the type of JavaScript
	 * <p>
	 *
	 * @param src
	 * 		The source of the file
	 */
	public Script(String src)
	{
		this();
		addAttribute(ScriptAttributes.Src, src);
		addAttribute(ScriptAttributes.Type, "text/javascript");
	}

	/**
	 * Constructs a script component
	 */
	public Script()
	{
		super(ComponentTypes.Script);
	}

	/**
	 * Constructs a new script with a specified source and type
	 * <p>
	 *
	 * @param src
	 * 		The source of the file
	 * @param type
	 * 		The type of script
	 */
	public Script(String src, String type)
	{
		this();
		if (src != null)
		{
			addAttribute(ScriptAttributes.Src, src);
		}
		if (type != null)
		{
			addAttribute(ScriptAttributes.Type, type);
		}
	}

	/**
	 * Returns the currently set JavaScript with no indentation
	 *
	 * @return The JavaScript
	 */
	public StringBuilder getJavascript()
	{
		return getJavascript(0);
	}

	/**
	 * Sets this script's JavaScript AS-IS
	 *
	 * @param javascript
	 * 		The JavaScript to directly insert
	 */
	@SuppressWarnings("unchecked")
	public J setJavascript(String javascript)
	{
		setText(javascript);
		return (J) this;
	}

	/**
	 * Returns the currently set JavaScript with the specified indentation
	 *
	 * @param tabCount
	 * 		The indentation of the JavaScript
	 * 		<p>
	 *
	 * @return The JavaScript
	 */
	public StringBuilder getJavascript(Integer tabCount)
	{
		preConfigure();
		return getText(tabCount);
	}

	@Override
	public int hashCode()
	{
		return getText(0).append(getAttribute(ScriptAttributes.Src))
		                 .hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == null)
		{
			return false;
		}
		if (obj.getClass() != getClass())
		{
			return false;
		}

		Script<?, ?> s = (Script<?,?>) obj;
		if (s.getAttribute(ScriptAttributes.Src)
		     .equals(getAttribute(ScriptAttributes.Src)))
		{
			if (s.getAttribute(ScriptAttributes.Type)
			     .equals(getAttribute(ScriptAttributes.Type)))
			{
				return s.getText(0)
				        .toString()
				        .equals(getText(0).toString());
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}

	/**
	 * Differences Between HTML and XHTML
	 * <p>
	 * In XHTML, the content inside scripts is declared as #PCDATA (instead of CDATA), which means that entities will be parsed.
	 * <p>
	 * This means that in XHTML, all special characters should be encoded, or all content should be wrapped inside a CDATA section:
	 */
	@Override
	public void preConfigure()
	{
		super.preConfigure();
		if (getAttribute(ScriptAttributes.Src) != null || !getAttribute(ScriptAttributes.Src).isEmpty())
		{
			try
			{
				if (getPage().getHtmlVersion()
				             .name()
				             .startsWith("X"))
				{
					String sb = "//<![CDATA[" +
							getText(0) +
							"//]]";
					setText(sb);
				}
			}
			catch (Exception e)
			{
				Script.logger.log(Level.FINE, "Unable to determine whether XHTML or HTML. Skipping CDATA Implementation", e);
			}
		}
	}

	/**
	 * Returns a reference if one was attached
	 *
	 * @return
	 */
	public JavascriptReference getReference()
	{
		return reference;
	}

}
