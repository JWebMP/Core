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
package za.co.mmagon.jwebswing.utilities;

import com.fasterxml.jackson.annotation.JsonValue;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author GedMarc
 * @since 25 Jan 2017
 */
public class RegularExpressionsDTO
		extends JavaScriptPart
{

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
	public static final String AlphaNumericFieldMin3 = "(?=.*[a-zA-Z])([a-zA-Z0-9 ]){3,}";
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
	public static final String SouthAfricanIDNumber = "(((\\d{2}((0[13578]|1[02])(0[1-9]|[12]\\d|3[01])|(0[13456789]|1[012])(0[1-9]|[12]\\d|30)|02(0[1-9]|1\\d|2[0-8])))|([02468][048]|[13579][26])0229))(( |-)(\\d{4})( |-)(\\d{3})|(\\d{7}))";
	public static final String SouthAfricanPhoneNumber = "(\\\\+[0..9]{2})?0(6|7|8){1}[0-9]{1}[0-9]{7}";
	public static final String yyyy_MM_dd = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";
	private static final long serialVersionUID = 1L;
	/**
	 * Default regular expressions
	 */
	private Map<String, Serializable> regularExpressions;


	/**
	 * Constructs a new instance of the regular expression dto
	 */
	public RegularExpressionsDTO()
	{
		//Nothing needed
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
		addExpression("email", EmailPattern);
		addExpression("saID", SouthAfricanIDNumber);
		addExpression("saPhoneNumber", SouthAfricanPhoneNumber);
		addExpression("yyyy_MM_dd", yyyy_MM_dd);
		return this;
	}

	/**
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
	 * Returns the regular expression map
	 *
	 * @return
	 */
	@JsonValue
	public Map<String, Serializable> getRegularExpressions()
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
	public void setRegularExpressions(Map<String, Serializable> regularExpressions)
	{
		this.regularExpressions = regularExpressions;
	}

	public RegularExpressionsDTO addPasswordRegex(int minLength, boolean specialChars, boolean numbers, boolean lowerCase, boolean upperCase)
	{
		String pattern = "" + (specialChars ? "(?=.*[$@!%^&*()])" : "") + (numbers ? "(?=.*[0-9])" : "") + (lowerCase ? "(?=.*[a-z])" : "") + (upperCase
		                                                                                                                                       ? "(?=.*[A-Z])"
		                                                                                                                                       : "") + ".{" + minLength + ",}";
		Pattern.compile(pattern);
		addExpression("password", pattern);
		return this;
	}
}
