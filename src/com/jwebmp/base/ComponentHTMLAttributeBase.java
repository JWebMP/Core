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
package com.jwebmp.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.base.html.attributes.GlobalAttributes;
import com.jwebmp.base.html.interfaces.AttributeDefinitions;
import com.jwebmp.base.html.interfaces.GlobalFeatures;
import com.jwebmp.base.html.interfaces.NoClassAttribute;
import com.jwebmp.base.html.interfaces.NoIDTag;
import com.jwebmp.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.base.interfaces.IComponentHTMLAttributeBase;
import com.jwebmp.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.logger.LogFactory;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.logging.Level;

import static com.jwebmp.utilities.StaticStrings.*;

/**
 * Denotes a component that has a tag. By default these can add events, features, variables etc
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
 * @since 23 Apr 2016
 */
public class ComponentHTMLAttributeBase<A extends Enum & AttributeDefinitions, F extends GlobalFeatures, E extends GlobalEvents, J extends ComponentHTMLAttributeBase<A, F, E, J>>
		extends ComponentHTMLBase<F, E, J>
		implements IComponentHTMLAttributeBase<A, J>
{

	/**
	 * Serial Version for all Components and their compatibility
	 *
	 * @version 2 Version 2 - Updated CSS Library and References
	 */
	@JsonIgnore
	private static final long serialVersionUID = 1L;

	/**
	 * Logger for the Component
	 */
	@JsonIgnore
	private static final java.util.logging.Logger LOG = LogFactory.getInstance()
	                                                              .getLogger("ComponentAttributes");

	/**
	 * The current stored attribute lists
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Map<String, String> attributes;

	/**
	 * Specifies if this component should render an ID attribute
	 */
	@JsonIgnore
	private boolean renderIDAttibute = true;

	/**
	 * Construct a new component that will render a tag
	 *
	 * @param componentType
	 */
	@SuppressWarnings("all")
	public ComponentHTMLAttributeBase(ComponentTypes componentType)
	{
		super(componentType);
	}

	/**
	 * Returns an Attribute Base interface of this component
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unused")
	public IComponentHTMLAttributeBase asAttributeBase()
	{
		return this;
	}

	/**
	 * Renders all the Attribute HTML. The All Custom attributes can contain any value=parameter pair
	 * <p>
	 *
	 * @return The attribute HTML
	 *
	 * @see com.jwebmp.base.html.attributes.GlobalAttributes
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

		//Build up the string builder
		if (!getAttributes().isEmpty())
		{
			sb.append(STRING_SPACE);
		}
		for (Entry<String, String> entry : getAttributes().entrySet())
		{
			String key = entry.getKey();
			String value = entry.getValue();
			if (value == null)
			{
				continue;
			}
			value = value.replaceAll(STRING_DOUBLE_QUOTES, STRING_SINGLE_QUOTES);
			boolean isKeyword = value.isEmpty();
			if (!isKeyword)
			{
				sb.append(key.toLowerCase())
				  .append(STRING_EQUALS_DOUBLE_QUOTES)
				  .append(value)
				  .append(STRING_DOUBLE_QUOTES_SPACE);
			}
			else
			{
				sb.append(key.toLowerCase())
				  .append(STRING_SPACE);
			}
		}
		if (!getAttributes().isEmpty())
		{
			sb.deleteCharAt(sb.lastIndexOf(STRING_SPACE));
		}
		return sb;
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
		if (!renderIDAttibute || (this instanceof NoIDTag))
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
	 * @param key
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J removeAttribute(GlobalAttributes key)
	{
		getAttributes().remove(key.toString());
		return (J) this;
	}

	/**
	 * Sets if this component should render an ID attribute
	 * <p>
	 *
	 * @param renderIDAttibute
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings({"unchecked", "unused"})
	public J setRenderIDAttibute(boolean renderIDAttibute)
	{
		this.renderIDAttibute = renderIDAttibute;
		if (!renderIDAttibute)
		{
			getAttributes().remove(GlobalAttributes.ID.toString());
		}
		return (J) this;
	}

	/**
	 * Renders the classes array as an in-line class string
	 *
	 * @return
	 */
	protected StringBuilder renderClasses()
	{
		return new StringBuilder();
	}

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
	@Override
	@NotNull
	@SuppressWarnings("unchecked")
	public final J addAttribute(@NotNull GlobalAttributes attribute, @NotNull String value)
	{
		if (attribute == GlobalAttributes.Style)
		{
			getAttributes().put(attribute.toString(), getAttributes().get(attribute.toString()) + STRING_EMPTY + value);
		}
		getAttributes().put(attribute.toString(), value);

		return (J) this;
	}

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
	 * @param attribute
	 * 		The GlobalAttribute to set the attribute to
	 * @param value
	 * 		The value of the attribute
	 *
	 * @return
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
	 * @param attribute
	 * 		The valid Local Attribute to add
	 * @param value
	 * 		The value of the attribute
	 *
	 * @return
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
	 * @param attribute
	 * 		The Global Attribute to apply
	 * @param bop
	 * 		Place Holder for return type boolean
	 * 		<p>
	 *
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
	 * @param attribute
	 * 		The Global Attribute to apply
	 * @param bop
	 * 		Place Holder for return type integer
	 * 		<p>
	 *
	 * @return HashMap of Attributes with GlobalAttributes Enumeration as Identifier
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public final Integer getAttribute(@NotNull GlobalAttributes attribute, @NotNull Integer bop)
	{
		try
		{
			return Integer.parseInt(getAttributes().get(attribute.toString()));
		}
		catch (NumberFormatException | NullPointerException nfe)
		{
			LOG.log(Level.FINE, "Invalid Global Attribute Reference [" + getClass().getSimpleName() + "] - [" + attribute + "]. Ignoring.", nfe);
			return bop;
		}
	}

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
	@Override
	@Nullable
	public final String getAttribute(@NotNull GlobalAttributes attribute)
	{
		getAttributes().putIfAbsent(attribute.toString(), STRING_EMPTY);
		return getAttributes().get(attribute.toString());
	}

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
	@Override
	@NotNull
	public String getAttribute(@NotNull A attributeValue)
	{
		String s = getAttributes().get(attributeValue.toString());
		if (s == null)
		{
			s = STRING_EMPTY;
		}
		return s;
	}

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
	@Override
	@NotNull
	public Integer getAttribute(@NotNull A attributeValue, @NotNull Integer uselessInt)
	{
		String s = getAttributes().get(attributeValue.toString());
		if (s == null)
		{
			s = "0";
		}
		return new Integer(s);
	}

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
	@Override
	@NotNull
	public Boolean getAttribute(@NotNull A attributeValue, @NotNull Boolean uselessInt)
	{
		String s = getAttributes().get(attributeValue.toString());
		if (s == null)
		{
			s = Boolean.toString(false);
		}
		return Boolean.valueOf(s);
	}

	/**
	 * Returns the current raw attribute map
	 *
	 * @return
	 */
	@NotNull
	protected Map<String, String> getAttributes()
	{
		if (attributes == null)
		{
			attributes = new TreeMap<>();
		}
		return attributes;
	}

	/**
	 * Adds an attribute with an enum value. The toString() method is read
	 *
	 * @param attribute
	 * @param value
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J addAttribute(@NotNull A attribute, @NotNull Enum value)
	{
		getAttributes().put(attribute.toString(), value.toString());
		return (J) this;
	}

	/**
	 * Sets the ID and adds the attribute to the global set
	 *
	 * @param id
	 *
	 * @return
	 */
	@Override
	@NotNull
	public J setID(String id)
	{
		addAttribute(GlobalAttributes.ID, id);
		return super.setID(id);
	}

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
	@SuppressWarnings("unchecked")
	@NotNull
	public final J addAttribute(String attribute, String value)
	{
		getAttributes().put(attribute, value);
		return (J) this;
	}

	/**
	 * Removes an attribute
	 *
	 * @param key
	 *
	 * @return
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
	 * @param key
	 *
	 * @return
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

	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J cloneComponent()
	{
		ComponentHTMLAttributeBase cloned = super.cloneComponent();

		cloned.attributes = new TreeMap();
		cloned.attributes.putAll(getAttributes());

		return (J) cloned;
	}

	/**
	 * Shortcut to adding a style attribute
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J addStyle(String property, String value)
	{
		addStyle(property + ":" + value);
		return (J) this;
	}

	/**
	 * Shortcut to adding a style attribute
	 *
	 * @param style
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J addStyle(String style)
	{
		if (!style.endsWith(STRING_SEMICOLON))
		{
			style += STRING_SEMICOLON;
		}
		if (getAttributes().get(GlobalAttributes.Style.toString()) == null)
		{
			addAttribute(GlobalAttributes.Style, style);
		}
		else
		{
			addAttribute(GlobalAttributes.Style, getAttributes().get(GlobalAttributes.Style.toString()) + style);
		}
		return (J) this;
	}
}
