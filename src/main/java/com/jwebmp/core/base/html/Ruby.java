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
import com.jwebmp.core.base.html.attributes.NoAttributes;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.children.RubyChildren;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * The &lt;ruby&gt; tag specifies a ruby annotation.<p>
 * <p>
 * Ruby annotations are used for East Asian typography, to show the pronunciation of East Asian characters.<p>
 * <p>
 * Use the &lt;ruby&gt; tag together with the &lt;rt&gt; and/or the &lt;rp&gt; tags: The &lt;ruby&gt; element consists of one or more characters that needs an
 * explanation/pronunciation, and an<p>
 * &lt;rt&gt; element that gives that information, and an optional &lt;rp&gt; element that defines what to show for browsers that not support ruby annotations. Browser Support<p>
 * <p>
 * The numbers in the table specify the first browser version that fully supports the element.<p>
 * <p>
 * Element<p>
 * <p>
 * &lt;ruby&gt; 5.0 5.5 Not supported 5.0 15.0
 * <p>
 * <p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * The &lt;ruby&gt; tag is new in HTML5.<p>
 * <p>
 *
 * @param <J>
 *
 * @author GedMarc
 * @version 1.0
 * 		<p>
 * @since Mar 1, 2015
 */
public class Ruby<J extends Ruby<J>>
		extends Component<RubyChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
{


	/**
	 * Constructs a new Ruby process
	 */
	public Ruby()
	{
		super(ComponentTypes.Ruby);
	}
}
