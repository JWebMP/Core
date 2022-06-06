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

import com.fasterxml.jackson.annotation.*;
import com.google.common.base.*;
import com.guicedee.guicedinjection.json.*;
import com.guicedee.logger.*;
import com.jwebmp.core.base.html.attributes.*;
import com.jwebmp.core.base.html.interfaces.*;
import com.jwebmp.core.base.html.interfaces.events.*;
import com.jwebmp.core.base.interfaces.*;
import com.jwebmp.core.base.servlets.enumarations.*;
import jakarta.validation.constraints.*;

import java.util.*;
import java.util.Map.*;
import java.util.logging.*;

/**
 * Denotes a component that has a tag. By default these can add events, features, variables etc
 *
 * @param <A> The allowed local attributes (Separate from Global Attributes)
 * @param <F> The allowed feature JavaScripts
 * @param <E> The allowed associated Events
 * @param <J> Component output for cloning. Returned on CloneComponent
 * @author GedMarc
 * @since 23 Apr 2016
 */
public class ComponentHTMLAttributeBase<A extends Enum<?> & AttributeDefinitions,
		F extends GlobalFeatures,
		E extends GlobalEvents,
		J extends ComponentHTMLAttributeBase<A, F, E, J>>
		extends ComponentHTMLOptionsBase<F, E, J>
		implements IComponentHTMLAttributeBase<A, J>
{
	/**
	 * Logger for the Component
	 */
	@JsonIgnore
	private static final java.util.logging.Logger LOG = LogFactory.getLog("ComponentAttributes");
	
	/**
	 * The current stored attribute lists
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Map<String, String> attributes;
	
	/**
	 * Specifies if this component should render an ID attribute
	 */
	private boolean renderIDAttibute = true;
	
	/**
	 * Renders the attributes with a single colon instead of a double colon, and replaces single colon values with double colons
	 */
	private boolean invertColonRender = false;
	
	/**
	 * Construct a new component that will render a tag
	 *
	 * @param componentType
	 */
	public ComponentHTMLAttributeBase(ComponentTypes componentType)
	{
		super(componentType);
	}
	
	/**
	 * Returns an Attribute Base interface of this component
	 *
	 * @return A cleaner version
	 */
	@NotNull
	public IComponentHTMLAttributeBase<?, ?> asAttributeBase()
	{
		return this;
	}
	
	/**
	 * Renders all the Attribute HTML. The All Custom attributes can contain any value=parameter pair
	 * <p>
	 *
	 * @return The attribute HTML
	 * @see com.jwebmp.core.base.html.attributes.GlobalAttributes
	 */
	@Override
	@NotNull
	protected StringBuilder renderAttributes(@NotNull StringBuilder sb)
	{
		StringBuilder sbClasses = renderClasses();
		if (sbClasses.length() > 0 && !(this instanceof NoClassAttribute))
		{
			addAttribute(GlobalAttributes.Class, sbClasses.toString());
		}
		if (!getAttributes().isEmpty())
		{
			sb.append(StaticStrings.STRING_SPACE);
		}
		for (Entry<String, String> entry : getAttributes().entrySet())
		{
			String key = entry.getKey();
			String value = entry.getValue();
			if (value == null)
			{
				continue;
			}
			if (isInvertColonRender())
			{
				value = value.replaceAll(StaticStrings.STRING_SINGLE_QUOTES, StaticStrings.STRING_DOUBLE_QUOTES);
			}
			else
			{
				value = value.replaceAll(StaticStrings.STRING_DOUBLE_QUOTES, StaticStrings.STRING_SINGLE_QUOTES);
			}
			boolean isKeyword = value.isEmpty();
			if (!isKeyword)
			{
				if (isInvertColonRender())
				{
					sb.append(key)
					  .append(StaticStrings.STRING_EQUALS_SINGLE_QUOTES)
					  .append(value)
					  .append(StaticStrings.STRING_SINGLE_QUOTES_SPACE);
				}
				else
				{
					sb.append(key)
					  .append(StaticStrings.STRING_EQUALS_DOUBLE_QUOTES)
					  .append(value)
					  .append(StaticStrings.STRING_DOUBLE_QUOTES_SPACE);
				}
			}
			else
			{
				sb.append(key)
				  .append(StaticStrings.STRING_SPACE);
			}
		}
		if (!getAttributes().isEmpty())
		{
			sb.deleteCharAt(sb.lastIndexOf(StaticStrings.STRING_SPACE));
		}
		sb = new StringBuilder(sb.toString()
		                         .toLowerCase());
		return sb;
	}
	
	/**
	 * Adds the ID attribute to the component
	 */
	@Override
	public void preConfigure()
	{
		if (!isConfigured())
		{
			if (isRenderIDAttibute())
			{
				addAttribute(GlobalAttributes.ID, getID());
			}
			else
			{
				removeAttribute(GlobalAttributes.ID);
			}
		}
		super.preConfigure();
	}
	
	/**
	 * Returns if this component should render for the ID attribute
	 * <p>
	 *
	 * @return
	 */
	@SuppressWarnings("all")
	public boolean isRenderIDAttibute()
	{
		if (!renderIDAttibute || NoIDTag.class.isAssignableFrom(getClass()))
		{
			return false;
		}
		else
		{
			return renderIDAttibute;
		}
	}
	
	/**
	 * Removes a key from the attribute set
	 *
	 * @param key The global attribute key
	 * @return This object
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J removeAttribute(GlobalAttributes key)
	{
		getAttributes().remove(key.toString());
		return (J) this;
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
	 * Adds an attribute value to the attribute collection, and marks it with a GlobalAttribute Enumeration.
	 * <p>
	 *
	 * @param attribute The GlobalAttribute to set the attribute to
	 * @param value     The value of the attribute
	 * @return This object
	 */
	@Override
	@NotNull
	@SuppressWarnings("unchecked")
	public final J addAttribute(@NotNull GlobalAttributes attribute, @NotNull String value)
	{
		if (attribute == GlobalAttributes.Style)
		{
			getAttributes().put(attribute.toString(), getAttributes().get(attribute.toString()) + StaticStrings.STRING_EMPTY + value);
		}
		else
		{
			getAttributes().put(attribute.toString(), value);
		}
		return (J) this;
	}
	
	
	/**
	 * Adds an attribute value to the attribute collection, and marks it with a GlobalAttribute Enumeration.
	 * <p>
	 *
	 * @param attribute The GlobalAttribute to set the attribute to
	 * @param value     The value of the attribute
	 * @return This object
	 */
	@Override
	@NotNull
	@SuppressWarnings("unchecked")
	public final J addAttribute(@NotNull GlobalAttributes attribute, @NotNull Object value)
	{
		if (attribute == GlobalAttributes.Style)
		{
			getAttributes().put(attribute.toString(), getAttributes().get(attribute.toString()) + StaticStrings.STRING_EMPTY + value);
		}
		else
		{
			getAttributes().put(attribute.toString(), value + "");
		}
		
		return (J) this;
	}
	
	/**
	 * Returns the current raw attribute map
	 *
	 * @return A Tree Map of Attributes
	 */
	@NotNull
	public Map<String, String> getAttributes()
	{
		if (attributes == null)
		{
			attributes = new TreeMap<>();
		}
		return attributes;
	}
	
	/**
	 * Renders the attributes with a single colon instead of a double colon, and replaces single colon values with double colons
	 *
	 * @return the variable
	 */
	public boolean isInvertColonRender()
	{
		return invertColonRender;
	}
	
	/**
	 * Renders the attributes with a single colon instead of a double colon, and replaces single colon values with double colons
	 *
	 * @param invertColonRender set variable
	 * @return This object
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setInvertColonRender(boolean invertColonRender)
	{
		this.invertColonRender = invertColonRender;
		return (J) this;
	}
	
	/**
	 * Adds an attribute value to the attribute collection, and marks it with a GlobalAttribute Enumeration.
	 * <p>
	 *
	 * @param attribute The GlobalAttribute to set the attribute to
	 * @param value     The value of the attribute
	 * @return This Object
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J addAttribute(@NotNull A attribute, @NotNull String value)
	{
		
		getAttributes().put(attribute.toString(), value);
		return (J) this;
	}
	
	/**
	 * Adds an attribute value to the attribute collection, and marks it with a GlobalAttribute Enumeration.
	 * <p>
	 *
	 * @param attribute The valid Local Attribute to add
	 * @param value     The value of the attribute
	 * @return This object
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public final J addAttribute(String attribute, String value)
	{
		if(!Strings.isNullOrEmpty(attribute))
		getAttributes().put(attribute, value);
		return (J) this;
	}
	
	/**
	 * Adds an attribute value to the attribute collection, and marks it with a GlobalAttribute Enumeration.
	 * <p>
	 *
	 * @param attribute The GlobalAttribute to set the attribute to
	 * @param value     The value of the attribute
	 * @return This Object
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public final J addAttribute(@NotNull A attribute, @NotNull Integer value)
	{
		getAttributes().put(attribute.toString(), value.toString());
		return (J) this;
	}
	
	/**
	 * Adds an attribute value to the attribute collection, and marks it with a GlobalAttribute Enumeration.
	 * <p>
	 *
	 * @param attribute The valid Local Attribute to add
	 * @param value     The value of the attribute
	 * @return This object
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public final J addAttribute(@NotNull A attribute, @NotNull Boolean value)
	{
		getAttributes().put(attribute.toString(), value.toString());
		return (J) this;
	}
	
	/**
	 * Returns an enumerated HashMap for ease of access
	 * <p>
	 *
	 * @param attribute The Global Attribute to apply
	 * @param bop       Place Holder for return type boolean
	 *                  <p>
	 * @return HashMap of Attributes with GlobalAttributes Enumeration as Identifier
	 */
	@Override
	@NotNull
	public final Boolean getAttribute(@NotNull GlobalAttributes attribute, @NotNull Boolean bop)
	{
		return Boolean.parseBoolean(getAttributes().get(attribute.toString()));
	}
	
	/**
	 * Returns an enumerated HashMap for ease of access
	 * <p>
	 *
	 * @param attribute The Global Attribute to apply
	 * @param bop       Place Holder for return type integer
	 *                  <p>
	 * @return HashMap of Attributes with GlobalAttributes Enumeration as Identifier
	 */
	@Override
	@NotNull
	public final Integer getAttribute(@NotNull GlobalAttributes attribute, @NotNull Integer bop)
	{
		try
		{
			return Integer.parseInt(getAttributes().get(attribute.toString()));
		}
		catch (NumberFormatException | NullPointerException nfe)
		{
			ComponentHTMLAttributeBase.LOG.log(Level.FINE, "Invalid Global Attribute Reference [" + getClass().getSimpleName() + "] - [" + attribute + "]. Ignoring.", nfe);
			return bop;
		}
	}
	
	/**
	 * Returns an enumerated HashMap for ease of access
	 * <p>
	 *
	 * @param attribute The Global Attribute to apply
	 *                  <p>
	 * @return HashMap of Attributes with GlobalAttributes Enumeration as Identifier
	 */
	@Override
	public final String getAttribute(@NotNull GlobalAttributes attribute)
	{
		getAttributes().putIfAbsent(attribute.toString(), StaticStrings.STRING_EMPTY);
		return Strings.nullToEmpty(getAttributes().get(attribute.toString()));
	}
	
	/**
	 * Gets this list of local attribute values
	 * <p>
	 *
	 * @param attributeValue The Valid Local Attribute to Return
	 *                       <p>
	 * @return A String of the attribute value currently set
	 */
	@Override
	@NotNull
	public String getAttribute(@NotNull A attributeValue)
	{
		String s = getAttributes().get(attributeValue.toString());
		if (Strings.isNullOrEmpty(s))
		{
			s = StaticStrings.STRING_EMPTY;
		}
		return s;
	}
	
	/**
	 * @param attributeValue The decoded value to Return
	 *                       <p>
	 * @return
	 */
	@Override
	public String getAttribute(String attributeValue)
	{
		String s = getAttributes().get(attributeValue);
		if (Strings.isNullOrEmpty(s))
		{
			s = StaticStrings.STRING_EMPTY;
		}
		return s;
	}
	
	/**
	 * @param attributeValue The decoded value to Return
	 * @param uselessInt     A useless parameter purely to return the type integer
	 *                       <p>
	 * @return
	 */
	@Override
	public Integer getAttribute(String attributeValue, Integer uselessInt)
	{
		String s = getAttributes().get(attributeValue);
		if (Strings.isNullOrEmpty(s))
		{
			s = StaticStrings.STRING_EMPTY;
		}
		return new StringToIntegerRelaxed().convert(s);
	}
	
	/**
	 * @param attributeValue The decoded value to Return
	 * @param uselessInt     A useless parameter purely to return the type Boolean
	 *                       <p>
	 * @return
	 */
	@Override
	public Boolean getAttribute(String attributeValue, Boolean uselessInt)
	{
		String s = getAttributes().get(attributeValue);
		if (Strings.isNullOrEmpty(s))
		{
			s = StaticStrings.STRING_EMPTY;
		}
		return new StringToBoolean().convert(s);
	}
	
	/**
	 * Gets this list of local attribute values
	 * <p>
	 *
	 * @param attributeValue The Valid Local Attribute to Return
	 * @param uselessInt     A useless parameter purely to return the type integer
	 *                       <p>
	 * @return A HashMap if this components local attributes. Never null
	 */
	@Override
	@NotNull
	public Integer getAttribute(@NotNull A attributeValue, @NotNull Integer uselessInt)
	{
		String s = getAttributes().get(attributeValue.toString());
		if (Strings.isNullOrEmpty(s))
		{
			s = "0";
		}
		return Integer.valueOf(s);
	}
	
	/**
	 * Gets this list of local attribute values
	 * <p>
	 *
	 * @param attributeValue The Valid Local Attribute to Return
	 * @param uselessInt     A useless parameter purely to return the type Boolean
	 *                       <p>
	 * @return A HashMap if this components local attributes. Never null
	 */
	@Override
	@NotNull
	public Boolean getAttribute(@NotNull A attributeValue, @NotNull Boolean uselessInt)
	{
		String s = getAttributes().get(attributeValue.toString());
		if (Strings.isNullOrEmpty(s))
		{
			s = Boolean.toString(false);
		}
		return Boolean.valueOf(s);
	}
	
	/**
	 * Sets if this component should render an ID attribute
	 * <p>
	 *
	 * @param renderIDAttribute If the ID must be rendered
	 * @return This Object
	 */
	@NotNull
	@SuppressWarnings({"unchecked", "unused"})
	public J setRenderIDAttribute(boolean renderIDAttribute)
	{
		renderIDAttibute = renderIDAttribute;
		if (!renderIDAttibute)
		{
			getAttributes().remove(GlobalAttributes.ID.toString());
		}
		return (J) this;
	}
	
	/**
	 * Adds an attribute with an enum value. The toString() method is read
	 *
	 * @param attribute The attribute key to add
	 * @param value     The value of the attribute or "" for keyword only
	 * @return This object
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J addAttribute(@NotNull A attribute, @NotNull Enum<?> value)
	{
		getAttributes().put(attribute.toString(), value.toString());
		return (J) this;
	}
	
	/**
	 * Sets the ID and adds the attribute to the global set
	 *
	 * @param id the id to add as an attribute
	 * @return This object
	 */
	@Override
	@NotNull
	public J setID(String id)
	{
		addAttribute(GlobalAttributes.ID, id);
		return super.setID(id);
	}
	
	/**
	 * Removes an attribute
	 *
	 * @param key the key to remove
	 * @return this object
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J removeAttribute(String key)
	{
		getAttributes().remove(key);
		return (J) this;
	}
	
	/**
	 * Removes a key from the attribute set
	 *
	 * @param key the key to remove
	 * @return this attribute
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J removeAttribute(A key)
	{
		getAttributes().remove(key.toString());
		return (J) this;
	}
	
	@Override
	public void destroy()
	{
		if (attributes != null)
		{
			attributes.clear();
			attributes = null;
		}
		super.destroy();
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
		ComponentHTMLAttributeBase<?, ?, ?, ?> cloned = super.cloneComponent();
		cloned.attributes = new TreeMap<>();
		cloned.attributes.putAll(getAttributes());
		//noinspection CastCanBeRemovedNarrowingVariableType
		return (J) cloned;
	}
	
	/**
	 * Shortcut to adding a style attribute
	 *
	 * @return This obejct
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	@Override
	public J addStyle(String property, String value)
	{
		if (Strings.isNullOrEmpty(property) || Strings.isNullOrEmpty(value))
		{
			return (J)this;
		}
		addStyle(property + StaticStrings.STRING_DOUBLE_COLON + value);
		return (J) this;
	}
	
	/**
	 * Shortcut to adding a style attribute
	 *
	 * @param style the style string to add
	 * @return This object
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	@Override
	public J addStyle(String style)
	{
		if (Strings.isNullOrEmpty(style))
		{
			return(J)this;
		}
		if (!style.endsWith(StaticStrings.STRING_SEMICOLON))
		{
			style += StaticStrings.STRING_SEMICOLON;
		}
		if (getAttributes().get(GlobalAttributes.Style.toString()) == null)
		{
			addAttribute(GlobalAttributes.Style, style);
		}
		else
		{
			addAttribute(GlobalAttributes.Style, Strings.nullToEmpty(getAttributes().get(GlobalAttributes.Style.toString())) + style);
		}
		if(getAttribute(GlobalAttributes.Style).contains("null"))
		{
			addAttribute(GlobalAttributes.Style, getAttribute(GlobalAttributes.Style).replace("null", ""));
		}
		return (J) this;
	}
}
