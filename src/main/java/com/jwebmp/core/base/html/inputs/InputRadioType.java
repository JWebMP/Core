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
package com.jwebmp.core.base.html.inputs;

import com.jwebmp.core.base.html.Input;
import com.jwebmp.core.base.html.attributes.InputRadioTypeAttributes;
import com.jwebmp.core.base.html.attributes.InputTypes;
import com.jwebmp.core.base.html.interfaces.InputChoiceType;

import javax.validation.constraints.NotNull;

/**
 * @param <J>
 *
 * @author GedMarc
 */
public class InputRadioType<J extends InputRadioType<J>>
		extends Input<InputRadioTypeAttributes, J>
		implements InputChoiceType<J>
{


	/**
	 * Constructs a new check box
	 */
	public InputRadioType()
	{
		super(InputTypes.Radio);
	}

	/**
	 * Sets the checkbox accordingly
	 *
	 * @param checked
	 *
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J setChecked(boolean checked)
	{
		if (checked)
		{
			addAttribute(InputRadioTypeAttributes.Checked, "");
		}
		else
		{
			removeAttribute(InputRadioTypeAttributes.Checked);
		}
		return (J) this;
	}

	@SuppressWarnings("unchecked")
	@NotNull
	public J setGroup(String groupName)
	{
		addAttribute("name", groupName);
		return (J) this;
	}

}
