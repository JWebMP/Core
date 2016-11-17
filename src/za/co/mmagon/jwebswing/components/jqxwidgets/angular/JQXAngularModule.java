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
package za.co.mmagon.jwebswing.components.jqxwidgets.angular;

import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.angular.modules.AngularModuleBase;
import za.co.mmagon.jwebswing.components.pools.jqxwidgets.JQXReferencePool;

/**
 * The integration between AngularJS and jQWidgets is implemented through a plug-in which we called jqxAngular. 
 * This plug-in includes AngularJS directives for all widgets.
 *
 * @author GedMarc
 * @since Nov 6, 2016
 * @version 1.0
 *
 */
public class JQXAngularModule extends AngularModuleBase
{

    private static final long serialVersionUID = 1L;

    public JQXAngularModule(Page page)
    {
        super("jqwidgets", page.getAngular());
        page.getAngular().addModule(this);
        page.setAngularEnabled(true);
        page.getBody().getJavascriptReferences().add(JQXReferencePool.Core.getJavaScriptReference());
        page.getBody().getJavascriptReferences().add(JQXReferencePool.AngularJS.getJavaScriptReference());
        
    }

    @Override
    public String renderFunction()
    {
        return "";
    }
}
