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
import net.sf.uadetector.*;
import za.co.mmagon.FileTemplates;
import za.co.mmagon.JWebSwingSiteBinder;
import za.co.mmagon.SessionHelper;
import za.co.mmagon.jwebswing.annotations.PageConfiguration;
import za.co.mmagon.jwebswing.base.ComponentDependancyBase;
import za.co.mmagon.jwebswing.base.ComponentEventBase;
import za.co.mmagon.jwebswing.base.ComponentFeatureBase;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.angular.AngularPageConfigurator;
import za.co.mmagon.jwebswing.base.client.InternetExplorerCompatibilityMode;
import za.co.mmagon.jwebswing.base.html.*;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.attributes.ScriptAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.NoFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.children.NoChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.html.interfaces.events.NoEvents;
import za.co.mmagon.jwebswing.base.interfaces.RenderAfterLinks;
import za.co.mmagon.jwebswing.base.interfaces.RenderAfterScripts;
import za.co.mmagon.jwebswing.base.interfaces.RenderBeforeDynamicScripts;
import za.co.mmagon.jwebswing.base.interfaces.RenderBeforeLinks;
import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.base.references.JavascriptReference;
import za.co.mmagon.jwebswing.base.servlets.JWScriptServlet;
import za.co.mmagon.jwebswing.base.servlets.enumarations.DevelopmentEnvironments;
import za.co.mmagon.jwebswing.base.servlets.enumarations.RequirementsPriority;
import za.co.mmagon.jwebswing.base.servlets.interfaces.IPage;
import za.co.mmagon.jwebswing.generics.WebReference;
import za.co.mmagon.logger.LogFactory;

import java.util.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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

	/**
	 * Adds a css reference to the body
	 *
	 * @param cssReference
	 *
	 * @return
	 */
	@Override
	public ComponentDependancyBase addCssReference(CSSReference cssReference)
	{
		return getBody().addCssReference(cssReference);
	}

	/**
	 * Adds a global variable to the body
	 *
	 * @param variable
	 */
	@Override
	public void addVariable(String variable)
	{
		getBody().addVariable(variable);
	}

	/**
	 * Adds a java script reference to the body
	 *
	 * @param jsReference
	 *
	 * @return
	 */
	@Override
	public ComponentDependancyBase addJavaScriptReference(JavascriptReference jsReference)
	{
		return getBody().addJavaScriptReference(jsReference);
	}

	/**
	 * Adds an event to the body
	 *
	 * @param event
	 *
	 * @return
	 */
	@Override
	public ComponentEventBase addEvent(GlobalEvents event)
	{
		return getBody().addEvent(event);
	}

	/**
	 * Adds a feature to the body
	 *
	 * @param feature
	 *
	 * @return
	 */
	@Override
	public ComponentFeatureBase addFeature(ComponentFeatureBase feature)
	{
		return getBody().addFeature(feature);
	}

	/**
	 * Adds a feature to the body
	 *
	 * @param feature
	 * @param position
	 *
	 * @return
	 */
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
		this.angular = null;
		this.fields = null;
		this.options = null;
		this.userAgent = null;

		super.destroy();
	}

	/**
	 * Returns the cached component
	 *
	 * @param componentID
	 * 		The component to look for
	 *
	 * @return
	 */
	public ComponentHierarchyBase getCachedComponent(String componentID)
	{
		for (Object chb : getBody().getChildrenHierarchy())
		{
			ComponentHierarchyBase<NoChildren, NoAttributes, NoFeatures, NoEvents, ? extends ComponentHierarchyBase> ch = (ComponentHierarchyBase) chb;
			if (ch.getID().equals(componentID))
			{
				return ch;
			}
		}
		return null;
	}

	@Override
	public void init()
	{
		if (!pageInitialized)
		{
			getBody().init();
			pageInitialized = true;
			for (Object chb : getBody().getChildrenHierarchy())
			{
				ComponentHierarchyBase<NoChildren, NoAttributes, NoFeatures, NoEvents, ? extends ComponentHierarchyBase> ch = (ComponentHierarchyBase) chb;
			}
		}

		if (!isInitialized())
		{
			log.log(Level.FINE, "Looking for plugins....");
			Set<Class<? extends PageConfigurator>> configs = GuiceContext.reflect().getSubTypesOf(PageConfigurator.class);
			List<PageConfigurator> configInstances = new ArrayList<>();
			for (Class<? extends PageConfigurator> pc : configs)
			{
				PageConfigurator config = GuiceContext.getInstance(pc);
				configInstances.add(config);
			}
			Collections.sort(configInstances, Comparator.comparing(PageConfigurator::getSortOrder));
			for (PageConfigurator configInstance : configInstances)
			{
				log.log(Level.FINE, new StringBuilder().append("Configuring [").append(configInstance.getClass().getSimpleName()).append("]").toString());
				configInstance.configure(this);
			}
		}

		super.init();
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
				//script rendering in body
				Set<Class<? extends RenderBeforeDynamicScripts>> renderBeforeScripts = GuiceContext.reflect().getSubTypesOf(RenderBeforeDynamicScripts.class);
				List<RenderBeforeDynamicScripts> renderB = new ArrayList<>();
				for (Class<? extends RenderBeforeDynamicScripts> renderBeforeScript : renderBeforeScripts)
				{
					RenderBeforeDynamicScripts s = GuiceContext.getInstance(renderBeforeScript);
					renderB.add(s);
				}

				Collections.sort(renderB, (RenderBeforeDynamicScripts o1, RenderBeforeDynamicScripts o2) -> ((Integer) o1.sortOrder()).compareTo(o2.sortOrder()));
				Paragraph before = new Paragraph().setTextOnly(true);
				renderB.forEach(render ->
				                {
					                before.setText(before.getText(0).toString() + render.render().toString());
				                });
				if (before.getText(0).toString().trim().length() > 0)
				{
					getBody().add(before);
				}
				addScriptsTo(getBody());
				Set<Class<? extends RenderAfterScripts>> renderAfterScripts = GuiceContext.reflect().getSubTypesOf(RenderAfterScripts.class);
				List<RenderAfterScripts> renderA = new ArrayList<>();
				for (Class<? extends RenderAfterScripts> renderBeforeScript : renderAfterScripts)
				{
					RenderAfterScripts s = GuiceContext.getInstance(renderBeforeScript);
					renderA.add(s);
				}
				Collections.sort(renderA, (RenderAfterScripts o1, RenderAfterScripts o2) -> ((Integer) o1.sortOrder()).compareTo(o2.sortOrder()));
				Paragraph after = new Paragraph().setTextOnly(true);
				for (RenderAfterScripts render : renderA)
				{
					after.setText(after.getText(0).toString() + render.render().toString());
				}
				if (after.getText(0).toString().trim().length() > 0)
				{
					getBody().add(after);
				}
			}

			if (!getOptions().isScriptsInHead())
			{
				List<Script> allScripts = getDynamicScripts();
				for (Script script : allScripts)
				{
					if (script != null)
					{
						allScripts.forEach(getBody()::add);
					}
				}
			}

			if (!getTopShelfScripts().isEmpty())
			{
				if (getRunningEnvironment().ordinal() >= DevelopmentEnvironments.Development.ordinal())
				{
					getHead().add(new Comment("Priority [" + RequirementsPriority.Top_Shelf + "] Values"));
				}
			}

			//HERE
			Set<Class<? extends RenderBeforeLinks>> renderBeforeScripts = GuiceContext.reflect().getSubTypesOf(RenderBeforeLinks.class);
			List<RenderBeforeLinks> renderB = new ArrayList<>();
			for (Class<? extends RenderBeforeLinks> renderBeforeScript : renderBeforeScripts)
			{
				RenderBeforeLinks s = GuiceContext.getInstance(renderBeforeScript);
				renderB.add(s);
			}
			Collections.sort(renderB, (RenderBeforeLinks o1, RenderBeforeLinks o2) -> ((Integer) o1.sortOrder()).compareTo(o2.sortOrder()));
			Paragraph before = new Paragraph().setTextOnly(true);
			for (RenderBeforeLinks render : renderB)
			{
				before.setText(before.getText(0).toString() + render.render().toString());
			}
			if (before.getText(0).toString().trim().length() > 0)
			{
				getHead().add(before);
			}
			//Top SHelf Scripts
			getTopShelfScripts().forEach(next ->
			                             {
				                             getHead().add(next);
			                             });
			//After
			Set<Class<? extends RenderAfterLinks>> renderAfterScripts = GuiceContext.reflect().getSubTypesOf(RenderAfterLinks.class);
			List<RenderAfterLinks> renderA = new ArrayList<>();
			for (Class<? extends RenderAfterLinks> renderBeforeScript : renderAfterScripts)
			{
				RenderAfterLinks s = GuiceContext.getInstance(renderBeforeScript);
				renderA.add(s);
			}
			Collections.sort(renderA, (RenderAfterLinks o1, RenderAfterLinks o2) -> ((Integer) o1.sortOrder()).compareTo(o2.sortOrder()));
			Paragraph after = new Paragraph().setTextOnly(true);
			for (RenderAfterLinks render : renderA)
			{
				after.setText(after.getText(0).toString() + render.render().toString());
			}
			if (after.getText(0).toString().trim().length() > 0)
			{
				getHead().add(after);
			}
			ArrayList<ComponentHierarchyBase> requirements = new ArrayList<>();
			for (RequirementsPriority priority : RequirementsPriority.values())
			{
				getPriorityRequirements(priority, requirements, true, false).forEach((comp) ->
				                                                                     {
					                                                                     getHead().getChildren().add(comp);
				                                                                     });
			}
			getHead().add(getCssStyle());
		}
		super.preConfigure();
	}

	/**
	 * Returns the script reference
	 *
	 * @return ArrayList of type script
	 */
	private List<Script> getDynamicScripts()
	{
		ArrayList<Script> allScripts = new ArrayList<>();
		if (getOptions().isDynamicRender())
		{
			if (getBody().readChildrenPropertyFirstResult(AngularPageConfigurator.AngularEnabledString, true))
			{
				Script jwScript = new Script();
				jwScript.addAttribute(ScriptAttributes.Type, "application/javascript");
				jwScript.addAttribute(ScriptAttributes.Src, SessionHelper.getServerPath() + JWebSwingSiteBinder.getJWScriptLocation().replaceAll("/", ""));
				allScripts.add(jwScript);
			}

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

			if (getBody().readChildrenPropertyFirstResult(AngularPageConfigurator.AngularEnabledString, true))
			{
				Script dynamicScript = new Script();
				dynamicScript.addAttribute(ScriptAttributes.Type, "application/javascript");
				dynamicScript.addAttribute(ScriptAttributes.Src, SessionHelper.getServerPath() + JWebSwingSiteBinder.getAngularScriptLocation().replaceAll("/", ""));
				allScripts.add(dynamicScript);
			}

		}
		else
		{
			if (getBody().readChildrenPropertyFirstResult(AngularPageConfigurator.AngularEnabledString, true))
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
			}

			StringBuilder js = renderJavascript();
			if (!js.toString().trim().isEmpty())
			{
				Script s = new Script();
				s.addAttribute(ScriptAttributes.Type, "application/javascript");
				s.setText(getNewLine() + js);
				allScripts.add(s);
			}

			if (getBody().readChildrenPropertyFirstResult(AngularPageConfigurator.AngularEnabledString, true))
			{
				StringBuilder jsAngular = getAngular().renderAngularJavascript(this);
				if (!jsAngular.toString().trim().isEmpty())
				{
					Script s = new Script();
					s.addAttribute(ScriptAttributes.Type, "application/javascript");
					s.setText(jsAngular);
					allScripts.add(s);
				}
			}
		}

		if (getOptions().isDynamicRender())
		{

		}
		else
		{

		}

		return allScripts;
	}

	/**
	 * Adds the variables in the application to the collection
	 */
	private void addVariablesScriptToPage()
	{
		StringBuilder variablesScriptBuilder = new StringBuilder();
		for (Iterator it = getBody().getVariablesAll().iterator(); it.hasNext(); )
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
			allScripts.forEach(getHead()::add);
		}

		for (Iterator iterator = getHead().getChildren().iterator(); iterator.hasNext(); )
		{
			ComponentHierarchyBase headObject = (ComponentHierarchyBase) iterator.next();
			headObject.preConfigure();
		}
	}

	/**
	 * Adds scripts to a component, ordered by priority and sort order.
	 * <p>
	 * Does not do top shelf
	 *
	 * @param component
	 */
	private void addScriptsTo(ComponentHierarchyBase component)
	{
		List<ComponentHierarchyBase> requirements = new CopyOnWriteArrayList<>();

		List<RequirementsPriority> arrs = new ArrayList<>(Arrays.asList(RequirementsPriority.values()));
		for (RequirementsPriority priority : arrs)
		{
			if (priority.equals(RequirementsPriority.Top_Shelf))
			{
				continue;
			}

			if (getRunningEnvironment().ordinal() >= DevelopmentEnvironments.Development.ordinal())
			{
				if (!getPriorityRequirements(priority, requirements, false, true).isEmpty())
				{
					getBody().add(new Comment("Priority [" + priority + "] Values"));
				}
			}
			getPriorityRequirements(priority, requirements, false, true).forEach(comp
					                                                                     ->
			                                                                     {
				                                                                     component.add(comp);
			                                                                     });
		}
	}

	/**
	 * Adds all the stuff for a given priority
	 *
	 * @param css
	 * 		CSS
	 * @param input
	 * 		the hierarchy to read from
	 * @param priority
	 * 		the priority
	 * @param javascript
	 * 		to return JavaScript or not
	 */
	private List<ComponentHierarchyBase> getPriorityRequirements(RequirementsPriority priority, List<ComponentHierarchyBase> input, boolean css, boolean javascript)
	{
		List<ComponentHierarchyBase> requirements = new CopyOnWriteArrayList<>();
		if (css)
		{
			List<CSSLink> links = getAllCssLinks(priority);
			for (CSSLink link : links)
			{
				if (!input.contains(link))
				{
					if (!requirements.contains(link))
					{
						requirements.add(link);
					}
				}
			}
		}
		if (javascript)
		{
			List<Script> scripts = getAllScripts(priority);
			for (Script script : scripts)
			{
				if (!input.contains(script))
				{
					if (!requirements.contains(script))
					{
						requirements.add(script);
					}
				}
			}
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

		for (CSSReference reference : allReferences)
		{
			CSSLink link = new CSSLink(reference);
			if (!allLinks.contains(link))
			{
				allLinks.add(link);
			}
		}
		return allLinks;
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
	 *
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
			angular = GuiceContext.getInstance(AngularPageConfigurator.class);
		}
		return angular;
	}

	/**
	 * Overidden method to return this, beware circular joins
	 *
	 * @return
	 */
	public Page getPage()
	{
		return this;
	}

	/**
	 * Returns the page fields currently set on the page
	 *
	 * @return
	 */
	public PageFields getFields()
	{
		return fields;
	}

	/**
	 * Sets teh fields currently set on the page
	 *
	 * @param fields
	 */
	public void setFields(PageFields fields)
	{
		this.fields = fields;
	}

	/**
	 * Whether or not the page is initialized
	 *
	 * @return
	 */
	public boolean isPageInitialized()
	{
		return pageInitialized;
	}

	/**
	 * Sets if the page is initialized
	 *
	 * @param pageInitialized
	 */
	public void setPageInitialized(boolean pageInitialized)
	{
		this.pageInitialized = pageInitialized;
	}

	@Override
	public List getJavascriptReferences()
	{
		return getBody().getJavascriptReferences();
	}

	@Override
	public List getCssReferences()
	{
		return getBody().getCssReferences();
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

		for (JavascriptReference reference : allJavascripts)
		{
			Script script = new Script(reference);
			script.setNewLineForClosingTag(false);
			if (!allScripts.contains(script))
			{
				allScripts.add(script);
			}
		}
		return allScripts;
	}
}
