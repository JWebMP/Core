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
import com.jwebmp.core.base.html.interfaces.AttributeDefinitions;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.interfaces.IComponentDataBindingBase;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;
import com.jwebmp.core.databind.IOnDataBind;
import com.jwebmp.core.databind.IOnDataBindCloak;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.guicedee.guicedinjection.GuiceContext;

import jakarta.validation.constraints.NotNull;

import java.util.*;

/**
 * Enables Angular
 *
 * @param <A> The allowed local attributes (Separate from Global Attributes)
 * @param <F> The allowed feature JavaScripts
 * @param <E> The allowed associated Events
 * @param <J> Component output for cloning. Returned on CloneComponent
 * @author GedMarc
 * @since 27 Apr 2016
 */
public class ComponentDataBindingBase<A extends Enum<?> & AttributeDefinitions,
		F extends GlobalFeatures,
		E extends GlobalEvents,
		J extends ComponentDataBindingBase<A, F, E, J>>
		extends ComponentHTMLAttributeBase<A, F, E, J>
		implements IComponentDataBindingBase<J>
{
	
	/**
	 * All the angular DTO objects for this component
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Map<String, Object> jsonObjects;
	
	/**
	 * Constructs a new component with the angular features enabled
	 *
	 * @param componentType
	 */
	public ComponentDataBindingBase(ComponentTypes componentType)
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
	public IComponentDataBindingBase<?> asAngularBase()
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
	
	@Override
	public void destroy()
	{
		if (jsonObjects != null)
		{
			jsonObjects.clear();
			jsonObjects = null;
		}
		super.destroy();
	}
	
	/**
	 * Binds this component to an angular variable. If it is an input is it bound directly, otherwise the text is set to what the variable
	 * contains
	 * <p>
	 * Over-ride this to apply more functionality such as calendar binding
	 *
	 * @param variableName
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J bind(@NotNull String variableName)
	{
		@SuppressWarnings("rawtypes")
		Set<IOnDataBind> services = GuiceContext.instance()
		                                        .getLoader(IOnDataBind.class, ServiceLoader.load(IOnDataBind.class));
		services.forEach(a -> a.onBind(this, variableName));
		return (J) this;
	}
	
	/**
	 * Adds an object for watching across an application
	 *
	 * @param name       The variable name to use
	 * @param dataObject The data object to map
	 * @return This for chain setting
	 */
	@Override
	@NotNull
	@SuppressWarnings("unchecked")
	public J addDto(@NotNull String name, Object dataObject)
	{
		if (dataObject == null)
		{
			dataObject = new JavaScriptPart<>();
		}
		if (dataObject instanceof JavaScriptPart)
		{
			((JavaScriptPart<?>) dataObject)
					.setReferenceId(getID());
		}
		getJsonObjects().put(name, dataObject);
		return (J) this;
	}
	
	/**
	 * Returns the angular objects mapped to this component
	 *
	 * @return
	 */
	@Override
	@NotNull
	public Map<String, Object> getJsonObjects()
	{
		if (jsonObjects == null)
		{
			jsonObjects = new LinkedHashMap<>();
		}
		return jsonObjects;
	}
	
	/**
	 * Returns the DTO currently mapped
	 *
	 * @param <T>       The type to return
	 * @param name      The name of the DTO to map
	 * @param classType The class type
	 * @return Null if not available
	 */
	@Override
	@NotNull
	@SuppressWarnings("unchecked")
	public <T> T getDto(@NotNull String name, @NotNull Class<T> classType)
	{
		return (T) getJsonObjects().get(name);
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
		Set<IOnDataBindCloak> services = GuiceContext.instance()
		                                             .getLoader(IOnDataBindCloak.class, ServiceLoader.load(IOnDataBindCloak.class));
		services.forEach(a -> a.onCloak(this));
		return (J) this;
	}
}
