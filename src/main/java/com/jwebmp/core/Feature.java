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

import com.jwebmp.core.base.ComponentFeatureBase;
import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

import javax.validation.constraints.NotNull;
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
@SuppressWarnings("MissingClassJavaDoc")
public abstract class Feature<F extends GlobalFeatures, O extends JavaScriptPart, J extends Feature<F, O, J>>
		extends ComponentFeatureBase<F, J>
		implements GlobalFeatures<F, J>
{

	/**
	 * Field serialVersionUID
	 */


	/**
	 * The options object associated with this feature
	 */
	private O options;

	/**
	 * Constructs a feature that can be used with all components
	 *
	 * @param name
	 * 		The unique name of the feature
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
	 * 		The unique name and component for the feature
	 * @param component
	 * 		The given component
	 */
	public Feature(String name, ComponentHierarchyBase component)
	{
		super(ComponentTypes.Feature);
		setName(name);
		super.setComponent(component);
		if (component != null)
		{
			component.addFeature(this);
		}
	}

	/**
	 * Adds a query to builder
	 *
	 * @param query
	 * 		Adds a query as a string builder
	 *
	 * @return Always this class
	 */
	public J addQuery(String query)
	{
		StringBuilder sb = new StringBuilder(query);
		return super.addQuery(sb);
	}

	/**
	 * Method hashCode ...
	 *
	 * @return int
	 */
	@Override
	public int hashCode()
	{
		return getName().hashCode();
	}

	/**
	 * Method equals ...
	 *
	 * @param obj
	 * 		of type Object
	 *
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null || getClass() != obj.getClass())
		{
			return false;
		}
		if (!super.equals(obj))
		{
			return false;
		}
		Feature<?, ?, ?> feature = (Feature<?, ?, ?>) obj;
		return Objects.equals(getName(), feature.getName());
	}

	/**
	 * Returns any client side options available with this component
	 *
	 * @return The options object that is nullable
	 *
	 * @see com.jwebmp.core.base.ComponentFeatureBase#getOptions()
	 */
	@Override
	public O getOptions()
	{
		return options;
	}

	/**
	 * Use Add Query to add a query to the container
	 */
	@Override
	protected abstract void assignFunctionsToComponent();

	/**
	 * Returns any hierarchal assigned component
	 *
	 * @param component
	 * 		The component to use
	 *
	 * @return This component
	 *
	 * @see com.jwebmp.core.base.ComponentFeatureBase#setComponent(ComponentHierarchyBase)
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	@Override
	public J setComponent(ComponentHierarchyBase component)
	{
		if (getComponent() != null)
		{
			getComponent().removeFeature((F) this);
		}
		if (component != null)
		{
			component.addFeature(this);
		}
		return super.setComponent(component);
	}

	/**
	 * Sets the options object
	 *
	 * @param options
	 * 		The options object
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setOptions(O options)
	{
		this.options = options;
		return (J) this;
	}

}
