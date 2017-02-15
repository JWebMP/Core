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
package za.co.mmagon.jwebswing.base;

import org.junit.Assert;
import org.junit.Test;
import za.co.mmagon.BaseTestClass;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 *
 * @author ged_m
 */
public class ComponentFeatureBaseTest extends BaseTestClass
{

    public ComponentFeatureBaseTest()
    {
    }

    @Test
    public void testFeatureComponentBuild()
    {
        ComponentFeatureBase cfb = new ComponentFeatureBase(ComponentTypes.Abbreviation);
        cfb.setID("testComp");
        cfb.getFeatures().add(getFeature());
        System.out.println(cfb);
        Assert.assertEquals("{\n"
                + "  \"id\" : \"testComp\",\n"
                + "  \"componentType\" : \"abbreviation\",\n"
                + "  \"tiny\" : false,\n"
                + "  \"configured\" : true,\n"
                + "  \"initialized\" : true,\n"
                + "  \"touched\" : false,\n"
                + "  \"features\" : [ {\n"
                + "    \"id\" : \"featureTest\",\n"
                + "    \"componentType\" : \"feature\",\n"
                + "    \"tiny\" : false,\n"
                + "    \"configured\" : true,\n"
                + "    \"initialized\" : true,\n"
                + "    \"touched\" : false,\n"
                + "    \"sortOrder\" : 1000,\n"
                + "    \"name\" : \"Test Feature\",\n"
                + "    \"renderAfterLoad\" : false,\n"
                + "    \"javascriptRenderedElsewhere\" : false,\n"
                + "    \"queries\" : [ \"Query Added\" ]\n"
                + "  } ],\n"
                + "  \"sortOrder\" : 1000,\n"
                + "  \"renderAfterLoad\" : false,\n"
                + "  \"javascriptRenderedElsewhere\" : false,\n"
                + "  \"componentClass\" : \"za.co.mmagon.jwebswing.base.ComponentFeatureBase\"\n"
                + "}", cfb.toString());
    }
}
