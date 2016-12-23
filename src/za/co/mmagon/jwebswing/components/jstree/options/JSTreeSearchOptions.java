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

import com.fasterxml.jackson.annotation.JsonProperty;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * This plugin adds the possibility to search for items in the tree and even to show only matching nodes.
 *
 * @author GedMarc
 * @since 23 Dec 2016
 * @version 1.0
 *
 */
public class JSTreeSearchOptions extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;
    /**
     * a jQuery-like AJAX config, which jstree uses if a server should be queried for results. A str (which is the search string) parameter will be added with the request, an optional inside parameter
     * will be added if the search is limited to a node id. The expected result is a JSON array with nodes that need to be opened so that matching nodes will be revealed. Leave this setting as false
     * to not query the server. You can also set this to a function, which will be invoked in the instance's scope and receive 3 parameters - the search string, the callback to call with the array of
     * nodes to load, and the optional node ID to limit the search to
     */
    private JSTreeSearchOptionsAjax ajax;
    /**
     * Indicates if the search should be fuzzy or not (should chnd3 match child node 3). Default is false.
     */
    private Boolean fuzzy;
    /**
     * Indicates if the search should be case sensitive. Default is false.
     */
    @JsonProperty("case_sensitive")
    private Boolean caseSensitive;
    /**
     * Indicates if the tree should be filtered (by default) to show only matching nodes (keep in mind this can be a heavy on large trees in old browsers).
     * <p>
     * This setting can be changed at runtime when calling the search method. Default is false.
     */
    @JsonProperty("show_only_matches")
    private Boolean showOnlyMatches;
    /**
     * Indicates if the children of matched element are shown (when show_only_matches is true)
     * <p>
     * This setting can be changed at runtime when calling the search method. Default is false.
     */
    @JsonProperty("show_only_matches_children")
    private Boolean showOnlyMatchesChildren;
    /**
     * Indicates if all nodes opened to reveal the search result, should be closed when the search is cleared or a new search is performed. Default is true.
     */
    @JsonProperty("close_opened_onclear")
    private Boolean closeOpenedOnClear;
    /**
     * Indicates if only leaf nodes should be included in search results. Default is false.
     */
    @JsonProperty("search_leaves_only")
    private Boolean searchLeavesOnly;

    public JSTreeSearchOptions()
    {

    }

    /**
     * a jQuery-like AJAX config, which jstree uses if a server should be queried for results.
     * <p>
     * A str (which is the search string) parameter will be added with the request, an optional inside parameter will be added if the search is limited to a node id. The expected result is a JSON
     * array with nodes that need to be opened so that matching nodes will be revealed. Leave this setting as false to not query the server. You can also set this to a function, which will be invoked
     * in the instance's scope and receive 3 parameters - the search string, the callback to call with the array of nodes to load, and the optional node ID to limit the search to
     *
     * @return
     */
    public JSTreeSearchOptionsAjax getAjax()
    {
        return ajax;
    }

    /**
     * a jQuery-like AJAX config, which jstree uses if a server should be queried for results. A str (which is the search string) parameter will be added with the request, an optional inside parameter
     * will be added if the search is limited to a node id. The expected result is a JSON array with nodes that need to be opened so that matching nodes will be revealed. Leave this setting as false
     * to not query the server. You can also set this to a function, which will be invoked in the instance's scope and receive 3 parameters - the search string, the callback to call with the array of
     * nodes to load, and the optional node ID to limit the search to
     *
     * @param ajax
     */
    public void setAjax(JSTreeSearchOptionsAjax ajax)
    {
        this.ajax = ajax;
    }

    /**
     * Indicates if the search should be fuzzy or not (should chnd3 match child node 3). Default is false.
     *
     * @return
     */
    public Boolean getFuzzy()
    {
        return fuzzy;
    }

    /**
     * Indicates if the search should be fuzzy or not (should chnd3 match child node 3). Default is false.
     *
     * @param fuzzy
     */
    public void setFuzzy(Boolean fuzzy)
    {
        this.fuzzy = fuzzy;
    }

    /**
     * Indicates if the search should be case sensitive. Default is false.
     *
     * @return
     */
    public Boolean getCaseSensitive()
    {
        return caseSensitive;
    }

    /**
     * Indicates if the search should be case sensitive. Default is false.
     *
     * @param caseSensitive
     */
    public void setCaseSensitive(Boolean caseSensitive)
    {
        this.caseSensitive = caseSensitive;
    }

    /**
     * Indicates if the tree should be filtered (by default) to show only matching nodes (keep in mind this can be a heavy on large trees in old browsers).
     * <p>
     * This setting can be changed at runtime when calling the search method. Default is false.
     *
     * @return
     */
    public Boolean getShowOnlyMatches()
    {
        return showOnlyMatches;
    }

    /**
     * Indicates if the tree should be filtered (by default) to show only matching nodes (keep in mind this can be a heavy on large trees in old browsers).
     * <p>
     * This setting can be changed at runtime when calling the search method. Default is false.
     *
     * @param showOnlyMatches
     */
    public void setShowOnlyMatches(Boolean showOnlyMatches)
    {
        this.showOnlyMatches = showOnlyMatches;
    }

    /**
     * Indicates if the children of matched element are shown (when show_only_matches is true)
     * <p>
     * This setting can be changed at runtime when calling the search method. Default is false.
     *
     * @return
     */
    public Boolean getShowOnlyMatchesChildren()
    {
        return showOnlyMatchesChildren;
    }

    /**
     * Indicates if the children of matched element are shown (when show_only_matches is true)
     * <p>
     * This setting can be changed at runtime when calling the search method. Default is false.
     *
     * @param showOnlyMatchesChildren
     */
    public void setShowOnlyMatchesChildren(Boolean showOnlyMatchesChildren)
    {
        this.showOnlyMatchesChildren = showOnlyMatchesChildren;
    }

    /**
     * Indicates if all nodes opened to reveal the search result, should be closed when the search is cleared or a new search is performed. Default is true.
     *
     * @return
     */
    public Boolean getCloseOpenedOnClear()
    {
        return closeOpenedOnClear;
    }

    /**
     * Indicates if all nodes opened to reveal the search result, should be closed when the search is cleared or a new search is performed. Default is true.
     *
     * @param closeOpenedOnClear
     */
    public void setCloseOpenedOnClear(Boolean closeOpenedOnClear)
    {
        this.closeOpenedOnClear = closeOpenedOnClear;
    }

    /**
     * Indicates if only leaf nodes should be included in search results. Default is false.
     *
     * @return
     */
    public Boolean getSearchLeavesOnly()
    {
        return searchLeavesOnly;
    }

    /**
     * Indicates if only leaf nodes should be included in search results. Default is false.
     *
     * @param searchLeavesOnly
     */
    public void setSearchLeavesOnly(Boolean searchLeavesOnly)
    {
        this.searchLeavesOnly = searchLeavesOnly;
    }

}
