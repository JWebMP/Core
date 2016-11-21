/*
 * Copyright (C) 2016 ged_m
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

import com.fasterxml.jackson.annotation.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.List;
import java.util.logging.*;
import javax.servlet.http.*;
import net.sf.uadetector.*;
import za.co.mmagon.jwebswing.base.*;
import za.co.mmagon.jwebswing.base.angular.*;
import za.co.mmagon.jwebswing.base.client.*;
import za.co.mmagon.jwebswing.base.html.*;
import za.co.mmagon.jwebswing.base.html.attributes.*;
import za.co.mmagon.jwebswing.base.html.interfaces.children.*;
import za.co.mmagon.jwebswing.base.interfaces.*;
import za.co.mmagon.jwebswing.base.references.*;
import za.co.mmagon.jwebswing.base.servlets.*;
import za.co.mmagon.jwebswing.base.servlets.enumarations.*;
import za.co.mmagon.jwebswing.generics.*;

/**
 * Top level of any HTML page.
 * <p>
 * Has only two children, head and body.
 * <p>
 * Sometimes scripts are added right at the end but we try to avoid that as much as possible.
 *
 * @author GedMarc
 * @since 24 Apr 2016
 * @version 2.0
 *
 * Replacement of the old page object
 */
public class Page extends Html implements IPage
{

    private static final long serialVersionUID = 1L;

    /**
     * Whether or not to render pace loader
     */
    private boolean paceEnabled = true;
    /**
     * Whether or not to render jQuery
     */
    private boolean jQueryEnabled;
    /**
     * Whether or not to render jQuery UI
     */
    private boolean jQueryUIEnabled;
    /**
     * Whether or not to render angular
     */
    private boolean angularEnabled;
    /**
     * Whether or not to render bootstrap
     */
    private boolean bootstrapEnabled;
    /**
     * Whether or not to dynamic render the requirements
     */
    private boolean dynamicRender = true;
    /**
     * Whether or not modernizr is enabled
     */
    private boolean modernizrEnabled;

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
     * The current user agent of the render
     */
    @JsonIgnore
    private transient ReadableUserAgent userAgent;
    /**
     * The Servlet attached to this page
     */
    @JsonIgnore
    private JWebSwingServlet servlet;
    /**
     * The session of this page
     */
    @JsonIgnore
    private transient HttpSession session;

    /**
     * The angular feature
     */
    private AngularFeature angular;

    /**
     * Cache for all the associated components throughout the life-cycle of the application
     */
    private HashMap<String, ComponentHierarchyBase> componentCache;

    /**
     * Populates all my components. Excludes this page
     */
    /**
     * @param title             Sets the title of the page
     * @param compatibilityMode Sets the Internet explorer mode to work on
     * @param base              Sets the base tag for the page. Convenience Parameter
     */
    public Page(Title title, InternetExplorerCompatibilityMode compatibilityMode, Base base)
    {
        setTitle(title);
        setCompatibilityMode(compatibilityMode);
        setBase(base);
        setID("jwPage");
        //setGenerator("JWebSwing - https://sourceforge.net/projects/jwebswing/");
    }

    /**
     * @param title             Sets the title of the page
     * @param compatibilityMode Sets the Internet explorer mode to work on
     */
    public Page(Title title, InternetExplorerCompatibilityMode compatibilityMode)
    {
        this(title, compatibilityMode, null);
    }

    /**
     * @param title Sets the title of the page
     */
    public Page(Title title)
    {
        this(title, null, null);
    }

    /**
     * @param title Sets the title of the page
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
     * Renders all the children to a string builder
     *
     * @return
     */
    @Override
    protected StringBuilder renderChildren()
    {
        StringBuilder pageOutput = new StringBuilder();
        StringBuilder bodyOutput = null;

        if (!isBodyEmpty())
        {
            bodyOutput = new StringBuilder(getBody().toString(1));
        }
        if (!isHeadEmpty())
        {
            pageOutput.append(getNewLine()).append(getCurrentTabIndentString()).append(getHead().toString(1));
        }
        if (bodyOutput != null)
        {
            pageOutput.append(getNewLine()).append(getCurrentTabIndentString()).append(bodyOutput);
        }
        return pageOutput;
    }

    @Override
    public void init()
    {
        if (!isInitialized())
        {
            getBody().init();
        }
        super.init();
    }

    /**
     * Configures the page and all its components
     */
    @Override
    public void preConfigure()
    {
        if (!isInitialized())
        {
            init();
        }
        if (!isConfigured())
        {
            getBody().preConfigure();
            getAngular().preConfigure();

            configurePageHeader();

            addVariablesScriptToPage();

            addScriptsToBody();

            ArrayList<Script> allScripts = getJavaScript();
            allScripts.stream().filter(script -> (script != null)).forEach(getBody()::add);

            getTopShelfScripts().forEach(next ->
            {
                getHead().add((HeadChildren) next);
            });

            ArrayList<ComponentHierarchyBase> requirements = new ArrayList<>();

            for (RequirementsPriority priority : RequirementsPriority.values())
            {
                getPriorityRequirements(priority, requirements, true, false).stream().forEach((comp) ->
                {
                    getHead().getChildren().add(comp);
                });
            }
            getHead().add((HeadChildren) getCssStyle());

            buildComponentHierarchy();
        }
        super.preConfigure();
    }

    /**
     * Returns the component with only it's methods
     *
     * @return
     */
    public IPage asMe()
    {
        return this;
    }

    /**
     * Returns this pages current component cache
     *
     * @return
     */
    @Override
    public HashMap<String, ComponentHierarchyBase> getComponentCache()
    {
        if (componentCache == null)
        {
            componentCache = new HashMap<>();
        }
        return componentCache;
    }

    /**
     * Returns all the components currently associated with this page
     *
     * @return
     */
    public ArrayList<ComponentHierarchyBase> getAllComponents()
    {
        ArrayList<ComponentHierarchyBase> b = new ArrayList<>();
        b.addAll(this.componentCache.values());
        return b;
    }

    /**
     * Builds the component hierarchy from scratch
     */
    public void buildComponentHierarchy()
    {
        //getComponentCache().clear();
        getComponentCache().put(getBody().getID(), getBody());
        buildComponentHierarchy(getBody(), getComponentCache());
    }

    /**
     * Builds up or adds components to the page
     *
     * @param startingPoint The starting component to update with
     * @param addToMap      The map to add to
     */
    public void buildComponentHierarchy(ComponentHierarchyBase startingPoint, HashMap<String, ComponentHierarchyBase> addToMap)
    {
        startingPoint.getChildren().stream().filter((child) -> !(child == null)).map((child)
                ->
        {
            ComponentHierarchyBase c = (ComponentHierarchyBase) child;
            addToMap.put(c.getID(), c);
            return child;
        }).forEach((child)
                ->
        {
            ComponentHierarchyBase c = (ComponentHierarchyBase) child;
            if (child != null)
            {
                buildComponentHierarchy(c, addToMap);
            }
        });
    }

    /**
     * Sets the current component cache
     *
     * @param componentCache
     */
    @Override
    public void setComponentCache(HashMap<String, ComponentHierarchyBase> componentCache)
    {
        this.componentCache = componentCache;
    }

    /**
     * Returns the style object. If dynamic rendering is enabled it will point to the Servlet.
     *
     * @return
     */
    public ComponentHierarchyBase getCssStyle()
    {
        StringBuilder css = getBody().renderCss(0);
        if (!css.toString().isEmpty())
        {
            if (isDynamicRender())
            {
                CSSLink renderedCSS = new CSSLink("css");
                return renderedCSS;
            }
            else
            {
                if (css.length() > 0)
                {
                    Style style = new Style();
                    style.setText(css);
                    return style;
                }
            }
        }
        return null;
    }

    /**
     * Returns the top shelf script and css references
     *
     * @return
     */
    private ArrayList<ComponentHierarchyBase> getTopShelfScripts()
    {
        ArrayList<ComponentHierarchyBase> arr;
        arr = getPriorityRequirements(RequirementsPriority.Top_Shelf, new ArrayList<ComponentHierarchyBase>(), true, true);
        return arr;
    }

    /**
     * Returns the script reference
     *
     * @return
     */
    private ArrayList<Script> getJavaScript()
    {
        ArrayList<Script> allScripts = new ArrayList<>();

        if (isAngularEnabled())
        {
            if (isDynamicRender())
            {
                Script dynamicScript = new Script();
                dynamicScript.addAttribute(ScriptAttributes.Type, "application/javascript");
                dynamicScript.addAttribute(ScriptAttributes.Src, "as");
                //dynamicScript.setTiny(true);
                //dynamicScript.setText("$.ajax({cache:false,async:false,dataType:'script',url:'as'}).fail(function(){alert('session lost'); });");
                allScripts.add(dynamicScript);
            }
            else
            {
                StringBuilder js = getAngular().renderTemplateScripts("jwangular");// getBody().renderJavascriptAll();
                if (!js.toString().trim().isEmpty())
                {
                    Script s = new Script();
                    s.addAttribute(ScriptAttributes.Type, "application/javascript");
                    s.setText(js);
                    allScripts.add(s);
                }
            }
        }
        if (isDynamicRender())
        {
            StringBuilder js = getBody().renderJavascriptAll();
            // if (!js.toString().trim().isEmpty())
            {
                Script dynamicScript = new Script();
                dynamicScript.addAttribute(ScriptAttributes.Type, "application/javascript");
                dynamicScript.addAttribute(ScriptAttributes.Src, "js");
                //dynamicScript.setTiny(true);
                //dynamicScript.setText("$.ajax({cache:false,dataType:'script',url:'js'}).fail(function(){alert('session lost'); });");
                allScripts.add(dynamicScript);
            }
        }
        else
        {
            StringBuilder js = getBody().renderJavascriptAll();
            if (!js.toString().trim().isEmpty())
            {
                Script s = new Script();
                s.addAttribute(ScriptAttributes.Type, "application/javascript");
                s.setText(js);
                allScripts.add(s);
            }
        }

        return allScripts;
    }

    /**
     * Builds up the Header Tag
     */
    private void configurePageHeader()
    {
        if (title != null)
        {
            getHead().add(title);
        }
        if (base != null)
        {
            getHead().add(this.base);
        }
        getHead().add(this.httpEquivMeta);
        getHead().add(cacheControl);
        getHead().add(author);
        getHead().add(this.applicationNameMeta);
        getHead().add(this.generatorMeta);
        getHead().add(descriptionMeta);
        getHead().add(this.keywordsMeta);
        getHead().add(this.favIconLink);

        getHead().getChildren().stream().forEach((headObject)
                ->
        {
            headObject.preConfigure();
        });
    }

    /**
     * Adds the variables in the application to the collection
     */
    private void addVariablesScriptToPage()
    {
        StringBuilder variablesScriptBuilder = new StringBuilder();
        for (Iterator it = getBody().getVariablesAll().iterator(); it.hasNext();)
        {
            String var = (String) it.next();
            variablesScriptBuilder.append("var ").append(var).append(";");
        }
        if (variablesScriptBuilder.length() > 0)
        {
            Script variablesScript = new Script();
            variablesScript.setID("variables");
            variablesScript.setNewLineForRawText(true);
            variablesScript.addAttribute(ScriptAttributes.Type, "text/javascript");
            variablesScript.setText(variablesScriptBuilder.toString());
            if (!getHead().getChildren().contains(variablesScript))
            {
                getHead().add(variablesScript);
            }
        }
    }

    private void addScriptsToBody()
    {
        ArrayList<ComponentHierarchyBase> requirements = new ArrayList<>();

        ArrayList<RequirementsPriority> arrs = new ArrayList<>(Arrays.asList(RequirementsPriority.values()));
        //render JS only
        arrs.stream().filter(a -> a != RequirementsPriority.Top_Shelf).map(priority ->
        {
            if (!getPriorityRequirements(priority, requirements, true, false).isEmpty())
            {
                //getBody().add(new Comment("Priority [" + priority + "] Values"));
            }
            return priority;
        }).forEachOrdered(priority ->
        {
            getPriorityRequirements(priority, requirements, false, true).stream().forEach(comp
                    ->
            {
                getBody().add(comp);
            });
        });
    }

    /**
     * Adds all the stuff for a given priority
     *
     * @param css        CSS
     * @param input      the hierarchy to read from
     * @param priority   the priority
     * @param javascript to return JavaScript or not
     */
    private ArrayList<ComponentHierarchyBase> getPriorityRequirements(RequirementsPriority priority, ArrayList<ComponentHierarchyBase> input, boolean css, boolean javascript)
    {
        ArrayList<ComponentHierarchyBase> requirements = new ArrayList<>();
        if (css)
        {
            getAllCssLinks(priority).stream().filter(cssLink -> (!input.contains(cssLink) && !requirements.contains(cssLink))).forEach(cssLink
                    ->
            {
                requirements.add(cssLink);
            });
        }
        if (javascript)
        {
            getAllScripts(priority).stream().filter(script -> (!input.contains(script) && !requirements.contains(script))).forEach(script
                    ->
            {
                requirements.add(script);
            });
        }

        return requirements;
    }

    /**
     * Gets all the links for all the bodies components
     *
     * @param priority
     *
     * @return
     */
    private List<CSSLink> getAllCssLinks(RequirementsPriority priority)
    {
        List<CSSReference> allReferences = getBody().getCssReferencesAll(priority);
        allReferences.sort(WebReference.getDummyReference());
        ArrayList<CSSLink> allLinks = new ArrayList<>();
        allReferences.stream().map(ref -> new CSSLink(ref)).forEach(allLinks::add);
        return allLinks;
    }

    /**
     * Gets all the scripts for all the body components
     *
     * @param priority
     *
     * @return
     */
    private List<Script> getAllScripts(RequirementsPriority priority)
    {
        List<JavascriptReference> allJavascripts = getBody().getJavascriptReferencesAll(priority);
        allJavascripts.sort(WebReference.getDummyReference());
        ArrayList<Script> allScripts = new ArrayList<>();
        allJavascripts.stream().map(js -> new Script(js)).forEach(s
                ->
        {
            s.setNewLineForClosingTag(false);
            allScripts.add(s);
        });
        return allScripts;
    }

    /**
     * Returns if the head object is empty
     *
     * @return
     */
    private boolean isHeadEmpty()
    {
        return getHead().getChildren().isEmpty();
    }

    /**
     * Returns if the body object is empty
     *
     * @return
     */
    private boolean isBodyEmpty()
    {
        return getBody().getChildren().isEmpty();
    }

    /**
     * Whether or not to render the JQuery requirements
     *
     * @return
     */
    @Override
    public boolean isjQueryEnabled()
    {
        return jQueryEnabled;
    }

    /**
     * Whether or not to render the JQuery Requirements
     *
     * @param jQueryEnabled
     */
    @Override
    public void setjQueryEnabled(boolean jQueryEnabled)
    {
        this.jQueryEnabled = jQueryEnabled;
        if (this.jQueryEnabled)
        {
            getBody().configureJQuery();
        }
    }

    /**
     * Whether or not to render the JQuery UI Requirements
     *
     * @return
     */
    @Override
    public boolean isjQueryUIEnabled()
    {
        return jQueryUIEnabled;
    }

    /**
     * Whether or not to render the JQuery UI Requirements
     *
     * @param jQueryUIEnabled
     */
    @Override
    public void setjQueryUIEnabled(boolean jQueryUIEnabled)
    {
        this.jQueryUIEnabled = jQueryUIEnabled;
        if (jQueryUIEnabled)
        {
            setjQueryEnabled(true);
            getBody().configureJQueryUI();
        }
    }

    /**
     * whether or not to render angular
     *
     * @return
     */
    @Override
    public boolean isAngularEnabled()
    {
        return angularEnabled;
    }

    /**
     * Whether or not to render angular
     *
     * @param angularEnabled
     */
    @Override
    public void setAngularEnabled(boolean angularEnabled)
    {
        this.angularEnabled = angularEnabled;
        if (angularEnabled)
        {
            setjQueryEnabled(true);
            getBody().configureAngular();
        }
    }

    /**
     * Whether or not to render bootstrap
     *
     * @return
     */
    @Override
    public boolean isBootstrapEnabled()
    {
        return bootstrapEnabled;
    }

    /**
     * Whether or not to render bootstrap
     *
     * @param bootstrapEnabled
     */
    @Override
    public void setBootstrapEnabled(boolean bootstrapEnabled)
    {
        this.bootstrapEnabled = bootstrapEnabled;
        if (bootstrapEnabled)
        {
            getBody().configureBootstrap();
        }
    }

    /**
     * Returns if pace should be set as the default render
     *
     * @return
     */
    @Override
    public boolean isPaceEnabled()
    {
        return paceEnabled;
    }

    /**
     * Sets if pace should be rendered s the default loader
     *
     * @param paceEnabled
     */
    @Override
    public void setPaceEnabled(boolean paceEnabled)
    {
        this.paceEnabled = paceEnabled;
        getBody().configurePace();
    }

    /**
     * Sets the author of this page
     *
     * @param author The author of this page
     */
    @Override
    public final void setAuthor(String author)
    {
        this.author = new Meta(Meta.MetadataFields.Author, author);
    }

    /**
     * Sets the description of this page
     *
     * @param description The description of the page
     */
    @Override
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
    @Override
    public final Meta getDescription()
    {
        return descriptionMeta;
    }

    /**
     * Returns the Application Name of the page
     *
     * @return Meta The meta tag
     */
    @Override
    public final Meta getApplicationName()
    {
        return applicationNameMeta;
    }

    /**
     * Sets the Application Name of this page
     *
     * @param applicationName The Application Name of the page
     */
    @Override
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
    @Override
    public final Meta getGenerator()
    {
        return generatorMeta;
    }

    /**
     * Sets the Generator of this page
     *
     * @param Generator The Generator of the page
     */
    @Override
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
    @Override
    public final Meta getKeywords()
    {
        return keywordsMeta;
    }

    /**
     * Sets the Keywords of this page
     *
     * @param Keywords The Keywords of the page
     */
    @Override
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
    @Override
    public final boolean removeTitle()
    {
        return getHead().getChildren().remove(getTitle());
    }

    /**
     * Returns the Application Name of the page
     *
     * @return Meta The meta tag
     */
    @Override
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
    @Override
    public final String getCompatibilityMode(int dummyInt)
    {
        return httpEquivMeta.getAttribute(MetaAttributes.Http_Equiv);
    }

    /**
     * Sets the Application Name of this page Null removes compatibility specification
     *
     * @param httpEquiv The Application Name of the page
     */
    @Override
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
     * Is Modernizr Enabled
     *
     * @return
     */
    @Override
    public boolean isModernizrEnabled()
    {
        return modernizrEnabled;
    }

    /**
     * Sets if Modernizr is enabled
     *
     * @param modernizrEnabled
     */
    @Override
    public void setModernizrEnabled(boolean modernizrEnabled)
    {
        this.modernizrEnabled = modernizrEnabled;
        getBody().configureModernizr();
    }

    /**
     * Sets the Icon in the browser address bar
     *
     * @param favIconURL The path to the icon
     */
    @Override
    public void setFavIcon(String favIconURL)
    {
        favIconLink.addAttribute(CSSLinkAttributes.Rel, "icon");
        String favType = favIconURL.substring(favIconURL.lastIndexOf("."));
        String mimeType = "";
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
    @Override
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
    @Override
    public Meta getCacheControl()
    {
        return cacheControl;
    }

    /**
     * Returns the Application Name of the page
     *
     * @return Meta The meta tag
     */
    @Override
    public final Base getBase()
    {
        return this.base;
    }

    /**
     * Returns the Application Name of the page
     *
     * @return Meta The meta tag
     */
    @Override
    public final Title getTitle()
    {
        return this.title;
    }

    /**
     * Sets the Title of this page
     *
     * @param Title The Title of the page
     */
    @Override
    public final void setTitle(Title Title)
    {
        this.title = Title;
        if (title != null)
        {
            title.setPage(this);
        }
    }

    /**
     * Sets the Title of this page
     *
     * @param Title The Title of the page
     */
    @Override
    public final void setTitle(String Title)
    {
        this.title = new Title(Title);
        if (title != null)
        {
            title.setPage(this);
        }
    }

    /**
     * Sets the Base of this page
     *
     * @param base The Base of the page
     */
    @Override
    public final void setBase(Base base)
    {
        this.base = base;
        if (base != null)
        {
            base.setPage(this);
        }
    }

    /**
     * Removes Base from the Header
     *
     * @return Remove
     */
    @Override
    public final boolean removeBase()
    {
        return getHead().getChildren().remove(getBase());
    }

    /**
     * Returns a readable user agent, or null if just a basic render
     *
     * @return
     */
    @Override
    public ReadableUserAgent getUserAgent()
    {
        if (userAgent == null)
        {
            userAgent = new UserAgent(DeviceCategory.EMPTY, UserAgentFamily.FIREFOX, "", "", OperatingSystem.EMPTY, "", "", UserAgentType.BROWSER, "", "", VersionNumber.UNKNOWN);
        }
        return userAgent;
    }

    /**
     * Sets the userAgent
     *
     * @param userAgent
     */
    @Override
    public void setUserAgent(ReadableUserAgent userAgent)
    {
        this.userAgent = userAgent;
    }

    /**
     * Returns the attached session if available
     *
     * @return HTTPSession or NULL
     */
    @Override
    public final HttpSession getSession()
    {
        return session;
    }

    /**
     * Sets this pages session
     *
     * @param session HttpSession or null
     */
    @Override
    public final void setSession(HttpSession session)
    {
        this.session = session;
    }

    /**
     * Returns the Servlet processing requests
     *
     * @return The JWebSwingServlet
     */
    @Override
    public JWebSwingServlet getServlet()
    {
        return servlet;
    }

    /**
     * Sets the Servlet to a new Servlet
     *
     * @param servlet The Servlet to set
     */
    @Override
    public void setServlet(JWebSwingServlet servlet)
    {
        this.servlet = servlet;
    }

    /**
     * Whether or not to dynamic render the requirements
     *
     * @return
     */
    @Override
    public boolean isDynamicRender()
    {
        return dynamicRender;
    }

    /**
     * Whether or not to dynamic render the requirements
     *
     * @param dynamicRender
     */
    @Override
    public void setDynamicRender(boolean dynamicRender)
    {
        this.dynamicRender = dynamicRender;
    }

    /**
     * Returns the document type that will be rendered with this HTML page real-time
     * <p>
     * @return Document Type
     */
    @Override
    public DocumentType getDocumentType()
    {
        return new DocumentType(getBrowser().getHtmlVersion());
    }

    /**
     * Sets all component in the head and body to tiny
     *
     * @param tiny
     *
     * @return
     */
    @Override
    public Page setTiny(boolean tiny)
    {
        super.setTiny(tiny);
        getHead().setTiny(tiny);
        getBody().setTiny(tiny);
        return this;
    }

    /**
     * Returns the JavaScript render for the body
     *
     * @return
     */
    @Override
    public StringBuilder renderJavascript()
    {
        return getBody().renderJavascript();
    }

    /**
     * Adds a variable into angular
     *
     * @param variableName
     *
     * @return
     */
    @Override
    public Page addAngularVariable(String variableName)
    {
        getAngular().getAngularVariables().add(variableName);
        return this;
    }

    /**
     * Returns the angular object
     *
     * @return
     */
    @Override
    public AngularFeature getAngular()
    {
        if (angular == null)
        {
            angular = new AngularFeature(getBody());
            getBody().addFeature(angular);
        }
        return angular;
    }
}
