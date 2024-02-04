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
import com.jwebmp.core.base.html.attributes.GlobalAttributes;
import com.jwebmp.core.base.html.attributes.InputTypes;
import com.jwebmp.core.base.html.interfaces.AttributeDefinitions;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.children.FormChildren;
import com.jwebmp.core.base.html.interfaces.children.ListItemChildren;
import com.jwebmp.core.base.html.interfaces.children.generics.ParagraphChildren;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;
import com.guicedee.services.jsonrepresentation.json.StaticStrings;

import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * Please note I have left out all the input type attributes that are not cross-browser - rather use the features available.<p>
 * <p>
 * Browser Support<p>
 * <p>
 * Internet Explorer Firefox Opera Google Chrome Safari<p>
 * <p>
 * The input tag is supported in all major browsers. Definition and Usage<p>
 * <p>
 * <p>
 * The input tag specifies an input field where the user can enter data.<p>
 * <p>
 * <p>
 * input elements are used within a form element to declare input controls that allow users to input data.<p>
 * <p>
 * <p>
 * An input field can vary in many ways, depending on the type attribute. Tips and Notes<p>
 * <p>
 * <p>
 * Note: The input element is empty, it contains attributes only.<p>
 * <p>
 * <p>
 * Tip: Use the label element to define labels for input elements. Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * <p>
 * The "align" attribute is not supported in HTML5.<p>
 * <p>
 * <p>
 * In HTML5, the input tag has several new attributes, and the type attribute has several new values. Differences Between HTML and XHTML<p>
 * <p>
 * <p>
 * In HTML, the input tag has no end tag.<p>
 * <p>
 * <p>
 * In XHTML, the input tag must be properly closed.<p>
 * <p>
 *
 * @param <A>
 * 		The attribute set for the input component
 * @param <J>
 *
 * @author GedMarc
 */
public class Input<A extends Enum<?> & AttributeDefinitions, J extends Input<A, J>>
		extends Component<IComponentHierarchyBase<?,?>, A, GlobalFeatures, GlobalEvents, J>
		implements ParagraphChildren, FormChildren, ListItemChildren
{
	/**
	 * The input type of this input tag
	 */
	private InputTypes inputType;

	/**
	 * Constructs a blank instance of input - generally not recommended.
	 */
	public Input()
	{
		this(null);
	}

	/**
	 * Construct a new instance of the input type field
	 * <p>
	 *
	 * @param inputType
	 */
	public Input(InputTypes inputType)
	{
		super(ComponentTypes.Input);
		setRenderIDAttribute(true);
		if (inputType != null)
		{
			this.inputType = inputType;
			addAttribute(GlobalAttributes.Type, getInputType().name()
			                                                  .toLowerCase());
			addAttribute(GlobalAttributes.Name, getID());
		}
		if (!getInlineClosingTag() && getPage().getHtmlVersion()
		                                       .name()
		                                       .startsWith("X") || !"select".equals(getTag()))
		{
			setInlineClosingTag(true);

		}
		setClosingTag(false);
	}

	@Override
	public void preConfigure()
	{
		if(!isConfigured())
		{
			if(getText() != null && !getText().isEmpty())
			{
				setInlineClosingTag(false);
			}
		}
		super.preConfigure();
	}

	/**
	 * Returns the input type of the input field
	 * <p>
	 *
	 * @return
	 */
	public final InputTypes getInputType()
	{
		return inputType;
	}

	/**
	 * Sets the input type of this field
	 * <p>
	 *
	 * @param inputType
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public J setInputType(InputTypes inputType)
	{
		this.inputType = inputType;
		addAttribute(GlobalAttributes.Type, inputType.toString());
		return (J) this;
	}

	@Override
	@NotNull
	public J setID(String id)
	{
		setName(id);
		return super.setID(id);
	}
	
	@Override
	public J setName(String name)
	{
		addAttribute(GlobalAttributes.Name, name);
		addAttribute("#" + name,"ngModel");
		return super.setName(name);
	}
	
	@NotNull
	@Override
	public String getName()
	{
		return getAttribute(GlobalAttributes.Name);
	}

	/**
	 * Sets this input as required in the form
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public J setRequired()
	{
		addAttribute("required", StaticStrings.STRING_EMPTY);
		return (J) this;
	}

	/**
	 * Sets the minimum length of this input
	 *
	 * @param minLength
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public J setMinimumLength(int minLength)
	{
		addAttribute("data-minlength", Integer.toString(minLength));
		addAttribute("minlength", Integer.toString(minLength));
		return (J) this;
	}
	
	
	/**
	 * Sets the minimum length of this input
	 *
	 * @param minimum
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public J setMinimum(int minimum)
	{
		addAttribute("data-min", Integer.toString(minimum));
		addAttribute("min", Integer.toString(minimum));
		return (J) this;
	}
	
	/**
	 * Sets the minimum length of this input
	 *
	 * @param minimum
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public J setMinimum(double minimum)
	{
		addAttribute("data-min", Double.toString(minimum));
		addAttribute("min", Double.toString(minimum));
		return (J) this;
	}
	
	
	/**
	 * Sets the minimum length of this input
	 *
	 * @param minLength
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public J setMaximumLength(int minLength)
	{
		addAttribute("data-maxlength", Integer.toString(minLength));
		addAttribute("maxlength", Integer.toString(minLength));
		return (J) this;
	}
	
	
	/**
	 * Sets the minimum length of this input
	 *
	 * @param max
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public J setMaximum(int max)
	{
		addAttribute("data-max", Integer.toString(max));
		addAttribute("max", Integer.toString(max));
		return (J) this;
	}
	
	
	/**
	 * Sets the minimum length of this input
	 *
	 * @param max
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public J setMaximum(double max)
	{
		addAttribute("data-max", Double.toString(max));
		addAttribute("max", Double.toString(max));
		return (J) this;
	}
	
	/**
	 * Sets the place holder for this input
	 *
	 * @param placeholder
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public J setPlaceholder(String placeholder)
	{
		addAttribute("placeholder", placeholder);
		return (J) this;
	}

	/**
	 * Sets the value attribute
	 *
	 * @param value
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public J setValue(String value)
	{
		addAttribute("value", value);
		return (J) this;
	}

	public String getValue()
	{
		return getAttribute("value");
	}
	
	/**
	 * Sets the raw pattern for this input object if required
	 *
	 * @param pattern
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public J setPattern(String pattern, boolean raw)
	{
		if (raw)
		{
			addAttribute("pattern", pattern);
		}
		else
		{
			setPattern(pattern);
		}
		return (J) this;
	}

	/**
	 * Sets the pattern for this input object if required
	 *
	 * @param angularPatternName
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public J setPattern(String angularPatternName)
	{
		addAttribute("pattern", angularPatternName);
		return (J) this;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof Input))
		{
			return false;
		}
		if (!super.equals(o))
		{
			return false;
		}
		Input<?, ?> input = (Input<?, ?>) o;
		return getInputType() == input.getInputType();
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(super.hashCode(), getInputType());
	}
	
}
