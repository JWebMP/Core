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
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.co.mmagon.jwebswing.base.client.InternetExplorerCompatibilityMode;
import za.co.mmagon.jwebswing.base.html.*;
import za.co.mmagon.jwebswing.base.html.attributes.CSSLinkAttributes;
import za.co.mmagon.jwebswing.base.html.attributes.MetaAttributes;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * A separated list of page fields Can be used as options
 *
 * @author GedMarc
 * @since Nov 21, 2016
 *
 */
public class PageFields extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;

    /**
     * Page Author
     */
    private Meta author;
    /**
     * Page Author
     */
    private Meta keywordsMeta;
    /**
     * Page Author
     */
    private Meta applicationNameMeta;
    /**
     * Page Author
     */
    private Meta descriptionMeta;
    /**
     * Page Author
     */
    private Meta generatorMeta;
    /**
     * Page HTTP Meta
     */
    private Meta httpEquivMeta;
    /**
     * Page Author
     */
    private Meta cacheControl;
    /**
     * The link for the Site icon
     */
    private CSSLink favIconLink;
    /**
     * The title of this page
     */
    private Title title;
    /**
     * The base of this page
     */
    private Base base;
    /**
     * The back reference to the page
     */
    @JsonIgnore
    private final Page page;

    /**
     * Constructor for page fields
     *
     * @param page
     */
    protected PageFields(Page page)
    {
        this.page = page;
    }

    /**
     * Sets the author of this page
     *
     * @param author The author of this page
     */
    public final void setAuthor(String author)
    {
        this.author = new Meta(Meta.MetadataFields.Author, author);
    }

    /**
     * Sets the description of this page
     *
     * @param description The description of the page
     */
    public final void setDescription(String description)
    {
        if (descriptionMeta == null)
        {
            descriptionMeta = new Meta(Meta.MetadataFields.Description, description);
        }
        else
        {
            descriptionMeta.addAttribute(MetaAttributes.Content, description);
        }
    }

    /**
     * Returns the description of the page
     *
     * @return Meta The meta tag
     */
    public final Meta getDescription()
    {
        return descriptionMeta;
    }

    /**
     * Returns the Application Name of the page
     *
     * @return Meta The meta tag
     */
    public final Meta getApplicationName()
    {
        return applicationNameMeta;
    }

    /**
     * Sets the Application Name of this page
     *
     * @param applicationName The Application Name of the page
     */
    public final void setApplicationNameMeta(String applicationName)
    {
        if (applicationNameMeta == null)
        {
            applicationNameMeta = new Meta(Meta.MetadataFields.Application_Name, applicationName);
        }
        else
        {
            applicationNameMeta.addAttribute(MetaAttributes.Content, applicationName);
        }
    }

    /**
     * Returns the Application Name of the page
     *
     * @return Meta The meta tag
     */
    public final Meta getGenerator()
    {
        return generatorMeta;
    }

    /**
     * Sets the Generator of this page
     *
     * @param Generator The Generator of the page
     */
    public final void setGenerator(String Generator)
    {
        if (generatorMeta == null)
        {
            generatorMeta = new Meta(Meta.MetadataFields.Generator, Generator);
        }
        else
        {
            generatorMeta.addAttribute(MetaAttributes.Content, Generator);
        }
    }

    /**
     * Returns the Application Name of the page
     *
     * @return Meta The meta tag
     */
    public final Meta getKeywords()
    {
        return keywordsMeta;
    }

    /**
     * Sets the Keywords of this page
     *
     * @param Keywords The Keywords of the page
     */
    public final void setKeywords(String Keywords)
    {
        if (keywordsMeta == null)
        {
            keywordsMeta = new Meta(Meta.MetadataFields.Keywords, Keywords);
        }
        else
        {
            keywordsMeta.addAttribute(MetaAttributes.Content, Keywords);
        }
    }

    /**
     * Removes Title from the Header
     *
     * @return Remove
     */
    public final boolean removeTitle()
    {
        return page.getHead().getChildren().remove(getTitle());
    }

    /**
     * Returns the Application Name of the page
     *
     * @return Meta The meta tag
     */
    public final Meta getCompatibilityMode()
    {
        return httpEquivMeta;
    }

    /**
     * Returns the Application Name of the page
     *
     * @param dummyInt Serves no function
     *
     * @return String The actual used compatibility mode
     */
    public final String getCompatibilityMode(int dummyInt)
    {
        return httpEquivMeta.getAttribute(MetaAttributes.Http_Equiv);
    }

    /**
     * Sets the Application Name of this page Null removes compatibility specification
     *
     * @param httpEquiv The Application Name of the page
     */
    public final void setCompatibilityMode(InternetExplorerCompatibilityMode httpEquiv)
    {
        if (httpEquivMeta != null && httpEquiv != null)
        {
            httpEquivMeta.addAttribute(MetaAttributes.Content, httpEquiv.getValue());
        }
        else if (httpEquiv != null)
        {
            httpEquivMeta = new Meta(Meta.MetadataFields.http_equiv, httpEquiv.getValue());
        }
        else
        {
            httpEquivMeta = null;
        }
    }

    /**
     * Sets the Icon in the browser address bar
     *
     * @param favIconURL The path to the icon
     */
    public void setFavIcon(String favIconURL)
    {
        favIconLink = new CSSLink();
        favIconLink.addAttribute(CSSLinkAttributes.Rel, "icon");
        String mimeType = "image/png";
        try
        {
            mimeType = Files.probeContentType(new File(favIconURL).toPath());
        }
        catch (IOException ex)
        {
            Logger.getLogger(Page.class.getName()).log(Level.SEVERE, null, ex);
        }
        //@TODO define the image type from url
        favIconLink.addAttribute(CSSLinkAttributes.Type, mimeType);
        favIconLink.addAttribute(CSSLinkAttributes.HRef, favIconURL);
    }

    /**
     * Returns the author
     *
     * @return
     */
    public Meta getAuthor()
    {
        return author;
    }

    /**
     * Returns the fav icon link
     *
     * @return
     */
    public CSSLink getFavIconLink()
    {
        return favIconLink;
    }

    /**
     * Returns the http-equiv meta tag
     *
     * @return
     */
    public Meta getHttpEquivMeta()
    {
        return httpEquivMeta;
    }

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
    public void setCacheControl(boolean enable)
    {
        if (enable)
        {
            cacheControl = new Meta("cache-control");
            cacheControl.addAttribute(MetaAttributes.Content, "public");
        }
        else
        {
            cacheControl = null;
        }
    }

    /**
     * Returns the Cache Control Meta Object
     *
     * @return
     */
    public Meta getCacheControl()
    {
        return cacheControl;
    }

    /**
     * Returns the Application Name of the page
     *
     * @return Meta The meta tag
     */
    public final Base getBase()
    {
        return this.base;
    }

    /**
     * Returns the Application Name of the page
     *
     * @return Meta The meta tag
     */
    public final Title getTitle()
    {
        return this.title;
    }

    /**
     * Sets the Title of this page
     *
     * @param Title The Title of the page
     */
    public final void setTitle(Title Title)
    {
        this.title = Title;
        if (title != null)
        {
            title.setPage(page);
        }
    }

    /**
     * Sets the Title of this page
     *
     * @param Title The Title of the page
     */
    public final void setTitle(String Title)
    {
        this.title = new Title(Title);
        if (title != null)
        {
            title.setPage(page);
        }
    }

    /**
     * Sets the Base of this page
     *
     * @param base The Base of the page
     */
    public final void setBase(Base base)
    {
        this.base = base;
        if (base != null)
        {
            base.setPage(page);
        }
    }

    /**
     * Removes Base from the Header
     *
     * @return Remove
     */
    public final boolean removeBase()
    {
        return page.getHead().getChildren().remove(getBase());
    }

}
