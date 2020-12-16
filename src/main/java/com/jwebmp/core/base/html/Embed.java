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
import com.jwebmp.core.base.html.attributes.EmbedAttributes;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.NoClosingTag;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage
 * <p>
 * The &lt;embed&gt; tag defines a container for an external application or interactive content (a plug-in). Browser Support Element &lt;embed&gt; Yes Yes Yes Yes Yes
 * <p>
 * Differences Between HTML 4.01 and HTML5
 * <p>
 * The &lt;embed&gt; tag is new in HTML5.
 * <p>
 * Note: Many web browsers have supported the &lt;embed&gt; tag for a long time.
 * <p>
 * However, the &lt;embed&gt; tag has not been a part of the HTML 4 specification.
 * <p>
 * The &lt;embed&gt; tag is new in HTML5, and will validate in an HTML5 page. However, if you use it in an HTML 4 page, the page will not validate.
 * <p>
 *
 * @param <J>
 *
 * @author GedMarc
 * @since 2014/12/21
 */
public class Embed<J extends Embed<J>>
		extends Component<IComponentHierarchyBase<?,?>, EmbedAttributes, GlobalFeatures, GlobalEvents, J>
		implements NoClosingTag
{


	/**
	 * Constructs an embedded content type with the media type and source specified
	 *
	 * @param source
	 * @param mediaType
	 */
	public Embed(String source, String mediaType)
	{
		super(ComponentTypes.Embed);
		addAttribute(EmbedAttributes.Src, source);
		addAttribute(EmbedAttributes.Type, mediaType);
	}
}
