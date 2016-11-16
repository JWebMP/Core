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

import com.google.inject.servlet.ServletModule;
import org.apache.log4j.Logger;
import za.co.mmagon.jwebswing.base.servlets.AjaxReceiverServlet;
import za.co.mmagon.jwebswing.base.servlets.AngularDataServlet;
import za.co.mmagon.jwebswing.base.servlets.AngularServlet;
import za.co.mmagon.jwebswing.base.servlets.CSSServlet;
import za.co.mmagon.jwebswing.base.servlets.JavaScriptServlet;

/**
 *
 * @author GedMarc
 * @since Nov 14, 2016
 * @version 1.0
 *
 */
public class GuiceInjectionFilter extends ServletModule
{

    /**
     * The logger for the swing Servlet
     */
    private static final Logger LOG = LoggerFactory.getInstance().makeNewLoggerInstance("GuiceFilter");
    private static boolean gzip = true;
    private static boolean cacheAll = true;

    public GuiceInjectionFilter()
    {

    }

    @Override
    protected void configureServlets()
    {
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

        LOG.trace("Configuring Servlets For Injection");
        serve("/js/*").with(JavaScriptServlet.class);
        serve("/ajax/*").with(AjaxReceiverServlet.class);
        serve("/css/*").with(CSSServlet.class);
        serve("/ad/*").with(AngularDataServlet.class);
        serve("/as/*").with(AngularServlet.class);
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
        GuiceInjectionFilter.gzip = gzip;
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
        GuiceInjectionFilter.cacheAll = cacheAll;
    }

}
