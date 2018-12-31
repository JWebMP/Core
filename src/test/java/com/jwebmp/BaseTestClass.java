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
package com.jwebmp;

import com.jwebmp.core.Feature;
import com.jwebmp.core.Page;
import com.jwebmp.testing.BaseTest;

import static com.jwebmp.core.base.servlets.enumarations.DevelopmentEnvironments.*;

/**
 * This Class
 *
 * @author GedMarc
 * @since 13 Jan 2016
 */
public class BaseTestClass
		extends BaseTest
{
	private Page<?> instance;

	public BaseTestClass()
	{
	}

	public Feature getFeature()
	{
		Feature f = new Feature("Test Feature")
		{
			@Override
			public void assignFunctionsToComponent()
			{
				addQuery(new StringBuilder("Query Added"));
			}
		};
		f.setID("featureTest");
		return f;
	}

	public Page<?> getInstance()
	{
		instance = new Page<>().setTiny(false)
		                       .setRunningEnvironment(Development);
		return instance;
	}

	public BaseTest setInstance(Page<?> instance)
	{
		this.instance = instance;
		return this;
	}


}
