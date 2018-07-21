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
package com.jwebmp.core.base;

import com.jwebmp.BaseTestClass;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author ged_m
 */
public class ComponentFeatureBaseTest
		extends BaseTestClass
{

	public ComponentFeatureBaseTest()
	{
	}

	@Test
	public void testFeatureComponentBuild()
	{
		ComponentFeatureBase cfb = new ComponentFeatureBase(ComponentTypes.Abbreviation);
		cfb.setID("testComp");
		cfb.addFeature(getFeature());
		System.out.println(cfb);
		Assertions.assertEquals(
				"{\n" +
				"  \"id\" : \"testComp\",\n" +
				"  \"componentType\" : \"abbreviation\",\n" +
				"  \"tiny\" : false,\n" +
				"  \"configured\" : true,\n" +
				"  \"initialized\" : true,\n" +
				"  \"touched\" : false,\n" +
				"  \"features\" : [ {\n" +
				"    \"id\" : \"featureTest\",\n" +
				"    \"componentType\" : \"feature\",\n" +
				"    \"tiny\" : false,\n" +
				"    \"configured\" : true,\n" +
				"    \"initialized\" : true,\n" +
				"    \"touched\" : false,\n" +
				"    \"sortOrder\" : 1000,\n" +
				"    \"name\" : \"Test Feature\",\n" +
				"    \"renderAfterLoad\" : false,\n" +
				"    \"javascriptRenderedElsewhere\" : false,\n" +
				"    \"queries\" : [ \"Query Added\" ]\n" +
				"  } ],\n" +
				"  \"sortOrder\" : 1000,\n" +
				"  \"renderAfterLoad\" : false,\n" +
				"  \"javascriptRenderedElsewhere\" : false,\n" +
				"  \"componentClass\" : \"com.jwebmp.core.base.ComponentFeatureBase\"\n" +
				"}",
				cfb.toString());
	}
}
