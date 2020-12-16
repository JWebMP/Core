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
import com.jwebmp.core.base.html.interfaces.*;
import com.jwebmp.core.base.html.interfaces.children.FormChildren;
import com.jwebmp.core.base.html.interfaces.children.ListItemChildren;
import com.jwebmp.core.base.html.interfaces.children.generics.ParagraphChildren;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * The &lt;i;&gt; tag defines a part of text in an alternate voice or mood. The content of the &lt;i;&gt; tag is usually displayed in italic.<p>
 * <p>
 * The &lt;i;&gt; tag can be used to indicate a technical term, a phrase from another language, a thought, or a ship name, etc.<p>
 * <p>
 * Use the &lt;i;&gt; element only when there is not a more appropriate semantic element, such as:
 * <p>
 * <p>
 * &lt;em&gt; (emphasized text)
 * <p>
 * &lt;strong&gt; (important text)
 * <p>
 * &lt;mark&gt; (marked/highlighted text)
 * <p>
 * &lt;cite&gt; (the title of a work)
 * <p>
 * &lt;dfn&gt; (a definition term)
 * <p>
 * <p>
 * Browser Support Element<p>
 * &lt;i;&gt; Yes Yes Yes Yes Yes<p>
 * <p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * In HTML 4.01, the &lt;i;&gt; tag was used to render text in italics. However, this is not necessarily the case with HTML5. Style sheets can be used to format the text inside the
 * &lt;i;&gt;
 * element.<p>
 * <p>
 *
 * @param <J>
 *
 * @author GedMarc
 */
public class Italic<J extends Italic<J>>
		extends Component<GlobalChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
		implements NoNewLineBeforeClosingTag, NoNewLineForRawText, NoIDTag, ParagraphChildren, ListItemChildren, FormChildren
{
	/**
	 * Constructs a new paragraph child of Italic
	 */
	public Italic()
	{
		this(null);
	}

	/**
	 * *
	 * Constructs a new italic section with the given text
	 * <p>
	 *
	 * @param text
	 */
	public Italic(String text)
	{
		super(ComponentTypes.Italic);
		setText(text);
	}

}
