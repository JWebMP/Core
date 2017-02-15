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
package za.co.mmagon;

import java.io.FileWriter;
import java.io.IOException;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.html.Body;

/**
 * This Class
 *
 * @author GedMarc
 * @since 13 Jan 2016
 */
public class BaseTestClass
{

    public BaseTestClass()
    {

    }

    public Page getInstance()
    {
        return resetInstance();
    }

    public Page resetInstance()
    {
        soutDivider();
        Page page = new Page();
        Body body = new Body(page);
        page.setID("Page");
        body.setID("Body");
        page.getOptions().setDynamicRender(false);
        return page;
    }

    public void soutDivider()
    {
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<===============================================================>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    public Page getPage()
    {
        return resetInstance();
    }

    protected void writeValuesToFile(String expected, String rendered)
    {
        try (FileWriter fw = new FileWriter("c:/temp/equalsText.txt"))
        {
            fw.write(rendered);
            fw.write("\n\n-----\n\n");
            fw.write(expected);
        }
        catch (IOException ex)
        {
            System.out.println("Couldn't write to file");
        }
    }

    public Feature getFeature()
    {
        Feature f = new Feature("Test Feature")
        {
            @Override
            public void assignFunctionsToComponent()
            {
                addQuery(new StringBuilder("Query Added"));
            }
        };
        f.setID("featureTest");
        return f;
    }

    /*
     * public ComponentEventBase getEvent() { ComponentEventBase e = new Event(EventTypes.activate, EventTypes.activate) { @Override public void fireEvent(AjaxCallObject ajaxObject, String calledFrom,
     * AjaxReceiver ajaxReceiver) { throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates. } }; e.setID("testEvent");
     * e.addQuery("This is the event query"); return e; }
     */
}
