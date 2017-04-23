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

import com.armineasy.injection.GuiceContext;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.uadetector.*;
import za.co.mmagon.FileTemplates;
import za.co.mmagon.SessionHelper;
import za.co.mmagon.jwebswing.annotations.PageConfiguration;
import za.co.mmagon.jwebswing.base.*;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.angular.AngularPageConfigurator;
import za.co.mmagon.jwebswing.base.client.InternetExplorerCompatibilityMode;
import za.co.mmagon.jwebswing.base.html.*;
import za.co.mmagon.jwebswing.base.html.attributes.ScriptAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.children.HeadChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.base.references.JavascriptReference;
import za.co.mmagon.jwebswing.base.servlets.JWScriptServlet;
import za.co.mmagon.jwebswing.base.servlets.enumarations.DevelopmentEnvironments;
import za.co.mmagon.jwebswing.base.servlets.enumarations.RequirementsPriority;
import za.co.mmagon.jwebswing.base.servlets.interfaces.IPage;
import za.co.mmagon.jwebswing.generics.WebReference;
import za.co.mmagon.logger.LogFactory;

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
@PageConfiguration
public class Page extends Html implements IPage
{

    private static final long serialVersionUID = 1L;

    private static final Logger log = LogFactory.getInstance().getLogger("Page");
    /**
     * The options available
     */
    private PageOptions options;
    /**
     * The fields available
     */
    private PageFields fields;

    /**
     * The current user agent of the render
     */
    @JsonIgnore
    private transient ReadableUserAgent userAgent;

    /**
     * The angular feature
     */
    private AngularPageConfigurator angular;

    /**
     * Cache for all the associated components throughout the life-cycle of the application
     */
    private transient java.util.Map<String, ComponentHierarchyBase> componentCache;

    /**
     * If this page has already gone through initialization
     */
    private boolean pageInitialized;

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
        getPageFields().setTitle(title);
        getPageFields().setCompatibilityMode(compatibilityMode);
        getPageFields().setBase(base);
        setID("jwPage");
        if (getRunningEnvironment().ordinal() >= DevelopmentEnvironments.QA.ordinal())
        {
            getPageFields().setGenerator("https://sourceforge.net/projects/jwebswing/");
        }

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
     * Initializes the page
     */
    public void initialize()
    {

    }

    /**
     * Gets called when the client makes a valid request.
     * <p>
     * Local Storage, Modernizr and Session Storage are available at the time of this call
     *
     * @param call
     * @param response
     *
     * @return
     */
    public AjaxResponse onConnect(AjaxCall call, AjaxResponse response)
    {
        return response;
    }

    /**
     * Adds a component onto the body
     *
     * @param <T>
     * @param component
     *
     * @return
     */
    public <T extends ComponentHierarchyBase> T add(T component)
    {
        return (T) getBody().add(component);
    }

    @Override
    public ComponentDependancyBase addCssReference(CSSReference cssReference)
    {
        return getBody().addCssReference(cssReference);
    }

    @Override
    public void addVariable(String variable)
    {
        getBody().addVariable(variable);
    }

    @Override
    public ComponentDependancyBase addJavaScriptReference(JavascriptReference jsReference)
    {
        return getBody().addJavaScriptReference(jsReference);
    }

    @Override
    public ComponentEventBase addEvent(GlobalEvents event)
    {
        return getBody().addEvent(event);
    }

    @Override
    public ComponentFeatureBase addFeature(ComponentFeatureBase feature)
    {
        return getBody().addFeature(feature);
    }

    @Override
    public ComponentFeatureBase addFeature(ComponentFeatureBase feature, int position)
    {
        return getBody().addFeature(feature, position);
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
        if (!pageInitialized)
        {
            getBody().preConfigure();
            pageInitialized = true;
        }

        if (!isInitialized())
        {
            log.log(Level.FINE, "Looking for plugins....");

            /*
             * Set<Class<?>> plugins = GuiceContext.reflect().getTypesAnnotatedWith(PluginInformation.class); for (Class plugin : plugins) { PluginInformation pi = (PluginInformation)
             * plugin.getAnnotation(PluginInformation.class); log.log(Level.FINE, "Plugin Found - {0} - version - {1}", new Object[] { pi.pluginName(), pi.pluginVersion() }); } log.log(Level.FINE,
             * "Plugins Completed");
             */
            GuiceContext.reflect().getSubTypesOf(PageConfigurator.class).stream().parallel().forEachOrdered(next ->
            {
                log.log(Level.FINE, "Running configuration : [{0}]", next.getSimpleName());
                PageConfigurator configurator = GuiceContext.inject().getInstance(next);
                configurator.configure(this);
                log.log(Level.FINE, "Configuration Completed : [{0}]", next.getSimpleName());
            });

            getBody().init();
            getBody().preConfigure();
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
            configurePageHeader();
            addVariablesScriptToPage();

            if (!getOptions().isScriptsInHead())
            {
                addScriptsTo(getBody());
            }

            if (!getOptions().isScriptsInHead())
            {
                List<Script> allScripts = getDynamicScripts();
                allScripts.stream().filter(script -> (script != null)).forEach(getBody()::add);
            }

            if (!getTopShelfScripts().isEmpty())
            {
                if (getRunningEnvironment().ordinal() >= DevelopmentEnvironments.Development.ordinal())
                {
                    getHead().add(new Comment("Priority [" + RequirementsPriority.Top_Shelf + "] Values"));
                }
            }
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
    public java.util.Map<String, ComponentHierarchyBase> getComponentCache()
    {
        if (componentCache == null)
        {
            componentCache = new HashMap<>();
            buildComponentHierarchy();
        }
        return componentCache;
    }

    /**
     * Returns all the components currently associated with this page
     *
     * @return
     */
    @Override
    public List<ComponentHierarchyBase> getAllComponents()
    {
        return (List<ComponentHierarchyBase>) getComponentCache().values();
    }

    /**
     * Builds the component hierarchy from scratch
     */
    public void buildComponentHierarchy()
    {
        //getComponentCache().clear();
        //getComponentCache().put(getBody().getID(), getBody());
        buildComponentHierarchy(getBody(), getComponentCache());
    }

    /**
     * Builds up or adds components to the page
     *
     * @param startingPoint The starting component to update with
     * @param addToMap      The map to add to
     */
    public void buildComponentHierarchy(ComponentHierarchyBase startingPoint, java.util.Map<String, ComponentHierarchyBase> addToMap)
    {
        startingPoint.getChildren().stream().filter(child -> !(child == null)).map(child
                ->
        {
            ComponentHierarchyBase c = (ComponentHierarchyBase) child;
            if (!c.getEvents().isEmpty() || !c.getFeatures().isEmpty())
            {
                addToMap.put(c.getID(), c);
            }
            return child;
        }).forEach(child
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
            if (getOptions().isDynamicRender())
            {
                CSSLink renderedCSS = new CSSLink(SessionHelper.getServerPath() + JWebSwingSiteBinder.getCSSLocation().replaceAll("/", ""));
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
    private List<ComponentHierarchyBase> getTopShelfScripts()
    {
        List<ComponentHierarchyBase> arr;
        arr = getPriorityRequirements(RequirementsPriority.Top_Shelf, new ArrayList<>(), true, true);
        return arr;
    }

    /**
     * Returns the script reference
     *
     * @return ArrayList of type script
     */
    private List<Script> getDynamicScripts()
    {
        ArrayList<Script> allScripts = new ArrayList<>();

        if (getBody().readChildrenPropertyFirstResult(AngularPageConfigurator.AngularEnabledString, true))
        {
            if (getOptions().isDynamicRender())
            {
                Script jwScript = new Script();
                jwScript.addAttribute(ScriptAttributes.Type, "application/javascript");
                jwScript.addAttribute(ScriptAttributes.Src, SessionHelper.getServerPath() + JWebSwingSiteBinder.getJWScriptLocation().replaceAll("/", ""));
                allScripts.add(jwScript);

                Script dynamicScript = new Script();
                dynamicScript.addAttribute(ScriptAttributes.Type, "application/javascript");
                dynamicScript.addAttribute(ScriptAttributes.Src, SessionHelper.getServerPath() + JWebSwingSiteBinder.getAngularScriptLocation().replaceAll("/", ""));
                allScripts.add(dynamicScript);
            }
            else
            {
                FileTemplates.getFileTemplate(JWScriptServlet.class, JWScriptServlet.FILE_TEMPLATE_NAME, "siteloader");
                StringBuilder jsScript = FileTemplates.renderTemplateScripts(JWScriptServlet.FILE_TEMPLATE_NAME);
                if (!jsScript.toString().trim().isEmpty())
                {
                    Script s = new Script();
                    s.addAttribute(ScriptAttributes.Type, "application/javascript");
                    s.setText(jsScript);
                    allScripts.add(s);
                }

                StringBuilder js = getAngular().renderAngularJavascript(this);
                if (!js.toString().trim().isEmpty())
                {
                    Script s = new Script();
                    s.addAttribute(ScriptAttributes.Type, "application/javascript");
                    s.setText(js);
                    allScripts.add(s);
                }
            }
        }

        if (getOptions().isDynamicRender())
        {
            StringBuilder js = renderJavascript();
            if (!js.toString().trim().isEmpty())
            {
                Script dynamicScript = new Script();
                dynamicScript.addAttribute(ScriptAttributes.Type, "application/javascript");
                dynamicScript.addAttribute(ScriptAttributes.Src, SessionHelper.getServerPath() + JWebSwingSiteBinder.getJavaScriptLocation().replaceAll("/", ""));
                //dynamicScript.setTiny(true);
                //dynamicScript.setText("$.ajax({cache:false,dataType:'script',url:'js'}).fail(function(){alert('session lost'); });");
                allScripts.add(dynamicScript);
            }
        }
        else
        {
            StringBuilder js = renderJavascript();
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
        if (getPageFields().getTitle() != null)
        {
            getHead().add(getPageFields().getTitle());
        }
        if (getPageFields().getBase() != null)
        {
            getHead().add(getPageFields().getBase());
        }
        getHead().add(getPageFields().getHttpEquivMeta());
        getHead().add(getPageFields().getCacheControl());
        getHead().add(getPageFields().getAuthor());
        getHead().add(getPageFields().getApplicationName());
        getHead().add(getPageFields().getGenerator());
        getHead().add(getPageFields().getDescription());
        getHead().add(getPageFields().getKeywords());
        getHead().add(getPageFields().getFavIconLink());

        if (getOptions().isScriptsInHead())
        {
            addScriptsTo(getHead());
        }

        if (getOptions().isScriptsInHead())
        {
            List<Script> allScripts = getDynamicScripts();
            allScripts.stream().filter(script -> (script != null)).forEach(getHead()::add);
        }

        for (Iterator iterator = getHead().getChildren().iterator(); iterator.hasNext();)
        {
            ComponentHierarchyBase headObject = (ComponentHierarchyBase) iterator.next();
            headObject.preConfigure();
        }
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

    private void addScriptsTo(ComponentHierarchyBase component)
    {
        List<ComponentHierarchyBase> requirements = new ArrayList<>();

        List<RequirementsPriority> arrs = new ArrayList<>(Arrays.asList(RequirementsPriority.values()));
        //render JS only
        arrs.stream().filter(a -> a != RequirementsPriority.Top_Shelf).forEachOrdered(priority ->
        {
            if (getRunningEnvironment().ordinal() >= DevelopmentEnvironments.Development.ordinal())
            {
                if (!getPriorityRequirements(priority, requirements, false, true).isEmpty())
                {
                    getBody().add(new Comment("Priority [" + priority + "] Values"));
                }
            }
            getPriorityRequirements(priority, requirements, false, true).stream().forEach(comp
                    ->
            {
                component.add(comp);
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
    private List<ComponentHierarchyBase> getPriorityRequirements(RequirementsPriority priority, List<ComponentHierarchyBase> input, boolean css, boolean javascript)
    {
        List<ComponentHierarchyBase> requirements = new ArrayList<>();
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
     * Returns a readable user agent, or null if just a basic render
     *
     * @return
     */
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
    public void setUserAgent(ReadableUserAgent userAgent)
    {
        this.userAgent = userAgent;
    }

    /**
     * Returns all the dynamic options for a page
     *
     * @return
     */
    @Override
    public PageOptions getOptions()
    {
        if (options == null)
        {
            options = new PageOptions(this);
        }
        return options;
    }

    /**
     * Returns the fields available for entry on this page
     *
     * @return
     */
    @Override
    public final PageFields getPageFields()
    {
        if (fields == null)
        {
            fields = new PageFields(this);
        }
        return fields;
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
    public AngularPageConfigurator getAngular()
    {
        if (angular == null)
        {
            angular = new AngularPageConfigurator();
        }
        return angular;
    }

    public Page getPage()
    {
        return this;
    }
}
