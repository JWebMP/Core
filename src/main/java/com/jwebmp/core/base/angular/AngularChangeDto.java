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

package com.jwebmp.core.base.angular;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.guicedinjection.GuiceContext;
import com.jwebmp.logger.LogFactory;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The angular change dto to apply
 *
 * @param <J>
 */
public class AngularChangeDto<J extends AngularChangeDto<J>>
		extends JavaScriptPart<J>
{


	private static Logger log = LogFactory.getLog("AngularChangeDto");
	@JsonProperty("old")
	private String oldProperty;
	@JsonProperty("new")
	private String newValue;

	/**
	 * Constructs a new angular change dto
	 */
	public AngularChangeDto()
	{
		//No config needed
	}

	/**
	 * The old and new property
	 *
	 * @param oldProperty
	 * @param newValue
	 */
	public AngularChangeDto(String oldProperty, String newValue)
	{
		this.oldProperty = oldProperty;
		this.newValue = newValue;
	}

	/**
	 * Returns the old value
	 *
	 * @return
	 */
	public String getOldProperty()
	{
		return oldProperty;
	}

	/**
	 * Sets the new value
	 *
	 * @param oldProperty
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J setOldProperty(String oldProperty)
	{
		this.oldProperty = oldProperty;
		return (J) this;
	}

	/**
	 * Returns the new value
	 *
	 * @return
	 */
	public String getNewValue()
	{
		return newValue;
	}

	/**
	 * Returns the new value
	 *
	 * @param newValue
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J setNewValue(String newValue)
	{
		this.newValue = newValue;
		return (J) this;
	}

	/**
	 * Returns the new value as the given object type
	 *
	 * @param type
	 * @param <T>
	 *
	 * @return
	 */
	public <T> Optional<T> asType(Class<T> type)
	{
		try
		{
			return Optional.ofNullable(GuiceContext.getInstance(ObjectMapper.class)
			                                       .readValue(newValue.getBytes(), type));
		}
		catch (IOException e)
		{
			log.log(Level.SEVERE, "Unable to get angular change dto from value", e);
		}
		return Optional.empty();
	}
}
