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
import com.jwebmp.core.base.html.attributes.BlockQuoteAttributes;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.children.generics.ParagraphChildren;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage
 * <p>
 * The &lt;blockquote&gt; tag specifies a section that is quoted from another source.
 * <p>
 * Browsers usually indent &lt;blockquote&gt; elements. Browser Support Element &lt;blockquote&gt; Yes Yes Yes Yes Yes
 * <p>
 * Tips and Notes
 * <p>
 * Tip: Use &lt;q&gt; for inline (short) quotations. Differences Between HTML 4.01 and HTML5
 * <p>
 * In HTML 4.01, the &lt;blockquote&gt; tag defines a long quotation.
 * <p>
 * In HTML5, the &lt;blockquote&gt; tag specifies a section that is quoted from another source. Differences Between HTML and XHTML
 * <p>
 * Note: To validate a &lt;blockquote&gt; element as XHTML, it must contain only other block-level elements, like this:
 * <p>
 * &lt;blockquote&gt;
 * <p>
 * Here is a long quotation here is a long quotation.
 * <p>
 * &lt;/blockquote&gt;
 * <p>
 *
 * @param <J>
 * @author GedMarc
 */
public class BlockQuote<J extends BlockQuote<J>>
		extends Component<ParagraphChildren, BlockQuoteAttributes, GlobalFeatures, GlobalEvents, J>

{
	/**
	 * Constructs a new block quote with the given text
	 *
	 * @param text
	 */
	public BlockQuote(String text)
	{
		this();
		setText(text);
	}
	
	/**
	 * Constructs a new Block Quote Item
	 */
	public BlockQuote()
	{
		super(ComponentTypes.BlockQuotes);
	}
	
	/**
	 * Constructs a new block quote with the given text and footer
	 *
	 * @param text
	 * @param footer
	 */
	public BlockQuote(String text, String footer)
	{
		this();
		add(text);
		Span d = new Span();
		d.setTag("footer");
		d.setText(footer);
		add(d);
	}
}
