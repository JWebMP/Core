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
import com.jwebmp.core.base.html.interfaces.GlobalChildren;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.children.PhraseChildren;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * The &gt;kbd&lt; tag is a phrase tag. It defines keyboard input.<p>
 * <p>
 * Tip: This tag is not deprecated, but it is possible to achieve richer effect with CSS.<p>
 * <p>
 * All phrase tags: Tag Description<p>
 * &gt;em&lt; Renders as emphasized text<p>
 * &gt;strong&lt; Defines important text<p>
 * &gt;code&lt; Defines a piece of computer code<p>
 * &gt;samp&lt; Defines sample output from a computer program<p>
 * &gt;kbd&lt; Defines keyboard input<p>
 * &gt;var&lt; Defines a variable Browser Support Element<p>
 * &gt;kbd&lt; Yes Yes Yes Yes Yes
 * <p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * NONE.<p>
 *
 * @param <J>
 * @author GedMarc
 * @version 1
 * @since 2015/02/09
 */
public class KeyboardInput<J extends KeyboardInput<J>>
		extends Component<GlobalChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
		implements PhraseChildren
{
	/**
	 * Constructs a new Keyboard Input
	 */
	public KeyboardInput()
	{
		super(ComponentTypes.KeyboardInput);
	}
	
}
