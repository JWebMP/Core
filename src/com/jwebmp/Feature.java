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
package com.jwebmp;

import com.jwebmp.base.ComponentFeatureBase;
import com.jwebmp.base.ComponentHierarchyBase;
import com.jwebmp.base.html.interfaces.GlobalFeatures;
import com.jwebmp.base.html.interfaces.NoFeatures;
import com.jwebmp.base.servlets.enumarations.ComponentTypes;
import com.jwebmp.htmlbuilder.javascript.JavaScriptPart;

import java.util.Objects;

/**
 * Container Class for Features. Splits from the hierarchy
 *
 * @param <O>
 * 		Any options associated with this feature
 * @param <J>
 * 		This Class
 *
 * @author GedMarc
 * @since 23 Apr 2016
 */
public abstract class Feature<O extends JavaScriptPart, J extends Feature<O, J>>
		extends ComponentFeatureBase<NoFeatures, J>
		implements GlobalFeatures
{

	private static final long serialVersionUID = 1L;

	/**
	 * The options object associated with this feature
	 */
	private O options;

	/**
	 * Constructs a feature that can be used with all components
	 *
	 * @param name
	 */
	public Feature(String name)
	{
		super(ComponentTypes.Feature);
		setName(name);
	}

	/**
	 * Constructs a feature that can be used with all components
	 *
	 * @param name
	 * @param component
	 */
	public Feature(String name, ComponentHierarchyBase component)
	{
		super(ComponentTypes.Feature);
		setName(name);
		setComponent(component);
		component.addFeature(this);
	}

	/**
	 * Adds a query to builder
	 *
	 * @param query
	 *
	 * @return
	 */
	public J addQuery(String query)
	{
		StringBuilder sb = new StringBuilder(query);
		return super.addQuery(sb);
	}

	@Override
	public int hashCode()
	{
		return getName().hashCode();
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
		Feature<?, ?> feature = (Feature<?, ?>) o;
		return Objects.equals(getName(), feature.getName());
	}

	/**
	 * Returns any client side options available with this component
	 *
	 * @return
	 */
	@Override
	public O getOptions()
	{
		return options;
	}

	/**
	 * Sets the options object
	 *
	 * @param options
	 */
	public void setOptions(O options)
	{
		this.options = options;
	}

	/**
	 * Any work that needs to get done pre render
	 */
	@Override
	protected abstract void assignFunctionsToComponent();
}
