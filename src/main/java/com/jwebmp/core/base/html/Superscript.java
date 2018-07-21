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
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.NoNewLineBeforeClosingTag;
import com.jwebmp.core.base.html.interfaces.NoNewLineForRawText;
import com.jwebmp.core.base.html.interfaces.children.PhraseChildren;
import com.jwebmp.core.base.html.interfaces.children.generics.ParagraphChildren;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * The &lt;sup&gt; tag defines superscript text.<p>
 * <p>
 * Superscript text appears half a character above the normal line, and is sometimes rendered in a smaller font.<p>
 * <p>
 * Superscript text can be used for footnotes, like WWW[1]
 * <p>
 * .<P>
 * <p>
 * Tip: Use the &lt;sub&gt; tag to define subscript text.<P>
 * Browser Support<p>
 * <p>
 * Element &lt;sup&gt; Yes Yes Yes Yes Yes<p>
 * <p>
 * Differences Between HTML 4.01 and HTML5<P>
 * <p>
 * NONE.<p>
 *
 * @param <J>
 *
 * @author Marc Magon
 * @version 1.0
 * @since forever
 */
public class Superscript<J extends Superscript<J>>
		extends Component<ParagraphChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
		implements NoNewLineBeforeClosingTag, NoNewLineForRawText, ParagraphChildren, PhraseChildren
{

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs and empty super script tag
	 */
	public Superscript()
	{
		this(null);
	}

	/**
	 * Constructs a new superscript tag with the given raw text
	 *
	 * @param text
	 */
	public Superscript(String text)
	{
		super("sup", ComponentTypes.SuperScript);
		setText(text);
	}
}
