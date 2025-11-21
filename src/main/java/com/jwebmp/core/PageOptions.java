/*
 * Copyright (C) 2017 GedMarc
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
package com.jwebmp.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jwebmp.core.base.client.InternetExplorerCompatibilityMode;
import com.jwebmp.core.base.html.Base;
import com.jwebmp.core.base.html.CSSLink;
import com.jwebmp.core.base.html.Meta;
import com.jwebmp.core.base.html.Title;
import com.jwebmp.core.base.html.attributes.CSSLinkAttributes;
import com.jwebmp.core.base.html.attributes.MetaAttributes;
import com.jwebmp.core.enumerations.AppleMobileStatusBarStyles;
import com.jwebmp.core.enumerations.CacheControl;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A separated list of page fields Can be used as options
 *
 * @author GedMarc
 * @since Nov 21, 2016
 */
public class PageOptions<J extends PageOptions<J>>
		extends JavaScriptPart<J>
{
	/**
	 * The back reference to the page
	 */
	@JsonIgnore
	private final Page<?> page;
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
	 * Whether or not to dynamic render the requirements
	 */
	private boolean dynamicRender = true;

	/**
	 * If the scripts should be rendered in the head section (like for cordova rendering)
	 */
	private boolean scriptsInHead;

	/**
	 * Constructor for page fields
	 *
	 * @param page
	 */
	protected PageOptions(Page<?> page)
	{
		this.page = page;
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
	 * Sets the description of this page
	 *
	 * @param description
	 * 		The description of the page
	 */
	@SuppressWarnings("unchecked")
	public @org.jspecify.annotations.NonNull J setDescription(String description)
	{
		if (descriptionMeta == null)
		{
			descriptionMeta = new Meta(Meta.MetadataFields.Description, description);
		}
		else
		{
			descriptionMeta.addAttribute(MetaAttributes.Content, description);
		}
		return (J) this;
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
	 * @param applicationName
	 * 		The Application Name of the page
	 */
	@SuppressWarnings("unchecked")
	public @org.jspecify.annotations.NonNull J setApplicationNameMeta(String applicationName)
	{
		if (applicationNameMeta == null)
		{
			applicationNameMeta = new Meta(Meta.MetadataFields.Application_Name, applicationName);
		}
		else
		{
			applicationNameMeta.addAttribute(MetaAttributes.Content, applicationName);
		}
		return (J) this;
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
	 * @param Generator
	 * 		The Generator of the page
	 */
	@SuppressWarnings("unchecked")
	public @org.jspecify.annotations.NonNull J setGenerator(String Generator)
	{
		if (generatorMeta == null)
		{
			generatorMeta = new Meta(Meta.MetadataFields.Generator, Generator);
		}
		else
		{
			generatorMeta.addAttribute(MetaAttributes.Content, Generator);
		}
		return (J) this;
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
	 * @param Keywords
	 * 		The Keywords of the page
	 */
	@SuppressWarnings("unchecked")
	public @org.jspecify.annotations.NonNull J setKeywords(String Keywords)
	{
		if (keywordsMeta == null)
		{
			keywordsMeta = new Meta(Meta.MetadataFields.Keywords, Keywords);
		}
		else
		{
			keywordsMeta.addAttribute(MetaAttributes.Content, Keywords);
		}
		return (J) this;
	}

	/**
	 * Removes Title from the Header
	 *
	 * @return Remove
	 */
	public final boolean removeTitle()
	{
		return page.getHead()
		           .getChildren()
		           .remove(getTitle());
	}

	/**
	 * Returns the Application Name of the page
	 *
	 * @return Meta The meta tag
	 */
	public final Title getTitle()
	{
		return title;
	}

	/**
	 * Sets the Title of this page
	 *
	 * @param Title
	 * 		The Title of the page
	 */
	@SuppressWarnings("unchecked")
	public @org.jspecify.annotations.NonNull J setTitle(String Title)
	{
		title = new Title(Title);
		title.setPage(page);
		return (J) this;
	}

	/**
	 * Sets the Title of this page
	 *
	 * @param Title
	 * 		The Title of the page
	 */
	@SuppressWarnings("unchecked")
	public @org.jspecify.annotations.NonNull J setTitle(Title Title)
	{
		title = Title;
		if (title != null)
		{
			title.setPage(page);
		}
		return (J) this;
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
	 * Sets the Application Name of this page Null removes compatibility specification
	 *
	 * @param httpEquiv
	 * 		The Application Name of the page
	 */
	@SuppressWarnings("unchecked")
	public @org.jspecify.annotations.NonNull J setCompatibilityMode(InternetExplorerCompatibilityMode httpEquiv)
	{
		if (httpEquivMeta != null && httpEquiv != null)
		{
			httpEquivMeta.addAttribute(MetaAttributes.Content, httpEquiv.getValue());
		}
		else if (httpEquiv != null)
		{
			httpEquivMeta = new Meta(Meta.MetadataFields.XUACompatible, httpEquiv.getValue());
		}
		else
		{
			httpEquivMeta = null;
		}
		return (J) this;
	}

	/**
	 * Returns the Application Name of the page
	 *
	 * @param dummyInt
	 * 		Serves no function
	 *
	 * @return String The actual used compatibility mode
	 */
	@SuppressWarnings("unused")
	public final String getCompatibilityMode(int dummyInt)
	{
		return httpEquivMeta.getAttribute(MetaAttributes.Http_Equiv);
	}

	/**
	 * Sets the Icon in the browser address bar
	 *
	 * @param favIconURL
	 * 		The path to the icon
	 */
	@SuppressWarnings("unchecked")
	public @org.jspecify.annotations.NonNull J setFavIcon(String favIconURL)
	{
		favIconLink = new CSSLink();
		favIconLink.addAttribute(CSSLinkAttributes.Rel, "icon");
		String mimeType = "image/png";
		try
		{
			mimeType = Files.probeContentType(new File(favIconURL).toPath());
		}
		catch (IOException | InvalidPathException ex)
		{
			Logger.getLogger(Page.class.getName())
			      .log(Level.FINER, "Unable to determine fav icon type from {0}", ex);
		}
		favIconLink.addAttribute(CSSLinkAttributes.Type, mimeType);
		favIconLink.addAttribute(CSSLinkAttributes.HRef, favIconURL);
		return (J) this;
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
	 * Sets the author of this page
	 *
	 * @param author
	 * 		The author of this page
	 */
	@SuppressWarnings("unchecked")
	public @org.jspecify.annotations.NonNull J setAuthor(String author)
	{
		this.author = new Meta(Meta.MetadataFields.Author, author);
		return (J) this;
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
	 * Returns the Cache Control Meta Object
	 *
	 * @return
	 */
	public Meta getCacheControl()
	{
		return cacheControl;
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
	 * The directive CACHE-CONTROL:NO-CACHE indicates cached information should not be used and instead requests should be forwarded to the origin server. This directive has the
	 * same semantics as
	 * the<p>
	 * PRAGMA:NO-CACHE.<p>
	 * <p>
	 * Clients SHOULD include both PRAGMA: NO-CACHE and CACHE-CONTROL: NO-CACHE when a no-cache request is sent to a server not known to be HTTP/1.1 compliant. Also see
	 * EXPIRES.<p>
	 * <p>
	 * Note: It may be better to specify cache commands in HTTP than in META statements, where they can influence more than the browser, but proxies and other intermediaries that
	 * may cache<p>
	 * information.
	 *
	 * @param enable
	 */
	@SuppressWarnings("unchecked")
	public @org.jspecify.annotations.NonNull J setCacheControl(CacheControl enable)
	{
		Meta appleMeta = new Meta();
		appleMeta.addAttribute("name", "CACHE-CONTROL");
		appleMeta.addAttribute("content", enable.toString());
		page.getHead()
		    .add(appleMeta);
		if(enable.equals(CacheControl.NO_CACHE))
		{
			Meta pragme = new Meta();
			pragme.addAttribute("name", "PRAGMA");
			pragme.addAttribute("content", "NO-CACHE");
			page.getHead()
			    .add(pragme);

			Meta cacheControl = new Meta();
			cacheControl.addAttribute("name", "CACHE-CONTROL");
			cacheControl.addAttribute("content", "NO-CACHE");
			page.getHead()
			    .add(cacheControl);
		}
		return (J) this;
	}

	/**
	 * Removes Base from the Header
	 *
	 * @return Remove
	 */
	public final boolean removeBase()
	{
		return page.getHead()
		           .getChildren()
		           .remove(getBase());
	}

	/**
	 * Returns the Application Name of the page
	 *
	 * @return Meta The meta tag
	 */
	public final Base getBase()
	{
		return base;
	}

	/**
	 * Sets the Base of this page
	 *
	 * @param base
	 * 		The Base of the page
	 */
	@SuppressWarnings("unchecked")
	public @org.jspecify.annotations.NonNull J setBase(Base base)
	{
		this.base = base;
		if (base != null)
		{
			base.setPage(page);
		}
		return (J) this;
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
	 * Sets the canonical meta head attribute to the given URL
	 *
	 * @param url
	 * 		The url
	 *
	 * @return This
	 */
	@SuppressWarnings("unchecked")
	public @org.jspecify.annotations.NonNull J setCanonicalLink(String url)
	{
		page.getHead()
		    .add(new CSSLink("canonical", null, url));
		return (J) this;
	}

	/**
	 * Sets this icon (not-favicon) to the given url with the size
	 *
	 * @param iconUrl
	 * 		The image url
	 * @param sizes
	 * 		The size (e.g. 192x192)
	 *
	 * @return This
	 */
	@SuppressWarnings("unchecked")
	public @org.jspecify.annotations.NonNull J setIcon(String iconUrl, String sizes)
	{
		page.getHead()
		    .add(new CSSLink<>(null, "icon", iconUrl).addAttribute("sizes", sizes));
		return (J) this;
	}

	/**
	 * Sets this icon (not-favicon) to the given url with the size
	 *
	 * @param iconUrl
	 * 		The image url
	 * @param sizes
	 * 		The size (e.g. 192x192)
	 *
	 * @return This
	 */
	@SuppressWarnings("unchecked")
	public @org.jspecify.annotations.NonNull J setAppleTouchIconPrecomposed(String iconUrl, String sizes)
	{
		page.getHead()
		    .add(new CSSLink<>(null, "apple-touch-icon-precomposed", iconUrl).addAttribute("sizes", sizes));
		return (J) this;
	}

	/**
	 * Sets this icon (not-favicon) to the given url with the size
	 *
	 * @param iconUrl
	 * 		The image url
	 * @param sizes
	 * 		The size (e.g. 192x192)
	 *
	 * @return This
	 */
	@SuppressWarnings("unchecked")
	public @org.jspecify.annotations.NonNull J setMSApplicationTileImage(String iconUrl, String sizes)
	{
		page.getHead()
		    .add(new CSSLink<>(null, "msapplication-TileImage", iconUrl).addAttribute("sizes", sizes));
		return (J) this;
	}

	/**
	 * Sets this icon (not-favicon) to the given url with the size
	 *
	 * @return This
	 */
	@SuppressWarnings("unchecked")
	public @org.jspecify.annotations.NonNull J setAppleMobileAppCapable(boolean capable)
	{
		Meta appleMeta = new Meta();
		appleMeta.addAttribute("name", "apple-mobile-web-app-capable");
		appleMeta.addAttribute("content", capable ? "yes" : "no");
		page.getHead()
		    .add(appleMeta);
		return (J) this;
	}

	/**
	 * Sets the background translucent style (text white for apple devices. Background takes the color of the app
	 *
	 * @param style
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public @org.jspecify.annotations.NonNull J setAppleMobileStatusBarStyle(AppleMobileStatusBarStyles style)
	{
		Meta appleMeta = new Meta();
		appleMeta.addAttribute("name", "apple-mobile-web-app-status-bar-style");
		appleMeta.addAttribute("content", style.toString());
		page.getHead()
		    .add(appleMeta);
		return (J) this;
	}


}
