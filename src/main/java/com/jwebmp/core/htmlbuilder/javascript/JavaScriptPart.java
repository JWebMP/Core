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
package com.jwebmp.core.htmlbuilder.javascript;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.common.base.CaseFormat;
import com.google.inject.Key;
import com.google.inject.name.Names;
import com.jwebmp.core.FileTemplates;
import com.guicedee.guicedinjection.json.StaticStrings;
import com.guicedee.guicedinjection.GuiceContext;
import com.guicedee.logger.LogFactory;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.jwebmp.core.FileTemplates.*;
import static com.guicedee.guicedinjection.interfaces.ObjectBinderKeys.*;

/**
 * Defines a section of a JavaScript part e.g. Position
 * <p>
 *
 * @author mmagon
 * @since 2014/07/09
 */
@SuppressWarnings({"MissingClassJavaDoc", "unused", "unchecked"})
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class JavaScriptPart<J extends JavaScriptPart<J>>
		implements Serializable
{

	/**
	 * The logger
	 */
	private static final Logger log = LogFactory.getInstance()
	                                            .getLogger("JavaScriptPart");
	/**
	 * A reference id that can be returned with a given variable
	 */
	private String referenceId;
	/**
	 * if empty braces should be rendered
	 */
	private boolean renderEmptyBraces = false;

	/**
	 * Constructs a new javascript part
	 */
	public JavaScriptPart()
	{
		//No configuration needed
	}

	/**
	 * Returns the object presented as a JSON strong
	 *
	 * @param o
	 * 		An object to represent
	 *
	 * @return the string
	 */
	public String objectAsString(Object o)
	{
			try
			{
				if (GuiceContext.buildingInjector)
				{
					return new ObjectMapper().writeValueAsString(o)
					                         .replace("\r\n", "\n");
				}
				ObjectWriter writer = GuiceContext.get(JSONObjectWriter);
				return writer.writeValueAsString(o)
				             .replace("\r\n", "\n");
			}
			catch (JsonProcessingException ex)
			{
				JavaScriptPart.log.log(Level.FINER, "Unable to Serialize as JSON Json Processing Exception", ex);
				return "";
			}
			catch (Exception ex)
			{
				JavaScriptPart.log.log(Level.SEVERE, "Unable to Serialize as JSON", ex);
				return "";
			}

	}

	/**
	 * Read direct from the stream
	 *
	 * @param <T>
	 * @param file
	 * 		the stream
	 * @param clazz
	 *
	 * @return
	 *
	 * @throws IOException
	 */
	public <T> T From(InputStream file, Class<T> clazz) throws IOException
	{
		return getJsonObjectReader().forType(clazz)
		                            .readValue(file);
	}

	/**
	 * Returns the JSON Renderer
	 *
	 * @return
	 */
	@JsonIgnore
	public ObjectReader getJsonObjectReader()
	{
		return GuiceContext.get(JSONObjectReader);
	}

	/**
	 * Returns the raw function renderer
	 *
	 * @return
	 */
	@JsonIgnore
	public ObjectMapper getFunctionObjectMapper()
	{
		return GuiceContext.get(Key.get(ObjectMapper.class, Names.named("JSFUNCTION")));
	}

	/**
	 * Read from a file
	 *
	 * @param <T>
	 * @param file
	 * @param clazz
	 *
	 * @return
	 *
	 * @throws IOException
	 */
	public <T> T From(File file, Class<T> clazz) throws IOException
	{
		return getJsonObjectReader().forType(clazz)
		                            .readValue(file);
	}

	/**
	 * Read from a reader
	 *
	 * @param <T>
	 * @param file
	 * @param clazz
	 *
	 * @return
	 *
	 * @throws IOException
	 */
	public <T> T From(Reader file, Class<T> clazz) throws IOException
	{
		return getJsonObjectReader().forType(clazz)
		                            .readValue(file);
	}

	/**
	 * Read from a content string
	 *
	 * @param <T>
	 * @param content
	 * @param clazz
	 *
	 * @return
	 *
	 * @throws IOException
	 */
	public <T> T From(String content, Class<T> clazz) throws IOException
	{
		return getJsonObjectReader().forType(clazz)
		                            .readValue(content);
	}

	/**
	 * Read from a URL
	 *
	 * @param <T>
	 * @param content
	 * @param clazz
	 *
	 * @return
	 *
	 * @throws IOException
	 */
	public <T> T From(URL content, Class<T> clazz) throws IOException
	{
		return getJsonObjectReader().forType(clazz)
		                            .readValue(content);
	}

	/**
	 * Read direct from the stream
	 *
	 * @param <T>
	 * @param file
	 * 		the stream
	 * @param clazz
	 *
	 * @return
	 *
	 * @throws IOException
	 */
	public <T> List<T> FromToList(InputStream file, Class<T> clazz) throws IOException
	{
		T list = getJsonObjectReader().forType(clazz)
		                              .readValue(file);
		ArrayList<T> lists = new ArrayList<>();
		lists.addAll(Arrays.asList((T[]) list));
		return lists;
	}

	/**
	 * Read from a URL
	 *
	 * @param <T>
	 * @param content
	 * @param clazz
	 *
	 * @return
	 *
	 * @throws IOException
	 */
	public <T> List<T> FromToList(URL content, Class<T> clazz) throws IOException
	{
		T list = getJsonObjectReader().forType(clazz)
		                              .readValue(content);
		ArrayList<T> lists = new ArrayList<>();
		lists.addAll(Arrays.asList((T[]) list));
		return lists;
	}

	/**
	 * Read from a file
	 *
	 * @param <T>
	 * @param file
	 * @param clazz
	 *
	 * @return
	 *
	 * @throws IOException
	 */
	public <T> List<T> FromToList(File file, Class<T> clazz) throws IOException
	{
		T list = getJsonObjectReader().forType(clazz)
		                              .readValue(file);
		ArrayList<T> lists = new ArrayList<>();
		lists.addAll(Arrays.asList((T[]) list));
		return lists;
	}

	/**
	 * Read from a reader
	 *
	 * @param <T>
	 * @param file
	 * @param clazz
	 *
	 * @return
	 *
	 * @throws IOException
	 */
	public <T> List<T> FromToList(Reader file, Class<T> clazz) throws IOException
	{
		T list = getJsonObjectReader().forType(clazz)
		                              .readValue(file);
		ArrayList<T> lists = new ArrayList<>();
		lists.addAll(Arrays.asList((T[]) list));
		return lists;
	}

	/**
	 * Read from a content string
	 *
	 * @param <T>
	 * @param content
	 * @param clazz
	 *
	 * @return
	 *
	 * @throws IOException
	 */
	public <T> List<T> FromToList(String content, Class<T> clazz) throws IOException
	{
		T list = getJsonObjectReader().forType(clazz)
		                              .readValue(content);
		ArrayList<T> lists = new ArrayList<>();
		lists.addAll(Arrays.asList((T[]) list));
		return lists;
	}

	/**
	 * Method render ...
	 *
	 * @return String
	 */
	public String render()
	{
		return toString();
	}

	/**
	 * Returns the section of string to be applied to the JavaScript part
	 * <p>
	 *
	 * @return The string to be added to the JavaScript
	 */
	@Override
	@JsonIgnore
	public String toString()
	{
		String s = null;
		switch (getJavascriptType())
		{
			case Javascript:
			{
				try
				{
					s = getJavascriptObjectMapper().writeValueAsString(this);
				}
				catch (com.fasterxml.jackson.databind.JsonMappingException mapException)
				{
					JavaScriptPart.log.log(Level.SEVERE, "JSON Mapping Exception!", mapException);
				}
				catch (JsonProcessingException ex)
				{
					JavaScriptPart.log.log(Level.SEVERE, "Error Writing as Javascript!", ex);
				}
				break;
			}
			case JSON:
			{
				try
				{
					s = getJsonObjectMapper().writeValueAsString(this);
				}
				catch (JsonProcessingException ex)
				{
					JavaScriptPart.log.log(Level.SEVERE, "Error Writing as JSON Data!", ex);
				}
				break;
			}
			case Function:
			{
				try
				{
					s = getJavascriptObjectMapper().writeValueAsString(this);
				}
				catch (JsonProcessingException ex)
				{
					JavaScriptPart.log.log(Level.SEVERE, "Error Writing as Javascript Function!", ex);
				}
				break;
			}
			default:
			{
				try
				{
					s = getJsonObjectMapper().writeValueAsString(this);
				}
				catch (JsonProcessingException ex)
				{
					JavaScriptPart.log.log(Level.SEVERE, "Error Writing as Default!", ex);
				}
				break;
			}
		}
		if (s != null)
		{
			if ("{ }".equals(s) && !isRenderEmptyBraces())
			{
				return "";
			}
		}
		else
		{
			return "";
		}
		return s.replace("\r\n", "\n");
	}

	/**
	 * Set the render type
	 * <p>
	 *
	 * @return
	 */
	@JsonIgnore
	public JavascriptPartType getJavascriptType()
	{
		return JavascriptPartType.Javascript;
	}

	/**
	 * Returns the JavaScript renderer
	 *
	 * @return
	 */
	@JsonIgnore
	public ObjectWriter getJavascriptObjectMapper()
	{
		try
		{
			return GuiceContext.get(JSONObjectWriter);
		}
		catch (NullPointerException e)
		{
			JavaScriptPart.log.log(Level.SEVERE, "Cant find javascript object mapper, returning default", e);
			return null;
		}
	}

	/**
	 * Returns the JSON Renderer
	 *
	 * @return
	 */
	@JsonIgnore
	public ObjectWriter getJsonObjectMapper()
	{
		return GuiceContext.get(Key.get(ObjectWriter.class, Names.named("JSON")));
	}

	/**
	 * Method isRenderEmptyBraces returns the renderEmptyBraces of this JavaScriptPart object.
	 * <p>
	 * if empty braces should be rendered
	 *
	 * @return the renderEmptyBraces (type boolean) of this JavaScriptPart object.
	 */
	@JsonIgnore
	public boolean isRenderEmptyBraces()
	{
		return renderEmptyBraces;
	}

	/**
	 * If this part should render when its just empty braces
	 *
	 * @param renderEmptyBraces
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@JsonIgnore
	public J setRenderEmptyBraces(boolean renderEmptyBraces)
	{
		this.renderEmptyBraces = renderEmptyBraces;
		return (J) this;
	}

	@JsonIgnore
	public ObjectReader getJavascriptObjectReader()
	{
		try
		{
			return GuiceContext.get(JSONObjectReader);
		}
		catch (NullPointerException e)
		{
			JavaScriptPart.log.log(Level.SEVERE, "Cant find javascript object mapper, returning default", e);
			return null;
		}
	}

	/**
	 * Renders the fields (getDeclaredFields()) as a map of html attributes
	 *
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Map<String, String> toAttributes()
	{
		Map<String, String> map = new LinkedHashMap<>();

		Field[] fields = getClass().getDeclaredFields();
		for (Field field : fields)
		{
			if (Modifier.isFinal(field.getModifiers()) || Modifier.isStatic(field.getModifiers()))
			{
				continue;
			}
			field.setAccessible(true);
			try
			{
				Object result = field.get(this);
				if (result != null)
				{
					if (JavaScriptPart.class.isAssignableFrom(result.getClass()))
					{
						map.put(CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_HYPHEN, field.getName()), ((JavaScriptPart) result)
								                                                                             .toString(true));
					}
					else
					{
						map.put(CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_HYPHEN, field.getName()), result.toString());
					}
				}
			}
			catch (Exception e)
			{
				JavaScriptPart.log.log(Level.WARNING, "Cant format as attributes", e);
			}
		}
		return map;
	}

	/**
	 * Renders the output in tiny format
	 *
	 * @param tiny
	 *
	 * @return
	 */
	@JsonIgnore
	public String toString(@SuppressWarnings("unused") boolean tiny)
	{
		String output = null;
		try
		{
			output = GuiceContext.get(JSONObjectWriterTiny)
			                     .writeValueAsString(this);
		}
		catch (Exception e)
		{
			JavaScriptPart.log.log(Level.WARNING, "Cant render tiny", e);
		}
		return output;
	}

	/**
	 * Sets the JW ID to send if necessary
	 *
	 * @return
	 */
	@JsonProperty(value = "$jwid")
	public String getReferenceId()
	{
		return referenceId;
	}

	/**
	 * Sets the JW ID to send if necessary
	 *
	 * @param referenceId
	 */
	@JsonProperty(value = "$jwid")
	public void setReferenceId(String referenceId)
	{
		this.referenceId = referenceId;
	}

	/**
	 * Method isConfigured returns the configured of this JavaScriptPart object.
	 *
	 * @return the configured (type boolean) of this JavaScriptPart object.
	 */
	@JsonIgnore
	public boolean isConfigured()
	{
		return true;
	}

	/**
	 * Method isInitialized returns the initialized of this JavaScriptPart object.
	 *
	 * @return the initialized (type boolean) of this JavaScriptPart object.
	 */
	@JsonIgnore
	public boolean isInitialized()
	{
		return true;
	}

	/**
	 * Method init ...
	 */
	public void init()
	{
		//No configuration needed
	}

	/**
	 * Method preConfigure ...
	 */
	public void preConfigure()
	{
		//No configuration needed
	}

	/**
	 * Method destroy ...
	 */
	public void destroy()
	{
		//No configuration needed
	}
}
