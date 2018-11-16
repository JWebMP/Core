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
import com.jwebmp.core.base.html.interfaces.children.AddressChildren;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;

import java.io.Serializable;

/**
 * <p>
 * Definition and Usage<p>
 * <p>
 * The &gt;address&lt; tag defines the contact information for the author/owner of a document or an article.<p>
 * <p>
 * If the &gt;address&lt; element is inside the &gt;body&lt; element, it represents contact information for the document.<p>
 * <p>
 * If the &gt;address&lt; element is inside an &gt;article&lt; element, it represents contact information for that article.<p>
 * <p>
 * The text in the &gt;address&lt; element usually renders in italic. Most browsers will add a line break before and after the address element.<p>
 * Browser Support Element &gt;address&lt; Yes Yes Yes Yes<p>
 * Yes
 * <p>
 * Tips and Notes
 * <p>
 * Tip: The &gt;address&lt; tag should NOT be used to describe a postal address, unless it is a part of the contact information.
 * <p>
 * Tip: The &gt;address&lt; element will typically be included along with other information in a &gt;footer&lt; element. Differences Between HTML 4.01 and HTML5
 * <p>
 * HTML 4.01 does not support the &gt;article&lt; tag, so in HTML 4.01 the &gt;address&lt; tag always defines the contact information of the document's author/owner. Global
 * Attributes
 * <p>
 * The &gt;address&lt; tag also supports the Global Attributes in HTML. Event Attributes
 * <p>
 * The &gt;address&lt; tag also supports the Event Attributes in HTML.
 *
 * @param <J>
 *
 * @author MMagon
 */
public class Address<J extends Address<J>>
		extends Component<AddressChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
		implements NoNewLineBeforeClosingTag, NoNewLineForRawText, Serializable
{


	/**
	 * Constructs a new instance of address
	 */
	public Address()
	{
		this(null);
	}

	/**
	 * Constructs a new address, usually displayed in italic
	 *
	 * @param address
	 */
	public Address(String address)
	{
		super(ComponentTypes.Address.getComponentTag(), ComponentTypes.Address);
		setText(address);
	}

}
