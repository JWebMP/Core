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
package com.jwebmp.core.base.interfaces;

/**
 * A set of CSS attributes that the Component class exposes.
 *
 * @param <J>
 * 		My type
 *
 * @author GedMarc
 * @since Sep 26, 2016
 */
@FunctionalInterface
public interface ICssStructure<J>
{

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
	J add(String textToAdd);
	
	/**
	 * This class with the associated exposed methods
	 *
	 * @return This component type-casted
	 */
	default IComponentStyleBase<?> asStyleBase()
	{
		return (IComponentStyleBase<?>) this;
	}
	
	/**
	 * This class with the associated exposed methods
	 *
	 * @return This component type-casted
	 */
	default IComponentHierarchyBase<?, ?> asHierarchyBase()
	{
		return (IComponentHierarchyBase<?, ?>) this;
	}
	
	
	/**
	 * This class with the associated exposed methods
	 *
	 * @return This component type-casted
	 */
	default IComponentHTMLAttributeBase<?, ?> asAttributeBase()
	{
		return (IComponentHTMLAttributeBase<?, ?>) this;
	}
	
	/**
	 * This class with the associated exposed methods
	 *
	 * @return This component type-casted
	 */
	default IComponentHTMLBase<?> asTagBase()
	{
		return (IComponentHTMLBase<?>) this;
	}
	
	/**
	 * This class with the associated exposed methods
	 *
	 * @return This component type-casted
	 */
	default IComponentEventBase<?, ?> asEventBase()
	{
		return (IComponentEventBase<?, ?>) this;
	}
	
	/**
	 * This class with the associated exposed methods
	 *
	 * @return This component type-casted
	 */
	default IComponentFeatureBase<?, ?> asFeatureBase()
	{
		return (IComponentFeatureBase<?, ?>) this;
	}
	
	/**
	 * This class with the associated exposed methods
	 *
	 * @return This component type-casted
	 */
	default IComponentThemeBase<?> asThemeBase()
	{
		return (IComponentThemeBase<?>) this;
	}
	
	/**
	 * Returns the components exposed dependency methods
	 *
	 * @return This component type-casted
	 */
	default IComponentDependencyBase<?> asDependencyBase()
	{
		return (IComponentDependencyBase<?>) this;
	}
	
	/**
	 * Returns the base exposed methods
	 *
	 * @return This component type-casted
	 */
	default IComponentBase<?> asBase()
	{
		return (IComponentBase<?>) this;
	}
}
