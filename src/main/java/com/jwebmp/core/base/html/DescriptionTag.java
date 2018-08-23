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
import com.jwebmp.core.base.html.interfaces.NoFeatures;
import com.jwebmp.core.base.html.interfaces.NoIDTag;
import com.jwebmp.core.base.html.interfaces.NoNewLineBeforeClosingTag;
import com.jwebmp.core.base.html.interfaces.NoNewLineForRawText;
import com.jwebmp.core.base.html.interfaces.children.DescriptionListChildren;
import com.jwebmp.core.base.html.interfaces.events.NoEvents;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * &lt;p&gt;
 * <p>
 * The &lt;dt&gt; tag defines a term/name in a description list.<p>
 * &lt;p&gt;
 * <p>
 * The &lt;dt&gt; tag is used in conjunction with &lt;dl&gt; (defines a description list) and &lt;dd&gt; (describes each term/name). Browser Support Element<p>
 * &lt;dt&gt; Yes Yes Yes Yes Yes<p>
 * &lt;p&gt;
 * <p>
 * Differences Between HTML 4.01 and HTML5<p>
 * &lt;p&gt;
 * <p>
 * In HTML 4.01, the &lt;dt&gt; tag defines an item in a definition list.<p>
 * &lt;p&gt;
 * <p>
 * In HTML5, the &lt;dt&gt; tag defines a term/name in a description list.<p>
 * &lt;p&gt;
 *
 * @param <J>
 *
 * @author GedMarc
 */
public class DescriptionTag<J extends DescriptionTag<J>>
		extends Component<IComponentHierarchyBase, NoAttributes, NoFeatures, NoEvents, J>
		implements NoIDTag, NoNewLineBeforeClosingTag, NoNewLineForRawText, DescriptionListChildren<IComponentHierarchyBase, J>
{

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new Description Tag
	 */
	public DescriptionTag()
	{
		super(ComponentTypes.DescriptionTag);
	}
}
