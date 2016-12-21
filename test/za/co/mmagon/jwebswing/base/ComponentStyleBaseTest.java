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
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.html.Body;
import za.co.mmagon.jwebswing.base.html.Comment;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourNames;

/**
 *
 * @author ged_m
 */
public class ComponentStyleBaseTest
        extends BaseTestClass
{

    public ComponentStyleBaseTest()
    {
    }

    @Test
    public void testCSS()
    {
        Page p = getPage();
        Body b = p.getBody();

        b.getCss().getBackground().setBackgroundColor$(ColourNames.DarkGoldenRod);
        b.add(new Comment("asdf"));

        System.out.println(p.toString());
        System.out.println(p.toString(true));
        Assert.assertEquals("<!DOCTYPE html>\n"
                + "<html>\n"
                + "	<head>\n"
                + "		<style type=\"text/css\">#body {background-color:darkgoldenrod;}</style>\n"
                + "	</head>\n"
                + "	<body id=\"body\">\n"
                + "		<!-- asdf -->\n"
                + "	</body>\n"
                + "</html>", p.toString(true));
    }
}
