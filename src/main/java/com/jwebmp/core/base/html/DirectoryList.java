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
import com.jwebmp.core.base.html.attributes.DirectoryListAttributes;
import com.jwebmp.core.base.html.interfaces.NoFeatures;
import com.jwebmp.core.base.html.interfaces.children.DirectoryListChildren;
import com.jwebmp.core.base.html.interfaces.events.NoEvents;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage
 * <p>
 * The dir tag is not supported in HTML5. Use CSS instead.
 * <p>
 * The dir tag is used to list directory titles. Browser Support Element dir Yes Yes Yes Yes Yes
 * <p>
 * Tips and Notes
 * <p>
 * Tip: Use CSS to style lists! In our CSS tutorial you can find more details about styling lists. Differences Between HTML 4.01 and HTML5
 * <p>
 * The dir tag is not supported in HTML5.
 * <p>
 *
 * @param <J>
 *
 * @author GedMarc
 */
public class DirectoryList<J extends DirectoryList<J>>
		extends Component<DirectoryListChildren<DirectoryListChildren, J>, DirectoryListAttributes, NoFeatures, NoEvents, J>
{


	/**
	 *
	 */
	public DirectoryList()
	{
		super(ComponentTypes.DirectoryList);
	}
}
