/*
 * Copyright (C) 2017 GedMarc
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
package za.co.mmagon.jwebswing.generics;

import java.util.Iterator;
import za.co.mmagon.JWebSwingSiteBinder;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.angular.AngularFeature;
import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.base.references.JavascriptReference;

/**
 * A page that loads the site dynamically.
 * <p>
 * Used for cordova or local storage accessed sites
 *
 * @author GedMarc
 * @since 2017/01/09
 */
public class DynamicLoadingPage extends Page
{

    private static final long serialVersionUID = 1L;
    /**
     * The location of the site loader (may be different for cordova devices)
     */
    private static final JavascriptReference reference = new JavascriptReference("DynamicSiteLoader", 1.0, JWebSwingSiteBinder.getSiteLoaderJSLocation().substring(1));
    
    private boolean requirementsConfigured;

    /**
     * A default loading page for dynamic loading
     */
    @SuppressWarnings("")
    public DynamicLoadingPage()
    {
        getBody().getJavascriptReferences().add(reference);

        getOptions().setjQueryEnabled(true);

        getBody().addAttribute("jwtype", "layout");
        getBody().addAttribute("ng-app", AngularFeature.getAppName());
        getBody().addAttribute("ng-controller", AngularFeature.getControllerName());
    }

    /**
     * Sets the page (all the references for cordova) onto the page
     * @param originalPage
     * @return 
     */
    public DynamicLoadingPage setPage(Page originalPage)
    {
        for (Iterator iterator = originalPage.getBody().getJavascriptReferencesAll().iterator(); iterator.hasNext();)
        {
            JavascriptReference next = (JavascriptReference) iterator.next();
            if (next.isCordovaRequired())
            {
                getBody().getJavascriptReferences().add(next);
            }
        }
        
        for (Iterator iterator = originalPage.getBody().getCssReferencesAll().iterator(); iterator.hasNext();)
        {
            CSSReference next = (CSSReference) iterator.next();
            if (next.isCordovaRequired())
            {
                getBody().getCssReferences().add(next);
            }
        }
        
        setRequirementsConfigured(true);
        return this;
    }

    /**
     * Are all the requirements configured
     * @return 
     */
    public boolean isRequirementsConfigured()
    {
        return requirementsConfigured;
    }

    /**
     * Sets if the requirements are configured
     * @param requirementsConfigured 
     */
    public void setRequirementsConfigured(boolean requirementsConfigured)
    {
        this.requirementsConfigured = requirementsConfigured;
    }
    
    
}
