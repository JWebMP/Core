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
import com.armineasy.injection.abstractions.GuiceSiteInjectorModule;
import com.armineasy.injection.interfaces.GuiceSiteBinder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Names;
import com.google.inject.servlet.RequestScoped;
import com.google.inject.servlet.SessionScoped;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.logging.Level;
import javax.servlet.http.HttpSession;
import net.sf.uadetector.UserAgentStringParser;
import net.sf.uadetector.service.UADetectorServiceFactory;
import org.reflections.Reflections;
import za.co.mmagon.BaseTestClass;
import za.co.mmagon.SessionHelper;
import za.co.mmagon.jwebswing.annotations.*;
import za.co.mmagon.jwebswing.base.ComponentBase;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.servlets.*;
import za.co.mmagon.jwebswing.components.modernizr.ModernizrDto;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.logger.LogFactory;

/**
 *
 * @author GedMarc
 * @since 20 Dec 2016
 * @version 1.0
 *
 */
public class JWebSwingSiteBinder extends GuiceSiteBinder
{

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
    private static String DataLocation = "/jwdata";

    private static final java.util.logging.Logger log = LogFactory.getInstance().getLogger("JWebSwingSiteBinder");

    /**
     * Constructs a new instance, mostly for injection
     */
    public JWebSwingSiteBinder()
    {
        //Nothing needed to be done
    }

    private Set<Class<?>> pages = GuiceContext.reflect().getTypesAnnotatedWith(PageConfiguration.class);
    private AjaxCall ajaxCall = new AjaxCall();

    @Override
    public void onBind(GuiceSiteInjectorModule module)
    {
        log.log(Level.CONFIG, "Configuring Servlet URL's");
        Reflections reflections = GuiceContext.reflect();

        module.bind(JWebSwingSiteBinder.class).in(SessionScoped.class);
        module.bind(UserAgentStringParser.class).toProvider(new Provider<UserAgentStringParser>()
        {
            @Override
            public UserAgentStringParser get()
            {
                return UADetectorServiceFactory.getResourceModuleParser();
            }
        }).in(Singleton.class);

        module.bind(AjaxResponse.class).in(RequestScoped.class);
        module.bind(AjaxCall.class).toProvider((Provider<AjaxCall>) () -> ajaxCall).in(RequestScoped.class);

        module.bindInterceptor$(Matchers.any(), Matchers.annotatedWith(SiteInterception.class),
                new SiteIntercepters());
        module.bindInterceptor$(Matchers.any(), Matchers.annotatedWith(AjaxCallInterception.class),
                new AjaxCallIntercepters());
        module.bindInterceptor$(Matchers.any(), Matchers.annotatedWith(DataCallInterception.class),
                new DataCallIntercepters());

        //Bind Local Storage
        module.bind(Map.class).annotatedWith(Names.named("LocalStorage")).toProvider((Provider<Map>) () ->
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
        module.bind(Map.class).annotatedWith(Names.named("SessionStorage")).toProvider((Provider<Map>) () ->
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
        //Bind Modernizr
        module.bind(ModernizrDto.class).toProvider((Provider<ModernizrDto>) () ->
        {
            if (!GuiceContext.isBuildingInjector())
            {
                HttpSession session = GuiceContext.inject().getInstance(HttpSession.class);
                ModernizrDto attributeMap = (ModernizrDto) session.getAttribute(AngularDataServlet.ModernizrSessionKey);
                if (attributeMap == null)
                {
                    attributeMap = new ModernizrDto();
                }
                return attributeMap;
            }
            return new ModernizrDto();
        });

        module.bind(Page.class).toProvider((Provider<Page>) () ->
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

                    PageConfiguration pc = next.getAnnotation(PageConfiguration.class);
                    if (SessionHelper.getServletUrl().equalsIgnoreCase(pc.url()))
                    {
                        Page returnedPage = (Page) GuiceContext.inject().getInstance(next);
                        return returnedPage;
                    }
                }
            }
            return new BaseTestClass().getInstance();
        });

        module.bind(ObjectMapper.class).toInstance(JavaScriptPart.getJsonObjectMapper());
        module.bind(ObjectMapper.class).annotatedWith(Names.named("JSON")).toInstance(JavaScriptPart.getJsonObjectMapper());

        pages.stream().filter(page -> !(Modifier.isAbstract(page.getModifiers()))).filter(page -> !(page.equals(Page.class))).forEachOrdered(page ->
        {
            PageConfiguration pc = page.getAnnotation(PageConfiguration.class);
            module.serveRegex$("(" + pc.url() + ")" + QueryParametersRegex).with(JWebSwingServlet.class);
            log.log(Level.CONFIG, "Serving Page URL [{0}] with [{1}]", new Object[]
            {
                pc.url(), page.getCanonicalName()
            });
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

    public AjaxCall getAjaxCall()
    {
        return ajaxCall;
    }

    public void setAjaxCall(AjaxCall ajaxCall)
    {
        this.ajaxCall = ajaxCall;
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
     * Sets the data location
     *
     * @param DataLocation
     */
    public static void setDataLocation(String DataLocation)
    {
        JWebSwingSiteBinder.DataLocation = DataLocation;
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

}
