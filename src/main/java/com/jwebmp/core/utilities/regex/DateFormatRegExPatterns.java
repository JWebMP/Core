package com.jwebmp.core.utilities.regex;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class DateFormatRegExPatterns
		implements IRegularExpressions
{
	/**
	 * yyyy-MM-dd
	 */
	public static final String yyyy_MM_dd = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";

	@Override
	public Map<String, Pattern> addPatterns()
	{
		Map<String, Pattern> patternMap = new LinkedHashMap<>();
		patternMap.put("date_yyyy_MM_dd", Pattern.compile(yyyy_MM_dd));
		return patternMap;
	}

}
