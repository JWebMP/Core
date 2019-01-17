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

import com.jwebmp.core.Component;
import com.jwebmp.core.base.html.attributes.NoAttributes;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.NoNewLineBeforeClosingTag;
import com.jwebmp.core.base.html.interfaces.NoNewLineForRawText;
import com.jwebmp.core.base.html.interfaces.children.DetailsChildren;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * The &lt;summary&gt; tag defines a visible heading for the &lt;details&gt; element. The heading can be clicked to view/hide the details.<p>
 * Browser Support<p>
 * <p>
 * The numbers in the table specify the first browser version that fully supports the element.<p>
 * Element
 * <p>
 * &lt;summary&gt; 12.0 Not supported Not supported 6.0 15.0
 * <p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * The &lt;summary&gt; tag is new in HTML5.<p>
 *
 * @param <J>
 *
 * @author GedMarc
 * @version 1.0
 * 		<p>
 * @since Mar 1, 2015
 */
public class Summary<J extends Summary<J>>
		extends Component<IComponentHierarchyBase, NoAttributes, GlobalFeatures, GlobalEvents, J>
		implements DetailsChildren<IComponentHierarchyBase, J>, NoNewLineBeforeClosingTag, NoNewLineForRawText
{


	/**
	 * Constructs a new instance of summary
	 */
	public Summary()
	{
		this(null);
	}

	/**
	 * @param text
	 * 		The raw text
	 */
	public Summary(String text)
	{
		super(ComponentTypes.Summary);
		setText(text);
	}

}
