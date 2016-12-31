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
package za.co.mmagon.jwebswing.components.bootstrap.media;

import org.junit.Assert;
import org.junit.Test;
import za.co.mmagon.BaseTestClass;
import za.co.mmagon.jwebswing.Page;

/**
 *
 * @author GedMarc
 */
public class BSMediaTest extends BaseTestClass
{

    public BSMediaTest()
    {
    }

    @Test
    public void testNothing()
    {
        BSMedia media = new BSMedia();
        media.setID("media");
        System.out.println(media.toString(true));
        Assert.assertEquals("<div class=\"media\" id=\"media\"></div>", media.toString(true));
    }

    @Test
    public void testNothingPage()
    {
        Page p = getInstance();
        BSMedia media = new BSMedia();
        media.setID("media");
        p.getBody().add(media);
        System.out.println(p.toString(true));
        Assert.assertEquals("<!DOCTYPE html>\n"
                + "<html>\n"
                + "	<head>\n"
                + "		<meta charset=\"utf-16\">\n"
                + "		<meta content=\"IE=Edge\" http-equiv=\"X-UA-Compatible\">\n"
                + "		<meta content=\"width=device-width, initial-scale=1\" name=\"viewport\">\n"
                + "		<link href=\"bower_components/bootstrap/dist/css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\">\n"
                + "		<link href=\"bower_components/bootstrap3-dialog/dist/css/bootstrap-dialog.css\" rel=\"stylesheet\" type=\"text/css\">\n"
                + "	</head>\n"
                + "	<body id=\"body\">\n"
                + "		<div class=\"media\" id=\"media\"></div>\n"
                + "		<script src=\"bower_components/jquery-3/dist/jquery.js\" type=\"text/javascript\"></script>\n"
                + "		<script src=\"bower_components/jquery-migrate/jquery-migrate.js\" type=\"text/javascript\"></script>\n"
                + "		<script src=\"bower_components/bootstrap/dist/js/bootstrap.js\" type=\"text/javascript\"></script>\n"
                + "		<script src=\"bower_components/bootstrap3-dialog/dist/js/bootstrap-dialog.js\" type=\"text/javascript\"></script>\n"
                + "	</body>\n"
                + "</html>", p.toString(true));
    }

    @Test
    public void testGetMediaLink()
    {
        BSMedia media = new BSMedia();
        media.setID("media");
        media.getMediaLink().setID("link");
        System.out.println(media.toString(true));
        Assert.assertEquals("<div class=\"media\" id=\"media\">\n"
                + "	<a class=\"media-left\" href=\"#\" id=\"link\"></a>\n"
                + "</div>", media.toString(true));
    }

    @Test
    public void testGetMediaBody()
    {
        BSMedia media = new BSMedia();
        media.setID("media");
        media.getMediaBody().setID("body");
        System.out.println(media.toString(true));
        Assert.assertEquals("<div class=\"media\" id=\"media\">\n"
                + "	<div class=\"media-body\" id=\"body\"></div>\n"
                + "</div>", media.toString(true));
    }

    @Test
    public void testGetMediaHeader()
    {
        BSMedia media = new BSMedia();
        media.setID("media");
        media.getMediaHeader().setID("header");

        media.getMediaBody().setID("body");

        System.out.println(media.toString(true));
        Assert.assertEquals("<div class=\"media\" id=\"media\">\n"
                + "	<div class=\"media-body\" id=\"body\">\n"
                + "		<h4 class=\"media-heading\" id=\"header\"></h4>\n"
                + "	</div>\n"
                + "</div>", media.toString(true));

    }

    @Test
    public void testGetMediaComponent()
    {
        BSMedia media = new BSMedia();
        media.setID("media");
        media.getMediaComponent().setID("object");
        media.getMediaLink().setID("link");

        System.out.println(media.toString(true));
        Assert.assertEquals("<div class=\"media\" id=\"media\">\n"
                + "	<a class=\"media-left\" href=\"#\" id=\"link\">\n"
                + "		<div class=\"media-object\" id=\"object\"></div>\n"
                + "	</a>\n"
                + "</div>", media.toString(true));
    }

}
