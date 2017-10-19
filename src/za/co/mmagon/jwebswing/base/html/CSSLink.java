/*
 * Copyright (C) 2017 Marc Magon
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
package za.co.mmagon.jwebswing.base.html;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.CSSLinkAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.NoClosingTag;
import za.co.mmagon.jwebswing.base.html.interfaces.NoFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.NoIDTag;
import za.co.mmagon.jwebswing.base.html.interfaces.children.HeadChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.NoChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.NoEvents;
import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.logger.LogFactory;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Header CSSLink Component
 * <p>
 *
 * @param <J>
 *
 * @author MMagon
 * <p>
 * <p>
 * <p>
 * Browser Support<p>
 * <p>
 * Internet Explorer Firefox Opera Google Chrome Safari<p>
 * <p>
 * When used for style sheets, the link tag is supported in all major browsers.<p>
 * No real support for anything else. Definition and Usage<p>
 * <p>
 * The link tag defines the relationship between a document and an external<p>
 * resource.<p>
 * <p>
 * The link tag is most used to link to style sheets.<p>
 * <p>
 * Note: The link element is an empty element, it contains attributes only.<p>
 * <p>
 * Note: This element goes only in the head section, but it can appear any<p>
 * number of times. Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * Some HTML 4.01 attributes are not supported in HTML5.<p>
 * <p>
 * The "sizes" attribute is new in HTML5.<p>
 * @version 1.0
 * @since 2013/11/12
 */
public class CSSLink<J extends CSSLink<J>>
		extends Component<NoChildren, CSSLinkAttributes, NoFeatures, NoEvents, J>
		implements NoIDTag, NoClosingTag, HeadChildren
{
	
	private static final Logger LOG = LogFactory.getInstance().getLogger("HeadCSSLink");
	
	private static final long serialVersionUID = 1L;
	/**
	 * If this link is a theme link
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Boolean themeLink;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	/**
	 * If this link is a secondary theme link
	 */
	private Boolean prettifyTheme;
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
	 * @param cssFile The file to route
	 */
	public CSSLink(String cssFile)
	{
		super("link", ComponentTypes.CSSLink);
		addAttribute(CSSLinkAttributes.Type, "text/css");
		addAttribute(CSSLinkAttributes.Rel, "stylesheet");
		addAttribute(CSSLinkAttributes.HRef, cssFile);
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
		addAttribute(CSSLinkAttributes.Type, type);
		addAttribute(CSSLinkAttributes.Rel, rel);
		addAttribute(CSSLinkAttributes.HRef, href);
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
			if (getPage().getBrowser().getHtmlVersion().name().startsWith("X"))
			{
				setInlineClosingTag(true);
			}
		}
		catch (Exception e)
		{
			LOG.log(Level.WARNING, "Unable to determine whether XHTML or HTML. Will still render correctly, just not W3 Compliant.", e);
		}
		
		if (isPrettifyTheme())
		{
			addClass("prettify");
		}
	}
	
	/**
	 * Is a valid equals clause
	 * <p>
	 *
	 * @param obj <p>
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
		final CSSLink lin = (CSSLink) obj;
		
		return this.getAttribute(CSSLinkAttributes.HRef).equals(lin.getAttribute(CSSLinkAttributes.HRef));
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(super.hashCode(), isThemeLink(), isPrettifyTheme(), getLinkedReference());
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
	
	/**
	 * Gets the prettify theme
	 *
	 * @return
	 */
	public boolean isPrettifyTheme()
	{
		prettifyTheme = getAttribute(CSSLinkAttributes.HRef).contains("prettify/");
		return prettifyTheme;
	}
	
	/**
	 * Sets the prettify theme if required
	 *
	 * @param prettifyTheme
	 */
	public void setPrettifyTheme(boolean prettifyTheme)
	{
		this.prettifyTheme = prettifyTheme;
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
	
}
