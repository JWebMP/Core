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
package com.jwebmp.core.base.angular.configurations;

import com.jwebmp.core.FileTemplates;
import com.jwebmp.core.base.angular.services.IAngularConfigurationScopeStatement;
import com.jwebmp.core.utilities.StaticStrings;
import com.jwebmp.guicedinjection.GuiceContext;

import javax.validation.constraints.NotNull;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.TreeSet;

/**
 * Maps to the angular function of right click
 *
 * @author GedMarc
 * @since 25 Jun 2016
 */
public class JWAngularConfiguration
		extends com.jwebmp.core.base.angular.AngularReferenceBase
{


	/**
	 * Constructs a new right click directive based on the angular object passed in
	 */
	public JWAngularConfiguration()
	{
		super("jwController");
	}

	/**
	 * Renders the right click directive from the JavaScript file
	 *
	 * @return
	 */
	@Override
	@NotNull
	public String renderFunction()
	{
		StringBuilder controllerOutput = FileTemplates.getFileTemplate(JWAngularConfiguration.class, "JWAngularConfigurationTemplate", "jwangularconfiguration");

		if (controllerOutput == null)
		{
			throw new UnsupportedOperationException("Didn't find FileTemplate for Angular Controller Classes.");
		}

		String output = controllerOutput.toString();
		StringBuilder statementOutput = new StringBuilder();

		Set<IAngularConfigurationScopeStatement> loader = GuiceContext.instance()
		                                                              .getLoader(IAngularConfigurationScopeStatement.class,
		                                                                         ServiceLoader.load(IAngularConfigurationScopeStatement.class));
		Set<IAngularConfigurationScopeStatement> controllers = new TreeSet<>();
		if (loader.iterator()
		          .hasNext())
		{
			for (IAngularConfigurationScopeStatement statement : loader)
			{
				controllers.add(GuiceContext.get(statement.getClass()));
			}
		}
		controllers.forEach(a ->
		                    {
			                    if (!statementOutput.toString()
			                                        .contains(a.getStatement()))
			                    {
				                    statementOutput.append(a.getStatement())
				                                   .append(StaticStrings.STRING_NEWLINE_TEXT);
			                    }
		                    });
		output = output.replace("JW_SCOPE_INSERTIONS;", statementOutput.toString());
		output = output.replace("JW_SCOPE_INSERTIONS", statementOutput.toString());
		return output;
	}

}
