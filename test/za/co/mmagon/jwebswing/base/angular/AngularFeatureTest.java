
/*
 * Copyright (C) 2016 GedMarc
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
package za.co.mmagon.jwebswing.base.angular;

import org.junit.Test;
import za.co.mmagon.BaseTestClass;
import za.co.mmagon.FileTemplates;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.html.Body;
import za.co.mmagon.jwebswing.events.rightclick.RightClickDirective;

/**
 *
 * @author GedMarc
 */
public class AngularFeatureTest extends BaseTestClass
{

    public AngularFeatureTest()
    {
    }

    @Test
    public void testAngular()
    {
        Page p = getPage();
        Body b = p.getBody();
        p.addAngularVariable("Variable1");
        //System.out.println(p);
        //System.out.println(p.toString(true));
        //System.out.println(b.toString(true));
        p.getAngular().configureTemplateVariables();
        System.out.println(FileTemplates.renderTemplateScripts("jwangular"));
    }

    @Test
    public void testTemplateScript()
    {
        Page p = getPage();
        Body b = p.getBody();
        p.addAngularVariable("Variable1");
        //System.out.println(p);
        //System.out.println(p.toString(true));
        //System.out.println(b.toString(true));
        p.getAngular().configureTemplateVariables();
        System.out.println(FileTemplates.getTemplateScript("jwangular"));
    }

    @Test
    public void testTemplateScriptWithDirective()
    {
        Page p = getPage();
        Body b = p.getBody();
        p.addAngularVariable("Variable1");
        b.getPage().getBody().getAngularDirectives().add(new RightClickDirective(b.getPage().getAngular()));
        //System.out.println(p);
        //System.out.println(p.toString(true));
        //System.out.println(b.toString(true));
        p.getAngular().configureTemplateVariables();
        System.out.println(FileTemplates.renderTemplateScripts("jwangular"));
    }

    @Test
    public void testBodyAttributes()
    {
        Page p = getPage();
        Body b = p.getBody();
        p.getOptions().setAngularEnabled(true);
        p.getAngular().configureTemplateVariables();
        System.out.println(p.toString(true));
    }
}
