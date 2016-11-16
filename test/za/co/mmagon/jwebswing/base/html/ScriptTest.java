/*
 * Copyright (C) 2014 MMagon
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
package za.co.mmagon.jwebswing.base.html;

import static org.junit.Assert.*;
import org.junit.Test;
import za.co.mmagon.jwebswing.base.html.attributes.ScriptAttributes;

/**
 *
 * @author MMagon
 */
public class ScriptTest
{

    public ScriptTest()
    {
    }

    @Test
    public void testJavascript()
    {
        java.util.Date start = new java.util.Date();
        Script s = new Script("src");
        //java.util.Date construct = new java.util.Date();
        //System.out.println("Script Construct Time [" + (construct.getTime() - start.getTime()) + "]");
        s.setJavascript("javascript");
        //java.util.Date attribute = new java.util.Date();
        //System.out.println("Script Attribute Time [" + (attribute.getTime() - start.getTime()) + "]");
        StringBuilder sb = new StringBuilder(s.toString(true));
        java.util.Date html = new java.util.Date();
        System.out.println("Script HTML Time [" + (html.getTime() - start.getTime()) + "]");
        System.out.println(sb.toString());

        start = new java.util.Date();
        s = new Script();
        s.setJavascript("javascript");
        html = new java.util.Date();
        sb = new StringBuilder(s.toString(true));
        System.out.println("Second Script Construct Time [" + (html.getTime() - start.getTime()) + "]");
        System.out.println(sb.toString());

        Script s1 = new Script();
        Script s2 = new Script();
        assertEquals(s1, s2);

        s2.addAttribute(ScriptAttributes.Type, "type");
        System.out.println(s1.equals(s2));
    }

}
