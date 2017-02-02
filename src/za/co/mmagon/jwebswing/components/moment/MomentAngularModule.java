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
package za.co.mmagon.jwebswing.components.moment;

import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.angular.modules.AngularModuleBase;

/**
 * Registers the moment angular module as available for the
 *
 * @author GedMarc
 * @since Oct 4, 2016
 * @version 1.0
 *
 */
public class MomentAngularModule extends AngularModuleBase
{

    private static final long serialVersionUID = 1L;

    public MomentAngularModule(ComponentHierarchyBase component)
    {
        super("angularMoment");
        component.getJavascriptReferences().add(MomentReferencePool.MomentReference.getJavaScriptReference());
        component.getJavascriptReferences().add(MomentReferencePool.MomentAngularReference.getJavaScriptReference());
    }

    @Override
    public String renderFunction()
    {
        return "";
    }
}
