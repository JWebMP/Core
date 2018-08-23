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
import com.jwebmp.core.base.html.attributes.FormAttributes;
import com.jwebmp.core.base.html.attributes.GlobalAttributes;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.children.ListItemChildren;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;
import com.jwebmp.core.utilities.StaticStrings;

import javax.validation.constraints.NotNull;

/**
 * Definition and Usage
 * <p>
 * The &lt;form&gt; tag is used to create an HTML form for user input.<p>
 * <p>
 * The &lt;form&gt; element can contain one or more of the following form elements:
 * <p>
 * <p>
 * &lt;input&gt;
 * <p>
 * &lt;textarea&gt;
 * <p>
 * &lt;button&gt;
 * <p>
 * &lt;select&gt;
 * <p>
 * &lt;option&gt;
 * <p>
 * &lt;optgroup&gt;
 * <p>
 * &lt;fieldset&gt;
 * <p>
 * &lt;label&gt;
 * <p>
 * <p>
 * Browser Support Element &lt;form&gt; Yes Yes Yes Yes Yes
 * <p>
 * Differences Between HTML 4.01 and HTML5
 * <p>
 * HTML5 has added two new attributes: autocomplete and novalidate, and removed the accept attribute. Differences Between HTML and XHTML<p>
 * <p>
 * In XHTML, the name attribute is deprecated. Use the global id attribute instead.<p>
 * <p>
 *
 * @param <J>
 *
 * @author Marc Magon
 * @since forever
 */
public class Form<J extends Form<J>>
		extends Component<IComponentHierarchyBase, FormAttributes, GlobalFeatures, GlobalEvents, J>
		implements ListItemChildren<IComponentHierarchyBase, J>
{

	private static final long serialVersionUID = 1L;
	/**
	 * The label of this form
	 */
	private Label label;

	/**
	 * Constructs a new form
	 */
	public Form()
	{
		super(ComponentTypes.Form);
	}

	@Override
	protected StringBuilder renderBeforeTag()
	{
		if (label != null)
		{
			StringBuilder sb = new StringBuilder();
			sb.append(super.renderBeforeTag());
			sb.append(label.toString(true));
			return sb;
		}
		else
		{
			return super.renderBeforeTag();
		}
	}

	/**
	 * Returns the label
	 *
	 * @return
	 */
	public Label getLabel()
	{
		return label;
	}

	/**
	 * Sets the label
	 *
	 * @param label
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setLabel(Label label)
	{
		this.label = label;
		return (J) this;
	}

	@SuppressWarnings("unchecked")
	@NotNull
	public J setNoValidate(boolean noValidate)
	{
		if (noValidate)
		{
			addAttribute(FormAttributes.NoValidate, StaticStrings.STRING_EMPTY);
		}
		else
		{
			removeAttribute(FormAttributes.NoValidate);
		}
		return (J) this;
	}

	@NotNull
	@Override
	public J setID(String id)
	{
		addAttribute("name", id);
		return super.setID(id);
	}

	@NotNull
	@Override
	public String getName()
	{
		return getAttribute(GlobalAttributes.Name);
	}

	@NotNull
	@Override
	public J setName(@NotNull String name)
	{
		addAttribute("name", name);
		return super.setName(name);
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	@Override
	public boolean equals(Object o)
	{
		return super.equals(o);
	}
}
