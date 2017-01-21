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
package za.co.mmagon.jwebswing.components.jquery.bootstrap.themes;

import org.junit.Assert;
import org.junit.Test;
import za.co.mmagon.BaseTestClass;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.html.*;
import za.co.mmagon.jwebswing.components.bootstrap.themes.SB2Theme;

/**
 *
 * @author GedMarc
 */
public class SBAdmin2ThemeTest extends BaseTestClass
{

    public SBAdmin2ThemeTest()
    {
    }

    @Test
    public void testAddingThemeToBody()
    {
        SB2Theme theme = new SB2Theme();
        Page p = getPage();
        Body b = p.getBody();
        b.add(new Comment("Stuff"));
        b.addTheme(theme);

        System.out.println(p.toString(true));
        Assert.assertEquals("<!DOCTYPE html>\n"
                + "<html>\n"
                + "	<head>\n"
                + "		<link href=\"bower_components/startbootstrap-sb-admin-2/dist/css/sb-admin-2.css\" rel=\"stylesheet\" type=\"text/css\">\n"
                + "		<link href=\"bower_components/bootstrap-social/bootstrap-social.css\" rel=\"stylesheet\" type=\"text/css\">\n"
                + "	</head>\n"
                + "	<body id=\"body\">\n"
                + "		<!-- Stuff -->\n"
                + "	</body>\n"
                + "</html>", p.toString(true));

    }

    @Test
    public void testAddingThemeToAny()
    {
        SB2Theme theme = new SB2Theme();
        Page p = getPage();
        Body b = p.getBody();
        b.add(new Comment("Stuff"));
        Paragraph pa = new Paragraph("Paragraph Here");
        b.add(pa);
        pa.setID("paragraph");
        pa.addTheme(theme);

        System.out.println(p.toString(true));
        Assert.assertEquals("<!DOCTYPE html>\n"
                + "<html>\n"
                + "	<head>\n"
                + "		<link href=\"bower_components/startbootstrap-sb-admin-2/dist/css/sb-admin-2.css\" rel=\"stylesheet\" type=\"text/css\">\n"
                + "		<link href=\"bower_components/bootstrap-social/bootstrap-social.css\" rel=\"stylesheet\" type=\"text/css\">\n"
                + "	</head>\n"
                + "	<body id=\"body\">\n"
                + "		<!-- Stuff -->\n"
                + "		<p id=\"paragraph\">Paragraph Here</p>\n"
                + "	</body>\n"
                + "</html>", p.toString(true));
    }
}
