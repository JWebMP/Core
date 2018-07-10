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

package com.jwebmp.htmlbuilder.javascript.jquery;

import com.jwebmp.Feature;
import com.jwebmp.base.ComponentFeatureBase;
import com.jwebmp.htmlbuilder.javascript.JavaScriptPart;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements an ordered hierarchy of JQueries. This is useful is
 * doing calls asynchronously. Especially for components with dependencies.
 *
 * @author MMagon
 */
public class JQueryExecuteSynchronouslyFeature
		extends Feature<JavaScriptPart, JQueryExecuteSynchronouslyFeature>
{

	private List<ComponentFeatureBase> orderedWhenList = new ArrayList();
	private List<ComponentFeatureBase> orderedThenList = new ArrayList();

	public JQueryExecuteSynchronouslyFeature()
	{
		super("JQueryWhenThen");
	}

	public boolean addFeatureToWhen(ComponentFeatureBase newWhen)
	{
		orderedWhenList.add(newWhen);
		return true;
	}

	public boolean addFeatureToThen(ComponentFeatureBase newWhen)
	{
		orderedThenList.add(newWhen);
		return true;
	}

	@Override
	public int hashCode()
	{
		int result = super.hashCode();
		result = 31 * result + orderedWhenList.hashCode();
		result = 31 * result + orderedThenList.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof JQueryExecuteSynchronouslyFeature))
		{
			return false;
		}
		if (!super.equals(o))
		{
			return false;
		}

		JQueryExecuteSynchronouslyFeature that = (JQueryExecuteSynchronouslyFeature) o;

		if (!orderedWhenList.equals(that.orderedWhenList))
		{
			return false;
		}
		return orderedThenList.equals(that.orderedThenList);
	}

	@Override
	public void assignFunctionsToComponent()
	{
		StringBuilder query = new StringBuilder("$.when(");
		for (ComponentFeatureBase feature : orderedWhenList)
		{
			query.append(feature.renderJavascript());
		}
		query.append(").then(");
		for (ComponentFeatureBase feature : orderedThenList)
		{
			query.append(feature.renderJavascript());
		}
		query.append(");");
	}
}
