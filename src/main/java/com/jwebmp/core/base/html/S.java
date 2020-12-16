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
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.NoNewLineBeforeClosingTag;
import com.jwebmp.core.base.html.interfaces.NoNewLineForRawText;
import com.jwebmp.core.base.html.interfaces.children.generics.ParagraphChildren;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * The &lt;s&gt; tag specifies text that is no longer correct, accurate or relevant.<p>
 * <p>
 * The &lt;s&gt; tag should not be used to define replaced or deleted text, use the &lt;del&gt; tag to define replaced or deleted text.<p>
 * <p>
 * Browser Support<p>
 * <p>
 * Element<p>
 * <p>
 * &lt;s&gt; Yes Yes Yes Yes Yes<p>
 * <p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * <p>
 * The &lt;s&gt; element was deprecated in HTML 4.01, and was used to define strikethrough text.<p>
 * <p>
 * The &lt;s&gt; element is redefined in HTML5, and is now used to define text that is no longer correct.<p>
 * <p>
 *
 * @param <J>
 *
 * @author GedMarc
 * @version 1.0
 * 		<p>
 * @since Mar 1, 2015
 */
public class S<J extends S<J>>
		extends Component<ParagraphChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
		implements ParagraphChildren, NoNewLineForRawText, NoNewLineBeforeClosingTag
{


	/**
	 * Constructs a new instance of S
	 */
	public S()
	{
		super(ComponentTypes.S);
	}
}
