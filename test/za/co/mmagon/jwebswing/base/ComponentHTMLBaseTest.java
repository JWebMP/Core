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
import za.co.mmagon.jwebswing.Event;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.interfaces.ComponentHTMLBase;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.plugins.jquery.JQueryReferencePool;
import za.co.mmagon.jwebswing.events.click.ClickAdapter;

/**
 *
 * @author ged_m
 */
public class ComponentHTMLBaseTest
{

    public ComponentHTMLBaseTest()
    {
    }

    @Test
    public void testInlineClosingTag()
    {
        ComponentHTMLBase tag = new ComponentHTMLAttributeBase(ComponentTypes.Area);
        //tag.setInlineClosingTag(true);
        tag.setID("testTag");
        //System.out.println(tag.toString());
        System.out.println(tag.toString(4));
        Assert.assertEquals("				<area id=\"testTag\">\n"
                + "				</area>", tag.toString(4).toString());
    }

    @Test
    public void testInlineClosingTagTiny()
    {
        ComponentHTMLBase tag = new ComponentHTMLAttributeBase(ComponentTypes.Area);
        // tag.setInlineClosingTag(true);
        tag.setTiny(true);
        tag.setID("testTag");
        System.out.println(tag.toString(4));
        Assert.assertEquals("<area id=\"testTag\"></area>", tag.toString(4).toString());
    }

    @Test
    public void testTabIndentRawText()
    {
        ComponentHTMLBase tag = new ComponentHTMLAttributeBase(ComponentTypes.Area);
        tag.setText("Raw Text");
        tag.setID("testTag");
        System.out.println(tag.toString(4));
        Assert.assertEquals("				<area id=\"testTag\">Raw Text\n"
                + "				</area>", tag.toString(4));
    }

    @Test
    public void testTabIndent()
    {
        ComponentHTMLBase tag = new ComponentHTMLAttributeBase(ComponentTypes.Area);
        tag.setID("testTag");
        System.out.println(tag.toString(4));
        Assert.assertEquals("				<area id=\"testTag\">\n"
                + "				</area>", tag.toString(4));
    }

    @Test
    public void testTabIndentTiny()
    {
        ComponentHTMLBase tag = new ComponentHTMLAttributeBase(ComponentTypes.Area);
        tag.setID("testTag");
        tag.setTiny(true);
        System.out.println(tag.toString(4));
        Assert.assertEquals("<area id=\"testTag\"></area>", tag.toString(4));
    }

    @Test
    public void testTagRendering()
    {
        ComponentHTMLBase tag = new ComponentHTMLAttributeBase(ComponentTypes.Area);
        tag.setID("testTag");
        tag.setTiny(true);
        System.out.println(tag.toString(true));
        System.out.println(tag);

    }

    @Test
    public void testClone()
    {
        ComponentEventBase shell = new ComponentEventBase(ComponentTypes.Abbreviation);
        shell.setID("shell");
        shell.addJavaScriptReference(JQueryReferencePool.JQueryV2.getJavaScriptReference());
        shell.addEvent(new ClickAdapter(new Div())
        {
            @Override
            public void onClick(AjaxCall call, AjaxResponse response)
            {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        Event.class.cast(shell.getEvents().get(0)).setID("clickEvent");

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
                + "  \"sortOrder\" : 1000,\n"
                + "  \"renderAfterLoad\" : false,\n"
                + "  \"javascriptRenderedElsewhere\" : false,\n"
                + "  \"events\" : [ {\n"
                + "    \"id\" : \"clickEvent\",\n"
                + "    \"componentType\" : \"event\",\n"
                + "    \"tiny\" : false,\n"
                + "    \"configured\" : true,\n"
                + "    \"initialized\" : true,\n"
                + "    \"touched\" : false,\n"
                + "    \"sortOrder\" : 1000,\n"
                + "    \"variables\" : [ ],\n"
                + "    \"name\" : \"click\",\n"
                + "    \"renderAfterLoad\" : false,\n"
                + "    \"javascriptRenderedElsewhere\" : false,\n"
                + "    \"eventType\" : \"click\"\n"
                + "  } ],\n"
                + "  \"componentClass\" : \"za.co.mmagon.jwebswing.base.ComponentEventBase\"\n"
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
                + "  \"sortOrder\" : 1000,\n"
                + "  \"renderAfterLoad\" : false,\n"
                + "  \"javascriptRenderedElsewhere\" : false,\n"
                + "  \"events\" : [ {\n"
                + "    \"id\" : \"clickEvent\",\n"
                + "    \"componentType\" : \"event\",\n"
                + "    \"tiny\" : false,\n"
                + "    \"configured\" : true,\n"
                + "    \"initialized\" : true,\n"
                + "    \"touched\" : false,\n"
                + "    \"sortOrder\" : 1000,\n"
                + "    \"variables\" : [ ],\n"
                + "    \"name\" : \"click\",\n"
                + "    \"renderAfterLoad\" : false,\n"
                + "    \"javascriptRenderedElsewhere\" : false,\n"
                + "    \"eventType\" : \"click\"\n"
                + "  } ],\n"
                + "  \"componentClass\" : \"za.co.mmagon.jwebswing.base.ComponentEventBase\"\n"
                + "}";
        Assert.assertEquals(shell.toString(), shellExpected);
        Assert.assertEquals(shell2.toString(), shell2Expected);
    }
}
