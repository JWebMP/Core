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
package com.jwebmp.core.base.angular.modules;

import com.jwebmp.core.Page;
import com.jwebmp.core.base.angular.AngularFeature;
import com.jwebmp.core.base.angular.services.IAngularModule;
import com.jwebmp.core.utilities.StaticStrings;
import com.jwebmp.guicedinjection.GuiceContext;

import javax.validation.constraints.NotNull;
import java.util.LinkedHashSet;
import java.util.ServiceLoader;
import java.util.Set;

import static com.jwebmp.core.services.JWebMPServicesBindings.*;

/**
 * @author GedMarc
 * @since 25 Jul 2016
 */
public class JWAngularModule
		extends AngularModuleBase
		implements IAngularModule<JWAngularModule>
{

	private static final long serialVersionUID = 1L;
	/**
	 * The attached page
	 */
	private Page page;

	public JWAngularModule(Page component)
	{
		super("jwApp");
		page = component;
	}

	@Override
	public Integer getSortOrder()
	{
		return Integer.MAX_VALUE - 100;
	}

	public String renderFunction(Page fromComponent)
	{
		page = fromComponent;
		return renderFunction();
	}

	@Override
	public String toString()
	{
		if (page != null)
		{
			page.toString(true);
		}
		return super.toString();
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		return super.equals(obj);
	}

	/**
	 * Overwrite the render function
	 *
	 * @return
	 */
	@Override
	@NotNull
	public String renderFunction()
	{
		String returnable = "var " + AngularFeature.getAppName() + " = angular.module(";
		returnable += StaticStrings.STRING_SINGLE_QUOTES + AngularFeature.getAppName() + "',";

		Set<IAngularModule> loader = GuiceContext.instance()
		                                         .getLoader(IAngularModule.class, ServiceLoader.load(IAngularModule.class));
		if (loader.iterator()
		          .hasNext())
		{
			Set<String> moduleNames = new LinkedHashSet<>();
			Set<IAngularModule> modules = GuiceContext.get(AngularModulesKey);
			for (IAngularModule module : modules)
			{
				moduleNames.add(module.getReferenceName());
			}
			StringBuilder nameRenders = new StringBuilder();
			for (String name : moduleNames)
			{
				nameRenders.append(StaticStrings.STRING_SINGLE_QUOTES)
				           .append(name)
				           .append("',");
			}
			if (nameRenders.indexOf(StaticStrings.STRING_COMMNA) != -1)
			{
				nameRenders = nameRenders.deleteCharAt(nameRenders.lastIndexOf(StaticStrings.STRING_COMMNA));
			}
			nameRenders.insert(0, StaticStrings.STRING_SQUARE_BRACE_OPEN);
			nameRenders.append(StaticStrings.STRING_SQUARE_BRACE_CLOSED);
			returnable += nameRenders;

			returnable += ");";
		}
		return returnable;
	}
}
