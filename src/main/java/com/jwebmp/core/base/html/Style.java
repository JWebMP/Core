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

import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.html.attributes.StyleAttributes;
import com.jwebmp.core.base.html.interfaces.NoClassAttribute;
import com.jwebmp.core.base.html.interfaces.NoFeatures;
import com.jwebmp.core.base.html.interfaces.NoIDTag;
import com.jwebmp.core.base.html.interfaces.children.HeadChildren;
import com.jwebmp.core.base.html.interfaces.events.NoEvents;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;

/**
 * The Style Tag
 * <p>
 * <p>
 * Browser Support<p>
 * <p>
 * Internet Explorer FireFox Opera Google Chrome Safari<p>
 * <p>
 * The style tag is supported in all major browsers. Definition and Usage<p>
 * <p>
 * The style tag is used to define style information for an HTML document.<p>
 * <p>
 * Inside the style element you specify how HTML elements should render in a<p>
 * browser.<p>
 * <p>
 * Each HTML document can contain multiple style tags.<p>
 * <p>
 * <p>
 *
 * @param <J>
 *
 * @author MMagon
 * 		<p>
 * 		<p>
 * @version 1.0
 * @since 2013/11/12
 */
@SuppressWarnings("MissingClassJavaDoc")
public class Style<C extends IComponentHierarchyBase, J extends Style<C, J>>
		extends ComponentHierarchyBase<C, StyleAttributes, NoFeatures, NoEvents, J>
		implements NoIDTag, HeadChildren<C, J>, NoClassAttribute
{

	/**
	 * Field serialVersionUID
	 */


	/**
	 * Constructs a new blank Style tag
	 */
	public Style()
	{
		super(ComponentTypes.Style);
		addAttribute(StyleAttributes.Type, "text/css");
	}

	/**
	 * Returns the raw CSS Data (getText shortcut)
	 * <p>
	 *
	 * @return The generated css
	 */
	public String getCSS()
	{
		return getText(0).toString();
	}

	/**
	 * Sets the raw CSS Data
	 * <p>
	 *
	 * @param cssString
	 * 		The css String (raw txt)
	 */
	public void setCSS(String cssString)
	{
		setText(cssString);
	}

	/**
	 * @see com.jwebmp.core.base.ComponentHierarchyBase#hashCode()
	 */
	@Override
	public int hashCode()
	{
		return getText(0).hashCode();
	}

	/**
	 * @see com.jwebmp.core.base.ComponentHierarchyBase#equals(Object)
	 */
	@Override
	public boolean equals(Object o)
	{
		if (o == null)
		{
			return false;
		}
		if (Style.class.isAssignableFrom(o.getClass()))
		{
			return getText(0).toString()
			                 .equals(((Style) o)
					                         .getText(0)
					                         .toString());
		}
		return false;
	}
}
