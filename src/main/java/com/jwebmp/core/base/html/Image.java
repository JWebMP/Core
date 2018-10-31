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
import com.jwebmp.core.base.html.attributes.ImageAttributes;
import com.jwebmp.core.base.html.interfaces.FigureChildren;
import com.jwebmp.core.base.html.interfaces.GlobalChildren;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.children.ImageMapChildren;
import com.jwebmp.core.base.html.interfaces.children.ListItemChildren;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;

/**
 * Browser Support<p>
 * <p>
 * Internet Explorer Firefox Opera Google Chrome Safari<p>
 * <p>
 * <p>
 * The img tag is supported in all major browsers. Definition and Usage<p>
 * <p>
 * The img tag defines an image in an HTML page.<p>
 * <p>
 * The img tag has two required attributes: src and alt.<p>
 * <p>
 * Note: Images are not technically inserted into an HTML page, images are linked to HTML pages. The img tag creates a holding space for the referenced image.<p>
 * <p>
 * Tip: To link an image to another document, simply nest the img tag inside a tags. Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * <p>
 * The following attributes: align, border, hspace, longdesc, and vspace is not supported in HTML5.<p>
 * <p>
 * The following attributes: align, border, hspace, and vspace are deprecated in HTML 4.01. Differences Between HTML and XHTML<p>
 * <p>
 * In HTML the img tag has no end tag.<p>
 * <p>
 * In XHTML the img tag must be properly closed.<p>
 * <p>
 *
 * @param <J>
 *
 * @author Marc Magon
 */
public class Image<J extends Image<J>>
		extends Component<IComponentHierarchyBase, ImageAttributes, GlobalFeatures, GlobalEvents, J>
		implements ImageMapChildren<IComponentHierarchyBase, J>, FigureChildren<IComponentHierarchyBase, J>, GlobalChildren, ListItemChildren<IComponentHierarchyBase, J>
{


	/**
	 * Construct a new Image
	 *
	 * @param image
	 */
	public Image(String image)
	{
		super(ComponentTypes.Image);
		setInlineClosingTag(true);
		addAttribute(ImageAttributes.Src, image);
	}

	@Override
	public int hashCode()
	{
		return 7;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (!(obj instanceof Image))
		{
			return false;
		}

		return getAttribute(ImageAttributes.Src).equals(((Image) obj)
				                                                .getAttribute(ImageAttributes.Src));
	}

}
