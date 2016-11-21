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

import com.google.inject.*;
import com.google.inject.servlet.*;
import org.apache.log4j.*;
import za.co.mmagon.jwebswing.base.servlets.*;

/**
 * Allows injection of the session, request and response
 *
 * @author GedMarc
 * @since Nov 14, 2016
 * @version 1.0
 *
 */
public class JWebSwingInjector extends GuiceServletContextListener
{

    /**
     * The logger for the swing Servlet
     */
    private static final Logger LOG = LoggerFactory.getInstance().makeNewLoggerInstance("JWInject");
    private static boolean gzip = true;
    private static boolean cacheAll = true;
    private static Injector injector;
    private static ServletModule injectionModule;

    public JWebSwingInjector()
    {

    }

    @Override
    protected Injector getInjector()
    {
        return injector();
    }

    /**
     * If the context is set to GZIP
     *
     * @return
     */
    public static boolean isGzip()
    {
        return gzip;
    }

    /**
     * Set if the content must be GZIP
     *
     * @param gzip
     */
    public static void setGzip(boolean gzip)
    {
        JWebSwingInjector.gzip = gzip;
    }

    /**
     * Sets if must cache all
     *
     * @return
     */
    public static boolean isCacheAll()
    {
        return cacheAll;
    }

    /**
     * Sets cache all
     *
     * @param cacheAll
     */
    public static void setCacheAll(boolean cacheAll)
    {
        JWebSwingInjector.cacheAll = cacheAll;
    }

    /**
     * Returns an instance of the injector
     *
     * @return
     */
    public static Injector injector()
    {
        if (injector == null)
        {
            injector = Guice.createInjector(injectionModule = new ServletModule()
            {
                @Override
                protected void configureServlets()
                {
                    LOG.trace("Configuring Servlets For Injection");
                    serve("/js*").with(JavaScriptServlet.class);
                    serve("/ajax*").with(AjaxReceiverServlet.class);
                    serve("/css*").with(CSSServlet.class);
                    serve("/ad*").with(AngularDataServlet.class);
                    serve("/as*").with(AngularServlet.class);

                    if (gzip)
                    {
                        LOG.trace("Enabling GZIP");
                        filter("/*").through(GZipServletFilter.class);
                    }
                    else
                    {

                    }

                    if (cacheAll)
                    {
                        LOG.trace("Enabling Cache");
                        filter("/*").through(CacheControlFilter.class);
                    }

                }
            });
        }
        return injector;
    }

    /**
     * Returns the injection module
     *
     * @return
     */
    public static ServletModule getInjectionModule()
    {
        return injectionModule;
    }

    /**
     * Sets the injection module
     *
     * @param injectionModule
     */
    public static void setInjectionModule(ServletModule injectionModule)
    {
        JWebSwingInjector.injectionModule = injectionModule;
    }

}
