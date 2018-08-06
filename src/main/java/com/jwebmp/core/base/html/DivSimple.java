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

import com.jwebmp.core.base.html.attributes.NoAttributes;
import com.jwebmp.core.base.html.interfaces.GlobalChildren;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;

/**
 * A basic div with the typed mostly taken care of
 *
 * @param <J>
 * 		This type
 */
public class DivSimple<J extends DivSimple<J>>
		extends Div<GlobalChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
{
	/**
	 * Constructs a new simple div
	 */
	public DivSimple()
	{
	}

	/**
	 * Constructs a new simple div
	 *
	 * @param myComponent
	 */
	public DivSimple(ComponentTypes myComponent)
	{
		super(myComponent);
	}

	/**
	 * Constructs a new simple div with the given text
	 *
	 * @param text
	 * 		Raw text to apply
	 */
	public DivSimple(String text)
	{
		super(text);
	}
}
