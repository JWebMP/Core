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
package com.jwebmp.base.html;

import com.jwebmp.Component;
import com.jwebmp.base.html.attributes.NoAttributes;
import com.jwebmp.base.html.interfaces.GlobalChildren;
import com.jwebmp.base.html.interfaces.GlobalFeatures;
import com.jwebmp.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * The nav tag defines a set of navigation links.<p>
 * <p>
 * <p>
 * Notice that NOT all links of a document should be inside a &gt;nav&lt; element.<p>
 * <p>
 * The &gt;nav&lt; element is intended only for major block of navigation links.<p>
 * <p>
 * Browsers, such as screen readers for disabled users, can use this element to determine whether to omit the initial rendering of this content. Browser Support<p>
 * <p>
 * <p>
 * The numbers in the table specify the first browser version that fully supports the element. Element<p>
 * &gt;nav&lt; 6.0 9.0 4.0 5.0 11.1 Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * The &gt;nav&lt; tag is new in HTML5.<p>
 * <p>
 *
 * @param <J>
 *
 * @author GedMarc
 * @version 1.0
 * 		<p>
 * @since Feb 9, 2015
 */
public class NavigationSection<J extends NavigationSection<J>>
		extends Component<GlobalChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
{

	private static final long serialVersionUID = 1L;

	/**
	 * Construct a new navigation section
	 */
	public NavigationSection()
	{
		super(ComponentTypes.Navigation);
	}
}
