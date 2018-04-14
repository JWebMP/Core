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
import com.jwebmp.base.angular.AngularPageConfigurator;
import com.jwebmp.base.html.attributes.ParagraphAttributes;
import com.jwebmp.base.html.interfaces.GlobalFeatures;
import com.jwebmp.base.html.interfaces.NoNewLineForRawText;
import com.jwebmp.base.html.interfaces.children.BodyChildren;
import com.jwebmp.base.html.interfaces.children.DetailsChildren;
import com.jwebmp.base.html.interfaces.children.HeadChildren;
import com.jwebmp.base.html.interfaces.children.generics.ParagraphChildren;
import com.jwebmp.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.base.servlets.enumarations.ComponentTypes;
import com.jwebmp.utilities.TextUtilities;

/**
 * This class defines a paragraph as per<p>
 * <p>
 * Definition and Usage<p>
 * <p>
 * The<p>
 * &lt;p&gt;
 * <p>
 * tag defines a paragraph.<p>
 * <p>
 * Browsers automatically add some space (m<p>
 * argin) before and after each<p>
 * &lt;p&gt;
 * <p>
 * element. The margins can be modified with CSS (with the margin properties). Browser Support Element<p>
 * &lt;p&gt;
 * <p>
 * Yes Yes Yes Yes Yes Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * The align attribute is not supported in HTML5.<p>
 * <p>
 *
 * @param <J>
 *
 * @author Marc Magon
 * @version 1.0
 * @since forever, 2008 or 2007 sometime I think - will need to check on the original version named "radio on live".
 */
public class Paragraph<J extends Paragraph<J>>
		extends Component<ParagraphChildren, ParagraphAttributes, GlobalFeatures, GlobalEvents, J>
		implements BodyChildren, NoNewLineForRawText, ParagraphChildren, DetailsChildren, HeadChildren
{

	private static final long serialVersionUID = 1L;
	/**
	 * Sets if this paragraph must render the text directly without a tag
	 */
	private boolean textOnly;

	/**
	 * Constructs a blank paragraph
	 */
	public Paragraph()
	{
		this("");
	}

	/**
	 * Constructs a new paragraph with the raw text set as the input text
	 * <p>
	 *
	 * @param text
	 */
	public Paragraph(String text)
	{
		super("p", ComponentTypes.Paragraph);
		setText(text);
	}

	@Override
	protected StringBuilder renderHTML(int tabCount)
	{
		if (isTextOnly())
		{
			return TextUtilities.getTabString(tabCount)
			                    .append(new StringBuilder(getText(tabCount)));
		}
		else
		{
			return super.renderHTML(tabCount);
		}
	}

	/**
	 * Sets if this paragraph must render the text directly without a tag
	 *
	 * @return
	 */
	public boolean isTextOnly()
	{
		return textOnly;
	}

	/**
	 * Sets if this paragraph must render the text directly without a tag
	 *
	 * @param textOnly
	 *
	 * @return
	 */
	public Paragraph setTextOnly(boolean textOnly)
	{
		this.textOnly = textOnly;
		return this;
	}

	/**
	 * Don't use the bind attribute, append in curly braces
	 *
	 * @param variableName
	 *
	 * @return
	 */
	@Override
	public J bind(String variableName)
	{
		AngularPageConfigurator.setRequired(true);
		if (variableName.contains("{{"))
		{
			setText(getText(0) + variableName);
		}
		else
		{
			setText(getText(0) + "{{" + variableName + "}}");
		}
		return (J) this;
	}

	@Override
	public boolean equals(Object o)
	{
		return super.equals(o);
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}
}
