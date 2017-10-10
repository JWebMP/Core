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
package za.co.mmagon;

import com.armineasy.injection.GuiceContext;
import com.armineasy.injection.abstractions.GuiceSiteInjectorModule;
import com.armineasy.injection.interfaces.GuiceSiteBinder;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.google.inject.Key;
import com.google.inject.Singleton;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Names;
import com.google.inject.servlet.RequestScoped;
import net.sf.uadetector.UserAgentStringParser;
import net.sf.uadetector.service.UADetectorServiceFactory;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.annotations.*;
import za.co.mmagon.jwebswing.base.ComponentBase;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.servlets.*;
import za.co.mmagon.jwebswing.base.servlets.options.AngularDataServletInitData;
import za.co.mmagon.jwebswing.base.servlets.options.AngularFileTransferData;
import za.co.mmagon.logger.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;

/**
 * @author GedMarc
 * @version 1.0
 * @since 20 Dec 2016
 */
public class JWebSwingSiteBinder extends GuiceSiteBinder
{
	
	private static final java.util.logging.Logger log = LogFactory.getInstance().getLogger("JWebSwingSiteBinder");
	/**
	 * The User Agent Parser
	 */
	private static final UserAgentStringParser userAgentParser = UADetectorServiceFactory.getResourceModuleParser();
	
	private static final String JavaScriptLocation = "/jwjs";
	private static final String AjaxScriptLocation = "/jwajax";
	private static final String CSSLocation = "/jwcss";
	private static final String AngularDataLocation = "/jwad";
	private static final String AngularScriptLocation = "/jwas";
	private static final String JWScriptLocation = "/jwscr";
	private static final String DataLocation = "/jwdata";
	
	private final static Set<Class<?>> pages = GuiceContext.reflect().getTypesAnnotatedWith(PageConfiguration.class);
	
	private AjaxCall ajaxCall = new AjaxCall();
	
	/**
	 * Constructs a new instance, mostly for injection
	 */
	public JWebSwingSiteBinder()
	{
	
	}
	
	/**
	 * Returns all the mapped pages
	 *
	 * @return
	 */
	public static Set<Class<?>> getPages()
	{
		return pages;
	}
	
	/**
	 * Returns the query parameters
	 *
	 * @return
	 */
	public static String getQueryParametersRegex()
	{
		return QueryParametersRegex;
	}
	
	/**
	 * Sets the query parameter regex, but the current one works fine. just in case
	 *
	 * @param QueryParametersRegex
	 */
	public static void setQueryParametersRegex(String QueryParametersRegex)
	{
		JWebSwingSiteBinder.QueryParametersRegex = QueryParametersRegex;
	}
	
	/**
	 * gets the location of the JavaScript Servlet
	 *
	 * @return
	 */
	public static String getJavaScriptLocation()
	{
		return JavaScriptLocation;
	}
	
	/**
	 * Gets the current Ajax location
	 *
	 * @return
	 */
	public static String getAjaxScriptLocation()
	{
		return AjaxScriptLocation;
	}
	
	/**
	 * Gets the CSS Location
	 *
	 * @return
	 */
	public static String getCSSLocation()
	{
		return CSSLocation;
	}
	
	/**
	 * Gets the angular script location
	 *
	 * @return
	 */
	public static String getAngularScriptLocation()
	{
		return AngularScriptLocation;
	}
	
	/**
	 * Gets the data location
	 *
	 * @return
	 */
	public static String getDataLocation()
	{
		return DataLocation;
	}
	
	/**
	 * Returns the angular data location
	 *
	 * @return
	 */
	public static String getAngularDataLocation()
	{
		return AngularDataLocation;
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
		return getDataLocation().replace("/", "") + "?component=" + component.getID();
	}
	
	/**
	 * The JW Script Location
	 *
	 * @return
	 */
	public static String getJWScriptLocation()
	{
		return JWScriptLocation;
	}
	
	@Override
	public void onBind(GuiceSiteInjectorModule module)
	{
		log.log(Level.CONFIG, "Building Event Map");
		log.log(Level.CONFIG, "Configuring Servlet URL's");
		//module.bind(JWebSwingSiteBinder.class).in(SessionScoped.class);
		module.bind(UserAgentStringParser.class).toInstance(userAgentParser);
		module.bind(AjaxResponse.class).in(RequestScoped.class);
		module.bind(AjaxCall.class).toProvider(() -> ajaxCall).in(RequestScoped.class);
		
		module.bindInterceptor$(Matchers.any(), Matchers.annotatedWith(SiteInterception.class),
		                        new SiteIntercepters());
		module.bindInterceptor$(Matchers.any(), Matchers.annotatedWith(AjaxCallInterception.class),
		                        new AjaxCallIntercepters());
		module.bindInterceptor$(Matchers.any(), Matchers.annotatedWith(DataCallInterception.class),
		                        new DataCallIntercepters());
		
		//Bind Local Storage
		module.bind(Map.class).annotatedWith(Names.named("LocalStorage")).toProvider(() ->
		{
			if (!GuiceContext.isBuildingInjector())
			{
				HttpSession session = GuiceContext.inject().getInstance(HttpSession.class);
				Map attributeMap = (Map) session.getAttribute(AngularDataServlet.LocalStorageSessionKey);
				if (attributeMap == null)
				{
					attributeMap = new HashMap();
				}
				return attributeMap;
			}
			return new HashMap();
		});
		//Bind Session Storage
		module.bind(Map.class).annotatedWith(Names.named("SessionStorage")).toProvider(() ->
		{
			if (!GuiceContext.isBuildingInjector())
			{
				HttpSession session = GuiceContext.inject().getInstance(HttpSession.class);
				Map attributeMap = (Map) session.getAttribute(AngularDataServlet.SessionStorageSessionKey);
				if (attributeMap == null)
				{
					attributeMap = new HashMap();
				}
				return attributeMap;
			}
			return new HashMap();
		});
		
		module.bind(SessionProperties.class);
		module.bind(AngularDataServletInitData.class);
		
		
		
		
		module.bind(Page.class).toProvider(() ->
		{
			if (!GuiceContext.isBuildingInjector())
			{
				for (Class<? extends Object> next : pages)
				{
					if (Modifier.isAbstract(next.getModifiers()))
					{
						continue;
					}
					if (next.equals(Page.class))
					{
						continue;
					}
					try
					{
						PageConfiguration pc = next.getAnnotation(PageConfiguration.class);
						HttpServletRequest request = GuiceContext.getInstance(HttpServletRequest.class);
						String pathInfo = request.getPathInfo();
						if (pathInfo == null)
						{
							pathInfo = "/";
						}
						
						String pcUrl = pc.url();
						if (pathInfo.equalsIgnoreCase(pcUrl))
						{
							Page returnedPage = (Page) GuiceContext.inject().getInstance(next);
							return returnedPage;
						}
						else if (SessionHelper.getServletUrl().equalsIgnoreCase(pc.url()))
						{
							Page returnedPage = (Page) GuiceContext.inject().getInstance(next);
							return returnedPage;
						}
						else
						{
							throw new RuntimeException("A JWebSwing Application must have a page applied. Please create a class that extends the za.co.mmagon.jwebswing.Page object.");
							
						}
					}
					catch (NullPointerException npe)
					{
						log.warning("Unable to process page : " + next + " due to null pointer");
					}
				}
			}
			return new BaseTestClass().getInstance();
		});
		
		
		module.bind(ObjectMapper.class).toProvider(() -> GuiceContext.getInstance(Key.get(ObjectMapper.class, Names.named("JSON")))).in(Singleton.class);
		
		module.bind(ObjectMapper.class).annotatedWith(Names.named("JSON")).toProvider(() ->
		                                                                              {
			                                                                              ObjectMapper jsonObjectMapper = new ObjectMapper();
			                                                                              jsonObjectMapper.enable(SerializationFeature.INDENT_OUTPUT);
			                                                                              jsonObjectMapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
			                                                                              jsonObjectMapper.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, true);
			                                                                              jsonObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			                                                                              jsonObjectMapper.registerModule(new ParameterNamesModule());
			                                                                              jsonObjectMapper.registerModule(new Jdk8Module());
			                                                                              jsonObjectMapper.registerModule(new JavaTimeModule());
			                                                                              return jsonObjectMapper;
		                                                                              }).in(Singleton.class);
		
		module.bind(ObjectMapper.class).annotatedWith(Names.named("JS")).toProvider(() ->
		                                                                            {
			                                                                            ObjectMapper jsonObjectMapper = new ObjectMapper();
			                                                                            jsonObjectMapper.enable(SerializationFeature.INDENT_OUTPUT);
			                                                                            jsonObjectMapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
			                                                                            jsonObjectMapper.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, true);
			                                                                            jsonObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			                                                                            jsonObjectMapper.registerModule(new ParameterNamesModule());
			                                                                            jsonObjectMapper.registerModule(new Jdk8Module());
			                                                                            jsonObjectMapper.registerModule(new JavaTimeModule());
			                                                                            return jsonObjectMapper;
		                                                                            }).in(Singleton.class);
		
		module.bind(ObjectMapper.class).annotatedWith(Names.named("JSFunction")).toProvider(() ->
		                                                                                    {
			                                                                                    ObjectMapper jsonObjectMapper = new ObjectMapper();
			                                                                                    jsonObjectMapper.enable(SerializationFeature.INDENT_OUTPUT);
			                                                                                    jsonObjectMapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
			                                                                                    jsonObjectMapper.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, true);
			                                                                                    jsonObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			                                                                                    jsonObjectMapper.registerModule(new ParameterNamesModule());
			                                                                                    jsonObjectMapper.registerModule(new Jdk8Module());
			                                                                                    jsonObjectMapper.registerModule(new JavaTimeModule());
			                                                                                    return jsonObjectMapper;
		                                                                                    }).in(Singleton.class);
		
		pages.forEach(page ->
		              {
			              if (!(Modifier.isAbstract(page.getModifiers())))
			              {
				              if (page.equals(Page.class))
				              {
					              return;
				              }
				              PageConfiguration pc = page.getAnnotation(PageConfiguration.class);
				              module.serveRegex$("(" + pc.url() + ")" + QueryParametersRegex).with(JWebSwingServlet.class);
				              log.log(Level.CONFIG, "Serving Page URL [{0}] with [{1}]", new Object[]
						              {
								              pc.url(), page.getCanonicalName()
						              });
			              }
		              });
		
		module.serveRegex$("(" + JavaScriptLocation + ")" + QueryParametersRegex).with(JavaScriptServlet.class);
		log.log(Level.CONFIG, "Serving JavaScripts at {0}", JavaScriptLocation);
		
		module.serveRegex$("(" + AjaxScriptLocation + ")" + QueryParametersRegex).with(AjaxReceiverServlet.class);
		log.log(Level.CONFIG, "Serving Ajax at {0}", AjaxScriptLocation);
		
		module.serveRegex$("(" + CSSLocation + ")" + QueryParametersRegex).with(CSSServlet.class);
		log.log(Level.CONFIG, "Serving CSS at {0}", CSSLocation);
		
		module.serveRegex$("(" + AngularDataLocation + ")" + QueryParametersRegex).with(AngularDataServlet.class);
		//module.serveRegex$("(" + AngularDataLocation + ")" + QueryParametersRegex).with(AngularDataVariables.class);
		log.log(Level.CONFIG, "Serving Angular Data at " + AngularDataLocation);
		
		module.serveRegex$("(" + AngularScriptLocation + ")" + QueryParametersRegex).with(AngularServlet.class);
		log.log(Level.CONFIG, "Serving Angular JavaScript at {0}", AngularScriptLocation);
		
		module.serveRegex$("(" + DataLocation + ")" + QueryParametersRegex).with(DataServlet.class);
		log.log(Level.CONFIG, "Serving Data at {0}", DataLocation);
		
		module.serveRegex$("(" + JWScriptLocation + ")" + QueryParametersRegex).with(JWScriptServlet.class);
		log.log(Level.CONFIG, "Serving JW Default Script at {0}", JWScriptLocation);
		
		log.log(Level.CONFIG, "Finished with configuring URL's");
	}
	
	/**
	 * Returns an ajax call currently set
	 *
	 * @return
	 */
	public AjaxCall getAjaxCall()
	{
		return ajaxCall;
	}
	
	/**
	 * Sets the given ajax call to an object
	 *
	 * @param ajaxCall
	 */
	public void setAjaxCall(AjaxCall ajaxCall)
	{
		this.ajaxCall = ajaxCall;
	}
	
}
