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
package com.jwebmp;

import com.jwebmp.base.html.attributes.NoAttributes;
import com.jwebmp.base.html.interfaces.GlobalChildren;
import com.jwebmp.base.html.interfaces.GlobalFeatures;
import com.jwebmp.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.base.servlets.enumarations.ComponentTypes;
import com.jwebmp.utilities.StaticStrings;

import static com.jwebmp.utilities.StaticStrings.CHAR_HASH;
import static com.jwebmp.utilities.StaticStrings.STRING_DOT;

/**
 * Extention of a component with no HTML. Renders the ID and all references to it as a class name instead of ID form
 * <p>
 *
 * @param <J>
 *
 * @author GedMarc
 * @since 2015/04/24
 */
public abstract class CSSComponent<J extends CSSComponent<J>>
		extends Component<CSSComponent, NoAttributes, GlobalFeatures, GlobalEvents, J>
		implements GlobalChildren
{

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new CSS Class with the given features and events associated
	 * <p>
	 *
	 * @param className
	 */
	public CSSComponent(String className)
	{
		super(ComponentTypes.CSSClass);
		setID(className);
	}

	/**
	 * CSS Components don't render any HTML
	 *
	 * @param tabCount
	 *
	 * @return
	 */
	@Override
	protected StringBuilder renderHTML(int tabCount)
	{
		return new StringBuilder();
	}

	/**
	 * Returns the component rendering for JQuery string Requires the rendering for component is set
	 * <p>
	 *
	 * @return $(' # x ').
	 */
	@Override
	public String getJQueryID()
	{
		return "$(\'" + getID(true) + "\').";
	}

	/**
	 * Returns the ID with the . in the front of it
	 * <p>
	 *
	 * @param jQueryHolder
	 * 		Anything
	 * 		<p>
	 *
	 * @return An ID starting with .
	 */
	@Override
	public String getID(boolean jQueryHolder)
	{
		return STRING_DOT + getID();
	}

	/**
	 * Replaces the # with a .
	 *
	 * @return
	 */
	@Override
	public String getID()
	{
		return super.getID()
		            .replace(CHAR_HASH, StaticStrings.CHAR_DOT);
	}


}
