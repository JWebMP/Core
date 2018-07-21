package com.jwebmp.core.utilities.regex;

import java.io.Serializable;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Marks default regular expressions to add to the DTO, used with a Service Locator
 */
@FunctionalInterface
public interface IRegularExpressions
		extends Serializable
{
	/**
	 * Returns a map of patterns to add
	 *
	 * @return
	 */
	Map<String, Pattern> addPatterns();
}
