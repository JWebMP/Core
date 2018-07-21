package com.jwebmp.core.utilities.regex;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class TextRegExPatterns
		implements IRegularExpressions
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

	/*
	 * Only 2 spaces or more no new lines
	 */
	public static final String WhiteSpacesNoNewLines = "[^\\S\\x0a\\x0d]{2,}";

	@Override
	public Map<String, Pattern> addPatterns()
	{
		Map<String, Pattern> patternMap = new LinkedHashMap<>();

		patternMap.put("textField", Pattern.compile(TextOnlyField));
		patternMap.put("textFieldMin3", Pattern.compile(TextFieldMin3));
		patternMap.put("alphaNumericField", Pattern.compile(AlphaNumericField));
		patternMap.put("alphaNumericFieldMin3", Pattern.compile(AlphaNumericFieldMin3));
		patternMap.put("textFieldMin3Words", Pattern.compile(TextFieldMin3Words));
		patternMap.put("whiteSpacesNoNewLines", Pattern.compile(WhiteSpacesNoNewLines));

		return patternMap;
	}

}
