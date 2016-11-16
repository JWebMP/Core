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
package za.co.mmagon.jwebswing.components.jqxWidgets.buttons;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import za.co.mmagon.jwebswing.components.jqxWidgets.themes.JQXWidgetThemes;

/**
 *
 * @author GedMarc
 */
public class JQXButtonFeatureTest
{

    public JQXButtonFeatureTest()
    {
    }

    /**
     * Test of getOptions method, of class JQXButtonFeature.
     */
    @Test
    public void testGetOptions()
    {
    }

    /**
     * Test of assignFunctionsToComponent method, of class JQXButtonFeature.
     */
    @Test
    public void testAssignFunctionsToComponent()
    {
        JQXButton but = new JQXButton();
        but.setID("id");
        but.getFeature().getOptions().setToggled(true);
        but.getFeature().getOptions().setTemplate(JQXButtonTemplates.Default);
        System.out.println(but.renderJavascript());
       // System.out.println(but.renderJavascript());
        assertEquals("$('#id').jqxButton({\n"
                + "  template : \"default\",\n"
                + "  toggled : true\n"
                + "});\n", but.renderJavascript().toString());

    }

    @Test
    public void testTemplate()
    {
        JQXButton but = new JQXButton();
        but.setID("id");
        but.getOptions().setToggled(true);
        but.getOptions().setTemplate(JQXButtonTemplates.Default);
     //   System.out.println(but.renderJavascript());
        System.out.println(but.renderJavascript());
        assertEquals("$('#id').jqxButton({\n"
                + "  template : \"default\",\n"
                + "  toggled : true\n"
                + "});\n", but.renderJavascript().toString());
    }

    @Test
    public void testTheme()
    {
        JQXButton but = new JQXButton();
        but.setID("id");
        but.getOptions().setTheme(JQXWidgetThemes.Fresh);
       // System.out.println(but.renderJavascript());
        System.out.println(but.renderJavascript());
        assertEquals("$('#id').jqxButton({\n"
                + "  theme : \"fresh\"\n"
                + "});\n"
                + "", but.renderJavascript().toString());
    }

    @Test
    public void testToStringFirst()
    {
        JQXButton but = new JQXButton();
        but.setID("id");
        but.getOptions().setTheme(JQXWidgetThemes.Fresh);
        but.toString(true);
    //    System.out.println(but.renderJavascript());
        System.out.println(but.renderJavascript());
        assertEquals("$('#id').jqxButton({\n"
                + "  theme : \"fresh\"\n"
                + "});\n"
                + "", but.renderJavascript().toString());
    }
}
