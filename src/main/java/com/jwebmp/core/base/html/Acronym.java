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
import com.jwebmp.core.base.client.HTMLVersions;
import com.jwebmp.core.base.html.attributes.NoAttributes;
import com.jwebmp.core.base.html.interfaces.NoFeatures;
import com.jwebmp.core.base.html.interfaces.NoIDTag;
import com.jwebmp.core.base.html.interfaces.NoNewLineBeforeClosingTag;
import com.jwebmp.core.base.html.interfaces.NoNewLineForRawText;
import com.jwebmp.core.base.html.interfaces.children.BodyChildren;
import com.jwebmp.core.base.html.interfaces.children.HtmlChildren;
import com.jwebmp.core.base.html.interfaces.children.NoChildren;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;
import lombok.extern.java.Log;

import java.io.Serializable;
import java.util.logging.Level;

/**
 * Definition and Usage<p>
 * <p>
 * The &lt;acronym&gt; tag is not supported in HTML5. Use the &lt;abbr&gt; tag instead.<p>
 * <p>
 * The &lt;acronym&gt; tag defines an acronym.<p>
 * <p>
 * An acronym can be spoken as if it were a word, example NATO, NASA, ASAP, GUI.<p>
 * <p>
 * By marking up acronyms you can give useful information to browsers, spell checkers, translation systems and search-engine indexers. Browser Support Element<p>
 * &lt;acronym&gt; All Browsers<p>
 * <p>
 * Tips and Notes<p>
 * <p>
 * Tip: The title attribute can be used to show the full version of the acronym when you mouse over it. Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * The &lt;acronym&gt; tag is not supported in HTML5.<p>
 * <p>
 * The &lt;acronym&gt; tag is not supported in HTML5. Use the &lt;abbr&gt; tag instead.<p>
 *
 * @param <J>
 *
 * @author MMagon
 * @version 1.0
 * @since 2014 09 22
 */
@Log
public class Acronym<J extends Acronym<J>>
		extends Component<NoChildren, NoAttributes, NoFeatures, GlobalEvents, J>
		implements NoNewLineBeforeClosingTag, NoNewLineForRawText, HtmlChildren, BodyChildren, Serializable, NoIDTag
{

	/**
	 * Constructs an Acronym
	 * <p>
	 *
	 * @param text
	 */
	public Acronym(String text)
	{
		this();
		setText(text);
	}

	/**
	 * Constructs an Acronym
	 * <p>
	 */
	public Acronym()
	{
		super(ComponentTypes.Acronym.getComponentTag(), ComponentTypes.Acronym);
	}

	/**
	 * Differences Between HTML and HTML 5
	 * <p>
	 * The &gt;acronym&lt; tag is not supported in HTML5. Use the &gt;abbr&lt; tag instead.
	 */
	@Override
	public void preConfigure()
	{
		super.preConfigure();
		try
		{
			if (getPage().getBrowser()
			             .getHtmlVersion() == HTMLVersions.HTML5)
			{
				setTag("abbr");
			}
		}
		catch (Exception e)
		{
			Acronym.log.log(Level.FINE, "Unable to determine whether HTML or HTML5. Document type not set?", e);
		}
	}
}
