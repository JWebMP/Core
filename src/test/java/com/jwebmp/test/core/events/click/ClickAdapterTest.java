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
package com.jwebmp.test.core.events.click;

import com.jwebmp.core.events.click.ClickAdapter;
import com.jwebmp.test.BaseTestClass;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.html.Div;
import com.jwebmp.core.base.html.DivSimple;
import io.smallrye.mutiny.Uni;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author GedMarc
 */
public class ClickAdapterTest
        extends BaseTestClass
{

    public ClickAdapterTest()
    {
    }

    @Test
    public void test()
    {
        Div test = new DivSimple<>();
        test.setID("test");
        ClickAdapter aa = new ClickAdapter(test)
        {
            @Override
            public Uni<Void> onClick(AjaxCall call, AjaxResponse response)
            {
                return Uni.createFrom()
                          .voidItem();
            }
        };
        test.addEvent(aa.setID("test"));
        assertTrue(!test.getEvents()
                        .isEmpty());
    }

    @Test
    public void testDirective()
    {
        Div test = new DivSimple<>();
        test.setID("test");

        ClickAdapter aa = new ClickAdapter(test)
        {
            @Override
            public Uni<Void> onClick(AjaxCall call, AjaxResponse response)
            {
                return Uni.createFrom()
                          .voidItem();
            }
        };
        test.addEvent(aa.setID("test"));
        System.out.println(test.toString(0));

    }

    @Test
    public void testDouble()
    {
        Div test = new DivSimple<>();
        test.setID("test");

        ClickAdapter aa = new ClickAdapter(test)
        {
            @Override
            public Uni<Void> onClick(AjaxCall call, AjaxResponse response)
            {
                return Uni.createFrom()
                          .voidItem();
            }
        };
        ClickAdapter ab = new ClickAdapter(test)
        {
            @Override
            public Uni<Void> onClick(AjaxCall call, AjaxResponse response)
            {
                return Uni.createFrom()
                          .voidItem();
            }
        };
        ab.setID("test4");
        test.addEvent(aa.setID("test"));
        test.addEvent(ab);
        System.out.println(test.toString(0));

    }
}
