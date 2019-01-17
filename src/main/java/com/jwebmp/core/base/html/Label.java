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
import com.jwebmp.core.base.html.attributes.LabelAttributes;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.NoNewLineBeforeChildren;
import com.jwebmp.core.base.html.interfaces.NoNewLineBeforeClosingTag;
import com.jwebmp.core.base.html.interfaces.NoNewLineForRawText;
import com.jwebmp.core.base.html.interfaces.children.generics.ParagraphChildren;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * The &gt;label&lt; tag defines a label for an &gt;input&lt; element.<p>
 * <p>
 * The &gt;label&lt; element does not render as anything special for the user. However, it provides a usability improvement for mouse users, because if the user clicks on the text
 * within the
 * &gt;label&lt;
 * <p>
 * element, it toggles the control.<p>
 * <p>
 * The for attribute of the &gt;label&lt; tag should be equal to the id attribute of the related element to bind them together. Browser Support Element<p>
 * &gt;label&lt; Yes Yes Yes Yes Yes Tips and Notes<p>
 * <p>
 * Tip: A label can be bound to an element either by using the "for" attribute, or by placing the element inside the &gt;label&lt; element. Differences Between HTML 4.01 and
 * HTML5<p>
 * <p>
 * The "form" attribute is new in HTML5.<p>
 * <p>
 *
 * @param <J>
 *
 * @author GedMarc
 * @version 1.0
 * 		<p>
 * @since Feb 9, 2015
 */
public class Label<J extends Label<J>>
		extends Component<IComponentHierarchyBase, LabelAttributes, GlobalFeatures, GlobalEvents, J>
		implements ParagraphChildren<IComponentHierarchyBase, J>, NoNewLineBeforeChildren, NoNewLineForRawText, NoNewLineBeforeClosingTag
{


	/**
	 * The component this is for
	 */
	private Component forInputComponent;
	/**
	 * The form this label is for
	 */
	private Form forFormComponent;

	/**
	 * Constructs a new label
	 */
	public Label()
	{
		this(null);
	}

	/**
	 * Constructs a new label with the attribute set
	 * <p>
	 *
	 * @param label
	 */
	@SuppressWarnings("")
	public Label(String label)
	{
		super(ComponentTypes.Label);
		setLabel(label);
	}

	/**
	 * Constructs a new label with the attribute set and the component specified
	 * <p>
	 *
	 * @param label
	 * @param forInputComponent
	 */
	@SuppressWarnings("")
	public Label(String label, Input forInputComponent)
	{
		super(ComponentTypes.Label);
		setForInputComponent(forInputComponent);
		setLabel(label);
		addAttribute(LabelAttributes.For, label);
	}

	/**
	 * Gets the text of this label
	 * <p>
	 *
	 * @return
	 */
	public String getLabel()
	{
		return getText(0).toString();
	}

	/**
	 * Sets the text of this label
	 * <p>
	 *
	 * @param label
	 */
	public void setLabel(String label)
	{
		setText(label);
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}
		if (!super.equals(o))
		{
			return false;
		}

		Label<?> label = (Label<?>) o;

		if (getForInputComponent() != null ? !getForInputComponent().equals(label.getForInputComponent()) : label.getForInputComponent() != null)
		{
			return false;
		}
		return getForFormComponent() != null ? getForFormComponent().equals(label.getForFormComponent()) : label.getForFormComponent() == null;
	}

	/**
	 * Returns the input type for which this is the component for
	 * <p>
	 *
	 * @return
	 */
	public Component getForInputComponent()
	{
		return forInputComponent;
	}

	/**
	 * Sets the for component with the given ID
	 * <p>
	 *
	 * @param forInputComponent
	 */
	public void setForInputComponent(Component forInputComponent)
	{
		this.forInputComponent = forInputComponent;
		if (forInputComponent != null)
		{
			addAttribute(LabelAttributes.For, forInputComponent.getID());
		}
	}

	/**
	 * Returns the form component that the label is attached to
	 * <p>
	 *
	 * @return
	 */
	public Form getForFormComponent()
	{
		return forFormComponent;
	}

	/**
	 * Sets the form for which the label is for
	 * <p>
	 *
	 * @param forFormComponent
	 */
	public void setForFormComponent(Form forFormComponent)
	{
		this.forFormComponent = forFormComponent;
		if (forFormComponent != null)
		{
			addAttribute(LabelAttributes.Form, forInputComponent.getID());
		}
	}
}
