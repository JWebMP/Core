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
     * In addition to the standard jQuery ajax options here you can suppy functions for data and url, the functions will be run in the current instance's scope and a param will be passed indicating
     * which node is being loaded, the return value of those functions will be used.
     */
    private JSTreeCoreDataFunction data;

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
     * In addition to the standard jQuery ajax options here you can suppy functions for data and url, the functions will be run in the current instance's scope and a param will be passed indicating
     * which node is being loaded, the return value of those functions will be used.
     *
     * @return
     */
    public JSTreeCoreDataFunction getData()
    {
        return data;
    }

    /**
     * In addition to the standard jQuery ajax options here you can suppy functions for data and url, the functions will be run in the current instance's scope and a param will be passed indicating
     * which node is being loaded, the return value of those functions will be used.
     *
     * @param data
     */
    public void setData(JSTreeCoreDataFunction data)
    {
        this.data = data;
    }

}
