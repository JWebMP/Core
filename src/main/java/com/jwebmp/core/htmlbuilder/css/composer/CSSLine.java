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

package com.jwebmp.core.htmlbuilder.css.composer;

import com.jwebmp.core.utilities.StaticStrings;

import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * This denotes a line for the CSS, for the composer.
 * <p>
 * Like a HashMap but built so it can equal another line
 *
 * @author MMagon
 * @version 1.0
 * @since 07 Apr 2013
 */
public class CSSLine
		implements Comparable<CSSLine>, Comparator<CSSLine>
{

	private String property;
	private String value;

	/**
	 * Construct a line from a property and a value
	 *
	 * @param property
	 * 		The property to assign
	 * @param value
	 * 		The value to assign
	 */
	public CSSLine(String property, String value)
	{
		String propertyUse;
		if (property == null)
		{
			propertyUse = "";
		}
		else
		{
			propertyUse = property;
		}
		setProperty(propertyUse);
		setValue(value);
	}

	/**
	 * Converts method name to CSS name
	 *
	 * @param methodName
	 * 		The method name
	 *
	 * @return Cleaned name
	 */
	private String cleanMethodNameToCSSName(String methodName)
	{
		String cssName = methodName.replace(StaticStrings.CHAR_UNDERSCORE, StaticStrings.CHAR_DASH)
		                           .toLowerCase();
		cssName = cssName.replace('$', StaticStrings.CHAR_SPACE)
		                 .trim();
		return cssName;
	}

	/**
	 * Constructs a CSSLine from a pre-existing pair
	 *
	 * @param aFullLine
	 * 		A full property:value line
	 */
	public CSSLine(String aFullLine)
	{
		if (aFullLine == null || aFullLine.isEmpty())
		{
			setProperty("");
			setValue("");
		}
		else if (!aFullLine.contains(":"))
		{
			setProperty(aFullLine);
		}
		else
		{
			StringTokenizer st = new StringTokenizer(aFullLine, ":");
			setProperty(st.nextToken());
			setValue(st.nextToken());
		}
	}

	/**
	 * Returns 1
	 *
	 * @return A static number
	 */
	@Override
	public int hashCode()
	{
		return 1;
	}

	/**
	 * Returns true if the input object's property and value matches this one
	 *
	 * @param obj
	 *
	 * @return
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof CSSLine)
		{
			CSSLine line = (CSSLine) obj;
			return line.property.trim()
			                    .equalsIgnoreCase(property.trim()) && line.value.trim()
			                                                                    .equalsIgnoreCase(value.trim());
		}
		else
		{
			return false;
		}
	}

	/**
	 * The property value pair of this line return The property value pair of this line
	 */
	@Override
	public String toString()
	{
		return getProperty() + ":" + getValue();
	}

	/**
	 * Returns which property is being assigned
	 *
	 * @return The Property
	 */
	public String getProperty()
	{
		return property;
	}

	/**
	 * Sets the property being assigned
	 *
	 * @param property
	 * 		The property for this line
	 */
	public final void setProperty(String property)
	{
		this.property = cleanMethodNameToCSSName(property);
	}

	/**
	 * Returns the value that this line belongs to
	 *
	 * @return The assignment for the property
	 */
	public String getValue()
	{
		return value.replace("_", "-")
		            .replaceAll(" ;", ";");
	}

	/**
	 * Sets what the value of this property is. Cleans out any quotations from the value in case
	 *
	 * @param value
	 * 		The new value of the property
	 */
	public final void setValue(String value)
	{
		String valueUse;
		if (value == null)
		{
			valueUse = "";
		}
		else
		{
			valueUse = value;
		}
		if (!valueUse.isEmpty())
		{
			valueUse = valueUse.replace(StaticStrings.STRING_SINGLE_QUOTES, StaticStrings.STRING_EMPTY);
			valueUse = valueUse.replace(StaticStrings.STRING_DOUBLE_QUOTES, StaticStrings.STRING_EMPTY);
		}
		this.value = valueUse;
	}

	/**
	 * The property value pair of this line return The property value pair of this line in quotations. It filters out value into CSS readable
	 *
	 * @param renderQuotations
	 *
	 * @return
	 */
	public String toString(boolean renderQuotations)
	{
		if (renderQuotations)
		{
			return StaticStrings.STRING_SINGLE_QUOTES + getProperty() + ":" + getValue() + StaticStrings.STRING_SINGLE_QUOTES;
		}
		else
		{
			return getProperty() + ":" + getValue();
		}
	}

	/**
	 * Compares this class with another. Sorts by property, then by value
	 *
	 * @param o
	 * 		The CSS line to compare to
	 *
	 * @return -1 for DESC, 0 for equal, 1 for ASC
	 */
	@Override
	public int compareTo(CSSLine o)
	{
		if (o.property.compareTo(property) == 0)
		{
			return o.value.compareTo(value);
		}
		return o.property.compareTo(property);
	}

	/**
	 * Compares this class with another. Sorts by property, then by value
	 *
	 * @param o1
	 * 		The CSS line to compare from
	 * 		* @param o2 The CSS line to compare to
	 *
	 * @return -1 for DESC, 0 for equal, 1 for ASC
	 */
	@Override
	public int compare(CSSLine o1, CSSLine o2)
	{
		if (o1.property.compareTo(o2.property) == 0)
		{
			return o1.value.compareTo(o2.value);
		}
		return o1.property.compareTo(o2.property);
	}

}
