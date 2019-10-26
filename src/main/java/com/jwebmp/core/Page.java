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
import com.google.inject.servlet.RequestScoped;
import com.jwebmp.core.annotations.PageConfiguration;
import com.jwebmp.core.base.ComponentFeatureBase;
import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.client.InternetExplorerCompatibilityMode;
import com.jwebmp.core.base.html.*;
import com.jwebmp.core.base.html.attributes.ScriptAttributes;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.references.CSSReference;
import com.jwebmp.core.base.references.JavascriptReference;
import com.jwebmp.core.base.servlets.SessionStorageProperties;
import com.jwebmp.core.services.IPage;
import com.jwebmp.core.services.IPageConfigurator;
import com.jwebmp.core.utilities.StaticStrings;
import com.guicedee.guicedinjection.GuiceContext;
import com.guicedee.logger.LogFactory;
import net.sf.uadetector.*;

import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.jwebmp.core.services.JWebMPServicesBindings.*;
import static com.guicedee.guicedinjection.GuiceContext.*;

/**
 * Top level of any HTML page.
 * <p>
 * Has only two children, head and body.
 * <p>
 * Sometimes scripts are added right at the end but we try to avoid that as much as possible.
 *
 * @author GedMarc
 * @version 2.0
 * 		<p>
 * 		Replacement of the old page object
 * @since 24 Apr 2016
 */
@SuppressWarnings({"NullableProblems", "unused"})
@PageConfiguration
@RequestScoped
public class Page<J extends Page<J>>
		extends Html<IComponentHierarchyBase, J>
		implements IPage
{
	private static final Logger log = LogFactory.getInstance()
	                                            .getLogger("Page");
	/**
	 * The options available
	 */
	private PageOptions options;

	/**
	 * The current user agent of the render
	 */
	@JsonIgnore
	private ReadableUserAgent userAgent;

	/**
	 * If this page has already gone through initialization
	 */
	private boolean pageInitialized;

	/**
	 * @param title
	 * 		Sets the title of the page
	 * @param compatibilityMode
	 * 		Sets the Internet explorer mode to work on
	 */
	public Page(Title title, InternetExplorerCompatibilityMode compatibilityMode)
	{
		this(title, compatibilityMode, null);
	}

	/**
	 * Populates all my components. Excludes this page
	 *
	 * @param title
	 * 		Sets the title of the page
	 * @param compatibilityMode
	 * 		Sets the Internet explorer mode to work on
	 * @param base
	 * 		Sets the base tag for the page. Convenience Parameter
	 */
	public Page(Title title, InternetExplorerCompatibilityMode compatibilityMode, Base base)
	{
		this.getOptions().setTitle(title);
		this.getOptions().setCompatibilityMode(compatibilityMode);
		this.getOptions().setBase(base);
		setID("jwPage");
	}

	/**
	 * @param title
	 * 		Sets the title of the page
	 */
	public Page(Title title)
	{
		this(title, null, null);
	}

	/**
	 * @param title
	 * 		Sets the title of the page
	 */
	public Page(String title)
	{
		this(new Title(title), null, null);
	}

	/**
	 * Constructs an empty page object
	 */
	public Page()
	{
		this(null, null, null);
	}

	/**
	 * Adds the text as a given paragraph
	 *
	 * @param addText
	 * 		The text to add to the body
	 *
	 * @return This
	 *
	 * @see Component#add(String)
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J add(@NotNull String addText)
	{
		getBody().add(addText);
		return (J) this;
	}

	/**
	 * Initializes the page
	 */
	public void initialize()
	{
		//Interception Marker
	}

	/**
	 * Gets called when the client makes a valid request.
	 * <p>
	 * Local Storage, Modernizr and Session Storage are available at the time of this call
	 *
	 * @param call
	 * 		The retrieved ajax call request scoped
	 * @param response
	 * 		The response ajax call request scoped
	 *
	 * @return Not null
	 */
	@SuppressWarnings("unused")
	@NotNull
	public AjaxResponse onConnect(AjaxCall<?> call, AjaxResponse<?> response)
	{
		return response;
	}

	/**
	 * Adds a css reference to the body
	 *
	 * @param cssReference
	 * 		the reference to add
	 *
	 * @return Always this
	 *
	 * @see com.jwebmp.core.base.ComponentDependancyBase#addCssReference(CSSReference)
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J addCssReference(CSSReference cssReference)
	{
		getBody().addCssReference(cssReference);
		return (J) this;
	}

	/**
	 * Adds a java script reference to the body
	 *
	 * @param jsReference
	 * 		Adds a javascript reference to the body
	 *
	 * @return This page
	 *
	 * @see com.jwebmp.core.base.ComponentDependancyBase#addJavaScriptReference(JavascriptReference)
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J addJavaScriptReference(JavascriptReference jsReference)
	{
		getBody().addJavaScriptReference(jsReference);
		return (J) this;
	}

	/**
	 * Returns the CSS references from the bdoy
	 *
	 * @return A set of references
	 *
	 * @see com.jwebmp.core.base.ComponentDependancyBase#getCssReferences()
	 */
	@Override
	public Set<CSSReference> getCssReferences()
	{
		return getBody().getCssReferences();
	}

	/**
	 * Gets the java script references from the body object
	 *
	 * @return A set of javascript references
	 *
	 * @see com.jwebmp.core.base.ComponentDependancyBase#getJavascriptReferences()
	 */
	@Override
	public Set<JavascriptReference> getJavascriptReferences()
	{
		return getBody().getJavascriptReferences();
	}

	/**
	 * Adds a feature to the collection
	 *
	 * @param feature
	 *
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J addFeature(@NotNull ComponentFeatureBase feature)
	{
		getBody().addFeature(feature);
		return (J) this;
	}

	/**
	 * Adds a variable to the collection
	 *
	 * @param variable
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J addVariable(@NotNull String variable)
	{
		getBody().addVariable(variable);
		return (J) this;
	}

	/**
	 * Returns all the dynamic options for a page
	 *
	 * @return The options with the page
	 *
	 * @see com.jwebmp.core.base.ComponentFeatureBase#getOptions()
	 */
	@Override
	@NotNull
	public PageOptions getOptions()
	{
		if (options == null)
		{
			options = new PageOptions(this);
		}
		return options;
	}

	/**
	 * Returns the JavaScript render for the body
	 *
	 * @return A single string builder containing all the java scripts applicable
	 *
	 * @see com.jwebmp.core.base.ComponentFeatureBase#renderJavascript()
	 */
	@NotNull
	@Override
	public StringBuilder renderJavascript()
	{
		return getBody().renderJavascriptAll();
	}

	/**
	 * Returns the queries
	 *
	 * @return The bodies direct queries
	 */
	@NotNull
	@Override
	public Set<StringBuilder> getQueries()
	{
		return getBody().getQueries();
	}

	/**
	 * Method destroy ...
	 */
	@Override
	public void destroy()
	{
		if (getHead() != null)
		{
			getHead().destroy();
		}
		if (getBody() != null)
		{
			getBody().destroy();
		}
		options = null;
		userAgent = null;

		super.destroy();
	}

	/**
	 * Returns the component with only it's methods
	 *
	 * @return Returns a trimmed out version of this page
	 */
	public IPage asMe()
	{
		return this;
	}

	/**
	 * Whether or not the page is initialized
	 *
	 * @return If initialized or not
	 */
	public boolean isPageInitialized()
	{
		return pageInitialized;
	}

	/**
	 * Sets if the page is initialized
	 *
	 * @param pageInitialized
	 * 		If this page is initialized
	 */
	public void setPageInitialized(boolean pageInitialized)
	{
		this.pageInitialized = pageInitialized;
	}

	/**
	 * Method hashCode ...
	 *
	 * @return int
	 */
	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	/**
	 * Method equals ...
	 *
	 * @param o
	 * 		of type Object
	 *
	 * @return boolean
	 */
	@Override
	public boolean equals(Object o)
	{
		return super.equals(o);
	}

	/**
	 * Returns the document type that will be rendered with this HTML page real-time
	 * <p>
	 *
	 * @return Document Type
	 */
	@Override
	@NotNull
	public DocumentType getDocumentType()
	{
		return new DocumentType(getBrowser().getHtmlVersion());
	}


	/**
	 * Returns if the user agent string registered the device as mobile
	 *
	 * @return If the header agent reads as smartphone smart tv or tablet
	 *
	 * @see com.jwebmp.core.services.IPage#isMobileOrSmartTablet()
	 */
	@Override
	public boolean isMobileOrSmartTablet()
	{
		Set<ReadableDeviceCategory.Category> mobiles = EnumSet.of(ReadableDeviceCategory.Category.SMARTPHONE, ReadableDeviceCategory.Category.SMART_TV,
		                                                          ReadableDeviceCategory.Category.TABLET);
		return mobiles.contains(getUserAgent().getDeviceCategory()
		                                      .getCategory());
	}

	/**
	 * Returns a readable user agent, or null if just a basic render
	 *
	 * @return The user agent, or an empty identifiable
	 */
	@NotNull
	public ReadableUserAgent getUserAgent()
	{
		if (userAgent == null)
		{
			try
			{
				ReadableUserAgent agent = GuiceContext.get(ReadableUserAgent.class);
				setUserAgent(agent);
			}
			catch (Throwable T)
			{
				Page.log.log(Level.FINER, "Readable User Agent can't be fetched, returning default", T);
				userAgent = new UserAgent(DeviceCategory.EMPTY, UserAgentFamily.FIREFOX, StaticStrings.STRING_EMPTY, StaticStrings.STRING_EMPTY, OperatingSystem.EMPTY,
				                          StaticStrings.STRING_EMPTY, StaticStrings.STRING_EMPTY,
				                          UserAgentType.BROWSER, StaticStrings.STRING_EMPTY, StaticStrings.STRING_EMPTY, VersionNumber.UNKNOWN);
			}
		}
		return userAgent;
	}

	/**
	 * Sets the userAgent
	 *
	 * @param userAgent
	 * 		Sets the referenced user agent
	 *
	 * @see com.jwebmp.core.services.IPage#setUserAgent(ReadableUserAgent)
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J setUserAgent(ReadableUserAgent userAgent)
	{
		this.userAgent = userAgent;
		return (J) this;
	}

	/**
	 * Sets all component in the head and body to tiny
	 *
	 * @param tiny
	 * 		Sets this object, the head, and the body to tiny
	 *
	 * @return Always this
	 *
	 * @see com.jwebmp.core.base.ComponentHierarchyBase#setTiny(boolean)
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J setTiny(boolean tiny)
	{
		super.setTiny(tiny);
		getHead().setTiny(tiny);
		getBody().setTiny(tiny);
		return (J) this;
	}

	/**
	 * Method adds to the body
	 *
	 * @param child
	 * 		of type IComponentHierarchyBase
	 *
	 * @return J
	 */
	@SuppressWarnings("unchecked")
	@Override
	public J add(@NotNull IComponentHierarchyBase child)
	{
		getBody().add(child);
		return (J) this;
	}

	@Override
	public @NotNull Set<ComponentHierarchyBase<IComponentHierarchyBase, ?, ?, ?, ?>> getChildrenHierarchy()
	{
		Set<ComponentHierarchyBase<IComponentHierarchyBase, ?, ?, ?, ?>> pageChildren = new LinkedHashSet<>();
		pageChildren.addAll(getHead().getChildrenHierarchy(true));
		pageChildren.addAll(getBody().getChildrenHierarchy(true));
		pageChildren.add(this);
		return pageChildren;
	}

	/**
	 * Overidden method to return this, beware circular joins
	 *
	 * @return Hard override to this page
	 *
	 * @see com.jwebmp.core.base.ComponentHierarchyBase#getPage()
	 */
	@Override
	@NotNull
	public Page getPage()
	{
		return this;
	}

	/**
	 * Configures the page and all its components
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void preConfigure()
	{
		if (!isInitialized())
		{
			init();
		}
		if (!isConfigured())
		{
			configurePage();

			getHead().preConfigure();
			getBody().preConfigure();

			configurePageHeader();
			addVariablesScriptToPage();
		}
		super.preConfigure();
		setConfigured(true);
	}

	/**
	 * Returns all the feature queries associated to this component and all its children
	 *
	 * @return The bodies list of queries
	 */
	@NotNull
	@Override
	public Set<StringBuilder> getQueriesAll()
	{
		return getBody().getQueriesAll();
	}

	/**
	 * Renders all the children to a string builder
	 *
	 * @return The string representation of this page
	 *
	 * @see com.jwebmp.core.base.ComponentHierarchyBase#renderChildren()
	 */
	@NotNull
	@Override
	protected StringBuilder renderChildren()
	{
		StringBuilder pageOutput = new StringBuilder();
		StringBuilder bodyOutput = null;

		boolean bodied = false;
		boolean headed = false;

		if (!isBodyEmpty())
		{
			bodyOutput = new StringBuilder(getBody().toString(1));
		}
		if (!isHeadEmpty())
		{
			pageOutput.append(getNewLine())
			          .append(getCurrentTabIndentString())
			          .append(getHead().toString(1))
			          .append(getNewLine());
			headed = true;
		}
		if (bodyOutput != null)
		{
			pageOutput.append(getNewLine())
			          .append(getCurrentTabIndentString())
			          .append(bodyOutput)
			          .append(getNewLine());
			bodied = true;
		}

		if (!headed && !bodied)
		{
			pageOutput.append(getNewLine());
		}
		return pageOutput;
	}

	/**
	 * Returns if the body object is empty
	 *
	 * @return if the body is empty
	 */
	private boolean isBodyEmpty()
	{
		return getBody().getChildren()
		                .isEmpty();
	}

	/**
	 * Returns if the head object is empty
	 *
	 * @return if the head is empty
	 */
	private boolean isHeadEmpty()
	{
		return getHead().getChildren()
		                .isEmpty();
	}

	/**
	 * Initialize all children
	 */
	@Override
	public void init()
	{
		if (!pageInitialized)
		{
			getHead().init();
			getBody().init();
			pageInitialized = true;
		}
		setInitialized(true);
	}

	/**
	 * Method configurePage ...
	 */
	@SuppressWarnings("unchecked")
	private void configurePage()
	{
		Set<IPageConfigurator> sortedConfigurators = new LinkedHashSet<>(GuiceContext.get(IPageConfiguratorsKey));
		sortedConfigurators.removeIf(a -> !a.enabled());
		for (IPageConfigurator sortedConfigurator : sortedConfigurators)
		{
			Page.log.log(Level.FINEST, "Loading IPageConfigurator - " +
			                           sortedConfigurator.getClass()
			                                             .getSimpleName());
			sortedConfigurator.configure(this);
		}
	}

	/**
	 * Builds up the Header Tag
	 */
	@SuppressWarnings("unchecked")
	private void configurePageHeader()
	{
		if (this.getOptions().getTitle() != null)
		{
			getHead().add(this.getOptions().getTitle());
		}
		if (this.getOptions().getBase() != null)
		{
			getHead().add(this.getOptions().getBase());
		}
		if (this.getOptions().getHttpEquivMeta() != null)
		{
			getHead().add(this.getOptions().getHttpEquivMeta());
		}
		if (this.getOptions().getCacheControl() != null)
		{
			getHead().add(this.getOptions().getCacheControl());
		}
		if (this.getOptions().getAuthor() != null)
		{
			getHead().add(this.getOptions().getAuthor());
		}
		if (this.getOptions().getApplicationName() != null)
		{
			getHead().add(this.getOptions().getApplicationName());
		}
		if (this.getOptions().getGenerator() != null)
		{
			getHead().add(this.getOptions().getGenerator());
		}
		if (this.getOptions().getDescription() != null)
		{
			getHead().add(this.getOptions().getDescription());
		}
		if (this.getOptions().getKeywords() != null)
		{
			getHead().add(this.getOptions().getKeywords());
		}
		if (this.getOptions().getFavIconLink() != null)
		{
			getHead().add(this.getOptions().getFavIconLink());
		}
	}

	/**
	 * Adds the variables in the application to the collection
	 */
	@SuppressWarnings("unchecked")
	private void addVariablesScriptToPage()
	{
		StringBuilder variablesScriptBuilder = new StringBuilder();
		for (Object o : getBody().getVariablesAll())
		{
			String var = (String) o;
			variablesScriptBuilder.append("var ")
			                      .append(var)
			                      .append(StaticStrings.STRING_SEMICOLON);
		}
		if (variablesScriptBuilder.length() > 0)
		{
			Script variablesScript = new Script();
			variablesScript.setID("variables");
			variablesScript.setNewLineForRawText(true);
			variablesScript.addAttribute(ScriptAttributes.Type, StaticStrings.HTML_HEADER_JAVASCRIPT);
			variablesScript.setText(variablesScriptBuilder.toString());
			if (!getHead().getChildren()
			              .contains(variablesScript))
			{
				getHead().add(variablesScript);
			}
		}
	}


	/**
	 * Gets the local storage key from the system
	 */
	@SuppressWarnings("unchecked")
	public UUID getLocalStorageKey()
	{
		SessionStorageProperties sp = get(SessionStorageProperties.class);
		Map<String, String> localStorage = sp.getLocalStorage();
		if (!localStorage.containsKey(StaticStrings.LOCAL_STORAGE_PARAMETER_KEY))
		{
			String uuid = UUID.randomUUID()
			                  .toString();
			String clientIP = SessionHelper.getClientIPAddress();
			get(AjaxResponse.class).getLocalStorage()
			                       .put(StaticStrings.LOCAL_STORAGE_PARAMETER_KEY, uuid);

			localStorage.put(StaticStrings.LOCAL_STORAGE_PARAMETER_KEY, uuid);
		}
		String guid = localStorage.get(StaticStrings.LOCAL_STORAGE_PARAMETER_KEY);
		return UUID.fromString(guid);
	}

}
