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
package za.co.mmagon.jwebswing.base.ajax;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.IOException;
import java.io.Serializable;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * DTO for angular variable transfers forward and back
 *
 * @author GedMarc
 * @since 08 May 2016
 */
public class AngularJsonVariable extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;

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
    private Serializable variable;
    /**
     * The owner id of this DTO
     */
    @JsonProperty(value = "$jwid")
    private String ownerId;

    /**
     * Constructs a blank object
     */
    public AngularJsonVariable()
    {
    }

    /**
     * Constructs a new instance with a given name and object
     *
     * @param variableName   The variable name to apply
     * @param variableObject The JSON object to use
     */
    public AngularJsonVariable(String variableName, String variableObject)
    {
        this.variableName = variableName;
        this.variableText = variableObject;
        this.variable = variableText;
    }

    /**
     * Constructs a new instance with a given name and object
     *
     * @param variableName   The variable name to apply
     * @param variableObject The JSON object to use
     */
    public AngularJsonVariable(String variableName, JavaScriptPart variableObject)
    {
        this.variableName = variableName;
        this.variable = variableObject;
    }

    /**
     * Gets the DTO Form of this object
     *
     * @param <T>       The type this object actually is
     * @param classType The class type to return
     *
     * @return The DTO direct from the call
     *
     * @throws IOException
     */
    public <T extends JavaScriptPart> T getDto(Class<T> classType) throws IOException
    {
        T output = JavaScriptPart.From(variableText, classType);
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
    public void setVariableText(String variableText)
    {
        this.variableText = variableText;
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
    public void setVariable(Serializable variable)
    {
        this.variable = variable;
    }

    /**
     * Sets the owning component ID
     *
     * @return
     */
    @Override
    public String getOwnerId()
    {
        return ownerId;
    }

    /**
     * Gets the owning component ID
     *
     * @param ownerId
     */
    @Override
    public void setOwnerId(String ownerId)
    {
        this.ownerId = ownerId;
    }

    /**
     * Returns the variable object in the format requested
     *
     * @param <T>       Generic type of JavaScript part
     * @param classType
     *
     * @return
     *
     * @throws IOException
     */
    public <T> T as(Class<T> classType) throws IOException
    {
        return JavaScriptPart.From(getVariableText(), classType);
    }

}
