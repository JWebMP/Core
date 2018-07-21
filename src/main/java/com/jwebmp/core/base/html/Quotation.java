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
import com.jwebmp.core.base.html.attributes.QuotationAttributes;
import com.jwebmp.core.base.html.interfaces.GlobalChildren;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.NoNewLineBeforeClosingTag;
import com.jwebmp.core.base.html.interfaces.NoNewLineForRawText;
import com.jwebmp.core.base.html.interfaces.children.generics.ParagraphChildren;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * The &lt;q&gt; tag defines a short quotation.<p>
 * <p>
 * Browsers normally insert quotation marks around the quotation.<p>
 * <p>
 * Browser Support<p>
 * &lt;q&gt; Yes Yes Yes Yes Yes<p>
 * <p>
 * Tips and Notes<p>
 * <p>
 * Tip: Use blockquote to mark up a section that is quoted from another source.<p>
 * <p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * NONE.
 *
 * @param <J>
 *
 * @author GedMarc
 * @version 1.0
 * 		<p>
 * @since Mar 1, 2015
 */
public class Quotation<J extends Quotation<J>>
		extends Component<GlobalChildren, QuotationAttributes, GlobalFeatures, GlobalEvents, J>
		implements ParagraphChildren, NoNewLineBeforeClosingTag, NoNewLineForRawText
{

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new Quotation
	 *
	 * @param text
	 * 		Specifies the quotation text
	 */
	public Quotation(String text)
	{
		super(ComponentTypes.Quotation);
	}
}
