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
package com.jwebmp.core.base.html;

import com.jwebmp.core.Component;
import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.html.attributes.LinkAttributes;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.NoNewLineForRawText;
import com.jwebmp.core.base.html.interfaces.children.BodyChildren;
import com.jwebmp.core.base.html.interfaces.children.ListChildren;
import com.jwebmp.core.base.html.interfaces.children.ListItemChildren;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;
import com.jwebmp.logger.LogFactory;

import javax.validation.constraints.NotNull;
import java.util.logging.Level;

/**
 * Browser Support<p>
 * <p>
 * Internet Explorer Firefox Opera Google Chrome Safari<p>
 * <p>
 * The a tag is supported in all major browsers. Definition and Usage<p>
 * <p>
 * The a tag defines a hyperlink, which is used to link from one page to another.<p>
 * <p>
 * The most important attribute of the a element is the href attribute, which indicates the link’s destination.<p>
 * <p>
 * By default, links will appear as follows in all browsers:
 * <p>
 * <p>
 * An unvisited link is underlined and blue A visited link is underlined and purple An active link is underlined and red<p>
 * <p>
 * Tips and Notes<p>
 * <p>
 * Tip: The following attributes: hreflang, media, rel, target, and type cannot be present if the href attribute is not present.<p>
 * <p>
 * Tip: A linked page is normally displayed in the current browser window, unless you specify another target.<p>
 * <p>
 * Tip: Use CSS to style links. Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * In HTML 4.01, the a tag could be either a hyperlink or an anchor. In HTML5, the a tag is always a hyperlink, but if it has no href
 * attribute, it is only a placeholder for a hyperlink.<p>
 * <p>
 * HTML5 has some new attributes, and some HTML 4.01 attributes are no longer supported.<p>
 *
 * @param <J>
 *
 * @author Marc Magon
 */
public class Link<J extends Link<J>>
		extends Component<IComponentHierarchyBase, LinkAttributes, GlobalFeatures, GlobalEvents, J>
		implements BodyChildren<IComponentHierarchyBase, J>, NoNewLineForRawText, ListItemChildren<IComponentHierarchyBase, J>, ListChildren<IComponentHierarchyBase, J>
{

	private static final java.util.logging.Logger log = LogFactory.getInstance()
	                                                              .getLogger("ALink");

	/**
	 * The address directing to
	 */
	private String directToAddress;
	/**
	 * The target frame
	 */
	private String targetFrameName;

	/**
	 * Constructs a new A tag
	 */
	public Link()
	{
		super("a", ComponentTypes.Link);
	}

	/**
	 * Creates a link directly to the address in the current window
	 * <p>
	 *
	 * @param directToAddress
	 * 		The address to redirect to
	 */
	public Link(String directToAddress)
	{
		this(directToAddress, null);
		if (directToAddress == null || directToAddress.isEmpty())
		{
			Link.log.log(Level.FINE, "Invalid Link Address.");
		}
	}

	/**
	 * Creates a link directly to the address in the specified target frame
	 * <p>
	 *
	 * @param directToAddress
	 * 		The address to redirect to
	 * @param targetFrameName
	 * 		The frame to redirect
	 */
	public Link(String directToAddress, String targetFrameName)
	{
		this(directToAddress, targetFrameName, (String) null);
	}

	/**
	 * Creates a link directly to the address in the specified target frame
	 * <p>
	 *
	 * @param directToAddress
	 * 		The address to redirect to
	 * @param targetFrameName
	 * 		The frame to redirect
	 * @param text
	 * 		Includes raw text in the link
	 */
	public Link(String directToAddress, String targetFrameName, String text)
	{
		super("a", ComponentTypes.Link);
		this.directToAddress = directToAddress;
		this.targetFrameName = targetFrameName;
		if (directToAddress != null)
		{
			addAttribute(LinkAttributes.HRef, directToAddress);
		}
		if (targetFrameName != null)
		{
			addAttribute(LinkAttributes.Target, targetFrameName);
		}
		setText(text);
	}

	/**
	 * Creates a link directly to the address in the specified target frame
	 * <p>
	 *
	 * @param directToAddress
	 * 		The address to redirect to
	 * @param targetFrameName
	 * 		The frame to redirect
	 * @param component
	 * 		Includes raw text in the link
	 */
	public Link(String directToAddress, String targetFrameName, ComponentHierarchyBase component)
	{
		super("a", ComponentTypes.Link);
		this.directToAddress = directToAddress;
		this.targetFrameName = targetFrameName;
		if (directToAddress != null)
		{
			addAttribute(LinkAttributes.HRef, directToAddress);
		}
		if (targetFrameName != null)
		{
			addAttribute(LinkAttributes.Target, targetFrameName);
		}
		add(component);
	}

	/**
	 * Returns the direct to address
	 * <p>
	 *
	 * @return The address redirecting to
	 */
	public String getDirectToAddress()
	{
		return directToAddress;
	}

	/**
	 * Sets the address to direct to
	 * <p>
	 *
	 * @param directToAddress
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setDirectToAddress(String directToAddress)
	{
		this.directToAddress = directToAddress;
		addAttribute(LinkAttributes.HRef, directToAddress);
		return (J) this;
	}

	/**
	 * Returns the current target frame name
	 * <p>
	 *
	 * @return The current target frame. Can be Null
	 */
	public String getTargetFrameName()
	{
		return targetFrameName;
	}

	/**
	 * Sets the target frame
	 * <p>
	 *
	 * @param targetFrameName
	 * 		The target frame
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setTargetFrameName(String targetFrameName)
	{
		this.targetFrameName = targetFrameName;
		addAttribute(LinkAttributes.Target, targetFrameName);
		return (J) this;
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	@Override
	public boolean equals(Object o)
	{
		return super.equals(o);
	}
}
