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

import java.io.Serializable;

/**
 * Definition and Usage
 * <p>
 * <p>
 * The article tag specifies independent, self-contained content.<p>
 * <p>
 * An article should make sense on its own and it should be possible to distribute it independently from the rest of the site.<p>
 * <p>
 * Potential sources for the article element:
 * <p>
 * <p>
 * Forum post Blog post News story Comment<p>
 * <p>
 * Browser Support<p>
 * <p>
 * The numbers in the table specify the first browser version that fully supports the element.
 * <p>
 * Element<p>
 * article 6.0 9.0 4.0 5.0 11.1
 * <p>
 * <p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * The article tag is new in HTML5. Global Attributes<p>
 * <p>
 * The article tag also supports the Global Attributes in HTML. Event Attributes<p>
 * <p>
 * The article tag also supports the Event Attributes in HTML.<p>
 * <p>
 *
 * @param <J>
 *
 * @author MMagon
 * 		<p>
 * @version 1.0
 * @since 2014/10/26
 */
public class Article<J extends Article<J>>
		extends Component<ParagraphChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
		implements NoNewLineBeforeClosingTag, NoNewLineForRawText, Serializable
{
	/**
	 * Constructs a new instance of article
	 */
	public Article()
	{
		this(null);
	}

	/**
	 * Constructs a new article instance
	 *
	 * @param text
	 */
	public Article(String text)
	{
		super(ComponentTypes.Article.getComponentTag(), ComponentTypes.Article);
		setText(text);
	}

}
