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
package com.jwebmp.base;

import com.jwebmp.Event;
import com.jwebmp.base.ajax.AjaxCall;
import com.jwebmp.base.ajax.AjaxResponse;
import com.jwebmp.base.html.Div;
import com.jwebmp.base.servlets.enumarations.ComponentTypes;
import com.jwebmp.events.click.ClickAdapter;
import com.jwebmp.plugins.jquery.JQueryReferencePool;
import org.junit.jupiter.api.Test;

/**
 * @author ged_m
 */
public class ComponentHTMLAttributeTest
{

	public ComponentHTMLAttributeTest()
	{
	}

	@Test
	public void testClone()
	{
		ComponentHTMLAttributeBase shell = new ComponentHTMLAttributeBase(ComponentTypes.Abbreviation);
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
		Event.class.cast(shell.getEvents()
		                      .stream()
		                      .findFirst()
		                      .get())
		           .setID("clickEvent");

		ComponentBase shell2 = shell.cloneComponent();
		shell2.setID("shell2");
		System.out.println(shell);
		System.out.println(shell2);
		String shellExpected = "{\n" + "  \"id\" : \"shell\",\n" + "  \"componentType\" : \"abbreviation\",\n" + "  \"tiny\" : false,\n" + "  \"configured\" : true,\n" + "  \"initialized\" : true,\n" + "  \"touched\" : false,\n" + "  \"javascriptReferences\" : [ {\n" + "    \"cordovaRequired\" : false,\n" + "    \"name\" : \"PersistJS\",\n" + "    \"version\" : 1.0,\n" + "    \"reference\" : \"persist-js/persist-all-min.js\"\n" + "  } ],\n" + "  \"sortOrder\" : 1000,\n" + "  \"renderAfterLoad\" : false,\n" + "  \"javascriptRenderedElsewhere\" : false,\n" + "  \"events\" : [ {\n" + "    \"id\" : \"clickEvent\",\n" + "    \"componentType\" : \"event\",\n" + "    \"tiny\" : false,\n" + "    \"configured\" : true,\n" + "    \"initialized\" : true,\n" + "    \"touched\" : false,\n" + "    \"sortOrder\" : 1000,\n" + "    \"name\" : \"click\",\n" + "    \"renderAfterLoad\" : false,\n" + "    \"javascriptRenderedElsewhere\" : false,\n" + "    \"registeredComponents\" : [ \"com.jwebmp.base.html.Div\" ],\n" + "    \"eventType\" : \"click\"\n" + "  } ],\n" + "  \"tag\" : \"abbr\",\n" + "  \"closingTag\" : true,\n" + "  \"newLineForRawText\" : false,\n" + "  \"newLineForClosingTag\" : true,\n" + "  \"renderTextBeforeChildren\" : true,\n" + "  \"attributes\" : {\n" + "    \"id\" : \"shell\"\n" + "  },\n" + "  \"componentClass\" : \"com.jwebmp.base.ComponentHTMLAttributeBase\"\n" + "}";
		String shell2Expected = "{\n" + "  \"id\" : \"shell2\",\n" + "  \"componentType\" : \"abbreviation\",\n" + "  \"tiny\" : false,\n" + "  \"configured\" : true,\n" + "  \"initialized\" : true,\n" + "  \"touched\" : false,\n" + "  \"javascriptReferences\" : [ {\n" + "    \"cordovaRequired\" : false,\n" + "    \"name\" : \"PersistJS\",\n" + "    \"version\" : 1.0,\n" + "    \"reference\" : \"persist-js/persist-all-min.js\"\n" + "  } ],\n" + "  \"sortOrder\" : 1000,\n" + "  \"renderAfterLoad\" : false,\n" + "  \"javascriptRenderedElsewhere\" : false,\n" + "  \"events\" : [ {\n" + "    \"id\" : \"clickEvent\",\n" + "    \"componentType\" : \"event\",\n" + "    \"tiny\" : false,\n" + "    \"configured\" : true,\n" + "    \"initialized\" : true,\n" + "    \"touched\" : false,\n" + "    \"sortOrder\" : 1000,\n" + "    \"name\" : \"click\",\n" + "    \"renderAfterLoad\" : false,\n" + "    \"javascriptRenderedElsewhere\" : false,\n" + "    \"registeredComponents\" : [ \"com.jwebmp.base.html.Div\" ],\n" + "    \"eventType\" : \"click\"\n" + "  } ],\n" + "  \"tag\" : \"abbr\",\n" + "  \"closingTag\" : true,\n" + "  \"newLineForRawText\" : false,\n" + "  \"newLineForClosingTag\" : true,\n" + "  \"renderTextBeforeChildren\" : true,\n" + "  \"attributes\" : {\n" + "    \"id\" : \"shell2\"\n" + "  },\n" + "  \"componentClass\" : \"com.jwebmp.base.ComponentHTMLAttributeBase\"\n" + "}";
		//		Assertions.assertEquals(shell.toString(), shellExpected);
		//	Assertions.assertEquals(shell2.toString(), shell2Expected);
	}
}
