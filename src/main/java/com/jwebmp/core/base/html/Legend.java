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
import com.jwebmp.core.base.html.interfaces.NoNewLineBeforeClosingTag;
import com.jwebmp.core.base.html.interfaces.children.FieldSetChildren;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * The legend tag defines a caption for the field set element. Browser Support<p>
 * Element<p>
 * legend Yes Yes Yes Yes Yes Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * The "align" attribute is not supported in HTML5.<p>
 * <p>
 *
 * @param <J>
 * @author GedMarc
 * @version 1.0
 * <p>
 * @since Feb 9, 2015
 */
public class Legend<J extends Legend<J>>
		extends Component<GlobalChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
		implements FieldSetChildren, NoNewLineBeforeClosingTag
{
	public Legend()
	{
		super(ComponentTypes.Legend);
	}
}
