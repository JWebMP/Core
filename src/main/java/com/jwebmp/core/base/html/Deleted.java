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
import com.jwebmp.core.base.html.attributes.DeletedAttributes;
import com.jwebmp.core.base.html.interfaces.NoFeatures;
import com.jwebmp.core.base.html.interfaces.NoIDTag;
import com.jwebmp.core.base.html.interfaces.NoNewLineBeforeClosingTag;
import com.jwebmp.core.base.html.interfaces.NoNewLineForRawText;
import com.jwebmp.core.base.html.interfaces.children.generics.ParagraphChildren;
import com.jwebmp.core.base.html.interfaces.events.NoEvents;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage
 * <p>
 * The &lt;del&gt; tag defines text that has been deleted from a document. Browser Support Element &lt;del&gt; Yes Yes Yes Yes Yes
 * <p>
 * Tips and Notes
 * <p>
 * Tip: Also look at the &lt;ins&gt; tag to markup inserted text.
 * <p>
 * Tip: Use &lt;del&gt; and &lt;ins&gt; to markup updates and modifications in a document.
 * <p>
 * Browsers will normally strike a line through deleted text and underline inserted text.
 * <p>
 * Differences Between HTML 4.01 and HTML5
 * <p>
 * NONE.
 * <p>
 *
 * @param <J>
 *
 * @author GedMarc
 * @since 2014/12/21
 */
public class Deleted<J extends Deleted<J>>
		extends Component<IComponentHierarchyBase, DeletedAttributes, NoFeatures, NoEvents, J>
		implements NoNewLineBeforeClosingTag, NoNewLineForRawText, NoIDTag, ParagraphChildren<IComponentHierarchyBase, J>
{


	/**
	 * The text marked as deleted
	 * <p>
	 *
	 * @param text
	 */
	public Deleted(String text)
	{
		super(ComponentTypes.Deleted);
		setText(text);
	}
}
