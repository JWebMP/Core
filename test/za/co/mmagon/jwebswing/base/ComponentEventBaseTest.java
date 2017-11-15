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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;
import za.co.mmagon.jwebswing.Event;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.events.click.ClickAdapter;
import za.co.mmagon.jwebswing.plugins.jquery.JQueryReferencePool;

/**
 * Enables the Events System in the Component Hierarchy Tree
 *
 * @author GedMarc
 * @version 1
 * @since 2016/04/23
 */
public class ComponentEventBaseTest extends BaseTestClass
{
	
	public ComponentEventBaseTest()
	{
	}
	
	@Test
	public void testEventBase()
	{
		//System.out.println(getEvent());
	}
	
	@Test
	public void testClone()
	{
		ComponentEventBase shell = new ComponentEventBase(ComponentTypes.Abbreviation);
		shell.setID("shell");
		shell.addJavaScriptReference(JQueryReferencePool.PersistJS.getJavaScriptReference());
		shell.addEvent(new ClickAdapter(new Div())
		{
			@Override
			public void onClick(AjaxCall call, AjaxResponse response)
			{
				throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
			}
		});
		Event.class.cast(shell.getEvents().stream().findFirst().get()).setID("clickEvent");
		
		ComponentBase shell2 = shell.cloneComponent();
		shell2.setID("shell2");
		System.out.println(shell);
		System.out.println(shell2);
		String shellExpected = "{\n" +
				                       "  \"id\" : \"shell\",\n" +
				                       "  \"componentType\" : \"abbreviation\",\n" +
				                       "  \"tiny\" : false,\n" +
				                       "  \"configured\" : true,\n" +
				                       "  \"initialized\" : true,\n" +
				                       "  \"touched\" : false,\n" +
				                       "  \"javascriptReferences\" : [ {\n" +
				                       "    \"cordovaRequired\" : false,\n" +
				                       "    \"name\" : \"PersistJS\",\n" +
				                       "    \"version\" : 1.0,\n" +
				                       "    \"reference\" : \"persist-js/persist-all-min.js\"\n" +
				                       "  } ],\n" +
				                       "  \"sortOrder\" : 1000,\n" +
				                       "  \"renderAfterLoad\" : false,\n" +
				                       "  \"javascriptRenderedElsewhere\" : false,\n" +
				                       "  \"events\" : [ {\n" +
				                       "    \"id\" : \"clickEvent\",\n" +
				                       "    \"componentType\" : \"event\",\n" +
				                       "    \"tiny\" : false,\n" +
				                       "    \"configured\" : true,\n" +
				                       "    \"initialized\" : true,\n" +
				                       "    \"touched\" : false,\n" +
				                       "    \"sortOrder\" : 1000,\n" +
				                       "    \"name\" : \"click\",\n" +
				                       "    \"renderAfterLoad\" : false,\n" +
				                       "    \"javascriptRenderedElsewhere\" : false,\n" +
				                       "    \"registeredComponents\" : [ \"za.co.mmagon.jwebswing.base.html.Div\" ],\n" +
				                       "    \"eventType\" : \"click\"\n" +
				                       "  } ],\n" +
				                       "  \"componentClass\" : \"za.co.mmagon.jwebswing.base.ComponentEventBase\"\n" +
				                       "}";
		String shell2Expected = "{\n" +
				                        "  \"id\" : \"shell2\",\n" +
				                        "  \"componentType\" : \"abbreviation\",\n" +
				                        "  \"tiny\" : false,\n" +
				                        "  \"configured\" : true,\n" +
				                        "  \"initialized\" : true,\n" +
				                        "  \"touched\" : false,\n" +
				                        "  \"javascriptReferences\" : [ {\n" +
				                        "    \"cordovaRequired\" : false,\n" +
				                        "    \"name\" : \"PersistJS\",\n" +
				                        "    \"version\" : 1.0,\n" +
				                        "    \"reference\" : \"persist-js/persist-all-min.js\"\n" +
				                        "  } ],\n" +
				                        "  \"sortOrder\" : 1000,\n" +
				                        "  \"renderAfterLoad\" : false,\n" +
				                        "  \"javascriptRenderedElsewhere\" : false,\n" +
				                        "  \"events\" : [ {\n" +
				                        "    \"id\" : \"clickEvent\",\n" +
				                        "    \"componentType\" : \"event\",\n" +
				                        "    \"tiny\" : false,\n" +
				                        "    \"configured\" : true,\n" +
				                        "    \"initialized\" : true,\n" +
				                        "    \"touched\" : false,\n" +
				                        "    \"sortOrder\" : 1000,\n" +
				                        "    \"name\" : \"click\",\n" +
				                        "    \"renderAfterLoad\" : false,\n" +
				                        "    \"javascriptRenderedElsewhere\" : false,\n" +
				                        "    \"registeredComponents\" : [ \"za.co.mmagon.jwebswing.base.html.Div\" ],\n" +
				                        "    \"eventType\" : \"click\"\n" +
				                        "  } ],\n" +
				                        "  \"componentClass\" : \"za.co.mmagon.jwebswing.base.ComponentEventBase\"\n" +
				                        "}";
		Assertions.assertEquals(shell.toString(), shellExpected);
		Assertions.assertEquals(shell2.toString(), shell2Expected);
	}
	
	@Test
	public void testHtml()
	{
		ComponentEventBase shell = new ComponentEventBase(ComponentTypes.Abbreviation);
		shell.setID("shell");
		shell.addJavaScriptReference(JQueryReferencePool.JQueryV2.getJavaScriptReference());
		Event e;
		Div d;
		shell.addEvent(e = new ClickAdapter(d = new Div())
		{
			@Override
			public void onClick(AjaxCall call, AjaxResponse response)
			{
				throw new UnsupportedOperationException("Not supported yet.");
			}
		});

		Event.class.cast(shell.getEvents().stream().findFirst().get()).setID("clickEvent");
		d.addEvent(e);
		
		System.out.println(d.toString(true));
	}
	
	@Test
	public void testPageHtml()
	{
		ComponentEventBase shell = new ComponentEventBase(ComponentTypes.Abbreviation);
		shell.setID("shell");
		shell.addJavaScriptReference(JQueryReferencePool.JQueryV2.getJavaScriptReference());
		Event e;
		Div d;
		shell.addEvent(e = new ClickAdapter(d = new Div())
		{
			@Override
			public void onClick(AjaxCall call, AjaxResponse response)
			{
				throw new UnsupportedOperationException("Not supported yet.");
			}
		});

		Event.class.cast(shell.getEvents().stream().findFirst().get()).setID("clickEvent");
		d.addEvent(e);
		
		Page page = getInstance();
		page.getBody().add(d);
		System.out.println(page.toString(true));
		
	}
}
