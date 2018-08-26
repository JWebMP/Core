package com.jwebmp.core.utilities.regex;

import com.jwebmp.core.services.IRegularExpressions;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class EmailAddressRegExPatterns
		implements IRegularExpressions
{
	/**
	 * Global standard for email recognition
	 */
	public static final String EmailPattern = "(?:[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-zA-Z0-9-]*[a-zA-Z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

	@Override
	public Map<String, Pattern> addPatterns()
	{
		Map<String, Pattern> patternMap = new LinkedHashMap<>();

		patternMap.put("emailField", Pattern.compile(EmailAddressRegExPatterns.EmailPattern));
		patternMap.put("email", Pattern.compile(EmailAddressRegExPatterns.EmailPattern));

		return patternMap;
	}

}
