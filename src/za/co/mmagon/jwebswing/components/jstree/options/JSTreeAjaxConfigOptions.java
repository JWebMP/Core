/*
 * Copyright (C) 2016 GedMarc
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
package za.co.mmagon.jwebswing.components.jstree.options;

import za.co.mmagon.jwebswing.components.jstree.options.functions.JSTreeCoreDataFunction;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 *
 * @author GedMarc
 * @since 22 Dec 2016
 * @version 1.0
 *
 */
public class JSTreeAjaxConfigOptions extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;
    /**
     * The Ajax url to retrieve data from.
     * <p>
     * Usually JWebSwingSiteBinder.DataLocation set in tree PreConfig
     */
    private String url;
    /**
     * Data to be sent to the server. It is converted to a query string, if not already a string. It's appended to the url for GET-requests. See processData option to prevent this automatic
     * processing. Object must be Key/Value pairs. If value is an Array, jQuery serializes multiple values with same key based on the value of the traditional setting (described below).
     */
    private JSTreeCoreDataFunction data;
    /**
     * If set to false, it will force requested pages not to be cached by the browser. Note: Setting cache to false will only work correctly with HEAD and GET requests. It works by appending
     * "_={timestamp}" to the GET parameters. The parameter is not needed for other types of requests, except in IE8 when a POST is made to a URL that has already been requested by a GET.
     */
    private Boolean cache;
    /**
     * The type of data that you're expecting back from the server. If none is specified, jQuery will try to infer it based on the MIME type of the response (an XML MIME type will yield XML, in 1.4
     * JSON will yield a JavaScript object, in 1.4 script will execute the script, and anything else will be returned as a string). The available types (and the result passed as the first argument to
     * your success callback) are:
     */
    private String dataType;
    /**
     * 
     */
    private String type;

    public JSTreeAjaxConfigOptions()
    {

    }

    /**
     * The Ajax url to retrieve data from.
     * <p>
     * Usually JWebSwingSiteBinder.DataLocation set in tree PreConfig
     *
     * @return
     */
    public String getUrl()
    {
        return url;
    }

    /**
     * The Ajax url to retrieve data from.
     * <p>
     * Usually JWebSwingSiteBinder.DataLocation set in tree PreConfig
     *
     * @param url
     */
    public void setUrl(String url)
    {
        this.url = url;
    }

    /**
     * Data to be sent to the server. It is converted to a query string, if not already a string. It's appended to the url for GET-requests. See processData option to prevent this automatic
     * processing. Object must be Key/Value pairs. If value is an Array, jQuery serializes multiple values with same key based on the value of the traditional setting (described below).
     *
     * @return
     */
    public JSTreeCoreDataFunction getData()
    {
        return data;
    }

    /**
     * Data to be sent to the server. It is converted to a query string, if not already a string. It's appended to the url for GET-requests. See processData option to prevent this automatic
     * processing. Object must be Key/Value pairs. If value is an Array, jQuery serializes multiple values with same key based on the value of the traditional setting (described below).
     *
     * @param data
     */
    public void setData(JSTreeCoreDataFunction data)
    {
        this.data = data;
    }

    /**
     * If set to false, it will force requested pages not to be cached by the browser. Note: Setting cache to false will only work correctly with HEAD and GET requests. It works by appending
     * "_={timestamp}" to the GET parameters. The parameter is not needed for other types of requests, except in IE8 when a POST is made to a URL that has already been requested by a GET.
     *
     * @return
     */
    public Boolean getCache()
    {
        return cache;
    }

    /**
     * If set to false, it will force requested pages not to be cached by the browser. Note: Setting cache to false will only work correctly with HEAD and GET requests. It works by appending
     * "_={timestamp}" to the GET parameters. The parameter is not needed for other types of requests, except in IE8 when a POST is made to a URL that has already been requested by a GET.
     *
     * @param cache
     */
    public void setCache(Boolean cache)
    {
        this.cache = cache;
    }

    /**
     * The type of data that you're expecting back from the server. If none is specified, jQuery will try to infer it based on the MIME type of the response (an XML MIME type will yield XML, in 1.4
     * JSON will yield a JavaScript object, in 1.4 script will execute the script, and anything else will be returned as a string). The available types (and the result passed as the first argument to
     * your success callback) are:
     *
     * @return
     */
    public String getDataType()
    {
        return dataType;
    }

    /**
     * The type of data that you're expecting back from the server. If none is specified, jQuery will try to infer it based on the MIME type of the response (an XML MIME type will yield XML, in 1.4
     * JSON will yield a JavaScript object, in 1.4 script will execute the script, and anything else will be returned as a string). The available types (and the result passed as the first argument to
     * your success callback) are:
     *
     * @param dataType
     */
    public void setDataType(String dataType)
    {
        this.dataType = dataType;
    }

}
