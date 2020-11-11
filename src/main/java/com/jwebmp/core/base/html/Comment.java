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
import com.jwebmp.core.base.html.attributes.NoAttributes;
import com.jwebmp.core.base.html.interfaces.NoFeatures;
import com.jwebmp.core.base.html.interfaces.children.*;
import com.jwebmp.core.base.html.interfaces.events.NoEvents;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;
import com.jwebmp.core.utilities.TextUtilities;

import jakarta.validation.constraints.NotNull;

/**
 * Defines a basic comment line
 *
 * @author GedMarc
 */
public class Comment<C extends IComponentHierarchyBase, J extends Comment<C, J>>
		extends ComponentHierarchyBase<C, NoAttributes, NoFeatures, NoEvents, J>
		implements HtmlChildren<C, J>, HeadChildren<C, J>, ImageMapChildren<C, J>, BodyChildren<C, J>, PageChildren
{


	/**
	 * Adds the specified comment in a comment block for HTML
	 * <p>
	 *
	 * @param comment
	 */
	public Comment(String comment)
	{
		super(ComponentTypes.Comment);
		setText(comment);
	}

	/**
	 * Over-rides the render HTML tag
	 * <p>
	 *
	 * @param tabCount
	 * 		The specified tab count
	 * 		<p>
	 *
	 * @return A customized string for comments
	 */
	@Override
	@NotNull
	protected StringBuilder renderHTML(int tabCount)
	{
		if (getText(0).length() == 0)
		{
			return new StringBuilder();
		}
		return !isTiny() ? new StringBuilder(TextUtilities.getTabString(tabCount) + "<!-- " + getText(0) + " -->") : new StringBuilder();
	}
}
