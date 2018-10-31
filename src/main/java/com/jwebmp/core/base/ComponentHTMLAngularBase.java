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
package com.jwebmp.core.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.base.angular.AngularAttributes;
import com.jwebmp.core.base.angular.AngularPageConfigurator;
import com.jwebmp.core.base.html.interfaces.AttributeDefinitions;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.interfaces.IComponentHTMLAngularBase;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.core.utilities.StaticStrings;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

/**
 * Enables Angular
 *
 * @param <A>
 * 		The allowed local attributes (Separate from Global Attributes)
 * @param <F>
 * 		The allowed feature JavaScripts
 * @param <E>
 * 		The allowed associated Events
 * @param <J>
 * 		Component output for cloning. Returned on CloneComponent
 *
 * @author GedMarc
 * @since 27 Apr 2016
 */
public class ComponentHTMLAngularBase<A extends Enum & AttributeDefinitions, F extends GlobalFeatures, E extends GlobalEvents, J extends ComponentHTMLAngularBase<A, F, E, J>>
		extends ComponentHTMLAttributeBase<A, F, E, J>
		implements IComponentHTMLAngularBase<J>
{


	/**
	 * All the angular attributes for this component
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Map<AngularAttributes, String> attributesAngular;
	/**
	 * All the angular DTO objects for this component
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private transient Map<String, Object> angularObjects;

	/**
	 * Constructs a new component with the angular features enabled
	 *
	 * @param componentType
	 */
	@SuppressWarnings("all")
	public ComponentHTMLAngularBase(ComponentTypes componentType)
	{
		super(componentType);
	}

	/**
	 * Returns an Angular Base interface of this component
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unused")
	public IComponentHTMLAngularBase asAngularBase()
	{
		return this;
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	@Override
	public boolean equals(Object o)
	{
		return super.equals(o);
	}

	/**
	 * Adds all the attributes associated with angular
	 *
	 * @return
	 */
	@Override
	@NotNull
	public Map<String, String> getAttributes()
	{
		Map<String, String> allAttributes = super.getAttributes();
		getAttributesAngular().forEach((key, value) -> allAttributes.put(key.toString(), value));
		return allAttributes;
	}

	@Override
	public void destroy()
	{
		if (angularObjects != null)
		{
			angularObjects.clear();
			angularObjects = null;
		}
		if (attributesAngular != null)
		{
			attributesAngular.clear();
			attributesAngular = null;
		}
		super.destroy();
	}

	/**
	 * Returns all the angular attributes on this component
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("all")
	private Map<AngularAttributes, String> getAttributesAngular()
	{
		if (attributesAngular == null)
		{
			attributesAngular = new HashMap<>();
		}
		return attributesAngular;
	}

	/**
	 * Binds this component to an angular variable. If it is an input is it bound directly, otherwise the text is set to what the variable
	 * contains
	 * <p>
	 * Over-ride this to apply more functionality such as calendar binding
	 *
	 * @param variableName
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J bind(@NotNull String variableName)
	{
		addAttribute(AngularAttributes.ngBind, variableName);
		AngularPageConfigurator.setRequired(true);
		return (J) this;
	}

	/**
	 * Sets an Angular Attribute
	 *
	 * @param attribute
	 * @param value
	 *
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J addAttribute(@NotNull AngularAttributes attribute, @NotNull String value)
	{
		getAttributesAngular().put(attribute, value);
		return (J) this;
	}

	/**
	 * Adds an object for watching across an application
	 *
	 * @param name
	 * 		The variable name to use
	 * @param dataObject
	 * 		The data object to map
	 *
	 * @return This for chain setting
	 */
	@Override
	@NotNull
	@SuppressWarnings("unchecked")
	public J addDto(@NotNull String name, @NotNull Object dataObject)
	{
		if (dataObject == null)
		{
			dataObject = new JavaScriptPart<>();
		}
		if (dataObject instanceof JavaScriptPart)
		{
			((JavaScriptPart) dataObject)
			                    .setReferenceId(getID());
		}
		getAngularObjects().put(name, dataObject);
		return (J) this;
	}

	/**
	 * Returns the angular objects mapped to this component
	 *
	 * @return
	 */
	@Override
	@NotNull
	public Map<String, Object> getAngularObjects()
	{
		if (angularObjects == null)
		{
			angularObjects = new HashMap<>();
			AngularPageConfigurator.setRequired(true);
		}
		return angularObjects;
	}

	/**
	 * Gets an angular attribute
	 *
	 * @param attribute
	 *
	 * @return
	 */
	@Override

	public String getAttribute(@NotNull AngularAttributes attribute)
	{
		return getAttributesAngular().get(attribute);
	}

	/**
	 * Returns the DTO currently mapped
	 *
	 * @param <T>
	 * 		The type to return
	 * @param name
	 * 		The name of the DTO to map
	 * @param classType
	 * 		The class type
	 *
	 * @return Null if not available
	 */
	@Override
	@NotNull
	@SuppressWarnings("unchecked")
	public <T> T getDto(@NotNull String name, @NotNull Class<T> classType)
	{
		return (T) getAngularObjects().get(name);
	}

	/**
	 * Instructs Angular to not show items that are bound until after the digest sequence
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J cloak()
	{
		addAttribute(AngularAttributes.ngCloak, StaticStrings.STRING_EMPTY);
		AngularPageConfigurator.setRequired(true);
		return (J) this;
	}
}
