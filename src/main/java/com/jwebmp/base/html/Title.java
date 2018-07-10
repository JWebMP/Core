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
import com.jwebmp.base.html.attributes.NoAttributes;
import com.jwebmp.base.html.interfaces.*;
import com.jwebmp.base.html.interfaces.children.HeadChildren;
import com.jwebmp.base.html.interfaces.events.NoEvents;
import com.jwebmp.base.servlets.enumarations.ComponentTypes;

/**
 * The page title tag<p>
 * <p>
 * <p>
 * Browser Support<p>
 * <p>
 * Internet Explorer Firefox Opera Google Chrome Safari<p>
 * <p>
 * The title tag is supported in all major browsers. Definition and Usage<p>
 * <p>
 * The title tag is required in all HTML documents and it defines the title of<p>
 * the document.<p>
 * <p>
 * The title element:
 * <p>
 * <p>
 * defines a title in the browser toolbar provides a title for the page when it<p>
 * is added to favorites displays a title for the page in search-engine results<p>
 * <p>
 *
 * @param <J>
 *
 * @author MMagon
 * @version 1.0
 * @since 2013/11/12
 */
public class Title<J extends Title<J>>
		extends Component<GlobalChildren, NoAttributes, NoFeatures, NoEvents, J>
		implements NoIDTag, HeadChildren, OneValidTag, NoClassAttribute, NoNewLineForRawText, NoNewLineBeforeChildren, NoNewLineBeforeClosingTag
{

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a blank title
	 */
	public Title()
	{
		this(null);
	}

	/**
	 * Constructs a header title
	 *
	 * @param title
	 * 		The title of the page
	 */
	public Title(String title)
	{
		super("title", ComponentTypes.HeadTitle);
		setText(title);
	}

	/**
	 * Returns the current set title
	 *
	 * @return
	 */
	public String getTitle()
	{
		return getText(0).toString();
	}

	/**
	 * Sets the pages title.
	 *
	 * @param title
	 * 		The title of the page
	 */
	public void setTitle(String title)
	{
		setText(title);
	}
}
