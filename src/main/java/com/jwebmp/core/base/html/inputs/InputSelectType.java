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
package com.jwebmp.core.base.html.inputs;

import com.jwebmp.core.base.html.Input;
import com.jwebmp.core.base.html.Option;
import com.jwebmp.core.base.html.attributes.InputButtonTypeAttributes;
import com.jwebmp.core.base.html.attributes.InputTypes;

import javax.validation.constraints.NotNull;

/**
 * @param <J>
 *
 * @author GedMarc
 */
public class InputSelectType<J extends InputSelectType<J>>
		extends Input<InputButtonTypeAttributes, J>
{

	private static final long serialVersionUID = 1L;

	private boolean multiple;

	/**
	 * Constructs a new instance of a button type
	 */
	public InputSelectType()
	{
		this(null);
	}

	/**
	 * Constructs a new button with the given text
	 *
	 * @param text
	 */
	public InputSelectType(String text)
	{
		super(InputTypes.Select);
		setTag("select");
		setText(text);
		removeAttribute("type");
		setInlineClosingTag(false);
		setClosingTag(true);

	}

	/**
	 * Adds a select option
	 *
	 * @param label
	 * @param value
	 *
	 * @return
	 */
	@NotNull
	public Option<?> addOption(String label, String value)
	{
		Option<?> option = new Option<>(value);
		option.setLabel(label);
		add(option);
		return option;
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

	/**
	 * If the select input type is rendering as multiple
	 *
	 * @return
	 */
	public boolean isMultiple()
	{
		return multiple;
	}

	/**
	 * Sets if this select widget renders as multiple
	 *
	 * @param multiple
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setMultiple(boolean multiple)
	{
		this.multiple = multiple;
		if (multiple)
		{
			addAttribute("multiple", "");
		}
		return (J) this;
	}
}
