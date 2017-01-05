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
package za.co.mmagon.jwebswing.components.jstree;

import org.junit.Assert;
import org.junit.Test;
import za.co.mmagon.BaseTestClass;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.components.jstree.themes.JSTreeDefaultDarkTheme;

/**
 *
 * @author GedMarc
 */
public class JSTreeTest extends BaseTestClass
{

    public JSTreeTest()
    {
    }

    @Test
    public void testPreConfigure()
    {
        Page p = getInstance();
        JSTree tree = new JSTree();
        tree.setID("id");
        p.getBody().add(tree);
        System.out.println(p.toString(true));

        Assert.assertEquals("<!DOCTYPE html>\n"
                + "<html>\n"
                + "	<body id=\"body\">\n"
                + "		<div id=\"id\"></div>\n"
                + "		<script src=\"bower_components/jquery-3/dist/jquery.js\" type=\"text/javascript\"></script>\n"
                + "		<script src=\"bower_components/jquery-migrate/jquery-migrate.js\" type=\"text/javascript\"></script>\n"
                + "		<script src=\"bower_components/jstree/dist/jstree.js\" type=\"text/javascript\"></script>\n"
                + "		<script type=\"application/javascript\">$('#id').jstree({\n"
                + "  \"core\" : {\n"
                + "    \"data\" : {\n"
                + "      \"url\" : \"jwdata?component=id\",\n"
                + "      \"data\" : function (node, donefunction) {return node;}\n"
                + "    }\n"
                + "  }\n"
                + "});\n"
                + "</script>\n"
                + "	</body>\n"
                + "</html>", p.toString(true));
    }

    @Test
    public void testGetData()
    {

        Page p = getInstance();
        JSTree tree = new JSTree();
        tree.setID("id");
        JSTreeData data = new JSTreeData();
        JSTreeNode node = new JSTreeNode("id", "text");
        data.getNodes().add(node);

        Assert.assertEquals("[{\n"
                + "  \"id\" : \"id\",\n"
                + "  \"text\" : \"text\",\n"
                + "  \"children\" : false\n"
                + "}]", data.toString());

        System.out.println(data);
        soutDivider();
        tree.setData(data);
        System.out.println(tree.renderJavascript());
        soutDivider();
    }

    @Test
    public void testSetTheme()
    {
        Page p = getInstance();
        JSTree tree = new JSTree();
        tree.setID("id");
        tree.setTheme(new JSTreeDefaultDarkTheme());
        p.getBody().add(tree);
        System.out.println(p.toString(true));
        Assert.assertEquals("<!DOCTYPE html>\n"
                + "<html>\n"
                + "	<head>\n"
                + "		<link href=\"bower_components/jstree/dist/themes/default-dark/style.css\" rel=\"stylesheet\" type=\"text/css\">\n"
                + "	</head>\n"
                + "	<body id=\"body\">\n"
                + "		<div id=\"id\"></div>\n"
                + "		<script src=\"bower_components/jquery-3/dist/jquery.js\" type=\"text/javascript\"></script>\n"
                + "		<script src=\"bower_components/jquery-migrate/jquery-migrate.js\" type=\"text/javascript\"></script>\n"
                + "		<script src=\"bower_components/jstree/dist/jstree.js\" type=\"text/javascript\"></script>\n"
                + "		<script type=\"application/javascript\">$('#id').jstree({\n"
                + "  \"core\" : {\n"
                + "    \"data\" : {\n"
                + "      \"url\" : \"jwdata?component=id\",\n"
                + "      \"data\" : function (node, donefunction) {return node;}\n"
                + "    },\n"
                + "    \"themes\" : {\n"
                + "      \"name\" : \"default-dark\"\n"
                + "    }\n"
                + "  }\n"
                + "});\n"
                + "</script>\n"
                + "	</body>\n"
                + "</html>", p.toString(true));
    }

}
