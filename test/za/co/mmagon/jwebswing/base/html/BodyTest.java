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

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import za.co.mmagon.BaseTestClass;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.generics.WebReference;
import za.co.mmagon.jwebswing.plugins.jquery.JQueryPageConfigurator;

/**
 *
 * @author MMagon
 */
public class BodyTest extends BaseTestClass
{

    private Page p;
    private Body b;

    public BodyTest()
    {
        resetBody();
    }

    private void resetBody()
    {
        p = new Page();
        b = p.getBody();
    }

    @Test
    public void testBody()
    {
        resetBody();
        System.out.println(b.toString(true));
        assertEquals("<body id=\"body\"></body>", b.toString(true));
    }

    @Test
    public void testSetGenerateJQuery()
    {
        resetBody();
        JQueryPageConfigurator.setRequired(b, true);
        b.add(new Comment("meh"));
        WebReference.setIsLocal(true);
        System.out.println(p.toString(true));
        assertEquals("<!DOCTYPE html>\n"
                + "<html>\n"
                + "	<body id=\"body\">\n"
                + "		<!-- meh -->\n"
                + "		<!-- Priority [First] Values -->\n"
                + "		<script src=\"bower_components/jquery-3/dist/jquery.js\" type=\"text/javascript\"></script>\n"
                + "		<!-- Priority [Second] Values -->\n"
                + "		<script src=\"bower_components/jquery-migrate/jquery-migrate.js\" type=\"text/javascript\"></script>\n"
                + "	</body>\n"
                + "</html>", p.toString(true).toString());
    }

    @Test
    public void testSetGenerateJQueryRemote()
    {
        resetBody();
        JQueryPageConfigurator.setRequired(b, true);
        b.add(new Comment("meh"));
        WebReference.setIsLocal(false);
        System.out.println(p.toString(true));
        assertEquals("<!DOCTYPE html>\n"
                + "<html>\n"
                + "	<body id=\"body\">\n"
                + "		<!-- meh -->\n"
                + "		<!-- Priority [First] Values -->\n"
                + "		<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.js\" type=\"text/javascript\"></script>\n"
                + "		<!-- Priority [Second] Values -->\n"
                + "		<script src=\"http://code.jquery.com/jquery-migrate-1.4.1.js\" type=\"text/javascript\"></script>\n"
                + "	</body>\n"
                + "</html>", p.toString(true).toString());
    }
}
