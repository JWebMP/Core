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
package com.jwebmp.core.annotations;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;
import com.google.inject.servlet.RequestScoped;
import com.google.inject.servlet.SessionScoped;
import com.jwebmp.core.Page;
import com.jwebmp.core.SessionHelper;
import com.jwebmp.core.base.ComponentBase;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.servlets.*;
import com.jwebmp.core.services.IPage;
import com.jwebmp.core.utilities.StaticStrings;
import com.jwebmp.guicedinjection.GuiceContext;
import com.jwebmp.guicedservlets.GuiceSiteInjectorModule;
import com.jwebmp.guicedservlets.services.IGuiceSiteBinder;
import com.jwebmp.logger.LogFactory;
import net.sf.uadetector.ReadableUserAgent;
import net.sf.uadetector.UserAgentStringParser;
import net.sf.uadetector.service.UADetectorServiceFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.logging.Level;

/**
 * @author GedMarc
 * @version 1.0
 * @since 20 Dec 2016
 */
public class JWebMPSiteBinder
		implements IGuiceSiteBinder<GuiceSiteInjectorModule>
{

	private static final java.util.logging.Logger log = LogFactory.getLog("JWebMPCoreBinder");
	/**
	 * The User Agent Parser
	 */
	private static final UserAgentStringParser userAgentParser = UADetectorServiceFactory.getResourceModuleParser();

	private static TypeLiteral<Map<String, String>> localStorageTypeLiteral = new TypeLiteral<Map<String, String>>() {};
	private static TypeLiteral<Map<String, String>> sessionStorageTypeLiteral = new TypeLiteral<Map<String, String>>() {};

	/**
	 * Constructs a new instance, mostly for injection
	 */
	public JWebMPSiteBinder()
	{
		//Nothing Needed
	}

	/**
	 * gets the location of the JavaScript Servlet
	 *
	 * @return
	 */
	public static String getJavaScriptLocation()
	{
		return StaticStrings.JAVASCRIPT_LOCATION;
	}

	/**
	 * Gets the current Ajax location
	 *
	 * @return
	 */
	public static String getAjaxScriptLocation()
	{
		return StaticStrings.AJAX_SCRIPT_LOCATION;
	}

	/**
	 * Gets the CSS Location
	 *
	 * @return
	 */
	public static String getCSSLocation()
	{
		return StaticStrings.CSS_LOCATION;
	}

	/**
	 * Gets the angular script location
	 *
	 * @return
	 */
	public static String getAngularScriptLocation()
	{
		return StaticStrings.ANGULAR_SCRIPT_LOCATION;
	}

	/**
	 * Returns the angular data location
	 *
	 * @return
	 */
	public static String getAngularDataLocation()
	{
		return StaticStrings.ANGULAR_DATA_LOCATION;
	}

	/**
	 * The JW Script Location
	 *
	 * @return
	 */
	public static String getJWScriptLocation()
	{
		return StaticStrings.JW_SCRIPT_LOCATION;
	}

	/**
	 * Returns the url to access the data binding search
	 *
	 * @param component
	 *
	 * @return
	 */
	public static String getDataBindUrl(ComponentBase component)
	{
		return getDataLocation().replace(StaticStrings.STRING_FORWARD_SLASH, StaticStrings.STRING_EMPTY) + "?component=" + component.getID();
	}

	/**
	 * Gets the data location
	 *
	 * @return
	 */
	public static String getDataLocation()
	{
		return StaticStrings.DATA_LOCATION;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onBind(GuiceSiteInjectorModule module)
	{
		log.fine("Bound HttpServletResponse.class");
		log.fine("Bound HttpServletRequest.class");
		log.fine("Bound HttpSession.class");

		log.fine("Bound UserAgentStringParser.class");
		module.bind(UserAgentStringParser.class)
		      .toInstance(userAgentParser);
		log.fine("Bound ReadableUserAgent.class");
		module.bind(ReadableUserAgent.class)
		      .toProvider(() ->
		                  {
			                  HttpServletRequest request = GuiceContext.get(HttpServletRequest.class);
			                  String headerInformation = request.getHeader("User-Agent");
			                  ReadableUserAgent agent = GuiceContext.get(UserAgentStringParser.class)
			                                                        .parse(headerInformation);
			                  return agent;
		                  })
		      .in(RequestScoped.class);

		log.fine("Bound AjaxResponse.class");
		module.bind(AjaxResponse.class)
		      .in(RequestScoped.class);
		log.fine("Bound AjaxCall.class");
		module.bind(AjaxCall.class)
		      .in(RequestScoped.class);
		//Bind Local Storage
		log.fine("Bound Map.class with @Named(LocalStorage)");
		module.bind(Map.class)
		      .annotatedWith(Names.named("LocalStorage"))
		      .toProvider(() ->
		                  {
			                  return GuiceContext.getInstance(SessionStorageProperties.class)
			                                     .getLocalStorage();

		                  });
		module.bind(localStorageTypeLiteral)
		      .annotatedWith(Names.named("LocalStorage"))
		      .toProvider(() ->
				                  GuiceContext.getInstance(SessionStorageProperties.class)
				                              .getLocalStorage());

		//Bind Session Storage
		log.fine("Bound Map.class with @Named(SessionStorage)");
		module.bind(Map.class)
		      .annotatedWith(Names.named("SessionStorage"))
		      .toProvider(() ->
				                  GuiceContext.getInstance(SessionStorageProperties.class)
				                              .getSessionStorage());
		module.bind(sessionStorageTypeLiteral)
		      .annotatedWith(Names.named("SessionStorage"))
		      .toProvider(() -> GuiceContext.getInstance(SessionStorageProperties.class)
		                                    .getSessionStorage());
		log.fine("Bound SessionStorageProperties.class");
		module.bind(SessionStorageProperties.class)
		      .in(SessionScoped.class);

		log.fine("Bound Page.class");
		final ServiceLoader<IPage> pages = ServiceLoader.load(IPage.class);
		module.bind(Page.class)
		      .toProvider(() ->
		                  {
			                  if (!pages.iterator()
			                            .hasNext())
			                  {
				                  log.log(Level.WARNING, "Returning blank page since no class was found that extends page or matches the given url");
				                  return new Page();
			                  }
			                  IPage outputPage = null;
			                  for (IPage page : pages)
			                  {
				                  outputPage = findPage(page);
				                  if (outputPage != null)
				                  {
					                  break;
				                  }
			                  }
			                  if (outputPage != null)
			                  {
				                  if (!Page.class.isAssignableFrom(outputPage.getClass()))
				                  {
					                  log.severe("Page Binding IPage Services must Extend Page.class");
					                  return new Page();
				                  }
				                  return (Page) outputPage;
			                  }
			                  return new Page();
		                  })
		      .in(RequestScoped.class);

		log.fine("Bound ObjectMapper.class @Named(JSON)");
		module.bind(ObjectMapper.class)
		      .annotatedWith(Names.named("JSON"))
		      .toProvider(this::getJsonMapper)
		      .in(Singleton.class);
		log.fine("Bound ObjectMapper.class @Named(JS)");
		module.bind(ObjectMapper.class)
		      .annotatedWith(Names.named("JS"))
		      .toProvider(this::getJsonMapper)
		      .in(Singleton.class);
		log.fine("Bound ObjectMapper.class @Named(JSFunction)");
		module.bind(ObjectMapper.class)
		      .annotatedWith(Names.named("JSFunction"))
		      .toProvider(this::getJsonMapper)
		      .in(Singleton.class);

		for (IPage page : pages)
		{
			PageConfiguration pc = page.getClass()
			                           .getAnnotation(PageConfiguration.class);
			if (pc == null)
			{
				log.log(Level.SEVERE, "Couldn't Find Page Configuration on IPage Object {0}", new Object[]{page.getClass().getCanonicalName()});
			}
			else
			{
				String url = pc.url();
				url = "(" + url + StaticStrings.QUERY_PARAMETERS_REGEX + ")";
				module.serveRegex$(url)
				      .with(JWebSwingServlet.class);
				log.log(Level.CONFIG, "Serving Page URL [{0}] with [{1}]", new Object[]{pc.url(), page.getClass().getCanonicalName()});
			}
		}

		module.serveRegex$("(" + StaticStrings.JAVASCRIPT_LOCATION + ")" + StaticStrings.QUERY_PARAMETERS_REGEX)
		      .with(JavaScriptServlet.class);
		log.log(Level.INFO, "Serving JavaScripts at {0}", StaticStrings.JAVASCRIPT_LOCATION);

		module.serveRegex$("(" + StaticStrings.AJAX_SCRIPT_LOCATION + ")" + StaticStrings.QUERY_PARAMETERS_REGEX)
		      .with(AjaxReceiverServlet.class);
		log.log(Level.INFO, "Serving Ajax at {0}", StaticStrings.AJAX_SCRIPT_LOCATION);

		module.serveRegex$("(" + StaticStrings.CSS_LOCATION + ")" + StaticStrings.QUERY_PARAMETERS_REGEX)
		      .with(CSSServlet.class);
		log.log(Level.INFO, "Serving CSS at {0}", StaticStrings.CSS_LOCATION);

		module.serveRegex$("(" + StaticStrings.ANGULAR_DATA_LOCATION + ")" + StaticStrings.QUERY_PARAMETERS_REGEX)
		      .with(AngularDataServlet.class);
		log.log(Level.INFO, "Serving Angular Data at " + StaticStrings.ANGULAR_DATA_LOCATION);

		module.serveRegex$("(" + StaticStrings.ANGULAR_SCRIPT_LOCATION + ")" + StaticStrings.QUERY_PARAMETERS_REGEX)
		      .with(AngularServlet.class);
		log.log(Level.INFO, "Serving Angular JavaScript at {0}", StaticStrings.ANGULAR_SCRIPT_LOCATION);

		module.serveRegex$("(" + StaticStrings.DATA_LOCATION + ")" + StaticStrings.QUERY_PARAMETERS_REGEX)
		      .with(DataServlet.class);
		log.log(Level.INFO, "Serving Data at {0}", StaticStrings.DATA_LOCATION);

		module.serveRegex$("(" + StaticStrings.JW_SCRIPT_LOCATION + ")" + StaticStrings.QUERY_PARAMETERS_REGEX)
		      .with(JWScriptServlet.class);
		log.log(Level.INFO, "Serving JW Default Script at {0}", StaticStrings.JW_SCRIPT_LOCATION);
	}

	/**
	 * Returns all the mapped pages
	 *
	 * @return
	 */
	public static Set<Class<? extends Page>> getPages()
	{
		return GuiceContext.reflect()
		                   .getTypesAnnotatedWith(PageConfiguration.class);
	}

	private IPage findPage(IPage next)
	{
		try
		{
			PageConfiguration pc = next.getClass()
			                           .getAnnotation(PageConfiguration.class);
			HttpServletRequest request = GuiceContext.getInstance(HttpServletRequest.class);
			String pathInfo = request.getPathInfo();
			if (pathInfo == null)
			{
				pathInfo = StaticStrings.STRING_FORWARD_SLASH;
			}

			String pcUrl = pc.url();
			if (pathInfo.equalsIgnoreCase(pcUrl) || SessionHelper.getServletUrl()
			                                                     .equalsIgnoreCase(pc.url()))
			{
				IPage page = GuiceContext.inject()
				                         .getInstance(next.getClass());
				String headerInformation = request.getHeader("User-Agent");
				ReadableUserAgent agent = GuiceContext.inject()
				                                      .getInstance(UserAgentStringParser.class)
				                                      .parse(headerInformation);
				page.setUserAgent(agent);
				return page;
			}
			else
			{
				log.log(Level.FINER, "Not the right page, moving on");
			}
		}
		catch (NullPointerException npe)
		{
			log.log(Level.SEVERE, "Unable to process page : " + next + " due to null pointer", npe);
		}
		catch (Exception npe)
		{
			log.log(Level.SEVERE, "Unable to process page : " + next, npe);
		}
		return null;
	}

	private ObjectMapper getJsonMapper()
	{
		ObjectMapper jsonObjectMapper = new ObjectMapper();
		configureObjectMapperForJSON(jsonObjectMapper);
		return jsonObjectMapper;
	}

	/**
	 * Configures json with the given properties
	 *
	 * @param jsonObjectMapper
	 */
	private void configureObjectMapperForJSON(ObjectMapper jsonObjectMapper)
	{
		jsonObjectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		jsonObjectMapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
		jsonObjectMapper.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, true);
		jsonObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		jsonObjectMapper.registerModule(new ParameterNamesModule());
		jsonObjectMapper.registerModule(new Jdk8Module());
		jsonObjectMapper.registerModule(new JavaTimeModule());
	}

}
