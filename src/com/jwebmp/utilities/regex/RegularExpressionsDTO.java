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
package com.jwebmp.utilities.regex;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import com.jwebmp.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.logger.LogFactory;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author GedMarc
 * @since 25 Jan 2017
 */
@JsonAutoDetect(fieldVisibility = PUBLIC_ONLY,
		getterVisibility = NONE,
		setterVisibility = NONE)
@JsonInclude(NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegularExpressionsDTO
		extends JavaScriptPart
{
	private static final Logger log = LogFactory.getLog("RegularExpressionDTO");
	private static final long serialVersionUID = 1L;


	/**
	 * Default regular expressions
	 */
	@JsonValue
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
		ServiceLoader<IRegularExpressions> regexConfigs = ServiceLoader.load(IRegularExpressions.class);
		Map<String, Pattern> patterns = new LinkedHashMap<>();
		for (IRegularExpressions regexConfig : regexConfigs)
		{
			log.finer("Regex Config Found [" + regexConfig.getClass()
			                                              .getSimpleName() + "]");
			patterns.putAll(regexConfig.addPatterns());
		}
		for (Map.Entry<String, Pattern> entry : patterns.entrySet())
		{
			log.finer("Client RegEx [" + entry.getKey() + "] bound to registered pattern");
			addExpression(entry.getKey(), entry.getValue()
			                                   .toString());
		}

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
	public Map<String, Serializable> getRegularExpressions()
	{
		if (regularExpressions == null)
		{
			setRegularExpressions(new HashMap<>());
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
