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
package za.co.mmagon.jwebswing.components.modernizr;

import com.fasterxml.jackson.annotation.*;

/**
 *
 * @author GedMarc
 * @since Nov 21, 2016
 * @version 1.0
 *
 */
public class ModernizrBrowserDto
{

    private Boolean htmlimports;
    private Boolean applicationcache;
    private Boolean blobconstructor;
    @JsonProperty(value = "blob-constructor")
    private Boolean blob_constructor;
    private Boolean cookies;
    private Boolean cors;
    private Boolean customprotocolhandler;
    private Boolean customevent;
    private Boolean dataview;
    private Boolean eventlistener;
    private Boolean geolocation;
    private Boolean history;
    private Boolean ie8compat;
    private Boolean json;
    private Boolean notification;
    private Boolean postmessage;
    private Boolean queryselector;
    private Boolean serviceworker;
    private Boolean svg;
    private Boolean templatestrings;
    private Boolean typedarrays;
    private Boolean websockets;
    private Boolean xdomainrequest;
    private Boolean webaudio;
    private Boolean cssescape;
    private Boolean supports;
    private Boolean target;
    private Boolean mutationobserver;

    /**
     * Abstract constructor
     */
    public ModernizrBrowserDto()
    {

    }

    /**
     * Tests for HTML Imports
     *
     * @return
     */
    public Boolean isHtmlimports()
    {
        return htmlimports;
    }

    /**
     * Tests for HTML Imports
     *
     * @param htmlimports
     */
    protected void setHtmlimports(Boolean htmlimports)
    {
        this.htmlimports = htmlimports;
    }

    /**
     * Is Application Cache
     *
     * @return
     */
    public Boolean isApplicationcache()
    {
        return applicationcache;
    }

    /**
     * Sets Application Cache
     *
     * @param applicationcache
     */
    protected void setApplicationcache(Boolean applicationcache)
    {
        this.applicationcache = applicationcache;
    }

    /**
     * Test result for Blob constructor
     *
     * @return
     */
    public Boolean isBlobconstructor()
    {
        return blobconstructor;
    }

    /**
     * Test result for Blob Constructor
     *
     * @param blobconstructor
     */
    protected void setBlobconstructor(Boolean blobconstructor)
    {
        this.blobconstructor = blobconstructor;
    }

    /**
     * Test result for Blob Constructor
     *
     * @return
     */
    public Boolean isBlobConstructor()
    {
        return blob_constructor;
    }

    /**
     * Test result for Blob Constructor
     *
     * @param blob_constructor
     */
    protected void setBlobConstructor(Boolean blob_constructor)
    {
        this.blob_constructor = blob_constructor;
    }

    /**
     * Test result for cookies available
     *
     * @return
     */
    public Boolean isCookies()
    {
        return cookies;
    }

    /**
     * Test result for if cookies available
     *
     * @param cookies
     */
    protected void setCookies(Boolean cookies)
    {
        this.cookies = cookies;
    }

    /**
     * Is Cors Enabled
     *
     * @return
     */
    public Boolean isCors()
    {
        return cors;
    }

    /**
     * Is Cors enabled
     *
     * @param cors
     */
    protected void setCors(Boolean cors)
    {
        this.cors = cors;
    }

    /**
     * Is custom protocol handler enabled
     *
     * @return
     */
    public Boolean isCustomprotocolhandler()
    {
        return customprotocolhandler;
    }

    /**
     * Is custom protocol handler enabled
     *
     * @param customprotocolhandler
     */
    protected void setCustomprotocolhandler(Boolean customprotocolhandler)
    {
        this.customprotocolhandler = customprotocolhandler;
    }

    /**
     * Is custom event handler enabled
     *
     * @return
     */
    public Boolean isCustomevent()
    {
        return customevent;
    }

    /**
     * Is custom event handler enabled
     *
     * @param customevent
     */
    protected void setCustomevent(Boolean customevent)
    {
        this.customevent = customevent;
    }

    /**
     * Is data view enabled
     *
     * @return
     */
    public Boolean isDataview()
    {
        return dataview;
    }

    /**
     * Is data view enabled
     *
     * @param dataview
     */
    protected void setDataview(Boolean dataview)
    {
        this.dataview = dataview;
    }

    /**
     * Is event listener enabled
     *
     * @return
     */
    public Boolean isEventlistener()
    {
        return eventlistener;
    }

    /**
     * Is event listener enabled
     *
     * @param eventlistener
     */
    protected void setEventlistener(Boolean eventlistener)
    {
        this.eventlistener = eventlistener;
    }

    /**
     * Is Geo location enabled
     *
     * @return
     */
    public Boolean isGeolocation()
    {
        return geolocation;
    }

    /**
     * Is Geo location enabled
     *
     * @param geolocation
     */
    protected void setGeolocation(Boolean geolocation)
    {
        this.geolocation = geolocation;
    }

    /**
     * Is history enabled
     *
     * @return
     */
    public Boolean isHistory()
    {
        return history;
    }

    /**
     * Is history enabled
     *
     * @param history
     */
    protected void setHistory(Boolean history)
    {
        this.history = history;
    }

    /**
     * Is ie 8 compatible mode
     *
     * @return
     */
    public Boolean isIe8compat()
    {
        return ie8compat;
    }

    /**
     * Is ie 8 compatible mode
     *
     * @param ie8compat
     */
    protected void setIe8compat(Boolean ie8compat)
    {
        this.ie8compat = ie8compat;
    }

    /**
     * Is JSON enabled
     *
     * @return
     */
    public Boolean isJson()
    {
        return json;
    }

    /**
     * Sets if JSon is enabled
     *
     * @param json
     */
    protected void setJson(Boolean json)
    {
        this.json = json;
    }

    /**
     * Are notifications enabled
     *
     * @return
     */
    public Boolean isNotification()
    {
        return notification;
    }

    /**
     * Are notifications enabled
     *
     * @param notification
     */
    protected void setNotification(Boolean notification)
    {
        this.notification = notification;
    }

    /**
     * Is post message
     *
     * @return
     */
    public Boolean isPostmessage()
    {
        return postmessage;
    }

    /**
     * Is post message
     *
     * @param postmessage
     */
    protected void setPostmessage(Boolean postmessage)
    {
        this.postmessage = postmessage;
    }

    /**
     * Is Query Selector
     *
     * @return
     */
    public Boolean isQueryselector()
    {
        return queryselector;
    }

    /**
     * Sets query selector
     *
     * @param queryselector
     */
    protected void setQueryselector(Boolean queryselector)
    {
        this.queryselector = queryselector;
    }

    /**
     * Are service workers allowed
     *
     * @return
     */
    public Boolean isServiceworker()
    {
        return serviceworker;
    }

    /**
     * Are service workers allowed
     *
     * @param serviceworker
     */
    protected void setServiceworker(Boolean serviceworker)
    {
        this.serviceworker = serviceworker;
    }

    /**
     * Is SVG Allowed
     *
     * @return
     */
    public Boolean isSvg()
    {
        return svg;
    }

    /**
     * Is SVG Allowed
     *
     * @param svg
     */
    protected void setSvg(Boolean svg)
    {
        this.svg = svg;
    }

    /**
     * Is template strings allowed
     *
     * @return
     */
    public Boolean isTemplatestrings()
    {
        return templatestrings;
    }

    /**
     * Is template strings allowed
     *
     * @param templatestrings
     */
    protected void setTemplatestrings(Boolean templatestrings)
    {
        this.templatestrings = templatestrings;
    }

    /**
     * Is typed arrays allowed
     *
     * @return
     */
    public Boolean isTypedarrays()
    {
        return typedarrays;
    }

    /**
     * Is typed arrays allowed
     *
     * @param typedarrays
     */
    protected void setTypedarrays(Boolean typedarrays)
    {
        this.typedarrays = typedarrays;
    }

    /**
     * Is web sockets allowed
     *
     * @return
     */
    public Boolean isWebsockets()
    {
        return websockets;
    }

    /**
     * Is web sockets allowed
     *
     * @param websockets
     */
    protected void setWebsockets(Boolean websockets)
    {
        this.websockets = websockets;
    }

    /**
     * Is XDomain Request Allowed
     *
     * @return
     */
    public Boolean isXdomainrequest()
    {
        return xdomainrequest;
    }

    /**
     * Is XDomain Request Allowed
     *
     * @param xdomainrequest
     */
    protected void setXdomainrequest(Boolean xdomainrequest)
    {
        this.xdomainrequest = xdomainrequest;
    }

    /**
     * Is Web Audio Allowed
     *
     * @return
     */
    public Boolean isWebaudio()
    {
        return webaudio;
    }

    /**
     * Is Web Audio Allowed
     *
     * @param webaudio
     */
    protected void setWebaudio(Boolean webaudio)
    {
        this.webaudio = webaudio;
    }

    /**
     * Is CSS Escape allowed
     *
     * @return
     */
    public Boolean isCssescape()
    {
        return cssescape;
    }

    /**
     * Is CSS Escape Allowed
     *
     * @param cssescape
     */
    protected void setCssescape(Boolean cssescape)
    {
        this.cssescape = cssescape;
    }

    /**
     * Is supports allowed
     *
     * @return
     */
    public Boolean isSupports()
    {
        return supports;
    }

    /**
     * Is supports allowed
     *
     * @param supports
     */
    protected void setSupports(Boolean supports)
    {
        this.supports = supports;
    }

    /**
     * Is target allowed
     *
     * @return
     */
    public Boolean isTarget()
    {
        return target;
    }

    /**
     * Sets target
     *
     * @param target
     */
    protected void setTarget(Boolean target)
    {
        this.target = target;
    }

    /**
     * Is Mutation Observer allowed
     *
     * @return
     */
    public Boolean isMutationobserver()
    {
        return mutationobserver;
    }

    /**
     * Is mutation observer allowed
     *
     * @param mutationobserver
     */
    protected void setMutationobserver(Boolean mutationobserver)
    {
        this.mutationobserver = mutationobserver;
    }
}
