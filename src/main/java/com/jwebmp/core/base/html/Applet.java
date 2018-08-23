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
import com.jwebmp.core.base.html.attributes.AppletAttributes;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;

/**
 * Defines a java Applet tag
 * <p>
 *
 * @param <J>
 *
 * @since @version @author MMagon
 */
public class Applet<J extends Applet<J>>
		extends Component<IComponentHierarchyBase, AppletAttributes, GlobalFeatures, GlobalEvents, J>
{

	/**
	 * Serial Version for all Components and their compatibility
	 */
	private static final long serialVersionUID = 1l;

	/**
	 * Constructs a new applet
	 */
	public Applet()
	{
		super(ComponentTypes.Applet.getComponentTag(), ComponentTypes.Applet);
		setTiny(true);
	}

}
