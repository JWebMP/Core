/*
 * Copyright (C) 2016 GedMarc
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
import com.armineasy.injection.filters.GZipServletFilter;
import com.armineasy.injection.interfaces.GuiceSiteBinder;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import org.reflections.Reflections;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.servlets.*;
import za.co.mmagon.jwebswing.generics.DynamicLoadingPage;
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

    private static String QueryParametersRegex = "(\\?.*)?";

    private static String JavaScriptLocation = "/jwjs";
    private static String AjaxScriptLocation = "/jwajax";
    private static String CSSLocation = "/jwcss";
    private static final String AngularDataLocation = "/jwad";
    private static final String SiteLoaderJSLocation = "/jwsiteloader";
    private static String AngularScriptLocation = "/jwas";
    private static final String CordovaLocation = "/jwcordova";

    private static String DataLocation = "/jwdata";

    private static final java.util.logging.Logger log = LogFactory.getInstance().getLogger("JWebSwingSiteBinder");

    /**
     * Constructs a new instance, mostly for injection
     */
    public JWebSwingSiteBinder()
    {
        //Nothing needed to be done
    }

    @Override
    public void onBind(GuiceSiteInjectorModule module)
    {
        module.filterRegex$("/*").through(new GZipServletFilter());

        module.bind(DynamicLoadingPage.class).asEagerSingleton();

        log.log(Level.CONFIG, "Configuring Servlet URL's");
        Reflections reflections = GuiceContext.reflect();
        Set<Class<? extends JWebSwingServlet>> siteBinders = reflections.getSubTypesOf(JWebSwingServlet.class);
        for (Iterator<Class<? extends JWebSwingServlet>> iterator = siteBinders.iterator(); iterator.hasNext();)
        {
            try
            {
                Class<? extends JWebSwingServlet> jwebSwingSite = iterator.next();
                JWebSwingServlet servlet = jwebSwingSite.newInstance();
                module.serveRegex$("(" + servlet.getUrl() + ")" + QueryParametersRegex).with(jwebSwingSite);
                module.bind(Page.class).toProvider(servlet);
                log.log(Level.CONFIG, "Serving {0} at {1}", new Object[]
                {
                    jwebSwingSite.getSimpleName(), servlet.getUrl()
                });
            }
            catch (InstantiationException | IllegalAccessException ex)
            {
                log.log(Level.SEVERE, null, ex);
            }

            break;
        }

        module.serveRegex$("(" + JavaScriptLocation + ")" + QueryParametersRegex).with(JavaScriptServlet.class);
        log.log(Level.CONFIG, "Serving JavaScripts at {0}", JavaScriptLocation);

        module.serveRegex$("(" + AjaxScriptLocation + ")" + QueryParametersRegex).with(AjaxReceiverServlet.class);
        log.log(Level.CONFIG, "Serving Ajax at {0}", AjaxScriptLocation);

        module.serveRegex$("(" + CSSLocation + ")" + QueryParametersRegex).with(CSSServlet.class);
        log.log(Level.CONFIG, "Serving CSS at {0}", CSSLocation);

        module.serveRegex$("(" + AngularDataLocation + ")" + QueryParametersRegex).with(AngularDataServlet.class);
        log.log(Level.CONFIG, "Serving Angular Data at " + AngularDataLocation);

        module.serveRegex$("(" + AngularScriptLocation + ")" + QueryParametersRegex).with(AngularServlet.class);
        log.log(Level.CONFIG, "Serving Angular JavaScript at {0}", AngularScriptLocation);

        module.serveRegex$("(" + DataLocation + ")" + QueryParametersRegex).with(DataServlet.class);
        log.log(Level.CONFIG, "Serving Data at {0}", DataLocation);

        module.serveRegex$("(" + SiteLoaderJSLocation + ")" + QueryParametersRegex).with(SiteLoaderJavascript.class);
        log.log(Level.CONFIG, "Serving Site Loader Javscript at {0}", SiteLoaderJSLocation);

        module.serveRegex$("(" + CordovaLocation + ")" + QueryParametersRegex).with(CordovaServlet.class);
        log.log(Level.CONFIG, "Serving Cordova at {0}", CordovaLocation);

        log.log(Level.CONFIG, "Finished with configuring URL's");
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
     * Sets the current java script location
     *
     * @param JavaScriptLocation
     */
    public static void setJavaScriptLocation(String JavaScriptLocation)
    {
        JWebSwingSiteBinder.JavaScriptLocation = JavaScriptLocation;
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
     * Sets the current Ajax location
     *
     * @param AjaxScriptLocation
     */
    public static void setAjaxScriptLocation(String AjaxScriptLocation)
    {
        JWebSwingSiteBinder.AjaxScriptLocation = AjaxScriptLocation;
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
     * Sets the CSS Location
     *
     * @param CSSLocation
     */
    public static void setCSSLocation(String CSSLocation)
    {
        JWebSwingSiteBinder.CSSLocation = CSSLocation;
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
     * Sets the angular script location
     *
     * @param AngularScriptLocation
     */
    public static void setAngularScriptLocation(String AngularScriptLocation)
    {
        JWebSwingSiteBinder.AngularScriptLocation = AngularScriptLocation;
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
     * Sets the site loader JS location
     *
     * @return
     */
    public static String getSiteLoaderJSLocation()
    {
        return SiteLoaderJSLocation;
    }

    /**
     * Gets the cordova location
     *
     * @return
     */
    public static String getCordovaLocation()
    {
        return CordovaLocation;
    }

}
