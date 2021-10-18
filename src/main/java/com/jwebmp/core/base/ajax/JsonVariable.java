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
package com.jwebmp.core.base.ajax;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.guicedee.guicedinjection.*;
import com.guicedee.guicedinjection.interfaces.*;
import com.guicedee.guicedinjection.representations.*;
import com.guicedee.logger.*;
import com.jwebmp.core.htmlbuilder.javascript.*;

import java.io.*;
import java.util.*;
import java.util.logging.*;

/**
 * DTO for angular variable transfers forward and back
 *
 * @author GedMarc
 * @since 08 May 2016
 */
@SuppressWarnings({"JavaDoc", "unused"})
public class JsonVariable
		extends JavaScriptPart<JsonVariable>
{
	private static final Logger log = LogFactory.getLog("JsonVariable");
	
	/**
	 * The variable name to use
	 */
	private String variableName;
	/**
	 * The object to assign
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@JsonDeserialize(using = ObjectToStringDeserialize.class)
	@JsonSerialize(using = AlwaysEmptySerializer.class)
	private String variableText;
	/**
	 * The actual variable object
	 */
	private Object variable;
	/**
	 * The owner id of this DTO
	 */
	@JsonProperty(value = "$jwid")
	private String ownerId;
	
	/**
	 * Constructs a blank object
	 */
	public JsonVariable()
	{
	}
	
	/**
	 * Constructs a new instance with a given name and object
	 *
	 * @param variableName   The variable name to apply
	 * @param variableObject The JSON object to use
	 */
	public JsonVariable(String variableName, String variableObject)
	{
		this.variableName = variableName;
		variableText = variableObject;
		variable = variableText;
	}
	
	/**
	 * Constructs a new instance with a given name and object
	 *
	 * @param variableName   The variable name to apply
	 * @param variableObject The JSON object to use
	 */
	public JsonVariable(String variableName, Object variableObject)
	{
		this.variableName = variableName;
		variable = variableObject;
	}
	
	/**
	 * Constructs a new instance with a given name and object
	 *
	 * @param variableName   The variable name to apply
	 * @param variableObject The JSON object to use
	 */
	public JsonVariable(String variableName, JavaScriptPart<?> variableObject)
	{
		this.variableName = variableName;
		variable = variableObject;
	}
	
	/**
	 * Gets the DTO Form of this object
	 *
	 * @param <T>       The type this object actually is
	 * @param classType The class type to return
	 * @return The DTO direct from the call
	 * @throws IOException
	 */
	public <T extends Serializable> T getDto(Class<T> classType) throws IOException
	{
		T output = IJsonRepresentation.From(variableText, classType);
		variable = output;
		return output;
	}
	
	/**
	 * Gets the variable name
	 *
	 * @return
	 */
	public String getVariableName()
	{
		return variableName;
	}
	
	/**
	 * Sets the variable name
	 *
	 * @param variableName
	 */
	public void setVariableName(String variableName)
	{
		this.variableName = variableName;
	}
	
	/**
	 * Returns the variable if any is applied
	 *
	 * @return
	 */
	public Object getVariable()
	{
		return variable;
	}
	
	/**
	 * Sets the variable if any is applied
	 *
	 * @param variable
	 */
	public JsonVariable setVariable(Serializable variable)
	{
		this.variable = variable;
		return this;
	}
	
	/**
	 * Sets the owning component ID
	 *
	 * @return
	 */
	@Override
	public String getReferenceId()
	{
		return ownerId;
	}
	
	/**
	 * Gets the owning component ID
	 *
	 * @param referenceId
	 */
	@Override
	public void setReferenceId(String referenceId)
	{
		ownerId = referenceId;
	}
	
	/**
	 * @return
	 */
	@SuppressWarnings("Convert2Diamond")
	public Map<String, Object> asMap()
	{
		String variableText = getVariableText();
		TypeReference<HashMap<String, Object>> typeRef
				= new TypeReference<HashMap<String, Object>>()
		{
		};
		try
		{
			return GuiceContext.get(ObjectBinderKeys.DefaultObjectMapper)
			                   .readValue(variableText, typeRef);
		}
		catch (JsonProcessingException e)
		{
			return new HashMap<>();
		}
		
	}
	
	/**
	 * @return
	 */
	@SuppressWarnings("Convert2Diamond")
	public List<Map<String, Object>> asListMap()
	{
		String variableText = getVariableText();
		TypeReference<List<Map<String, Object>>> typeRef
				= new TypeReference<List<Map<String, Object>>>()
		{
		};
		try
		{
			return GuiceContext.get(ObjectBinderKeys.DefaultObjectMapper)
			                   .readValue(variableText, typeRef);
		}
		catch (JsonProcessingException e)
		{
			return new ArrayList<>();
		}
		
	}
	
	
	/**
	 * Returns the variable object in the format requested
	 *
	 * @param <T>       Generic type of JavaScript part
	 * @param classType
	 * @return
	 */
	public <T> T as(Class<T> classType)
	{
		try
		{
			T instance = GuiceContext.get(classType);
			return IJsonRepresentation.From(getVariableText(), classType);
		}
		catch (Exception e)
		{
			log.log(Level.WARNING, "Error in decoding Ajax Response Variable", e);
			return null;
		}
	}
	
	/**
	 * Gets a variable object or blank so it at least gets instantiated
	 *
	 * @return
	 */
	public String getVariableText()
	{
		return variableText;
	}
	
	/**
	 * Sets the variable name to a new object
	 *
	 * @param variableText
	 */
	public JsonVariable setVariableText(String variableText)
	{
		this.variableText = variableText;
		return this;
	}
	
	/**
	 * Returns the variable object in the format requested
	 *
	 * @param <T> Generic type of JavaScript part
	 * @return
	 */
	public <T> T update(T object)
	{
		try
		{
			ObjectMapper om = GuiceContext.get(ObjectMapper.class);
			om.readerForUpdating(object)
			  .readValue(getVariableText());
			return object;
		}
		catch (Exception e)
		{
			log.log(Level.WARNING, "Error in decoding Ajax Response Variable", e);
			return null;
		}
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}
		JsonVariable that = (JsonVariable) o;
		return Objects.equals(getVariableName(), that.getVariableName());
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(getVariableName());
	}
}
