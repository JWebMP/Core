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
package com.jwebmp.core.utilities;

import org.apache.commons.text.StringEscapeUtils;

import javax.validation.constraints.NotNull;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Convenience methods for escaping special characters related to HTML, XML, and regular expressions.
 * <p>
 * <p>
 */
public class EscapeChars
{

	private static final Pattern SCRIPT = Pattern.compile("<SCRIPT>", Pattern.CASE_INSENSITIVE);
	private static final Pattern SCRIPT_END = Pattern.compile("</SCRIPT>", Pattern.CASE_INSENSITIVE);

	private static final Character[] EscapeRegexCharsetRaw = new Character[]{StaticStrings.CHAR_DOT, '\\', '?', '*', '+', '&', ':', '{', '}', '[', ']', '(', ')', '^', '$'};
	private static final List<Character> EscapeRegexCharset = Arrays.asList(EscapeChars.EscapeRegexCharsetRaw);

	/**
	 * Static only
	 */
	private EscapeChars()
	{
		//empty - prevent construction
	}

	/**
	 * Escape characters for text appearing in HTML markup.
	 * <p>
	 * &lt;P&gt;This method exists as a defence against Cross Site Scripting (XSS) hacks. The idea is to neutralize control characters commonly used by scripts, such that they will
	 * not be executed by
	 * the browser. This is done by replacing the control characters with their escaped equivalents. See {link hirondelle.web4j.security.SafeText} as well.
	 *
	 * @param input
	 *
	 * @return
	 */
	public static String forHTML(String input)
	{
		return StringEscapeUtils.escapeHtml4(input);
	}

	/**
	 * Escape all ampersand characters in a URL.
	 *
	 * @param input
	 *
	 * @return
	 */
	public static String forHrefAmpersand(String input)
	{
		return input.replace("&", StaticStrings.HTML_AMPERSAND);
	}

	/**
	 * Formats as UTF-8
	 *
	 * @param aURLFragment
	 *
	 * @return
	 *
	 * @throws java.io.UnsupportedEncodingException
	 */
	@NotNull
	public static String forURL(String aURLFragment) throws UnsupportedEncodingException
	{
		String result = "";
		try
		{
			result = URLEncoder.encode(aURLFragment, "UTF-8");
		}
		catch (UnsupportedEncodingException ex)
		{
			throw ex;
		}
		return result;
	}

	/**
	 * Escape characters for text appearing as XML data, between tags.
	 *
	 * @param aText
	 *
	 * @return
	 */
	public static String forXML(String aText)
	{
		return StringEscapeUtils.escapeXml11(aText);
	}

	/**
	 * Escapes characters for text appearing as data in the
	 *
	 * @param input
	 *
	 * @return
	 */
	public static String forJSON(String input)
	{
		return StringEscapeUtils.escapeJson(input);
	}

	/**
	 * Returns opening and closing tags replaced with the HTML Equivalents replaced by their escaped equivalents.
	 *
	 * @param aText
	 *
	 * @return
	 */
	public static String disableTags(String aText)
	{
		StringBuilder result = new StringBuilder();
		StringCharacterIterator iterator = new StringCharacterIterator(aText);
		char character = iterator.current();
		while (character != CharacterIterator.DONE)
		{
			switch (character)
			{
				case '<':
					result.append("&lt;");
					break;
				case '>':
					result.append("&gt;");
					break;
				default:
					//the char is not a special one
					//add it to the result as is
					result.append(character);
					break;
			}
			character = iterator.next();
		}
		return result.toString();
	}

	/**
	 * Replace characters having special meaning in regular expressions with their escaped equivalents, preceded by a '\' character.
	 *
	 * @param aRegexFragment
	 *
	 * @return
	 */
	public static String forRegex(String aRegexFragment)
	{
		StringBuilder result = new StringBuilder();
		StringCharacterIterator iterator = new StringCharacterIterator(aRegexFragment);
		char character = iterator.current();
		while (character != CharacterIterator.DONE)
		{
			if (EscapeChars.EscapeRegexCharset.contains(character))
			{
				result.append('\\' + character);
			}
			else
			{
				result.append(character);
			}
			character = iterator.next();
		}
		return result.toString();
	}

	/**
	 * Escape <tt>'$'</tt> and <tt>'\'</tt> characters in replacement strings.
	 *
	 * @param input
	 *
	 * @return
	 */
	public static String forReplacementString(String input)
	{
		return Matcher.quoteReplacement(input);
	}

	/**
	 * Disable all script tags
	 *
	 * @param aText
	 *
	 * @return
	 */
	public static String forScriptTagsOnly(String aText)
	{
		String result;
		Matcher matcher = EscapeChars.SCRIPT.matcher(aText);
		result = matcher.replaceAll("&gt;SCRIPT&lt;");
		matcher = EscapeChars.SCRIPT_END.matcher(result);
		result = matcher.replaceAll("&gt;/SCRIPT&lt;");
		return result;
	}

	/**
	 * Adds padding to string builder
	 *
	 * @param index
	 * @param stringBuilder
	 */
	public static void addCharEntity(Integer index, StringBuilder stringBuilder)
	{
		String padding = "";
		if (index <= 9)
		{
			padding = "00";
		}
		else if (index <= 99)
		{
			padding = "0";
		}
		else
		{
			//no prefix
		}
		String number = padding + index.toString();
		stringBuilder.append("&#")
		             .append(number)
		             .append(";");
	}
}
