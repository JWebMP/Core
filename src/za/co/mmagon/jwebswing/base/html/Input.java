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
package za.co.mmagon.jwebswing.base.html;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.angular.AngularAttributes;
import za.co.mmagon.jwebswing.base.angular.AngularPageConfigurator;
import za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes;
import za.co.mmagon.jwebswing.base.html.attributes.InputTypes;
import za.co.mmagon.jwebswing.base.html.interfaces.AttributeDefinitions;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.children.generics.ParagraphChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

import javax.validation.constraints.NotNull;

import static za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes.Name;
import static za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes.Type;
import static za.co.mmagon.jwebswing.utilities.StaticStrings.STRING_EMPTY;

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
 * @author Marc Magon
 */
public class Input<A extends Enum & AttributeDefinitions, J extends Input<A, J>>
		extends Component<GlobalChildren, A, GlobalFeatures, GlobalEvents, J>
		implements GlobalChildren, ParagraphChildren
{
	private static final long serialVersionUID = 1L;

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
		if (inputType != null)
		{
			this.inputType = inputType;
			addAttribute(Type, getInputType().name()
			                                 .toLowerCase());
			addAttribute(Name, getID());
		}
		if (!getInlineClosingTag() && getPage().getHtmlVersion()
		                                       .name()
		                                       .startsWith("X") || !getTag().equals("select"))
		{
			setInlineClosingTag(true);

		}
		setClosingTag(false);
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
		addAttribute(Type, inputType.toString());
		return (J) this;
	}

	/**
	 * Differences Between HTML and XHTML
	 * <p>
	 * In HTML the base tag has no end tag.
	 * <p>
	 * In XHTML the base tag must be properly closed.
	 */
	@Override
	public void preConfigure()
	{

		super.preConfigure();
	}

	@Override
	@NotNull
	public J setID(String id)
	{
		addAttribute(Name, id);
		return super.setID(id);
	}

	@Override
	public String getName()
	{
		return getAttribute(GlobalAttributes.Name);
	}

	/**
	 * Push to model instead of bind
	 *
	 * @param variableName
	 *
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public J bind(String variableName)
	{
		AngularPageConfigurator.setRequired(true);
		addAttribute(AngularAttributes.ngModel, variableName);
		return (J) this;
	}

	/**
	 * Sets this input as required in the form
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public J setRequired()
	{
		addAttribute("required", STRING_EMPTY);
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
		addAttribute(AngularAttributes.ngPattern, angularPatternName);
		return (J) this;
	}

	@Override
	public boolean equals(Object o)
	{
		return super.equals(o);
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}
}
