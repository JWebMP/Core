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
package com.jwebmp.core.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.guicedee.services.jsonrepresentation.json.StaticStrings;
import com.guicedee.services.jsonrepresentation.json.StringToBoolean;
import com.guicedee.services.jsonrepresentation.json.StringToIntegerRelaxed;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.interfaces.IComponentHTMLOptionsBase;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;
import jakarta.validation.constraints.NotNull;
import lombok.extern.java.Log;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Denotes a component that has a tag. By default these can add events, features, variables etc
 *
 * @param <F> The allowed feature JavaScripts
 * @param <E> The allowed associated Events
 * @param <J> Component output for cloning. Returned on CloneComponent
 * @author GedMarc
 * @since 23 Apr 2016
 */
@Log
public class ComponentHTMLOptionsBase<
		F extends GlobalFeatures,
		E extends GlobalEvents,
		J extends ComponentHTMLOptionsBase<F, E, J>>
		extends ComponentHTMLBase<F, E, J>
		implements IComponentHTMLOptionsBase<J>
{

	/**
	 * The current stored option lists
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Map<String, String> options;
	
	/**
	 * Construct a new component that will render a tag
	 *
	 * @param componentType
	 */
	public ComponentHTMLOptionsBase(ComponentTypes componentType)
	{
		super(componentType);
	}
	
	@Override
	protected StringBuilder renderAttributes(StringBuilder sb)
	{
		return new StringBuilder();
	}
	
	/**
	 * Returns an Option Base interface of this component
	 *
	 * @return A cleaner version
	 */
	@NotNull
	public IComponentHTMLOptionsBase<?> asOptionBase()
	{
		return this;
	}
	
	/**
	 * Renders all the Option HTML. The All Custom options can contain any value=parameter pair
	 * <p>
	 *
	 * @return The option HTML
	 */
	@NotNull
	protected StringBuilder renderOptions(@NotNull StringBuilder sb)
	{
		if (!getOption().isEmpty())
		{
			sb.append(StaticStrings.STRING_SPACE);
		}
		for (Entry<String, String> entry : getOption().entrySet())
		{
			String key = entry.getKey();
			String value = entry.getValue();
			if (value == null)
			{
				continue;
			}
			sb.append(key)
			  .append(StaticStrings.STRING_DOUBLE_COLON)
			  .append(value)
			  .append(StaticStrings.STRING_SPACE);
		}
		return sb;
	}
	
	/**
	 * Renders the classes array as an in-line class string
	 *
	 * @return An empty string builder
	 */
	protected StringBuilder renderClasses()
	{
		return new StringBuilder();
	}
	
	/**
	 * Returns the current raw option map
	 *
	 * @return A Tree Map of Options
	 */
	@NotNull
	public Map<String, String> getOption()
	{
		if (options == null)
		{
			options = new TreeMap<>();
		}
		return options;
	}
	
	/**
	 * @param optionValue The decoded value to Return
	 *                    <p>
	 * @return
	 */
	@Override
	public String getOption(String optionValue)
	{
		String s = getOption().get(optionValue);
		if (s == null)
		{
			s = StaticStrings.STRING_EMPTY;
		}
		return s;
	}
	
	/**
	 * @param optionValue The decoded value to Return
	 * @param uselessInt  A useless parameter purely to return the type integer
	 *                    <p>
	 * @return
	 */
	@Override
	public Integer getOption(String optionValue, Integer uselessInt)
	{
		String s = getOption().get(optionValue);
		if (s == null)
		{
			s = StaticStrings.STRING_EMPTY;
		}
		return new StringToIntegerRelaxed().convert(s);
	}
	
	/**
	 * @param optionValue The decoded value to Return
	 * @param uselessInt  A useless parameter purely to return the type Boolean
	 *                    <p>
	 * @return
	 */
	@Override
	public Boolean getOption(String optionValue, Boolean uselessInt)
	{
		String s = getOption().get(optionValue);
		if (s == null)
		{
			s = StaticStrings.STRING_EMPTY;
		}
		return new StringToBoolean().convert(s);
	}
	
	/**
	 * Removes an option
	 *
	 * @param key the key to remove
	 * @return this object
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J removeOption(String key)
	{
		getOption().remove(key);
		return (J) this;
	}
	
	@Override
	public void destroy()
	{
		if (options != null)
		{
			options.clear();
			options = null;
		}
		super.destroy();
	}
	
	@Override
	public J addOption(String attribute, String value)
	{
		getOption().put(attribute, value);
		return (J) this;
	}
	
	public J addOption(String attribute, Object value)
	{
		getOption().put(attribute, value.toString());
		return (J) this;
	}
	
	/**
	 * Method cloneComponent ...
	 *
	 * @return J
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J cloneComponent()
	{
		ComponentHTMLOptionsBase<?, ?, ?> cloned = super.cloneComponent();
		cloned.options = new TreeMap<>();
		cloned.options.putAll(getOption());
		//noinspection CastCanBeRemovedNarrowingVariableType
		return (J) cloned;
	}
}
