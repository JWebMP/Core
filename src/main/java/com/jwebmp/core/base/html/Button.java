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
import com.jwebmp.core.base.html.interfaces.AttributeDefinitions;
import com.jwebmp.core.base.html.interfaces.GlobalChildren;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.children.BodyChildren;
import com.jwebmp.core.base.html.interfaces.children.FormChildren;
import com.jwebmp.core.base.html.interfaces.children.ListItemChildren;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage &gt;p&lt;
 * <p>
 * The &gt;button&lt; tag defines a clickable button. &gt;p&lt;
 * <p>
 * Inside a &gt;button&lt; element you can put content, like text or images.<p>
 * This is the difference between this element and buttons created with the &gt;input&lt; element. &gt;p&lt;
 * <p>
 * Tip: Always specify the type attribute for a &gt;button&lt; element.<p>
 * Different browsers use different default types for the &gt;button&lt; element. Browser Support
 * <p>
 * Element &gt;button&lt; Yes Yes Yes Yes Yes &gt;p&lt;
 * <p>
 * Tips and Notes &gt;p&lt;
 * <p>
 * Note: If you use the &gt;button&lt; element in an HTML form, different browsers may submit different values.
 * <p>
 * Use &gt;input&lt; to create buttons in an HTML form.<p>
 * Differences Between HTML 4.01 and HTML5 &gt;p&lt; HTML5 has the following new attributes: autofocus, form, formaction, formenctype,
 * formmethod, formnovalidate, and formtarget. &gt;p&lt;
 * <p>
 *
 * @param <C>
 * @param <J>
 * @param <A>
 * @param <F>
 * @param <E>
 * @author GedMarc
 * @since 2014/12/20
 */
public class Button<C extends GlobalChildren,
		A extends Enum<?> & AttributeDefinitions,
		F extends GlobalFeatures,
		E extends GlobalEvents,
		J extends Button<C, A, F, E, J>>
		extends Component<C, A, F, E, J>
		implements ListItemChildren, FormChildren, BodyChildren
{
	/**
	 * Constructs a new button object with no text
	 */
	public Button()
	{
		this("");
	}
	
	/**
	 * Constructs a new button object with the given text
	 * <p>
	 *
	 * @param text The text to show on the button
	 */
	public Button(String text)
	{
		super(ComponentTypes.Button);
		addAttribute("type", "button");
		setText(text);
	}
}
