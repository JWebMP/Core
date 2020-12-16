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

package com.jwebmp.core.htmlbuilder.javascript.jquery;

import com.jwebmp.core.Feature;
import com.jwebmp.core.base.ComponentFeatureBase;
import com.jwebmp.core.base.interfaces.IComponentFeatureBase;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements an ordered hierarchy of JQueries. This is useful is
 * doing calls asynchronously. Especially for components with dependencies.
 *
 * @author MMagon
 */
public class JQueryExecuteSynchronouslyFeature
		extends Feature<JQueryExecuteSynchronouslyFeature, JavaScriptPart<?>, JQueryExecuteSynchronouslyFeature>
{

	private final List<IComponentFeatureBase<?,?>> orderedWhenList = new ArrayList<>();
	private final List<IComponentFeatureBase<?,?>> orderedThenList = new ArrayList<>();

	public JQueryExecuteSynchronouslyFeature()
	{
		super("JQueryWhenThen");
	}

	public boolean addFeatureToWhen(IComponentFeatureBase<?,?> newWhen)
	{
		orderedWhenList.add(newWhen);
		return true;
	}

	public boolean addFeatureToThen(IComponentFeatureBase<?,?> newWhen)
	{
		orderedThenList.add(newWhen);
		return true;
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

	@Override
	public void assignFunctionsToComponent()
	{
		StringBuilder query = new StringBuilder("$.when(");
		for (IComponentFeatureBase<?,?> feature : orderedWhenList)
		{
			query.append(feature.renderJavascript());
		}
		query.append(").then(");
		for (IComponentFeatureBase<?,?> feature : orderedThenList)
		{
			query.append(feature.renderJavascript());
		}
		query.append(");");
		addQuery(query);
	}
}
