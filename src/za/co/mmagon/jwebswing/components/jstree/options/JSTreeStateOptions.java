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

import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptLiteralFunction;

/**
 * This plugin saves all opened and selected nodes in the user's browser, so when returning to the same tree the previous state will be restored.
 *
 * @author GedMarc
 * @since 23 Dec 2016
 * @version 1.0
 *
 */
public class JSTreeStateOptions extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;
    /**
     * A string for the key to use when saving the current tree (change if using multiple trees in your project). Defaults to jstree.
     */
    private String key;
    /**
     * A space separated list of events that trigger a state save. Defaults to changed.jstree open_node.jstree close_node.jstree.
     */
    private String events;
    /**
     * Time in milliseconds after which the state will expire. Defaults to 'false' meaning - no expire.
     */
    private Integer ttl;
    /**
     * A function that will be executed prior to restoring state with one argument - the state object. Can be used to clear unwanted parts of the state.
     */
    private JavascriptLiteralFunction filter;

    public JSTreeStateOptions()
    {

    }

    /**
     * A string for the key to use when saving the current tree (change if using multiple trees in your project). Defaults to jstree.
     *
     * @return
     */
    public String getKey()
    {
        return key;
    }

    /**
     * A string for the key to use when saving the current tree (change if using multiple trees in your project). Defaults to jstree.
     *
     * @param key
     */
    public void setKey(String key)
    {
        this.key = key;
    }

    /**
     * A space separated list of events that trigger a state save. Defaults to changed.jstree open_node.jstree close_node.jstree.
     *
     * @return
     */
    public String getEvents()
    {
        return events;
    }

    /**
     * A space separated list of events that trigger a state save. Defaults to changed.jstree open_node.jstree close_node.jstree.
     *
     * @param events
     */
    public void setEvents(String events)
    {
        this.events = events;
    }

    /**
     * Time in milliseconds after which the state will expire. Defaults to 'false' meaning - no expire.
     *
     * @return
     */
    public Integer getTtl()
    {
        return ttl;
    }

    /**
     * Time in milliseconds after which the state will expire. Defaults to 'false' meaning - no expire.
     *
     * @param ttl
     */
    public void setTtl(Integer ttl)
    {
        this.ttl = ttl;
    }

    /**
     * A function that will be executed prior to restoring state with one argument - the state object. Can be used to clear unwanted parts of the state.
     *
     * @return
     */
    public JavascriptLiteralFunction getFilter()
    {
        return filter;
    }

    /**
     * A function that will be executed prior to restoring state with one argument - the state object. Can be used to clear unwanted parts of the state.
     *
     * @param filter
     */
    public void setFilter(JavascriptLiteralFunction filter)
    {
        this.filter = filter;
    }

}
