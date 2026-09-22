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
package com.jwebmp.test.core.base;

import com.jwebmp.test.BaseTestClass;
import com.guicedee.modules.services.jsonrepresentation.IJsonRepresentation;
import com.guicedee.modules.services.jsonrepresentation.json.StaticStrings;
import com.jwebmp.core.base.ComponentFeatureBase;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.JsonNode;

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
		JsonNode json = json(cfb.toJson());
		Assertions.assertEquals("testComp", json.get("id").asText());
		Assertions.assertEquals(ComponentFeatureBase.class.getCanonicalName(), json.get("componentClass").asText());
		Assertions.assertFalse(json.get("renderAfterLoad").asBoolean());

		JsonNode feature = json.get("features").get(0);
		Assertions.assertEquals("featureTest", feature.get("id").asText());
		Assertions.assertEquals("Test Feature", feature.get("name").asText());
		Assertions.assertEquals("Query Added" + StaticStrings.STRING_NEWLINE_TEXT, feature.get("queries").get(0).asText());
		ComponentFeatureBase featureComponent = (ComponentFeatureBase) cfb.getFeatures().iterator().next();
		Assertions.assertTrue(featureComponent.renderJavascript().toString().contains("Query Added"));
	}

	private JsonNode json(String value)
	{
		try
		{
			return IJsonRepresentation.getObjectMapper().readTree(value);
		}
		catch (Exception e)
		{
			throw new AssertionError("Feature JSON must be valid", e);
		}
	}
}
