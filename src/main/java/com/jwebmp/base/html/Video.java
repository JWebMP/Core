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
package com.jwebmp.base.html;

import com.jwebmp.Component;
import com.jwebmp.base.html.attributes.VideoAttributes;
import com.jwebmp.base.html.interfaces.GlobalFeatures;
import com.jwebmp.base.html.interfaces.children.VideoChildren;
import com.jwebmp.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.base.servlets.enumarations.ComponentTypes;

/**
 * Browser Support<p>
 * <p>
 * The numbers in the table specify the first browser version that fully supports the element.
 * <p>
 * Element &lt;video&gt; 4.0 9.0 3.5 4.0 10.5
 * <p>
 * Differences Between HTML 4.01 and HTML5
 * <p>
 * The &lt;video&gt; tag is new in HTML5.<p>
 * <p>
 *
 * @param <J>
 *
 * @author GedMarc
 * @version 1.0
 * 		<p>
 * @since Mar 1, 2015
 */
public class Video<J extends Video<J>>
		extends Component<VideoChildren, VideoAttributes, GlobalFeatures, GlobalEvents, J>
{

	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	public Video()
	{
		super(ComponentTypes.Video);
	}
}
