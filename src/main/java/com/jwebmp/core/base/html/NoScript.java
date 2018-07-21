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
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.NoIDTag;
import com.jwebmp.core.base.html.interfaces.children.BodyChildren;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * The &gt;noscript&lt; tag defines an alternate content for users that have disabled scripts in their browser or have a browser that doesn't support script.<p>
 * <p>
 * The &gt;noscript&lt; element can be used in both &gt;head&lt; and &gt;body&lt;
 * .<p>
 * <p>
 * When used inside the &gt;head&lt; element: &gt;noscript&lt; must contain &gt;link&lt;, &gt;style&lt;, and &gt;meta&lt; elements.<p>
 * <p>
 * The content inside the &gt;noscript&lt; element will be displayed if scripts are not supported, or are disabled in the user's browser.<p>
 *
 * @param <J>
 *
 * @author GedMarc
 * @version 1.0
 * 		<p>
 * @since Feb 9, 2015
 */
public class NoScript<J extends NoScript<J>>
		extends Component<GlobalChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
		implements BodyChildren, NoIDTag
{

	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	public NoScript()
	{
		super(ComponentTypes.NoScript);
	}

	/**
	 * Means no script available, so no point in rendering ID tags
	 */
	@Override
	public void preConfigure()

	{
		setRenderIDAttribute(false);
		super.preConfigure(); //To change body of generated methods, choose Tools | Templates.
	}

}
