/*
 * Copyright (C) 2017 GedMarc
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
package za.co.mmagon.jwebswing.components.bootstrap.buttons.toolbars;

import org.junit.Assert;
import org.junit.Test;
import za.co.mmagon.BaseTestClass;
import za.co.mmagon.jwebswing.components.bootstrap.buttons.*;
import za.co.mmagon.jwebswing.components.bootstrap.buttons.groups.*;

/**
 *
 * @author GedMarc
 */
public class BSButtonToolbarTest extends BaseTestClass
{

    public BSButtonToolbarTest()
    {
    }

    @Test
    public void testToolbar()
    {
        BSButtonToolbar bbt = new BSButtonToolbar();
        bbt.setID("toolbar");
        System.out.println(bbt.toString(true));

        BSButtonGroup group = new BSButtonGroup();
        group.setID("group");
        bbt.add(group);
        System.out.println(bbt.toString(true));

        BSButtonSuccess bbs = new BSButtonSuccess();
        group.add(bbs);
        bbs.setID("button");

        System.out.println(bbt.toString(true));

        Assert.assertEquals("<div aria_label=\"Button Toolbar\" class=\"btn-toolbar\" id=\"toolbar\" role=\"toolbar\">\n"
                + "	<div aria_label=\"Button Group\" class=\"btn-group\" id=\"group\" role=\"group\">\n"
                + "		<div class=\"btn btn-success\" id=\"button\"></div>\n"
                + "	</div>\n"
                + "</div>", bbt.toString(true));

    }

    @Test
    public void testSetSize()
    {
        BSButtonToolbar bbt = new BSButtonToolbar();
        bbt.setID("toolbar");
        System.out.println(bbt.toString(true));

        BSButtonGroup group = new BSButtonGroup();
        group.setID("group");
        group.setSize(BSComponentButtonGroupSizeOptions.Btn_Group_Lg);
        bbt.add(group);
        System.out.println(bbt.toString(true));

        BSButtonWarning bbs = new BSButtonWarning();
        group.add(bbs);
        bbs.setID("button");

        System.out.println(bbt.toString(true));

        Assert.assertEquals("<div aria_label=\"Button Toolbar\" class=\"btn-toolbar\" id=\"toolbar\" role=\"toolbar\">\n"
                + "	<div aria_label=\"Button Group\" class=\"btn-group btn-group-lg\" id=\"group\" role=\"group\">\n"
                + "		<div class=\"btn btn-warning\" id=\"button\"></div>\n"
                + "	</div>\n"
                + "</div>", bbt.toString(true));
    }

    @Test
    public void testSetVertical()
    {
        BSButtonToolbar bbt = new BSButtonToolbar();
        bbt.setID("toolbar");
        System.out.println(bbt.toString(true));

        BSButtonGroupVertical group = new BSButtonGroupVertical();
        group.setID("group");
        group.setSize(BSComponentButtonGroupSizeOptions.Btn_Group_Sm);
        bbt.add(group);
        System.out.println(bbt.toString(true));

        BSButtonInfoOutline bbs = new BSButtonInfoOutline();
        group.add(bbs);
        bbs.setID("button");

        System.out.println(bbt.toString(true));

        Assert.assertEquals("<div aria_label=\"Button Toolbar\" class=\"btn-toolbar\" id=\"toolbar\" role=\"toolbar\">\n"
                + "	<div aria_label=\"Button Group\" class=\"btn-group-vertical btn-group-sm\" id=\"group\" role=\"group\">\n"
                + "		<div class=\"btn btn-outline-info\" id=\"button\"></div>\n"
                + "	</div>\n"
                + "</div>", bbt.toString(true));
    }
}
