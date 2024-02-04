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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.Component;
import com.jwebmp.core.base.html.attributes.CSSLinkAttributes;
import com.jwebmp.core.base.html.interfaces.NoClosingTag;
import com.jwebmp.core.base.html.interfaces.NoFeatures;
import com.jwebmp.core.base.html.interfaces.NoIDTag;
import com.jwebmp.core.base.html.interfaces.children.HeadChildren;
import com.jwebmp.core.base.html.interfaces.children.NoChildren;
import com.jwebmp.core.base.html.interfaces.events.NoEvents;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.references.CSSReference;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;
import lombok.extern.java.Log;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Header CSSLink Component
 * <p>
 *
 * @param <J>
 *
 * @author MMagon
 * 		<p>
 * 		<p>
 * 		<p>
 * 		Browser Support<p>
 * 		<p>
 * 		Internet Explorer Firefox Opera Google Chrome Safari<p>
 * 		<p>
 * 		When used for style sheets, the link tag is supported in all major browsers.<p>
 * 		No real support for anything else. Definition and Usage<p>
 * 		<p>
 * 		The link tag defines the relationship between a document and an external<p>
 * 		resource.<p>
 * 		<p>
 * 		The link tag is most used to link to style sheets.<p>
 * 		<p>
 * 		Note: The link element is an empty element, it contains attributes only.<p>
 * 		<p>
 * 		Note: This element goes only in the head section, but it can appear any<p>
 * 		number of times. Differences Between HTML 4.01 and HTML5<p>
 * 		<p>
 * 		Some HTML 4.01 attributes are not supported in HTML5.<p>
 * 		<p>
 * 		The "sizes" attribute is new in HTML5.<p>
 * @version 1.0
 * @since 2013/11/12
 */
@Log
public class CSSLink<J extends CSSLink<J>>
		extends Component<NoChildren, CSSLinkAttributes, NoFeatures, NoEvents, J>
		implements NoClosingTag, HeadChildren
{

	


	/**
	 * If this link is a theme link
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Boolean themeLink;
	/**
	 * An applied linked reference
	 */
	private CSSReference linkedReference;

	/**
	 * Constructs an empty link
	 */
	public CSSLink()
	{
		super(ComponentTypes.CSSLink);
		setRenderIDAttribute(false);
	}

	/**
	 * Constructs a new Head Link
	 *
	 * @param linkedReference
	 */
	public CSSLink(CSSReference linkedReference)
	{
		this(linkedReference.toString());
		this.linkedReference = linkedReference;

	}

	/**
	 * The CSS file link
	 *
	 * @param cssFile
	 * 		The file to route
	 */
	public CSSLink(String cssFile)
	{
		super("link", ComponentTypes.CSSLink);
		addAttribute(CSSLinkAttributes.Type, "text/css");
		addAttribute(CSSLinkAttributes.Rel, "stylesheet");
		addAttribute(CSSLinkAttributes.HRef, cssFile);
		setInlineClosingTag(false);
	}

	/**
	 * Creates a new header link with the given properties
	 *
	 * @param type
	 * @param rel
	 * @param href
	 */
	public CSSLink(String type, String rel, String href)
	{
		super("link", ComponentTypes.CSSLink);
		if (type != null)
		{
			addAttribute(CSSLinkAttributes.Type, type);
		}
		if (rel != null)
		{
			addAttribute(CSSLinkAttributes.Rel, rel);
		}
		if (href != null)
		{
			addAttribute(CSSLinkAttributes.HRef, href);
		}
		setInlineClosingTag(false);
	}

	/**
	 * Differences Between HTML and XHTML
	 * <p>
	 * In HTML the base tag has no end tag.
	 * <p>
	 * In XHTML the base tag must be properly closed.
	 */
	@Override
	public void preConfigure()
	{
		super.preConfigure();
		try
		{
			if (getPage().getBrowser()
			             .getHtmlVersion()
			             .name()
			             .startsWith("X"))
			{
				setInlineClosingTag(true);
			}
		}
		catch (Exception e)
		{
			log.log(Level.WARNING, "Unable to determine whether XHTML or HTML. Will still render correctly, just not W3 Compliant.", e);
		}
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	/**
	 * Is a valid equals clause
	 * <p>
	 *
	 * @param obj
	 * 		<p>
	 *
	 * @return
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null || !(obj instanceof CSSLink))
		{
			return false;
		}
		CSSLink lin = (CSSLink) obj;

		return getAttribute(CSSLinkAttributes.HRef).equals(lin.getAttribute(CSSLinkAttributes.HRef));
	}

	/**
	 * Returns the linked reference if any for the link
	 *
	 * @return
	 */
	public CSSReference getLinkedReference()
	{
		return linkedReference;
	}

	/**
	 * Returns the linked reference if any for the link
	 *
	 * @param linkedReference
	 */
	public void setLinkedReference(CSSReference linkedReference)
	{
		this.linkedReference = linkedReference;
	}

	/**
	 * @return
	 */
	@JsonIgnore
	public boolean isThemeLink()
	{
		if (getAttribute(CSSLinkAttributes.HRef) != null && getAttribute(CSSLinkAttributes.HRef).contains("_theme"))
		{
			themeLink = true;
		}

		return themeLink;
	}

	/**
	 * @param themeLink
	 */
	public void setThemeLink(boolean themeLink)
	{
		this.themeLink = themeLink;
	}

}
