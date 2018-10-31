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
import com.jwebmp.core.base.html.interfaces.NoNewLineForRawText;
import com.jwebmp.core.base.html.interfaces.children.ListChildren;
import com.jwebmp.core.base.html.interfaces.children.ListItemChildren;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * The &lt;li&gt; tag defines a list item.<p>
 * <p>
 * The &lt;li&gt; tag is used in ordered lists(&lt;ol&gt;), unordered lists (&lt;ul&gt;), and in menu lists (&lt;menu&gt;)
 * .<p>
 * Browser Support<p>
 * Element
 * <p>
 * &lt;li&gt; Yes Yes Yes Yes Yes<p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * The "type" attribute is NOT supported in HTML5.<p>
 * s
 * <p>
 * The "value" attribute was deprecated in HTML 4.01, but IS supported in HTML5.<p>
 * Tips and Notes<p>
 * <p>
 * Tip: Use CSS to define the type of list.<p>
 *
 * @param <J>
 *
 * @author Marc Magon
 * @version 1.0
 * @since forever
 */
public class ListItem<J extends ListItem<J>>
		extends Component<ListItemChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
		implements ListChildren<ListItemChildren, J>, NoNewLineForRawText, ListItemChildren<ListItemChildren, J>
{


	/**
	 * Constructs a blank text List Item
	 */
	public ListItem()
	{
		this("");

	}

	/**
	 * Constructs a list item with the given text
	 *
	 * @param text
	 */
	public ListItem(String text)
	{
		super(ComponentTypes.ListItem);
		setText(text);
	}

	/**
	 * Returns a list item of the specified text
	 *
	 * @param textToAdd
	 *
	 * @return
	 */
	public ListItemChildren addItem(String textToAdd)
	{
		ListItem li = new ListItem(textToAdd);
		add(li);
		return li;
	}

	/**
	 * Returns a list of the specified text
	 *
	 * @param textToAdd
	 *
	 * @return
	 */
	public List addList(String textToAdd)
	{
		ListItem<?> lit = new ListItem<>(textToAdd);
		List<?, ?, ?, ?> li = new List<>(false);
		lit.add(li);
		super.add(li);
		return li;
	}
}
