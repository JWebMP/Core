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
import za.co.mmagon.jwebswing.base.servlets.enumarations.RequirementsPriority;

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
                + "  \"features\" : [ {\n"
                + "    \"id\" : \"featureTest\",\n"
                + "    \"componentType\" : \"feature\",\n"
                + "    \"tiny\" : false,\n"
                + "    \"configured\" : true,\n"
                + "    \"cssReferences\" : [ {\n"
                + "      \"name\" : \"CSSPaceBarberShop\",\n"
                + "      \"version\" : 1.02,\n"
                + "      \"reference\" : \"bower_components/PACE/themes/red/pace-theme-barber-shop.css\"\n"
                + "    } ],\n"
                + "    \"javascriptReferences\" : [ {\n"
                + "      \"name\" : \"PACE\",\n"
                + "      \"version\" : 1.02,\n"
                + "      \"reference\" : \"bower_components/PACE/pace.js\"\n"
                + "    } ],\n"
                + "    \"sortOrder\" : 1000,\n"
                + "    \"name\" : \"Test Feature\",\n"
                + "    \"renderAfterLoad\" : false,\n"
                + "    \"queries\" : [ \"Query Added\" ]\n"
                + "  } ],\n"
                + "  \"sortOrder\" : 1000,\n"
                + "  \"renderAfterLoad\" : false\n"
                + "}", cfb.toString());
    }

    @Test
    public void testComponentWithFeature()
    {
        ComponentFeatureBase cfb = new ComponentFeatureBase(ComponentTypes.Abbreviation);
        cfb.getFeatures().add(getFeature());
        System.out.println(cfb.getJavascriptReferencesAll());
        Assert.assertEquals("[bower_components/PACE/pace.js]", cfb.getJavascriptReferencesAll().toString());
        System.out.println(cfb.getCssReferencesAll());
        Assert.assertEquals("[bower_components/PACE/themes/red/pace-theme-barber-shop.css]", cfb.getCssReferencesAll().toString());
        System.out.println(cfb.getJavascriptReferencesAll(RequirementsPriority.First));
        Assert.assertEquals("[bower_components/PACE/pace.js]", cfb.getJavascriptReferencesAll(RequirementsPriority.First).toString());
        System.out.println(cfb.getJavascriptReferencesAll(RequirementsPriority.Second));
        Assert.assertEquals("[]", cfb.getJavascriptReferencesAll(RequirementsPriority.Second).toString());
    }

}
