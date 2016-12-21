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
    public void testLoader()
    {
        resetBody();
        p.getOptions().setPaceEnabled(true);
        b.add(new Comment("asdf"));
        WebReference.setIsLocal(true);
        //b.addFeature(new PaceLoader(PaceTheme.Bounce));
        System.out.println(p.toString(true));
        assertEquals("<!DOCTYPE html>\n"
                + "<html>\n"
                + "	<head>\n"
                + "		<script src=\"bower_components/PACE/pace.js\" type=\"text/javascript\"></script>\n"
                + "		<link href=\"bower_components/PACE/themes/red/pace-theme-flash.css\" rel=\"stylesheet\" type=\"text/css\">\n"
                + "	</head>\n"
                + "	<body id=\"body\">\n"
                + "		<!-- asdf -->\n"
                + "	</body>\n"
                + "</html>", p.toString(true).toString());
    }

    @Test
    public void testSetGenerateJQuery()
    {
        resetBody();
        p.getOptions().setjQueryEnabled(true);
        b.add(new Comment("meh"));
        WebReference.setIsLocal(true);
        System.out.println(p.toString(true));
        assertEquals("<!DOCTYPE html>\n"
                + "<html>\n"
                + "	<body id=\"body\">\n"
                + "		<!-- meh -->\n"
                + "		<script src=\"bower_components/jquery-3/dist/jquery.js\" type=\"text/javascript\"></script>\n"
                + "		<script src=\"bower_components/jquery-migrate/jquery-migrate.js\" type=\"text/javascript\"></script>\n"
                + "	</body>\n"
                + "</html>", p.toString(true).toString());
    }

    @Test
    public void testSetGenerateJQueryRemote()
    {
        resetBody();
        p.getOptions().setjQueryEnabled(true);
        b.add(new Comment("meh"));
        WebReference.setIsLocal(false);
        System.out.println(p.toString(true));
        assertEquals("<!DOCTYPE html>\n"
                + "<html>\n"
                + "	<body id=\"body\">\n"
                + "		<!-- meh -->\n"
                + "		<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.js\" type=\"text/javascript\"></script>\n"
                + "		<script src=\"http://code.jquery.com/jquery-migrate-1.4.1.js\" type=\"text/javascript\"></script>\n"
                + "	</body>\n"
                + "</html>", p.toString(true).toString());
    }

    @Test
    public void testSetGenerateUI()
    {
        resetBody();
        p.getOptions().setjQueryUIEnabled(true);
        WebReference.setIsLocal(false);
        System.out.println(p.toString(true));
        assertEquals("<!DOCTYPE html>\n"
                + "<html>\n"
                + "	<head>\n"
                + "		<link href=\"https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.4/jquery-ui.css\" rel=\"stylesheet\" type=\"text/css\">\n"
                + "	</head>\n"
                + "	<body id=\"body\">\n"
                + "		<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.js\" type=\"text/javascript\"></script>\n"
                + "		<script src=\"http://code.jquery.com/jquery-migrate-1.4.1.js\" type=\"text/javascript\"></script>\n"
                + "		<script src=\"https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.0/jquery-ui.js\" type=\"text/javascript\"></script></body>\n"
                + "</html>", p.toString(true).toString());
    }

    @Test
    public void testBootstrap()
    {
        Page p = getPage();
        p.setTiny(false);
        p.getOptions().setBootstrapEnabled(true);
        p.getPageFields().setTitle("title");
        System.out.println(p.toString(true));

        assertEquals("<!DOCTYPE html>\n"
                + "<html>\n"
                + "	<head>\n"
                + "		<meta charset=\"utf-16\">\n"
                + "		<meta content=\"IE=Edge\" http-equiv=\"X-UA-Compatible\">\n"
                + "		<meta content=\"width=device-width, initial-scale=1\" name=\"viewport\">\n"
                + "		<title>title</title>\n"
                + "		<link href=\"bower_components/bootstrap/dist/css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\">\n"
                + "		<link href=\"bower_components/bootstrap3-dialog/dist/css/bootstrap-dialog.css\" rel=\"stylesheet\" type=\"text/css\">\n"
                + "	</head>\n"
                + "	<body id=\"body\">\n"
                + "		<script src=\"bower_components/jquery-3/dist/jquery.js\" type=\"text/javascript\"></script>\n"
                + "		<script src=\"bower_components/jquery-migrate/jquery-migrate.js\" type=\"text/javascript\"></script>\n"
                + "		<script src=\"bower_components/bootstrap/dist/js/bootstrap.js\" type=\"text/javascript\"></script>\n"
                + "		<script src=\"bower_components/bootstrap3-dialog/dist/js/bootstrap-dialog.js\" type=\"text/javascript\"></script></body>\n"
                + "</html>", p.toString(true));
    }

    @Test
    public void testAngular()
    {
        Page p = getPage();
        p.getOptions().setAngularEnabled(true);
        p.getBody().add(new Comment("meh"));
        //p.getBody().preConfigure();
        System.out.println(p.toString());
        System.out.println(p.toString(true));
    }

}
