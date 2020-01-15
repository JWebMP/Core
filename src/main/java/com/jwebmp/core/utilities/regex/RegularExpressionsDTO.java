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
package com.jwebmp.core.utilities.regex;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import com.guicedee.guicedinjection.GuiceContext;
import com.guicedee.logger.LogFactory;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.core.services.IRegularExpressions;

import java.util.*;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.*;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;

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
		extends JavaScriptPart<RegularExpressionsDTO>
{
	private static final Logger log = LogFactory.getLog("RegularExpressionDTO");


	/**
	 * Default regular expressions
	 */
	@JsonValue
	private Map<String, Object> regularExpressions;

	/**
	 * Constructs a new instance of the regular expression dto
	 */
	public RegularExpressionsDTO()
	{
		addDefaults();
	}

	/**
	 * Adds the text, alpha numeric and email field patterns to this dto
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public RegularExpressionsDTO addDefaults()
	{
		Map<String, Pattern> patterns = new LinkedHashMap<>();
		Set<IRegularExpressions> regess = GuiceContext.instance()
		                                              .getLoader(IRegularExpressions.class, ServiceLoader.load(IRegularExpressions.class));
		regess.forEach(regexConfig ->
		               {
			               RegularExpressionsDTO.log.finer("Regex Config Found [" + regexConfig.getClass()
			                                                                                   .getSimpleName() + "]");
			               patterns.putAll(regexConfig.addPatterns());
		               });
		for (Map.Entry<String, Pattern> entry : patterns.entrySet())
		{
			RegularExpressionsDTO.log.finer("Client RegEx [" + entry.getKey() + "] bound to registered pattern");
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
	public Map<String, Object> getRegularExpressions()
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
	public void setRegularExpressions(Map<String, Object> regularExpressions)
	{
		this.regularExpressions = regularExpressions;
	}

	@SuppressWarnings("ResultOfMethodCallIgnored")
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
