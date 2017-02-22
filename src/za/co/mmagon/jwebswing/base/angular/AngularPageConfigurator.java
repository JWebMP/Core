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
package za.co.mmagon.jwebswing.base.angular;

import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.PageConfigurator;
import za.co.mmagon.jwebswing.base.ComponentHTMLAngularBase;

/**
 *
 * @author GedMarc
 * @since 21 Feb 2017
 *
 */
public class AngularPageConfigurator extends PageConfigurator
{

    private static final long serialVersionUID = 1L;
    public static final String AngularEnabledString = "angular-enabled";

    public AngularPageConfigurator()
    {

    }

    @Override
    public Page configure(Page page)
    {
        if (!page.isConfigured())
        {
            page.getOptions().setjQueryEnabled(true);
            page.getOptions().setJquery3(true);
            if (page.getBody().readChildrenPropertyFirstResult(AngularEnabledString, true))
            {
                page.getBody().getJavascriptReferences().add(AngularReferencePool.Angular1.getJavaScriptReference());
            }
        }
        return page;
    }

    /**
     * Sets angular as a required component
     *
     * @param component
     * @param required
     */
    public static void setAngularRequired(ComponentHTMLAngularBase component, boolean required)
    {
        component.getProperties().put(AngularEnabledString, required);
    }
}
