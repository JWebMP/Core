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

import com.armineasy.injection.abstractions.GuiceSiteInjectorModule;
import com.armineasy.injection.annotations.GuiceSiteModule;
import com.armineasy.injection.interfaces.GuiceSiteBinder;
import java.util.*;
import java.util.logging.Level;
import org.reflections.Reflections;
import org.reflections.scanners.*;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import za.co.mmagon.jwebswing.base.servlets.*;
import za.co.mmagon.logger.LogFactory;

/**
 *
 * @author GedMarc
 * @since 20 Dec 2016
 * @version 1.0
 *
 */
@GuiceSiteModule
public class JWebSwingSiteBinder extends GuiceSiteBinder
{

    public static String QueryParametersRegex = "(\\?.*)?";

    public static String JavaScriptLocation = "/jwjs";
    public static String AjaxScriptLocation = "/jwajax";
    public static String CSSLocation = "/jwcss";
    public static final String AngularDataLocation = "/jwad";
    public static String AngularScriptLocation = "/jwas";

    public static String DataLocation = "/jwdata";

    private static final java.util.logging.Logger log = LogFactory.getInstance().getLogger("JWebSwingSiteBinder");

    public JWebSwingSiteBinder()
    {

    }

    @Override
    public void onBind(GuiceSiteInjectorModule module)
    {
        log.log(Level.CONFIG, "Configuring Servlet URL's");

        List<ClassLoader> classLoadersList = new LinkedList<>();
        classLoadersList.add(ClasspathHelper.contextClassLoader());
        classLoadersList.add(ClasspathHelper.staticClassLoader());
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setScanners(new SubTypesScanner(false /*
                 * don't exclude Object.class
                 */), new ResourcesScanner(), new TypeAnnotationsScanner())
                .setUrls(ClasspathHelper.forClassLoader(classLoadersList.toArray(new ClassLoader[0]))));

        Set<Class<? extends JWebSwingServlet>> siteBinders = reflections.getSubTypesOf(JWebSwingServlet.class);
        for (Iterator<Class<? extends JWebSwingServlet>> iterator = siteBinders.iterator(); iterator.hasNext();)
        {
            try
            {
                Class<? extends JWebSwingServlet> jwebSwingSite = iterator.next();
                JWebSwingServlet servlet = jwebSwingSite.newInstance();
                module.serveRegex$("(" + servlet.getUrl() + ")" + QueryParametersRegex).with(jwebSwingSite);
                log.log(Level.CONFIG, "Serving " + jwebSwingSite.getSimpleName() + " at " + servlet.getUrl());
            }
            catch (InstantiationException | IllegalAccessException ex)
            {
                log.log(Level.SEVERE, null, ex);
            }
        }

        module.serveRegex$("(" + JavaScriptLocation + ")" + QueryParametersRegex).with(JavaScriptServlet.class);
        log.log(Level.CONFIG, "Serving JavaScripts at " + JavaScriptLocation);
        
        module.serveRegex$("(" + AjaxScriptLocation + ")" + QueryParametersRegex).with(AjaxReceiverServlet.class);
        log.log(Level.CONFIG, "Serving Ajax at " + AjaxScriptLocation);
        
        module.serveRegex$("(" + CSSLocation + ")" + QueryParametersRegex).with(CSSServlet.class);
        log.log(Level.CONFIG, "Serving CSS at " + CSSLocation);
        
        module.serveRegex$("(" + AngularDataLocation + ")" + QueryParametersRegex).with(AngularDataServlet.class);
        log.log(Level.CONFIG, "Serving Angular Data at " + AngularDataLocation);
        
        module.serveRegex$("(" + AngularScriptLocation + ")" + QueryParametersRegex).with(AngularServlet.class);
        log.log(Level.CONFIG, "Serving Angular JavaScript at " + AngularScriptLocation);
        
        module.serveRegex$("(" + DataLocation + ")" + QueryParametersRegex).with(AngularServlet.class);
        log.log(Level.CONFIG, "Serving Data at " + DataLocation);
        
        log.log(Level.CONFIG, "Finished with configuring URL's");

    }
}
