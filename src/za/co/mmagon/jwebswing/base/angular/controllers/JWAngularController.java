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
package za.co.mmagon.jwebswing.base.angular.controllers;

import com.armineasy.injection.GuiceContext;
import java.util.Set;
import za.co.mmagon.FileTemplates;

/**
 * Maps to the angular function of right click
 *
 * @author GedMarc
 * @since 25 Jun 2016
 */
public class JWAngularController extends AngularControllerBase
{

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new right click directive based on the angular object passed in
     */
    public JWAngularController()
    {
        super("jwController");
        setSortOrder(100);
    }

    /**
     * Renders the right click directive from the JavaScript file
     *
     * @return
     */
    @Override
    public String renderFunction()
    {
        StringBuilder controllerOutput = FileTemplates.getFileTemplate(AngularControllerBase.class, "jwcontroller");
        String output = controllerOutput.toString();

        StringBuilder statementOutput = new StringBuilder();

        Set<Class<? extends AngularControllerScopeStatement>> controllers = GuiceContext.reflect().getSubTypesOf(AngularControllerScopeStatement.class);
        controllers.stream().map(next -> GuiceContext.inject().getInstance(next)).distinct().forEachOrdered(statement ->
        {
            if (!statementOutput.toString().contains(statement.getStatement()))
            {
                statementOutput.append(statement.getStatement()).append("\n");
            }
        });

        output = output.replace("//JW_SCOPE_INSERTIONS", statementOutput.toString());
        return output;
    }

}
