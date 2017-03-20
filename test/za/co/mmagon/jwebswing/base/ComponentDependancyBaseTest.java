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
import za.co.mmagon.jwebswing.plugins.ajaxenabler.AjaxEnablerReferencePool;
import za.co.mmagon.jwebswing.plugins.jquery.JQueryReferencePool;

/**
 *
 * @author ged_m
 */
public class ComponentDependancyBaseTest extends BaseTestClass
{

    public ComponentDependancyBaseTest()
    {
    }

    @Test
    public void testReferences()
    {
        ComponentDependancyBase cd = new ComponentDependancyBase(ComponentTypes.Abbreviation);
        cd.setID("ID");
        cd.addCssReference(null);
        cd.addJavaScriptReference(AjaxEnablerReferencePool.AjaxEnabler.getJavaScriptReference());
        System.out.println(cd);
        Assert.assertEquals("{\n"
                + "  \"id\" : \"ID\",\n"
                + "  \"componentType\" : \"abbreviation\",\n"
                + "  \"tiny\" : false,\n"
                + "  \"configured\" : true,\n"
                + "  \"initialized\" : true,\n"
                + "  \"touched\" : false,\n"
                + "  \"cssReferences\" : [ null ],\n"
                + "  \"javascriptReferences\" : [ {\n"
                + "    \"cordovaRequired\" : false,\n"
                + "    \"name\" : \"AjaxEnabler\",\n"
                + "    \"version\" : 1.0,\n"
                + "    \"reference\" : \"javascript/jwebswing/ajax-enabler.js\"\n"
                + "  } ],\n"
                + "  \"componentClass\" : \"za.co.mmagon.jwebswing.base.ComponentDependancyBase\"\n"
                + "}", cd.toString());
    }

    @Test
    public void testClone()
    {
        ComponentDependancyBase shell = new ComponentDependancyBase(ComponentTypes.Abbreviation);
        shell.setID("shell");
        shell.addJavaScriptReference(JQueryReferencePool.JQueryV2.getJavaScriptReference());
        ComponentBase shell2 = shell.cloneComponent();
        shell2.setID("shell2");
        System.out.println(shell);
        System.out.println(shell2);
        String shellExpected = "{\n"
                + "  \"id\" : \"shell\",\n"
                + "  \"componentType\" : \"abbreviation\",\n"
                + "  \"tiny\" : false,\n"
                + "  \"configured\" : true,\n"
                + "  \"initialized\" : true,\n"
                + "  \"touched\" : false,\n"
                + "  \"javascriptReferences\" : [ {\n"
                + "    \"cordovaRequired\" : false,\n"
                + "    \"name\" : \"JQuery\",\n"
                + "    \"version\" : 2.24,\n"
                + "    \"reference\" : \"bower_components/jquery/dist/jquery.js\"\n"
                + "  } ],\n"
                + "  \"componentClass\" : \"za.co.mmagon.jwebswing.base.ComponentDependancyBase\"\n"
                + "}";
        String shell2Expected = "{\n"
                + "  \"id\" : \"shell2\",\n"
                + "  \"componentType\" : \"abbreviation\",\n"
                + "  \"tiny\" : false,\n"
                + "  \"configured\" : true,\n"
                + "  \"initialized\" : true,\n"
                + "  \"touched\" : false,\n"
                + "  \"javascriptReferences\" : [ {\n"
                + "    \"cordovaRequired\" : false,\n"
                + "    \"name\" : \"JQuery\",\n"
                + "    \"version\" : 2.24,\n"
                + "    \"reference\" : \"bower_components/jquery/dist/jquery.js\"\n"
                + "  } ],\n"
                + "  \"componentClass\" : \"za.co.mmagon.jwebswing.base.ComponentDependancyBase\"\n"
                + "}";
        Assert.assertEquals(shell.toString(), shellExpected);
        Assert.assertEquals(shell2.toString(), shell2Expected);
    }

}
