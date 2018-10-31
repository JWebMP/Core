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
import com.jwebmp.core.base.html.interfaces.children.BodyChildren;
import com.jwebmp.core.base.html.interfaces.children.generics.ParagraphChildren;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;

/**
 * Implements the PreFormattedText tag<p>
 * <p>
 * Definition and Usage<p>
 * <p>
 * The<p>
 * &gt;pre&lt; tag defines preformatted text.<p>
 * <p>
 * Text in a &gt;pre&lt; element is displayed in a fixed-width font (usually Courier), and it preserves both spaces and line breaks.<p>
 * Browser Support<p>
 * Element<p>
 * &gt;pre&lt; Yes Yes Yes Yes Yes<p>
 * Tips and Notes<p>
 * <p>
 * Tip: Use the &gt;pre&lt; element when displaying text with unusual formatting, or some sort of computer code.<p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * The "width" attribute is not supported in HTML5.<p>
 *
 * @param <J>
 *
 * @author mmagon
 * @version 1.0
 * @since 2014/06/12
 */
public class PreFormattedText<J extends PreFormattedText<J>>
		extends Component<IComponentHierarchyBase, NoAttributes, GlobalFeatures, GlobalEvents, J>
		implements BodyChildren<IComponentHierarchyBase, J>, NoNewLineForRawText, NoNewLineBeforeClosingTag, ParagraphChildren<IComponentHierarchyBase, J>
{


	/**
	 * Creates a new Pre tag
	 */
	public PreFormattedText()
	{
		this(null);
	}

	/**
	 * Constructs a new Pre-formatted Text Object with the given text set as the raw text
	 *
	 * @param preFormattedText
	 */
	public PreFormattedText(String preFormattedText)
	{
		super(ComponentTypes.PreFormatted);
		setText(preFormattedText);
	}
}
