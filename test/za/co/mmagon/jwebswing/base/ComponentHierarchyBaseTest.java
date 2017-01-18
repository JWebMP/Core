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
import za.co.mmagon.jwebswing.components.pace.PaceLoaderReferencePool;
import za.co.mmagon.jwebswing.components.pace.preloadedThemes.PaceTheme;

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
        chb1.addJavaScriptReference(PaceLoaderReferencePool.PaceLoader.getJavaScriptReference());
        ComponentHierarchyBase chb2 = new ComponentHierarchyBase(ComponentTypes.Paragraph);
        chb2.addCssReference(PaceTheme.Barbershop.getCSSReference());
        chb2.addCssReference(PaceTheme.Bounce.getCSSReference());
        chb2.addCssReference(PaceTheme.CenterRader.getCSSReference());
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
}
