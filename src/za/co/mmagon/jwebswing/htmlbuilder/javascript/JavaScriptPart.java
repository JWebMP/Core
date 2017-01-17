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

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.co.mmagon.logger.LogFactory;

/**
 * Defines a section of a JavaScript part e.g. Position
 * <p>
 * @author mmagon
 *
 * @since 2014/07/09
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
@JsonInclude(Include.NON_NULL)
public class JavaScriptPart implements Serializable
{

    private static final Logger LOG = LogFactory.getInstance().getLogger("JavaScriptPart");
    /**
     * Version 2
     */
    private static final long serialVersionUID = 2L;
    /**
     * The Object Mapper for rendering the JavaScript with Jackson
     */
    private static final ObjectMapper javascriptObjectMapper = new ObjectMapper();
    /**
     * The Object Mapper for rendering the JSON with Jackson
     */
    private static final ObjectMapper jsonObjectMapper = new ObjectMapper();
    /**
     * The Object Mapper for rendering the Function Scripts with Jackson
     */
    private static final ObjectMapper functionObjectMapper = new ObjectMapper();

    /*
     * Pretty print config
     */
    static
    {
        javascriptObjectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        jsonObjectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        functionObjectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        javascriptObjectMapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
        jsonObjectMapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
        jsonObjectMapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);

        javascriptObjectMapper.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, true);
        jsonObjectMapper.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, true);
        functionObjectMapper.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, true);
    }

    @JsonProperty(value = "$jwid")
    private String ownerId;

    public JavaScriptPart()
    {
    }

    public String render()
    {
        return toString();
    }

    /**
     * Returns the section of string to be applied to the JavaScript part
     * <p>
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
                    s = javascriptObjectMapper.writeValueAsString(this);
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
                    s = jsonObjectMapper.writeValueAsString(this);
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
                    s = javascriptObjectMapper.writeValueAsString(this);
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
                    s = jsonObjectMapper.writeValueAsString(this);
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
     * @return
     */
    public JavascriptPartType getJavascriptType()
    {
        return JavascriptPartType.Javascript;
    }

    /**
     * Returns the JavaScript renderer
     *
     * @return
     */
    public static ObjectMapper getJavascriptObjectMapper()
    {
        return javascriptObjectMapper;
    }

    /**
     * Returns the JSON Renderer
     *
     * @return
     */
    public static ObjectMapper getJsonObjectMapper()
    {
        return jsonObjectMapper;
    }

    /**
     * Returns the raw function renderer
     *
     * @return
     */
    public static ObjectMapper getFunctionObjectMapper()
    {
        return functionObjectMapper;
    }

    /**
     * Returns the object presented as a JSON strong
     *
     * @param o
     *
     * @return
     */
    public static String objectAsString(Object o)
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
    public static <T> T From(InputStream file, Class<T> clazz) throws IOException
    {
        T out = jsonObjectMapper.readValue(file, clazz);
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
    public static <T> T From(File file, Class<T> clazz) throws IOException
    {
        T out = jsonObjectMapper.readValue(file, clazz);
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
    public static <T> T From(Reader file, Class<T> clazz) throws IOException
    {
        T out = jsonObjectMapper.readValue(file, clazz);
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
    public static <T> T From(String content, Class<T> clazz) throws IOException
    {
        T out = jsonObjectMapper.readValue(content, clazz);
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
    public static <T> T From(URL content, Class<T> clazz) throws IOException
    {
        T out = jsonObjectMapper.readValue(content, clazz);
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
    public static <T> List<T> FromToList(InputStream file, Class<T> clazz) throws IOException
    {
        T list = jsonObjectMapper.readValue(file, clazz);
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
    public static <T> List<T> FromToList(File file, Class<T> clazz) throws IOException
    {
        T list = jsonObjectMapper.readValue(file, clazz);
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
    public static <T> List<T> FromToList(Reader file, Class<T> clazz) throws IOException
    {
        T list = jsonObjectMapper.readValue(file, clazz);
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
    public static <T> List<T> FromToList(String content, Class<T> clazz) throws IOException
    {
        T list = jsonObjectMapper.readValue(content, clazz);
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
    public static <T> ArrayList<T> FromToList(URL content, Class<T> clazz) throws IOException
    {
        T list = jsonObjectMapper.readValue(content, clazz);
        ArrayList<T> lists = new ArrayList<>();
        lists.addAll(Arrays.asList((T[]) list));
        return lists;
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
