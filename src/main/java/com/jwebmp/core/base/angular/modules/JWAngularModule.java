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
import com.jwebmp.core.utilities.StaticStrings;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author GedMarc
 * @since 25 Jul 2016
 */
public class JWAngularModule
		extends AngularModuleBase
{

	private static final long serialVersionUID = 1L;
	/**
	 * The attached page
	 */
	private Page page;

	public JWAngularModule(Page component)
	{
		super("jwApp");
		setSortOrder(9999999);
		page = component;
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
		int result = super.hashCode();
		result = 31 * result + page.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof JWAngularModule))
		{
			return false;
		}
		if (!super.equals(o))
		{
			return false;
		}

		JWAngularModule that = (JWAngularModule) o;

		return page.equals(that.page);
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

		Set<String> moduleNames = new LinkedHashSet<>();
		List<AngularModuleBase> modules = new ArrayList<>(page.getAngular()
		                                                      .getAngularModules());
		modules.sort((o1, o2) -> o1.compare(o1, o2));
		for (AngularModuleBase module : modules)
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
		return returnable;
	}
}
