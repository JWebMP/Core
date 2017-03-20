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
package za.co.mmagon.jwebswing;

import com.fasterxml.jackson.annotation.JsonIgnore;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * A list of page options available to the page
 *
 * @author GedMarc
 * @since Nov 21, 2016
 *
 */
public class PageOptions extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;
    @JsonIgnore
    private final Page page;

    /**
     * Whether or not to render jQuery
     */
    private boolean jQueryEnabled;
    /**
     * Whether or not to dynamic render the requirements
     */
    private boolean dynamicRender = true;
    /**
     * Whether or not modernizr is enabled
     */
    private boolean modernizrEnabled;
    /**
     * If the scripts should be rendered in the head section (like for cordova rendering)
     */
    private boolean scriptsInHead;
    /**
     * The local storage
     */
    private boolean localStorage;
    /**
     * The Google maps API key that highlights if it should render. Needed for the dynamic rendering sometimes
     */
    private String googleMapsJSApi;

    /**
     * If the page is using JQuery 3
     */
    private boolean jquery3 = true;

    /**
     * Construct directly with the page
     *
     * @param page
     */
    protected PageOptions(Page page)
    {
        this.page = page;
    }

    /**
     * Is Modernizr Enabled
     *
     * @return
     */
    public boolean isModernizrEnabled()
    {
        return modernizrEnabled;
    }

    /**
     * Sets if Modernizr is enabled
     *
     * @param modernizrEnabled
     */
    public void setModernizrEnabled(boolean modernizrEnabled)
    {
        this.modernizrEnabled = modernizrEnabled;
        page.getBody().configureModernizr();
    }

    /**
     * Whether or not to dynamic render the requirements
     *
     * @return
     */
    public boolean isDynamicRender()
    {
        return dynamicRender;
    }

    /**
     * Whether or not to dynamic render the requirements
     *
     * @param dynamicRender
     */
    public void setDynamicRender(boolean dynamicRender)
    {
        this.dynamicRender = dynamicRender;
    }

    /**
     * Whether or not to place the scripts in the head
     *
     * @return
     */
    public boolean isScriptsInHead()
    {
        return scriptsInHead;
    }

    /**
     * Sets if scripts must be rendered in the head
     *
     * @param scriptsInHead
     */
    public void setScriptsInHead(boolean scriptsInHead)
    {
        this.scriptsInHead = scriptsInHead;
    }

    /**
     * If this page should be rendered with dynamic local storage support
     *
     * @return
     */
    public boolean isLocalStorage()
    {
        return localStorage;
    }

    /**
     * If the page should be rendered with dynamic local storage support. This renders a default page that is then fetched from the server to support cordova applications
     *
     * @param localStorage
     */
    public void setLocalStorage(boolean localStorage)
    {
        this.localStorage = localStorage;
    }

    /**
     * Whether or not google maps api is being used
     *
     * @return
     */
    public boolean isGoogleMapsJSApi()
    {
        if (googleMapsJSApi == null)
        {
            return false;
        }
        return !googleMapsJSApi.isEmpty();
    }

    /**
     * Returns the current assigned google maps api key
     *
     * @return
     */
    public String getGoogleMapsJSApi()
    {
        return googleMapsJSApi;
    }

    /**
     * The api code for the google maps javascript implementation
     *
     * @param googleMapsJSApi
     */
    public void setGoogleMapsJSApi(String googleMapsJSApi)
    {
        this.googleMapsJSApi = googleMapsJSApi;
    }
}
