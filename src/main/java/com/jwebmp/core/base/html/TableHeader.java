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
import com.jwebmp.core.base.html.interfaces.GlobalChildren;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.NoNewLineBeforeClosingTag;
import com.jwebmp.core.base.html.interfaces.NoNewLineForRawText;
import com.jwebmp.core.base.html.interfaces.children.TableChildren;
import com.jwebmp.core.base.html.interfaces.children.TableRowChildren;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;

/**
 * Browser Support
 * <p>
 * <p>
 * Internet Explorer Firefox Opera Google Chrome Safari<p>
 * <p>
 * The th tag is supported in all major browsers.
 * <p>
 * <p>
 * Definition and Usage<p>
 * <p>
 * The th tag defines a header cell in an HTML table.<p>
 * <p>
 * An HTML table has two kinds of cells:
 * <p>
 * <p>
 * Header cells - contains header information (created with the th element) Standard cells - contains data (created with the td element)
 * <p>
 * <p>
 * The text in th elements are bold and centered by default.<p>
 * <p>
 * The text in td elements are regular and left-aligned by default.
 * <p>
 * Tips and Notes<p>
 * <p>
 * Tip: Use the colspan and rowspan attribute to let the content span over multiple columns or rows! Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * Some HTML 4.01 attributes are not supported in HTML5.<p>
 *
 * @param <J>
 *
 * @author MMagon
 * @version 1.0
 * @since Forever
 */
public class TableHeader<J extends TableHeader<J>>
		extends Component<GlobalChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
		implements TableChildren, TableRowChildren, NoNewLineBeforeClosingTag, NoNewLineForRawText
{


	/**
	 * Constructs an empty Table Header
	 */
	public TableHeader()
	{
		this(null);
	}

	/**
	 * Constructs a new header with the given text
	 *
	 * @param headerText
	 */
	public TableHeader(String headerText)
	{
		super(ComponentTypes.TableHeader);
		setText(headerText);
	}
}
