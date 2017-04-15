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
package za.co.mmagon.jwebswing.base.dto;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 *
 * @author GedMarc
 * @since 25 Jan 2017
 *
 */
public class RegularExpressionsDTO extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;
    /**
     * Forces only text at least one character
     */
    public static final String TextOnlyField = "([a-zA-Z ]){1,}";
    /**
     * Forces only characters and numbers
     */
    public static final String AlphaNumericField = "(?=.*[a-zA-Z])([a-zA-Z0-9 ]){1,}";
    /**
     * Text only minimum of 3 characters
     */
    public static final String TextFieldMin3 = "([a-zA-Z ]){3,}";
    /**
     * Alpha Numeric minimum of 3 characters
     */
    public static final String AlphaNumericFieldMin3 = "(?=.*[a-zA-Z])([a-zA-Z0-9 ]){1,}";
    /**
     * Text Field only minimum 3 WORDS
     */
    public static final String TextFieldMin3Words = "(?=.*[a-zA-Z])(\\b\\w+\\b\\s?){3,}";
    /**
     * Global standard for email recognition
     */
    public static final String EmailPattern = "(?:[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-zA-Z0-9-]*[a-zA-Z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

    /*
     * Only 2 spaces or more no new lines
     */
    public static final String WhiteSpacesNoNewLines = "[^\\S\\x0a\\x0d]{2,}";

    /**
     * Default regular expressions
     */
    private Map<String, Object> regularExpressions;

    /**
     * Constructs a new instance of the regular expression dto
     */
    public RegularExpressionsDTO()
    {
        //Nothing needed
    }

    /**
     *
     * @param name
     * @param expression
     *
     * @return
     */
    public RegularExpressionsDTO addExpression(String name, String expression)
    {
        getRegularExpressions().put(name, expression);
        return this;
    }

    /**
     * Adds the text, alpha numeric and email field patterns to this dto
     *
     * @return
     */
    public RegularExpressionsDTO addDefaults()
    {
        addExpression("textField", TextOnlyField);
        addExpression("textFieldMin3", TextFieldMin3);
        addExpression("alphaNumericField", AlphaNumericField);
        addExpression("emailField", EmailPattern);
        return this;
    }

    /**
     * Returns the regular expression map
     *
     * @return
     */
    @JsonValue
    public Map<String, Object> getRegularExpressions()
    {
        if (regularExpressions == null)
        {
            setRegularExpressions(new HashMap());
        }
        return regularExpressions;
    }

    /**
     * Reset the variable expressions
     *
     * @param regularExpressions
     */
    public void setRegularExpressions(Map<String, Object> regularExpressions)
    {
        this.regularExpressions = regularExpressions;
    }

}
