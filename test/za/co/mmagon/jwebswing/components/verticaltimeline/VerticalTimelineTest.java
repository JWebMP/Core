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
package za.co.mmagon.jwebswing.components.verticaltimeline;

import org.junit.*;
import za.co.mmagon.*;
import za.co.mmagon.jwebswing.*;
import za.co.mmagon.jwebswing.base.html.*;
import za.co.mmagon.jwebswing.components.fontawesome.*;

/**
 *
 * @author GedMarc
 */
public class VerticalTimelineTest extends BaseTestClass
{

    public VerticalTimelineTest()
    {
    }

    @Test
    public void testBasicStructure()
    {
        VerticalTimeline vt = getMe();
        System.out.println(vt.toString(true));
        Assert.assertEquals("<section class=\"verticalTimeline cd-container\" id=\"id\"></section>", vt.toString(true));
    }

    @Test
    public void testDeepStructure()
    {
        VerticalTimeline vt = getMe();
        VerticalTimelineBlock vtb = new VerticalTimelineBlock();
        vtb.getImageContainer().setID("vtbImageID");
        vtb.getImageContainer().add(FontAwesome.icon(FontAwesomeIcons.cog));
        vtb.getContent().setID("content");
        vtb.getContent().setHeader(new H2("header text"));
        vtb.getContent().setText("paragraph text");
        vtb.getContent().setSpanText(new Span("span text"));

        vtb.setID("vtbId");
        vtb.getContent().getHeader().setID("headerID");
        vtb.getContent().asVerticalTimelineContent().getReadMoreLink().setID("readmoreID");
        vtb.getContent().asVerticalTimelineContent().getSpanText().setID("spanID");
        vtb.getContent().asVerticalTimelineContent().getHeader().setID("headerID");
        vtb.getContent().asVerticalTimelineContent().getText().setID("textID");
        vt.add(vtb);

        System.out.println(vt.toString(true));
        Assert.assertEquals("<section class=\"verticalTimeline cd-container\" id=\"id\">\n"
                + "	<div class=\"cd-timeline-block\" id=\"vtbId\">\n"
                + "		<div class=\"cd-timeline-img\" id=\"vtbImageID\">\n"
                + "			<i class=\"fa fa-cog\"></i>\n"
                + "		</div>\n"
                + "		<div class=\"cd-timeline-content\" id=\"content\">\n"
                + "			<h2 id=\"headerID\">header text</h2>\n"
                + "			<p id=\"textID\">paragraph text</p>\n"
                + "			<a class=\"cd-read-more\" id=\"readmoreID\"></a>\n"
                + "			<span class=\"cd-date\" id=\"spanID\">span text</span>\n"
                + "		</div>\n"
                + "	</div>\n"
                + "</section>", vt.toString(true));
    }

    @Test
    public void testReferences()
    {
        Page p = getInstance();

        VerticalTimeline vt = getMe();
        VerticalTimelineBlock vtb = new VerticalTimelineBlock();
        vtb.getImageContainer().setID("vtbImageID");
        vtb.getImageContainer().add(FontAwesome.icon(FontAwesomeIcons.cog));
        vtb.getContent().setID("content");
        vtb.getContent().setHeader(new H2("header text"));
        vtb.getContent().setText("paragraph text");
        vtb.getContent().setSpanText(new Span("span text"));

        vtb.setID("vtbId");
        vtb.getContent().getHeader().setID("headerID");
        vtb.getContent().asVerticalTimelineContent().getReadMoreLink().setID("readmoreID");
        vtb.getContent().asVerticalTimelineContent().getSpanText().setID("spanID");
        vtb.getContent().asVerticalTimelineContent().getHeader().setID("headerID");
        vtb.getContent().asVerticalTimelineContent().getText().setID("textID");
        vt.add(vtb);

        p.getBody().add(vt);

        System.out.println(p.toString(true));

        Assert.assertEquals("<!DOCTYPE html>\n"
                + "<html>\n"
                + "	<head>\n"
                + "		<meta charset=\"utf-16\">\n"
                + "		<meta content=\"IE=Edge\" http-equiv=\"X-UA-Compatible\">\n"
                + "		<meta content=\"width=device-width, initial-scale=1\" name=\"viewport\">\n"
                + "		<link href=\"bower_components/font-awesome/css/font-awesome.css\" rel=\"stylesheet\" type=\"text/css\">\n"
                + "		<link href=\"bower_components/bootstrap/dist/css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\">\n"
                + "		<link href=\"bower_components/bootstrap3-dialog/dist/css/bootstrap-dialog.css\" rel=\"stylesheet\" type=\"text/css\">\n"
                + "		<link href=\"bower_components/vertical-timeline-jwebswing/css/style.css\" rel=\"stylesheet\" type=\"text/css\">\n"
                + "	</head>\n"
                + "	<body id=\"body\">\n"
                + "		<section class=\"verticalTimeline cd-container\" id=\"id\">\n"
                + "			<div class=\"cd-timeline-block\" id=\"vtbId\">\n"
                + "				<div class=\"cd-timeline-img\" id=\"vtbImageID\">\n"
                + "					<i class=\"fa fa-cog\"></i>\n"
                + "				</div>\n"
                + "				<div class=\"cd-timeline-content\" id=\"content\">\n"
                + "					<h2 id=\"headerID\">header text</h2>\n"
                + "					<p id=\"textID\">paragraph text</p>\n"
                + "					<a class=\"cd-read-more\" id=\"readmoreID\"></a>\n"
                + "					<span class=\"cd-date\" id=\"spanID\">span text</span>\n"
                + "				</div>\n"
                + "			</div>\n"
                + "		</section>\n"
                + "		<script src=\"bower_components/jwebswing-moderniz/modernizr.js\" type=\"text/javascript\"></script>\n"
                + "		<script src=\"bower_components/jquery-3/dist/jquery.js\" type=\"text/javascript\"></script>\n"
                + "		<script src=\"bower_components/jquery-migrate/jquery-migrate.js\" type=\"text/javascript\"></script>\n"
                + "		<script src=\"bower_components/bootstrap/dist/js/bootstrap.js\" type=\"text/javascript\"></script>\n"
                + "		<script src=\"bower_components/bootstrap3-dialog/dist/js/bootstrap-dialog.js\" type=\"text/javascript\"></script>\n"
                + "		<script src=\"bower_components/vertical-timeline-jwebswing/js/main.js\" type=\"text/javascript\"></script>\n"
                + "	</body>\n"
                + "</html>", p.toString(true));

    }

    public VerticalTimeline getMe()
    {
        VerticalTimeline vt = new VerticalTimeline();
        vt.setID("id");
        return vt;
    }

}
