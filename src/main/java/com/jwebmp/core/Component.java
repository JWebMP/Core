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
package com.jwebmp.core;

import com.jwebmp.core.base.ComponentStyleBase;
import com.jwebmp.core.base.html.Paragraph;
import com.jwebmp.core.base.html.Span;
import com.jwebmp.core.base.html.interfaces.AttributeDefinitions;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.interfaces.ICssStructure;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;

import javax.validation.constraints.NotNull;

/**
 * The base class for all HTML generation, Everything must extend a component
 * <p>
 *
 * @param <C>
 * 		The allowed children for a component
 * @param <A>
 * 		The allowed local attributes (Separate from Global Attributes)
 * @param <F>
 * 		The allowed feature JavaScripts
 * @param <E>
 * 		The allowed associated Events
 * @param <J>
 * 		Component output for cloning. Returned on CloneComponent
 * 		<p>
 * 		<p>
 *
 * @author Marc Magon
 * @version 1.0
 * @since 2009/10/01
 */
@SuppressWarnings("MissingClassJavaDoc")
public class Component<C extends IComponentHierarchyBase, A extends Enum & AttributeDefinitions, F extends GlobalFeatures, E extends GlobalEvents, J extends Component<C, A, F, E, J>>
		extends ComponentStyleBase<C, A, F, E, J>
		implements ICssStructure<J>
{
	/**
	 * Don't setup anything constructor - dangerous
	 */
	public Component()
	{
		this("notspecified", ComponentTypes.Span);
	}

	/**
	 * Construct a new Component with a custom tag
	 * <p>
	 *
	 * @param tagName
	 * 		The tag to apply
	 * @param myComponent
	 * 		The HTML component rendering for
	 */
	public Component(String tagName, ComponentTypes myComponent)
	{
		this(tagName, myComponent, false);
	}

	/**
	 * Constructs a component with the tag name, it's associated base HTML component, and whether it closes in line or not
	 * <p>
	 *
	 * @param tagName
	 * 		The tag name to apply
	 * @param myComponent
	 * 		The component enumeration applied with this component
	 * @param inlineTagClose
	 * 		Whether or not to close the tag InLine or not
	 */
	public Component(String tagName, ComponentTypes myComponent, boolean inlineTagClose)
	{
		super(myComponent);
		setTag(tagName);
		setInlineClosingTag(inlineTagClose);
	}

	/**
	 * Construct a new Component with a custom tag
	 * <p>
	 *
	 * @param myComponent
	 * 		The HTML component rendering for
	 */
	public Component(ComponentTypes myComponent)
	{
		this(myComponent.getComponentTag(), myComponent, false);
	}

	/**
	 * Adds a paragraph component with the attached text
	 * <p>
	 *
	 * @param textToAdd
	 * 		The text to add
	 * 		<p>
	 *
	 * @return The new paragraph component
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J add(@NotNull String textToAdd)
	{
		Paragraph p = new Paragraph();
		p.setText(textToAdd);
		add((C) p);
		return (J) this;
	}

	@SuppressWarnings({"unused", "unchecked"})
	@NotNull
	public J add(String textToAdd, boolean inline)
	{
		Span p = new Span();
		p.setText(textToAdd);
		add((C) p);
		return (J) this;
	}

	/**
	 * Returns this component with all the shortcuts for CSS
	 *
	 * @return The CSS Set of a component
	 */
	@SuppressWarnings("unused")
	@NotNull
	public ICssStructure asCSS()
	{
		return ICssStructure.class.cast(this);
	}

}
