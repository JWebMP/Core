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

import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;
import com.google.inject.servlet.RequestScoped;
import com.google.inject.servlet.SessionScoped;
import com.jwebmp.core.Page;
import com.jwebmp.core.base.ComponentBase;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.angular.servlets.AngularDataServlet;
import com.jwebmp.core.base.angular.servlets.AngularServlet;
import com.jwebmp.core.base.servlets.*;
import com.jwebmp.core.services.IPage;
import com.jwebmp.core.utilities.StaticStrings;
import com.jwebmp.guicedinjection.GuiceContext;
import com.jwebmp.guicedservlets.GuicedServletKeys;
import com.jwebmp.guicedservlets.services.GuiceSiteInjectorModule;
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
	/**
	 * Field log
	 */
	private static final java.util.logging.Logger log = LogFactory.getLog("JWebMPCoreBinder");
	/**
	 * The User Agent Parser
	 */
	private static final UserAgentStringParser userAgentParser = UADetectorServiceFactory.getResourceModuleParser();

	/**
	 * Field localStorageTypeLiteral
	 */
	@SuppressWarnings("Convert2Diamond")
	private static TypeLiteral<Map<String, String>> localStorageTypeLiteral = new TypeLiteral<Map<String, String>>() {};

	/**
	 * Field sessionStorageTypeLiteral
	 */
	@SuppressWarnings("Convert2Diamond")
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
	 * @return The set script location for javascripts
	 */
	public static String getJavaScriptLocation()
	{
		return StaticStrings.JAVASCRIPT_LOCATION;
	}

	/**
	 * Gets the current Ajax location
	 *
	 * @return The ajax screipt location
	 */
	public static String getAjaxScriptLocation()
	{
		return StaticStrings.AJAX_SCRIPT_LOCATION;
	}

	/**
	 * Gets the CSS Location
	 *
	 * @return The CSS Location
	 */
	public static String getCSSLocation()
	{
		return StaticStrings.CSS_LOCATION;
	}

	/**
	 * Gets the angular script location
	 *
	 * @return The Angular Scripts location
	 */
	public static String getAngularScriptLocation()
	{
		return StaticStrings.ANGULAR_SCRIPT_LOCATION;
	}

	/**
	 * Returns the angular data location
	 *
	 * @return The Angular Data Scripts
	 */
	public static String getAngularDataLocation()
	{
		return StaticStrings.ANGULAR_DATA_LOCATION;
	}

	/**
	 * The JW Script Location
	 *
	 * @return the site script location
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
		return JWebMPSiteBinder.getDataLocation()
		                       .replace(StaticStrings.STRING_FORWARD_SLASH, StaticStrings.STRING_EMPTY) + "?component=" + component.getID();
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

	/**
	 * Method onBind ...
	 *
	 * @param module
	 * 		of type GuiceSiteInjectorModule
	 */
	@Override
	public void onBind(GuiceSiteInjectorModule module)
	{
		JWebMPSiteBinder.log.fine("Bound UserAgentStringParser.class");
		module.bind(UserAgentStringParser.class)
		      .toInstance(JWebMPSiteBinder.userAgentParser);
		JWebMPSiteBinder.log.fine("Bound ReadableUserAgent.class");
		module.bind(ReadableUserAgent.class)
		      .toProvider(() ->
		                  {
			                  HttpServletRequest request = GuiceContext.get(GuicedServletKeys.getHttpServletRequestKey());
			                  String headerInformation = request.getHeader("User-Agent");
			                  return GuiceContext.get(UserAgentStringParser.class)
			                                     .parse(headerInformation);
		                  })
		      .in(RequestScoped.class);

		JWebMPSiteBinder.log.fine("Bound AjaxResponse.class");
		module.bind(AjaxResponse.class)
		      .in(RequestScoped.class);
		JWebMPSiteBinder.log.fine("Bound AjaxCall.class");
		module.bind(AjaxCall.class)
		      .in(RequestScoped.class);
		//Bind Local Storage
		JWebMPSiteBinder.log.fine("Bound Map.class with @Named(LocalStorage)");
		module.bind(Map.class)
		      .annotatedWith(Names.named("LocalStorage"))
		      .toProvider(() -> GuiceContext.getInstance(SessionStorageProperties.class)
		                                    .getLocalStorage());
		module.bind(JWebMPSiteBinder.localStorageTypeLiteral)
		      .annotatedWith(Names.named("LocalStorage"))
		      .toProvider(() -> GuiceContext.getInstance(SessionStorageProperties.class)
		                                    .getLocalStorage());

		//Bind Session Storage
		JWebMPSiteBinder.log.fine("Bound Map.class with @Named(SessionStorage)");
		module.bind(Map.class)
		      .annotatedWith(Names.named("SessionStorage"))
		      .toProvider(() -> GuiceContext.getInstance(SessionStorageProperties.class)
		                                    .getSessionStorage());
		module.bind(JWebMPSiteBinder.sessionStorageTypeLiteral)
		      .annotatedWith(Names.named("SessionStorage"))
		      .toProvider(() -> GuiceContext.getInstance(SessionStorageProperties.class)
		                                    .getSessionStorage());
		JWebMPSiteBinder.log.fine("Bound SessionStorageProperties.class");
		module.bind(SessionStorageProperties.class)
		      .in(SessionScoped.class);

		JWebMPSiteBinder.log.fine("Bound Page.class");

		module.bind(Page.class)
		      .toProvider(new PageProvider())
		      .in(RequestScoped.class);

		Set<IPage> notInjectedPages = GuiceContext.instance()
		                                          .getLoader(IPage.class, true, ServiceLoader.load(IPage.class));

		for (IPage page : notInjectedPages)
		{
			PageConfiguration pc = page.getClass()
			                           .getAnnotation(PageConfiguration.class);
			if (pc == null)
			{
				JWebMPSiteBinder.log.log(Level.SEVERE, "Couldnt Find Page Configuration on IPage Object {0}", new Object[]{page.getClass().getCanonicalName()});
			}
			else if (!pc.ignore())
			{
				StringBuilder url = new StringBuilder(pc.url());
				url.insert(0, "(")
				   .append(StaticStrings.QUERY_PARAMETERS_REGEX)
				   .append(")");
				module.serveRegex$(url.toString())
				      .with(JWebSwingServlet.class);
				JWebMPSiteBinder.log.log(Level.CONFIG, "Serving Page URL [{0}] with [{1}]", new Object[]{pc.url(), page.getClass().getCanonicalName()});
			}
		}

		module.serveRegex$("(" + StaticStrings.JAVASCRIPT_LOCATION + ")" + StaticStrings.QUERY_PARAMETERS_REGEX)
		      .with(JavaScriptServlet.class);
		JWebMPSiteBinder.log.log(Level.FINE, "Serving JavaScripts at {0}", StaticStrings.JAVASCRIPT_LOCATION);

		module.serveRegex$("(" + StaticStrings.AJAX_SCRIPT_LOCATION + ")" + StaticStrings.QUERY_PARAMETERS_REGEX)
		      .with(AjaxReceiverServlet.class);
		JWebMPSiteBinder.log.log(Level.FINE, "Serving Ajax at {0}", StaticStrings.AJAX_SCRIPT_LOCATION);

		module.serveRegex$("(" + StaticStrings.CSS_LOCATION + ")" + StaticStrings.QUERY_PARAMETERS_REGEX)
		      .with(CSSServlet.class);
		JWebMPSiteBinder.log.log(Level.FINE, "Serving CSS at {0}", StaticStrings.CSS_LOCATION);

		module.serveRegex$("(" + StaticStrings.ANGULAR_DATA_LOCATION + ")" + StaticStrings.QUERY_PARAMETERS_REGEX)
		      .with(AngularDataServlet.class);
		JWebMPSiteBinder.log.log(Level.FINE, "Serving Angular Data at " + StaticStrings.ANGULAR_DATA_LOCATION);

		module.serveRegex$("(" + StaticStrings.ANGULAR_SCRIPT_LOCATION + ")" + StaticStrings.QUERY_PARAMETERS_REGEX)
		      .with(AngularServlet.class);
		JWebMPSiteBinder.log.log(Level.FINE, "Serving Angular JavaScript at {0}", StaticStrings.ANGULAR_SCRIPT_LOCATION);

		module.serveRegex$("(" + StaticStrings.DATA_LOCATION + ")" + StaticStrings.QUERY_PARAMETERS_REGEX)
		      .with(DataServlet.class);
		JWebMPSiteBinder.log.log(Level.FINE, "Serving Data at {0}", StaticStrings.DATA_LOCATION);

		module.serveRegex$("(" + StaticStrings.JW_SCRIPT_LOCATION + ")" + StaticStrings.QUERY_PARAMETERS_REGEX)
		      .with(JWScriptServlet.class);
		JWebMPSiteBinder.log.log(Level.FINE, "Serving JW Default Script at {0}", StaticStrings.JW_SCRIPT_LOCATION);
	}
}
