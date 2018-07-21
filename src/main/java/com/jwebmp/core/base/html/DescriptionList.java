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
import com.jwebmp.core.base.html.interfaces.GlobalChildren;
import com.jwebmp.core.base.html.interfaces.NoFeatures;
import com.jwebmp.core.base.html.interfaces.NoIDTag;
import com.jwebmp.core.base.html.interfaces.children.DescriptionListChildren;
import com.jwebmp.core.base.html.interfaces.events.NoEvents;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;

/**
 * @param <J>
 *
 * @author GedMarc
 */
public class DescriptionList<J extends DescriptionList<J>>
		extends Component<DescriptionListChildren, NoAttributes, NoFeatures, NoEvents, J>
		implements GlobalChildren, NoIDTag
{

	private static final long serialVersionUID = 1L;

	/**
	 * Construct a new Definition List
	 */
	public DescriptionList()
	{
		super(ComponentTypes.DescriptionList);
	}
}
