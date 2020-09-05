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

package com.jwebmp.core.utilities;

import java.io.Serializable;
import java.nio.charset.Charset;

/**
 * Default set of strings
 */
@SuppressWarnings("MissingFieldJavaDoc")
public interface StaticStrings
		extends Serializable
{
	String REQUEST_SITE_HEADER_NAME = "jwsiteurl";

	String HTML_HEADER_JSON = "text/json";
	String HTML_HEADER_JAVASCRIPT = "application/javascript";
	String HTML_HEADER_CSS = "text/css";
	String HTML_HEADER_DEFAULT_CONTENT_TYPE = "text/html";

	String STRING_ANGULAR_EVENT_START = "jwCntrl.perform($event,";
	String STRING_ANGULAR_EVENT_START_SHORT = "perform($event,";

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
	String NOT_WEB_SOCKETS = "(?!wssocket)";

	String SESSION_STORAGE_TAB_KEY = "sessionkey";
	String SESSION_STORAGE_PARAMETER_KEY = "sessionid";
	String LOCAL_STORAGE_PARAMETER_KEY = "jwamsmk";
	String LOCAL_STORAGE_VARIABLE_KEY = "jwCntrl.jw.localstorage";
	String SESSION_STORAGE_VARIABLE_KEY = "jwCntrl.jw.sessionstorage";
	String LocalStorageSessionAttributeKey = "LocalStorage";
	String SessionStorageSessionAttributeKey = "SessionStorage";

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
}
