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
package za.co.mmagon.jwebswing.annotations;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.google.inject.Singleton;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Names;
import com.google.inject.servlet.RequestScoped;
import net.sf.uadetector.UserAgentStringParser;
import net.sf.uadetector.service.UADetectorServiceFactory;
import za.co.mmagon.SessionHelper;
import za.co.mmagon.guiceinjection.GuiceContext;
import za.co.mmagon.guiceinjection.abstractions.GuiceSiteInjectorModule;
import za.co.mmagon.guiceinjection.interfaces.GuiceSiteBinder;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.ComponentBase;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.servlets.*;
import za.co.mmagon.logger.LogFactory;

import javax.annotation.Nullable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;

import static za.co.mmagon.jwebswing.utilities.StaticStrings.*;

/**
 * @author GedMarc
 * @version 1.0
 * @since 20 Dec 2016
 */
public class SiteBinder extends GuiceSiteBinder
{

	private static final java.util.logging.Logger log = LogFactory.getLog("SiteBinder");
	/**
	 * The User Agent Parser
	 */
	private static final UserAgentStringParser userAgentParser = UADetectorServiceFactory.getResourceModuleParser();

	/**
	 * Constructs a new instance, mostly for injection
	 */
	public SiteBinder()
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
		return JAVASCRIPT_LOCATION;
	}

	/**
	 * Gets the current Ajax location
	 *
	 * @return
	 */
	public static String getAjaxScriptLocation()
	{
		return AJAX_SCRIPT_LOCATION;
	}

	/**
	 * Gets the CSS Location
	 *
	 * @return
	 */
	public static String getCSSLocation()
	{
		return CSS_LOCATION;
	}

	/**
	 * Gets the angular script location
	 *
	 * @return
	 */
	public static String getAngularScriptLocation()
	{
		return ANGULAR_SCRIPT_LOCATION;
	}

	/**
	 * Returns the angular data location
	 *
	 * @return
	 */
	public static String getAngularDataLocation()
	{
		return ANGULAR_DATA_LOCATION;
	}

	/**
	 * The JW Script Location
	 *
	 * @return
	 */
	public static String getJWScriptLocation()
	{
		return JW_SCRIPT_LOCATION;
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
		return getDataLocation().replace(STRING_FORWARD_SLASH, STRING_EMPTY) + "?component=" + component.getID();
	}

	/**
	 * Gets the data location
	 *
	 * @return
	 */
	public static String getDataLocation()
	{
		return DATA_LOCATION;
	}

	@Override
	public void onBind(GuiceSiteInjectorModule module)
	{
		log.log(Level.INFO, "Configuring Servlet URL's");

		module.bind(UserAgentStringParser.class)
				.toInstance(userAgentParser);
		module.bind(AjaxResponse.class)
				.in(RequestScoped.class);
		module.bind(AjaxCall.class)
				.in(RequestScoped.class);

		log.fine("Bound Intercepter @SiteInterception");
		module.bindInterceptor$(Matchers.any(), Matchers.annotatedWith(SiteInterception.class), new SiteIntercepters());
		log.fine("Bound Intercepter @AjaxCallInterception");
		module.bindInterceptor$(Matchers.any(), Matchers.annotatedWith(AjaxCallInterception.class), new AjaxCallIntercepters());
		log.fine("Bound Intercepter @DataCallInterception");
		module.bindInterceptor$(Matchers.any(), Matchers.annotatedWith(DataCallInterception.class), new DataCallIntercepters());

		//Bind Local Storage
		log.fine("Bound Map.class with @Named(LocalStorage)");
		module.bind(Map.class)
				.annotatedWith(Names.named("LocalStorage"))
				.toProvider(() ->
				            {
					            if (!GuiceContext.isBuildingInjector())
					            {
						            HttpSession session = GuiceContext.inject()
								                                  .getInstance(HttpSession.class);
						            Map attributeMap = (Map) session.getAttribute(LocalStorageSessionAttributeKey);
						            if (attributeMap == null)
						            {
							            attributeMap = new HashMap();
						            }
						            return attributeMap;
					            }
					            return new HashMap();
				            });
		//Bind Session Storage
		log.fine("Bound Map.class with @Named(SessionStorage)");
		module.bind(Map.class)
				.annotatedWith(Names.named("SessionStorage"))
				.toProvider(() ->
				            {
					            if (!GuiceContext.isBuildingInjector())
					            {
						            HttpSession session = GuiceContext.inject()
								                                  .getInstance(HttpSession.class);
						            Map attributeMap = (Map) session.getAttribute(SessionStorageSessionAttributeKey);
						            if (attributeMap == null)
						            {
							            attributeMap = new HashMap();
						            }
						            return attributeMap;
					            }
					            return new HashMap();
				            });
		log.fine("Bound SessionStorageProperties");
		module.bind(SessionStorageProperties.class);

		log.fine("Bound Page.class");
		module.bind(Page.class)
				.toProvider(() ->
				            {
					            for (Class<? extends Page> next : getPages())
					            {
						            if (Modifier.isAbstract(next.getModifiers()) || next.equals(Page.class))
						            {
							            continue;
						            }
						            Page page = findPage(next);
						            if (page != null)
						            {
							            return page;
						            }
					            }
					            log.log(Level.WARNING,
					                    "Returning blank page since no class was found that extends page or matches the given url");
					            return new Page();
				            });

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


		for (Class<?> page : getPages())
		{
			if (!(Modifier.isAbstract(page.getModifiers())))
			{
				if (page.equals(Page.class))
				{
					continue;
				}
				PageConfiguration pc = page.getAnnotation(PageConfiguration.class);
				module.serveRegex$("(" + pc.url() + ")" + QUERY_PARAMETERS_REGEX)
						.with(JWebSwingServlet.class);
				log.log(Level.CONFIG, "Serving Page URL [{0}] with [{1}]", new Object[]{pc.url(), page.getCanonicalName()});
			}
		}

		module.serveRegex$("(" + JAVASCRIPT_LOCATION + ")" + QUERY_PARAMETERS_REGEX)
				.with(JavaScriptServlet.class);
		log.log(Level.INFO, "Serving JavaScripts at {0}", JAVASCRIPT_LOCATION);

		module.serveRegex$("(" + AJAX_SCRIPT_LOCATION + ")" + QUERY_PARAMETERS_REGEX)
				.with(AjaxReceiverServlet.class);
		log.log(Level.INFO, "Serving Ajax at {0}", AJAX_SCRIPT_LOCATION);

		module.serveRegex$("(" + CSS_LOCATION + ")" + QUERY_PARAMETERS_REGEX)
				.with(CSSServlet.class);
		log.log(Level.INFO, "Serving CSS at {0}", CSS_LOCATION);

		module.serveRegex$("(" + ANGULAR_DATA_LOCATION + ")" + QUERY_PARAMETERS_REGEX)
				.with(AngularDataServlet.class);
		log.log(Level.INFO, "Serving Angular Data at " + ANGULAR_DATA_LOCATION);

		module.serveRegex$("(" + ANGULAR_SCRIPT_LOCATION + ")" + QUERY_PARAMETERS_REGEX)
				.with(AngularServlet.class);
		log.log(Level.INFO, "Serving Angular JavaScript at {0}", ANGULAR_SCRIPT_LOCATION);

		module.serveRegex$("(" + DATA_LOCATION + ")" + QUERY_PARAMETERS_REGEX)
				.with(DataServlet.class);
		log.log(Level.INFO, "Serving Data at {0}", DATA_LOCATION);

		module.serveRegex$("(" + JW_SCRIPT_LOCATION + ")" + QUERY_PARAMETERS_REGEX)
				.with(JWScriptServlet.class);
		log.log(Level.INFO, "Serving JW Default Script at {0}", JW_SCRIPT_LOCATION);

		log.log(Level.CONFIG, "Finished with configuring URL's");
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

	@Nullable
	private Page findPage(Class<? extends Page> next)
	{
		try
		{
			PageConfiguration pc = next.getAnnotation(PageConfiguration.class);
			HttpServletRequest request = GuiceContext.getInstance(HttpServletRequest.class);
			String pathInfo = request.getPathInfo();
			if (pathInfo == null)
			{
				pathInfo = STRING_FORWARD_SLASH;
			}

			String pcUrl = pc.url();
			if (pathInfo.equalsIgnoreCase(pcUrl) || SessionHelper.getServletUrl()
					                                        .equalsIgnoreCase(pc.url()))
			{
				return GuiceContext.inject()
						       .getInstance(next);
			}
			else
			{
				log.log(Level.SEVERE,
				        "A JWebSwing Application must have a page applied. Please create a class that extends the za.co.mmagon.jwebswing"
						        + ".Page object.");
			}
		}
		catch (NullPointerException npe)
		{
			log.log(Level.WARNING, "Unable to process page : " + next + " due to null pointer", npe);
		}
		return null;
	}

	/**
	 * Configures json with the given properties
	 *
	 * @param jsonObjectMapper
	 */
	private void configureObjectMapperForJS(ObjectMapper jsonObjectMapper)
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
