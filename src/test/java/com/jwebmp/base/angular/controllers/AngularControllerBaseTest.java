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

package com.jwebmp.core.base.angular.controllers;

import com.jwebmp.BaseTestClass;
import com.jwebmp.core.Page;
import com.jwebmp.core.base.angular.AngularVariableWatcher;
import com.jwebmp.core.base.angular.AngularVariableWatcherTest;
import org.junit.jupiter.api.Test;

class AngularControllerBaseTest
		extends BaseTestClass
{
	@Test
	public void testRender()
	{
		AngularControllerBase acb = new AngularControllerBase("testWatchBuilder")
		{
			@Override
			public String renderFunction()
			{
				return "render";
			}
		};
		Page p = new Page();

		p.getAngular()
		 .getAngularWatchers()
		 .add(new AngularVariableWatcher("watchName", "unexistingvariable.name", AngularVariableWatcherTest.AngularChangeEventClass.class));
		System.out.println(p.getAngular()
		                    .renderAngularJavascript(p));
	}
}
