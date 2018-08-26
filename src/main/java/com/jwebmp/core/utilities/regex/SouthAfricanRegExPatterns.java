package com.jwebmp.core.utilities.regex;

import com.jwebmp.core.services.IRegularExpressions;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class SouthAfricanRegExPatterns
		implements IRegularExpressions
{
	public static final String SouthAfricanIDNumber = "(((\\d{2}((0[13578]|1[02])(0[1-9]|[12]\\d|3[01])|(0[13456789]|1[012])(0[1-9]|[12]\\d|30)|02(0[1-9]|1\\d|2[0-8])))|([02468][048]|[13579][26])0229))(( |-)(\\d{4})( |-)(\\d{3})|(\\d{7}))";
	public static final String SouthAfricanPhoneNumber = "(\\\\+[0..9]{2})?0(6|7|8){1}[0-9]{1}[0-9]{7}";

	@Override
	public Map<String, Pattern> addPatterns()
	{
		Map<String, Pattern> patternMap = new LinkedHashMap<>();
		patternMap.put("saID", Pattern.compile(SouthAfricanRegExPatterns.SouthAfricanIDNumber));
		patternMap.put("saPhoneNumber", Pattern.compile(SouthAfricanRegExPatterns.SouthAfricanPhoneNumber));
		return patternMap;
	}

}
