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
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 *
 * @author ged_m
 */
public class ComponentBaseTest extends BaseTestClass
{

    public ComponentBaseTest()
    {
    }

    @Test
    public void testShell()
    {
        ComponentBase shell = new ComponentBase(ComponentTypes.Abbreviation);
        shell.setID("ID");
        System.out.println(shell);
        Assert.assertEquals("{\n"
                + "  \"id\" : \"ID\",\n"
                + "  \"componentType\" : \"abbreviation\",\n"
                + "  \"tiny\" : false,\n"
                + "  \"configured\" : true,\n"
                + "  \"initialized\" : true,\n"
                + "  \"touched\" : false,\n"
                + "  \"componentClass\" : \"za.co.mmagon.jwebswing.base.ComponentBase\"\n"
                + "}", shell.toString());
    }

    @Test
    public void testShellRawText()
    {
        ComponentBase shell = new ComponentBase(ComponentTypes.Abbreviation);
        shell.setID("ID");
        shell.setText("This is raw text");
        System.out.println(shell);
        Assert.assertEquals("{\n"
                + "  \"id\" : \"ID\",\n"
                + "  \"componentType\" : \"abbreviation\",\n"
                + "  \"text\" : \"This is raw text\",\n"
                + "  \"tiny\" : false,\n"
                + "  \"configured\" : true,\n"
                + "  \"initialized\" : true,\n"
                + "  \"touched\" : false,\n"
                + "  \"componentClass\" : \"za.co.mmagon.jwebswing.base.ComponentBase\"\n"
                + "}", shell.toString());
    }

    @Test
    public void testShellTiny()
    {
        ComponentBase shell = new ComponentBase(ComponentTypes.Abbreviation);
        shell.setTiny(true);
        shell.setID("ID");
        System.out.println(shell);
        Assert.assertEquals("{\n"
                + "  \"id\" : \"ID\",\n"
                + "  \"componentType\" : \"abbreviation\",\n"
                + "  \"tiny\" : true,\n"
                + "  \"configured\" : true,\n"
                + "  \"initialized\" : true,\n"
                + "  \"touched\" : false,\n"
                + "  \"componentClass\" : \"za.co.mmagon.jwebswing.base.ComponentBase\"\n"
                + "}", shell.toString());
    }

    @Test
    public void testClone()
    {
        ComponentBase shell = new ComponentBase(ComponentTypes.Abbreviation);
        shell.setID("shell");
        ComponentBase shell2 = shell.cloneComponent();
        shell2.setID("shell2");
        System.out.println(shell);
        System.out.println(shell2);
        String shellExpected = "{\n"
                + "  \"id\" : \"shell\",\n"
                + "  \"componentType\" : \"abbreviation\",\n"
                + "  \"tiny\" : false,\n"
                + "  \"configured\" : true,\n"
                + "  \"initialized\" : true,\n"
                + "  \"touched\" : false,\n"
                + "  \"componentClass\" : \"za.co.mmagon.jwebswing.base.ComponentBase\"\n"
                + "}";
        String shell2Expected = "{\n"
                + "  \"id\" : \"shell2\",\n"
                + "  \"componentType\" : \"abbreviation\",\n"
                + "  \"tiny\" : false,\n"
                + "  \"configured\" : true,\n"
                + "  \"initialized\" : true,\n"
                + "  \"touched\" : false,\n"
                + "  \"componentClass\" : \"za.co.mmagon.jwebswing.base.ComponentBase\"\n"
                + "}";
        Assert.assertEquals(shell.toString(), shellExpected);
        Assert.assertEquals(shell2.toString(), shell2Expected);
    }

    @Test
    public void testProperties()
    {
        ComponentBase shell = new ComponentBase(ComponentTypes.Abbreviation);
        shell.setID("shell");
        shell.getProperties().put("Property1", "Value 1");
        System.out.println(shell);

        String shellExpected = "{\n"
                + "  \"id\" : \"shell\",\n"
                + "  \"componentType\" : \"abbreviation\",\n"
                + "  \"tiny\" : false,\n"
                + "  \"configured\" : true,\n"
                + "  \"initialized\" : true,\n"
                + "  \"touched\" : false,\n"
                + "  \"properties\" : {\n"
                + "    \"Property1\" : \"Value 1\"\n"
                + "  },\n"
                + "  \"componentClass\" : \"za.co.mmagon.jwebswing.base.ComponentBase\"\n"
                + "}";

        Assert.assertEquals(shell.toString(), shellExpected);
    }
}
