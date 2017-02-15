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
import za.co.mmagon.jwebswing.base.html.*;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 *
 * @author ged_m
 */
public class ComponentHierarchyBaseTest extends BaseTestClass
{

    public ComponentHierarchyBaseTest()
    {
    }

    @Test
    public void test()
    {
        ComponentHierarchyBase head = new ComponentHierarchyBase(ComponentTypes.Head);
        head.add(new Meta("name"));
        head.add(new Meta(Meta.MetadataFields.Author, "Author Me"));
        ComponentHierarchyBase body = new ComponentHierarchyBase(ComponentTypes.Body);
        System.out.println(head.toString());
        System.out.println(head.toString(true));
        System.out.println(body.toString(true));
    }

    @Test
    public void testChildrenReferences()
    {
        ComponentHierarchyBase chb = new ComponentHierarchyBase(ComponentTypes.Paragraph);
        ComponentHierarchyBase chb1 = new ComponentHierarchyBase(ComponentTypes.Paragraph);
        ComponentHierarchyBase chb2 = new ComponentHierarchyBase(ComponentTypes.Paragraph);
        ComponentHierarchyBase chb3 = new ComponentHierarchyBase(ComponentTypes.Paragraph);

        chb.add(chb1);
        chb.add(chb2);
        chb.add(chb3);

        System.out.println(chb.getJavascriptReferencesAll());
        Assert.assertEquals("[bower_components/PACE/pace.js]", chb.getJavascriptReferencesAll().toString());
        System.out.println(chb.getCssReferencesAll());
        Assert.assertEquals("[bower_components/PACE/themes/red/pace-theme-barber-shop.css, bower_components/PACE/themes/red/pace-theme-bounce.css, bower_components/PACE/themes/red/pace-theme-center-rader.css]", chb.getCssReferencesAll().toString());
    }

    @Test
    public void testChildrenPreConfigure()
    {
        Body b = getPage().getBody();
        Paragraph p = new Paragraph("Text");
        b.add(p);
        b.preConfigure();
        System.out.println(p);
        //System.out.println(b.getPage().toString(true));
    }

    /*
     * @Test public void testFindParent() { Body b = getPage().getBody(); BSForm form = new BSForm(); b.add(form);
     *
     * Body compFound = form.findParent(Body.class); System.out.println(" Found Parent? : " + (compFound != null) + (compFound != null ? " " + compFound.getClass() : ""));
     *
     * Div d1 = new Div(); Div d2 = new Div(); Div d3 = new Div(); Div d4 = new Div(); Div d5 = new Div(); form.add(d1); d1.add(d2); d2.add(d3); d3.add(d4); d4.add(d5);
     *
     * BSForm formFound = (BSForm) d5.findParent(BSForm.class); System.out.println(" Found Parent? : " + (formFound != null) + (formFound != null ? " " + formFound.getClass() : ""));
     * System.out.println(formFound.toString(true));
     *
     * }
     */

    @Test
    public void testClasses()
    {
        ComponentHierarchyBase tag = new ComponentHierarchyBase(ComponentTypes.Area);
        tag.setID("testTag");
        tag.addClass("This is a class");
        tag.addClass("KKKKKKK");
        System.out.println(tag);
        System.out.println(tag.toString(true));
        Assert.assertEquals("<area class=\"This is a class KKKKKKK\" id=\"testTag\">\n"
                + "</area>", tag.toString(true));
    }

    @Test
    public void testClassesTiny()
    {
        ComponentHierarchyBase tag = new ComponentHierarchyBase(ComponentTypes.Area);
        tag.setID("testTag");
        tag.setTiny(true);
        tag.addClass("Class1");
        tag.addClass("Class2");
        System.out.println(tag);
        System.out.println(tag.toString(true));
        Assert.assertEquals("<area class=\"Class1 Class2\" id=\"testTag\"></area>", tag.toString(true));
    }

}
