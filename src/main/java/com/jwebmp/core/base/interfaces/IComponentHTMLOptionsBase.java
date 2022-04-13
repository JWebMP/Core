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
 * @param <J>
 *
 * @author GedMarc
 * @since Sep 26, 2016
 */
public interface IComponentHTMLOptionsBase<J extends IComponentHTMLOptionsBase<J>>
{
	/**
	 * Adds an attribute value to the attribute collection, and marks it with a GlobalOption Enumeration.
	 * <p>
	 *
	 * @param attribute
	 * 		The GlobalOption to set the attribute to
	 * @param value
	 * 		The value of the attribute
	 *
	 * @return
	 */
	J addOption(String attribute, String value);

	/**
	 * This component cloned
	 * @return
	 */
	J cloneComponent();

	/**
	 * Gets this list of decoded attribute values
	 * <p>
	 *
	 * @param attributeValue
	 * 		The Valid Local Option to Return
	 * 		<p>
	 *
	 * @return A String of the attribute value currently set
	 */
	String getOption(String attributeValue);

	/**
	 * Gets this list of decoded attribute values
	 * <p>
	 *
	 * @param attributeValue
	 * 		The decoded value to Return
	 * @param uselessInt
	 * 		A useless parameter purely to return the type integer
	 * 		<p>
	 *
	 * @return A HashMap if this components local attributes. Never null
	 */
	Integer getOption(String attributeValue, Integer uselessInt);

	/**
	 * Gets this list of decoded attribute values
	 * <p>
	 *
	 * @param attributeValue
	 * 		The decoded value to Return
	 * @param uselessInt
	 * 		A useless parameter purely to return the type Boolean
	 * 		<p>
	 *
	 * @return A HashMap if this components local attributes. Never null
	 */
	Boolean getOption(String attributeValue, Boolean uselessInt);

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
