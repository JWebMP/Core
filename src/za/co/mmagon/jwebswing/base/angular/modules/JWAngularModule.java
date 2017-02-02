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
package za.co.mmagon.jwebswing.base.angular.modules;

import java.util.ArrayList;
import java.util.List;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.angular.AngularFeature;

/**
 *
 * @author GedMarc
 * @since 25 Jul 2016
 */
public class JWAngularModule extends AngularModuleBase
{

    private static final long serialVersionUID = 1L;
    private ComponentHierarchyBase component;

    public JWAngularModule(ComponentHierarchyBase component)
    {
        super("jwApp");
        setSortOrder(9999999);
        this.component = component;
    }

    /**
     * Overwrite the render function
     *
     * @return
     */
    @Override
    public String renderFunction()
    {
        String returnable = "var " + AngularFeature.getAppName() + " = angular.module(";
        returnable += "'" + AngularFeature.getAppName() + "',";

        ArrayList<String> moduleNames = new ArrayList<>();
        List<AngularModuleBase> modules = component.getPage().getBody().getAngularModulesAll();
        modules.stream().forEach(module ->
        {
            String name = module.getReferenceName();
            if (!moduleNames.contains(name))
            {
                moduleNames.add(module.getReferenceName());
            }
        });

        StringBuilder nameRenders = new StringBuilder();
        for (String name : moduleNames)
        {
            nameRenders.append("'").append(name).append("',");
        }

        if (nameRenders.indexOf(",") != -1)
        {
            nameRenders = nameRenders.deleteCharAt(nameRenders.lastIndexOf(","));
        }
        nameRenders.insert(0, "[");
        nameRenders.append("]");
        returnable += nameRenders;

        returnable += ");";
        return returnable;
    }
}
