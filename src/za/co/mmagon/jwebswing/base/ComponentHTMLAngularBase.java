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
package za.co.mmagon.jwebswing.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import za.co.mmagon.jwebswing.base.angular.AngularAttributes;
import za.co.mmagon.jwebswing.base.angular.AngularPageConfigurator;
import za.co.mmagon.jwebswing.base.html.interfaces.AttributeDefinitions;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.interfaces.IComponentHTMLAngularBase;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

import javax.annotation.Nullable;
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
		extends ComponentHTMLAttributeBase<A, F, E, J> implements IComponentHTMLAngularBase<J>
{

	private static final long serialVersionUID = 1L;

	/**
	 * All the angular attributes for this component
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Map<AngularAttributes, String> attributesAngular;
	/**
	 * All the angular DTO objects for this component
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Map<String, JavaScriptPart> angularObjects;

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
	 * Gets an angular attribute
	 *
	 * @param attribute
	 *
	 * @return
	 */
	@Override
	@Nullable
	public String getAttribute(@NotNull AngularAttributes attribute)
	{
		return getAttributesAngular().get(attribute);
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
	public J addDto(@NotNull String name, @NotNull JavaScriptPart dataObject)
	{
		dataObject.setReferenceId(getID());
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
	public Map<String, JavaScriptPart> getAngularObjects()
	{
		if (angularObjects == null)
		{
			angularObjects = new HashMap<>();
			AngularPageConfigurator.setRequired(this, true);
		}
		return angularObjects;
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
	public <T extends JavaScriptPart> T getDto(@NotNull String name, @NotNull Class<T> classType)
	{
		return (T) getAngularObjects().get(name);
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

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof ComponentHTMLAngularBase))
		{
			return false;
		}
		if (!super.equals(o))
		{
			return false;
		}

		ComponentHTMLAngularBase<?, ?, ?, ?> that = (ComponentHTMLAngularBase<?, ?, ?, ?>) o;

		return getAttributesAngular().equals(that.getAttributesAngular()) && getAngularObjects().equals(that.getAngularObjects());
	}

	/**
	 * Binds this component to an angular variable. If it is an input is it bound directly, otherwise the text is set to what the variable contains
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
		AngularPageConfigurator.setRequired(this, true);
		return (J) this;
	}

	@Override
	public void destroy()
	{
		if (this.angularObjects != null)
		{
			this.angularObjects.clear();
			this.angularObjects = null;
		}
		if (this.attributesAngular != null)
		{
			this.attributesAngular.clear();
			this.attributesAngular = null;
		}
		super.destroy();
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
		addAttribute(AngularAttributes.ngCloak, "");
		AngularPageConfigurator.setRequired(this, true);
		return (J) this;
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}
}
