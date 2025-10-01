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
import com.jwebmp.core.Event;
import com.jwebmp.core.Page;
import com.jwebmp.core.base.ComponentBase;
import com.jwebmp.core.base.ComponentEventBase;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.html.Div;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;
import com.jwebmp.core.events.click.ClickAdapter;
import io.smallrye.mutiny.Uni;
import org.junit.jupiter.api.Test;

/**
 * Enables the Events System in the Component Hierarchy Tree
 *
 * @author GedMarc
 * @version 1
 * @since 2016/04/23
 */
public class ComponentEventBaseTest
        extends BaseTestClass
{

    public ComponentEventBaseTest()
    {
    }


    @Test
    public void testClone()
    {
        ComponentEventBase shell = new ComponentEventBase(ComponentTypes.Abbreviation);
        shell.setID("shell");
        shell.addEvent(new ClickAdapter(new Div())
        {
            @Override
            public Uni<Void> onClick(AjaxCall call, AjaxResponse response)
            {
                throw new UnsupportedOperationException("Not supported yet.");
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
        String shellExpected = "{\n" +
                "  \"id\" : \"shell\",\n" +
                "  \"componentType\" : \"abbreviation\",\n" +
                "  \"tiny\" : false,\n" +
                "  \"configured\" : true,\n" +
                "  \"initialized\" : true,\n" +
                "  \"touched\" : false,\n" +
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
                "    \"variables\" : [ \"jwCntrl.jw.localstorage\" ],\n" +
                "    \"name\" : \"click\",\n" +
                "    \"renderAfterLoad\" : false,\n" +
                "    \"javascriptRenderedElsewhere\" : false,\n" +
                "    \"registeredComponents\" : [ \"com.jwebmp.core.base.html.Div\" ],\n" +
                "    \"eventType\" : \"click\"\n" +
                "  } ],\n" +
                "  \"componentClass\" : \"com.jwebmp.core.base.ComponentEventBase\"\n" +
                "}";
        String shell2Expected = "{\n" +
                "  \"id\" : \"shell2\",\n" +
                "  \"componentType\" : \"abbreviation\",\n" +
                "  \"tiny\" : false,\n" +
                "  \"configured\" : true,\n" +
                "  \"initialized\" : true,\n" +
                "  \"touched\" : false,\n" +
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
                "    \"variables\" : [ \"jwCntrl.jw.localstorage\" ],\n" +
                "    \"name\" : \"click\",\n" +
                "    \"renderAfterLoad\" : false,\n" +
                "    \"javascriptRenderedElsewhere\" : false,\n" +
                "    \"registeredComponents\" : [ \"com.jwebmp.core.base.html.Div\" ],\n" +
                "    \"eventType\" : \"click\"\n" +
                "  } ],\n" +
                "  \"componentClass\" : \"com.jwebmp.core.base.ComponentEventBase\"\n" +
                "}";
        //		Assertions.assertEquals(shell.toJson(), shellExpected);
        //	Assertions.assertEquals(shell2.toJson(), shell2Expected);
    }

    @Test
    public void testHtml()
    {
        ComponentEventBase shell = new ComponentEventBase(ComponentTypes.Abbreviation);
        shell.setID("shell");
        Event e;
        Div d;
        shell.addEvent(e = new ClickAdapter(d = new Div())
        {
            @Override
            public Uni<Void> onClick(AjaxCall call, AjaxResponse response)
            {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });

        Event.class.cast(shell.getEvents()
                              .stream()
                              .findFirst()
                              .get())
                   .setID("clickEvent");
        d.addEvent(e);

        System.out.println(d.toString(true));
    }

    @Test
    public void testPageHtml()
    {
        ComponentEventBase shell = new ComponentEventBase(ComponentTypes.Abbreviation);
        shell.setID("shell");
        Event e;
        Div d;
        shell.addEvent(e = new ClickAdapter(d = new Div())
        {
            @Override
            public Uni<Void> onClick(AjaxCall call, AjaxResponse response)
            {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });

        Event.class.cast(shell.getEvents()
                              .stream()
                              .findFirst()
                              .get())
                   .setID("clickEvent");
        d.addEvent(e);

        Page<?> page = getInstance();
        page.getBody()
            .add(d);
        System.out.println(page.toString(true));

    }
}
