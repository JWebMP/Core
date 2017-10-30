package za.co.mmagon.jwebswing.utilities;

import java.io.Serializable;

/**
 * Default set of strings
 */
public interface StaticStrings extends Serializable
{
	String REQUEST_SITE_HEADER_NAME = "jwsiteurl";

	String HTML_HEADER_JAVASCRIPT = "application/javascript";
	String HTML_HEADER_DEFAULT_CONTENT_TYPE = "text/html";

	String HTML_AMPERSAND = "&amp;";

	String STRING_EMPTY = "";
	String STRING_SPACE = " ";
	String STRING_TAB = "\t";
	String STRING_NEWLINE_TEXT = "\n";
	String STRING_SINGLE_QUOTES = "'";
	String STRING_DOUBLE_QUOTES = "\"";
	String STRING_DOUBLE_QUOTES_SPACE = "\" ";

	char CHAR_SPACE = ' ';

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


	String ACCESS_CONTROL_ALLOW_ORIGIN_HEADER_NAME = "Access-Control-Allow-Origin";
	String ACCESS_CONTROL_ALLOW_CREDENTIALS_HEADER_NAME = "Access-Control-Allow-Credentials";
	String ACCESS_CONTROL_ALLOW_METHODS_HEADER_NAME = "Access-Control-Allow-Methods";
	String ACCESS_CONTROL_ALLOW_HEADERS_HEADER_NAME = "Access-Control-Allow-Headers";
}
