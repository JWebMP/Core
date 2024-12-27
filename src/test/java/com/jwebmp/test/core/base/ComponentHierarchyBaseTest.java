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
import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.html.Body;
import com.jwebmp.core.base.html.Meta;
import com.jwebmp.core.base.html.Paragraph;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author ged_m
 */
public class ComponentHierarchyBaseTest
        extends BaseTestClass
{

    public ComponentHierarchyBaseTest()
    {
    }

    @Test
    public void test()
    {
        com.jwebmp.core.base.ComponentHierarchyBase head = new com.jwebmp.core.base.ComponentHierarchyBase(ComponentTypes.Head);
        head.add(new Meta("name"));
        head.add(new Meta(Meta.MetadataFields.Author, "Author Me"));
        com.jwebmp.core.base.ComponentHierarchyBase body = new com.jwebmp.core.base.ComponentHierarchyBase(ComponentTypes.Body);
        System.out.println(head.toJson());
        System.out.println(head.toString(true));
        System.out.println(body.toString(true));
    }

    @Test
    public void testChildrenPreConfigure()
    {
        Body b = getInstance().getBody();
        Paragraph p = new Paragraph("Text");
        b.add(p);
        //b.preConfigure();
        System.out.println(p.toString(0));
        //System.out.println(b.getPage().toString(true));
    }

    @Test
    public void testClasses()
    {
        com.jwebmp.core.base.ComponentHierarchyBase tag = new com.jwebmp.core.base.ComponentHierarchyBase(ComponentTypes.Area);
        tag.setID("testTag");
        tag.addClass("This is a class");
        tag.addClass("KKKKKKK");
        System.out.println(tag);
        System.out.println(tag.toString(true));
        Assertions.assertEquals("<area class=\"This is a class KKKKKKK\" id=\"testTag\">" + "</area>", tag.toString(true));
    }

    @Test
    public void testClassesTiny()
    {
        com.jwebmp.core.base.ComponentHierarchyBase tag = new ComponentHierarchyBase(ComponentTypes.Area);
        tag.setID("testTag");
        tag.setTiny(true);
        tag.addClass("Class1");
        tag.addClass("Class2");
        System.out.println(tag);
        System.out.println(tag.toString(true));
        Assertions.assertEquals("<area class=\"Class1 Class2\" id=\"testTag\"></area>", tag.toString(true));
    }

}
