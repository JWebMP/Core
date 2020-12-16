/*
 * Copyright (C) 2016 ged_m
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
package com.jwebmp.core.base;

import com.jwebmp.BaseTestClass;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;
import com.jwebmp.core.plugins.jquery.JQueryReferencePool;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


/**
 * @author ged_m
 */
public class ComponentDependancyBaseTest
		extends BaseTestClass
{

	public ComponentDependancyBaseTest()
	{
	}

	@Test
	public void testReferences()
	{
		ComponentDependencyBase cd = new ComponentDependencyBase(ComponentTypes.Abbreviation);
		cd.setID("ID");
		Assertions.assertThrows(NullPointerException.class, new Executable()
		{
			@Override
			public void execute()
			{
				cd.addCssReference(null);
			}
		});
	cd.addJavaScriptReference(JQueryReferencePool.JQueryV3.getJavaScriptReference());
		System.out.println(cd);
/*		Assertions.assertEquals(
				"{\n" + "  \"id\" : \"ID\",\n" + "  \"componentType\" : \"abbreviation\",\n" + "  \"tiny\" : false,\n" + "  " + "\"configured\"" + " : true,\n" + "  \"initialized\" : true,\n" + "  \"touched\" : false,\n" + "  " + "\"javascriptReferences\" : [ {\n" + "    \"cordovaRequired\" : false,\n" + "    \"name\" : \"AjaxEnabler\",\n" + "    \"version\" : 1.0,\n" + "    " + "\"reference\" : \"javascript/jwebswing/ajax-enabler.js\"\n" + "  } ],\n" + "  \"componentClass\" : \"com.jwebmp.core.base.ComponentDependancyBase\"\n" + "}",
				cd.toString());*/
	}

	@Test
	public void testClone()
	{
		ComponentDependencyBase shell = new ComponentDependencyBase(ComponentTypes.Abbreviation);
		shell.setID("shell");
		shell.addJavaScriptReference(JQueryReferencePool.JQueryV3.getJavaScriptReference());
		ComponentBase shell2 = shell.cloneComponent();
		shell2.setID("shell2");
		System.out.println(shell);
		System.out.println(shell2);
		String shellExpected = "{\n" +
		                       "  \" id\" : \"shell\",\n"
		                       + "  \"componentType\" : \"abbreviation\",\n"
		                       + "  \"tiny\" : false,\n"
		                       + "  \"configured\" : true,\n"
		                       + "  \"initialized\" : true,\n"
		                       + "  \"touched\" : false,\n" + "  " + "\"javascriptReferences\" : [ {\n" + "    \"cordovaRequired\" : false,\n" +
		                       "    \"name\" : " + "\"AjaxEnabler\",\n" + "    \"version\" : 1.0,\n" + "    \"reference\" : " + "\"javascript/jwebswing/ajax-enabler.js\"\n" +
		                       "  } ],\n" + "  \"componentClass\" : \"com.jwebmp.core.base.ComponentDependancyBase\"\n" + "}";
		String shell2Expected = "{\n" + "  \"id\" : \"shell2\",\n" + "  \"componentType\" : \"abbreviation\",\n" + "  \"tiny\" : false,\n" + "  \"configured\" : true,\n" +
		                        "  \"initialized\" : true,\n" + "  \"touched\" : false,\n" + "  " + "\"javascriptReferences\" : [ {\n" + "    \"cordovaRequired\" : false,\n" +
		                        "    \"name\" : " + "\"AjaxEnabler\",\n" + "    \"version\" : 1.0,\n" + "    \"reference\" : " + "\"javascript/jwebswing/ajax-enabler.js\"\n" +
		                        "  } ],\n" + "  \"componentClass\" : \"com.jwebmp.core.base.ComponentDependancyBase\"\n" + "}";
		//Assertions.assertEquals(shell.toString(), shellExpected);
		//Assertions.assertEquals(shell2.toString(), shell2Expected);
	}

}
