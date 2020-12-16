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

import com.jwebmp.core.base.html.attributes.GlobalAttributes;
import com.jwebmp.core.base.html.interfaces.AttributeDefinitions;

/**
 * @param <A>
 * @param <J>
 *
 * @author GedMarc
 * @since Sep 26, 2016
 */
public interface IComponentHTMLAttributeBase<A extends Enum<?> & AttributeDefinitions, J extends IComponentHTMLAttributeBase<A,J>>
{
	/**
	 * Adds an attribute value to the attribute collection, and marks it with a GlobalAttribute Enumeration.
	 * <p>
	 *
	 * @param attribute
	 * 		The GlobalAttribute to set the attribute to
	 * @param value
	 * 		The value of the attribute
	 *
	 * @return
	 */
	J addAttribute(GlobalAttributes attribute, String value);

	/**
	 * Adds an attribute value to the attribute collection, and marks it with a GlobalAttribute Enumeration.
	 * <p>
	 *
	 * @param attribute
	 * 		The GlobalAttribute to set the attribute to
	 * @param value
	 * 		The value of the attribute
	 *
	 * @return
	 */
	J addAttribute(A attribute, String value);

	/**
	 * Adds an attribute value to the attribute collection, and marks it with a GlobalAttribute Enumeration.
	 * <p>
	 *
	 * @param attribute
	 * 		The GlobalAttribute to set the attribute to
	 * @param value
	 * 		The value of the attribute
	 *
	 * @return
	 */
	J addAttribute(String attribute, String value);

	/**
	 * Adds an attribute value to the attribute collection, and marks it with a GlobalAttribute Enumeration.
	 * <p>
	 *
	 * @param attribute
	 * 		The GlobalAttribute to set the attribute to
	 * @param value
	 * 		The value of the attribute
	 *
	 * @return
	 */
	J addAttribute(A attribute, Integer value);

	/**
	 * Adds an attribute value to the attribute collection, and marks it with a GlobalAttribute Enumeration.
	 * <p>
	 *
	 * @param attribute
	 * 		The valid Local Attribute to add
	 * @param value
	 * 		The value of the attribute
	 *
	 * @return
	 */
	J addAttribute(A attribute, Boolean value);
	
	/**
	 * This component cloned
	 * @return
	 */
	J cloneComponent();

	/**
	 * Returns an enumerated HashMap for ease of access
	 * <p>
	 *
	 * @param attribute
	 * 		The Global Attribute to apply
	 * @param bop
	 * 		Place Holder for return type boolean
	 * 		<p>
	 *
	 * @return HashMap of Attributes with GlobalAttributes Enumeration as Identifier
	 */
	Boolean getAttribute(GlobalAttributes attribute, Boolean bop);

	/**
	 * Returns an enumerated HashMap for ease of access
	 * <p>
	 *
	 * @param attribute
	 * 		The Global Attribute to apply
	 * @param bop
	 * 		Place Holder for return type integer
	 * 		<p>
	 *
	 * @return HashMap of Attributes with GlobalAttributes Enumeration as Identifier
	 */
	Integer getAttribute(GlobalAttributes attribute, Integer bop);

	/**
	 * Returns an enumerated HashMap for ease of access
	 * <p>
	 *
	 * @param attribute
	 * 		The Global Attribute to apply
	 * 		<p>
	 *
	 * @return HashMap of Attributes with GlobalAttributes Enumeration as Identifier
	 */
	String getAttribute(GlobalAttributes attribute);

	/**
	 * Gets this list of local attribute values
	 * <p>
	 *
	 * @param attributeValue
	 * 		The Valid Local Attribute to Return
	 * 		<p>
	 *
	 * @return A String of the attribute value currently set
	 */
	String getAttribute(A attributeValue);


	/**
	 * Gets this list of decoded attribute values
	 * <p>
	 *
	 * @param attributeValue
	 * 		The Valid Local Attribute to Return
	 * 		<p>
	 *
	 * @return A String of the attribute value currently set
	 */
	String getAttribute(String attributeValue);

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
	Integer getAttribute(String attributeValue, Integer uselessInt);

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
	Boolean getAttribute(String attributeValue, Boolean uselessInt);

	/**
	 * Gets this list of local attribute values
	 * <p>
	 *
	 * @param attributeValue
	 * 		The Valid Local Attribute to Return
	 * @param uselessInt
	 * 		A useless parameter purely to return the type integer
	 * 		<p>
	 *
	 * @return A HashMap if this components local attributes. Never null
	 */
	Integer getAttribute(A attributeValue, Integer uselessInt);

	/**
	 * Gets this list of local attribute values
	 * <p>
	 *
	 * @param attributeValue
	 * 		The Valid Local Attribute to Return
	 * @param uselessInt
	 * 		A useless parameter purely to return the type Boolean
	 * 		<p>
	 *
	 * @return A HashMap if this components local attributes. Never null
	 */
	Boolean getAttribute(A attributeValue, Boolean uselessInt);
	
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
	
	/**
	 * Shortcut to adding a style attribute
	 *
	 * @param property the style string to add
	 * @return This object
	 */
	J addStyle(String property, String value);
	
	/**
	 * Shortcut to adding a style attribute
	 *
	 * @param style the style string to add
	 * @return This object
	 */
	J addStyle(String style);
}
