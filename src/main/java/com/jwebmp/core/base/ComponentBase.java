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

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.guicedee.services.jsonrepresentation.json.StaticStrings;
import com.jwebmp.core.base.interfaces.IComponentBase;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.core.utilities.GUIDGenerator;
import jakarta.validation.constraints.NotNull;
import lombok.extern.java.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

/**
 * Defines the raw necessities for a component to exist
 *
 * @param <J> Component output for cloning. Always make it this class to make life easy
 * @author GedMarc
 * @since 22 Apr 2016
 */
@SuppressWarnings("MissingClassJavaDoc")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY,
                getterVisibility = JsonAutoDetect.Visibility.NONE,
                setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Log
public class ComponentBase<J extends ComponentBase<J>>
		implements IComponentBase<J>
{
	
	/**
	 * The ID of the component rendering for
	 */
	private String id;
	
	/**
	 * The enumeration component type associated with this class to escape the use of "instance of" statements. performance thing
	 */
	private ComponentTypes componentType;
	
	/**
	 * Any raw text that should be built into this component. Rendered before children
	 */
	private String text;
	/**
	 * Specifies if this component should render as small as possible
	 */
	private boolean tiny;
	/**
	 * Whether this component has been configured or not
	 */
	private boolean configured;
	/**
	 * Initialized flag
	 */
	private boolean initialized;
	/**
	 * Sets if this component should be sent on the next call back
	 */
	private boolean touched;
	
	/**
	 * A set of properties for this component
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Map<String, Object> properties;
	
	/**
	 * Constructs a new Component Shell
	 *
	 * @param componentType
	 */
	public ComponentBase(@NotNull ComponentTypes componentType)
	{
		this.componentType = componentType;
		//direct access, don't enable id tag generation
		this.id = GUIDGenerator.generateGuid();
	}
	
	/**
	 * Returns an Attribute Base interface of this component
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unused")
	public IComponentBase<J> asBase()
	{
		return this;
	}
	
	/**
	 * Clones this component and assigns a new ID
	 * <p>
	 *
	 * @return The cloned component
	 */
	@Override
	@SuppressWarnings("unchecked")
	
	public J cloneComponent()
	{
		J component = null;
		try
		{
			component = (J) clone();
			component.setID(GUIDGenerator.generateGuid());
		}
		catch (CloneNotSupportedException ex)
		{
			ComponentBase.log.log(Level.SEVERE, "Cloning Error in Shell", ex);
		}
		return component;
	}
	
	/**
	 * Gets the ID of this component
	 * <p>
	 *
	 * @return The ID of this component
	 */
	@Override
	@NotNull
	public String getID()
	{
		return id;
	}
	
	/**
	 * Generates and places a new ID on this component
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public J generateID()
	{
		id = GUIDGenerator.generateGuid();
		return (J)this;
	}
	
	/**
	 * Returns the ID with the # in the front of it
	 * <p>
	 *
	 * @param jQueryHolder Anything
	 *                     <p>
	 * @return An ID starting with #
	 */
	@Override
	@NotNull
	public String getID(boolean jQueryHolder)
	{
		return StaticStrings.STRING_HASH + id;
	}
	
	/**
	 * Returns the component rendering for JQuery string Requires the rendering for component is set
	 * <p>
	 *
	 * @return $(' # x ').
	 */
	@Override
	@NotNull
	public String getJQueryID()
	{
		return "$(\"" + getID(true) + "\").";
	}
	
	/**
	 * Returns the new line character according to Running Environment
	 * <p>
	 *
	 * @return A new line if is in development mode
	 */
	@Override
	@NotNull
	public String getNewLine()
	{
		if (!isTiny())
		{
			return StaticStrings.STRING_NEWLINE_TEXT;
		}
		else
		{
			return StaticStrings.STRING_EMPTY;
		}
	}
	
	/**
	 * Returns a map of user defined properties for this component
	 *
	 * @return
	 */
	@Override
	@NotNull
	public Map<String, Object> getProperties()
	{
		if (properties == null)
		{
			properties = new HashMap<>();
		}
		return properties;
	}
	
	/**
	 * returns a new StringSuilder of the raw text with the specific tab counts
	 * <p>
	 *
	 * @param tabCounts <p>
	 * @return
	 */
	@Override
	@NotNull
	public StringBuilder getText(int tabCounts)
	{
		StringBuilder sb = new StringBuilder();
		getText(sb);
		return sb;
	}
	
	/**
	 * Appends the text used as raw text outside the tags to the incoming StringBuilder
	 * <p>
	 *
	 * @param sb The StringBuilder to append to
	 *           <p>
	 * @return The current set Raw Text
	 */
	@NotNull
	protected StringBuilder getText(StringBuilder sb)
	{
		if (text == null)
		{
			return new StringBuilder();
		}
		else
		{
			sb.append(text);
			return sb;
		}
	}
	
	/**
	 * If this component is already configured
	 *
	 * @return
	 */
	@Override
	public boolean isConfigured()
	{
		return configured;
	}
	
	/**
	 * If this component is already configured
	 *
	 * @param configured
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J setConfigured(boolean configured)
	{
		this.configured = configured;
		return (J) this;
	}
	
	/**
	 * Specifies whether or not to render this component in a Production/QA fashion
	 * <p>
	 *
	 * @return If this component will render in production mode
	 */
	@Override
	public boolean isTiny()
	{
		return tiny;
	}
	
	/**
	 * If this component will render as tiny HTML. Global override value
	 * <p>
	 *
	 * @param tiny Set if this component must render as tiny HTML. Does not affect CSS or JavaScript rendering
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J setTiny(boolean tiny)
	{
		this.tiny = tiny;
		return (J) this;
	}
	
	/**
	 * Returns if this component is needing refresh on next Ajax call
	 * <p>
	 *
	 * @return true if going to be touched
	 */
	@Override
	public boolean isTouched()
	{
		return touched;
	}
	
	/**
	 * Mark this component as needing refresh to the Ajax Controller
	 * <p>
	 *
	 * @param touched Whether or not to update on next ajax call
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J setTouched(boolean touched)
	{
		this.touched = touched;
		return (J) this;
	}
	
	/**
	 * Run-Once on creation Executes a piece of code before running any rendering. Call super after your changes Marks the component as
	 * configured
	 */
	@Override
	public void preConfigure()
	{
		setConfigured(true);
	}
	
	/**
	 * Sets this components user defined properties
	 *
	 * @param properties
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J setProperties(Map<String, Object> properties)
	{
		this.properties = properties;
		return (J) this;
	}
	
	/**
	 * Sets this components Raw Text
	 * <p>
	 *
	 * @param text The text to display as Raw Text
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J setText(String text)
	{
		this.text = text;
		return (J) this;
	}
	
	/**
	 * Sets the ID of this component
	 * <p>
	 *
	 * @param id The ID
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J setID(String id)
	{
		this.id = id;
		return (J) this;
	}
	
	/**
	 * Default HashCode over-ride
	 *
	 * @return
	 */
	@Override
	public int hashCode()
	{
		return getID().hashCode();
	}
	
	/**
	 * Default equals for a component
	 *
	 * @param obj The incoming object
	 * @return True if the ID, Type and Text are the same
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		ComponentBase<?> other = (ComponentBase<?>) obj;
		return other.getID()
		            .equals(getID());
	}
	
	/**
	 * Renders the component as a JSON Object
	 *
	 * @return
	 */
	@Override
	public String toString()
	{
		return getComponentType() + " - " + getID();
	}
	
	/**
	 * Renders the component as a JSON Object
	 *
	 * @return
	 */
	public String toJson()
	{
		if (!isConfigured())
		{
			init();
			preConfigure();
		}
		return new JavaScriptPart<>().objectAsString(this);
	}
	
	/**
	 * Runs before anything Can be used as constructor intializations.
	 */
	public void init()
	{
		setInitialized(true);
	}
	
	/**
	 * Returns the actual text object for analysis
	 *
	 * @return
	 */
	public String getText()
	{
		return text;
	}
	
	/**
	 * Sets this components Raw Text
	 * <p>
	 *
	 * @param text The text to display as Raw Text
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J setText(StringBuilder text)
	{
		this.text = text.toString();
		return (J) this;
	}
	
	/**
	 * Gets this components enumeration
	 * <p>
	 *
	 * @return The Component Enumeration of this component
	 */
	@NotNull
	@Override
	public ComponentTypes getComponentType()
	{
		return componentType;
	}
	
	/**
	 * Sets this components enumeration. Currently little more than an easy to compare Enum
	 * <p>
	 *
	 * @param componentType The component to mimic
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setComponentType(ComponentTypes componentType)
	{
		this.componentType = componentType;
		return (J) this;
	}
	
	/**
	 * If this component has been initialized
	 *
	 * @return
	 */
	public boolean isInitialized()
	{
		return initialized;
	}
	
	/**
	 * If this component has been initialized
	 *
	 * @param initialized
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setInitialized(boolean initialized)
	{
		this.initialized = initialized;
		return (J) this;
	}
	
	/**
	 * For JSON Reconstruction
	 *
	 * @return
	 */
	@JsonProperty("componentClass")
	@SuppressWarnings("unused")
	protected String getComponentClass()
	{
		return getClass().getCanonicalName();
	}
	
	/**
	 * If the component has a property attached
	 *
	 * @param propertyName
	 * @return
	 */
	public boolean hasProperty(String propertyName)
	{
		return getProperties().containsKey(propertyName);
	}
	
	/**
	 * Returns a specific property in toString form
	 *
	 * @param propertyName
	 * @return
	 */
	@NotNull
	public String getProperty(String propertyName)
	{
		return getProperties().get(propertyName)
		                      .toString();
	}
	
	/**
	 * Returns the classes canonical name used for ID's in events
	 *
	 * @return
	 */
	@NotNull
	public String getClassCanonicalName()
	{
		try
		{
			if (getClass().getCanonicalName() != null)
			{
				return getClass().getCanonicalName()
				                 .replace(StaticStrings.CHAR_DOT, StaticStrings.CHAR_UNDERSCORE);
			}
			return getClass().getName()
			                 .replace(StaticStrings.CHAR_DOT, StaticStrings.CHAR_UNDERSCORE);
		}
		catch (NullPointerException npe)
		{
			ComponentBase.log.log(Level.FINE, "Null Pointer in getting canonical name", npe);
			return getClass().getTypeName();
		}
	}
	
	/**
	 * Destroys this instance
	 */
	public void destroy()
	{
		getProperties().clear();
		setProperties(null);
	}
}
