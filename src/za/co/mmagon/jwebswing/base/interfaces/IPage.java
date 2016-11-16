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

package za.co.mmagon.jwebswing.base.interfaces;

import java.util.HashMap;
import javax.servlet.http.HttpSession;
import net.sf.uadetector.ReadableUserAgent;
import za.co.mmagon.jwebswing.base.servlets.JWebSwingServlet;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.angular.AngularFeature;
import za.co.mmagon.jwebswing.base.client.InternetExplorerCompatibilityMode;
import za.co.mmagon.jwebswing.base.html.Base;
import za.co.mmagon.jwebswing.base.html.DocumentType;
import za.co.mmagon.jwebswing.base.html.Meta;
import za.co.mmagon.jwebswing.base.html.Title;

/**
 * Neatness Interface
 * @author GedMarc
 * @since Oct 3, 2016
 * 
 */
public interface IPage 
{

    /**
     * Adds a variable into angular
     *
     * @param variableName
     * @return
     */
    Page addAngularVariable(String variableName);

    /**
     * Returns the angular object
     *
     * @return
     */
    AngularFeature getAngular();

    /**
     * Returns the Application Name of the page
     *
     * @return Meta The meta tag
     */
    Meta getApplicationName();

    /**
     * Returns the Application Name of the page
     *
     * @return Meta The meta tag
     */
    Base getBase();

    /**
     * Returns the Cache Control Meta Object
     *
     * @return
     */
    Meta getCacheControl();

    /**
     * Returns the Application Name of the page
     *
     * @return Meta The meta tag
     */
    Meta getCompatibilityMode();

    /**
     * Returns the Application Name of the page
     *
     * @param dummyInt Serves no function
     * @return String The actual used compatibility mode
     */
    String getCompatibilityMode(int dummyInt);

    /**
     * Returns this pages current component cache
     * @return
     */
    HashMap<String, ComponentHierarchyBase> getComponentCache();

    /**
     * Returns the description of the page
     *
     * @return Meta The meta tag
     */
    Meta getDescription();

    /**
     * Returns the document type that will be rendered with this HTML page
     * real-time
     * <p>
     * @return Document Type
     */
    DocumentType getDocumentType();

    /**
     * Returns the Application Name of the page
     *
     * @return Meta The meta tag
     */
    Meta getGenerator();

    /**
     * Returns the Application Name of the page
     *
     * @return Meta The meta tag
     */
    Meta getKeywords();

    /**
     * Returns the Servlet processing requests
     *
     * @return The JWebSwingServlet
     */
    JWebSwingServlet getServlet();

    /**
     * Returns the attached session if available
     *
     * @return HTTPSession or NULL
     */
    HttpSession getSession();

    /**
     * Returns the Application Name of the page
     *
     * @return Meta The meta tag
     */
    Title getTitle();

    /**
     * Returns a readable user agent, or null if just a basic render
     *
     * @return
     */
    ReadableUserAgent getUserAgent();

    /**
     * whether or not to render angular
     *
     * @return
     */
    boolean isAngularEnabled();

    /**
     * Whether or not to render bootstrap
     *
     * @return
     */
    boolean isBootstrapEnabled();

    /**
     * Whether or not to dynamic render the requirements
     *
     * @return
     */
    boolean isDynamicRender();

    /**
     * Returns if pace should be set as the default render
     *
     * @return
     */
    boolean isPaceEnabled();

    /**
     * Whether or not to render the JQuery requirements
     *
     * @return
     */
    boolean isjQueryEnabled();

    /**
     * Whether or not to render the JQuery UI Requirements
     *
     * @return
     */
    boolean isjQueryUIEnabled();

    /**
     * Removes Base from the Header
     *
     * @return Remove
     */
    boolean removeBase();

    /**
     * Removes Title from the Header
     *
     * @return Remove
     */
    boolean removeTitle();

    /**
     * Returns the JavaScript render for the body
     *
     * @return
     */
    StringBuilder renderJavascript();

    /**
     * Whether or not to render angular
     *
     * @param angularEnabled
     */
    void setAngularEnabled(boolean angularEnabled);

    /**
     * Sets the Application Name of this page
     *
     * @param applicationName The Application Name of the page
     */
    void setApplicationNameMeta(String applicationName);

    /**
     * Sets the author of this page
     *
     * @param author The author of this page
     */
    void setAuthor(String author);

    /**
     * Sets the Base of this page
     *
     * @param base The Base of the page
     */
    void setBase(Base base);

    /**
     * Whether or not to render bootstrap
     *
     * @param bootstrapEnabled
     */
    void setBootstrapEnabled(boolean bootstrapEnabled);

    /**
     * Sets the Cache Control.
     * <p>
     * <p>
     * <p>
     * HTTP 1.1. Allowed values = PUBLIC | PRIVATE | NO-CACHE | NO-STORE.<p>
     * <p>
     * Public - may be cached in public shared caches.<p>
     * Private - may only be cached in private cache.<p>
     * No-Cache - may not be cached.<p>
     * No-Store - may be cached but not archived.<p>
     * <p>
     * The directive CACHE-CONTROL:NO-CACHE indicates cached information should not be used and instead requests should be forwarded to the origin server. This directive has the same semantics as
     * the<p>
     * PRAGMA:NO-CACHE.<p>
     * <p>
     * Clients SHOULD include both PRAGMA: NO-CACHE and CACHE-CONTROL: NO-CACHE when a no-cache request is sent to a server not known to be HTTP/1.1 compliant. Also see EXPIRES.<p>
     * <p>
     * Note: It may be better to specify cache commands in HTTP than in META statements, where they can influence more than the browser, but proxies and other intermediaries that may cache<p>
     * information.
     *
     * @param enable
     */
    void setCacheControl(boolean enable);

    /**
     * Sets the Application Name of this page Null removes compatibility specification
     *
     * @param httpEquiv The Application Name of the page
     */
    void setCompatibilityMode(InternetExplorerCompatibilityMode httpEquiv);

    /**
     * Sets the current component cache
     * @param componentCache
     */
    void setComponentCache(HashMap<String, ComponentHierarchyBase> componentCache);

    /**
     * Sets the description of this page
     *
     * @param description The description of the page
     */
    void setDescription(String description);

    /**
     * Whether or not to dynamic render the requirements
     *
     * @param dynamicRender
     */
    void setDynamicRender(boolean dynamicRender);

    /**
     * Sets the Icon in the browser address bar
     *
     * @param favIconURL The path to the icon
     */
    void setFavIcon(String favIconURL);

    /**
     * Sets the Generator of this page
     *
     * @param Generator The Generator of the page
     */
    void setGenerator(String Generator);

    /**
     * Sets the Keywords of this page
     *
     * @param Keywords The Keywords of the page
     */
    void setKeywords(String Keywords);

    /**
     * Sets if pace should be rendered s the default loader
     *
     * @param paceEnabled
     */
    void setPaceEnabled(boolean paceEnabled);

    /**
     * Sets the Servlet to a new Servlet
     *
     * @param servlet The Servlet to set
     */
    void setServlet(JWebSwingServlet servlet);

    /**
     * Sets this pages session
     *
     * @param session HttpSession or null
     */
    void setSession(HttpSession session);

    /**
     * Sets all component in the head and body to tiny
     *
     * @param tiny
     */
    Page setTiny(boolean tiny);

    /**
     * Sets the Title of this page
     *
     * @param Title The Title of the page
     */
    void setTitle(Title Title);

    /**
     * Sets the Title of this page
     *
     * @param Title The Title of the page
     */
    void setTitle(String Title);

    /**
     * Sets the userAgent
     *
     * @param userAgent
     */
    void setUserAgent(ReadableUserAgent userAgent);

    /**
     * Whether or not to render the JQuery Requirements
     *
     * @param jQueryEnabled
     */
    void setjQueryEnabled(boolean jQueryEnabled);

    /**
     * Whether or not to render the JQuery UI Requirements
     *
     * @param jQueryUIEnabled
     */
    void setjQueryUIEnabled(boolean jQueryUIEnabled);
    
     /**
     * Is Modernizr Enabled
     * @return 
     */
    public boolean isModernizrEnabled();

    /**
     * Sets if Modernizr is enabled
     * @param modernizrEnabled 
     */
    public void setModernizrEnabled(boolean modernizrEnabled);
    

}
