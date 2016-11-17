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
package za.co.mmagon.jwebswing.components.jqueryUI.accordion;

import za.co.mmagon.jwebswing.components.jqueryui.accordion.JQUIAccordion;
import za.co.mmagon.jwebswing.components.jqueryui.accordion.JQUIAccordionTab;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.junit.Assert;
import org.junit.Test;
import za.co.mmagon.BaseTestClass;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.attributes.HeaderTypes;
import za.co.mmagon.jwebswing.generics.Direction;
import za.co.mmagon.jwebswing.htmlbuilder.effects.EasingEffects;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.events.mouseevents.MouseEventType;

/**
 *
 * @author GedMarc
 */
public class JQUIAccordionTest extends BaseTestClass
{

    public JQUIAccordionTest()
    {
    }

    @Test
    public void testDefault() throws UnsupportedEncodingException, IOException
    {
        JQUIAccordion accordion = new JQUIAccordion();
        accordion.setID("id");
        String rendered = accordion.renderJavascript().toString();
        String expected = "$('#id').accordion();\n";
        System.out.println(rendered);
        Assert.assertEquals(expected, rendered);

    }

    @Test
    public void testIcons() throws UnsupportedEncodingException, IOException
    {
        JQUIAccordion accordion = new JQUIAccordion();
        accordion.setID("id");
        accordion.getOptions().getIcons().setHeader("headerIcons");
        accordion.getOptions().getIcons().setActiveHeader("activeHeaderIcons");
        String expected = "$('#id').accordion({\n"
                + "  icons : {\n"
                + "    header : \"headerIcons\",\n"
                + "    activeHeader : \"activeHeaderIcons\"\n"
                + "  }\n"
                + "});\n"
                + "";
        String rendered = accordion.renderJavascript().toString();
        System.out.println(rendered);

        //super.writeValuesToFile(expected, rendered);
        Assert.assertEquals(expected, rendered);
    }

    @Test
    public void testActive() throws UnsupportedEncodingException, IOException
    {
        JQUIAccordion accordion = new JQUIAccordion();
        accordion.setID("id");
        accordion.getOptions().setActive(1);

        String rendered = accordion.renderJavascript().toString();
        String expected = "$('#id').accordion({\n"
                + "  active : 1\n"
                + "});\n";
        System.out.println(rendered);
        //super.writeValuesToFile(expected, rendered);
        Assert.assertEquals(expected, rendered);
    }

    @Test
    public void testCollapsible() throws UnsupportedEncodingException, IOException
    {
        JQUIAccordion accordion = new JQUIAccordion();
        accordion.setID("id");
        accordion.getOptions().setCollapsible(true);
        String sss = accordion.renderJavascriptAll().toString();
        System.out.println("ssss : " + sss);
        String rendered = accordion.renderJavascript().toString();
        String expected = "$('#id').accordion({\n"
                + "  collapsible : true\n"
                + "});\n";
        System.out.println(rendered);
        //super.writeValuesToFile(expected, rendered);
        Assert.assertEquals(expected, rendered);
    }

    @Test
    public void testAnimate() throws UnsupportedEncodingException, IOException
    {
        JQUIAccordion accordion = new JQUIAccordion();
        accordion.setID("id");
        accordion.getOptions().getAnimate().setDuration(200);
        accordion.getOptions().getAnimate().setDirection(Direction.Vertical);
        accordion.getOptions().getAnimate().setEasing(EasingEffects.easeInBack);
        String rendered = accordion.renderJavascript().toString();
        String expected = "$('#id').accordion({\n"
                + "  animate : {\n"
                + "    easing : \"easeInBack\",\n"
                + "    duration : 200,\n"
                + "    direction : \"vertical\"\n"
                + "  }\n"
                + "});\n";
        System.out.println(rendered);
        //super.writeValuesToFile(expected, rendered);
        Assert.assertEquals(expected, rendered);
    }

    @Test
    public void testEvent() throws UnsupportedEncodingException, IOException
    {
        JQUIAccordion accordion = new JQUIAccordion();
        accordion.setID("id");

        accordion.getOptions().setEvent(MouseEventType.MouseOver);

        String rendered = accordion.renderJavascript().toString();
        String expected = "$('#id').accordion({\n"
                + "  event : \"mouseover\"\n"
                + "});\n";
        System.out.println(rendered);
        //super.writeValuesToFile(expected, rendered);
        Assert.assertEquals(expected, rendered);
    }

    @Test
    public void testHeader() throws UnsupportedEncodingException, IOException
    {
        JQUIAccordion accordion = new JQUIAccordion();
        accordion.setID("id");

        accordion.getOptions().setHeader(HeaderTypes.H3);

        String rendered = accordion.renderJavascript().toString();
        String expected = "$('#id').accordion({\n"
                + "  header : \"h3\"\n"
                + "});\n";
        System.out.println(rendered);
        //super.writeValuesToFile(expected, rendered);
        Assert.assertEquals(expected, rendered);
    }

    @Test
    public void testStructure() throws UnsupportedEncodingException, IOException
    {
        JQUIAccordion accordion = new JQUIAccordion();
        accordion.setID("id");
        Div d1 = new Div();
        d1.setID("d1");
        Div d2 = new Div();
        d2.setID("d2");
        JQUIAccordionTab tab1 = new JQUIAccordionTab("tab1", d1);
        tab1.getHeader().setID("h1");
        JQUIAccordionTab tab2 = new JQUIAccordionTab("tab2", d2);
        tab2.getHeader().setID("h2");

        accordion.addAccordianTab(tab1);
        accordion.addAccordianTab(tab2);

        accordion.getOptions().setHeader(HeaderTypes.H3);

        String rendered = accordion.toString(true).toString();
        String expected = "<div id=\"id\" jwtype=\"accordion\">\n"
                + "	<h3 id=\"h1\">tab1</h3>\n"
                + "	<div id=\"d1\"></div>\n"
                + "	<h3 id=\"h2\">tab2</h3>\n"
                + "	<div id=\"d2\"></div>\n"
                + "</div>";
        System.out.println(rendered);
        //super.writeValuesToFile(expected, rendered);
        Assert.assertEquals(expected, rendered);
    }
}
