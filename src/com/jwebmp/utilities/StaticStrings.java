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

package com.jwebmp.utilities;

import java.io.Serializable;
import java.nio.charset.Charset;

/**
 * Default set of strings
 */
public interface StaticStrings
		extends Serializable
{
	String REQUEST_SITE_HEADER_NAME = "jwsiteurl";

	String HTML_HEADER_JSON = "text/json";
	String HTML_HEADER_JAVASCRIPT = "application/javascript";
	String HTML_HEADER_CSS = "text/css";
	String HTML_HEADER_DEFAULT_CONTENT_TYPE = "text/html";

	String UTF8 = "UTF-8";
	Charset UTF8_CHARSET = Charset.forName("UTF-8");

	String STRING_EMPTY = "";
	String STRING_SPACE = " ";
	String STRING_FORWARD_SLASH = "/";
	String STRING_BACK_SLASH = "\\";
	String STRING_TAB = "\t";
	String STRING_DOLLAR = "$";
	String STRING_EQUALS = "=";
	String STRING_NEWLINE_TEXT = "\n";
	String STRING_DOUBLE_COLON = ":";
	String STRING_SINGLE_QUOTES = "'";
	String STRING_DOUBLE_QUOTES = "\"";
	String STRING_SINGLE_QUOTES_SPACE = "\' ";
	String STRING_DOUBLE_QUOTES_SPACE = "\" ";
	String STRING_EQUALS_SINGLE_QUOTES = "=\'";
	String STRING_EQUALS_DOUBLE_QUOTES = "=\"";
	String STRING_SHARP_BRACE_OPEN = "<";
	String STRING_SHARP_BRACE_SLASH_OPEN = "</";
	String STRING_SQUARE_BRACE_OPEN = "[";
	String STRING_SQUARE_BRACE_CLOSED = "]";
	String STRING_SHARP_BRACE_CLOSED = ">";
	String STRING_HASH = "#";
	String STRING_DASH = "-";
	String STRING_COMMNA = ",";
	String STRING_DOT = ".";
	String STRING_SEMICOLON = ";";
	String STRING_BRACES_OPEN = "{";
	String STRING_BRACES_CLOSE = "}";

	String STRING_CLOSING_BRACKET_SEMICOLON = ");";

	String STRING_ANGULAR_EVENT_START = "jwCntrl.perform($event,";
	String STRING_ANGULAR_EVENT_START_SHORT = "perform($event,";

	char CHAR_SPACE = ' ';
	char CHAR_DOT = '.';
	char CHAR_EQUALS = '=';
	char CHAR_UNDERSCORE = '_';
	char CHAR_DOLLAR = '$';
	char CHAR_DASH = '-';
	char CHAR_QUESTIONMARK = '?';
	char CHAR_SLASH = '/';
	char CHAR_BACKSLASH = '\\';
	char CHAR_HASH = '#';
	char CHAR_PLUS = '+';

	String JAVASCRIPT_LOCATION = "/jwjs";
	String AJAX_SCRIPT_LOCATION = "/jwajax";
	String CSS_LOCATION = "/jwcss";
	String ANGULAR_DATA_LOCATION = "/jwad";
	String ANGULAR_SCRIPT_LOCATION = "/jwas";
	String JW_SCRIPT_LOCATION = "/jwscr";
	String DATA_LOCATION = "/jwdata";

	/**
	 * A default regex to identify query parameters
	 */
	String QUERY_PARAMETERS_REGEX = "(\\?.*)?";

	String LOCAL_STORAGE_PARAMETER_KEY = "jwamsmk";
	String LOCAL_STORAGE_VARIABLE_KEY = "jwCntrl.jw.localstorage";

	String ACCESS_CONTROL_ALLOW_ORIGIN_HEADER_NAME = "Access-Control-Allow-Origin";
	String ACCESS_CONTROL_ALLOW_CREDENTIALS_HEADER_NAME = "Access-Control-Allow-Credentials";
	String ACCESS_CONTROL_ALLOW_METHODS_HEADER_NAME = "Access-Control-Allow-Methods";
	String ACCESS_CONTROL_ALLOW_HEADERS_HEADER_NAME = "Access-Control-Allow-Headers";

	String DEFAULT_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

	String STRING_SELECTED = "selected";

	/**
	 * The &times; string
	 */
	String HTML_TIMES = "&times;";
	/**
	 * The &nbsp; string
	 */
	String HTML_TAB = "&nbsp;";
	String HTML_AMPERSAND = "&amp;";
	/**
	 * Default text for Latin
	 */
	String ShortLatin = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...";
	/**
	 * Default Medium text for Latin
	 */
	String MediumLatin = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Libero laboriosam dolor perspiciatis omnis " +
	                     "exercitationem. Beatae, officia pariatur? Est cum veniam excepturi. Maiores praesentium, porro voluptas" +
	                     " dicta, " +
	                     "debitis...";

	String LocalStorageSessionAttributeKey = "LocalStorage";
	String SessionStorageSessionAttributeKey = "SessionStorage";

}
