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
package za.co.mmagon.jwebswing.base.client;

/**
 * Describes valid IE Compatibility Mode Settings. Damn I.E. to Heck
 * <p>
 * Just use edge if it is a problem, otherwise you have to actually set the
 * DocType to something not HTML5
 * <p>
 * http://msdn.microsoft.com/en-us/library/ff955275%28v=vs.85%29.aspx
 * <p>
 * 2.1.2.4 X-UA-Compatibility Meta Tag and HTTP Response Header
 * <p>
 * Web developers can also specify a document mode by including instructions in
 * a meta element or HTTP response header:
 * <p>
 * Webpages that include a meta element (see [HTML]) with an http-equivalent
 * value of X-UA-Compatible.
 * <p>
 * Webpages that are served with an HTTP header named "X-UA-Compatible".
 * <p>
 * If both of these instructions are sent, the developer's preference (meta
 * element) takes precedence over the web server setting (HTTP header).
 * <p>
 * For more information about how to control default rendering with document
 * modes, see "META Tags and Locking in Future Compatibility" at
 * [MSDN-METATagsLocking].
 * <p>
 * The X-UA-Compatible value determines Windows Internet Explorer’s document as
 * follows:.
 *
 * @author MMagon
 * @since 24 Jun 2013
 * @version 1.0
 */
public enum InternetExplorerCompatibilityMode
{

    /**
     * Quirks mode
     */
    IE5("IE=5"),
    /**
     *
     * IE7 mode
     */
    IE7("IE=7"),
    /**
     * IE7 mode (if a valid &lt;!DOCTYPE&gt; declaration is present)
     * <p>
     * Quirks mode (otherwise)
     */
    EmulateIE7("IE=Emulate7"),
    /**
     * Set to IE 8
     */
    IE8("IE=8"),
    /**
     * IE8 mode (if a valid &lt;!DOCTYPE&gt; declaration is present)
     * <p>
     * Quirks mode (otherwise)
     */
    EmulateIE8("IE=Emulate8"),
    /**
     * Set to run in IE 9 (Or Latest Version)
     */
    IE9("IE=9"),
    /**
     * IE9 mode (if a valid &lt;!DOCTYPE&gt; declaration is present)
     * <p>
     * Quirks mode (otherwise)
     */
    EmulateIE9("IE=Emulate9"),
    /**
     * IE10 mode
     */
    IE10("IE=10"),
    /**
     * IE10 mode (if a valid &lt;!DOCTYPE&gt; declaration is present)
     * <p>
     * Quirks mode (otherwise)
     */
    EmulateIE10("IE=Emulate10"),
    /**
     * IE 11 Mode
     */
    IE11("IE=11"),
    /**
     * IE11 mode (if a valid &lt;!DOCTYPE&gt; declaration is present)
     * <p>
     * Quirks mode (otherwise)
     */
    EmulateIE11("IE=Emulate11"),
    /**
     * The highest supported document mode of the browser
     */
    Edge("IE=Edge");

    private final String valueString;

    /**
     * The constructor accepting the values for the X-UA-Compatible value.
     * <p>
     * @param valueString
     */
    private InternetExplorerCompatibilityMode(String valueString)
    {
        this.valueString = valueString;
    }

    /**
     * The value that must be inside the compatible set
     * <p>
     * @return A string of the value that must be in the X-UA-Compatible string
     */
    public String getValue()
    {
        return valueString;
    }
}
