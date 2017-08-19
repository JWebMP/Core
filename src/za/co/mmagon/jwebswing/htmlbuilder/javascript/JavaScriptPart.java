/*
 * Copyright (C) 2014 mmagon
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
package za.co.mmagon.jwebswing.htmlbuilder.javascript;

import com.armineasy.injection.GuiceContext;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Key;
import com.google.inject.name.Names;
import za.co.mmagon.logger.LogFactory;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Defines a section of a JavaScript part e.g. Position
 * <p>
 *
 * @author mmagon
 * @since 2014/07/09
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
@JsonInclude(Include.NON_NULL)
public class JavaScriptPart<J extends JavaScriptPart<J>> implements Serializable
{
	
	private static final Logger LOG = LogFactory.getInstance().getLogger("JavaScriptPart");
	/**
	 * Version 2
	 */
	private static final long serialVersionUID = 2L;

	@JsonProperty(value = "$jwid")
	private String ownerId;
	
	public JavaScriptPart()
	{
	}
	
	/**
	 * Returns the JavaScript renderer
	 *
	 * @return
	 */
	public ObjectMapper getJavascriptObjectMapper()
	{
		return GuiceContext.getInstance(Key.get(ObjectMapper.class, Names.named("JS")));
	}
	
	/**
	 * Returns the JSON Renderer
	 *
	 * @return
	 */
	public ObjectMapper getJsonObjectMapper()
	{
		return GuiceContext.getInstance(Key.get(ObjectMapper.class, Names.named("JSON")));
	}
	
	/**
	 * Returns the raw function renderer
	 *
	 * @return
	 */
	public ObjectMapper getFunctionObjectMapper()
	{
		return GuiceContext.getInstance(Key.get(ObjectMapper.class, Names.named("JSFUNCTION")));
	}
	
	/**
	 * Returns the object presented as a JSON strong
	 *
	 * @param o
	 *
	 * @return
	 */
	public String objectAsString(Object o)
	{
		try
		{
			return getJsonObjectMapper().writeValueAsString(o).replaceAll("\r\n", "\n");
		}
		catch (JsonProcessingException ex)
		{
			LOG.log(Level.SEVERE, "Unable to Serialize as JSON", ex);
			return "";
		}
		catch (Exception ex)
		{
			LOG.log(Level.SEVERE, "Unable to Serialize as JSON", ex);
			return "";
		}
	}
	
	/**
	 * Read direct from the stream
	 *
	 * @param <T>
	 * @param file  the stream
	 * @param clazz
	 *
	 * @return
	 *
	 * @throws IOException
	 */
	public <T> T From(InputStream file, Class<T> clazz) throws IOException
	{
		T out = getJsonObjectMapper().readValue(file, clazz);
		return out;
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
		T out = getJsonObjectMapper().readValue(file, clazz);
		return out;
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
		T out = getJsonObjectMapper().readValue(file, clazz);
		return out;
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
		T out = getJsonObjectMapper().readValue(content, clazz);
		return out;
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
		T out = getJsonObjectMapper().readValue(content, clazz);
		return out;
	}
	
	/**
	 * Read direct from the stream
	 *
	 * @param <T>
	 * @param file  the stream
	 * @param clazz
	 *
	 * @return
	 *
	 * @throws IOException
	 */
	public <T> List<T> FromToList(InputStream file, Class<T> clazz) throws IOException
	{
		T list = getJsonObjectMapper().readValue(file, clazz);
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
		T list = getJsonObjectMapper().readValue(file, clazz);
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
		T list = getJsonObjectMapper().readValue(file, clazz);
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
		T list = getJsonObjectMapper().readValue(content, clazz);
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
	public <T> ArrayList<T> FromToList(URL content, Class<T> clazz) throws IOException
	{
		T list = getJsonObjectMapper().readValue(content, clazz);
		ArrayList<T> lists = new ArrayList<>();
		lists.addAll(Arrays.asList((T[]) list));
		return lists;
	}
	
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
					LOG.log(Level.FINE, "JSON Mapping Exception!", mapException);
				}
				catch (JsonProcessingException ex)
				{
					LOG.log(Level.SEVERE, "Error Writing as Javascript!", ex);
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
					LOG.log(Level.SEVERE, "Error Writing as JSON Data!", ex);
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
					LOG.log(Level.SEVERE, "Error Writing as Javascript Function!", ex);
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
					LOG.log(Level.SEVERE, "Error Writing as Default!", ex);
				}
				break;
			}
		}
		if (s != null)
		{
			if (s.equals("{ }"))
			{
				return "";
			}
		}
		else
		{
			return "";
		}
		
		s = s.replaceAll("\r\n", "\n");
		
		return s;
	}
	
	/**
	 * Set the render type
	 * <p>
	 *
	 * @return
	 */
	public JavascriptPartType getJavascriptType()
	{
		return JavascriptPartType.Javascript;
	}
	
	/**
	 * Sets the JW ID to send if necessary
	 *
	 * @return
	 */
	public String getOwnerId()
	{
		return ownerId;
	}
	
	/**
	 * Sets the JW ID to send if necessary
	 *
	 * @param ownerId
	 */
	public void setOwnerId(String ownerId)
	{
		this.ownerId = ownerId;
	}
	
}
